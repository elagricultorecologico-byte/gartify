/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.StateSet
 *  android.util.TypedValue
 *  android.util.Xml
 *  java.io.IOException
 *  java.lang.Enum
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package d2;

import M1.j;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class u {
    int a;
    private a b;
    int[][] c = new int[10][];
    a[] d = new a[10];

    private void a(int[] nArray, a a2) {
        int n2 = this.a;
        if (n2 == 0 || nArray.length == 0) {
            this.b = a2;
        }
        if (n2 >= this.c.length) {
            this.f(n2, n2 + 10);
        }
        int[][] nArray2 = this.c;
        n2 = this.a;
        nArray2[n2] = nArray;
        this.d[n2] = a2;
        this.a = n2 + 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static u b(Context object, TypedArray typedArray, int n2) {
        Throwable throwable2;
        block12: {
            u u2;
            block13: {
                if ((n2 = typedArray.getResourceId(n2, 0)) == 0) {
                    return null;
                }
                if (!object.getResources().getResourceTypeName(n2).equals((Object)"xml")) {
                    return null;
                }
                typedArray = object.getResources().getXml(n2);
                try {
                    u2 = new u();
                    AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)typedArray);
                    while ((n2 = typedArray.next()) != 2 && n2 != 1) {
                    }
                    if (n2 != 2) break block12;
                    if (!typedArray.getName().equals((Object)"selector")) break block13;
                    u2.h((Context)object, (XmlPullParser)typedArray, attributeSet, object.getTheme());
                }
                catch (Throwable throwable2) {}
            }
            typedArray.close();
            return u2;
        }
        object = new XmlPullParserException("No start tag found");
        throw object;
        if (typedArray == null) throw throwable2;
        try {
            typedArray.close();
            throw throwable2;
        }
        catch (Throwable throwable3) {
            try {
                throwable2.addSuppressed(throwable3);
                throw throwable2;
            }
            catch (Resources.NotFoundException | IOException | XmlPullParserException throwable4) {
                return null;
            }
        }
    }

    private b d(TypedArray typedArray, int n2, b b2) {
        TypedValue typedValue = typedArray.peekValue(n2);
        if (typedValue != null) {
            n2 = typedValue.type;
            if (n2 == 5) {
                return new b(d2.u$c.h, TypedValue.complexToDimensionPixelSize((int)typedValue.data, (DisplayMetrics)typedArray.getResources().getDisplayMetrics()));
            }
            if (n2 == 6) {
                return new b(d2.u$c.g, typedValue.getFraction(1.0f, 1.0f));
            }
        }
        return b2;
    }

    private void f(int n2, int n3) {
        Object object = new int[n3][];
        System.arraycopy((Object)this.c, (int)0, (Object)object, (int)0, (int)n2);
        this.c = object;
        object = new a[n3];
        System.arraycopy((Object)this.d, (int)0, (Object)object, (int)0, (int)n2);
        this.d = (a[])object;
    }

    private int g(int[] nArray) {
        int[][] nArray2 = this.c;
        for (int i2 = 0; i2 < this.a; ++i2) {
            if (!StateSet.stateSetMatches((int[])nArray2[i2], (int[])nArray)) continue;
            return i2;
        }
        return -1;
    }

    private void h(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int n2;
        int n3;
        int n4 = xmlPullParser.getDepth() + 1;
        while ((n3 = xmlPullParser.next()) != 1 && ((n2 = xmlPullParser.getDepth()) >= n4 || n3 != 3)) {
            if (n3 != 2 || n2 > n4 || !xmlPullParser.getName().equals((Object)"item")) continue;
            Object object = context.getResources();
            object = theme == null ? object.obtainAttributes(attributeSet, j.U4) : theme.obtainStyledAttributes(attributeSet, j.U4, 0, 0);
            b b2 = this.d((TypedArray)object, j.V4, null);
            object.recycle();
            int n5 = attributeSet.getAttributeCount();
            object = new int[n5];
            n2 = 0;
            for (n3 = 0; n3 < n5; ++n3) {
                int n6 = attributeSet.getAttributeNameResource(n3);
                int n7 = n2;
                if (n6 != M1.a.S) {
                    n7 = attributeSet.getAttributeBooleanValue(n3, false) ? n6 : -n6;
                    object[n2] = (Resources)n7;
                    n7 = n2 + 1;
                }
                n2 = n7;
            }
            this.a(StateSet.trimStateSet((int[])object, (int)n2), new a(b2));
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public int c(int n2) {
        int n3 = -n2;
        int n4 = 0;
        while (true) {
            int n5;
            block7: {
                float f2;
                block6: {
                    c c2;
                    b b2;
                    block5: {
                        if (n4 >= this.a) {
                            return n3;
                        }
                        b2 = this.d[n4].a;
                        c2 = b2.a;
                        if (c2 != d2.u$c.h) break block5;
                        f2 = Math.max((float)n3, (float)b2.b);
                        break block6;
                    }
                    n5 = n3;
                    if (c2 != d2.u$c.g) break block7;
                    f2 = Math.max((float)n3, (float)((float)n2 * b2.b));
                }
                n5 = (int)f2;
            }
            ++n4;
            n3 = n5;
        }
    }

    public a e(int[] nArray) {
        int n2;
        int n3 = n2 = this.g(nArray);
        if (n2 < 0) {
            n3 = this.g(StateSet.WILD_CARD);
        }
        if (n3 < 0) {
            return this.b;
        }
        return this.d[n3];
    }

    public static class a {
        public b a;

        a(b b2) {
            this.a = b2;
        }
    }

    public static class b {
        c a;
        float b;

        b(c c2, float f2) {
            this.a = c2;
            this.b = f2;
        }

        public int a(int n2) {
            c c2 = this.a;
            if (c2 == d2.u$c.g) {
                return (int)(this.b * (float)n2);
            }
            if (c2 == d2.u$c.h) {
                return (int)this.b;
            }
            return 0;
        }
    }

    public static final class c
    extends Enum {
        public static final /* enum */ c g = new c("PERCENT", 0);
        public static final /* enum */ c h = new c("PIXELS", 1);
        private static final c[] i = d2.u$c.d();

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private c() {
            void var2_-1;
            void var1_-1;
        }

        private static /* synthetic */ c[] d() {
            return new c[]{g, h};
        }

        public static c valueOf(String string) {
            return (c)Enum.valueOf(c.class, (String)string);
        }

        public static c[] values() {
            return (c[])i.clone();
        }
    }
}

