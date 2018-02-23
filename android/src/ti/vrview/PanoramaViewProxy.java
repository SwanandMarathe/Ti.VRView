package ti.vrview;

import java.io.File;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.InputStream;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.AsyncResult;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiMessenger;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;
import ti.modules.titanium.filesystem.FileProxy;
import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Message;
import android.util.Pair;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import com.google.vr.sdk.widgets.pano.VrPanoramaView.Options;

import java.io.IOException;
import org.appcelerator.titanium.io.TiBaseFile;
import org.appcelerator.titanium.io.TiFile;
import org.appcelerator.titanium.io.TiFileFactory;

@Kroll.proxy(creatableInModule = VrviewModule.class)
public class PanoramaViewProxy extends TiViewProxy {

	TiUIView view;
	private int type = VrviewModule.TYPE_MONO;
	private static final int MSG_FIRST_ID = TiViewProxy.MSG_LAST_ID + 1;
	private static final int MSG_START = MSG_FIRST_ID + 500;
	private static final int MSG_STOP = MSG_FIRST_ID + 501;
	private static final String LCAT = "TiVR";

	private ImageLoaderTask backgroundImageLoaderTask;
	private Uri fileUriOfPanoImage;
	public VrPanoramaView panoWidgetView;

	private class PanoramaView extends TiUIView {
	
		private Options panoOptions = new Options();
		public boolean loadImageSuccessful = false;
		private Uri fileUriOfPanoImage;

		public PanoramaView(final TiViewProxy proxy) {
			super(proxy);
			Log.d(LCAT,"Start PanoramaView with " + fileUriOfPanoImage.toString());
			LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			LinearLayout container = new LinearLayout(proxy.getActivity());
			container.setLayoutParams(lp);
			panoWidgetView = new VrPanoramaView(proxy.getActivity());

			panoOptions.inputType = type;
			if (backgroundImageLoaderTask != null) {
				backgroundImageLoaderTask.cancel(true);
			}
			backgroundImageLoaderTask = new ImageLoaderTask();
			backgroundImageLoaderTask
					.execute(Pair.create(fileUriOfPanoImage, panoOptions));
			container.addView(panoWidgetView);
			setNativeView(container);
		}
	}

	// Constructor
	public PanoramaViewProxy() {
		super();
	}

	@Override
	public boolean handleMessage(Message msg) {
		AsyncResult result = null;
		switch (msg.what) {

		case MSG_START: {
			result = (AsyncResult) msg.obj;
			handleStart();
			result.setResult(null);
			return true;
		}
		case MSG_STOP: {
			result = (AsyncResult) msg.obj;
			handleStop();
			result.setResult(null);
			return true;
		}
		default: {
			return super.handleMessage(msg);
		}
		}
	}

	@Kroll.method
	public void start() {
		if (TiApplication.isUIThread()) {
			handleStart();
		} else {
			TiMessenger.sendBlockingMainMessage(getMainHandler().obtainMessage(
					MSG_START));

		}
	}

	private void handleStart() {

	}

	@Kroll.method
	public void stop() {
		if (TiApplication.isUIThread()) {
			handleStop();
		} else {
			TiMessenger.sendBlockingMainMessage(getMainHandler().obtainMessage(
					MSG_STOP));

		}
	}

	private void handleStop() {

	}

	@Override
	public TiUIView createView(Activity activity) {
		view = new PanoramaView(this);
		view.getLayoutParams().autoFillsHeight = true;
		view.getLayoutParams().autoFillsWidth = true;
		return view;
	}

	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict opts) {
		super.handleCreationDict(opts);

		if (opts.containsKeyAndNotNull(TiC.PROPERTY_TYPE)) {
			type = opts.getInt(TiC.PROPERTY_TYPE);
		}
		if (opts.containsKeyAndNotNull(TiC.PROPERTY_IMAGE)) {
			Object inputValue = opts.get(TiC.PROPERTY_IMAGE);
			TiBaseFile inputFile = null;
			if (inputValue instanceof TiFile) {
				inputFile = TiFileFactory.createTitaniumFile(
						((TiFile) inputValue).getFile().getAbsolutePath(),
						false);
			} else {
				if (inputValue instanceof FileProxy) {
					inputFile = ((FileProxy) inputValue).getBaseFile();
				} else {
					if (inputValue instanceof TiBaseFile) {
						inputFile = (TiBaseFile) inputValue;
					} else {
						// Assume path provided
						inputFile = TiFileFactory.createTitaniumFile(
								inputValue.toString(), false);
					}
				}
			}
			Log.d(LCAT,"Panofile = "+inputFile.toString());
			if (inputFile.exists()) {
				fileUriOfPanoImage = Uri.fromFile(inputFile.getNativeFile());
			} else Log.e(LCAT,"(pano) file not exists");
			

		} else
			Log.w(LCAT, "image missing");

	}

	/**
	 * Helper class to manage threading.
	 */
	class ImageLoaderTask extends AsyncTask<Pair<Uri, Options>, Void, Boolean> {

		/**
		 * Reads the bitmap from disk in the background and waits until it's
		 * loaded by pano widget.
		 */
		@SuppressWarnings("unchecked")
		@Override
		protected Boolean doInBackground(Pair<Uri, Options>... fileInformation) {
			Options panoOptions = null; // It's safe to use null
			// VrPanoramaView.Options.
			InputStream istr = null;

			try {
				istr = new FileInputStream(new File(
						fileInformation[0].first.getPath()));
				panoOptions = fileInformation[0].second;
			} catch (IOException e) {
				return false;
			}

			panoWidgetView.loadImageFromBitmap(
					BitmapFactory.decodeStream(istr), panoOptions);
			try {
				istr.close();
			} catch (IOException e) {
			}

			return true;
		}
	}

}
