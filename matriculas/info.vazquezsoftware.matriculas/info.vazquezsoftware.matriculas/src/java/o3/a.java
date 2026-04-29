/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.net.Authenticator
 *  java.net.Authenticator$RequestorType
 *  java.net.InetAddress
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.URL
 *  java.util.Iterator
 *  java.util.List
 */
package o3;

import I2.o;
import V2.k;
import b3.h;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import m3.A;
import m3.C;
import m3.b;
import m3.g;
import m3.n;
import m3.p;
import m3.t;
import m3.y;

public final class a
implements b {
    private final p d;

    public a(p p2) {
        k.e(p2, "defaultDns");
        this.d = p2;
    }

    public /* synthetic */ a(p p2, int n2, V2.g g2) {
        if ((n2 & 1) != 0) {
            p2 = p.b;
        }
        this(p2);
    }

    private final InetAddress b(Proxy proxy, t t2, p p2) {
        Proxy.Type type = proxy.type();
        int n2 = type == null ? -1 : a.a[type.ordinal()];
        if (n2 == 1) {
            return (InetAddress)o.w(p2.a(t2.h()));
        }
        if ((proxy = proxy.address()) != null) {
            proxy = ((InetSocketAddress)proxy).getAddress();
            k.d(proxy, "address() as InetSocketAddress).address");
            return proxy;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    @Override
    public y a(C object, A object2) {
        g g2;
        k.e(object2, "response");
        List list = ((A)object2).j();
        y y2 = ((A)object2).i0();
        t t2 = y2.i();
        boolean bl = ((A)object2).p() == 407;
        object2 = object == null ? null : ((C)object).b();
        Object object3 = object2;
        if (object2 == null) {
            object3 = Proxy.NO_PROXY;
        }
        Iterator iterator = list.iterator();
        while (true) {
            void var5_7;
            if (!iterator.hasNext()) {
                return null;
            }
            g2 = (g)iterator.next();
            if (!h.u("Basic", g2.c(), true)) continue;
            object2 = object == null || (object2 = ((C)object).a()) == null ? null : ((m3.a)object2).c();
            Object object4 = object2;
            if (object2 == null) {
                p p2 = this.d;
            }
            if (bl) {
                object2 = object3.address();
                if (object2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
                }
                object2 = (InetSocketAddress)object2;
                String string = object2.getHostName();
                k.d(object3, "proxy");
                object2 = Authenticator.requestPasswordAuthentication((String)string, (InetAddress)this.b((Proxy)object3, t2, (p)var5_7), (int)object2.getPort(), (String)t2.p(), (String)g2.b(), (String)g2.c(), (URL)t2.r(), (Authenticator.RequestorType)Authenticator.RequestorType.PROXY);
            } else {
                object2 = t2.h();
                k.d(object3, "proxy");
                object2 = Authenticator.requestPasswordAuthentication((String)object2, (InetAddress)this.b((Proxy)object3, t2, (p)var5_7), (int)t2.l(), (String)t2.p(), (String)g2.b(), (String)g2.c(), (URL)t2.r(), (Authenticator.RequestorType)Authenticator.RequestorType.SERVER);
            }
            if (object2 != null) break;
        }
        object = bl ? "Proxy-Authorization" : "Authorization";
        object3 = object2.getUserName();
        k.d(object3, "auth.userName");
        object2 = object2.getPassword();
        k.d(object2, "auth.password");
        object2 = n.a((String)object3, new String((char[])object2), g2.a());
        return y2.h().d((String)object, (String)object2).b();
    }

    public abstract class a {
        public static final int[] a;

        static {
            int[] nArray = new int[Proxy.Type.values().length];
            nArray[Proxy.Type.DIRECT.ordinal()] = 1;
            a = nArray;
        }
    }
}

