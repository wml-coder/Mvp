package com.example.mvp.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public abstract class BaseView<P extends BasePresenter,CONTRACT> extends Activity {

    protected P p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //弱引用
        p = getPresenter();
        //绑定
        p.bindView(this);
    }

    //让P层做需求
    public abstract CONTRACT getContract();

    //从子类中获取具体的契约
    public abstract P getPresenter();

    //如果presenter层出现异常,告知view层
    public  void error(Exception e){}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除绑定
        p.unBindView();
    }
}
