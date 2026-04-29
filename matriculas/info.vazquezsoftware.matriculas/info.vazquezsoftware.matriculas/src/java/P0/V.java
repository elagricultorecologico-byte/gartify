/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.List
 */
package P0;

import H0.o;
import P0.M;
import android.database.Cursor;
import java.util.List;

public final class v
implements M.b {
    public final M a;
    public final List b;
    public final o c;

    public /* synthetic */ v(M m2, List list, o o2) {
        this.a = m2;
        this.b = list;
        this.c = o2;
    }

    @Override
    public final Object apply(Object object) {
        return M.J0(this.a, this.b, this.c, (Cursor)object);
    }
}

