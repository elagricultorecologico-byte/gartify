/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.nio.channels.Channels
 *  java.nio.channels.FileChannel
 *  java.nio.channels.ReadableByteChannel
 *  java.nio.channels.WritableByteChannel
 */
package j0;

import android.os.Build;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract class d {
    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(ReadableByteChannel readableByteChannel, FileChannel fileChannel) {
        void var3_4;
        block6: {
            block7: {
                int n2;
                block5: {
                    try {
                        n2 = Build.VERSION.SDK_INT;
                        if (n2 <= 23) break block5;
                    }
                    catch (Throwable throwable) {
                        break block6;
                    }
                    try {
                        fileChannel.transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
                        break block7;
                    }
                    catch (Throwable throwable) {
                        break block6;
                    }
                }
                InputStream inputStream = Channels.newInputStream((ReadableByteChannel)readableByteChannel);
                OutputStream outputStream = Channels.newOutputStream((WritableByteChannel)fileChannel);
                byte[] byArray = new byte[4096];
                while ((n2 = inputStream.read(byArray)) > 0) {
                    outputStream.write(byArray, 0, n2);
                }
            }
            fileChannel.force(false);
            readableByteChannel.close();
            fileChannel.close();
            return;
        }
        readableByteChannel.close();
        fileChannel.close();
        throw var3_4;
    }
}

