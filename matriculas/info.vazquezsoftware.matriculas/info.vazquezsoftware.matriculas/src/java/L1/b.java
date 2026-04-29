/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.webkit.WebView
 *  com.google.android.gms.internal.ads.Hi
 *  java.lang.Object
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONObject
 */
package l1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.Hi;
import f1.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class b {
    private final Context a;
    private final ApplicationInfo b;
    private final List c;
    private final a d;
    private final JSONObject e = new JSONObject();
    private final AtomicBoolean f = new AtomicBoolean(false);

    b(Context context, Hi hi, List list, a a2) {
        this.a = context;
        this.b = context.getApplicationInfo();
        this.c = list;
        this.d = a2;
    }

    /*
     * Exception decompiling
     */
    public final void a(WebView var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 3[TRYBLOCK] [3 : 95->101)] org.json.JSONException
         *     at fc.i.L0(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:227)
         *     at dc.f.b(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:196)
         *     at dc.f.c(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
         *     at dc.f.a(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:157)
         *     at md.e.l(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
         *     at kd.k.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
         *     at kd.f.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:179)
         *     at og.h.r0(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:235)
         *     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithCFR(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:784)
         *     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:141)
         *     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:3)
         *     at z6.a.run(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
         *     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1154)
         *     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:652)
         *     at java.lang.Thread.run(Thread.java:1564)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final JSONObject b() {
        if (!this.f.get()) {
            this.a(null);
        }
        return this.e;
    }
}

