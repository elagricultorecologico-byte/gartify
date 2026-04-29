/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.util.AttributeSet
 *  android.util.StateSet
 *  android.util.Xml
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Objects
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package d2;

import M1.a;
import M1.j;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import d2.l;
import d2.s;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class t {
    final int a;
    final l b;
    final int[][] c;
    final l[] d;
    final s e;
    final s f;
    final s g;
    final s h;

    private t(b b2) {
        this.a = b2.a;
        this.b = b2.b;
        this.c = b2.c;
        this.d = b2.d;
        this.e = b2.e;
        this.f = b2.f;
        this.g = b2.g;
        this.h = b2.h;
    }

    public static t b(Context context, TypedArray typedArray, int n2) {
        if ((n2 = typedArray.getResourceId(n2, 0)) == 0) {
            return null;
        }
        if (!Objects.equals((Object)context.getResources().getResourceTypeName(n2), (Object)"xml")) {
            return null;
        }
        return new b(context, n2).j();
    }

    private int e(int[] nArray) {
        int[][] nArray2 = this.c;
        for (int i2 = 0; i2 < this.a; ++i2) {
            if (!StateSet.stateSetMatches((int[])nArray2[i2], (int[])nArray)) continue;
            return i2;
        }
        return -1;
    }

    private static void g(b b2, Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int n2;
        int n3;
        int n4 = xmlPullParser.getDepth() + 1;
        while ((n3 = xmlPullParser.next()) != 1 && ((n2 = xmlPullParser.getDepth()) >= n4 || n3 != 3)) {
            if (n3 != 2 || n2 > n4 || !xmlPullParser.getName().equals((Object)"item")) continue;
            Object object = context.getResources();
            object = theme == null ? object.obtainAttributes(attributeSet, j.V2) : theme.obtainStyledAttributes(attributeSet, j.V2, 0, 0);
            l l2 = l.b(context, object.getResourceId(j.W2, 0), object.getResourceId(j.X2, 0)).m();
            object.recycle();
            int n5 = attributeSet.getAttributeCount();
            object = new int[n5];
            n3 = 0;
            for (n2 = 0; n2 < n5; ++n2) {
                int n6 = attributeSet.getAttributeNameResource(n2);
                int n7 = n3;
                if (n6 != M1.a.H) {
                    n7 = n3;
                    if (n6 != M1.a.I) {
                        n7 = attributeSet.getAttributeBooleanValue(n2, false) ? n6 : -n6;
                        object[n3] = (Resources)n7;
                        n7 = n3 + 1;
                    }
                }
                n3 = n7;
            }
            b2.i(StateSet.trimStateSet((int[])object, (int)n3), l2);
        }
    }

    public static int h(int n2) {
        return (n2 & 0xA) >> 1 | (n2 & 5) << 1;
    }

    public l c(boolean bl) {
        if (bl && (this.e != null || this.f != null || this.g != null || this.h != null)) {
            l.b b2 = this.b.w();
            s s2 = this.e;
            if (s2 != null) {
                b2.D(s2.e());
            }
            if ((s2 = this.f) != null) {
                b2.H(s2.e());
            }
            if ((s2 = this.g) != null) {
                b2.v(s2.e());
            }
            if ((s2 = this.h) != null) {
                b2.z(s2.e());
            }
            return b2.m();
        }
        return this.b;
    }

    protected l d(int[] nArray) {
        int n2;
        int n3 = n2 = this.e(nArray);
        if (n2 < 0) {
            n3 = this.e(StateSet.WILD_CARD);
        }
        if (this.e == null && this.f == null && this.g == null && this.h == null) {
            return this.d[n3];
        }
        l.b b2 = this.d[n3].w();
        s s2 = this.e;
        if (s2 != null) {
            b2.D(s2.d(nArray));
        }
        if ((s2 = this.f) != null) {
            b2.H(s2.d(nArray));
        }
        if ((s2 = this.g) != null) {
            b2.v(s2.d(nArray));
        }
        if ((s2 = this.h) != null) {
            b2.z(s2.d(nArray));
        }
        return b2.m();
    }

    public boolean f() {
        s s2;
        return this.a > 1 || (s2 = this.e) != null && s2.h() || (s2 = this.f) != null && s2.h() || (s2 = this.g) != null && s2.h() || (s2 = this.h) != null && s2.h();
        {
        }
    }

    public b i() {
        return new b(this);
    }

    public static final class b {
        private int a;
        private l b;
        private int[][] c;
        private l[] d;
        private s e;
        private s f;
        private s g;
        private s h;

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private b(Context object, int n2) {
            Throwable throwable2;
            XmlResourceParser xmlResourceParser;
            block10: {
                block11: {
                    this.m();
                    xmlResourceParser = object.getResources().getXml(n2);
                    try {
                        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
                        while ((n2 = xmlResourceParser.next()) != 2 && n2 != 1) {
                        }
                        if (n2 != 2) break block10;
                        if (!xmlResourceParser.getName().equals((Object)"selector")) break block11;
                        t.g(this, object, (XmlPullParser)xmlResourceParser, attributeSet, object.getTheme());
                    }
                    catch (Throwable throwable2) {}
                }
                xmlResourceParser.close();
                return;
            }
            super("No start tag found");
            throw object;
            if (xmlResourceParser == null) throw throwable2;
            try {
                xmlResourceParser.close();
                throw throwable2;
            }
            catch (Throwable throwable3) {
                try {
                    throwable2.addSuppressed(throwable3);
                    throw throwable2;
                }
                catch (Resources.NotFoundException | IOException | XmlPullParserException throwable4) {
                    this.m();
                    return;
                }
            }
        }

        public b(l l2) {
            this.m();
            this.i(StateSet.WILD_CARD, l2);
        }

        public b(t t2) {
            int n2;
            this.a = n2 = t2.a;
            this.b = t2.b;
            int[][] nArray = t2.c;
            int[][] nArrayArray = new int[nArray.length][];
            this.c = nArrayArray;
            this.d = new l[t2.d.length];
            System.arraycopy((Object)nArray, (int)0, (Object)nArrayArray, (int)0, (int)n2);
            System.arraycopy((Object)t2.d, (int)0, (Object)this.d, (int)0, (int)this.a);
            this.e = t2.e;
            this.f = t2.f;
            this.g = t2.g;
            this.h = t2.h;
        }

        private boolean k(int n2, int n3) {
            return (n3 | n2) == n2;
        }

        private void l(int n2, int n3) {
            Object object = new int[n3][];
            System.arraycopy((Object)this.c, (int)0, (Object)object, (int)0, (int)n2);
            this.c = object;
            object = new l[n3];
            System.arraycopy((Object)this.d, (int)0, (Object)object, (int)0, (int)n2);
            this.d = (l[])object;
        }

        private void m() {
            this.b = new l();
            this.c = new int[10][];
            this.d = new l[10];
        }

        public b i(int[] nArray, l l2) {
            int n2 = this.a;
            if (n2 == 0 || nArray.length == 0) {
                this.b = l2;
            }
            if (n2 >= this.c.length) {
                this.l(n2, n2 + 10);
            }
            int[][] nArray2 = this.c;
            n2 = this.a;
            nArray2[n2] = nArray;
            this.d[n2] = l2;
            this.a = n2 + 1;
            return this;
        }

        public t j() {
            if (this.a == 0) {
                return null;
            }
            return new t(this);
        }

        public b n(s s2, int n2) {
            if (this.k(n2, 1)) {
                this.e = s2;
            }
            if (this.k(n2, 2)) {
                this.f = s2;
            }
            if (this.k(n2, 4)) {
                this.g = s2;
            }
            if (this.k(n2, 8)) {
                this.h = s2;
            }
            return this;
        }
    }
}

