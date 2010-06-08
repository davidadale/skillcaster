package resume.client.view;

import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import resume.client.presenter.AppPresenter;
import resume.shared.event.Message;
import resume.shared.event.Message.Level;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.rippleware.gwt.client.ui.MessageBar;

public class AppView extends Composite implements AppPresenter.Display{

	private static AppViewUiBinder uiBinder = GWT.create(AppViewUiBinder.class);

	interface AppViewUiBinder extends UiBinder<DockLayoutPanel, AppView> {
	}	

	@UiField
	MessageBar messageBar;
	
	@UiField
	HTMLPanel header;	
	
	@UiField
	DeckPanel screens;
	
	public AppView(){
		DockLayoutPanel outer = uiBinder.createAndBindUi(this);
		initWidget(outer);
		screens.setAnimationEnabled(true);
		Element north = outer.getWidgetContainerElement( header ); 
		north.getStyle().setOverflow(Overflow.VISIBLE);
		
		//Element topElem = outer.getWidgetContainerElement(header);
	    //topElem.getStyle().setOverflow(Overflow.VISIBLE);				
	}
	
	public void addTab(String label, Widget tab) {
		// TODO Auto-generated method stub
		
	}

	public void setFooter(Widget footer) {
		// TODO Auto-generated method stub
		
	}

	public void setHeader(Widget header) {
		// TODO Auto-generated method stub
		
	}

	public void setMainTab(Widget tab) {
		// TODO Auto-generated method stub
		
	}

	public Widget asWidget() {
		return this;
	}

	public void startProcessing() {
		// TODO Auto-generated method stub
		
	}

	public void stopProcessing() {
		// TODO Auto-generated method stub
		
	}

	public void cancelActiveScreen() {
		
		int activeScreenIndex = screens.getVisibleWidget();
		if( activeScreenIndex > 0 ){
			screens.remove( activeScreenIndex );
		}
		screens.showWidget(0);
	}

	public void showScreen(WidgetDisplay screen) {
		screens.add( screen.asWidget() );
		int index = screens.getWidgetIndex( screen.asWidget() );
		screens.showWidget( index );
	}

	public void show(Message msg) {
		if( msg.getLevel() == Level.INFO ){
			messageBar.info( msg.getMessage() );
		}else{
			messageBar.error( msg.getMessage() );
		}
	}

	public void closeView(WidgetDisplay display) {
		screens.remove( display.asWidget() );
		int count = screens.getWidgetCount();
		if( count > 0 ){
			screens.showWidget( 0 );	
		}
	}

	public void showView(WidgetDisplay display) {
		screens.add( display.asWidget() );
		int index = screens.getWidgetIndex( display.asWidget() );
		screens.showWidget( index );
	}
	
}
