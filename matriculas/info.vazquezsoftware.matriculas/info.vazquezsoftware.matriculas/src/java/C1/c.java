/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  u1.k
 *  x1.n
 */
package C1;

import android.content.Context;
import android.os.IBinder;
import u1.k;
import x1.n;

public abstract class c {
    private final String a;
    private Object b;

    protected c(String string) {
        this.a = string;
    }

    protected abstract Object a(IBinder var1);

    protected final Object b(Context context) {
        block6: {
            if (this.b == null) {
                n.i((Object)context);
                context = k.c((Context)context);
                if (context != null) {
                    ClassNotFoundException classNotFoundException2;
                    block8: {
                        InstantiationException instantiationException2;
                        block7: {
                            context = context.getClassLoader();
                            try {
                                this.b = this.a((IBinder)context.loadClass(this.a).newInstance());
                                break block6;
                            }
                            catch (IllegalAccessException illegalAccessException) {
                            }
                            catch (InstantiationException instantiationException2) {
                                break block7;
                            }
                            catch (ClassNotFoundException classNotFoundException2) {
                                break block8;
                            }
                            throw new a("Could not access creator.", illegalAccessException);
                        }
                        throw new a("Could not instantiate creator.", instantiationException2);
                    }
                    throw new a("Could not load creator class.", classNotFoundException2);
                }
                throw new a("Could not get remote context.");
            }
        }
        return this.b;
    }

    public static class a
    extends Exception {
        public a(String string) {
            super(string);
        }

        public a(String string, Throwable throwable) {
            super(string, throwable);
        }
    }
}

