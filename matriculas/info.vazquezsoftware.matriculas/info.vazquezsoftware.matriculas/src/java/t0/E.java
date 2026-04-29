/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package t0;

import android.app.Notification;

public final class e {
    private final int a;
    private final int b;
    private final Notification c;

    public e(int n2, Notification notification, int n3) {
        this.a = n2;
        this.c = notification;
        this.b = n3;
    }

    public int a() {
        return this.b;
    }

    public Notification b() {
        return this.c;
    }

    public int c() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && e.class == object.getClass()) {
            object = (e)object;
            if (this.a != ((e)object).a) {
                return false;
            }
            if (this.b != ((e)object).b) {
                return false;
            }
            return this.c.equals((Object)((e)object).c);
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 31 + this.b) * 31 + this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ForegroundInfo{");
        stringBuilder.append("mNotificationId=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mForegroundServiceType=");
        stringBuilder.append(this.b);
        stringBuilder.append(", mNotification=");
        stringBuilder.append((Object)this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

