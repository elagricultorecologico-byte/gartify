/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  org.json.JSONObject
 */
package f1;

import f1.n;
import org.json.JSONObject;

public abstract class x {
    public static x d(JSONObject jSONObject) {
        return new n(jSONObject.optInt("impression_prerequisite", 0), jSONObject.optInt("click_prerequisite", 0), jSONObject.optBoolean("notification_flow_enabled", false));
    }

    public abstract int a();

    public abstract int b();

    public abstract boolean c();
}

