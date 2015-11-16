package com.zyl2015.trid.ui.activities.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.zyl2015.trid.R;
import com.zyl2015.trid.ctrler.ChatCtrler;
import com.zyl2015.trid.enums.RefreshType;
import com.zyl2015.trid.ui.activities.BaseActivity;
import com.zyl2015.trid.ui.activities.IRefreshListener;
import com.zyl2015.trid.ui.adapter.MessageAdapter;
import com.zyl2015.trid.ui.widgets.dialog.AlertDialog;
import com.zyl2015.trid.ui.widgets.view.PasteEditText;

/**
 * 聊天界面
 * Created by zyl on 2015/11/8.
 */
public class ChatActivity extends BaseActivity  {

    private static final String TAG = "ChatActivity";
    private static final int REQUEST_CODE_EMPTY_HISTORY = 2;
    public static final int REQUEST_CODE_CONTEXT_MENU = 3;
    private static final int REQUEST_CODE_MAP = 4;
    public static final int REQUEST_CODE_TEXT = 5;
    public static final int REQUEST_CODE_VOICE = 6;
    public static final int REQUEST_CODE_PICTURE = 7;
    public static final int REQUEST_CODE_LOCATION = 8;
    public static final int REQUEST_CODE_NET_DISK = 9;
    public static final int REQUEST_CODE_FILE = 10;
    public static final int REQUEST_CODE_COPY_AND_PASTE = 11;
    public static final int REQUEST_CODE_PICK_VIDEO = 12;
    public static final int REQUEST_CODE_DOWNLOAD_VIDEO = 13;
    public static final int REQUEST_CODE_VIDEO = 14;
    public static final int REQUEST_CODE_DOWNLOAD_VOICE = 15;
    public static final int REQUEST_CODE_SELECT_USER_CARD = 16;
    public static final int REQUEST_CODE_SEND_USER_CARD = 17;
    public static final int REQUEST_CODE_CAMERA = 18;
    public static final int REQUEST_CODE_LOCAL = 19;
    public static final int REQUEST_CODE_CLICK_DESTORY_IMG = 20;
    public static final int REQUEST_CODE_GROUP_DETAIL = 21;
    public static final int REQUEST_CODE_SELECT_VIDEO = 23;
    public static final int REQUEST_CODE_SELECT_FILE = 24;
    public static final int REQUEST_CODE_ADD_TO_BLACKLIST = 25;
    public static final int REQUEST_CODE_SET_ALARM = 26;

    public static final int RESULT_CODE_COPY = 1;
    public static final int RESULT_CODE_DELETE = 2;
    public static final int RESULT_CODE_FORWARD = 3;
    public static final int RESULT_CODE_OPEN = 4;
    public static final int RESULT_CODE_DWONLOAD = 5;
    public static final int RESULT_CODE_TO_CLOUD = 6;
    public static final int RESULT_CODE_EXIT_GROUP = 7;
    public static final int RESULT_CODE_SET_ALARM_SUCCESS = 8;

    private InputMethodManager manager;
    private ChatCtrler chatCtrler;

    private View recordingContainer;
    private ImageView micImage;
    private TextView recordingHint;
    private ListView listView;
    private PasteEditText mEditTextContent;
    private View buttonSetModeKeyboard;
    private View buttonSetModeVoice;
    private View buttonSend;
    private View buttonPressToSpeak;

    private EMConversation conversation;
    private String toChatUsername;

    private LinearLayout emojiIconContainer;
    private LinearLayout btnContainer;
    private ImageView locationImgview;
    private View more;
    //表情按钮
    private ImageView iv_emoticons_normal;
    private ImageView iv_emoticons_checked;
    private RelativeLayout edittext_layout;
    //闹钟预览图
    private RelativeLayout alarmPreview_layout;
    private ImageView addAlarm;
    //选择按钮
    private ToggleButton alarm_preview_btn1;
    private ToggleButton alarm_preview_btn2;

    private TextView content1;
    private TextView content2;
    private TextView date1;
    private TextView date2;
    private TextView time1;
    private TextView time2;
    //更多按钮
    private Button btnMore;
    //清空历史记录
    private RelativeLayout container_menu;
    //显示语音按钮
    private Button btn_set_mode_voice;

    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initialize();
    }

    private void initialize() {
        initView();
        ctrler = new ChatCtrler(this,conversation);
        chatCtrler = (ChatCtrler) ctrler;

    }

    private void initView() {

        recordingContainer = findViewById(R.id.recording_container);
        micImage = (ImageView) findViewById(R.id.mic_image);
        recordingHint = (TextView) findViewById(R.id.recording_hint);
        listView = (ListView) findViewById(R.id.list);
        mEditTextContent = (PasteEditText) findViewById(R.id.et_sendmessage);
        buttonSetModeKeyboard = findViewById(R.id.btn_set_mode_keyboard);
        buttonSetModeVoice = findViewById(R.id.btn_set_mode_voice);
        buttonSend = findViewById(R.id.btn_send);
        buttonPressToSpeak = findViewById(R.id.btn_press_to_speak);
        btnMore = (Button) findViewById(R.id.btn_more);
        emojiIconContainer = (LinearLayout) findViewById(R.id.ll_btn_container);
        btnContainer = (LinearLayout) findViewById(R.id.ll_btn_container);
        locationImgview = (ImageView) findViewById(R.id.btn_location);
        iv_emoticons_normal = (ImageView) findViewById(R.id.iv_emoticons_normal);
        iv_emoticons_checked = (ImageView) findViewById(R.id.iv_emoticons_checked);
        content1 = (TextView) findViewById(R.id.text_12);
        content2 = (TextView) findViewById(R.id.text_22);
        date1 = (TextView) findViewById(R.id.date_1);
        date2 = (TextView) findViewById(R.id.date_2);
        time1 = (TextView) findViewById(R.id.time_1);
        time2 = (TextView) findViewById(R.id.time_2);
        alarm_preview_btn1 = (ToggleButton) findViewById(R.id.but_preview_1);
        alarm_preview_btn2 = (ToggleButton) findViewById(R.id.but_preview_2);
        container_menu = (RelativeLayout) findViewById(R.id.container_menu);
        btn_set_mode_voice = (Button) findViewById(R.id.btn_set_mode_voice);
        edittext_layout = (RelativeLayout) findViewById(R.id.edittext_layout);
        alarmPreview_layout=(RelativeLayout)findViewById(R.id.alarm_preview);
        manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        more = findViewById(R.id.more);
        bindListeners();
    }

    /**
     * 绑定点击事件
     */
    private void bindListeners() {
        container_menu.setOnClickListener(this);
        btn_set_mode_voice.setOnClickListener(this);
        buttonSetModeKeyboard.setOnClickListener(this);
        btnMore.setOnClickListener(this);
        mEditTextContent.setOnClickListener(this);
        mEditTextContent.addTextChangedListener(new MyTextWatcher());

    }

    /**
     * 点击事件逻辑
     *
     * @param v
     */
    public void widgetClick(View v) {
        switch (v.getId()) {

            //清空聊天记录按钮
            case R.id.container_menu: {

                String st5 = getResources().getString(R.string.Whether_to_empty_all_chats);
                startActivityForResult(new Intent(this, AlertDialog.class)
                        .putExtra("titleIsCancel", true).putExtra("msg", st5)
                        .putExtra("cancel", true), REQUEST_CODE_EMPTY_HISTORY);
                break;
            }

            case R.id.btn_set_mode_voice: {
                //点击录音部分视图显示状态变化
                hideKeyboard();
                edittext_layout.setVisibility(View.GONE);
                more.setVisibility(View.GONE);
                v.setVisibility(View.GONE);
                buttonSetModeKeyboard.setVisibility(View.VISIBLE);
                buttonSend.setVisibility(View.GONE);
                btnMore.setVisibility(View.VISIBLE);
                buttonPressToSpeak.setVisibility(View.VISIBLE);
                iv_emoticons_normal.setVisibility(View.VISIBLE);
                iv_emoticons_checked.setVisibility(View.INVISIBLE);
                btnContainer.setVisibility(View.VISIBLE);
                emojiIconContainer.setVisibility(View.GONE);
                break;
            }

            case R.id.btn_set_mode_keyboard: {
                //点击键盘按钮图标显示状态变化
                edittext_layout.setVisibility(View.VISIBLE);
                more.setVisibility(View.GONE);
                v.setVisibility(View.GONE);
                buttonSetModeVoice.setVisibility(View.VISIBLE);
                mEditTextContent.requestFocus();
                buttonPressToSpeak.setVisibility(View.GONE);
                if (TextUtils.isEmpty(mEditTextContent.getText())) {
                    btnMore.setVisibility(View.VISIBLE);
                    buttonSend.setVisibility(View.GONE);
                } else {
                    btnMore.setVisibility(View.GONE);
                    buttonSend.setVisibility(View.VISIBLE);
                }
                break;
            }

            case R.id.btn_more: {
                //点击更多按钮
                if (more.getVisibility() == View.GONE) {
                    hideKeyboard();
                    more.setVisibility(View.VISIBLE);
                    btnContainer.setVisibility(View.VISIBLE);
                    alarmPreview_layout.setVisibility(View.GONE);
                    emojiIconContainer.setVisibility(View.GONE);
                } else if (emojiIconContainer.getVisibility() == View.VISIBLE) {
                    emojiIconContainer.setVisibility(View.GONE);
                    btnContainer.setVisibility(View.VISIBLE);
                    iv_emoticons_normal.setVisibility(View.VISIBLE);
                    iv_emoticons_checked.setVisibility(View.INVISIBLE);
                } else if (alarmPreview_layout.getVisibility() == View.VISIBLE) {
                    alarmPreview_layout.setVisibility(View.GONE);
                    btnContainer.setVisibility(View.VISIBLE);
                } else {
                    more.setVisibility(View.GONE);
                }
                break;
            }

            case R.id.et_sendmessage:{
                listView.setSelection(listView.getCount()-1);
                if (more.getVisibility() == View.VISIBLE) {
                    more.setVisibility(View.GONE);
                    iv_emoticons_normal.setVisibility(View.VISIBLE);
                    iv_emoticons_checked.setVisibility(View.INVISIBLE);
                }
                break;
            }

            default:
                break;
        }
    }

    /**
     * 内部类，用于监听文字变化
     */
    private class MyTextWatcher implements TextWatcher{
        @Override
        public void onTextChanged(CharSequence s,int start,int before,int count){
            if(!TextUtils.isEmpty(s)){
                btnMore.setVisibility(View.GONE);
                buttonSend.setVisibility(View.VISIBLE);
            }else{
                btnMore.setVisibility(View.VISIBLE);
                buttonSend.setVisibility(View.GONE);
            }
        }
        @Override
        public void beforeTextChanged(CharSequence s,int start,int count,int after){}
        @Override
        public void afterTextChanged(Editable s){}
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_EMPTY_HISTORY) {
                EMChatManager.getInstance().clearConversation(toChatUsername);
            }
        }
    }

    /**
     * 隐藏软键盘
     */
    private void hideKeyboard() {
        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (getCurrentFocus() != null)
                manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public void handlerUI(RefreshType type) {
        switch (type){
            case ADAPTERSELECTLAST:
                adapter.refreshSelectLast();
                break;
            case ADAPTERDATACHANGE:
                adapter.notifyDataSetChanged();
                break;
            case CLEAREDITTEXT:
                mEditTextContent.setText("");
                break;
            case SETRESULT:
                setResult(RESULT_OK);
                break;
            case NEWMSG:{
                if(adapter == null){
                    return;
                }
                runOnUiThread(new Runnable() {
                    public void run() {
                        adapter.refreshSelectLast();
                    }
                });
                break;
            }
            case CHATUI:{
                if(adapter == null){
                    return;
                }

                runOnUiThread(new Runnable() {
                    public void run() {
                        adapter.refresh();
                    }
                });
            }
        }
    }

    public String getToChatUsername(){
        return toChatUsername;
    }

}
