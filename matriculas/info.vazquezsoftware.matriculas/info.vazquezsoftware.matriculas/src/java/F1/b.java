/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.atomic.AtomicInteger
 */
package f1;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class b
implements ThreadFactory {
    private final AtomicInteger a;
    final String b;

    b(String string) {
        this.b = string;
        this.a = new AtomicInteger(1);
    }

    public final Thread newThread(Runnable runnable) {
        int n2 = this.a.getAndIncrement();
        int n3 = String.valueOf((int)n2).length();
        String string = this.b;
        StringBuilder stringBuilder = new StringBuilder(string.length() + 12 + n3);
        stringBuilder.append("AdWorker(");
        stringBuilder.append(string);
        stringBuilder.append(") #");
        stringBuilder.append(n2);
        return new Thread(runnable, stringBuilder.toString());
    }
}

