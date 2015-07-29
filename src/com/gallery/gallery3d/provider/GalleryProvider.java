/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gallery.gallery3d.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore.Images.ImageColumns;
import android.util.Log;

import com.gallery.gallery3d.app.GalleryApp;
import com.gallery.gallery3d.common.AsyncTaskUtil;
import com.gallery.gallery3d.common.Utils;
import com.gallery.gallery3d.data.DataManager;
import com.gallery.gallery3d.data.MediaItem;
import com.gallery.gallery3d.data.MediaObject;
import com.gallery.gallery3d.data.Path;
import com.gallery.gallery3d.util.GalleryUtils;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GalleryProvider extends ContentProvider {
    private static final String TAG = "GalleryProvider";

    public static final String AUTHORITY = "com.gallery.gallery3d.provider";
    public static final Uri BASE_URI = Uri.parse("content://" + AUTHORITY);

    private DataManager mDataManager;
    private static Uri sBaseUri;

    public static String getAuthority(Context context) {
        return context.getPackageName() + ".provider";
    }

    public static Uri getUriFor(Context context, Path path) {
        if (sBaseUri == null) {
            sBaseUri = Uri.parse("content://" + context.getPackageName() + ".provider");
        }
        return sBaseUri.buildUpon()
                .appendEncodedPath(path.toString().substring(1)) // ignore the leading '/'
                .build();
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException();
    }

    // TODO: consider concurrent access
    @Override
    public String getType(Uri uri) {
        long token = Binder.clearCallingIdentity();
        try {
            Path path = Path.fromString(uri.getPath());
            MediaItem item = (MediaItem) mDataManager.getMediaObject(path);
            return item != null ? item.getMimeType() : null;
        } finally {
            Binder.restoreCallingIdentity(token);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean onCreate() {
        GalleryApp app = (GalleryApp) getContext().getApplicationContext();
        mDataManager = app.getDataManager();
        return true;
    }

    // TODO: consider concurrent access
    @Override
    public Cursor query(Uri uri, String[] projection,
            String selection, String[] selectionArgs, String sortOrder) {
        long token = Binder.clearCallingIdentity();
        try {
            Path path = Path.fromString(uri.getPath());
            MediaObject object = mDataManager.getMediaObject(path);
            if (object == null) {
                Log.w(TAG, "cannot find: " + uri);
                return null;
            }
            
            return null;
        } finally {
            Binder.restoreCallingIdentity(token);
        }
    }

    @Override
    public ParcelFileDescriptor openFile(Uri uri, String mode)
            throws FileNotFoundException {
        long token = Binder.clearCallingIdentity();
        try {
            if (mode.contains("w")) {
                throw new FileNotFoundException("cannot open file for write");
            }
            Path path = Path.fromString(uri.getPath());
            MediaObject object = mDataManager.getMediaObject(path);
            if (object == null) {
                throw new FileNotFoundException(uri.toString());
            }
            
            throw new FileNotFoundException("unspported type: " + object);
        } finally {
            Binder.restoreCallingIdentity(token);
        }
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException();
    }

    private static interface PipeDataWriter<T> {
        void writeDataToPipe(ParcelFileDescriptor output, T args);
    }

    // Modified from ContentProvider.openPipeHelper. We are target at API LEVEL 10.
    // But openPipeHelper is available in API LEVEL 11.
    private static <T> ParcelFileDescriptor openPipeHelper(
            final T args, final PipeDataWriter<T> func) throws FileNotFoundException {
        try {
            final ParcelFileDescriptor[] pipe = ParcelFileDescriptor.createPipe();
            AsyncTask<Object, Object, Object> task = new AsyncTask<Object, Object, Object>() {
                @Override
                protected Object doInBackground(Object... params) {
                    try {
                        func.writeDataToPipe(pipe[1], args);
                        return null;
                    } finally {
                        Utils.closeSilently(pipe[1]);
                    }
                }
            };
            AsyncTaskUtil.executeInParallel(task, (Object[]) null);
            return pipe[0];
        } catch (IOException e) {
            throw new FileNotFoundException("failure making pipe");
        }
    }

}
