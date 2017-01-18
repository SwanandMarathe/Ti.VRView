package de.appwerft.vrview;

import android.view.LayoutInflater;
import android.view.View;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.util.TiRHelper;
import org.appcelerator.titanium.view.TiUIView;

public class PanoramaView extends TiUIView {

    private static final String TAG = "de.appwerft.vrview.PanoramaView";
    private VrPanoramaView panoWidgetView;

    private static int id_pano_container = 0;
    private static int id_pano_view = 0;

    public PanoramaView(TiViewProxy proxy) {
        super(proxy);

        try {
            id_pano_container = TiRHelper.getResource("id.pano_container");
            id_pano_view = TiRHelper.getResource("id.pano_view");
        } catch (TiRHelper.ResourceNotFoundException e) {
            Log.e(TAG, "XML resources could not be found!!!");
        }

        LayoutInflater inflater = LayoutInflater.from(proxy.getActivity());
        View view = inflater.inflate(id_pano_container, null, false);

        setNativeView(view);

    }

}