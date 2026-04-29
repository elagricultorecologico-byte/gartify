/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentProviderClient
 *  android.content.ContentUris
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.content.pm.Signature
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.CancellationSignal
 *  android.os.RemoteException
 *  android.util.Log
 *  androidx.core.content.res.e
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 */
package C;

import C.d;
import C.f;
import C.i;
import C.k;
import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

abstract class e {
    private static final Comparator a = new C.c();

    public static /* synthetic */ int a(byte[] byArray, byte[] byArray2) {
        if (byArray.length != byArray2.length) {
            return byArray.length - byArray2.length;
        }
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            byte by = byArray[i2];
            byte by2 = byArray2[i2];
            if (by == by2) continue;
            return by - by2;
        }
        return 0;
    }

    private static List b(Signature[] signatureArray) {
        ArrayList arrayList = new ArrayList();
        int n2 = signatureArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add((Object)signatureArray[i2].toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if (Arrays.equals((byte[])((byte[])list.get(i2)), (byte[])((byte[])list2.get(i2)))) continue;
            return false;
        }
        return true;
    }

    private static List d(i i2, Resources resources) {
        if (i2.b() != null) {
            return i2.b();
        }
        return androidx.core.content.res.e.c((Resources)resources, (int)i2.c());
    }

    static k.a e(Context context, i i2, CancellationSignal cancellationSignal) {
        ProviderInfo providerInfo = e.f(context.getPackageManager(), i2, context.getResources());
        if (providerInfo == null) {
            return k.a.a(1, null);
        }
        return k.a.a(0, e.g(context, i2, providerInfo.authority, cancellationSignal));
    }

    static ProviderInfo f(PackageManager packageManager, i i2, Resources resources) {
        String string = i2.e();
        ProviderInfo providerInfo = packageManager.resolveContentProvider(string, 0);
        if (providerInfo != null) {
            if (providerInfo.packageName.equals((Object)i2.f())) {
                packageManager = e.b(packageManager.getPackageInfo((String)providerInfo.packageName, (int)64).signatures);
                Collections.sort((List)packageManager, (Comparator)a);
                i2 = e.d(i2, resources);
                for (int i3 = 0; i3 < i2.size(); ++i3) {
                    resources = new ArrayList((Collection)i2.get(i3));
                    Collections.sort((List)resources, (Comparator)a);
                    if (!e.c((List)packageManager, (List)resources)) continue;
                    return providerInfo;
                }
                return null;
            }
            packageManager = new StringBuilder();
            packageManager.append("Found content provider ");
            packageManager.append(string);
            packageManager.append(", but package was not ");
            packageManager.append(i2.f());
            throw new PackageManager.NameNotFoundException(packageManager.toString());
        }
        packageManager = new StringBuilder();
        packageManager.append("No package found for authority: ");
        packageManager.append(string);
        throw new PackageManager.NameNotFoundException(packageManager.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static k.b[] g(Context object, i object2, String object3, CancellationSignal cancellationSignal) {
        block18: {
            block20: {
                int n2;
                int n3;
                int n4;
                int n5;
                int n6;
                int n7;
                Object object4;
                Uri uri;
                Uri uri2;
                block17: {
                    ArrayList arrayList;
                    block16: {
                        arrayList = new ArrayList();
                        uri2 = new Uri.Builder().scheme("content").authority((String)object3).build();
                        uri = new Uri.Builder().scheme("content").authority((String)object3).appendPath("file").build();
                        object = d.a((Context)object, uri2);
                        Object var17_8 = null;
                        object3 = var17_8;
                        object4 = object;
                        try {
                            object2 = ((i)object2).g();
                            object3 = var17_8;
                            object4 = object;
                            object2 = object.a(uri2, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{object2}, null, cancellationSignal);
                            if (object2 == null) break block16;
                            object3 = object2;
                            object4 = object;
                            if (object2.getCount() <= 0) break block16;
                            object3 = object2;
                            object4 = object;
                            n7 = object2.getColumnIndex("result_code");
                            object3 = object2;
                            object4 = object;
                            object3 = object2;
                            object4 = object;
                            cancellationSignal = new ArrayList();
                            object3 = object2;
                            object4 = object;
                            n6 = object2.getColumnIndex("_id");
                            object3 = object2;
                            object4 = object;
                            n5 = object2.getColumnIndex("file_id");
                            object3 = object2;
                            object4 = object;
                            n4 = object2.getColumnIndex("font_ttc_index");
                            object3 = object2;
                            object4 = object;
                            n3 = object2.getColumnIndex("font_weight");
                            object3 = object2;
                            object4 = object;
                            n2 = object2.getColumnIndex("font_italic");
                            break block17;
                        }
                        catch (Throwable throwable) {
                            object2 = object3;
                            object3 = object4;
                            break block18;
                        }
                    }
                    object3 = arrayList;
                    break block20;
                }
                while (true) {
                    boolean bl;
                    int n8;
                    int n9;
                    int n10;
                    block22: {
                        block21: {
                            block19: {
                                object3 = object2;
                                object4 = object;
                                if (!object2.moveToNext()) break;
                                if (n7 != -1) {
                                    object3 = object2;
                                    object4 = object;
                                    n10 = object2.getInt(n7);
                                } else {
                                    n10 = 0;
                                }
                                if (n4 != -1) {
                                    object3 = object2;
                                    object4 = object;
                                    n9 = object2.getInt(n4);
                                } else {
                                    n9 = 0;
                                }
                                if (n5 == -1) {
                                    try {
                                        object3 = ContentUris.withAppendedId((Uri)uri2, (long)object2.getLong(n6));
                                        break block19;
                                    }
                                    catch (Throwable throwable) {
                                        object3 = object;
                                        object = throwable;
                                        break block18;
                                    }
                                }
                                object3 = ContentUris.withAppendedId((Uri)uri, (long)object2.getLong(n5));
                            }
                            n8 = n3 != -1 ? object2.getInt(n3) : 400;
                            if (n2 == -1) break block21;
                            int n11 = object2.getInt(n2);
                            bl = true;
                            if (n11 == 1) break block22;
                        }
                        bl = false;
                    }
                    cancellationSignal.add((Object)k.b.a((Uri)object3, n9, n8, bl, n10));
                }
                object3 = cancellationSignal;
            }
            if (object2 != null) {
                object2.close();
            }
            object.close();
            return (k.b[])object3.toArray((Object[])new k.b[0]);
        }
        if (object2 != null) {
            object2.close();
        }
        object3.close();
        throw object;
    }

    private static interface a {
        public Cursor a(Uri var1, String[] var2, String var3, String[] var4, String var5, CancellationSignal var6);

        public void close();
    }

    private static class b
    implements a {
        private final ContentProviderClient a;

        b(Context context, Uri uri) {
            this.a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override
        public Cursor a(Uri uri, String[] stringArray, String string, String[] stringArray2, String string2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                uri = contentProviderClient.query(uri, stringArray, string, stringArray2, string2, cancellationSignal);
                return uri;
            }
            catch (RemoteException remoteException) {
                Log.w((String)"FontsProvider", (String)"Unable to query the content provider", (Throwable)remoteException);
                return null;
            }
        }

        @Override
        public void close() {
            ContentProviderClient contentProviderClient = this.a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    private static class c
    implements a {
        private final ContentProviderClient a;

        c(Context context, Uri uri) {
            this.a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override
        public Cursor a(Uri uri, String[] stringArray, String string, String[] stringArray2, String string2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                uri = contentProviderClient.query(uri, stringArray, string, stringArray2, string2, cancellationSignal);
                return uri;
            }
            catch (RemoteException remoteException) {
                Log.w((String)"FontsProvider", (String)"Unable to query the content provider", (Throwable)remoteException);
                return null;
            }
        }

        @Override
        public void close() {
            ContentProviderClient contentProviderClient = this.a;
            if (contentProviderClient != null) {
                f.a(contentProviderClient);
            }
        }
    }
}

