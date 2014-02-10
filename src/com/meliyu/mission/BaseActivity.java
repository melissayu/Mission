package com.meliyu.mission;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class BaseActivity extends Activity {

	public static final int MAIN = 0;
	public static final int A1 = 1;
	public static final int A2 = 2;
	public static final int A3 = 3;
	public static final int R1 = 4;
	public static final int R2 = 5;
	public static final int R3 = 6;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base_activity);
		
		String rid = getIntent().getExtras().getString("rid");
		
		Resources res = getResources();
		int resID = res.getIdentifier(rid, "array", "com.meliyu.mission");

		final String[] strings = res.getStringArray(resID);
		
		final TextView maintext = (TextView) this.findViewById(R.id.maintext);
		maintext.setText(strings[MAIN]);

		final TextView action1text = (TextView) this.findViewById(R.id.action1);
		action1text.setText(strings[A1]);
		final TextView action2text = (TextView) this.findViewById(R.id.action2);
		action2text.setText(strings[A2]);
		final TextView action3text = (TextView) this.findViewById(R.id.action3);
		action3text.setText(strings[A3]);

		action1text.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(strings[R1].equals("end")){
					Intent goToNextActivity = new Intent(getApplicationContext(), EndActivity.class);	
					startActivity(goToNextActivity);					
				}
				else {
					Intent goToNextActivity = new Intent(getApplicationContext(), BaseActivity.class);	
					goToNextActivity.putExtra("rid", strings[R1]);
					startActivity(goToNextActivity);
				}
			}
		});
		action2text.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent goToNextActivity = new Intent(getApplicationContext(), BaseActivity.class);
				goToNextActivity.putExtra("rid", strings[R2]);
				startActivity(goToNextActivity);
			}
		});
		action3text.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent goToNextActivity = new Intent(getApplicationContext(), BaseActivity.class);
				goToNextActivity.putExtra("rid", strings[R3]);
				startActivity(goToNextActivity);
			}
		});
	}


}
