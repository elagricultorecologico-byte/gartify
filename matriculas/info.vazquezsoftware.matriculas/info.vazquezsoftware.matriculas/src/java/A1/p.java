/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  java.lang.Object
 *  java.util.Objects
 */
package a1;

import a1.s;
import android.view.MotionEvent;
import android.view.View;
import java.util.Objects;

final class p
implements View.OnTouchListener {
    p(s s2) {
        Objects.requireNonNull((Object)s2);
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}

