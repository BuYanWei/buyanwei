package com.example.message;

import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
/**
 * 给手机号发短信
 * @author Administrator
 *
 */
public class MainActivity extends Activity implements OnClickListener {
	private EditText phone, huoqu;// 手机号 获取验证码
	private Button fasong,huoqu1;// 发送按钮

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	/**
	 * 初始化组件
	 */
	private void init() {
		phone = (EditText) findViewById(R.id.phone);
		huoqu = (EditText) findViewById(R.id.huoqu);
		fasong = (Button) findViewById(R.id.fasong);
		huoqu1 = (Button) findViewById(R.id.huoqu1);

		fasong.setOnClickListener(this);
		huoqu1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.fasong:
			String ph = phone.getText().toString();
			SmsManager smsManager = SmsManager.getDefault();//获取短信管理器
			//这是给手机号发送固定的短信  
			smsManager.sendTextMessage(ph, null, "ww", null, null);
			break;

//		case R.id.huoqu1:
//			registSmsReciver();
//			break;
		}

	}

//	private SmsReciver smsReciver = new SmsReciver();
//	/** 收到短信Action **/
//	String ACTION_SMS_RECIVER = "android.provider.Telephony.SMS_RECEIVED";
//
//	/**
//	 * 注册广播接受者监听短信验证码自动回写 可在onCreate()中进行注册;
//	 */
//	private void registSmsReciver() {
//		IntentFilter filter = new IntentFilter();
//		filter.addAction(ACTION_SMS_RECIVER);
//		// 设置优先级 不然监听不到短信
//		filter.setPriority(1000);
//		registerReceiver(smsReciver, filter);
//	}
//
//	/**
//	 * 短信广播接受者 用户监听短信，自动填写验证码
//	 */
//	private class SmsReciver extends BroadcastReceiver {
//
//		@Override
//		public void onReceive(Context context, Intent intent) {
//			Object[] objs = (Object[]) intent.getExtras().get("pdus");
//			for (Object obj : objs) {
//				byte[] pdu = (byte[]) obj;
//				SmsMessage sms = SmsMessage.createFromPdu(pdu);
//				// 短信的内容
//				String message = sms.getMessageBody();
//				Log.d("log", "message     " + message);
//				// 短息的手机号，如果你们公司发送验证码的号码是固定的这里可以进行一个号码的校验
//				String from = sms.getOriginatingAddress();
//				Log.d("log", "from     " + from);
//				analysisVerify(message);
//
//			}
//		}
//
//	}
//
//	/**
//	 * 解析短信并且回写 这里解析的是纯数字的短信，如果小伙伴的验证码包含字母的话，可用正则替换
//	 * 
//	 * @param message
//	 */
//	private void analysisVerify(String message) {
//		char[] msgs = message.toCharArray();
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < msgs.length; i++) {
//			if ('0' <= msgs[i] && msgs[i] <= '9') {
//				sb.append(msgs[i]);
//			}
//		}
//
//		huoqu.setText(sb.toString());
//	}
//
//	@Override
//	protected void onDestroy() {
//		super.onDestroy();
//		// 取消短信广播注册
//		if (smsReciver != null) {
//			unregisterReceiver(smsReciver);
//			smsReciver = null;
//		}
//	}
}
