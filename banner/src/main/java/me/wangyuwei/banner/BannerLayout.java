package me.wangyuwei.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * 作者： 巴掌 on 16/6/9 17:37
 */
public class BannerLayout extends FrameLayout {

    private ImageView iv_banner;
    private TextView tv_banner_title;

    public BannerLayout(Context context) {
        super(context);
        initView();
    }

    public BannerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public BannerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.banner_layout, this);
        iv_banner = (ImageView) this.findViewById(R.id.iv_banner);
        tv_banner_title = (TextView) this.findViewById(R.id.tv_banner_title);
    }

    public void setEntity(BannerEntity entity) {
        Glide.with(getContext()).load(entity.imageUrl).centerCrop().crossFade().into(iv_banner);
        tv_banner_title.setText(entity.title);
    }


}
