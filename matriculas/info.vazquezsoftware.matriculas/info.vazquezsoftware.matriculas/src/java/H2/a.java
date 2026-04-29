/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Status
 *  j2.a
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 */
package h2;

import com.google.android.gms.common.api.Status;
import java.util.Locale;
import v1.b;

public class a
extends b {
    public a(int n2) {
        super(new Status(n2, String.format((Locale)Locale.getDefault(), (String)"Review Error(%d): %s", (Object[])new Object[]{n2, j2.a.a((int)n2)})));
    }
}

