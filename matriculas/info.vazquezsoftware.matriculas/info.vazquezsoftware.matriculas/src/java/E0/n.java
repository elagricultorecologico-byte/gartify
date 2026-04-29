/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.adservices.measurement.DeletionRequest
 *  android.adservices.measurement.MeasurementManager
 *  android.adservices.measurement.WebSourceRegistrationRequest
 *  android.adservices.measurement.WebTriggerRegistrationRequest
 *  android.content.Context
 *  android.net.Uri
 *  android.util.Log
 *  android.view.InputEvent
 *  androidx.core.os.s
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package e0;

import H2.q;
import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.InputEvent;
import androidx.core.os.s;
import e0.c;
import e0.d;
import e0.e;
import e0.f;
import e0.g;
import e0.h;
import e0.i;
import e0.j;
import e0.k;
import e0.l;
import e0.m;
import e0.o;
import e0.p;

public abstract class n {
    public static final b a = new b(null);

    public abstract Object a(e0.a var1, L2.e var2);

    public abstract Object b(L2.e var1);

    public abstract Object c(Uri var1, InputEvent var2, L2.e var3);

    public abstract Object d(Uri var1, L2.e var2);

    public abstract Object e(o var1, L2.e var2);

    public abstract Object f(p var1, L2.e var2);

    private static final class a
    extends n {
        private final MeasurementManager b;

        public a(MeasurementManager measurementManager) {
            V2.k.e(measurementManager, "mMeasurementManager");
            this.b = measurementManager;
        }

        public a(Context object) {
            V2.k.e(object, "context");
            object = object.getSystemService(i.a());
            V2.k.d(object, "context.getSystemService\u2026:class.java\n            )");
            this(j.a(object));
        }

        private final DeletionRequest k(e0.a a2) {
            e0.b.a();
            throw null;
        }

        private final WebSourceRegistrationRequest l(o o2) {
            d.a();
            throw null;
        }

        private final WebTriggerRegistrationRequest m(p p2) {
            e.a();
            throw null;
        }

        @Override
        public Object a(e0.a object, L2.e e2) {
            c3.k k2 = new c3.k(M2.b.c(e2), 1);
            k2.E();
            h.a(this.b, this.k((e0.a)object), new m(), s.a((L2.e)k2));
            object = k2.y();
            if (object == M2.b.e()) {
                N2.h.c(e2);
            }
            if (object == M2.b.e()) {
                return object;
            }
            return q.a;
        }

        @Override
        public Object b(L2.e e2) {
            Object object = new c3.k(M2.b.c(e2), 1);
            ((c3.k)object).E();
            k.a(this.b, new m(), s.a((L2.e)object));
            object = ((c3.k)object).y();
            if (object == M2.b.e()) {
                N2.h.c(e2);
            }
            return object;
        }

        @Override
        public Object c(Uri object, InputEvent inputEvent, L2.e e2) {
            c3.k k2 = new c3.k(M2.b.c(e2), 1);
            k2.E();
            f.a(this.b, object, inputEvent, new m(), s.a((L2.e)k2));
            object = k2.y();
            if (object == M2.b.e()) {
                N2.h.c(e2);
            }
            if (object == M2.b.e()) {
                return object;
            }
            return q.a;
        }

        @Override
        public Object d(Uri object, L2.e e2) {
            c3.k k2 = new c3.k(M2.b.c(e2), 1);
            k2.E();
            l.a(this.b, object, new m(), s.a((L2.e)k2));
            object = k2.y();
            if (object == M2.b.e()) {
                N2.h.c(e2);
            }
            if (object == M2.b.e()) {
                return object;
            }
            return q.a;
        }

        @Override
        public Object e(o object, L2.e e2) {
            c3.k k2 = new c3.k(M2.b.c(e2), 1);
            k2.E();
            g.a(this.b, this.l((o)object), new m(), s.a((L2.e)k2));
            object = k2.y();
            if (object == M2.b.e()) {
                N2.h.c(e2);
            }
            if (object == M2.b.e()) {
                return object;
            }
            return q.a;
        }

        @Override
        public Object f(p object, L2.e e2) {
            c3.k k2 = new c3.k(M2.b.c(e2), 1);
            k2.E();
            c.a(this.b, this.m((p)object), new m(), s.a((L2.e)k2));
            object = k2.y();
            if (object == M2.b.e()) {
                N2.h.c(e2);
            }
            if (object == M2.b.e()) {
                return object;
            }
            return q.a;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(V2.g g2) {
            this();
        }

        public final n a(Context context) {
            V2.k.e(context, "context");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AdServicesInfo.version=");
            a0.b b2 = a0.b.a;
            stringBuilder.append(b2.a());
            Log.d((String)"MeasurementManager", (String)stringBuilder.toString());
            if (b2.a() >= 5) {
                return new a(context);
            }
            return null;
        }
    }
}

