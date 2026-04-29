/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.Selection
 *  android.text.Spannable
 *  android.text.TextWatcher
 *  android.widget.EditText
 *  androidx.emoji2.text.f
 *  androidx.emoji2.text.f$f
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.ref.Reference
 *  java.lang.ref.WeakReference
 */
package Q;

import Q.d;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.f;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class g
implements TextWatcher {
    private final EditText g;
    private final boolean h;
    private f.f i;
    private int j = Integer.MAX_VALUE;
    private int k = 0;
    private boolean l;

    g(EditText editText, boolean bl) {
        this.g = editText;
        this.h = bl;
        this.l = true;
    }

    private f.f a() {
        if (this.i == null) {
            this.i = new a(this.g);
        }
        return this.i;
    }

    static void b(EditText editText, int n2) {
        if (n2 == 1 && editText != null && editText.isAttachedToWindow()) {
            editText = editText.getEditableText();
            int n3 = Selection.getSelectionStart((CharSequence)editText);
            n2 = Selection.getSelectionEnd((CharSequence)editText);
            f.c().p((CharSequence)editText);
            d.b((Spannable)editText, n3, n2);
        }
    }

    private boolean d() {
        return !this.l || !this.h && !f.i();
        {
        }
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
    }

    public void c(boolean bl) {
        if (this.l != bl) {
            if (this.i != null) {
                f.c().u(this.i);
            }
            this.l = bl;
            if (bl) {
                Q.g.b(this.g, f.c().e());
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int n2, int n3, int n4) {
        block0: {
            block1: {
                block2: {
                    if (this.g.isInEditMode() || this.d() || n3 > n4 || !(charSequence instanceof Spannable)) break block0;
                    n3 = f.c().e();
                    if (n3 == 0) break block1;
                    if (n3 == 1) break block2;
                    if (n3 == 3) break block1;
                    break block0;
                }
                charSequence = (Spannable)charSequence;
                f.c().s(charSequence, n2, n2 + n4, this.j, this.k);
                return;
            }
            f.c().t(this.a());
        }
    }

    private static class a
    extends f.f {
        private final Reference a;

        a(EditText editText) {
            this.a = new WeakReference((Object)editText);
        }

        public void b() {
            super.b();
            Q.g.b((EditText)this.a.get(), 1);
        }
    }
}

