/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  android.util.Log
 *  androidx.core.os.e
 *  com.google.android.gms.common.util.i
 *  java.lang.CharSequence
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Locale
 */
package x1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.os.e;
import java.util.Locale;
import p.i;
import t1.b;
import u1.j;
import u1.p;

public abstract class x {
    private static final i a = new i();
    private static Locale b;

    public static String a(Context object) {
        String string = object.getPackageName();
        try {
            String string2 = B1.e.a(object).d(string).toString();
            return string2;
        }
        catch (PackageManager.NameNotFoundException | NullPointerException throwable) {
            object = object.getApplicationInfo().name;
            if (TextUtils.isEmpty((CharSequence)object)) {
                return string;
            }
            return object;
        }
    }

    public static String b(Context context, int n2) {
        context = context.getResources();
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return context.getString(17039370);
                }
                return context.getString(t1.b.a);
            }
            return context.getString(t1.b.j);
        }
        return context.getString(t1.b.d);
    }

    public static String c(Context context, int n2) {
        Resources resources = context.getResources();
        String string = x.a(context);
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 5) {
                        if (n2 != 7) {
                            if (n2 != 9) {
                                if (n2 != 20) {
                                    switch (n2) {
                                        default: {
                                            return resources.getString(p.a, new Object[]{string});
                                        }
                                        case 18: {
                                            return resources.getString(t1.b.m, new Object[]{string});
                                        }
                                        case 17: {
                                            return x.g(context, "common_google_play_services_sign_in_failed_text", string);
                                        }
                                        case 16: 
                                    }
                                    return x.g(context, "common_google_play_services_api_unavailable_text", string);
                                }
                                return x.g(context, "common_google_play_services_restricted_profile_text", string);
                            }
                            return resources.getString(t1.b.i, new Object[]{string});
                        }
                        return x.g(context, "common_google_play_services_network_error_text", string);
                    }
                    return x.g(context, "common_google_play_services_invalid_account_text", string);
                }
                return resources.getString(t1.b.b, new Object[]{string});
            }
            if (com.google.android.gms.common.util.i.f((Context)context)) {
                return resources.getString(t1.b.n);
            }
            return resources.getString(t1.b.k, new Object[]{string});
        }
        return resources.getString(t1.b.e, new Object[]{string});
    }

    public static String d(Context context, int n2) {
        if (n2 != 6 && n2 != 19) {
            return x.c(context, n2);
        }
        return x.g(context, "common_google_play_services_resolution_required_text", x.a(context));
    }

    public static String e(Context context, int n2) {
        String string = n2 == 6 ? x.h(context, "common_google_play_services_resolution_required_title") : x.f(context, n2);
        if (string == null) {
            return context.getResources().getString(t1.b.h);
        }
        return string;
    }

    public static String f(Context context, int n2) {
        Resources resources = context.getResources();
        switch (n2) {
            default: {
                context = new StringBuilder();
                context.append("Unexpected error code ");
                context.append(n2);
                Log.e((String)"GoogleApiAvailability", (String)context.toString());
                return null;
            }
            case 20: {
                Log.e((String)"GoogleApiAvailability", (String)"The current user profile is restricted and could not use authenticated features.");
                return x.h(context, "common_google_play_services_restricted_profile_title");
            }
            case 17: {
                Log.e((String)"GoogleApiAvailability", (String)"The specified account could not be signed in.");
                return x.h(context, "common_google_play_services_sign_in_failed_title");
            }
            case 16: {
                Log.e((String)"GoogleApiAvailability", (String)"One of the API components you attempted to connect to is not available.");
                return null;
            }
            case 11: {
                Log.e((String)"GoogleApiAvailability", (String)"The application is not licensed to the user.");
                return null;
            }
            case 10: {
                Log.e((String)"GoogleApiAvailability", (String)"Developer error occurred. Please see logs for detailed information");
                return null;
            }
            case 9: {
                Log.e((String)"GoogleApiAvailability", (String)"Google Play services is invalid. Cannot recover.");
                return null;
            }
            case 8: {
                Log.e((String)"GoogleApiAvailability", (String)"Internal error occurred. Please see logs for detailed information");
                return null;
            }
            case 7: {
                Log.e((String)"GoogleApiAvailability", (String)"Network error occurred. Please retry request later.");
                return x.h(context, "common_google_play_services_network_error_title");
            }
            case 5: {
                Log.e((String)"GoogleApiAvailability", (String)"An invalid account was specified when connecting. Please provide a valid account.");
                return x.h(context, "common_google_play_services_invalid_account_title");
            }
            case 4: 
            case 6: 
            case 18: {
                return null;
            }
            case 3: {
                return resources.getString(t1.b.c);
            }
            case 2: {
                return resources.getString(t1.b.l);
            }
            case 1: 
        }
        return resources.getString(t1.b.f);
    }

    private static String g(Context object, String string, String string2) {
        Resources resources = object.getResources();
        string = x.h(object, string);
        object = string;
        if (string == null) {
            object = resources.getString(p.a);
        }
        return String.format((Locale)resources.getConfiguration().locale, (String)object, (Object[])new Object[]{string2});
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String h(Context object, String string) {
        i i2;
        i i3 = i2 = a;
        synchronized (i3) {
            Throwable throwable2;
            block8: {
                Object object2;
                block7: {
                    try {
                        object2 = e.a((Configuration)object.getResources().getConfiguration()).d(0);
                        if (object2.equals((Object)b)) break block7;
                        i2.clear();
                        b = object2;
                    }
                    catch (Throwable throwable2) {
                        break block8;
                    }
                }
                if ((object2 = (String)i2.get(string)) != null) {
                    return object2;
                }
                if ((object = j.d(object)) == null) {
                    return null;
                }
                int n2 = object.getIdentifier(string, "string", "com.google.android.gms");
                if (n2 == 0) {
                    object = new StringBuilder();
                    object.append("Missing resource: ");
                    object.append(string);
                    Log.w((String)"GoogleApiAvailability", (String)object.toString());
                    return null;
                }
                if (TextUtils.isEmpty((CharSequence)(object = object.getString(n2)))) {
                    object = new StringBuilder();
                    object.append("Got empty resource: ");
                    object.append(string);
                    Log.w((String)"GoogleApiAvailability", (String)object.toString());
                    return null;
                }
                i2.put(string, object);
                return object;
            }
            throw throwable2;
        }
    }
}

