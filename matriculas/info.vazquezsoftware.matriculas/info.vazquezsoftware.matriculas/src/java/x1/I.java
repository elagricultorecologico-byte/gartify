/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.IBinder
 *  android.os.IInterface
 *  java.lang.Object
 */
package x1;

import H1.n;
import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import x1.g0;

public interface i
extends IInterface {
    public Account b();

    public static abstract class a
    extends n
    implements i {
        public static i Z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (iInterface instanceof i) {
                return (i)iInterface;
            }
            return new g0(iBinder);
        }
    }
}

