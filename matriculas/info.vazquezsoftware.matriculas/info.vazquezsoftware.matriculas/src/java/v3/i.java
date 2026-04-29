/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.NoSuchMethodException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.UnsupportedOperationException
 *  java.util.List
 *  javax.net.ssl.SSLParameters
 *  javax.net.ssl.SSLSocket
 */
package v3;

import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import v3.g;
import v3.h;
import v3.k;

public class i
extends k {
    public static final a d;
    private static final boolean e;

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        boolean bl;
        block4: {
            block6: {
                block5: {
                    void var1_3;
                    d = new a(null);
                    String string = System.getProperty((String)"java.specification.version");
                    if (string == null) {
                        Object var1_1 = null;
                    } else {
                        Integer n2 = b3.h.m(string);
                    }
                    bl = false;
                    if (var1_3 == null) break block5;
                    if (var1_3.intValue() < 9) break block4;
                    break block6;
                }
                try {
                    SSLSocket.class.getMethod("getApplicationProtocol", null);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    break block4;
                }
            }
            bl = true;
        }
        e = bl;
    }

    @Override
    public void e(SSLSocket sSLSocket, String string, List objectArray) {
        V2.k.e(sSLSocket, "sslSocket");
        V2.k.e(objectArray, "protocols");
        string = sSLSocket.getSSLParameters();
        objectArray = k.a.b((List)objectArray).toArray((Object[])new String[0]);
        if (objectArray != null) {
            g.a((SSLParameters)string, (String[])objectArray);
            sSLSocket.setSSLParameters((SSLParameters)string);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override
    public String g(SSLSocket object) {
        boolean bl;
        block5: {
            block4: {
                V2.k.e(object, "sslSocket");
                try {
                    object = h.a(object);
                    if (object != null) break block4;
                    bl = true;
                    break block5;
                }
                catch (UnsupportedOperationException unsupportedOperationException) {
                    return null;
                }
            }
            bl = V2.k.a(object, "");
        }
        if (bl) {
            return null;
        }
        return object;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(V2.g g2) {
            this();
        }

        public final i a() {
            if (this.b()) {
                return new i();
            }
            return null;
        }

        public final boolean b() {
            return e;
        }
    }
}

