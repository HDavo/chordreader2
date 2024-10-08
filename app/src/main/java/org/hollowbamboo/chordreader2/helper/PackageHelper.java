package org.hollowbamboo.chordreader2.helper;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import org.hollowbamboo.chordreader2.util.UtilLogger;

public class PackageHelper {

	private static final UtilLogger log = new UtilLogger(org.hollowbamboo.chordreader2.helper.PackageHelper.class);
	
	public static String getVersionName(Context context) {
		try {
			return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
		} catch (NameNotFoundException e) {
			// should never happen
			log.d(e, "unexpected exception");
			return "";
		}
	}
}
