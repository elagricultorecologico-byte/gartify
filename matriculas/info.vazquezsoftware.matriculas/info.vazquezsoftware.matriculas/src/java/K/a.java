/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.view.ActionProvider
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.KeyEvent
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  androidx.core.content.a
 *  androidx.core.graphics.drawable.a
 *  androidx.core.view.b
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.UnsupportedOperationException
 */
package k;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.b;

public class a
implements z.b {
    private final int a;
    private final int b;
    private final int c;
    private CharSequence d;
    private CharSequence e;
    private Intent f;
    private char g;
    private int h = 4096;
    private char i;
    private int j = 4096;
    private Drawable k;
    private Context l;
    private MenuItem.OnMenuItemClickListener m;
    private CharSequence n;
    private CharSequence o;
    private ColorStateList p = null;
    private PorterDuff.Mode q = null;
    private boolean r = false;
    private boolean s = false;
    private int t = 16;

    public a(Context context, int n2, int n3, int n4, int n5, CharSequence charSequence) {
        this.l = context;
        this.a = n3;
        this.b = n2;
        this.c = n5;
        this.d = charSequence;
    }

    private void c() {
        Drawable drawable = this.k;
        if (drawable != null && (this.r || this.s)) {
            this.k = drawable = androidx.core.graphics.drawable.a.r((Drawable)drawable);
            this.k = drawable = drawable.mutate();
            if (this.r) {
                androidx.core.graphics.drawable.a.o((Drawable)drawable, (ColorStateList)this.p);
            }
            if (this.s) {
                androidx.core.graphics.drawable.a.p((Drawable)this.k, (PorterDuff.Mode)this.q);
            }
        }
    }

    @Override
    public z.b a(b b2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public b b() {
        return null;
    }

    @Override
    public boolean collapseActionView() {
        return false;
    }

    public z.b d(int n2) {
        throw new UnsupportedOperationException();
    }

    public z.b e(View view) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean expandActionView() {
        return false;
    }

    public z.b f(int n2) {
        this.setShowAsAction(n2);
        return this;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override
    public View getActionView() {
        return null;
    }

    @Override
    public int getAlphabeticModifiers() {
        return this.j;
    }

    public char getAlphabeticShortcut() {
        return this.i;
    }

    @Override
    public CharSequence getContentDescription() {
        return this.n;
    }

    public int getGroupId() {
        return this.b;
    }

    public Drawable getIcon() {
        return this.k;
    }

    @Override
    public ColorStateList getIconTintList() {
        return this.p;
    }

    @Override
    public PorterDuff.Mode getIconTintMode() {
        return this.q;
    }

    public Intent getIntent() {
        return this.f;
    }

    public int getItemId() {
        return this.a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override
    public int getNumericModifiers() {
        return this.h;
    }

    public char getNumericShortcut() {
        return this.g;
    }

    public int getOrder() {
        return this.c;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.d;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence;
        }
        return this.d;
    }

    @Override
    public CharSequence getTooltipText() {
        return this.o;
    }

    public boolean hasSubMenu() {
        return false;
    }

    @Override
    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.t & 1) != 0;
    }

    public boolean isChecked() {
        return (this.t & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.t & 0x10) != 0;
    }

    public boolean isVisible() {
        return (this.t & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.i = Character.toLowerCase((char)c2);
        return this;
    }

    @Override
    public MenuItem setAlphabeticShortcut(char c2, int n2) {
        this.i = Character.toLowerCase((char)c2);
        this.j = KeyEvent.normalizeMetaState((int)n2);
        return this;
    }

    public MenuItem setCheckable(boolean bl) {
        this.t = bl | this.t & 0xFFFFFFFE;
        return this;
    }

    public MenuItem setChecked(boolean bl) {
        int n2 = this.t;
        int n3 = bl ? 2 : 0;
        this.t = n3 | n2 & 0xFFFFFFFD;
        return this;
    }

    @Override
    public z.b setContentDescription(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    public MenuItem setEnabled(boolean bl) {
        int n2 = this.t;
        int n3 = bl ? 16 : 0;
        this.t = n3 | n2 & 0xFFFFFFEF;
        return this;
    }

    public MenuItem setIcon(int n2) {
        this.k = androidx.core.content.a.d((Context)this.l, (int)n2);
        this.c();
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.k = drawable;
        this.c();
        return this;
    }

    @Override
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.p = colorStateList;
        this.r = true;
        this.c();
        return this;
    }

    @Override
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.q = mode;
        this.s = true;
        this.c();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.g = c2;
        return this;
    }

    @Override
    public MenuItem setNumericShortcut(char c2, int n2) {
        this.g = c2;
        this.h = KeyEvent.normalizeMetaState((int)n2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.g = c2;
        this.i = Character.toLowerCase((char)c3);
        return this;
    }

    @Override
    public MenuItem setShortcut(char c2, char c3, int n2, int n3) {
        this.g = c2;
        this.h = KeyEvent.normalizeMetaState((int)n2);
        this.i = Character.toLowerCase((char)c3);
        this.j = KeyEvent.normalizeMetaState((int)n3);
        return this;
    }

    @Override
    public void setShowAsAction(int n2) {
    }

    public MenuItem setTitle(int n2) {
        this.d = this.l.getResources().getString(n2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.d = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.e = charSequence;
        return this;
    }

    @Override
    public z.b setTooltipText(CharSequence charSequence) {
        this.o = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean bl) {
        int n2 = this.t;
        int n3 = 8;
        if (bl) {
            n3 = 0;
        }
        this.t = n2 & 8 | n3;
        return this;
    }
}

