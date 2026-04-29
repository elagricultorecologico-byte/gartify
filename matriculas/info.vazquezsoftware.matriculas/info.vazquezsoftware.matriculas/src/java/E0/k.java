/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.adservices.measurement.MeasurementManager
 *  android.os.OutcomeReceiver
 *  java.lang.Object
 *  java.util.concurrent.Executor
 */
package e0;

import android.adservices.measurement.MeasurementManager;
import android.os.OutcomeReceiver;
import java.util.concurrent.Executor;

public abstract class k {
    public static /* bridge */ /* synthetic */ void a(MeasurementManager measurementManager, Executor executor, OutcomeReceiver outcomeReceiver) {
        measurementManager.getMeasurementApiStatus(executor, outcomeReceiver);
    }
}

