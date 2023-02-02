package com.example.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp.base.BaseView;
import com.example.mvp.bean.BaseBean;
import com.example.mvp.bean.UserInfo;
import com.example.mvp.login.LoginContract;
import com.example.mvp.login.LoginPresenter;

public class LoginActivity extends BaseView<LoginPresenter, LoginContract.View> {

    private EditText nameET;
    private EditText pwdET;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
    }

    //初始化控件
    private void initView() {
        nameET = findViewById(R.id.et_name);
        pwdET = findViewById(R.id.et_pwd);
        btn = findViewById(R.id.bt_login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLoginAction(v);
            }
        });
    }

    @Override
    public LoginContract.View getContract() {
        return new LoginContract.View<UserInfo>() {
            @Override
            public void handlerResult(UserInfo userInfo) {
                if (userInfo != null){
                    Toast.makeText(LoginActivity.this,userInfo.toString(),Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this,"登陆失败!",Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    /**
     * 点击事件
     * @param view
     */
    public void doLoginAction(View view){
        String name = nameET.getText().toString();
        String pwd = pwdET.getText().toString();
        p.getContract().requestLogin(name,pwd);
    }
}
