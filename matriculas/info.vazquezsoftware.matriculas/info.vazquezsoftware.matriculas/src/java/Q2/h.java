/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Point
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  androidx.appcompat.app.c
 *  androidx.appcompat.app.c$a
 *  androidx.core.content.a
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package q2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k2.d;
import q2.b;
import q2.c;
import q2.d;
import q2.e;
import q2.f;
import q2.g;
import q2.i;
import q2.j;
import q2.k;

public abstract class h {
    private static k2.a a;
    private static a b;

    public static /* synthetic */ void a(androidx.appcompat.app.c c3, View view) {
        b.a(false);
        c3.dismiss();
    }

    public static /* synthetic */ void b(k2.c c3, Activity activity) {
        if (c3.a()) {
            h.l(activity, c3);
            return;
        }
        b.a(true);
    }

    public static /* synthetic */ void c(Activity activity, androidx.appcompat.app.c c3, View view) {
        h.n(activity);
        h.p(activity, b);
        c3.dismiss();
    }

    public static /* synthetic */ void d(k2.c c3, Activity activity, k2.b b2) {
        if (c3.c() == 2) {
            b2.a(activity, new e(c3, activity));
            return;
        }
        if (c3.c() == 3) {
            boolean bl = h.h((Context)activity);
            b.a(bl);
            return;
        }
        if (c3.c() == 1) {
            b.a(true);
            return;
        }
        if (c3.c() == 0) {
            b.a(true);
        }
    }

    public static /* synthetic */ void e(k2.c object, Activity activity, k2.e e2) {
        if (object.c() == 3) {
            if (h.h((Context)activity)) {
                h.o((Context)activity, true);
                object = b;
                if (object != null) {
                    object.a(true);
                    return;
                }
            } else {
                h.o((Context)activity, false);
                if (b != null) {
                    h.m(activity);
                    return;
                }
                h.m(activity);
            }
        }
    }

    public static /* synthetic */ void f(k2.e object) {
        object = b;
        if (object != null) {
            object.b();
        }
    }

    public static /* synthetic */ void g(k2.e object) {
        object = b;
        if (object != null) {
            object.b();
        }
    }

    private static boolean h(Context object) {
        Object object2 = Z.b.a(object.getApplicationContext());
        object = object2.getString("IABTCF_PurposeConsents", "");
        String string = object2.getString("IABTCF_VendorConsents", "");
        String string2 = object2.getString("IABTCF_VendorLegitimateInterests", "");
        object2 = object2.getString("IABTCF_PurposeLegitimateInterests", "");
        boolean bl = h.i(string, 755);
        boolean bl2 = h.i(string2, 755);
        string2 = new ArrayList();
        string2.add((Object)1);
        string = new ArrayList();
        string.add((Object)2);
        string.add((Object)7);
        string.add((Object)9);
        string.add((Object)10);
        return h.j((List)string2, (String)object, bl) && h.k((List)string, (String)object, (String)object2, bl, bl2);
    }

    private static boolean i(String string, int n2) {
        if (string == null) {
            return false;
        }
        return string.length() >= n2 && string.charAt(n2 - 1) == '1';
    }

    private static boolean j(List list, String string, boolean bl) {
        list = list.iterator();
        while (list.hasNext()) {
            if (h.i(string, (Integer)list.next())) continue;
            return false;
        }
        return bl;
    }

    private static boolean k(List list, String string, String string2, boolean bl, boolean bl2) {
        block1: {
            boolean bl3;
            boolean bl4;
            Iterator iterator = list.iterator();
            do {
                boolean bl5 = iterator.hasNext();
                bl3 = true;
                if (!bl5) break block1;
                list = (Integer)iterator.next();
                bl4 = h.i(string2, list.intValue()) && bl2;
                if (h.i(string, list.intValue()) && bl) continue;
                bl3 = false;
            } while (bl4 || bl3);
            return false;
        }
        return true;
    }

    private static void l(Activity activity, k2.c c3) {
        k2.f.b((Context)activity, new c(c3, activity), new d());
    }

    private static void m(Activity activity) {
        c.a a2 = new c.a((Context)activity);
        View view = activity.getLayoutInflater().inflate(k.a, null);
        a2.l(view);
        a2 = a2.a();
        if (a2.getWindow() != null) {
            a2.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(androidx.core.content.a.b((Context)activity, (int)i.a)));
        }
        Button button = (Button)view.findViewById(j.b);
        view = (Button)view.findViewById(j.a);
        button.setOnClickListener((View.OnClickListener)new f(activity, (androidx.appcompat.app.c)a2));
        view.setOnClickListener((View.OnClickListener)new g((androidx.appcompat.app.c)a2));
        a2.show();
        if (a2.getWindow() != null) {
            view = activity.getWindowManager().getDefaultDisplay();
            activity = new Point();
            view.getSize((Point)activity);
            int n2 = (int)((double)activity.x * 0.7);
            a2.getWindow().setLayout(n2, -2);
        }
    }

    public static void n(Activity activity) {
        k2.f.a((Context)activity).d();
        h.o((Context)activity, true);
    }

    public static void o(Context context, boolean bl) {
        context = Z.b.a(context).edit();
        context.putBoolean("user_selected_show_ads", bl);
        context.apply();
    }

    public static void p(Activity activity, a object) {
        b = object;
        object = new d.a().c(false).b(a).a();
        k2.c c3 = k2.f.a((Context)activity);
        c3.b(activity, (k2.d)object, new q2.a(c3, activity), new b());
    }

    public static interface a {
        public void a(boolean var1);

        public void b();
    }
}

