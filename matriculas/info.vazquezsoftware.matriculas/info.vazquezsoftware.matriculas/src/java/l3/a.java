/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.UnsupportedOperationException
 */
package l3;

import L2.e;

public interface a {
    public void a(Object var1);

    public Object b(Object var1, e var2);

    public static final abstract class a {
        public static /* synthetic */ void a(a a2, Object object, int n2, Object object2) {
            if (object2 == null) {
                if ((n2 & 1) != 0) {
                    object = null;
                }
                a2.a(object);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
    }
}

