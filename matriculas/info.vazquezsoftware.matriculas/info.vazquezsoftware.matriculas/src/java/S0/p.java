/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  B3.a
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.InvocationHandler
 *  org.chromium.support_lib_boundary.WebMessageBoundaryInterface
 *  org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface
 */
package s0;

import B3.a;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;
import r0.e;
import r0.f;
import s0.r;
import s0.s;

public abstract class p
implements WebMessageBoundaryInterface {
    private static final String[] a = new String[]{"WEB_MESSAGE_ARRAY_BUFFER"};

    private static f[] a(InvocationHandler[] invocationHandlerArray) {
        f[] fArray = new f[invocationHandlerArray.length];
        for (int i2 = 0; i2 < invocationHandlerArray.length; ++i2) {
            fArray[i2] = new r(invocationHandlerArray[i2]);
        }
        return fArray;
    }

    public static e b(WebMessageBoundaryInterface webMessageBoundaryInterface) {
        f[] fArray = p.a(webMessageBoundaryInterface.getPorts());
        if (s.C.d()) {
            int n2 = (webMessageBoundaryInterface = (WebMessagePayloadBoundaryInterface)B3.a.a(WebMessagePayloadBoundaryInterface.class, (InvocationHandler)webMessageBoundaryInterface.getMessagePayload())).getType();
            if (n2 != 0) {
                if (n2 != 1) {
                    return null;
                }
                return new e(webMessageBoundaryInterface.getAsArrayBuffer(), fArray);
            }
            return new e(webMessageBoundaryInterface.getAsString(), fArray);
        }
        return new e(webMessageBoundaryInterface.getData(), fArray);
    }
}

