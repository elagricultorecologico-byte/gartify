/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.AssertionError
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.Socket
 *  java.net.SocketTimeoutException
 *  java.nio.charset.Charset
 *  java.nio.charset.StandardCharsets
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.TimeZone
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 */
package n3;

import H2.a;
import I2.D;
import I2.E;
import I2.i;
import I2.o;
import V2.k;
import V2.v;
import b3.g;
import b3.h;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import m3.A;
import m3.B;
import m3.e;
import m3.q;
import m3.s;
import m3.t;
import m3.w;
import m3.z;
import n3.b;
import n3.c;
import z3.o;
import z3.x;

public abstract class d {
    public static final byte[] a;
    public static final s b;
    public static final B c;
    public static final z d;
    private static final z3.o e;
    public static final TimeZone f;
    private static final g g;
    public static final boolean h;
    public static final String i;

    static {
        Object object = new byte[]{};
        a = object;
        b = s.h.g(new String[0]);
        c = B.a.c(B.g, object, null, 1, null);
        d = z.a.c(z.a, object, null, 0, 0, 7, null);
        o.a a2 = z3.o.j;
        object = z3.e.j;
        e = a2.d(object.a("efbbbf"), object.a("feff"), object.a("fffe"), object.a("0000ffff"), object.a("ffff0000"));
        object = TimeZone.getTimeZone((String)"GMT");
        k.b(object);
        f = object;
        g = new g("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        h = false;
        object = w.class.getName();
        k.d(object, "OkHttpClient::class.java.name");
        i = b3.h.f0(b3.h.e0((String)object, "okhttp3."), "Client");
    }

    public static /* synthetic */ int A(String string, int n2, int n3, int n4, Object object) {
        if ((n4 & 1) != 0) {
            n2 = 0;
        }
        if ((n4 & 2) != 0) {
            n3 = string.length();
        }
        return n3.d.z(string, n2, n3);
    }

    public static final int B(String string, int n2, int n3) {
        block3: {
            k.e(string, "<this>");
            if (n2 <= --n3) {
                char c2;
                while ((c2 = string.charAt(n3)) == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                    if (n3 != n2) {
                        --n3;
                        continue;
                    }
                    break block3;
                }
                return n3 + 1;
            }
        }
        return n2;
    }

    public static /* synthetic */ int C(String string, int n2, int n3, int n4, Object object) {
        if ((n4 & 1) != 0) {
            n2 = 0;
        }
        if ((n4 & 2) != 0) {
            n3 = string.length();
        }
        return n3.d.B(string, n2, n3);
    }

    public static final int D(String string, int n2) {
        k.e(string, "<this>");
        int n3 = string.length();
        while (n2 < n3) {
            char c2 = string.charAt(n2);
            if (c2 != ' ' && c2 != '\t') {
                return n2;
            }
            ++n2;
        }
        return string.length();
    }

    public static final String[] E(String[] objectArray, String[] stringArray, Comparator comparator) {
        k.e(objectArray, "<this>");
        k.e(stringArray, "other");
        k.e(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        int n2 = objectArray.length;
        int n3 = 0;
        block0: while (n3 < n2) {
            String string;
            String string2 = objectArray[n3];
            int n4 = n3 + 1;
            int n5 = stringArray.length;
            int n6 = 0;
            do {
                n3 = n4;
                if (n6 >= n5) continue block0;
                string = stringArray[n6];
                ++n6;
            } while (comparator.compare((Object)string2, (Object)string) != 0);
            arrayList.add((Object)string2);
            n3 = n4;
        }
        objectArray = arrayList.toArray((Object[])new String[0]);
        if (objectArray != null) {
            return (String[])objectArray;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean F(Socket socket, z3.d d2) {
        boolean bl;
        k.e(socket, "<this>");
        k.e(d2, "source");
        boolean bl2 = true;
        int n2 = socket.getSoTimeout();
        try {
            socket.setSoTimeout(1);
            bl = d2.O();
        }
        catch (Throwable throwable) {
            try {
                socket.setSoTimeout(n2);
                throw throwable;
            }
            catch (IOException iOException) {
                return false;
            }
            catch (SocketTimeoutException socketTimeoutException) {
                return bl2;
            }
        }
        socket.setSoTimeout(n2);
        return bl ^ true;
    }

    public static final boolean G(String string) {
        k.e(string, "name");
        return b3.h.u(string, "Authorization", true) || b3.h.u(string, "Cookie", true) || b3.h.u(string, "Proxy-Authorization", true) || b3.h.u(string, "Set-Cookie", true);
        {
        }
    }

    public static final int H(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - 48;
        }
        if ('a' <= c2 && c2 < 'g') {
            return c2 - 87;
        }
        if ('A' <= c2 && c2 < 'G') {
            return c2 - 55;
        }
        return -1;
    }

    public static final Charset I(z3.d d2, Charset charset) {
        k.e(d2, "<this>");
        k.e(charset, "default");
        int n2 = d2.H0(e);
        if (n2 != -1) {
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 == 4) {
                                return b3.d.a.b();
                            }
                            throw new AssertionError();
                        }
                        return b3.d.a.a();
                    }
                    d2 = StandardCharsets.UTF_16LE;
                    k.d(d2, "UTF_16LE");
                    return d2;
                }
                d2 = StandardCharsets.UTF_16BE;
                k.d(d2, "UTF_16BE");
                return d2;
            }
            d2 = StandardCharsets.UTF_8;
            k.d(d2, "UTF_8");
            return d2;
        }
        return charset;
    }

    public static final int J(z3.d d2) {
        k.e(d2, "<this>");
        int n2 = n3.d.d(d2.G0(), 255);
        int n3 = n3.d.d(d2.G0(), 255);
        return n3.d.d(d2.G0(), 255) | (n2 << 16 | n3 << 8);
    }

    public static final int K(z3.b b2, byte by) {
        k.e(b2, "<this>");
        int n2 = 0;
        while (!b2.O() && b2.L(0L) == by) {
            ++n2;
            b2.G0();
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final boolean L(x x2, int n2, TimeUnit object) {
        Throwable throwable2222;
        long l2;
        long l3;
        block7: {
            k.e(x2, "<this>");
            k.e(object, "timeUnit");
            l3 = System.nanoTime();
            l2 = x2.h().e() ? x2.h().c() - l3 : Long.MAX_VALUE;
            x2.h().d(Math.min((long)l2, (long)object.toNanos((long)n2)) + l3);
            try {
                object = new z3.b();
                while (x2.j0((z3.b)object, 8192L) != -1L) {
                    ((z3.b)object).a();
                }
            }
            catch (Throwable throwable2222) {
                break block7;
            }
            catch (InterruptedIOException interruptedIOException) {
                if (l2 == Long.MAX_VALUE) {
                    x2.h().a();
                    return false;
                }
                x2.h().d(l3 + l2);
                return false;
            }
            if (l2 == Long.MAX_VALUE) {
                x2.h().a();
                return true;
            }
            x2.h().d(l3 + l2);
            return true;
        }
        if (l2 == Long.MAX_VALUE) {
            x2.h().a();
            throw throwable2222;
        }
        x2.h().d(l3 + l2);
        throw throwable2222;
    }

    public static final ThreadFactory M(String string, boolean bl) {
        k.e(string, "name");
        return new c(string, bl);
    }

    private static final Thread N(String string, boolean bl, Runnable runnable) {
        k.e(string, "$name");
        string = new Thread(runnable, string);
        string.setDaemon(bl);
        return string;
    }

    public static final List O(s s2) {
        k.e(s2, "<this>");
        Y2.c c2 = Y2.d.h(0, s2.size());
        ArrayList arrayList = new ArrayList(o.o(c2, 10));
        c2 = c2.iterator();
        while (c2.hasNext()) {
            int n2 = ((D)((Object)c2)).b();
            arrayList.add((Object)new u3.c(s2.f(n2), s2.i(n2)));
        }
        return arrayList;
    }

    public static final s P(List object) {
        k.e(object, "<this>");
        s.a a2 = new s.a();
        Iterator iterator = object.iterator();
        while (iterator.hasNext()) {
            Object object2 = (u3.c)iterator.next();
            object = ((u3.c)object2).a();
            object2 = ((u3.c)object2).b();
            a2.c(((z3.e)object).x(), ((z3.e)object2).x());
        }
        return a2.d();
    }

    public static final String Q(t t2, boolean bl) {
        String string;
        k.e(t2, "<this>");
        if (b3.h.J(t2.h(), ":", false, 2, null)) {
            string = new StringBuilder();
            string.append('[');
            string.append(t2.h());
            string.append(']');
            string = string.toString();
        } else {
            string = t2.h();
        }
        if (!bl && t2.l() == t.k.c(t2.p())) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(':');
        stringBuilder.append(t2.l());
        return stringBuilder.toString();
    }

    public static /* synthetic */ String R(t t2, boolean bl, int n2, Object object) {
        if ((n2 & 1) != 0) {
            bl = false;
        }
        return n3.d.Q(t2, bl);
    }

    public static final List S(List list) {
        k.e(list, "<this>");
        list = Collections.unmodifiableList((List)o.M((Collection)list));
        k.d(list, "unmodifiableList(toMutableList())");
        return list;
    }

    public static final Map T(Map map) {
        k.e(map, "<this>");
        if (map.isEmpty()) {
            return E.f();
        }
        map = Collections.unmodifiableMap((Map)new LinkedHashMap(map));
        k.d(map, "{\n    Collections.unmodi\u2026(LinkedHashMap(this))\n  }");
        return map;
    }

    public static final long U(String string, long l2) {
        k.e(string, "<this>");
        try {
            long l3 = Long.parseLong((String)string);
            return l3;
        }
        catch (NumberFormatException numberFormatException) {
            return l2;
        }
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final int V(String string, int n2) {
        if (string == null) {
            string = null;
        } else {
            string = Long.valueOf((long)Long.parseLong((String)string));
        }
        if (string != null) {
            long l2 = string.longValue();
            if (l2 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (l2 >= 0L) return (int)l2;
            return 0;
        }
        return n2;
        catch (NumberFormatException numberFormatException) {
            return n2;
        }
    }

    public static final String W(String string, int n2, int n3) {
        k.e(string, "<this>");
        n2 = n3.d.z(string, n2, n3);
        string = string.substring(n2, n3.d.B(string, n2, n3));
        k.d(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return string;
    }

    public static /* synthetic */ String X(String string, int n2, int n3, int n4, Object object) {
        if ((n4 & 1) != 0) {
            n2 = 0;
        }
        if ((n4 & 2) != 0) {
            n3 = string.length();
        }
        return n3.d.W(string, n2, n3);
    }

    public static final Throwable Y(Exception exception, List list) {
        k.e((Object)exception, "<this>");
        k.e(list, "suppressed");
        if (list.size() > 1) {
            System.out.println((Object)list);
        }
        list = list.iterator();
        while (list.hasNext()) {
            H2.a.a(exception, (Exception)((Object)list.next()));
        }
        return exception;
    }

    public static final void Z(z3.c c2, int n2) {
        k.e(c2, "<this>");
        c2.Q(n2 >>> 16 & 0xFF);
        c2.Q(n2 >>> 8 & 0xFF);
        c2.Q(n2 & 0xFF);
    }

    public static /* synthetic */ Thread a(String string, boolean bl, Runnable runnable) {
        return n3.d.N(string, bl, runnable);
    }

    public static /* synthetic */ q b(q q2, e e2) {
        return n3.d.h(q2, e2);
    }

    public static final void c(List list, Object object) {
        k.e(list, "<this>");
        if (!list.contains(object)) {
            list.add(object);
        }
    }

    public static final int d(byte by, int n2) {
        return by & n2;
    }

    public static final int e(short s2, int n2) {
        return s2 & n2;
    }

    public static final long f(int n2, long l2) {
        return l2 & (long)n2;
    }

    public static final q.c g(q q2) {
        k.e(q2, "<this>");
        return new b(q2);
    }

    private static final q h(q q2, e e2) {
        k.e(q2, "$this_asFactory");
        k.e(e2, "it");
        return q2;
    }

    public static final boolean i(String string) {
        k.e(string, "<this>");
        return g.a(string);
    }

    public static final boolean j(t t2, t t3) {
        k.e(t2, "<this>");
        k.e(t3, "other");
        return k.a(t2.h(), t3.h()) && t2.l() == t3.l() && k.a(t2.p(), t3.p());
    }

    public static final int k(String string, long l2, TimeUnit timeUnit) {
        k.e(string, "name");
        long l3 = l2 - 0L;
        long l4 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
        if (l4 >= 0) {
            if (timeUnit != null) {
                if ((l2 = timeUnit.toMillis(l2)) <= Integer.MAX_VALUE) {
                    if (l2 == 0L && l4 > 0) {
                        throw new IllegalArgumentException(k.j(string, " too small.").toString());
                    }
                    return (int)l2;
                }
                throw new IllegalArgumentException(k.j(string, " too large.").toString());
            }
            throw new IllegalStateException("unit == null");
        }
        throw new IllegalStateException(k.j(string, " < 0").toString());
    }

    public static final void l(long l2, long l3, long l4) {
        if ((l3 | l4) >= 0L && l3 <= l2 && l2 - l3 >= l4) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final void m(Closeable closeable) {
        k.e(closeable, "<this>");
        try {
            closeable.close();
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final void n(Socket socket) {
        k.e(socket, "<this>");
        try {
            socket.close();
            return;
        }
        catch (RuntimeException runtimeException) {
            if (!k.a(runtimeException.getMessage(), "bio == null")) throw runtimeException;
            return;
        }
        catch (AssertionError assertionError) {
            throw assertionError;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static final String[] o(String[] objectArray, String string) {
        k.e(objectArray, "<this>");
        k.e(string, "value");
        objectArray = Arrays.copyOf((Object[])objectArray, (int)(objectArray.length + 1));
        k.d(objectArray, "copyOf(this, newSize)");
        objectArray = (String[])objectArray;
        objectArray[I2.i.r((Object[])objectArray)] = string;
        return objectArray;
    }

    public static final int p(String string, char c2, int n2, int n3) {
        k.e(string, "<this>");
        while (n2 < n3) {
            if (string.charAt(n2) == c2) {
                return n2;
            }
            ++n2;
        }
        return n3;
    }

    public static final int q(String string, String string2, int n2, int n3) {
        k.e(string, "<this>");
        k.e(string2, "delimiters");
        while (n2 < n3) {
            if (b3.h.I(string2, string.charAt(n2), false, 2, null)) {
                return n2;
            }
            ++n2;
        }
        return n3;
    }

    public static /* synthetic */ int r(String string, char c2, int n2, int n3, int n4, Object object) {
        if ((n4 & 2) != 0) {
            n2 = 0;
        }
        if ((n4 & 4) != 0) {
            n3 = string.length();
        }
        return n3.d.p(string, c2, n2, n3);
    }

    public static final boolean s(x x2, int n2, TimeUnit timeUnit) {
        k.e(x2, "<this>");
        k.e(timeUnit, "timeUnit");
        try {
            boolean bl = n3.d.L(x2, n2, timeUnit);
            return bl;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public static final String t(String string, Object ... objectArray) {
        k.e(string, "format");
        k.e(objectArray, "args");
        v v2 = v.a;
        v2 = Locale.US;
        objectArray = Arrays.copyOf((Object[])objectArray, (int)objectArray.length);
        string = String.format((Locale)v2, (String)string, (Object[])Arrays.copyOf((Object[])objectArray, (int)objectArray.length));
        k.d(string, "format(locale, format, *args)");
        return string;
    }

    public static final boolean u(String[] stringArray, String[] stringArray2, Comparator comparator) {
        k.e(stringArray, "<this>");
        k.e(comparator, "comparator");
        if (stringArray.length != 0 && stringArray2 != null && stringArray2.length != 0) {
            int n2 = stringArray.length;
            int n3 = 0;
            block0: while (n3 < n2) {
                String string = stringArray[n3];
                int n4 = n3 + 1;
                Iterator iterator = V2.b.a(stringArray2);
                do {
                    n3 = n4;
                    if (!iterator.hasNext()) continue block0;
                } while (comparator.compare((Object)string, (Object)((String)iterator.next())) != 0);
                return true;
            }
        }
        return false;
    }

    public static final long v(A object) {
        k.e(object, "<this>");
        object = ((A)object).M().c("Content-Length");
        if (object == null) {
            return -1L;
        }
        return n3.d.U((String)object, -1L);
    }

    public static final List w(Object ... list) {
        k.e(list, "elements");
        list = (Object[])list.clone();
        list = Collections.unmodifiableList((List)o.i(Arrays.copyOf((Object[])list, (int)((Object[])list).length)));
        k.d(list, "unmodifiableList(listOf(*elements.clone()))");
        return list;
    }

    public static final int x(String[] stringArray, String string, Comparator comparator) {
        k.e(stringArray, "<this>");
        k.e(string, "value");
        k.e(comparator, "comparator");
        int n2 = stringArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (comparator.compare((Object)stringArray[i2], (Object)string) != 0) continue;
            return i2;
        }
        return -1;
    }

    public static final int y(String string) {
        k.e(string, "<this>");
        int n2 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string.charAt(i2);
            if (k.f(c2, 31) > 0 && k.f(c2, 127) < 0) {
                continue;
            }
            return i2;
        }
        return -1;
    }

    public static final int z(String string, int n2, int n3) {
        k.e(string, "<this>");
        while (n2 < n3) {
            char c2 = string.charAt(n2);
            if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
                ++n2;
                continue;
            }
            return n2;
        }
        return n3;
    }
}

