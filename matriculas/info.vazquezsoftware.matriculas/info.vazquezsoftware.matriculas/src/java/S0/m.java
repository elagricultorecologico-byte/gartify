/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  B3.a
 *  androidx.webkit.ProfileStore
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.InvocationHandler
 *  java.util.List
 *  org.chromium.support_lib_boundary.ProfileBoundaryInterface
 *  org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface
 */
package s0;

import B3.a;
import androidx.webkit.ProfileStore;
import java.lang.reflect.InvocationHandler;
import java.util.List;
import org.chromium.support_lib_boundary.ProfileBoundaryInterface;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;
import r0.b;
import s0.l;
import s0.s;
import s0.t;

public class m
implements ProfileStore {
    private static ProfileStore b;
    private final ProfileStoreBoundaryInterface a;

    private m(ProfileStoreBoundaryInterface profileStoreBoundaryInterface) {
        this.a = profileStoreBoundaryInterface;
    }

    public static ProfileStore a() {
        if (b == null) {
            b = new m(t.c().getProfileStore());
        }
        return b;
    }

    public boolean deleteProfile(String string) {
        if (s.c0.d()) {
            return this.a.deleteProfile(string);
        }
        throw s.a();
    }

    public List getAllProfileNames() {
        if (s.c0.d()) {
            return this.a.getAllProfileNames();
        }
        throw s.a();
    }

    public b getOrCreateProfile(String string) {
        if (s.c0.d()) {
            return new l((ProfileBoundaryInterface)B3.a.a(ProfileBoundaryInterface.class, (InvocationHandler)this.a.getOrCreateProfile(string)));
        }
        throw s.a();
    }

    public b getProfile(String string) {
        if (s.c0.d()) {
            if ((string = this.a.getProfile(string)) != null) {
                return new l((ProfileBoundaryInterface)B3.a.a(ProfileBoundaryInterface.class, (InvocationHandler)string));
            }
            return null;
        }
        throw s.a();
    }
}

