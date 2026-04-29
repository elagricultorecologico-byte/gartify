/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package t0;

import android.util.Log;

public abstract class j {
    private static j a;
    private static final int b = 20;

    public j(int n2) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static j c() {
        Class<j> clazz = j.class;
        synchronized (j.class) {
            try {
                if (a != null) return a;
                j j2 = new a(3);
                a = j2;
                return a;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void e(j j2) {
        Class<j> clazz = j.class;
        synchronized (j.class) {
            a = j2;
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return;
        }
    }

    public static String f(String string) {
        int n2 = string.length();
        StringBuilder stringBuilder = new StringBuilder(23);
        stringBuilder.append("WM-");
        int n3 = b;
        if (n2 >= n3) {
            stringBuilder.append(string.substring(0, n3));
        } else {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public abstract void a(String var1, String var2, Throwable ... var3);

    public abstract void b(String var1, String var2, Throwable ... var3);

    public abstract void d(String var1, String var2, Throwable ... var3);

    public abstract void g(String var1, String var2, Throwable ... var3);

    public abstract void h(String var1, String var2, Throwable ... var3);

    public static class a
    extends j {
        private int c;

        public a(int n2) {
            super(n2);
            this.c = n2;
        }

        @Override
        public void a(String string, String string2, Throwable ... throwableArray) {
            if (this.c <= 3) {
                if (throwableArray != null && throwableArray.length >= 1) {
                    Log.d((String)string, (String)string2, (Throwable)throwableArray[0]);
                    return;
                }
                Log.d((String)string, (String)string2);
            }
        }

        @Override
        public void b(String string, String string2, Throwable ... throwableArray) {
            if (this.c <= 6) {
                if (throwableArray != null && throwableArray.length >= 1) {
                    Log.e((String)string, (String)string2, (Throwable)throwableArray[0]);
                    return;
                }
                Log.e((String)string, (String)string2);
            }
        }

        @Override
        public void d(String string, String string2, Throwable ... throwableArray) {
            if (this.c <= 4) {
                if (throwableArray != null && throwableArray.length >= 1) {
                    Log.i((String)string, (String)string2, (Throwable)throwableArray[0]);
                    return;
                }
                Log.i((String)string, (String)string2);
            }
        }

        @Override
        public void g(String string, String string2, Throwable ... throwableArray) {
            if (this.c <= 2) {
                if (throwableArray != null && throwableArray.length >= 1) {
                    Log.v((String)string, (String)string2, (Throwable)throwableArray[0]);
                    return;
                }
                Log.v((String)string, (String)string2);
            }
        }

        @Override
        public void h(String string, String string2, Throwable ... throwableArray) {
            if (this.c <= 5) {
                if (throwableArray != null && throwableArray.length >= 1) {
                    Log.w((String)string, (String)string2, (Throwable)throwableArray[0]);
                    return;
                }
                Log.w((String)string, (String)string2);
            }
        }
    }
}

