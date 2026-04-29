/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package G0;

import G0.o;

final class i
extends o {
    private final o.c a;
    private final o.b b;

    private i(o.c c2, o.b b2) {
        this.a = c2;
        this.b = b2;
    }

    @Override
    public o.b b() {
        return this.b;
    }

    @Override
    public o.c c() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof o) {
            object = (o)object;
            Enum enum_ = this.a;
            if ((enum_ == null ? ((o)object).c() == null : enum_.equals((Object)((o)object).c())) && ((enum_ = this.b) == null ? ((o)object).b() == null : enum_.equals((Object)((o)object).b()))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Enum enum_ = this.a;
        int n2 = 0;
        int n3 = enum_ == null ? 0 : enum_.hashCode();
        enum_ = this.b;
        if (enum_ != null) {
            n2 = enum_.hashCode();
        }
        return (n3 ^ 0xF4243) * 1000003 ^ n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NetworkConnectionInfo{networkType=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", mobileSubtype=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    static final class b
    extends o.a {
        private o.c a;
        private o.b b;

        b() {
        }

        @Override
        public o a() {
            return new i(this.a, this.b);
        }

        @Override
        public o.a b(o.b b2) {
            this.b = b2;
            return this;
        }

        @Override
        public o.a c(o.c c2) {
            this.a = c2;
            return this;
        }
    }
}

