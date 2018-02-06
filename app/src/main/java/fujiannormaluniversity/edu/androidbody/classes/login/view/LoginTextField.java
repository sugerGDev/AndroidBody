package fujiannormaluniversity.edu.androidbody.classes.login.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
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
            mInputWidget.setHint(typedArray.getString(R.styleable.LoginTextField_placeholder));
        }finally {
            typedArray.recycle();
        }
    }


    /**
     * 设置当前 keyboard 样式
     * @param inputType InputType 枚举类型
     * @param imeOptions EditorInfo 枚举类型
     */
    public void setEditTextKeyboardType(int inputType, int imeOptions) {

        mInputWidget.setInputType(inputType);
        mInputWidget.setImeOptions(imeOptions);
    }
}
