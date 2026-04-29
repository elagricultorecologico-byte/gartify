/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.graphics.PointF
 *  android.net.Uri$Builder
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.view.MotionEvent
 *  android.view.ViewConfiguration
 *  android.view.WindowManager$BadTokenException
 *  com.google.android.gms.internal.ads.Fu
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.ez0
 *  com.google.android.gms.internal.ads.rU
 *  com.google.android.gms.internal.ads.vU
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicInteger
 */
package e1;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import b1.A;
import com.google.android.gms.internal.ads.Fu;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.ez0;
import com.google.android.gms.internal.ads.rU;
import com.google.android.gms.internal.ads.vU;
import e1.F0;
import e1.e;
import e1.f;
import e1.g;
import e1.h;
import e1.i;
import e1.j;
import e1.k;
import e1.l;
import e1.m;
import e1.n;
import e1.o;
import e1.o0;
import e1.p;
import e1.q;
import e1.r;
import e1.s;
import e1.t;
import e1.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class u {
    private final Context a;
    private final vU b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g = 0;
    private int h;
    private PointF i;
    private PointF j;
    private Handler k;
    private Runnable l = new t(this);

    public u(Context context) {
        this.a = context;
        this.h = ViewConfiguration.get((Context)context).getScaledTouchSlop();
        a1.t.w().a();
        this.k = a1.t.w().b();
        this.b = a1.t.s().b();
    }

    public u(Context context, String string) {
        this(context);
        this.c = string;
    }

    private final boolean s(float f2, float f3, float f4, float f5) {
        return Math.abs((float)(this.i.x - f2)) < (float)this.h && Math.abs((float)(this.i.y - f3)) < (float)this.h && Math.abs((float)(this.j.x - f4)) < (float)this.h && Math.abs((float)(this.j.y - f5)) < (float)this.h;
    }

    private final void t(Context context) {
        ArrayList arrayList = new ArrayList();
        int n2 = u.u((List)arrayList, "None", true);
        int n3 = u.u((List)arrayList, "Shake", true);
        int n4 = u.u((List)arrayList, "Flick", true);
        int n5 = this.b.g().ordinal();
        if (n5 != 1) {
            if (n5 == 2) {
                n2 = n4;
            }
        } else {
            n2 = n3;
        }
        a1.t.g();
        context = F0.n(context);
        AtomicInteger atomicInteger = new AtomicInteger(n2);
        context.setTitle((CharSequence)"Setup gesture");
        context.setSingleChoiceItems((CharSequence[])arrayList.toArray((Object[])new String[0]), n2, (DialogInterface.OnClickListener)new k(atomicInteger));
        context.setNegativeButton((CharSequence)"Dismiss", (DialogInterface.OnClickListener)new l(this));
        context.setPositiveButton((CharSequence)"Save", (DialogInterface.OnClickListener)new m(this, atomicInteger, n2, n3, n4));
        context.setOnCancelListener((DialogInterface.OnCancelListener)new n(this));
        context.create().show();
    }

    private static final int u(List list, String string, boolean bl) {
        if (!bl) {
            return -1;
        }
        list.add((Object)string);
        return list.size() - 1;
    }

    public final void a(MotionEvent motionEvent) {
        block7: {
            block9: {
                int n2;
                int n3;
                int n4;
                int n5;
                block8: {
                    n5 = motionEvent.getActionMasked();
                    n4 = motionEvent.getHistorySize();
                    n3 = motionEvent.getPointerCount();
                    if (n5 == 0) {
                        this.g = 0;
                        this.i = new PointF(motionEvent.getX(0), motionEvent.getY(0));
                        return;
                    }
                    n2 = this.g;
                    if (n2 == -1) break block7;
                    if (n2 != 0) break block8;
                    if (n5 == 5) {
                        this.g = 5;
                        this.j = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                        motionEvent = this.k;
                        Runnable runnable = this.l;
                        Oi oi = Yi.R5;
                        motionEvent.postDelayed(runnable, ((Long)A.c().d(oi)).longValue());
                        return;
                    }
                    break block7;
                }
                if (n2 != 5) break block7;
                if (n3 != 2) break block9;
                if (n5 != 2) break block7;
                n5 = 0;
                for (n3 = 0; n3 < n4; ++n3) {
                    n5 |= this.s(motionEvent.getHistoricalX(0, n3), motionEvent.getHistoricalY(0, n3), motionEvent.getHistoricalX(1, n3), motionEvent.getHistoricalY(1, n3)) ^ 1;
                }
                if (this.s(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && n5 == 0) break block7;
            }
            this.g = -1;
            this.k.removeCallbacks(this.l);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b() {
        WindowManager.BadTokenException badTokenException2;
        block5: {
            CharSequence[] charSequenceArray;
            try {
                charSequenceArray = this.a;
                if (!(charSequenceArray instanceof Activity)) {
                    int n2 = o0.b;
                    f1.p.e("Can not create dialog without Activity Context");
                    return;
                }
            }
            catch (WindowManager.BadTokenException badTokenException2) {
                break block5;
            }
            boolean bl = TextUtils.isEmpty((CharSequence)a1.t.s().i());
            String string = "Creative preview (enabled)";
            if (bl) {
                string = "Creative preview";
            }
            bl = a1.t.s().m();
            String string2 = "Troubleshooting (enabled)";
            if (!bl) {
                string2 = "Troubleshooting";
            }
            Object object = new ArrayList();
            int n3 = u.u((List)object, "Ad information", true);
            int n4 = u.u((List)object, string, true);
            int n5 = u.u((List)object, string2, true);
            string = Yi.Ca;
            bl = (Boolean)A.c().d((Oi)string);
            int n6 = u.u((List)object, "Open ad inspector", bl);
            int n7 = u.u((List)object, "Ad inspector settings", bl);
            a1.t.g();
            string = F0.n((Context)charSequenceArray);
            string2 = string.setTitle((CharSequence)"Select a debug mode");
            charSequenceArray = (CharSequence[])object.toArray((Object[])new String[0]);
            object = new e(this, n3, n4, n5, n6, n7);
            string2.setItems(charSequenceArray, (DialogInterface.OnClickListener)object);
            string.create().show();
            return;
        }
        o0.l("", badTokenException2);
    }

    public final void c(String string) {
        this.d = string;
    }

    public final void d(String string) {
        this.e = string;
    }

    public final void e(String string) {
        this.c = string;
    }

    public final void f(String string) {
        this.f = string;
    }

    final /* synthetic */ void g() {
        this.g = 4;
        this.b();
    }

    final /* synthetic */ void h(int n2, int n3, int n4, int n5, int n6, DialogInterface object, int n7) {
        if (n7 == n2) {
            Context context = this.a;
            if (!(context instanceof Activity)) {
                n2 = o0.b;
                f1.p.e("Can not create dialog without Activity Context");
                return;
            }
            String string = this.c;
            boolean bl = TextUtils.isEmpty((CharSequence)string);
            object = "No debug information";
            if (!bl) {
                string = string.replaceAll("\\+", "%20");
                Object object22 = new Uri.Builder().encodedQuery(string).build();
                string = new StringBuilder();
                a1.t.g();
                Map map = F0.t(object22);
                for (Object object22 : map.keySet()) {
                    string.append((String)object22);
                    string.append(" = ");
                    string.append((String)map.get(object22));
                    string.append("\n\n");
                }
                if (!TextUtils.isEmpty((CharSequence)(string = string.toString().trim()))) {
                    object = string;
                }
            }
            a1.t.g();
            string = F0.n(context);
            string.setMessage((CharSequence)object);
            string.setTitle((CharSequence)"Ad Information");
            string.setPositiveButton((CharSequence)"Share", (DialogInterface.OnClickListener)new o(this, (String)object));
            string.setNegativeButton((CharSequence)"Close", (DialogInterface.OnClickListener)p.g);
            string.create().show();
            return;
        }
        if (n7 == n3) {
            n2 = o0.b;
            f1.p.a("Debug mode [Creative Preview] selected.");
            Fu.a.execute((Runnable)new g(this));
            return;
        }
        if (n7 == n4) {
            n2 = o0.b;
            f1.p.a("Debug mode [Troubleshooting] selected.");
            Fu.a.execute((Runnable)new h(this));
            return;
        }
        if (n7 == n5) {
            vU vU2 = this.b;
            ez0 ez02 = Fu.f;
            object = Fu.a;
            if (vU2.t()) {
                ez02.execute((Runnable)new r(this));
                return;
            }
            object.execute((Runnable)new q(this, ez02));
            return;
        }
        if (n7 == n6) {
            vU vU3 = this.b;
            ez0 ez03 = Fu.f;
            object = Fu.a;
            if (vU3.t()) {
                ez03.execute((Runnable)new f(this));
                return;
            }
            object.execute((Runnable)new s(this, ez03));
        }
    }

    final /* synthetic */ void i(AtomicInteger atomicInteger, int n2, int n3, int n4, DialogInterface dialogInterface, int n5) {
        if (atomicInteger.get() != n2) {
            if (atomicInteger.get() == n3) {
                this.b.f(rU.h);
            } else if (atomicInteger.get() == n4) {
                this.b.f(rU.i);
            } else {
                this.b.f(rU.g);
            }
        }
        this.b();
    }

    final /* synthetic */ void j(String string, DialogInterface dialogInterface, int n2) {
        a1.t.g();
        string = Intent.createChooser((Intent)new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", string), (CharSequence)"Share via");
        F0.y(this.a, (Intent)string);
    }

    final /* synthetic */ void k(ez0 ez02) {
        Context context;
        y y2 = a1.t.s();
        if (!y2.e(context = this.a, this.d, this.e)) {
            a1.t.s().f(context, this.d, this.e);
            return;
        }
        ez02.execute((Runnable)new j(this));
    }

    final /* synthetic */ void l() {
        a1.t.s().c(this.a);
    }

    final /* synthetic */ void m(ez0 ez02) {
        Context context;
        y y2 = a1.t.s();
        if (!y2.e(context = this.a, this.d, this.e)) {
            a1.t.s().f(context, this.d, this.e);
            return;
        }
        ez02.execute((Runnable)new i(this));
    }

    final /* synthetic */ void n() {
        this.t(this.a);
    }

    final /* synthetic */ void o() {
        String string;
        String string2;
        Context context;
        y y2 = a1.t.s();
        if (!y2.d(context = this.a, string2 = this.d, string = this.e)) {
            y2.n(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        String string3 = y2.f;
        if ("2".equals((Object)string3)) {
            int n2 = o0.b;
            f1.p.a("Creative is not pushed for this device.");
            y2.n(context, "There was no creative pushed from DFP to the device.", false, false);
            return;
        }
        if ("1".equals((Object)string3)) {
            int n3 = o0.b;
            f1.p.a("The app is not linked for creative preview.");
            y2.f(context, string2, string);
            return;
        }
        if ("0".equals((Object)string3)) {
            int n4 = o0.b;
            f1.p.a("Device is linked for in app preview.");
            y2.n(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    final /* synthetic */ void p() {
        y y2 = a1.t.s();
        String string = this.d;
        String string2 = this.e;
        String string3 = this.f;
        boolean bl = y2.m();
        Context context = this.a;
        y2.l(y2.e(context, string, string2));
        if (y2.m()) {
            if (!bl && !TextUtils.isEmpty((CharSequence)string3)) {
                y2.h(context, string2, string3, string);
            }
            int n2 = o0.b;
            f1.p.a("Device is linked for debug signals.");
            y2.n(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        y2.f(context, string, string2);
    }

    final /* synthetic */ void q() {
        this.t(this.a);
    }

    final /* synthetic */ void r() {
        a1.t.s().c(this.a);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("{Dialog: ");
        stringBuilder.append(this.c);
        stringBuilder.append(",DebugSignal: ");
        stringBuilder.append(this.f);
        stringBuilder.append(",AFMA Version: ");
        stringBuilder.append(this.e);
        stringBuilder.append(",Ad Unit ID: ");
        stringBuilder.append(this.d);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

