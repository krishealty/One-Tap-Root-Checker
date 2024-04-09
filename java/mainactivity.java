package com.krishealty.onetaprootchecker;



import android.animation.*;

import android.app.*;

import android.app.Activity;

import android.app.DialogFragment;

import android.app.Fragment;

import android.app.FragmentManager;

import android.content.*;

import android.content.Intent;

import android.content.res.*;

import android.graphics.*;

import android.graphics.Typeface;

import android.graphics.drawable.*;

import android.media.*;

import android.net.*;

import android.net.Uri;

import android.os.*;

import android.os.Bundle;

import android.text.*;

import android.text.style.*;

import android.util.*;

import android.view.*;

import android.view.View;

import android.view.View.*;

import android.view.animation.*;

import android.webkit.*;

import android.widget.*;

import android.widget.LinearLayout;

import android.widget.TextView;

import java.io.*;

import java.io.InputStream;

import java.text.*;

import java.util.*;

import java.util.regex.*;

import org.json.*;



public class MainActivity extends Activity {

	

	private LinearLayout linear1;

	private TextView header;

	private TextView check_button;

	private TextView credits_text;

	

	private Intent superuser = new Intent();

	private AlertDialog su;

	private Intent switch_page = new Intent();

	

	@Override

	protected void onCreate(Bundle _savedInstanceState) {

		super.onCreate(_savedInstanceState);

		setContentView(R.layout.main);

		initialize(_savedInstanceState);

		initializeLogic();

	}

	

	private void initialize(Bundle _savedInstanceState) {

		linear1 = findViewById(R.id.linear1);

		header = findViewById(R.id.header);

		check_button = findViewById(R.id.check_button);

		credits_text = findViewById(R.id.credits_text);

		

		check_button.setOnClickListener(new View.OnClickListener() {

			@Override

			public void onClick(View _view) {

				_ArabWareChannel();
				_ArabWareChannels();

			}

		});

		

		credits_text.setOnClickListener(new View.OnClickListener() {

			@Override

			public void onClick(View _view) {

				switch_page.setClass(getApplicationContext(), CreditsActivity.class);

				startActivity(switch_page);

			}

		});

	}

	

	private void initializeLogic() {

		header.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/plastic_dots.ttf"), 0);

		credits_text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/plastic_dots.ttf"), 0);

		check_button.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/plastic_dots.ttf"), 1);

	}

	

	
	public void _ArabWareChannel () {
		try {
			Runtime.getRuntime().exec("su");
			su = new AlertDialog.Builder(MainActivity.this).create();
			LayoutInflater suLI = getLayoutInflater();
			View suCV = (View) suLI.inflate(R.layout.su_success, null);
			su.setView(suCV);

			su.setCancelable(true);

			su.show();
		} catch (Exception e ) {
		}
	}

	

	public void _ArabWareChannels () {
		try {
			Runtime.getRuntime().exec("su");
		} catch (Exception e ) {
			su = new AlertDialog.Builder(MainActivity.this).create();
			LayoutInflater suLI = getLayoutInflater();
			View suCV = (View) suLI.inflate(R.layout.su_fail, null);
			su.setView(suCV);

			su.setCancelable(true);

			su.show();
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
