package com.example.mvp.login;

import com.example.mvp.base.BaseModel;
import com.example.mvp.bean.UserInfo;

public class LoginModel extends BaseModel<LoginPresenter, LoginContract.Model> {
    public LoginModel(LoginPresenter loginPresenter) {
        super(loginPresenter);
    }

    @Override
    public LoginContract.Model getContract() {

        return new LoginContract.Model() {
            @Override
            public void executeLogin(String name, String pwd) throws Exception {
                if ("wml".equalsIgnoreCase(name)&&"111".equalsIgnoreCase(pwd)){
                    p.getContract().respondResult(new UserInfo("AA","wu"));
                }else {
                    p.getContract().respondResult(null);
                }
            }
        };
    }
}
