/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.Signature
 *  android.content.pm.SigningInfo
 *  java.lang.Object
 */
package u1;

import android.content.pm.Signature;
import android.content.pm.SigningInfo;

public abstract class n {
    public static /* bridge */ /* synthetic */ Signature[] a(SigningInfo signingInfo) {
        return signingInfo.getSigningCertificateHistory();
    }
}

