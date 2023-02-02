package com.example.mvp.base;

/**
 * 接收P层交给他的请求
 * @param <P>
 * @param <CONTRACT>
 */
public abstract class BaseModel<P extends BasePresenter, CONTRACT> {

    protected P p;

    //业务结束,通过presenter调用锲约(接口中的方法)void respondResult(T t)

    public BaseModel(P p) {
        this.p = p;
    }

    public abstract CONTRACT getContract();
}
