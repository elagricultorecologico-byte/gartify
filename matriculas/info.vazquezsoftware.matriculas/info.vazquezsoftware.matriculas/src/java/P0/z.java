/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Map
 */
package P0;

import P0.M;
import android.database.Cursor;
import java.util.Map;

public final class z
implements M.b {
    public final Map a;

    public /* synthetic */ z(Map map) {
        this.a = map;
    }

    @Override
    public final Object apply(Object object) {
        return M.A0(this.a, (Cursor)object);
    }
}

