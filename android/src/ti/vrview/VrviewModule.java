/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.vrview;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import com.google.vr.sdk.widgets.video.VrVideoView;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

@Kroll.module(name = "Vrview", id = "ti.vrview")
public class VrviewModule extends KrollModule {
	
	final static int FORMAT_DEFAULT = VrVideoView.Options.FORMAT_DEFAULT;
	final static int FORMAT_HLS = VrVideoView.Options.FORMAT_HLS;
	final static int TYPE_MONO = VrVideoView.Options.TYPE_MONO;
	final static int TYPE_STEREO_OVER_UNDER = VrVideoView.Options.TYPE_STEREO_OVER_UNDER;

	public VrviewModule() {
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) {

	}

}
