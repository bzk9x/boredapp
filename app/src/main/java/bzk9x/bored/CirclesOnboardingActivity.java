package bzk9x.bored;

import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.content.*;
import android.content.Context;
import android.content.Intent;
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
import android.view.View.*;
import android.view.animation.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class CirclesOnboardingActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear4;
	private TextView textview1;
	private LinearLayout linear17;
	private TextView textview8;
	private LinearLayout linear19;
	private LinearLayout linear21;
	private LinearLayout linear23;
	private TextView textview9;
	private LinearLayout linear29;
	private LinearLayout imageSpinContainer;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear10;
	private CircleImageView circleimageview2;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private CircleImageView circleimageview3;
	private CircleImageView circleimageview1;
	private CircleImageView circleimageview4;
	private LinearLayout linear16;
	private CircleImageView circleimageview5;
	private TextView textview2;
	private LinearLayout linear20;
	private ImageView imageview1;
	private TextView textview3;
	private TextView textview4;
	private LinearLayout linear22;
	private ImageView imageview2;
	private TextView textview5;
	private TextView textview6;
	private LinearLayout linear24;
	private ImageView imageview3;
	private TextView textview7;
	private ImageView imageview12;
	private TextView textview20;
	
	private ObjectAnimator imagespin = new ObjectAnimator();
	private ObjectAnimator rotate = new ObjectAnimator();
	private ObjectAnimator counter1 = new ObjectAnimator();
	private ObjectAnimator counter2 = new ObjectAnimator();
	private ObjectAnimator counter3 = new ObjectAnimator();
	private ObjectAnimator counter4 = new ObjectAnimator();
	private ObjectAnimator scaleX = new ObjectAnimator();
	private ObjectAnimator scaleY = new ObjectAnimator();
	private TimerTask sclaleInDelay;
	private TimerTask scaleInComplete;
	private Vibrator vibrator;
	private Intent start_rotate_delay = new Intent();
	private TimerTask start_rotate_delay_;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.circles_onboarding);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear4 = findViewById(R.id.linear4);
		textview1 = findViewById(R.id.textview1);
		linear17 = findViewById(R.id.linear17);
		textview8 = findViewById(R.id.textview8);
		linear19 = findViewById(R.id.linear19);
		linear21 = findViewById(R.id.linear21);
		linear23 = findViewById(R.id.linear23);
		textview9 = findViewById(R.id.textview9);
		linear29 = findViewById(R.id.linear29);
		imageSpinContainer = findViewById(R.id.imageSpinContainer);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		linear10 = findViewById(R.id.linear10);
		circleimageview2 = findViewById(R.id.circleimageview2);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		linear14 = findViewById(R.id.linear14);
		circleimageview3 = findViewById(R.id.circleimageview3);
		circleimageview1 = findViewById(R.id.circleimageview1);
		circleimageview4 = findViewById(R.id.circleimageview4);
		linear16 = findViewById(R.id.linear16);
		circleimageview5 = findViewById(R.id.circleimageview5);
		textview2 = findViewById(R.id.textview2);
		linear20 = findViewById(R.id.linear20);
		imageview1 = findViewById(R.id.imageview1);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		linear22 = findViewById(R.id.linear22);
		imageview2 = findViewById(R.id.imageview2);
		textview5 = findViewById(R.id.textview5);
		textview6 = findViewById(R.id.textview6);
		linear24 = findViewById(R.id.linear24);
		imageview3 = findViewById(R.id.imageview3);
		textview7 = findViewById(R.id.textview7);
		imageview12 = findViewById(R.id.imageview12);
		textview20 = findViewById(R.id.textview20);
		vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	}
	
	private void initializeLogic() {
		sclaleInDelay = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						scaleX.setTarget(imageSpinContainer);
						scaleX.setPropertyName("scaleX");
						scaleX.setFloatValues((float)(1));
						scaleX.setDuration((int)(500));
						scaleX.setInterpolator(new DecelerateInterpolator());
						scaleX.start();
						scaleY.setTarget(imageSpinContainer);
						scaleY.setPropertyName("scaleY");
						scaleY.setFloatValues((float)(1));
						scaleY.setDuration((int)(500));
						scaleY.setInterpolator(new DecelerateInterpolator());
						scaleY.start();
						scaleInComplete = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										vibrator.vibrate((long)(5));
									}
								});
							}
						};
						_timer.schedule(scaleInComplete, (int)(500));
						start_rotate_delay_ = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										imagespin.setTarget(imageSpinContainer);
										imagespin.setPropertyName("rotation");
										imagespin.setFloatValues((float)(360));
										imagespin.setDuration((int)(6000));
										imagespin.setRepeatMode(ValueAnimator.RESTART);
										imagespin.setRepeatCount((int)(-1));
										imagespin.setInterpolator(new LinearInterpolator());
										imagespin.start();
										rotate.setTarget(circleimageview1);
										rotate.setPropertyName("rotation");
										rotate.setFloatValues((float)(-360));
										rotate.setDuration((int)(6000));
										rotate.setRepeatMode(ValueAnimator.RESTART);
										rotate.setRepeatCount((int)(-1));
										rotate.setInterpolator(new LinearInterpolator());
										rotate.start();
										counter1.setTarget(circleimageview2);
										counter1.setPropertyName("rotation");
										counter1.setFloatValues((float)(-360));
										counter1.setDuration((int)(6000));
										counter1.setRepeatMode(ValueAnimator.RESTART);
										counter1.setRepeatCount((int)(-1));
										counter1.setInterpolator(new LinearInterpolator());
										counter1.start();
										counter2.setTarget(circleimageview3);
										counter2.setPropertyName("rotation");
										counter2.setFloatValues((float)(-360));
										counter2.setDuration((int)(6000));
										counter2.setRepeatMode(ValueAnimator.RESTART);
										counter2.setRepeatCount((int)(-1));
										counter2.setInterpolator(new LinearInterpolator());
										counter2.start();
										counter3.setTarget(circleimageview4);
										counter3.setPropertyName("rotation");
										counter3.setFloatValues((float)(-360));
										counter3.setDuration((int)(6000));
										counter3.setRepeatMode(ValueAnimator.RESTART);
										counter3.setRepeatCount((int)(-1));
										counter3.setInterpolator(new LinearInterpolator());
										counter3.start();
										counter4.setTarget(circleimageview5);
										counter4.setPropertyName("rotation");
										counter4.setFloatValues((float)(-360));
										counter4.setDuration((int)(6000));
										counter4.setRepeatMode(ValueAnimator.RESTART);
										counter4.setRepeatCount((int)(-1));
										counter4.setInterpolator(new LinearInterpolator());
										counter4.start();
									}
								});
							}
						};
						_timer.schedule(start_rotate_delay_, (int)(1500));
					}
				});
			}
		};
		_timer.schedule(sclaleInDelay, (int)(250));
		imageSpinContainer.setScaleX((float)(0));
		imageSpinContainer.setScaleY((float)(0));
		linear17.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)64, 0xFF130E14));
		linear19.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)32, 0xFF130E14));
		linear21.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)32, 0xFF130E14));
		linear23.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)32, 0xFF130E14));
		linear29.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFF471E58));
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