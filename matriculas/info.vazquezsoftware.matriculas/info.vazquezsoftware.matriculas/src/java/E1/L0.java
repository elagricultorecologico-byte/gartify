/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecInfo$CodecProfileLevel
 *  android.media.MediaCodecList
 *  android.util.Range
 *  java.lang.Integer
 *  java.lang.LinkageError
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package e1;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class l0 {
    private static final Map a = new HashMap();
    private static List b;
    private static final Object c;

    static {
        c = new Object();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static List a(String var0) {
        block22: {
            block21: {
                block20: {
                    block19: {
                        var11_3 = var4_2 = l0.c;
                        // MONITORENTER : var11_3
                        var3_4 = l0.a;
                        if (var3_4.containsKey((Object)var0)) {
                            var0 = (List)var3_4.get((Object)var0);
                            // MONITOREXIT : var11_3
                            return var0;
                        }
                        var11_3 = var4_2;
                        // MONITORENTER : var11_3
                        try {
                            if (l0.b == null) break block19;
                            // MONITOREXIT : var11_3
                            break block20;
                        }
                        catch (Throwable var3_5) {
                            break block21;
                        }
                    }
                    var3_4 = new MediaCodecList(0);
                    l0.b = Arrays.asList((Object[])var3_4.getCodecInfos());
                    // MONITOREXIT : var11_3
                }
                var3_4 = new ArrayList();
                var5_9 = l0.b.iterator();
            }
            throw var3_5;
            while (true) {
                if (!var5_9.hasNext()) ** GOTO lbl-1000
                var7_13 = (MediaCodecInfo)var5_9.next();
                if (var7_13.isEncoder() || !Arrays.asList((Object[])var7_13.getSupportedTypes()).contains((Object)var0)) continue;
                var6_12 = new HashMap();
                var6_12.put((Object)"codecName", (Object)var7_13.getName());
                var7_13 = var7_13.getCapabilitiesForType(var0);
                var10_16 = new ArrayList();
                var8_14 = var7_13.profileLevels;
                var2_11 = ((MediaCodecInfo.CodecProfileLevel[])var8_14).length;
                ** GOTO lbl49
lbl-1000:
                // 1 sources

                {
                    l0.a.put((Object)var0, (Object)var3_4);
                    // MONITOREXIT : var11_3
                    return var3_4;
lbl49:
                    // 2 sources

                    for (var1_10 = 0; var1_10 < var2_11; ++var1_10) {
                        var9_15 = var8_14[var1_10];
                        var10_16.add((Object)new Integer[]{var9_15.profile, var9_15.level});
                        continue;
                    }
                    ** try [egrp 5[TRYBLOCK] [17, 16, 15 : 267->441)] { 
lbl56:
                    // 1 sources

                    var6_12.put((Object)"profileLevels", (Object)var10_16);
                    var8_14 = var7_13.getVideoCapabilities();
                    if (var8_14 != null) {
                        var6_12.put((Object)"bitRatesBps", (Object)l0.b(var8_14.getBitrateRange()));
                        var6_12.put((Object)"widthAlignment", (Object)var8_14.getWidthAlignment());
                        var6_12.put((Object)"heightAlignment", (Object)var8_14.getHeightAlignment());
                        var6_12.put((Object)"frameRates", (Object)l0.b(var8_14.getSupportedFrameRates()));
                        var6_12.put((Object)"widths", (Object)l0.b(var8_14.getSupportedWidths()));
                        var6_12.put((Object)"heights", (Object)l0.b(var8_14.getSupportedHeights()));
                    }
                    var6_12.put((Object)"instancesLimit", (Object)var7_13.getMaxSupportedInstances());
                    var3_4.add((Object)var6_12);
                    continue;
                }
                break;
            }
lbl77:
            // 5 sources

            catch (LinkageError var3_6) {
                break block22;
            }
lbl79:
            // 5 sources

            catch (RuntimeException var3_7) {}
        }
        var5_9 = new HashMap();
        var5_9.put((Object)"error", (Object)var3_8.getClass().getSimpleName());
        var3_8 = new ArrayList();
        var3_8.add((Object)var5_9);
        l0.a.put((Object)var0, (Object)var3_8);
        // MONITOREXIT : var11_3
        return var3_8;
    }

    private static Integer[] b(Range range) {
        return new Integer[]{(Integer)range.getLower(), (Integer)range.getUpper()};
    }
}

