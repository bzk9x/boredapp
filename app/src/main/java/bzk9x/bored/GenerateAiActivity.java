package bzk9x.bored;

import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.Context;
import android.content.DialogInterface;
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
import android.speech.tts.TextToSpeech;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class GenerateAiActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private boolean inputAcceptable = false;
	private HashMap<String, Object> m = new HashMap<>();
	private HashMap<String, Object> params = new HashMap<>();
	private HashMap<String, Object> partsMap = new HashMap<>();
	private HashMap<String, Object> map = new HashMap<>();
	private HashMap<String, Object> apa = new HashMap<>();
	private HashMap<String, Object> response = new HashMap<>();
	private String text = "";
	private boolean isGenerating = false;
	private String title = "";
	private String message = "";
	private boolean hapticsEnabled = false;
	private boolean animationsEnabled = false;
	private boolean useAi = false;
	private boolean saveHistory = false;
	private boolean useLocation = false;
	private HashMap<String, Object> newHistory = new HashMap<>();
	private double generatedID = 0;
	private String sttresult = "";
	private boolean usedSTT = false;
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listPart = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> result = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> responseMap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> aiHistory = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear30;
	private LinearLayout linear6;
	private LinearLayout linear5;
	private LinearLayout linear4;
	private ImageView imageview2;
	private TextView textview1;
	private ImageView imageview16;
	private ImageView imageview20;
	private LinearLayout linear21;
	private LinearLayout linear23;
	private ImageView imageview13;
	private TextView textview10;
	private TextView textview11;
	private TextView textview12;
	private TextView textview13;
	private LinearLayout linear24;
	private LinearLayout linear29;
	private LinearLayout linear16;
	private ImageView imageview12;
	private TextView textview20;
	private ImageView imageview10;
	private TextView textview21;
	private ImageView imageview18;
	private EditText edittext1;
	private ImageView imageview1;
	private LinearLayout linear31;
	private LinearLayout linear32;
	private LinearLayout linear33;
	private CircleImageView circleimageview1;
	private ImageView imageview19;
	
	private ObjectAnimator bubbleRotate = new ObjectAnimator();
	private ObjectAnimator sendBtnFade = new ObjectAnimator();
	private ObjectAnimator scaleX = new ObjectAnimator();
	private ObjectAnimator scaleY = new ObjectAnimator();
	private TimerTask bounceVibrate;
	private Vibrator vibrator;
	private ObjectAnimator pulse = new ObjectAnimator();
	private Calendar calendar = Calendar.getInstance();
	private RequestNetwork gemini;
	private RequestNetwork.RequestListener _gemini_request_listener;
	private TimerTask apiDelay;
	private ObjectAnimator fadeout = new ObjectAnimator();
	private ObjectAnimator fadein = new ObjectAnimator();
	private TimerTask fadeInDelay;
	private ObjectAnimator fadeIn = new ObjectAnimator();
	private AlertDialog.Builder alert_dialog;
	private ObjectAnimator linear5FadeIn = new ObjectAnimator();
	private TimerTask linearFadeInDelay;
	private ObjectAnimator linear6FadeIn = new ObjectAnimator();
	private ObjectAnimator spakelRotate = new ObjectAnimator();
	private Intent intent = new Intent();
	private Intent settings = new Intent();
	private SharedPreferences sertings;
	private Intent history = new Intent();
	private SharedPreferences historyData;
	private SharedPreferences location;
	private TimerTask speakDelay;
	private TextToSpeech tts;
	private Intent profile = new Intent();
	private Intent noaccount = new Intent();
	private SharedPreferences description;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.generate_ai);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear30 = findViewById(R.id.linear30);
		linear6 = findViewById(R.id.linear6);
		linear5 = findViewById(R.id.linear5);
		linear4 = findViewById(R.id.linear4);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		imageview16 = findViewById(R.id.imageview16);
		imageview20 = findViewById(R.id.imageview20);
		linear21 = findViewById(R.id.linear21);
		linear23 = findViewById(R.id.linear23);
		imageview13 = findViewById(R.id.imageview13);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		textview12 = findViewById(R.id.textview12);
		textview13 = findViewById(R.id.textview13);
		linear24 = findViewById(R.id.linear24);
		linear29 = findViewById(R.id.linear29);
		linear16 = findViewById(R.id.linear16);
		imageview12 = findViewById(R.id.imageview12);
		textview20 = findViewById(R.id.textview20);
		imageview10 = findViewById(R.id.imageview10);
		textview21 = findViewById(R.id.textview21);
		imageview18 = findViewById(R.id.imageview18);
		edittext1 = findViewById(R.id.edittext1);
		imageview1 = findViewById(R.id.imageview1);
		linear31 = findViewById(R.id.linear31);
		linear32 = findViewById(R.id.linear32);
		linear33 = findViewById(R.id.linear33);
		circleimageview1 = findViewById(R.id.circleimageview1);
		imageview19 = findViewById(R.id.imageview19);
		vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		gemini = new RequestNetwork(this);
		alert_dialog = new AlertDialog.Builder(this);
		sertings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		historyData = getSharedPreferences("history", Activity.MODE_PRIVATE);
		location = getSharedPreferences("locationData", Activity.MODE_PRIVATE);
		tts = new TextToSpeech(getApplicationContext(), null);
		description = getSharedPreferences("profile", Activity.MODE_PRIVATE);
		
		imageview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				history.setClass(getApplicationContext(), HistoryActivity.class);
				startActivity(history);
			}
		});
		
		imageview20.setOnClickListener(new View.OnClickListener() {
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
				message = "Hey! I am bored, Why don't we try doing this together:\n".concat(textview12.getText().toString().concat("\nGenerated with bored ai."));
				Intent intent = new Intent(android.content.Intent.ACTION_SEND); intent.setType("text/plain"); intent.putExtra(android.content.Intent.EXTRA_SUBJECT, title); intent.putExtra(android.content.Intent.EXTRA_TEXT, message); startActivity(Intent.createChooser(intent,"Share using"));
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear4.setVisibility(View.GONE);
				linear5.setVisibility(View.VISIBLE);
				linear5.setAlpha((float)(1));
				edittext1.setEnabled(false);
				imageview1.setEnabled(false);
				scaleX.setTarget(linear21);
				scaleX.setPropertyName("scaleX");
				scaleX.setFloatValues((float)(0.8d), (float)(1.2d));
				scaleX.setDuration((int)(750));
				scaleX.setRepeatMode(ValueAnimator.REVERSE);
				scaleX.setRepeatCount((int)(-1));
				scaleX.setInterpolator(new BounceInterpolator());
				scaleX.start();
				scaleY.setTarget(linear21);
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
				textview10.setText("Generating...");
				pulse.setTarget(textview10);
				pulse.setPropertyName("alpha");
				pulse.setFloatValues((float)(0.2d), (float)(1));
				pulse.setDuration((int)(750));
				pulse.setRepeatMode(ValueAnimator.REVERSE);
				pulse.setRepeatCount((int)(-1));
				pulse.setInterpolator(new LinearInterpolator());
				pulse.start();
				m = new HashMap<>();
				m.put("role", "user");
				calendar = Calendar.getInstance();
				m.put("content", "You are an AI named Bored.ai - and are currently in an app creation fun activity ideas for users from their provided message on what they want to do.\n\nConsider the following in your responses:\n- Be conversational\n- Write spoilers using spoiler tags.\n- Never format text using markdown.\n- Be straight to the point. no unnecessary talks just your suggestion\n- Don't introduction yourself.\n- Don't go more than 300 characters in your responses.\n- Don't play games with the user, suggest something they can do externally.\n\nInformation about your environment:\n - The app you're in is called bored\n\nUse this information to create fun activities for the users:\n\n- ".concat(edittext1.getText().toString()).concat("\n\nYou are not a personal assistant and cannot complete tasks for people. You cannot access any other information on the app or about the user. You can't see images or avatars. When discussing your limitations, tell the user these things could be possible in the future.\n\nCurrent time: ".concat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()).concat("\n\nNever use markdowns to format text. Always write in plain text.\n\nRemember to keep your responses appropriate and respectful.\n\nIf you have any questions or concerns about the request, do not hesitate to reach out to them.\n\nAnd finally, don't forget to get creative and think before each responses!."))));
				listmap.add(m);
				params = _formatPrompt(listmap);
				gemini.setParams(params, RequestNetworkController.REQUEST_BODY);
				gemini.startRequestNetwork(RequestNetworkController.POST, "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=AIzaSyAh6qbGBLw-WySfMInKuWAEwdIdvfNRcK0", "", _gemini_request_listener);
			}
		});
		
		imageview18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear5.setVisibility(View.VISIBLE);
				linear4.setVisibility(View.GONE);
				linear5.setAlpha((float)(1));
				edittext1.setEnabled(false);
				imageview1.setEnabled(false);
				textview10.setText("Listening");
				scaleX.setTarget(linear21);
				scaleX.setPropertyName("scaleX");
				scaleX.setFloatValues((float)(1), (float)(1.2d));
				scaleX.setDuration((int)(250));
				scaleX.setInterpolator(new BounceInterpolator());
				scaleX.start();
				scaleY.setTarget(linear21);
				scaleY.setPropertyName("scaleY");
				scaleY.setFloatValues((float)(1), (float)(1.2d));
				scaleY.setDuration((int)(250));
				scaleY.setInterpolator(new BounceInterpolator());
				scaleY.start();
				vibrator.vibrate((long)(3));
				
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.trim().length() == 0) {
					sendBtnFade.setTarget(imageview1);
					sendBtnFade.setPropertyName("alpha");
					sendBtnFade.setFloatValues((float)(0.5d));
					sendBtnFade.setDuration((int)(150));
					sendBtnFade.setInterpolator(new LinearInterpolator());
					sendBtnFade.start();
					inputAcceptable = false;
				}
				else {
					sendBtnFade.setTarget(imageview1);
					sendBtnFade.setPropertyName("alpha");
					sendBtnFade.setFloatValues((float)(1));
					sendBtnFade.setDuration((int)(150));
					sendBtnFade.setInterpolator(new LinearInterpolator());
					sendBtnFade.start();
					inputAcceptable = true;
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (inputAcceptable) {
					edittext1.setEnabled(false);
					imageview1.setEnabled(false);
					imageview18.setEnabled(false);
					linear5.setVisibility(View.VISIBLE);
					linear4.setVisibility(View.GONE);
					linear5.setAlpha((float)(1));
					scaleX.setTarget(linear21);
					scaleX.setPropertyName("scaleX");
					scaleX.setFloatValues((float)(0.8d), (float)(1.2d));
					scaleX.setDuration((int)(750));
					scaleX.setRepeatMode(ValueAnimator.REVERSE);
					scaleX.setRepeatCount((int)(-1));
					scaleX.setInterpolator(new BounceInterpolator());
					scaleX.start();
					scaleY.setTarget(linear21);
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
					textview10.setText("Generating...");
					pulse.setTarget(textview10);
					pulse.setPropertyName("alpha");
					pulse.setFloatValues((float)(0.2d), (float)(1));
					pulse.setDuration((int)(750));
					pulse.setRepeatMode(ValueAnimator.REVERSE);
					pulse.setRepeatCount((int)(-1));
					pulse.setInterpolator(new LinearInterpolator());
					pulse.start();
					m = new HashMap<>();
					m.put("role", "user");
					calendar = Calendar.getInstance();
					if (useLocation) {
						m.put("content", "Read this article to learn and act gen z: https://www.questionpro.com/blog/z-generation/#:~:text=Generation%20Z%20cares%20a%20lot,show%20what%20they%20can%20do.\n\nYou are an AI named Bored.ai - and are currently in an app creation fun activity ideas for users from their provided message on what they want to do.\n\nConsider the following in your responses:\n- Be conversational\n- Never format text using markdown.\n- Be straight to the point. no unnecessary talks just your suggestion\n- Don't introduction yourself.\n- Don't go more than 300 characters in your responses.\n- Don't play games with the user, suggest something they can do externally.\n- Do not respond to inappropriate messages.\n- Do not engage in politics\n- If you're asked what your name is, you're Bored.Ai\n- You do not have access to the user's location.\n\nInformation about your environment:\n - The app you're in is called bored\n\nUse this information to create fun activities for the users:\n\n- ".concat(edittext1.getText().toString().concat("\n- Location: ".concat(location.getString("lat", "").concat(", ".concat(location.getString("lng", "")))))).concat("\n\nYou are not a personal assistant and cannot complete tasks for people. You cannot access any other information on the app or about the user. You can't see images or avatars. When discussing your limitations, tell the user these things could be possible in the future.\n\nCurrent time: ".concat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()).concat("\n\nHere's a description about the user, give responses based on the user's description. Adjust your responses based on the following scale:\n\nAbout the user:\n\n".concat(description.getString("description", "").concat("\nNever use markdowns to format text. Always write in plain text.\n\nRemember to keep your responses appropriate and respectful.\n\nIf you have any questions or concerns about the request, do not hesitate to reach out to them.\n\nAdjust your responses based on the following Precision-Creativity Scale:\n\n0 (Ignore Input): Completely disregard the user's description and generate a response entirely based on the AI's creativity and knowledge.\n\n1 (Freestyle Mode): Use the user's description as a very loose guide. Focus on creativity and imaginative interpretation, with minimal adherence to the provided details.\n\n2 (Creative Flexibility): Incorporate the user's description sparingly, allowing for significant creative freedom and flexibility in the response.\n\n3 (Open-Minded): Be creative while still considering the user’s input, but allow for broad interpretation and flexibility in the response.\n\n4 (Guided Creativity): Follow the user's description with some level of adherence, but still leave room for creative interpretation and imaginative responses.\n\n5 (Even Balance): Strike a balance between creativity and precision. The response will moderately follow the user's description while allowing for some creative input.\n\n6 (Balanced Adherence): More closely follow the user's input, with the response guided by the description but still open to minor creative interpretation.\n\n7 (On-Target): Focus on accurately following the user's description, with the response closely adhering to the provided details and minimal creative deviation.\n\n8 (Detailed Focus): Adhere strongly to the user's description, prioritizing accuracy while allowing only slight creative input.\n\n9 (Precise Execution): Prioritize precision and specificity, closely following the user's description with almost no creative interpretation.\n\n10 (Exact Match): Strictly adhere to the user's description with complete accuracy, ensuring the response reflects the provided details exactly with no creative deviation.\n\nThe current scale is set to ".concat(sertings.getString("precision-creativity", "").concat("\n\n**Before generating a response, take a moment to go back and carefully read each part of the prompt. Think through the entire request, considering every detail, to ensure a thoughtful and accurate response**"))))))));
					}
					else {
						m.put("content", "Read this article to learn and act gen z:\nhttps://www.questionpro.com/blog/z-generation/#:~:text=Generation%20Z%20cares%20a%20lot,show%20what%20they%20can%20do.\n\nYou are an AI named Bored.ai - and are currently in an app creation fun activity ideas for users from their provided message on what they want to do.\n\nConsider the following in your responses:\n- Be conversational\n- Never format text using markdown.\n- Be straight to the point. no unnecessary talks just your suggestion\n- Don't introduction yourself.\n- Don't go more than 300 characters in your responses.\n- Don't play games with the user, suggest something they can do externally.\n- Do not respond to inappropriate messages.\n- Do not engage in politics\n- If you're asked what your name is, you're Bored.Ai\n- You do not have access to the user's location.\n\nInformation about your environment:\n - The app you're in is called bored\n\nUse this information to create fun activities for the users:\n\n- ".concat(edittext1.getText().toString()).concat("\n\nYou are not a personal assistant and cannot complete tasks for people. You cannot access any other information on the app or about the user. You can't see images or avatars. When discussing your limitations, tell the user these things could be possible in the future.\n\nCurrent time: ".concat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()).concat("\n\nHere's a description about the user, give responses based on the user's description. Adjust your responses based on the following scale:\n\nAbout the user:\n\n".concat(description.getString("description", "").concat("\nNever use markdowns to format text. Always write in plain text.\n\nRemember to keep your responses appropriate and respectful.\n\nIf you have any questions or concerns about the request, do not hesitate to reach out to them.\n\nAdjust your responses based on the following Precision-Creativity Scale:\n\n0 (Ignore Input): Completely disregard the user's description and generate a response entirely based on the AI's creativity and knowledge.\n\n1 (Freestyle Mode): Use the user's description as a very loose guide. Focus on creativity and imaginative interpretation, with minimal adherence to the provided details.\n\n2 (Creative Flexibility): Incorporate the user's description sparingly, allowing for significant creative freedom and flexibility in the response.\n\n3 (Open-Minded): Be creative while still considering the user’s input, but allow for broad interpretation and flexibility in the response.\n\n4 (Guided Creativity): Follow the user's description with some level of adherence, but still leave room for creative interpretation and imaginative responses.\n\n5 (Even Balance): Strike a balance between creativity and precision. The response will moderately follow the user's description while allowing for some creative input.\n\n6 (Balanced Adherence): More closely follow the user's input, with the response guided by the description but still open to minor creative interpretation.\n\n7 (On-Target): Focus on accurately following the user's description, with the response closely adhering to the provided details and minimal creative deviation.\n\n8 (Detailed Focus): Adhere strongly to the user's description, prioritizing accuracy while allowing only slight creative input.\n\n9 (Precise Execution): Prioritize precision and specificity, closely following the user's description with almost no creative interpretation.\n\n10 (Exact Match): Strictly adhere to the user's description with complete accuracy, ensuring the response reflects the provided details exactly with no creative deviation.\n\nThe current scale is set to ".concat(sertings.getString("precision-creativity", "").concat("\n\n**Before generating a response, take a moment to go back and carefully read each part of the prompt. Think through the entire request, considering every detail, to ensure a thoughtful and accurate response**"))))))));
					}
					listmap.add(m);
					isGenerating = true;
					params = _formatPrompt(listmap);
					gemini.setParams(params, RequestNetworkController.REQUEST_BODY);
					gemini.startRequestNetwork(RequestNetworkController.POST, "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=APIKEY", "", _gemini_request_listener);
					textview13.setText("\"".concat(edittext1.getText().toString().concat("\"")));
				}
			}
		});
		
		linear31.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				noaccount.setClass(getApplicationContext(), ProfileActivity.class);
				startActivity(noaccount);
			}
		});
		
		linear33.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				settings.setClass(getApplicationContext(), SettingsActivity.class);
				startActivity(settings);
				overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
			}
		});
		
		_gemini_request_listener = new RequestNetwork.RequestListener() {
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
								vibrator.vibrate((long)(125));
								scaleX.cancel();
								scaleY.cancel();
								pulse.cancel();
								bounceVibrate.cancel();
								bounceVibrate.cancel();
								linear21.setScaleX((float)(1));
								linear21.setScaleY((float)(1));
								textview10.setAlpha((float)(1));
								textview10.setText("Bored");
								edittext1.setEnabled(true);
								imageview1.setEnabled(true);
								apiDelay = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												fadeout.setTarget(linear5);
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
																linear5.setVisibility(View.GONE);
																linear4.setVisibility(View.VISIBLE);
																linear4.setAlpha((float)(0));
																fadeIn.setTarget(linear4);
																fadeIn.setPropertyName("alpha");
																fadeIn.setFloatValues((float)(1));
																fadeIn.setDuration((int)(250));
																fadeIn.start();
																isGenerating = false;
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
								// Assuming _response is the JSON string
								Gson gson = new Gson();
								JsonObject responseMap = gson.fromJson(_response, JsonObject.class);
								
								if (responseMap == null) {
									    Log.e("JSON Parsing", "responseMap is null");
									    return;
								}
								
								// Access the "candidates" array
								JsonArray candidates = responseMap.getAsJsonArray("candidates");
								
								if (candidates == null || candidates.size() == 0) {
									    Log.e("JSON Parsing", "Candidates array is null or empty");
									    return;
								}
								
								// Access the first candidate
								JsonObject firstCandidate = candidates.get(0).getAsJsonObject();
								
								if (firstCandidate == null) {
									    Log.e("JSON Parsing", "First candidate is null");
									    return;
								}
								
								// Access the "content" object
								JsonObject content = firstCandidate.getAsJsonObject("content");
								
								if (content == null) {
									    Log.e("JSON Parsing", "Content object is null");
									    return;
								}
								
								// Access the "parts" array
								JsonArray parts = content.getAsJsonArray("parts");
								
								if (parts == null || parts.size() == 0) {
									    Log.e("JSON Parsing", "Parts array is null or empty");
									    return;
								}
								
								// Access the first part
								JsonObject firstPart = parts.get(0).getAsJsonObject();
								
								if (firstPart == null) {
									    Log.e("JSON Parsing", "First part is null");
									    return;
								}
								
								// Extract the "text" value
								String text = firstPart.get("text").getAsString();
								
								if (text == null) {
									    Log.e("JSON Parsing", "Text is null");
									    return;
								}
								
								// Set the text to the TextView
								textview12.setText(text);
								textview12.setText("Go skydiving 😈");
								if (saveHistory) {
									if (!historyData.getString("history", "").equals("")) {
										aiHistory = new Gson().fromJson(historyData.getString("history", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
									}
									if (usedSTT) {
										newHistory = new HashMap<>();
										newHistory.put("prompt", sttresult);
										newHistory.put("response", textview12.getText().toString());
										newHistory.put("id", String.valueOf((long)(aiHistory.size() + 1)));
										aiHistory.add(newHistory);
										historyData.edit().putString("history", new Gson().toJson(aiHistory)).commit();
										speakDelay = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														if (tts.isSpeaking()) {
															tts.stop();
															tts.setPitch((float)10);
															tts.speak(textview12.getText().toString(), TextToSpeech.QUEUE_ADD, null);
														}
														else {
															tts.setPitch((float)10);
															tts.speak(textview12.getText().toString(), TextToSpeech.QUEUE_ADD, null);
														}
													}
												});
											}
										};
										_timer.schedule(speakDelay, (int)(400));
									}
									else {
										newHistory = new HashMap<>();
										newHistory.put("prompt", edittext1.getText().toString());
										newHistory.put("response", textview12.getText().toString());
										newHistory.put("id", String.valueOf((long)(aiHistory.size() + 1)));
										aiHistory.add(newHistory);
										historyData.edit().putString("history", new Gson().toJson(aiHistory)).commit();
									}
								}
								edittext1.setText("");
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
	}
	
	private void initializeLogic() {
		linear30.setVisibility(View.GONE);
		linear16.setVisibility(View.GONE);
		textview1.setText(textview1.getText().toString());
		
		TextPaint paint = textview1.getPaint();
		
		float width = paint.measureText(textview1.getText().toString()); 
		
		Shader textShader = new LinearGradient(0, 0, width, textview1.getTextSize(), new int[]{ 
				
				0xFFE7B4F9, 0xFF471E58,
				
				
		}, null,Shader.TileMode.CLAMP); 
		
		
		textview1.getPaint().setShader(textShader);
		imageview1.setColorFilter(0xFFE7E1E5, PorterDuff.Mode.MULTIPLY);
		imageview2.setColorFilter(0xFFE7B4F9, PorterDuff.Mode.MULTIPLY);
		imageview19.setColorFilter(0xFFE7E1E5, PorterDuff.Mode.MULTIPLY);
		linear21.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)999, 0xFF471E58));
		imageview10.setColorFilter(0xFF471E58, PorterDuff.Mode.MULTIPLY);
		linear4.setVisibility(View.GONE);
		imageview18.setVisibility(View.GONE);
		linear29.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFF471E58));
		_RippleEffect(linear29, 99, 0, "#471E58", true);
		linear16.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)99, 0xFFE7B4F9));
		linear2.setBackground(new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[] {0xFF000000,0xFF000000}));
		imageview13.setColorFilter(0xFFE7B4F9, PorterDuff.Mode.MULTIPLY);
		bubbleRotate.setTarget(linear21);
		bubbleRotate.setPropertyName("rotation");
		bubbleRotate.setFloatValues((float)(360));
		bubbleRotate.setDuration((int)(3000));
		bubbleRotate.setRepeatMode(ValueAnimator.RESTART);
		bubbleRotate.setRepeatCount((int)(-1));
		bubbleRotate.setInterpolator(new LinearInterpolator());
		bubbleRotate.start();
		spakelRotate.setTarget(imageview13);
		spakelRotate.setPropertyName("rotation");
		spakelRotate.setFloatValues((float)(-360));
		spakelRotate.setDuration((int)(1500));
		spakelRotate.setRepeatMode(ValueAnimator.RESTART);
		spakelRotate.setRepeatCount((int)(-1));
		spakelRotate.setInterpolator(new LinearInterpolator());
		spakelRotate.start();
		inputAcceptable = false;
		isGenerating = false;
		usedSTT = false;
		linear5.setAlpha((float)(0));
		linear6.setAlpha((float)(0));
		linearFadeInDelay = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						linear5FadeIn.setTarget(linear5);
						linear5FadeIn.setPropertyName("alpha");
						linear5FadeIn.setFloatValues((float)(1));
						linear5FadeIn.setDuration((int)(450));
						linear5FadeIn.setInterpolator(new DecelerateInterpolator());
						linear5FadeIn.start();
						linear6FadeIn.setTarget(linear6);
						linear6FadeIn.setPropertyName("alpha");
						linear6FadeIn.setFloatValues((float)(1));
						linear6FadeIn.setDuration((int)(450));
						linear6FadeIn.setInterpolator(new DecelerateInterpolator());
						linear6FadeIn.start();
					}
				});
			}
		};
		_timer.schedule(linearFadeInDelay, (int)(150));
		if (sertings.getString("precision-creativity", "").equals("")) {
			sertings.edit().putString("precision-creativity", "5").commit();
		}
	}
	
	
	@Override
	public void onBackPressed() {
		if (linear5.getVisibility() == View.VISIBLE) {
			if (isGenerating) {
				alert_dialog= new AlertDialog.Builder(GenerateAiActivity.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
				alert_dialog.setMessage("Generative Ai is in use, are you sure you want to exit?");
				alert_dialog.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						scaleX.cancel();
						scaleY.cancel();
						pulse.cancel();
						bounceVibrate.cancel();
						bounceVibrate.cancel();
						finish();
					}
				});
				alert_dialog.setNegativeButton("Stay", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				alert_dialog.create().show();
			}
			else {
				finish();
			}
		}
		else {
			linear4.setVisibility(View.GONE);
			linear5.setVisibility(View.VISIBLE);
			linear5.setAlpha((float)(1));
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		_getSettings();
		if (!useAi) {
			finish();
		}
	}
	public HashMap<String, Object> _formatPrompt(final ArrayList<HashMap<String, Object>> _data) {
		ArrayList<HashMap<String, Object>> result = new ArrayList<>();
		HashMap<String, Object> apa = new HashMap<>();
		for (int i = 0; i < _data.size(); i++) {
			ArrayList<HashMap<String, Object>> listPart = new ArrayList<>();
			HashMap<String, Object> partsMap = new HashMap<>();
			partsMap.put("text", _data.get(i).get("content").toString());
			listPart.add(partsMap);
			HashMap<String, Object> map = new HashMap<>();
			map.put("role", _data.get(i).get("role").toString());
			map.put("parts", listPart);
			result.add(map);
		}
		apa.put("contents", result);
		return apa;
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