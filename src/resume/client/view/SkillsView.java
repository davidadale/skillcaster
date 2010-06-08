package resume.client.view;

import java.util.ArrayList;
import java.util.List;

import resume.client.component.SkillWidget;
import resume.client.presenter.SkillsPresenter;
import resume.shared.data.Skill;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class SkillsView extends Composite implements SkillsPresenter.Display {

	private static SkillsViewUiBinder uiBinder = GWT
			.create(SkillsViewUiBinder.class);

	interface SkillsViewUiBinder extends UiBinder<Widget, SkillsView> {
	}

	@UiField
	VerticalPanel skills;
	List<SkillWidget> skillWidgets = new ArrayList<SkillWidget>();
	
	@UiField
	Button save;
	
	@UiField
	Button cancel;

	public SkillsView() {
		initWidget(uiBinder.createAndBindUi(this));
		for( int i=0;i<7;i++ ){
			SkillWidget widget = new SkillWidget();
			skillWidgets.add(widget );
			skills.add( widget );
		}
	}

	public void commit() {
		for(SkillWidget widget : skillWidgets ){
			widget.commit();
		}
	}

	public HasClickHandlers getCancelButton() {
		return cancel;
	}

	public HasClickHandlers getSaveButton() {
		return save;
	}

	public void setSkills(List<Skill> skills) {
		
		for(int i=0;i<7;i++){
			skillWidgets.get( i ).setSkill( (skills.size()>i)?skills.get( i ):null  );
		}
		
//		for(Skill skill: skills){
//			SkillWidget widget = new SkillWidget( skill );
//			this.skills.add( widget );
//			this.skillWidgets.add( widget );
//		}
	}

	public Widget asWidget() {
		return this;
	}

	public void startProcessing() {

	}

	public void stopProcessing() {

	}

}
