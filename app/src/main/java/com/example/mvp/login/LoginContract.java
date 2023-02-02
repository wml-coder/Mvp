package com.example.mvp.login;

import com.example.mvp.bean.BaseBean;
import com.example.mvp.bean.UserInfo;

/**
 * 把model层,View层,Presenter层协商的共同业务,封装成接口
 * 契约,合同
 */
public interface LoginContract {

    interface Model{
        //model层子类完成方法的具体实现
        void executeLogin(String name,String psw) throws Exception;
    }

    interface View<T extends BaseBean>{
        //真实项目中,请求结果往往是以javaBean
        void handlerResult(T t);
    }

    interface Presenter<T extends BaseBean>{
        //登录请求(接收View请求,可以自己做,也可以交给model层做)
        void requestLogin(String name,String psw);

        //结果相应(接收model的结果,通知view层刷新)
        void respondResult(T t);
    }
}
