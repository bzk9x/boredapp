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
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
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

public class StartAppActivity extends AppCompatActivity {
	
	private boolean hapticsEnabled = false;
	private boolean animationsEnabled = false;
	private boolean useAi = false;
	private boolean saveHistory = false;
	private boolean useLocation = false;
	
	private LinearLayout linear1;
	
	private SharedPreferences sertings;
	private Intent startApp = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.start_app);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		sertings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
	}
	
	private void initializeLogic() {
		_getSettings();
		if (useLocation) {
			startApp.setClass(getApplicationContext(), LoadingGetLocationActivity.class);
			startActivity(startApp);
			finish();
		}
		else {
			startApp.setClass(getApplicationContext(), AiOnboardingActivity.class);
			startActivity(startApp);
			finish();
		}
	}
	
	public void _getSettings() {
		if (sertings.getString("disableHaptics", "").equals("")) {
			sertings.edit().putString("disableHaptics", "0").commit();
		}
		if (sertings.getString("disableAnimations", "").equals("")) {
			sertings.edit().putString("disableAnimations", "0").commit();
		}
		if (sertings.getString("aiEnabled", "").equals("")) {
			sertings.edit().putString("aiEnabled", "1").commit();
		}
		if (sertings.getString("useLocation", "").equals("")) {
			sertings.edit().putString("useLocation", "0").commit();
		}
		if (sertings.getString("saveHistory", "").equals("")) {
			sertings.edit().putString("saveHistory", "1").commit();
		}
		if (sertings.getString("disableHaptics", "").equals("0")) {
			hapticsEnabled = true;
		}
		else {
			hapticsEnabled = false;
		}
		if (sertings.getString("disableAnimations", "").equals("0")) {
			animationsEnabled = true;
		}
		else {
			animationsEnabled = false;
		}
		if (sertings.getString("aiEnabled", "").equals("0")) {
			useAi = false;
		}
		else {
			useAi = true;
		}
		if (sertings.getString("saveHistory", "").equals("0")) {
			saveHistory = false;
		}
		else {
			saveHistory = true;
		}
		if (sertings.getString("useLocation", "").equals("0")) {
			useLocation = false;
		}
		else {
			useLocation = true;
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