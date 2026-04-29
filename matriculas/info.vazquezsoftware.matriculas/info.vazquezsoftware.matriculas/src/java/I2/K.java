/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder$DeathRecipient
 *  i2.t
 *  java.lang.Object
 */
package i2;

import android.os.IBinder;
import i2.t;

public final class k
implements IBinder.DeathRecipient {
    public final t a;

    public /* synthetic */ k(t t2) {
        this.a = t2;
    }

    public final void binderDied() {
        t.j((t)this.a);
    }
}

