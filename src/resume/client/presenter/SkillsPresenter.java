package resume.client.presenter;

import java.util.List;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import resume.shared.data.Skill;
import resume.shared.event.CancelEvent;
import resume.shared.event.SkillsSavedEvent;
import resume.shared.rpc.DispatchCallback;
import resume.shared.rpc.SaveSkills;
import resume.shared.rpc.SaveSkillsResult;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.inject.Inject;

public class SkillsPresenter extends WidgetPresenter<SkillsPresenter.Display> {

	DispatchAsync dispatcher;
	
	List<Skill> skills;
	
	@Inject
	public SkillsPresenter(Display display, EventBus eventBus,
			DispatchAsync dispatcher) {
		super(display, eventBus);
		this.dispatcher = dispatcher;
	}

	public interface Display extends WidgetDisplay{
		public void setSkills( List<Skill> skills );
		public void commit();
		public HasClickHandlers getSaveButton();
		public HasClickHandlers getCancelButton();
	}

	@Override
	public Place getPlace() {
		return null;
	}

	@Override
	protected void onBind() {
		display.getSaveButton().addClickHandler( new ClickHandler() {
			public void onClick(ClickEvent event) {
				display.commit();
				dispatcher.execute(new SaveSkills( skills ), new DispatchCallback<SaveSkillsResult>() {
					@Override
					public void onSuccess(SaveSkillsResult result) {
						eventBus.fireEvent( new SkillsSavedEvent(result.getSkills() ) );
						eventBus.fireEvent( new CancelEvent( SkillsPresenter.this ) );
					}
				});
			}
		});
		
		display.getCancelButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				eventBus.fireEvent( new CancelEvent( SkillsPresenter.this ) );
			}
		});
	}
	
	public void setSkills(List<Skill> skills){
		this.skills = skills;
		display.setSkills( skills );
	}

	@Override
	protected void onPlaceRequest(PlaceRequest request) {
		
	}

	@Override
	protected void onUnbind() {
		
	}

	public void refreshDisplay() {
		
	}

	public void revealDisplay() {
		
	}
	
}
