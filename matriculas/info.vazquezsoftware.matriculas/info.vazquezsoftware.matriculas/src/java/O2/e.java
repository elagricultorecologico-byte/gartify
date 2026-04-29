/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  android.util.JsonWriter
 *  java.io.Writer
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Date
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 */
package o2;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import m2.b;
import m2.c;
import m2.d;
import m2.f;
import m2.g;

final class e
implements m2.e,
g {
    private e a = null;
    private boolean b = true;
    private final JsonWriter c;
    private final Map d;
    private final Map e;
    private final d f;
    private final boolean g;

    e(Writer writer, Map map, Map map2, d d3, boolean bl) {
        this.c = new JsonWriter(writer);
        this.d = map;
        this.e = map2;
        this.f = d3;
        this.g = bl;
    }

    private boolean l(Object object) {
        return object == null || object.getClass().isArray() || object instanceof Collection || object instanceof Date || object instanceof Enum || object instanceof Number;
        {
        }
    }

    private e o(String string, Object object) {
        this.q();
        this.c.name(string);
        if (object == null) {
            this.c.nullValue();
            return this;
        }
        return this.f(object, false);
    }

    private e p(String string, Object object) {
        if (object == null) {
            return this;
        }
        this.q();
        this.c.name(string);
        return this.f(object, false);
    }

    private void q() {
        if (this.b) {
            e e2 = this.a;
            if (e2 != null) {
                e2.q();
                this.a.b = false;
                this.a = null;
                this.c.endObject();
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    @Override
    public m2.e a(c c3, Object object) {
        return this.i(c3.b(), object);
    }

    @Override
    public m2.e d(c c3, long l2) {
        return this.h(c3.b(), l2);
    }

    public e e(long l2) {
        this.q();
        this.c.value(l2);
        return this;
    }

    /*
     * WARNING - void declaration
     */
    e f(Object object, boolean object22) {
        void var2_16;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        if (var2_16 != false && this.l(object)) {
            void var1_4;
            if (object == null) {
                Object var1_2 = null;
            } else {
                Class clazz = object.getClass();
            }
            throw new b(String.format((String)"%s cannot be encoded inline", (Object[])new Object[]{var1_4}));
        }
        if (object == null) {
            this.c.nullValue();
            return this;
        }
        if (object instanceof Number) {
            this.c.value((Number)object);
            return this;
        }
        if (object.getClass().isArray()) {
            int n5;
            if (object instanceof byte[]) {
                return this.k((byte[])object);
            }
            this.c.beginArray();
            if (object instanceof int[]) {
                int[] nArray = (int[])object;
                n2 = nArray.length;
                for (n5 = n4; n5 < n2; ++n5) {
                    n4 = nArray[n5];
                    this.c.value((long)n4);
                }
            } else if (object instanceof long[]) {
                long[] lArray = (long[])object;
                n4 = lArray.length;
                for (n5 = n2; n5 < n4; ++n5) {
                    this.e(lArray[n5]);
                }
            } else if (object instanceof double[]) {
                double[] dArray = (double[])object;
                n4 = dArray.length;
                for (n5 = n3; n5 < n4; ++n5) {
                    double d3 = dArray[n5];
                    this.c.value(d3);
                }
            } else if (object instanceof boolean[]) {
                for (boolean bl : (boolean[])object) {
                    this.c.value(bl);
                }
            } else if (object instanceof Number[]) {
                Number[] numberArray = (Number[])object;
                n4 = numberArray.length;
                for (n5 = 0; n5 < n4; ++n5) {
                    this.f(numberArray[n5], false);
                }
            } else {
                Object[] objectArray = (Object[])object;
                n4 = objectArray.length;
                for (n5 = 0; n5 < n4; ++n5) {
                    this.f(objectArray[n5], false);
                }
            }
            this.c.endArray();
            return this;
        }
        if (object instanceof Collection) {
            Collection collection = (Collection)object;
            this.c.beginArray();
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                this.f(iterator.next(), false);
            }
            this.c.endArray();
            return this;
        }
        if (object instanceof Map) {
            Map map = (Map)object;
            this.c.beginObject();
            for (Map.Entry entry : map.entrySet()) {
                Object object2 = entry.getKey();
                try {
                    this.i((String)object2, entry.getValue());
                }
                catch (ClassCastException classCastException) {
                    throw new b(String.format((String)"Only String keys are currently supported in maps, got %s of type %s instead.", (Object[])new Object[]{object2, object2.getClass()}), (Exception)((Object)classCastException));
                }
            }
            this.c.endObject();
            return this;
        }
        Object object3 = (d)this.d.get((Object)object.getClass());
        if (object3 != null) {
            return this.n((d)object3, object, (boolean)var2_16);
        }
        object3 = (f)this.e.get((Object)object.getClass());
        if (object3 != null) {
            object3.a(object, this);
            return this;
        }
        if (object instanceof Enum) {
            this.g(((Enum)object).name());
            return this;
        }
        return this.n(this.f, object, (boolean)var2_16);
    }

    public e g(String string) {
        this.q();
        this.c.value(string);
        return this;
    }

    public e h(String string, long l2) {
        this.q();
        this.c.name(string);
        return this.e(l2);
    }

    public e i(String string, Object object) {
        if (this.g) {
            return this.p(string, object);
        }
        return this.o(string, object);
    }

    public e j(boolean bl) {
        this.q();
        this.c.value(bl);
        return this;
    }

    public e k(byte[] byArray) {
        this.q();
        if (byArray == null) {
            this.c.nullValue();
            return this;
        }
        this.c.value(Base64.encodeToString((byte[])byArray, (int)2));
        return this;
    }

    void m() {
        this.q();
        this.c.flush();
    }

    e n(d d3, Object object, boolean bl) {
        if (!bl) {
            this.c.beginObject();
        }
        d3.a(object, this);
        if (!bl) {
            this.c.endObject();
        }
        return this;
    }
}

