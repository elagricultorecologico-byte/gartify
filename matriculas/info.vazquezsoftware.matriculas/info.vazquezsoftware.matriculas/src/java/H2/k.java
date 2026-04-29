/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.Override
 */
package h2;

import L1.j;
import android.os.Bundle;
import h2.m;
import i2.g;
import i2.i;

abstract class k
extends g {
    final i g;
    final j h;
    final m i;

    k(m m2, i i2, j j2) {
        this.i = m2;
        this.g = i2;
        this.h = j2;
    }

    @Override
    public void u0(Bundle bundle) {
        bundle = this.i.a;
        if (bundle != null) {
            bundle.u(this.h);
        }
        this.g.c("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}

