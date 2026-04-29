/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 */
package O;

import O.h;

public final class l {
    double a = Math.sqrt((double)1500.0);
    double b = 0.5;
    private boolean c = false;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    private double i = Double.MAX_VALUE;
    private final h.o j = new h.o();

    public l() {
    }

    public l(float f2) {
        this.i = f2;
    }

    private void d() {
        if (this.c) {
            return;
        }
        if (this.i != Double.MAX_VALUE) {
            double d2 = this.b;
            if (d2 > 1.0) {
                double d3 = -d2;
                double d4 = this.a;
                this.f = d3 * d4 + d4 * Math.sqrt((double)(d2 * d2 - 1.0));
                d3 = this.b;
                d2 = -d3;
                d4 = this.a;
                this.g = d2 * d4 - d4 * Math.sqrt((double)(d3 * d3 - 1.0));
            } else if (d2 >= 0.0 && d2 < 1.0) {
                this.h = this.a * Math.sqrt((double)(1.0 - d2 * d2));
            }
            this.c = true;
            return;
        }
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    public float a() {
        return (float)this.b;
    }

    public float b() {
        return (float)this.i;
    }

    public float c() {
        double d2 = this.a;
        return (float)(d2 * d2);
    }

    public boolean e(float f2, float f3) {
        return (double)Math.abs((float)f3) < this.e && (double)Math.abs((float)(f2 - this.b())) < this.d;
    }

    public l f(float f2) {
        if (!(f2 < 0.0f)) {
            this.b = f2;
            this.c = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public l g(float f2) {
        this.i = f2;
        return this;
    }

    public l h(float f2) {
        if (!(f2 <= 0.0f)) {
            this.a = Math.sqrt((double)f2);
            this.c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    void i(double d2) {
        this.d = d2 = Math.abs((double)d2);
        this.e = d2 * 62.5;
    }

    h.o j(double d2, double d3, long l2) {
        this.d();
        double d4 = (double)l2 / 1000.0;
        double d5 = d2 - this.i;
        double d6 = this.b;
        if (d6 > 1.0) {
            d2 = this.g;
            double d7 = this.f;
            d6 = d5 - (d2 * d5 - d3) / (d2 - d7);
            d3 = (d5 * d2 - d3) / (d2 - d7);
            d2 = Math.pow((double)Math.E, (double)(d2 * d4)) * d6 + Math.pow((double)Math.E, (double)(this.f * d4)) * d3;
            d7 = this.g;
            double d8 = Math.pow((double)Math.E, (double)(d7 * d4));
            d5 = this.f;
            d3 = d6 * d7 * d8 + d3 * d5 * Math.pow((double)Math.E, (double)(d5 * d4));
        } else if (d6 == 1.0) {
            d2 = this.a;
            d3 += d2 * d5;
            d2 = Math.pow((double)Math.E, (double)(-d2 * d4)) * (d5 += d3 * d4);
            double d9 = Math.pow((double)Math.E, (double)(-this.a * d4));
            double d10 = this.a;
            d6 = -d10;
            d3 = d3 * Math.pow((double)Math.E, (double)(-d10 * d4)) + d5 * d9 * d6;
        } else {
            double d11 = 1.0 / this.h;
            d2 = this.a;
            d3 = d11 * (d6 * d2 * d5 + d3);
            d2 = Math.pow((double)Math.E, (double)(-d6 * d2 * d4)) * (Math.cos((double)(this.h * d4)) * d5 + Math.sin((double)(this.h * d4)) * d3);
            double d12 = this.a;
            d6 = -d12;
            d11 = this.b;
            double d13 = Math.pow((double)Math.E, (double)(-d11 * d12 * d4));
            double d14 = this.h;
            d12 = -d14;
            d14 = Math.sin((double)(d14 * d4));
            double d15 = this.h;
            d3 = d6 * d2 * d11 + d13 * (d12 * d5 * d14 + d3 * d15 * Math.cos((double)(d15 * d4)));
        }
        h.o o2 = this.j;
        o2.a = (float)(d2 + this.i);
        o2.b = (float)d3;
        return o2;
    }
}

