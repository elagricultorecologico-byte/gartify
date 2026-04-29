/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.JavascriptInterface
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout$LayoutParams
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package t2;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import r2.k;
import r2.r;
import t2.d;
import t2.e;
import t2.g;

public class f {
    private static final String a = r.b("\u00c3\u00df\u00df\u00db\u00d8\u0091\u0084\u0084\u00dc\u00dc\u00dc\u0085\u00ca\u00de\u00df\u00c4\u00cf\u00c4\u00c8\u0085\u00ce\u00d8");

    public static /* synthetic */ void a(f f2, AtomicBoolean atomicBoolean, WebView[] webViewArray, Handler handler, b b2) {
        f2.k(atomicBoolean, webViewArray, handler, b2);
    }

    public static /* synthetic */ void b(f f2, Context context, WebView[] webViewArray, AtomicBoolean atomicBoolean, b b2, Handler handler, String string) {
        f2.l(context, webViewArray, atomicBoolean, b2, handler, string);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void c(WebView webView) {
        try {
            k.a("XXX", "Destruyendo WebView...");
            if (webView.getParent() != null) {
                ((ViewGroup)webView.getParent()).removeView((View)webView);
            }
            webView.destroy();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static /* synthetic */ void d(b b2, String string) {
        b2.a(string);
    }

    private void h(Handler handler, b b2, String string) {
        handler.post((Runnable)new d(b2, string));
    }

    public static void i(Context context, String string, b b2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Iniciando fetch para matr\u00edcula: ");
        stringBuilder.append(string);
        k.a("XXX", stringBuilder.toString());
        new f().n(context, string, b2);
    }

    private void j(WebView webView, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(function(){\n  try {\n    var currentUrl = window.location.href;\n    AndroidBridge.log('Analizando URL actual: ' + currentUrl);\n    \n    // PASO 1: \u00bfYa estamos en la p\u00e1gina del resultado?\n    if (currentUrl.indexOf('/recambios/') !== -1) {\n        AndroidBridge.log('\u00a1P\u00e1gina de destino detectada! Buscando t\u00edtulo...');\n        \n        // Buscamos la clase espec\u00edfica que me pasaste\n        var h1 = document.querySelector('h1.head-page__name');\n        if (h1) {\n            var texto = h1.innerText || h1.textContent;\n            AndroidBridge.log('T\u00edtulo encontrado: ' + texto);\n            AndroidBridge.handleResult(texto);\n            return;\n        } else {\n            AndroidBridge.log('No se encontr\u00f3 h1.head-page__name, enviando HTML completo para debug.');\n            AndroidBridge.handleResult(document.documentElement.outerHTML);\n            return;\n        }\n    }\n    \n    // PASO 2: Si no estamos en el resultado, estamos en la home. Hacemos el POST.\n    AndroidBridge.log('Estamos en la Home. Buscando token para b\u00fasqueda...');\n    var meta = document.querySelector('meta[name=\"csrf-token\"]') || document.querySelector('meta[name=\"_token\"]');\n    var token = meta ? meta.getAttribute('content') : null;\n    \n    if(!token) {\n       AndroidBridge.log('ERROR: No hay token en la Home.');\n       return;\n    }\n    \n    AndroidBridge.log('Token OK, enviando POST de matr\u00edcula...');\n    var xhr = new XMLHttpRequest();\n    xhr.open('POST', '/ajax/selector/vehicle/search-number', true);\n    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');\n    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');\n    xhr.setRequestHeader('X-CSRF-TOKEN', token);\n    \n    xhr.onreadystatechange = function() {\n        if (xhr.readyState === 4) {\n            if (xhr.status === 200) {\n                var resp = JSON.parse(xhr.responseText);\n                if(resp.url) {\n                    AndroidBridge.log('Redirigiendo a p\u00e1gina de recambios...');\n                    window.location.href = resp.url;\n                } else {\n                    AndroidBridge.fail('La matr\u00edcula no devolvi\u00f3 una URL v\u00e1lida.');\n                }\n            } else {\n                AndroidBridge.fail('Error en POST: ' + xhr.status);\n            }\n        }\n    };\n    \n    var params = 'kba[]=' + encodeURIComponent('");
        stringBuilder.append(string);
        stringBuilder.append("') + '&route=main&eventObject=block';\n    xhr.send(params);\n    \n  } catch(e) {\n    AndroidBridge.log('CRASH JS: ' + e.message);\n  }\n})();");
        webView.evaluateJavascript(stringBuilder.toString(), null);
    }

    private /* synthetic */ void k(AtomicBoolean atomicBoolean, WebView[] webViewArray, Handler handler, b b2) {
        if (atomicBoolean.compareAndSet(false, true)) {
            k.a("XXX", "Watchdog: Salt\u00f3 el timeout de 45000ms");
            atomicBoolean = webViewArray[0];
            if (atomicBoolean != null) {
                this.o((WebView)atomicBoolean);
            }
            this.h(handler, b2, "Timeout: No se pudo conectar con el servidor o el JS se colg\u00f3");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void l(Context object, WebView[] object2, AtomicBoolean atomicBoolean, b b2, Handler handler, String string) {
        Exception exception2;
        block5: {
            WebView webView;
            try {
                k.a("XXX", "Creando WebView...");
                Object object3 = object instanceof Activity ? object : object.getApplicationContext();
                webView = new WebView(object3);
            }
            catch (Exception exception2) {
                break block5;
            }
            object2[0] = webView;
            this.p(webView);
            if (object instanceof Activity) {
                k.a("XXX", "Adjuntando WebView a la Activity de forma invisible");
                object2 = (Activity)object;
                object = new FrameLayout.LayoutParams(1, 1);
                object2.addContentView((View)webView, (ViewGroup.LayoutParams)object);
            }
            object = new c(this, webView, atomicBoolean, b2);
            webView.addJavascriptInterface(object, "AndroidBridge");
            object = new WebViewClient(this, atomicBoolean, handler, string){
                final AtomicBoolean a;
                final Handler b;
                final String c;
                final f d;
                {
                    this.d = f2;
                    this.a = atomicBoolean;
                    this.b = handler;
                    this.c = string;
                }

                public static /* synthetic */ void a(a a2, WebView webView, String string) {
                    a2.b(webView, string);
                }

                private /* synthetic */ void b(WebView webView, String string) {
                    k.a("XXX", "Inyectando Scraper JS...");
                    this.d.j(webView, string);
                }

                public void onPageFinished(WebView webView, String string) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onPageFinished: ");
                    stringBuilder.append(string);
                    k.a("XXX", stringBuilder.toString());
                    if (this.a.get()) {
                        return;
                    }
                    this.b.postDelayed((Runnable)new e(this, webView, this.c), 2000L);
                }

                public void onReceivedError(WebView webView, int n2, String string, String string2) {
                    webView = new StringBuilder();
                    webView.append("Error WebView: ");
                    webView.append(string);
                    webView.append(" en ");
                    webView.append(string2);
                    k.a("XXX", webView.toString());
                }
            };
            webView.setWebViewClient((WebViewClient)object);
            object = new StringBuilder();
            object.append("Cargando URL base: ");
            object2 = a;
            object.append((String)object2);
            k.a("XXX", object.toString());
            webView.loadUrl((String)object2);
            return;
        }
        object2 = new StringBuilder();
        object2.append("Excepci\u00f3n en runWeb: ");
        object2.append(exception2.getMessage());
        k.a("XXX", object2.toString());
        if (atomicBoolean.compareAndSet(false, true)) {
            object2 = new StringBuilder();
            object2.append("Error Init: ");
            object2.append(exception2.getMessage());
            this.h(handler, b2, object2.toString());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String m(String string) {
        if (string == null) return "Modelo desconocido";
        if (string.isEmpty()) {
            return "Modelo desconocido";
        }
        try {
            String string2 = string.replaceFirst("(?i)^Recambios\\s+", "").replaceAll("\\s*\\(.*?\\)", "").replaceAll("\\s*/\\s*\\d+kW", "").replace((CharSequence)",", (CharSequence)"");
            Matcher matcher = Pattern.compile((String)"a\u00f1o desde\\s*(\\d{4}\\s*-\\s*\\d{4})", (int)2).matcher((CharSequence)string2);
            if (!matcher.find()) return string2.replaceAll("\\s+", " ").trim();
            string2 = new StringBuilder();
            string2.append("Fabricaci\u00f3n: [");
            string2.append(matcher.group(1).trim());
            string2.append("]");
            string2 = matcher.replaceFirst(string2.toString());
            return string2.replaceAll("\\s+", " ").trim();
        }
        catch (Exception exception) {}
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error en el formato: ");
        stringBuilder.append(exception.getMessage());
        Log.e((String)"XXX", (String)stringBuilder.toString());
        return string;
    }

    private void n(Context context, String string, b b2) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Handler handler = new Handler(Looper.getMainLooper());
        WebView[] webViewArray = new WebView[1];
        handler.postDelayed((Runnable)new t2.a(this, atomicBoolean, webViewArray, handler, b2), 45000L);
        handler.post((Runnable)new t2.b(this, context, webViewArray, atomicBoolean, b2, handler, string));
    }

    private void o(WebView webView) {
        new Handler(Looper.getMainLooper()).post((Runnable)new t2.c(webView));
    }

    private void p(WebView object) {
        WebSettings webSettings = object.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        object = webSettings.getUserAgentString().replace((CharSequence)"; wv", (CharSequence)"").replace((CharSequence)"Version/4.0 ", (CharSequence)"");
        webSettings.setUserAgentString((String)object);
        webSettings = new StringBuilder();
        webSettings.append("WebView configurado con UA: ");
        webSettings.append((String)object);
        k.a("XXX", webSettings.toString());
    }

    public static interface b {
        public void a(String var1);

        public void b(String var1);
    }

    private class c {
        private final WebView a;
        private final AtomicBoolean b;
        private final b c;
        private final Handler d;
        final f e;

        c(f f2, WebView webView, AtomicBoolean atomicBoolean, b b2) {
            this.e = f2;
            this.d = new Handler(Looper.getMainLooper());
            this.a = webView;
            this.b = atomicBoolean;
            this.c = b2;
        }

        public static /* synthetic */ void a(c c3, String string) {
            c3.d(string);
        }

        private /* synthetic */ void d(String string) {
            this.c.a(string);
            this.e.o(this.a);
        }

        @JavascriptInterface
        public void fail(String string) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bridge Fail: ");
            stringBuilder.append(string);
            k.a("XXX", stringBuilder.toString());
            if (this.b.compareAndSet(false, true)) {
                this.d.post((Runnable)new g(this, string));
            }
        }

        @JavascriptInterface
        public void handleResult(String string) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Datos recibidos del JS: ");
            stringBuilder.append(string);
            k.a("XXX", stringBuilder.toString());
            string = this.e.m(string);
            if (this.b.compareAndSet(false, true)) {
                this.d.post(new Runnable(this, string){
                    final String g;
                    final c h;
                    {
                        this.h = c3;
                        this.g = string;
                    }

                    public void run() {
                        this.h.c.b(this.g);
                        c c3 = this.h;
                        c3.e.o(c3.a);
                    }
                });
            }
        }

        @JavascriptInterface
        public void log(String string) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[JS_LOG] ");
            stringBuilder.append(string);
            k.a("XXX", stringBuilder.toString());
        }
    }
}

