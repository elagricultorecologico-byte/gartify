/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  java.lang.CharSequence
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Set
 *  java.util.TreeMap
 */
package j0;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class f {
    public final String a;
    public final Map b;
    public final Set c;
    public final Set d;

    public f(String string, Map map, Set set, Set set2) {
        this.a = string;
        this.b = Collections.unmodifiableMap((Map)map);
        this.c = Collections.unmodifiableSet((Set)set);
        string = set2 == null ? null : Collections.unmodifiableSet((Set)set2);
        this.d = string;
    }

    public static f a(m0.b b2, String string) {
        return new f(string, f.b(b2, string), f.d(b2, string), f.f(b2, string));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Map b(m0.b b2, String string) {
        Throwable throwable2;
        block4: {
            HashMap hashMap;
            block3: {
                Object object = new StringBuilder();
                object.append("PRAGMA table_info(`");
                object.append(string);
                object.append("`)");
                b2 = b2.C0(object.toString());
                hashMap = new HashMap();
                try {
                    if (b2.getColumnCount() <= 0) break block3;
                    int n2 = b2.getColumnIndex("name");
                    int n3 = b2.getColumnIndex("type");
                    int n4 = b2.getColumnIndex("notnull");
                    int n5 = b2.getColumnIndex("pk");
                    int n6 = b2.getColumnIndex("dflt_value");
                    while (b2.moveToNext()) {
                        String string2 = b2.getString(n2);
                        String string3 = b2.getString(n3);
                        boolean bl = b2.getInt(n4) != 0;
                        int n7 = b2.getInt(n5);
                        string = b2.getString(n6);
                        object = new a(string2, string3, bl, n7, string, 2);
                        hashMap.put((Object)string2, object);
                    }
                }
                catch (Throwable throwable2) {
                    break block4;
                }
            }
            b2.close();
            return hashMap;
        }
        b2.close();
        throw throwable2;
    }

    private static List c(Cursor cursor) {
        int n2 = cursor.getColumnIndex("id");
        int n3 = cursor.getColumnIndex("seq");
        int n4 = cursor.getColumnIndex("from");
        int n5 = cursor.getColumnIndex("to");
        int n6 = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < n6; ++i2) {
            cursor.moveToPosition(i2);
            arrayList.add((Object)new c(cursor.getInt(n2), cursor.getInt(n3), cursor.getString(n4), cursor.getString(n5)));
        }
        Collections.sort((List)arrayList);
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Set d(m0.b b2, String string) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        StringBuilder stringBuilder;
        HashSet hashSet;
        block4: {
            hashSet = new HashSet();
            stringBuilder = new StringBuilder();
            stringBuilder.append("PRAGMA foreign_key_list(`");
            stringBuilder.append(string);
            stringBuilder.append("`)");
            b2 = b2.C0(stringBuilder.toString());
            try {
                n7 = b2.getColumnIndex("id");
                n6 = b2.getColumnIndex("seq");
                n5 = b2.getColumnIndex("table");
                n4 = b2.getColumnIndex("on_delete");
                n3 = b2.getColumnIndex("on_update");
                string = f.c((Cursor)b2);
                n2 = b2.getCount();
                break block4;
            }
            catch (Throwable throwable) {}
            b2.close();
            throw throwable;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object;
            b2.moveToPosition(i2);
            if (b2.getInt(n6) != 0) continue;
            int n8 = b2.getInt(n7);
            ArrayList arrayList = new ArrayList();
            stringBuilder = new ArrayList();
            Iterator iterator = string.iterator();
            while (iterator.hasNext()) {
                object = (c)iterator.next();
                if (((c)object).g != n8) continue;
                arrayList.add((Object)((c)object).i);
                stringBuilder.add((Object)((c)object).j);
            }
            object = new b(b2.getString(n5), b2.getString(n4), b2.getString(n3), (List)arrayList, (List)stringBuilder);
            hashSet.add(object);
        }
        b2.close();
        return hashSet;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static d e(m0.b b2, String object, boolean bl) {
        int n2;
        int n3;
        int n4;
        StringBuilder stringBuilder;
        block4: {
            Throwable throwable2;
            block5: {
                block3: {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("PRAGMA index_xinfo(`");
                    stringBuilder.append((String)object);
                    stringBuilder.append("`)");
                    b2 = b2.C0(stringBuilder.toString());
                    try {
                        n4 = b2.getColumnIndex("seqno");
                        n3 = b2.getColumnIndex("cid");
                        n2 = b2.getColumnIndex("name");
                        if (n4 == -1 || n3 == -1 || n2 == -1) break block3;
                        stringBuilder = new TreeMap();
                        break block4;
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                }
                b2.close();
                return null;
            }
            b2.close();
            throw throwable2;
        }
        while (b2.moveToNext()) {
            if (b2.getInt(n3) < 0) continue;
            stringBuilder.put((Object)b2.getInt(n4), (Object)b2.getString(n2));
        }
        ArrayList arrayList = new ArrayList(stringBuilder.size());
        arrayList.addAll(stringBuilder.values());
        object = new d((String)object, bl, (List)arrayList);
        b2.close();
        return object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Set f(m0.b var0, String var1_2) {
        block9: {
            block6: {
                block8: {
                    block7: {
                        var7_3 = new StringBuilder();
                        var7_3.append("PRAGMA index_list(`");
                        var7_3.append(var1_2);
                        var7_3.append("`)");
                        var1_2 = var0.C0(var7_3.toString());
                        try {
                            var4_4 = var1_2.getColumnIndex("name");
                            var3_5 = var1_2.getColumnIndex("origin");
                            var2_6 = var1_2.getColumnIndex("unique");
                            if (var4_4 == -1 || var3_5 == -1 || var2_6 == -1) break block6;
                            var7_3 = new HashSet();
lbl15:
                            // 3 sources

                            while (var1_2.moveToNext()) {
                                if (!"c".equals((Object)var1_2.getString(var3_5))) continue;
                                var8_9 = var1_2.getString(var4_4);
                                var5_7 = var1_2.getInt(var2_6);
                                var6_8 = true;
                                if (var5_7 != 1) {
                                    var6_8 = false;
                                }
                                var8_9 = f.e(var0, (String)var8_9, var6_8);
                                if (var8_9 == null) {
                                    break block7;
                                }
                                ** GOTO lbl-1000
                            }
                            break block8;
                        }
                        catch (Throwable var0_1) {
                            break block9;
                        }
                    }
                    var1_2.close();
                    return null;
lbl-1000:
                    // 1 sources

                    {
                        var7_3.add(var8_9);
                        ** GOTO lbl15
                    }
                }
                var1_2.close();
                return var7_3;
            }
            var1_2.close();
            return null;
        }
        var1_2.close();
        throw var0_1;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            object = (f)object;
            String string = this.a;
            if (string != null ? !string.equals((Object)((f)object).a) : ((f)object).a != null) {
                return false;
            }
            string = this.b;
            if (string != null ? !string.equals((Object)((f)object).b) : ((f)object).b != null) {
                return false;
            }
            string = this.c;
            if (string != null ? !string.equals((Object)((f)object).c) : ((f)object).c != null) {
                return false;
            }
            string = this.d;
            if (string != null && (object = ((f)object).d) != null) {
                return string.equals(object);
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        String string = this.a;
        int n2 = 0;
        int n3 = string != null ? string.hashCode() : 0;
        string = this.b;
        int n4 = string != null ? string.hashCode() : 0;
        string = this.c;
        if (string != null) {
            n2 = string.hashCode();
        }
        return (n3 * 31 + n4) * 31 + n2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TableInfo{name='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", columns=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", foreignKeys=");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(", indices=");
        stringBuilder.append((Object)this.d);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static class a {
        public final String a;
        public final String b;
        public final int c;
        public final boolean d;
        public final int e;
        public final String f;
        private final int g;

        public a(String string, String string2, boolean bl, int n2, String string3, int n3) {
            this.a = string;
            this.b = string2;
            this.d = bl;
            this.e = n2;
            this.c = j0.f$a.a(string2);
            this.f = string3;
            this.g = n3;
        }

        private static int a(String string) {
            if (string == null) {
                return 5;
            }
            if ((string = string.toUpperCase(Locale.US)).contains((CharSequence)"INT")) {
                return 3;
            }
            if (!(string.contains((CharSequence)"CHAR") || string.contains((CharSequence)"CLOB") || string.contains((CharSequence)"TEXT"))) {
                if (string.contains((CharSequence)"BLOB")) {
                    return 5;
                }
                if (!(string.contains((CharSequence)"REAL") || string.contains((CharSequence)"FLOA") || string.contains((CharSequence)"DOUB"))) {
                    return 1;
                }
                return 4;
            }
            return 2;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object != null && this.getClass() == object.getClass()) {
                String string;
                object = (a)object;
                if (this.e != ((a)object).e) {
                    return false;
                }
                if (!this.a.equals((Object)((a)object).a)) {
                    return false;
                }
                if (this.d != ((a)object).d) {
                    return false;
                }
                if (this.g == 1 && ((a)object).g == 2 && (string = this.f) != null && !string.equals((Object)((a)object).f)) {
                    return false;
                }
                if (this.g == 2 && ((a)object).g == 1 && (string = ((a)object).f) != null && !string.equals((Object)this.f)) {
                    return false;
                }
                int n2 = this.g;
                if (n2 != 0 && n2 == ((a)object).g && ((string = this.f) != null ? !string.equals((Object)((a)object).f) : ((a)object).f != null)) {
                    return false;
                }
                if (this.c == ((a)object).c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int n2 = this.a.hashCode();
            int n3 = this.c;
            int n4 = this.d ? 1231 : 1237;
            return ((n2 * 31 + n3) * 31 + n4) * 31 + this.e;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Column{name='");
            stringBuilder.append(this.a);
            stringBuilder.append('\'');
            stringBuilder.append(", type='");
            stringBuilder.append(this.b);
            stringBuilder.append('\'');
            stringBuilder.append(", affinity='");
            stringBuilder.append(this.c);
            stringBuilder.append('\'');
            stringBuilder.append(", notNull=");
            stringBuilder.append(this.d);
            stringBuilder.append(", primaryKeyPosition=");
            stringBuilder.append(this.e);
            stringBuilder.append(", defaultValue='");
            stringBuilder.append(this.f);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static class b {
        public final String a;
        public final String b;
        public final String c;
        public final List d;
        public final List e;

        public b(String string, String string2, String string3, List list, List list2) {
            this.a = string;
            this.b = string2;
            this.c = string3;
            this.d = Collections.unmodifiableList((List)list);
            this.e = Collections.unmodifiableList((List)list2);
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object != null && this.getClass() == object.getClass()) {
                object = (b)object;
                if (!this.a.equals((Object)((b)object).a)) {
                    return false;
                }
                if (!this.b.equals((Object)((b)object).b)) {
                    return false;
                }
                if (!this.c.equals((Object)((b)object).c)) {
                    return false;
                }
                if (!this.d.equals((Object)((b)object).d)) {
                    return false;
                }
                return this.e.equals((Object)((b)object).e);
            }
            return false;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode()) * 31 + this.e.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ForeignKey{referenceTable='");
            stringBuilder.append(this.a);
            stringBuilder.append('\'');
            stringBuilder.append(", onDelete='");
            stringBuilder.append(this.b);
            stringBuilder.append('\'');
            stringBuilder.append(", onUpdate='");
            stringBuilder.append(this.c);
            stringBuilder.append('\'');
            stringBuilder.append(", columnNames=");
            stringBuilder.append((Object)this.d);
            stringBuilder.append(", referenceColumnNames=");
            stringBuilder.append((Object)this.e);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    static class c
    implements Comparable {
        final int g;
        final int h;
        final String i;
        final String j;

        c(int n2, int n3, String string, String string2) {
            this.g = n2;
            this.h = n3;
            this.i = string;
            this.j = string2;
        }

        public int d(c c2) {
            int n2;
            int n3 = n2 = this.g - c2.g;
            if (n2 == 0) {
                n3 = this.h - c2.h;
            }
            return n3;
        }
    }

    public static class d {
        public final String a;
        public final boolean b;
        public final List c;

        public d(String string, boolean bl, List list) {
            this.a = string;
            this.b = bl;
            this.c = list;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object != null && this.getClass() == object.getClass()) {
                object = (d)object;
                if (this.b != ((d)object).b) {
                    return false;
                }
                if (!this.c.equals((Object)((d)object).c)) {
                    return false;
                }
                if (this.a.startsWith("index_")) {
                    return ((d)object).a.startsWith("index_");
                }
                return this.a.equals((Object)((d)object).a);
            }
            return false;
        }

        public int hashCode() {
            int n2 = this.a.startsWith("index_") ? -1184239155 : this.a.hashCode();
            return (n2 * 31 + this.b) * 31 + this.c.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Index{name='");
            stringBuilder.append(this.a);
            stringBuilder.append('\'');
            stringBuilder.append(", unique=");
            stringBuilder.append(this.b);
            stringBuilder.append(", columns=");
            stringBuilder.append((Object)this.c);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
}

