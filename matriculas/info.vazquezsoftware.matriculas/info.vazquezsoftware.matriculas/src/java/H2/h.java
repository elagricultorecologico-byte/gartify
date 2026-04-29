/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  com.google.android.play.core.common.PlayCoreDialogWrapperActivity
 *  java.lang.Object
 *  java.lang.Override
 */
package h2;

import L1.i;
import L1.j;
import L1.l;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import h2.b;
import h2.c;
import h2.g;
import h2.m;

public final class h
implements c {
    private final m a;
    private final Handler b = new Handler(Looper.getMainLooper());

    h(m m2) {
        this.a = m2;
    }

    @Override
    public final i a(Activity activity, b object) {
        if (((b)object).b()) {
            return l.c(null);
        }
        Intent intent = new Intent((Context)activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", (Parcelable)((b)object).a());
        intent.putExtra("window_flags", activity.getWindow().getDecorView().getWindowSystemUiVisibility());
        object = new j();
        intent.putExtra("result_receiver", (Parcelable)new g(this, this.b, (j)object));
        activity.startActivity(intent);
        return ((j)object).a();
    }

    @Override
    public final i b() {
        return this.a.a();
    }
}

