package com.example.cityzone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;

public class ParseApplication extends Application{
	
	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, "P52tZuAjQM6fA2hkweNUIT9q0pL9b4imeWOJsN7C", "l1OuOE1RlHVTeAkP6lmiafUGFO7cBbZMJ9N8vBrO");
		
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
		
	}
}
