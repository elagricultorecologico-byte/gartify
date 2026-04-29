/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  java.lang.Object
 */
package a0;

import android.os.Build;

public final class b {
    public static final b a = new b();

    private b() {
    }

    public final int a() {
        if (Build.VERSION.SDK_INT >= 30) {
            return a0.b$a.a.a();
        }
        return 0;
    }

    private static final class a {
        public static final a a = new a();

        private a() {
        }

        public final int a() {
            return a0.a.a(1000000);
        }
    }
}

