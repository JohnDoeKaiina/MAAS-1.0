package medhack.maas;

import medhack.maas.SplashActivity;
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
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.florent37.viewtooltip.*;
import com.google.firebase.FirebaseApp;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private LinearLayout linear3;
	private LinearLayout linear10;
	private LinearLayout linear5;
	private LinearLayout linear26;
	private LinearLayout linear4;
	private LinearLayout linear11;
	private HorizontalScrollView hscroll2;
	private LinearLayout buttonout;
	private CircleImageView circleimageview1;
	private EditText search;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	private LinearLayout request_in;
	private EditText request;
	private TextView textview34;
	private HorizontalScrollView hscroll1;
	private LinearLayout linear6;
	private CardView cardview1;
	private CardView cardview3;
	private CardView cardview2;
	private LinearLayout linear7;
	private ImageView imageview1;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private LinearLayout linear9;
	private ImageView imageview3;
	private TextView textview11;
	private TextView textview12;
	private TextView textview13;
	private LinearLayout linear8;
	private ImageView imageview2;
	private TextView textview8;
	private TextView textview9;
	private TextView textview10;
	private TextView textview14;
	private LinearLayout linear12;
	private CardView cardview13;
	private CardView cardview16;
	private CardView cardview14;
	private CardView cardview15;
	private LinearLayout linear22;
	private ImageView imageview13;
	private TextView textview30;
	private LinearLayout linear25;
	private ImageView imageview16;
	private TextView textview33;
	private LinearLayout linear23;
	private ImageView imageview14;
	private TextView textview31;
	private LinearLayout linear24;
	private ImageView imageview15;
	private TextView textview32;
	
	private Intent i = new Intent();
	
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
		vscroll1 = findViewById(R.id.vscroll1);
		linear3 = findViewById(R.id.linear3);
		linear10 = findViewById(R.id.linear10);
		linear5 = findViewById(R.id.linear5);
		linear26 = findViewById(R.id.linear26);
		linear4 = findViewById(R.id.linear4);
		linear11 = findViewById(R.id.linear11);
		hscroll2 = findViewById(R.id.hscroll2);
		buttonout = findViewById(R.id.buttonout);
		circleimageview1 = findViewById(R.id.circleimageview1);
		search = findViewById(R.id.search);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		request_in = findViewById(R.id.request_in);
		request = findViewById(R.id.request);
		textview34 = findViewById(R.id.textview34);
		hscroll1 = findViewById(R.id.hscroll1);
		linear6 = findViewById(R.id.linear6);
		cardview1 = findViewById(R.id.cardview1);
		cardview3 = findViewById(R.id.cardview3);
		cardview2 = findViewById(R.id.cardview2);
		linear7 = findViewById(R.id.linear7);
		imageview1 = findViewById(R.id.imageview1);
		textview5 = findViewById(R.id.textview5);
		textview6 = findViewById(R.id.textview6);
		textview7 = findViewById(R.id.textview7);
		linear9 = findViewById(R.id.linear9);
		imageview3 = findViewById(R.id.imageview3);
		textview11 = findViewById(R.id.textview11);
		textview12 = findViewById(R.id.textview12);
		textview13 = findViewById(R.id.textview13);
		linear8 = findViewById(R.id.linear8);
		imageview2 = findViewById(R.id.imageview2);
		textview8 = findViewById(R.id.textview8);
		textview9 = findViewById(R.id.textview9);
		textview10 = findViewById(R.id.textview10);
		textview14 = findViewById(R.id.textview14);
		linear12 = findViewById(R.id.linear12);
		cardview13 = findViewById(R.id.cardview13);
		cardview16 = findViewById(R.id.cardview16);
		cardview14 = findViewById(R.id.cardview14);
		cardview15 = findViewById(R.id.cardview15);
		linear22 = findViewById(R.id.linear22);
		imageview13 = findViewById(R.id.imageview13);
		textview30 = findViewById(R.id.textview30);
		linear25 = findViewById(R.id.linear25);
		imageview16 = findViewById(R.id.imageview16);
		textview33 = findViewById(R.id.textview33);
		linear23 = findViewById(R.id.linear23);
		imageview14 = findViewById(R.id.imageview14);
		textview31 = findViewById(R.id.textview31);
		linear24 = findViewById(R.id.linear24);
		imageview15 = findViewById(R.id.imageview15);
		textview32 = findViewById(R.id.textview32);
		
		circleimageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ModelAppActivity.class);
				i.putExtra("url", "https://maas-10-123456789.streamlit.app/");
				startActivity(i);
			}
		});
		
		linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ViewTooltip
				        .on(MainActivity.this, linear9)
				        .position(ViewTooltip.Position.TOP)
				        .text("This model is unavailable")
				         .shadowColor(0xFF000000)
				.color(0xFF3F51B5)
				.corner(15)
				        .show();
			}
		});
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ViewTooltip
				        .on(MainActivity.this, linear8)
				        .position(ViewTooltip.Position.TOP)
				        .text("Unavailable")
				         .shadowColor(0xFF000000)
				.color(0xFFE91E63)
				.corner(15)
				        .show();
			}
		});
		
		linear22.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ModelAppActivity.class);
				i.putExtra("url", "https://maas-10-t2pyuhgiqtcqxekbhhxclf.streamlit.app/");
				startActivity(i);
			}
		});
		
		linear25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ModelAppActivity.class);
				i.putExtra("url", "https://maas-10-amqmbbchxpimj9zz7vac6cmodel3pregnacy.streamlit.app/");
				startActivity(i);
			}
		});
		
		linear24.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ViewTooltip
				        .on(MainActivity.this, linear24)
				        .position(ViewTooltip.Position.TOP)
				        .text("Currently not available")
				         .shadowColor(0xFF000000)
				.color(0xFF3F51B5)
				.corner(15)
				        .show();
			}
		});
	}
	
	private void initializeLogic() {
		buttonout.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)360, 0xFFEEEEEE));
		search.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)360, 0xFFFFFFFF));
		request.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)360, 0xFFEEEEEE));
		request_in.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)360, 0xFF616161));
		linear1.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR|View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
		
		if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
				    setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
				            | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, true);
		}
		if (Build.VERSION.SDK_INT >= 19) {
				    getWindow().getDecorView().setSystemUiVisibility(
				            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
				                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
				                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
				    );
		}
		if (Build.VERSION.SDK_INT >= 21) {
				    setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
				            | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, false);
				    getWindow().setStatusBarColor(Color.TRANSPARENT);
				    getWindow().setNavigationBarColor(Color.TRANSPARENT);
		}
	}
	private void setWindowFlag(final int bits, boolean on) {
		    Window win = getWindow();
		    WindowManager.LayoutParams winParams = win.getAttributes();
		    if (on) {
				        winParams.flags |= bits;
				    } else {
				        winParams.flags &= ~bits;
				    }
		    win.setAttributes(winParams);
	}
	{
	}
	
	public void _extra_upload() {
	}
	
	private ValueCallback<Uri> mUploadMessage;
	public ValueCallback<Uri[]> uploadMessage;
	public static final int REQUEST_SELECT_FILE = 100;
	
	private final static int FILECHOOSER_RESULTCODE = 1;
	{
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