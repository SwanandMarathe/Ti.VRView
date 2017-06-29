# Ti.VRview

It is a Titanium module for realizing of a VR view for cardboard and DayDream. It supports video and images, mono and stereo.

The project is work in progress and no ready for use.

<img src="http://www.affinityvr.com/wp-content/uploads/2016/05/vr-view.jpg" width=500 />
##Usage

```javascript
var VR = require("de.appwerft.vrview");
var win = Ti.UI.createWindow({
	theme : "Theme.AppCompat.NoTitleBar.Fullscreen"
});
var vrView = VR.createVrVideoView({
	autostart : true,
	isStereo : true
});
vrView.loadVideo("http://tools.webmasterei.com/vrview/VRtest.mp4");
vrView.playVideo();
win.add(vrView);
```

Don't forget to restrict the screenorientation to "landscape"!
```xml
<activity 
	android:name="org.appcelerator.titanium.TiActivity" 
	android:screenOrientation="landscape" 
	android:configChanges="keyboardHidden|screenSize"
/>
		
```
