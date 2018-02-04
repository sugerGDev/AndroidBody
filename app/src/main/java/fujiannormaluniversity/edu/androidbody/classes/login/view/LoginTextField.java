package fujiannormaluniversity.edu.androidbody.classes.login.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import fujiannormaluniversity.edu.androidbody.R;
import fujiannormaluniversity.edu.androidbody.inputView.AEditText;

public class LoginTextField extends ConstraintLayout {

    private TextView mTitle;
    private AEditText mInputWidget;

    public LoginTextField(Context context) {
        this(context,null);
    }


    public LoginTextField(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public LoginTextField(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onCreateView(context);
        onSetProperty(context, attrs);

    }


    private void onCreateView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.login_textfield,this);
        mTitle  = (TextView)findViewById(R.id.login_textfield_title);
        mInputWidget  = (AEditText)findViewById(R.id.login_textfield_inputWidge);

    }

    private void onSetProperty(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoginTextField);
        try {
            mTitle.setText(typedArray.getString(R.styleable.LoginTextField_title));
            mInputWidget.setPlaceholder(typedArray.getString(R.styleable.LoginTextField_placeholder));
        }finally {
            typedArray.recycle();
        }
    }


    /**
     * 获取 输入控件
     * @return  AEditText 对象
     */
    public AEditText getmInputWidget() {
        return mInputWidget;
    }
}
