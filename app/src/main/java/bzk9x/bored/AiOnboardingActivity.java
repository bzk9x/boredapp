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
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class AiOnboardingActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ImageView imageview2;
	private LinearLayout linear3;
	private ImageView imageview1;
	private TextView textview1;
	
	private TimerTask fadeInDelay;
	private ObjectAnimator fadeIn = new ObjectAnimator();
	private ObjectAnimator slideIn = new ObjectAnimator();
	private TimerTask sparkeRotateDelay;
	private ObjectAnimator sparkleRotate = new ObjectAnimator();
	private ObjectAnimator imageScaleX = new ObjectAnimator();
	private ObjectAnimator imageScaleY = new ObjectAnimator();
	private ObjectAnimator circleScaleX = new ObjectAnimator();
	private ObjectAnimator circleScaleY = new ObjectAnimator();
	private Intent ai = new Intent();
	private Vibrator vibrator;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.ai_onboarding);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		imageview2 = findViewById(R.id.imageview2);
		linear3 = findViewById(R.id.linear3);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { Window w = getWindow();  w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); };
		imageview1.setColorFilter(0xFFE7B4F9, PorterDuff.Mode.MULTIPLY);
		imageview2.setColorFilter(0xFFE7B4F9, PorterDuff.Mode.MULTIPLY);
		textview1.setText(textview1.getText().toString());
		
		TextPaint paint = textview1.getPaint();
		
		float width = paint.measureText(textview1.getText().toString()); 
		
		Shader textShader = new LinearGradient(0, 0, width, textview1.getTextSize(), new int[]{ 
				
				0xFFE7B4F9, 0xFF471E58,
				
				
		}, null,Shader.TileMode.CLAMP); 
		
		
		textview1.getPaint().setShader(textShader);
		linear2.setAlpha((float)(0));
		linear2.setTranslationY((float)(100));
		imageview2.setVisibility(View.GONE);
		linear3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)999, 0xFFE7B4F9));
		linear3.setVisibility(View.GONE);
		fadeInDelay = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						fadeIn.setTarget(linear2);
						fadeIn.setPropertyName("alpha");
						fadeIn.setFloatValues((float)(1));
						fadeIn.setDuration((int)(450));
						fadeIn.setInterpolator(new DecelerateInterpolator());
						fadeIn.start();
						sparkleRotate.setTarget(imageview1);
						sparkleRotate.setPropertyName("rotation");
						sparkleRotate.setFloatValues((float)(360));
						sparkleRotate.setDuration((int)(700));
						sparkleRotate.setInterpolator(new DecelerateInterpolator());
						sparkleRotate.start();
						slideIn.setTarget(linear2);
						slideIn.setPropertyName("translationY");
						slideIn.setFloatValues((float)(0));
						slideIn.setDuration((int)(450));
						slideIn.setInterpolator(new DecelerateInterpolator());
						slideIn.start();
						fadeInDelay = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										fadeIn.setTarget(textview1);
										fadeIn.setPropertyName("alpha");
										fadeIn.setFloatValues((float)(0));
										fadeIn.setDuration((int)(250));
										fadeIn.setInterpolator(new DecelerateInterpolator());
										fadeIn.start();
										fadeInDelay = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														linear2.setVisibility(View.GONE);
														imageview2.setVisibility(View.VISIBLE);
														fadeInDelay = new TimerTask() {
															@Override
															public void run() {
																runOnUiThread(new Runnable() {
																	@Override
																	public void run() {
																		imageScaleX.setTarget(imageview2);
																		imageScaleX.setPropertyName("scaleX");
																		imageScaleX.setFloatValues((float)(0.1d));
																		imageScaleX.setDuration((int)(250));
																		imageScaleX.setInterpolator(new LinearInterpolator());
																		imageScaleX.start();
																		imageScaleY.setTarget(imageview2);
																		imageScaleY.setPropertyName("scaleY");
																		imageScaleY.setFloatValues((float)(0.1d));
																		imageScaleY.setDuration((int)(250));
																		imageScaleY.setInterpolator(new LinearInterpolator());
																		imageScaleY.start();
																		fadeInDelay = new TimerTask() {
																			@Override
																			public void run() {
																				runOnUiThread(new Runnable() {
																					@Override
																					public void run() {
																						imageview2.setVisibility(View.GONE);
																						linear3.setVisibility(View.VISIBLE);
																						circleScaleX.setTarget(linear3);
																						circleScaleX.setPropertyName("scaleX");
																						circleScaleX.setFloatValues((float)(50));
																						circleScaleX.setDuration((int)(250));
																						circleScaleX.setInterpolator(new LinearInterpolator());
																						circleScaleX.start();
																						circleScaleY.setTarget(linear3);
																						circleScaleY.setPropertyName("scaleY");
																						circleScaleY.setFloatValues((float)(50));
																						circleScaleY.setDuration((int)(250));
																						circleScaleY.setInterpolator(new LinearInterpolator());
																						circleScaleY.start();
																						vibrator.vibrate((long)(5));
																						fadeInDelay = new TimerTask() {
																							@Override
																							public void run() {
																								runOnUiThread(new Runnable() {
																									@Override
																									public void run() {
																										ai.setClass(getApplicationContext(), GenerateAiActivity.class);
																										startActivity(ai);
																										overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
																										finish();
																									}
																								});
																							}
																						};
																						_timer.schedule(fadeInDelay, (int)(150));
																					}
																				});
																			}
																		};
																		_timer.schedule(fadeInDelay, (int)(250));
																	}
																});
															}
														};
														_timer.schedule(fadeInDelay, (int)(250));
													}
												});
											}
										};
										_timer.schedule(fadeInDelay, (int)(250));
									}
								});
							}
						};
						_timer.schedule(fadeInDelay, (int)(1500));
					}
				});
			}
		};
		_timer.schedule(fadeInDelay, (int)(250));
	}
	
	@Override
	public void onBackPressed() {
		
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