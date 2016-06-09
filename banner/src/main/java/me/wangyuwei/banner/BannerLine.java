package me.wangyuwei.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * 作者： 巴掌 on 16/6/9 22:37
 */
public class BannerLine extends View {

    private Paint mPaint;
    private float mWidth;
    private int mPageSize;
    private float mPageWidth = 0f;
    private int mPosition;
    private float mPositionOffset;

    public BannerLine(Context context) {
        super(context);
        initView();
    }

    public BannerLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public BannerLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        mWidth = dm.widthPixels;
        mPaint = new Paint();
        mPaint.setColor(ContextCompat.getColor(getContext(), R.color.banner_red));
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(1000f);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (mPosition == 0) {
            canvas.drawLine((mPageSize - 3) * mPageWidth + mPageWidth * mPositionOffset, 0, (mPageSize - 2) * mPageWidth + mPageWidth * mPositionOffset, 0, mPaint);
            canvas.drawLine(0, 0, mPageWidth * mPositionOffset, 0, mPaint);
        } else if (mPosition == mPageSize - 2) {
            canvas.drawLine((mPosition - 1) * mPageWidth + mPageWidth * mPositionOffset, 0, mPosition * mPageWidth + mPageWidth * mPositionOffset, 0, mPaint);
            canvas.drawLine(0, 0, mPageWidth * mPositionOffset, 0, mPaint);
        } else {
            canvas.drawLine((mPosition - 1) * mPageWidth + mPageWidth * mPositionOffset, 0, mPosition * mPageWidth + mPageWidth * mPositionOffset, 0, mPaint);
        }

    }

    public void setPageWidth(int pageSize) {
        this.mPageSize = pageSize;
        calcPageWidth();
    }

    private void calcPageWidth() {
        this.mPageWidth = this.mWidth / (this.mPageSize - 2);
    }

    public void setPageScrolled(int position, float positionOffset) {
        mPosition = position;
        mPositionOffset = positionOffset;
        invalidate();
    }

}
