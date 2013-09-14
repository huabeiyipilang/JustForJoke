package cn.kli.justforjoke;

import android.app.Application;

public class App extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		LockScreenManager.lock(this);
	}
}
