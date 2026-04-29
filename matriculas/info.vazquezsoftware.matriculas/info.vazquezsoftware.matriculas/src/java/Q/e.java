/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.method.KeyListener
 *  android.view.KeyEvent
 *  android.view.View
 *  androidx.emoji2.text.f
 *  java.lang.Object
 */
package Q;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.f;

final class e
implements KeyListener {
    private final KeyListener a;
    private final a b;

    e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    e(KeyListener keyListener, a a2) {
        this.a = keyListener;
        this.b = a2;
    }

    public void clearMetaKeyState(View view, Editable editable, int n2) {
        this.a.clearMetaKeyState(view, editable, n2);
    }

    public int getInputType() {
        return this.a.getInputType();
    }

    public boolean onKeyDown(View view, Editable editable, int n2, KeyEvent keyEvent) {
        return this.b.a(editable, n2, keyEvent) || this.a.onKeyDown(view, editable, n2, keyEvent);
        {
        }
    }

    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.a.onKeyOther(view, editable, keyEvent);
    }

    public boolean onKeyUp(View view, Editable editable, int n2, KeyEvent keyEvent) {
        return this.a.onKeyUp(view, editable, n2, keyEvent);
    }

    public static class a {
        public boolean a(Editable editable, int n2, KeyEvent keyEvent) {
            return f.g((Editable)editable, (int)n2, (KeyEvent)keyEvent);
        }
    }
}

