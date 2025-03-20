package bzk9x.bored;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
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
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class NoAccountActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private LinearLayout linear18;
	private LinearLayout linear19;
	private ImageView imageview11;
	private TextView textview11;
	private TextView textview1;
	private TextView textview8;
	private LinearLayout linear16;
	private LinearLayout linear20;
	private ImageView imageview10;
	private TextView textview9;
	private ImageView imageview12;
	private TextView textview12;
	
	private Intent createAccount = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.no_account);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear18 = findViewById(R.id.linear18);
		linear19 = findViewById(R.id.linear19);
		imageview11 = findViewById(R.id.imageview11);
		textview11 = findViewById(R.id.textview11);
		textview1 = findViewById(R.id.textview1);
		textview8 = findViewById(R.id.textview8);
		linear16 = findViewById(R.id.linear16);
		linear20 = findViewById(R.id.linear20);
		imageview10 = findViewById(R.id.imageview10);
		textview9 = findViewById(R.id.textview9);
		imageview12 = findViewById(R.id.imageview12);
		textview12 = findViewById(R.id.textview12);
		
		imageview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		textview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				createAccount.setClass(getApplicationContext(), AuthActivity.class);
				startActivity(createAccount);
			}
		});
	}
	
	private void initializeLogic() {
		imageview10.setColorFilter(0xFF471E58, PorterDuff.Mode.MULTIPLY);
		_RippleEffect(linear16, 99, 0, "#E7B4F9", true);
		_RippleEffect(linear20, 99, 0, "#504154", true);
	}
	
	public void _Shape(final double _t1, final double _t2, final double _b1, final double _b2, final String _Background, final double _Stroke, final String _stroke, final double _Elevation, final View _view) {
		android.graphics.drawable.GradientDrawable gs = new android.graphics.drawable.GradientDrawable();
		
		gs.setColor(Color.parseColor(_Background));
		
		gs.setStroke((int)_Stroke, Color.parseColor(_stroke));
		
		gs.setCornerRadii(new float[]{(int)_t1,(int)_t1,(int)_t2,(int)_t2,(int)_b1,(int)_b1,(int)_b2,(int)_b2});
		
		_view.setBackground(gs);
		_view.setElevation((int)_Elevation);
	}
	
	
	public void _RippleEffect(final View _view, final double _radius, final double _shadow, final String _color, final boolean _ripple) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setElevation((int)_shadow);
			
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#212121")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setBackground(gd);
			_view.setElevation((int)_shadow);
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