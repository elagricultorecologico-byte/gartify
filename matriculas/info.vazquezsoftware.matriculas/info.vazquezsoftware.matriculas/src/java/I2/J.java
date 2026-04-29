/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 */
package i2;

public abstract class j
implements Runnable {
    private final L1.j g;

    j() {
        this.g = null;
    }

    public j(L1.j j2) {
        this.g = j2;
    }

    protected abstract void a();

    final L1.j b() {
        return this.g;
    }

    public final void c(Exception exception) {
        L1.j j2 = this.g;
        if (j2 != null) {
            j2.d(exception);
        }
    }

    public final void run() {
        try {
            this.a();
            return;
        }
        catch (Exception exception) {
            this.c(exception);
            return;
        }
    }
}

