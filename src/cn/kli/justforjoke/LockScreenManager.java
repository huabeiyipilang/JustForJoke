package cn.kli.justforjoke;

import android.content.Context;
import android.content.Intent;

public class LockScreenManager {

	public static void lock(Context context) {
		Config config = new Config(context);
		if(config.getLockEnable()){
			Intent intent = new Intent(context, JokeService.class);
			intent.setAction(JokeService.ACTION_BLOCK_SCREEN);
			context.startService(intent);
			
			Intent activityIntent = new Intent(context, BlankActivity.class);
			activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(activityIntent);
		}
	}
}
