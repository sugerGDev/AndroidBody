package fujiannormaluniversity.edu.androidbody.classes.login.action;

/**
 * 定义计时器侦听事件
 */
 public interface ATimerEventListener{

    /**
     * 计时器走的事件回调
     * @param sec 秒
     */
    void onTickTimer(long sec);

    /**
     * 计时器暂停事件回调
     * @param sec 秒
     */
    void onTickPause(long sec);

    /**
     * 计时器完成事件
     */
    void onTickFinish();
}
