/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package H0;

import H0.o;
import java.util.Arrays;

final class d
extends o {
    private final String a;
    private final byte[] b;
    private final F0.d c;

    private d(String string, byte[] byArray, F0.d d2) {
        this.a = string;
        this.b = byArray;
        this.c = d2;
    }

    @Override
    public String b() {
        return this.a;
    }

    @Override
    public byte[] c() {
        return this.b;
    }

    @Override
    public F0.d d() {
        return this.c;
    }

    public boolean equals(Object object) {
        byte[] byArray;
        o o2;
        if (object == this) {
            return true;
        }
        return object instanceof o && this.a.equals((Object)(o2 = (o)object).b()) && Arrays.equals((byte[])(byArray = this.b), (byte[])(object = o2 instanceof d ? (Object)((d)o2).b : (Object)o2.c())) && this.c.equals((Object)o2.d());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode((byte[])this.b)) * 1000003 ^ this.c.hashCode();
    }

    static final class b
    extends o.a {
        private String a;
        private byte[] b;
        private F0.d c;

        b() {
        }

        @Override
        public o a() {
            String string = this.a;
            String string2 = "";
            if (string == null) {
                string2 = new StringBuilder();
                string2.append("");
                string2.append(" backendName");
                string2 = string2.toString();
            }
            string = string2;
            if (this.c == null) {
                string = new StringBuilder();
                string.append(string2);
                string.append(" priority");
                string = string.toString();
            }
            if (string.isEmpty()) {
                return new d(this.a, this.b, this.c);
            }
            string2 = new StringBuilder();
            string2.append("Missing required properties:");
            string2.append(string);
            throw new IllegalStateException(string2.toString());
        }

        @Override
        public o.a b(String string) {
            if (string != null) {
                this.a = string;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        @Override
        public o.a c(byte[] byArray) {
            this.b = byArray;
            return this;
        }

        @Override
        public o.a d(F0.d d2) {
            if (d2 != null) {
                this.c = d2;
                return this;
            }
            throw new NullPointerException("Null priority");
        }
    }
}

