package com.meliyu.mission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class StartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		final TextView maintext = (TextView) this.findViewById(R.id.begin);
		maintext.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent goToNextActivity = new Intent(getApplicationContext(), BaseActivity.class);
				goToNextActivity.putExtra("rid", "s01");
				startActivity(goToNextActivity);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

}
