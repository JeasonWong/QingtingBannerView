package me.wangyuwei.qingtingbanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import me.wangyuwei.banner.BannerEntity;
import me.wangyuwei.banner.BannerView;
import me.wangyuwei.banner.OnBannerClickListener;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {


    private BannerView mBannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mBannerView = (BannerView) this.findViewById(R.id.banner_view);

        Banner banner = JSON.parseObject(readAssets(), Banner.class);

        final List<BannerEntity> entities = new ArrayList<>();
        for (int i = 0; i < banner.getRecommends().size(); i++) {
            BannerEntity entity = new BannerEntity();
            entity.imageUrl = banner.getRecommends().get(i).getThumb();
            entity.title = banner.getRecommends().get(i).getTitle();
            entities.add(entity);
        }

        mBannerView.setEntities(entities);
        mBannerView.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, position + "=> " + entities.get(position).title, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private String readAssets() {
        String json = "";
        try {
            InputStream inputStream = this.getAssets().open("banner.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

}
