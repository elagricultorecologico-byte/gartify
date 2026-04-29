/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.adservices.measurement.MeasurementManager
 *  android.net.Uri
 *  android.os.OutcomeReceiver
 *  android.view.InputEvent
 *  java.lang.Object
 *  java.util.concurrent.Executor
 */
package e0;

import android.adservices.measurement.MeasurementManager;
import android.net.Uri;
import android.os.OutcomeReceiver;
import android.view.InputEvent;
import java.util.concurrent.Executor;

public abstract class f {
    public static /* bridge */ /* synthetic */ void a(MeasurementManager measurementManager, Uri uri, InputEvent inputEvent, Executor executor, OutcomeReceiver outcomeReceiver) {
        measurementManager.registerSource(uri, inputEvent, executor, outcomeReceiver);
    }
}

