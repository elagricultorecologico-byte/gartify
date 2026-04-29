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
 *  java.util.Arrays
 */
package G0;

import G0.l;
import G0.o;
import java.util.Arrays;

final class f
extends l {
    private final long a;
    private final Integer b;
    private final long c;
    private final byte[] d;
    private final String e;
    private final long f;
    private final o g;

    private f(long l2, Integer n2, long l3, byte[] byArray, String string, long l4, o o2) {
        this.a = l2;
        this.b = n2;
        this.c = l3;
        this.d = byArray;
        this.e = string;
        this.f = l4;
        this.g = o2;
    }

    @Override
    public Integer b() {
        return this.b;
    }

    @Override
    public long c() {
        return this.a;
    }

    @Override
    public long d() {
        return this.c;
    }

    @Override
    public o e() {
        return this.g;
    }

    public boolean equals(Object object) {
        byte[] byArray;
        l l2;
        if (object == this) {
            return true;
        }
        return object instanceof l && this.a == (l2 = (l)object).c() && ((object = this.b) == null ? l2.b() == null : object.equals((Object)l2.b())) && this.c == l2.d() && Arrays.equals((byte[])(byArray = this.d), (byte[])(object = l2 instanceof f ? (Object)((f)l2).d : (Object)l2.f())) && ((object = this.e) == null ? l2.g() == null : object.equals((Object)l2.g())) && this.f == l2.h() && ((object = this.g) == null ? l2.e() == null : object.equals((Object)l2.e()));
    }

    @Override
    public byte[] f() {
        return this.d;
    }

    @Override
    public String g() {
        return this.e;
    }

    @Override
    public long h() {
        return this.f;
    }

    public int hashCode() {
        long l2 = this.a;
        int n2 = (int)(l2 ^ l2 >>> 32);
        Object object = this.b;
        int n3 = 0;
        int n4 = object == null ? 0 : object.hashCode();
        l2 = this.c;
        int n5 = (int)(l2 ^ l2 >>> 32);
        int n6 = Arrays.hashCode((byte[])this.d);
        object = this.e;
        int n7 = object == null ? 0 : object.hashCode();
        l2 = this.f;
        int n8 = (int)(l2 >>> 32 ^ l2);
        object = this.g;
        if (object != null) {
            n3 = object.hashCode();
        }
        return ((((((n2 ^ 0xF4243) * 1000003 ^ n4) * 1000003 ^ n5) * 1000003 ^ n6) * 1000003 ^ n7) * 1000003 ^ n8) * 1000003 ^ n3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LogEvent{eventTimeMs=");
        stringBuilder.append(this.a);
        stringBuilder.append(", eventCode=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", eventUptimeMs=");
        stringBuilder.append(this.c);
        stringBuilder.append(", sourceExtension=");
        stringBuilder.append(Arrays.toString((byte[])this.d));
        stringBuilder.append(", sourceExtensionJsonProto3=");
        stringBuilder.append(this.e);
        stringBuilder.append(", timezoneOffsetSeconds=");
        stringBuilder.append(this.f);
        stringBuilder.append(", networkConnectionInfo=");
        stringBuilder.append((Object)this.g);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    static final class b
    extends l.a {
        private Long a;
        private Integer b;
        private Long c;
        private byte[] d;
        private String e;
        private Long f;
        private o g;

        b() {
        }

        @Override
        public l a() {
            Object object = this.a;
            String string = "";
            if (object == null) {
                object = new StringBuilder();
                object.append("");
                object.append(" eventTimeMs");
                string = object.toString();
            }
            object = string;
            if (this.c == null) {
                object = new StringBuilder();
                object.append(string);
                object.append(" eventUptimeMs");
                object = object.toString();
            }
            string = object;
            if (this.f == null) {
                string = new StringBuilder();
                string.append((String)object);
                string.append(" timezoneOffsetSeconds");
                string = string.toString();
            }
            if (string.isEmpty()) {
                return new f(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
            }
            object = new StringBuilder();
            object.append("Missing required properties:");
            object.append(string);
            throw new IllegalStateException(object.toString());
        }

        @Override
        public l.a b(Integer n2) {
            this.b = n2;
            return this;
        }

        @Override
        public l.a c(long l2) {
            this.a = l2;
            return this;
        }

        @Override
        public l.a d(long l2) {
            this.c = l2;
            return this;
        }

        @Override
        public l.a e(o o2) {
            this.g = o2;
            return this;
        }

        @Override
        l.a f(byte[] byArray) {
            this.d = byArray;
            return this;
        }

        @Override
        l.a g(String string) {
            this.e = string;
            return this;
        }

        @Override
        public l.a h(long l2) {
            this.f = l2;
            return this;
        }
    }
}

