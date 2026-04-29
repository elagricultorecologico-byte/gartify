/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  org.json.JSONObject
 */
package f1;

import f1.o;
import f1.y;
import org.json.JSONObject;

public final class w {
    private final y a;

    private w(y y2) {
        this.a = y2;
    }

    public static w b(JSONObject object) {
        object = (object = object.optJSONObject("ping_strategy")) == null ? new o(1, 0, 1.0, false) : new o(object.optInt("max_attempts", 1), object.optInt("initial_backoff_ms", 0), object.optDouble("backoff_multiplier", 1.0), object.optBoolean("buffer_after_max_attempts", false));
        return new w((y)object);
    }

    public final y a() {
        return this.a;
    }
}

