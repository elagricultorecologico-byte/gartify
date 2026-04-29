/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.text.TextUtils
 *  com.google.android.gms.auth.api.signin.GoogleSignInAccount
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.locks.Lock
 *  java.util.concurrent.locks.ReentrantLock
 *  org.json.JSONException
 *  x1.n
 */
package s1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import x1.n;

public class a {
    private static final Lock c = new ReentrantLock();
    private static a d;
    private final Lock a = new ReentrantLock();
    private final SharedPreferences b;

    a(Context context) {
        this.b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context object) {
        n.i((Object)object);
        Lock lock = c;
        lock.lock();
        try {
            if (d == null) {
                a a2;
                d = a2 = new a(object.getApplicationContext());
            }
            object = d;
        }
        catch (Throwable throwable) {
            c.unlock();
            throw throwable;
        }
        lock.unlock();
        return object;
    }

    private static final String d(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(":");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public GoogleSignInAccount b() {
        String string = this.c("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        if ((string = this.c(s1.a.d("googleSignInAccount", string))) == null) return null;
        try {
            return GoogleSignInAccount.m((String)string);
        }
        catch (JSONException jSONException) {
            return null;
        }
    }

    protected final String c(String string) {
        this.a.lock();
        try {
            string = this.b.getString(string, null);
            return string;
        }
        finally {
            this.a.unlock();
        }
    }
}

