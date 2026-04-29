/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.text.DateFormat
 *  java.text.ParsePosition
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.Locale
 */
package s3;

import H2.q;
import V2.k;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import n3.d;

public abstract class c {
    private static final a a = new ThreadLocal(){

        protected DateFormat a() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(d.f);
            return simpleDateFormat;
        }
    };
    private static final String[] b;
    private static final DateFormat[] c;

    static {
        String[] stringArray = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        b = stringArray;
        c = new DateFormat[stringArray.length];
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final Date a(String object) {
        String[] stringArray;
        k.e(object, "<this>");
        if (object.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = ((DateFormat)a.get()).parse((String)object, parsePosition);
        if (parsePosition.getIndex() == object.length()) {
            return date;
        }
        String[] stringArray2 = stringArray = b;
        synchronized (stringArray) {
            DateFormat[] dateFormatArray;
            int n2;
            try {
                int n3 = stringArray.length;
                for (n2 = 0; n2 < n3; date = date.parse((String)object, parsePosition), ++n2) {
                    dateFormatArray = c;
                }
            }
            catch (Throwable throwable) {}
            {
                DateFormat dateFormat = dateFormatArray[n2];
                date = dateFormat;
                if (dateFormat == null) {
                    date = new SimpleDateFormat(b[n2], Locale.US);
                    date.setTimeZone(d.f);
                    dateFormatArray[n2] = date;
                }
                parsePosition.setIndex(0);
                int n4 = parsePosition.getIndex();
                if (n4 == 0) continue;
                return date;
            }
            object = q.a;
            // ** MonitorExit[var9_5] (shouldn't be in output)
            return null;
            throw throwable;
        }
    }

    public static final String b(Date object) {
        k.e(object, "<this>");
        object = ((DateFormat)a.get()).format(object);
        k.d(object, "STANDARD_DATE_FORMAT.get().format(this)");
        return object;
    }
}

