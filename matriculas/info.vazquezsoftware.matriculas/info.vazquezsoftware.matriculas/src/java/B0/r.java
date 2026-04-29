/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.room.h
 *  androidx.work.b
 *  h0.c
 *  j0.b
 *  j0.c
 *  j0.e
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  m0.e
 *  m0.f
 *  t0.b
 *  t0.s
 */
package B0;

import B0.p;
import B0.q;
import B0.v;
import android.database.Cursor;
import androidx.room.h;
import androidx.work.b;
import h0.a;
import h0.d;
import j0.c;
import java.util.ArrayList;
import java.util.List;
import m0.e;
import m0.f;
import t0.s;

public final class r
implements q {
    private final h a;
    private final a b;
    private final d c;
    private final d d;
    private final d e;
    private final d f;
    private final d g;
    private final d h;
    private final d i;
    private final d j;

    public r(h h2) {
        this.a = h2;
        this.b = new a(this, h2){
            final r d;
            {
                this.d = r2;
                super(h2);
            }

            @Override
            public String d() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void i(f f2, p object) {
                Object object2 = ((p)object).a;
                if (object2 == null) {
                    f2.H(1);
                } else {
                    f2.w(1, (String)object2);
                }
                f2.e0(2, (long)v.j(((p)object).b));
                object2 = ((p)object).c;
                if (object2 == null) {
                    f2.H(3);
                } else {
                    f2.w(3, (String)object2);
                }
                object2 = ((p)object).d;
                if (object2 == null) {
                    f2.H(4);
                } else {
                    f2.w(4, (String)object2);
                }
                object2 = androidx.work.b.k((b)((p)object).e);
                if (object2 == null) {
                    f2.H(5);
                } else {
                    f2.p0(5, (byte[])object2);
                }
                object2 = androidx.work.b.k((b)((p)object).f);
                if (object2 == null) {
                    f2.H(6);
                } else {
                    f2.p0(6, (byte[])object2);
                }
                f2.e0(7, ((p)object).g);
                f2.e0(8, ((p)object).h);
                f2.e0(9, ((p)object).i);
                f2.e0(10, (long)((p)object).k);
                f2.e0(11, (long)v.a(((p)object).l));
                f2.e0(12, ((p)object).m);
                f2.e0(13, ((p)object).n);
                f2.e0(14, ((p)object).o);
                f2.e0(15, ((p)object).p);
                f2.e0(16, (long)((p)object).q);
                f2.e0(17, (long)v.i(((p)object).r));
                object = ((p)object).j;
                if (object != null) {
                    f2.e0(18, (long)v.h(object.b()));
                    f2.e0(19, (long)object.g());
                    f2.e0(20, (long)object.h());
                    f2.e0(21, (long)object.f());
                    f2.e0(22, (long)object.i());
                    f2.e0(23, object.c());
                    f2.e0(24, object.d());
                    object = v.c(object.a());
                    if (object == null) {
                        f2.H(25);
                        return;
                    }
                    f2.p0(25, (byte[])object);
                    return;
                }
                f2.H(18);
                f2.H(19);
                f2.H(20);
                f2.H(21);
                f2.H(22);
                f2.H(23);
                f2.H(24);
                f2.H(25);
            }
        };
        this.c = new d(this, h2){
            final r d;
            {
                this.d = r2;
                super(h2);
            }

            @Override
            public String d() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.d = new d(this, h2){
            final r d;
            {
                this.d = r2;
                super(h2);
            }

            @Override
            public String d() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.e = new d(this, h2){
            final r d;
            {
                this.d = r2;
                super(h2);
            }

            @Override
            public String d() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }
        };
        this.f = new d(this, h2){
            final r d;
            {
                this.d = r2;
                super(h2);
            }

            @Override
            public String d() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.g = new d(this, h2){
            final r d;
            {
                this.d = r2;
                super(h2);
            }

            @Override
            public String d() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.h = new d(this, h2){
            final r d;
            {
                this.d = r2;
                super(h2);
            }

            @Override
            public String d() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.i = new d(this, h2){
            final r d;
            {
                this.d = r2;
                super(h2);
            }

            @Override
            public String d() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.j = new d(this, h2){
            final r d;
            {
                this.d = r2;
                super(h2);
            }

            @Override
            public String d() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
    }

    @Override
    public void a(String string) {
        this.a.b();
        f f2 = this.c.a();
        if (string == null) {
            f2.H(1);
        } else {
            f2.w(1, string);
        }
        this.a.c();
        try {
            f2.B();
            this.a.r();
            return;
        }
        finally {
            this.a.g();
            this.c.f(f2);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List b() {
        void var27_33;
        Cursor cursor;
        h0.c c2;
        block5: {
            ArrayList arrayList;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            c2 = h0.c.i((String)"SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", (int)0);
            this.a.b();
            cursor = j0.c.b((h)this.a, (e)c2, (boolean)false, null);
            try {
                n15 = j0.b.b((Cursor)cursor, (String)"required_network_type");
                n14 = j0.b.b((Cursor)cursor, (String)"requires_charging");
                n13 = j0.b.b((Cursor)cursor, (String)"requires_device_idle");
                n12 = j0.b.b((Cursor)cursor, (String)"requires_battery_not_low");
                n11 = j0.b.b((Cursor)cursor, (String)"requires_storage_not_low");
                n10 = j0.b.b((Cursor)cursor, (String)"trigger_content_update_delay");
                n9 = j0.b.b((Cursor)cursor, (String)"trigger_max_content_delay");
                n8 = j0.b.b((Cursor)cursor, (String)"content_uri_triggers");
                n7 = j0.b.b((Cursor)cursor, (String)"id");
                n6 = j0.b.b((Cursor)cursor, (String)"state");
                n5 = j0.b.b((Cursor)cursor, (String)"worker_class_name");
                n4 = j0.b.b((Cursor)cursor, (String)"input_merger_class_name");
                n3 = j0.b.b((Cursor)cursor, (String)"input");
                n2 = j0.b.b((Cursor)cursor, (String)"output");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block5;
            }
            try {
                int n16 = j0.b.b((Cursor)cursor, (String)"initial_delay");
                int n17 = j0.b.b((Cursor)cursor, (String)"interval_duration");
                int n18 = j0.b.b((Cursor)cursor, (String)"flex_duration");
                int n19 = j0.b.b((Cursor)cursor, (String)"run_attempt_count");
                int n20 = j0.b.b((Cursor)cursor, (String)"backoff_policy");
                int n21 = j0.b.b((Cursor)cursor, (String)"backoff_delay_duration");
                int n22 = j0.b.b((Cursor)cursor, (String)"period_start_time");
                int n23 = j0.b.b((Cursor)cursor, (String)"minimum_retention_duration");
                int n24 = j0.b.b((Cursor)cursor, (String)"schedule_requested_at");
                int n25 = j0.b.b((Cursor)cursor, (String)"run_in_foreground");
                int n26 = j0.b.b((Cursor)cursor, (String)"out_of_quota_policy");
                arrayList = new ArrayList(cursor.getCount());
                while (cursor.moveToNext()) {
                    String string = cursor.getString(n7);
                    String string2 = cursor.getString(n5);
                    t0.b b2 = new t0.b();
                    b2.k(v.e(cursor.getInt(n15)));
                    boolean bl = cursor.getInt(n14) != 0;
                    b2.m(bl);
                    bl = cursor.getInt(n13) != 0;
                    b2.n(bl);
                    bl = cursor.getInt(n12) != 0;
                    b2.l(bl);
                    bl = cursor.getInt(n11) != 0;
                    b2.o(bl);
                    b2.p(cursor.getLong(n10));
                    b2.q(cursor.getLong(n9));
                    b2.j(v.b(cursor.getBlob(n8)));
                    p p2 = new p(string, string2);
                    p2.b = v.g(cursor.getInt(n6));
                    p2.d = cursor.getString(n4);
                    p2.e = androidx.work.b.g((byte[])cursor.getBlob(n3));
                    p2.f = androidx.work.b.g((byte[])cursor.getBlob(n2));
                    p2.g = cursor.getLong(n16);
                    p2.h = cursor.getLong(n17);
                    p2.i = cursor.getLong(n18);
                    p2.k = cursor.getInt(n19);
                    p2.l = v.d(cursor.getInt(n20));
                    p2.m = cursor.getLong(n21);
                    p2.n = cursor.getLong(n22);
                    p2.o = cursor.getLong(n23);
                    p2.p = cursor.getLong(n24);
                    bl = cursor.getInt(n25) != 0;
                    p2.q = bl;
                    p2.r = v.f(cursor.getInt(n26));
                    p2.j = b2;
                    arrayList.add((Object)p2);
                }
            }
            catch (Throwable throwable) {
                break block5;
            }
            cursor.close();
            c2.A();
            return arrayList;
        }
        cursor.close();
        c2.A();
        throw var27_33;
    }

    @Override
    public boolean c() {
        Throwable throwable2;
        Cursor cursor;
        h0.c c2;
        block3: {
            boolean bl;
            block2: {
                boolean bl2 = false;
                c2 = h0.c.i((String)"SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", (int)0);
                this.a.b();
                cursor = j0.c.b((h)this.a, (e)c2, (boolean)false, null);
                bl = bl2;
                try {
                    if (!cursor.moveToFirst()) break block2;
                    int n2 = cursor.getInt(0);
                    bl = bl2;
                    if (n2 == 0) break block2;
                    bl = true;
                }
                catch (Throwable throwable2) {
                    break block3;
                }
            }
            cursor.close();
            c2.A();
            return bl;
        }
        cursor.close();
        c2.A();
        throw throwable2;
    }

    @Override
    public int d(String string, long l2) {
        this.a.b();
        f f2 = this.h.a();
        f2.e0(1, l2);
        if (string == null) {
            f2.H(2);
        } else {
            f2.w(2, string);
        }
        this.a.c();
        try {
            int n2 = f2.B();
            this.a.r();
            return n2;
        }
        finally {
            this.a.g();
            this.h.f(f2);
        }
    }

    @Override
    public List e(String string) {
        Throwable throwable2;
        h0.c c2;
        block5: {
            ArrayList arrayList;
            c2 = h0.c.i((String)"SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", (int)1);
            if (string == null) {
                c2.H(1);
            } else {
                c2.w(1, string);
            }
            this.a.b();
            string = j0.c.b((h)this.a, (e)c2, (boolean)false, null);
            try {
                arrayList = new ArrayList(string.getCount());
                while (string.moveToNext()) {
                    arrayList.add((Object)string.getString(0));
                }
            }
            catch (Throwable throwable2) {
                break block5;
            }
            string.close();
            c2.A();
            return arrayList;
        }
        string.close();
        c2.A();
        throw throwable2;
    }

    @Override
    public List f(String string) {
        Throwable throwable2;
        h0.c c2;
        block5: {
            ArrayList arrayList;
            c2 = h0.c.i((String)"SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", (int)1);
            if (string == null) {
                c2.H(1);
            } else {
                c2.w(1, string);
            }
            this.a.b();
            string = j0.c.b((h)this.a, (e)c2, (boolean)false, null);
            try {
                int n2 = j0.b.b((Cursor)string, (String)"id");
                int n3 = j0.b.b((Cursor)string, (String)"state");
                arrayList = new ArrayList(string.getCount());
                while (string.moveToNext()) {
                    p.b b2 = new p.b();
                    b2.a = string.getString(n2);
                    b2.b = v.g(string.getInt(n3));
                    arrayList.add((Object)b2);
                }
            }
            catch (Throwable throwable2) {
                break block5;
            }
            string.close();
            c2.A();
            return arrayList;
        }
        string.close();
        c2.A();
        throw throwable2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List g(long l2) {
        void var29_34;
        Cursor cursor;
        h0.c c2;
        block5: {
            ArrayList arrayList;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            c2 = h0.c.i((String)"SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", (int)1);
            c2.e0(1, l2);
            this.a.b();
            cursor = j0.c.b((h)this.a, (e)c2, (boolean)false, null);
            try {
                n15 = j0.b.b((Cursor)cursor, (String)"required_network_type");
                n14 = j0.b.b((Cursor)cursor, (String)"requires_charging");
                n13 = j0.b.b((Cursor)cursor, (String)"requires_device_idle");
                n12 = j0.b.b((Cursor)cursor, (String)"requires_battery_not_low");
                n11 = j0.b.b((Cursor)cursor, (String)"requires_storage_not_low");
                n10 = j0.b.b((Cursor)cursor, (String)"trigger_content_update_delay");
                n9 = j0.b.b((Cursor)cursor, (String)"trigger_max_content_delay");
                n8 = j0.b.b((Cursor)cursor, (String)"content_uri_triggers");
                n7 = j0.b.b((Cursor)cursor, (String)"id");
                n6 = j0.b.b((Cursor)cursor, (String)"state");
                n5 = j0.b.b((Cursor)cursor, (String)"worker_class_name");
                n4 = j0.b.b((Cursor)cursor, (String)"input_merger_class_name");
                n3 = j0.b.b((Cursor)cursor, (String)"input");
                n2 = j0.b.b((Cursor)cursor, (String)"output");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block5;
            }
            try {
                int n16 = j0.b.b((Cursor)cursor, (String)"initial_delay");
                int n17 = j0.b.b((Cursor)cursor, (String)"interval_duration");
                int n18 = j0.b.b((Cursor)cursor, (String)"flex_duration");
                int n19 = j0.b.b((Cursor)cursor, (String)"run_attempt_count");
                int n20 = j0.b.b((Cursor)cursor, (String)"backoff_policy");
                int n21 = j0.b.b((Cursor)cursor, (String)"backoff_delay_duration");
                int n22 = j0.b.b((Cursor)cursor, (String)"period_start_time");
                int n23 = j0.b.b((Cursor)cursor, (String)"minimum_retention_duration");
                int n24 = j0.b.b((Cursor)cursor, (String)"schedule_requested_at");
                int n25 = j0.b.b((Cursor)cursor, (String)"run_in_foreground");
                int n26 = j0.b.b((Cursor)cursor, (String)"out_of_quota_policy");
                arrayList = new ArrayList(cursor.getCount());
                while (cursor.moveToNext()) {
                    String string = cursor.getString(n7);
                    String string2 = cursor.getString(n5);
                    t0.b b2 = new t0.b();
                    b2.k(v.e(cursor.getInt(n15)));
                    boolean bl = cursor.getInt(n14) != 0;
                    b2.m(bl);
                    bl = cursor.getInt(n13) != 0;
                    b2.n(bl);
                    bl = cursor.getInt(n12) != 0;
                    b2.l(bl);
                    bl = cursor.getInt(n11) != 0;
                    b2.o(bl);
                    b2.p(cursor.getLong(n10));
                    b2.q(cursor.getLong(n9));
                    b2.j(v.b(cursor.getBlob(n8)));
                    p p2 = new p(string, string2);
                    p2.b = v.g(cursor.getInt(n6));
                    p2.d = cursor.getString(n4);
                    p2.e = androidx.work.b.g((byte[])cursor.getBlob(n3));
                    p2.f = androidx.work.b.g((byte[])cursor.getBlob(n2));
                    p2.g = cursor.getLong(n16);
                    p2.h = cursor.getLong(n17);
                    p2.i = cursor.getLong(n18);
                    p2.k = cursor.getInt(n19);
                    p2.l = v.d(cursor.getInt(n20));
                    p2.m = cursor.getLong(n21);
                    p2.n = cursor.getLong(n22);
                    p2.o = cursor.getLong(n23);
                    p2.p = cursor.getLong(n24);
                    bl = cursor.getInt(n25) != 0;
                    p2.q = bl;
                    p2.r = v.f(cursor.getInt(n26));
                    p2.j = b2;
                    arrayList.add((Object)p2);
                }
            }
            catch (Throwable throwable) {
                break block5;
            }
            cursor.close();
            c2.A();
            return arrayList;
        }
        cursor.close();
        c2.A();
        throw var29_34;
    }

    @Override
    public s h(String string) {
        Throwable throwable2;
        h h2;
        h0.c c2;
        block5: {
            block4: {
                c2 = h0.c.i((String)"SELECT state FROM workspec WHERE id=?", (int)1);
                if (string == null) {
                    c2.H(1);
                } else {
                    c2.w(1, string);
                }
                this.a.b();
                h2 = this.a;
                string = null;
                h2 = j0.c.b((h)h2, (e)c2, (boolean)false, null);
                try {
                    if (!h2.moveToFirst()) break block4;
                    string = v.g(h2.getInt(0));
                }
                catch (Throwable throwable2) {
                    break block5;
                }
            }
            h2.close();
            c2.A();
            return string;
        }
        h2.close();
        c2.A();
        throw throwable2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List i(int n2) {
        void var27_33;
        Cursor cursor;
        h0.c c2;
        block5: {
            ArrayList arrayList;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            int n16;
            c2 = h0.c.i((String)"SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", (int)1);
            c2.e0(1, (long)n2);
            this.a.b();
            cursor = j0.c.b((h)this.a, (e)c2, (boolean)false, null);
            try {
                n16 = j0.b.b((Cursor)cursor, (String)"required_network_type");
                n15 = j0.b.b((Cursor)cursor, (String)"requires_charging");
                n14 = j0.b.b((Cursor)cursor, (String)"requires_device_idle");
                n13 = j0.b.b((Cursor)cursor, (String)"requires_battery_not_low");
                n12 = j0.b.b((Cursor)cursor, (String)"requires_storage_not_low");
                n11 = j0.b.b((Cursor)cursor, (String)"trigger_content_update_delay");
                n10 = j0.b.b((Cursor)cursor, (String)"trigger_max_content_delay");
                n9 = j0.b.b((Cursor)cursor, (String)"content_uri_triggers");
                n8 = j0.b.b((Cursor)cursor, (String)"id");
                n7 = j0.b.b((Cursor)cursor, (String)"state");
                n6 = j0.b.b((Cursor)cursor, (String)"worker_class_name");
                n5 = j0.b.b((Cursor)cursor, (String)"input_merger_class_name");
                n4 = j0.b.b((Cursor)cursor, (String)"input");
                n3 = j0.b.b((Cursor)cursor, (String)"output");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block5;
            }
            try {
                int n17 = j0.b.b((Cursor)cursor, (String)"initial_delay");
                int n18 = j0.b.b((Cursor)cursor, (String)"interval_duration");
                int n19 = j0.b.b((Cursor)cursor, (String)"flex_duration");
                int n20 = j0.b.b((Cursor)cursor, (String)"run_attempt_count");
                int n21 = j0.b.b((Cursor)cursor, (String)"backoff_policy");
                int n22 = j0.b.b((Cursor)cursor, (String)"backoff_delay_duration");
                int n23 = j0.b.b((Cursor)cursor, (String)"period_start_time");
                int n24 = j0.b.b((Cursor)cursor, (String)"minimum_retention_duration");
                int n25 = j0.b.b((Cursor)cursor, (String)"schedule_requested_at");
                n2 = j0.b.b((Cursor)cursor, (String)"run_in_foreground");
                int n26 = j0.b.b((Cursor)cursor, (String)"out_of_quota_policy");
                arrayList = new ArrayList(cursor.getCount());
                while (cursor.moveToNext()) {
                    String string = cursor.getString(n8);
                    String string2 = cursor.getString(n6);
                    t0.b b2 = new t0.b();
                    b2.k(v.e(cursor.getInt(n16)));
                    boolean bl = cursor.getInt(n15) != 0;
                    b2.m(bl);
                    bl = cursor.getInt(n14) != 0;
                    b2.n(bl);
                    bl = cursor.getInt(n13) != 0;
                    b2.l(bl);
                    bl = cursor.getInt(n12) != 0;
                    b2.o(bl);
                    b2.p(cursor.getLong(n11));
                    b2.q(cursor.getLong(n10));
                    b2.j(v.b(cursor.getBlob(n9)));
                    p p2 = new p(string, string2);
                    p2.b = v.g(cursor.getInt(n7));
                    p2.d = cursor.getString(n5);
                    p2.e = androidx.work.b.g((byte[])cursor.getBlob(n4));
                    p2.f = androidx.work.b.g((byte[])cursor.getBlob(n3));
                    p2.g = cursor.getLong(n17);
                    p2.h = cursor.getLong(n18);
                    p2.i = cursor.getLong(n19);
                    p2.k = cursor.getInt(n20);
                    p2.l = v.d(cursor.getInt(n21));
                    p2.m = cursor.getLong(n22);
                    p2.n = cursor.getLong(n23);
                    p2.o = cursor.getLong(n24);
                    p2.p = cursor.getLong(n25);
                    bl = cursor.getInt(n2) != 0;
                    p2.q = bl;
                    p2.r = v.f(cursor.getInt(n26));
                    p2.j = b2;
                    arrayList.add((Object)p2);
                }
            }
            catch (Throwable throwable) {
                break block5;
            }
            cursor.close();
            c2.A();
            return arrayList;
        }
        cursor.close();
        c2.A();
        throw var27_33;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public p j(String object) {
        void var1_4;
        Cursor cursor;
        h0.c c2;
        block6: {
            block8: {
                block7: {
                    int n26;
                    int n25;
                    int n24;
                    int n23;
                    int n22;
                    int n21;
                    int n20;
                    int n19;
                    int n18;
                    int n17;
                    int n16;
                    int n15;
                    int n14;
                    int n13;
                    c2 = h0.c.i((String)"SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", (int)1);
                    if (object == null) {
                        c2.H(1);
                    } else {
                        c2.w(1, (String)object);
                    }
                    this.a.b();
                    cursor = j0.c.b((h)this.a, (e)c2, (boolean)false, null);
                    try {
                        n13 = j0.b.b((Cursor)cursor, (String)"required_network_type");
                        n14 = j0.b.b((Cursor)cursor, (String)"requires_charging");
                        n15 = j0.b.b((Cursor)cursor, (String)"requires_device_idle");
                        n16 = j0.b.b((Cursor)cursor, (String)"requires_battery_not_low");
                        n17 = j0.b.b((Cursor)cursor, (String)"requires_storage_not_low");
                        n18 = j0.b.b((Cursor)cursor, (String)"trigger_content_update_delay");
                        n19 = j0.b.b((Cursor)cursor, (String)"trigger_max_content_delay");
                        n20 = j0.b.b((Cursor)cursor, (String)"content_uri_triggers");
                        n21 = j0.b.b((Cursor)cursor, (String)"id");
                        n22 = j0.b.b((Cursor)cursor, (String)"state");
                        n23 = j0.b.b((Cursor)cursor, (String)"worker_class_name");
                        n24 = j0.b.b((Cursor)cursor, (String)"input_merger_class_name");
                        n25 = j0.b.b((Cursor)cursor, (String)"input");
                        n26 = j0.b.b((Cursor)cursor, (String)"output");
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                        break block6;
                    }
                    try {
                        int n12 = j0.b.b((Cursor)cursor, (String)"initial_delay");
                        int n11 = j0.b.b((Cursor)cursor, (String)"interval_duration");
                        int n10 = j0.b.b((Cursor)cursor, (String)"flex_duration");
                        int n9 = j0.b.b((Cursor)cursor, (String)"run_attempt_count");
                        int n8 = j0.b.b((Cursor)cursor, (String)"backoff_policy");
                        int n7 = j0.b.b((Cursor)cursor, (String)"backoff_delay_duration");
                        int n6 = j0.b.b((Cursor)cursor, (String)"period_start_time");
                        int n5 = j0.b.b((Cursor)cursor, (String)"minimum_retention_duration");
                        int n4 = j0.b.b((Cursor)cursor, (String)"schedule_requested_at");
                        int n3 = j0.b.b((Cursor)cursor, (String)"run_in_foreground");
                        int n2 = j0.b.b((Cursor)cursor, (String)"out_of_quota_policy");
                        if (!cursor.moveToFirst()) break block7;
                        String string2 = cursor.getString(n21);
                        String string = cursor.getString(n23);
                        t0.b b2 = new t0.b();
                        b2.k(v.e(cursor.getInt(n13)));
                        boolean bl = cursor.getInt(n14) != 0;
                        b2.m(bl);
                        bl = cursor.getInt(n15) != 0;
                        b2.n(bl);
                        bl = cursor.getInt(n16) != 0;
                        b2.l(bl);
                        bl = cursor.getInt(n17) != 0;
                        b2.o(bl);
                        b2.p(cursor.getLong(n18));
                        b2.q(cursor.getLong(n19));
                        b2.j(v.b(cursor.getBlob(n20)));
                        object = new p(string2, string);
                        ((p)object).b = v.g(cursor.getInt(n22));
                        ((p)object).d = cursor.getString(n24);
                        ((p)object).e = androidx.work.b.g((byte[])cursor.getBlob(n25));
                        ((p)object).f = androidx.work.b.g((byte[])cursor.getBlob(n26));
                        ((p)object).g = cursor.getLong(n12);
                        ((p)object).h = cursor.getLong(n11);
                        ((p)object).i = cursor.getLong(n10);
                        ((p)object).k = cursor.getInt(n9);
                        ((p)object).l = v.d(cursor.getInt(n8));
                        ((p)object).m = cursor.getLong(n7);
                        ((p)object).n = cursor.getLong(n6);
                        ((p)object).o = cursor.getLong(n5);
                        ((p)object).p = cursor.getLong(n4);
                        bl = cursor.getInt(n3) != 0;
                        ((p)object).q = bl;
                        ((p)object).r = v.f(cursor.getInt(n2));
                        ((p)object).j = b2;
                        break block8;
                    }
                    catch (Throwable throwable) {
                        break block6;
                    }
                }
                object = null;
            }
            cursor.close();
            c2.A();
            return object;
        }
        cursor.close();
        c2.A();
        throw var1_4;
    }

    @Override
    public int k(String string) {
        this.a.b();
        f f2 = this.g.a();
        if (string == null) {
            f2.H(1);
        } else {
            f2.w(1, string);
        }
        this.a.c();
        try {
            int n2 = f2.B();
            this.a.r();
            return n2;
        }
        finally {
            this.a.g();
            this.g.f(f2);
        }
    }

    @Override
    public void l(p p2) {
        this.a.b();
        this.a.c();
        try {
            this.b.h(p2);
            this.a.r();
            return;
        }
        finally {
            this.a.g();
        }
    }

    @Override
    public int m(s object, String ... stringArray) {
        int n2;
        this.a.b();
        Object object2 = j0.e.b();
        object2.append("UPDATE workspec SET state=");
        object2.append("?");
        object2.append(" WHERE id IN (");
        j0.e.a((StringBuilder)object2, (int)stringArray.length);
        object2.append(")");
        object2 = object2.toString();
        object2 = this.a.d((String)object2);
        object2.e0(1, (long)v.j(object));
        int n3 = stringArray.length;
        int n4 = 2;
        for (n2 = 0; n2 < n3; ++n2) {
            object = stringArray[n2];
            if (object == null) {
                object2.H(n4);
            } else {
                object2.w(n4, (String)object);
            }
            ++n4;
        }
        this.a.c();
        try {
            n2 = object2.B();
            this.a.r();
            return n2;
        }
        finally {
            this.a.g();
        }
    }

    @Override
    public List n(String string) {
        Throwable throwable2;
        h0.c c2;
        block5: {
            ArrayList arrayList;
            c2 = h0.c.i((String)"SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", (int)1);
            if (string == null) {
                c2.H(1);
            } else {
                c2.w(1, string);
            }
            this.a.b();
            string = j0.c.b((h)this.a, (e)c2, (boolean)false, null);
            try {
                arrayList = new ArrayList(string.getCount());
                while (string.moveToNext()) {
                    arrayList.add((Object)string.getString(0));
                }
            }
            catch (Throwable throwable2) {
                break block5;
            }
            string.close();
            c2.A();
            return arrayList;
        }
        string.close();
        c2.A();
        throw throwable2;
    }

    @Override
    public List o(String string) {
        Throwable throwable2;
        h0.c c2;
        block5: {
            ArrayList arrayList;
            c2 = h0.c.i((String)"SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", (int)1);
            if (string == null) {
                c2.H(1);
            } else {
                c2.w(1, string);
            }
            this.a.b();
            string = j0.c.b((h)this.a, (e)c2, (boolean)false, null);
            try {
                arrayList = new ArrayList(string.getCount());
                while (string.moveToNext()) {
                    arrayList.add((Object)androidx.work.b.g((byte[])string.getBlob(0)));
                }
            }
            catch (Throwable throwable2) {
                break block5;
            }
            string.close();
            c2.A();
            return arrayList;
        }
        string.close();
        c2.A();
        throw throwable2;
    }

    @Override
    public int p(String string) {
        this.a.b();
        f f2 = this.f.a();
        if (string == null) {
            f2.H(1);
        } else {
            f2.w(1, string);
        }
        this.a.c();
        try {
            int n2 = f2.B();
            this.a.r();
            return n2;
        }
        finally {
            this.a.g();
            this.f.f(f2);
        }
    }

    @Override
    public void q(String string, long l2) {
        this.a.b();
        f f2 = this.e.a();
        f2.e0(1, l2);
        if (string == null) {
            f2.H(2);
        } else {
            f2.w(2, string);
        }
        this.a.c();
        try {
            f2.B();
            this.a.r();
            return;
        }
        finally {
            this.a.g();
            this.e.f(f2);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List r() {
        void var27_33;
        Cursor cursor;
        h0.c c2;
        block5: {
            ArrayList arrayList;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            c2 = h0.c.i((String)"SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", (int)0);
            this.a.b();
            cursor = j0.c.b((h)this.a, (e)c2, (boolean)false, null);
            try {
                n15 = j0.b.b((Cursor)cursor, (String)"required_network_type");
                n14 = j0.b.b((Cursor)cursor, (String)"requires_charging");
                n13 = j0.b.b((Cursor)cursor, (String)"requires_device_idle");
                n12 = j0.b.b((Cursor)cursor, (String)"requires_battery_not_low");
                n11 = j0.b.b((Cursor)cursor, (String)"requires_storage_not_low");
                n10 = j0.b.b((Cursor)cursor, (String)"trigger_content_update_delay");
                n9 = j0.b.b((Cursor)cursor, (String)"trigger_max_content_delay");
                n8 = j0.b.b((Cursor)cursor, (String)"content_uri_triggers");
                n7 = j0.b.b((Cursor)cursor, (String)"id");
                n6 = j0.b.b((Cursor)cursor, (String)"state");
                n5 = j0.b.b((Cursor)cursor, (String)"worker_class_name");
                n4 = j0.b.b((Cursor)cursor, (String)"input_merger_class_name");
                n3 = j0.b.b((Cursor)cursor, (String)"input");
                n2 = j0.b.b((Cursor)cursor, (String)"output");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block5;
            }
            try {
                int n16 = j0.b.b((Cursor)cursor, (String)"initial_delay");
                int n17 = j0.b.b((Cursor)cursor, (String)"interval_duration");
                int n18 = j0.b.b((Cursor)cursor, (String)"flex_duration");
                int n19 = j0.b.b((Cursor)cursor, (String)"run_attempt_count");
                int n20 = j0.b.b((Cursor)cursor, (String)"backoff_policy");
                int n21 = j0.b.b((Cursor)cursor, (String)"backoff_delay_duration");
                int n22 = j0.b.b((Cursor)cursor, (String)"period_start_time");
                int n23 = j0.b.b((Cursor)cursor, (String)"minimum_retention_duration");
                int n24 = j0.b.b((Cursor)cursor, (String)"schedule_requested_at");
                int n25 = j0.b.b((Cursor)cursor, (String)"run_in_foreground");
                int n26 = j0.b.b((Cursor)cursor, (String)"out_of_quota_policy");
                arrayList = new ArrayList(cursor.getCount());
                while (cursor.moveToNext()) {
                    String string = cursor.getString(n7);
                    String string2 = cursor.getString(n5);
                    t0.b b2 = new t0.b();
                    b2.k(v.e(cursor.getInt(n15)));
                    boolean bl = cursor.getInt(n14) != 0;
                    b2.m(bl);
                    bl = cursor.getInt(n13) != 0;
                    b2.n(bl);
                    bl = cursor.getInt(n12) != 0;
                    b2.l(bl);
                    bl = cursor.getInt(n11) != 0;
                    b2.o(bl);
                    b2.p(cursor.getLong(n10));
                    b2.q(cursor.getLong(n9));
                    b2.j(v.b(cursor.getBlob(n8)));
                    p p2 = new p(string, string2);
                    p2.b = v.g(cursor.getInt(n6));
                    p2.d = cursor.getString(n4);
                    p2.e = androidx.work.b.g((byte[])cursor.getBlob(n3));
                    p2.f = androidx.work.b.g((byte[])cursor.getBlob(n2));
                    p2.g = cursor.getLong(n16);
                    p2.h = cursor.getLong(n17);
                    p2.i = cursor.getLong(n18);
                    p2.k = cursor.getInt(n19);
                    p2.l = v.d(cursor.getInt(n20));
                    p2.m = cursor.getLong(n21);
                    p2.n = cursor.getLong(n22);
                    p2.o = cursor.getLong(n23);
                    p2.p = cursor.getLong(n24);
                    bl = cursor.getInt(n25) != 0;
                    p2.q = bl;
                    p2.r = v.f(cursor.getInt(n26));
                    p2.j = b2;
                    arrayList.add((Object)p2);
                }
            }
            catch (Throwable throwable) {
                break block5;
            }
            cursor.close();
            c2.A();
            return arrayList;
        }
        cursor.close();
        c2.A();
        throw var27_33;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List s(int n2) {
        void var27_33;
        Cursor cursor;
        h0.c c2;
        block5: {
            ArrayList arrayList;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            int n16;
            c2 = h0.c.i((String)"SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", (int)1);
            c2.e0(1, (long)n2);
            this.a.b();
            cursor = j0.c.b((h)this.a, (e)c2, (boolean)false, null);
            try {
                n16 = j0.b.b((Cursor)cursor, (String)"required_network_type");
                n15 = j0.b.b((Cursor)cursor, (String)"requires_charging");
                n14 = j0.b.b((Cursor)cursor, (String)"requires_device_idle");
                n13 = j0.b.b((Cursor)cursor, (String)"requires_battery_not_low");
                n12 = j0.b.b((Cursor)cursor, (String)"requires_storage_not_low");
                n11 = j0.b.b((Cursor)cursor, (String)"trigger_content_update_delay");
                n10 = j0.b.b((Cursor)cursor, (String)"trigger_max_content_delay");
                n9 = j0.b.b((Cursor)cursor, (String)"content_uri_triggers");
                n8 = j0.b.b((Cursor)cursor, (String)"id");
                n7 = j0.b.b((Cursor)cursor, (String)"state");
                n6 = j0.b.b((Cursor)cursor, (String)"worker_class_name");
                n5 = j0.b.b((Cursor)cursor, (String)"input_merger_class_name");
                n4 = j0.b.b((Cursor)cursor, (String)"input");
                n3 = j0.b.b((Cursor)cursor, (String)"output");
            }
            catch (Throwable throwable) {
                // empty catch block
                break block5;
            }
            try {
                int n17 = j0.b.b((Cursor)cursor, (String)"initial_delay");
                int n18 = j0.b.b((Cursor)cursor, (String)"interval_duration");
                int n19 = j0.b.b((Cursor)cursor, (String)"flex_duration");
                int n20 = j0.b.b((Cursor)cursor, (String)"run_attempt_count");
                int n21 = j0.b.b((Cursor)cursor, (String)"backoff_policy");
                int n22 = j0.b.b((Cursor)cursor, (String)"backoff_delay_duration");
                int n23 = j0.b.b((Cursor)cursor, (String)"period_start_time");
                int n24 = j0.b.b((Cursor)cursor, (String)"minimum_retention_duration");
                int n25 = j0.b.b((Cursor)cursor, (String)"schedule_requested_at");
                n2 = j0.b.b((Cursor)cursor, (String)"run_in_foreground");
                int n26 = j0.b.b((Cursor)cursor, (String)"out_of_quota_policy");
                arrayList = new ArrayList(cursor.getCount());
                while (cursor.moveToNext()) {
                    String string = cursor.getString(n8);
                    String string2 = cursor.getString(n6);
                    t0.b b2 = new t0.b();
                    b2.k(v.e(cursor.getInt(n16)));
                    boolean bl = cursor.getInt(n15) != 0;
                    b2.m(bl);
                    bl = cursor.getInt(n14) != 0;
                    b2.n(bl);
                    bl = cursor.getInt(n13) != 0;
                    b2.l(bl);
                    bl = cursor.getInt(n12) != 0;
                    b2.o(bl);
                    b2.p(cursor.getLong(n11));
                    b2.q(cursor.getLong(n10));
                    b2.j(v.b(cursor.getBlob(n9)));
                    p p2 = new p(string, string2);
                    p2.b = v.g(cursor.getInt(n7));
                    p2.d = cursor.getString(n5);
                    p2.e = androidx.work.b.g((byte[])cursor.getBlob(n4));
                    p2.f = androidx.work.b.g((byte[])cursor.getBlob(n3));
                    p2.g = cursor.getLong(n17);
                    p2.h = cursor.getLong(n18);
                    p2.i = cursor.getLong(n19);
                    p2.k = cursor.getInt(n20);
                    p2.l = v.d(cursor.getInt(n21));
                    p2.m = cursor.getLong(n22);
                    p2.n = cursor.getLong(n23);
                    p2.o = cursor.getLong(n24);
                    p2.p = cursor.getLong(n25);
                    bl = cursor.getInt(n2) != 0;
                    p2.q = bl;
                    p2.r = v.f(cursor.getInt(n26));
                    p2.j = b2;
                    arrayList.add((Object)p2);
                }
            }
            catch (Throwable throwable) {
                break block5;
            }
            cursor.close();
            c2.A();
            return arrayList;
        }
        cursor.close();
        c2.A();
        throw var27_33;
    }

    @Override
    public void t(String string, b object) {
        this.a.b();
        f f2 = this.d.a();
        object = androidx.work.b.k((b)object);
        if (object == null) {
            f2.H(1);
        } else {
            f2.p0(1, (byte[])object);
        }
        if (string == null) {
            f2.H(2);
        } else {
            f2.w(2, string);
        }
        this.a.c();
        try {
            f2.B();
            this.a.r();
            return;
        }
        finally {
            this.a.g();
            this.d.f(f2);
        }
    }

    @Override
    public int u() {
        this.a.b();
        f f2 = this.i.a();
        this.a.c();
        try {
            int n2 = f2.B();
            this.a.r();
            return n2;
        }
        finally {
            this.a.g();
            this.i.f(f2);
        }
    }
}

