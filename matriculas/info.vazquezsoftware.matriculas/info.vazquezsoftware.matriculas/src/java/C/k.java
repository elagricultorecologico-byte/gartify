/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.net.Uri
 *  android.os.CancellationSignal
 *  android.os.Handler
 *  androidx.core.graphics.e
 *  java.lang.Object
 */
package C;

import C.e;
import C.i;
import C.j;
import D.h;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;

public abstract class k {
    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bArray) {
        return androidx.core.graphics.e.b((Context)context, (CancellationSignal)cancellationSignal, (b[])bArray, (int)0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, i i2) {
        return e.e(context, i2, cancellationSignal);
    }

    public static Typeface c(Context context, i i2, int n2, boolean bl, int n3, Handler object, c c2) {
        object = new C.a(c2, (Handler)object);
        if (bl) {
            return j.e(context, i2, (C.a)object, n2, n3);
        }
        return j.d(context, i2, n2, null, (C.a)object);
    }

    public static class a {
        private final int a;
        private final b[] b;

        public a(int n2, b[] bArray) {
            this.a = n2;
            this.b = bArray;
        }

        static a a(int n2, b[] bArray) {
            return new a(n2, bArray);
        }

        public b[] b() {
            return this.b;
        }

        public int c() {
            return this.a;
        }
    }

    public static class b {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        public b(Uri uri, int n2, int n3, boolean bl, int n4) {
            this.a = (Uri)h.g(uri);
            this.b = n2;
            this.c = n3;
            this.d = bl;
            this.e = n4;
        }

        static b a(Uri uri, int n2, int n3, boolean bl, int n4) {
            return new b(uri, n2, n3, bl, n4);
        }

        public int b() {
            return this.e;
        }

        public int c() {
            return this.b;
        }

        public Uri d() {
            return this.a;
        }

        public int e() {
            return this.c;
        }

        public boolean f() {
            return this.d;
        }
    }

    public static abstract class c {
        public abstract void a(int var1);

        public abstract void b(Typeface var1);
    }
}

