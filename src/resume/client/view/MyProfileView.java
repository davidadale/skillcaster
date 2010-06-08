package resume.client.view;

import java.util.List;

import resume.client.component.AccomplishmentWidget;
import resume.client.component.ResumeMenuBar;
import resume.client.presenter.MyProfilePresenter;
import resume.shared.data.Accomplishment;
import resume.shared.data.Bio;
import resume.shared.data.Profile;
import resume.shared.data.Skill;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.Widget;
import com.pietschy.gwt.pectin.client.binding.WidgetBinder;
import com.rippleware.gwt.client.ui.CoolList;
import com.rippleware.gwt.client.ui.EditableLabel;
import com.rippleware.gwt.client.ui.HasCommand;
import com.rippleware.gwt.client.ui.ImageUploader;
import com.rippleware.gwt.client.ui.SimpleListItem;
import com.rippleware.gwt.client.ui.UnorderedList;

public class MyProfileView extends ResizeComposite implements
		MyProfilePresenter.Display {

	interface MyProfileViewBinder extends UiBinder<Widget, MyProfileView> {
	}

	private static MyProfileViewBinder uiBinder = GWT
			.create(MyProfileViewBinder.class);

	MyProfileViewModel model = new MyProfileViewModel();
	WidgetBinder binder = new WidgetBinder();

	Profile profile;
	Bio bio;

	@UiField
	ResumeMenuBar menuBar;

	@UiField
	ImageUploader profileImage;

	@UiField
	DockLayoutPanel layout;

	@UiField
	DivElement name;

	@UiField
	DivElement title;

	@UiField
	DivElement company;

	@UiField
	EditableLabel bioLabel;

	@UiField
	UnorderedList skills;

	@UiField
	CoolList accomplishments;

	public MyProfileView() {
		initWidget(uiBinder.createAndBindUi(this));
		binder.bind(model.story).to(bioLabel);
		bioLabel
				.setEmptyMessage("No bio has been filled out yet. Click on the edit link to update your bio.");
	}

	public Widget asWidget() {
		return this;
	}

	public void startProcessing() {

	}

	public void stopProcessing() {

	}

	public Profile getProfile() {
		return this.profile;
	} 

	public void setProfile(Profile profile) {
		this.profile = profile;
		name.setInnerText(profile.getName());
		title.setInnerText(profile.getTitle());
		company.setInnerText(profile.getCompany());
	}
	
	public ImageUploader getImageUploader(){
		return profileImage;
	}

	public Bio getBio() {
		return this.bio;
	}

	public void setBio(Bio bio) {
		this.bio = bio;
		model.setBio(bio);
	}

	public void setAccomplishements(List<Accomplishment> accomplishments) {
		for (Accomplishment acc : accomplishments) {
			this.addAccomplishement(acc);
		}
	}

	public void setSkillList(List<Skill> skills) {
		this.skills.clear();

		for (Skill skill : skills) {
			if (!skill.isEmpty()) {
				SimpleListItem li = new SimpleListItem("<p><b>"
						+ skill.getCategory().toString() + "</b><br/>"
						+ skill.getQualifications() + "</p>", true);
				this.skills.add(li);
			}
		}

	}

	public void commitBio() {
		model.commit();
	}

	public void showImageDialog() {
		profileImage.showEditor();
	}

	public void editBio() {
		bioLabel.edit();
	}

	public HasClickHandlers getCancelBioLink() {
		return bioLabel.getCancelButton();
	}

	public HasClickHandlers getEditBioLink() {
		return bioLabel.getEditButton();
	}

	public HasClickHandlers getSaveBioLink() {
		return bioLabel.getSaveButton();
	}

	// public HasChangeHandlers getProfileImage() {
	// //return profileImage;
	// }

	public void setProfileImageUrl(String url) {
		// /profileImage.setProfileImageUrl(url);
	}

	public HasCommand getAddWorkExperienceMenuItem() {
		return menuBar.getAddWorkExperienceMnu();
	}

	public HasCommand getAddEducationMenuItem() {
		return menuBar.getAddEducationMnu();
	}

	public HasCommand getEditProfileImageMenuItem() {
		return menuBar.getEditProfileImageMnu();
	}

	public HasCommand getEditProfileMenuItem() {
		return menuBar.getEditProfileMnu();
	}

	public HasCommand getEditBioMenuItem() {
		return menuBar.getEditBioMnu();
	}

	public HasCommand getEditSkillsMenuItem() {
		return menuBar.getEditSkillsMnu();
	}

	public void addAccomplishement(Accomplishment accomplishment) {
		AccomplishmentWidget widget = new AccomplishmentWidget(accomplishment);
		// widget.addActionLink(createDeleteLink());
		// widget.addActionLink(createDeleteLink());
		accomplishments.add(widget);
	}

	protected Anchor createDeleteLink() {
		Anchor delete = new Anchor("Delete");
		delete.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

			}
		});
		return delete;
	}

	public void addAccomplishement(AccomplishmentWidget accomplishment) {
		accomplishments.add(accomplishment);
	}

	public void removeAccomplishment(AccomplishmentWidget accomplishment) {
		accomplishments.remove(accomplishment);
	}

}
