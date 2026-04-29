/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.ContextThemeWrapper
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package d2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import d2.a;
import d2.d;
import d2.e;
import d2.f;
import d2.g;
import d2.i;
import d2.j;
import d2.k;

public class l {
    public static final d m = new j(0.5f);
    e a;
    e b;
    e c;
    e d;
    d e;
    d f;
    d g;
    d h;
    g i;
    g j;
    g k;
    g l;

    public l() {
        this.a = d2.i.b();
        this.b = d2.i.b();
        this.c = d2.i.b();
        this.d = d2.i.b();
        this.e = new a(0.0f);
        this.f = new a(0.0f);
        this.g = new a(0.0f);
        this.h = new a(0.0f);
        this.i = d2.i.c();
        this.j = d2.i.c();
        this.k = d2.i.c();
        this.l = d2.i.c();
    }

    private l(b b2) {
        this.a = b2.a;
        this.b = b2.b;
        this.c = b2.c;
        this.d = b2.d;
        this.e = b2.e;
        this.f = b2.f;
        this.g = b2.g;
        this.h = b2.h;
        this.i = b2.i;
        this.j = b2.j;
        this.k = b2.k;
        this.l = b2.l;
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int n2, int n3) {
        return d2.l.c(context, n2, n3, 0);
    }

    private static b c(Context context, int n2, int n3, int n4) {
        return d2.l.d(context, n2, n3, new a(n4));
    }

    private static b d(Context context, int n2, int n3, d object) {
        context = new ContextThemeWrapper(context, n2);
        if (n3 != 0) {
            context.getTheme().applyStyle(n3, true);
        }
        context = context.obtainStyledAttributes(M1.j.p4);
        try {
            int n4 = context.getInt(M1.j.q4, 0);
            n3 = context.getInt(M1.j.t4, n4);
            n2 = context.getInt(M1.j.u4, n4);
            int n5 = context.getInt(M1.j.s4, n4);
            n4 = context.getInt(M1.j.r4, n4);
            Object object2 = d2.l.m((TypedArray)context, M1.j.v4, (d)object);
            d d2 = d2.l.m((TypedArray)context, M1.j.y4, (d)object2);
            d d3 = d2.l.m((TypedArray)context, M1.j.z4, (d)object2);
            object = d2.l.m((TypedArray)context, M1.j.x4, (d)object2);
            d d4 = d2.l.m((TypedArray)context, M1.j.w4, (d)object2);
            object2 = new b();
            object = ((b)object2).A(n3, d2).E(n2, d3).w(n5, (d)object).s(n4, d4);
            return object;
        }
        finally {
            context.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int n2, int n3) {
        return d2.l.f(context, attributeSet, n2, n3, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int n2, int n3, int n4) {
        return d2.l.g(context, attributeSet, n2, n3, new a(n4));
    }

    public static b g(Context context, AttributeSet attributeSet, int n2, int n3, d d2) {
        attributeSet = context.obtainStyledAttributes(attributeSet, M1.j.V2, n2, n3);
        n3 = attributeSet.getResourceId(M1.j.W2, 0);
        n2 = attributeSet.getResourceId(M1.j.X2, 0);
        attributeSet.recycle();
        return d2.l.d(context, n3, n2, d2);
    }

    public static d m(TypedArray typedArray, int n2, d d2) {
        TypedValue typedValue = typedArray.peekValue(n2);
        if (typedValue != null) {
            n2 = typedValue.type;
            if (n2 == 5) {
                return new a(TypedValue.complexToDimensionPixelSize((int)typedValue.data, (DisplayMetrics)typedArray.getResources().getDisplayMetrics()));
            }
            if (n2 == 6) {
                return new j(typedValue.getFraction(1.0f, 1.0f));
            }
        }
        return d2;
    }

    public g h() {
        return this.k;
    }

    public e i() {
        return this.d;
    }

    public d j() {
        return this.h;
    }

    public e k() {
        return this.c;
    }

    public d l() {
        return this.g;
    }

    public g n() {
        return this.l;
    }

    public g o() {
        return this.j;
    }

    public g p() {
        return this.i;
    }

    public e q() {
        return this.a;
    }

    public d r() {
        return this.e;
    }

    public e s() {
        return this.b;
    }

    public d t() {
        return this.f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append((Object)this.r());
        stringBuilder.append(", ");
        stringBuilder.append((Object)this.t());
        stringBuilder.append(", ");
        stringBuilder.append((Object)this.l());
        stringBuilder.append(", ");
        stringBuilder.append((Object)this.j());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean u() {
        return this.b instanceof k && this.a instanceof k && this.c instanceof k && this.d instanceof k;
    }

    public boolean v(RectF rectF) {
        boolean bl = this.l.getClass().equals(g.class) && this.j.getClass().equals(g.class) && this.i.getClass().equals(g.class) && this.k.getClass().equals(g.class);
        float f2 = this.e.a(rectF);
        boolean bl2 = this.f.a(rectF) == f2 && this.h.a(rectF) == f2 && this.g.a(rectF) == f2;
        return bl && bl2 && this.u();
    }

    public b w() {
        return new b(this);
    }

    public l x(float f2) {
        return this.w().o(f2).m();
    }

    public l y(d d2) {
        return this.w().p(d2).m();
    }

    public l z(c c2) {
        return this.w().D(c2.a(this.r())).H(c2.a(this.t())).v(c2.a(this.j())).z(c2.a(this.l())).m();
    }

    public static final class b {
        private e a = d2.i.b();
        private e b = d2.i.b();
        private e c = d2.i.b();
        private e d = d2.i.b();
        private d e = new a(0.0f);
        private d f = new a(0.0f);
        private d g = new a(0.0f);
        private d h = new a(0.0f);
        private g i = d2.i.c();
        private g j = d2.i.c();
        private g k = d2.i.c();
        private g l = d2.i.c();

        public b() {
        }

        public b(l l2) {
            this.a = l2.a;
            this.b = l2.b;
            this.c = l2.c;
            this.d = l2.d;
            this.e = l2.e;
            this.f = l2.f;
            this.g = l2.g;
            this.h = l2.h;
            this.i = l2.i;
            this.j = l2.j;
            this.k = l2.k;
            this.l = l2.l;
        }

        private static float n(e e2) {
            if (e2 instanceof k) {
                return ((k)e2).a;
            }
            if (e2 instanceof f) {
                return ((f)e2).a;
            }
            return -1.0f;
        }

        public b A(int n2, d d2) {
            return this.B(d2.i.a(n2)).D(d2);
        }

        public b B(e e2) {
            this.a = e2;
            float f2 = d2.l$b.n(e2);
            if (f2 != -1.0f) {
                this.C(f2);
            }
            return this;
        }

        public b C(float f2) {
            this.e = new a(f2);
            return this;
        }

        public b D(d d2) {
            this.e = d2;
            return this;
        }

        public b E(int n2, d d2) {
            return this.F(d2.i.a(n2)).H(d2);
        }

        public b F(e e2) {
            this.b = e2;
            float f2 = d2.l$b.n(e2);
            if (f2 != -1.0f) {
                this.G(f2);
            }
            return this;
        }

        public b G(float f2) {
            this.f = new a(f2);
            return this;
        }

        public b H(d d2) {
            this.f = d2;
            return this;
        }

        public l m() {
            return new l(this);
        }

        public b o(float f2) {
            return this.C(f2).G(f2).y(f2).u(f2);
        }

        public b p(d d2) {
            return this.D(d2).H(d2).z(d2).v(d2);
        }

        public b q(int n2, float f2) {
            return this.r(d2.i.a(n2)).o(f2);
        }

        public b r(e e2) {
            return this.B(e2).F(e2).x(e2).t(e2);
        }

        public b s(int n2, d d2) {
            return this.t(d2.i.a(n2)).v(d2);
        }

        public b t(e e2) {
            this.d = e2;
            float f2 = d2.l$b.n(e2);
            if (f2 != -1.0f) {
                this.u(f2);
            }
            return this;
        }

        public b u(float f2) {
            this.h = new a(f2);
            return this;
        }

        public b v(d d2) {
            this.h = d2;
            return this;
        }

        public b w(int n2, d d2) {
            return this.x(d2.i.a(n2)).z(d2);
        }

        public b x(e e2) {
            this.c = e2;
            float f2 = d2.l$b.n(e2);
            if (f2 != -1.0f) {
                this.y(f2);
            }
            return this;
        }

        public b y(float f2) {
            this.g = new a(f2);
            return this;
        }

        public b z(d d2) {
            this.g = d2;
            return this;
        }
    }

    public static interface c {
        public d a(d var1);
    }
}

