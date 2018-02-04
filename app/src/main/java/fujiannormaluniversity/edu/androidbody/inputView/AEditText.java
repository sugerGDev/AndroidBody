package fujiannormaluniversity.edu.androidbody.inputView;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import fujiannormaluniversity.edu.androidbody.R;

public class AEditText extends ConstraintLayout {

    private EditText mEditText;


    public AEditText(Context context) {
        this(context, null);
    }

    public AEditText(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public AEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);



        onCreateView(context);
    }

    private void onCreateView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.activity_edittext,this);
        mEditText = (EditText) findViewById(R.id.activity_edittext);
    }

    /**
     * 设置 placeholder 内容
     * @param placeholder 指定placeholder
     */
    public void setPlaceholder(String placeholder){
        mEditText.setHint(placeholder);
    }


    /**
     * 获取输入控件
     * @return 获取EditText对象
     */
    public EditText getmEditText() {
        return mEditText;
    }
}
