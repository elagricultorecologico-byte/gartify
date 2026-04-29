/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  B3.a
 *  java.lang.Object
 *  java.lang.reflect.InvocationHandler
 *  java.util.concurrent.Callable
 *  org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface
 */
package s0;

import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import r0.a;
import s0.j;

public class k
extends a {
    private final JsReplyProxyBoundaryInterface a;

    public k(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        this.a = jsReplyProxyBoundaryInterface;
    }

    public static /* synthetic */ Object a(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        return new k(jsReplyProxyBoundaryInterface);
    }

    public static k b(InvocationHandler invocationHandler) {
        invocationHandler = (JsReplyProxyBoundaryInterface)B3.a.a(JsReplyProxyBoundaryInterface.class, (InvocationHandler)invocationHandler);
        return (k)invocationHandler.getOrCreatePeer((Callable)new j((JsReplyProxyBoundaryInterface)invocationHandler));
    }
}

