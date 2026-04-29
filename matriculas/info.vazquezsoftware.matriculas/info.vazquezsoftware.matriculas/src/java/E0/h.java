/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.adservices.measurement.DeletionRequest
 *  android.adservices.measurement.MeasurementManager
 *  android.os.OutcomeReceiver
 *  java.lang.Object
 *  java.util.concurrent.Executor
 */
package e0;

import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;
import android.os.OutcomeReceiver;
import java.util.concurrent.Executor;

public abstract class h {
    public static /* bridge */ /* synthetic */ void a(MeasurementManager measurementManager, DeletionRequest deletionRequest, Executor executor, OutcomeReceiver outcomeReceiver) {
        measurementManager.deleteRegistrations(deletionRequest, executor, outcomeReceiver);
    }
}

