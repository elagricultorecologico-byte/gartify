/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package H3;

import F3.m;
import H3.e;
import H3.g;

public abstract class f {
    public static e.a a(e e2, m m2) {
        Object object = m2;
        int n2 = 0;
        while (object != null) {
            Object object2;
            int n3;
            m m3;
            block19: {
                block18: {
                    e.a a2 = e2.b((m)object, n2);
                    if (a2 == e.a.k) {
                        return a2;
                    }
                    m3 = object;
                    n3 = n2;
                    object2 = a2;
                    if (a2 == e.a.g) {
                        m3 = object;
                        n3 = n2++;
                        object2 = a2;
                        if (object.k() > 0) {
                            object = object.i(0);
                            continue;
                        }
                    }
                    while (m3.w() == null && n3 > 0) {
                        block17: {
                            block16: {
                                a2 = e.a.g;
                                if (object2 == a2) break block16;
                                object = object2;
                                if (object2 != e.a.h) break block17;
                            }
                            object2 = e2.a(m3, n3);
                            object = object2;
                            if (object2 == e.a.k) {
                                return object2;
                            }
                        }
                        m m4 = m3.F();
                        --n3;
                        if (object == e.a.j) {
                            m3.I();
                        }
                        object2 = a2;
                        m3 = m4;
                    }
                    if (object2 == e.a.g) break block18;
                    object = object2;
                    if (object2 != e.a.h) break block19;
                }
                object2 = e2.a(m3, n3);
                object = object2;
                if (object2 == e.a.k) {
                    return object2;
                }
            }
            if (m3 == m2) {
                return object;
            }
            object2 = m3.w();
            if (object == e.a.j) {
                m3.I();
            }
            object = object2;
            n2 = n3;
        }
        return e.a.g;
    }

    public static void b(g g2, m m2) {
        m m3 = m2;
        int n2 = 0;
        while (m3 != null) {
            int n3;
            m m4 = m3.F();
            g2.b(m3, n2);
            m m5 = m3;
            if (m4 != null) {
                m5 = m3;
                if (!m3.u()) {
                    m5 = m4.i(m3.R());
                }
            }
            m3 = m5;
            if (m5.k() > 0) {
                m3 = m5.i(0);
                continue;
            }
            for (n3 = n2++; m3.w() == null && n3 > 0; --n3) {
                g2.a(m3, n3);
                m3 = m3.F();
            }
            g2.a(m3, n3);
            if (m3 == m2) break;
            m3 = m3.w();
            n2 = n3;
        }
    }
}

