package fujiannormaluniversity.edu.androidbody.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by alirezaahmadi on 2016/12/12AD.
 */

public abstract class OSHelper {

    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * hides soft keyboard if its open
     * @param activity
     */
    public static void hideKeyboard(AppCompatActivity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if(view == null) {
            view = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
