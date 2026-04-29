/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package G0;

import G0.k;
import G0.m;
import G0.p;
import java.util.List;

final class g
extends m {
    private final long a;
    private final long b;
    private final k c;
    private final Integer d;
    private final String e;
    private final List f;
    private final p g;

    private g(long l2, long l3, k k2, Integer n2, String string, List list, p p2) {
        this.a = l2;
        this.b = l3;
        this.c = k2;
        this.d = n2;
        this.e = string;
        this.f = list;
        this.g = p2;
    }

    @Override
    public k b() {
        return this.c;
    }

    @Override
    public List c() {
        return this.f;
    }

    @Override
    public Integer d() {
        return this.d;
    }

    @Override
    public String e() {
        return this.e;
    }

    public boolean equals(Object object) {
        Object object2;
        if (object == this) {
            return true;
        }
        return object instanceof m && this.a == ((m)(object = (m)object)).g() && this.b == ((m)object).h() && ((object2 = this.c) == null ? ((m)object).b() == null : object2.equals((Object)((m)object).b())) && ((object2 = this.d) == null ? ((m)object).d() == null : object2.equals((Object)((m)object).d())) && ((object2 = this.e) == null ? ((m)object).e() == null : object2.equals((Object)((m)object).e())) && ((object2 = this.f) == null ? ((m)object).c() == null : object2.equals((Object)((m)object).c())) && ((object2 = this.g) == null ? ((m)object).f() == null : object2.equals((Object)((m)object).f()));
    }

    @Override
    public p f() {
        return this.g;
    }

    @Override
    public long g() {
        return this.a;
    }

    @Override
    public long h() {
        return this.b;
    }

    public int hashCode() {
        long l2 = this.a;
        int n2 = (int)(l2 ^ l2 >>> 32);
        l2 = this.b;
        int n3 = (int)(l2 ^ l2 >>> 32);
        Object object = this.c;
        int n4 = 0;
        int n5 = object == null ? 0 : object.hashCode();
        object = this.d;
        int n6 = object == null ? 0 : object.hashCode();
        object = this.e;
        int n7 = object == null ? 0 : object.hashCode();
        object = this.f;
        int n8 = object == null ? 0 : object.hashCode();
        object = this.g;
        if (object != null) {
            n4 = object.hashCode();
        }
        return ((((((n2 ^ 0xF4243) * 1000003 ^ n3) * 1000003 ^ n5) * 1000003 ^ n6) * 1000003 ^ n7) * 1000003 ^ n8) * 1000003 ^ n4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LogRequest{requestTimeMs=");
        stringBuilder.append(this.a);
        stringBuilder.append(", requestUptimeMs=");
        stringBuilder.append(this.b);
        stringBuilder.append(", clientInfo=");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(", logSource=");
        stringBuilder.append((Object)this.d);
        stringBuilder.append(", logSourceName=");
        stringBuilder.append(this.e);
        stringBuilder.append(", logEvents=");
        stringBuilder.append((Object)this.f);
        stringBuilder.append(", qosTier=");
        stringBuilder.append((Object)this.g);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    static final class b
    extends m.a {
        private Long a;
        private Long b;
        private k c;
        private Integer d;
        private String e;
        private List f;
        private p g;

        b() {
        }

        @Override
        public m a() {
            Object object = this.a;
            String string = "";
            if (object == null) {
                string = new StringBuilder();
                string.append("");
                string.append(" requestTimeMs");
                string = string.toString();
            }
            object = string;
            if (this.b == null) {
                object = new StringBuilder();
                object.append(string);
                object.append(" requestUptimeMs");
                object = object.toString();
            }
            if (object.isEmpty()) {
                return new g(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
            }
            string = new StringBuilder();
            string.append("Missing required properties:");
            string.append((String)object);
            throw new IllegalStateException(string.toString());
        }

        @Override
        public m.a b(k k2) {
            this.c = k2;
            return this;
        }

        @Override
        public m.a c(List list) {
            this.f = list;
            return this;
        }

        @Override
        m.a d(Integer n2) {
            this.d = n2;
            return this;
        }

        @Override
        m.a e(String string) {
            this.e = string;
            return this;
        }

        @Override
        public m.a f(p p2) {
            this.g = p2;
            return this;
        }

        @Override
        public m.a g(long l2) {
            this.a = l2;
            return this;
        }

        @Override
        public m.a h(long l2) {
            this.b = l2;
            return this;
        }
    }
}

