/*
 * Copyright (C) 2011 The Android Open Source Project
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

package com.UltimateImgSpider.app;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.OnMenuVisibilityListener;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import com.UltimateImgSpider.R;
import com.UltimateImgSpider.common.ApiHelper;

import java.util.ArrayList;

public class GalleryActionBar implements OnNavigationListener {
    @SuppressWarnings("unused")
    private static final String TAG = "GalleryActionBar";

    private ClusterRunner mClusterRunner;
    private CharSequence[] mTitles;
    private ArrayList<Integer> mActions;
    private Context mContext;
    private LayoutInflater mInflater;
    private AbstractGalleryActivity mActivity;
    private ActionBar mActionBar;
    private int mCurrentIndex;

    private AlbumModeAdapter mAlbumModeAdapter;
    private OnAlbumModeSelectedListener mAlbumModeListener;
    private int mLastAlbumModeSelected;
    private CharSequence [] mAlbumModes;
    public static final int ALBUM_FILMSTRIP_MODE_SELECTED = 0;
    public static final int ALBUM_GRID_MODE_SELECTED = 1;

    public interface ClusterRunner {
        public void doCluster(int id);
    }

    public interface OnAlbumModeSelectedListener {
        public void onAlbumModeSelected(int mode);
    }

    private static class ActionItem {
        public int action;
        public boolean enabled;
        public boolean visible;
        public int spinnerTitle;
        public int dialogTitle;
        public int clusterBy;

        public ActionItem(int action, boolean applied, boolean enabled, int title,
                int clusterBy) {
            this(action, applied, enabled, title, title, clusterBy);
        }

        public ActionItem(int action, boolean applied, boolean enabled, int spinnerTitle,
                int dialogTitle, int clusterBy) {
            this.action = action;
            this.enabled = enabled;
            this.spinnerTitle = spinnerTitle;
            this.dialogTitle = dialogTitle;
            this.clusterBy = clusterBy;
            this.visible = true;
        }
    }

    private class AlbumModeAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mAlbumModes.length;
        }

        @Override
        public Object getItem(int position) {
            return mAlbumModes[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.action_bar_two_line_text,
                        parent, false);
            }
            TwoLineListItem view = (TwoLineListItem) convertView;
            view.getText1().setText(mActionBar.getTitle());
            view.getText2().setText((CharSequence) getItem(position));
            return convertView;
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.action_bar_text,
                        parent, false);
            }
            TextView view = (TextView) convertView;
            view.setText((CharSequence) getItem(position));
            return convertView;
        }
    }


    public GalleryActionBar(AbstractGalleryActivity activity) {
        mActionBar = activity.getActionBar();
        mContext = activity.getAndroidContext();
        mActivity = activity;
        mInflater = ((Activity) mActivity).getLayoutInflater();
        mCurrentIndex = 0;
    }

    public int getHeight() {
        return mActionBar != null ? mActionBar.getHeight() : 0;
    }

    // The only use case not to hideMenu in this method is to ensure
    // all elements disappear at the same time when exiting gallery.
    // hideMenu should always be true in all other cases.
    public void disableClusterMenu(boolean hideMenu) {
        if (mActionBar != null) {
            mClusterRunner = null;
            if (hideMenu) {
                mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
            }
        }
    }

    public void onConfigurationChanged() {
        if (mActionBar != null && mAlbumModeListener != null) {
            OnAlbumModeSelectedListener listener = mAlbumModeListener;
        }
    }


    public void disableAlbumModeMenu(boolean hideMenu) {
        if (mActionBar != null) {
            mAlbumModeListener = null;
            if (hideMenu) {
                mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
            }
        }
    }


    @TargetApi(ApiHelper.VERSION_CODES.ICE_CREAM_SANDWICH)
    private void setHomeButtonEnabled(boolean enabled) {
        if (mActionBar != null) mActionBar.setHomeButtonEnabled(enabled);
    }

    public void setDisplayOptions(boolean displayHomeAsUp, boolean showTitle) {
        if (mActionBar == null) return;
        int options = 0;
        if (displayHomeAsUp) options |= ActionBar.DISPLAY_HOME_AS_UP;
        if (showTitle) options |= ActionBar.DISPLAY_SHOW_TITLE;

        mActionBar.setDisplayOptions(options,
                ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_TITLE);
        mActionBar.setHomeButtonEnabled(displayHomeAsUp);
    }

    public void setTitle(String title) {
        if (mActionBar != null) mActionBar.setTitle(title);
    }

    public void setTitle(int titleId) {
        if (mActionBar != null) {
            mActionBar.setTitle(mContext.getString(titleId));
        }
    }

    public void setSubtitle(String title) {
        if (mActionBar != null) mActionBar.setSubtitle(title);
    }

    public void show() {
        if (mActionBar != null) mActionBar.show();
    }

    public void hide() {
        if (mActionBar != null) mActionBar.hide();
    }

    public void addOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        if (mActionBar != null) mActionBar.addOnMenuVisibilityListener(listener);
    }

    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        if (mActionBar != null) mActionBar.removeOnMenuVisibilityListener(listener);
    }


    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {

        return false;
    }

    private Menu mActionBarMenu;
    private ShareActionProvider mSharePanoramaActionProvider;
    private ShareActionProvider mShareActionProvider;
    private Intent mSharePanoramaIntent;
    private Intent mShareIntent;

    public void createActionBarMenu(int menuRes, Menu menu) {
        mActivity.getMenuInflater().inflate(menuRes, menu);
        mActionBarMenu = menu;

        MenuItem item = menu.findItem(R.id.action_share_panorama);
        if (item != null) {
            mSharePanoramaActionProvider = (ShareActionProvider)
                item.getActionProvider();
            mSharePanoramaActionProvider
                .setShareHistoryFileName("panorama_share_history.xml");
            mSharePanoramaActionProvider.setShareIntent(mSharePanoramaIntent);
        }

        item = menu.findItem(R.id.action_share);
        if (item != null) {
            mShareActionProvider = (ShareActionProvider)
                item.getActionProvider();
            mShareActionProvider
                .setShareHistoryFileName("share_history.xml");
            mShareActionProvider.setShareIntent(mShareIntent);
        }
    }

    public Menu getMenu() {
        return mActionBarMenu;
    }

    public void setShareIntents(Intent sharePanoramaIntent, Intent shareIntent,
        ShareActionProvider.OnShareTargetSelectedListener onShareListener) {
        mSharePanoramaIntent = sharePanoramaIntent;
        if (mSharePanoramaActionProvider != null) {
            mSharePanoramaActionProvider.setShareIntent(sharePanoramaIntent);
        }
        mShareIntent = shareIntent;
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
            mShareActionProvider.setOnShareTargetSelectedListener(
                onShareListener);
        }
    }
}
