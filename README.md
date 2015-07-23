# Gallery2-android-4.4.2_r1
源码取自Android gallery2，计划只保留图片预览和图片查看功能，用于UltimateImgSpider。

Android原版Gallery2-android-4.4.2_r1源码地址：

https://android.googlesource.com/platform/packages/apps/Gallery2/+/android-4.4.2_r1

下载下来直接编译会报很多错，原因是有些库和源码需要添加到编译路径中，默认是不添加的。下面是编译运行都正常时的工程配置：

![Renderings](https://raw.githubusercontent.com/sj969/Gallery2-android-4.4.2_r1/master/project-config/project-struct.png)
![Renderings](https://raw.githubusercontent.com/sj969/Gallery2-android-4.4.2_r1/master/project-config/source-folders.png)
![Renderings](https://raw.githubusercontent.com/sj969/Gallery2-android-4.4.2_r1/master/project-config/build-path.png)
![Renderings](https://raw.githubusercontent.com/sj969/Gallery2-android-4.4.2_r1/master/project-config/order-export.png)

Android原版的有照片编辑功能，不过我这边编译的时候有几个RenderScript总是报错，然后就把它们删掉了，估计也是环境没配置好。
不过暂时用不到照片编辑功能，所以先不管了。
