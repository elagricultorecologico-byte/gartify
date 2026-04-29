/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 */
package N2;

import L2.e;
import L2.i;
import N2.a;

public abstract class j
extends a {
    public j(e e2) {
        super(e2);
        if (e2 != null) {
            if (e2.getContext() == L2.j.g) {
                return;
            }
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override
    public i getContext() {
        return L2.j.g;
    }
}

