package com.adobe.air.wand.connection;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import com.adobe.air.wand.Version;
import com.adobe.air.wand.connection.Connection.Listener;
import com.google.android.gms.drive.FileUploadPreferences;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.channels.CancelledKeyException;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.util.InetAddressUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.java_websocket.WebSocket;
import org.java_websocket.server.WebSocketServer;
import org.json.JSONObject;

public class WandWebSocket implements Connection {
    private static final String CONNECT_PING_URL = "http://dh8vjmvwgc27o.cloudfront.net/AIRGamepad/connect_ping.txt";
    private static final String LOG_TAG = "WandWebSocket";
    private static final String WEBSOCKET_PROTOCOL = "WEBSOCKET";
    private final String HANDSHAKE_SYNCHRONIZER = "HANDSHAKE_SYNCHRONIZER";
    private final String OPEN_SYNCHRONIZER = "OPEN_SYNCHRONIZER";
    private Activity mActivity = null;
    private boolean mAllowIncomingConnection = false;
    private WebSocket mConnection = null;
    private Listener mConnectionListener = null;
    private String mConnectionToken = null;
    private Handshake mHandshake = null;
    private Timer mHandshakeTimer = null;
    private boolean mIsDisposed = false;
    private String mLocalID = null;
    private WandSocketServer mWandSocketServer = null;

    private class ConnectPingTask extends AsyncTask<String, Integer, Long> {
        private ConnectPingTask() {
        }

        protected Long doInBackground(String... strArr) {
            if (strArr == null || strArr.length < 1) {
                return Long.valueOf(0);
            }
            try {
                new DefaultHttpClient().execute(new HttpGet(strArr[0]));
                return Long.valueOf(0);
            } catch (Exception e) {
                return Long.valueOf(-1);
            }
        }

        protected void onProgressUpdate(Integer... numArr) {
        }

        protected void onPostExecute(Long l) {
        }
    }

    private static class Handshake {
        private static final String APPLICATION_URL = "applicationURL";
        private static final String DESTINATION_ID = "destinationID";
        private static final String PROTOCOL = "protocol";
        private static final String PUBLISHER = "publisher";
        private static final String SOURCE_ID = "sourceID";
        private static final String STATUS = "status";
        private static final String STATUS_SUCCESS = "SUCCESS";
        public static final int TIMEOUT_MILLISECONDS = 30000;
        private static final String VERSION = "version";
        private String mApplicationURL = null;
        private String mDestinationID = null;
        private String mProtocol = WandWebSocket.WEBSOCKET_PROTOCOL;
        private String mPublisher = null;
        private String mSourceID = null;
        private String mVersion = null;

        public String getProtocol() {
            return this.mProtocol;
        }

        public String getVersion() {
            return this.mVersion;
        }

        public String getSourceID() {
            return this.mSourceID;
        }

        public String getDestinationID() {
            return this.mDestinationID;
        }

        public String getPublisher() {
            return this.mPublisher;
        }

        public String getApplicationURL() {
            return this.mApplicationURL;
        }

        private Handshake() {
        }

        public static Handshake parse(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            Handshake handshake = new Handshake();
            handshake.mProtocol = jSONObject.getString(PROTOCOL);
            handshake.mVersion = jSONObject.getString(VERSION);
            handshake.mSourceID = jSONObject.getString(SOURCE_ID);
            handshake.mDestinationID = jSONObject.getString(DESTINATION_ID);
            if (jSONObject.has(PUBLISHER)) {
                handshake.mPublisher = jSONObject.getString(PUBLISHER);
            }
            if (jSONObject.has(APPLICATION_URL)) {
                handshake.mApplicationURL = jSONObject.getString(APPLICATION_URL);
            }
            return handshake;
        }

        public String getSuccessResponse(String str) throws Exception {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PROTOCOL, WandWebSocket.WEBSOCKET_PROTOCOL);
            jSONObject.put(VERSION, this.mVersion);
            jSONObject.put(SOURCE_ID, str);
            jSONObject.put(DESTINATION_ID, this.mSourceID);
            jSONObject.put("status", STATUS_SUCCESS);
            if (Version.isGreaterThanEqualTo(this.mVersion, "1.1.0")) {
                jSONObject.put(PUBLISHER, this.mPublisher);
                jSONObject.put(APPLICATION_URL, this.mApplicationURL);
            }
            return jSONObject.toString();
        }
    }

    private class WandSocketServer extends WebSocketServer {
        private boolean mHasStartedServer = false;

        class C00771 extends TimerTask {
            C00771() {
            }

            public void run() {
                synchronized ("OPEN_SYNCHRONIZER") {
                    if (WandWebSocket.this.mConnection == null) {
                        return;
                    }
                    synchronized ("HANDSHAKE_SYNCHRONIZER") {
                        if (WandWebSocket.this.mHandshake != null) {
                            return;
                        }
                        WandWebSocket.this.mConnection.close(1003, "AIR Gamepad handshake timedout");
                    }
                }
            }
        }

        public WandSocketServer(InetSocketAddress inetSocketAddress) throws UnknownHostException {
            super(inetSocketAddress);
        }

        public void start() {
            if (!this.mHasStartedServer) {
                super.start();
                this.mHasStartedServer = true;
            }
        }

        public void stop() throws IOException, InterruptedException {
            if (this.mHasStartedServer) {
                try {
                    super.stop();
                } catch (CancelledKeyException e) {
                }
                this.mHasStartedServer = false;
                if (WandWebSocket.this.mWandSocketServer != null) {
                    if (WandWebSocket.this.mConnection != null) {
                        WandWebSocket.this.forceCloseConnection();
                    }
                    WandWebSocket.this.mWandSocketServer = null;
                    try {
                        WandWebSocket.this.startSocketServer();
                    } catch (Exception e2) {
                    }
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onOpen(org.java_websocket.WebSocket r3, org.java_websocket.handshake.ClientHandshake r4) {
            /*
            r2 = this;
            r1 = "OPEN_SYNCHRONIZER";
            monitor-enter(r1);
            r0 = com.adobe.air.wand.connection.WandWebSocket.this;	 Catch:{ all -> 0x0026 }
            r0 = r0.mAllowIncomingConnection;	 Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x001d;
        L_0x000b:
            r0 = com.adobe.air.wand.connection.WandWebSocket.this;	 Catch:{ all -> 0x0026 }
            r0 = r0.mConnection;	 Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x001d;
        L_0x0013:
            r0 = com.adobe.air.wand.connection.WandWebSocket.this;	 Catch:{ all -> 0x0026 }
            r0.mConnection = r3;	 Catch:{ all -> 0x0026 }
            r2.scheduleHandshakeTimer();	 Catch:{ all -> 0x0026 }
            monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        L_0x001c:
            return;
        L_0x001d:
            monitor-exit(r1);	 Catch:{ all -> 0x0026 }
            r0 = 1003; // 0x3eb float:1.406E-42 double:4.955E-321;
            r1 = "AIR Gamepad is already connected";
            r3.close(r0, r1);
            goto L_0x001c;
        L_0x0026:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0026 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adobe.air.wand.connection.WandWebSocket.WandSocketServer.onOpen(org.java_websocket.WebSocket, org.java_websocket.handshake.ClientHandshake):void");
        }

        private void scheduleHandshakeTimer() {
            try {
                WandWebSocket.this.mHandshakeTimer.schedule(new C00771(), 30000);
            } catch (Exception e) {
            }
        }

        public void onClose(WebSocket webSocket, int i, String str, boolean z) {
            synchronized ("OPEN_SYNCHRONIZER") {
                if (WandWebSocket.this.mConnection == webSocket) {
                    WandWebSocket.this.mConnection = null;
                    synchronized ("HANDSHAKE_SYNCHRONIZER") {
                        if (WandWebSocket.this.mHandshake != null) {
                            WandWebSocket.this.mHandshake = null;
                            if (WandWebSocket.this.mConnectionListener != null) {
                                WandWebSocket.this.mConnectionListener.onConnectionClose();
                            }
                        }
                    }
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMessage(org.java_websocket.WebSocket r7, java.lang.String r8) {
            /*
            r6 = this;
            r2 = 0;
            r3 = "OPEN_SYNCHRONIZER";
            monitor-enter(r3);
            r0 = com.adobe.air.wand.connection.WandWebSocket.this;	 Catch:{ all -> 0x0024 }
            r0 = r0.mConnection;	 Catch:{ all -> 0x0024 }
            if (r7 == r0) goto L_0x000e;
        L_0x000c:
            monitor-exit(r3);	 Catch:{ all -> 0x0024 }
        L_0x000d:
            return;
        L_0x000e:
            r4 = "HANDSHAKE_SYNCHRONIZER";
            monitor-enter(r4);	 Catch:{ all -> 0x0024 }
            r0 = com.adobe.air.wand.connection.WandWebSocket.this;	 Catch:{ all -> 0x0099 }
            r0 = r0.mHandshake;	 Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x003b;
        L_0x0019:
            r0 = "NO_OP";
            r0 = r8.equals(r0);	 Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x0027;
        L_0x0021:
            monitor-exit(r4);	 Catch:{ all -> 0x0099 }
            monitor-exit(r3);	 Catch:{ all -> 0x0024 }
            goto L_0x000d;
        L_0x0024:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0024 }
            throw r0;
        L_0x0027:
            r0 = com.adobe.air.wand.connection.WandWebSocket.this;	 Catch:{ all -> 0x0099 }
            r0 = r0.mConnectionListener;	 Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x0038;
        L_0x002f:
            r0 = com.adobe.air.wand.connection.WandWebSocket.this;	 Catch:{ all -> 0x0099 }
            r0 = r0.mConnectionListener;	 Catch:{ all -> 0x0099 }
            r0.onReceive(r8);	 Catch:{ all -> 0x0099 }
        L_0x0038:
            monitor-exit(r4);	 Catch:{ all -> 0x0099 }
            monitor-exit(r3);	 Catch:{ all -> 0x0024 }
            goto L_0x000d;
        L_0x003b:
            r0 = "";
            r1 = com.adobe.air.wand.connection.WandWebSocket.Handshake.parse(r8);	 Catch:{ Exception -> 0x0063 }
            r5 = com.adobe.air.wand.connection.WandWebSocket.this;	 Catch:{ Exception -> 0x006c }
            r5.validateHandshake(r1);	 Catch:{ Exception -> 0x006c }
        L_0x0046:
            if (r1 != 0) goto L_0x0073;
        L_0x0048:
            r1 = 1003; // 0x3eb float:1.406E-42 double:4.955E-321;
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0099 }
            r2.<init>();	 Catch:{ all -> 0x0099 }
            r5 = "Invalid AIR Gamepad handshake : ";
            r2 = r2.append(r5);	 Catch:{ all -> 0x0099 }
            r0 = r2.append(r0);	 Catch:{ all -> 0x0099 }
            r0 = r0.toString();	 Catch:{ all -> 0x0099 }
            r7.close(r1, r0);	 Catch:{ all -> 0x0099 }
            monitor-exit(r4);	 Catch:{ all -> 0x0099 }
            monitor-exit(r3);	 Catch:{ all -> 0x0024 }
            goto L_0x000d;
        L_0x0063:
            r0 = move-exception;
            r0 = new java.lang.Exception;	 Catch:{ Exception -> 0x006c }
            r1 = "Unable to parse the handshake";
            r0.<init>(r1);	 Catch:{ Exception -> 0x006c }
            throw r0;	 Catch:{ Exception -> 0x006c }
        L_0x006c:
            r0 = move-exception;
            r0 = r0.getMessage();	 Catch:{ all -> 0x0099 }
            r1 = r2;
            goto L_0x0046;
        L_0x0073:
            r0 = com.adobe.air.wand.connection.WandWebSocket.this;	 Catch:{ all -> 0x0099 }
            r0.mHandshake = r1;	 Catch:{ all -> 0x0099 }
            r0 = com.adobe.air.wand.connection.WandWebSocket.this;	 Catch:{ Exception -> 0x0091 }
            r0 = r0.mConnectionListener;	 Catch:{ Exception -> 0x0091 }
            if (r0 == 0) goto L_0x008d;
        L_0x0080:
            r0 = com.adobe.air.wand.connection.WandWebSocket.this;	 Catch:{ Exception -> 0x0091 }
            r0 = r0.mConnectionListener;	 Catch:{ Exception -> 0x0091 }
            r1 = r1.getVersion();	 Catch:{ Exception -> 0x0091 }
            r0.onConnectionOpen(r1);	 Catch:{ Exception -> 0x0091 }
        L_0x008d:
            monitor-exit(r4);	 Catch:{ all -> 0x0099 }
            monitor-exit(r3);	 Catch:{ all -> 0x0024 }
            goto L_0x000d;
        L_0x0091:
            r0 = move-exception;
            r0 = com.adobe.air.wand.connection.WandWebSocket.this;	 Catch:{ all -> 0x0099 }
            r1 = 0;
            r0.mHandshake = r1;	 Catch:{ all -> 0x0099 }
            goto L_0x008d;
        L_0x0099:
            r0 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x0099 }
            throw r0;	 Catch:{ all -> 0x0024 }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adobe.air.wand.connection.WandWebSocket.WandSocketServer.onMessage(org.java_websocket.WebSocket, java.lang.String):void");
        }

        public void onError(WebSocket webSocket, Exception exception) {
            if (WandWebSocket.this.mConnection != null && WandWebSocket.this.mConnection != webSocket && webSocket != null) {
                try {
                    webSocket.close(1003, "AIR Gamepad is already connected");
                } catch (Exception e) {
                }
            }
        }
    }

    public WandWebSocket(Activity activity) throws UnknownHostException {
        this.mActivity = activity;
        this.mHandshakeTimer = new Timer();
    }

    private void startSocketServer() throws Exception {
        if (this.mWandSocketServer == null) {
            this.mWandSocketServer = new WandSocketServer(new InetSocketAddress(getLocalIpAddress(), getPreferredPort()));
            this.mWandSocketServer.start();
        }
    }

    private void stopSocketServer() {
        WandSocketServer wandSocketServer = this.mWandSocketServer;
        this.mWandSocketServer = null;
        if (wandSocketServer != null) {
            try {
                wandSocketServer.stop();
            } catch (Exception e) {
            }
        }
    }

    private String constructLocalID() throws Exception {
        InetAddress localIpAddress = getLocalIpAddress();
        if (localIpAddress == null) {
            return null;
        }
        byte[] address = localIpAddress.getAddress();
        return Long.toString((((long) getUnsignedByte(address[0])) * 16777216) + (((((long) getUnsignedByte(address[3])) * 1) + (((long) getUnsignedByte(address[2])) * 256)) + (((long) getUnsignedByte(address[1])) * 65536)), 32).toUpperCase();
    }

    public void connect() throws Exception {
        if (this.mIsDisposed) {
            throw new Exception("Connection has been disposed");
        } else if (this.mAllowIncomingConnection) {
            throw new Exception("Connection is already established");
        } else {
            this.mAllowIncomingConnection = true;
            if (this.mWandSocketServer == null) {
                startSocketServer();
            }
            this.mLocalID = constructLocalID();
            this.mConnectionToken = this.mLocalID;
            if (this.mConnectionListener != null) {
                this.mConnectionListener.updateConnectionToken(getConnectionToken());
            }
            if (this.mConnectionListener != null) {
                this.mConnectionListener.onConnectSuccess();
            }
        }
    }

    private void forceCloseConnection() {
        WebSocket webSocket = this.mConnection;
        this.mWandSocketServer.onClose(this.mConnection, 1001, "AIR Gamepad has closed", false);
        webSocket.close(1001, "AIR Gamepad has closed");
    }

    public void disconnect() throws Exception {
        if (this.mIsDisposed) {
            throw new Exception("Connection has been disposed");
        } else if (this.mAllowIncomingConnection) {
            if (this.mConnection != null) {
                forceCloseConnection();
            }
            stopSocketServer();
            this.mAllowIncomingConnection = false;
            if (this.mConnectionListener != null) {
                this.mConnectionListener.onDisconnectSuccess();
            }
        } else {
            throw new Exception("Connection is not established");
        }
    }

    public String getConnectionToken() throws Exception {
        if (this.mIsDisposed) {
            throw new Exception("Connection has been disposed");
        } else if (this.mAllowIncomingConnection) {
            return this.mConnectionToken == null ? "" : this.mConnectionToken;
        } else {
            throw new Exception("Connection is not established");
        }
    }

    public void registerListener(Listener listener) throws Exception {
        if (this.mIsDisposed) {
            throw new Exception("Connection has been disposed");
        } else if (listener == null) {
            throw new Exception("Invalid Connection.Listener");
        } else if (this.mConnectionListener != null) {
            throw new Exception("A listener is already registered");
        } else {
            this.mConnectionListener = listener;
        }
    }

    public void unregisterListener() {
        this.mConnectionListener = null;
    }

    public void send(String str) throws Exception {
        if (this.mIsDisposed) {
            throw new Exception("Connection has been disposed");
        } else if (this.mConnection != null) {
            try {
                this.mConnection.send(str);
            } catch (Throwable th) {
                Exception exception = new Exception("Unable to send Message");
            }
        }
    }

    private InetAddress getWiFiIpAddress() throws UnknownHostException {
        WifiManager wifiManager = (WifiManager) this.mActivity.getSystemService("wifi");
        if (wifiManager == null) {
            return null;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        if (connectionInfo.getIpAddress() == 0) {
            return null;
        }
        return InetAddress.getByName(String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(connectionInfo.getIpAddress() & 255), Integer.valueOf((connectionInfo.getIpAddress() >> 8) & 255), Integer.valueOf((connectionInfo.getIpAddress() >> 16) & 255), Integer.valueOf((connectionInfo.getIpAddress() >> 24) & 255)}));
    }

    private InetAddress getWiFiHotspotIpAddress() throws UnknownHostException, SocketException {
        if (((ConnectivityManager) this.mActivity.getSystemService("connectivity")) == null) {
            return null;
        }
        WifiManager wifiManager = (WifiManager) this.mActivity.getSystemService("wifi");
        if (wifiManager == null) {
            return null;
        }
        Object obj = null;
        for (Method method : wifiManager.getClass().getDeclaredMethods()) {
            if (method.getName().equals("isWifiApEnabled")) {
                try {
                    Object obj2;
                    if (((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue()) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    obj = obj2;
                } catch (IllegalArgumentException e) {
                } catch (IllegalAccessException e2) {
                } catch (InvocationTargetException e3) {
                }
            }
        }
        if (obj == null) {
            return null;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        String toLowerCase = connectionInfo.getMacAddress().toLowerCase();
        byte[] bArr = new byte[6];
        int i;
        if (toLowerCase.indexOf(":") == -1 && toLowerCase.length() == 12) {
            for (i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) Integer.parseInt(toLowerCase.substring(i * 2, (i * 2) + 2), 16);
            }
        } else {
            String[] split = toLowerCase.split(":");
            i = 0;
            while (i < bArr.length && i < split.length) {
                bArr[i] = (byte) Integer.parseInt(split[i], 16);
                i++;
            }
        }
        Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
            Enumeration inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                if (!inetAddress.isLoopbackAddress() && InetAddressUtils.isIPv4Address(inetAddress.getHostAddress())) {
                    try {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress != null && hardwareAddress.length == 6) {
                            int i2;
                            for (i2 = 0; i2 < hardwareAddress.length; i2++) {
                                if (hardwareAddress[i2] != bArr[i2]) {
                                    obj = null;
                                    break;
                                }
                            }
                            i2 = 1;
                            if (obj != null) {
                                return inetAddress;
                            }
                        }
                    } catch (SocketException e4) {
                    }
                }
            }
        }
        return null;
    }

    private InetAddress getLocalIpAddress() {
        try {
            InetAddress wiFiIpAddress = getWiFiIpAddress();
            if (wiFiIpAddress == null) {
                return getWiFiHotspotIpAddress();
            }
            return wiFiIpAddress;
        } catch (Exception e) {
            return null;
        }
    }

    private int getPreferredPort() {
        return 1234;
    }

    private int getUnsignedByte(byte b) {
        return b >= (byte) 0 ? b : b + FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED;
    }

    private void validateHandshake(Handshake handshake) throws Exception {
        if (handshake == null) {
            throw new Exception("Handshake is null");
        }
        String version = handshake.getVersion();
        if (!Pattern.matches("\\d+\\.\\d+\\.\\d+", version)) {
            throw new Exception("Invalid version format");
        } else if (Version.isGreaterThan(version, "1.1.0") || !Version.isGreaterThanEqualTo(version, Version.V1_0_0)) {
            throw new Exception("Unsupported version");
        } else if (!WEBSOCKET_PROTOCOL.equals(handshake.getProtocol())) {
            throw new Exception("Invalid protocol");
        } else if (!this.mLocalID.equals(handshake.getDestinationID())) {
            throw new Exception("Invalid destinationID");
        } else if (!Version.isGreaterThanEqualTo(version, "1.1.0")) {
        } else {
            if (handshake.getPublisher() == null) {
                throw new Exception("Invalid publisher");
            }
            version = handshake.getApplicationURL();
            if (version == null) {
                throw new Exception("Invalid applicationURL");
            }
            try {
                URL url = new URL(version);
            } catch (Exception e) {
                throw new Exception("Invalid applicationURL");
            }
        }
    }

    public void onConnectionChanged() {
        if (!this.mIsDisposed && this.mAllowIncomingConnection) {
            try {
                String constructLocalID = constructLocalID();
                if (this.mLocalID != null || constructLocalID != null) {
                    if (this.mLocalID == null || constructLocalID == null || !this.mLocalID.equals(constructLocalID)) {
                        disconnect();
                        connect();
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private void pingServerOnConnect(String str, String str2) throws Exception {
        if (str == null || str2 == null) {
            new ConnectPingTask().execute(new String[]{CONNECT_PING_URL});
            return;
        }
        new ConnectPingTask().execute(new String[]{"http://dh8vjmvwgc27o.cloudfront.net/AIRGamepad/connect_ping.txt?publisher=" + URLEncoder.encode(str, "UTF-8") + "&applicationURL=" + URLEncoder.encode(str2, "UTF-8")});
    }

    public void onReadyForConnection() throws Exception {
        if (this.mHandshake == null || this.mLocalID == null) {
            throw new Exception("Invalid state at onReadyForConnection callback.");
        }
        this.mConnection.send(this.mHandshake.getSuccessResponse(this.mLocalID));
        pingServerOnConnect(this.mHandshake.mPublisher, this.mHandshake.mApplicationURL);
    }

    public void dispose() throws Exception {
        if (!this.mIsDisposed) {
            this.mIsDisposed = true;
            if (this.mAllowIncomingConnection) {
                disconnect();
            }
            unregisterListener();
            if (this.mConnection != null) {
                this.mConnection.close(1001, "AIR Gamepad has closed");
            }
            this.mConnection = null;
            this.mHandshake = null;
            if (this.mHandshakeTimer != null) {
                this.mHandshakeTimer.cancel();
                this.mHandshakeTimer.purge();
            }
            this.mHandshakeTimer = null;
            this.mWandSocketServer = null;
            this.mActivity = null;
        }
    }
}
