/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.AbstractWindowedCursor
 *  android.database.Cursor
 *  android.os.CancellationSignal
 *  androidx.room.h
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 */
package j0;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.h;
import j0.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import m0.e;

public abstract class c {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(m0.b b2) {
        Throwable throwable2222;
        Object object;
        block6: {
            int n2;
            ArrayList arrayList = new ArrayList();
            object = b2.C0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
            try {
                while (true) {
                    boolean bl = object.moveToNext();
                    n2 = 0;
                    if (bl) {
                        arrayList.add((Object)object.getString(0));
                        continue;
                    }
                    break;
                }
            }
            catch (Throwable throwable2222) {
                break block6;
            }
            object.close();
            int n3 = arrayList.size();
            while (true) {
                if (n2 >= n3) {
                    return;
                }
                object = arrayList.get(n2);
                int n4 = n2 + 1;
                String string = (String)object;
                n2 = n4;
                if (!string.startsWith("room_fts_content_sync_")) continue;
                object = new StringBuilder();
                object.append("DROP TRIGGER IF EXISTS ");
                object.append(string);
                b2.v(object.toString());
                n2 = n4;
            }
        }
        object.close();
        throw throwable2222;
    }

    public static Cursor b(h object, e e2, boolean bl, CancellationSignal cancellationSignal) {
        e2 = object.q(e2, cancellationSignal);
        object = e2;
        if (bl) {
            object = e2;
            if (e2 instanceof AbstractWindowedCursor) {
                cancellationSignal = (AbstractWindowedCursor)e2;
                int n2 = cancellationSignal.getCount();
                int n3 = cancellationSignal.hasWindow() ? cancellationSignal.getWindow().getNumRows() : n2;
                object = e2;
                if (n3 < n2) {
                    object = b.a((Cursor)cancellationSignal);
                }
            }
        }
        return object;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int c(File object) {
        void var0_3;
        FileInputStream fileInputStream;
        block7: {
            FileInputStream fileInputStream2;
            block6: {
                fileInputStream = null;
                ByteBuffer byteBuffer = ByteBuffer.allocate((int)4);
                fileInputStream2 = new FileInputStream(object);
                fileInputStream2 = fileInputStream2.getChannel();
                fileInputStream2.tryLock(60L, 4L, true);
                fileInputStream2.position(60L);
                if (fileInputStream2.read(byteBuffer) != 4) break block6;
                byteBuffer.rewind();
                int n2 = byteBuffer.getInt();
                fileInputStream2.close();
                return n2;
            }
            try {
                object = new IOException("Bad database header, unable to read 4 bytes at offset 60");
                throw object;
            }
            catch (Throwable throwable) {
                fileInputStream = fileInputStream2;
            }
            break block7;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        throw var0_3;
    }
}

