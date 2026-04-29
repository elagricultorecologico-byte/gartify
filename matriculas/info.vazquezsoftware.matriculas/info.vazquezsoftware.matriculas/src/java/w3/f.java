/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.logging.Handler
 *  java.util.logging.LogRecord
 */
package w3;

import V2.k;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import w3.e;
import w3.g;

public final class f
extends Handler {
    public static final f a = new f();

    private f() {
    }

    public void close() {
    }

    public void flush() {
    }

    public void publish(LogRecord logRecord) {
        k.e(logRecord, "record");
        e e2 = e.a;
        String string = logRecord.getLoggerName();
        k.d(string, "record.loggerName");
        int n2 = g.a(logRecord);
        String string2 = logRecord.getMessage();
        k.d(string2, "record.message");
        e2.a(string, n2, string2, logRecord.getThrown());
    }
}

