/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.app.FragmentManager
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Resources
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.View
 *  android.widget.ProgressBar
 *  androidx.core.app.k$c
 *  androidx.core.app.k$e
 *  androidx.core.app.k$f
 *  androidx.fragment.app.g
 *  androidx.fragment.app.n
 *  com.google.android.gms.common.api.GoogleApiActivity
 *  com.google.android.gms.common.util.i
 *  com.google.android.gms.common.util.m
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.NoClassDefFoundError
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 */
package u1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.app.k;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.util.i;
import com.google.android.gms.common.util.m;
import e1.J0;
import e1.M0;
import e1.N0;
import t1.a;
import u1.b;
import u1.c;
import u1.e;
import u1.f;
import u1.h;
import u1.k;
import u1.q;
import u1.r;
import w1.F;
import w1.G;
import x1.A;
import x1.n;
import x1.x;

public class g
extends h {
    public static final int d;
    private static final Object e;
    private static final g f;
    private String c;

    static {
        e = new Object();
        f = new g();
        d = h.a;
    }

    public static g m() {
        return f;
    }

    @Override
    public Intent b(Context context, int n2, String string) {
        return super.b(context, n2, string);
    }

    @Override
    public PendingIntent c(Context context, int n2, int n3) {
        return super.c(context, n2, n3);
    }

    @Override
    public final String e(int n2) {
        return super.e(n2);
    }

    @Override
    public int g(Context context) {
        return super.g(context);
    }

    @Override
    public int h(Context context, int n2) {
        return super.h(context, n2);
    }

    @Override
    public final boolean j(int n2) {
        return super.j(n2);
    }

    public Dialog k(Activity activity, int n2, int n3, DialogInterface.OnCancelListener onCancelListener) {
        return this.p((Context)activity, n2, A.b(activity, this.b((Context)activity, n2, "d"), n3), onCancelListener, null);
    }

    public PendingIntent l(Context context, b b2) {
        if (b2.g()) {
            return b2.f();
        }
        return this.c(context, b2.b(), 0);
    }

    public boolean n(Activity activity, int n2, int n3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialog = this.k(activity, n2, n3, onCancelListener);
        if (dialog == null) {
            return false;
        }
        this.s(activity, dialog, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void o(Context context, int n2) {
        this.t(context, n2, null, this.d(context, n2, 0, "n"));
    }

    final Dialog p(Context object, int n2, A a2, DialogInterface.OnCancelListener object2, DialogInterface.OnClickListener onClickListener) {
        Object object3 = null;
        if (n2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        object.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals((Object)object.getResources().getResourceEntryName(typedValue.resourceId))) {
            object3 = new AlertDialog.Builder(object, 5);
        }
        typedValue = object3;
        if (object3 == null) {
            typedValue = new AlertDialog.Builder(object);
        }
        typedValue.setMessage((CharSequence)x.c(object, n2));
        if (object2 != null) {
            typedValue.setOnCancelListener(object2);
        }
        if ((object3 = x.b(object, n2)) != null) {
            object2 = a2;
            if (a2 == null) {
                object2 = onClickListener;
            }
            typedValue.setPositiveButton((CharSequence)object3, (DialogInterface.OnClickListener)object2);
        }
        if ((object = x.f(object, n2)) != null) {
            typedValue.setTitle((CharSequence)object);
        }
        Log.w((String)"GoogleApiAvailability", (String)String.format((String)"Creating dialog for Google Play services availability issue. ConnectionResult=%s", (Object[])new Object[]{n2}), (Throwable)new IllegalArgumentException());
        return typedValue.create();
    }

    public final Dialog q(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar((Context)activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity);
        builder.setView((View)progressBar);
        builder.setMessage((CharSequence)x.c((Context)activity, 18));
        builder.setPositiveButton((CharSequence)"", null);
        builder = builder.create();
        this.s(activity, (Dialog)builder, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return builder;
    }

    public final G r(Context context, F f2) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        G g2 = new G(f2);
        G1.f.l(context, g2, intentFilter);
        g2.a(context);
        if (!this.i(context, "com.google.android.gms")) {
            f2.a();
            g2.b();
            return null;
        }
        return g2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final void s(Activity activity, Dialog dialog, String string, DialogInterface.OnCancelListener onCancelListener) {
        block2: {
            try {
                boolean bl = activity instanceof androidx.fragment.app.g;
                if (!bl) break block2;
            }
            catch (NoClassDefFoundError noClassDefFoundError) {
                break block2;
            }
            activity = ((androidx.fragment.app.g)activity).V();
            q.R1(dialog, onCancelListener).Q1((androidx.fragment.app.n)activity, string);
            return;
        }
        activity = activity.getFragmentManager();
        u1.c.a(dialog, onCancelListener).show((FragmentManager)activity, string);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final void t(Context object, int n2, String object2, PendingIntent object3) {
        Log.w((String)"GoogleApiAvailability", (String)String.format((String)"GMS core API Availability. ConnectionResult=%s, tag=%s", (Object[])new Object[]{n2, null}), (Throwable)new IllegalArgumentException());
        if (n2 == 18) {
            this.u((Context)object);
            return;
        }
        if (object3 == null) {
            if (n2 == 6) {
                Log.w((String)"GoogleApiAvailability", (String)"Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
            return;
        }
        String string = x.e(object, n2);
        object2 = x.d(object, n2);
        Resources resources = object.getResources();
        NotificationManager notificationManager = (NotificationManager)n.i(object.getSystemService("notification"));
        string = new k.e(object).m(true).e(true).i((CharSequence)string).p((k.f)new k.c().h((CharSequence)object2));
        if (i.e((Context)object)) {
            n.k(m.a());
            string.o(object.getApplicationInfo().icon).n(2);
            if (i.f((Context)object)) {
                string.a(t1.a.a, (CharSequence)resources.getString(t1.b.o), object3);
            } else {
                string.g(object3);
            }
        } else {
            string.o(17301642).q((CharSequence)resources.getString(t1.b.h)).r(System.currentTimeMillis()).g(object3).h((CharSequence)object2);
        }
        if (m.c()) {
            n.k(m.c());
            Object object4 = object2 = e;
            synchronized (object4) {
                object3 = this.c;
            }
            object2 = object3;
            if (object3 == null) {
                object3 = "com.google.android.gms.availability";
                resources = J0.a(notificationManager, "com.google.android.gms.availability");
                object = object.getResources().getString(t1.b.g);
                if (resources == null) {
                    M0.a(notificationManager, N0.a("com.google.android.gms.availability", (CharSequence)object, 4));
                    object2 = object3;
                } else {
                    object2 = object3;
                    if (!object.contentEquals(u1.e.a((NotificationChannel)resources))) {
                        u1.f.a((NotificationChannel)resources, (CharSequence)object);
                        M0.a(notificationManager, (NotificationChannel)resources);
                        object2 = object3;
                    }
                }
            }
            string.f((String)object2);
        }
        object = string.b();
        if (n2 != 1 && n2 != 2 && n2 != 3) {
            n2 = 39789;
        } else {
            k.b.set(false);
            n2 = 10436;
        }
        notificationManager.notify(n2, (Notification)object);
    }

    final void u(Context context) {
        new r(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean v(Activity activity, w1.h h2, int n2, int n3, DialogInterface.OnCancelListener onCancelListener) {
        if ((h2 = this.p((Context)activity, n2, A.c(h2, this.b((Context)activity, n2, "d"), 2), onCancelListener, null)) == null) {
            return false;
        }
        this.s(activity, (Dialog)h2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean w(Context context, b b2, int n2) {
        PendingIntent pendingIntent;
        if (!B1.b.a(context) && (pendingIntent = this.l(context, b2)) != null) {
            this.t(context, b2.b(), null, PendingIntent.getActivity((Context)context, (int)0, (Intent)GoogleApiActivity.a((Context)context, (PendingIntent)pendingIntent, (int)n2, (boolean)true), (int)(G1.g.a | 0x8000000)));
            return true;
        }
        return false;
    }
}

