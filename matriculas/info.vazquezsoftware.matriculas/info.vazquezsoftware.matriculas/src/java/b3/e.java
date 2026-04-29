/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 */
package b3;

import H2.j;
import U2.p;
import V2.k;
import Y2.c;
import Y2.d;
import b3.u;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class e
implements a3.d {
    private final CharSequence a;
    private final int b;
    private final int c;
    private final p d;

    public e(CharSequence charSequence, int n3, int n4, p p3) {
        k.e(charSequence, "input");
        k.e(p3, "getNextMatch");
        this.a = charSequence;
        this.b = n3;
        this.c = n4;
        this.d = p3;
    }

    public static final /* synthetic */ p b(e e3) {
        return e3.d;
    }

    public static final /* synthetic */ int d(e e3) {
        return e3.c;
    }

    @Override
    public Iterator iterator() {
        return new Iterator(this){
            private int g;
            private int h;
            private int i;
            private c j;
            private int k;
            final e l;
            {
                int n3;
                this.l = e3;
                this.g = -1;
                this.h = n3 = Y2.d.e(e3.b, 0, e3.a.length());
                this.i = n3;
            }

            /*
             * Unable to fully structure code
             */
            private final void b() {
                block6: {
                    var2_1 = this.i;
                    var1_2 = 0;
                    if (var2_1 < 0) {
                        this.g = 0;
                        this.j = null;
                        return;
                    }
                    if (e.d(this.l) <= 0) break block6;
                    this.k = var2_1 = this.k + 1;
                    if (var2_1 >= e.d(this.l)) ** GOTO lbl-1000
                }
                if (this.i > e.c(this.l).length()) lbl-1000:
                // 2 sources

                {
                    this.j = new c(this.h, u.M(e.c(this.l)));
                    this.i = -1;
                } else {
                    var4_3 = (j)e.b(this.l).h(e.c(this.l), this.i);
                    if (var4_3 == null) {
                        this.j = new c(this.h, u.M(e.c(this.l)));
                        this.i = -1;
                    } else {
                        var3_4 = ((Number)var4_3.a()).intValue();
                        var2_1 = ((Number)var4_3.b()).intValue();
                        this.j = Y2.d.h(this.h, var3_4);
                        this.h = var3_4 += var2_1;
                        if (var2_1 == 0) {
                            var1_2 = 1;
                        }
                        this.i = var3_4 + var1_2;
                    }
                }
                this.g = 1;
            }

            public c c() {
                if (this.g == -1) {
                    this.b();
                }
                if (this.g != 0) {
                    c c3 = this.j;
                    k.c(c3, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                    this.j = null;
                    this.g = -1;
                    return c3;
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                if (this.g == -1) {
                    this.b();
                }
                return this.g == 1;
            }

            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }
}

