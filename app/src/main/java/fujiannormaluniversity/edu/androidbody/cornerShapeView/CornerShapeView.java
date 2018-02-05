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

public class CornerShapeView extends View {


    private int   mborderColor;
    private float mborderRadius;
    private float mborderWidth;
    private float mborderXRadius;
    private float mborderYRadius;


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
            mborderWidth = typedArray.getDimension(R.styleable.CornerShapeView_borderWidth, 0.5f);
            mborderColor = typedArray.getColor(R.styleable.CornerShapeView_borderColor,Color.parseColor("#e2e2e2"));
            mborderXRadius = typedArray.getDimension(R.styleable.CornerShapeView_borderXRadius, dip2px(context,-1.f));
            mborderYRadius = typedArray.getDimension(R.styleable.CornerShapeView_borderYRadius, dip2px(context,-1.f));



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

        float rx = mborderXRadius == -1.f ? mborderRadius : mborderXRadius;
        float ry = mborderYRadius == -1.f ? mborderRadius : mborderYRadius;


        // 画出圆角
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(0.f,0.f,mWidthSize,mHeightSize,rx,ry,mPaint);
        }else {
            canvas.drawRoundRect( new RectF(0.f,0.f,mWidthSize,mHeightSize),rx,ry,mPaint);
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
