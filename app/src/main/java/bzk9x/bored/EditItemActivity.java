package bzk9x.bored;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.os.Vibrator;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class EditItemActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private boolean usernameAccepted = false;
	private HashMap<String, Object> userProfile = new HashMap<>();
	
	private ArrayList<String> reservedUsernames = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear4;
	private TextView textview8;
	private ImageView imageview11;
	private TextView textview11;
	private LinearLayout linear3;
	private TextView textview12;
	private EditText edittext1;
	
	private SharedPreferences profile;
	private DatabaseReference userIds = _firebase.getReference("userIds");
	private ChildEventListener _userIds_child_listener;
	private TimerTask timer;
	private Vibrator vibrator;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.edit_item);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear4 = findViewById(R.id.linear4);
		textview8 = findViewById(R.id.textview8);
		imageview11 = findViewById(R.id.imageview11);
		textview11 = findViewById(R.id.textview11);
		linear3 = findViewById(R.id.linear3);
		textview12 = findViewById(R.id.textview12);
		edittext1 = findViewById(R.id.edittext1);
		profile = getSharedPreferences("profile", Activity.MODE_PRIVATE);
		vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
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
		
		textview12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (usernameAccepted) {
					userProfile.put("username", edittext1.getText().toString().trim());
					profile.edit().putString("profile", new Gson().toJson(userProfile)).commit();
					userIds.child(userProfile.get("uid").toString()).updateChildren(userProfile);
					SketchwareUtil.showMessage(getApplicationContext(), "Username updated");
					vibrator.vibrate((long)(5));
					finish();
				}
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (!(_charSeq.trim().length() == 0)) {
					usernameAccepted = false;
					if (_charSeq.trim().length() < 4) {
						textview8.setText(_charSeq.trim().concat(" is too short, use a longer username"));
						usernameAccepted = false;
					}
					else {
						if (_charSeq.trim().length() > 16) {
							textview8.setText(_charSeq.trim().concat(" is too long, use a shorter username"));
							usernameAccepted = false;
						}
						else {
							if (_charSeq.trim().contains(" ")) {
								textview8.setText("Usernames cannot contain spaces");
								usernameAccepted = false;
							}
							else {
								if (!_charSeq.trim().matches("^[0-9a-zA-Z_\\-\\.]+$")) {
									textview8.setText(_charSeq.trim().concat(" is not available. Only the characters A-Z, a-z, 0-9, underscores, dahses and periods are allowed"));
									usernameAccepted = false;
								}
								else {
									if (reservedUsernames.contains(_charSeq.trim().toLowerCase())) {
										textview8.setText("The username ".concat(_charSeq.trim().concat(" is not available")));
										usernameAccepted = false;
									}
									else {
										textview8.setText("");
										usernameAccepted = true;
									}
								}
							}
						}
					}
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		_userIds_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		userIds.addChildEventListener(_userIds_child_listener);
	}
	
	private void initializeLogic() {
		usernameAccepted = false;
		reservedUsernames.add("tiwa");
		reservedUsernames.add("tolu");
		reservedUsernames.add("temi");
		reservedUsernames.add("tiwalope");
		reservedUsernames.add("toluwani");
		reservedUsernames.add("temiloluwa");
		reservedUsernames.add("draco");
		reservedUsernames.add("purpose");
		reservedUsernames.add("bzk9x");
		reservedUsernames.add("bored");
		reservedUsernames.add("bored.app");
		reservedUsernames.add("bored_app");
		reservedUsernames.add("bored_ai");
		reservedUsernames.add("bored.ai");
		reservedUsernames.add("admin");
		userProfile = new Gson().fromJson(profile.getString("profile", ""), new TypeToken<HashMap<String, Object>>(){}.getType());
		edittext1.setText(getIntent().getStringExtra("username"));
		edittext1.setHint(getIntent().getStringExtra("username"));
		linear4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)64, 0xFF130E14));
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