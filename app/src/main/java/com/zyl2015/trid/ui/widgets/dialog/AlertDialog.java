package com.zyl2015.trid.ui.widgets.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyl2015.trid.R;
import com.zyl2015.trid.ui.activities.BaseActivityAdapter;


/**
 * 自定义对话框,Activity形式
 * Created by zyl on 2015/11/9.
 */
public class AlertDialog extends BaseActivityAdapter {
    private TextView mTextView;
    private Button btn_cancel;
    private Button btn_ok;
    private int position;
    private ImageView imageView;
    private EditText editText;
    private boolean isEditextShow;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog);
        initWidgets();
        showViews();
    }

    private void initWidgets(){
        mTextView=(TextView)findViewById(R.id.title);
        btn_cancel=(Button)findViewById(R.id.btn_cancel);
        btn_ok=(Button)findViewById(R.id.btn_ok);
        imageView=(ImageView)findViewById(R.id.image);
        editText=(EditText)findViewById(R.id.edit);
    }

    private void showViews(){
        //提示内容
        String msg=getIntent().getStringExtra("msg");
        //提示标题
        String title=getIntent().getStringExtra("title");
        position=getIntent().getIntExtra("position", -1);
        //是否显示取消标题
        boolean isCancelTitle=getIntent().getBooleanExtra("titleIsCancel",false);
        //是否显示取消按钮
        boolean isCancelShow=getIntent().getBooleanExtra("cancel",false);
        //是否显示文本编辑框
        isEditextShow=getIntent().getBooleanExtra("edidTextShow",false);
        //文本编辑框内容
        String edit_text=getIntent().getStringExtra("edit_text");

        if(msg!=null)
            ((TextView)findViewById(R.id.alert_message)).setText(msg);
        if(title!=null)
            mTextView.setText(title);
        if(isCancelTitle)
            mTextView.setVisibility(View.GONE);
        if(isCancelShow)
            btn_cancel.setVisibility(View.VISIBLE);
        if(isEditextShow){
            editText.setVisibility(View.VISIBLE);
            editText.setText(edit_text);
        }

    }

    @Override
    public void widgetClick(View v){
        switch (v.getId()){
            case R.id.btn_ok:
                setResult(RESULT_OK, new Intent().putExtra("position", position).
                        putExtra("edittext", editText.getText().toString()));
                finish();
                break;
            case R.id.btn_cancel:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        finish();
        return true;
    }

}
