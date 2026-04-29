/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package G0;

import G0.j;
import java.util.List;

final class d
extends j {
    private final List a;

    d(List list) {
        if (list != null) {
            this.a = list;
            return;
        }
        throw new NullPointerException("Null logRequests");
    }

    @Override
    public List c() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof j) {
            object = (j)object;
            return this.a.equals((Object)((j)object).c());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 0xF4243;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BatchedLogRequest{logRequests=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

