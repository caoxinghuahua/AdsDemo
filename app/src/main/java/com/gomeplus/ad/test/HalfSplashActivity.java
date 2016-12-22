package com.gomeplus.ad.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.gomeplus.meixin.ad.listener.MXAdsListener;
import com.gomeplus.meixin.ad.view.MXSplashAd;

public class HalfSplashActivity extends Activity implements View.OnClickListener,MXAdsListener{
    private Button loadSplashHalfBt;
    private Button showSplashHalfBt;
    private MXSplashAd mSplashAdHalf;
    private final  String TAG=this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_half_splash);
        loadSplashHalfBt=(Button) findViewById(R.id.loadHalfSc);
        showSplashHalfBt=(Button) findViewById(R.id.showHalfSc);
        loadSplashHalfBt.setOnClickListener(this);
        showSplashHalfBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loadHalfSc:
                loadSplashAdHalf();
                break;
            case R.id.showHalfSc:
                showSplashHalf();
                break;
        }
    }
    private void loadSplashAdHalf(){
        if(mSplashAdHalf==null){
            mSplashAdHalf=new MXSplashAd(this,"10016",false);
            mSplashAdHalf.setListener(this);
        }
        mSplashAdHalf.load();
    }
    private void showSplashHalf(){
        if(mSplashAdHalf==null)return;
        View mSplashAdHalfView=mSplashAdHalf.getView();
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,600);
        params.gravity= Gravity.BOTTOM;
        if(mSplashAdHalfView!=null){
            this.addContentView(mSplashAdHalfView,params);
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

}
