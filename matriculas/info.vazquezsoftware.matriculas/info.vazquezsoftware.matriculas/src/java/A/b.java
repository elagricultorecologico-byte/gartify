/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package a;

public abstract class b {
    private static final String a = "_COROUTINE";

    public static final /* synthetic */ StackTraceElement a(Throwable throwable, String string) {
        return b.b(throwable, string);
    }

    private static final StackTraceElement b(Throwable throwable, String string) {
        StackTraceElement stackTraceElement = throwable.getStackTrace()[0];
        throwable = new StringBuilder();
        throwable.append(a);
        throwable.append('.');
        throwable.append(string);
        return new StackTraceElement(throwable.toString(), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }
}

