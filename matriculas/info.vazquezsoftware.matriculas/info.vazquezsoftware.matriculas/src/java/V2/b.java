/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  androidx.recyclerview.widget.RecyclerView$D
 *  androidx.recyclerview.widget.RecyclerView$h
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import r2.m;
import r2.n;

public class b
extends RecyclerView.h {
    private ArrayList d;
    private LayoutInflater e;
    private Context f;
    private a g;
    private n h;
    private String[] i;

    public b(Context context, ArrayList arrayList) {
        this.e = LayoutInflater.from((Context)context);
        this.d = arrayList;
        this.f = context;
        this.h = new n(context);
        this.i = this.f.getResources().getStringArray(2130903041);
    }

    public m B(int n2) {
        return (m)this.d.get(n2);
    }

    public void C(b b2, int n2) {
        m m2 = this.B(n2);
        b2.A.setText((CharSequence)m2.a());
        n2 = m2.b();
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            if (n2 == 5) {
                                b2.D.setBackgroundResource(2131231008);
                            }
                        } else {
                            b2.D.setBackgroundResource(2131230842);
                        }
                    } else {
                        b2.D.setBackgroundResource(2131231012);
                    }
                } else {
                    b2.D.setBackgroundResource(2131230887);
                }
            } else {
                b2.D.setBackgroundResource(2131230860);
            }
        } else {
            b2.D.setBackgroundResource(2131230989);
        }
        n2 = this.h.o(m2.h());
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 == 2) {
                    b2.B.setText((CharSequence)this.h.j(m2.h()));
                }
            } else {
                b2.B.setText((CharSequence)this.h.k(m2.h()));
            }
        } else {
            b2.B.setText((CharSequence)this.h.i(m2.h()).trim());
        }
        b2.E.setText((CharSequence)m2.j());
        b2.F.setText((CharSequence)m2.i());
        b2.G.setText((CharSequence)m2.c());
        b2.C.setText((CharSequence)m2.f());
    }

    public b D(ViewGroup viewGroup, int n2) {
        return new b(this, this.e.inflate(2131492927, viewGroup, false));
    }

    public void E(a a2) {
        this.g = a2;
    }

    public void F(ArrayList arrayList) {
        this.d = arrayList;
    }

    public int e() {
        ArrayList arrayList = this.d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public class b
    extends RecyclerView.D
    implements View.OnClickListener {
        protected TextView A;
        protected TextView B;
        protected TextView C;
        protected ImageView D;
        protected TextView E;
        protected TextView F;
        protected TextView G;
        protected ImageButton H;
        protected ImageButton I;
        protected TextView J;
        protected RelativeLayout K;
        final b L;

        public b(b b2, View view) {
            this.L = b2;
            super(view);
            this.A = (TextView)view.findViewById(2131296832);
            b2 = (RelativeLayout)view.findViewById(2131296706);
            this.K = b2;
            b2.setOnClickListener(this);
            this.B = (TextView)view.findViewById(2131296843);
            this.C = (TextView)view.findViewById(2131296837);
            this.D = (ImageView)view.findViewById(2131296524);
            this.E = (TextView)view.findViewById(2131296846);
            this.F = (TextView)view.findViewById(2131296845);
            this.G = (TextView)view.findViewById(2131296834);
            b2 = (ImageButton)view.findViewById(2131296502);
            this.H = b2;
            b2.setOnClickListener(this);
            b2 = (ImageButton)view.findViewById(2131296503);
            this.I = b2;
            b2.setOnClickListener(this);
            b2 = (TextView)view.findViewById(2131296841);
            this.J = b2;
            b2.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (this.L.g != null) {
                this.L.g.y(view, this.r(), this.L.d);
            }
        }
    }
}

