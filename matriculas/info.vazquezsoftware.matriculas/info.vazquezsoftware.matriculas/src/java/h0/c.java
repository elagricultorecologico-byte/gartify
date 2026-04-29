/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AutoCloseable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.TreeMap
 */
package h0;

import java.util.TreeMap;
import m0.d;
import m0.e;

public class c
implements e,
d,
AutoCloseable {
    static final TreeMap o = new TreeMap();
    private volatile String g;
    final long[] h;
    final double[] i;
    final String[] j;
    final byte[][] k;
    private final int[] l;
    final int m;
    int n;

    private c(int n2) {
        this.m = n2++;
        this.l = new int[n2];
        this.h = new long[n2];
        this.i = new double[n2];
        this.j = new String[n2];
        this.k = new byte[n2][];
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static c i(String string, int n2) {
        Object object = o;
        TreeMap treeMap = object;
        // MONITORENTER : treeMap
        Object object2 = object.ceilingEntry((Object)n2);
        if (object2 != null) {
            object.remove(object2.getKey());
            object2 = (c)object2.getValue();
            ((c)object2).j(string, n2);
            // MONITOREXIT : treeMap
            return object2;
        }
        object = new c(n2);
        ((c)object).j(string, n2);
        return object;
    }

    private static void p() {
        TreeMap treeMap = o;
        if (treeMap.size() > 15) {
            int n2 = treeMap.size() - 10;
            treeMap = treeMap.descendingKeySet().iterator();
            while (n2 > 0) {
                treeMap.next();
                treeMap.remove();
                --n2;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A() {
        TreeMap treeMap;
        TreeMap treeMap2 = treeMap = o;
        synchronized (treeMap2) {
            treeMap.put((Object)this.m, (Object)this);
            c.p();
            return;
        }
    }

    @Override
    public void H(int n2) {
        this.l[n2] = 1;
    }

    @Override
    public void K(int n2, double d2) {
        this.l[n2] = 3;
        this.i[n2] = d2;
    }

    @Override
    public String a() {
        return this.g;
    }

    public void close() {
    }

    @Override
    public void e0(int n2, long l2) {
        this.l[n2] = 2;
        this.h[n2] = l2;
    }

    @Override
    public void f(d d2) {
        for (int i2 = 1; i2 <= this.n; ++i2) {
            int n2 = this.l[i2];
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            if (n2 != 5) continue;
                            d2.p0(i2, this.k[i2]);
                            continue;
                        }
                        d2.w(i2, this.j[i2]);
                        continue;
                    }
                    d2.K(i2, this.i[i2]);
                    continue;
                }
                d2.e0(i2, this.h[i2]);
                continue;
            }
            d2.H(i2);
        }
    }

    void j(String string, int n2) {
        this.g = string;
        this.n = n2;
    }

    @Override
    public void p0(int n2, byte[] byArray) {
        this.l[n2] = 5;
        this.k[n2] = byArray;
    }

    @Override
    public void w(int n2, String string) {
        this.l[n2] = 4;
        this.j[n2] = string;
    }
}

