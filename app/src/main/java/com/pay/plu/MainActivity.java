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
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class MainActivity extends AppCompatActivity {
	
	private boolean n = false;
	
	private LinearLayout linear1;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private ImageView imageview1;
	private LinearLayout linear6;
	private ImageView imageview2;
	private LinearLayout linear8;
	private ImageView imageview3;
	
	private Intent dd = new Intent();
	private SharedPreferences sp;
	private MediaPlayer k;
	private Intent o = new Intent();
	private SharedPreferences p;
	private Intent z = new Intent();
	private Intent t = new Intent();
	private Intent ku = new Intent();
	private Intent so = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		p = getSharedPreferences("p", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog aboutdialog = new AlertDialog.Builder(MainActivity.this).create();
				View inflate = getLayoutInflater().inflate(R.layout.chi,null); 
				aboutdialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				aboutdialog.setView(inflate);
				LinearLayout linear1 = (LinearLayout) inflate.findViewById(R.id.linear1);
				LinearLayout linear2 = (LinearLayout) inflate.findViewById(R.id.linear2);
				LinearLayout linear3 = (LinearLayout) inflate.findViewById(R.id.linear3);
				HorizontalScrollView hscroll1 = (HorizontalScrollView) inflate.findViewById(R.id.hscroll1);
				ImageView imageview1 = (ImageView) inflate.findViewById(R.id.imageview1);
				ImageView imageview2 = (ImageView) inflate.findViewById(R.id.imageview2);
				ImageView imageview3 = (ImageView) inflate.findViewById(R.id.imageview3);
				ImageView imageview4 = (ImageView) inflate.findViewById(R.id.imageview4);
				androidx.cardview.widget.CardView cardview1 = (androidx.cardview.widget.CardView) inflate.findViewById(R.id.cardview1);
				androidx.cardview.widget.CardView cardview2 = (androidx.cardview.widget.CardView) inflate.findViewById(R.id.cardview2);
				androidx.cardview.widget.CardView cardview3 = (androidx.cardview.widget.CardView) inflate.findViewById(R.id.cardview3);
				androidx.cardview.widget.CardView cardview5 = (androidx.cardview.widget.CardView) inflate.findViewById(R.id.cardview5);
				androidx.cardview.widget.CardView cardview7 = (androidx.cardview.widget.CardView) inflate.findViewById(R.id.cardview7);
				cardview1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						aboutdialog.dismiss();
						dd.setClass(getApplicationContext(), PlayActivity.class);
						startActivity(dd);
					}
				});
				aboutdialog.setCancelable(false);
				aboutdialog.show();
				cardview2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						aboutdialog.dismiss();
						z.setClass(getApplicationContext(), ZawActivity.class);
						startActivity(z);
					}
				});
				aboutdialog.setCancelable(false);
				aboutdialog.show();
				cardview3.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						aboutdialog.dismiss();
						t.setClass(getApplicationContext(), TxaActivity.class);
						startActivity(t);
					}
				});
				aboutdialog.setCancelable(false);
				aboutdialog.show();
				cardview5.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						aboutdialog.dismiss();
						ku.setClass(getApplicationContext(), KyuActivity.class);
						startActivity(ku);
					}
				});
				aboutdialog.setCancelable(false);
				aboutdialog.show();
				cardview7.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						aboutdialog.dismiss();
						so.setClass(getApplicationContext(), SoeActivity.class);
						startActivity(so);
					}
				});
				aboutdialog.setCancelable(false);
				aboutdialog.show();
				imageview1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						aboutdialog.dismiss();
					}
				});
				aboutdialog.setCancelable(false);
				aboutdialog.show();
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog aboutdialog = new AlertDialog.Builder(MainActivity.this).create();
				View inflate = getLayoutInflater().inflate(R.layout.abo,null); 
				aboutdialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				aboutdialog.setView(inflate);
				ImageView mal = (ImageView) inflate.findViewById(R.id.mal);
				LinearLayout linear1 = (LinearLayout) inflate.findViewById(R.id.linear1);
				LinearLayout linear2 = (LinearLayout) inflate.findViewById(R.id.linear2);
				mal.setImageResource(R.drawable.kok_2);
				
				linear2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						aboutdialog.dismiss();
					}
				});
				linear1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						o.setAction(Intent.ACTION_VIEW);
						o.setData(Uri.parse("https://m.me/koy2021"));
						startActivity(o);
					}
				});
				aboutdialog.setCancelable(false);
				aboutdialog.show();
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog aboutdialog = new AlertDialog.Builder(MainActivity.this).create();
				View inflate = getLayoutInflater().inflate(R.layout.dia,null); 
				aboutdialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				aboutdialog.setView(inflate);
				LinearLayout linear1 = (LinearLayout) inflate.findViewById(R.id.linear1);
				LinearLayout linear2 = (LinearLayout) inflate.findViewById(R.id.linear2);
				LinearLayout linear3 = (LinearLayout) inflate.findViewById(R.id.linear3);
				LinearLayout linear4 = (LinearLayout) inflate.findViewById(R.id.linear4);
				TextView k1 = (TextView) inflate.findViewById(R.id.k1);
				TextView k2 = (TextView) inflate.findViewById(R.id.k2);
				
				
				k1.setText(sp.getString("hs", ""));
				k2.setText(sp.getString("score", ""));
				sp.edit().putString("score", "").commit();
				linear4.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						aboutdialog.dismiss();
					}
				});
				aboutdialog.setCancelable(false);
				aboutdialog.show();
			}
		});
	}
	
	private void initializeLogic() {
		
		
		_NavStatusBarColor("#E47501", "#FFFFFF");
		if (p.getString("ky", "").equals("")) {
			final AlertDialog aboutdialog = new AlertDialog.Builder(MainActivity.this).create();
			View inflate = getLayoutInflater().inflate(R.layout.abo,null); 
			aboutdialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
			aboutdialog.setView(inflate);
			ImageView mal = (ImageView) inflate.findViewById(R.id.mal);
			LinearLayout linear1 = (LinearLayout) inflate.findViewById(R.id.linear1);
			LinearLayout linear2 = (LinearLayout) inflate.findViewById(R.id.linear2);
			mal.setImageResource(R.drawable.kok_1);
			
			linear2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
					p.edit().putString("ky", "1").commit();
					n = true;
					aboutdialog.dismiss();
				}
			});
			linear1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
					o.setAction(Intent.ACTION_VIEW);
					o.setData(Uri.parse("https://m.me/koy2021"));
					startActivity(o);
				}
			});
			aboutdialog.setCancelable(false);
			aboutdialog.show();
			n = false;
		}
		else {
			if (p.getString("ky", "").equals("1")) {
				n = true;
			}
			else {
				n = false;
			}
		}
		
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
	public void onStart() {
		super.onStart();
		if (sp.getString("hs", "").equals("")) {
			
		}
		else {
			if (sp.getString("score", "").equals("")) {
				
			}
			else {
				final AlertDialog aboutdialog = new AlertDialog.Builder(MainActivity.this).create();
				View inflate = getLayoutInflater().inflate(R.layout.dia,null); 
				aboutdialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				aboutdialog.setView(inflate);
				LinearLayout linear1 = (LinearLayout) inflate.findViewById(R.id.linear1);
				LinearLayout linear2 = (LinearLayout) inflate.findViewById(R.id.linear2);
				LinearLayout linear3 = (LinearLayout) inflate.findViewById(R.id.linear3);
				LinearLayout linear4 = (LinearLayout) inflate.findViewById(R.id.linear4);
				TextView k1 = (TextView) inflate.findViewById(R.id.k1);
				TextView k2 = (TextView) inflate.findViewById(R.id.k2);
				
				
				k1.setText(sp.getString("hs", ""));
				k2.setText(sp.getString("score", ""));
				sp.edit().putString("score", "").commit();
				linear4.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						aboutdialog.dismiss();
					}
				});
				aboutdialog.setCancelable(false);
				aboutdialog.show();
			}
		}
	}
	
	@Override
	public void onBackPressed() {
		final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(MainActivity.this);
		
		View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.ext,null );
		bottomSheetDialog.setContentView(bottomSheetView);
		
		bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
		androidx.cardview.widget.CardView cardview1 = (androidx.cardview.widget.CardView) bottomSheetView.findViewById(R.id.cardview1);
		LinearLayout linear3 = (LinearLayout) bottomSheetView.findViewById(R.id.linear3);
		LinearLayout linear6 = (LinearLayout) bottomSheetView.findViewById(R.id.linear6);
		LinearLayout linear5 = (LinearLayout) bottomSheetView.findViewById(R.id.linear5);
		
		
		linear5.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
				bottomSheetDialog.dismiss();
				finish();
			}
		});
		linear6.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
				bottomSheetDialog.dismiss();
				SketchwareUtil.showMessage(getApplicationContext(), "App by plugin");
			}
		});
		bottomSheetDialog.setCancelable(true);
		bottomSheetDialog.show();
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