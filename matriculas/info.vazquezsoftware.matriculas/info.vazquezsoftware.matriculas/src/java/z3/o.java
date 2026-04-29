/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 *  java.util.RandomAccess
 */
package z3;

import I2.c;
import I2.i;
import V2.g;
import V2.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import z3.b;
import z3.e;
import z3.x;

public final class o
extends c
implements RandomAccess {
    public static final a j = new a(null);
    private final e[] h;
    private final int[] i;

    private o(e[] eArray, int[] nArray) {
        this.h = eArray;
        this.i = nArray;
    }

    public /* synthetic */ o(e[] eArray, int[] nArray, g g2) {
        this(eArray, nArray);
    }

    @Override
    public int f() {
        return this.h.length;
    }

    public e j(int n2) {
        return this.h[n2];
    }

    public final e[] k() {
        return this.h;
    }

    public final int[] l() {
        return this.i;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        private final void a(long l2, b b2, int n2, List list, int n3, int n4, List list2) {
            int n5 = n2;
            n2 = n3;
            int n6 = n2 < n4 ? 1 : 0;
            if (n6 != 0) {
                Object object;
                int n7;
                block28: {
                    block27: {
                        if (n2 < n4) {
                            n6 = n2;
                            while (true) {
                                n7 = n6 + 1;
                                if ((n6 = ((e)list.get(n6)).u() >= n5 ? 1 : 0) == 0) break;
                                if (n7 < n4) {
                                    n6 = n7;
                                    continue;
                                }
                                break block27;
                                break;
                            }
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    object = (e)list.get(n3);
                    e e2 = (e)list.get(n4 - 1);
                    if (n5 == ((e)object).u()) {
                        n7 = ((Number)list2.get(n2)).intValue();
                        object = (e)list.get(++n2);
                    } else {
                        n7 = -1;
                    }
                    if (((e)object).g(n5) != e2.g(n5)) {
                        int n8 = n2 + 1;
                        n3 = 1;
                        n6 = 1;
                        if (n8 < n4) {
                            while (true) {
                                int n9 = n8 + 1;
                                n3 = n6;
                                if (((e)list.get(n8 - 1)).g(n5) != ((e)list.get(n8)).g(n5)) {
                                    n3 = n6 + 1;
                                }
                                if (n9 >= n4) break;
                                n8 = n9;
                                n6 = n3;
                            }
                        }
                        l2 = l2 + this.c(b2) + (long)2 + (long)(n3 * 2);
                        b2.R0(n3);
                        b2.R0(n7);
                        if (n2 < n4) {
                            n3 = n2;
                            while (true) {
                                n6 = n3 + 1;
                                n7 = ((e)list.get(n3)).g(n5);
                                if (n3 == n2 || n7 != ((e)list.get(n3 - 1)).g(n5)) {
                                    b2.R0(n7 & 0xFF);
                                }
                                if (n6 >= n4) break;
                                n3 = n6;
                            }
                        }
                        object = new b();
                        n3 = n2;
                        while (n3 < n4) {
                            n8 = ((e)list.get(n3)).g(n5);
                            n6 = n3 + 1;
                            if (n6 < n4) {
                                n2 = n6;
                                while (true) {
                                    n7 = n2 + 1;
                                    if (n8 == ((e)list.get(n2)).g(n5)) {
                                        if (n7 >= n4) break;
                                        n2 = n7;
                                        continue;
                                    }
                                    break;
                                }
                            } else {
                                n2 = n4;
                            }
                            if (n6 == n2 && n5 + 1 == ((e)list.get(n3)).u()) {
                                b2.R0(((Number)list2.get(n3)).intValue());
                            } else {
                                b2.R0((int)(this.c((b)object) + l2) * -1);
                                this.a(l2, (b)object, n5 + 1, list, n3, n2, list2);
                            }
                            n3 = n2;
                        }
                        b2.O0((x)object);
                        return;
                    }
                    int n10 = Math.min((int)((e)object).u(), (int)e2.u());
                    if (n5 < n10) {
                        int n11 = n5;
                        n3 = 0;
                        while (true) {
                            int n12 = n11 + 1;
                            n6 = n3++;
                            if (((e)object).g(n11) != e2.g(n11)) break block28;
                            if (n12 >= n10) {
                                n6 = n3;
                                break block28;
                            }
                            n11 = n12;
                        }
                    }
                    n6 = 0;
                }
                l2 = l2 + this.c(b2) + (long)2 + (long)n6 + 1L;
                b2.R0(-n6);
                b2.R0(n7);
                n6 = n5 + n6;
                if (n5 < n6) {
                    while (true) {
                        n3 = n5 + 1;
                        b2.R0(((e)object).g(n5) & 0xFF);
                        if (n3 >= n6) break;
                        n5 = n3;
                    }
                }
                if (n2 + 1 == n4) {
                    n3 = n6 == ((e)list.get(n2)).u() ? 1 : 0;
                    if (n3 != 0) {
                        b2.R0(((Number)list2.get(n2)).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.");
                }
                object = new b();
                b2.R0((int)(this.c((b)object) + l2) * -1);
                this.a(l2, (b)object, n6, list, n2, n4, list2);
                b2.O0((x)object);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        static /* synthetic */ void b(a a2, long l2, b b2, int n2, List list, int n3, int n4, List list2, int n5, Object object) {
            if ((n5 & 1) != 0) {
                l2 = 0L;
            }
            if ((n5 & 4) != 0) {
                n2 = 0;
            }
            if ((n5 & 0x10) != 0) {
                n3 = 0;
            }
            if ((n5 & 0x20) != 0) {
                n4 = list.size();
            }
            a2.a(l2, b2, n2, list, n3, n4, list2);
        }

        private final long c(b b2) {
            return b2.A0() / (long)4;
        }

        public final o d(e ... objectArray) {
            Object[] objectArray2;
            k.e(objectArray, "byteStrings");
            int n2 = objectArray.length;
            int n3 = 0;
            if (n2 == 0) {
                return new o(new e[0], new int[]{0, -1}, null);
            }
            Object object = I2.i.x(objectArray);
            I2.o.p(object);
            Object object2 = new ArrayList(objectArray.length);
            int n4 = objectArray.length;
            for (n2 = 0; n2 < n4; ++n2) {
                objectArray2 = objectArray[n2];
                object2.add((Object)-1);
            }
            objectArray2 = object2.toArray((Object[])new Integer[0]);
            if (objectArray2 != null) {
                objectArray2 = (Integer[])objectArray2;
                objectArray2 = I2.o.k(Arrays.copyOf((Object[])objectArray2, (int)objectArray2.length));
                int n5 = objectArray.length;
                n4 = 0;
                n2 = 0;
                while (n4 < n5) {
                    objectArray2.set(I2.o.f(object, objectArray[n4], 0, 0, 6, null), (Object)n2);
                    ++n4;
                    ++n2;
                }
                n2 = ((e)object.get(0)).u() > 0 ? 1 : 0;
                if (n2 != 0) {
                    n4 = 0;
                    while (n4 < object.size()) {
                        e e2 = (e)object.get(n4);
                        n5 = n2 = n4 + 1;
                        while (n5 < object.size() && ((e)(object2 = (e)object.get(n5))).v(e2)) {
                            boolean bl = ((e)object2).u() != e2.u();
                            if (bl) {
                                if (((Number)objectArray2.get(n5)).intValue() > ((Number)objectArray2.get(n4)).intValue()) {
                                    object.remove(n5);
                                    objectArray2.remove(n5);
                                    continue;
                                }
                                ++n5;
                                continue;
                            }
                            throw new IllegalArgumentException(k.j("duplicate option: ", object2).toString());
                        }
                        n4 = n2;
                    }
                    object2 = new b();
                    a.b(this, 0L, (b)object2, 0, object, 0, 0, (List)objectArray2, 53, null);
                    object = new int[(int)this.c((b)object2)];
                    n2 = n3;
                    while (!((b)object2).O()) {
                        object[n2] = (List)((b)object2).D();
                        ++n2;
                    }
                    objectArray = Arrays.copyOf((Object[])objectArray, (int)objectArray.length);
                    k.d(objectArray, "java.util.Arrays.copyOf(this, size)");
                    return new o((e[])objectArray, (int[])object, null);
                }
                throw new IllegalArgumentException("the empty byte string is not a supported option");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }
}

