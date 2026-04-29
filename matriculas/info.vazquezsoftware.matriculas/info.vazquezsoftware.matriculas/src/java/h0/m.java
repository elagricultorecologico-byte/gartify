/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  L0.a
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.Executor
 */
package H0;

import java.util.concurrent.Executor;

class m
implements Executor {
    private final Executor g;

    m(Executor executor) {
        this.g = executor;
    }

    public void execute(Runnable runnable) {
        this.g.execute((Runnable)new a(runnable));
    }

    static class a
    implements Runnable {
        private final Runnable g;

        a(Runnable runnable) {
            this.g = runnable;
        }

        public void run() {
            try {
                this.g.run();
                return;
            }
            catch (Exception exception) {
                L0.a.d((String)"Executor", (String)"Background execution failure.", (Throwable)exception);
                return;
            }
        }
    }
}

