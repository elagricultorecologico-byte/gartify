/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.text.method.TransformationMethod
 *  android.view.View
 *  androidx.emoji2.text.f
 *  java.lang.CharSequence
 *  java.lang.Object
 */
package Q;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.f;

class h
implements TransformationMethod {
    private final TransformationMethod a;

    h(TransformationMethod transformationMethod) {
        this.a = transformationMethod;
    }

    public TransformationMethod a() {
        return this.a;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.a;
        CharSequence charSequence2 = charSequence;
        if (transformationMethod != null) {
            charSequence2 = transformationMethod.getTransformation(charSequence, view);
        }
        charSequence = charSequence2;
        if (charSequence2 != null) {
            charSequence = f.c().e() != 1 ? charSequence2 : f.c().p(charSequence2);
        }
        return charSequence;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean bl, int n2, Rect rect) {
        TransformationMethod transformationMethod = this.a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, bl, n2, rect);
        }
    }
}

