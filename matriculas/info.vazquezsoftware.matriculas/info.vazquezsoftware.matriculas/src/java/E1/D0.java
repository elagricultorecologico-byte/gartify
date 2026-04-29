/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  u1.i
 */
package e1;

import X0.a;
import android.content.Context;
import e1.B;
import e1.o0;
import f1.m;
import f1.p;
import java.io.IOException;
import u1.i;

final class d0
extends B {
    private final Context c;

    d0(Context context) {
        this.c = context;
    }

    @Override
    public final void a() {
        Object object;
        int n2;
        boolean bl;
        block4: {
            try {
                bl = a.b(this.c);
                break block4;
            }
            catch (i i2) {
            }
            catch (IllegalStateException illegalStateException) {
            }
            catch (IOException iOException) {
                // empty catch block
            }
            n2 = o0.b;
            p.d("Fail to get isAdIdFakeForDebugLogging", (Throwable)object);
            bl = false;
        }
        m.h(bl);
        object = new StringBuilder(String.valueOf((boolean)bl).length() + 38);
        object.append("Update ad debug logging enablement as ");
        object.append(bl);
        object = object.toString();
        n2 = o0.b;
        p.f((String)object);
    }
}

