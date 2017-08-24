package xyz.designabc.mystique.util.transition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;

import xyz.designabc.mystique.R;

/**
 * Authored by vipulkumar on 22/06/17.
 */

public class TransitionUtils {

    //For Cards
    public static void setupGalleryImageEnterTransition(@NonNull Activity activity, View container) {
        if (!DeviceUtil.isPreLollipopDevice()) {
            if (!CardTransform.setup(activity, container)) {
                MorphTransform.setup(activity, container,
                        ContextCompat.getColor(activity, R.color.background_regular),
                        activity.getResources().getDimensionPixelSize(R.dimen.spacing_large));
            }
        }
    }

    //For Cards
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static ActivityOptions getGalleryImageExitTransitionBundle(@NonNull Activity activity, @NonNull Intent intent, View view) {
        CardTransform.addExtras(intent, ContextCompat.getColor(
                activity, R.color.white), 0);
        return ActivityOptions.makeSceneTransitionAnimation(
                activity, view, ViewCompat.getTransitionName(view));
    }

    //For Fab
    public static void setupFabEnterTransition(@NonNull Activity activity, View container) {
        if (!DeviceUtil.isPreLollipopDevice()) {
            if (!FabTransform.setup(activity, container)) {
                MorphTransform.setup(activity, container,
                        ContextCompat.getColor(activity, R.color.background_regular),
                        activity.getResources().getDimensionPixelSize(R.dimen.spacing_large));
            }
        }
    }

    //For Fab
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static ActivityOptions getFabExitTransitionBundle(@NonNull Activity activity, @NonNull Intent intent, View view) {
        FabTransform.addExtras(intent, ContextCompat.getColor(
                activity, R.color.colorPrimary), R.drawable.ic_person_black_24dp);
        return ActivityOptions.makeSceneTransitionAnimation(
                activity, view, ViewCompat.getTransitionName(view));
    }
}
