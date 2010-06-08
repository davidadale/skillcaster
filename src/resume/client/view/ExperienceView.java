package resume.client.view;

import resume.client.presenter.ExperiencePresenter;
import resume.shared.data.Experience;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.pietschy.gwt.pectin.client.binding.WidgetBinder;

public class ExperienceView extends Composite implements ExperiencePresenter.Display {

	private static ExperienceViewUiBinder uiBinder = GWT
			.create(ExperienceViewUiBinder.class);

	interface ExperienceViewUiBinder extends
			UiBinder<Widget, ExperienceView> {
	}
	
	ExperienceViewFormModel model = new ExperienceViewFormModel();
	WidgetBinder binder = new WidgetBinder();
	
	@UiField
	TextBox company;
	
	@UiField
	DateBox completed;
	Label label = new Label();
	
	@UiField
	TextBox role;
	
	@UiField
	TextArea shortDescription;
	
	@UiField
	Button save;
	
	@UiField
	Button cancel;

	public ExperienceView() {
		initWidget(uiBinder.createAndBindUi(this));
		DateTimeFormat format = DateTimeFormat.getShortDateFormat();
		
		completed.setFormat(new DateBox.DefaultFormat(format));
		binder.bind(model.company).to(company);
		binder.bind(model.completed).to(completed);
		binder.bind(model.role).to(role);
		binder.bind(model.shortDescription).to(shortDescription);
	}

	public Widget asWidget() {
		return this;
	}

	public void startProcessing() {
		
	}

	public void stopProcessing() {
		
	}

	public void commit() {
		model.commit();
	}

	public HasClickHandlers getCancelButton() {
		return cancel;
	}

	public HasClickHandlers getSaveButton() {
		return save;
	}

	public void setExperience(Experience experience) {
		model.setExperience( experience );
	}

}
