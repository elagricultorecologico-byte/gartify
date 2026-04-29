/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.List
 */
package h3;

import H2.d;
import c3.z0;
import h3.r;
import h3.u;
import java.util.List;

public abstract class t {
    private static final u a(Throwable throwable, String string) {
        if (throwable != null) {
            throw throwable;
        }
        t.d();
        throw new d();
    }

    static /* synthetic */ u b(Throwable throwable, String string, int n2, Object object) {
        if ((n2 & 1) != 0) {
            throwable = null;
        }
        if ((n2 & 2) != 0) {
            string = null;
        }
        return t.a(throwable, string);
    }

    public static final boolean c(z0 z02) {
        return z02.N0() instanceof u;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final z0 e(r r2, List object) {
        try {
            object = r2.b((List)object);
            return object;
        }
        catch (Throwable throwable) {
            return t.a(throwable, r2.a());
        }
    }
}

