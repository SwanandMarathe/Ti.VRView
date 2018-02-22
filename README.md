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
var panoView = VR.createPanoramaView({
    type : VR.TYPE_MONO,
    image : Ti.Filessystem.getFile(...).nativePath
});

win.add(panoView);
```

##  Constants

### Type of streaming

* FORMAT_DEFAULT
Indicates that the video is in a standard video container format such as mp4, webm, ogg, aac.

* FORMAT_HLS
Indicates that the video uses the HTTP Live Streaming (HLS) format.


### Mono (screen) or stereo (cardbox)
* TYPE_MONO
Each video frame is a monocular equirectangular panorama.

* TYPE_STEREO_OVER_UNDER
Each video frame contains two vertically-stacked equirectangular panoramas.


## Methods

* createPanoramaView()

* createVideoView()
