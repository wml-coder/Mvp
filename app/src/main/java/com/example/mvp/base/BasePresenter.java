package com.example.mvp.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends BaseView, M extends BaseModel, CONTRACT> {

    protected M m;
    //绑定view层弱引用
    private WeakReference<V> vWeakReference;

    public BasePresenter() {
        m = getModel();
    }

    public void bindView(V v){
        vWeakReference = new WeakReference<>(v);
    }

    public void unBindView() {
        if (vWeakReference != null){
            vWeakReference.clear();
            vWeakReference = null;
            System.gc();
        }
    }

    //获取View,P...V
    public V getView(){
        if (vWeakReference!= null){
            return vWeakReference.get();
        }
        return null;
    }

    //获取子类具体契约(model层和view层协商的共同业务)
    public abstract CONTRACT getContract();

    //获取model
    public abstract M getModel();
}
