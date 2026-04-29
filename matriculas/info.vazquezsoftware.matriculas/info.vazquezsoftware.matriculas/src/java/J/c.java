/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.animation.Interpolator
 *  android.widget.OverScroller
 *  androidx.core.view.T
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Arrays
 */
package J;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.T;
import java.util.Arrays;

public class c {
    private static final Interpolator x = new Interpolator(){

        public float getInterpolation(float f2) {
            return (f2 -= 1.0f) * f2 * f2 * f2 * f2 + 1.0f;
        }
    };
    private int a;
    private int b;
    private int c = -1;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private final int p;
    private int q;
    private OverScroller r;
    private final c s;
    private View t;
    private boolean u;
    private final ViewGroup v;
    private final Runnable w = new Runnable(this){
        final c g;
        {
            this.g = c2;
        }

        public void run() {
            this.g.K(0);
        }
    };

    private c(Context context, ViewGroup viewGroup, c c2) {
        if (viewGroup != null) {
            if (c2 != null) {
                int n2;
                this.v = viewGroup;
                this.s = c2;
                viewGroup = ViewConfiguration.get((Context)context);
                this.p = n2 = (int)(context.getResources().getDisplayMetrics().density * 20.0f + 0.5f);
                this.o = n2;
                this.b = viewGroup.getScaledTouchSlop();
                this.m = viewGroup.getScaledMaximumFlingVelocity();
                this.n = viewGroup.getScaledMinimumFlingVelocity();
                this.r = new OverScroller(context, x);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    private boolean D(int n2) {
        if (!this.C(n2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ignoring pointerId=");
            stringBuilder.append(n2);
            stringBuilder.append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
            Log.e((String)"ViewDragHelper", (String)stringBuilder.toString());
            return false;
        }
        return true;
    }

    private void G() {
        this.l.computeCurrentVelocity(1000, this.m);
        this.p(this.g(this.l.getXVelocity(this.c), this.n, this.m), this.g(this.l.getYVelocity(this.c), this.n, this.m));
    }

    private void H(float f2, float f3, int n2) {
        int n3;
        int n4 = n3 = this.c(f2, f3, n2, 1);
        if (this.c(f3, f2, n2, 4)) {
            n4 = n3 | 4;
        }
        n3 = n4;
        if (this.c(f2, f3, n2, 2)) {
            n3 = n4 | 2;
        }
        n4 = n3;
        if (this.c(f3, f2, n2, 8)) {
            n4 = n3 | 8;
        }
        if (n4 != 0) {
            int[] nArray = this.i;
            nArray[n2] = nArray[n2] | n4;
            this.s.f(n4, n2);
        }
    }

    private void I(float f2, float f3, int n2) {
        this.s(n2);
        float[] fArray = this.d;
        this.f[n2] = f2;
        fArray[n2] = f2;
        fArray = this.e;
        this.g[n2] = f3;
        fArray[n2] = f3;
        this.h[n2] = this.y((int)f2, (int)f3);
        this.k |= 1 << n2;
    }

    private void J(MotionEvent motionEvent) {
        int n2 = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = motionEvent.getPointerId(i2);
            if (!this.D(n3)) continue;
            float f2 = motionEvent.getX(i2);
            float f3 = motionEvent.getY(i2);
            this.f[n3] = f2;
            this.g[n3] = f3;
        }
    }

    private boolean c(float f2, float f3, int n2, int n3) {
        int n4;
        f2 = Math.abs((float)f2);
        f3 = Math.abs((float)f3);
        if (!((this.h[n2] & n3) != n3 || (this.q & n3) == 0 || (this.j[n2] & n3) == n3 || (this.i[n2] & n3) == n3 || f2 <= (float)(n4 = this.b) && f3 <= (float)n4)) {
            if (f2 < f3 * 0.5f && this.s.g(n3)) {
                int[] nArray = this.j;
                nArray[n2] = nArray[n2] | n3;
                return false;
            }
            if ((this.i[n2] & n3) == 0 && f2 > (float)this.b) {
                return true;
            }
        }
        return false;
    }

    private boolean f(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        int n2 = this.s.d(view) > 0 ? 1 : 0;
        boolean bl = this.s.e(view) > 0;
        if (n2 != 0 && bl) {
            n2 = this.b;
            return f2 * f2 + f3 * f3 > (float)(n2 * n2);
        }
        if (n2 != 0) {
            return Math.abs((float)f2) > (float)this.b;
        }
        return bl && Math.abs((float)f3) > (float)this.b;
    }

    private float g(float f2, float f3, float f4) {
        float f5 = Math.abs((float)f2);
        if (f5 < f3) {
            return 0.0f;
        }
        f3 = f2;
        if (f5 > f4) {
            if (f2 > 0.0f) {
                return f4;
            }
            f3 = -f4;
        }
        return f3;
    }

    private int h(int n2, int n3, int n4) {
        int n5 = Math.abs((int)n2);
        if (n5 < n3) {
            return 0;
        }
        n3 = n2;
        if (n5 > n4) {
            if (n2 > 0) {
                return n4;
            }
            n3 = -n4;
        }
        return n3;
    }

    private void i() {
        float[] fArray = this.d;
        if (fArray == null) {
            return;
        }
        Arrays.fill((float[])fArray, (float)0.0f);
        Arrays.fill((float[])this.e, (float)0.0f);
        Arrays.fill((float[])this.f, (float)0.0f);
        Arrays.fill((float[])this.g, (float)0.0f);
        Arrays.fill((int[])this.h, (int)0);
        Arrays.fill((int[])this.i, (int)0);
        Arrays.fill((int[])this.j, (int)0);
        this.k = 0;
    }

    private void j(int n2) {
        if (this.d != null && this.C(n2)) {
            this.d[n2] = 0.0f;
            this.e[n2] = 0.0f;
            this.f[n2] = 0.0f;
            this.g[n2] = 0.0f;
            this.h[n2] = 0;
            this.i[n2] = 0;
            this.j[n2] = 0;
            this.k = ~(1 << n2) & this.k;
        }
    }

    private int k(int n2, int n3, int n4) {
        if (n2 == 0) {
            return 0;
        }
        int n5 = this.v.getWidth();
        int n6 = n5 / 2;
        float f2 = Math.min((float)1.0f, (float)((float)Math.abs((int)n2) / (float)n5));
        float f3 = n6;
        f2 = this.q(f2);
        n2 = (n3 = Math.abs((int)n3)) > 0 ? Math.round((float)(Math.abs((float)((f3 + f2 * f3) / (float)n3)) * 1000.0f)) * 4 : (int)(((float)Math.abs((int)n2) / (float)n4 + 1.0f) * 256.0f);
        return Math.min((int)n2, (int)600);
    }

    /*
     * Enabled aggressive block sorting
     */
    private int l(View view, int n2, int n3, int n4, int n5) {
        float f2;
        float f3;
        int n6 = this.h(n4, (int)this.n, (int)this.m);
        n4 = this.h(n5, (int)this.n, (int)this.m);
        n5 = Math.abs((int)n2);
        int n7 = Math.abs((int)n3);
        int n8 = Math.abs((int)n6);
        int n9 = Math.abs((int)n4);
        int n10 = n8 + n9;
        int n11 = n5 + n7;
        if (n6 != 0) {
            f3 = n8;
            f2 = n10;
        } else {
            f3 = n5;
            f2 = n11;
        }
        float f4 = f3 / f2;
        if (n4 != 0) {
            f2 = n9;
            f3 = n10;
        } else {
            f2 = n7;
            f3 = n11;
        }
        f3 = f2 / f3;
        n2 = this.k(n2, n6, this.s.d(view));
        n3 = this.k(n3, n4, this.s.e(view));
        return (int)((float)n2 * f4 + (float)n3 * f3);
    }

    public static c n(ViewGroup object, float f2, c c2) {
        object = J.c.o(object, c2);
        object.b = (int)((float)object.b * (1.0f / f2));
        return object;
    }

    public static c o(ViewGroup viewGroup, c c2) {
        return new c(viewGroup.getContext(), viewGroup, c2);
    }

    private void p(float f2, float f3) {
        this.u = true;
        this.s.l(this.t, f2, f3);
        this.u = false;
        if (this.a == 1) {
            this.K(0);
        }
    }

    private float q(float f2) {
        return (float)Math.sin((double)((f2 - 0.5f) * 0.47123894f));
    }

    private void r(int n2, int n3, int n4, int n5) {
        int n6 = this.t.getLeft();
        int n7 = this.t.getTop();
        int n8 = n2;
        if (n4 != 0) {
            n8 = this.s.a(this.t, n2, n4);
            T.R((View)this.t, (int)(n8 - n6));
        }
        n2 = n3;
        if (n5 != 0) {
            n2 = this.s.b(this.t, n3, n5);
            T.S((View)this.t, (int)(n2 - n7));
        }
        if (n4 == 0 && n5 == 0) {
            return;
        }
        this.s.k(this.t, n8, n2, n8 - n6, n2 - n7);
    }

    private void s(int n2) {
        Object[] objectArray = this.d;
        if (objectArray != null && objectArray.length > n2) {
            return;
        }
        float[] fArray = new float[++n2];
        float[] fArray2 = new float[n2];
        float[] fArray3 = new float[n2];
        float[] fArray4 = new float[n2];
        int[] nArray = new int[n2];
        int[] nArray2 = new int[n2];
        int[] nArray3 = new int[n2];
        if (objectArray != null) {
            System.arraycopy((Object)objectArray, (int)0, (Object)fArray, (int)0, (int)objectArray.length);
            objectArray = this.e;
            System.arraycopy((Object)objectArray, (int)0, (Object)fArray2, (int)0, (int)objectArray.length);
            objectArray = this.f;
            System.arraycopy((Object)objectArray, (int)0, (Object)fArray3, (int)0, (int)objectArray.length);
            objectArray = this.g;
            System.arraycopy((Object)objectArray, (int)0, (Object)fArray4, (int)0, (int)objectArray.length);
            objectArray = this.h;
            System.arraycopy((Object)objectArray, (int)0, (Object)nArray, (int)0, (int)objectArray.length);
            objectArray = this.i;
            System.arraycopy((Object)objectArray, (int)0, (Object)nArray2, (int)0, (int)objectArray.length);
            objectArray = this.j;
            System.arraycopy((Object)objectArray, (int)0, (Object)nArray3, (int)0, (int)objectArray.length);
        }
        this.d = fArray;
        this.e = fArray2;
        this.f = fArray3;
        this.g = fArray4;
        this.h = nArray;
        this.i = nArray2;
        this.j = nArray3;
    }

    private boolean u(int n2, int n3, int n4, int n5) {
        int n6 = this.t.getLeft();
        int n7 = this.t.getTop();
        if ((n2 -= n6) == 0 && (n3 -= n7) == 0) {
            this.r.abortAnimation();
            this.K(0);
            return false;
        }
        n4 = this.l(this.t, n2, n3, n4, n5);
        this.r.startScroll(n6, n7, n2, n3, n4);
        this.K(2);
        return true;
    }

    private int y(int n2, int n3) {
        int n4 = n2 < this.v.getLeft() + this.o ? 1 : 0;
        int n5 = n4;
        if (n3 < this.v.getTop() + this.o) {
            n5 = n4 | 4;
        }
        n4 = n5;
        if (n2 > this.v.getRight() - this.o) {
            n4 = n5 | 2;
        }
        if (n3 > this.v.getBottom() - this.o) {
            return n4 | 8;
        }
        return n4;
    }

    public int A() {
        return this.a;
    }

    public boolean B(int n2, int n3) {
        return this.E(this.t, n2, n3);
    }

    public boolean C(int n2) {
        return (1 << n2 & this.k) != 0;
    }

    public boolean E(View view, int n2, int n3) {
        if (view == null) {
            return false;
        }
        return n2 >= view.getLeft() && n2 < view.getRight() && n3 >= view.getTop() && n3 < view.getBottom();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void F(MotionEvent motionEvent) {
        int n2;
        int n3 = motionEvent.getActionMasked();
        int n4 = motionEvent.getActionIndex();
        if (n3 == 0) {
            this.a();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int n5 = 0;
        if (n3 != 0) {
            if (n3 != 1) {
                if (n3 != 2) {
                    if (n3 != 3) {
                        if (n3 != 5) {
                            if (n3 != 6) return;
                            n5 = motionEvent.getPointerId(n4);
                            if (this.a == 1 && n5 == this.c) {
                                block15: {
                                    n4 = motionEvent.getPointerCount();
                                    for (n2 = 0; n2 < n4; ++n2) {
                                        View view;
                                        float f2;
                                        float f3;
                                        View view2;
                                        n3 = motionEvent.getPointerId(n2);
                                        if (n3 == this.c || (view2 = this.t((int)(f3 = motionEvent.getX(n2)), (int)(f2 = motionEvent.getY(n2)))) != (view = this.t) || !this.R(view, n3)) continue;
                                        n2 = this.c;
                                        break block15;
                                    }
                                    n2 = -1;
                                }
                                if (n2 == -1) {
                                    this.G();
                                }
                            }
                            this.j(n5);
                            return;
                        }
                        n2 = motionEvent.getPointerId(n4);
                        float f4 = motionEvent.getX(n4);
                        float f5 = motionEvent.getY(n4);
                        this.I(f4, f5, n2);
                        if (this.a == 0) {
                            this.R(this.t((int)f4, (int)f5), n2);
                            n4 = this.h[n2];
                            n5 = this.q;
                            if ((n4 & n5) == 0) return;
                            this.s.h(n4 & n5, n2);
                            return;
                        }
                        if (!this.B((int)f4, (int)f5)) return;
                        this.R(this.t, n2);
                        return;
                    }
                    if (this.a == 1) {
                        this.p(0.0f, 0.0f);
                    }
                    this.a();
                    return;
                }
                if (this.a == 1) {
                    if (!this.D(this.c)) return;
                    n2 = motionEvent.findPointerIndex(this.c);
                    float f6 = motionEvent.getX(n2);
                    float f7 = motionEvent.getY(n2);
                    float[] fArray = this.f;
                    n5 = this.c;
                    n2 = (int)(f6 - fArray[n5]);
                    n5 = (int)(f7 - this.g[n5]);
                    this.r(this.t.getLeft() + n2, this.t.getTop() + n5, n2, n5);
                    this.J(motionEvent);
                    return;
                }
                n4 = motionEvent.getPointerCount();
                for (n2 = n5; n2 < n4; ++n2) {
                    View view;
                    n5 = motionEvent.getPointerId(n2);
                    if (!this.D(n5)) continue;
                    float f8 = motionEvent.getX(n2);
                    float f9 = motionEvent.getY(n2);
                    float f10 = f8 - this.d[n5];
                    float f11 = f9 - this.e[n5];
                    this.H(f10, f11, n5);
                    if (this.a == 1 || this.f(view = this.t((int)f8, (int)f9), f10, f11) && this.R(view, n5)) break;
                }
                this.J(motionEvent);
                return;
            }
            if (this.a == 1) {
                this.G();
            }
            this.a();
            return;
        }
        float f12 = motionEvent.getX();
        float f13 = motionEvent.getY();
        n4 = motionEvent.getPointerId(0);
        motionEvent = this.t((int)f12, (int)f13);
        this.I(f12, f13, n4);
        this.R((View)motionEvent, n4);
        n5 = this.h[n4];
        n2 = this.q;
        if ((n5 & n2) == 0) return;
        this.s.h(n5 & n2, n4);
    }

    void K(int n2) {
        this.v.removeCallbacks(this.w);
        if (this.a != n2) {
            this.a = n2;
            this.s.j(n2);
            if (this.a == 0) {
                this.t = null;
            }
        }
    }

    public void L(int n2) {
        this.o = n2;
    }

    public void M(int n2) {
        this.q = n2;
    }

    public void N(float f2) {
        this.n = f2;
    }

    public boolean O(int n2, int n3) {
        if (this.u) {
            return this.u(n2, n3, (int)this.l.getXVelocity(this.c), (int)this.l.getYVelocity(this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean P(MotionEvent motionEvent) {
        block17: {
            int n2;
            int n3;
            int n4;
            block14: {
                block15: {
                    block16: {
                        n4 = motionEvent.getActionMasked();
                        n3 = motionEvent.getActionIndex();
                        if (n4 == 0) {
                            this.a();
                        }
                        if (this.l == null) {
                            this.l = VelocityTracker.obtain();
                        }
                        this.l.addMovement(motionEvent);
                        if (n4 == 0) break block14;
                        if (n4 == 1) break block15;
                        if (n4 == 2) break block16;
                        if (n4 == 3) break block15;
                        if (n4 != 5) {
                            if (n4 == 6) {
                                this.j(motionEvent.getPointerId(n3));
                            }
                        } else {
                            n4 = motionEvent.getPointerId(n3);
                            float f2 = motionEvent.getX(n3);
                            float f3 = motionEvent.getY(n3);
                            this.I(f2, f3, n4);
                            n3 = this.a;
                            if (n3 == 0) {
                                int n5 = this.h[n4];
                                n3 = this.q;
                                if ((n5 & n3) != 0) {
                                    this.s.h(n5 & n3, n4);
                                }
                            } else if (n3 == 2 && (motionEvent = this.t((int)f2, (int)f3)) == this.t) {
                                this.R((View)motionEvent, n4);
                            }
                        }
                        break block17;
                    }
                    if (this.d != null && this.e != null) {
                        int n6 = motionEvent.getPointerCount();
                        for (n4 = 0; n4 < n6; ++n4) {
                            int n7 = motionEvent.getPointerId(n4);
                            if (!this.D(n7)) continue;
                            float f4 = motionEvent.getX(n4);
                            float f5 = motionEvent.getY(n4);
                            float f6 = f4 - this.d[n7];
                            float f7 = f5 - this.e[n7];
                            View view = this.t((int)f4, (int)f5);
                            n3 = view != null && this.f(view, f6, f7) ? 1 : 0;
                            if (n3 != 0) {
                                int n8 = view.getLeft();
                                int n9 = (int)f6;
                                int n10 = this.s.a(view, n8 + n9, n9);
                                n9 = view.getTop();
                                int n11 = (int)f7;
                                int n12 = this.s.b(view, n9 + n11, n11);
                                int n13 = this.s.d(view);
                                n11 = this.s.e(view);
                                if ((n13 == 0 || n13 > 0 && n10 == n8) && (n11 == 0 || n11 > 0 && n12 == n9)) break;
                            }
                            this.H(f6, f7, n7);
                            if (this.a == 1 || n3 != 0 && this.R(view, n7)) break;
                        }
                        this.J(motionEvent);
                    }
                    break block17;
                }
                this.a();
                break block17;
            }
            float f8 = motionEvent.getX();
            float f9 = motionEvent.getY();
            n4 = motionEvent.getPointerId(0);
            this.I(f8, f9, n4);
            motionEvent = this.t((int)f8, (int)f9);
            if (motionEvent == this.t && this.a == 2) {
                this.R((View)motionEvent, n4);
            }
            if (((n2 = this.h[n4]) & (n3 = this.q)) != 0) {
                this.s.h(n2 & n3, n4);
            }
        }
        return this.a == 1;
    }

    public boolean Q(View view, int n2, int n3) {
        this.t = view;
        this.c = -1;
        boolean bl = this.u(n2, n3, 0, 0);
        if (!bl && this.a == 0 && this.t != null) {
            this.t = null;
        }
        return bl;
    }

    boolean R(View view, int n2) {
        if (view == this.t && this.c == n2) {
            return true;
        }
        if (view != null && this.s.m(view, n2)) {
            this.c = n2;
            this.b(view, n2);
            return true;
        }
        return false;
    }

    public void a() {
        this.c = -1;
        this.i();
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public void b(View view, int n2) {
        if (view.getParent() == this.v) {
            this.t = view;
            this.c = n2;
            this.s.i(view, n2);
            this.K(1);
            return;
        }
        view = new StringBuilder();
        view.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        view.append((Object)this.v);
        view.append(")");
        throw new IllegalArgumentException(view.toString());
    }

    public boolean d(int n2) {
        int n3 = this.d.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (!this.e(n2, i2)) continue;
            return true;
        }
        return false;
    }

    public boolean e(int n2, int n3) {
        if (!this.C(n3)) {
            return false;
        }
        boolean bl = (n2 & 1) == 1;
        n2 = (n2 & 2) == 2 ? 1 : 0;
        float f2 = this.f[n3] - this.d[n3];
        float f3 = this.g[n3] - this.e[n3];
        if (bl && n2 != 0) {
            n2 = this.b;
            return f2 * f2 + f3 * f3 > (float)(n2 * n2);
        }
        if (bl) {
            return Math.abs((float)f2) > (float)this.b;
        }
        return n2 != 0 && Math.abs((float)f3) > (float)this.b;
    }

    public boolean m(boolean bl) {
        if (this.a == 2) {
            boolean bl2 = this.r.computeScrollOffset();
            int n2 = this.r.getCurrX();
            int n3 = this.r.getCurrY();
            int n4 = n2 - this.t.getLeft();
            int n5 = n3 - this.t.getTop();
            if (n4 != 0) {
                T.R((View)this.t, (int)n4);
            }
            if (n5 != 0) {
                T.S((View)this.t, (int)n5);
            }
            if (n4 != 0 || n5 != 0) {
                this.s.k(this.t, n2, n3, n4, n5);
            }
            boolean bl3 = bl2;
            if (bl2) {
                bl3 = bl2;
                if (n2 == this.r.getFinalX()) {
                    bl3 = bl2;
                    if (n3 == this.r.getFinalY()) {
                        this.r.abortAnimation();
                        bl3 = false;
                    }
                }
            }
            if (!bl3) {
                if (bl) {
                    this.v.post(this.w);
                } else {
                    this.K(0);
                }
            }
        }
        return this.a == 2;
    }

    public View t(int n2, int n3) {
        for (int i2 = this.v.getChildCount() - 1; i2 >= 0; --i2) {
            View view = this.v.getChildAt(this.s.c(i2));
            if (n2 < view.getLeft() || n2 >= view.getRight() || n3 < view.getTop() || n3 >= view.getBottom()) continue;
            return view;
        }
        return null;
    }

    public View v() {
        return this.t;
    }

    public int w() {
        return this.p;
    }

    public int x() {
        return this.o;
    }

    public int z() {
        return this.b;
    }

    public static abstract class c {
        public abstract int a(View var1, int var2, int var3);

        public abstract int b(View var1, int var2, int var3);

        public int c(int n2) {
            return n2;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int n2, int n3) {
        }

        public boolean g(int n2) {
            return false;
        }

        public void h(int n2, int n3) {
        }

        public void i(View view, int n2) {
        }

        public abstract void j(int var1);

        public abstract void k(View var1, int var2, int var3, int var4, int var5);

        public abstract void l(View var1, float var2, float var3);

        public abstract boolean m(View var1, int var2);
    }
}

