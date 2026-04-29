/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  t0.a
 *  t0.c
 *  t0.k
 *  t0.n
 *  t0.s
 */
package B0;

import android.net.Uri;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import t0.c;
import t0.k;
import t0.n;
import t0.s;

public abstract class v {
    public static int a(t0.a a2) {
        int n2 = a.b[a2.ordinal()];
        if (n2 != 1) {
            if (n2 == 2) {
                return 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not convert ");
            stringBuilder.append((Object)a2);
            stringBuilder.append(" to int");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return 0;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c b(byte[] object) {
        Object object2;
        ByteArrayInputStream byteArrayInputStream;
        block21: {
            c c2;
            block23: {
                block22: {
                    c2 = new c();
                    if (object == null) {
                        return c2;
                    }
                    byteArrayInputStream = new ByteArrayInputStream(object);
                    object2 = new ObjectInputStream((InputStream)byteArrayInputStream);
                    object = object2;
                    for (int i2 = object2.readInt(); i2 > 0; --i2) {
                        object = object2;
                        c2.a(Uri.parse((String)object2.readUTF()), object2.readBoolean());
                    }
                    try {
                        object2.close();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                    try {
                        byteArrayInputStream.close();
                        return c2;
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                        return c2;
                    }
                    catch (Throwable throwable) {
                        object2 = null;
                        break block21;
                    }
                    catch (IOException iOException) {
                        object2 = null;
                        break block22;
                    }
                    catch (Throwable throwable) {
                        object2 = object;
                        object = throwable;
                        break block21;
                    }
                    catch (IOException iOException) {}
                }
                object = object2;
                {
                    void var3_14;
                    var3_14.printStackTrace();
                    if (object2 == null) break block23;
                }
                try {
                    object2.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            byteArrayInputStream.close();
            return c2;
        }
        if (object2 != null) {
            try {
                object2.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        try {
            byteArrayInputStream.close();
            throw object;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        throw object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static byte[] c(c var0) {
        block21: {
            block22: {
                var1_7 = var0.c();
                var4_8 = null;
                var5_9 = null;
                if (var1_7 == 0) {
                    return null;
                }
                var6_10 = new ByteArrayOutputStream();
                var2_11 = var5_9;
                try {
                    var2_11 = var5_9;
                    var3_15 /* !! */  = new ObjectOutputStream((OutputStream)var6_10);
                }
                catch (Throwable var0_4) {
                    break block21;
                }
                catch (IOException var3_16) {
                    var0 = var4_8;
                    break block22;
                }
                try {
                    var3_15 /* !! */ .writeInt(var0.c());
                    for (c var0 : var0.b()) {
                        var3_15 /* !! */ .writeUTF(var0.a().toString());
                        var3_15 /* !! */ .writeBoolean(var0.b());
                    }
                }
                catch (Throwable var0_1) {
                    var2_11 = var3_15 /* !! */ ;
                    break block21;
                }
                catch (IOException var2_12) {
                    var0 = var3_15 /* !! */ ;
                    var3_15 /* !! */  = var2_12;
                    break block22;
                }
                try {
                    var3_15 /* !! */ .close();
                }
                catch (IOException var0_2) {
                    var0_2.printStackTrace();
                }
                try {
                    var6_10.close();
                    return var6_10.toByteArray();
                }
                catch (IOException var0_3) {
                    var0_3.printStackTrace();
                    return var6_10.toByteArray();
                }
            }
            var2_11 = var0;
            {
                var3_15 /* !! */ .printStackTrace();
                if (var0 == null) ** GOTO lbl-1000
            }
            try {
                var0.close();
            }
            catch (IOException var0_5) {
                var0_5.printStackTrace();
            }
lbl-1000:
            // 3 sources

            {
                var6_10.close();
            }
            return var6_10.toByteArray();
        }
        if (var2_11 != null) {
            try {
                var2_11.close();
            }
            catch (IOException var2_13) {
                var2_13.printStackTrace();
            }
        }
        try {
            var6_10.close();
            throw var0_6;
        }
        catch (IOException var2_14) {
            var2_14.printStackTrace();
        }
        throw var0_6;
    }

    public static t0.a d(int n2) {
        if (n2 != 0) {
            if (n2 == 1) {
                return t0.a.h;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not convert ");
            stringBuilder.append(n2);
            stringBuilder.append(" to BackoffPolicy");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return t0.a.g;
    }

    public static k e(int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            if (Build.VERSION.SDK_INT >= 30 && n2 == 5) {
                                return k.l;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Could not convert ");
                            stringBuilder.append(n2);
                            stringBuilder.append(" to NetworkType");
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        return k.k;
                    }
                    return k.j;
                }
                return k.i;
            }
            return k.h;
        }
        return k.g;
    }

    public static n f(int n2) {
        if (n2 != 0) {
            if (n2 == 1) {
                return n.h;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not convert ");
            stringBuilder.append(n2);
            stringBuilder.append(" to OutOfQuotaPolicy");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return n.g;
    }

    public static s g(int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            if (n2 == 5) {
                                return s.l;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Could not convert ");
                            stringBuilder.append(n2);
                            stringBuilder.append(" to State");
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        return s.k;
                    }
                    return s.j;
                }
                return s.i;
            }
            return s.h;
        }
        return s.g;
    }

    public static int h(k k2) {
        int n2 = a.c[k2.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        if (n2 != 5) {
                            if (Build.VERSION.SDK_INT >= 30 && k2 == k.l) {
                                return 5;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Could not convert ");
                            stringBuilder.append((Object)k2);
                            stringBuilder.append(" to int");
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        return 4;
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static int i(n n2) {
        int n3 = a.d[n2.ordinal()];
        if (n3 != 1) {
            if (n3 == 2) {
                return 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not convert ");
            stringBuilder.append((Object)n2);
            stringBuilder.append(" to int");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return 0;
    }

    public static int j(s s2) {
        switch (a.a[s2.ordinal()]) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not convert ");
                stringBuilder.append((Object)s2);
                stringBuilder.append(" to int");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            case 6: {
                return 5;
            }
            case 5: {
                return 4;
            }
            case 4: {
                return 3;
            }
            case 3: {
                return 2;
            }
            case 2: {
                return 1;
            }
            case 1: 
        }
        return 0;
    }
}

