/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.view.InputEvent
 *  e0.a
 *  e0.n
 *  e0.o
 *  e0.p
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 */
package c0;

import H2.l;
import H2.q;
import L2.e;
import V2.g;
import V2.k;
import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import c3.I;
import c3.J;
import c3.W;
import c3.f;
import e0.n;
import e0.o;
import e0.p;

public abstract class a {
    public static final b a = new b(null);

    public static final a a(Context context) {
        return a.a(context);
    }

    public abstract l2.a b();

    public abstract l2.a c(Uri var1, InputEvent var2);

    private static final class a
    extends a {
        private final n b;

        public a(n n3) {
            k.e(n3, "mMeasurementManager");
            this.b = n3;
        }

        @Override
        public l2.a b() {
            return b0.b.c(f.b(J.a(W.a()), null, null, new U2.p(this, null){
                int k;
                final a l;
                {
                    this.l = a3;
                    super(2, e3);
                }

                @Override
                public final e i(Object object, e e3) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                @Override
                public final Object o(Object object) {
                    Object object2 = M2.b.e();
                    int n3 = this.k;
                    if (n3 != 0) {
                        if (n3 == 1) {
                            l.b(object);
                            return object;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    l.b(object);
                    object = this.l.b;
                    this.k = 1;
                    object = object.b((e)this);
                    if (object == object2) {
                        return object2;
                    }
                    return object;
                }

                public final Object r(I i3, e e3) {
                    return (this.i(i3, e3)).o(q.a);
                }
            }, 3, null), null, 1, null);
        }

        @Override
        public l2.a c(Uri uri, InputEvent inputEvent) {
            k.e(uri, "attributionSource");
            return b0.b.c(f.b(J.a(W.a()), null, null, new U2.p(this, uri, inputEvent, null){
                int k;
                final a l;
                final Uri m;
                final InputEvent n;
                {
                    this.l = a3;
                    this.m = uri;
                    this.n = inputEvent;
                    super(2, e3);
                }

                @Override
                public final e i(Object object, e e3) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                /*
                 * Enabled force condition propagation
                 * Lifted jumps to return sites
                 */
                @Override
                public final Object o(Object object) {
                    Object object2 = M2.b.e();
                    int n3 = this.k;
                    if (n3 != 0) {
                        if (n3 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        l.b(object);
                        return q.a;
                    } else {
                        l.b(object);
                        n n4 = this.l.b;
                        Uri uri = this.m;
                        object = this.n;
                        this.k = 1;
                        if (n4.c(uri, (InputEvent)object, (e)this) != object2) return q.a;
                        return object2;
                    }
                }

                public final Object r(I i3, e e3) {
                    return (this.i(i3, e3)).o(q.a);
                }
            }, 3, null), null, 1, null);
        }

        public l2.a e(e0.a a3) {
            k.e(a3, "deletionRequest");
            return b0.b.c(f.b(J.a(W.a()), null, null, new U2.p(this, a3, null){
                int k;
                final a l;
                {
                    this.l = a3;
                    super(2, e3);
                }

                @Override
                public final e i(Object object, e e3) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                /*
                 * Enabled force condition propagation
                 * Lifted jumps to return sites
                 */
                @Override
                public final Object o(Object object) {
                    Object object2 = M2.b.e();
                    int n3 = this.k;
                    if (n3 != 0) {
                        if (n3 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        l.b(object);
                        return q.a;
                    } else {
                        l.b(object);
                        object = this.l.b;
                        this.k = 1;
                        if (object.a(null, (e)this) != object2) return q.a;
                        return object2;
                    }
                }

                public final Object r(I i3, e e3) {
                    return (this.i(i3, e3)).o(q.a);
                }
            }, 3, null), null, 1, null);
        }

        public l2.a f(Uri uri) {
            k.e(uri, "trigger");
            return b0.b.c(f.b(J.a(W.a()), null, null, new U2.p(this, uri, null){
                int k;
                final a l;
                final Uri m;
                {
                    this.l = a3;
                    this.m = uri;
                    super(2, e3);
                }

                @Override
                public final e i(Object object, e e3) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                /*
                 * Enabled force condition propagation
                 * Lifted jumps to return sites
                 */
                @Override
                public final Object o(Object object) {
                    Object object2 = M2.b.e();
                    int n3 = this.k;
                    if (n3 != 0) {
                        if (n3 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        l.b(object);
                        return q.a;
                    } else {
                        l.b(object);
                        object = this.l.b;
                        Uri uri = this.m;
                        this.k = 1;
                        if (object.d(uri, (e)this) != object2) return q.a;
                        return object2;
                    }
                }

                public final Object r(I i3, e e3) {
                    return (this.i(i3, e3)).o(q.a);
                }
            }, 3, null), null, 1, null);
        }

        public l2.a g(o o3) {
            k.e(o3, "request");
            return b0.b.c(f.b(J.a(W.a()), null, null, new U2.p(this, o3, null){
                int k;
                final a l;
                {
                    this.l = a3;
                    super(2, e3);
                }

                @Override
                public final e i(Object object, e e3) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                /*
                 * Enabled force condition propagation
                 * Lifted jumps to return sites
                 */
                @Override
                public final Object o(Object object) {
                    Object object2 = M2.b.e();
                    int n3 = this.k;
                    if (n3 != 0) {
                        if (n3 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        l.b(object);
                        return q.a;
                    } else {
                        l.b(object);
                        object = this.l.b;
                        this.k = 1;
                        if (object.e(null, (e)this) != object2) return q.a;
                        return object2;
                    }
                }

                public final Object r(I i3, e e3) {
                    return (this.i(i3, e3)).o(q.a);
                }
            }, 3, null), null, 1, null);
        }

        public l2.a h(p p3) {
            k.e(p3, "request");
            return b0.b.c(f.b(J.a(W.a()), null, null, new U2.p(this, p3, null){
                int k;
                final a l;
                {
                    this.l = a3;
                    super(2, e3);
                }

                @Override
                public final e i(Object object, e e3) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                /*
                 * Enabled force condition propagation
                 * Lifted jumps to return sites
                 */
                @Override
                public final Object o(Object object) {
                    Object object2 = M2.b.e();
                    int n3 = this.k;
                    if (n3 != 0) {
                        if (n3 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        l.b(object);
                        return q.a;
                    } else {
                        l.b(object);
                        object = this.l.b;
                        this.k = 1;
                        if (object.f(null, (e)this) != object2) return q.a;
                        return object2;
                    }
                }

                public final Object r(I i3, e e3) {
                    return (this.i(i3, e3)).o(q.a);
                }
            }, 3, null), null, 1, null);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g g3) {
            this();
        }

        public final a a(Context context) {
            k.e(context, "context");
            context = n.a.a(context);
            if (context != null) {
                return new a((n)context);
            }
            return null;
        }
    }
}

