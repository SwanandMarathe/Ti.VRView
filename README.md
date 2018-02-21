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
	isStereo : false,
    image : Ti.Filessystem.getFile(...).nativePath
});

win.add(vrView);
```

