package me.wangyuwei.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 巴掌 on 16/6/9 17:32
 */
public class BannerView extends FrameLayout {

    private ViewPager mVpBanner;
    private BannerLine mLine;
    private List<BannerEntity> mEntities = new ArrayList<>();
    private BannerPagerAdapter mAdapter;

    public BannerView(Context context) {
        this(context, null);
    }

    public BannerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(getContext(), R.layout.banner_view, this);
        mVpBanner = (ViewPager) this.findViewById(R.id.vp_banner);
        mLine = (BannerLine) this.findViewById(R.id.line);
        TypedArray typeArray = context.obtainStyledAttributes(attrs,
                R.styleable.QingtingBanner);
        int lineColor = typeArray.getColor(R.styleable.QingtingBanner_qt_line_color, ContextCompat.getColor(getContext(), R.color.banner_red));
        typeArray.recycle();
        mLine.setLineColor(lineColor);
    }

    public void setEntities(List<BannerEntity> entities) {
        addExtraPage(entities);
        showBanner();
    }

    private void addExtraPage(List<BannerEntity> entities) {
        mEntities.add(entities.get(entities.size() - 1));
        mEntities.addAll(entities);
        mEntities.add(entities.get(0));
    }

    private void showBanner() {
        mLine.setPageWidth(mEntities.size());
        mAdapter = new BannerPagerAdapter(getContext(), mEntities);
        mVpBanner.setAdapter(mAdapter);
        mVpBanner.setCurrentItem(1, false);
        mVpBanner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mLine.setPageScrolled(position, positionOffset);
                if (positionOffsetPixels == 0.0) {
                    if (position == mEntities.size() - 1) {
                        mVpBanner.setCurrentItem(1, false);
                    } else if (position == 0) {
                        mVpBanner.setCurrentItem(mEntities.size() - 2, false);
                    } else {
                        mVpBanner.setCurrentItem(position);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setOnBannerClickListener(OnBannerClickListener clickListener) {
        if (mAdapter != null) {
            mAdapter.setOnBannerClickListener(clickListener);
        }
    }

}
