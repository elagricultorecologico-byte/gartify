/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 */
package G3;

import java.util.ArrayList;

public class e
extends ArrayList {
    private final int g;
    private final int h;

    e(int n2, int n3) {
        super(n2);
        this.g = n2;
        this.h = n3;
    }

    public static e h() {
        return new e(0, 0);
    }

    boolean c() {
        return this.size() < this.h;
    }
}

