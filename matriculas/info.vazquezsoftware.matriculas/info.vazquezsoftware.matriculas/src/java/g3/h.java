/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 */
package G3;

import D3.e;
import E3.b;
import G3.f;
import java.util.HashMap;
import java.util.Map;

public class h
implements Cloneable {
    private static final Map p;
    private static final String[] q;
    private static final String[] r;
    private static final String[] s;
    private static final String[] t;
    private static final String[] u;
    private static final String[] v;
    private static final String[] w;
    private String g;
    private String h;
    private boolean i = true;
    private boolean j = true;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;

    static {
        int n2;
        p = new HashMap();
        String[] stringArray = new String[]{"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext", "template", "article", "main", "svg", "math", "center"};
        q = stringArray;
        r = new String[]{"object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", "s"};
        s = new String[]{"meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
        t = new String[]{"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s"};
        u = new String[]{"pre", "plaintext", "title", "textarea"};
        v = new String[]{"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
        w = new String[]{"input", "keygen", "object", "select", "textarea"};
        int n3 = stringArray.length;
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            G3.h.n(new h(stringArray[n2]));
        }
        stringArray = r;
        n3 = stringArray.length;
        for (n2 = 0; n2 < n3; ++n2) {
            h object2 = new h(stringArray[n2]);
            object2.i = false;
            object2.j = false;
            G3.h.n(object2);
        }
        for (String string : s) {
            h h2 = (h)p.get((Object)string);
            e.j(h2);
            h2.k = true;
        }
        for (String string : t) {
            h h3 = (h)p.get((Object)string);
            e.j(h3);
            h3.j = false;
        }
        for (String string : u) {
            h h4 = (h)p.get((Object)string);
            e.j(h4);
            h4.m = true;
        }
        for (String string : v) {
            h h5 = (h)p.get((Object)string);
            e.j(h5);
            h5.n = true;
        }
        stringArray = w;
        n3 = stringArray.length;
        for (n2 = n4; n2 < n3; ++n2) {
            String string = stringArray[n2];
            h h6 = (h)p.get((Object)string);
            e.j(h6);
            h6.o = true;
        }
    }

    private h(String string) {
        this.g = string;
        this.h = b.a(string);
    }

    private static void n(h h2) {
        p.put((Object)h2.g, (Object)h2);
    }

    public static h q(String string) {
        return G3.h.r(string, f.d);
    }

    public static h r(String object, f object2) {
        e.j(object);
        Object object3 = p;
        Object object4 = (h)object3.get(object);
        if (object4 == null) {
            object = ((f)object2).c((String)object);
            e.h((String)object);
            object4 = b.a((String)object);
            object3 = (h)object3.get(object4);
            if (object3 == null) {
                object = new h((String)object);
                ((h)object).i = false;
                return object;
            }
            if (((f)object2).e() && !object.equals(object4)) {
                object2 = ((h)object3).a();
                ((h)object2).g = object;
                return object2;
            }
            return object3;
        }
        return object4;
    }

    protected h a() {
        try {
            h h2 = (h)super.clone();
            return h2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException((Throwable)cloneNotSupportedException);
        }
    }

    public boolean b() {
        return this.j;
    }

    public String c() {
        return this.g;
    }

    public boolean d() {
        return this.i;
    }

    public boolean e() {
        return this.k;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof h)) {
            return false;
        }
        object = (h)object;
        if (!this.g.equals((Object)((h)object).g)) {
            return false;
        }
        if (this.k != ((h)object).k) {
            return false;
        }
        if (this.j != ((h)object).j) {
            return false;
        }
        if (this.i != ((h)object).i) {
            return false;
        }
        if (this.m != ((h)object).m) {
            return false;
        }
        if (this.l != ((h)object).l) {
            return false;
        }
        if (this.n != ((h)object).n) {
            return false;
        }
        return this.o == ((h)object).o;
    }

    public boolean g() {
        return this.n;
    }

    public boolean h() {
        return this.i ^ true;
    }

    public int hashCode() {
        return ((((((this.g.hashCode() * 31 + this.i) * 31 + this.j) * 31 + this.k) * 31 + this.l) * 31 + this.m) * 31 + this.n) * 31 + this.o;
    }

    public boolean i() {
        return p.containsKey((Object)this.g);
    }

    public boolean k() {
        return this.k || this.l;
        {
        }
    }

    public String l() {
        return this.h;
    }

    public boolean m() {
        return this.m;
    }

    h o() {
        this.l = true;
        return this;
    }

    public String toString() {
        return this.g;
    }
}

