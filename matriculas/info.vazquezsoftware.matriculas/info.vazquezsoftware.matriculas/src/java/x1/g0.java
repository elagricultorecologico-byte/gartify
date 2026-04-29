/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.IBinder
 *  android.os.Parcel
 *  java.lang.Object
 *  java.lang.Override
 */
package x1;

import H1.a;
import H1.o;
import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import x1.i;

public final class g0
extends a
implements i {
    g0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override
    public final Account b() {
        Parcel parcel = this.a(2, this.Z());
        Account account = (Account)o.a(parcel, Account.CREATOR);
        parcel.recycle();
        return account;
    }
}

