package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

public final class PlayerColumnNames {
    public final String name;
    public final String title;
    public final String zzazA;
    public final String zzazB;
    public final String zzazC;
    public final String zzazD;
    public final String zzazE;
    public final String zzazF;
    public final String zzazG;
    public final String zzazH;
    public final String zzazI;
    public final String zzazJ;
    public final String zzazK;
    public final String zzazL;
    public final String zzazM;
    public final String zzazN;
    public final String zzazO;
    public final String zzazP;
    public final String zzazq;
    public final String zzazr;
    public final String zzazs;
    public final String zzazt;
    public final String zzazu;
    public final String zzazv;
    public final String zzazw;
    public final String zzazx;
    public final String zzazy;
    public final String zzazz;

    public PlayerColumnNames(String prefix) {
        if (TextUtils.isEmpty(prefix)) {
            this.zzazq = "external_player_id";
            this.zzazr = "profile_name";
            this.zzazs = "profile_icon_image_uri";
            this.zzazt = "profile_icon_image_url";
            this.zzazu = "profile_hi_res_image_uri";
            this.zzazv = "profile_hi_res_image_url";
            this.zzazw = "last_updated";
            this.zzazx = "is_in_circles";
            this.zzazy = "played_with_timestamp";
            this.zzazz = "current_xp_total";
            this.zzazA = "current_level";
            this.zzazB = "current_level_min_xp";
            this.zzazC = "current_level_max_xp";
            this.zzazD = "next_level";
            this.zzazE = "next_level_max_xp";
            this.zzazF = "last_level_up_timestamp";
            this.title = "player_title";
            this.zzazG = "has_all_public_acls";
            this.zzazH = "is_profile_visible";
            this.zzazI = "most_recent_external_game_id";
            this.zzazJ = "most_recent_game_name";
            this.zzazK = "most_recent_activity_timestamp";
            this.zzazL = "most_recent_game_icon_uri";
            this.zzazM = "most_recent_game_hi_res_uri";
            this.zzazN = "most_recent_game_featured_uri";
            this.zzazO = "has_debug_access";
            this.zzazP = "gamer_tag";
            this.name = "real_name";
            return;
        }
        this.zzazq = prefix + "external_player_id";
        this.zzazr = prefix + "profile_name";
        this.zzazs = prefix + "profile_icon_image_uri";
        this.zzazt = prefix + "profile_icon_image_url";
        this.zzazu = prefix + "profile_hi_res_image_uri";
        this.zzazv = prefix + "profile_hi_res_image_url";
        this.zzazw = prefix + "last_updated";
        this.zzazx = prefix + "is_in_circles";
        this.zzazy = prefix + "played_with_timestamp";
        this.zzazz = prefix + "current_xp_total";
        this.zzazA = prefix + "current_level";
        this.zzazB = prefix + "current_level_min_xp";
        this.zzazC = prefix + "current_level_max_xp";
        this.zzazD = prefix + "next_level";
        this.zzazE = prefix + "next_level_max_xp";
        this.zzazF = prefix + "last_level_up_timestamp";
        this.title = prefix + "player_title";
        this.zzazG = prefix + "has_all_public_acls";
        this.zzazH = prefix + "is_profile_visible";
        this.zzazI = prefix + "most_recent_external_game_id";
        this.zzazJ = prefix + "most_recent_game_name";
        this.zzazK = prefix + "most_recent_activity_timestamp";
        this.zzazL = prefix + "most_recent_game_icon_uri";
        this.zzazM = prefix + "most_recent_game_hi_res_uri";
        this.zzazN = prefix + "most_recent_game_featured_uri";
        this.zzazO = prefix + "has_debug_access";
        this.zzazP = prefix + "gamer_tag";
        this.name = prefix + "real_name";
    }
}
