/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.Callable
 *  org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface
 */
package s0;

import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import s0.k;

public final class j
implements Callable {
    public final JsReplyProxyBoundaryInterface a;

    public /* synthetic */ j(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        this.a = jsReplyProxyBoundaryInterface;
    }

    public final Object call() {
        return k.a(this.a);
    }
}

