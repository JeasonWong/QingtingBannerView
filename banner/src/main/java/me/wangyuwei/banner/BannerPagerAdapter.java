package me.wangyuwei.banner;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 巴掌 on 16/6/9 17:34
 */
public class BannerPagerAdapter extends PagerAdapter {

    private Context context;
    private List<BannerEntity> entities = new ArrayList<>();
    private List<BannerLayout> layouts = new ArrayList<>();

    public BannerPagerAdapter(Context context, List<BannerEntity> entities) {
        this.context = context;
        this.entities = entities;
        setLayouts();
    }

    private void setLayouts() {
        for (BannerEntity entity : entities) {
            BannerLayout layout = new BannerLayout(context);
            layout.setEntity(entity);
            layouts.add(layout);
        }
    }

    @Override
    public int getCount() {
        return layouts.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(layouts.get(position), 0);
        return layouts.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(layouts.get(position));
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }

}
