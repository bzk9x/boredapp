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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class HistoryActivity extends AppCompatActivity {
	
	private boolean hapticsEnabled = false;
	private boolean animationsEnabled = false;
	private boolean useAi = false;
	private boolean saveHistory = false;
	private boolean useLocation = false;
	private String title = "";
	private String messages = "";
	private String message = "";
	
	private ArrayList<HashMap<String, Object>> aiHistory = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout linear6;
	private LinearLayout linear5;
	private TextView textview2;
	private TextView textview3;
	private ListView listview1;
	
	private SharedPreferences sertings;
	private SharedPreferences historyData;
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.history);
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
		textview1 = findViewById(R.id.textview1);
		linear6 = findViewById(R.id.linear6);
		linear5 = findViewById(R.id.linear5);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		listview1 = findViewById(R.id.listview1);
		sertings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		historyData = getSharedPreferences("history", Activity.MODE_PRIVATE);
		
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
	}
	
	private void initializeLogic() {
		_getSettings();
		if (saveHistory) {
			linear5.setVisibility(View.VISIBLE);
			linear6.setVisibility(View.GONE);
			if (historyData.getString("history", "").equals("")) {
				linear5.setVisibility(View.GONE);
				linear6.setVisibility(View.VISIBLE);
				textview2.setText("No history");
				textview3.setText("Responses from Bored.Ai will be saved here");
			}
			else {
				aiHistory = new Gson().fromJson(historyData.getString("history", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				SketchwareUtil.sortListMap(aiHistory, "id", false, false);
				listview1.setAdapter(new Listview1Adapter(aiHistory));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		}
		else {
			linear5.setVisibility(View.GONE);
			linear6.setVisibility(View.VISIBLE);
		}
		imageview1.setColorFilter(0xFFE7E1E5, PorterDuff.Mode.MULTIPLY);
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
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.history_item, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)64, 0xFF130E14));
			textview1.setText(_data.get((int)_position).get("prompt").toString());
			textview2.setText(_data.get((int)_position).get("response").toString());
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					title = "Hey! I was bored, I was thinking we could try doing this together";
					message = "Hey! I am bored, Why don't we try doing this together:\n".concat(textview2.getText().toString().concat("\nGenerated with bored ai."));
					Intent intent = new Intent(android.content.Intent.ACTION_SEND); intent.setType("text/plain"); intent.putExtra(android.content.Intent.EXTRA_SUBJECT, title); intent.putExtra(android.content.Intent.EXTRA_TEXT, message); startActivity(Intent.createChooser(intent,"Share using"));
				}
			});
			
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