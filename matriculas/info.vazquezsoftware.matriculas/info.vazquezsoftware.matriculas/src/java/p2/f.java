/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.OutputStream
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Float
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.charset.Charset
 *  java.util.Collection
 *  java.util.Map
 *  java.util.Map$Entry
 */
package p2;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
import p2.b;
import p2.c;
import p2.d;
import p2.e;
import p2.i;

final class f
implements m2.e {
    private static final Charset f = Charset.forName((String)"UTF-8");
    private static final m2.c g = m2.c.a("key").b(p2.a.b().c(1).a()).a();
    private static final m2.c h = m2.c.a("value").b(p2.a.b().c(2).a()).a();
    private static final m2.d i = new e();
    private OutputStream a;
    private final Map b;
    private final Map c;
    private final m2.d d;
    private final i e = new i(this);

    f(OutputStream outputStream, Map map, Map map2, m2.d d3) {
        this.a = outputStream;
        this.b = map;
        this.c = map2;
        this.d = d3;
    }

    public static /* synthetic */ void b(Map.Entry entry, m2.e e2) {
        e2.a(g, entry.getKey());
        e2.a(h, entry.getValue());
    }

    private static ByteBuffer l(int n2) {
        return ByteBuffer.allocate((int)n2).order(ByteOrder.LITTLE_ENDIAN);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private long m(m2.d d3, Object object) {
        Throwable throwable222222;
        b b2 = new b();
        OutputStream outputStream = this.a;
        this.a = b2;
        {
            catch (Throwable throwable222222) {}
        }
        d3.a(object, this);
        this.a = outputStream;
        long l2 = b2.a();
        b2.close();
        return l2;
        catch (Throwable throwable3) {
            this.a = outputStream;
            throw throwable3;
        }
        try {
            b2.close();
            throw throwable222222;
        }
        catch (Throwable throwable4) {
            throwable222222.addSuppressed(throwable4);
        }
        throw throwable222222;
    }

    private f n(m2.d d3, m2.c c3, Object object, boolean bl) {
        long l2 = this.m(d3, object);
        if (bl && l2 == 0L) {
            return this;
        }
        this.s(p2.f.r(c3) << 3 | 2);
        this.t(l2);
        d3.a(object, this);
        return this;
    }

    private f o(m2.f f2, m2.c c3, Object object, boolean bl) {
        this.e.d(c3, bl);
        f2.a(object, this.e);
        return this;
    }

    private static d q(m2.c object) {
        if ((object = (d)((m2.c)object).c(d.class)) != null) {
            return object;
        }
        throw new m2.b("Field has no @Protobuf config");
    }

    private static int r(m2.c object) {
        if ((object = (d)((m2.c)object).c(d.class)) != null) {
            return object.tag();
        }
        throw new m2.b("Field has no @Protobuf config");
    }

    private void s(int n2) {
        while ((long)(n2 & 0xFFFFFF80) != 0L) {
            this.a.write(n2 & 0x7F | 0x80);
            n2 >>>= 7;
        }
        this.a.write(n2 & 0x7F);
    }

    private void t(long l2) {
        while ((0xFFFFFFFFFFFFFF80L & l2) != 0L) {
            this.a.write((int)l2 & 0x7F | 0x80);
            l2 >>>= 7;
        }
        this.a.write((int)l2 & 0x7F);
    }

    @Override
    public m2.e a(m2.c c3, Object object) {
        return this.f(c3, object, true);
    }

    m2.e c(m2.c c3, double d3, boolean bl) {
        if (bl && d3 == 0.0) {
            return this;
        }
        this.s(p2.f.r(c3) << 3 | 1);
        this.a.write(p2.f.l(8).putDouble(d3).array());
        return this;
    }

    m2.e e(m2.c c3, float f2, boolean bl) {
        if (bl && f2 == 0.0f) {
            return this;
        }
        this.s(p2.f.r(c3) << 3 | 5);
        this.a.write(p2.f.l(4).putFloat(f2).array());
        return this;
    }

    m2.e f(m2.c object, Object object22, boolean bl) {
        block19: {
            block20: {
                block15: {
                    block18: {
                        block17: {
                            block16: {
                                if (object22 == null) break block15;
                                if (!(object22 instanceof CharSequence)) break block16;
                                object22 = (CharSequence)object22;
                                if (!bl || object22.length() != 0) {
                                    this.s(p2.f.r((m2.c)object) << 3 | 2);
                                    object = object22.toString().getBytes(f);
                                    this.s(((Object)object).length);
                                    this.a.write((byte[])object);
                                    return this;
                                }
                                break block15;
                            }
                            if (!(object22 instanceof Collection)) break block17;
                            object22 = ((Collection)object22).iterator();
                            while (object22.hasNext()) {
                                this.f((m2.c)object, object22.next(), false);
                            }
                            break block15;
                        }
                        if (!(object22 instanceof Map)) break block18;
                        for (Object object22 : ((Map)object22).entrySet()) {
                            this.n(i, (m2.c)object, object22, false);
                        }
                        break block15;
                    }
                    if (object22 instanceof Double) {
                        return this.c((m2.c)object, (Double)object22, bl);
                    }
                    if (object22 instanceof Float) {
                        return this.e((m2.c)object, ((Float)object22).floatValue(), bl);
                    }
                    if (object22 instanceof Number) {
                        return this.j((m2.c)object, ((Number)object22).longValue(), bl);
                    }
                    if (object22 instanceof Boolean) {
                        return this.k((m2.c)object, (Boolean)object22, bl);
                    }
                    if (!(object22 instanceof byte[])) break block19;
                    object22 = (byte[])object22;
                    if (!bl || ((Object)object22).length != 0) break block20;
                }
                return this;
            }
            this.s(p2.f.r((m2.c)object) << 3 | 2);
            this.s(((Object)object22).length);
            this.a.write((byte[])object22);
            return this;
        }
        Object object3 = (m2.d)this.b.get((Object)object22.getClass());
        if (object3 != null) {
            return this.n((m2.d)object3, (m2.c)object, object22, bl);
        }
        object3 = (m2.f)this.c.get((Object)object22.getClass());
        if (object3 != null) {
            return this.o((m2.f)object3, (m2.c)object, object22, bl);
        }
        if (object22 instanceof c) {
            return this.g((m2.c)object, ((c)object22).d());
        }
        if (object22 instanceof Enum) {
            return this.g((m2.c)object, ((Enum)object22).ordinal());
        }
        return this.n(this.d, (m2.c)object, object22, bl);
    }

    public f g(m2.c c3, int n2) {
        return this.h(c3, n2, true);
    }

    f h(m2.c object, int n2, boolean bl) {
        block3: {
            block4: {
                block5: {
                    block2: {
                        if (bl && n2 == 0) break block2;
                        int n3 = p2.f$a.a[(object = p2.f.q((m2.c)object)).intEncoding().ordinal()];
                        if (n3 == 1) break block3;
                        if (n3 == 2) break block4;
                        if (n3 == 3) break block5;
                    }
                    return this;
                }
                this.s(object.tag() << 3 | 5);
                this.a.write(p2.f.l(4).putInt(n2).array());
                return this;
            }
            this.s(object.tag() << 3);
            this.s(n2 << 1 ^ n2 >> 31);
            return this;
        }
        this.s(object.tag() << 3);
        this.s(n2);
        return this;
    }

    public f i(m2.c c3, long l2) {
        return this.j(c3, l2, true);
    }

    f j(m2.c object, long l2, boolean bl) {
        block3: {
            block4: {
                block5: {
                    block2: {
                        if (bl && l2 == 0L) break block2;
                        int n2 = p2.f$a.a[(object = p2.f.q((m2.c)object)).intEncoding().ordinal()];
                        if (n2 == 1) break block3;
                        if (n2 == 2) break block4;
                        if (n2 == 3) break block5;
                    }
                    return this;
                }
                this.s(object.tag() << 3 | 1);
                this.a.write(p2.f.l(8).putLong(l2).array());
                return this;
            }
            this.s(object.tag() << 3);
            this.t(l2 >> 63 ^ l2 << 1);
            return this;
        }
        this.s(object.tag() << 3);
        this.t(l2);
        return this;
    }

    f k(m2.c c3, boolean bl, boolean bl2) {
        return this.h(c3, bl ? 1 : 0, bl2);
    }

    f p(Object object) {
        if (object == null) {
            return this;
        }
        m2.d d3 = (m2.d)this.b.get((Object)object.getClass());
        if (d3 != null) {
            d3.a(object, this);
            return this;
        }
        d3 = new StringBuilder();
        d3.append("No encoder for ");
        d3.append(object.getClass());
        throw new m2.b(d3.toString());
    }
}

