package me.wangyuwei.banner;

import java.io.Serializable;

/**
 * 作者： 巴掌 on 16/6/9 21:06
 */
public class BannerEntity implements Serializable {

    public String imageUrl;
    public String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BannerEntity that = (BannerEntity) o;

        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        return title != null ? title.equals(that.title) : that.title == null;

    }

    @Override
    public int hashCode() {
        int result = imageUrl != null ? imageUrl.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
