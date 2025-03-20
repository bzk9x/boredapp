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
import android.media.MediaPlayer;
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
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class MainNewActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private HashMap<String, Object> pages = new HashMap<>();
	private boolean swiping = false;
	private boolean timerRunning = false;
	private boolean binded = false;
	private boolean pageChanged = false;
	
	private ArrayList<HashMap<String, Object>> pagesMap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private ViewPager viewpager1;
	private HorizontalScrollView hscroll1;
	private LinearLayout linear7;
	private LinearLayout linear30;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear14;
	private LinearLayout linear13;
	private LinearLayout linear15;
	private LinearLayout linear12;
	private ImageView imageview13;
	private TextView textview21;
	private ImageView imageview1;
	private TextView textview2;
	private ImageView imageview2;
	private TextView textview3;
	private ImageView imageview3;
	private TextView textview4;
	private ImageView imageview4;
	private TextView textview5;
	private ImageView imageview5;
	private TextView textview8;
	private ImageView imageview6;
	private TextView textview7;
	private ImageView imageview8;
	private TextView textview9;
	private ImageView imageview9;
	private TextView textview6;
	
	private Vibrator vibrator;
	private MediaPlayer mediaPlayer;
	private TimerTask fadeOutDalay;
	private ObjectAnimator fadeOut = new ObjectAnimator();
	private TimerTask hideDrawerDelay;
	private ObjectAnimator hideDrawer = new ObjectAnimator();
	private TimerTask swipe_checking;
	private Intent standBy = new Intent();
	private TimerTask standbyDelay;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main_new);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		viewpager1 = findViewById(R.id.viewpager1);
		hscroll1 = findViewById(R.id.hscroll1);
		linear7 = findViewById(R.id.linear7);
		linear30 = findViewById(R.id.linear30);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		linear14 = findViewById(R.id.linear14);
		linear13 = findViewById(R.id.linear13);
		linear15 = findViewById(R.id.linear15);
		linear12 = findViewById(R.id.linear12);
		imageview13 = findViewById(R.id.imageview13);
		textview21 = findViewById(R.id.textview21);
		imageview1 = findViewById(R.id.imageview1);
		textview2 = findViewById(R.id.textview2);
		imageview2 = findViewById(R.id.imageview2);
		textview3 = findViewById(R.id.textview3);
		imageview3 = findViewById(R.id.imageview3);
		textview4 = findViewById(R.id.textview4);
		imageview4 = findViewById(R.id.imageview4);
		textview5 = findViewById(R.id.textview5);
		imageview5 = findViewById(R.id.imageview5);
		textview8 = findViewById(R.id.textview8);
		imageview6 = findViewById(R.id.imageview6);
		textview7 = findViewById(R.id.textview7);
		imageview8 = findViewById(R.id.imageview8);
		textview9 = findViewById(R.id.textview9);
		imageview9 = findViewById(R.id.imageview9);
		textview6 = findViewById(R.id.textview6);
		vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		viewpager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int _position, float _positionOffset, int _positionOffsetPixels) {
				if (binded) {
					swiping = true;
				}
			}
			
			@Override
			public void onPageSelected(int _position) {
				if (binded) {
					vibrator.vibrate((long)(5));
					mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.card_flip_2);
					mediaPlayer.start();
					viewpager1.setEnabled(false);
					pageChanged = true;
				}
			}
			
			@Override
			public void onPageScrollStateChanged(int _scrollState) {
				
			}
		});
	}
	
	private void initializeLogic() {
		binded = false;
		linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFF504154));
		linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear30.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		pages = new HashMap<>();
		pages.put("page", "0");
		pagesMap.add(pages);
		pages = new HashMap<>();
		pages.put("page", "1");
		pagesMap.add(pages);
		viewpager1.setAdapter(new Viewpager1Adapter(pagesMap));
		viewpager1.setCurrentItem((int)1);
		binded = true;
		swiping = false;
	}
	
	public void _Shape(final double _t1, final double _t2, final double _b1, final double _b2, final String _Background, final double _Stroke, final String _stroke, final double _Elevation, final View _view) {
		android.graphics.drawable.GradientDrawable gs = new android.graphics.drawable.GradientDrawable();
		
		gs.setColor(Color.parseColor(_Background));
		
		gs.setStroke((int)_Stroke, Color.parseColor(_stroke));
		
		gs.setCornerRadii(new float[]{(int)_t1,(int)_t1,(int)_t2,(int)_t2,(int)_b1,(int)_b1,(int)_b2,(int)_b2});
		
		_view.setBackground(gs);
		_view.setElevation((int)_Elevation);
	}
	
	
	public void _StartTransitionActivity(final Intent _intent, final View _view, final String _name) {
		//code made by LORD HOSSEIN 
		_view.setTransitionName(_name); 
		
		
		android.app.ActivityOptions optionsCompat = android.app.ActivityOptions.makeSceneTransitionAnimation(MainNewActivity.this, _view, _name); 
		startActivity(_intent, optionsCompat.toBundle());
	}
	
	public class Viewpager1Adapter extends PagerAdapter {
		
		Context _context;
		ArrayList<HashMap<String, Object>> _data;
		
		public Viewpager1Adapter(Context _ctx, ArrayList<HashMap<String, Object>> _arr) {
			_context = _ctx;
			_data = _arr;
		}
		
		public Viewpager1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_context = getApplicationContext();
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public boolean isViewFromObject(View _view, Object _object) {
			return _view == _object;
		}
		
		@Override
		public void destroyItem(ViewGroup _container, int _position, Object _object) {
			_container.removeView((View) _object);
		}
		
		@Override
		public int getItemPosition(Object _object) {
			return super.getItemPosition(_object);
		}
		
		@Override
		public CharSequence getPageTitle(int pos) {
			// Use the Activity Event (onTabLayoutNewTabAdded) in order to use this method
			return "page " + String.valueOf(pos);
		}
		
		@Override
		public Object instantiateItem(ViewGroup _container,  final int _position) {
			View _view = LayoutInflater.from(_context).inflate(R.layout.home, _container, false);
			
			final LinearLayout linear44 = _view.findViewById(R.id.linear44);
			final LinearLayout linear45 = _view.findViewById(R.id.linear45);
			final LinearLayout linear46 = _view.findViewById(R.id.linear46);
			final LinearLayout linear47 = _view.findViewById(R.id.linear47);
			final LinearLayout linear48 = _view.findViewById(R.id.linear48);
			final LinearLayout linear50 = _view.findViewById(R.id.linear50);
			final LinearLayout linear18 = _view.findViewById(R.id.linear18);
			final LinearLayout linear31 = _view.findViewById(R.id.linear31);
			final LinearLayout linear19 = _view.findViewById(R.id.linear19);
			final LinearLayout linear23 = _view.findViewById(R.id.linear23);
			final LinearLayout linear32 = _view.findViewById(R.id.linear32);
			final LinearLayout linear41 = _view.findViewById(R.id.linear41);
			final LinearLayout linear40 = _view.findViewById(R.id.linear40);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final ImageView imageview16 = _view.findViewById(R.id.imageview16);
			final LinearLayout linear21 = _view.findViewById(R.id.linear21);
			final LinearLayout linear22 = _view.findViewById(R.id.linear22);
			final TextView textview10 = _view.findViewById(R.id.textview10);
			final TextView textview11 = _view.findViewById(R.id.textview11);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout linear16 = _view.findViewById(R.id.linear16);
			final ImageView imageview10 = _view.findViewById(R.id.imageview10);
			final TextView textview12 = _view.findViewById(R.id.textview12);
			final LinearLayout linear52 = _view.findViewById(R.id.linear52);
			final TextView textview14 = _view.findViewById(R.id.textview14);
			
			if (_position == 0) {
				linear45.setVisibility(View.GONE);
				linear46.setVisibility(View.VISIBLE);
			}
			if (_position == 1) {
				linear45.setVisibility(View.VISIBLE);
				linear46.setVisibility(View.GONE);
			}
			_Shape(0, 64, 64, 0, "#130E14", 0, "#130E14", 0, linear50);
			_Shape(64, 0, 0, 64, "#130E14", 0, "#130E14", 0, linear52);
			swipe_checking = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							if (pageChanged) {
								pageChanged = false;
								standbyDelay = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												standBy.setClass(getApplicationContext(), StandbyActivity.class);
												startActivity(standBy);
												overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
											}
										});
									}
								};
								_timer.schedule(standbyDelay, (int)(500));
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(swipe_checking, (int)(0), (int)(1));
			
			_container.addView(_view);
			return _view;
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