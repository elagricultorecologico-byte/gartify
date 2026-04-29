/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 */
package m3;

import V2.g;
import V2.k;
import java.nio.charset.Charset;
import m3.v;
import n3.d;
import z3.c;

public abstract class z {
    public static final a a = new a(null);

    public static final z c(String string, v v2) {
        return a.a(string, v2);
    }

    public abstract long a();

    public abstract v b();

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public abstract void f(c var1);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public static /* synthetic */ z c(a a2, byte[] byArray, v v2, int n2, int n3, int n4, Object object) {
            if ((n4 & 1) != 0) {
                v2 = null;
            }
            if ((n4 & 2) != 0) {
                n2 = 0;
            }
            if ((n4 & 4) != 0) {
                n3 = byArray.length;
            }
            return a2.b(byArray, v2, n2, n3);
        }

        public final z a(String object, v v2) {
            Charset charset;
            k.e(object, "<this>");
            Charset charset2 = charset = b3.d.b;
            Object object2 = v2;
            if (v2 != null) {
                charset2 = v.d(v2, null, 1, null);
                if (charset2 == null) {
                    object2 = v.e;
                    charset2 = new StringBuilder();
                    charset2.append((Object)v2);
                    charset2.append("; charset=utf-8");
                    object2 = ((v.a)object2).b(charset2.toString());
                    charset2 = charset;
                } else {
                    object2 = v2;
                }
            }
            object = object.getBytes(charset2);
            k.d(object, "this as java.lang.String).getBytes(charset)");
            return this.b((byte[])object, (v)object2, 0, ((Object)object).length);
        }

        public final z b(byte[] byArray, v v2, int n2, int n3) {
            k.e(byArray, "<this>");
            d.l(byArray.length, n2, n3);
            return new z(v2, n3, byArray, n2){
                final v b;
                final int c;
                final byte[] d;
                final int e;
                {
                    this.b = v2;
                    this.c = n2;
                    this.d = byArray;
                    this.e = n3;
                }

                @Override
                public long a() {
                    return this.c;
                }

                @Override
                public v b() {
                    return this.b;
                }

                @Override
                public void f(c c2) {
                    k.e(c2, "sink");
                    c2.k(this.d, this.e, this.c);
                }
            };
        }
    }
}

