/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.ParcelFileDescriptor
 *  android.os.Parcelable
 *  android.view.MenuItem
 *  android.view.View
 *  android.widget.Button
 *  android.widget.TextView
 *  android.widget.Toast
 *  androidx.activity.q
 *  androidx.appcompat.app.d
 *  androidx.lifecycle.p
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.io.PrintWriter
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  v2.a
 */
package info.vazquezsoftware.matriculas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.q;
import androidx.appcompat.app.d;
import androidx.lifecycle.p;
import e.c;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import r2.m;
import r2.n;
import r2.t;
import s2.a;

public class ExportarActivity
extends d {
    private n I;
    private TextView J;
    private Button K;
    private Button L;
    private ArrayList M;
    private String N;
    d.c O = this.O(new c(), new r2.a(this));

    public static /* synthetic */ void o0(ExportarActivity exportarActivity, d.a a2) {
        exportarActivity.s0(a2);
    }

    private String p0(int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            if (n2 != 5) {
                                return null;
                            }
                            return this.getString(2131886136);
                        }
                        return this.getString(2131886132);
                    }
                    return this.getString(2131886133);
                }
                return this.getString(2131886135);
            }
            return this.getString(2131886134);
        }
        return this.getString(2131886186);
    }

    private void q0() {
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("application/vnd.ms-excel");
        intent.putExtra("android.intent.extra.TITLE", "matriculas.xls");
        this.O.a(intent);
    }

    private String r0(String string) {
        int n2 = this.I.o(string);
        if (n2 == 0) {
            return this.I.i(string);
        }
        if (n2 == 1) {
            return this.I.k(string);
        }
        if (n2 == 2) {
            return this.I.j(string);
        }
        return null;
    }

    private /* synthetic */ void s0(d.a a2) {
        if (a2.b() == -1 && (a2 = a2.a()) != null) {
            if ((a2 = a2.getData()) != null) {
                this.N = a2.toString();
                this.u0((Uri)a2);
                return;
            }
            Toast.makeText((Context)this, (int)2131886179, (int)0).show();
        }
    }

    private void t0() {
        q q2 = new q(this, true){
            final ExportarActivity d;
            {
                this.d = exportarActivity;
                super(bl);
            }

            public void d() {
                a.m = false;
                this.d.finish();
            }
        };
        this.c().h((p)this, q2);
    }

    private void u0(Uri uri) {
        ParcelFileDescriptor parcelFileDescriptor = this.getContentResolver().openFileDescriptor(uri, "w");
        FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
        PrintWriter printWriter = new PrintWriter((OutputStream)fileOutputStream);
        printWriter.println("Matr\u00edcula;Modelo;Modelo Espec\u00edfico;Descripci\u00f3n;Energ\u00eda;Fecha;Fabricaci\u00f3n;Distintivo");
        parcelFileDescriptor = this.M;
        int n2 = parcelFileDescriptor.size();
        int n3 = 0;
        int n4 = 0;
        while (n4 < n2) {
            Object object = parcelFileDescriptor.get(n4);
            ++n4;
            m m2 = (m)object;
            object = new StringBuilder();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.r0(m2.h()));
            stringBuilder.append(";");
            object.append(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(m2.j());
            stringBuilder.append(";");
            object.append(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(m2.i());
            stringBuilder.append(";");
            object.append(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(m2.a());
            stringBuilder.append(";");
            object.append(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(m2.c());
            stringBuilder.append(";");
            object.append(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(m2.f());
            stringBuilder.append(";");
            object.append(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(m2.d());
            stringBuilder.append(";");
            object.append(stringBuilder.toString());
            object.append(this.p0(m2.b()));
            printWriter.println(object.toString().replaceAll("null", ""));
            ++n3;
        }
        try {
            printWriter.flush();
            printWriter.close();
            fileOutputStream.close();
            this.N = uri.toString();
            this.J.setText((CharSequence)this.getString(2131886206, new Object[]{n3, this.N}));
            this.K.setEnabled(false);
            this.L.setVisibility(0);
            return;
        }
        catch (IOException iOException) {
            Toast.makeText((Context)this, (int)2131886179, (int)0).show();
            return;
        }
    }

    public void onClickEnviar(View view) {
        view = new Intent("android.intent.action.SEND");
        view.setType("text/plain");
        view.putExtra("android.intent.extra.EMAIL", new String[]{""});
        view.putExtra("android.intent.extra.STREAM", (Parcelable)Uri.parse((String)this.N));
        view.putExtra("android.intent.extra.SUBJECT", this.getString(2131886199));
        this.startActivity(Intent.createChooser((Intent)view, (CharSequence)this.getString(2131886175)));
    }

    public void onClickExportar(View view) {
        a.m = false;
        if (this.M == null) {
            return;
        }
        this.q0();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131492893);
        t.b(this.findViewById(2131296704), 20);
        this.J = (TextView)this.findViewById(2131296839);
        this.K = (Button)this.findViewById(2131296371);
        this.L = (Button)this.findViewById(2131296370);
        this.c0().r(true);
        this.I = new n((Context)this);
        bundle = v2.a.j((Context)this).p(1);
        this.M = bundle;
        if (bundle == null) {
            this.J.setText(2131886336);
        } else {
            this.J.setText((CharSequence)this.getString(2131886205, new Object[]{bundle.size()}));
        }
        this.t0();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.finish();
        return true;
    }
}

