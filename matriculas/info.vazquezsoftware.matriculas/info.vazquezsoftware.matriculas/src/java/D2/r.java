/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.graphics.Path
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  com.google.android.material.drawable.e
 *  java.lang.Object
 *  java.lang.Override
 */
package d2;

import android.graphics.Outline;
import android.graphics.Path;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.drawable.e;
import d2.p;

class r
extends p {
    r(View view) {
        this.k(view);
    }

    private void k(View view) {
        view.setOutlineProvider(new ViewOutlineProvider(this){
            final r a;
            {
                this.a = r2;
            }

            public void getOutline(View view, Outline outline) {
                if (!this.a.e.isEmpty()) {
                    com.google.android.material.drawable.e.a((Outline)outline, (Path)this.a.e);
                }
            }
        });
    }

    @Override
    void b(View view) {
        view.setClipToOutline(this.i() ^ true);
        if (this.i()) {
            view.invalidate();
            return;
        }
        view.invalidateOutline();
    }

    @Override
    boolean i() {
        return this.a;
    }
}

