package test.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTSettings.ViewPort;
import com.googlecode.mgwt.ui.client.MGWTSettings.ViewPort.DENSITY;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.touch.TouchPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TestPopup implements EntryPoint {

	
	/**
	 * Resources that match the GWT standard style theme.
	 */
	public interface Resources extends ClientBundle {
	
		/**
		 * The styles used in this widget.
		 */
		@Source({ Css.DEFAULT_CSS })
		Css css();
	}
	
	public interface Css extends CssResource {
		/**
		 * The path to the default CSS styles used by this resource.
		 */
		String DEFAULT_CSS = "test/client/Test.css";

		String touchPanel();
		String popupPanel();
		String popupPanelTouch();
		String popupPanelShow();
	}

	
	Resources resources = GWT.create(Resources.class);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// set viewport and other settings for mobile
		ViewPort viewPort = new MGWTSettings.ViewPort();
		viewPort.setTargetDensity(DENSITY.MEDIUM);
	    viewPort.setUserScaleAble(false).setMinimumScale(1.0).setMinimumScale(1.0).setMaximumScale(1.0);
		MGWTSettings settings = new MGWTSettings();
		settings.setViewPort(viewPort);
		settings.setAddGlosToIcon(true);
		settings.setFullscreen(true);
		settings.setPreventScrolling(true);
		MGWT.applySettings(settings);
		
		resources.css().ensureInjected();
		
		// set the view
		LayoutPanel layoutPanel = new LayoutPanel();
		
		TouchPanel touchPanel = new TouchPanel();
		touchPanel.addStyleName(resources.css().touchPanel());
		layoutPanel.add(touchPanel);
		
		
		// set the popup
		final PopupPanel popupPanel = new PopupPanel(true, true);
		popupPanel.addStyleName(resources.css().popupPanel());
//		
		LayoutPanel popupLayoutPanel = new LayoutPanel();
		popupPanel.add(popupLayoutPanel);
		
		TouchPanel popupTouchPanel = new TouchPanel();
		popupTouchPanel.addStyleName(resources.css().popupPanelTouch());
		popupLayoutPanel.add(popupTouchPanel);

		ScrollPanel scrollPanel = new ScrollPanel();
		CellList<Item> myCellList = new CellList<Item>(new ItemCell());
		myCellList.setRound(true);
		myCellList.setGroup(false);
		
		// add elements to item cell
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(new Item("item1"));
		itemList.add(new Item("item2"));
		itemList.add(new Item("item3"));
		itemList.add(new Item("item4"));
		itemList.add(new Item("item5"));
		itemList.add(new Item("item6"));
		itemList.add(new Item("item7"));
		itemList.add(new Item("item8"));
		itemList.add(new Item("item9"));
		itemList.add(new Item("item10"));
		
		myCellList.render(itemList);
		scrollPanel.refresh();
		
		
		scrollPanel.add(myCellList);
		popupLayoutPanel.add(scrollPanel);
		
		
		
		
		
		
		// add to root panel
		RootPanel.get().add(layoutPanel);
		RootPanel.get().add(popupPanel);
	}
}
