package com.unitedmindset.applicationfinder.extensions;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.adobe.fre.FREASErrorException;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FRENoSuchNameException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREReadOnlyException;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class GetPackageInfoFunction implements FREFunction {

	public FREObject call(FREContext context, FREObject[] args) {
		
		String uri = "";
		try{
			uri = args[0].getAsString();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			e.printStackTrace();
		}
		
		ApplicationFinderContext c = (ApplicationFinderContext)context;
		PackageManager pm = c.packageManager;
		PackageInfo packageInfo = null;
		try{
			packageInfo = pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
		} catch (PackageManager.NameNotFoundException e) {
			packageInfo = null;
		}
		
		//no packageInfo? return now
		if(packageInfo==null)
			return null;
		
		FREObject result = null;
		//new object
		try {
			result = FREObject.newObject("com.unitedmindset.extensions.applicationfinder.vos.PackageInfo", null);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (FRETypeMismatchException e1) {
			e1.printStackTrace();
		} catch (FREInvalidObjectException e1) {
			e1.printStackTrace();
		} catch (FREASErrorException e1) {
			e1.printStackTrace();
		} catch (FRENoSuchNameException e1) {
			e1.printStackTrace();
		} catch (FREWrongThreadException e1) {
			e1.printStackTrace();
		}
		//packageName:String
		try {
			_setProperty(result, "packageName", FREObject.newObject( packageInfo.packageName ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//versionName:String
		try {
			_setProperty(result, "versionName", FREObject.newObject( packageInfo.versionName ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//versionCode:String
		try {
			_setProperty(result, "versionCode", FREObject.newObject( packageInfo.versionCode ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//applicationInfo:ApplicationInfo
		_setApplicationInfo(result, packageInfo.applicationInfo);
		return result;
	}
	
	private void _setProperty(FREObject data, String propertyLabel, FREObject object)
	{
		try {
			data.setProperty(propertyLabel, object);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (FRETypeMismatchException e1) {
			e1.printStackTrace();
		} catch (FREInvalidObjectException e1) {
			e1.printStackTrace();
		} catch (FREASErrorException e1) {
			e1.printStackTrace();
		} catch (FRENoSuchNameException e1) {
			e1.printStackTrace();
		} catch (FREReadOnlyException e1) {
			e1.printStackTrace();
		} catch (FREWrongThreadException e1) {
			e1.printStackTrace();
		}
	}
	
	private void _setApplicationInfo(FREObject data, ApplicationInfo applicationInfo)
	{
		//no applicationInfo? return now
		if(applicationInfo==null)
			return;
		
		FREObject result = null;
		//new object
		try {
			result = FREObject.newObject("com.unitedmindset.extensions.applicationfinder.vos.ApplicationInfo", null);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (FRETypeMismatchException e1) {
			e1.printStackTrace();
		} catch (FREInvalidObjectException e1) {
			e1.printStackTrace();
		} catch (FREASErrorException e1) {
			e1.printStackTrace();
		} catch (FRENoSuchNameException e1) {
			e1.printStackTrace();
		} catch (FREWrongThreadException e1) {
			e1.printStackTrace();
		}
		//name
		try {
			_setProperty(result, "permission", FREObject.newObject( applicationInfo.permission ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dataDir:String
		try {
			_setProperty(result, "dataDir", FREObject.newObject( applicationInfo.dataDir ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//packageName:String
		try {
			_setProperty(result, "packageName", FREObject.newObject( applicationInfo.packageName ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//processName:String
		try {
			_setProperty(result, "processName", FREObject.newObject( applicationInfo.processName ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//publicSourceDir:String
		try {
			_setProperty(result, "publicSourceDir", FREObject.newObject( applicationInfo.publicSourceDir ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//sourceDir:String
		try {
			_setProperty(result, "sourceDir", FREObject.newObject( applicationInfo.sourceDir ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//targetSdkVersion:int
		try {
			_setProperty(result, "targetSdkVersion", FREObject.newObject( applicationInfo.targetSdkVersion ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//taskAffinity:String
		try {
			_setProperty(result, "taskAffinity", FREObject.newObject( applicationInfo.taskAffinity ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//uid:Number
		try {
			_setProperty(result, "uid", FREObject.newObject( applicationInfo.uid ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//icon:Number
		try {
			_setProperty(result, "icon", FREObject.newObject( applicationInfo.icon ));
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//set to packageInfo
		try {
			data.setProperty("applicationInfo", result);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (FRETypeMismatchException e1) {
			e1.printStackTrace();
		} catch (FREInvalidObjectException e1) {
			e1.printStackTrace();
		} catch (FREASErrorException e1) {
			e1.printStackTrace();
		} catch (FRENoSuchNameException e1) {
			e1.printStackTrace();
		} catch (FREReadOnlyException e1) {
			e1.printStackTrace();
		} catch (FREWrongThreadException e1) {
			e1.printStackTrace();
		}
	}

}
