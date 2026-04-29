/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package p2;

import p2.d;

public final class a {
    private int a;
    private d.a b = d.a.g;

    public static a b() {
        return new a();
    }

    public d a() {
        return new a(this.a, this.b);
    }

    public a c(int n2) {
        this.a = n2;
        return this;
    }

    private static final class a
    implements d {
        private final int a;
        private final d.a b;

        a(int n2, d.a a2) {
            this.a = n2;
            this.b = a2;
        }

        public Class annotationType() {
            return d.class;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof d)) {
                return false;
            }
            return this.a == (object = (d)object).tag() && this.b.equals((Object)object.intEncoding());
        }

        public int hashCode() {
            return (0xDE0D66 ^ this.a) + (this.b.hashCode() ^ 0x79AD669E);
        }

        @Override
        public d.a intEncoding() {
            return this.b;
        }

        @Override
        public int tag() {
            return this.a;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("@com.google.firebase.encoders.proto.Protobuf");
            stringBuilder.append('(');
            stringBuilder.append("tag=");
            stringBuilder.append(this.a);
            stringBuilder.append("intEncoding=");
            stringBuilder.append((Object)this.b);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
}

