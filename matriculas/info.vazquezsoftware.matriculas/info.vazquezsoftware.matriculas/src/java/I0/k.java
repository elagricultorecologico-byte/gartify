/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.util.Log
 *  com.google.android.datatransport.runtime.backends.TransportBackendDiscovery
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 */
package I0;

import I0.d;
import I0.e;
import I0.i;
import I0.m;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class k
implements e {
    private final a a;
    private final i b;
    private final Map c = new HashMap();

    k(a a2, i i2) {
        this.a = a2;
        this.b = i2;
    }

    k(Context context, i i2) {
        this(new a(context), i2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public m a(String object) {
        k k2 = this;
        synchronized (k2) {
            Throwable throwable2;
            Object object2;
            block5: {
                try {
                    if (this.c.containsKey(object)) {
                        return (m)this.c.get(object);
                    }
                    object2 = this.a.b((String)object);
                    if (object2 != null) break block5;
                }
                catch (Throwable throwable2) {}
                return null;
            }
            object2 = object2.create(this.b.a((String)object));
            this.c.put(object, object2);
            return object2;
            throw throwable2;
        }
    }

    static class a {
        private final Context a;
        private Map b = null;

        a(Context context) {
            this.a = context;
        }

        private Map a(Context context) {
            Bundle bundle = I0.k$a.d(context);
            if (bundle == null) {
                Log.w((String)"BackendRegistry", (String)"Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.EMPTY_MAP;
            }
            HashMap hashMap = new HashMap();
            for (String string : bundle.keySet()) {
                String[] stringArray = bundle.get(string);
                if (!(stringArray instanceof String) || !string.startsWith("backend:")) continue;
                stringArray = ((String)stringArray).split(",", -1);
                int n2 = stringArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    String string2 = stringArray[i2].trim();
                    if (string2.isEmpty()) continue;
                    hashMap.put((Object)string2, (Object)string.substring(8));
                }
            }
            return hashMap;
        }

        private Map c() {
            if (this.b == null) {
                this.b = this.a(this.a);
            }
            return this.b;
        }

        private static Bundle d(Context context) {
            block7: {
                PackageManager packageManager;
                block6: {
                    try {
                        packageManager = context.getPackageManager();
                        if (packageManager != null) break block6;
                    }
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {
                        Log.w((String)"BackendRegistry", (String)"Application info not found.");
                        return null;
                    }
                    Log.w((String)"BackendRegistry", (String)"Context has no PackageManager.");
                    return null;
                }
                ComponentName componentName = new ComponentName(context, TransportBackendDiscovery.class);
                context = packageManager.getServiceInfo(componentName, 128);
                if (context != null) break block7;
                Log.w((String)"BackendRegistry", (String)"TransportBackendDiscovery has no service info.");
                return null;
            }
            context = context.metaData;
            return context;
        }

        d b(String string) {
            block11: {
                ClassNotFoundException classNotFoundException2;
                block10: {
                    IllegalAccessException illegalAccessException2;
                    block9: {
                        InstantiationException instantiationException2;
                        block8: {
                            NoSuchMethodException noSuchMethodException2;
                            block7: {
                                string = (String)this.c().get((Object)string);
                                if (string == null) {
                                    return null;
                                }
                                try {
                                    d d2 = (d)Class.forName((String)string).asSubclass(d.class).getDeclaredConstructor(null).newInstance(null);
                                    return d2;
                                }
                                catch (InvocationTargetException invocationTargetException) {
                                }
                                catch (NoSuchMethodException noSuchMethodException2) {
                                    break block7;
                                }
                                catch (InstantiationException instantiationException2) {
                                    break block8;
                                }
                                catch (IllegalAccessException illegalAccessException2) {
                                    break block9;
                                }
                                catch (ClassNotFoundException classNotFoundException2) {
                                    break block10;
                                }
                                Log.w((String)"BackendRegistry", (String)String.format((String)"Could not instantiate %s", (Object[])new Object[]{string}), (Throwable)invocationTargetException);
                                break block11;
                            }
                            Log.w((String)"BackendRegistry", (String)String.format((String)"Could not instantiate %s", (Object[])new Object[]{string}), (Throwable)noSuchMethodException2);
                            break block11;
                        }
                        Log.w((String)"BackendRegistry", (String)String.format((String)"Could not instantiate %s.", (Object[])new Object[]{string}), (Throwable)instantiationException2);
                        break block11;
                    }
                    Log.w((String)"BackendRegistry", (String)String.format((String)"Could not instantiate %s.", (Object[])new Object[]{string}), (Throwable)illegalAccessException2);
                    break block11;
                }
                Log.w((String)"BackendRegistry", (String)String.format((String)"Class %s is not found.", (Object[])new Object[]{string}), (Throwable)classNotFoundException2);
            }
            return null;
        }
    }
}

