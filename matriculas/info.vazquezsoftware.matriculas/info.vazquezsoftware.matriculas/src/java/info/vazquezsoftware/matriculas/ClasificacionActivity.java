/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.MenuItem
 *  androidx.appcompat.app.d
 *  java.lang.Object
 */
package info.vazquezsoftware.matriculas;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.d;

public class ClasificacionActivity
extends d {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131492892);
        this.c0().r(true);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.finish();
        return true;
    }
}

