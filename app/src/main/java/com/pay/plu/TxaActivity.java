package com.pay.plu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class TxaActivity extends AppCompatActivity {
	
	private double highscore = 0;
	
	private LinearLayout linear1;
	
	private SharedPreferences sp;
	private MediaPlayer k;
	private MediaPlayer k1;
	private Intent o = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.txa);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
	}
	
	private void initializeLogic() {
		k = MediaPlayer.create(getApplicationContext(), R.raw.game);
		k.start();
		if (sp.getString("hs", "").equals("")) {
			highscore = 0;
		}
		else {
			highscore = Double.parseDouble(sp.getString("hs", ""));
		}
		GameView bcv = new GameView(this);
		linear1.addView(bcv);
		_NavStatusBarColor("#6A99DF", "#404040");
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		finish();
		k.pause();
	}
	public void _extra () {
	}
	
	public class GameView extends View{
		private Paint myPaint;
		private int speed=1;
		private int time = 0;
		private int score = 0;
		private int myCarPosition = 1;
		private ArrayList<HashMap<String, Object>> otherCars = new ArrayList<>();
		
		int viewWidth = 0;
		int viewHeight = 0;
		
		public GameView(Context context){
			super(context);
			myPaint = new Paint();
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			viewWidth = this.getMeasuredWidth();
			viewHeight = this.getMeasuredHeight();
			
			if (time%700 < 10 + speed){
				HashMap<String, Object> map = new HashMap<>();
				map.put("lane", getRandom(0,2));
				map.put("startTime", time);
				otherCars.add(map);
			}
			
			time = time + 10 + speed;
			
			int carWidth = viewWidth/3;
			int carHeight = carWidth+20;
			
			myPaint.setStyle(android.graphics.Paint.Style.FILL);
			
			android.graphics.drawable.Drawable d = getResources().getDrawable(R.drawable.ako_3, null);
			d.setBounds((myCarPosition*viewWidth/3) + viewWidth/20 + 25, viewHeight - 2 -carHeight, (myCarPosition*viewWidth/3) + (viewWidth/15) + carWidth-25, viewHeight-2);
			d.draw(canvas);
			
			myPaint.setColor(Color.GREEN);
			
			for (int i = 0; i<otherCars.size(); i++){
				int carX = ((int)otherCars.get(i).get("lane")*viewWidth/3) + viewWidth/15;
				int carY = time - (int)otherCars.get(i).get("startTime");
				
				android.graphics.drawable.Drawable d2 = getResources().getDrawable(R.drawable.ako_4, null);
				d2.setBounds(carX+25, carY-carHeight, carX + carWidth-25, carY);
				d2.draw(canvas);
				
				if ((int)otherCars.get(i).get("lane") == myCarPosition){
					if (carY > viewHeight - 2 - carHeight && carY < viewHeight - 2){
						sp.edit().putString("hs", String.valueOf((int)highscore)).commit();
						sp.edit().putString("score", String.valueOf(score)).commit();
						k.pause();
						k1 = MediaPlayer.create(getApplicationContext(), R.raw.lv_0_20210809112118);
						k1.start();
						SketchwareUtil.showMessage(getApplicationContext(), "ဟာနိုင်အောင်ကစားလေကွာ😒 နင်အဲ့တာကြောင့်ရည်းစားမရတာ......");
						finish();
					}}
				
				if (carY > viewHeight + carHeight){
					otherCars.remove(i);
					score++;
					speed = 1 + Math.abs(score/8);
					if (score > highscore){
						highscore = score;
					}
				}
			}
			
			myPaint.setColor(Color.WHITE);
			myPaint.setTextSize(40);
			canvas.drawText("Score: " + String.valueOf(score), 80f, 80f, myPaint);
			canvas.drawText("Speed: " + String.valueOf(speed), 380f, 80f, myPaint);
			
			invalidate();
		}
		
		@Override
		public boolean onTouchEvent(MotionEvent event) {
			switch(event.getAction()) {
				case MotionEvent.ACTION_DOWN:
				float x1 = event.getX();
				if ( x1<viewWidth/2){
					if (myCarPosition>0){
						myCarPosition--;
					}
				}
				if ( x1>viewWidth/2){
					if (myCarPosition<2){
						myCarPosition++;
					}
				}
				invalidate();
				break;
				case MotionEvent.ACTION_UP:
				break;
			}
			return true;
			
			
		}
		
	}
	
	
	public void _NavStatusBarColor (final String _color1, final String _color2) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#" + _color1.replace("#", "")));	w.setNavigationBarColor(Color.parseColor("#" + _color2.replace("#", "")));
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}