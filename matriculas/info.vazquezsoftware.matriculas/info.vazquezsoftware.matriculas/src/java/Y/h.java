/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Q
 *  androidx.lifecycle.S$c
 *  androidx.lifecycle.V
 *  androidx.lifecycle.j
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 */
package Y;

import V2.k;
import X.a;
import Y.a;
import Y.b;
import androidx.lifecycle.Q;
import androidx.lifecycle.S;
import androidx.lifecycle.V;
import androidx.lifecycle.j;

public final class h {
    public static final h a = new h();

    private h() {
    }

    public final X.a a(V v2) {
        k.e(v2, "owner");
        if (v2 instanceof j) {
            return ((j)v2).q();
        }
        return a.b.c;
    }

    public final S.c b(V v2) {
        k.e(v2, "owner");
        if (v2 instanceof j) {
            return ((j)v2).p();
        }
        return b.a;
    }

    public final String c(Z2.b object) {
        k.e(object, "modelClass");
        object = Y.a.a((Z2.b)object);
        if (object != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("androidx.lifecycle.ViewModelProvider.DefaultKey:");
            stringBuilder.append((String)object);
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final Q d() {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }
}

