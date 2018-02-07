package fujiannormaluniversity.edu.androidbody.classes.login.action;

import android.app.PendingIntent;
import android.os.Handler;
import android.util.Log;


public class ATimer {

    private long millisInFuture;
    private long countDownInterval;
    private boolean status;
    private  ATimerEventListener eventListener;


    public ATimer(long pMillisInFuture, long pCountDownInterval) {

        this.millisInFuture = pMillisInFuture;
        this.countDownInterval = pCountDownInterval;
        status = false;
    }

    public void Stop() {
        status = false;
    }

    public long getCurrentTime() {
        return millisInFuture;
    }

    public void Start(long pMillisInFuture) {
        this.millisInFuture = pMillisInFuture;
        status = true;
        Initialize();
    }

    public void setTimerEventListener(ATimerEventListener pEventListener) {
        if (pEventListener != null) {
            this.eventListener = pEventListener;
        }
    }


    private void Initialize()
    {
        final Handler handler = new Handler();
        Log.v("status", "starting");
        final Runnable counter = new Runnable(){

            public void run(){
                long sec = millisInFuture/1000;
                if(status) {
                    if(millisInFuture <= 0) {
                        status = false; // 停止，设置标志为False
                        Log.v("status", "done");
                        eventListener.onTickFinish();

                    } else {
                        Log.v("status", Long.toString(sec) + " seconds remain");
                        eventListener.onTickTimer(sec);

                        millisInFuture -= countDownInterval;
                        handler.postDelayed(this, countDownInterval);
                    }
                } else {
                    Log.v("status", Long.toString(sec) + " seconds remain and timer has stopped!");
                    eventListener.onTickPause(sec);
                    handler.postDelayed(this, countDownInterval);
                }
            }


        };

        handler.postDelayed(counter, countDownInterval);
    }
}
