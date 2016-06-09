package me.wangyuwei.banner;

import android.content.Context;
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

    private ViewPager vp_banner;
    private BannerLine line;
    private List<BannerEntity> entities = new ArrayList<>();
    private BannerPagerAdapter mAdapter;

    public BannerView(Context context) {
        super(context);
        initView();
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.banner_view, this);
        vp_banner = (ViewPager) this.findViewById(R.id.vp_banner);
        line = (BannerLine) this.findViewById(R.id.line);
    }

    public void setEntities(List<BannerEntity> entities) {
        addExtraPage(entities);
        showBanner();
    }

    private void addExtraPage(List<BannerEntity> entities) {
        this.entities.add(entities.get(entities.size() - 1));
        this.entities.addAll(entities);
        this.entities.add(entities.get(0));
    }

    private void showBanner() {
        line.setPageWidth(entities.size());
        mAdapter = new BannerPagerAdapter(getContext(), entities);
        vp_banner.setAdapter(mAdapter);
        vp_banner.setCurrentItem(1, false);
        vp_banner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                line.setPageScrolled(position, positionOffset);
                if (positionOffsetPixels == 0.0) {
                    if (position == entities.size() - 1) {
                        vp_banner.setCurrentItem(1, false);
                    } else if (position == 0) {
                        vp_banner.setCurrentItem(entities.size() - 2, false);
                    } else {
                        vp_banner.setCurrentItem(position);
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

}
