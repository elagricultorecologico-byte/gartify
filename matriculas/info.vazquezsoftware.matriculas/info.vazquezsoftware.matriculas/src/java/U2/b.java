/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.concurrent.TimeUnit
 *  m3.v
 *  m3.w$a
 *  m3.y$a
 *  m3.z
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package u2;

import java.util.concurrent.TimeUnit;
import m3.v;
import m3.w;
import m3.y;
import m3.z;
import org.json.JSONArray;
import org.json.JSONObject;
import r2.k;
import r2.r;
import u2.a;
import u2.c;
import u2.d;

public abstract class b {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void a(String string, c c2) {
        Exception exception2;
        block3: {
            Object object;
            try {
                w.a a2 = new w.a();
                object = TimeUnit.SECONDS;
                object = a2.b(30L, object).G(30L, object).K(30L, object).a();
                a2 = new StringBuilder();
                a2.append("{\n  \"operationName\": \"GetInfoVehiculo\",\n  \"variables\": {\n    \"id\": \"P-");
                a2.append(string);
                a2.append("\",\n    \"nativeAds\": {\n      \"app\": \"autoficha\",\n      \"platform\": \"android\"\n    }\n  },\n  \"query\": \"query GetInfoVehiculo($id: String!, $nativeAds: InputNativeAds) {\\n  getInfoVehiculo(id: $id, nativeAds: $nativeAds) {\\n    __typename\\n    ... on IHeader {\\n      title\\n      subtitle\\n      description\\n      image\\n      subtitle\\n      __typename\\n    }\\n    ... on IContent {\\n      title\\n      icon\\n      values {\\n        textColor\\n        backgroundColor\\n        value\\n        title\\n        __typename\\n      }\\n      __typename\\n    }\\n    ... on ITable {\\n      icon\\n      values {\\n        title\\n        textColor\\n        backgroundColor\\n        values {\\n          textColor\\n          backgroundColor\\n          value\\n          title\\n          __typename\\n        }\\n        __typename\\n      }\\n      title\\n      __typename\\n    }\\n    ... on IAlert {\\n      __typename\\n      alert_type\\n      title\\n      description\\n      links {\\n        title\\n        value\\n        __typename\\n      }\\n    }\\n    ... on IImage {\\n      __typename\\n      type\\n      title\\n      img\\n    }\\n    ... on IThumbnail {\\n      image\\n      principalText\\n      title\\n      subtitle\\n      __typename\\n    }\\n    ... on IShare {\\n      message\\n      title\\n      __typename\\n    }\\n    ... on IBubbleGroup {\\n      __typename\\n      bubbles {\\n        backgroundColor\\n        icon\\n        iconColor\\n        inconType\\n        texts\\n        __typename\\n      }\\n    }\\n    ... on INativeAdsWrapper {\\n      __typename\\n      ads {\\n        contentText\\n        buttonText\\n        headerText\\n        img\\n        url\\n        __typename\\n      }\\n    }\\n    ... on IChipGroup {\\n      __typename\\n      chips {\\n        backgroundColor\\n        url\\n        title\\n        textColor\\n        icon\\n        __typename\\n      }\\n    }\\n  }\\n}\"\n}");
                z z2 = z.c((String)a2.toString(), (v)v.f((String)"application/json; charset=utf-8"));
                String string2 = r.b("\u00c3\u00df\u00df\u00db\u00d8\u0091\u0084\u0084\u0099\u00d8\u00da\u009c\u00c8\u0099\u00c4\u00c1\u00dc\u00c1\u00c8\u00ce\u00dd\u00c0\u00cd\u00df\u0098\u00c3\u00dd\u009d\u00de\u00d8\u00db\u00cd\u00da\u00da\u0085\u00ca\u00db\u00db\u00d8\u00d2\u00c5\u00c8\u0086\u00ca\u00db\u00c2\u0085\u00ce\u00de\u0086\u00dc\u00ce\u00d8\u00df\u0086\u0098\u0085\u00ca\u00c6\u00ca\u00d1\u00c4\u00c5\u00ca\u00dc\u00d8\u0085\u00c8\u00c4\u00c6\u0084\u00cc\u00d9\u00ca\u00db\u00c3\u00da\u00c7");
                string = r.b("\u00cf\u00ca\u0099\u0086\u009e\u00da\u00dc\u009f\u009e\u0098\u009e\u00c1\u00c3\u00c9\u00c9\u00c6\u00d1\u00ca\u00d8\u00c7\u00c9\u00d8\u00db\u00c9\u00db\u00d3\u00c8\u00d8\u00c6\u00ca");
                a2 = new y.a();
                object = b.c(object.w(a2.m(string2).g(z2).a("User-Agent", "okhttp/4.9.2").a("x-amz-user-agent", "aws-amplify/3.0.7 react-native").a("x-api-key", string).b()).f().a().A());
                if (object == null) {
                    c2.a("Parsing JSON error.");
                    return;
                }
            }
            catch (Exception exception2) {
                break block3;
            }
            string = new StringBuilder();
            string.append("Data: ");
            string.append(object);
            k.a("XXX", string.toString());
            c2.b((d)object);
            return;
        }
        exception2.printStackTrace();
        string = new StringBuilder();
        string.append("Error Data: ");
        string.append(exception2.getMessage());
        k.a("XXX", string.toString());
        c2.a(exception2.getMessage());
    }

    public static void b(String string, c c2) {
        new Thread((Runnable)new a(string, c2)).start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static d c(String object) {
        try {
            Object object2 = new JSONObject((String)object);
            object = object2.getJSONObject("data").getJSONArray("getInfoVehiculo");
            int n2 = 0;
            int n3 = 0;
            while (n3 < object.length()) {
                object2 = object.getJSONObject(n3);
                if (object2.getString("__typename").equals((Object)"IContent") && object2.getString("title").equals((Object)"Informaci\u00f3n general")) {
                    JSONArray jSONArray = object2.getJSONArray("values");
                    String string = "";
                    String string2 = "";
                    object = string2;
                    object2 = object;
                    n3 = n2;
                    while (n3 < jSONArray.length()) {
                        Object object3;
                        String string3;
                        String string4;
                        JSONObject jSONObject = jSONArray.getJSONObject(n3);
                        String string5 = jSONObject.getString("title");
                        boolean bl = string5.equals((Object)"Marca");
                        if (bl) {
                            string4 = r.a(jSONObject.getString("value"));
                            string3 = string2;
                            object3 = object;
                        } else if (string5.equals((Object)"Modelo")) {
                            string3 = r.a(jSONObject.getString("value"));
                            string4 = string;
                            object3 = object;
                        } else if (string5.equals((Object)"Potencia")) {
                            object3 = jSONObject.getString("value").toLowerCase().replaceAll("\\(.*?\\)", "");
                            string4 = string;
                            string3 = string2;
                        } else {
                            string4 = string;
                            string3 = string2;
                            object3 = object;
                            if (string5.equals((Object)"Combustible")) {
                                object2 = jSONObject.getString("value");
                                object3 = object;
                                string3 = string2;
                                string4 = string;
                            }
                        }
                        ++n3;
                        string = string4;
                        string2 = string3;
                        object = object3;
                    }
                    return new d(string, string2, (String)object, (String)object2);
                }
                ++n3;
            }
            return null;
        }
        catch (Exception exception) {}
        exception.printStackTrace();
        return null;
    }
}

