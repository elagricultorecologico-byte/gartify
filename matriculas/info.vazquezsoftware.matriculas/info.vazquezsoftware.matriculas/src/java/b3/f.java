/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 */
package b3;

import V2.g;
import V2.k;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class f
implements Iterator {
    private static final a l = new a(null);
    private final CharSequence g;
    private int h;
    private int i;
    private int j;
    private int k;

    public f(CharSequence charSequence) {
        V2.k.e(charSequence, "string");
        this.g = charSequence;
    }

    public String b() {
        if (this.hasNext()) {
            this.h = 0;
            int n3 = this.j;
            int n4 = this.i;
            this.i = this.k + n3;
            return this.g.subSequence(n4, n3).toString();
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        int n3;
        int n4;
        block5: {
            n4 = this.h;
            if (n4 != 0) {
                return n4 == 1;
            }
            n4 = this.k;
            n3 = 2;
            if (n4 < 0) {
                this.h = 2;
                return false;
            }
            int n5 = this.g.length();
            int n6 = this.g.length();
            for (n4 = this.i; n4 < n6; ++n4) {
                char c3 = this.g.charAt(n4);
                if (c3 != '\n' && c3 != '\r') {
                    continue;
                }
                if (c3 != '\r' || (n5 = n4 + 1) >= this.g.length() || this.g.charAt(n5) != '\n') {
                    n3 = 1;
                }
                break block5;
            }
            n3 = -1;
            n4 = n5;
        }
        this.h = 1;
        this.k = n3;
        this.j = n4;
        return true;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(g g3) {
            this();
        }
    }
}

