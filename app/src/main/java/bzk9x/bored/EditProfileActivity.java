package bzk9x.bored;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.io.File;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class EditProfileActivity extends AppCompatActivity {
	
	public final int REQ_CD_NEWBANNER = 101;
	public final int REQ_CD_AVATAR = 102;
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private HashMap<String, Object> userProfile = new HashMap<>();
	private String selectedImage = "";
	private HashMap<String, Object> updatedProfile = new HashMap<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private ImageView imageview1;
	private LinearLayout linear3;
	private LinearLayout linear2;
	private CircleImageView circleimageview1;
	private LinearLayout linear4;
	private TextView textview30;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private TextView textview1;
	private TextView textview22;
	private TextView textview23;
	private TextView textview24;
	private TextView textview25;
	private TextView textview26;
	private TextView textview27;
	private TextView textview34;
	private TextView textview29;
	private TextView textview35;
	private TextView textview36;
	private TextView textview37;
	
	private SharedPreferences profile;
	private Intent createProfile = new Intent();
	private Intent newBanner = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference banners = _firebase_storage.getReference("banners");
	private OnCompleteListener<Uri> _banners_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _banners_download_success_listener;
	private OnSuccessListener _banners_delete_success_listener;
	private OnProgressListener _banners_upload_progress_listener;
	private OnProgressListener _banners_download_progress_listener;
	private OnFailureListener _banners_failure_listener;
	
	private ProgressDialog pd;
	private DatabaseReference userIds = _firebase.getReference("userIds");
	private ChildEventListener _userIds_child_listener;
	private Vibrator vibrator;
	private Intent avatar = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference avatars = _firebase_storage.getReference("avatars");
	private OnCompleteListener<Uri> _avatars_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _avatars_download_success_listener;
	private OnSuccessListener _avatars_delete_success_listener;
	private OnProgressListener _avatars_upload_progress_listener;
	private OnProgressListener _avatars_download_progress_listener;
	private OnFailureListener _avatars_failure_listener;
	
	private Intent edit_username = new Intent();
	private Intent edit_displayname = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.edit_profile);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		linear3 = findViewById(R.id.linear3);
		linear2 = findViewById(R.id.linear2);
		circleimageview1 = findViewById(R.id.circleimageview1);
		linear4 = findViewById(R.id.linear4);
		textview30 = findViewById(R.id.textview30);
		linear5 = findViewById(R.id.linear5);
		linear7 = findViewById(R.id.linear7);
		textview1 = findViewById(R.id.textview1);
		textview22 = findViewById(R.id.textview22);
		textview23 = findViewById(R.id.textview23);
		textview24 = findViewById(R.id.textview24);
		textview25 = findViewById(R.id.textview25);
		textview26 = findViewById(R.id.textview26);
		textview27 = findViewById(R.id.textview27);
		textview34 = findViewById(R.id.textview34);
		textview29 = findViewById(R.id.textview29);
		textview35 = findViewById(R.id.textview35);
		textview36 = findViewById(R.id.textview36);
		textview37 = findViewById(R.id.textview37);
		profile = getSharedPreferences("profile", Activity.MODE_PRIVATE);
		newBanner.setType("image/*");
		newBanner.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		avatar.setType("image/*");
		avatar.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		textview22.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				updatedProfile = new Gson().fromJson(profile.getString("profile", ""), new TypeToken<HashMap<String, Object>>(){}.getType());
				userProfile.put("banner", "DEFAULT");
				profile.edit().putString("profile", new Gson().toJson(userProfile)).commit();
				userIds.child(userProfile.get("uid").toString()).updateChildren(userProfile);
				SketchwareUtil.showMessage(getApplicationContext(), "Banner removed");
				imageview1.setImageResource(R.drawable.bored_banner);
			}
		});
		
		textview23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(newBanner, REQ_CD_NEWBANNER);
			}
		});
		
		textview25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				updatedProfile = new Gson().fromJson(profile.getString("profile", ""), new TypeToken<HashMap<String, Object>>(){}.getType());
				userProfile.put("avatar", "DEFAULT_1");
				profile.edit().putString("profile", new Gson().toJson(userProfile)).commit();
				userIds.child(userProfile.get("uid").toString()).updateChildren(userProfile);
				SketchwareUtil.showMessage(getApplicationContext(), "Profile picture removed");
				circleimageview1.setImageResource(R.drawable.avatar_1);
			}
		});
		
		textview26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(avatar, REQ_CD_AVATAR);
			}
		});
		
		textview29.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edit_username.putExtra("username", textview34.getText().toString());
				edit_username.setClass(getApplicationContext(), EditItemActivity.class);
				startActivity(edit_username);
			}
		});
		
		textview37.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edit_displayname.putExtra("display_name", textview36.getText().toString());
				edit_displayname.setClass(getApplicationContext(), EditDisplayNameActivity.class);
				startActivity(edit_displayname);
			}
		});
		
		_banners_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_banners_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_banners_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				userProfile.put("banner", _downloadUrl);
				profile.edit().putString("profile", new Gson().toJson(userProfile)).commit();
				userIds.child(userProfile.get("uid").toString()).updateChildren(userProfile);
				Glide.with(getApplicationContext()).load(Uri.parse(_downloadUrl)).into(imageview1);
				SketchwareUtil.showMessage(getApplicationContext(), "Banner updated");
				vibrator.vibrate((long)(5));
				pd.dismiss();
			}
		};
		
		_banners_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_banners_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_banners_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
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
		
		_avatars_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_avatars_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_avatars_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				userProfile.put("avatar", _downloadUrl);
				profile.edit().putString("profile", new Gson().toJson(userProfile)).commit();
				userIds.child(userProfile.get("uid").toString()).updateChildren(userProfile);
				Glide.with(getApplicationContext()).load(Uri.parse(_downloadUrl)).into(circleimageview1);
				SketchwareUtil.showMessage(getApplicationContext(), "Avatar updated");
				vibrator.vibrate((long)(5));
				pd.dismiss();
			}
		};
		
		_avatars_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_avatars_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_avatars_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { Window w = getWindow();  w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); };
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_NEWBANNER:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				selectedImage = _filePath.get((int)(0));
				pd = new ProgressDialog(EditProfileActivity.this);
				pd.setMessage("Saving");
				pd.setCancelable(false);
				pd.setCanceledOnTouchOutside(false);
				pd.show();
				banners.child(userProfile.get("uid").toString().concat(".png")).putFile(Uri.fromFile(new File(selectedImage))).addOnFailureListener(_banners_failure_listener).addOnProgressListener(_banners_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return banners.child(userProfile.get("uid").toString().concat(".png")).getDownloadUrl();
					}}).addOnCompleteListener(_banners_upload_success_listener);
			}
			else {
				
			}
			break;
			
			case REQ_CD_AVATAR:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				selectedImage = _filePath.get((int)(0));
				pd = new ProgressDialog(EditProfileActivity.this);
				pd.setMessage("Saving");
				pd.setCancelable(false);
				pd.setCanceledOnTouchOutside(false);
				pd.show();
				avatars.child(userProfile.get("uid").toString().concat(".png")).putFile(Uri.fromFile(new File(selectedImage))).addOnFailureListener(_avatars_failure_listener).addOnProgressListener(_avatars_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return avatars.child(userProfile.get("uid").toString().concat(".png")).getDownloadUrl();
					}}).addOnCompleteListener(_avatars_upload_success_listener);
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		linear2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)64, 0xFF130E14));
		linear4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)64, 0xFF130E14));
		linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)64, 0xFF130E14));
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)64, 0xFF130E14));
		userProfile = new Gson().fromJson(profile.getString("profile", ""), new TypeToken<HashMap<String, Object>>(){}.getType());
		if (profile.getString("profile", "").equals("")) {
			createProfile.setClass(getApplicationContext(), CreateProfileActivity.class);
			startActivity(createProfile);
		}
		else {
			userProfile = new Gson().fromJson(profile.getString("profile", ""), new TypeToken<HashMap<String, Object>>(){}.getType());
			textview34.setText(userProfile.get("username").toString());
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
				textview36.setText(userProfile.get("username").toString());
			}
			else {
				textview36.setText(userProfile.get("display_name").toString());
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