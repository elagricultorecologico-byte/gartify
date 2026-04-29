/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.ClassCastException
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  java.util.ConcurrentModificationException
 *  java.util.Map
 */
package p;

import V2.g;
import V2.k;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import q.a;

public class i {
    private int[] g;
    private Object[] h;
    private int i;

    public i() {
        this(0, 1, null);
    }

    public i(int n2) {
        Object[] objectArray = n2 == 0 ? a.a : new int[n2];
        this.g = objectArray;
        objectArray = n2 == 0 ? (Object[])a.c : (Object[])new Object[n2 << 1];
        this.h = objectArray;
    }

    public /* synthetic */ i(int n2, int n3, g g2) {
        if ((n3 & 1) != 0) {
            n2 = 0;
        }
        this(n2);
    }

    public i(i i2) {
        this(0, 1, null);
        if (i2 != null) {
            this.g(i2);
        }
    }

    private final int c(Object object, int n2) {
        int n3;
        int n4 = this.i;
        if (n4 == 0) {
            return -1;
        }
        int n5 = a.a(this.g, n4, n2);
        if (n5 < 0 || k.a(object, this.h[n5 << 1])) {
            return n5;
        }
        for (n3 = n5 + 1; n3 < n4 && this.g[n3] == n2; ++n3) {
            if (!k.a(object, this.h[n3 << 1])) continue;
            return n3;
        }
        --n5;
        while (n5 >= 0 && this.g[n5] == n2) {
            if (k.a(object, this.h[n5 << 1])) {
                return n5;
            }
            --n5;
        }
        return ~n3;
    }

    private final int e() {
        int n2;
        int n3 = this.i;
        if (n3 == 0) {
            return -1;
        }
        int n4 = a.a(this.g, n3, 0);
        if (n4 < 0 || this.h[n4 << 1] == null) {
            return n4;
        }
        for (n2 = n4 + 1; n2 < n3 && this.g[n2] == 0; ++n2) {
            if (this.h[n2 << 1] != null) continue;
            return n2;
        }
        for (n3 = n4 - 1; n3 >= 0 && this.g[n3] == 0; --n3) {
            if (this.h[n3 << 1] != null) continue;
            return n3;
        }
        return ~n2;
    }

    public final int a(Object object) {
        int n2 = this.i * 2;
        Object[] objectArray = this.h;
        if (object == null) {
            for (int i2 = 1; i2 < n2; i2 += 2) {
                if (objectArray[i2] != null) continue;
                return i2 >> 1;
            }
        } else {
            for (int i3 = 1; i3 < n2; i3 += 2) {
                if (!k.a(object, objectArray[i3])) continue;
                return i3 >> 1;
            }
        }
        return -1;
    }

    public void b(int n2) {
        int n3 = this.i;
        Object[] objectArray = this.g;
        if (objectArray.length < n2) {
            objectArray = Arrays.copyOf((int[])objectArray, (int)n2);
            k.d(objectArray, "copyOf(this, newSize)");
            this.g = objectArray;
            objectArray = Arrays.copyOf((Object[])this.h, (int)(n2 * 2));
            k.d(objectArray, "copyOf(this, newSize)");
            this.h = objectArray;
        }
        if (this.i == n3) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public void clear() {
        if (this.i > 0) {
            this.g = a.a;
            this.h = a.c;
            this.i = 0;
        }
        if (this.i <= 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public boolean containsKey(Object object) {
        return this.d(object) >= 0;
    }

    public boolean containsValue(Object object) {
        return this.a(object) >= 0;
    }

    public int d(Object object) {
        if (object == null) {
            return this.e();
        }
        return this.c(object, object.hashCode());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        block18: {
            int n2;
            block19: {
                block15: {
                    block16: {
                        if (this == object) {
                            return true;
                        }
                        if (!(object instanceof i)) break block15;
                        if (this.size() == ((i)object).size()) break block16;
                        return false;
                    }
                    object = (i)object;
                    int n3 = this.i;
                    for (int i2 = 0; i2 < n3; ++i2) {
                        Object object2;
                        Object object3;
                        block17: {
                            Object object4 = this.f(i2);
                            object3 = this.j(i2);
                            object2 = ((i)object).get(object4);
                            if (object3 != null) break block17;
                            if (object2 != null) return false;
                            if (((i)object).containsKey(object4)) continue;
                            return false;
                        }
                        if (k.a(object3, object2)) continue;
                        return false;
                    }
                    return true;
                }
                if (!(object instanceof Map)) break block18;
                if (this.size() == ((Map)object).size()) break block19;
                return false;
            }
            try {
                n2 = this.i;
            }
            catch (ClassCastException | NullPointerException throwable) {
                return false;
            }
            for (int i3 = 0; i3 < n2; ++i3) {
                Object object5;
                Object object6;
                block20: {
                    Object object7 = this.f(i3);
                    object6 = this.j(i3);
                    object5 = ((Map)object).get(object7);
                    if (object6 != null) break block20;
                    if (object5 != null) return false;
                    if (((Map)object).containsKey(object7)) continue;
                    return false;
                }
                boolean bl = k.a(object6, object5);
                if (bl) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public Object f(int n2) {
        if (n2 >= 0 && n2 < this.i) {
            return this.h[n2 << 1];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected index to be within 0..size()-1, but was ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString().toString());
    }

    public void g(i i2) {
        k.e(i2, "map");
        int n2 = i2.i;
        this.b(this.i + n2);
        int n3 = this.i;
        if (n3 == 0) {
            if (n2 > 0) {
                I2.i.e(i2.g, this.g, 0, 0, n2);
                I2.i.g(i2.h, this.h, 0, 0, n2 << 1);
                this.i = n2;
                return;
            }
        } else {
            for (int i3 = 0; i3 < n2; ++i3) {
                this.put(i2.f(i3), i2.j(i3));
            }
        }
    }

    public Object get(Object object) {
        int n2 = this.d(object);
        if (n2 >= 0) {
            return this.h[(n2 << 1) + 1];
        }
        return null;
    }

    public Object getOrDefault(Object object, Object object2) {
        int n2 = this.d(object);
        if (n2 >= 0) {
            return this.h[(n2 << 1) + 1];
        }
        return object2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Object h(int n2) {
        int n3;
        if (n2 >= 0 && n2 < (n3 = this.i)) {
            Object[] objectArray = this.h;
            int n4 = n2 << 1;
            Object object = objectArray[n4 + 1];
            if (n3 <= 1) {
                this.clear();
                return object;
            }
            int n5 = n3 - 1;
            int[] nArray = this.g;
            int n6 = nArray.length;
            int n7 = 8;
            if (n6 > 8 && n3 < nArray.length / 3) {
                if (n3 > 8) {
                    n7 = n3 + (n3 >> 1);
                }
                int[] nArray2 = Arrays.copyOf((int[])nArray, (int)n7);
                k.d(nArray2, "copyOf(this, newSize)");
                this.g = nArray2;
                Object[] objectArray2 = Arrays.copyOf((Object[])this.h, (int)(n7 << 1));
                k.d(objectArray2, "copyOf(this, newSize)");
                this.h = objectArray2;
                if (n3 != this.i) throw new ConcurrentModificationException();
                if (n2 > 0) {
                    I2.i.e(nArray, this.g, 0, 0, n2);
                    I2.i.g(objectArray, this.h, 0, 0, n4);
                }
                if (n2 < n5) {
                    int[] nArray3 = this.g;
                    n7 = n2 + 1;
                    I2.i.e(nArray, nArray3, n2, n7, n3);
                    I2.i.g(objectArray, this.h, n4, n7 << 1, n3 << 1);
                }
            } else {
                if (n2 < n5) {
                    n7 = n2 + 1;
                    I2.i.e(nArray, nArray, n2, n7, n3);
                    Object[] objectArray3 = this.h;
                    I2.i.g(objectArray3, objectArray3, n4, n7 << 1, n3 << 1);
                }
                Object[] objectArray4 = this.h;
                n2 = n5 << 1;
                objectArray4[n2] = null;
                objectArray4[n2 + 1] = null;
            }
            if (n3 != this.i) throw new ConcurrentModificationException();
            this.i = n5;
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected index to be within 0..size()-1, but was ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString().toString());
    }

    public int hashCode() {
        int[] nArray = this.g;
        Object[] objectArray = this.h;
        int n2 = this.i;
        int n3 = 1;
        int n4 = 0;
        int n5 = 0;
        while (n4 < n2) {
            Object object = objectArray[n3];
            int n6 = nArray[n4];
            int n7 = object != null ? object.hashCode() : 0;
            n5 += n7 ^ n6;
            ++n4;
            n3 += 2;
        }
        return n5;
    }

    public Object i(int n2, Object object) {
        if (n2 >= 0 && n2 < this.i) {
            n2 = (n2 << 1) + 1;
            Object[] objectArray = this.h;
            Object object2 = objectArray[n2];
            objectArray[n2] = object;
            return object2;
        }
        object = new StringBuilder();
        object.append("Expected index to be within 0..size()-1, but was ");
        object.append(n2);
        throw new IllegalArgumentException(object.toString().toString());
    }

    public boolean isEmpty() {
        return this.i <= 0;
    }

    public Object j(int n2) {
        if (n2 >= 0 && n2 < this.i) {
            return this.h[(n2 << 1) + 1];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected index to be within 0..size()-1, but was ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString().toString());
    }

    public Object put(Object objectArray, Object object) {
        int n2 = this.i;
        int n3 = objectArray != null ? objectArray.hashCode() : 0;
        int n4 = objectArray != null ? this.c(objectArray, n3) : this.e();
        if (n4 >= 0) {
            n4 = (n4 << 1) + 1;
            objectArray = this.h;
            Object object2 = objectArray[n4];
            objectArray[n4] = object;
            return object2;
        }
        int n5 = ~n4;
        Object[] objectArray2 = this.g;
        if (n2 >= objectArray2.length) {
            n4 = 8;
            if (n2 >= 8) {
                n4 = (n2 >> 1) + n2;
            } else if (n2 < 4) {
                n4 = 4;
            }
            objectArray2 = Arrays.copyOf((int[])objectArray2, (int)n4);
            k.d(objectArray2, "copyOf(this, newSize)");
            this.g = objectArray2;
            objectArray2 = Arrays.copyOf((Object[])this.h, (int)(n4 << 1));
            k.d(objectArray2, "copyOf(this, newSize)");
            this.h = objectArray2;
            if (n2 != this.i) {
                throw new ConcurrentModificationException();
            }
        }
        if (n5 < n2) {
            objectArray2 = this.g;
            n4 = n5 + 1;
            I2.i.e(objectArray2, objectArray2, n4, n5, n2);
            objectArray2 = this.h;
            I2.i.g(objectArray2, objectArray2, n4 << 1, n5 << 1, this.i << 1);
        }
        if (n2 == (n4 = this.i) && n5 < (objectArray2 = this.g).length) {
            objectArray2[n5] = n3;
            objectArray2 = this.h;
            n3 = n5 << 1;
            objectArray2[n3] = (int)objectArray;
            objectArray2[n3 + 1] = (int)object;
            this.i = n4 + 1;
            return null;
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object object, Object object2) {
        Object object3 = this.get(object);
        if (object3 == null) {
            return this.put(object, object2);
        }
        return object3;
    }

    public Object remove(Object object) {
        int n2 = this.d(object);
        if (n2 >= 0) {
            return this.h(n2);
        }
        return null;
    }

    public boolean remove(Object object, Object object2) {
        int n2 = this.d(object);
        if (n2 >= 0 && k.a(object2, this.j(n2))) {
            this.h(n2);
            return true;
        }
        return false;
    }

    public Object replace(Object object, Object object2) {
        int n2 = this.d(object);
        if (n2 >= 0) {
            return this.i(n2, object2);
        }
        return null;
    }

    public boolean replace(Object object, Object object2, Object object3) {
        int n2 = this.d(object);
        if (n2 >= 0 && k.a(object2, this.j(n2))) {
            this.i(n2, object3);
            return true;
        }
        return false;
    }

    public int size() {
        return this.i;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        Object object = new StringBuilder(this.i * 28);
        object.append('{');
        int n2 = this.i;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object2;
            if (i2 > 0) {
                object.append(", ");
            }
            if ((object2 = this.f(i2)) != object) {
                object.append(object2);
            } else {
                object.append("(this Map)");
            }
            object.append('=');
            object2 = this.j(i2);
            if (object2 != object) {
                object.append(object2);
                continue;
            }
            object.append("(this Map)");
        }
        object.append('}');
        object = object.toString();
        k.d(object, "StringBuilder(capacity).\u2026builderAction).toString()");
        return object;
    }
}

