/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package c3;

import c3.Z;
import c3.l0;
import c3.m0;
import h3.D;

public abstract class w0 {
    private static final D a = new D("COMPLETING_ALREADY");
    public static final D b = new D("COMPLETING_WAITING_CHILDREN");
    private static final D c = new D("COMPLETING_RETRY");
    private static final D d = new D("TOO_LATE_TO_CANCEL");
    private static final D e = new D("SEALED");
    private static final Z f = new Z(false);
    private static final Z g = new Z(true);

    public static final /* synthetic */ D a() {
        return a;
    }

    public static final /* synthetic */ D b() {
        return c;
    }

    public static final /* synthetic */ Z c() {
        return g;
    }

    public static final /* synthetic */ Z d() {
        return f;
    }

    public static final /* synthetic */ D e() {
        return e;
    }

    public static final /* synthetic */ D f() {
        return d;
    }

    public static final Object g(Object object) {
        if (object instanceof l0) {
            return new m0((l0)object);
        }
        return object;
    }

    public static final Object h(Object object) {
        Object object2 = object instanceof m0 ? (m0)object : null;
        if (object2 != null && (object2 = ((m0)object2).a) != null) {
            return object2;
        }
        return object;
    }
}

