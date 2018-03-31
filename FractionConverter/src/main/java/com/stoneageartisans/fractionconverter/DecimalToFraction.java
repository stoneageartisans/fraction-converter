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

public class DecimalToFraction extends Activity {

	// Variables
	private EditText input;
	private TextView output_whole;
	private TextView output_numerator;
	private TextView output_denominator;
	private Button convert;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.layout_d2f);
        initialize();

    }
    
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
    	
    	super.onSaveInstanceState(savedInstanceState);
    	savedInstanceState.putString( "whole", output_whole.getText().toString() );
    	savedInstanceState.putString( "numerator", output_numerator.getText().toString() );
    	savedInstanceState.putString( "denominator", output_denominator.getText().toString() );
    	
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
    	
    	super.onRestoreInstanceState(savedInstanceState);
    	output_whole.setText( savedInstanceState.getString("whole") );
    	output_numerator.setText( savedInstanceState.getString("numerator") );
    	output_denominator.setText( savedInstanceState.getString("denominator") );
    	
    }

	private void initialize() {

        int font_size = 20;

        input = (EditText) this.findViewById(R.id.d2f_input);
    	input.setTextSize(font_size);
    	
    	output_whole = (TextView) this.findViewById(R.id.d2f_output_whole);
    	output_whole.setTextSize(font_size);
    	
    	( (TextView) this.findViewById(R.id.d2f_fraction_separator) ).setTextSize(font_size);
    	
    	output_numerator = (TextView) this.findViewById(R.id.d2f_output_numerator);
    	output_numerator.setTextSize(font_size);
    	
    	output_denominator = (TextView) this.findViewById(R.id.d2f_output_denominator);
    	output_denominator.setTextSize(font_size);

    	input.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
				calculateFraction();
				return false;
			}
        });

    	convert = (Button) this.findViewById(R.id.d2f_convert);
    	convert.setTextSize(font_size);
    	convert.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				calculateFraction();
			}    		
    	});

    }

    private void calculateFraction() {
    	
    	int whole = 0;
    	int numerator = 0;
    	int denominator = 0;
    	int places = 0;
    	String svalue = input.getText().toString();    	
    	
    	try {    		
    		whole = (int) Double.parseDouble(svalue);
    		if( svalue.contains(".") ) {
                try {
                    numerator = Integer.parseInt(svalue.substring( svalue.indexOf(".") + 1 ) );
                    if(numerator > 0) {
                        places = svalue.substring( svalue.indexOf(".") + 1 ).length();
                        denominator = 1;
                        for(int i = 0; i < places; i++ ) {
            	    		denominator = denominator * 10;
            	    	} 
                    }
                } catch(NumberFormatException ex) {
                    // do nothing
                }
    		}
    		if( (numerator > 0) && (denominator > 0) ) {
		    	while( ( (numerator % 2) == 0 ) && ( (denominator % 2) == 0 ) ) {
		    		numerator = numerator / 2;
		    		denominator = denominator / 2;
		    	}
		    	while( ( (numerator % 3) == 0 ) && ( (denominator % 3) == 0 ) ) {
		    		numerator = numerator / 3;
		    		denominator = denominator / 3;
		    	}
		    	while( ( (numerator % 5) == 0 ) && ( (denominator % 5) == 0 ) ) {
		    		numerator = numerator / 5;
		    		denominator = denominator / 5;
		    	}
		    	while( ( (numerator % 7) == 0 ) && ( (denominator % 7) == 0 ) ) {
		    		numerator = numerator / 7;
		    		denominator = denominator / 7;
		    	}
		    	while( ( (numerator % 11) == 0 ) && ( (denominator % 11) == 0 ) ) {
		    		numerator = numerator / 11;
		    		denominator = denominator / 11;
		    	}
		    	while( ( (numerator % 13) == 0 ) && ( (denominator % 13) == 0 ) ) {
		    		numerator = numerator / 13;
		    		denominator = denominator / 13;
		    	}
    		}
    	} catch(NumberFormatException ex) {
    		// do nothing
    	}
    	
    	if(whole > 0) {
    		output_whole.setText( String.valueOf(whole) );
    	} else {
    		output_whole.setText("");
    	}
    	if(numerator > 0) {
    		output_numerator.setText( String.valueOf(numerator) );
    		output_denominator.setText( String.valueOf(denominator) );
    	} else {
    		output_numerator.setText("");
    		output_denominator.setText("");
    	}

    }

}
