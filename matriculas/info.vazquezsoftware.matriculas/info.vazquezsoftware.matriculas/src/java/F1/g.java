/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$MemoryInfo
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.Uri$Builder
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.provider.Settings$Secure
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.jk
 *  com.google.android.gms.internal.ads.qk0
 *  java.lang.ArithmeticException
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.ClassCastException
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.math.BigInteger
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Locale
 *  java.util.Map
 *  java.util.StringTokenizer
 *  java.util.UUID
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 *  u1.h
 */
package f1;

import T0.i;
import U0.b;
import U0.c;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import b1.A;
import b1.h2;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.jk;
import com.google.android.gms.internal.ads.qk0;
import f1.e;
import f1.f;
import f1.p;
import g1.a;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u1.h;

public final class g {
    public static final Handler b = new qk0(Looper.getMainLooper());
    private static final String c = i.class.getName();
    private static final String d = a.class.getName();
    private static final String e = b.class.getName();
    private static final String f = c.class.getName();
    private static final String g = T0.f.class.getName();
    private float a = -1.0f;

    public static boolean A(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return false;
        }
        return string.startsWith((String)jk.d.e());
    }

    public static int B(Context context, int n2) {
        if (context != null) {
            Context context2 = context;
            if (context.getApplicationContext() != null) {
                context2 = context.getApplicationContext();
            }
            if ((context2 = context2.getResources()) != null && (context = context2.getDisplayMetrics()) != null && (context2 = context2.getConfiguration()) != null) {
                int n3 = context2.orientation;
                int n4 = n2;
                if (n2 == 0) {
                    n4 = n3;
                }
                if (n4 == n3) {
                    return Math.round((float)((float)context.heightPixels / context.density));
                }
                return Math.round((float)((float)context.widthPixels / context.density));
            }
        }
        return -1;
    }

    public static final int C(DisplayMetrics displayMetrics, int n2) {
        return (int)TypedValue.applyDimension((int)1, (float)n2, (DisplayMetrics)displayMetrics);
    }

    public static final String D(StackTraceElement[] object, String string) {
        String string2;
        StackTraceElement stackTraceElement;
        int n2;
        block6: {
            int n3;
            n2 = 0;
            while ((n3 = n2 + 1) < ((StackTraceElement[])object).length) {
                stackTraceElement = object[n2];
                string2 = stackTraceElement.getClassName();
                if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (c.equalsIgnoreCase(string2) || d.equalsIgnoreCase(string2) || e.equalsIgnoreCase(string2) || f.equalsIgnoreCase(string2) || g.equalsIgnoreCase(string2))) {
                    object = object[n3].getClassName();
                    break block6;
                }
                n2 = n3;
            }
            object = null;
        }
        if (string != null) {
            stackTraceElement = new StringTokenizer(string, ".");
            string2 = new StringBuilder();
            if (stackTraceElement.hasMoreElements()) {
                string2.append(stackTraceElement.nextToken());
                for (n2 = 2; n2 > 0 && stackTraceElement.hasMoreElements(); --n2) {
                    string2.append(".");
                    string2.append(stackTraceElement.nextToken());
                }
                string = string2.toString();
            }
            if (object != null && !object.contains((CharSequence)string)) {
                return object;
            }
        }
        return null;
    }

    public static final boolean E() {
        Object object = Yi.Oc;
        boolean bl = (Boolean)A.c().d(object);
        if (Build.VERSION.SDK_INT >= 31) {
            object = Build.FINGERPRINT;
            if (!object.contains((CharSequence)"generic") && !object.contains((CharSequence)"emulator")) {
                if (bl) {
                    return Build.HARDWARE.contains((CharSequence)"ranchu");
                }
                return false;
            }
            return true;
        }
        return Build.DEVICE.startsWith("generic");
    }

    public static final boolean F(Context context, int n2) {
        return h.f().h(context, n2) == 0;
    }

    public static final boolean a(Context context) {
        int n2 = h.f().h(context, 12451000);
        return n2 == 0 || n2 == 2;
        {
        }
    }

    public static final boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static final int c(DisplayMetrics displayMetrics, int n2) {
        return Math.round((float)((float)n2 / displayMetrics.density));
    }

    public static final void d(Context context, String string, String string22, Bundle bundle, boolean bl, f f2) {
        Context context2 = context.getApplicationContext();
        string22 = context2;
        if (context2 == null) {
            string22 = context;
        }
        bundle.putString("os", Build.VERSION.RELEASE);
        bundle.putString("api", String.valueOf((int)Build.VERSION.SDK_INT));
        bundle.putString("appid", string22.getPackageName());
        string22 = string;
        if (string == null) {
            int n2 = h.f().a(context);
            context = new StringBuilder(String.valueOf((int)n2).length() + 10);
            context.append(n2);
            context.append(".260910000");
            string22 = context.toString();
        }
        bundle.putString("js", string22);
        string = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps");
        for (String string22 : bundle.keySet()) {
            string.appendQueryParameter(string22, bundle.getString(string22));
        }
        f2.b(string.toString());
    }

    public static final int e(Context context, int n2) {
        return f1.g.C(context.getResources().getDisplayMetrics(), n2);
    }

    public static final String f(Context object) {
        Yi.a((Context)object);
        object = object.getContentResolver();
        object = object == null ? null : Settings.Secure.getString((ContentResolver)object, (String)"android_id");
        if (object == null || f1.g.E()) {
            object = "emulator";
        }
        return f1.g.g((String)object, "MD5");
    }

    private static String g(String string, String string2) {
        for (int i2 = 0; i2 < 2; ++i2) {
            try {
                Object object = MessageDigest.getInstance((String)string2);
                object.update(string.getBytes());
                Locale locale = Locale.US;
                BigInteger bigInteger = new BigInteger(1, object.digest());
                object = String.format((Locale)locale, (String)"%032X", (Object[])new Object[]{bigInteger});
                return object;
            }
            catch (ArithmeticException arithmeticException) {
                return null;
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                continue;
            }
        }
        return null;
    }

    private final JSONArray h(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        collection = collection.iterator();
        while (collection.hasNext()) {
            this.i(jSONArray, collection.next());
        }
        return jSONArray;
    }

    private final void i(JSONArray jSONArray, Object object) {
        if (object instanceof Bundle) {
            jSONArray.put((Object)this.y((Bundle)object));
            return;
        }
        if (object instanceof Map) {
            jSONArray.put((Object)this.w((Map)object));
            return;
        }
        if (object instanceof Collection) {
            jSONArray.put((Object)this.h((Collection)object));
            return;
        }
        if (object instanceof Object[]) {
            jSONArray.put((Object)this.z((Object[])object));
            return;
        }
        jSONArray.put(object);
    }

    private final void j(JSONObject jSONObject, String objectArray, Object object) {
        int n2;
        Oi oi = Yi.s;
        Object[] objectArray2 = objectArray;
        if (((Boolean)A.c().d(oi)).booleanValue()) {
            objectArray2 = String.valueOf((Object)objectArray);
        }
        if (object instanceof Bundle) {
            jSONObject.put((String)objectArray2, (Object)this.y((Bundle)object));
            return;
        }
        if (object instanceof Map) {
            jSONObject.put((String)objectArray2, (Object)this.w((Map)object));
            return;
        }
        if (object instanceof Collection) {
            jSONObject.put(String.valueOf((Object)objectArray2), (Object)this.h((Collection)object));
            return;
        }
        if (object instanceof Object[]) {
            jSONObject.put((String)objectArray2, (Object)this.h((Collection)Arrays.asList((Object[])((Object[])object))));
            return;
        }
        boolean bl = object instanceof int[];
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        if (bl) {
            if ((object = (Object)((int[])object)) == null) {
                objectArray = new Integer[]{};
            } else {
                n4 = ((Object)object).length;
                objectArray = new Integer[n4];
                for (n2 = 0; n2 < n4; ++n2) {
                    objectArray[n2] = (int)object[n2];
                }
            }
            jSONObject.put((String)objectArray2, (Object)this.z(objectArray));
            return;
        }
        if (object instanceof double[]) {
            if ((object = (Object)((double[])object)) == null) {
                objectArray = new Double[]{};
            } else {
                n4 = ((Object)object).length;
                objectArray = new Double[n4];
                for (n2 = n3; n2 < n4; ++n2) {
                    objectArray[n2] = (double)object[n2];
                }
            }
            jSONObject.put((String)objectArray2, (Object)this.z(objectArray));
            return;
        }
        if (object instanceof long[]) {
            if ((object = (Object)((long[])object)) == null) {
                objectArray = new Long[]{};
            } else {
                n3 = ((Object)object).length;
                objectArray = new Long[n3];
                for (n2 = n4; n2 < n3; ++n2) {
                    objectArray[n2] = (long)object[n2];
                }
            }
            jSONObject.put((String)objectArray2, (Object)this.z(objectArray));
            return;
        }
        if (object instanceof boolean[]) {
            if ((object = (Object)((boolean[])object)) == null) {
                objectArray = new Boolean[]{};
            } else {
                n4 = ((Object)object).length;
                objectArray = new Boolean[n4];
                for (n2 = n5; n2 < n4; ++n2) {
                    objectArray[n2] = (boolean)object[n2];
                }
            }
            jSONObject.put((String)objectArray2, (Object)this.z(objectArray));
            return;
        }
        jSONObject.put((String)objectArray2, object);
    }

    private static final void k(ViewGroup viewGroup, h2 h22, String string, int n2, int n3) {
        if (viewGroup.getChildCount() != 0) {
            return;
        }
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText((CharSequence)string);
        textView.setTextColor(n2);
        textView.setBackgroundColor(n3);
        string = new FrameLayout(context);
        string.setBackgroundColor(n2);
        n2 = f1.g.e(context, 3);
        n3 = h22.l;
        int n4 = h22.i;
        string.addView((View)textView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(n3 - n2, n4 - n2, 17));
        viewGroup.addView((View)string, n3, n4);
    }

    public static Object o(Map map, Object object, Object object2) {
        if (map.containsKey(object)) {
            return map.get(object);
        }
        return object2;
    }

    public static ActivityManager.MemoryInfo p(Context context) {
        if (context == null) {
            return null;
        }
        ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        context = new ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo((ActivityManager.MemoryInfo)context);
            return context;
        }
        catch (NullPointerException nullPointerException) {
            p.f("Error retrieving the memory information.");
            return context;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String q(Context object) {
        Bundle bundle;
        if (object == null) {
            return null;
        }
        try {
            bundle = B1.e.a((Context)object).c((String)object.getPackageName(), (int)128).metaData;
            if (bundle == null) return null;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return null;
        }
        if (!bundle.containsKey("com.google.unity.ads.UNITY_VERSION")) return null;
        return bundle.getString("com.google.unity.ads.UNITY_VERSION");
    }

    public static String r(String string) {
        return f1.g.g(string, "MD5");
    }

    public static String s(String string) {
        return f1.g.g(string, "SHA-256");
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String u() {
        UUID uUID = UUID.randomUUID();
        byte[] byArray = BigInteger.valueOf((long)uUID.getLeastSignificantBits()).toByteArray();
        byte[] byArray2 = BigInteger.valueOf((long)uUID.getMostSignificantBits()).toByteArray();
        String string = new BigInteger(1, byArray).toString();
        int n2 = 0;
        void var1_2;
        while (n2 < 2) {
            try {
                String string2;
                MessageDigest messageDigest = MessageDigest.getInstance((String)"MD5");
                messageDigest.update(byArray);
                messageDigest.update(byArray2);
                byte[] byArray3 = new byte[8];
                System.arraycopy((Object)messageDigest.digest(), (int)0, (Object)byArray3, (int)0, (int)8);
                messageDigest = new BigInteger(1, byArray3);
                String string3 = string2 = messageDigest.toString();
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
            ++n2;
        }
        return var1_2;
    }

    public static T0.h v(Context context, int n2, int n3, int n4) {
        n3 = f1.g.B(context, n4);
        if (n3 == -1) {
            return T0.h.r;
        }
        n4 = Math.min((int)90, (int)Math.round((float)((float)n3 * 0.15f)));
        n3 = n2 > 655 ? Math.round((float)((float)n2 / 728.0f * 90.0f)) : (n2 > 632 ? 81 : (n2 > 526 ? Math.round((float)((float)n2 / 468.0f * 60.0f)) : (n2 > 432 ? 68 : Math.round((float)((float)n2 / 320.0f * 50.0f)))));
        return new T0.h(n2, Math.max((int)Math.min((int)n3, (int)n4), (int)50));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final int l(Context context, int n2) {
        if (!(this.a < 0.0f)) return Math.round((float)((float)n2 / this.a));
        g g2 = this;
        synchronized (g2) {
            Throwable throwable2;
            block4: {
                try {
                    if (!(this.a < 0.0f)) return Math.round((float)((float)n2 / this.a));
                    if ((context = (WindowManager)context.getSystemService("window")) == null) {
                        return 0;
                    }
                }
                catch (Throwable throwable2) {
                    break block4;
                }
                context = context.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                context.getMetrics(displayMetrics);
                this.a = displayMetrics.density;
                return Math.round((float)((float)n2 / this.a));
            }
            throw throwable2;
        }
    }

    public final void m(ViewGroup viewGroup, h2 h22, String string, String string2) {
        if (string2 != null) {
            p.f(string2);
        }
        f1.g.k(viewGroup, h22, string, -65536, -16777216);
    }

    public final void n(ViewGroup viewGroup, h2 h22, String string) {
        f1.g.k(viewGroup, h22, "Ads by Google", -16777216, -1);
    }

    public final void t(Context context, String string, String string2, Bundle bundle, boolean bl) {
        f1.g.d(context, string, "gmob-apps", bundle, true, new e(this, context));
    }

    public final JSONObject w(Map map) {
        ClassCastException classCastException2;
        block3: {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                for (String string : map.keySet()) {
                    this.j(jSONObject, string, map.get((Object)string));
                }
            }
            catch (ClassCastException classCastException2) {
                break block3;
            }
            return jSONObject;
        }
        throw new JSONException("Could not convert map to JSON: ".concat(String.valueOf((Object)classCastException2.getMessage())));
    }

    public final JSONObject x(Bundle bundle, JSONObject jSONObject) {
        if (bundle != null) {
            try {
                bundle = this.y(bundle);
                return bundle;
            }
            catch (JSONException jSONException) {
                p.d("Error converting Bundle to JSON", jSONException);
            }
        }
        return null;
    }

    public final JSONObject y(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String string : bundle.keySet()) {
            this.j(jSONObject, string, bundle.get(string));
        }
        return jSONObject;
    }

    final JSONArray z(Object[] objectArray) {
        JSONArray jSONArray = new JSONArray();
        int n2 = objectArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.i(jSONArray, objectArray[i2]);
        }
        return jSONArray;
    }
}

