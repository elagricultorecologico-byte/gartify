/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.Retention
 *  java.lang.annotation.RetentionPolicy
 */
package org.chromium.support_lib_boundary;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface;

public interface WebMessagePayloadBoundaryInterface
extends FeatureFlagHolderBoundaryInterface {
    public byte[] getAsArrayBuffer();

    public String getAsString();

    public int getType();

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface WebMessagePayloadType {
        public static final int TYPE_ARRAY_BUFFER = 1;
        public static final int TYPE_STRING = 0;
    }
}

