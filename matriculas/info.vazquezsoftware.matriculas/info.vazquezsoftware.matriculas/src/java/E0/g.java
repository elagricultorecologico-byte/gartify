/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.adservices.measurement.MeasurementManager
 *  android.adservices.measurement.WebSourceRegistrationRequest
 *  android.os.OutcomeReceiver
 *  java.lang.Object
 *  java.util.concurrent.Executor
 */
package e0;

import android.adservices.measurement.MeasurementManager;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.os.OutcomeReceiver;
import java.util.concurrent.Executor;

public abstract class g {
    public static /* bridge */ /* synthetic */ void a(MeasurementManager measurementManager, WebSourceRegistrationRequest webSourceRegistrationRequest, Executor executor, OutcomeReceiver outcomeReceiver) {
        measurementManager.registerWebSource(webSourceRegistrationRequest, executor, outcomeReceiver);
    }
}

