package fujiannormaluniversity.edu.androidbody.inputView;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import fujiannormaluniversity.edu.androidbody.R;
import fujiannormaluniversity.edu.androidbody.utils.OSHelper;

public class AEditText extends AppCompatEditText {



    public AEditText(Context context) {
        super(context);
    }

    public AEditText(Context context, AttributeSet attrs) {
        super(context,attrs);
        onCreateView(context,attrs);
    }

    public AEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onCreateView(context,attrs);
    }




    private void onCreateView(Context context, AttributeSet attrs) {
      onSetProperty(context);
    }

    private void onSetProperty(Context context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(null);
        }
        setMaxLines(1);
        setTextSize(14);
        setTextColor(OSHelper.getColor(context,R.color.text_3));
        setHintTextColor(OSHelper.getColor(context,R.color.text_placeholder));
        setGravity(Gravity.CENTER_HORIZONTAL);
    }


}
