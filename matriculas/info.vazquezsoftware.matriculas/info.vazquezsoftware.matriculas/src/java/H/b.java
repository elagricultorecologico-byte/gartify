/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.SystemClock
 *  android.util.SparseArray
 *  androidx.core.graphics.drawable.a
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.System
 *  java.lang.Throwable
 */
package h;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.core.graphics.drawable.a;

public abstract class b
extends Drawable
implements Drawable.Callback {
    private d g;
    private Rect h;
    private Drawable i;
    private Drawable j;
    private int k = 255;
    private boolean l;
    private int m = -1;
    private boolean n;
    private Runnable o;
    private long p;
    private long q;
    private c r;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d(Drawable drawable) {
        Throwable throwable2;
        block9: {
            block8: {
                if (this.r == null) {
                    this.r = new c();
                }
                drawable.setCallback((Drawable.Callback)this.r.b(drawable.getCallback()));
                try {
                    if (this.g.A > 0 || !this.l) break block8;
                    drawable.setAlpha(this.k);
                }
                catch (Throwable throwable2) {
                    break block9;
                }
            }
            d d2 = this.g;
            if (d2.E) {
                drawable.setColorFilter(d2.D);
            } else {
                if (d2.H) {
                    a.o((Drawable)drawable, (ColorStateList)d2.F);
                }
                d2 = this.g;
                if (d2.I) {
                    a.p((Drawable)drawable, (PorterDuff.Mode)d2.G);
                }
            }
            drawable.setVisible(this.isVisible(), true);
            drawable.setDither(this.g.x);
            drawable.setState(this.getState());
            drawable.setLevel(this.getLevel());
            drawable.setBounds(this.getBounds());
            a.m((Drawable)drawable, (int)a.f((Drawable)this));
            a.j((Drawable)drawable, (boolean)this.g.C);
            d2 = this.h;
            if (d2 != null) {
                a.l((Drawable)drawable, (int)((Rect)d2).left, (int)((Rect)d2).top, (int)((Rect)d2).right, (int)((Rect)d2).bottom);
            }
            drawable.setCallback(this.r.a());
            return;
        }
        drawable.setCallback(this.r.a());
        throw throwable2;
    }

    private boolean e() {
        return this.isAutoMirrored() && a.f((Drawable)this) == 1;
    }

    static int f(Resources resources, int n2) {
        if (resources != null) {
            n2 = resources.getDisplayMetrics().densityDpi;
        }
        if (n2 == 0) {
            return 160;
        }
        return n2;
    }

    void a(boolean bl) {
        boolean bl2;
        long l2;
        Drawable drawable;
        long l3;
        boolean bl3;
        block9: {
            block7: {
                block6: {
                    block8: {
                        bl3 = true;
                        this.l = true;
                        l3 = SystemClock.uptimeMillis();
                        drawable = this.i;
                        if (drawable == null) break block6;
                        l2 = this.p;
                        if (l2 == 0L) break block7;
                        if (l2 > l3) break block8;
                        drawable.setAlpha(this.k);
                        this.p = 0L;
                        break block7;
                    }
                    drawable.setAlpha((255 - (int)((l2 - l3) * 255L) / this.g.A) * this.k / 255);
                    bl2 = true;
                    break block9;
                }
                this.p = 0L;
            }
            bl2 = false;
        }
        drawable = this.j;
        if (drawable != null) {
            l2 = this.q;
            if (l2 != 0L) {
                if (l2 <= l3) {
                    drawable.setVisible(false, false);
                    this.j = null;
                    this.q = 0L;
                } else {
                    drawable.setAlpha((int)((l2 - l3) * 255L) / this.g.B * this.k / 255);
                    bl2 = bl3;
                }
            }
        } else {
            this.q = 0L;
        }
        if (bl && bl2) {
            this.scheduleSelf(this.o, l3 + 16L);
        }
    }

    public void applyTheme(Resources.Theme theme) {
        this.g.b(theme);
    }

    abstract d b();

    int c() {
        return this.m;
    }

    public boolean canApplyTheme() {
        return this.g.canApplyTheme();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        if ((drawable = this.j) != null) {
            drawable.draw(canvas);
        }
    }

    /*
     * Unable to fully structure code
     */
    boolean g(int var1_1) {
        if (var1_1 == this.m) {
            return false;
        }
        var2_2 = SystemClock.uptimeMillis();
        if (this.g.B > 0) {
            var4_3 = this.j;
            if (var4_3 != null) {
                var4_3.setVisible(false, false);
            }
            if ((var4_3 = this.i) != null) {
                this.j = var4_3;
                this.q = (long)this.g.B + var2_2;
            } else {
                this.j = null;
                this.q = 0L;
            }
        } else {
            var4_3 = this.i;
            if (var4_3 != null) {
                var4_3.setVisible(false, false);
            }
        }
        if (var1_1 < 0) ** GOTO lbl-1000
        var4_3 = this.g;
        if (var1_1 < var4_3.h) {
            var4_3 = var4_3.g(var1_1);
            this.i = var4_3;
            this.m = var1_1;
            if (var4_3 != null) {
                var1_1 = this.g.A;
                if (var1_1 > 0) {
                    this.p = var2_2 + (long)var1_1;
                }
                this.d((Drawable)var4_3);
            }
        } else lbl-1000:
        // 2 sources

        {
            this.i = null;
            this.m = -1;
        }
        if (this.p != 0L || this.q != 0L) {
            var4_3 = this.o;
            if (var4_3 == null) {
                this.o = new Runnable(this){
                    final b g;
                    {
                        this.g = b2;
                    }

                    public void run() {
                        this.g.a(true);
                        this.g.invalidateSelf();
                    }
                };
            } else {
                this.unscheduleSelf((Runnable)var4_3);
            }
            this.a(true);
        }
        this.invalidateSelf();
        return true;
    }

    public int getAlpha() {
        return this.k;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.g.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.g.c()) {
            this.g.d = this.getChangingConfigurations();
            return this.g;
        }
        return null;
    }

    public Drawable getCurrent() {
        return this.i;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.h;
        if (rect2 != null) {
            rect.set(rect2);
            return;
        }
        super.getHotspotBounds(rect);
    }

    public int getIntrinsicHeight() {
        if (this.g.q()) {
            return this.g.i();
        }
        Drawable drawable = this.i;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.g.q()) {
            return this.g.m();
        }
        Drawable drawable = this.i;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.g.q()) {
            return this.g.j();
        }
        Drawable drawable = this.i;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.g.q()) {
            return this.g.k();
        }
        Drawable drawable = this.i;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.i;
        if (drawable != null && drawable.isVisible()) {
            return this.g.n();
        }
        return -2;
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.i;
        if (drawable != null) {
            b.b(drawable, outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean bl;
        int n2;
        Rect rect2 = this.g.l();
        if (rect2 != null) {
            rect.set(rect2);
            int n3 = rect2.left;
            int n4 = rect2.top;
            n2 = rect2.bottom;
            bl = (rect2.right | (n3 | n4 | n2)) != 0;
        } else {
            rect2 = this.i;
            bl = rect2 != null ? rect2.getPadding(rect) : super.getPadding(rect);
        }
        if (this.e()) {
            n2 = rect.left;
            rect.left = rect.right;
            rect.right = n2;
        }
        return bl;
    }

    void h(d d2) {
        this.g = d2;
        int n2 = this.m;
        if (n2 >= 0) {
            d2 = d2.g(n2);
            this.i = d2;
            if (d2 != null) {
                this.d((Drawable)d2);
            }
        }
        this.j = null;
    }

    final void i(Resources resources) {
        this.g.y(resources);
    }

    public void invalidateDrawable(Drawable drawable) {
        d d2 = this.g;
        if (d2 != null) {
            d2.p();
        }
        if (drawable == this.i && this.getCallback() != null) {
            this.getCallback().invalidateDrawable((Drawable)this);
        }
    }

    public boolean isAutoMirrored() {
        return this.g.C;
    }

    public void jumpToCurrentState() {
        boolean bl;
        Drawable drawable = this.j;
        boolean bl2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.j = null;
            bl = true;
        } else {
            bl = false;
        }
        drawable = this.i;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            if (this.l) {
                this.i.setAlpha(this.k);
            }
        }
        if (this.q != 0L) {
            this.q = 0L;
            bl = true;
        }
        if (this.p != 0L) {
            this.p = 0L;
            bl = bl2;
        }
        if (bl) {
            this.invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.n && super.mutate() == this) {
            d d2 = this.b();
            d2.r();
            this.h(d2);
            this.n = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        if ((drawable = this.i) != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int n2) {
        return this.g.w(n2, this.c());
    }

    protected boolean onLevelChange(int n2) {
        Drawable drawable = this.j;
        if (drawable != null) {
            return drawable.setLevel(n2);
        }
        drawable = this.i;
        if (drawable != null) {
            return drawable.setLevel(n2);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l2) {
        if (drawable == this.i && this.getCallback() != null) {
            this.getCallback().scheduleDrawable((Drawable)this, runnable, l2);
        }
    }

    public void setAlpha(int n2) {
        if (!this.l || this.k != n2) {
            this.l = true;
            this.k = n2;
            Drawable drawable = this.i;
            if (drawable != null) {
                if (this.p == 0L) {
                    drawable.setAlpha(n2);
                    return;
                }
                this.a(false);
            }
        }
    }

    public void setAutoMirrored(boolean bl) {
        d d2 = this.g;
        if (d2.C != bl) {
            d2.C = bl;
            d2 = this.i;
            if (d2 != null) {
                a.j((Drawable)d2, (boolean)bl);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        d d2 = this.g;
        d2.E = true;
        if (d2.D != colorFilter) {
            d2.D = colorFilter;
            d2 = this.i;
            if (d2 != null) {
                d2.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean bl) {
        d d2 = this.g;
        if (d2.x != bl) {
            d2.x = bl;
            d2 = this.i;
            if (d2 != null) {
                d2.setDither(bl);
            }
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.i;
        if (drawable != null) {
            a.k((Drawable)drawable, (float)f2, (float)f3);
        }
    }

    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        Rect rect = this.h;
        if (rect == null) {
            this.h = new Rect(n2, n3, n4, n5);
        } else {
            rect.set(n2, n3, n4, n5);
        }
        rect = this.i;
        if (rect != null) {
            a.l((Drawable)rect, (int)n2, (int)n3, (int)n4, (int)n5);
        }
    }

    public void setTint(int n2) {
        this.setTintList(ColorStateList.valueOf((int)n2));
    }

    public void setTintList(ColorStateList colorStateList) {
        d d2 = this.g;
        d2.H = true;
        if (d2.F != colorStateList) {
            d2.F = colorStateList;
            a.o((Drawable)this.i, (ColorStateList)colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        d d2 = this.g;
        d2.I = true;
        if (d2.G != mode) {
            d2.G = mode;
            a.p((Drawable)this.i, (PorterDuff.Mode)mode);
        }
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        boolean bl3 = super.setVisible(bl, bl2);
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.setVisible(bl, bl2);
        }
        if ((drawable = this.i) != null) {
            drawable.setVisible(bl, bl2);
        }
        return bl3;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.i && this.getCallback() != null) {
            this.getCallback().unscheduleDrawable((Drawable)this, runnable);
        }
    }

    private static abstract class b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    static class c
    implements Drawable.Callback {
        private Drawable.Callback g;

        c() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.g;
            this.g = null;
            return callback;
        }

        public c b(Drawable.Callback callback) {
            this.g = callback;
            return this;
        }

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long l2) {
            Drawable.Callback callback = this.g;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, l2);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.g;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static abstract class d
    extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;
        final b a;
        Resources b;
        int c;
        int d;
        int e;
        SparseArray f;
        Drawable[] g;
        int h;
        boolean i;
        boolean j;
        Rect k;
        boolean l;
        boolean m;
        int n;
        int o;
        int p;
        int q;
        boolean r;
        int s;
        boolean t;
        boolean u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        int z;

        d(d d2, b object, Resources resources) {
            int n2 = 0;
            this.i = false;
            this.l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.a = object;
            Object var7_5 = null;
            object = resources != null ? resources : (d2 != null ? d2.b : null);
            this.b = object;
            int n3 = d2 != null ? d2.c : 0;
            this.c = n3 = h.b.f(resources, n3);
            if (d2 != null) {
                this.d = d2.d;
                this.e = d2.e;
                this.v = true;
                this.w = true;
                this.i = d2.i;
                this.l = d2.l;
                this.x = d2.x;
                this.y = d2.y;
                this.z = d2.z;
                this.A = d2.A;
                this.B = d2.B;
                this.C = d2.C;
                this.D = d2.D;
                this.E = d2.E;
                this.F = d2.F;
                this.G = d2.G;
                this.H = d2.H;
                this.I = d2.I;
                if (d2.c == n3) {
                    if (d2.j) {
                        object = var7_5;
                        if (d2.k != null) {
                            object = new Rect(d2.k);
                        }
                        this.k = object;
                        this.j = true;
                    }
                    if (d2.m) {
                        this.n = d2.n;
                        this.o = d2.o;
                        this.p = d2.p;
                        this.q = d2.q;
                        this.m = true;
                    }
                }
                if (d2.r) {
                    this.s = d2.s;
                    this.r = true;
                }
                if (d2.t) {
                    this.u = d2.u;
                    this.t = true;
                }
                object = d2.g;
                this.g = new Drawable[((Drawable[])object).length];
                this.h = d2.h;
                d2 = d2.f;
                this.f = d2 != null ? d2.clone() : new SparseArray(this.h);
                int n4 = this.h;
                for (n3 = n2; n3 < n4; ++n3) {
                    d2 = object[n3];
                    if (d2 == null) continue;
                    if ((d2 = d2.getConstantState()) != null) {
                        this.f.put(n3, (Object)d2);
                        continue;
                    }
                    this.g[n3] = object[n3];
                }
                return;
            }
            this.g = new Drawable[10];
            this.h = 0;
        }

        private void e() {
            SparseArray sparseArray = this.f;
            if (sparseArray != null) {
                int n2 = sparseArray.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    int n3 = this.f.keyAt(i2);
                    sparseArray = (Drawable.ConstantState)this.f.valueAt(i2);
                    this.g[n3] = this.s(sparseArray.newDrawable(this.b));
                }
                this.f = null;
            }
        }

        private Drawable s(Drawable drawable) {
            androidx.core.graphics.drawable.a.m((Drawable)drawable, (int)this.z);
            drawable = drawable.mutate();
            drawable.setCallback((Drawable.Callback)this.a);
            return drawable;
        }

        public final int a(Drawable drawable) {
            int n2 = this.h;
            if (n2 >= this.g.length) {
                this.o(n2, n2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback((Drawable.Callback)this.a);
            this.g[n2] = drawable;
            ++this.h;
            int n3 = this.e;
            this.e = drawable.getChangingConfigurations() | n3;
            this.p();
            this.k = null;
            this.j = false;
            this.m = false;
            this.v = false;
            return n2;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                this.e();
                int n2 = this.h;
                Drawable[] drawableArray = this.g;
                for (int i2 = 0; i2 < n2; ++i2) {
                    Drawable drawable = drawableArray[i2];
                    if (drawable == null || !androidx.core.graphics.drawable.a.b((Drawable)drawable)) continue;
                    androidx.core.graphics.drawable.a.a((Drawable)drawableArray[i2], (Resources.Theme)theme);
                    this.e |= drawableArray[i2].getChangingConfigurations();
                }
                this.y(h.b$b.c(theme));
            }
        }

        public boolean c() {
            if (this.v) {
                return this.w;
            }
            this.e();
            this.v = true;
            int n2 = this.h;
            Drawable[] drawableArray = this.g;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (drawableArray[i2].getConstantState() != null) continue;
                this.w = false;
                return false;
            }
            this.w = true;
            return true;
        }

        public boolean canApplyTheme() {
            int n2 = this.h;
            Drawable[] drawableArray = this.g;
            for (int i2 = 0; i2 < n2; ++i2) {
                Drawable drawable = drawableArray[i2];
                if (!(drawable != null ? androidx.core.graphics.drawable.a.b((Drawable)drawable) : (drawable = (Drawable.ConstantState)this.f.get(i2)) != null && h.b$b.a((Drawable.ConstantState)drawable))) continue;
                return true;
            }
            return false;
        }

        protected void d() {
            this.m = true;
            this.e();
            int n2 = this.h;
            Drawable[] drawableArray = this.g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                Drawable drawable = drawableArray[i2];
                int n3 = drawable.getIntrinsicWidth();
                if (n3 > this.n) {
                    this.n = n3;
                }
                if ((n3 = drawable.getIntrinsicHeight()) > this.o) {
                    this.o = n3;
                }
                if ((n3 = drawable.getMinimumWidth()) > this.p) {
                    this.p = n3;
                }
                if ((n3 = drawable.getMinimumHeight()) <= this.q) continue;
                this.q = n3;
            }
        }

        final int f() {
            return this.g.length;
        }

        public final Drawable g(int n2) {
            int n3;
            Drawable drawable = this.g[n2];
            if (drawable != null) {
                return drawable;
            }
            drawable = this.f;
            if (drawable != null && (n3 = drawable.indexOfKey(n2)) >= 0) {
                this.g[n2] = drawable = this.s(((Drawable.ConstantState)this.f.valueAt(n3)).newDrawable(this.b));
                this.f.removeAt(n3);
                if (this.f.size() == 0) {
                    this.f = null;
                }
                return drawable;
            }
            return null;
        }

        public int getChangingConfigurations() {
            return this.d | this.e;
        }

        public final int h() {
            return this.h;
        }

        public final int i() {
            if (!this.m) {
                this.d();
            }
            return this.o;
        }

        public final int j() {
            if (!this.m) {
                this.d();
            }
            return this.q;
        }

        public final int k() {
            if (!this.m) {
                this.d();
            }
            return this.p;
        }

        public final Rect l() {
            boolean bl = this.i;
            Rect rect = null;
            if (bl) {
                return null;
            }
            Rect rect2 = this.k;
            if (rect2 == null && !this.j) {
                this.e();
                Rect rect3 = new Rect();
                int n2 = this.h;
                Drawable[] drawableArray = this.g;
                for (int i2 = 0; i2 < n2; ++i2) {
                    Rect rect4 = rect;
                    if (drawableArray[i2].getPadding(rect3)) {
                        int n3;
                        rect2 = rect;
                        if (rect == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        if ((n3 = rect3.left) > rect2.left) {
                            rect2.left = n3;
                        }
                        if ((n3 = rect3.top) > rect2.top) {
                            rect2.top = n3;
                        }
                        if ((n3 = rect3.right) > rect2.right) {
                            rect2.right = n3;
                        }
                        n3 = rect3.bottom;
                        rect4 = rect2;
                        if (n3 > rect2.bottom) {
                            rect2.bottom = n3;
                            rect4 = rect2;
                        }
                    }
                    rect = rect4;
                }
                this.j = true;
                this.k = rect;
                return rect;
            }
            return rect2;
        }

        public final int m() {
            if (!this.m) {
                this.d();
            }
            return this.n;
        }

        public final int n() {
            if (this.r) {
                return this.s;
            }
            this.e();
            int n2 = this.h;
            Drawable[] drawableArray = this.g;
            int n3 = n2 > 0 ? drawableArray[0].getOpacity() : -2;
            for (int i2 = 1; i2 < n2; ++i2) {
                n3 = Drawable.resolveOpacity((int)n3, (int)drawableArray[i2].getOpacity());
            }
            this.s = n3;
            this.r = true;
            return n3;
        }

        public void o(int n2, int n3) {
            Drawable[] drawableArray = new Drawable[n3];
            Drawable[] drawableArray2 = this.g;
            if (drawableArray2 != null) {
                System.arraycopy((Object)drawableArray2, (int)0, (Object)drawableArray, (int)0, (int)n2);
            }
            this.g = drawableArray;
        }

        void p() {
            this.r = false;
            this.t = false;
        }

        public final boolean q() {
            return this.l;
        }

        abstract void r();

        public final void t(boolean bl) {
            this.l = bl;
        }

        public final void u(int n2) {
            this.A = n2;
        }

        public final void v(int n2) {
            this.B = n2;
        }

        final boolean w(int n2, int n3) {
            int n4 = this.h;
            Drawable[] drawableArray = this.g;
            boolean bl = false;
            for (int i2 = 0; i2 < n4; ++i2) {
                Drawable drawable = drawableArray[i2];
                boolean bl2 = bl;
                if (drawable != null) {
                    boolean bl3 = androidx.core.graphics.drawable.a.m((Drawable)drawable, (int)n2);
                    bl2 = bl;
                    if (i2 == n3) {
                        bl2 = bl3;
                    }
                }
                bl = bl2;
            }
            this.z = n2;
            return bl;
        }

        public final void x(boolean bl) {
            this.i = bl;
        }

        final void y(Resources resources) {
            if (resources != null) {
                this.b = resources;
                int n2 = h.b.f(resources, this.c);
                int n3 = this.c;
                this.c = n2;
                if (n3 != n2) {
                    this.m = false;
                    this.j = false;
                }
            }
        }
    }
}

