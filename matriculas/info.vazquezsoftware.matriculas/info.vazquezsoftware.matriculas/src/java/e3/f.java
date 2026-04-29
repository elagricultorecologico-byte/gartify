/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package e3;

import e3.n;
import e3.o;
import h3.E;

public interface f
extends o,
n {
    public static final a a = e3.f$a.a;

    public static final class a {
        static final a a = new a();
        private static final int b = E.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 0x7FFFFFFE);

        private a() {
        }

        public final int a() {
            return b;
        }
    }
}

