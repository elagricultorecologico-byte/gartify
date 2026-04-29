/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.os.CancellationSignal
 *  java.io.Closeable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package m0;

import android.database.Cursor;
import android.os.CancellationSignal;
import java.io.Closeable;
import java.util.List;
import m0.e;
import m0.f;

public interface b
extends Closeable {
    public Cursor B0(e var1, CancellationSignal var2);

    public f C(String var1);

    public Cursor C0(String var1);

    public Cursor N(e var1);

    public String R();

    public boolean T();

    public void h0();

    public boolean isOpen();

    public void l();

    public void m();

    public void m0(String var1, Object[] var2);

    public List s();

    public void v(String var1);
}

