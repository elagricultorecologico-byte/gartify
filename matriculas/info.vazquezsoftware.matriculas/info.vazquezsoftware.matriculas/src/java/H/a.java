/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.StateSet
 *  androidx.appcompat.widget.X
 *  androidx.core.content.res.k
 *  androidx.vectordrawable.graphics.drawable.c
 *  androidx.vectordrawable.graphics.drawable.h
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 *  p.f
 *  p.j
 */
package h;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.X;
import androidx.core.content.res.k;
import androidx.vectordrawable.graphics.drawable.h;
import h.b;
import h.e;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p.j;

public class a
extends h.e {
    private c u;
    private g v;
    private int w = -1;
    private int x = -1;
    private boolean y;

    public a() {
        this(null, null);
    }

    a(c c2, Resources resources) {
        super(null);
        this.h(new c(c2, this, resources));
        this.onStateChange(this.getState());
        this.jumpToCurrentState();
    }

    public static a l(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Object object = xmlPullParser.getName();
        if (object.equals((Object)"animated-selector")) {
            object = new a();
            ((a)((Object)object)).m(context, resources, xmlPullParser, attributeSet, theme);
            return object;
        }
        context = new StringBuilder();
        context.append(xmlPullParser.getPositionDescription());
        context.append(": invalid animated-selector tag ");
        context.append((String)object);
        throw new XmlPullParserException(context.toString());
    }

    private void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int n2;
        int n3;
        int n4 = xmlPullParser.getDepth() + 1;
        while ((n3 = xmlPullParser.next()) != 1 && ((n2 = xmlPullParser.getDepth()) >= n4 || n3 != 3)) {
            if (n3 != 2 || n2 > n4) continue;
            if (xmlPullParser.getName().equals((Object)"item")) {
                this.p(context, resources, xmlPullParser, attributeSet, theme);
                continue;
            }
            if (!xmlPullParser.getName().equals((Object)"transition")) continue;
            this.q(context, resources, xmlPullParser, attributeSet, theme);
        }
    }

    private void o() {
        this.onStateChange(this.getState());
    }

    private int p(Context object, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Object object2 = k.s((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])i.c.h);
        int n2 = object2.getResourceId(i.c.i, 0);
        int n3 = object2.getResourceId(i.c.j, -1);
        object = n3 > 0 ? X.h().j(object, n3) : null;
        object2.recycle();
        int[] nArray = this.j(attributeSet);
        object2 = object;
        if (object == null) {
            while ((n3 = xmlPullParser.next()) == 4) {
            }
            if (n3 == 2) {
                object2 = xmlPullParser.getName().equals((Object)"vector") ? h.c((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme) : i.a.a(resources, xmlPullParser, attributeSet, theme);
            } else {
                object = new StringBuilder();
                object.append(xmlPullParser.getPositionDescription());
                object.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                throw new XmlPullParserException(object.toString());
            }
        }
        if (object2 != null) {
            return this.u.B(nArray, (Drawable)object2, n2);
        }
        object = new StringBuilder();
        object.append(xmlPullParser.getPositionDescription());
        object.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(object.toString());
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Object object = k.s((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])i.c.k);
        int n2 = object.getResourceId(i.c.n, -1);
        int n3 = object.getResourceId(i.c.m, -1);
        int n4 = object.getResourceId(i.c.l, -1);
        Drawable drawable = n4 > 0 ? X.h().j(context, n4) : null;
        boolean bl = object.getBoolean(i.c.o, false);
        object.recycle();
        object = drawable;
        if (drawable == null) {
            while ((n4 = xmlPullParser.next()) == 4) {
            }
            if (n4 == 2) {
                object = xmlPullParser.getName().equals((Object)"animated-vector") ? androidx.vectordrawable.graphics.drawable.c.b((Context)context, (Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme) : i.a.a(resources, xmlPullParser, attributeSet, theme);
            } else {
                context = new StringBuilder();
                context.append(xmlPullParser.getPositionDescription());
                context.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                throw new XmlPullParserException(context.toString());
            }
        }
        if (object != null) {
            if (n2 != -1 && n3 != -1) {
                return this.u.C(n2, n3, (Drawable)object, bl);
            }
            context = new StringBuilder();
            context.append(xmlPullParser.getPositionDescription());
            context.append(": <transition> tag requires 'fromId' & 'toId' attributes");
            throw new XmlPullParserException(context.toString());
        }
        context = new StringBuilder();
        context.append(xmlPullParser.getPositionDescription());
        context.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(context.toString());
    }

    private boolean r(int n2) {
        block8: {
            int n3;
            Object object;
            block10: {
                Drawable drawable;
                block11: {
                    block9: {
                        object = this.v;
                        if (object != null) {
                            if (n2 == this.w) {
                                return true;
                            }
                            if (n2 == this.x && ((g)object).a()) {
                                ((g)object).b();
                                this.w = this.x;
                                this.x = n2;
                                return true;
                            }
                            n3 = this.w;
                            ((g)object).d();
                        } else {
                            n3 = this.c();
                        }
                        this.v = null;
                        this.x = -1;
                        this.w = -1;
                        object = this.u;
                        int n4 = ((c)((Object)object)).E(n3);
                        int n5 = ((c)((Object)object)).E(n2);
                        if (n5 == 0 || n4 == 0) break block8;
                        int n6 = ((c)((Object)object)).G(n4, n5);
                        if (n6 < 0) {
                            return false;
                        }
                        boolean bl = ((c)((Object)object)).I(n4, n5);
                        this.g(n6);
                        drawable = this.getCurrent();
                        if (!(drawable instanceof AnimationDrawable)) break block9;
                        boolean bl2 = ((c)((Object)object)).H(n4, n5);
                        object = new e((AnimationDrawable)drawable, bl2, bl);
                        break block10;
                    }
                    if (!(drawable instanceof androidx.vectordrawable.graphics.drawable.c)) break block11;
                    object = new d((androidx.vectordrawable.graphics.drawable.c)drawable);
                    break block10;
                }
                if (!(drawable instanceof Animatable)) break block8;
                object = new b((Animatable)drawable);
            }
            ((g)object).c();
            this.v = object;
            this.x = n3;
            this.w = n2;
            return true;
        }
        return false;
    }

    private void s(TypedArray typedArray) {
        c c2 = this.u;
        c2.d |= i.a.b(typedArray);
        c2.x(typedArray.getBoolean(i.c.d, c2.i));
        c2.t(typedArray.getBoolean(i.c.e, c2.l));
        c2.u(typedArray.getInt(i.c.f, c2.A));
        c2.v(typedArray.getInt(i.c.g, c2.B));
        this.setDither(typedArray.getBoolean(i.c.b, c2.x));
    }

    @Override
    void h(b.d d2) {
        super.h(d2);
        if (d2 instanceof c) {
            this.u = (c)d2;
        }
    }

    public boolean isStateful() {
        return true;
    }

    @Override
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g g3 = this.v;
        if (g3 != null) {
            g3.d();
            this.v = null;
            this.g(this.w);
            this.w = -1;
            this.x = -1;
        }
    }

    c k() {
        return new c(this.u, this, null);
    }

    public void m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArray = k.s((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])i.c.a);
        this.setVisible(typedArray.getBoolean(i.c.c, true), true);
        this.s(typedArray);
        this.i(resources);
        typedArray.recycle();
        this.n(context, resources, xmlPullParser, attributeSet, theme);
        this.o();
    }

    @Override
    public Drawable mutate() {
        if (!this.y && super.mutate() == this) {
            this.u.r();
            this.y = true;
        }
        return this;
    }

    @Override
    protected boolean onStateChange(int[] nArray) {
        int n2 = this.u.F(nArray);
        boolean bl = n2 != this.c() && (this.r(n2) || this.g(n2));
        Drawable drawable = this.getCurrent();
        if (drawable != null) {
            return drawable.setState(nArray) | bl;
        }
        return bl;
    }

    @Override
    public boolean setVisible(boolean bl, boolean bl2) {
        boolean bl3 = super.setVisible(bl, bl2);
        g g3 = this.v;
        if (g3 != null && (bl3 || bl2)) {
            if (bl) {
                g3.c();
                return bl3;
            }
            this.jumpToCurrentState();
        }
        return bl3;
    }

    private static class b
    extends g {
        private final Animatable a;

        b(Animatable animatable) {
            this.a = animatable;
        }

        @Override
        public void c() {
            this.a.start();
        }

        @Override
        public void d() {
            this.a.stop();
        }
    }

    static class c
    extends e.a {
        p.f K;
        j L;

        c(c c2, a a2, Resources resources) {
            super(c2, a2, resources);
            if (c2 != null) {
                this.K = c2.K;
                this.L = c2.L;
                return;
            }
            this.K = new p.f();
            this.L = new j();
        }

        private static long D(int n2, int n3) {
            long l2 = n2;
            return (long)n3 | l2 << 32;
        }

        int B(int[] nArray, Drawable drawable, int n2) {
            int n3 = super.z(nArray, drawable);
            this.L.i(n3, (Object)n2);
            return n3;
        }

        int C(int n2, int n3, Drawable drawable, boolean bl) {
            int n4 = super.a(drawable);
            long l2 = c.D(n2, n3);
            long l3 = bl ? 0x200000000L : 0L;
            drawable = this.K;
            long l4 = n4;
            drawable.a(l2, (Object)(l4 | l3));
            if (bl) {
                l2 = c.D(n3, n2);
                this.K.a(l2, (Object)(0x100000000L | l4 | l3));
            }
            return n4;
        }

        int E(int n2) {
            if (n2 < 0) {
                return 0;
            }
            return (Integer)this.L.e(n2, (Object)0);
        }

        int F(int[] nArray) {
            int n2 = super.A(nArray);
            if (n2 >= 0) {
                return n2;
            }
            return super.A(StateSet.WILD_CARD);
        }

        int G(int n2, int n3) {
            long l2 = c.D(n2, n3);
            return (int)((Long)this.K.e(l2, (Object)-1L)).longValue();
        }

        boolean H(int n2, int n3) {
            long l2 = c.D(n2, n3);
            return ((Long)this.K.e(l2, (Object)-1L) & 0x100000000L) != 0L;
        }

        boolean I(int n2, int n3) {
            long l2 = c.D(n2, n3);
            return ((Long)this.K.e(l2, (Object)-1L) & 0x200000000L) != 0L;
        }

        public Drawable newDrawable() {
            return new a(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }

        @Override
        void r() {
            this.K = this.K.c();
            this.L = this.L.c();
        }
    }

    private static class d
    extends g {
        private final androidx.vectordrawable.graphics.drawable.c a;

        d(androidx.vectordrawable.graphics.drawable.c c2) {
            this.a = c2;
        }

        @Override
        public void c() {
            this.a.start();
        }

        @Override
        public void d() {
            this.a.stop();
        }
    }

    private static class e
    extends g {
        private final ObjectAnimator a;
        private final boolean b;

        e(AnimationDrawable animationDrawable, boolean bl, boolean bl2) {
            int n2 = animationDrawable.getNumberOfFrames();
            int n3 = 0;
            int n4 = bl ? n2 - 1 : 0;
            if (!bl) {
                n3 = n2 - 1;
            }
            f f2 = new f(animationDrawable, bl);
            animationDrawable = ObjectAnimator.ofInt((Object)animationDrawable, (String)"currentIndex", (int[])new int[]{n4, n3});
            animationDrawable.setAutoCancel(true);
            animationDrawable.setDuration((long)f2.a());
            animationDrawable.setInterpolator((TimeInterpolator)f2);
            this.b = bl2;
            this.a = animationDrawable;
        }

        @Override
        public boolean a() {
            return this.b;
        }

        @Override
        public void b() {
            this.a.reverse();
        }

        @Override
        public void c() {
            this.a.start();
        }

        @Override
        public void d() {
            this.a.cancel();
        }
    }

    private static class f
    implements TimeInterpolator {
        private int[] a;
        private int b;
        private int c;

        f(AnimationDrawable animationDrawable, boolean bl) {
            this.b(animationDrawable, bl);
        }

        int a() {
            return this.c;
        }

        int b(AnimationDrawable animationDrawable, boolean bl) {
            int n2;
            this.b = n2 = animationDrawable.getNumberOfFrames();
            int[] nArray = this.a;
            if (nArray == null || nArray.length < n2) {
                this.a = new int[n2];
            }
            nArray = this.a;
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                int n4 = bl ? n2 - i2 - 1 : i2;
                nArray[i2] = n4 = animationDrawable.getDuration(n4);
                n3 += n4;
            }
            this.c = n3;
            return n3;
        }

        public float getInterpolation(float f2) {
            int n2;
            int n3;
            int n4 = (int)(f2 * (float)this.c + 0.5f);
            int n5 = this.b;
            int[] nArray = this.a;
            for (n2 = 0; n2 < n5 && n4 >= (n3 = nArray[n2]); n4 -= n3, ++n2) {
            }
            f2 = n2 < n5 ? (float)n4 / (float)this.c : 0.0f;
            return (float)n2 / (float)n5 + f2;
        }
    }

    private static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }
}

