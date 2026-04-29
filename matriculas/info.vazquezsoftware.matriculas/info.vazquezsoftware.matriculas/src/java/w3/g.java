/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.logging.Level
 *  java.util.logging.LogRecord
 */
package w3;

import java.util.logging.Level;
import java.util.logging.LogRecord;

public abstract class g {
    public static final /* synthetic */ int a(LogRecord logRecord) {
        return g.b(logRecord);
    }

    private static final int b(LogRecord logRecord) {
        Level level;
        int n2 = logRecord.getLevel().intValue();
        if (n2 > (level = Level.INFO).intValue()) {
            return 5;
        }
        if (logRecord.getLevel().intValue() == level.intValue()) {
            return 4;
        }
        return 3;
    }
}

