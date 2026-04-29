/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.List
 */
package J;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

abstract class b {
    private static boolean a(int n2, Rect rect, Rect rect2, Rect rect3) {
        boolean bl = b.b(n2, rect, rect2);
        if (!b.b(n2, rect, rect3) && bl) {
            if (!b.j(n2, rect, rect3)) {
                return true;
            }
            if (n2 != 17 && n2 != 66) {
                return b.k(n2, rect, rect2) < b.m(n2, rect, rect3);
            }
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean b(int n2, Rect rect, Rect rect2) {
        if (n2 == 17) return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
        if (n2 == 33) return rect2.right >= rect.left && rect2.left <= rect.right;
        if (n2 == 66) return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
        if (n2 == 130) return rect2.right >= rect.left && rect2.left <= rect.right;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object c(Object object, b b2, a a2, Object object2, Rect rect, int n2) {
        Rect rect2 = new Rect(rect);
        int n3 = 0;
        if (n2 != 17) {
            if (n2 != 33) {
                if (n2 != 66) {
                    if (n2 != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    rect2.offset(0, -(rect.height() + 1));
                } else {
                    rect2.offset(-(rect.width() + 1), 0);
                }
            } else {
                rect2.offset(0, rect.height() + 1);
            }
        } else {
            rect2.offset(rect.width() + 1, 0);
        }
        int n4 = b2.b(object);
        Rect rect3 = new Rect();
        Object object3 = null;
        while (n3 < n4) {
            Object object4 = b2.a(object, n3);
            if (object4 != object2) {
                a2.a(object4, rect3);
                if (b.h(n2, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    object3 = object4;
                }
            }
            ++n3;
        }
        return object3;
    }

    public static Object d(Object object, b b2, a a2, Object object2, int n2, boolean bl, boolean bl2) {
        int n3 = b2.b(object);
        ArrayList arrayList = new ArrayList(n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            arrayList.add(b2.a(object, i2));
        }
        Collections.sort((List)arrayList, (Comparator)new c(bl, a2));
        if (n2 != 1) {
            if (n2 == 2) {
                return b.e(object2, arrayList, bl2);
            }
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
        return b.f(object2, arrayList, bl2);
    }

    private static Object e(Object object, ArrayList arrayList, boolean bl) {
        int n2 = arrayList.size();
        int n3 = object == null ? -1 : arrayList.lastIndexOf(object);
        if (++n3 < n2) {
            return arrayList.get(n3);
        }
        if (bl && n2 > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    private static Object f(Object object, ArrayList arrayList, boolean bl) {
        int n2 = arrayList.size();
        int n3 = object == null ? n2 : arrayList.indexOf(object);
        if (--n3 >= 0) {
            return arrayList.get(n3);
        }
        if (bl && n2 > 0) {
            return arrayList.get(n2 - 1);
        }
        return null;
    }

    private static int g(int n2, int n3) {
        return n2 * 13 * n2 + n3 * n3;
    }

    private static boolean h(int n2, Rect rect, Rect rect2, Rect rect3) {
        if (!b.i(rect, rect2, n2)) {
            return false;
        }
        if (!b.i(rect, rect3, n2)) {
            return true;
        }
        if (b.a(n2, rect, rect2, rect3)) {
            return true;
        }
        if (b.a(n2, rect, rect3, rect2)) {
            return false;
        }
        return b.g(b.k(n2, rect, rect2), b.o(n2, rect, rect2)) < b.g(b.k(n2, rect, rect3), b.o(n2, rect, rect3));
    }

    private static boolean i(Rect rect, Rect rect2, int n2) {
        if (n2 != 17) {
            if (n2 != 33) {
                if (n2 != 66) {
                    if (n2 == 130) {
                        int n3 = rect.top;
                        n2 = rect2.top;
                        return (n3 < n2 || rect.bottom <= n2) && rect.bottom < rect2.bottom;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                n2 = rect.left;
                int n4 = rect2.left;
                return (n2 < n4 || rect.right <= n4) && rect.right < rect2.right;
            }
            n2 = rect.bottom;
            int n5 = rect2.bottom;
            return (n2 > n5 || rect.top >= n5) && rect.top > rect2.top;
        }
        n2 = rect.right;
        int n6 = rect2.right;
        return (n2 > n6 || rect.left >= n6) && rect.left > rect2.left;
    }

    private static boolean j(int n2, Rect rect, Rect rect2) {
        if (n2 != 17) {
            if (n2 != 33) {
                if (n2 != 66) {
                    if (n2 == 130) {
                        return rect.bottom <= rect2.top;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                return rect.right <= rect2.left;
            }
            return rect.top >= rect2.bottom;
        }
        return rect.left >= rect2.right;
    }

    private static int k(int n2, Rect rect, Rect rect2) {
        return Math.max((int)0, (int)b.l(n2, rect, rect2));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int l(int n2, Rect rect, Rect rect2) {
        int n3;
        if (n2 != 17) {
            if (n2 != 33) {
                if (n2 != 66) {
                    if (n2 != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    n2 = rect2.top;
                    n3 = rect.bottom;
                    return n2 - n3;
                }
                n2 = rect2.left;
                n3 = rect.right;
                return n2 - n3;
            }
            n2 = rect.top;
            n3 = rect2.bottom;
            return n2 - n3;
        }
        n2 = rect.left;
        n3 = rect2.right;
        return n2 - n3;
    }

    private static int m(int n2, Rect rect, Rect rect2) {
        return Math.max((int)1, (int)b.n(n2, rect, rect2));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int n(int n2, Rect rect, Rect rect2) {
        int n3;
        if (n2 != 17) {
            if (n2 != 33) {
                if (n2 != 66) {
                    if (n2 != 130) throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    n2 = rect2.bottom;
                    n3 = rect.bottom;
                    return n2 - n3;
                }
                n2 = rect2.right;
                n3 = rect.right;
                return n2 - n3;
            }
            n2 = rect.top;
            n3 = rect2.top;
            return n2 - n3;
        }
        n2 = rect.left;
        n3 = rect2.left;
        return n2 - n3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int o(int n2, Rect rect, Rect rect2) {
        if (n2 == 17) return Math.abs((int)(rect.top + rect.height() / 2 - (rect2.top + rect2.height() / 2)));
        if (n2 == 33) return Math.abs((int)(rect.left + rect.width() / 2 - (rect2.left + rect2.width() / 2)));
        if (n2 == 66) return Math.abs((int)(rect.top + rect.height() / 2 - (rect2.top + rect2.height() / 2)));
        if (n2 == 130) return Math.abs((int)(rect.left + rect.width() / 2 - (rect2.left + rect2.width() / 2)));
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    public static interface a {
        public void a(Object var1, Rect var2);
    }

    public static interface b {
        public Object a(Object var1, int var2);

        public int b(Object var1);
    }

    private static class c
    implements Comparator {
        private final Rect g = new Rect();
        private final Rect h = new Rect();
        private final boolean i;
        private final a j;

        c(boolean bl, a a2) {
            this.i = bl;
            this.j = a2;
        }

        public int compare(Object object, Object object2) {
            Rect rect = this.g;
            Rect rect2 = this.h;
            this.j.a(object, rect);
            this.j.a(object2, rect2);
            int n2 = rect.top;
            int n3 = rect2.top;
            if (n2 < n3) {
                return -1;
            }
            if (n2 > n3) {
                return 1;
            }
            n2 = rect.left;
            n3 = rect2.left;
            if (n2 < n3) {
                if (this.i) {
                    return 1;
                }
                return -1;
            }
            if (n2 > n3) {
                if (this.i) {
                    return -1;
                }
                return 1;
            }
            n3 = rect.bottom;
            n2 = rect2.bottom;
            if (n3 < n2) {
                return -1;
            }
            if (n3 > n2) {
                return 1;
            }
            n3 = rect.right;
            n2 = rect2.right;
            if (n3 < n2) {
                if (this.i) {
                    return 1;
                }
                return -1;
            }
            if (n3 > n2) {
                if (this.i) {
                    return -1;
                }
                return 1;
            }
            return 0;
        }
    }
}

