/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.OverwritingInputMerger
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 */
package t0;

import androidx.work.OverwritingInputMerger;
import t0.u;

public final class l
extends u {
    l(a a2) {
        super(a2.b, a2.c, a2.d);
    }

    public static l d(Class clazz) {
        return (l)new a(clazz).b();
    }

    public static final class a
    extends u.a {
        public a(Class clazz) {
            super(clazz);
            this.c.d = OverwritingInputMerger.class.getName();
        }

        l g() {
            if (this.a && this.c.j.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new l(this);
        }

        a h() {
            return this;
        }
    }
}

