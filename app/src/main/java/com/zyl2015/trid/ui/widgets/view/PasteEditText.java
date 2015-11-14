package com.zyl2015.trid.ui.widgets.view;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * 自定义的textview,用来处理复制粘贴的消息
 * Created by zyl on 2015/11/9.
 */
public class PasteEditText extends EditText{
    private Context context;

    public PasteEditText(Context context){
        super(context);
        this.context=context;
    }

    public PasteEditText(Context context,AttributeSet attrs){
        super(context,attrs);
        this.context=context;
    }

    public PasteEditText(Context context,AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
        this.context=context;
    }

    @SuppressLint("NewApi")
    @Override
    public boolean onTextContextMenuItem(int id){
        if(id==android.R.id.paste){
            ClipboardManager clip=(ClipboardManager)getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            if(clip==null||clip.getText()==null){
                return false;
            }
        }
        return super.onTextContextMenuItem(id);
    }

    @Override
    protected void onTextChanged(CharSequence text,int start,int lengthBefore,int lengthAfter){
        super.onTextChanged(text,start,lengthBefore,lengthAfter);
    }



}
