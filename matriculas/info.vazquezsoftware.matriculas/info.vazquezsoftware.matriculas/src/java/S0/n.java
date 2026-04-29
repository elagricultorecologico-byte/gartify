/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  B3.a
 *  java.lang.Object
 *  java.lang.reflect.InvocationHandler
 *  org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface
 */
package s0;

import B3.a;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface;
import r0.d;

public class n
implements d {
    private final ScriptHandlerBoundaryInterface a;

    private n(ScriptHandlerBoundaryInterface scriptHandlerBoundaryInterface) {
        this.a = scriptHandlerBoundaryInterface;
    }

    public static n a(InvocationHandler invocationHandler) {
        return new n((ScriptHandlerBoundaryInterface)B3.a.a(ScriptHandlerBoundaryInterface.class, (InvocationHandler)invocationHandler));
    }
}

