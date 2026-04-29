/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.lang.Object
 *  java.util.concurrent.Callable
 */
package l1;

import C1.a;
import android.net.Uri;
import java.util.concurrent.Callable;
import l1.r;

final class i
implements Callable {
    private final r a;
    private final Uri b;
    private final a c;

    /* synthetic */ i(r r2, Uri uri, a a2) {
        this.a = r2;
        this.b = uri;
        this.c = a2;
    }

    public final /* synthetic */ Object call() {
        return this.a.s6(this.b, this.c);
    }
}

