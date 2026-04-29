/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package N1;

import N1.a;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

public class d {
    private long a;
    private long b;
    private TimeInterpolator c;
    private int d;
    private int e;

    public d(long l2, long l3) {
        this.c = null;
        this.d = 0;
        this.e = 1;
        this.a = l2;
        this.b = l3;
    }

    public d(long l2, long l3, TimeInterpolator timeInterpolator) {
        this.d = 0;
        this.e = 1;
        this.a = l2;
        this.b = l3;
        this.c = timeInterpolator;
    }

    static d a(ValueAnimator valueAnimator) {
        d d2 = new d(valueAnimator.getStartDelay(), valueAnimator.getDuration(), valueAnimator.getInterpolator());
        d2.d = valueAnimator.getRepeatCount();
        d2.e = valueAnimator.getRepeatMode();
        return d2;
    }

    public long b() {
        return this.a;
    }

    public long c() {
        return this.b;
    }

    public TimeInterpolator d() {
        TimeInterpolator timeInterpolator = this.c;
        if (timeInterpolator != null) {
            return timeInterpolator;
        }
        return N1.a.b;
    }

    public int e() {
        return this.d;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof d)) {
            return false;
        }
        object = (d)object;
        if (this.b() != ((d)object).b()) {
            return false;
        }
        if (this.c() != ((d)object).c()) {
            return false;
        }
        if (this.e() != ((d)object).e()) {
            return false;
        }
        if (this.f() != ((d)object).f()) {
            return false;
        }
        return this.d().getClass().equals((Object)((d)object).d().getClass());
    }

    public int f() {
        return this.e;
    }

    public int hashCode() {
        return ((((int)(this.b() ^ this.b() >>> 32) * 31 + (int)(this.c() ^ this.c() >>> 32)) * 31 + this.d().getClass().hashCode()) * 31 + this.e()) * 31 + this.f();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString((int)System.identityHashCode((Object)this)));
        stringBuilder.append(" delay: ");
        stringBuilder.append(this.b());
        stringBuilder.append(" duration: ");
        stringBuilder.append(this.c());
        stringBuilder.append(" interpolator: ");
        stringBuilder.append((Object)this.d().getClass());
        stringBuilder.append(" repeatCount: ");
        stringBuilder.append(this.e());
        stringBuilder.append(" repeatMode: ");
        stringBuilder.append(this.f());
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}

