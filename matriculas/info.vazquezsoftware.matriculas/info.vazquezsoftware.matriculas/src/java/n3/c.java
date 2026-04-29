/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.concurrent.ThreadFactory
 */
package n3;

import java.util.concurrent.ThreadFactory;
import n3.d;

public final class c
implements ThreadFactory {
    public final String a;
    public final boolean b;

    public /* synthetic */ c(String string, boolean bl) {
        this.a = string;
        this.b = bl;
    }

    public final Thread newThread(Runnable runnable) {
        return d.a(this.a, this.b, runnable);
    }
}

