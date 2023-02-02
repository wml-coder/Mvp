package com.example.mvp.login;

import com.example.mvp.LoginActivity;
import com.example.mvp.base.BasePresenter;
import com.example.mvp.bean.BaseBean;
import com.example.mvp.bean.UserInfo;

public class LoginPresenter extends BasePresenter<LoginActivity, LoginModel, LoginContract.Presenter> {
    @Override
    public LoginContract.Presenter getContract() {
        //执行view的请求,返回model结果
        return new LoginContract.Presenter<UserInfo>() {
            @Override
            public void requestLogin(String name, String pwd) {
                //三种风格(P层很极端1.自己全做2.全交给model做3.交给功能模块做)
                try {
                    m.getContract().executeLogin(name,pwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void respondResult(UserInfo userInfo) {
                //有结果就告知view
                getView().getContract().handlerResult(userInfo);
            }

        };
    }

    @Override
    public LoginModel getModel() {
        return new LoginModel(this);
    }
}
