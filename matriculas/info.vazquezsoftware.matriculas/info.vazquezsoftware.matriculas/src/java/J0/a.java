/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.channels.FileChannel
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.locks.Lock
 *  java.util.concurrent.locks.ReentrantLock
 */
package j0;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a {
    private static final Map e = new HashMap();
    private final File a;
    private final Lock b;
    private final boolean c;
    private FileChannel d;

    public a(String string, File file, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(".lck");
        string = new File(file, stringBuilder.toString());
        this.a = string;
        this.b = j0.a.a(string.getAbsolutePath());
        this.c = bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Lock a(String string) {
        Map map;
        Map map2 = map = e;
        synchronized (map2) {
            Throwable throwable2;
            block4: {
                Lock lock;
                block3: {
                    try {
                        Lock lock2;
                        lock = lock2 = (Lock)map.get((Object)string);
                        if (lock2 != null) break block3;
                        lock = new ReentrantLock();
                        map.put((Object)string, (Object)lock);
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return lock;
            }
            throw throwable2;
        }
    }

    public void b() {
        this.b.lock();
        if (this.c) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.a);
                fileOutputStream = fileOutputStream.getChannel();
                this.d = fileOutputStream;
                fileOutputStream.lock();
                return;
            }
            catch (IOException iOException) {
                throw new IllegalStateException("Unable to grab copy lock.", (Throwable)iOException);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        FileChannel fileChannel = this.d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            }
            catch (IOException iOException) {}
        }
        this.b.unlock();
    }
}

