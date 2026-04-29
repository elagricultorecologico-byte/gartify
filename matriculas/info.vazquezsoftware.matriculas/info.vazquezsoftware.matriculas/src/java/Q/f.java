/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.InputFilter
 *  android.text.method.PasswordTransformationMethod
 *  android.text.method.TransformationMethod
 *  android.util.SparseArray
 *  android.widget.TextView
 *  androidx.emoji2.text.f
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.System
 */
package Q;

import Q.d;
import Q.h;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

public final class f {
    private final b a;

    public f(TextView textView, boolean bl) {
        D.h.h(textView, "textView cannot be null");
        if (!bl) {
            this.a = new c(textView);
            return;
        }
        this.a = new a(textView);
    }

    public InputFilter[] a(InputFilter[] inputFilterArray) {
        return this.a.a(inputFilterArray);
    }

    public boolean b() {
        return this.a.b();
    }

    public void c(boolean bl) {
        this.a.c(bl);
    }

    public void d(boolean bl) {
        this.a.d(bl);
    }

    public TransformationMethod e(TransformationMethod transformationMethod) {
        return this.a.e(transformationMethod);
    }

    private static class a
    extends b {
        private final TextView a;
        private final d b;
        private boolean c;

        a(TextView textView) {
            this.a = textView;
            this.c = true;
            this.b = new d(textView);
        }

        private InputFilter[] f(InputFilter[] inputFilterArray) {
            int n2 = inputFilterArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (inputFilterArray[i2] != this.b) continue;
                return inputFilterArray;
            }
            InputFilter[] inputFilterArray2 = new InputFilter[inputFilterArray.length + 1];
            System.arraycopy((Object)inputFilterArray, (int)0, (Object)inputFilterArray2, (int)0, (int)n2);
            inputFilterArray2[n2] = this.b;
            return inputFilterArray2;
        }

        private SparseArray g(InputFilter[] inputFilterArray) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i2 = 0; i2 < inputFilterArray.length; ++i2) {
                InputFilter inputFilter = inputFilterArray[i2];
                if (!(inputFilter instanceof d)) continue;
                sparseArray.put(i2, (Object)inputFilter);
            }
            return sparseArray;
        }

        private InputFilter[] h(InputFilter[] inputFilterArray) {
            SparseArray sparseArray = this.g(inputFilterArray);
            if (sparseArray.size() == 0) {
                return inputFilterArray;
            }
            int n2 = inputFilterArray.length;
            InputFilter[] inputFilterArray2 = new InputFilter[inputFilterArray.length - sparseArray.size()];
            int n3 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                int n4 = n3;
                if (sparseArray.indexOfKey(i2) < 0) {
                    inputFilterArray2[n3] = inputFilterArray[i2];
                    n4 = n3 + 1;
                }
                n3 = n4;
            }
            return inputFilterArray2;
        }

        private TransformationMethod j(TransformationMethod transformationMethod) {
            TransformationMethod transformationMethod2 = transformationMethod;
            if (transformationMethod instanceof h) {
                transformationMethod2 = ((h)transformationMethod).a();
            }
            return transformationMethod2;
        }

        private void k() {
            InputFilter[] inputFilterArray = this.a.getFilters();
            this.a.setFilters(this.a(inputFilterArray));
        }

        private TransformationMethod m(TransformationMethod transformationMethod) {
            if (transformationMethod instanceof h) {
                return transformationMethod;
            }
            if (transformationMethod instanceof PasswordTransformationMethod) {
                return transformationMethod;
            }
            return new h(transformationMethod);
        }

        @Override
        InputFilter[] a(InputFilter[] inputFilterArray) {
            if (!this.c) {
                return this.h(inputFilterArray);
            }
            return this.f(inputFilterArray);
        }

        @Override
        public boolean b() {
            return this.c;
        }

        @Override
        void c(boolean bl) {
            if (bl) {
                this.l();
            }
        }

        @Override
        void d(boolean bl) {
            this.c = bl;
            this.l();
            this.k();
        }

        @Override
        TransformationMethod e(TransformationMethod transformationMethod) {
            if (this.c) {
                return this.m(transformationMethod);
            }
            return this.j(transformationMethod);
        }

        void i(boolean bl) {
            this.c = bl;
        }

        void l() {
            TransformationMethod transformationMethod = this.e(this.a.getTransformationMethod());
            this.a.setTransformationMethod(transformationMethod);
        }
    }

    static abstract class b {
        b() {
        }

        abstract InputFilter[] a(InputFilter[] var1);

        public abstract boolean b();

        abstract void c(boolean var1);

        abstract void d(boolean var1);

        abstract TransformationMethod e(TransformationMethod var1);
    }

    private static class c
    extends b {
        private final a a;

        c(TextView textView) {
            this.a = new a(textView);
        }

        private boolean f() {
            return androidx.emoji2.text.f.i() ^ true;
        }

        @Override
        InputFilter[] a(InputFilter[] inputFilterArray) {
            if (this.f()) {
                return inputFilterArray;
            }
            return this.a.a(inputFilterArray);
        }

        @Override
        public boolean b() {
            return this.a.b();
        }

        @Override
        void c(boolean bl) {
            if (this.f()) {
                return;
            }
            this.a.c(bl);
        }

        @Override
        void d(boolean bl) {
            if (this.f()) {
                this.a.i(bl);
                return;
            }
            this.a.d(bl);
        }

        @Override
        TransformationMethod e(TransformationMethod transformationMethod) {
            if (this.f()) {
                return transformationMethod;
            }
            return this.a.e(transformationMethod);
        }
    }
}

