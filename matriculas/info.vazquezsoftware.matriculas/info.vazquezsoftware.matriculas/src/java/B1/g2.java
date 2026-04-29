/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  f1.g
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 */
package b1;

import T0.t;
import android.content.Context;
import android.os.Bundle;
import b1.c2;
import b1.f2;
import b1.i1;
import b1.t1;
import b1.x;
import com.google.ads.mediation.admob.AdMobAdapter;
import f1.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class g2 {
    public static final g2 a = new g2();

    protected g2() {
    }

    public final c2 a(Context object, i1 i12) {
        String string = i12.a();
        Object object2 = i12.c();
        object2 = !object2.isEmpty() ? Collections.unmodifiableList((List)new ArrayList((Collection)object2)) : null;
        boolean bl = i12.g((Context)object);
        Bundle bundle = i12.d(AdMobAdapter.class);
        String string2 = i12.e();
        object = object.getApplicationContext();
        if (object != null) {
            object = object.getPackageName();
            x.a();
            object = g.D((StackTraceElement[])Thread.currentThread().getStackTrace(), (String)object);
        } else {
            object = null;
        }
        boolean bl2 = i12.l();
        t t2 = t1.e().i();
        int n3 = Math.max((int)i12.i(), (int)t2.c());
        String string3 = (String)Collections.max((Collection)Arrays.asList((Object[])new String[]{null, t2.a()}), (Comparator)f2.g);
        List list = i12.b();
        return new c2(8, -1L, bundle, -1, (List)object2, bl, n3, false, string2, null, null, string, i12.h(), i12.j(), Collections.unmodifiableList((List)new ArrayList((Collection)i12.k())), i12.f(), (String)object, bl2, null, t2.d(), string3, list, i12.n(), i12.m(), t2.b().d(), i12.p(), i12.q());
    }
}

