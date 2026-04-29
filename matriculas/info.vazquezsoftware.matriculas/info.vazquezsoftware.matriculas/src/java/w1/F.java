/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  androidx.fragment.app.g
 *  java.lang.Object
 */
package w1;

import android.app.Activity;
import androidx.fragment.app.g;
import x1.n;

public class f {
    private final Object a;

    public f(Activity activity) {
        n.j(activity, "Activity must not be null");
        this.a = activity;
    }

    public final boolean a() {
        return this.a instanceof g;
    }

    public final boolean b() {
        return this.a instanceof Activity;
    }

    public final Activity c() {
        return (Activity)this.a;
    }

    public final g d() {
        return (g)this.a;
    }
}

