/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.adservices.measurement.MeasurementManager
 *  android.net.Uri
 *  android.os.OutcomeReceiver
 *  java.lang.Object
 *  java.util.concurrent.Executor
 */
package e0;

import android.adservices.measurement.MeasurementManager;
import android.net.Uri;
import android.os.OutcomeReceiver;
import java.util.concurrent.Executor;

public abstract class l {
    public static /* bridge */ /* synthetic */ void a(MeasurementManager measurementManager, Uri uri, Executor executor, OutcomeReceiver outcomeReceiver) {
        measurementManager.registerTrigger(uri, executor, outcomeReceiver);
    }
}

