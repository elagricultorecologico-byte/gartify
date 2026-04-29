/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  com.google.android.gms.common.api.Status
 *  java.lang.Object
 *  java.lang.Override
 *  u1.b
 */
package K1;

import G1.c;
import K1.b;
import K1.f;
import K1.h;
import K1.l;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract class e
extends G1.b
implements f {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override
    protected final boolean h1(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return false;
            }
            case 9: {
                h h2 = (h)c.a(parcel, h.CREATOR);
                c.b(parcel);
                break;
            }
            case 8: {
                l l2 = (l)c.a(parcel, l.CREATOR);
                c.b(parcel);
                this.G2(l2);
                break;
            }
            case 7: {
                Status status = (Status)c.a(parcel, Status.CREATOR);
                status = (GoogleSignInAccount)c.a(parcel, GoogleSignInAccount.CREATOR);
                c.b(parcel);
                break;
            }
            case 6: {
                Status status = (Status)c.a(parcel, Status.CREATOR);
                c.b(parcel);
                break;
            }
            case 4: {
                Status status = (Status)c.a(parcel, Status.CREATOR);
                c.b(parcel);
                break;
            }
            case 3: {
                Object object = (u1.b)c.a(parcel, u1.b.CREATOR);
                object = (b)c.a(parcel, b.CREATOR);
                c.b(parcel);
            }
        }
        parcel2.writeNoException();
        return true;
    }
}

