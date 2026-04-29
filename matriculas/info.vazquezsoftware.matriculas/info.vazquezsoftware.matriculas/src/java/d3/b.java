/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.MalformedURLException
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 */
package D3;

import C3.a;
import D3.d;
import E3.c;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

abstract class b {
    private static final Map a = Collections.unmodifiableMap((Map)new HashMap());

    static void a(d.c c2, HttpURLConnection httpURLConnection) {
        LinkedHashSet linkedHashSet = b.c(c2);
        Iterator iterator = c2.A().get(b.b(c2.a), a).entrySet().iterator();
        c2 = null;
        while (iterator.hasNext()) {
            Object object = (Map.Entry)iterator.next();
            List list = (List)object.getValue();
            if (list == null || list.size() == 0) continue;
            if ("Cookie".equals(object = (String)object.getKey())) {
                object = linkedHashSet;
            } else {
                if (!"Cookie2".equals(object)) continue;
                object = new HashSet();
                c2 = object;
            }
            object.addAll((Collection)list);
        }
        if (linkedHashSet.size() > 0) {
            httpURLConnection.addRequestProperty("Cookie", c.k((Collection)linkedHashSet, "; "));
        }
        if (c2 != null && c2.size() > 0) {
            httpURLConnection.addRequestProperty("Cookie2", c.k((Collection)c2, "; "));
        }
    }

    static URI b(URL uRL) {
        try {
            uRL = uRL.toURI();
            return uRL;
        }
        catch (URISyntaxException uRISyntaxException) {
            MalformedURLException malformedURLException = new MalformedURLException(uRISyntaxException.getMessage());
            malformedURLException.initCause((Throwable)uRISyntaxException);
            throw malformedURLException;
        }
    }

    private static LinkedHashSet c(a.c c2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry entry : c2.a().entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append((String)entry.getValue());
            linkedHashSet.add((Object)stringBuilder.toString());
        }
        return linkedHashSet;
    }

    static void d(d.c c2, URL uRL, Map map) {
        c2.A().put(b.b(uRL), map);
    }
}

