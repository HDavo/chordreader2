package org.hollowbamboo.chordreader2.data;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

import org.hollowbamboo.chordreader2.R;


public enum ColorScheme {
	
	Dark (R.string.pref_scheme_dark, R.color.scheme_dark_background, 
			R.color.scheme_dark_foreground, R.color.scheme_dark_link
	),
	Light (R.string.pref_scheme_light, R.color.scheme_light_background, 
			R.color.scheme_light_foreground, R.color.scheme_light_link
	),
	Android (R.string.pref_scheme_android, R.color.scheme_android_background, 
			R.color.scheme_android_foreground, R.color.scheme_android_link
	),
	;
	
	private final int nameResource;
	private final int backgroundColorResource;
	private final int foregroundColorResource;
	private final int linkColorResource;
	
	private int backgroundColor = -1;
	private int foregroundColor = -1;
	private int linkColor = -1;
	
	private static final Map<String, ColorScheme> preferenceNameToColorScheme = new HashMap<String, ColorScheme>();
	
	ColorScheme(int nameResource, int backgroundColorResource, int foregroundColorResource,
				int linkColorResource) {
		this.nameResource = nameResource;
		this.backgroundColorResource = backgroundColorResource;
		this.foregroundColorResource = foregroundColorResource;
		this.linkColorResource = linkColorResource;

	}

	public int getNameResource() {
		return nameResource;
	}	
	
	public int getBackgroundColor(Context context) {
		if(backgroundColor == -1) {
			backgroundColor = context.getResources().getColor(backgroundColorResource);
		}
		return backgroundColor;
	}
	
	public int getForegroundColor(Context context) {
		if(foregroundColor == -1) {
			foregroundColor = context.getResources().getColor(foregroundColorResource);
		}
		return foregroundColor;
	}
	
	
	public int getLinkColor(Context context) {
		if(linkColor == -1) {
			linkColor = context.getResources().getColor(linkColorResource);
		}
		return linkColor;
	}

	public static ColorScheme findByPreferenceName(String name, Context context) {
		if(preferenceNameToColorScheme.isEmpty()) {
			// initialize map
			for (ColorScheme colorScheme : values()) {
				preferenceNameToColorScheme.put(context.getText(colorScheme.getNameResource()).toString(), colorScheme);
			}
		}
		return preferenceNameToColorScheme.get(name);
	}
}
