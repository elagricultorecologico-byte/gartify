/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Binder
 *  android.os.RemoteException
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package x1;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import x1.i;

public abstract class a
extends i.a {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Account c0(i i2) {
        Throwable throwable2222222;
        long l2;
        block5: {
            if (i2 == null) {
                return null;
            }
            l2 = Binder.clearCallingIdentity();
            i2 = i2.b();
            {
                catch (Throwable throwable2222222) {
                    break block5;
                }
                catch (RemoteException remoteException) {}
                {
                    Log.w((String)"AccountAccessor", (String)"Remote account accessor probably died");
                }
                Binder.restoreCallingIdentity((long)l2);
                return null;
            }
            Binder.restoreCallingIdentity((long)l2);
            return i2;
        }
        Binder.restoreCallingIdentity((long)l2);
        throw throwable2222222;
    }
}

