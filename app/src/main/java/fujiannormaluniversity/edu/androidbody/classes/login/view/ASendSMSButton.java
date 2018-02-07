package fujiannormaluniversity.edu.androidbody.classes.login.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import fujiannormaluniversity.edu.androidbody.R;
import fujiannormaluniversity.edu.androidbody.classes.login.action.ATimer;
import fujiannormaluniversity.edu.androidbody.classes.login.action.ATimerEventListener;
import fujiannormaluniversity.edu.androidbody.utils.OSHelper;


public class ASendSMSButton extends AppCompatButton {


    private ATimer aTimer;

    public ASendSMSButton(Context context) {
        super(context);
    }

    public ASendSMSButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        onCreateView(context,attrs);
    }

    public ASendSMSButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onCreateView(context,attrs);

    }



    private void onCreateView(Context context, AttributeSet attrs) {
        onSetProperty(context);
        onInitTimer();

    }

    public void Start(){
        aTimer.Start(60000);
        setClickable(false);
    }

    public void Stop(){
        aTimer.Stop();
        setClickable(true);
    }

    /**
     * 设置相关属性
     * @param context 当前上下文
     */
    private void onSetProperty(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(null);
        }

        setTextColor(OSHelper.getColor(context, R.color.main));
        setTextSize(14);
        setGravity(Gravity.RIGHT);
    }


    /**
     * 初始化计时器
     */
    private void onInitTimer() {
        aTimer = new ATimer(60000,1000);
        aTimer.setTimerEventListener(new ATimerEventListener() {
            @Override
            public void onTickTimer(long sec) {
                setText(String.format("%s秒", Long.toString(sec)));
            }

            @Override
            public void onTickPause(long sec) {

            }

            @Override
            public void onTickFinish() {
                setText("重新发送");
                setClickable(true);
            }
        });




        final Handler handler = new Handler();
        final Runnable counter = new Runnable(){

            public void run(){
                handler.postDelayed(this, 900);
            }
        };

        handler.postDelayed(counter, 900);
    }

}
