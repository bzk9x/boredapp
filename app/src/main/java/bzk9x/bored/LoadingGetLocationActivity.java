package bzk9x.bored;

import android.Manifest;
import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class LoadingGetLocationActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private double lat = 0;
	private double lng = 0;
	private boolean appStarted = false;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private TextView textview1;
	private TextView textview2;
	
	private LocationManager location;
	private LocationListener _location_location_listener;
	private SharedPreferences locationData;
	private TimerTask startAppDelay;
	private Intent startApp = new Intent();
	private ObjectAnimator fadeIn = new ObjectAnimator();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.loading_get_location);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
		} else {
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
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		location = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationData = getSharedPreferences("locationData", Activity.MODE_PRIVATE);
		
		_location_location_listener = new LocationListener() {
			@Override
			public void onLocationChanged(Location _param1) {
				final double _lat = _param1.getLatitude();
				final double _lng = _param1.getLongitude();
				final double _acc = _param1.getAccuracy();
				lat = _lat;
				lng = _lng;
				locationData.edit().putString("lat", String.valueOf(lat)).commit();
				locationData.edit().putString("lng", String.valueOf(lng)).commit();
				textview1.setText("> Starting app\n> Location request enabled\n> Getting location...\n> ".concat(locationData.getString("lat", "").concat(", ".concat(locationData.getString("lng", "")))));
			}
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
			}
			
			@Override
			public void onProviderEnabled(String provider) {
			}
			
			@Override
			public void onProviderDisabled(String provider) {
			}
		};
	}
	
	private void initializeLogic() {
		if (ContextCompat.checkSelfPermission(LoadingGetLocationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			location.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1, _location_location_listener);
		}
		startApp.setClass(getApplicationContext(), AiOnboardingActivity.class);
		startActivity(startApp);
		finish();
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