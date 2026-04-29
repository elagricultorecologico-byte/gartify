/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 *  x1.n
 */
package u1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import x1.n;

public class a
implements ServiceConnection {
    boolean a = false;
    private final BlockingQueue b = new LinkedBlockingQueue();

    public IBinder a(long l2, TimeUnit timeUnit) {
        n.h((String)"BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.a) {
            this.a = true;
            if ((timeUnit = (IBinder)this.b.poll(l2, timeUnit)) != null) {
                return timeUnit;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.b.add((Object)iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}

