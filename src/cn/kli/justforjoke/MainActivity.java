package cn.kli.justforjoke;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Config config = new Config(this);
		if(config.getAdminEnable()){
			new Config(this).setLockEnable(true);
			LockScreenManager.lock(this);
		}else{
			Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
			ComponentName componentName = new ComponentName(this, DeviceReceiver.class); 
			intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
			startActivity(intent);
		}
		finish();
	}
}
