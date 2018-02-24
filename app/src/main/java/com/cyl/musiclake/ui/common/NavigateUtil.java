package com.cyl.musiclake.ui.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Pair;
import android.view.View;

import com.cyl.musiclake.R;
import com.cyl.musiclake.data.model.Playlist;
import com.cyl.musiclake.ui.music.local.fragment.AlbumDetailFragment;
import com.cyl.musiclake.ui.music.local.fragment.ArtistSongsFragment;
import com.cyl.musiclake.ui.music.local.fragment.FolderSongsFragment;
import com.cyl.musiclake.ui.music.local.fragment.LocalMusicFragment;
import com.cyl.musiclake.ui.music.local.fragment.LoveFragment;
import com.cyl.musiclake.ui.music.local.fragment.PlaylistDetailFragment;
import com.cyl.musiclake.ui.music.local.fragment.RecentlyFragment;
import com.cyl.musiclake.ui.music.online.fragment.DownloadFragment;

import java.io.File;

/**
 * Created by yonglong on 2016/12/24.
 * 导航工具类
 */

public class NavigateUtil {

    /**
     * 跳转到专辑
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void navigateToAlbum(Activity context, long albumID, String title, Pair<View, String> transitionViews) {

        FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        Fragment fragment;

        if (transitionViews != null) {
            Transition changeImage = TransitionInflater.from(context).inflateTransition(R.transition.image_transform);
            transaction.addSharedElement(transitionViews.first, transitionViews.second);
            fragment = AlbumDetailFragment.newInstance(albumID, title, transitionViews.second);
            fragment.setSharedElementEnterTransition(changeImage);
        } else {
            transaction.setCustomAnimations(R.anim.activity_fade_in,
                    R.anim.activity_fade_out, R.anim.activity_fade_in, R.anim.activity_fade_out);
            fragment = AlbumDetailFragment.newInstance(albumID, title, null);
        }
        transaction.hide(((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment_container));
        transaction.add(R.id.fragment_container, fragment);
        transaction.addToBackStack(title).commit();
    }

    /**
     * 跳转到专辑
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void navigateToArtist(Activity context, long artistID, String title, Pair<View, String> transitionViews) {
        FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        Fragment fragment;

        if (transitionViews != null) {
            Transition changeImage = TransitionInflater.from(context).inflateTransition(R.transition.image_transform);
            transaction.addSharedElement(transitionViews.first, transitionViews.second);
            fragment = ArtistSongsFragment.newInstance(artistID, title, transitionViews.second);
            fragment.setSharedElementEnterTransition(changeImage);
        } else {
            transaction.setCustomAnimations(R.anim.activity_fade_in,
                    R.anim.activity_fade_out, R.anim.activity_fade_in, R.anim.activity_fade_out);
            fragment = ArtistSongsFragment.newInstance(artistID, title, null);
        }
        transaction.hide(((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment_container));
        transaction.add(R.id.fragment_container, fragment);
        transaction.addToBackStack(title).commit();
    }


    public static void navigateToLocalMusic(Activity context, Pair<View, String> transitionViews) {
        FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        Fragment fragment;

        if (transitionViews != null) {
            transaction.addSharedElement(transitionViews.first, transitionViews.second);
            fragment = LocalMusicFragment.newInstance("local");
        } else {
//            transaction.setCustomAnimations(R.anim.activity_fade_in,
//                    R.anim.activity_fade_out, R.anim.activity_fade_in, R.anim.activity_fade_out);
            fragment = LocalMusicFragment.newInstance("local");
        }
        transaction.hide(((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment_container));
        transaction.add(R.id.fragment_container, fragment);
        transaction.addToBackStack(fragment.getTag()).commit();
    }

    public static void navigateToFolderSongs(Activity context, String path) {
        FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        Fragment fragment;

        fragment = FolderSongsFragment.newInstance(path);
        transaction.hide(((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment_container));
        transaction.add(R.id.fragment_container, fragment);
        transaction.addToBackStack(fragment.getTag()).commit();
    }

    public static void navigateRecentlyMusic(Activity context) {
        FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        Fragment fragment;
        fragment = RecentlyFragment.newInstance();
        transaction.hide(((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment_container));
        transaction.add(R.id.fragment_container, fragment);
        transaction.addToBackStack(fragment.getTag()).commit();
    }

    public static void navigateToLoveMusic(Activity context, Pair<View, String> transitionViews) {
        FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        Fragment fragment;

        fragment = LoveFragment.newInstance();
        transaction.hide(((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment_container));
        transaction.add(R.id.fragment_container, fragment);
        transaction.addToBackStack(fragment.getTag()).commit();
    }

    public static void navigateToDownload(Activity context, Pair<View, String> transitionViews) {
        FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        Fragment fragment;

        if (transitionViews != null) {
            transaction.addSharedElement(transitionViews.first, transitionViews.second);
            fragment = DownloadFragment.newInstance();
        } else {
//            transaction.setCustomAnimations(R.anim.activity_fade_in,
//                    R.anim.activity_fade_out, R.anim.activity_fade_in, R.anim.activity_fade_out);
            fragment = DownloadFragment.newInstance();
        }
//        transaction.hide(((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment_container));
        transaction.add(R.id.fragment_container, fragment);
        transaction.addToBackStack(fragment.getTag()).commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void navigateToPlaylist(Activity context, Playlist playlist, Pair<View, String> transitionViews) {
        FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        Fragment fragment;


        if (transitionViews != null) {

            Transition changeImage = TransitionInflater.from(context).inflateTransition(R.transition.image_transform);
            transaction.addSharedElement(transitionViews.first, transitionViews.second);
            fragment = PlaylistDetailFragment.newInstance(playlist, true, transitionViews.second);
            fragment.setSharedElementEnterTransition(changeImage);

        } else {
            transaction.setCustomAnimations(R.anim.activity_fade_in,
                    R.anim.activity_fade_out, R.anim.activity_fade_in, R.anim.activity_fade_out);
            fragment = PlaylistDetailFragment.newInstance(playlist, false, null);
        }
        transaction.hide(((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment_container));
        transaction.add(R.id.fragment_container, fragment);
        transaction.addToBackStack(fragment.getTag()).commit();
    }

    public static void scanFileAsync(Context ctx, String filePath) {
        Intent scanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        scanIntent.setData(Uri.fromFile(new File(filePath)));
        ctx.sendBroadcast(scanIntent);
    }
}