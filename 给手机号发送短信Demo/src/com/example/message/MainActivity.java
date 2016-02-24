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
 * ���ֻ��ŷ�����
 * @author Administrator
 *
 */
public class MainActivity extends Activity implements OnClickListener {
	private EditText phone, huoqu;// �ֻ��� ��ȡ��֤��
	private Button fasong,huoqu1;// ���Ͱ�ť

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	/**
	 * ��ʼ�����
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
			SmsManager smsManager = SmsManager.getDefault();//��ȡ���Ź�����
			//���Ǹ��ֻ��ŷ��͹̶��Ķ���  
			smsManager.sendTextMessage(ph, null, "ww", null, null);
			break;

//		case R.id.huoqu1:
//			registSmsReciver();
//			break;
		}

	}

//	private SmsReciver smsReciver = new SmsReciver();
//	/** �յ�����Action **/
//	String ACTION_SMS_RECIVER = "android.provider.Telephony.SMS_RECEIVED";
//
//	/**
//	 * ע��㲥�����߼���������֤���Զ���д ����onCreate()�н���ע��;
//	 */
//	private void registSmsReciver() {
//		IntentFilter filter = new IntentFilter();
//		filter.addAction(ACTION_SMS_RECIVER);
//		// �������ȼ� ��Ȼ������������
//		filter.setPriority(1000);
//		registerReceiver(smsReciver, filter);
//	}
//
//	/**
//	 * ���Ź㲥������ �û��������ţ��Զ���д��֤��
//	 */
//	private class SmsReciver extends BroadcastReceiver {
//
//		@Override
//		public void onReceive(Context context, Intent intent) {
//			Object[] objs = (Object[]) intent.getExtras().get("pdus");
//			for (Object obj : objs) {
//				byte[] pdu = (byte[]) obj;
//				SmsMessage sms = SmsMessage.createFromPdu(pdu);
//				// ���ŵ�����
//				String message = sms.getMessageBody();
//				Log.d("log", "message     " + message);
//				// ��Ϣ���ֻ��ţ�������ǹ�˾������֤��ĺ����ǹ̶���������Խ���һ�������У��
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
//	 * �������Ų��һ�д ����������Ǵ����ֵĶ��ţ����С������֤�������ĸ�Ļ������������滻
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
//		// ȡ�����Ź㲥ע��
//		if (smsReciver != null) {
//			unregisterReceiver(smsReciver);
//			smsReciver = null;
//		}
//	}
}
