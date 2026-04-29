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
 *  android.util.StateSet
 *  android.util.Xml
 *  java.io.IOException
 *  java.lang.Object
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
import android.util.StateSet;
import android.util.Xml;
import d2.a;
import d2.d;
import d2.l;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class s {
    int a;
    private d b;
    int[][] c = new int[10][];
    d[] d = new d[10];

    private void a(int[] nArray, d d2) {
        int n2 = this.a;
        if (n2 == 0 || nArray.length == 0) {
            this.b = d2;
        }
        if (n2 >= this.c.length) {
            this.f(n2, n2 + 10);
        }
        int[][] nArray2 = this.c;
        n2 = this.a;
        nArray2[n2] = nArray;
        this.d[n2] = d2;
        this.a = n2 + 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static s b(Context object, TypedArray typedArray, int n2, d d2) {
        Throwable throwable2;
        block12: {
            s s2;
            block13: {
                int n3 = typedArray.getResourceId(n2, 0);
                if (n3 == 0) {
                    return s.c(l.m(typedArray, n2, d2));
                }
                if (!object.getResources().getResourceTypeName(n3).equals((Object)"xml")) {
                    return s.c(l.m(typedArray, n2, d2));
                }
                typedArray = object.getResources().getXml(n3);
                try {
                    s2 = new s();
                    AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)typedArray);
                    while ((n2 = typedArray.next()) != 2 && n2 != 1) {
                    }
                    if (n2 != 2) break block12;
                    if (!typedArray.getName().equals((Object)"selector")) break block13;
                    s2.i((Context)object, (XmlPullParser)typedArray, attributeSet, object.getTheme());
                }
                catch (Throwable throwable2) {}
            }
            typedArray.close();
            return s2;
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
                return s.c(d2);
            }
        }
    }

    public static s c(d d2) {
        s s2 = new s();
        s2.a(StateSet.WILD_CARD, d2);
        return s2;
    }

    private void f(int n2, int n3) {
        Object object = new int[n3][];
        System.arraycopy((Object)this.c, (int)0, (Object)object, (int)0, (int)n2);
        this.c = object;
        object = new d[n3];
        System.arraycopy((Object)this.d, (int)0, (Object)object, (int)0, (int)n2);
        this.d = (d[])object;
    }

    private int g(int[] nArray) {
        int[][] nArray2 = this.c;
        for (int i2 = 0; i2 < this.a; ++i2) {
            if (!StateSet.stateSetMatches((int[])nArray2[i2], (int[])nArray)) continue;
            return i2;
        }
        return -1;
    }

    private void i(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int n2;
        int n3;
        int n4 = xmlPullParser.getDepth() + 1;
        while ((n3 = xmlPullParser.next()) != 1 && ((n2 = xmlPullParser.getDepth()) >= n4 || n3 != 3)) {
            if (n3 != 2 || n2 > n4 || !xmlPullParser.getName().equals((Object)"item")) continue;
            Object object = context.getResources();
            object = theme == null ? object.obtainAttributes(attributeSet, j.p4) : theme.obtainStyledAttributes(attributeSet, j.p4, 0, 0);
            d d2 = l.m((TypedArray)object, j.v4, new a(0.0f));
            object.recycle();
            int n5 = attributeSet.getAttributeCount();
            object = new int[n5];
            n2 = 0;
            for (n3 = 0; n3 < n5; ++n3) {
                int n6 = attributeSet.getAttributeNameResource(n3);
                int n7 = n2;
                if (n6 != M1.a.g) {
                    n7 = attributeSet.getAttributeBooleanValue(n3, false) ? n6 : -n6;
                    object[n2] = (Resources)n7;
                    n7 = n2 + 1;
                }
                n2 = n7;
            }
            this.a(StateSet.trimStateSet((int[])object, (int)n2), d2);
        }
    }

    public d d(int[] nArray) {
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

    public d e() {
        return this.b;
    }

    public boolean h() {
        return this.a > 1;
    }
}

