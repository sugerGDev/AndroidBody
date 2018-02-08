package fujiannormaluniversity.edu.androidbody.classes.login.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import fujiannormaluniversity.edu.androidbody.R;

public class LoginTextField extends ConstraintLayout {

    private TextView mTitle;
    private AEditText mInputWidget;
    private ASendSMSButton mSendSMSButton;

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

            // 存在sms button
            boolean smsbtn = typedArray.getBoolean(R.styleable.LoginTextField_smsbtn,false);
            if ( smsbtn ){
                setSMSButtonClickListener();
            }

        }catch (Exception e) {
            e.printStackTrace();

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


    /**
     * 设置当前发送验证码按钮为有效
     */
    private void setSMSButtonClickListener(){
        mSendSMSButton = (ASendSMSButton)findViewById(R.id.login_textfield_sendsms);
        mSendSMSButton.setVisibility(View.VISIBLE);
        mSendSMSButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mSendSMSButton.Start();
            }
        });

    }
}
