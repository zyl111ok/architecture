package com.zyl2015.trid.ui.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.easemob.chat.EMChat;
import com.zyl2015.trid.R;
import com.zyl2015.trid.ctrler.BaseCtrler;
import com.zyl2015.trid.ctrler.LoginCtrler;
import com.zyl2015.trid.enums.RefreshType;
import com.zyl2015.trid.ui.activities.BaseActivity;
import com.zyl2015.trid.ui.activities.chat.ChatActivity;

import android.os.Handler;
import android.widget.*;


/**
 * 登录界面
 * Created by zyl on 2015/10/26.
 */
public class LoginActivity extends BaseActivity {
    private TextView tv_getSmsValidationCode;//获取验证码TextView
    private LoginCtrler loginCtrler;
    private Button btn_login;//登陆按钮
    private EditText edt_phoneNum;//电话号码输入框
    private EditText edt_smsValidationCode;//短信验证码输入框

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_trid);
        initialize();
    }

    /**
     * 对象实例化
     */
    private void initialize(){
        initWidget();
        ctrler=new LoginCtrler(this);
        loginCtrler=(LoginCtrler)ctrler;
        loginCtrler.setHandler(handler);
        EMChat.getInstance().init(getApplicationContext());
    }

    /**
     * 控件实例化
     */
    public void initWidget(){
        tv_getSmsValidationCode=(TextView)findViewById(R.id.textv_login_getIdentifyingCode);
        btn_login=(Button)findViewById(R.id.btn_login);
        edt_phoneNum=(EditText)findViewById(R.id.edt_login_phoneNum);
        edt_smsValidationCode=(EditText)findViewById(R.id.edt_login_smsValidationCode);
        tv_getSmsValidationCode.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    /**
     * 控件点击事件绑定
     * @param v
     */
    public void widgetClick(View v){
        switch (v.getId()){
            case R.id.textv_login_getIdentifyingCode: {
                loginCtrler.requestConfrim(edt_phoneNum.getText().toString(), null);
                break;
            }
            case R.id.btn_login:{
                String tel=edt_phoneNum.getText().toString();
                String code=edt_smsValidationCode.getText().toString();
                loginCtrler.requestLogin(tel,code,null);
                break;
            }
            default:
                break;
        }
    }

    /**
     * 网络返回成功后更新UI操作
     */
    public void handlerUI(RefreshType type){
        switch (type){
            case COUNT: {
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
                break;
            }
            case SKIP:{
                startActivity(new Intent(this, ChatActivity.class));
                finish();
            }
            default:
                break;
        }

    }

    public BaseCtrler getCtrler(){
        return ctrler;
    }

    public Handler getHandler(){
        return handler;
    }
}
