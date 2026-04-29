/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  android.view.ViewGroup
 *  androidx.fragment.app.f
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package T;

import T.g;
import V2.k;
import android.view.ViewGroup;
import androidx.fragment.app.f;

public final class d
extends g {
    private final ViewGroup h;

    public d(f f2, ViewGroup viewGroup) {
        k.e((Object)f2, (String)"fragment");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Attempting to use <fragment> tag to add fragment ");
        stringBuilder.append((Object)f2);
        stringBuilder.append(" to container ");
        stringBuilder.append((Object)viewGroup);
        super(f2, stringBuilder.toString());
        this.h = viewGroup;
    }
}

