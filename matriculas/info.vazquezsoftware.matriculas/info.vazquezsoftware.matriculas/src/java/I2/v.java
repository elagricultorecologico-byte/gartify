/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  java.lang.Object
 *  java.lang.String
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 */
package i2;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class v {
    public static String a(byte[] byArray) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance((String)"SHA-256");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            return "";
        }
        messageDigest.update(byArray);
        return Base64.encodeToString((byte[])messageDigest.digest(), (int)11);
    }
}

