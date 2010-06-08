package resume.client.view;


import static com.pietschy.gwt.pectin.client.metadata.MetadataPlugin.watermark;
import static com.pietschy.gwt.pectin.client.validation.ValidationPlugin.validateField;
import resume.shared.data.Profile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.pietschy.gwt.pectin.client.FieldModel;
import com.pietschy.gwt.pectin.client.FormModel;
import com.pietschy.gwt.pectin.client.ListFieldModel;
import com.pietschy.gwt.pectin.client.bean.BeanModelProvider;
import com.pietschy.gwt.pectin.client.validation.ValidationManager;
import com.pietschy.gwt.pectin.client.validation.ValidationPlugin;
import com.pietschy.gwt.pectin.client.validation.validator.NotEmptyValidator;

public class EditProfileViewFormModel extends FormModel {

	// create our bindings to our bean
	public abstract static class ContactProvider extends
			BeanModelProvider<Profile> {
	}

	private BeanModelProvider<Profile> profileProvider;

	FieldModel<String> name;
	FieldModel<String> title;
	FieldModel<String> company;
	ListFieldModel<String> emails;
	ListFieldModel<String> phoneNumbers;
	ListFieldModel<String> addresses;
	ListFieldModel<String> websites;
	ListFieldModel<String> blogs;

	public EditProfileViewFormModel() {
		this.profileProvider = GWT.create(ContactProvider.class);
		name = fieldOfType(String.class).boundTo(profileProvider, "name");
		title = fieldOfType(String.class).boundTo(profileProvider,"title");
		company = fieldOfType(String.class).boundTo(profileProvider,"company");
		emails = listOfType(String.class).boundTo(profileProvider,"emails" );
		addresses = listOfType(String.class).boundTo(profileProvider,"addresses");
		phoneNumbers = listOfType(String.class).boundTo(profileProvider,"phoneNumbers");
		websites = listOfType(String.class).boundTo(profileProvider,"websites");
		blogs = listOfType(String.class).boundTo(profileProvider,"blogs");
		
		watermark(name).with("Name");
		watermark(title).with("Title");
		watermark(company).with("Company");
		
		validateField(name).using(new NotEmptyValidator("Please enter your first name"));
		
		name.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
				validate();
			}
		});		
		
	}

	public void setContact(Profile contact) {
		// clear any previous validation state.
		getValidationManager().clear();
		// and update all our value models
		profileProvider.setBean(contact);
	}

	public void commit() {
		profileProvider.commit();
	}

	public boolean validate() {
		return getValidationManager().validate();
	}

	/**
	 * Exposed for testing.
	 */
	ValidationManager getValidationManager() {
		return ValidationPlugin.getValidationManager(this);
	}

}
