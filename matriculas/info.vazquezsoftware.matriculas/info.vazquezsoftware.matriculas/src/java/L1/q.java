/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.du
 *  java.lang.Object
 *  java.util.concurrent.Callable
 */
package l1;

import android.os.Bundle;
import com.google.android.gms.internal.ads.du;
import java.util.concurrent.Callable;
import l1.r;

final class q
implements Callable {
    private final r a;
    private final du b;
    private final Bundle c;

    /* synthetic */ q(r r2, du du2, Bundle bundle) {
        this.a = r2;
        this.b = du2;
        this.c = bundle;
    }

    public final /* synthetic */ Object call() {
        return this.a.p6(this.b, this.c);
    }
}

