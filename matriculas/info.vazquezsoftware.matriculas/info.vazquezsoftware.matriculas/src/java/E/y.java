/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.SpannableString
 *  android.text.Spanned
 *  android.text.TextUtils
 *  android.text.style.ClickableSpan
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionInfo
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo$Builder
 *  android.view.accessibility.AccessibilityNodeInfo$ExtraRenderingInfo
 *  android.view.accessibility.AccessibilityNodeInfo$RangeInfo
 *  androidx.appcompat.app.E
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.time.Duration
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  y.c
 */
package E;

import E.B;
import E.g;
import E.h;
import E.i;
import E.j;
import E.k;
import E.l;
import E.m;
import E.n;
import E.o;
import E.p;
import E.q;
import E.r;
import E.s;
import E.t;
import E.u;
import E.v;
import E.w;
import E.x;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.app.E;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class y {
    private static int d;
    private final AccessibilityNodeInfo a;
    public int b = -1;
    private int c = -1;

    private y(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.a = accessibilityNodeInfo;
    }

    public y(Object object) {
        this.a = (AccessibilityNodeInfo)object;
    }

    private boolean F() {
        return this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty() ^ true;
    }

    private int G(ClickableSpan clickableSpan, SparseArray sparseArray) {
        int n2;
        if (sparseArray != null) {
            for (n2 = 0; n2 < sparseArray.size(); ++n2) {
                if (!clickableSpan.equals((Object)((ClickableSpan)((WeakReference)sparseArray.valueAt(n2)).get()))) continue;
                return sparseArray.keyAt(n2);
            }
        }
        n2 = d;
        d = n2 + 1;
        return n2;
    }

    public static y O0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new y(accessibilityNodeInfo);
    }

    static y P0(Object object) {
        if (object != null) {
            return new y(object);
        }
        return null;
    }

    public static y Z() {
        return y.O0(AccessibilityNodeInfo.obtain());
    }

    public static y a0(y y2) {
        return y.O0(AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)y2.a));
    }

    public static y b0(View view) {
        return y.O0(AccessibilityNodeInfo.obtain((View)view));
    }

    private void e(ClickableSpan clickableSpan, Spanned spanned, int n2) {
        this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add((Object)spanned.getSpanStart((Object)clickableSpan));
        this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add((Object)spanned.getSpanEnd((Object)clickableSpan));
        this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add((Object)spanned.getSpanFlags((Object)clickableSpan));
        this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add((Object)n2);
    }

    private void f0(View view) {
        if ((view = this.z(view)) != null) {
            ArrayList arrayList = new ArrayList();
            int n2 = 0;
            int n3 = 0;
            while (true) {
                if (n3 >= view.size()) break;
                if (((WeakReference)view.valueAt(n3)).get() == null) {
                    arrayList.add((Object)n3);
                }
                ++n3;
            }
            for (int i2 = n2; i2 < arrayList.size(); ++i2) {
                view.remove(((Integer)arrayList.get(i2)).intValue());
            }
        }
    }

    private void g() {
        this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private List h(String string) {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList = this.a.getExtras().getIntegerArrayList(string);
        if (arrayList == null) {
            arrayList2 = new ArrayList();
            this.a.getExtras().putIntegerArrayList(string, arrayList2);
        }
        return arrayList2;
    }

    private void h0(int n2, boolean bl) {
        Bundle bundle = this.v();
        if (bundle != null) {
            int n3 = bundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0);
            int n4 = bl ? n2 : 0;
            bundle.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", n4 | n3 & ~n2);
        }
    }

    static String j(int n2) {
        if (n2 != 1) {
            if (n2 != 2) {
                switch (n2) {
                    default: {
                        switch (n2) {
                            default: {
                                switch (n2) {
                                    default: {
                                        switch (n2) {
                                            default: {
                                                return "ACTION_UNKNOWN";
                                            }
                                            case 16908375: {
                                                return "ACTION_DRAG_CANCEL";
                                            }
                                            case 16908374: {
                                                return "ACTION_DRAG_DROP";
                                            }
                                            case 16908373: {
                                                return "ACTION_DRAG_START";
                                            }
                                            case 16908372: 
                                        }
                                        return "ACTION_IME_ENTER";
                                    }
                                    case 16908362: {
                                        return "ACTION_PRESS_AND_HOLD";
                                    }
                                    case 16908361: {
                                        return "ACTION_PAGE_RIGHT";
                                    }
                                    case 16908360: {
                                        return "ACTION_PAGE_LEFT";
                                    }
                                    case 16908359: {
                                        return "ACTION_PAGE_DOWN";
                                    }
                                    case 16908358: {
                                        return "ACTION_PAGE_UP";
                                    }
                                    case 16908357: {
                                        return "ACTION_HIDE_TOOLTIP";
                                    }
                                    case 16908356: 
                                }
                                return "ACTION_SHOW_TOOLTIP";
                            }
                            case 16908349: {
                                return "ACTION_SET_PROGRESS";
                            }
                            case 16908348: {
                                return "ACTION_CONTEXT_CLICK";
                            }
                            case 16908347: {
                                return "ACTION_SCROLL_RIGHT";
                            }
                            case 16908346: {
                                return "ACTION_SCROLL_DOWN";
                            }
                            case 16908345: {
                                return "ACTION_SCROLL_LEFT";
                            }
                            case 16908344: {
                                return "ACTION_SCROLL_UP";
                            }
                            case 16908343: {
                                return "ACTION_SCROLL_TO_POSITION";
                            }
                            case 16908342: 
                        }
                        return "ACTION_SHOW_ON_SCREEN";
                    }
                    case 16908382: {
                        return "ACTION_SCROLL_IN_DIRECTION";
                    }
                    case 16908354: {
                        return "ACTION_MOVE_WINDOW";
                    }
                    case 0x200000: {
                        return "ACTION_SET_TEXT";
                    }
                    case 524288: {
                        return "ACTION_COLLAPSE";
                    }
                    case 262144: {
                        return "ACTION_EXPAND";
                    }
                    case 131072: {
                        return "ACTION_SET_SELECTION";
                    }
                    case 65536: {
                        return "ACTION_CUT";
                    }
                    case 32768: {
                        return "ACTION_PASTE";
                    }
                    case 16384: {
                        return "ACTION_COPY";
                    }
                    case 8192: {
                        return "ACTION_SCROLL_BACKWARD";
                    }
                    case 4096: {
                        return "ACTION_SCROLL_FORWARD";
                    }
                    case 2048: {
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    }
                    case 1024: {
                        return "ACTION_NEXT_HTML_ELEMENT";
                    }
                    case 512: {
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    }
                    case 256: {
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    }
                    case 128: {
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    }
                    case 64: {
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    }
                    case 32: {
                        return "ACTION_LONG_CLICK";
                    }
                    case 16: {
                        return "ACTION_CLICK";
                    }
                    case 8: {
                        return "ACTION_CLEAR_SELECTION";
                    }
                    case 4: 
                }
                return "ACTION_SELECT";
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    private boolean l(int n2) {
        Bundle bundle = this.v();
        if (bundle == null) {
            return false;
        }
        return (bundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & n2) == n2;
    }

    public static ClickableSpan[] r(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[])((Spanned)charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray x(View view) {
        SparseArray sparseArray;
        SparseArray sparseArray2 = sparseArray = this.z(view);
        if (sparseArray == null) {
            sparseArray2 = new SparseArray();
            view.setTag(y.c.I, (Object)sparseArray2);
        }
        return sparseArray2;
    }

    private SparseArray z(View view) {
        return (SparseArray)view.getTag(y.c.I);
    }

    public CharSequence A() {
        if (Build.VERSION.SDK_INT >= 30) {
            return E.y$b.b(this.a);
        }
        return this.a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public void A0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            E.e.a(this.a, charSequence);
            return;
        }
        this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
    }

    public CharSequence B() {
        if (this.F()) {
            List list = this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List list2 = this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List list3 = this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List list4 = this.h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            CharSequence charSequence = this.a.getText();
            int n2 = this.a.getText().length();
            charSequence = new SpannableString((CharSequence)TextUtils.substring((CharSequence)charSequence, (int)0, (int)n2));
            for (int i2 = 0; i2 < list.size(); ++i2) {
                charSequence.setSpan((Object)new E.a((Integer)list4.get(i2), this, this.v().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer)list.get(i2)).intValue(), ((Integer)list2.get(i2)).intValue(), ((Integer)list3.get(i2)).intValue());
            }
            return charSequence;
        }
        return this.a.getText();
    }

    public void B0(View view) {
        this.b = -1;
        this.a.setParent(view);
    }

    public CharSequence C() {
        if (Build.VERSION.SDK_INT >= 28) {
            return g.a(this.a);
        }
        return this.a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public void C0(View view, int n2) {
        this.b = n2;
        this.a.setParent(view, n2);
    }

    public String D() {
        if (Build.VERSION.SDK_INT >= 33) {
            return E.y$c.g(this.a);
        }
        return this.a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public void D0(boolean bl) {
        if (Build.VERSION.SDK_INT >= 28) {
            E.d.a(this.a, bl);
            return;
        }
        this.h0(1, bl);
    }

    public String E() {
        return this.a.getViewIdResourceName();
    }

    public void E0(boolean bl) {
        this.a.setScrollable(bl);
    }

    public void F0(boolean bl) {
        this.a.setSelected(bl);
    }

    public void G0(boolean bl) {
        if (Build.VERSION.SDK_INT >= 26) {
            i.a(this.a, bl);
            return;
        }
        this.h0(4, bl);
    }

    public boolean H() {
        if (Build.VERSION.SDK_INT >= 34) {
            return E.y$d.f(this.a);
        }
        return this.l(64);
    }

    public void H0(View view) {
        this.c = -1;
        this.a.setSource(view);
    }

    public boolean I() {
        return this.a.isAccessibilityFocused();
    }

    public void I0(View view, int n2) {
        this.c = n2;
        this.a.setSource(view, n2);
    }

    public boolean J() {
        return this.a.isCheckable();
    }

    public void J0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            E.y$b.c(this.a, charSequence);
            return;
        }
        this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
    }

    public boolean K() {
        return this.a.isChecked();
    }

    public void K0(CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    public boolean L() {
        return this.a.isClickable();
    }

    public void L0(View view) {
        this.a.setTraversalAfter(view);
    }

    public boolean M() {
        return this.a.isContextClickable();
    }

    public void M0(boolean bl) {
        this.a.setVisibleToUser(bl);
    }

    public boolean N() {
        return this.a.isEnabled();
    }

    public AccessibilityNodeInfo N0() {
        return this.a;
    }

    public boolean O() {
        return this.a.isFocusable();
    }

    public boolean P() {
        return this.a.isFocused();
    }

    public boolean Q() {
        return this.l(0x4000000);
    }

    public boolean R() {
        if (Build.VERSION.SDK_INT >= 24) {
            return E.c.a(this.a);
        }
        return true;
    }

    public boolean S() {
        return this.a.isLongClickable();
    }

    public boolean T() {
        return this.a.isPassword();
    }

    public boolean U() {
        return this.a.isScrollable();
    }

    public boolean V() {
        return this.a.isSelected();
    }

    public boolean W() {
        if (Build.VERSION.SDK_INT >= 26) {
            return j.a(this.a);
        }
        return this.l(4);
    }

    public boolean X() {
        if (Build.VERSION.SDK_INT >= 33) {
            return E.y$c.h(this.a);
        }
        return this.l(0x800000);
    }

    public boolean Y() {
        return this.a.isVisibleToUser();
    }

    public void a(int n2) {
        this.a.addAction(n2);
    }

    public void b(a a2) {
        this.a.addAction((AccessibilityNodeInfo.AccessibilityAction)a2.a);
    }

    public void c(View view) {
        this.a.addChild(view);
    }

    public boolean c0(int n2, Bundle bundle) {
        return this.a.performAction(n2, bundle);
    }

    public void d(View view, int n2) {
        this.a.addChild(view, n2);
    }

    public void d0() {
    }

    public boolean e0(a a2) {
        return this.a.removeAction((AccessibilityNodeInfo.AccessibilityAction)a2.a);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof y)) {
            return false;
        }
        y y2 = (y)object;
        object = this.a;
        if (object == null ? y2.a != null : !object.equals((Object)y2.a)) {
            return false;
        }
        if (this.c != y2.c) {
            return false;
        }
        return this.b == y2.b;
    }

    public void f(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            this.g();
            this.f0(view);
            ClickableSpan[] clickableSpanArray = y.r(charSequence);
            if (clickableSpanArray != null && clickableSpanArray.length > 0) {
                this.v().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", y.c.a);
                view = this.x(view);
                for (int i2 = 0; i2 < clickableSpanArray.length; ++i2) {
                    int n2 = this.G(clickableSpanArray[i2], (SparseArray)view);
                    view.put(n2, (Object)new WeakReference((Object)clickableSpanArray[i2]));
                    this.e(clickableSpanArray[i2], (Spanned)charSequence, n2);
                }
            }
        }
    }

    public void g0(boolean bl) {
        this.a.setAccessibilityFocused(bl);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public List i() {
        List list = this.a.getActionList();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                arrayList.add((Object)new a(list.get(i2)));
            }
            return arrayList;
        }
        return Collections.EMPTY_LIST;
    }

    public void i0(Rect rect) {
        this.a.setBoundsInParent(rect);
    }

    public void j0(Rect rect) {
        this.a.setBoundsInScreen(rect);
    }

    public int k() {
        return this.a.getActions();
    }

    public void k0(boolean bl) {
        this.a.setCheckable(bl);
    }

    public void l0(boolean bl) {
        this.a.setChecked(bl);
    }

    public void m(Rect rect) {
        this.a.getBoundsInParent(rect);
    }

    public void m0(CharSequence charSequence) {
        this.a.setClassName(charSequence);
    }

    public void n(Rect rect) {
        this.a.getBoundsInScreen(rect);
    }

    public void n0(boolean bl) {
        this.a.setClickable(bl);
    }

    public void o(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            E.y$d.b(this.a, rect);
            return;
        }
        Rect rect2 = (Rect)this.a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void o0(Object object) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.a;
        object = object == null ? null : (AccessibilityNodeInfo.CollectionInfo)((e)object).a;
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)object);
    }

    public int p() {
        return this.a.getChildCount();
    }

    public void p0(Object object) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.a;
        object = object == null ? null : (AccessibilityNodeInfo.CollectionItemInfo)((f)object).a;
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)object);
    }

    public CharSequence q() {
        return this.a.getClassName();
    }

    public void q0(CharSequence charSequence) {
        this.a.setContentDescription(charSequence);
    }

    public void r0(boolean bl) {
        this.a.setEnabled(bl);
    }

    public CharSequence s() {
        if (Build.VERSION.SDK_INT >= 34) {
            return E.y$d.c(this.a);
        }
        return this.a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public void s0(CharSequence charSequence) {
        this.a.setError(charSequence);
    }

    public CharSequence t() {
        return this.a.getContentDescription();
    }

    public void t0(boolean bl) {
        this.a.setFocusable(bl);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Object object = new Rect();
        this.m((Rect)object);
        Object object2 = new StringBuilder();
        object2.append("; boundsInParent: ");
        object2.append(object);
        stringBuilder.append(object2.toString());
        this.n((Rect)object);
        object2 = new StringBuilder();
        object2.append("; boundsInScreen: ");
        object2.append(object);
        stringBuilder.append(object2.toString());
        this.o((Rect)object);
        object2 = new StringBuilder();
        object2.append("; boundsInWindow: ");
        object2.append(object);
        stringBuilder.append(object2.toString());
        stringBuilder.append("; packageName: ");
        stringBuilder.append(this.y());
        stringBuilder.append("; className: ");
        stringBuilder.append(this.q());
        stringBuilder.append("; text: ");
        stringBuilder.append(this.B());
        stringBuilder.append("; error: ");
        stringBuilder.append(this.u());
        stringBuilder.append("; maxTextLength: ");
        stringBuilder.append(this.w());
        stringBuilder.append("; stateDescription: ");
        stringBuilder.append(this.A());
        stringBuilder.append("; contentDescription: ");
        stringBuilder.append(this.t());
        stringBuilder.append("; tooltipText: ");
        stringBuilder.append(this.C());
        stringBuilder.append("; viewIdResName: ");
        stringBuilder.append(this.E());
        stringBuilder.append("; uniqueId: ");
        stringBuilder.append(this.D());
        stringBuilder.append("; checkable: ");
        stringBuilder.append(this.J());
        stringBuilder.append("; checked: ");
        stringBuilder.append(this.K());
        stringBuilder.append("; focusable: ");
        stringBuilder.append(this.O());
        stringBuilder.append("; focused: ");
        stringBuilder.append(this.P());
        stringBuilder.append("; selected: ");
        stringBuilder.append(this.V());
        stringBuilder.append("; clickable: ");
        stringBuilder.append(this.L());
        stringBuilder.append("; longClickable: ");
        stringBuilder.append(this.S());
        stringBuilder.append("; contextClickable: ");
        stringBuilder.append(this.M());
        stringBuilder.append("; enabled: ");
        stringBuilder.append(this.N());
        stringBuilder.append("; password: ");
        stringBuilder.append(this.T());
        object = new StringBuilder();
        object.append("; scrollable: ");
        object.append(this.U());
        stringBuilder.append(object.toString());
        stringBuilder.append("; containerTitle: ");
        stringBuilder.append(this.s());
        stringBuilder.append("; granularScrollingSupported: ");
        stringBuilder.append(this.Q());
        stringBuilder.append("; importantForAccessibility: ");
        stringBuilder.append(this.R());
        stringBuilder.append("; visible: ");
        stringBuilder.append(this.Y());
        stringBuilder.append("; isTextSelectable: ");
        stringBuilder.append(this.X());
        stringBuilder.append("; accessibilityDataSensitive: ");
        stringBuilder.append(this.H());
        stringBuilder.append("; [");
        List list = this.i();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            a a2 = (a)list.get(i2);
            object2 = y.j(a2.b());
            object = object2;
            if (object2.equals((Object)"ACTION_UNKNOWN")) {
                object = object2;
                if (a2.c() != null) {
                    object = a2.c().toString();
                }
            }
            stringBuilder.append((String)object);
            if (i2 == list.size() - 1) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public CharSequence u() {
        return this.a.getError();
    }

    public void u0(boolean bl) {
        this.a.setFocused(bl);
    }

    public Bundle v() {
        return this.a.getExtras();
    }

    public void v0(boolean bl) {
        if (Build.VERSION.SDK_INT >= 28) {
            E.f.a(this.a, bl);
            return;
        }
        this.h0(2, bl);
    }

    public int w() {
        return this.a.getMaxTextLength();
    }

    public void w0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            h.a(this.a, charSequence);
            return;
        }
        this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
    }

    public void x0(View view) {
        this.a.setLabelFor(view);
    }

    public CharSequence y() {
        return this.a.getPackageName();
    }

    public void y0(int n2) {
        this.a.setMaxTextLength(n2);
    }

    public void z0(CharSequence charSequence) {
        this.a.setPackageName(charSequence);
    }

    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;
        public static final a R;
        public static final a S;
        public static final a T;
        public static final a U;
        public static final a V;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;
        public static final a k;
        public static final a l;
        public static final a m;
        public static final a n;
        public static final a o;
        public static final a p;
        public static final a q;
        public static final a r;
        public static final a s;
        public static final a t;
        public static final a u;
        public static final a v;
        public static final a w;
        public static final a x;
        public static final a y;
        public static final a z;
        final Object a;
        private final int b;
        private final Class c;
        protected final B d;

        static {
            Object var2 = null;
            e = new a(1, null);
            f = new a(2, null);
            g = new a(4, null);
            h = new a(8, null);
            i = new a(16, null);
            j = new a(32, null);
            k = new a(64, null);
            l = new a(128, null);
            m = new a(256, null, B.b.class);
            n = new a(512, null, B.b.class);
            o = new a(1024, null, B.c.class);
            p = new a(2048, null, B.c.class);
            q = new a(4096, null);
            r = new a(8192, null);
            s = new a(16384, null);
            t = new a(32768, null);
            u = new a(65536, null);
            v = new a(131072, null, B.g.class);
            w = new a(262144, null);
            x = new a(524288, null);
            y = new a(0x100000, null);
            z = new a(0x200000, null, B.h.class);
            int n2 = Build.VERSION.SDK_INT;
            A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, 16908342, null, null, null);
            B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, 16908343, null, null, B.e.class);
            C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, 16908344, null, null, null);
            D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, 16908345, null, null, null);
            E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, 16908346, null, null, null);
            F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, 16908347, null, null, null);
            Object object = n2 >= 29 ? E.k.a() : null;
            G = new a(object, 16908358, null, null, null);
            object = n2 >= 29 ? E.t.a() : null;
            H = new a(object, 16908359, null, null, null);
            object = n2 >= 29 ? E.u.a() : null;
            I = new a(object, 16908360, null, null, null);
            object = n2 >= 29 ? E.v.a() : null;
            J = new a(object, 16908361, null, null, null);
            K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, 16908348, null, null, null);
            object = n2 >= 24 ? E.w.a() : null;
            L = new a(object, 16908349, null, null, B.f.class);
            object = n2 >= 26 ? E.x.a() : null;
            M = new a(object, 16908354, null, null, B.d.class);
            object = n2 >= 28 ? E.l.a() : null;
            N = new a(object, 16908356, null, null, null);
            object = n2 >= 28 ? E.m.a() : null;
            O = new a(object, 16908357, null, null, null);
            object = n2 >= 30 ? E.n.a() : null;
            P = new a(object, 16908362, null, null, null);
            object = n2 >= 30 ? E.o.a() : null;
            Q = new a(object, 16908372, null, null, null);
            object = n2 >= 32 ? E.p.a() : null;
            R = new a(object, 16908373, null, null, null);
            object = n2 >= 32 ? E.q.a() : null;
            S = new a(object, 16908374, null, null, null);
            object = n2 >= 32 ? E.r.a() : null;
            T = new a(object, 16908375, null, null, null);
            object = n2 >= 33 ? E.s.a() : null;
            U = new a(object, 16908376, null, null, null);
            object = var2;
            if (n2 >= 34) {
                object = E.y$d.a();
            }
            V = new a(object, 16908382, null, null, null);
        }

        public a(int n2, CharSequence charSequence) {
            this(null, n2, charSequence, null, null);
        }

        public a(int n2, CharSequence charSequence, B b2) {
            this(null, n2, charSequence, b2, null);
        }

        private a(int n2, CharSequence charSequence, Class clazz) {
            this(null, n2, charSequence, null, clazz);
        }

        a(Object object) {
            this(object, 0, null, null, null);
        }

        a(Object object, int n2, CharSequence charSequence, B b2, Class clazz) {
            this.b = n2;
            this.d = b2;
            this.a = object == null ? new AccessibilityNodeInfo.AccessibilityAction(n2, charSequence) : object;
            this.c = clazz;
        }

        public a a(CharSequence charSequence, B b2) {
            return new a(null, this.b, charSequence, b2, this.c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction)this.a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction)this.a).getLabel();
        }

        public boolean d(View view, Bundle object) {
            if (this.d != null) {
                object = this.c;
                if (object != null) {
                    try {
                        androidx.appcompat.app.E.a((Object)object.getDeclaredConstructor(null).newInstance(null));
                        throw null;
                    }
                    catch (Exception exception) {
                        object = this.c;
                        object = object == null ? "null" : object.getName();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to execute command with argument class ViewCommandArgument: ");
                        stringBuilder.append((String)object);
                        Log.e((String)"A11yActionCompat", (String)stringBuilder.toString(), (Throwable)exception);
                    }
                }
                return this.d.a(view, null);
            }
            return false;
        }

        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (!(object instanceof a)) {
                return false;
            }
            object = (a)object;
            Object object2 = this.a;
            return !(object2 == null ? ((a)object).a != null : !object2.equals(((a)object).a));
        }

        public int hashCode() {
            Object object = this.a;
            if (object != null) {
                return object.hashCode();
            }
            return 0;
        }

        public String toString() {
            String string;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AccessibilityActionCompat: ");
            String string2 = string = E.y.j(this.b);
            if (string.equals((Object)"ACTION_UNKNOWN")) {
                string2 = string;
                if (this.c() != null) {
                    string2 = this.c().toString();
                }
            }
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
    }

    private static abstract class b {
        public static Object a(int n2, float f2, float f3, float f4) {
            return new AccessibilityNodeInfo.RangeInfo(n2, f2, f3, f4);
        }

        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    private static abstract class c {
        public static f a(boolean bl, int n2, int n3, int n4, int n5, boolean bl2, String string, String string2) {
            return new f(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(bl).setColumnIndex(n2).setRowIndex(n3).setColumnSpan(n4).setRowSpan(n5).setSelected(bl2).setRowTitle(string).setColumnTitle(string2).build());
        }

        public static y b(AccessibilityNodeInfo accessibilityNodeInfo, int n2, int n3) {
            return y.P0(accessibilityNodeInfo.getChild(n2, n3));
        }

        public static String c(Object object) {
            return ((AccessibilityNodeInfo.CollectionItemInfo)object).getColumnTitle();
        }

        public static String d(Object object) {
            return ((AccessibilityNodeInfo.CollectionItemInfo)object).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static y f(AccessibilityNodeInfo accessibilityNodeInfo, int n2) {
            return y.P0(accessibilityNodeInfo.getParent(n2));
        }

        public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean bl) {
            accessibilityNodeInfo.setTextSelectable(bl);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String string) {
            accessibilityNodeInfo.setUniqueId(string);
        }
    }

    private static abstract class d {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static long d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void g(AccessibilityNodeInfo accessibilityNodeInfo, boolean bl) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(bl);
        }

        public static void h(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, long l2) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis((long)l2));
        }

        public static void k(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean bl) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, bl);
        }

        public static void l(AccessibilityNodeInfo accessibilityNodeInfo, boolean bl) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(bl);
        }
    }

    public static class e {
        final Object a;

        e(Object object) {
            this.a = object;
        }

        public static e a(int n2, int n3, boolean bl) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain((int)n2, (int)n3, (boolean)bl));
        }

        public static e b(int n2, int n3, boolean bl, int n4) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain((int)n2, (int)n3, (boolean)bl, (int)n4));
        }
    }

    public static class f {
        final Object a;

        f(Object object) {
            this.a = object;
        }

        public static f a(int n2, int n3, int n4, int n5, boolean bl, boolean bl2) {
            return new f(AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n2, (int)n3, (int)n4, (int)n5, (boolean)bl, (boolean)bl2));
        }
    }
}

