package cn.kli.justforjoke;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootCompletedReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		Log.i("klilog", "received action = "+action);
		if(action.equals(Intent.ACTION_BOOT_COMPLETED)){
			LockScreenManager.lock(context);
		}
	}

}
