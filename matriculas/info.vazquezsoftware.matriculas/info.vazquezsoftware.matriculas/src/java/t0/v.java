/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.ListenableWorker
 *  androidx.work.WorkerParameters
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package t0;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import t0.j;

public abstract class v {
    private static final String a = j.f("WorkerFactory");

    public static v c() {
        return new v(){

            @Override
            public ListenableWorker a(Context context, String string, WorkerParameters workerParameters) {
                return null;
            }
        };
    }

    public abstract ListenableWorker a(Context var1, String var2, WorkerParameters var3);

    public final ListenableWorker b(Context object, String string, WorkerParameters workerParameters) {
        ListenableWorker listenableWorker;
        ListenableWorker listenableWorker2 = listenableWorker = this.a((Context)object, string, workerParameters);
        if (listenableWorker == null) {
            Object object2;
            try {
                object2 = Class.forName((String)string).asSubclass(ListenableWorker.class);
            }
            catch (Throwable throwable) {
                j j2 = j.c();
                String string2 = a;
                object2 = new StringBuilder();
                object2.append("Invalid class: ");
                object2.append(string);
                j2.b(string2, object2.toString(), throwable);
                object2 = null;
            }
            listenableWorker2 = listenableWorker;
            if (object2 != null) {
                try {
                    listenableWorker2 = (ListenableWorker)object2.getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{object, workerParameters});
                }
                catch (Throwable throwable) {
                    object = j.c();
                    object2 = a;
                    listenableWorker2 = new StringBuilder();
                    listenableWorker2.append("Could not instantiate ");
                    listenableWorker2.append(string);
                    ((j)object).b((String)object2, listenableWorker2.toString(), throwable);
                    listenableWorker2 = listenableWorker;
                }
            }
        }
        if (listenableWorker2 != null && listenableWorker2.isUsed()) {
            throw new IllegalStateException(String.format((String)"WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", (Object[])new Object[]{this.getClass().getName(), string}));
        }
        return listenableWorker2;
    }
}

