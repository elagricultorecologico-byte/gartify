/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 */
package k;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import k.b;
import z.a;

public class d
extends b
implements Menu {
    private final a d;

    public d(Context context, a a2) {
        super(context);
        if (a2 != null) {
            this.d = a2;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(int n2) {
        return this.c(this.d.add(n2));
    }

    public MenuItem add(int n2, int n3, int n4, int n5) {
        return this.c(this.d.add(n2, n3, n4, n5));
    }

    public MenuItem add(int n2, int n3, int n4, CharSequence charSequence) {
        return this.c(this.d.add(n2, n3, n4, charSequence));
    }

    public MenuItem add(CharSequence charSequence) {
        return this.c(this.d.add(charSequence));
    }

    public int addIntentOptions(int n2, int n3, int n4, ComponentName componentName, Intent[] intentArray, Intent intent, int n5, MenuItem[] menuItemArray) {
        MenuItem[] menuItemArray2 = menuItemArray != null ? new MenuItem[menuItemArray.length] : null;
        n3 = this.d.addIntentOptions(n2, n3, n4, componentName, intentArray, intent, n5, menuItemArray2);
        if (menuItemArray2 != null) {
            n4 = menuItemArray2.length;
            for (n2 = 0; n2 < n4; ++n2) {
                menuItemArray[n2] = this.c(menuItemArray2[n2]);
            }
        }
        return n3;
    }

    public SubMenu addSubMenu(int n2) {
        return this.d(this.d.addSubMenu(n2));
    }

    public SubMenu addSubMenu(int n2, int n3, int n4, int n5) {
        return this.d(this.d.addSubMenu(n2, n3, n4, n5));
    }

    public SubMenu addSubMenu(int n2, int n3, int n4, CharSequence charSequence) {
        return this.d(this.d.addSubMenu(n2, n3, n4, charSequence));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return this.d(this.d.addSubMenu(charSequence));
    }

    public void clear() {
        this.e();
        this.d.clear();
    }

    public void close() {
        this.d.close();
    }

    public MenuItem findItem(int n2) {
        return this.c(this.d.findItem(n2));
    }

    public MenuItem getItem(int n2) {
        return this.c(this.d.getItem(n2));
    }

    public boolean hasVisibleItems() {
        return this.d.hasVisibleItems();
    }

    public boolean isShortcutKey(int n2, KeyEvent keyEvent) {
        return this.d.isShortcutKey(n2, keyEvent);
    }

    public boolean performIdentifierAction(int n2, int n3) {
        return this.d.performIdentifierAction(n2, n3);
    }

    public boolean performShortcut(int n2, KeyEvent keyEvent, int n3) {
        return this.d.performShortcut(n2, keyEvent, n3);
    }

    public void removeGroup(int n2) {
        this.f(n2);
        this.d.removeGroup(n2);
    }

    public void removeItem(int n2) {
        this.g(n2);
        this.d.removeItem(n2);
    }

    public void setGroupCheckable(int n2, boolean bl, boolean bl2) {
        this.d.setGroupCheckable(n2, bl, bl2);
    }

    public void setGroupEnabled(int n2, boolean bl) {
        this.d.setGroupEnabled(n2, bl);
    }

    public void setGroupVisible(int n2, boolean bl) {
        this.d.setGroupVisible(n2, bl);
    }

    public void setQwertyMode(boolean bl) {
        this.d.setQwertyMode(bl);
    }

    public int size() {
        return this.d.size();
    }
}

