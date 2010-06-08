package resume.client.view;

import resume.client.presenter.EducationPresenter;
import resume.shared.data.Education;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.pietschy.gwt.pectin.client.binding.WidgetBinder;


public class EducationView extends Composite implements EducationPresenter.Display {

	private static EducationViewUiBinder uiBinder = GWT
			.create(EducationViewUiBinder.class);

	EducationViewModel model = new EducationViewModel();
	WidgetBinder binder = new WidgetBinder();

	
	@UiField
	Button save;
	
	@UiField
	Button cancel;
	
	@UiField
	TextBox school;
	
	@UiField
	TextBox degree;
	
	@UiField
	DateBox completed;
	 
	
	interface EducationViewUiBinder extends UiBinder<Widget, EducationView> {
	}

	public EducationView() {
		initWidget(uiBinder.createAndBindUi(this));
		binder.bind( model.school ).to( school );
		binder.bind( model.degree ).to( degree );
		binder.bind( model.completed ).to( completed );
	}

	public void commit() {
		model.commit();
	}

	public void setEducation(Education education) {
		model.setEducation( education );
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

	public HasClickHandlers getCancelButton() {
		return cancel;
	}

	public HasClickHandlers getSaveButton() {
		return save;
	}

}
