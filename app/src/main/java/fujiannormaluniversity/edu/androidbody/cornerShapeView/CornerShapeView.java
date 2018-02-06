package fujiannormaluniversity.edu.androidbody.cornerShapeView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.*;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import fujiannormaluniversity.edu.androidbody.R;
import static fujiannormaluniversity.edu.androidbody.utils.OSHelper.dip2px;
import static fujiannormaluniversity.edu.androidbody.utils.OSHelper.getColor;

public class CornerShapeView extends View {


    private int   mborderColor;
    private float mborderRadius;
    private float mborderWidth;


    private float mWidthSize;
    private float mHeightSize;

    private Paint mPaint;


    public CornerShapeView(Context context) {
       this(context,null);
    }

    public CornerShapeView(Context context, AttributeSet attrs) {
       this(context,attrs,0);
    }

    public CornerShapeView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context,attrs,defStyleAttr);
        onCreateView(context,attrs,defStyleAttr);
    }

    /**
     * 配置 CornerShapeView
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void onCreateView(Context context, AttributeSet attrs, int defStyleAttr) {


        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CornerShapeView);
        try {

            //获取所需的控件参数
            mborderRadius = typedArray.getDimension(R.styleable.CornerShapeView_borderRadius, dip2px(context,22.5f));
            mborderWidth = typedArray.getDimension(R.styleable.CornerShapeView_borderWidth, 1.f);
            mborderColor = typedArray.getColor(R.styleable.CornerShapeView_borderColor,getColor(context,R.color.border));



            mPaint = new Paint();
            mPaint.setAntiAlias(true);
            mPaint.setStrokeWidth(mborderWidth);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(mborderColor);


        }finally {
            typedArray.recycle();
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        // 画出圆角
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(0.f,0.f,mWidthSize,mHeightSize,mborderRadius,mborderRadius,mPaint);
        }else {
            canvas.drawRoundRect( new RectF(0.f,0.f,mWidthSize,mHeightSize),mborderRadius,mborderRadius,mPaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // 获取控件宽高
        mWidthSize = MeasureSpec.getSize(widthMeasureSpec);
        mHeightSize = MeasureSpec.getSize(heightMeasureSpec);

    }
}
