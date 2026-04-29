/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.RemoteException
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package h2;

import android.os.Bundle;
import android.os.RemoteException;
import h2.l;
import h2.m;
import h2.n;
import i2.f;

final class j
extends i2.j {
    final L1.j h;
    final m i;

    j(m m2, L1.j j2, L1.j j3) {
        this.h = j3;
        this.i = m2;
        super(j2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected final void a() {
        RemoteException remoteException2;
        block4: {
            Object object;
            Bundle bundle;
            String string;
            f f2;
            block3: {
                try {
                    f2 = (f)this.i.a.e();
                    string = m.c(this.i);
                    bundle = new Bundle();
                    object = n.a();
                    bundle.putInt("playcore_version_code", ((Integer)object.get((Object)"java")).intValue());
                    if (!object.containsKey((Object)"native")) break block3;
                    bundle.putInt("playcore_native_version", ((Integer)object.get((Object)"native")).intValue());
                }
                catch (RemoteException remoteException2) {
                    break block4;
                }
            }
            if (object.containsKey((Object)"unity")) {
                bundle.putInt("playcore_unity_version", ((Integer)object.get((Object)"unity")).intValue());
            }
            object = this.i;
            l l2 = new l((m)object, this.h, m.c((m)object));
            f2.p5(string, bundle, l2);
            return;
        }
        m m2 = this.i;
        m.b().b(remoteException2, "error requesting in-app review for %s", m.c(m2));
        this.h.d((Exception)((Object)new RuntimeException((Throwable)remoteException2)));
    }
}

