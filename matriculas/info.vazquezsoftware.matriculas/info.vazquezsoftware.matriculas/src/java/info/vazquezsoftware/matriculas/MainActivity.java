/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Color
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Vibrator
 *  android.text.SpannableString
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.Button
 *  android.widget.EditText
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.activity.q
 *  androidx.appcompat.app.b
 *  androidx.appcompat.app.d
 *  androidx.appcompat.widget.Toolbar
 *  androidx.drawerlayout.widget.DrawerLayout
 *  androidx.drawerlayout.widget.DrawerLayout$e
 *  androidx.lifecycle.p
 *  com.google.android.material.navigation.NavigationView
 *  com.google.android.material.navigation.NavigationView$d
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package info.vazquezsoftware.matriculas;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.b;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import info.vazquezsoftware.matriculas.ClasificacionActivity;
import info.vazquezsoftware.matriculas.ExportarActivity;
import info.vazquezsoftware.matriculas.InformacionActivity;
import info.vazquezsoftware.matriculas.MatriculasActivity;
import info.vazquezsoftware.matriculas.PremiumActivity;
import info.vazquezsoftware.matriculas.WebViewActivity;
import r2.l;
import r2.n;
import r2.o;
import r2.p;
import r2.q;
import s2.a;
import s2.c;

public class MainActivity
extends d
implements NavigationView.d {
    public static String M = "key_matricula";
    public static String N = "key_favorito";
    private static n O;
    private static String P;
    private EditText I;
    private Toast J;
    private long K = 0L;
    private LinearLayout L;

    public static /* synthetic */ void o0(Dialog dialog, View view) {
        dialog.dismiss();
    }

    private NavigationView p0() {
        NavigationView navigationView = (NavigationView)this.findViewById(2131296619);
        navigationView.setNavigationItemSelectedListener((NavigationView.d)this);
        MenuItem menuItem = navigationView.getMenu().findItem(2131296610);
        if (menuItem != null) {
            SpannableString spannableString = new SpannableString(menuItem.getTitle());
            spannableString.setSpan((Object)new q(Color.parseColor((String)"#FF9800"), -16777216), 0, spannableString.length(), 0);
            menuItem.setTitle((CharSequence)spannableString);
        }
        return navigationView;
    }

    private static void q0(Context context, n n2, String string) {
        context.startActivity(new Intent(context, InformacionActivity.class).putExtra(M, n2.l(string)));
    }

    private void r0() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)"https://play.google.com/store/apps/developer?id=V%C3%A1zquez+Software"));
        try {
            this.startActivity(intent);
            return;
        }
        catch (Exception exception) {
            intent.setData(Uri.parse((String)"https://play.google.com/store/apps/developer?id=V%C3%A1zquez+Software"));
            return;
        }
    }

    private void s0(View view) {
        InputMethodManager inputMethodManager;
        if (view != null && (inputMethodManager = (InputMethodManager)this.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void t0() {
        androidx.activity.q q2 = new androidx.activity.q(this, true){
            final MainActivity d;
            {
                this.d = mainActivity;
                super(bl);
            }

            public void d() {
                a.m = true;
                this.d.finish();
            }
        };
        this.c().h((androidx.lifecycle.p)this, q2);
    }

    private void u0() {
        new c((Activity)this, (ViewGroup)this.findViewById(2131296544), this.getString(2131886110), null).j();
    }

    private void v0() {
        Dialog dialog = new Dialog((Context)this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(2131492922);
        ((TextView)dialog.findViewById(2131296848)).setText(2131886117);
        dialog.setCancelable(false);
        ((Button)dialog.findViewById(2131296369)).setOnClickListener((View.OnClickListener)new l(dialog));
        dialog.show();
        dialog.getWindow().setLayout(-1, -2);
        this.t0();
    }

    public boolean i(MenuItem menuItem) {
        int n2 = menuItem.getItemId();
        if (n2 == 2131296617) {
            a.m = false;
            this.startActivity(new Intent((Context)this, PremiumActivity.class));
        } else if (n2 == 2131296616) {
            a.m = false;
            this.r0();
        } else if (n2 == 2131296610) {
            a.m = false;
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("market://details?id=");
                stringBuilder.append("info.vazquezsoftware.gasolineras");
                menuItem = new Intent("android.intent.action.VIEW", Uri.parse((String)stringBuilder.toString()));
                this.startActivity((Intent)menuItem);
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("https://play.google.com/store/apps/details?id=");
                stringBuilder.append("info.vazquezsoftware.gasolineras");
                this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)stringBuilder.toString())));
            }
        } else if (n2 == 2131296612) {
            this.startActivity(new Intent((Context)this, ClasificacionActivity.class));
        } else if (n2 == 2131296615) {
            this.startActivity(new Intent((Context)this, MatriculasActivity.class).putExtra(N, 1));
        } else if (n2 == 2131296614) {
            this.startActivity(new Intent((Context)this, ExportarActivity.class));
        } else if (n2 == 2131296613) {
            menuItem = new Intent((Context)this, WebViewActivity.class);
            menuItem.putExtra("url", "https://www.google.com/maps/@39.3651063,-2.1013684,5.47z/data=!5m1!1e1");
            this.startActivity((Intent)menuItem);
        } else if (n2 == 2131296618) {
            a.m = false;
            menuItem = new Intent((Context)this, WebViewActivity.class);
            menuItem.putExtra("url", "https://sites.google.com/view/vazquezsoftware");
            this.startActivity((Intent)menuItem);
        } else if (n2 == 2131296611) {
            this.v0();
        }
        ((DrawerLayout)this.findViewById(2131296447)).d(0x800003);
        return true;
    }

    public void onClickBorrar(View view) {
        this.I.setText(null);
    }

    public void onClickBuscar(View object) {
        if (!o.b((Context)this) && o.a((Context)this)) {
            object = this.I.getText().toString();
            P = object;
            if (O.l((String)object).length() >= 3 && O.o(P) != -1) {
                long l2 = System.currentTimeMillis() - this.K;
                if (l2 < 10000L) {
                    this.x0(this.getString(2131886164, new Object[]{10L - l2 / 1000L}));
                    ((Vibrator)this.getSystemService("vibrator")).vibrate(100L);
                    return;
                }
                this.K = System.currentTimeMillis();
                MainActivity.q0((Context)this, O, P);
                return;
            }
            this.w0(2131886255);
            ((Vibrator)this.getSystemService("vibrator")).vibrate(100L);
            this.s0(this.getCurrentFocus());
            return;
        }
        this.w0(2131886334);
        ((Vibrator)this.getSystemService("vibrator")).vibrate(100L);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131492897);
        this.L = (LinearLayout)this.findViewById(2131296544);
        if (InformacionActivity.e0 != null && !p.f((Context)this)) {
            InformacionActivity.e0.l((Context)this);
        }
        this.I = (EditText)this.findViewById(2131296464);
        Toolbar toolbar = (Toolbar)this.findViewById(2131296815);
        this.l0(toolbar);
        bundle = (DrawerLayout)this.findViewById(2131296447);
        toolbar = new b((Activity)this, (DrawerLayout)bundle, toolbar, 2131886333, 2131886332);
        bundle.a((DrawerLayout.e)toolbar);
        toolbar.i();
        toolbar = this.p0();
        O = new n((Context)this);
        if (!p.f((Context)this)) {
            this.u0();
        } else {
            toolbar.getMenu().findItem(2131296617).setVisible(false);
            this.L.setVisibility(8);
        }
        this.c().h((androidx.lifecycle.p)this, new androidx.activity.q(this, true, (DrawerLayout)bundle){
            final DrawerLayout d;
            final MainActivity e;
            {
                this.e = mainActivity;
                this.d = drawerLayout;
                super(bl);
            }

            public void d() {
                if (this.d.C(0x800003)) {
                    this.d.d(0x800003);
                    return;
                }
                this.e.finish();
            }
        });
        this.invalidateOptionsMenu();
        if (p.e((Context)this)) {
            this.v0();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        menuItem.getItemId();
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onRestart() {
        super.onRestart();
        if (InformacionActivity.e0 != null && !p.f((Context)this)) {
            InformacionActivity.e0.l((Context)this);
        }
    }

    public void w0(int n2) {
        Toast toast = this.J;
        if (toast != null) {
            toast.cancel();
        }
        this.J = toast = Toast.makeText((Context)this, (int)n2, (int)0);
        toast.show();
    }

    public void x0(String string) {
        Toast toast = this.J;
        if (toast != null) {
            toast.cancel();
        }
        string = Toast.makeText((Context)this, (CharSequence)string, (int)0);
        this.J = string;
        string.show();
    }
}

