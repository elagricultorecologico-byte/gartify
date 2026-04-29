/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  f1.p
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.List
 */
package b1;

import android.os.Bundle;
import android.text.TextUtils;
import f1.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class h1 {
    private final HashSet a = new HashSet();
    private final Bundle b = new Bundle();
    private final HashMap c = new HashMap();
    private final HashSet d = new HashSet();
    private final Bundle e = new Bundle();
    private final HashSet f = new HashSet();
    private String g;
    private final List h = new ArrayList();
    private String i;
    private String j;
    private int k = -1;
    private boolean l;
    private String m;
    private int n = 60000;
    private long o;

    final /* synthetic */ String A() {
        return this.i;
    }

    final /* synthetic */ String a() {
        return this.j;
    }

    final /* synthetic */ int b() {
        return this.k;
    }

    final /* synthetic */ boolean c() {
        return this.l;
    }

    final /* synthetic */ String d() {
        return this.m;
    }

    final /* synthetic */ int e() {
        return this.n;
    }

    final /* synthetic */ long f() {
        return this.o;
    }

    public final void g(String string) {
        this.a.add((Object)string);
    }

    public final void h(Class clazz, Bundle bundle) {
        this.b.putBundle(clazz.getName(), bundle);
    }

    public final void i(String string) {
        this.d.add((Object)string);
    }

    public final void j(String string) {
        this.d.remove((Object)"B3EEABB8EE11C2BE770B684D95219ECB");
    }

    public final void k(String string) {
        this.g = string;
    }

    public final void l(List list) {
        List list2 = this.h;
        list2.clear();
        for (String string : list) {
            if (TextUtils.isEmpty((CharSequence)string)) {
                p.f((String)"neighboring content URL should not be null or empty");
                continue;
            }
            list2.add((Object)string);
        }
    }

    public final void m(String string) {
        this.i = string;
    }

    public final void n(String string) {
        this.j = string;
    }

    public final void o(boolean bl) {
        this.k = bl ? 1 : 0;
    }

    public final void p(String string, String string2) {
        this.e.putString(string, string2);
    }

    public final void q(String string) {
        this.f.add((Object)string);
    }

    public final void r(boolean bl) {
        this.l = bl;
    }

    final /* synthetic */ HashSet s() {
        return this.a;
    }

    final /* synthetic */ Bundle t() {
        return this.b;
    }

    final /* synthetic */ HashMap u() {
        return this.c;
    }

    final /* synthetic */ HashSet v() {
        return this.d;
    }

    final /* synthetic */ Bundle w() {
        return this.e;
    }

    final /* synthetic */ HashSet x() {
        return this.f;
    }

    final /* synthetic */ String y() {
        return this.g;
    }

    final /* synthetic */ List z() {
        return this.h;
    }
}

