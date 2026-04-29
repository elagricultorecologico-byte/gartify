/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Writer
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.DateFormat
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Locale
 *  java.util.Map
 *  java.util.TimeZone
 */
package o2;

import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import m2.f;
import m2.g;
import o2.a;
import o2.c;
import o2.e;

public final class d
implements n2.b {
    private static final m2.d e = new a();
    private static final f f = new o2.b();
    private static final f g = new c();
    private static final b h = new b();
    private final Map a = new HashMap();
    private final Map b = new HashMap();
    private m2.d c = e;
    private boolean d = false;

    public d() {
        this.m(String.class, f);
        this.m(Boolean.class, g);
        this.m(Date.class, h);
    }

    public static /* synthetic */ void b(Boolean bl, g g2) {
        g2.c(bl);
    }

    public static /* synthetic */ void c(Object object, m2.e e2) {
        e2 = new StringBuilder();
        e2.append("Couldn't find encoder for type ");
        e2.append(object.getClass().getCanonicalName());
        throw new m2.b(e2.toString());
    }

    public static /* synthetic */ void d(String string, g g2) {
        g2.b(string);
    }

    public m2.a i() {
        return new m2.a(this){
            final d a;
            {
                this.a = d3;
            }

            @Override
            public void a(Object object, Writer object2) {
                object2 = new e((Writer)object2, this.a.a, this.a.b, this.a.c, this.a.d);
                ((e)object2).f(object, false);
                ((e)object2).m();
            }
        };
    }

    public d j(n2.a a2) {
        a2.a(this);
        return this;
    }

    public d k(boolean bl) {
        this.d = bl;
        return this;
    }

    public d l(Class clazz, m2.d d3) {
        this.a.put((Object)clazz, (Object)d3);
        this.b.remove((Object)clazz);
        return this;
    }

    public d m(Class clazz, f f2) {
        this.b.put((Object)clazz, (Object)f2);
        this.a.remove((Object)clazz);
        return this;
    }

    private static final class b
    implements f {
        private static final DateFormat a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone((String)"UTC"));
        }

        private b() {
        }

        public void b(Date date, g g2) {
            g2.b(a.format(date));
        }
    }
}

