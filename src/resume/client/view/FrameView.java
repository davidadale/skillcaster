package resume.client.view;

import net.customware.gwt.presenter.client.widget.WidgetDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;
import com.rippleware.gwt.client.ui.MessageBar;
import resume.client.presenter.FramePresenter;
import resume.shared.event.Message;
import resume.shared.event.Message.Level;

public class FrameView extends Composite implements FramePresenter.Display{

	private static FrameViewUiBinder uiBinder = GWT
			.create(FrameViewUiBinder.class);

	interface FrameViewUiBinder extends UiBinder<Widget, FrameView> {
	}

	@UiField
	MessageBar messageBar;
	
	@UiField
	DeckPanel screens;
	
	public FrameView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void showView(WidgetDisplay display){
		screens.add( display.asWidget() );
	}
	
	public void closeView(WidgetDisplay display){
		screens.remove( display.asWidget() );
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

	public void show(Message message) {
		
		if( message.getLevel()== Level.INFO){
			messageBar.info( message.getMessage() );
		}else{
			messageBar.error( message.getMessage() );
		}
		
	}

	
}
