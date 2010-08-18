package com.nolanlawson.chordfinder.chords;

import java.util.HashMap;
import java.util.Map;

import com.nolanlawson.chordfinder.util.ArrayUtil;

/**
 * Enum for add9 and add11.
 * @author nolan
 *
 */
public enum ChordAdded {

	Add9 (new String[]{"add9", "2"}),
	Add11 (new String[]{"add11", "4"});
	
	private String[] aliases;
	
	ChordAdded (String[] aliases) {
		this.aliases = aliases;
	}
	
	public String[] getAliases() {
		return aliases;
	}
	
	public static String[] getAllAliases() {
		String[] result = new String[0];
		
		for (ChordAdded chordAdded : values()) {
			result = ArrayUtil.concatenate(result, chordAdded.aliases);
		}
		
		return result;
	}
	
	private static Map<String,ChordAdded> lookupMap = new HashMap<String, ChordAdded>();
	
	static {
		for (ChordAdded value : values()) {
			for (String alias : value.aliases) {
				lookupMap.put(alias.toLowerCase(), value);
			}
		}
	}
	
	public static ChordAdded findByAlias(String alias) {
		return lookupMap.get(alias.toLowerCase());
	}

}
