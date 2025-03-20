package bzk9x.bored;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class SettingsActivity extends AppCompatActivity {
	
	private boolean hapticsEnabled = false;
	private boolean animationsEnabled = false;
	private boolean useAi = false;
	private boolean saveHistory = false;
	private boolean useLocation = false;
	private double lat = 0;
	private double lng = 0;
	private double acc = 0;
	private boolean noVib = false;
	private boolean vib = false;
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private TextView textview5;
	private LinearLayout linear10;
	private LinearLayout linear13;
	private TextView textview8;
	private LinearLayout linear16;
	private LinearLayout linear25;
	private TextView textview15;
	private LinearLayout linear28;
	private TextView textview18;
	private TextView textview11;
	private LinearLayout linear19;
	private LinearLayout linear22;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private TextView textview6;
	private Switch switch3;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private TextView textview7;
	private Switch switch4;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private TextView textview10;
	private Switch switch5;
	private LinearLayout linear26;
	private LinearLayout linear27;
	private TextView textview14;
	private Switch switch8;
	private ImageView imageview4;
	private LinearLayout linear29;
	private LinearLayout linear31;
	private LinearLayout linear30;
	private TextView textview16;
	private TextView textview19;
	private TextView textview17;
	private SeekBar seekbar1;
	private LinearLayout linear20;
	private LinearLayout linear21;
	private TextView textview12;
	private Switch switch6;
	private ImageView imageview2;
	private LinearLayout linear23;
	private LinearLayout linear24;
	private TextView textview13;
	private Switch switch7;
	private ImageView imageview3;
	
	private SharedPreferences settings;
	private Intent requestLocationPermission = new Intent();
	private Intent twitter = new Intent();
	private Intent coffee = new Intent();
	private Intent about = new Intent();
	private Vibrator vibrator;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.settings);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		textview5 = findViewById(R.id.textview5);
		linear10 = findViewById(R.id.linear10);
		linear13 = findViewById(R.id.linear13);
		textview8 = findViewById(R.id.textview8);
		linear16 = findViewById(R.id.linear16);
		linear25 = findViewById(R.id.linear25);
		textview15 = findViewById(R.id.textview15);
		linear28 = findViewById(R.id.linear28);
		textview18 = findViewById(R.id.textview18);
		textview11 = findViewById(R.id.textview11);
		linear19 = findViewById(R.id.linear19);
		linear22 = findViewById(R.id.linear22);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		textview6 = findViewById(R.id.textview6);
		switch3 = findViewById(R.id.switch3);
		linear14 = findViewById(R.id.linear14);
		linear15 = findViewById(R.id.linear15);
		textview7 = findViewById(R.id.textview7);
		switch4 = findViewById(R.id.switch4);
		linear17 = findViewById(R.id.linear17);
		linear18 = findViewById(R.id.linear18);
		textview10 = findViewById(R.id.textview10);
		switch5 = findViewById(R.id.switch5);
		linear26 = findViewById(R.id.linear26);
		linear27 = findViewById(R.id.linear27);
		textview14 = findViewById(R.id.textview14);
		switch8 = findViewById(R.id.switch8);
		imageview4 = findViewById(R.id.imageview4);
		linear29 = findViewById(R.id.linear29);
		linear31 = findViewById(R.id.linear31);
		linear30 = findViewById(R.id.linear30);
		textview16 = findViewById(R.id.textview16);
		textview19 = findViewById(R.id.textview19);
		textview17 = findViewById(R.id.textview17);
		seekbar1 = findViewById(R.id.seekbar1);
		linear20 = findViewById(R.id.linear20);
		linear21 = findViewById(R.id.linear21);
		textview12 = findViewById(R.id.textview12);
		switch6 = findViewById(R.id.switch6);
		imageview2 = findViewById(R.id.imageview2);
		linear23 = findViewById(R.id.linear23);
		linear24 = findViewById(R.id.linear24);
		textview13 = findViewById(R.id.textview13);
		switch7 = findViewById(R.id.switch7);
		imageview3 = findViewById(R.id.imageview3);
		settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		linear25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				about.setClass(getApplicationContext(), DescriptionActivity.class);
				startActivity(about);
			}
		});
		
		linear19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				twitter.setAction(Intent.ACTION_VIEW);
				twitter.setData(Uri.parse("https://x.com/tiwafr"));
				startActivity(twitter);
			}
		});
		
		linear22.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				coffee.setAction(Intent.ACTION_VIEW);
				coffee.setData(Uri.parse("https://buymeacoffee.com/bzk9z"));
				startActivity(coffee);
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					settings.edit().putString("aiEnabled", "1").commit();
					switch4.setEnabled(true);
					switch5.setEnabled(true);
				}
				else {
					settings.edit().putString("aiEnabled", "0").commit();
					switch4.setEnabled(false);
					switch5.setEnabled(false);
				}
			}
		});
		
		switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					settings.edit().putString("useLocation", "1").commit();
					requestLocationPermission.setClass(getApplicationContext(), RequestLocationPermissionActivity.class);
					startActivity(requestLocationPermission);
					overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
				}
				else {
					settings.edit().putString("useLocation", "0").commit();
				}
			}
		});
		
		switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					settings.edit().putString("saveHistory", "1").commit();
				}
				else {
					settings.edit().putString("saveHistory", "0").commit();
				}
			}
		});
		
		seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				if (vib) {
					vibrator.vibrate((long)(3));
				}
				textview17.setText(String.valueOf((long)(_progressValue)));
				settings.edit().putString("precision-creativity", String.valueOf((long)(_progressValue))).commit();
				if (_progressValue == 0) {
					textview19.setText("Disabled");
				}
				if ((_progressValue == 1) || (_progressValue == 2)) {
					textview19.setText("Freestyle mode");
				}
				if ((_progressValue == 3) || (_progressValue == 4)) {
					textview19.setText("Open-minded");
				}
				if ((_progressValue == 5) || (_progressValue == 6)) {
					textview19.setText("Even balanced");
				}
				if ((_progressValue == 7) || (_progressValue == 8)) {
					textview19.setText("On target");
				}
				if ((_progressValue == 9) || (_progressValue == 10)) {
					textview19.setText("Exact match");
				}
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				
			}
		});
	}
	
	private void initializeLogic() {
		vscroll1.setHorizontalScrollBarEnabled(false);
		linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)64, 0xFF130E14));
		linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)64, 0xFF130E14));
		linear16.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)64, 0xFF130E14));
		linear19.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)64, 0xFF130E14));
		linear22.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)64, 0xFF130E14));
		linear25.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)64, 0xFF130E14));
		linear28.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)64, 0xFF130E14));
		switch6.setEnabled(false);
		switch7.setEnabled(false);
		linear10.setVisibility(View.GONE);
		vib = false;
		if (settings.getString("aiEnabled", "").equals("0")) {
			switch3.setChecked(false);
			switch4.setEnabled(false);
			switch5.setEnabled(false);
		}
		else {
			switch3.setChecked(true);
			switch4.setEnabled(true);
			switch5.setEnabled(true);
		}
		if (settings.getString("useLocation", "").equals("0")) {
			switch4.setChecked(false);
		}
		else {
			switch4.setChecked(true);
		}
		if (settings.getString("saveHistory", "").equals("0")) {
			switch5.setChecked(false);
		}
		else {
			switch5.setChecked(true);
		}
		if (settings.getString("precision-creativity", "").equals("")) {
			settings.edit().putString("precision-creativity", "5").commit();
			seekbar1.setProgress((int)5);
			vib = true;
		}
		else {
			seekbar1.setProgress((int)Double.parseDouble(settings.getString("precision-creativity", "")));
			vib = true;
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