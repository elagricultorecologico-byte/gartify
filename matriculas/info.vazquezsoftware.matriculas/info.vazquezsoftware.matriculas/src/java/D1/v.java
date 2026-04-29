/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.renderscript.Allocation
 *  android.renderscript.Element
 *  android.renderscript.RenderScript
 *  android.renderscript.ScriptIntrinsicBlur
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.util.Objects
 */
package d1;

import a1.l;
import a1.t;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import d1.B;
import d1.u;
import e1.F0;
import java.util.Objects;

final class v
extends e1.B {
    final B c;

    /* synthetic */ v(B b2, byte[] byArray) {
        Objects.requireNonNull((Object)b2);
        this.c = b2;
    }

    @Override
    public final void a() {
        B b2 = this.c;
        Bitmap bitmap = t.C().a(b2.h.u.l);
        if (bitmap != null) {
            t.g();
            l l2 = b2.h.u;
            boolean bl = l2.j;
            float f2 = l2.k;
            b2 = b2.g;
            if (bl && !(f2 <= 0.0f) && !(f2 > 25.0f)) {
                try {
                    Bitmap bitmap2 = Bitmap.createScaledBitmap((Bitmap)bitmap, (int)bitmap.getWidth(), (int)bitmap.getHeight(), (boolean)false);
                    Bitmap bitmap3 = Bitmap.createBitmap((Bitmap)bitmap2);
                    RenderScript renderScript = RenderScript.create((Context)b2);
                    l2 = ScriptIntrinsicBlur.create((RenderScript)renderScript, (Element)Element.U8_4((RenderScript)renderScript));
                    bitmap2 = Allocation.createFromBitmap((RenderScript)renderScript, (Bitmap)bitmap2);
                    renderScript = Allocation.createFromBitmap((RenderScript)renderScript, (Bitmap)bitmap3);
                    l2.setRadius(f2);
                    l2.setInput((Allocation)bitmap2);
                    l2.forEach((Allocation)renderScript);
                    renderScript.copyTo(bitmap3);
                    l2 = new BitmapDrawable(b2.getResources(), bitmap3);
                }
                catch (RuntimeException runtimeException) {
                    l2 = new BitmapDrawable(b2.getResources(), bitmap);
                }
            } else {
                l2 = new BitmapDrawable(b2.getResources(), bitmap);
            }
            F0.l.post((Runnable)new u(this, (Drawable)l2));
        }
    }
}

