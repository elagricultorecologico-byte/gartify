/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.webkit.WebResourceError
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.google.android.gms.internal.ads.cd0
 *  e1.o0
 *  f1.p
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Objects
 */
package a1;

import a1.s;
import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.cd0;
import e1.o0;
import f1.p;
import java.util.Objects;

final class o
extends WebViewClient {
    final s a;

    o(s s2) {
        Objects.requireNonNull((Object)s2);
        this.a = s2;
    }

    public final void onReceivedError(WebView object, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        int n3;
        object = this.a;
        if (((s)object).R5() != null) {
            try {
                ((s)object).R5().g0(cd0.d((int)1, null, null));
            }
            catch (RemoteException remoteException) {
                n3 = o0.b;
                p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
            }
        }
        if (((s)(object = this.a)).R5() != null) {
            try {
                ((s)object).R5().i0(0);
            }
            catch (RemoteException remoteException) {
                n3 = o0.b;
                p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
            }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView object, String string) {
        object = this.a;
        if (string.startsWith(((s)object).O5())) {
            return false;
        }
        if (string.startsWith("gmsg://noAdLoaded")) {
            int n3;
            if (((s)object).R5() != null) {
                try {
                    ((s)object).R5().g0(cd0.d((int)3, null, null));
                }
                catch (RemoteException remoteException) {
                    n3 = o0.b;
                    p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
                }
            }
            if (((s)(object = this.a)).R5() != null) {
                try {
                    ((s)object).R5().i0(3);
                }
                catch (RemoteException remoteException) {
                    n3 = o0.b;
                    p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
                }
            }
            this.a.M5(0);
            return true;
        }
        if (string.startsWith("gmsg://scriptLoadFailed")) {
            int n4;
            object = this.a;
            if (((s)object).R5() != null) {
                try {
                    ((s)object).R5().g0(cd0.d((int)1, null, null));
                }
                catch (RemoteException remoteException) {
                    n4 = o0.b;
                    p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
                }
            }
            if (((s)(object = this.a)).R5() != null) {
                try {
                    ((s)object).R5().i0(0);
                }
                catch (RemoteException remoteException) {
                    n4 = o0.b;
                    p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
                }
            }
            this.a.M5(0);
            return true;
        }
        if (string.startsWith("gmsg://adResized")) {
            object = this.a;
            if (((s)object).R5() != null) {
                try {
                    ((s)object).R5().e();
                }
                catch (RemoteException remoteException) {
                    int n5 = o0.b;
                    p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
                }
            }
            object = this.a;
            ((s)object).M5(((s)object).L5(string));
            return true;
        }
        if (string.startsWith("gmsg://")) {
            return true;
        }
        object = this.a;
        if (((s)object).R5() != null) {
            try {
                ((s)object).R5().g();
                ((s)object).R5().c();
            }
            catch (RemoteException remoteException) {
                int n6 = o0.b;
                p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
            }
        }
        this.a.P5(string);
        return true;
    }
}

