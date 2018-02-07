package fujiannormaluniversity.edu.androidbody.navigationbar;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import fujiannormaluniversity.edu.androidbody.R;

public class ANavigationBar extends ConstraintLayout {

    private TextView titleTextView;
    private TextDrawable backButton;

    public ANavigationBar(Context context) {
      this(context,null);
    }

    public ANavigationBar(Context context, AttributeSet attrs) {
       this(context,attrs,0);
    }

    public ANavigationBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.onLoadView(context);
    }


    /**
     * 设置返回按钮侦听事件
     * @param onClickListener
     */
    public void setBackButtonTapListener(OnClickListener onClickListener) {
        this.backButton.setOnClickListener(onClickListener);
    }

    /**
     * 设置标题文字
     * @param string
     */
    public void  setTitleValue(String string) {
        this.titleTextView.setText(string);
    }

    /**
     * 加载View对象
     * @param context object
     */
    private void onLoadView(Context context) {

        LayoutInflater.from(context).inflate(R.layout.activity_navigaitionbar, this);
        titleTextView = (TextView)findViewById(R.id.navigaiontitle);
//        backButton = (TextDrawable)findViewById(R.id.backbtn);

    }
}
