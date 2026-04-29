/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package h0;

public abstract class b {
    public static String a(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '");
        stringBuilder.append(string);
        stringBuilder.append("')");
        return stringBuilder.toString();
    }
}

