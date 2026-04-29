/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 *  f1.p
 *  java.lang.CharSequence
 *  java.lang.ClassCastException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package b1;

import B1.e;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import f1.p;

public final class u1
extends ContentProvider {
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        block19: {
            Bundle bundle;
            block17: {
                String string;
                block15: {
                    block18: {
                        Object object;
                        block16: {
                            block13: {
                                NullPointerException nullPointerException2;
                                block14: {
                                    bundle = null;
                                    try {
                                        bundle = object = e.a((Context)context).c((String)context.getPackageName(), (int)128).metaData;
                                        break block13;
                                    }
                                    catch (PackageManager.NameNotFoundException nameNotFoundException) {
                                    }
                                    catch (NullPointerException nullPointerException2) {
                                        break block14;
                                    }
                                    p.d((String)"Failed to load metadata: Package name not found.", (Throwable)nameNotFoundException);
                                    break block13;
                                }
                                p.d((String)"Failed to load metadata: Null pointer exception.", (Throwable)nullPointerException2);
                            }
                            if (bundle != null) break block16;
                            p.c((String)"Metadata was null.");
                            break block17;
                        }
                        try {
                            object = (String)bundle.get("com.google.android.gms.ads.APPLICATION_ID");
                        }
                        catch (ClassCastException classCastException) {
                            throw new IllegalStateException("The com.google.android.gms.ads.APPLICATION_ID metadata must have a String value.", (Throwable)classCastException);
                        }
                        try {
                            string = (String)bundle.get("com.google.android.gms.ads.INTEGRATION_MANAGER");
                            if (object == null) break block15;
                        }
                        catch (ClassCastException classCastException) {
                            throw new IllegalStateException("The com.google.android.gms.ads.INTEGRATION_MANAGER metadata must have a String value.", (Throwable)classCastException);
                        }
                        if (!object.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$")) break block18;
                        p.a((String)"Publisher provided Google AdMob App ID in manifest: ".concat((String)object));
                        break block17;
                    }
                    throw new IllegalStateException("\n\n******************************************************************************\n* Invalid application ID. Follow instructions here:                          *\n* https://goo.gle/admob-android-update-manifest                              *\n* to find your app ID.                                                       *\n* Google Ad Manager publishers should follow instructions here:              *\n* https://goo.gle/ad-manager-android-update-manifest.                        *\n******************************************************************************\n\n");
                }
                if (TextUtils.isEmpty((CharSequence)string)) break block19;
                p.a((String)"The Google Mobile Ads SDK is integrated by ".concat(String.valueOf((Object)string)));
            }
            if (bundle != null) {
                boolean bl = bundle.getBoolean("com.google.android.gms.ads.flag.OPTIMIZE_INITIALIZATION", false);
                boolean bl2 = bundle.getBoolean("com.google.android.gms.ads.flag.OPTIMIZE_AD_LOADING", false);
                if (bl) {
                    p.a((String)"com.google.android.gms.ads.flag.OPTIMIZE_INITIALIZATION is enabled");
                }
                if (bl2) {
                    p.a((String)"com.google.android.gms.ads.flag.OPTIMIZE_AD_LOADING is enabled");
                }
            }
            super.attachInfo(context, providerInfo);
            return;
        }
        throw new IllegalStateException("\n\n******************************************************************************\n* Missing application ID. AdMob publishers should follow the instructions    *\n* here:                                                                      *\n* https://goo.gle/admob-android-update-manifest.                             *\n* to add a valid App ID inside the AndroidManifest.                          *\n* Google Ad Manager publishers should follow instructions here:              *\n* https://goo.gle/ad-manager-android-update-manifest.                        *\n******************************************************************************\n\n");
    }

    public final int delete(Uri uri, String string, String[] stringArray) {
        return 0;
    }

    public final String getType(Uri uri) {
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final boolean onCreate() {
        return false;
    }

    public final Cursor query(Uri uri, String[] stringArray, String string, String[] stringArray2, String string2) {
        return null;
    }

    public final int update(Uri uri, ContentValues contentValues, String string, String[] stringArray) {
        return 0;
    }
}

