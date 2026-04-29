/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.EditText
 *  android.widget.Toast
 *  androidx.appcompat.app.c$a
 *  androidx.appcompat.app.d
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$h
 *  androidx.recyclerview.widget.RecyclerView$p
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.ArrayList
 *  v2.a
 *  v2.b
 */
package info.vazquezsoftware.matriculas;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.appcompat.app.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import info.vazquezsoftware.matriculas.InformacionActivity;
import info.vazquezsoftware.matriculas.MainActivity;
import info.vazquezsoftware.matriculas.informeIA.InformeIAActivity;
import java.util.ArrayList;
import r2.b;
import r2.c;
import r2.m;
import v2.a;
import v2.b;

public class MatriculasActivity
extends d
implements b.a {
    private v2.b I;
    private a J;

    private void r0(View view) {
        if (view != null) {
            ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131492898);
        this.c0().r(true);
        this.J = a.j((Context)this);
        ArrayList arrayList = a.j((Context)this).p(this.getIntent().getIntExtra(MainActivity.N, 1));
        bundle = (RecyclerView)this.findViewById(2131296711);
        bundle.setLayoutManager((RecyclerView.p)new LinearLayoutManager((Context)this));
        arrayList = new v2.b((Context)this, arrayList);
        this.I = arrayList;
        arrayList.E((b.a)this);
        bundle.setAdapter((RecyclerView.h)this.I);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.finish();
        return true;
    }

    protected void onResume() {
        super.onResume();
        if (this.J != null && this.I != null) {
            int n2 = this.getIntent().getIntExtra(MainActivity.N, 1);
            ArrayList arrayList = this.J.p(n2);
            this.I.F(arrayList);
            this.I.j();
        }
    }

    @Override
    public void y(View object, int n2, ArrayList arrayList) {
        m m2 = this.I.B(n2);
        if (object.getId() == 2131296502) {
            this.J.f(m2.h());
            arrayList.remove(n2);
            this.I.m(n2);
            return;
        }
        if (object.getId() == 2131296503) {
            object = new c.a((Context)this);
            object.j(2131886165);
            m2 = new EditText((Context)this);
            m2.setInputType(16384);
            m2.setText(((m)arrayList.get(n2)).a());
            object.l((View)m2);
            object.h(2131886201, new DialogInterface.OnClickListener(this, (EditText)m2, arrayList, n2){
                final EditText g;
                final ArrayList h;
                final int i;
                final MatriculasActivity j;
                {
                    this.j = matriculasActivity;
                    this.g = editText;
                    this.h = arrayList;
                    this.i = n2;
                }

                public void onClick(DialogInterface object, int n2) {
                    object = this.g.getText().toString();
                    ((m)this.h.get(this.i)).k((String)object);
                    this.j.J.A((m)this.h.get(this.i));
                    this.j.I.j();
                    object = this.j;
                    ((MatriculasActivity)object).r0(object.getCurrentFocus());
                    Toast.makeText((Context)this.j, (int)2131886254, (int)0).show();
                }
            });
            object.f(2131886131, new DialogInterface.OnClickListener(this){
                final MatriculasActivity g;
                {
                    this.g = matriculasActivity;
                }

                public void onClick(DialogInterface dialogInterface, int n2) {
                }
            });
            object.m();
            return;
        }
        if (object.getId() == 2131296706) {
            object = new Intent((Context)this, InformacionActivity.class);
            object.putExtra(MainActivity.M, m2.h());
            this.startActivity((Intent)object);
            return;
        }
        if (object.getId() == 2131296841) {
            arrayList = new Intent((Context)this, InformeIAActivity.class);
            arrayList.putExtra(MainActivity.M, m2.h());
            arrayList.putExtra("modelo", m2.a());
            n2 = m2.b();
            object = n2 == 4 ? this.getString(2131886183) : (n2 == 1 ? this.getString(2131886184) : (n2 == 3 ? this.getString(2131886188) : (n2 == 2 ? this.getString(2131886185) : (n2 == 5 ? this.getString(2131886187) : this.getString(2131886186)))));
            arrayList.putExtra("distintivo", (String)object);
            if (m2.f() != null && !m2.f().isEmpty()) {
                try {
                    object = m2.f().split("/");
                    int n3 = Integer.parseInt((String)object[0]);
                    n2 = Integer.parseInt((String)object[1]);
                    c c2 = new c((Context)this);
                    object = new b(n3, n2);
                    object = c2.m((b)object);
                    object = this.getString(2131886113, new Object[]{((b)object).a(), ((b)object).b()});
                }
                catch (Exception exception) {
                    object = m2.f();
                }
            } else {
                object = "";
            }
            arrayList.putExtra("fecha", (String)object);
            if (m2.g() != null && !m2.g().isEmpty()) {
                arrayList.putExtra("informe_ia_cached", m2.g());
            }
            this.startActivity((Intent)arrayList);
        }
    }
}

