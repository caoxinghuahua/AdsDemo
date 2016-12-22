广告投放系统android SDK

Android 广告sdk在使用时首先需要初始化MXAdsController用来完成初始化，获取地理位置等工作，需要传入当前APP的context上下文信息，同时还需要初始化开发环境。接入时首选需将aar添加到工程中。

API 方法说明

MXAdsController(环境配置类)

getInstance(Context context)
说明：获取广告单列MXAdsController
参数：context  （上下文，必填，类型:Context）

initEnvir(Environment envir)
说明：初始化开发环境
参数：envir （环境变量，有DEV,PRE,ONLINE三个值，必填，类型:枚举）

Environment
说明：环境变量，枚举，有DEV,PRE,ONLINE三个值

MXAdsBannerView(横幅广告类)

MXAdsBannerView(Context context,String slotId, ADSize adSize)
说明：横幅广告构造函数，初始化广告位，广告栏大小等信息
参数：context （当前activity的上下文，必填，类型:Context）
            slotId （广告位Id，必填，类型:String）
            ADSize （广告的大小，必填，类型:枚举）

setAdListener(MxAdsListener listener)
说明：设置横幅广告监听
参数：listener （横幅广告监听器，必填，类型: MXAdsListener）

destory()
说明：销毁横幅广告对象，销毁后，该对象不可再用

ADSize
说明：横幅广告尺寸，枚举。有三个值WRAP_HEIGHT,CALCULATE_HEIGHT,FIXEED_HEIGHT分别表示自适应高度，根据屏幕宽度计算高度和固定高度。

MXAdsListener(广告监听器)

adLoadSuccess()
说明：广告加载成功

adLoadFail()
说明：广告加载失败

adClick()
说明：点击广告

adShow()
说明：广告显示

adHide()
说明：广告隐藏

adClose()
说明：广告关闭

MXSplashAd(开屏广告类)

MXSplashAd(Activity activity,String slotId，boolean isFull)
说明：开屏广告初始化
参数：activity （上下文，必填，类型: Activity）
           slotId （广告位id，必填，类型:String）
           isFull （是否全屏，必填，类型:boolean）

setAdListener(MXAdsListener listener)
说明：设置开屏广告监听器
参数：listener （开屏广告监听，必填，类型：MXAdsListener）

load()
说明：加载开屏广告

show()
说明：显示开屏广告

getView()
说明：获取半屏时的view，全屏时返回null

destory()
说明：销毁开屏广告对象，销毁后，该对象不可再用

MXInterstitialAd(插屏广告类)

MXInterstitialAd(Activity activity，String slotId,boolean isFull )
说明：插屏广告初始化
参数：activity （当前Activity实例，必填，类型:Activity）
           slotId （广告位id，必填，类型:String）
           isFull （是否全屏，必填，类型:boolean）

load()
说明：加载插屏数据

show()
说明：显示插屏广告

setAdListener(MXAdsListener listener)
说明：设置插屏广告监听器
参数：listener （插屏广告监听，必填，类型：MXAdsListener）

destory()
说明：销毁插屏广告对象，销毁后，该对象不可再用

联调时可以用maven上的aar
测试地址：http://10.69.213.76:8081/nexus/content/repositories/snapshots/
上线地址：http://10.69.213.76:8081/nexus/content/repositories/releases/

api文档也可以参见wiki：http://wiki.intra.gomeplus.com/pages/viewpage.action?pageId=20416111
