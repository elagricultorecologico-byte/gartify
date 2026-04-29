/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Map$Entry
 *  q.b
 *  q.c
 */
package p;

import H2.q;
import I2.o;
import V2.k;
import java.util.Map;
import q.b;
import q.c;

public class h {
    private int a;
    private final c b;
    private final b c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    public h(int n3) {
        this.a = n3;
        if (n3 > 0) {
            this.b = new c(0, 0.75f);
            this.c = new b();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private final int e(Object object, Object object2) {
        int n3 = this.f(object, object2);
        if (n3 >= 0) {
            return n3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative size: ");
        stringBuilder.append(object);
        stringBuilder.append('=');
        stringBuilder.append(object2);
        throw new IllegalStateException(stringBuilder.toString().toString());
    }

    protected Object a(Object object) {
        k.e(object, "key");
        return null;
    }

    protected void b(boolean bl, Object object, Object object2, Object object3) {
        k.e(object, "key");
        k.e(object2, "oldValue");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final Object c(Object object) {
        Object object2;
        Object object3;
        block10: {
            Object object4;
            block9: {
                b b3;
                k.e(object, "key");
                b b4 = b3 = this.c;
                // MONITORENTER : b4
                object4 = this.b.a(object);
                if (object4 != null) {
                    ++this.h;
                    // MONITOREXIT : b4
                    return object4;
                }
                ++this.i;
                // MONITOREXIT : b4
                object3 = this.a(object);
                if (object3 == null) {
                    return null;
                }
                b4 = b3 = this.c;
                // MONITORENTER : b4
                ++this.f;
                object2 = this.b.d(object, object3);
                if (object2 == null) break block9;
                this.b.d(object, object2);
                break block10;
            }
            this.d += this.e(object, object3);
            object4 = q.a;
        }
        // MONITOREXIT : b4
        if (object2 != null) {
            this.b(false, object, object3, object2);
            return object2;
        }
        this.g(this.a);
        return object3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final Object d(Object object, Object object2) {
        b b3;
        k.e(object, "key");
        k.e(object2, "value");
        b b4 = b3 = this.c;
        // MONITORENTER : b4
        ++this.e;
        this.d += this.e(object, object2);
        Object object3 = this.b.d(object, object2);
        if (object3 != null) {
            this.d -= this.e(object, object3);
        }
        q q2 = q.a;
        // MONITOREXIT : b4
        if (object3 != null) {
            this.b(false, object, object3, object2);
        }
        this.g(this.a);
        return object3;
    }

    protected int f(Object object, Object object2) {
        k.e(object, "key");
        k.e(object2, "value");
        return 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void g(int n3) {
        Object object;
        while (true) {
            Object object2;
            b b3;
            b b4 = b3 = this.c;
            synchronized (b4) {
                block7: {
                    if (this.d < 0 || this.b.c() && this.d != 0) break block6;
                    if (this.d <= n3 || this.b.c()) break;
                    object2 = (Map.Entry)o.x((Iterable)this.b.b());
                    if (object2 != null) break block7;
                    return;
                }
                object = object2.getKey();
                object2 = object2.getValue();
                this.b.e(object);
                this.d -= this.e(object, object2);
                ++this.g;
            }
            this.b(true, object, object2, null);
        }
        {
            block6: {
                return;
            }
            try {
                object = new IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
                throw object;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String toString() {
        b b3;
        b b4 = b3 = this.c;
        synchronized (b4) {
            Throwable throwable2;
            block3: {
                int n3;
                try {
                    n3 = this.h;
                    int n4 = this.i + n3;
                    n3 = n4 != 0 ? n3 * 100 / n4 : 0;
                }
                catch (Throwable throwable2) {
                    break block3;
                }
                Object object = new StringBuilder();
                object.append("LruCache[maxSize=");
                object.append(this.a);
                object.append(",hits=");
                object.append(this.h);
                object.append(",misses=");
                object.append(this.i);
                object.append(",hitRate=");
                object.append(n3);
                object.append("%]");
                return object.toString();
            }
            throw throwable2;
        }
    }
}

