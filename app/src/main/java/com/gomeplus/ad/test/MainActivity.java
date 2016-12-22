package com.gomeplus.ad.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.gomeplus.meixin.ad.listener.MXAdsListener;
import com.gomeplus.meixin.ad.manger.ADSize;
import com.gomeplus.meixin.ad.manger.Environment;
import com.gomeplus.meixin.ad.manger.MXAdsController;
import com.gomeplus.meixin.ad.view.MXAdsBannerView;
import com.gomeplus.meixin.ad.view.MXInterstitialAd;
import com.gomeplus.meixin.ad.view.MXSplashAd;


public class MainActivity extends Activity implements View.OnClickListener,MXAdsListener {
    private Button loadSplashBt;
    private Button showSplashBt;
    private Button splashHalfBt;
    private Button loadIntBt;
    private Button showIntBt;
    private Button loadIntHalfBt;
    private Button showIntHalfBt;
    private Button showBanner;
    private Button hideBanner;
    private LinearLayout layout;
    private MXSplashAd mSplashAd;
    private MXInterstitialAd mInterstitialAd;
    private MXInterstitialAd mInterstitialAdHalf;
    private MXAdsBannerView bannerView;
    private final  String TAG=this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MXAdsController.getInstance(this).initEnvir(Environment.PRE);
        initView();
        initListener();
    }
    private void initView(){
        loadSplashBt=(Button) findViewById(R.id.loadSc);
        showSplashBt=(Button) findViewById(R.id.showSc);
        splashHalfBt=(Button) findViewById(R.id.splashHalfBt);
        loadIntBt= (Button) findViewById(R.id.loadInt);
        showIntBt=(Button) findViewById(R.id.showInt);
        loadIntHalfBt=(Button) findViewById(R.id.loadInthalf);
        showIntHalfBt=(Button) findViewById(R.id.showInthalf);
        layout=(LinearLayout) findViewById(R.id.layout);
        showBanner=(Button) findViewById(R.id.bannerBt);
        hideBanner=(Button) findViewById(R.id.hideBanner);
    }
    private void initListener(){
        loadSplashBt.setOnClickListener(this);
        showSplashBt.setOnClickListener(this);
        loadIntBt.setOnClickListener(this);
        showIntBt.setOnClickListener(this);
        splashHalfBt.setOnClickListener(this);
        showBanner.setOnClickListener(this);
        hideBanner.setOnClickListener(this);
        loadIntHalfBt.setOnClickListener(this);
        showIntHalfBt.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loadSc:
                loadSplash();
                break;
            case R.id.showSc:
                showSplash();
                break;
            case R.id.loadInt:
                loadInterstitial();
                break;
            case R.id.showInt:
                showInterstitial();
            case R.id.loadInthalf:
                loadInterstitialHalf();
                break;
            case R.id.showInthalf:
                showInterstitialHalf();
                break;
            case R.id.bannerBt:
                loadBanner();
                break;
            case R.id.hideBanner:
                hideBanner();
                break;
            case R.id.splashHalfBt:
                startActivity(new Intent(this,HalfSplashActivity.class));
                break;
        }

    }
    private void loadBanner(){
        if(bannerView==null){
            bannerView=new MXAdsBannerView(this,"10016", ADSize.WRAP_HEIGHT);
            layout.addView(bannerView);
        }
    }
    private void hideBanner(){
        if(bannerView!=null){
            layout.removeAllViews();
        }
    }
    private void loadSplash(){
        if(mSplashAd==null){
            mSplashAd=new MXSplashAd(this,"10016",true);
            mSplashAd.setListener(this);
        }
        mSplashAd.load();
    }
    private void showSplash(){
        if(mSplashAd!=null){
            mSplashAd.show();
        }
    }
    private void loadInterstitial(){
        if(mInterstitialAd==null){
            mInterstitialAd=new MXInterstitialAd(this,"10016",true);
            mInterstitialAd.setListener(this);
        }
        mInterstitialAd.load();
    }
    private void showInterstitial(){
        if(mInterstitialAd!=null){
            mInterstitialAd.show();
        }
    }
    private void loadInterstitialHalf(){
        if(mInterstitialAdHalf==null){
            mInterstitialAdHalf=new MXInterstitialAd(this,"10016",false);
            mInterstitialAdHalf.setListener(this);
        }
        mInterstitialAdHalf.load();
    }
    private void showInterstitialHalf(){
        if(mInterstitialAdHalf!=null){
            mInterstitialAdHalf.show();
        }
    }
    @Override
    public void adLoadSuccess() {
        Log.i(TAG,"ads success");
    }

    @Override
    public void adLoadFail() {
        Log.i(TAG,"ads fail");
    }

    @Override
    public void adClick() {
        Log.i(TAG,"ads click");
    }

    @Override
    public void adShow() {
        Log.i(TAG,"ads show");
    }

    @Override
    public void adHide() {
        Log.i(TAG,"ads hide");
    }

    @Override
    public void adClose() {
        Log.i(TAG,"ads close");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mInterstitialAd.destory();
        mSplashAd.destory();
        mInterstitialAdHalf.destory();
        bannerView.destory();
    }
}
