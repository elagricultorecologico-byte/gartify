/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 */
package d;

import V2.g;
import V2.k;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

public final class f
implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR;
    public static final c k;
    private final IntentSender g;
    private final Intent h;
    private final int i;
    private final int j;

    static {
        k = new c(null);
        CREATOR = new Parcelable.Creator(){

            public f a(Parcel parcel) {
                V2.k.e(parcel, "inParcel");
                return new f(parcel);
            }

            public f[] b(int n2) {
                return new f[n2];
            }
        };
    }

    public f(IntentSender intentSender, Intent intent, int n2, int n3) {
        V2.k.e(intentSender, "intentSender");
        this.g = intentSender;
        this.h = intent;
        this.i = n2;
        this.j = n3;
    }

    public f(Parcel parcel) {
        V2.k.e(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        V2.k.b(parcelable);
        this((IntentSender)parcelable, (Intent)parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }

    public final Intent a() {
        return this.h;
    }

    public final int b() {
        return this.i;
    }

    public final int c() {
        return this.j;
    }

    public int describeContents() {
        return 0;
    }

    public final IntentSender f() {
        return this.g;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        V2.k.e(parcel, "dest");
        parcel.writeParcelable((Parcelable)this.g, n2);
        parcel.writeParcelable((Parcelable)this.h, n2);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
    }

    public static final class a {
        private final IntentSender a;
        private Intent b;
        private int c;
        private int d;

        public a(PendingIntent pendingIntent) {
            V2.k.e(pendingIntent, "pendingIntent");
            pendingIntent = pendingIntent.getIntentSender();
            V2.k.d(pendingIntent, "pendingIntent.intentSender");
            this((IntentSender)pendingIntent);
        }

        public a(IntentSender intentSender) {
            V2.k.e(intentSender, "intentSender");
            this.a = intentSender;
        }

        public final f a() {
            return new f(this.a, this.b, this.c, this.d);
        }

        public final a b(Intent intent) {
            this.b = intent;
            return this;
        }

        public final a c(int n2, int n3) {
            this.d = n2;
            this.c = n3;
            return this;
        }
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(g g2) {
            this();
        }
    }
}

