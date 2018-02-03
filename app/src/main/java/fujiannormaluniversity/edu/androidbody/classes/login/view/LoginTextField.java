package fujiannormaluniversity.edu.androidbody.classes.login.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import fujiannormaluniversity.edu.androidbody.R;

public class LoginTextField extends ConstraintLayout {
    public LoginTextField(Context context) {
        super(context);
        onLoadView(context);
    }


    public LoginTextField(Context context, AttributeSet attrs) {
        super(context, attrs);
        onLoadView(context);
    }

    public LoginTextField(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onLoadView(context);
    }


    private void onLoadView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.login_textfield,this);
    }
}
