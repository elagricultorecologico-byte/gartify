/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.FS
 *  com.google.android.gms.internal.ads.Fu
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.QS
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.ez0
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayDeque
 *  java.util.Collections
 *  java.util.ConcurrentModificationException
 *  java.util.HashSet
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package l1;

import a1.t;
import android.text.TextUtils;
import android.util.Pair;
import b1.A;
import com.google.android.gms.internal.ads.FS;
import com.google.android.gms.internal.ads.Fu;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.QS;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.ez0;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import l1.Z;
import l1.a0;
import l1.b0;
import l1.h0;
import org.json.JSONException;
import org.json.JSONObject;

public final class c0 {
    private final int a;
    private final long b;
    private final boolean c;
    private final boolean d;
    private final Map e;
    private final ArrayDeque f = new ArrayDeque();
    private final ArrayDeque g = new ArrayDeque();
    private final QS h;
    private Map i;

    public c0(QS qS) {
        this.h = qS;
        qS = Yi.R7;
        this.a = (Integer)A.c().d((Oi)qS);
        qS = Yi.S7;
        this.b = (Long)A.c().d((Oi)qS);
        qS = Yi.W7;
        this.c = (Boolean)A.c().d((Oi)qS);
        qS = Yi.V7;
        this.d = (Boolean)A.c().d((Oi)qS);
        this.e = Collections.synchronizedMap((Map)new Z(this));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void i() {
        c0 c02 = this;
        synchronized (c02) {
            Throwable throwable2;
            ConcurrentModificationException concurrentModificationException2;
            block9: {
                try {
                    long l2 = t.o().b();
                    Set set = this.e.entrySet();
                    try {
                        set = set.iterator();
                        while (set.hasNext()) {
                            Map.Entry entry = (Map.Entry)set.next();
                            if (l2 - ((a0)entry.getValue()).a > this.b) {
                                ArrayDeque arrayDeque = this.g;
                                Pair pair = new Pair((Object)((String)entry.getKey()), (Object)((a0)entry.getValue()).b);
                                arrayDeque.add((Object)pair);
                                set.remove();
                                continue;
                            }
                            break;
                        }
                    }
                    catch (ConcurrentModificationException concurrentModificationException2) {
                        break block9;
                    }
                }
                catch (Throwable throwable2) {}
                return;
            }
            t.l().j((Throwable)concurrentModificationException2, "QueryJsonMap.removeExpiredEntries");
            return;
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void j(FS fS) {
        c0 c02 = this;
        synchronized (c02) {
            boolean bl = this.c;
            if (!bl) {
                return;
            }
            ArrayDeque arrayDeque = this.g;
            ArrayDeque arrayDeque2 = arrayDeque.clone();
            arrayDeque.clear();
            Object object = this.f;
            arrayDeque = object.clone();
            object.clear();
            ez0 ez02 = Fu.a;
            object = new b0(this, fS, arrayDeque2, arrayDeque);
            ez02.execute((Runnable)object);
            return;
        }
    }

    private final void k(FS fS, ArrayDeque arrayDeque, String string) {
        while (!arrayDeque.isEmpty()) {
            Object object = (Pair)arrayDeque.poll();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(fS.c());
            this.i = concurrentHashMap;
            concurrentHashMap.put((Object)"action", (Object)"ev");
            this.i.put((Object)"e_r", (Object)string);
            this.i.put((Object)"e_id", (Object)((String)object.first));
            if (this.d) {
                object = (String)object.second;
                try {
                    concurrentHashMap = new JSONObject((String)object);
                    object = concurrentHashMap.getString("request_agent");
                    String string2 = concurrentHashMap.getJSONObject("extras").getString("query_info_type");
                    concurrentHashMap = new Pair((Object)h0.b(string2), object);
                }
                catch (JSONException jSONException) {
                    concurrentHashMap = new Pair((Object)"", (Object)"");
                }
                c0.l(this.i, "e_type", (String)concurrentHashMap.first);
                c0.l(this.i, "e_agent", (String)concurrentHashMap.second);
            }
            this.h.b(this.i);
        }
    }

    private static final void l(Map map, String string, String string2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            map.put((Object)string, (Object)string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(String string, String string2, FS fS) {
        c0 c02 = this;
        synchronized (c02) {
            long l2 = t.o().b();
            HashSet hashSet = new HashSet();
            a0 a02 = new a0(l2, string2, (Set)hashSet);
            this.e.put((Object)string, (Object)a02);
            this.i();
            this.j(fS);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String b(String string, FS fS) {
        c0 c02 = this;
        synchronized (c02) {
            Throwable throwable2;
            block4: {
                try {
                    a0 a02 = (a0)this.e.get((Object)string);
                    fS.c().put((Object)"request_id", (Object)string);
                    if (a02 != null) {
                        fS.c().put((Object)"mhit", (Object)"true");
                        return a02.b;
                    }
                }
                catch (Throwable throwable2) {
                    break block4;
                }
                fS.c().put((Object)"mhit", (Object)"false");
                return null;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void c(String string) {
        c0 c02 = this;
        synchronized (c02) {
            this.e.remove((Object)string);
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean d(String object, String string) {
        c0 c02 = this;
        synchronized (c02) {
            Throwable throwable2;
            block5: {
                block4: {
                    try {
                        boolean bl;
                        object = (a0)this.e.get(object);
                        if (object == null || !(bl = ((a0)object).c.contains((Object)string))) break block4;
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                    return true;
                }
                return false;
            }
            throw throwable2;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean e(String object, String string, int n2) {
        c0 c02 = this;
        synchronized (c02) {
            Throwable throwable2;
            block5: {
                try {
                    object = (a0)this.e.get(object);
                    if (object != null) {
                        object = ((a0)object).c;
                        object.add((Object)string);
                        int n3 = object.size();
                        return n3 < n2;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                return false;
            }
            throw throwable2;
        }
    }

    final /* synthetic */ void f(FS fS, ArrayDeque arrayDeque, ArrayDeque arrayDeque2) {
        this.k(fS, arrayDeque, "to");
        this.k(fS, arrayDeque2, "of");
    }

    final /* synthetic */ int g() {
        return this.a;
    }

    final /* synthetic */ ArrayDeque h() {
        return this.f;
    }
}

