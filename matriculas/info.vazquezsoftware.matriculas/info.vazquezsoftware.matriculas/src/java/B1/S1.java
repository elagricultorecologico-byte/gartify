/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.Cn
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Objects
 */
package b1;

import Z0.b;
import Z0.c;
import b1.t1;
import com.google.android.gms.internal.ads.Cn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

final class s1
extends Cn {
    final t1 g;

    /* synthetic */ s1(t1 t12, byte[] byArray) {
        Objects.requireNonNull((Object)t12);
        this.g = t12;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b3(List object) {
        ArrayList arrayList;
        int n3;
        Object object2;
        t1 t12 = this.g;
        Object object3 = object2 = t12.n();
        synchronized (object3) {
            n3 = 0;
            t12.p(false);
            t12.q(true);
            arrayList = new ArrayList((Collection)t12.o());
            t12.o().clear();
        }
        object = t1.m(object);
        int n4 = arrayList.size();
        while (n3 < n4) {
            ((c)arrayList.get(n3)).a((b)object);
            ++n3;
        }
        return;
    }
}

