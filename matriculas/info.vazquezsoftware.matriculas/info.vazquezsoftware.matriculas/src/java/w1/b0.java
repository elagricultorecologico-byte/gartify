/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Intent
 *  android.os.Bundle
 *  java.io.FileDescriptor
 *  java.io.PrintWriter
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.WeakHashMap
 */
package w1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import w1.d0;
import w1.g;
import w1.h;

public final class b0
extends Fragment
implements h {
    private static final WeakHashMap h = new WeakHashMap();
    private final d0 g = new d0();

    public static b0 c(Activity activity) {
        Object object;
        WeakHashMap weakHashMap;
        block7: {
            block6: {
                b0 b02;
                weakHashMap = h;
                object = (WeakReference)weakHashMap.get((Object)activity);
                if (object != null && (object = (b0)object.get()) != null) {
                    return object;
                }
                try {
                    b02 = (b0)activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                    if (b02 == null) break block6;
                    object = b02;
                }
                catch (ClassCastException classCastException) {
                    throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", (Throwable)classCastException);
                }
                if (!b02.isRemoving()) break block7;
            }
            object = new b0();
            activity.getFragmentManager().beginTransaction().add((Fragment)object, "LifecycleFragmentImpl").commitAllowingStateLoss();
        }
        weakHashMap.put((Object)activity, (Object)new WeakReference(object));
        return object;
    }

    @Override
    public final void a(String string, g g2) {
        this.g.b(string, g2);
    }

    @Override
    public final g b(String string, Class clazz) {
        return this.g.a(string, clazz);
    }

    public final void dump(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        super.dump(string, fileDescriptor, printWriter, stringArray);
        this.g.j(string, fileDescriptor, printWriter, stringArray);
    }

    @Override
    public final Activity e() {
        return this.getActivity();
    }

    public final void onActivityResult(int n2, int n3, Intent intent) {
        super.onActivityResult(n2, n3, intent);
        this.g.f(n2, n3, intent);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g.c(bundle);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.g.i();
    }

    public final void onResume() {
        super.onResume();
        this.g.e();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.g.g(bundle);
    }

    public final void onStart() {
        super.onStart();
        this.g.d();
    }

    public final void onStop() {
        super.onStop();
        this.g.h();
    }
}

