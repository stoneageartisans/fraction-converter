package com.stoneageartisans.fractionconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class FractionToDecimal extends Activity {

	// Variables	
	private EditText input_whole;
	private EditText input_numerator;
	private EditText input_denominator;
	private Button convert;
	private TextView output;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.layout_f2d);
        initialize();

    }
    
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
    	
    	super.onSaveInstanceState(savedInstanceState);
    	savedInstanceState.putString( "output", output.getText().toString() );
    	
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
    	
    	super.onRestoreInstanceState(savedInstanceState);
    	output.setText( savedInstanceState.getString("output") );
    	
    }

    private void initialize() {

        int font_size = 20;

        input_whole = (EditText) this.findViewById(R.id.f2d_input_whole);
        input_whole.setTextSize(font_size);
    	
    	( (TextView) this.findViewById(R.id.f2d_fraction_separator) ).setTextSize(font_size);
    	
    	input_numerator = (EditText) this.findViewById(R.id.f2d_input_numerator);
    	input_numerator.setTextSize(font_size);
    	
    	input_denominator = (EditText) this.findViewById(R.id.f2d_input_denominator);
    	input_denominator.setTextSize(font_size);
    	
    	output = (TextView) this.findViewById(R.id.f2d_output);
    	output.setTextSize(font_size);
    	
    	input_whole.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
				calculateDecimal();
				return false;
			}
        });
    	
    	input_numerator.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
				calculateDecimal();
				return false;
			}
        });
    	
    	input_denominator.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
				calculateDecimal();
				return false;
			}
        });
    	
    	convert = (Button) this.findViewById(R.id.f2d_convert);
    	convert.setTextSize(font_size);
    	convert.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				calculateDecimal();
			}    		
    	});

    }
    
    private void calculateDecimal() {
    	
    	String whole = input_whole.getText().toString();
    	String numerator = input_numerator.getText().toString();
    	String denominator = input_denominator.getText().toString();
    	double dvalue = 0;
    	
    	try {
    		dvalue = Double.parseDouble(whole);    		
    	} catch(NumberFormatException ex) {
    		// do nothing
    	}
    	
    	try {
    		dvalue = dvalue + ( Double.parseDouble(numerator) / Double.parseDouble(denominator) );
    	} catch(NumberFormatException ex) {
    		// do nothing
    	}    	
    	
    	if(dvalue > 0) {
    		output.setText( String.valueOf(dvalue) );
    	} else {
    		output.setText("");
    	}
    	
    }

}
