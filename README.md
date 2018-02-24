# Ti.VRView

It is a Titanium module for realizing of a VRPanoramaView and VRVideoView.


## Usage

```javascript
var VR = require("ti.vrview");
var win = Ti.UI.createWindow({
});
var panoView = VR.createPanoramaView({
    type : VR.TYPE_MONO,
    image : Ti.Filessystem.getFile(Ti.Filesystem.applicationDataDirectory, "pano.jpg")),
    onload : function() {}
});
var panoView = VR.createVideoView({
    type : VR.TYPE_STEREO_OVER_UNDER,
    format : VR.FORMAT_DEFAULT,
    image : Ti.Filessystem.getFile(Ti.Filesystem.applicationDataDirectory, "pano.mp4"))
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
