/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 */
package b1;

import T0.h;
import T0.s;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;

public final class p2 {
    private final h[] a;
    private final String b;

    public p2(Context context, AttributeSet object) {
        boolean bl;
        block7: {
            block6: {
                boolean bl2;
                String string;
                block5: {
                    context = context.getResources().obtainAttributes(object, s.a);
                    object = context.getString(s.b);
                    string = context.getString(s.c);
                    bl = TextUtils.isEmpty((CharSequence)object);
                    bl2 = TextUtils.isEmpty((CharSequence)string);
                    if (bl || !bl2) break block5;
                    this.a = p2.c((String)object);
                    break block6;
                }
                if (!bl || bl2) break block7;
                this.a = p2.c(string);
            }
            object = context.getString(s.d);
            this.b = object;
            context.recycle();
            if (!TextUtils.isEmpty((CharSequence)object)) {
                return;
            }
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
        if (!bl) {
            context.recycle();
            throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
        }
        context.recycle();
        throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
    }

    private static h[] c(String string) {
        String[] stringArray = string.split("\\s*,\\s*");
        int n3 = stringArray.length;
        h[] hArray = new h[n3];
        for (int i3 = 0; i3 < stringArray.length; ++i3) {
            String string2 = stringArray[i3].trim();
            if (string2.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                int n4;
                int n5;
                Object object;
                block18: {
                    String string3;
                    block17: {
                        object = string2.split("[xX]");
                        object[0] = object[0].trim();
                        object[1] = object[1].trim();
                        string3 = object[0];
                        try {
                            if (!"FULL_WIDTH".equals((Object)string3)) break block17;
                            n5 = -1;
                        }
                        catch (NumberFormatException numberFormatException) {
                            throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": ".concat(string2));
                        }
                    }
                    n5 = Integer.parseInt((String)string3);
                    object = object[1];
                    if (!"AUTO_HEIGHT".equals(object)) break block18;
                    n4 = -2;
                }
                n4 = Integer.parseInt((String)object);
                hArray[i3] = new h(n5, n4);
                continue;
            }
            if ("BANNER".equals((Object)string2)) {
                hArray[i3] = h.j;
                continue;
            }
            if ("LARGE_BANNER".equals((Object)string2)) {
                hArray[i3] = h.l;
                continue;
            }
            if ("FULL_BANNER".equals((Object)string2)) {
                hArray[i3] = h.k;
                continue;
            }
            if ("LEADERBOARD".equals((Object)string2)) {
                hArray[i3] = h.m;
                continue;
            }
            if ("MEDIUM_RECTANGLE".equals((Object)string2)) {
                hArray[i3] = h.n;
                continue;
            }
            if ("SMART_BANNER".equals((Object)string2)) {
                hArray[i3] = h.p;
                continue;
            }
            if ("WIDE_SKYSCRAPER".equals((Object)string2)) {
                hArray[i3] = h.o;
                continue;
            }
            if ("FLUID".equals((Object)string2)) {
                hArray[i3] = h.q;
                continue;
            }
            if ("ICON".equals((Object)string2)) {
                hArray[i3] = h.s;
                continue;
            }
            throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": ".concat(string2));
        }
        if (n3 != 0) {
            return hArray;
        }
        throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": ".concat(string));
    }

    public final h[] a(boolean bl) {
        if (!bl && this.a.length != 1) {
            throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
        }
        return this.a;
    }

    public final String b() {
        return this.b;
    }
}

