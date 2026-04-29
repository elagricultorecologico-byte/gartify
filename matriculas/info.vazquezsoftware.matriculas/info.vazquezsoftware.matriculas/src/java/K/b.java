/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  java.lang.Object
 */
package k;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import k.c;
import p.i;

abstract class b {
    final Context a;
    private i b;
    private i c;

    b(Context context) {
        this.a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        if (menuItem instanceof z.b) {
            MenuItem menuItem2;
            z.b b2 = (z.b)menuItem;
            if (this.b == null) {
                this.b = new i();
            }
            menuItem = menuItem2 = (MenuItem)this.b.get(b2);
            if (menuItem2 == null) {
                menuItem = new c(this.a, b2);
                this.b.put(b2, menuItem);
            }
            return menuItem;
        }
        return menuItem;
    }

    final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }

    final void e() {
        i i2 = this.b;
        if (i2 != null) {
            i2.clear();
        }
        if ((i2 = this.c) != null) {
            i2.clear();
        }
    }

    final void f(int n2) {
        if (this.b != null) {
            int n3 = 0;
            while (n3 < this.b.size()) {
                int n4 = n3;
                if (((z.b)this.b.f(n3)).getGroupId() == n2) {
                    this.b.h(n3);
                    n4 = n3 - 1;
                }
                n3 = n4 + 1;
            }
        }
    }

    final void g(int n2) {
        if (this.b != null) {
            for (int i2 = 0; i2 < this.b.size(); ++i2) {
                if (((z.b)this.b.f(i2)).getItemId() != n2) continue;
                this.b.h(i2);
                return;
            }
        }
    }
}

