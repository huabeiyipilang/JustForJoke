package cn.kli.justforjoke;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Config {
	
	private Context mContext;
	
	public Config(Context context){
		mContext = context;
	}
	
	public void setHasAdmin(boolean enable){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putBoolean("admin", enable);
		editor.commit();
	}
	
	public boolean getAdminEnable(){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		return prefs.getBoolean("admin", false);
	}
	
	
	public void setLockEnable(boolean enable){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putBoolean("lock", enable);
		editor.commit();
	}
	
	public boolean getLockEnable(){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
		return prefs.getBoolean("lock", false);
	}
}
