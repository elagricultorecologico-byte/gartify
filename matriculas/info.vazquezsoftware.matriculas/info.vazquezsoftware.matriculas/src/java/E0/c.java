/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.adservices.measurement.MeasurementManager
 *  android.adservices.measurement.WebTriggerRegistrationRequest
 *  android.os.OutcomeReceiver
 *  java.lang.Object
 *  java.util.concurrent.Executor
 */
package e0;

import android.adservices.measurement.MeasurementManager;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.os.OutcomeReceiver;
import java.util.concurrent.Executor;

public abstract class c {
    public static /* bridge */ /* synthetic */ void a(MeasurementManager measurementManager, WebTriggerRegistrationRequest webTriggerRegistrationRequest, Executor executor, OutcomeReceiver outcomeReceiver) {
        measurementManager.registerWebTrigger(webTriggerRegistrationRequest, executor, outcomeReceiver);
    }
}

