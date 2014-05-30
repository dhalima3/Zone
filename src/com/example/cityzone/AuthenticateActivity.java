package com.example.cityzone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class AuthenticateActivity extends Activity {

	protected String mAction;

	protected EditText mEmailField;
	protected EditText mPasswordField;
	protected Button mButton;
	protected ProgressBar mProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_authenticate);

		mEmailField = (EditText) findViewById(R.id.editText1);
		mPasswordField = (EditText) findViewById(R.id.editText2);
		mButton = (Button) findViewById(R.id.button1);
		mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);

		Bundle bundle = getIntent().getExtras();
		mAction = bundle.getString(LoginOrSignupActivity.TYPE);

		mButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mProgressBar.setVisibility(View.VISIBLE);

				String username = mEmailField.getText().toString();
				String password = mPasswordField.getText().toString();

				if (mAction.equals(LoginOrSignupActivity.SIGNUP)) {
					/*
					 * Sign up using ParseUser
					 */
					ParseUser user = new ParseUser();
					user.setUsername("my name");
					user.setPassword("my pass");
					user.setEmail("email@example.com");
					 
					// other fields can be set just like with ParseObject
					user.put("phone", "650-253-0000");
					 
					user.signUpInBackground(new SignUpCallback() {
					  public void done(ParseException e) {
					    if (e == null) {
					      // Hooray! Let them use the app now.
					    } else {
					      // Sign up didn't succeed. Look at the ParseException
					      // to figure out what went wrong
					    }
					  }
					});
				} else {
					/*
					 * Login using ParseUser
					 */
				}
			}
		});
	}

}
