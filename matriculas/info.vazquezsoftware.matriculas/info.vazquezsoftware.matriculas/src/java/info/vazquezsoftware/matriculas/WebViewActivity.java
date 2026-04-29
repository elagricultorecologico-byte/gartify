/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.MenuItem
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  androidx.appcompat.app.d
 *  java.lang.Object
 *  java.lang.String
 */
package info.vazquezsoftware.matriculas;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.d;

public class WebViewActivity
extends d {
    protected void onCreate(Bundle object) {
        super.onCreate(object);
        this.setContentView(2131492900);
        this.c0().r(true);
        object = this.getIntent().getStringExtra("url");
        WebView webView = (WebView)this.findViewById(2131296874);
        webView.setVisibility(0);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl((String)object);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.finish();
        return true;
    }
}

