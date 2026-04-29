/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  android.view.ActionProvider
 *  android.view.ActionProvider$VisibilityListener
 *  android.view.CollapsibleActionView
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  android.widget.FrameLayout
 *  androidx.appcompat.view.c
 *  androidx.core.view.b
 *  androidx.core.view.b$b
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
package k;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.b;
import java.lang.reflect.Method;

public class c
extends k.b
implements MenuItem {
    private final z.b d;
    private Method e;

    public c(Context context, z.b b2) {
        super(context);
        if (b2 != null) {
            this.d = b2;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.d.expandActionView();
    }

    public ActionProvider getActionProvider() {
        androidx.core.view.b b2 = this.d.b();
        if (b2 instanceof a) {
            return ((a)b2).e;
        }
        return null;
    }

    public View getActionView() {
        View view;
        View view2 = view = this.d.getActionView();
        if (view instanceof b) {
            view2 = ((b)view).a();
        }
        return view2;
    }

    public int getAlphabeticModifiers() {
        return this.d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.d.getContentDescription();
    }

    public int getGroupId() {
        return this.d.getGroupId();
    }

    public Drawable getIcon() {
        return this.d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.d.getIntent();
    }

    public int getItemId() {
        return this.d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.d.getNumericShortcut();
    }

    public int getOrder() {
        return this.d.getOrder();
    }

    public SubMenu getSubMenu() {
        return this.d(this.d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.d.getTooltipText();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h(boolean bl) {
        Exception exception2;
        block3: {
            block2: {
                try {
                    if (this.e != null) break block2;
                    this.e = this.d.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                }
                catch (Exception exception2) {
                    break block3;
                }
            }
            this.e.invoke((Object)this.d, new Object[]{bl});
            return;
        }
        Log.w((String)"MenuItemWrapper", (String)"Error while calling setExclusiveCheckable", (Throwable)exception2);
    }

    public boolean hasSubMenu() {
        return this.d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.d.isCheckable();
    }

    public boolean isChecked() {
        return this.d.isChecked();
    }

    public boolean isEnabled() {
        return this.d.isEnabled();
    }

    public boolean isVisible() {
        return this.d.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider object) {
        a a2 = new a(this, this.a, (ActionProvider)object);
        z.b b2 = this.d;
        object = object != null ? a2 : null;
        b2.a((androidx.core.view.b)object);
        return this;
    }

    public MenuItem setActionView(int n2) {
        this.d.setActionView(n2);
        View view = this.d.getActionView();
        if (view instanceof CollapsibleActionView) {
            this.d.setActionView((View)new b(view));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        Object object = view;
        if (view instanceof CollapsibleActionView) {
            object = new b(view);
        }
        this.d.setActionView((View)object);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.d.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int n2) {
        this.d.setAlphabeticShortcut(c2, n2);
        return this;
    }

    public MenuItem setCheckable(boolean bl) {
        this.d.setCheckable(bl);
        return this;
    }

    public MenuItem setChecked(boolean bl) {
        this.d.setChecked(bl);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean bl) {
        this.d.setEnabled(bl);
        return this;
    }

    public MenuItem setIcon(int n2) {
        this.d.setIcon(n2);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.d.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int n2) {
        this.d.setNumericShortcut(c2, n2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        z.b b2 = this.d;
        onActionExpandListener = onActionExpandListener != null ? new c(this, onActionExpandListener) : null;
        b2.setOnActionExpandListener(onActionExpandListener);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        z.b b2 = this.d;
        onMenuItemClickListener = onMenuItemClickListener != null ? new d(this, onMenuItemClickListener) : null;
        b2.setOnMenuItemClickListener(onMenuItemClickListener);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.d.setShortcut(c2, c3);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int n2, int n3) {
        this.d.setShortcut(c2, c3, n2, n3);
        return this;
    }

    public void setShowAsAction(int n2) {
        this.d.setShowAsAction(n2);
    }

    public MenuItem setShowAsActionFlags(int n2) {
        this.d.setShowAsActionFlags(n2);
        return this;
    }

    public MenuItem setTitle(int n2) {
        this.d.setTitle(n2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean bl) {
        return this.d.setVisible(bl);
    }

    private class a
    extends androidx.core.view.b
    implements ActionProvider.VisibilityListener {
        private b.b d;
        private final ActionProvider e;
        final c f;

        a(c c2, Context context, ActionProvider actionProvider) {
            this.f = c2;
            super(context);
            this.e = actionProvider;
        }

        public boolean a() {
            return this.e.hasSubMenu();
        }

        public boolean b() {
            return this.e.isVisible();
        }

        public View c(MenuItem menuItem) {
            return this.e.onCreateActionView(menuItem);
        }

        public boolean d() {
            return this.e.onPerformDefaultAction();
        }

        public void e(SubMenu subMenu) {
            this.e.onPrepareSubMenu(this.f.d(subMenu));
        }

        public boolean f() {
            return this.e.overridesItemVisibility();
        }

        public void i(b.b object) {
            this.d = object;
            ActionProvider actionProvider = this.e;
            object = object != null ? this : null;
            actionProvider.setVisibilityListener((ActionProvider.VisibilityListener)object);
        }

        public void onActionProviderVisibilityChanged(boolean bl) {
            b.b b2 = this.d;
            if (b2 != null) {
                b2.onActionProviderVisibilityChanged(bl);
            }
        }
    }

    static class b
    extends FrameLayout
    implements androidx.appcompat.view.c {
        final CollapsibleActionView g;

        b(View view) {
            super(view.getContext());
            this.g = (CollapsibleActionView)view;
            this.addView(view);
        }

        View a() {
            return (View)this.g;
        }

        public void c() {
            this.g.onActionViewExpanded();
        }

        public void f() {
            this.g.onActionViewCollapsed();
        }
    }

    private class c
    implements MenuItem.OnActionExpandListener {
        private final MenuItem.OnActionExpandListener a;
        final c b;

        c(c c2, MenuItem.OnActionExpandListener onActionExpandListener) {
            this.b = c2;
            this.a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.a.onMenuItemActionCollapse(this.b.c(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.a.onMenuItemActionExpand(this.b.c(menuItem));
        }
    }

    private class d
    implements MenuItem.OnMenuItemClickListener {
        private final MenuItem.OnMenuItemClickListener a;
        final c b;

        d(c c2, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.b = c2;
            this.a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.a.onMenuItemClick(this.b.c(menuItem));
        }
    }
}

