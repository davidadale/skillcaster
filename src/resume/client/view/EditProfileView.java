package resume.client.view;

import resume.client.presenter.EditProfilePresenter;
import resume.shared.data.Profile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.pietschy.gwt.pectin.client.binding.WidgetBinder;
import com.pietschy.gwt.pectin.client.components.AbstractDynamicList;
import com.pietschy.gwt.pectin.client.validation.binding.ValidationBinder;
import com.pietschy.gwt.pectin.client.validation.component.ValidationDisplayLabel;

public class EditProfileView extends Composite implements
		EditProfilePresenter.Display {

	private EditProfileViewFormModel model = new EditProfileViewFormModel();

	private WidgetBinder binder = new WidgetBinder();
	private ValidationBinder validation = new ValidationBinder();

	ValidationDisplayLabel nameValidationMessages = new ValidationDisplayLabel();

	private static EditProfileViewUiBinder uiBinder = GWT
			.create(EditProfileViewUiBinder.class);

	interface EditProfileViewUiBinder extends UiBinder<Widget, EditProfileView> {
	}
	
	interface Style extends CssResource{
		String website();
		String email();
	}
	
	@UiField
	Style otherStyles;

	@UiField
	TextBox name;

	@UiField
	TextBox title;

	@UiField
	TextBox company;

	@UiField
	FlowPanel emailElement;

	@UiField
	FlowPanel phoneNumberElement;

	@UiField
	FlowPanel addressElement;

	@UiField
	FlowPanel websiteElement;
	
	@UiField
	FlowPanel blogElement;
	
	AbstractDynamicList<String> emails;

	AbstractDynamicList<String> phoneNumbers;

	AbstractDynamicList<String> addresses;

	AbstractDynamicList<String> websites;
	
	AbstractDynamicList<String> blogs;	
	

	@UiField
	Button save;

	@UiField
	Button cancel;

	public EditProfileView() {

		initWidget(uiBinder.createAndBindUi(this));
		createDynamicList();
		emailElement.add(emails);
		phoneNumberElement.add(phoneNumbers);
		addressElement.add(addresses);
		websiteElement.add(websites);
		blogElement.add(blogs);

		binder.bind(model.name).to(name);
		binder.bind(model.title).to(title);
		binder.bind(model.company).to(company);
		binder.bind(model.emails).to(emails);
		binder.bind(model.addresses).to(addresses);
		binder.bind(model.phoneNumbers).to(phoneNumbers);
		binder.bind(model.websites).to(websites);
		binder.bind(model.blogs).to(blogs);

		validation.bindValidationOf(model.name).to(nameValidationMessages);

	}
	
	protected void createDynamicList(){
		emails = new AbstractDynamicList<String>("Add",
				"Remove", false) {
			protected HasValue<String> createWidget() {
				TextBox email = new TextBox();
				email.addStyleName( otherStyles.email() );
				return email;
			}
		};
		
		phoneNumbers = new AbstractDynamicList<String>(
				"Add", "Remove", false) {
			@Override
			protected HasValue<String> createWidget() {
				return new TextBox();
			}
		};		
		
		addresses = new AbstractDynamicList<String>(
				"Add", "Remove", false) {
			@Override
			protected HasValue<String> createWidget() {
				return new TextArea();
			}
		};
		
		websites = new AbstractDynamicList<String>(
				"Add", "Remove", false) {
			protected HasValue<String> createWidget() {
				TextBox url = new TextBox();
				url.addStyleName( otherStyles.website() );
				return url;
			};
		};
		
		blogs = new AbstractDynamicList<String>(
				"Add", "Remove", false) {
			protected HasValue<String> createWidget() {
				TextBox url = new TextBox();
				url.addStyleName( otherStyles.website() );
				return url;			
			};
		};			
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

	public HasClickHandlers getSaveButton() {
		return save;
	}

	public HasClickHandlers getCancelButton() {
		return cancel;
	}

	public void setProfile(Profile profile) {
		model.setContact(profile);
	}

	// private ValidationDisplayLabel createValidationLabel(FieldModelBase<?>
	// field) {
	// ValidationDisplayLabel label = new ValidationDisplayLabel();
	// validation.bindValidationOf(field).to(label);
	// return label;
	// }

}
