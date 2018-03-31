package com.stoneageartisans.fractionconverter;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class FractionConverter extends TabActivity {
	
	// Variables
	private int font_size = 20;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.layout_main);
		initialize();

	}
	
	@Override
	public void onResume() {
		
	    super.onResume();
	    
	}
	
	@Override
	public void onPause() {
		
	    super.onPause();
	    
	}

	private void initialize() {

		TabHost tab_host = this.getTabHost();

		TabSpec decimal_to_fraction = tab_host.newTabSpec("tab_d2f");
		decimal_to_fraction.setIndicator(".xy \u2192 x/y");
		decimal_to_fraction.setContent( new Intent(this, DecimalToFraction.class) );

        TabSpec fraction_to_decimal = tab_host.newTabSpec("tab_f2d");
        fraction_to_decimal.setIndicator("x/y \u2192 .xy");
        fraction_to_decimal.setContent( new Intent(this, FractionToDecimal.class) );

        tab_host.addTab(decimal_to_fraction);
        tab_host.addTab(fraction_to_decimal);

        // Center the text on each tab
        ( (TextView) ( (RelativeLayout) this.getTabWidget().getChildAt(0) ).findViewById(android.R.id.title) ).getLayoutParams().height = LayoutParams.MATCH_PARENT;
        ( (TextView) ( (RelativeLayout) this.getTabWidget().getChildAt(1) ).findViewById(android.R.id.title) ).getLayoutParams().height = LayoutParams.MATCH_PARENT;

        ( (TextView) this.findViewById(R.id.title) ).setTextSize(font_size);

        // Change the size of the text on each tab
        ( (TextView) ( (RelativeLayout) this.getTabWidget().getChildAt(0) ).findViewById(android.R.id.title) ).setTextSize(font_size);
        ( (TextView) ( (RelativeLayout) this.getTabWidget().getChildAt(1) ).findViewById(android.R.id.title) ).setTextSize(font_size);

    }

}
