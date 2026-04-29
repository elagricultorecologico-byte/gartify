/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.LinkedList
 *  java.util.List
 */
package F3;

import C3.d;
import D3.e;
import E3.c;
import F3.b;
import F3.f;
import F3.n;
import H3.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class m
implements Cloneable {
    static final List i = Collections.EMPTY_LIST;
    m g;
    int h;

    protected m() {
    }

    private void H(int n2) {
        List list = this.r();
        while (n2 < list.size()) {
            ((m)list.get(n2)).Q(n2);
            ++n2;
        }
    }

    protected void A(Appendable appendable) {
        H3.f.b(new a(appendable, n.a(this)), this);
    }

    abstract void B(Appendable var1, int var2, f.a var3);

    abstract void C(Appendable var1, int var2, f.a var3);

    public f D() {
        m m2 = this.N();
        if (m2 instanceof f) {
            return (f)m2;
        }
        return null;
    }

    public m E() {
        return this.g;
    }

    public final m F() {
        return this.g;
    }

    public m G() {
        m m2 = this.g;
        if (m2 == null) {
            return null;
        }
        if (this.h > 0) {
            return (m)m2.r().get(this.h - 1);
        }
        return null;
    }

    public void I() {
        e.j(this.g);
        this.g.J(this);
    }

    protected void J(m m2) {
        boolean bl = m2.g == this;
        e.d(bl);
        int n2 = m2.h;
        this.r().remove(n2);
        this.H(n2);
        m2.g = null;
    }

    protected void K(m m2) {
        m2.P(this);
    }

    protected void L(m m2, m m3) {
        boolean bl = m2.g == this;
        e.d(bl);
        e.j(m3);
        m m4 = m3.g;
        if (m4 != null) {
            m4.J(m3);
        }
        int n2 = m2.h;
        this.r().set(n2, (Object)m3);
        m3.g = this;
        m3.Q(n2);
        m2.g = null;
    }

    public void M(m m2) {
        e.j(m2);
        e.j(this.g);
        this.g.L(this, m2);
    }

    public m N() {
        m m2;
        m m3 = this;
        while ((m2 = m3.g) != null) {
            m3 = m2;
        }
        return m3;
    }

    public void O(String string) {
        e.j(string);
        this.o(string);
    }

    protected void P(m m2) {
        e.j(m2);
        m m3 = this.g;
        if (m3 != null) {
            m3.J(this);
        }
        this.g = m2;
    }

    protected void Q(int n2) {
        this.h = n2;
    }

    public int R() {
        return this.h;
    }

    public List S() {
        m m2 = this.g;
        if (m2 == null) {
            return Collections.EMPTY_LIST;
        }
        Object object2 = m2.r();
        m2 = new ArrayList(object2.size() - 1);
        for (Object object2 : object2) {
            if (object2 == this) continue;
            m2.add(object2);
        }
        return m2;
    }

    public String a(String string) {
        e.h(string);
        if (this.t() && this.e().v(string)) {
            return c.o(this.g(), this.e().t(string));
        }
        return "";
    }

    protected void b(int n2, m ... mArray) {
        int n3;
        int n4;
        List list;
        block6: {
            e.j(mArray);
            if (mArray.length == 0) {
                return;
            }
            list = this.r();
            int n5 = 0;
            m m2 = mArray[0].E();
            if (m2 != null && m2.k() == mArray.length) {
                List list2 = m2.r();
                n4 = mArray.length;
                while (true) {
                    n3 = n4 - 1;
                    if (n4 <= 0) break;
                    if (mArray[n3] == list2.get(n3)) {
                        n4 = n3;
                        continue;
                    }
                    break block6;
                    break;
                }
                m2.q();
                list.addAll(n2, (Collection)Arrays.asList((Object[])mArray));
                n4 = mArray.length;
                while (true) {
                    n5 = n4 - 1;
                    if (n4 <= 0) break;
                    mArray[n5].g = this;
                    n4 = n5;
                }
                this.H(n2);
                return;
            }
        }
        e.f(mArray);
        n3 = mArray.length;
        for (n4 = n5; n4 < n3; ++n4) {
            this.K(mArray[n4]);
        }
        list.addAll(n2, (Collection)Arrays.asList((Object[])mArray));
        this.H(n2);
    }

    public m c(String string, String string2) {
        string = n.b(this).e().a(string);
        this.e().H(string, string2);
        return this;
    }

    public String d(String string) {
        e.j(string);
        if (!this.t()) {
            return "";
        }
        String string2 = this.e().t(string);
        if (string2.length() > 0) {
            return string2;
        }
        if (string.startsWith("abs:")) {
            return this.a(string.substring(4));
        }
        return "";
    }

    public abstract b e();

    public boolean equals(Object object) {
        return this == object;
    }

    public abstract String g();

    public m h(m m2) {
        e.j(m2);
        e.j(this.g);
        this.g.b(this.h, m2);
        return this;
    }

    public m i(int n2) {
        return (m)this.r().get(n2);
    }

    public abstract int k();

    public List l() {
        if (this.k() == 0) {
            return i;
        }
        List list = this.r();
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll((Collection)list);
        return Collections.unmodifiableList((List)arrayList);
    }

    public m m() {
        m m2 = this.n(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add((Object)m2);
        while (!linkedList.isEmpty()) {
            m m3 = (m)linkedList.remove();
            int n2 = m3.k();
            for (int i2 = 0; i2 < n2; ++i2) {
                List list = m3.r();
                m m4 = ((m)list.get(i2)).n(m3);
                list.set(i2, (Object)m4);
                linkedList.add((Object)m4);
            }
        }
        return m2;
    }

    protected m n(m m2) {
        m m3;
        try {
            m3 = (m)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException((Throwable)cloneNotSupportedException);
        }
        m3.g = m2;
        int n2 = m2 == null ? 0 : this.h;
        m3.h = n2;
        return m3;
    }

    protected abstract void o(String var1);

    public abstract m q();

    protected abstract List r();

    public boolean s(String string) {
        e.j(string);
        if (!this.t()) {
            return false;
        }
        if (string.startsWith("abs:")) {
            String string2 = string.substring(4);
            if (this.e().v(string2) && !this.a(string2).isEmpty()) {
                return true;
            }
        }
        return this.e().v(string);
    }

    protected abstract boolean t();

    public String toString() {
        return this.z();
    }

    public boolean u() {
        return this.g != null;
    }

    protected void v(Appendable appendable, int n2, f.a a2) {
        appendable.append('\n').append((CharSequence)c.m(n2 * a2.i()));
    }

    public m w() {
        m m2 = this.g;
        if (m2 == null) {
            return null;
        }
        m2 = m2.r();
        int n2 = this.h + 1;
        if (m2.size() > n2) {
            return (m)m2.get(n2);
        }
        return null;
    }

    public abstract String x();

    void y() {
    }

    public String z() {
        StringBuilder stringBuilder = c.b();
        this.A((Appendable)stringBuilder);
        return c.n(stringBuilder);
    }

    private static class a
    implements g {
        private final Appendable a;
        private final f.a b;

        a(Appendable appendable, f.a a2) {
            this.a = appendable;
            this.b = a2;
            a2.l();
        }

        @Override
        public void a(m m2, int n2) {
            if (!m2.x().equals((Object)"#text")) {
                try {
                    m2.C(this.a, n2, this.b);
                    return;
                }
                catch (IOException iOException) {
                    throw new d(iOException);
                }
            }
        }

        @Override
        public void b(m m2, int n2) {
            try {
                m2.B(this.a, n2, this.b);
                return;
            }
            catch (IOException iOException) {
                throw new d(iOException);
            }
        }
    }
}

