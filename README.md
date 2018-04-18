# AwakeningView
## 一行链式代码，解决各种View/Layout 圆形/圆角边框等问题
## 使用如下 以圆角距形为例 
###
    AwakeningView.RectangleBuilder.create() //RectangleBuilder 对应圆角距形,CircleBuilder 对应圆形
                 .connerAll(5) //设置所有圆角角度，调用此方法后，如果继续调用connerXX方法，那么connerXX方法将不会生效
                 .strokeSize(2)//设置边框大小
                 .strokeColor(R.color.colorAccent) //设置边框颜色
                 .fillColor(R.color.colorPrimary) //设置填充颜色
                 .build()
                 .target(findViewById(R.id.tv_main1),findViewById(R.id.tv_main2),...)// 目标控件
                 .dashGap(0).dashWidth(0) //虚线宽度与间距 不需要可以不设置
                 .alpha(255) //透明度 默认255 不透明
                 .build();//设置完成

# Prerequisites

## Add this in your root build.gradle file (not your module build.gradle file):
###
    allprojects {
        repositories {
            ...
            jcenter()
        }
    }
# Dependency
## Add this to your module's build.gradle file (make sure the version matches the jcenter badge above):
### 
    dependencies {
        ...
        compile 'com.deilsky:awakeningView:1.1.2'
    }
