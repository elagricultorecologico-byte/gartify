/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeProvider
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package E;

import E.y;
import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

public class z {
    private final Object a;

    public z() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new b(this);
            return;
        }
        this.a = new a(this);
    }

    public z(Object object) {
        this.a = object;
    }

    public void a(int n2, y y2, String string, Bundle bundle) {
    }

    public y b(int n2) {
        return null;
    }

    public List c(String string, int n2) {
        return null;
    }

    public y d(int n2) {
        return null;
    }

    public Object e() {
        return this.a;
    }

    public boolean f(int n2, int n3, Bundle bundle) {
        return false;
    }

    static class a
    extends AccessibilityNodeProvider {
        final z a;

        a(z z2) {
            this.a = z2;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int n2) {
            y y2 = this.a.b(n2);
            if (y2 == null) {
                return null;
            }
            return y2.N0();
        }

        public List findAccessibilityNodeInfosByText(String string, int n2) {
            if ((string = this.a.c(string, n2)) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int n3 = string.size();
            for (n2 = 0; n2 < n3; ++n2) {
                arrayList.add((Object)((y)string.get(n2)).N0());
            }
            return arrayList;
        }

        public AccessibilityNodeInfo findFocus(int n2) {
            y y2 = this.a.d(n2);
            if (y2 == null) {
                return null;
            }
            return y2.N0();
        }

        public boolean performAction(int n2, int n3, Bundle bundle) {
            return this.a.f(n2, n3, bundle);
        }
    }

    static class b
    extends a {
        b(z z2) {
            super(z2);
        }

        public void addExtraDataToAccessibilityNodeInfo(int n2, AccessibilityNodeInfo accessibilityNodeInfo, String string, Bundle bundle) {
            this.a.a(n2, y.O0(accessibilityNodeInfo), string, bundle);
        }
    }
}

