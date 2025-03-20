package bzk9x.bored;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
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
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
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
import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class ProfileActivity extends AppCompatActivity {
	
	private HashMap<String, Object> friend = new HashMap<>();
	private HashMap<String, Object> userProfile = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> friends = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView imageview1;
	private LinearLayout linear8;
	private LinearLayout linear5;
	private ImageView imageview16;
	private LinearLayout linear9;
	private LinearLayout linear30;
	private LinearLayout linear31;
	private ImageView imageview17;
	private TextView textview22;
	private ImageView imageview13;
	private TextView textview21;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private CircleImageView circleimageview1;
	private TextView textview1;
	private TextView textview2;
	
	private SharedPreferences profile;
	private Intent createProfile = new Intent();
	private Intent edit = new Intent();
	private Intent circles = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		imageview1 = findViewById(R.id.imageview1);
		linear8 = findViewById(R.id.linear8);
		linear5 = findViewById(R.id.linear5);
		imageview16 = findViewById(R.id.imageview16);
		linear9 = findViewById(R.id.linear9);
		linear30 = findViewById(R.id.linear30);
		linear31 = findViewById(R.id.linear31);
		imageview17 = findViewById(R.id.imageview17);
		textview22 = findViewById(R.id.textview22);
		imageview13 = findViewById(R.id.imageview13);
		textview21 = findViewById(R.id.textview21);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		circleimageview1 = findViewById(R.id.circleimageview1);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		profile = getSharedPreferences("profile", Activity.MODE_PRIVATE);
		
		imageview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		linear30.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edit.setClass(getApplicationContext(), EditProfileActivity.class);
				startActivity(edit);
			}
		});
		
		linear31.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				circles.setClass(getApplicationContext(), CirclesOnboardingActivity.class);
				startActivity(circles);
			}
		});
	}
	
	private void initializeLogic() {
		_Shape(64, 64, 0, 0, "#000000", 0, "#000000", 0, linear4);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { Window w = getWindow();  w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); };
		linear30.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFF504154));
		linear31.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFF504154));
	}
	
	@Override
	public void onStart() {
		super.onStart();
		_loadProfile();
	}
	public void _Shape(final double _t1, final double _t2, final double _b1, final double _b2, final String _Background, final double _Stroke, final String _stroke, final double _Elevation, final View _view) {
		android.graphics.drawable.GradientDrawable gs = new android.graphics.drawable.GradientDrawable();
		
		gs.setColor(Color.parseColor(_Background));
		
		gs.setStroke((int)_Stroke, Color.parseColor(_stroke));
		
		gs.setCornerRadii(new float[]{(int)_t1,(int)_t1,(int)_t2,(int)_t2,(int)_b1,(int)_b1,(int)_b2,(int)_b2});
		
		_view.setBackground(gs);
		_view.setElevation((int)_Elevation);
	}
	
	
	public void _loadProfile() {
		if (profile.getString("profile", "").equals("")) {
			createProfile.setClass(getApplicationContext(), CreateProfileActivity.class);
			startActivity(createProfile);
		}
		else {
			userProfile = new Gson().fromJson(profile.getString("profile", ""), new TypeToken<HashMap<String, Object>>(){}.getType());
			textview2.setText(userProfile.get("username").toString());
			if (!userProfile.containsKey("banner")) {
				imageview1.setImageResource(R.drawable.bored_banner);
			}
			else {
				if (userProfile.get("banner").toString().equals("DEFAULT")) {
					imageview1.setImageResource(R.drawable.bored_banner);
				}
				else {
					Glide.with(getApplicationContext()).load(Uri.parse(userProfile.get("banner").toString())).into(imageview1);
				}
			}
			if (!userProfile.containsKey("display_name")) {
				textview1.setText(userProfile.get("username").toString());
			}
			else {
				textview1.setText(userProfile.get("display_name").toString());
			}
			if (userProfile.get("avatar").toString().equals("DEFAULT_1")) {
				circleimageview1.setImageResource(R.drawable.avatar_1);
			}
			else {
				if (userProfile.get("avatar").toString().equals("DEFAULT_2")) {
					circleimageview1.setImageResource(R.drawable.avatar_2);
				}
				else {
					if (userProfile.get("avatar").toString().equals("DEFAULT_3")) {
						circleimageview1.setImageResource(R.drawable.avatar_3);
					}
					else {
						if (userProfile.get("avatar").toString().equals("DEFAULT_4")) {
							circleimageview1.setImageResource(R.drawable.avatar_4);
						}
						else {
							if (userProfile.get("avatar").toString().equals("DEFAULT_5")) {
								circleimageview1.setImageResource(R.drawable.avatar_5);
							}
							else {
								if (userProfile.get("avatar").toString().equals("DEFAULT_6")) {
									circleimageview1.setImageResource(R.drawable.avatar_6);
								}
								else {
									if (userProfile.get("avatar").toString().equals("DEFAULT_7")) {
										circleimageview1.setImageResource(R.drawable.avatar_7);
									}
									else {
										if (userProfile.get("avatar").toString().equals("DEFAULT_8")) {
											circleimageview1.setImageResource(R.drawable.avatar_8);
										}
										else {
											if (userProfile.get("avatar").toString().equals("DEFAULT_9")) {
												circleimageview1.setImageResource(R.drawable.avatar_9);
											}
											else {
												if (userProfile.get("avatar").toString().equals("DEFAULT_10")) {
													circleimageview1.setImageResource(R.drawable.avatar_10);
												}
												else {
													Glide.with(getApplicationContext()).load(Uri.parse(userProfile.get("avatar").toString())).into(circleimageview1);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
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