package cn.kli.justforjoke;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import cn.kli.utils.klilog;

public class JokeService extends Service {
	
	public final static String ACTION_BLOCK_SCREEN = "block_screen";
	public final static String ACTION_UNBLOCK_SCREEN = "unblock_screen";
	public final static String ACTION_SET_ALARM = "set_alarm";
	public final static String ACTION_INIT = "init";
	public final static String ACTION_RELEASE = "release";

	private BlockScreen mBlockScreen;
	
	@Override
	public void onCreate() {
		mBlockScreen = new BlockScreen(this);
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		String action = null;
		if(intent == null){
			action = ACTION_BLOCK_SCREEN;
		}else{
			action = intent.getAction();
		}
		if(ACTION_BLOCK_SCREEN.equals(action)){
			blockScreen();
		}else if(ACTION_UNBLOCK_SCREEN.equals(action)){
			unBlockScreen();
		}else if(ACTION_SET_ALARM.equals(action)){
			setAlarm();
		}else if(ACTION_INIT.equals(action)){
			init();
		}else if(ACTION_RELEASE.equals(action)){
			release();
		}
		return START_STICKY;
	}


	private void release() {
		klilog.i("release");
		
	}

	private void init() {
		klilog.i("init");
		
	}

	private void blockScreen(){
		klilog.i("blockScreen");
		mBlockScreen.openPanel();
		
		ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
		am.killBackgroundProcesses("com.android.settings");
	}
	
	private void unBlockScreen(){
		klilog.i("unBlockScreen");
		mBlockScreen.closePanel();
	}
	
	private void setAlarm(){
		klilog.i("setAlarm");
	}


	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
}
