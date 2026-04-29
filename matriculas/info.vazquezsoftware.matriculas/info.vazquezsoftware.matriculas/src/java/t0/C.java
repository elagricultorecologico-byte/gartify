/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.lang.Object
 *  java.util.HashSet
 *  java.util.Set
 */
package t0;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

public final class c {
    private final Set a = new HashSet();

    public void a(Uri object, boolean bl) {
        object = new a((Uri)object, bl);
        this.a.add(object);
    }

    public Set b() {
        return this.a;
    }

    public int c() {
        return this.a.size();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && c.class == object.getClass()) {
            object = (c)object;
            return this.a.equals((Object)((c)object).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public static final class a {
        private final Uri a;
        private final boolean b;

        a(Uri uri, boolean bl) {
            this.a = uri;
            this.b = bl;
        }

        public Uri a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object != null && a.class == object.getClass()) {
                object = (a)object;
                if (this.b == ((a)object).b && this.a.equals((Object)((a)object).a)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode() * 31 + this.b;
        }
    }
}

