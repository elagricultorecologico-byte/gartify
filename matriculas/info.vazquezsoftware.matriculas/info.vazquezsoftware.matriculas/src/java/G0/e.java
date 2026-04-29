/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package G0;

import G0.a;
import G0.k;

final class e
extends k {
    private final k.b a;
    private final a b;

    private e(k.b b2, a a2) {
        this.a = b2;
        this.b = a2;
    }

    @Override
    public a b() {
        return this.b;
    }

    @Override
    public k.b c() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof k) {
            object = (k)object;
            Object object2 = this.a;
            if ((object2 == null ? ((k)object).c() == null : object2.equals((Object)((k)object).c())) && ((object2 = this.b) == null ? ((k)object).b() == null : object2.equals(((k)object).b()))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Object object = this.a;
        int n2 = 0;
        int n3 = object == null ? 0 : object.hashCode();
        object = this.b;
        if (object != null) {
            n2 = object.hashCode();
        }
        return (n3 ^ 0xF4243) * 1000003 ^ n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClientInfo{clientType=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", androidClientInfo=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    static final class b
    extends k.a {
        private k.b a;
        private a b;

        b() {
        }

        @Override
        public k a() {
            return new e(this.a, this.b);
        }

        @Override
        public k.a b(a a2) {
            this.b = a2;
            return this;
        }

        @Override
        public k.a c(k.b b2) {
            this.a = b2;
            return this;
        }
    }
}

