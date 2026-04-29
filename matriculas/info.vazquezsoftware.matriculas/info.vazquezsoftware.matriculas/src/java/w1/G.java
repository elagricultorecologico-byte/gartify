/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  android.os.Bundle
 *  java.io.FileDescriptor
 *  java.io.PrintWriter
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package w1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import w1.b0;
import w1.e0;
import w1.f;
import w1.h;
import x1.n;

public abstract class g {
    protected final h g;

    protected g(h h2) {
        this.g = h2;
    }

    public static h c(Activity activity) {
        return w1.g.d(new f(activity));
    }

    protected static h d(f f2) {
        if (f2.a()) {
            return e0.D1(f2.d());
        }
        if (f2.b()) {
            return b0.c(f2.c());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
    }

    public Activity b() {
        Activity activity = this.g.e();
        n.i(activity);
        return activity;
    }

    public abstract void e(int var1, int var2, Intent var3);

    public void f(Bundle bundle) {
    }

    public void g() {
    }

    public void h() {
    }

    public void i(Bundle bundle) {
    }

    public void j() {
    }

    public void k() {
    }
}

