/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.CancellationException
 */
package c3;

import V2.k;
import c3.p0;
import java.util.concurrent.CancellationException;

public final class q0
extends CancellationException {
    public final transient p0 g;

    public q0(String string, Throwable throwable, p0 p02) {
        super(string);
        this.g = p02;
        if (throwable != null) {
            this.initCause(throwable);
        }
    }

    public boolean equals(Object object) {
        return object == this || object instanceof q0 && k.a((object = (q0)((Object)object)).getMessage(), this.getMessage()) && k.a(((q0)((Object)object)).g, this.g) && k.a(object.getCause(), this.getCause());
        {
        }
    }

    public Throwable fillInStackTrace() {
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String string = this.getMessage();
        k.b(string);
        int n2 = string.hashCode();
        int n3 = this.g.hashCode();
        string = this.getCause();
        int n4 = string != null ? string.hashCode() : 0;
        return (n2 * 31 + n3) * 31 + n4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("; job=");
        stringBuilder.append((Object)this.g);
        return stringBuilder.toString();
    }
}

