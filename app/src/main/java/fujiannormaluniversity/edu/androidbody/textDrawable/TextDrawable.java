package fujiannormaluniversity.edu.androidbody.textDrawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import fujiannormaluniversity.edu.androidbody.*;


import static fujiannormaluniversity.edu.androidbody.utils.OSHelper.dip2px;

public class TextDrawable extends android.support.v7.widget.AppCompatTextView {

    private Drawable drawableLeft;
    private Drawable drawableRight;
    private Drawable drawableTop;

    private int leftWidth;
    private int rightWidth;
    private int topWidth;
    private int leftHeight;
    private int rightHeight;
    private int topHeight;

    private Context mContext;

    public TextDrawable(Context context) {
        this(context,null,0);

    }

    public TextDrawable(Context context, AttributeSet attrs) {
        this(context,attrs,0);

    }

    public TextDrawable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        this.mContext = context;
        this.onCreate(context,attrs);
        this.onDrawableWithBounds();
    }



    private void onCreate(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextDrawable);

        try {

            drawableLeft = typedArray.getDrawable(R.styleable.TextDrawable_leftDrawable);
            drawableRight = typedArray.getDrawable(R.styleable.TextDrawable_rightDrawable);
            drawableTop = typedArray.getDrawable(R.styleable.TextDrawable_topDrawable);

            if (drawableLeft != null) {
                leftWidth = typedArray.getDimensionPixelOffset(R.styleable.TextDrawable_leftDrawableWidth, dip2px(context, 20));
                leftHeight = typedArray.getDimensionPixelOffset(R.styleable.TextDrawable_leftDrawableHeight, dip2px(context, 20));
            }
            if (drawableRight != null) {
                rightWidth = typedArray.getDimensionPixelOffset(R.styleable.TextDrawable_rightDrawableWidth, dip2px(context, 20));
                rightHeight = typedArray.getDimensionPixelOffset(R.styleable.TextDrawable_rightDrawableHeight, dip2px(context, 20));
            }
            if (drawableTop != null) {
                topWidth = typedArray.getDimensionPixelOffset(R.styleable.TextDrawable_topDrawableWidth, dip2px(context, 20));
                topHeight = typedArray.getDimensionPixelOffset(R.styleable.TextDrawable_topDrawableHeight, dip2px(context, 20));
            }

        }finally {
            typedArray.recycle();
        }

    }

    private void onDrawableWithBounds() {
        if (drawableLeft != null) {
            drawableLeft.setBounds(0, 0, leftWidth, leftHeight);
        }

        if (drawableRight != null) {
            drawableRight.setBounds(0, 0, rightWidth, rightHeight);
        }
        if (drawableTop != null) {
            drawableTop.setBounds(0, 0, topWidth, topHeight);
        }

        this.setCompoundDrawables(drawableLeft, drawableTop, drawableRight, null);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (drawableLeft != null) {
            super.onMeasure(widthMeasureSpec, leftHeight);

        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

        Log.d("onMeasure","onMeasure");
    }

    /**
     * 设置左侧图片并重绘
     */
    public void setDrawableLeft(int drawableLeftRes) {
        this.drawableLeft = this.mContext.getResources().getDrawable(drawableLeftRes);
        invalidate();
    }

    /**
     * 设置右侧图片并重绘
     */
    public void setDrawableRight(Drawable drawableRight) {
        this.drawableRight = drawableLeft;
        invalidate();
    }

    /**
     * 设置右侧图片并重绘
     */
    public void setDrawableRight(int drawableRightRes) {
        this.drawableRight = this.mContext.getResources().getDrawable(drawableRightRes);
        invalidate();
    }

    /**
     * 设置上部图片并重绘
     */
    public void setDrawable(Drawable drawableTop) {
        this.drawableTop = drawableTop;
        invalidate();
    }

    /**
     * 设置右侧图片并重绘
     */
    public void setDrawableTop(int drawableTopRes) {
        this.drawableTop = this.mContext.getResources().getDrawable(drawableTopRes);
        invalidate();
    }

}
