/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package b1;

import T0.t;
import android.os.Bundle;
import b1.c2;
import java.util.ArrayList;
import java.util.List;

public final class d2 {
    private Bundle a = new Bundle();
    private List b = new ArrayList();
    private boolean c = false;
    private int d = -1;
    private final Bundle e = new Bundle();
    private final Bundle f = new Bundle();
    private final List g = new ArrayList();
    private int h = -1;
    private String i = null;
    private final List j = new ArrayList();
    private int k = 60000;
    private final int l = t.b.h.d();
    private long m = 0L;

    public final c2 a() {
        Bundle bundle = this.a;
        Bundle bundle2 = this.e;
        List list = this.b;
        boolean bl = this.c;
        int n3 = this.d;
        int n4 = this.h;
        String string = this.i;
        List list2 = this.j;
        int n5 = this.l;
        Bundle bundle3 = this.f;
        int n6 = this.k;
        long l3 = this.m;
        return new c2(8, -1L, bundle, -1, list, bl, n3, false, null, null, null, null, bundle2, bundle3, this.g, null, null, false, null, n4, string, list2, n6, null, n5, l3, 0L);
    }

    public final d2 b(Bundle bundle) {
        this.a = bundle;
        return this;
    }

    public final d2 c(List list) {
        this.b = list;
        return this;
    }

    public final d2 d(boolean bl) {
        this.c = bl;
        return this;
    }

    public final d2 e(int n3) {
        this.d = n3;
        return this;
    }

    public final d2 f(int n3) {
        this.h = n3;
        return this;
    }

    public final d2 g(String string) {
        this.i = string;
        return this;
    }

    public final d2 h(int n3) {
        this.k = n3;
        return this;
    }

    public final d2 i(long l3) {
        this.m = l3;
        return this;
    }
}

