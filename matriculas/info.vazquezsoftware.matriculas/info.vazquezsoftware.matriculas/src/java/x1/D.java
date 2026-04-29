/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.view.View
 *  androidx.appcompat.app.E
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Map
 *  java.util.Set
 */
package x1;

import android.accounts.Account;
import android.view.View;
import androidx.appcompat.app.E;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p.b;

public final class d {
    private final Account a;
    private final Set b;
    private final Set c;
    private final Map d;
    private final int e;
    private final View f;
    private final String g;
    private final String h;
    private final J1.a i;
    private Integer j;

    public d(Account account, Set set, Map object, int n2, View view, String string, String string2, J1.a a2, boolean bl) {
        this.a = account;
        set = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet((Set)set);
        this.b = set;
        account = object;
        if (object == null) {
            account = Collections.EMPTY_MAP;
        }
        this.d = account;
        this.f = view;
        this.e = n2;
        this.g = string;
        this.h = string2;
        object = a2;
        if (a2 == null) {
            object = J1.a.k;
        }
        this.i = object;
        set = new HashSet((Collection)set);
        if (!(account = account.values().iterator()).hasNext()) {
            this.c = Collections.unmodifiableSet((Set)set);
            return;
        }
        E.a((Object)account.next());
        throw null;
    }

    public Account a() {
        return this.a;
    }

    public Account b() {
        Account account = this.a;
        if (account != null) {
            return account;
        }
        return new Account("<<default account>>", "com.google");
    }

    public Set c() {
        return this.c;
    }

    public String d() {
        return this.g;
    }

    public Set e() {
        return this.b;
    }

    public final J1.a f() {
        return this.i;
    }

    public final Integer g() {
        return this.j;
    }

    public final String h() {
        return this.h;
    }

    public final void i(Integer n2) {
        this.j = n2;
    }

    public static final class a {
        private Account a;
        private b b;
        private String c;
        private String d;
        private final J1.a e = J1.a.k;

        public d a() {
            return new d(this.a, this.b, null, 0, null, this.c, this.d, this.e, false);
        }

        public a b(String string) {
            this.c = string;
            return this;
        }

        public final a c(Collection collection) {
            if (this.b == null) {
                this.b = new b();
            }
            this.b.addAll(collection);
            return this;
        }

        public final a d(Account account) {
            this.a = account;
            return this;
        }

        public final a e(String string) {
            this.d = string;
            return this;
        }
    }
}

