/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.annotation.Retention
 *  java.lang.annotation.RetentionPolicy
 */
package org.chromium.support_lib_boundary;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.SOURCE)
public @interface PrefetchStatusCodeBoundaryInterface {
    public static final int FAILURE = 1;
    public static final int SUCCESS = 0;
}

