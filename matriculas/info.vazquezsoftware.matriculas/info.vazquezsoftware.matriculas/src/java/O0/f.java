/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo$Builder
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Map
 *  java.util.Set
 */
package O0;

import F0.d;
import O0.c;
import android.app.job.JobInfo;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class f {
    private long a(int n2, long l2) {
        long l3 = l2 > 1L ? l2 : 2L;
        double d2 = Math.max((double)1.0, (double)(Math.log((double)10000.0) / Math.log((double)(l3 * (long)(--n2)))));
        return (long)(Math.pow((double)3.0, (double)n2) * (double)l2 * d2);
    }

    public static a b() {
        return new a();
    }

    static f d(R0.a a2, Map map) {
        return new O0.b(a2, map);
    }

    public static f f(R0.a a2) {
        return f.b().a(d.g, b.a().b(30000L).d(86400000L).a()).a(d.i, b.a().b(1000L).d(86400000L).a()).a(d.h, b.a().b(86400000L).d(86400000L).c(f.i((Object[])new c[]{c.h})).a()).c(a2).b();
    }

    private static Set i(Object ... objectArray) {
        return Collections.unmodifiableSet((Set)new HashSet((Collection)Arrays.asList((Object[])objectArray)));
    }

    private void j(JobInfo.Builder builder, Set set) {
        if (set.contains((Object)c.g)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains((Object)c.i)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains((Object)c.h)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public JobInfo.Builder c(JobInfo.Builder builder, d d2, long l2, int n2) {
        builder.setMinimumLatency(this.g(d2, l2, n2));
        this.j(builder, ((b)this.h().get((Object)d2)).c());
        return builder;
    }

    abstract R0.a e();

    public long g(d object, long l2, int n2) {
        long l3 = this.e().a();
        object = (b)this.h().get(object);
        return Math.min((long)Math.max((long)this.a(n2, ((b)object).b()), (long)(l2 - l3)), (long)((b)object).d());
    }

    abstract Map h();

    public static class a {
        private R0.a a;
        private Map b = new HashMap();

        public a a(d d2, b b2) {
            this.b.put((Object)d2, (Object)b2);
            return this;
        }

        public f b() {
            if (this.a != null) {
                if (this.b.keySet().size() >= d.values().length) {
                    Map map = this.b;
                    this.b = new HashMap();
                    return f.d(this.a, map);
                }
                throw new IllegalStateException("Not all priorities have been configured");
            }
            throw new NullPointerException("missing required property: clock");
        }

        public a c(R0.a a2) {
            this.a = a2;
            return this;
        }
    }

    public static abstract class b {
        public static a a() {
            return new c.b().c(Collections.EMPTY_SET);
        }

        abstract long b();

        abstract Set c();

        abstract long d();

        public static abstract class a {
            public abstract b a();

            public abstract a b(long var1);

            public abstract a c(Set var1);

            public abstract a d(long var1);
        }
    }

    public static final class c
    extends Enum {
        public static final /* enum */ c g;
        public static final /* enum */ c h;
        public static final /* enum */ c i;
        private static final c[] j;

        static {
            c c2;
            c c3;
            c c4;
            g = c4 = new c("NETWORK_UNMETERED", 0);
            h = c3 = new c("DEVICE_IDLE", 1);
            i = c2 = new c("DEVICE_CHARGING", 2);
            j = new c[]{c4, c3, c2};
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private c() {
            void var2_-1;
            void var1_-1;
        }

        public static c valueOf(String string) {
            return (c)Enum.valueOf(c.class, (String)string);
        }

        public static c[] values() {
            return (c[])j.clone();
        }
    }
}

