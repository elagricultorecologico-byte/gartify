/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.PrintStream
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Arrays
 */
package v;

import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import r.d;
import u.b;
import u.e;
import u.f;

public class o {
    static int g;
    ArrayList a = new ArrayList();
    int b;
    boolean c = false;
    int d;
    ArrayList e = null;
    private int f = -1;

    public o(int n2) {
        int n3 = g;
        g = n3 + 1;
        this.b = n3;
        this.d = n2;
    }

    private String e() {
        int n2 = this.d;
        if (n2 == 0) {
            return "Horizontal";
        }
        if (n2 == 1) {
            return "Vertical";
        }
        if (n2 == 2) {
            return "Both";
        }
        return "Unknown";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int j(d d2, ArrayList arrayList, int n2) {
        int n3;
        int n4 = 0;
        f f2 = (f)((e)arrayList.get(0)).K();
        d2.E();
        f2.g(d2, false);
        for (n3 = 0; n3 < arrayList.size(); ++n3) {
            ((e)arrayList.get(n3)).g(d2, false);
        }
        if (n2 == 0 && f2.W0 > 0) {
            u.b.b(f2, d2, arrayList, 0);
        }
        if (n2 == 1 && f2.X0 > 0) {
            u.b.b(f2, d2, arrayList, 1);
        }
        try {
            d2.A();
        }
        catch (Exception exception) {
            PrintStream printStream = System.err;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(exception.toString());
            stringBuilder.append("\n");
            stringBuilder.append(Arrays.toString((Object[])exception.getStackTrace()).replace((CharSequence)"[", (CharSequence)"   at ").replace((CharSequence)",", (CharSequence)"\n   at").replace((CharSequence)"]", (CharSequence)""));
            printStream.println(stringBuilder.toString());
        }
        this.e = new ArrayList();
        for (n3 = n4; n3 < arrayList.size(); ++n3) {
            a a2 = new a((e)arrayList.get(n3), d2, n2);
            this.e.add((Object)a2);
        }
        if (n2 == 0) {
            n2 = d2.y(f2.O);
            n3 = d2.y(f2.Q);
            d2.E();
            return n3 - n2;
        }
        n2 = d2.y(f2.P);
        n3 = d2.y(f2.R);
        d2.E();
        return n3 - n2;
    }

    public boolean a(e e2) {
        if (this.a.contains((Object)e2)) {
            return false;
        }
        this.a.add((Object)e2);
        return true;
    }

    public void b(ArrayList arrayList) {
        int n2 = this.a.size();
        if (this.f != -1 && n2 > 0) {
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                o o2 = (o)arrayList.get(i2);
                if (this.f != o2.b) continue;
                this.g(this.d, o2);
            }
        }
        if (n2 == 0) {
            arrayList.remove((Object)this);
        }
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public int f(d d2, int n2) {
        if (this.a.size() == 0) {
            return 0;
        }
        return this.j(d2, this.a, n2);
    }

    public void g(int n2, o o2) {
        ArrayList arrayList = this.a;
        int n3 = arrayList.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            Object object = arrayList.get(i2);
            object = (e)object;
            o2.a((e)object);
            if (n2 == 0) {
                ((e)object).I0 = o2.c();
                continue;
            }
            ((e)object).J0 = o2.c();
        }
        this.f = o2.b;
    }

    public void h(boolean bl) {
        this.c = bl;
    }

    public void i(int n2) {
        this.d = n2;
    }

    public String toString() {
        Object object = new StringBuilder();
        object.append(this.e());
        object.append(" [");
        object.append(this.b);
        object.append("] <");
        object = object.toString();
        ArrayList arrayList = this.a;
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object2 = arrayList.get(i2);
            object2 = (e)object2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append(" ");
            stringBuilder.append(((e)object2).t());
            object = stringBuilder.toString();
        }
        arrayList = new StringBuilder();
        arrayList.append((String)object);
        arrayList.append(" >");
        return arrayList.toString();
    }

    static class a {
        WeakReference a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;

        a(e e2, d d2, int n2) {
            this.a = new WeakReference((Object)e2);
            this.b = d2.y(e2.O);
            this.c = d2.y(e2.P);
            this.d = d2.y(e2.Q);
            this.e = d2.y(e2.R);
            this.f = d2.y(e2.S);
            this.g = n2;
        }
    }
}

