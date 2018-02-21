# Ti.VRPanoramaView

It is a Titanium module for realizing of a VRPanoramaView.
The common format for panorama is this format:

<img src="https://github.com/AppWerft/Ti.VRPanoramaView/blob/master/documentation/example.jpg?raw=true" width=700 />)


The project is work in progress and no ready for use.


## Usage

```javascript
var VR = require("ti.vrpanoramaview");
var win = Ti.UI.createWindow({
	theme : "Theme.AppCompat.NoTitleBar.Fullscreen"
});
var vrView = VR.createView({
	isStereo : true
    image : Ti.Filessystem.getFile(...).nativePath
});

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
