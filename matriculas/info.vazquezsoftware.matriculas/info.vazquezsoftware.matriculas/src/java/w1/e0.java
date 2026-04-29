/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 *  androidx.fragment.app.f
 *  androidx.fragment.app.g
 *  androidx.fragment.app.n
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
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.f;
import androidx.fragment.app.n;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import w1.d0;
import w1.g;
import w1.h;

public final class e0
extends f
implements h {
    private static final WeakHashMap j0 = new WeakHashMap();
    private final d0 i0 = new d0();

    public static e0 D1(androidx.fragment.app.g g2) {
        Object object;
        WeakHashMap weakHashMap;
        block7: {
            n n2;
            block6: {
                e0 e02;
                n2 = g2.V();
                weakHashMap = j0;
                object = (WeakReference)weakHashMap.get((Object)g2);
                if (object != null && (object = (e0)object.get()) != null) {
                    return object;
                }
                try {
                    e02 = (e0)n2.f0("SLifecycleFragmentImpl");
                    if (e02 == null) break block6;
                    object = e02;
                }
                catch (ClassCastException classCastException) {
                    throw new IllegalStateException("Fragment with tag SLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", (Throwable)classCastException);
                }
                if (!e02.f0()) break block7;
            }
            object = new e0();
            n2.m().d((f)object, "SLifecycleFragmentImpl").g();
        }
        weakHashMap.put((Object)g2, (Object)new WeakReference(object));
        return object;
    }

    public final void J0() {
        super.J0();
        this.i0.e();
    }

    public final void K0(Bundle bundle) {
        super.K0(bundle);
        this.i0.g(bundle);
    }

    public final void L0() {
        super.L0();
        this.i0.d();
    }

    public final void M0() {
        super.M0();
        this.i0.h();
    }

    @Override
    public final void a(String string, g g2) {
        this.i0.b(string, g2);
    }

    @Override
    public final g b(String string, Class clazz) {
        return this.i0.a(string, clazz);
    }

    @Override
    public final Activity e() {
        return this.k();
    }

    public final void h(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        super.h(string, fileDescriptor, printWriter, stringArray);
        this.i0.j(string, fileDescriptor, printWriter, stringArray);
    }

    public final void j0(int n2, int n3, Intent intent) {
        super.j0(n2, n3, intent);
        this.i0.f(n2, n3, intent);
    }

    public final void o0(Bundle bundle) {
        super.o0(bundle);
        this.i0.c(bundle);
    }

    public final void t0() {
        super.t0();
        this.i0.i();
    }
}

