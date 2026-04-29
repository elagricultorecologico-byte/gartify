/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.ParcelFileDescriptor
 *  java.lang.Object
 *  java.lang.String
 */
package org.chromium.support_lib_boundary;

import android.content.ContentProvider;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;

public interface DropDataContentProviderBoundaryInterface {
    public Uri cache(byte[] var1, String var2, String var3);

    public Bundle call(String var1, String var2, Bundle var3);

    public String[] getStreamTypes(Uri var1, String var2);

    public String getType(Uri var1);

    public boolean onCreate();

    public void onDragEnd(boolean var1);

    public ParcelFileDescriptor openFile(ContentProvider var1, Uri var2);

    public Cursor query(Uri var1, String[] var2, String var3, String[] var4, String var5);

    public void setClearCachedDataIntervalMs(int var1);
}

