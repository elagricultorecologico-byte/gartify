/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ClipDescription
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.view.inputmethod.InputContentInfo
 *  java.lang.Object
 *  java.lang.Override
 */
package H;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

public final class f {
    private final c a;

    private f(c c2) {
        this.a = c2;
    }

    public f(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.a = new a(uri, clipDescription, uri2);
            return;
        }
        this.a = new b(uri, clipDescription, uri2);
    }

    public static f f(Object object) {
        if (object == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 25) {
            return null;
        }
        return new f(new a(object));
    }

    public Uri a() {
        return this.a.b();
    }

    public ClipDescription b() {
        return this.a.getDescription();
    }

    public Uri c() {
        return this.a.d();
    }

    public void d() {
        this.a.c();
    }

    public Object e() {
        return this.a.a();
    }

    private static final class a
    implements c {
        final InputContentInfo a;

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = new InputContentInfo(uri, clipDescription, uri2);
        }

        a(Object object) {
            this.a = (InputContentInfo)object;
        }

        @Override
        public Object a() {
            return this.a;
        }

        @Override
        public Uri b() {
            return this.a.getContentUri();
        }

        @Override
        public void c() {
            this.a.requestPermission();
        }

        @Override
        public Uri d() {
            return this.a.getLinkUri();
        }

        @Override
        public ClipDescription getDescription() {
            return this.a.getDescription();
        }
    }

    private static final class b
    implements c {
        private final Uri a;
        private final ClipDescription b;
        private final Uri c;

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = uri;
            this.b = clipDescription;
            this.c = uri2;
        }

        @Override
        public Object a() {
            return null;
        }

        @Override
        public Uri b() {
            return this.a;
        }

        @Override
        public void c() {
        }

        @Override
        public Uri d() {
            return this.c;
        }

        @Override
        public ClipDescription getDescription() {
            return this.b;
        }
    }

    private static interface c {
        public Object a();

        public Uri b();

        public void c();

        public Uri d();

        public ClipDescription getDescription();
    }
}

