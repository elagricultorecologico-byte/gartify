/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.InputFilter
 *  android.text.Selection
 *  android.text.Spannable
 *  android.text.Spanned
 *  android.widget.TextView
 *  androidx.emoji2.text.f
 *  androidx.emoji2.text.f$f
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.ref.Reference
 *  java.lang.ref.WeakReference
 */
package Q;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.f;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class d
implements InputFilter {
    private final TextView a;
    private f.f b;

    d(TextView textView) {
        this.a = textView;
    }

    private f.f a() {
        if (this.b == null) {
            this.b = new a(this.a, this);
        }
        return this.b;
    }

    static void b(Spannable spannable, int n2, int n3) {
        if (n2 >= 0 && n3 >= 0) {
            Selection.setSelection((Spannable)spannable, (int)n2, (int)n3);
            return;
        }
        if (n2 >= 0) {
            Selection.setSelection((Spannable)spannable, (int)n2);
            return;
        }
        if (n3 >= 0) {
            Selection.setSelection((Spannable)spannable, (int)n3);
        }
    }

    public CharSequence filter(CharSequence charSequence, int n2, int n3, Spanned spanned, int n4, int n5) {
        block5: {
            block4: {
                block6: {
                    block3: {
                        if (!this.a.isInEditMode()) break block3;
                        spanned = charSequence;
                        break block4;
                    }
                    int n6 = f.c().e();
                    if (n6 == 0) break block5;
                    if (n6 == 1) break block6;
                    if (n6 == 3) break block5;
                    spanned = charSequence;
                    break block4;
                }
                if (n5 == 0 && n4 == 0 && spanned.length() == 0 && charSequence == this.a.getText()) {
                    return charSequence;
                }
                spanned = charSequence;
                if (charSequence != null) {
                    if (n2 != 0 || n3 != charSequence.length()) {
                        charSequence = charSequence.subSequence(n2, n3);
                    }
                    spanned = f.c().q(charSequence, 0, charSequence.length());
                }
            }
            return spanned;
        }
        f.c().t(this.a());
        return charSequence;
    }

    private static class a
    extends f.f {
        private final Reference a;
        private final Reference b;

        a(TextView textView, d d2) {
            this.a = new WeakReference((Object)textView);
            this.b = new WeakReference((Object)d2);
        }

        private boolean c(TextView inputFilterArray, InputFilter inputFilter) {
            if (inputFilter != null && inputFilterArray != null) {
                if ((inputFilterArray = inputFilterArray.getFilters()) == null) {
                    return false;
                }
                for (int i2 = 0; i2 < inputFilterArray.length; ++i2) {
                    if (inputFilterArray[i2] != inputFilter) continue;
                    return true;
                }
            }
            return false;
        }

        public void b() {
            CharSequence charSequence;
            CharSequence charSequence2;
            super.b();
            TextView textView = (TextView)this.a.get();
            if (this.c(textView, (InputFilter)this.b.get()) && textView.isAttachedToWindow() && (charSequence2 = textView.getText()) != (charSequence = f.c().p(charSequence2))) {
                int n2 = Selection.getSelectionStart((CharSequence)charSequence);
                int n3 = Selection.getSelectionEnd((CharSequence)charSequence);
                textView.setText(charSequence);
                if (charSequence instanceof Spannable) {
                    d.b((Spannable)charSequence, n2, n3);
                }
            }
        }
    }
}

