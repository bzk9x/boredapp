package bzk9x.bored;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import java.util.regex.*;
import org.json.*;

public class CreateProfileActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> randomUsername = new HashMap<>();
	private String generatedUsername = "";
	private boolean usersIdGotten = false;
	private double randomAvatar = 0;
	private String avatar = "";
	private HashMap<String, Object> newProfile = new HashMap<>();
	private double generatedID = 0;
	private boolean accountCreated = false;
	private String id = "";
	private boolean devicesGotten = false;
	private boolean accountExists = false;
	
	private ArrayList<HashMap<String, Object>> userIdsMap = new ArrayList<>();
	private ArrayList<String> ids = new ArrayList<>();
	private ArrayList<String> devicesList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> devicesMap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview8;
	private ProgressBar progressbar1;
	private TextView textview1;
	
	private RequestNetwork randomUsernameAPI;
	private RequestNetwork.RequestListener _randomUsernameAPI_request_listener;
	private DatabaseReference userIds = _firebase.getReference("userIds");
	private ChildEventListener _userIds_child_listener;
	private DatabaseReference devices = _firebase.getReference("devices");
	private ChildEventListener _devices_child_listener;
	private SharedPreferences profile;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.create_profile);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		textview8 = findViewById(R.id.textview8);
		progressbar1 = findViewById(R.id.progressbar1);
		textview1 = findViewById(R.id.textview1);
		randomUsernameAPI = new RequestNetwork(this);
		profile = getSharedPreferences("profile", Activity.MODE_PRIVATE);
		
		_randomUsernameAPI_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				id=android.provider.Settings.Secure.getString(getApplicationContext().getContentResolver(),android.provider.Settings.Secure.ANDROID_ID);
				randomUsername = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
				generatedUsername = randomUsername.get("usernames").toString().substring((int)(1), (int)(randomUsername.get("usernames").toString().length() - 1));
				randomAvatar = SketchwareUtil.getRandom((int)(1), (int)(10));
				avatar = "DEFAULT_".concat(String.valueOf((long)(randomAvatar)));
				while(usersIdGotten) {
					generatedID = userIdsMap.size() + 1;
					if (ids.contains(String.valueOf((long)(generatedID)))) {
						generatedID = userIdsMap.size() + 1;
					}
					else {
						newProfile = new HashMap<>();
						newProfile.put("username", generatedUsername);
						newProfile.put("uid", String.valueOf((long)(generatedID)));
						newProfile.put("avatar", avatar);
						newProfile.put("deviceID", id);
						profile.edit().putString("profile", new Gson().toJson(newProfile)).commit();
						userIds.child(String.valueOf((long)(generatedID))).updateChildren(newProfile);
						newProfile = new HashMap<>();
						newProfile.put("uid", String.valueOf((long)(generatedID)));
						devices.child(id).updateChildren(newProfile);
						SketchwareUtil.showMessage(getApplicationContext(), "Profile created");
						accountCreated = true;
						usersIdGotten = false;
						finish();
					}
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_userIds_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (!accountCreated) {
					userIds.addListenerForSingleValueEvent(new ValueEventListener() {
						@Override
						public void onDataChange(DataSnapshot _dataSnapshot) {
							userIdsMap = new ArrayList<>();
							try {
								GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
								for (DataSnapshot _data : _dataSnapshot.getChildren()) {
									HashMap<String, Object> _map = _data.getValue(_ind);
									userIdsMap.add(_map);
								}
							}
							catch (Exception _e) {
								_e.printStackTrace();
							}
							ids.add(_childKey);
							usersIdGotten = true;
						}
						@Override
						public void onCancelled(DatabaseError _databaseError) {
						}
					});
				}
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
		
		_devices_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				devicesList.add(_childKey);
				if (devicesList.contains(id)) {
					if (true) {
						devices.addListenerForSingleValueEvent(new ValueEventListener() {
							@Override
							public void onDataChange(DataSnapshot _dataSnapshot) {
								devicesMap = new ArrayList<>();
								try {
									GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
									for (DataSnapshot _data : _dataSnapshot.getChildren()) {
										HashMap<String, Object> _map = _data.getValue(_ind);
										devicesMap.add(_map);
									}
								}
								catch (Exception _e) {
									_e.printStackTrace();
								}
								
							}
							@Override
							public void onCancelled(DatabaseError _databaseError) {
							}
						});
					}
				}
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
		devices.addChildEventListener(_devices_child_listener);
	}
	
	private void initializeLogic() {
		randomUsernameAPI.startRequestNetwork(RequestNetworkController.GET, "https://usernameapiv1.vercel.app/api/random-usernames", "", _randomUsernameAPI_request_listener);
		usersIdGotten = false;
		accountCreated = false;
		accountCreated = false;
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