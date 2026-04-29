/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.widget.RelativeLayout
 *  java.lang.Object
 *  java.lang.String
 */
package d1;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import e1.u;

final class s
extends RelativeLayout {
    final u g;
    boolean h;

    public s(Context object, String string, String string2, String string3) {
        super((Context)object);
        object = new u((Context)object, string);
        this.g = object;
        ((u)object).d(string2);
        ((u)object).c(string3);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.h) {
            this.g.a(motionEvent);
        }
        return false;
    }
}

