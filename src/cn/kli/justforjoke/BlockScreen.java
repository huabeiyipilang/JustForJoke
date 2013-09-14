package cn.kli.justforjoke;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class BlockScreen extends FloatView{
	private View mWarning;
	private Handler mHandler = new Handler();
	private Runnable mRunnable = new Runnable(){

		@Override
		public void run() {
			Intent intent = new Intent(mContext, JokeService.class);
			intent.setAction(JokeService.ACTION_UNBLOCK_SCREEN);
			mContext.startService(intent);
			
			new Config(mContext).setLockEnable(false);
		}
		
	};
	
	public BlockScreen(Context context) {
		super(context);
		mWarning = mContentView.findViewById(R.id.tv_warning);
		mWarning.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				int action = event.getAction();
				switch(action){
				case MotionEvent.ACTION_DOWN:
					mHandler.postDelayed(mRunnable, 10*1000);
					break;
				case MotionEvent.ACTION_UP:
					mHandler.removeCallbacks(mRunnable);
					break;
				}
				return false;
			}
			
		});
	}

	@Override
	int onInflaterContentView() {
		return R.layout.block_screen;
	}
}
