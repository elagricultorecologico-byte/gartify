/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  I2.y$a
 *  V2.k
 *  Y2.d
 *  b3.h
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.NoSuchElementException
 *  java.util.Set
 */
package I2;

import H2.n;
import I2.G;
import I2.L;
import I2.M;
import I2.p;
import I2.q;
import I2.r;
import I2.v;
import I2.x;
import I2.y;
import U2.l;
import V2.k;
import Y2.d;
import b3.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

abstract class y
extends x {
    public static /* synthetic */ Appendable A(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence object, int n2, CharSequence charSequence3, l l2, int n3, Object object2) {
        block5: {
            if ((n3 & 2) != 0) {
                charSequence = ", ";
            }
            object2 = "";
            if ((n3 & 4) != 0) {
                charSequence2 = "";
            }
            if ((n3 & 8) != 0) {
                object = object2;
            }
            if ((n3 & 0x10) != 0) {
                n2 = -1;
            }
            if ((n3 & 0x20) != 0) {
                charSequence3 = "...";
            }
            if ((n3 & 0x40) == 0) break block5;
            l2 = null;
        }
        return y.z(iterable, appendable, charSequence, charSequence2, object, n2, charSequence3, l2);
    }

    public static final String B(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n2, CharSequence charSequence4, l l2) {
        k.e((Object)iterable, (String)"<this>");
        k.e((Object)charSequence, (String)"separator");
        k.e((Object)charSequence2, (String)"prefix");
        k.e((Object)charSequence3, (String)"postfix");
        k.e((Object)charSequence4, (String)"truncated");
        return ((StringBuilder)y.z(iterable, (Appendable)new StringBuilder(), charSequence, charSequence2, charSequence3, n2, charSequence4, l2)).toString();
    }

    public static /* synthetic */ String C(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n2, CharSequence charSequence4, l l2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            charSequence = ", ";
        }
        if ((n3 & 2) != 0) {
            charSequence2 = "";
        }
        if ((n3 & 4) != 0) {
            charSequence3 = "";
        }
        if ((n3 & 8) != 0) {
            n2 = -1;
        }
        if ((n3 & 0x10) != 0) {
            charSequence4 = "...";
        }
        if ((n3 & 0x20) != 0) {
            l2 = null;
        }
        return y.B(iterable, charSequence, charSequence2, charSequence3, n2, charSequence4, l2);
    }

    public static Object D(List list) {
        k.e((Object)list, (String)"<this>");
        if (!list.isEmpty()) {
            return list.get(q.h(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static Object E(List list) {
        k.e((Object)list, (String)"<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Comparable F(Iterable iterable) {
        k.e((Object)iterable, (String)"<this>");
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        iterable = (Comparable)iterator.next();
        while (iterator.hasNext()) {
            Comparable comparable = (Comparable)iterator.next();
            if (iterable.compareTo((Object)comparable) <= 0) continue;
            iterable = comparable;
        }
        return iterable;
    }

    public static List G(Collection collection, Iterable iterable) {
        k.e((Object)collection, (String)"<this>");
        k.e((Object)iterable, (String)"elements");
        if (iterable instanceof Collection) {
            int n2 = collection.size();
            iterable = (Collection)iterable;
            ArrayList arrayList = new ArrayList(n2 + iterable.size());
            arrayList.addAll(collection);
            arrayList.addAll((Collection)iterable);
            return arrayList;
        }
        collection = new ArrayList(collection);
        v.q(collection, iterable);
        return collection;
    }

    public static List H(Collection collection, Object object) {
        k.e((Object)collection, (String)"<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(object);
        return arrayList;
    }

    public static final List I(Iterable iterable, int n2) {
        k.e((Object)iterable, (String)"<this>");
        if (n2 >= 0) {
            if (n2 == 0) {
                return q.g();
            }
            if (iterable instanceof Collection) {
                if (n2 >= ((Collection)iterable).size()) {
                    return y.K(iterable);
                }
                if (n2 == 1) {
                    return p.b(y.v(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(n2);
            iterable = iterable.iterator();
            int n3 = 0;
            while (iterable.hasNext()) {
                int n4;
                arrayList.add(iterable.next());
                n3 = n4 = n3 + 1;
                if (n4 != n2) continue;
            }
            return q.l((List)arrayList);
        }
        iterable = new StringBuilder();
        iterable.append("Requested element count ");
        iterable.append(n2);
        iterable.append(" is less than zero.");
        throw new IllegalArgumentException(iterable.toString().toString());
    }

    public static final Collection J(Iterable iterable, Collection collection) {
        k.e((Object)iterable, (String)"<this>");
        k.e((Object)collection, (String)"destination");
        iterable = iterable.iterator();
        while (iterable.hasNext()) {
            collection.add(iterable.next());
        }
        return collection;
    }

    public static List K(Iterable object) {
        k.e((Object)object, (String)"<this>");
        if (object instanceof Collection) {
            Collection collection = (Collection)object;
            int n2 = collection.size();
            if (n2 != 0) {
                if (n2 != 1) {
                    return y.M(collection);
                }
                object = object instanceof List ? ((List)object).get(0) : collection.iterator().next();
                return p.b(object);
            }
            return q.g();
        }
        return q.l(y.L(object));
    }

    public static final List L(Iterable iterable) {
        k.e((Object)iterable, (String)"<this>");
        if (iterable instanceof Collection) {
            return y.M((Collection)iterable);
        }
        return (List)y.J(iterable, (Collection)new ArrayList());
    }

    public static List M(Collection collection) {
        k.e((Object)collection, (String)"<this>");
        return new ArrayList(collection);
    }

    public static Set N(Iterable object) {
        k.e((Object)object, (String)"<this>");
        if (object instanceof Collection) {
            Collection collection = (Collection)object;
            int n2 = collection.size();
            if (n2 != 0) {
                if (n2 != 1) {
                    return (Set)y.J(object, (Collection)new LinkedHashSet(G.c(collection.size())));
                }
                object = object instanceof List ? ((List)object).get(0) : collection.iterator().next();
                return L.a(object);
            }
            return M.b();
        }
        return M.c((Set)y.J(object, (Collection)new LinkedHashSet()));
    }

    public static List O(Iterable iterable, Iterable iterable2) {
        k.e((Object)iterable, (String)"<this>");
        k.e((Object)iterable2, (String)"other");
        Iterator iterator = iterable.iterator();
        Iterator iterator2 = iterable2.iterator();
        iterable = new ArrayList(Math.min((int)r.o(iterable, 10), (int)r.o(iterable2, 10)));
        while (iterator.hasNext() && iterator2.hasNext()) {
            iterable.add((Object)n.a(iterator.next(), iterator2.next()));
        }
        return iterable;
    }

    public static a3.d s(Iterable iterable) {
        k.e((Object)iterable, (String)"<this>");
        return new a(iterable);
    }

    public static boolean t(Iterable iterable, Object object) {
        k.e((Object)iterable, (String)"<this>");
        if (iterable instanceof Collection) {
            return ((Collection)iterable).contains(object);
        }
        return y.y(iterable, object) >= 0;
    }

    public static List u(List list, int n2) {
        k.e((Object)list, (String)"<this>");
        if (n2 >= 0) {
            return y.I((Iterable)list, d.b((int)(list.size() - n2), (int)0));
        }
        list = new StringBuilder();
        list.append("Requested element count ");
        list.append(n2);
        list.append(" is less than zero.");
        throw new IllegalArgumentException(list.toString().toString());
    }

    public static final Object v(Iterable iterable) {
        k.e((Object)iterable, (String)"<this>");
        if (iterable instanceof List) {
            return y.w((List)iterable);
        }
        if ((iterable = iterable.iterator()).hasNext()) {
            return iterable.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object w(List list) {
        k.e((Object)list, (String)"<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static Object x(Iterable iterable) {
        k.e((Object)iterable, (String)"<this>");
        if (iterable instanceof List) {
            if ((iterable = (List)iterable).isEmpty()) {
                return null;
            }
            return iterable.get(0);
        }
        if (!(iterable = iterable.iterator()).hasNext()) {
            return null;
        }
        return iterable.next();
    }

    public static final int y(Iterable iterable, Object object) {
        k.e((Object)iterable, (String)"<this>");
        if (iterable instanceof List) {
            return ((List)iterable).indexOf(object);
        }
        iterable = iterable.iterator();
        int n2 = 0;
        while (iterable.hasNext()) {
            Object object2 = iterable.next();
            if (n2 < 0) {
                q.n();
            }
            if (k.a((Object)object, (Object)object2)) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    public static final Appendable z(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence object, CharSequence charSequence2, int n2, CharSequence charSequence3, l l2) {
        int n3;
        k.e((Object)iterable, (String)"<this>");
        k.e((Object)appendable, (String)"buffer");
        k.e((Object)charSequence, (String)"separator");
        k.e((Object)object, (String)"prefix");
        k.e((Object)charSequence2, (String)"postfix");
        k.e((Object)charSequence3, (String)"truncated");
        appendable.append(object);
        iterable = iterable.iterator();
        int n4 = 0;
        while (true) {
            n3 = n4++;
            if (!iterable.hasNext()) break;
            object = iterable.next();
            if (n4 > 1) {
                appendable.append(charSequence);
            }
            if (n2 >= 0) {
                n3 = n4;
                if (n4 > n2) break;
            }
            h.a((Appendable)appendable, (Object)object, (l)l2);
        }
        if (n2 >= 0 && n3 > n2) {
            appendable.append(charSequence3);
        }
        appendable.append(charSequence2);
        return appendable;
    }
}

