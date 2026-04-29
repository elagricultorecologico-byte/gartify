/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 */
package r;

import r.f;

class g
implements f {
    private final Object[] a;
    private int b;

    g(int n2) {
        if (n2 > 0) {
            this.a = new Object[n2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override
    public boolean a(Object object) {
        int n2 = this.b;
        Object[] objectArray = this.a;
        if (n2 < objectArray.length) {
            objectArray[n2] = object;
            this.b = n2 + 1;
            return true;
        }
        return false;
    }

    @Override
    public Object b() {
        int n2 = this.b;
        if (n2 > 0) {
            int n3 = n2 - 1;
            Object[] objectArray = this.a;
            Object object = objectArray[n3];
            objectArray[n3] = null;
            this.b = n2 - 1;
            return object;
        }
        return null;
    }

    @Override
    public void c(Object[] objectArray, int n2) {
        int n3 = n2;
        if (n2 > objectArray.length) {
            n3 = objectArray.length;
        }
        for (n2 = 0; n2 < n3; ++n2) {
            Object object = objectArray[n2];
            int n4 = this.b;
            Object[] objectArray2 = this.a;
            if (n4 >= objectArray2.length) continue;
            objectArray2[n4] = object;
            this.b = n4 + 1;
        }
    }
}

