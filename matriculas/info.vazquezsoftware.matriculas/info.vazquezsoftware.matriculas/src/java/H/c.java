/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  androidx.core.graphics.drawable.a
 *  java.lang.Object
 *  java.lang.Runnable
 */
package h;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

public abstract class c
extends Drawable
implements Drawable.Callback {
    private Drawable g;

    public c(Drawable drawable) {
        this.a(drawable);
    }

    public void a(Drawable drawable) {
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.g = drawable;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this);
        }
    }

    public void draw(Canvas canvas) {
        this.g.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.g.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.g.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.g.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.g.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.g.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.g.getMinimumWidth();
    }

    public int getOpacity() {
        return this.g.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.g.getPadding(rect);
    }

    public int[] getState() {
        return this.g.getState();
    }

    public Region getTransparentRegion() {
        return this.g.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        this.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return a.h((Drawable)this.g);
    }

    public boolean isStateful() {
        return this.g.isStateful();
    }

    public void jumpToCurrentState() {
        this.g.jumpToCurrentState();
    }

    protected void onBoundsChange(Rect rect) {
        this.g.setBounds(rect);
    }

    protected boolean onLevelChange(int n3) {
        return this.g.setLevel(n3);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l3) {
        this.scheduleSelf(runnable, l3);
    }

    public void setAlpha(int n3) {
        this.g.setAlpha(n3);
    }

    public void setAutoMirrored(boolean bl) {
        a.j((Drawable)this.g, (boolean)bl);
    }

    public void setChangingConfigurations(int n3) {
        this.g.setChangingConfigurations(n3);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.g.setColorFilter(colorFilter);
    }

    public void setDither(boolean bl) {
        this.g.setDither(bl);
    }

    public void setFilterBitmap(boolean bl) {
        this.g.setFilterBitmap(bl);
    }

    public void setHotspot(float f3, float f4) {
        a.k((Drawable)this.g, (float)f3, (float)f4);
    }

    public void setHotspotBounds(int n3, int n4, int n5, int n6) {
        a.l((Drawable)this.g, (int)n3, (int)n4, (int)n5, (int)n6);
    }

    public boolean setState(int[] nArray) {
        return this.g.setState(nArray);
    }

    public void setTint(int n3) {
        a.n((Drawable)this.g, (int)n3);
    }

    public void setTintList(ColorStateList colorStateList) {
        a.o((Drawable)this.g, (ColorStateList)colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        a.p((Drawable)this.g, (PorterDuff.Mode)mode);
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        return super.setVisible(bl, bl2) || this.g.setVisible(bl, bl2);
        {
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.unscheduleSelf(runnable);
    }
}

