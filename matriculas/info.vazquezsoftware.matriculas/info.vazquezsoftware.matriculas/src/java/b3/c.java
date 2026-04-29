/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.Object
 */
package b3;

import b3.b;

abstract class c
extends b {
    public static final boolean d(char c3, char c4, boolean bl) {
        if (c3 == c4) {
            return true;
        }
        if (!bl) {
            return false;
        }
        return (c3 = Character.toUpperCase((char)c3)) == (c4 = Character.toUpperCase((char)c4)) || Character.toLowerCase((char)c3) == Character.toLowerCase((char)c4);
        {
        }
    }
}

