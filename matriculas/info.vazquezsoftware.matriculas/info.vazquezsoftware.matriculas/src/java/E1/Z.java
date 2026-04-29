/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.B9
 *  com.google.android.gms.internal.ads.G9
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Q8
 *  com.google.android.gms.internal.ads.Uj0
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.Z8
 *  com.google.android.gms.internal.ads.c9
 *  com.google.android.gms.internal.ads.g9
 *  com.google.android.gms.internal.ads.i9
 *  com.google.android.gms.internal.ads.t9
 *  com.google.android.gms.internal.ads.u9
 *  com.google.android.gms.internal.ads.vn
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.Pattern
 */
package e1;

import android.content.Context;
import b1.A;
import b1.x;
import com.google.android.gms.internal.ads.B9;
import com.google.android.gms.internal.ads.G9;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Q8;
import com.google.android.gms.internal.ads.Uj0;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.Z8;
import com.google.android.gms.internal.ads.c9;
import com.google.android.gms.internal.ads.g9;
import com.google.android.gms.internal.ads.i9;
import com.google.android.gms.internal.ads.t9;
import com.google.android.gms.internal.ads.u9;
import com.google.android.gms.internal.ads.vn;
import e1.o0;
import f1.g;
import java.io.File;
import java.util.regex.Pattern;

public final class z
extends u9 {
    private final Context c;

    private z(Context context, t9 t92) {
        super(t92);
        this.c = context;
    }

    public static i9 b(Context context) {
        z z2 = new z(context, (t9)new G9(null, null));
        context = new i9((Q8)new B9(new File(Uj0.a().a(context.getCacheDir(), "admob_volley")), 0x1400000), (Z8)z2, 4);
        context.a();
        return context;
    }

    public final c9 a(g9 g92) {
        if (g92.a() == 0) {
            String string = g92.j();
            Oi oi = Yi.r5;
            if (Pattern.matches((String)((String)A.c().d(oi)), (CharSequence)string)) {
                string = this.c;
                x.a();
                if (g.F((Context)string, 0xCC77C0)) {
                    if ((string = new vn((Context)string).a(g92)) != null) {
                        o0.k("Got gmscore asset response: ".concat(String.valueOf((Object)g92.j())));
                        return string;
                    }
                    o0.k("Failed to get gmscore asset response: ".concat(String.valueOf((Object)g92.j())));
                }
            }
        }
        return super.a(g92);
    }
}

