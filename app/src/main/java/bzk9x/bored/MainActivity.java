package bzk9x.bored;

import bzk9x.bored.StartAppActivity;
import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Context;
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
import android.os.Vibrator;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
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
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
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

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> responseMap = new HashMap<>();
	private double filter = 0;
	private boolean searching = false;
	private String link = "";
	private String title = "";
	private String message = "";
	private String apiLink = "";
	private double participates = 0;
	private boolean isConnected = false;
	private boolean hapticsEnabled = false;
	private boolean animationsEnabled = false;
	private boolean useAi = false;
	private boolean saveHistory = false;
	private boolean useLocation = false;
	private double randomCategory = 0;
	private double randomResult = 0;
	private String responseGotten = "";
	private String category = "";
	private String accessibility = "";
	private String participants = "";
	private String duration = "";
	
	private ArrayList<String> response = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> responseListMap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> responses = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> educationalList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> socialList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> charityList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> cookingList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> relaxationList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> busyworkList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> recreationalList = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear42;
	private LinearLayout linear6;
	private LinearLayout linear5;
	private LinearLayout linear18;
	private LinearLayout linear17;
	private LinearLayout linear31;
	private LinearLayout linear19;
	private LinearLayout linear23;
	private LinearLayout linear32;
	private LinearLayout linear41;
	private LinearLayout linear40;
	private ImageView imageview16;
	private LinearLayout linear21;
	private LinearLayout linear22;
	private TextView textview10;
	private TextView textview11;
	private LinearLayout linear24;
	private TextView textview12;
	private LinearLayout linear2;
	private LinearLayout linear25;
	private LinearLayout linear26;
	private LinearLayout linear27;
	private LinearLayout linear28;
	private ImageView imageview11;
	private TextView textview13;
	private TextView textview14;
	private TextView textview15;
	private TextView textview16;
	private TextView textview17;
	private TextView textview18;
	private TextView textview19;
	private LinearLayout linear29;
	private ImageView imageview12;
	private TextView textview20;
	private LinearLayout linear16;
	private ImageView imageview10;
	private TextView textview1;
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
	private LinearLayout linear43;
	private LinearLayout linear44;
	private ImageView imageview17;
	
	private RequestNetwork requestAPI;
	private RequestNetwork.RequestListener _requestAPI_request_listener;
	private ObjectAnimator rotate = new ObjectAnimator();
	private ObjectAnimator scaleX = new ObjectAnimator();
	private ObjectAnimator scaleY = new ObjectAnimator();
	private TimerTask bounceVibrate;
	private TimerTask bounce;
	private Vibrator vibrator;
	private ObjectAnimator pulse = new ObjectAnimator();
	private TimerTask apiDelay;
	private ObjectAnimator fadeout = new ObjectAnimator();
	private TimerTask fadeoutDelay;
	private TimerTask fadeInDelay;
	private ObjectAnimator fadeIn = new ObjectAnimator();
	private Intent openLink = new Intent();
	private Intent intent = new Intent();
	private Intent generate = new Intent();
	private ObjectAnimator connectingAnimation = new ObjectAnimator();
	private ObjectAnimator spinner = new ObjectAnimator();
	private DatabaseReference api = _firebase.getReference("questions");
	private ChildEventListener _api_child_listener;
	private DatabaseReference requestDatabase = _firebase.getReference("requestDatabase");
	private ChildEventListener _requestDatabase_child_listener;
	private ObjectAnimator connectFadeOut = new ObjectAnimator();
	private ObjectAnimator connectingFocus = new ObjectAnimator();
	private TimerTask connectingFocusTimer;
	private Intent settings = new Intent();
	private SharedPreferences sertings;
	private ObjectAnimator settingsIconScaleX = new ObjectAnimator();
	private ObjectAnimator settingsIconScaleY = new ObjectAnimator();
	private TimerTask settingsIconRotateDelay;
	private ObjectAnimator settingsIconRotate = new ObjectAnimator();
	private ObjectAnimator settingsIconFadeInOut = new ObjectAnimator();
	private DatabaseReference social = _firebase.getReference("questions/social");
	private ChildEventListener _social_child_listener;
	private DatabaseReference charity = _firebase.getReference("questions/charity");
	private ChildEventListener _charity_child_listener;
	private DatabaseReference cooking = _firebase.getReference("questions/cooking");
	private ChildEventListener _cooking_child_listener;
	private DatabaseReference relaxation = _firebase.getReference("questions/relaxation");
	private ChildEventListener _relaxation_child_listener;
	private DatabaseReference busywork = _firebase.getReference("questions/busywork");
	private ChildEventListener _busywork_child_listener;
	private DatabaseReference recreational = _firebase.getReference("questions/recreational");
	private ChildEventListener _recreational_child_listener;
	private DatabaseReference educational = _firebase.getReference("questions/educational");
	private ChildEventListener _educational_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear42 = findViewById(R.id.linear42);
		linear6 = findViewById(R.id.linear6);
		linear5 = findViewById(R.id.linear5);
		linear18 = findViewById(R.id.linear18);
		linear17 = findViewById(R.id.linear17);
		linear31 = findViewById(R.id.linear31);
		linear19 = findViewById(R.id.linear19);
		linear23 = findViewById(R.id.linear23);
		linear32 = findViewById(R.id.linear32);
		linear41 = findViewById(R.id.linear41);
		linear40 = findViewById(R.id.linear40);
		imageview16 = findViewById(R.id.imageview16);
		linear21 = findViewById(R.id.linear21);
		linear22 = findViewById(R.id.linear22);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		linear24 = findViewById(R.id.linear24);
		textview12 = findViewById(R.id.textview12);
		linear2 = findViewById(R.id.linear2);
		linear25 = findViewById(R.id.linear25);
		linear26 = findViewById(R.id.linear26);
		linear27 = findViewById(R.id.linear27);
		linear28 = findViewById(R.id.linear28);
		imageview11 = findViewById(R.id.imageview11);
		textview13 = findViewById(R.id.textview13);
		textview14 = findViewById(R.id.textview14);
		textview15 = findViewById(R.id.textview15);
		textview16 = findViewById(R.id.textview16);
		textview17 = findViewById(R.id.textview17);
		textview18 = findViewById(R.id.textview18);
		textview19 = findViewById(R.id.textview19);
		linear29 = findViewById(R.id.linear29);
		imageview12 = findViewById(R.id.imageview12);
		textview20 = findViewById(R.id.textview20);
		linear16 = findViewById(R.id.linear16);
		imageview10 = findViewById(R.id.imageview10);
		textview1 = findViewById(R.id.textview1);
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
		linear43 = findViewById(R.id.linear43);
		linear44 = findViewById(R.id.linear44);
		imageview17 = findViewById(R.id.imageview17);
		requestAPI = new RequestNetwork(this);
		vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		sertings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		
		imageview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				settings.setClass(getApplicationContext(), SettingsActivity.class);
				startActivity(settings);
				overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
			}
		});
		
		linear29.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				title = "Hey! I was bored, I was thinking we could try doing this together";
				message = "Hey! I am bored, Why don't we try doing this together:\n".concat(textview12.getText().toString());
				Intent intent = new Intent(android.content.Intent.ACTION_SEND); intent.setType("text/plain"); intent.putExtra(android.content.Intent.EXTRA_SUBJECT, title); intent.putExtra(android.content.Intent.EXTRA_TEXT, message); startActivity(Intent.createChooser(intent,"Share using"));
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (isConnected) {
					if (!searching) {
						linear7.setEnabled(false);
						linear17.setVisibility(View.GONE);
						linear18.setVisibility(View.VISIBLE);
						linear18.setAlpha((float)(1));
						textview10.setText("Searching...");
						searching = true;
						scaleX.setTarget(linear19);
						scaleX.setPropertyName("scaleX");
						scaleX.setFloatValues((float)(0.8d), (float)(1.2d));
						scaleX.setDuration((int)(750));
						scaleX.setRepeatMode(ValueAnimator.REVERSE);
						scaleX.setRepeatCount((int)(-1));
						scaleX.setInterpolator(new BounceInterpolator());
						scaleX.start();
						scaleY.setTarget(linear19);
						scaleY.setPropertyName("scaleY");
						scaleY.setFloatValues((float)(0.8d), (float)(1.2d));
						scaleY.setDuration((int)(750));
						scaleY.setRepeatMode(ValueAnimator.REVERSE);
						scaleY.setRepeatCount((int)(-1));
						scaleY.setInterpolator(new BounceInterpolator());
						scaleY.start();
						bounceVibrate = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										vibrator.vibrate((long)(3));
									}
								});
							}
						};
						_timer.scheduleAtFixedRate(bounceVibrate, (int)(0), (int)(2250));
						pulse.setTarget(textview10);
						pulse.setPropertyName("alpha");
						pulse.setFloatValues((float)(0.2d), (float)(1));
						pulse.setDuration((int)(750));
						pulse.setRepeatMode(ValueAnimator.REVERSE);
						pulse.setRepeatCount((int)(-1));
						pulse.setInterpolator(new LinearInterpolator());
						pulse.start();
						try{
							if (filter == 0) {
								randomCategory = SketchwareUtil.getRandom((int)(1), (int)(7));
								if (randomCategory == 1) {
									randomResult = SketchwareUtil.getRandom((int)(0), (int)(educationalList.size()));
									responseGotten = educationalList.get((int)randomResult).get("name").toString();
									category = educationalList.get((int)randomResult).get("category").toString();
									accessibility = educationalList.get((int)randomResult).get("accessibility").toString();
									participants = educationalList.get((int)randomResult).get("min_participants").toString();
									duration = educationalList.get((int)randomResult).get("duration").toString();
								}
								else {
									if (randomCategory == 2) {
										randomResult = SketchwareUtil.getRandom((int)(0), (int)(recreationalList.size()));
										responseGotten = recreationalList.get((int)randomResult).get("name").toString();
										category = recreationalList.get((int)randomResult).get("category").toString();
										accessibility = recreationalList.get((int)randomResult).get("accessibility").toString();
										participants = recreationalList.get((int)randomResult).get("min_participants").toString();
										duration = recreationalList.get((int)randomResult).get("duration").toString();
									}
									else {
										if (randomCategory == 3) {
											randomResult = SketchwareUtil.getRandom((int)(0), (int)(socialList.size()));
											responseGotten = socialList.get((int)randomResult).get("name").toString();
											category = socialList.get((int)randomResult).get("category").toString();
											accessibility = socialList.get((int)randomResult).get("accessibility").toString();
											participants = socialList.get((int)randomResult).get("min_participants").toString();
											duration = socialList.get((int)randomResult).get("duration").toString();
										}
										else {
											if (randomCategory == 4) {
												randomResult = SketchwareUtil.getRandom((int)(0), (int)(charityList.size()));
												responseGotten = charityList.get((int)randomResult).get("name").toString();
												category = charityList.get((int)randomResult).get("category").toString();
												accessibility = charityList.get((int)randomResult).get("accessibility").toString();
												participants = charityList.get((int)randomResult).get("min_participants").toString();
												duration = charityList.get((int)randomResult).get("duration").toString();
											}
											else {
												if (randomCategory == 5) {
													randomResult = SketchwareUtil.getRandom((int)(0), (int)(cookingList.size()));
													responseGotten = cookingList.get((int)randomResult).get("name").toString();
													category = cookingList.get((int)randomResult).get("category").toString();
													accessibility = cookingList.get((int)randomResult).get("accessibility").toString();
													participants = cookingList.get((int)randomResult).get("min_participants").toString();
													duration = cookingList.get((int)randomResult).get("duration").toString();
												}
												else {
													if (randomCategory == 6) {
														randomResult = SketchwareUtil.getRandom((int)(0), (int)(relaxationList.size()));
														responseGotten = relaxationList.get((int)randomResult).get("name").toString();
														category = relaxationList.get((int)randomResult).get("category").toString();
														accessibility = relaxationList.get((int)randomResult).get("accessibility").toString();
														participants = relaxationList.get((int)randomResult).get("min_participants").toString();
														duration = relaxationList.get((int)randomResult).get("duration").toString();
													}
													else {
														randomResult = SketchwareUtil.getRandom((int)(0), (int)(busyworkList.size()));
														responseGotten = busyworkList.get((int)randomResult).get("name").toString();
														category = busyworkList.get((int)randomResult).get("category").toString();
														accessibility = busyworkList.get((int)randomResult).get("accessibility").toString();
														participants = busyworkList.get((int)randomResult).get("min_participants").toString();
														duration = busyworkList.get((int)randomResult).get("duration").toString();
													}
												}
											}
										}
									}
								}
							}
							else {
								if (filter == 1) {
									randomResult = SketchwareUtil.getRandom((int)(0), (int)(educationalList.size()));
									category = educationalList.get((int)randomResult).get("name").toString();
									responseGotten = educationalList.get((int)randomResult).get("category").toString();
									accessibility = educationalList.get((int)randomResult).get("accessibility").toString();
									participants = educationalList.get((int)randomResult).get("min_participants").toString();
									duration = educationalList.get((int)randomResult).get("duration").toString();
								}
								else {
									if (filter == 2) {
										randomResult = SketchwareUtil.getRandom((int)(0), (int)(recreationalList.size()));
										responseGotten = recreationalList.get((int)randomResult).get("name").toString();
										category = recreationalList.get((int)randomResult).get("category").toString();
										accessibility = recreationalList.get((int)randomResult).get("accessibility").toString();
										participants = recreationalList.get((int)randomResult).get("min_participants").toString();
										duration = recreationalList.get((int)randomResult).get("duration").toString();
									}
									else {
										if (filter == 3) {
											randomResult = SketchwareUtil.getRandom((int)(0), (int)(socialList.size()));
											responseGotten = socialList.get((int)randomResult).get("name").toString();
											category = socialList.get((int)randomResult).get("category").toString();
											accessibility = socialList.get((int)randomResult).get("accessibility").toString();
											participants = socialList.get((int)randomResult).get("min_participants").toString();
											duration = socialList.get((int)randomResult).get("duration").toString();
										}
										else {
											if (filter == 4) {
												randomResult = SketchwareUtil.getRandom((int)(0), (int)(charityList.size()));
												responseGotten = charityList.get((int)randomResult).get("name").toString();
												category = charityList.get((int)randomResult).get("category").toString();
												accessibility = charityList.get((int)randomResult).get("accessibility").toString();
												participants = charityList.get((int)randomResult).get("min_participants").toString();
												duration = charityList.get((int)randomResult).get("duration").toString();
											}
											else {
												if (filter == 5) {
													randomResult = SketchwareUtil.getRandom((int)(0), (int)(cookingList.size()));
													responseGotten = cookingList.get((int)randomResult).get("name").toString();
													category = cookingList.get((int)randomResult).get("category").toString();
													accessibility = cookingList.get((int)randomResult).get("accessibility").toString();
													participants = cookingList.get((int)randomResult).get("min_participants").toString();
													duration = cookingList.get((int)randomResult).get("duration").toString();
												}
												else {
													if (filter == 6) {
														randomResult = SketchwareUtil.getRandom((int)(0), (int)(relaxationList.size()));
														responseGotten = relaxationList.get((int)randomResult).get("name").toString();
														category = relaxationList.get((int)randomResult).get("category").toString();
														accessibility = relaxationList.get((int)randomResult).get("accessibility").toString();
														participants = relaxationList.get((int)randomResult).get("min_participants").toString();
														duration = relaxationList.get((int)randomResult).get("duration").toString();
													}
													else {
														randomResult = SketchwareUtil.getRandom((int)(0), (int)(busyworkList.size()));
														responseGotten = busyworkList.get((int)randomResult).get("name").toString();
														category = busyworkList.get((int)randomResult).get("category").toString();
														accessibility = busyworkList.get((int)randomResult).get("accessibility").toString();
														participants = busyworkList.get((int)randomResult).get("min_participants").toString();
														duration = busyworkList.get((int)randomResult).get("duration").toString();
													}
												}
											}
										}
									}
								}
							}
							apiDelay = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											textview12.setText(responseGotten);
											textview13.setText(category);
											textview15.setText(accessibility);
											textview17.setText(participants);
											textview19.setText(duration);
											vibrator.vibrate((long)(125));
											scaleX.cancel();
											scaleY.cancel();
											pulse.cancel();
											linear19.setScaleX((float)(1));
											linear19.setScaleY((float)(1));
											textview10.setAlpha((float)(1));
											textview10.setText("Bored");
											searching = false;
											bounceVibrate.cancel();
											apiDelay = new TimerTask() {
												@Override
												public void run() {
													runOnUiThread(new Runnable() {
														@Override
														public void run() {
															fadeout.setTarget(linear18);
															fadeout.setPropertyName("alpha");
															fadeout.setFloatValues((float)(0));
															fadeout.setDuration((int)(250));
															fadeout.start();
															fadeInDelay = new TimerTask() {
																@Override
																public void run() {
																	runOnUiThread(new Runnable() {
																		@Override
																		public void run() {
																			linear18.setVisibility(View.GONE);
																			linear17.setVisibility(View.VISIBLE);
																			linear17.setAlpha((float)(0));
																			fadeIn.setTarget(linear17);
																			fadeIn.setPropertyName("alpha");
																			fadeIn.setFloatValues((float)(1));
																			fadeIn.setDuration((int)(250));
																			fadeIn.start();
																		}
																	});
																}
															};
															_timer.schedule(fadeInDelay, (int)(250));
														}
													});
												}
											};
											_timer.schedule(apiDelay, (int)(500));
											linear7.setEnabled(true);
											if (textview13.getText().toString().equals("Educational")) {
												imageview11.setImageResource(R.drawable.tab_icn_2);
											}
											else {
												if (textview13.getText().toString().equals("Recreational")) {
													imageview11.setImageResource(R.drawable.tab_icn_3);
												}
												else {
													if (textview13.getText().toString().equals("Social")) {
														imageview11.setImageResource(R.drawable.tab_icn_4);
													}
													else {
														if (textview13.getText().toString().equals("Charity")) {
															imageview11.setImageResource(R.drawable.tab_icn_5);
														}
														else {
															if (textview13.getText().toString().equals("Cooking")) {
																imageview11.setImageResource(R.drawable.tab_icn_6);
															}
															else {
																if (textview13.getText().toString().equals("Relaxing")) {
																	imageview11.setImageResource(R.drawable.tab_icn_7);
																}
																else {
																	if (textview13.getText().toString().equals("Busywork")) {
																		imageview11.setImageResource(R.drawable.tab_icn_8);
																	}
																	else {
																		imageview11.setImageResource(R.drawable.tab_icn_1);
																	}
																}
															}
														}
													}
												}
											}
										}
									});
								}
							};
							_timer.schedule(apiDelay, (int)(2000));
						}catch(Exception e){
							SketchwareUtil.showMessage(getApplicationContext(), "An error occured");
						}
					}
				}
				else {
					if (!connectingFocus.isRunning()) {
						SketchwareUtil.showMessage(getApplicationContext(), "Connecting");
						vibrator.vibrate((long)(5));
						connectingFocus.setTarget(textview10);
						connectingFocus.setPropertyName("translationX");
						connectingFocus.setFloatValues((float)(-45));
						connectingFocus.setDuration((int)(100));
						connectingFocus.setInterpolator(new LinearInterpolator());
						connectingFocus.start();
						connectingFocusTimer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										vibrator.vibrate((long)(5));
										connectingFocus.setTarget(textview10);
										connectingFocus.setPropertyName("translationX");
										connectingFocus.setFloatValues((float)(45));
										connectingFocus.setDuration((int)(100));
										connectingFocus.setInterpolator(new LinearInterpolator());
										connectingFocus.start();
										connectingFocusTimer = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														vibrator.vibrate((long)(5));
														connectingFocus.setTarget(textview10);
														connectingFocus.setPropertyName("translationX");
														connectingFocus.setFloatValues((float)(0));
														connectingFocus.setDuration((int)(100));
														connectingFocus.setInterpolator(new LinearInterpolator());
														connectingFocus.start();
													}
												});
											}
										};
										_timer.schedule(connectingFocusTimer, (int)(100));
									}
								});
							}
						};
						_timer.schedule(connectingFocusTimer, (int)(100));
					}
				}
			}
		});
		
		linear30.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (useAi) {
					generate.setClass(getApplicationContext(), AiOnboardingActivity.class);
					startActivity(generate);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Generative Ai is disabled. You can enable it in settings.");
					imageview16.setColorFilter(0xFFE7B4F9, PorterDuff.Mode.MULTIPLY);
					settingsIconScaleX.setTarget(imageview16);
					settingsIconScaleX.setPropertyName("scaleX");
					settingsIconScaleX.setFloatValues((float)(1.2d));
					settingsIconScaleX.setDuration((int)(500));
					settingsIconScaleX.setInterpolator(new LinearInterpolator());
					settingsIconScaleX.start();
					settingsIconScaleY.setTarget(imageview16);
					settingsIconScaleY.setPropertyName("scaleY");
					settingsIconScaleY.setFloatValues((float)(1.2d));
					settingsIconScaleY.setDuration((int)(500));
					settingsIconScaleY.setInterpolator(new LinearInterpolator());
					settingsIconScaleY.start();
					settingsIconRotateDelay = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									settingsIconRotate.setTarget(imageview16);
									settingsIconRotate.setPropertyName("rotation");
									settingsIconRotate.setFloatValues((float)(0), (float)(360));
									settingsIconRotate.setDuration((int)(500));
									settingsIconRotate.setInterpolator(new DecelerateInterpolator());
									settingsIconRotate.start();
									settingsIconRotateDelay = new TimerTask() {
										@Override
										public void run() {
											runOnUiThread(new Runnable() {
												@Override
												public void run() {
													settingsIconScaleX.setTarget(imageview16);
													settingsIconScaleX.setPropertyName("scaleX");
													settingsIconScaleX.setFloatValues((float)(1));
													settingsIconScaleX.setDuration((int)(500));
													settingsIconScaleX.setInterpolator(new LinearInterpolator());
													settingsIconScaleX.start();
													settingsIconScaleY.setTarget(imageview16);
													settingsIconScaleY.setPropertyName("scaleY");
													settingsIconScaleY.setFloatValues((float)(1));
													settingsIconScaleY.setDuration((int)(500));
													settingsIconScaleY.setInterpolator(new LinearInterpolator());
													settingsIconScaleY.start();
													settingsIconFadeInOut.setTarget(imageview16);
													settingsIconFadeInOut.setPropertyName("alpha");
													settingsIconFadeInOut.setFloatValues((float)(0));
													settingsIconFadeInOut.setDuration((int)(250));
													settingsIconFadeInOut.start();
													settingsIconRotateDelay = new TimerTask() {
														@Override
														public void run() {
															runOnUiThread(new Runnable() {
																@Override
																public void run() {
																	imageview16.setColorFilter(0xFFE7E1E5, PorterDuff.Mode.MULTIPLY);
																	settingsIconFadeInOut.setTarget(imageview16);
																	settingsIconFadeInOut.setPropertyName("alpha");
																	settingsIconFadeInOut.setFloatValues((float)(1));
																	settingsIconFadeInOut.setDuration((int)(250));
																	settingsIconFadeInOut.start();
																}
															});
														}
													};
													_timer.schedule(settingsIconRotateDelay, (int)(250));
												}
											});
										}
									};
									_timer.schedule(settingsIconRotateDelay, (int)(750));
								}
							});
						}
					};
					_timer.schedule(settingsIconRotateDelay, (int)(500));
				}
			}
		});
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFF504154));
				linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				filter = 0;
				apiLink = "https://bored-api.appbrewery.com/random";
			}
		});
		
		linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFF504154));
				linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				filter = 1;
				apiLink = "https://bored-api.appbrewery.com/filter?type=education";
			}
		});
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFF504154));
				linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				filter = 2;
				apiLink = "https://bored-api.appbrewery.com/filter?type=recreational";
			}
		});
		
		linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFF504154));
				linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				filter = 3;
				apiLink = "https://bored-api.appbrewery.com/filter?type=social";
			}
		});
		
		linear14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFF504154));
				linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				filter = 4;
				apiLink = "https://bored-api.appbrewery.com/filter?type=charity";
			}
		});
		
		linear13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFF504154));
				linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				filter = 5;
				apiLink = "https://bored-api.appbrewery.com/filter?type=cooking";
			}
		});
		
		linear15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFF504154));
				linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				filter = 6;
				apiLink = "https://bored-api.appbrewery.com/filter?type=relaxation";
			}
		});
		
		linear12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFF504154));
				linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				linear15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
				filter = 7;
				apiLink = "https://bored-api.appbrewery.com/filter?type=busywork";
			}
		});
		
		_requestAPI_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				apiDelay = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								textview12.setText(responseListMap.get((int)0).get("activity").toString());
								textview13.setText(responseListMap.get((int)0).get("type").toString());
								textview15.setText(responseListMap.get((int)0).get("accessibility").toString());
								textview17.setText(String.valueOf((long)(Double.parseDouble(responseListMap.get((int)0).get("participants").toString()))));
								textview19.setText(responseListMap.get((int)0).get("duration").toString());
								vibrator.vibrate((long)(125));
								scaleX.cancel();
								scaleY.cancel();
								pulse.cancel();
								linear19.setScaleX((float)(1));
								linear19.setScaleY((float)(1));
								textview10.setAlpha((float)(1));
								textview10.setText("Bored");
								searching = false;
								bounceVibrate.cancel();
								apiDelay = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												fadeout.setTarget(linear18);
												fadeout.setPropertyName("alpha");
												fadeout.setFloatValues((float)(0));
												fadeout.setDuration((int)(250));
												fadeout.start();
												fadeInDelay = new TimerTask() {
													@Override
													public void run() {
														runOnUiThread(new Runnable() {
															@Override
															public void run() {
																linear18.setVisibility(View.GONE);
																linear17.setVisibility(View.VISIBLE);
																linear17.setAlpha((float)(0));
																fadeIn.setTarget(linear17);
																fadeIn.setPropertyName("alpha");
																fadeIn.setFloatValues((float)(1));
																fadeIn.setDuration((int)(250));
																fadeIn.start();
															}
														});
													}
												};
												_timer.schedule(fadeInDelay, (int)(250));
											}
										});
									}
								};
								_timer.schedule(apiDelay, (int)(500));
								linear7.setEnabled(true);
								if (textview13.getText().toString().equals("education")) {
									imageview11.setImageResource(R.drawable.tab_icn_2);
								}
								else {
									if (textview13.getText().toString().equals("recreational")) {
										imageview11.setImageResource(R.drawable.tab_icn_3);
									}
									else {
										if (textview13.getText().toString().equals("social")) {
											imageview11.setImageResource(R.drawable.tab_icn_4);
										}
										else {
											if (textview13.getText().toString().equals("charity")) {
												imageview11.setImageResource(R.drawable.tab_icn_5);
											}
											else {
												if (textview13.getText().toString().equals("cooking")) {
													imageview11.setImageResource(R.drawable.tab_icn_6);
												}
												else {
													if (textview13.getText().toString().equals("relaxation")) {
														imageview11.setImageResource(R.drawable.tab_icn_7);
													}
													else {
														if (textview13.getText().toString().equals("busywork")) {
															imageview11.setImageResource(R.drawable.tab_icn_8);
														}
														else {
															imageview11.setImageResource(R.drawable.tab_icn_1);
														}
													}
												}
											}
										}
									}
								}
							}
						});
					}
				};
				_timer.schedule(apiDelay, (int)(2000));
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_api_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				requestDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						responses = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								responses.add(_map);
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
		api.addChildEventListener(_api_child_listener);
		
		_requestDatabase_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				pulse.cancel();
				isConnected = true;
				connectFadeOut.setTarget(textview10);
				connectFadeOut.setPropertyName("alpha");
				connectFadeOut.setFloatValues((float)(linear31.getAlpha()), (float)(1));
				connectFadeOut.setDuration((int)(750));
				connectFadeOut.setInterpolator(new LinearInterpolator());
				connectFadeOut.start();
				textview10.setText("Bored");
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
		requestDatabase.addChildEventListener(_requestDatabase_child_listener);
		
		_social_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				social.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						socialList = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								socialList.add(_map);
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
		social.addChildEventListener(_social_child_listener);
		
		_charity_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				charity.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						charityList = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								charityList.add(_map);
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
		charity.addChildEventListener(_charity_child_listener);
		
		_cooking_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				cooking.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						cookingList = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								cookingList.add(_map);
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
		cooking.addChildEventListener(_cooking_child_listener);
		
		_relaxation_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				relaxation.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						relaxationList = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								relaxationList.add(_map);
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
		relaxation.addChildEventListener(_relaxation_child_listener);
		
		_busywork_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				busywork.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						busyworkList = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								busyworkList.add(_map);
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
		busywork.addChildEventListener(_busywork_child_listener);
		
		_recreational_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				recreational.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						recreationalList = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								recreationalList.add(_map);
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
		recreational.addChildEventListener(_recreational_child_listener);
		
		_educational_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				educational.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						educationalList = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								educationalList.add(_map);
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
		educational.addChildEventListener(_educational_child_listener);
	}
	
	private void initializeLogic() {
		_getSettings();
		linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFF504154));
		linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear30.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)99, (int)3, 0xFF504154, Color.TRANSPARENT));
		linear17.setVisibility(View.GONE);
		imageview16.setColorFilter(0xFFE7E1E5, PorterDuff.Mode.MULTIPLY);
		rotate.setTarget(linear21);
		rotate.setPropertyName("rotation");
		rotate.setFloatValues((float)(360));
		rotate.setDuration((int)(3000));
		rotate.setRepeatMode(ValueAnimator.RESTART);
		rotate.setRepeatCount((int)(-1));
		rotate.setInterpolator(new LinearInterpolator());
		rotate.start();
		searching = false;
		apiLink = "https://bored-api.appbrewery.com/random";
		textview21.setText(textview21.getText().toString());
		
		TextPaint paint = textview21.getPaint();
		
		float width = paint.measureText(textview21.getText().toString()); 
		
		Shader textShader = new LinearGradient(0, 0, width, textview21.getTextSize(), new int[]{ 
				
				0xFFE7B4F9, 0xFF471E58,
				
				
		}, null,Shader.TileMode.CLAMP); 
		
		
		textview21.getPaint().setShader(textShader);
		if (useAi) {
			linear30.setAlpha((float)(1));
		}
		else {
			linear30.setAlpha((float)(0.3d));
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		_getSettings();
		hscroll1.setHorizontalScrollBarEnabled(false);
		imageview10.setColorFilter(0xFF471E58, PorterDuff.Mode.MULTIPLY);
		linear21.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)999, 0xFF471E58));
		linear22.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)999, 0xFFE7B4F9));
		imageview13.setColorFilter(0xFFE7B4F9, PorterDuff.Mode.MULTIPLY);
		if (responses.size() == 0) {
			isConnected = false;
			textview10.setText("Connecting...");
			pulse.setTarget(textview10);
			pulse.setPropertyName("alpha");
			pulse.setFloatValues((float)(0.2d), (float)(1));
			pulse.setDuration((int)(750));
			pulse.setRepeatMode(ValueAnimator.REVERSE);
			pulse.setRepeatCount((int)(-1));
			pulse.setInterpolator(new LinearInterpolator());
			pulse.start();
		}
		if (useAi) {
			linear30.setAlpha((float)(1));
		}
		else {
			linear30.setAlpha((float)(0.3d));
		}
		_RippleEffect(linear16, 99, 0, "#E7B4F9", true);
		_RippleEffect(linear29, 99, 0, "#504154", true);
	}
	
	@Override
	public void onBackPressed() {
		if (linear18.getVisibility() == View.VISIBLE) {
			finish();
		}
		else {
			linear17.setVisibility(View.GONE);
			linear18.setVisibility(View.VISIBLE);
			linear18.setAlpha((float)(1));
		}
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