package ti.vrview;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;

import com.google.vr.sdk.widgets.video.VrVideoView;

@Kroll.module(name = "Vrview", id = "ti.vrview")
public class VrviewModule extends KrollModule {
    
	@Kroll.constant
    final static int FORMAT_DEFAULT = VrVideoView.Options.FORMAT_DEFAULT;
	@Kroll.constant
	final static int FORMAT_HLS = VrVideoView.Options.FORMAT_HLS;
	@Kroll.constant
	final static int TYPE_MONO = VrVideoView.Options.TYPE_MONO;
	@Kroll.constant
	final static int TYPE_STEREO_OVER_UNDER = VrVideoView.Options.TYPE_STEREO_OVER_UNDER;
    
    public VrviewModule() {
        super();
    }
    
    @Kroll.onAppCreate
    public static void onAppCreate(TiApplication app) {
        
    }
    
}
