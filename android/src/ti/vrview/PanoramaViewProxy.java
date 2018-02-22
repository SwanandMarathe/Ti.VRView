package ti.vrview;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.view.TiUIView;
import org.appcelerator.titanium.proxy.TiViewProxy;

import android.app.Activity;

@Kroll.proxy(creatableInModule = VrviewModule.class)
public class PanoramaViewProxy extends TiViewProxy {

	public PanoramaViewProxy() {
		super();
	}

	@Override
	public TiUIView createView(Activity activity) {
		PanoramaView view = new PanoramaView(this);
		view.getLayoutParams().autoFillsHeight = true;
		view.getLayoutParams().autoFillsWidth = true;

		return view;
	}
}