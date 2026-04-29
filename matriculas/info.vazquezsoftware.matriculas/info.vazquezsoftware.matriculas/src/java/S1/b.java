/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  com.google.android.material.chip.Chip
 *  java.lang.Object
 */
package S1;

import android.widget.CompoundButton;
import com.google.android.material.chip.Chip;

public final class b
implements CompoundButton.OnCheckedChangeListener {
    public final Chip a;

    public /* synthetic */ b(Chip chip) {
        this.a = chip;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl) {
        Chip.b((Chip)this.a, (CompoundButton)compoundButton, (boolean)bl);
    }
}

