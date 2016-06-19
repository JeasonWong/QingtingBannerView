# QingtingBannerView
仿蜻蜓FM轮播banner

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-QingtingBannerView-green.svg?style=true)](https://android-arsenal.com/details/1/3712)

## What's QingtingBannerView ?
A simple banner has infinite loop and animated line.

## Demo
![效果](http://i1.buimg.com/49cbbddf29cd4882.gif)

## Feature
* Infinite loop
* Animated line in bottom

## Import

Add it in your project's build.gradle at the end of repositories:

```gradle
repositories {
    maven {
        url 'https://dl.bintray.com/wangyuwei/maven'
    }
}
```

Step 2. Add the dependency in the form

```gradle
dependencies {
  compile 'me.wangyuwei:banner:1.0.6'
}
```

## Usage
#### Step 1 : Define your banner under your xml  :

```xml
    <me.wangyuwei.banner.BannerView
        android:id="@+id/banner_view"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        qt:qt_line_color="#688fdb" />
```

#### Step 2 : Initialize banner data :

```java
    List<BannerEntity> entities = new ArrayList<>();
```


#### Step 3 : set banner data :
```java
    mBannerView.setEntities(entities);
```

#### Step 4 : set banner click listener :
```java
    mBannerView.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void onClick(int position) {
                    Toast.makeText(MainActivity.this, position + "=> " + entities.get(position).title, Toast.LENGTH_SHORT).show();
                }
            });
```





##**Lincense**

```lincense
Copyright [2016] [JeasonWong of copyright owner]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

