/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.LinkedHashMap
 *  java.util.Map
 */
package V2;

import H2.j;
import H2.n;
import I2.E;
import I2.o;
import U2.c;
import U2.f;
import U2.i;
import U2.l;
import U2.m;
import U2.p;
import U2.q;
import U2.r;
import U2.s;
import U2.t;
import U2.u;
import U2.v;
import V2.d;
import V2.g;
import V2.k;
import V2.w;
import Z2.b;
import b3.h;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class e
implements b,
d {
    public static final a b;
    private static final Map c;
    private static final HashMap d;
    private static final HashMap e;
    private static final HashMap f;
    private static final Map g;
    private final Class a;

    static {
        Object object4;
        b = new a(null);
        int n3 = 0;
        Object object22 = o.i(U2.a.class, l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, U2.w.class, U2.b.class, c.class, U2.d.class, U2.e.class, f.class, U2.g.class, U2.h.class, i.class, U2.j.class, U2.k.class, m.class, U2.n.class, U2.o.class);
        ArrayList arrayList = new ArrayList(o.o((Iterable)object22, 10));
        for (Object object22 : object22) {
            if (n3 < 0) {
                o.n();
            }
            arrayList.add((Object)n.a((Class)object22, n3));
            ++n3;
        }
        c = E.i((Iterable)arrayList);
        Object object32 = new HashMap();
        object32.put((Object)"boolean", (Object)"kotlin.Boolean");
        object32.put((Object)"char", (Object)"kotlin.Char");
        object32.put((Object)"byte", (Object)"kotlin.Byte");
        object32.put((Object)"short", (Object)"kotlin.Short");
        object32.put((Object)"int", (Object)"kotlin.Int");
        object32.put((Object)"float", (Object)"kotlin.Float");
        object32.put((Object)"long", (Object)"kotlin.Long");
        object32.put((Object)"double", (Object)"kotlin.Double");
        d = object32;
        object22 = new HashMap();
        object22.put((Object)"java.lang.Boolean", (Object)"kotlin.Boolean");
        object22.put((Object)"java.lang.Character", (Object)"kotlin.Char");
        object22.put((Object)"java.lang.Byte", (Object)"kotlin.Byte");
        object22.put((Object)"java.lang.Short", (Object)"kotlin.Short");
        object22.put((Object)"java.lang.Integer", (Object)"kotlin.Int");
        object22.put((Object)"java.lang.Float", (Object)"kotlin.Float");
        object22.put((Object)"java.lang.Long", (Object)"kotlin.Long");
        object22.put((Object)"java.lang.Double", (Object)"kotlin.Double");
        e = object22;
        arrayList = new HashMap();
        arrayList.put((Object)"java.lang.Object", (Object)"kotlin.Any");
        arrayList.put((Object)"java.lang.String", (Object)"kotlin.String");
        arrayList.put((Object)"java.lang.CharSequence", (Object)"kotlin.CharSequence");
        arrayList.put((Object)"java.lang.Throwable", (Object)"kotlin.Throwable");
        arrayList.put((Object)"java.lang.Cloneable", (Object)"kotlin.Cloneable");
        arrayList.put((Object)"java.lang.Number", (Object)"kotlin.Number");
        arrayList.put((Object)"java.lang.Comparable", (Object)"kotlin.Comparable");
        arrayList.put((Object)"java.lang.Enum", (Object)"kotlin.Enum");
        arrayList.put((Object)"java.lang.annotation.Annotation", (Object)"kotlin.Annotation");
        arrayList.put((Object)"java.lang.Iterable", (Object)"kotlin.collections.Iterable");
        arrayList.put((Object)"java.util.Iterator", (Object)"kotlin.collections.Iterator");
        arrayList.put((Object)"java.util.Collection", (Object)"kotlin.collections.Collection");
        arrayList.put((Object)"java.util.List", (Object)"kotlin.collections.List");
        arrayList.put((Object)"java.util.Set", (Object)"kotlin.collections.Set");
        arrayList.put((Object)"java.util.ListIterator", (Object)"kotlin.collections.ListIterator");
        arrayList.put((Object)"java.util.Map", (Object)"kotlin.collections.Map");
        arrayList.put((Object)"java.util.Map$Entry", (Object)"kotlin.collections.Map.Entry");
        arrayList.put((Object)"kotlin.jvm.internal.StringCompanionObject", (Object)"kotlin.String.Companion");
        arrayList.put((Object)"kotlin.jvm.internal.EnumCompanionObject", (Object)"kotlin.Enum.Companion");
        arrayList.putAll((Map)object32);
        arrayList.putAll((Map)object22);
        object22 = object32.values();
        k.d(object22, "<get-values>(...)");
        for (Object object32 : object22) {
            object4 = new StringBuilder();
            object4.append("kotlin.jvm.internal.");
            k.b(object32);
            object4.append(h.s0((String)object32, '.', null, 2, null));
            object4.append("CompanionObject");
            String string = object4.toString();
            object4 = new StringBuilder();
            object4.append((String)object32);
            object4.append(".Companion");
            object32 = n.a(string, object4.toString());
            arrayList.put(((j)object32).c(), ((j)object32).d());
        }
        for (Object object32 : c.entrySet()) {
            object4 = (Class)object32.getKey();
            n3 = ((Number)object32.getValue()).intValue();
            object4 = object4.getName();
            object32 = new StringBuilder();
            object32.append("kotlin.Function");
            object32.append(n3);
            arrayList.put(object4, (Object)object32.toString());
        }
        f = arrayList;
        object22 = new LinkedHashMap(E.c(arrayList.size()));
        for (Object object4 : arrayList.entrySet()) {
            object32 = object4.getKey();
            object4 = (String)object4.getValue();
            k.b(object4);
            object22.put(object32, (Object)h.s0((String)object4, '.', null, 2, null));
        }
        g = object22;
    }

    public e(Class clazz) {
        k.e(clazz, "jClass");
        this.a = clazz;
    }

    @Override
    public String a() {
        return b.a(this.d());
    }

    @Override
    public boolean b(Object object) {
        return b.c(object, this.d());
    }

    @Override
    public String c() {
        return b.b(this.d());
    }

    @Override
    public Class d() {
        return this.a;
    }

    public boolean equals(Object object) {
        return object instanceof e && k.a(T2.a.b(this), T2.a.b((b)object));
    }

    public int hashCode() {
        return T2.a.b(this).hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)this.d());
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g3) {
            this();
        }

        public final String a(Class object) {
            k.e(object, "jClass");
            boolean bl = object.isAnonymousClass();
            String string = null;
            if (bl) {
                return null;
            }
            if (object.isLocalClass()) {
                return null;
            }
            if (object.isArray()) {
                Object object2 = object.getComponentType();
                object = string;
                if (object2.isPrimitive()) {
                    object2 = (String)f.get((Object)object2.getName());
                    object = string;
                    if (object2 != null) {
                        object = new StringBuilder();
                        object.append((String)object2);
                        object.append("Array");
                        object = object.toString();
                    }
                }
                if (object == null) {
                    return "kotlin.Array";
                }
                return object;
            }
            string = (String)f.get((Object)object.getName());
            if (string == null) {
                return object.getCanonicalName();
            }
            return string;
        }

        public final String b(Class object) {
            k.e(object, "jClass");
            boolean bl = object.isAnonymousClass();
            String string = null;
            if (bl) {
                return null;
            }
            if (object.isLocalClass()) {
                Object object2;
                string = object.getSimpleName();
                Method method = object.getEnclosingMethod();
                if (method != null) {
                    k.b(string);
                    object2 = new StringBuilder();
                    object2.append(method.getName());
                    object2.append('$');
                    object2 = h.q0(string, object2.toString(), null, 2, null);
                    if (object2 != null) {
                        return object2;
                    }
                }
                if ((object = object.getEnclosingConstructor()) != null) {
                    k.b(string);
                    object2 = new StringBuilder();
                    object2.append(object.getName());
                    object2.append('$');
                    return h.q0(string, object2.toString(), null, 2, null);
                }
                k.b(string);
                return h.p0(string, '$', null, 2, null);
            }
            if (object.isArray()) {
                Object object3 = object.getComponentType();
                object = string;
                if (object3.isPrimitive()) {
                    object3 = (String)g.get((Object)object3.getName());
                    object = string;
                    if (object3 != null) {
                        object = new StringBuilder();
                        object.append((String)object3);
                        object.append("Array");
                        object = object.toString();
                    }
                }
                if (object == null) {
                    return "Array";
                }
                return object;
            }
            string = (String)g.get((Object)object.getName());
            if (string == null) {
                return object.getSimpleName();
            }
            return string;
        }

        public final boolean c(Object object, Class clazz) {
            k.e(clazz, "jClass");
            Map map = c;
            k.c(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            map = (Integer)map.get((Object)clazz);
            if (map != null) {
                return w.c(object, map.intValue());
            }
            map = clazz;
            if (clazz.isPrimitive()) {
                map = T2.a.b(T2.a.c(clazz));
            }
            return map.isInstance(object);
        }
    }
}

