/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.InetAddress
 *  java.net.UnknownHostException
 *  java.util.List
 */
package m3;

import I2.i;
import V2.k;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public interface p {
    public static final a a = m3.p$a.a;
    public static final p b = new a.a();

    public List a(String var1);

    public static final class m3.p$a {
        static final m3.p$a a = new m3.p$a();

        private m3.p$a() {
        }

        private static final class a
        implements p {
            @Override
            public List a(String string) {
                k.e(string, "hostname");
                try {
                    List list = InetAddress.getAllByName((String)string);
                    k.d(list, "getAllByName(hostname)");
                    list = i.w((Object[])list);
                    return list;
                }
                catch (NullPointerException nullPointerException) {
                    string = new UnknownHostException(k.j("Broken system behaviour for dns lookup of ", string));
                    string.initCause((Throwable)nullPointerException);
                    throw string;
                }
            }
        }
    }
}

