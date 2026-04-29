/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.AndroidRuntimeException
 *  android.view.View
 *  androidx.appcompat.app.E
 *  androidx.core.view.T
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.ArrayList
 */
package O;

import O.c;
import O.i;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.appcompat.app.E;
import androidx.core.view.T;
import java.util.ArrayList;

public abstract class h
implements c.c {
    public static final p A;
    public static final p n;
    public static final p o;
    public static final p p;
    public static final p q;
    public static final p r;
    public static final p s;
    public static final p t;
    public static final p u;
    public static final p v;
    public static final p w;
    public static final p x;
    public static final p y;
    public static final p z;
    float a = 0.0f;
    float b = Float.MAX_VALUE;
    boolean c = false;
    final Object d;
    final i e;
    boolean f = false;
    float g = Float.MAX_VALUE;
    float h = -Float.MAX_VALUE;
    private long i = 0L;
    private float j;
    private final ArrayList k = new ArrayList();
    private final ArrayList l = new ArrayList();
    private c m;

    static {
        n = new p("translationX"){

            public float c(View view) {
                return view.getTranslationX();
            }

            public void d(View view, float f2) {
                view.setTranslationX(f2);
            }
        };
        o = new p("translationY"){

            public float c(View view) {
                return view.getTranslationY();
            }

            public void d(View view, float f2) {
                view.setTranslationY(f2);
            }
        };
        p = new p("translationZ"){

            public float c(View view) {
                return T.G((View)view);
            }

            public void d(View view, float f2) {
                T.v0((View)view, (float)f2);
            }
        };
        q = new p("scaleX"){

            public float c(View view) {
                return view.getScaleX();
            }

            public void d(View view, float f2) {
                view.setScaleX(f2);
            }
        };
        r = new p("scaleY"){

            public float c(View view) {
                return view.getScaleY();
            }

            public void d(View view, float f2) {
                view.setScaleY(f2);
            }
        };
        s = new p("rotation"){

            public float c(View view) {
                return view.getRotation();
            }

            public void d(View view, float f2) {
                view.setRotation(f2);
            }
        };
        t = new p("rotationX"){

            public float c(View view) {
                return view.getRotationX();
            }

            public void d(View view, float f2) {
                view.setRotationX(f2);
            }
        };
        u = new p("rotationY"){

            public float c(View view) {
                return view.getRotationY();
            }

            public void d(View view, float f2) {
                view.setRotationY(f2);
            }
        };
        v = new p("x"){

            public float c(View view) {
                return view.getX();
            }

            public void d(View view, float f2) {
                view.setX(f2);
            }
        };
        w = new p("y"){

            public float c(View view) {
                return view.getY();
            }

            public void d(View view, float f2) {
                view.setY(f2);
            }
        };
        x = new p("z"){

            public float c(View view) {
                return T.J((View)view);
            }

            public void d(View view, float f2) {
                T.x0((View)view, (float)f2);
            }
        };
        y = new p("alpha"){

            public float c(View view) {
                return view.getAlpha();
            }

            public void d(View view, float f2) {
                view.setAlpha(f2);
            }
        };
        z = new p("scrollX"){

            public float c(View view) {
                return view.getScrollX();
            }

            public void d(View view, float f2) {
                view.setScrollX((int)f2);
            }
        };
        A = new p("scrollY"){

            public float c(View view) {
                return view.getScrollY();
            }

            public void d(View view, float f2) {
                view.setScrollY((int)f2);
            }
        };
    }

    h(Object object, i i2) {
        this.d = object;
        this.e = i2;
        if (i2 != s && i2 != t && i2 != u) {
            if (i2 == y) {
                this.j = 0.00390625f;
                return;
            }
            if (i2 != q && i2 != r) {
                this.j = 1.0f;
                return;
            }
            this.j = 0.002f;
            return;
        }
        this.j = 0.1f;
    }

    private void b(boolean bl) {
        this.f = false;
        this.c().k(this);
        this.i = 0L;
        this.c = false;
        for (int i2 = 0; i2 < this.k.size(); ++i2) {
            if (this.k.get(i2) == null) {
                continue;
            }
            E.a((Object)this.k.get(i2));
            throw null;
        }
        O.h.g(this.k);
    }

    private float d() {
        return this.e.a(this.d);
    }

    private static void g(ArrayList arrayList) {
        for (int i2 = arrayList.size() - 1; i2 >= 0; --i2) {
            if (arrayList.get(i2) != null) continue;
            arrayList.remove(i2);
        }
    }

    private void j() {
        if (!this.f) {
            float f2;
            this.f = true;
            if (!this.c) {
                this.b = this.d();
            }
            if (!((f2 = this.b) > this.g) && !(f2 < this.h)) {
                this.c().d(this, 0L);
                return;
            }
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
    }

    @Override
    public boolean a(long l2) {
        long l3 = this.i;
        if (l3 == 0L) {
            this.i = l2;
            this.h(this.b);
            return false;
        }
        this.i = l2;
        float f2 = this.c().g();
        l2 = f2 == 0.0f ? Integer.MAX_VALUE : (long)((float)(l2 - l3) / f2);
        boolean bl = this.k(l2);
        this.b = f2 = Math.min((float)this.b, (float)this.g);
        this.b = f2 = Math.max((float)f2, (float)this.h);
        this.h(f2);
        if (bl) {
            this.b(false);
        }
        return bl;
    }

    public c c() {
        c c2 = this.m;
        if (c2 != null) {
            return c2;
        }
        return O.c.h();
    }

    float e() {
        return this.j * 0.75f;
    }

    public boolean f() {
        return this.f;
    }

    void h(float f2) {
        this.e.b(this.d, f2);
        for (int i2 = 0; i2 < this.l.size(); ++i2) {
            if (this.l.get(i2) == null) {
                continue;
            }
            E.a((Object)this.l.get(i2));
            throw null;
        }
        O.h.g(this.l);
    }

    public void i() {
        if (this.c().j()) {
            if (!this.f) {
                this.j();
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
    }

    abstract boolean k(long var1);

    static class o {
        float a;
        float b;

        o() {
        }
    }

    public static abstract class p
    extends i {
        private p(String string) {
            super(string);
        }
    }
}

