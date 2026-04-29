/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Base64
 *  java.io.BufferedReader
 *  java.io.ByteArrayInputStream
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URL
 *  java.nio.charset.StandardCharsets
 *  java.security.KeyStore
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateFactory
 *  java.security.cert.X509Certificate
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.regex.Pattern
 *  javax.net.ssl.HttpsURLConnection
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManagerFactory
 *  javax.net.ssl.X509TrustManager
 */
package w2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import r2.k;
import w2.b;
import w2.c;
import w2.d;
import w2.e;

public abstract class f {
    private static final ExecutorService a = Executors.newSingleThreadExecutor();
    private static final Handler b = new Handler(Looper.getMainLooper());
    private static SSLSocketFactory c = null;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void a(String object, a a2) {
        Exception exception2;
        block5: {
            Object object2;
            Object object3;
            try {
                object3 = new StringBuilder();
                object3.append("https://sede.dgt.gob.es/es/vehiculos/informacion-de-vehiculos/distintivo-ambiental/index.html?matricula=");
                object3.append((String)object);
                object2 = new URL(object3.toString());
                object3 = (HttpsURLConnection)object2.openConnection();
                object3.setSSLSocketFactory(f.g());
                object3.setRequestMethod("GET");
                object3.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
                object3.setConnectTimeout(15000);
                object3.setReadTimeout(15000);
                int n2 = object3.getResponseCode();
                if (n2 != 200) {
                    object2 = b;
                    object = new d(a2, n2);
                    object2.post((Runnable)object);
                    return;
                }
                object2 = new InputStreamReader(object3.getInputStream(), StandardCharsets.UTF_8);
                object = new BufferedReader((Reader)object2);
                object2 = new StringBuilder();
                while ((object3 = object.readLine()) != null) {
                    object2.append((String)object3);
                }
            }
            catch (Exception exception2) {
                break block5;
            }
            object.close();
            object = object2.toString();
            object = Pattern.compile((String)"<p[^>]*class=[^>]*my-auto[^>]*>(.*?)</p>", (int)34).matcher((CharSequence)object);
            if (object.find()) {
                object3 = object.group(1).replaceAll("<[^>]*>", "").trim();
                object = b;
                object2 = new b(a2, (String)object3);
                object.post((Runnable)object2);
                return;
            }
            object2 = b;
            object = new c(a2);
            object2.post((Runnable)object);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error: ");
        stringBuilder.append(exception2.getMessage());
        k.a("XXX_DGT", stringBuilder.toString());
        b.post((Runnable)new e(a2, exception2));
    }

    public static /* synthetic */ void b(a a2, String string) {
        a2.b(string);
    }

    public static /* synthetic */ void c(a a2) {
        a2.a("No se encontr\u00f3 el elemento en la web de la DGT");
    }

    public static /* synthetic */ void d(a a2, Exception exception) {
        a2.a(exception.getMessage());
    }

    public static /* synthetic */ void e(a a2, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error de servidor: ");
        stringBuilder.append(n2);
        a2.a(stringBuilder.toString());
    }

    public static void f(Context context, String string, a a2) {
        a.execute((Runnable)new w2.a(string, a2));
    }

    private static SSLSocketFactory g() {
        SSLSocketFactory sSLSocketFactory = c;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        sSLSocketFactory = new ByteArrayInputStream(Base64.decode((String)"MIIFgzCCA2ugAwIBAgIPXZONMGc2yAYdGsdUhGkHMA0GCSqGSIb3DQEBCwUAMDsxCzAJBgNVBAYTAkVTMREwDwYDVQQKDAhGTk1ULVJDTTEZMBcGA1UECwwQQUMgUkFJWiBGTk1ULVJDTTAeFw0wODEwMjkxNTU5NTZaFw0zMDAxMDEwMDAwMDBaMDsxCzAJBgNVBAYTAkVTMREwDwYDVQQKDAhGTk1ULVJDTTEZMBcGA1UECwwQQUMgUkFJWiBGTk1ULVJDTTCCAiIwDQYJKoZIhvcNAQEBBQADggIPADCCAgoCggIBALpxgHpMhm5/yBNtwMZ9HACXjywMI7sQmkCpGreHiPibVmr75nuOi5KOpyVdWRHbNi63URcfqQgfBBckWKo3Shjf5TnUV/3XwSyRAZHiItQDwFj8d0fsjz50Q7qsNI1NOHZnjrDIbzAzWHFctPVrbtQBULgTfmxKo0nRIBnuvMApGGWn3v7v3QqQIecaZ5JCEJhfTzC8PhxFtBDXaEAUwED653cXeuYLj2VbPNmaUtu1vZ5Gzz3rkQUCwJaydkxNEJY7kvqcfw+Z374jNUUeAlz+taibmSXaXvMiwzn15Cou08YfxGyqxRxqAQVKL9LFwag0Jl1mpdICIfkYtwb1TplvqKtMUejPUBjFd8g5CSxJkjKZqLsXF3mwWsXmo8RZZUc1g16p6DULmbvkzSDGm0oGObVo/CK67lWMK07q87Hj/LaZmtVC+nFNCM+HHmpxffnTtOmlcYF7wk5HlqX2doWjKI/pgG6BU6VtX7hI+cL5NqYuSf+4lsKMB7ObiFj86xsc3i1w4peSMKGJ47xVqCfWS+2QrYv6YyVZLag13cqXM7zlzced0ezvXg5KkAYmY6252TUtB7p2ZSysV4999AeU14ECll2jB0nVetBX+RvnU0Z1qrB5QstocQjpYL05ac70r8NWQMetUqIJ5G+GR4of6ygnXYMgrwTJbFaai0b1AgMBAAGjgYMwgYAwDwYDVR0TAQH/BAUwAwEB/zAOBgNVHQ8BAf8EBAMCAQYwHQYDVR0OBBYEFPd9xf3E6Jobd2Sn9R2gzL+HYJptMD4GA1UdIAQ3MDUwMwYEVR0gADArMCkGCCsGAQUFBwIBFh1odHRwOi8vd3d3LmNlcnQuZm5tdC5lcy9kcGNzLzANBgkqhkiG9w0BAQsFAAOCAgEAB5BK3/MjTvDDnFFlm5wioooMhfNzKWtN/gHiqQxjAb8EZ6WdmF/9ARP67Jpi6Yb+tmLSbkyU+8B1RXxlDPiyN8+sD8+Nb/kZ94/sHvJwnvDKuO+3/3Y3dlv2bojzr2IyIpMNOmqOFGYMLVN0V2Ue1bLdI4E7pWYjJ2cJj+F3qkPNZVEI7VFY/uY5+ctHhKQV8Xa7pO6kO8Rf77IzlhEYt8llvhjho6Tc+hj507wTmzl6NLrTQfv6MooqtyuGC2mDOL7Nii4LcK2NJpLuHvUBKwrZ1pebbuCoGRw6IYsMHkCtA+fdZn71uSANA+iW+YJF1DngoABd15jmfZ5nc8OaKveri6E6FO80vFIOiZiaBECEHX5FaZNXzuvO+FB8TxxuBEOb+dY7Ixjp6o7RTUaN8Tvkasq6+yO3m/qZASlaWFot4/nUbQ4mrcFuNLwy+AwF+mWj2zs3gyLp1txyM/1d8iC9djwj2ij3+RvrWWTV3F9yfiD8zYm1kGdNYno/Tq0dwzn+evQoFt9B9kiABdcPUXmsEKvU7ANm5mqwujGSQkBqvjrTcuFqN1W8rB2Vt2lh8kORdOag0wokRqEIr9baRRmW1FMdW4R58MD3R++Lj8UGrp1MYp3/RgT408m2ECVAdf4WqslKYIYvuu8wd+RU4riEmViAqhOLUTpPSPaLtrM=", (int)0));
        X509Certificate x509Certificate = (X509Certificate)CertificateFactory.getInstance((String)"X.509").generateCertificate((InputStream)sSLSocketFactory);
        sSLSocketFactory = TrustManagerFactory.getInstance((String)TrustManagerFactory.getDefaultAlgorithm());
        sSLSocketFactory.init(null);
        X509TrustManager x509TrustManager = (X509TrustManager)sSLSocketFactory.getTrustManagers()[0];
        sSLSocketFactory = KeyStore.getInstance((String)KeyStore.getDefaultType());
        sSLSocketFactory.load(null, null);
        sSLSocketFactory.setCertificateEntry("dgt_cert", (Certificate)x509Certificate);
        X509Certificate[] x509CertificateArray = x509TrustManager.getAcceptedIssuers();
        int n2 = x509CertificateArray.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            x509TrustManager = x509CertificateArray[i2];
            x509Certificate = new StringBuilder();
            x509Certificate.append("system_cert_");
            x509Certificate.append(n3);
            sSLSocketFactory.setCertificateEntry(x509Certificate.toString(), (Certificate)x509TrustManager);
            ++n3;
        }
        x509Certificate = TrustManagerFactory.getInstance((String)TrustManagerFactory.getDefaultAlgorithm());
        x509Certificate.init((KeyStore)sSLSocketFactory);
        sSLSocketFactory = SSLContext.getInstance((String)"TLS");
        sSLSocketFactory.init(null, x509Certificate.getTrustManagers(), null);
        c = sSLSocketFactory = sSLSocketFactory.getSocketFactory();
        return sSLSocketFactory;
    }
}

