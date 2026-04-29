/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonReader
 *  android.util.JsonToken
 *  java.io.IOException
 *  java.io.Reader
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package G0;

import G0.h;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.io.Reader;

public abstract class n {
    static n a(long l2) {
        return new h(l2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static n b(Reader var0) {
        block7: {
            block6: {
                var0 = new JsonReader(var0);
                try {
                    var0.beginObject();
lbl4:
                    // 2 sources

                    while (var0.hasNext()) {
                        if (!var0.nextName().equals((Object)"nextRequestWaitMillis")) ** GOTO lbl-1000
                        if (var0.peek() == JsonToken.STRING) {
                            var1_1 = n.a(Long.parseLong((String)var0.nextString()));
                            break block6;
                        }
                        ** GOTO lbl-1000
                    }
                    ** GOTO lbl21
                }
                catch (Throwable var1_2) {
                    break block7;
                }
            }
            var0.close();
            return var1_1;
lbl-1000:
            // 1 sources

            {
                var1_3 = n.a(var0.nextLong());
            }
            var0.close();
            return var1_3;
lbl-1000:
            // 1 sources

            {
                var0.skipValue();
                ** GOTO lbl4
lbl21:
                // 1 sources

                var1_4 = new IOException("Response is missing nextRequestWaitMillis field.");
                throw var1_4;
            }
        }
        var0.close();
        throw var1_2;
    }

    public abstract long c();
}

