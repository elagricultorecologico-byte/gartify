/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 */
package x1;

import android.os.Bundle;
import v1.a;
import x1.m;
import x1.v;
import x1.w;

public class t
implements a.d {
    public static final t c = t.a().a();
    private final String b;

    /* synthetic */ t(String string, w w2) {
        this.b = string;
    }

    public static a a() {
        return new a(null);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        String string = this.b;
        if (string != null) {
            bundle.putString("api", string);
        }
        return bundle;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof t)) {
            return false;
        }
        object = (t)object;
        return m.a(this.b, ((t)object).b);
    }

    public final int hashCode() {
        return m.b(this.b);
    }

    public static class a {
        private String a;

        /* synthetic */ a(v v2) {
        }

        public t a() {
            return new t(this.a, null);
        }
    }
}

