/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.ConnectivityManager
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.Network
 *  android.net.NetworkCapabilities
 *  android.net.NetworkInfo
 *  android.os.Build$VERSION
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.Throwable
 */
package z0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import t0.j;
import z0.d;
import z0.e;

public class f
extends d {
    static final String j = t0.j.f("NetworkStateTracker");
    private final ConnectivityManager g;
    private b h;
    private a i;

    public f(Context context, D0.a a2) {
        super(context, a2);
        this.g = (ConnectivityManager)this.b.getSystemService("connectivity");
        if (f.j()) {
            this.h = new b(this);
            return;
        }
        this.i = new a(this);
    }

    private static boolean j() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void e() {
        if (f.j()) {
            void var1_3;
            try {
                t0.j.c().a(j, "Registering network callback", new Throwable[0]);
                z0.e.a(this.g, this.h);
                return;
            }
            catch (SecurityException securityException) {
            }
            catch (IllegalArgumentException illegalArgumentException) {
                // empty catch block
            }
            t0.j.c().b(j, "Received exception while registering network callback", new Throwable[]{var1_3});
            return;
        }
        t0.j.c().a(j, "Registering broadcast receiver", new Throwable[0]);
        this.b.registerReceiver((BroadcastReceiver)this.i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void f() {
        if (f.j()) {
            void var1_3;
            try {
                t0.j.c().a(j, "Unregistering network callback", new Throwable[0]);
                this.g.unregisterNetworkCallback((ConnectivityManager.NetworkCallback)this.h);
                return;
            }
            catch (SecurityException securityException) {
            }
            catch (IllegalArgumentException illegalArgumentException) {
                // empty catch block
            }
            t0.j.c().b(j, "Received exception while unregistering network callback", new Throwable[]{var1_3});
            return;
        }
        t0.j.c().a(j, "Unregistering broadcast receiver", new Throwable[0]);
        this.b.unregisterReceiver((BroadcastReceiver)this.i);
    }

    x0.b g() {
        NetworkInfo networkInfo = this.g.getActiveNetworkInfo();
        boolean bl = false;
        boolean bl2 = networkInfo != null && networkInfo.isConnected();
        boolean bl3 = this.i();
        boolean bl4 = B.a.a(this.g);
        boolean bl5 = bl;
        if (networkInfo != null) {
            bl5 = bl;
            if (!networkInfo.isRoaming()) {
                bl5 = true;
            }
        }
        return new x0.b(bl2, bl3, bl4, bl5);
    }

    public x0.b h() {
        return this.g();
    }

    boolean i() {
        SecurityException securityException2;
        block5: {
            block4: {
                Network network;
                try {
                    network = this.g.getActiveNetwork();
                    network = this.g.getNetworkCapabilities(network);
                    if (network == null) break block4;
                }
                catch (SecurityException securityException2) {
                    break block5;
                }
                boolean bl = network.hasCapability(16);
                if (bl) {
                    return true;
                }
            }
            return false;
        }
        t0.j.c().b(j, "Unable to validate active network", securityException2);
        return false;
    }

    private class a
    extends BroadcastReceiver {
        final f a;

        a(f f2) {
            this.a = f2;
        }

        public void onReceive(Context object, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals((Object)"android.net.conn.CONNECTIVITY_CHANGE")) {
                t0.j.c().a(j, "Network broadcast received", new Throwable[0]);
                object = this.a;
                ((d)object).d(((f)object).g());
            }
        }
    }

    private class b
    extends ConnectivityManager.NetworkCallback {
        final f a;

        b(f f2) {
            this.a = f2;
        }

        public void onCapabilitiesChanged(Network object, NetworkCapabilities networkCapabilities) {
            t0.j.c().a(j, String.format((String)"Network capabilities changed: %s", (Object[])new Object[]{networkCapabilities}), new Throwable[0]);
            object = this.a;
            ((d)object).d(((f)object).g());
        }

        public void onLost(Network object) {
            t0.j.c().a(j, "Network connection lost", new Throwable[0]);
            object = this.a;
            ((d)object).d(((f)object).g());
        }
    }
}

