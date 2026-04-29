/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Typeface
 *  android.os.Build$VERSION
 *  android.text.TextPaint
 *  android.util.Log
 *  android.util.Xml
 *  androidx.core.content.res.h
 *  androidx.core.content.res.h$e
 *  f.j
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  org.xmlpull.v1.XmlPullParser
 *  y.d
 */
package a2;

import a2.c;
import a2.d;
import a2.f;
import a2.g;
import a2.k;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import android.util.Xml;
import androidx.core.content.res.h;
import f.j;
import org.xmlpull.v1.XmlPullParser;

public class e {
    public final ColorStateList a;
    public final ColorStateList b;
    public final ColorStateList c;
    public final String d;
    public String e;
    public final int f;
    public final int g;
    public final boolean h;
    public final float i;
    public final float j;
    public final float k;
    public final boolean l;
    public final float m;
    private ColorStateList n;
    private float o;
    private final int p;
    private boolean q = false;
    private boolean r = false;
    private Typeface s;

    public e(Context context, int n3) {
        TypedArray typedArray = context.obtainStyledAttributes(n3, f.j.J2);
        this.o(typedArray.getDimension(f.j.K2, 0.0f));
        this.n(a2.c.a(context, typedArray, f.j.N2));
        this.a = a2.c.a(context, typedArray, f.j.O2);
        this.b = a2.c.a(context, typedArray, f.j.P2);
        this.f = typedArray.getInt(f.j.M2, 0);
        this.g = typedArray.getInt(f.j.L2, 1);
        int n4 = a2.c.e(typedArray, f.j.W2, f.j.U2);
        this.p = typedArray.getResourceId(n4, 0);
        this.d = typedArray.getString(n4);
        this.h = typedArray.getBoolean(f.j.Y2, false);
        this.c = a2.c.a(context, typedArray, f.j.Q2);
        this.i = typedArray.getFloat(f.j.R2, 0.0f);
        this.j = typedArray.getFloat(f.j.S2, 0.0f);
        this.k = typedArray.getFloat(f.j.T2, 0.0f);
        typedArray.recycle();
        context = context.obtainStyledAttributes(n3, M1.j.c3);
        n3 = M1.j.d3;
        this.l = context.hasValue(n3);
        this.m = context.getFloat(n3, 0.0f);
        if (Build.VERSION.SDK_INT >= 26) {
            this.e = context.getString(a2.c.e((TypedArray)context, M1.j.g3, M1.j.e3));
        }
        context.recycle();
    }

    static /* synthetic */ Typeface b(e e3, Typeface typeface) {
        e3.s = typeface;
        return typeface;
    }

    static /* synthetic */ boolean c(e e3, boolean bl) {
        e3.q = bl;
        return bl;
    }

    private void d() {
        String string;
        if (this.s == null && (string = this.d) != null) {
            this.s = Typeface.create((String)string, (int)this.f);
        }
        if (this.s == null) {
            int n3 = this.g;
            this.s = n3 != 1 ? (n3 != 2 ? (n3 != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE) : Typeface.SERIF) : Typeface.SANS_SERIF;
            this.s = Typeface.create((Typeface)this.s, (int)this.f);
        }
    }

    private Typeface i(Context object) {
        if (this.r) {
            return null;
        }
        this.r = true;
        if ((object = a2.e.m(object, this.p)) == null) {
            return null;
        }
        if ((object = Typeface.create((String)object, (int)0)) == Typeface.DEFAULT) {
            return null;
        }
        return Typeface.create((Typeface)object, (int)this.f);
    }

    private boolean l(Context context) {
        if (a2.f.a()) {
            this.f(context);
            return true;
        }
        if (this.q) {
            return true;
        }
        int n3 = this.p;
        if (n3 == 0) {
            return false;
        }
        Typeface typeface = androidx.core.content.res.h.c((Context)context, (int)n3);
        if (typeface != null) {
            this.s = typeface;
            this.q = true;
            return true;
        }
        if ((context = this.i(context)) != null) {
            this.s = context;
            this.q = true;
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String m(Context object, int n3) {
        object = object.getResources();
        if (n3 == 0) return null;
        if (!object.getResourceTypeName(n3).equals((Object)"font")) {
            return null;
        }
        try {
            XmlResourceParser xmlResourceParser = object.getXml(n3);
            while (xmlResourceParser.getEventType() != 1) {
                if (xmlResourceParser.getEventType() == 2 && xmlResourceParser.getName().equals((Object)"font-family")) {
                    xmlResourceParser = object.obtainAttributes(Xml.asAttributeSet((XmlPullParser)xmlResourceParser), y.d.h);
                    object = xmlResourceParser.getString(y.d.o);
                    xmlResourceParser.recycle();
                    return object;
                }
                xmlResourceParser.next();
            }
            return null;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public Typeface e() {
        this.d();
        return this.s;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Typeface f(Context context) {
        if (this.q) {
            return this.s;
        }
        if (!context.isRestricted()) {
            try {
                context = androidx.core.content.res.h.g((Context)context, (int)this.p);
                this.s = context;
                if (context != null) {
                    this.s = Typeface.create((Typeface)context, (int)this.f);
                }
            }
            catch (Exception exception) {
                context = new StringBuilder();
                context.append("Error loading font ");
                context.append(this.d);
                Log.d((String)"TextAppearance", (String)context.toString(), (Throwable)exception);
            }
            catch (Resources.NotFoundException | UnsupportedOperationException throwable) {}
        }
        this.d();
        this.q = true;
        return this.s;
    }

    public void g(Context context, g g3) {
        int n3;
        if (!this.l(context)) {
            this.d();
        }
        if ((n3 = this.p) == 0) {
            this.q = true;
        }
        if (this.q) {
            g3.b(this.s, true);
            return;
        }
        try {
            h.e e3 = new h.e(this, g3){
                final g a;
                final e b;
                {
                    this.b = e3;
                    this.a = g3;
                }

                public void f(int n3) {
                    a2.e.c(this.b, true);
                    this.a.a(n3);
                }

                public void g(Typeface typeface) {
                    e e3 = this.b;
                    a2.e.b(e3, Typeface.create((Typeface)typeface, (int)e3.f));
                    a2.e.c(this.b, true);
                    this.a.b(this.b.s, false);
                }
            };
            androidx.core.content.res.h.i((Context)context, (int)n3, (h.e)e3, null);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error loading font ");
            stringBuilder.append(this.d);
            Log.d((String)"TextAppearance", (String)stringBuilder.toString(), (Throwable)exception);
            this.q = true;
            g3.a(-3);
        }
        catch (Resources.NotFoundException notFoundException) {
            this.q = true;
            g3.a(1);
        }
    }

    public void h(Context context, TextPaint textPaint, g g3) {
        this.r(context, textPaint, this.e());
        this.g(context, new g(this, context, textPaint, g3){
            final Context a;
            final TextPaint b;
            final g c;
            final e d;
            {
                this.d = e3;
                this.a = context;
                this.b = textPaint;
                this.c = g3;
            }

            @Override
            public void a(int n3) {
                this.c.a(n3);
            }

            @Override
            public void b(Typeface typeface, boolean bl) {
                this.d.r(this.a, this.b, typeface);
                this.c.b(typeface, bl);
            }
        });
    }

    public ColorStateList j() {
        return this.n;
    }

    public float k() {
        return this.o;
    }

    public void n(ColorStateList colorStateList) {
        this.n = colorStateList;
    }

    public void o(float f3) {
        this.o = f3;
    }

    public void p(Context context, TextPaint textPaint, g g3) {
        this.q(context, textPaint, g3);
        context = this.n;
        int n3 = context != null ? context.getColorForState(textPaint.drawableState, context.getDefaultColor()) : -16777216;
        textPaint.setColor(n3);
        float f3 = this.k;
        float f4 = this.i;
        float f5 = this.j;
        context = this.c;
        n3 = context != null ? context.getColorForState(textPaint.drawableState, context.getDefaultColor()) : 0;
        textPaint.setShadowLayer(f3, f4, f5, n3);
    }

    public void q(Context context, TextPaint textPaint, g g3) {
        Typeface typeface;
        if (this.l(context) && this.q && (typeface = this.s) != null) {
            this.r(context, textPaint, typeface);
            return;
        }
        this.h(context, textPaint, g3);
    }

    public void r(Context context, TextPaint textPaint, Typeface typeface) {
        if ((context = a2.k.a(context, typeface)) != null) {
            typeface = context;
        }
        textPaint.setTypeface(typeface);
        int n3 = this.f & ~typeface.getStyle();
        boolean bl = (n3 & 1) != 0;
        textPaint.setFakeBoldText(bl);
        float f3 = (n3 & 2) != 0 ? -0.25f : 0.0f;
        textPaint.setTextSkewX(f3);
        textPaint.setTextSize(this.o);
        if (Build.VERSION.SDK_INT >= 26) {
            a2.d.a(textPaint, this.e);
        }
        if (this.l) {
            textPaint.setLetterSpacing(this.m);
        }
    }
}

