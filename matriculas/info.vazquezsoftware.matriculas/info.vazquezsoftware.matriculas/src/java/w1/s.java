/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.DeadObjectException
 *  android.os.RemoteException
 *  com.google.android.gms.common.api.Status
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.RuntimeException
 */
package w1;

import L1.j;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import v1.b;
import w1.H;
import w1.V;
import w1.z;

abstract class S
extends H {
    protected final j b;

    public S(int n2, j j2) {
        super(n2);
        this.b = j2;
    }

    @Override
    public final void a(Status object) {
        object = new b((Status)object);
        this.b.d((Exception)((Object)object));
    }

    @Override
    public final void b(Exception exception) {
        this.b.d(exception);
    }

    @Override
    public final void c(z z2) {
        try {
            this.h(z2);
            return;
        }
        catch (RuntimeException runtimeException) {
            this.b.d((Exception)((Object)runtimeException));
            return;
        }
        catch (RemoteException remoteException) {
            this.a(V.e(remoteException));
            return;
        }
        catch (DeadObjectException deadObjectException) {
            this.a(V.e((RemoteException)((Object)deadObjectException)));
            throw deadObjectException;
        }
    }

    protected abstract void h(z var1);
}

