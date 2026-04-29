/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 */
package k0;

import V2.k;

abstract class e {
    public static final Void a(String string) {
        k.e(string, "key");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No valid saved state was found for the key '");
        stringBuilder.append(string);
        stringBuilder.append("'. It may be missing, null, or not of the expected type. This can occur if the value was saved with a different type or if the saved state was modified unexpectedly.");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}

