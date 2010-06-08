package resume.client.presenter;

import java.util.List;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import resume.client.component.AccomplishmentWidget;
import resume.shared.data.Accomplishment;
import resume.shared.data.Bio;
import resume.shared.data.Experience;
import resume.shared.data.Profile;
import resume.shared.data.Skill;
import resume.shared.event.AddEducationEvent;
import resume.shared.event.AddWorkExperienceEvent;
import resume.shared.event.DeleteAccomplishmentEvent;
import resume.shared.event.DeleteAccomplishmentEventHandler;
import resume.shared.event.EditAccomplishmentEvent;
import resume.shared.event.EditExperienceEvent;
import resume.shared.event.EditProfileEvent;
import resume.shared.event.EditSkillsEvent;
import resume.shared.event.ExperienceSavedEvent;
import resume.shared.event.ExperienceSavedEventHandler;
import resume.shared.event.ProfileLoadedEvent;
import resume.shared.event.ProfileLoadedEventHandler;
import resume.shared.event.ProfileSavedEvent;
import resume.shared.event.ProfileSavedEventHandler;
import resume.shared.event.SkillsSavedEvent;
import resume.shared.event.SkillsSavedEventHandler;
import resume.shared.rpc.DeleteAccomplishment;
import resume.shared.rpc.DispatchCallback;
import resume.shared.rpc.EducationSavedEvent;
import resume.shared.rpc.EducationSavedEventHandler;
import resume.shared.rpc.SaveBio;
import resume.shared.rpc.SaveBioResult;
import resume.shared.rpc.VoidResult;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Anchor;
import com.google.inject.Inject;
import com.rippleware.gwt.client.ui.HasCommand;
import com.rippleware.gwt.client.ui.ImageUploader;

public class MyProfilePresenter extends
		WidgetPresenter<MyProfilePresenter.Display> {

	DispatchAsync dispatcher;
	Profile profile;
	Bio bio;
	List<Skill> skills;

	EventBus eventBus;

	public interface Display extends WidgetDisplay {

		void setProfile(Profile profile);
		void setProfileImageUrl(String url);
		void showImageDialog();
		void setBio(Bio bio);
		void editBio();
		void commitBio();
		void addAccomplishement(AccomplishmentWidget accomplishment);
		void removeAccomplishment(AccomplishmentWidget accomplishment);
		void setAccomplishements(List<Accomplishment> accomplishments);
		void setSkillList(List<Skill> skills);
		HasCommand getEditProfileMenuItem();
		HasCommand getEditProfileImageMenuItem();
		HasCommand getEditSkillsMenuItem();
		HasCommand getEditBioMenuItem();
		HasCommand getAddWorkExperienceMenuItem();
		HasCommand getAddEducationMenuItem();
		HasClickHandlers getSaveBioLink();
		HasClickHandlers getCancelBioLink();
		ImageUploader getImageUploader();
	}

	@Inject
	public MyProfilePresenter(Display display, EventBus eventBus,
			DispatchAsync dispatcher) {
		super(display, eventBus);
		this.eventBus = eventBus;
		this.dispatcher = dispatcher;
	}

	@Override
	public Place getPlace() {
		return null;
	}

	protected String getUnCroppedProfileImageUrl(){
		return "/image?username=" + profile.getUsername();
	}
	
	protected String getCroppedProfileImageUrl(){
		return "/crop?username=" + profile.getUsername(); 
	}
	
	@Override
	protected void onBind() {
		
		display.getAddWorkExperienceMenuItem().setCommand(new Command() {
			public void execute() {
				eventBus.fireEvent(new AddWorkExperienceEvent());
			}
		});
		
		display.getAddEducationMenuItem().setCommand(new Command(){
			 public void execute() {
				 eventBus.fireEvent( new AddEducationEvent() );
			}
		});

		display.getEditProfileMenuItem().setCommand(new Command() {
			public void execute() {
				eventBus.fireEvent(new EditProfileEvent(profile));
			}
		});

		display.getEditSkillsMenuItem().setCommand( new Command(){
			public void execute() {
				eventBus.fireEvent( new EditSkillsEvent( skills ) );
			}
		});
		
		// load up the data on the myprofile presenter after profile has been
		// retrieved
		eventBus.addHandler(ProfileLoadedEvent.TYPE,
				new ProfileLoadedEventHandler() {
					public void onProfileLoaded(ProfileLoadedEvent event) {
						profile = event.getProfile();
						getDisplay().setProfile(event.getProfile()); // display
						// data

						if (event.getBio() != null) {
							bio = event.getBio(); // store bio
							getDisplay().setBio(bio); // set display

						}

						display.getImageUploader().setCroppedImageUrl( getCroppedProfileImageUrl() );
						display.getImageUploader().setUnCroppedImageUrl( getUnCroppedProfileImageUrl() );
						
						display.getImageUploader().showImage();

						for ( Accomplishment a : event.getAccomplisments()) {
							display.addAccomplishement( 
									createWidgetWithLinks( new AccomplishmentWidget( a ), a ) );
						}
						
						skills = event.getSkills();
						display.setSkillList( skills );
						
					}
				});
		
		eventBus.addHandler(DeleteAccomplishmentEvent.TYPE,
				new DeleteAccomplishmentEventHandler() {
					public void deleteAcccomplishment(
							DeleteAccomplishmentEvent event) {
						dispatcher.execute(new DeleteAccomplishment(event
								.getAccomplishment()),
								new DispatchCallback<VoidResult>() {
									@Override
									public void onSuccess(VoidResult result) {
										// display.removeAccomplishment(event.get
										// )
									}
								});
					}
				});

		eventBus.addHandler(ExperienceSavedEvent.TYPE,
				new ExperienceSavedEventHandler() {
					public void experienceSaved(final ExperienceSavedEvent event) {
						display.addAccomplishement( 
								createWidgetWithLinks(new AccomplishmentWidget(event.getExperience()),event.getExperience())
						);
					}
				});

		eventBus.addHandler(SkillsSavedEvent.TYPE, new SkillsSavedEventHandler() {
			public void skillsSaved(SkillsSavedEvent event) {
				MyProfilePresenter.this.skills = event.getSkills();
				display.setSkillList( event.getSkills() );
			}
		});
		
		eventBus.addHandler(EducationSavedEvent.TYPE, new EducationSavedEventHandler() {
			public void educationSaved(final EducationSavedEvent event) {
				display.addAccomplishement(
						createWidgetWithLinks(new AccomplishmentWidget( event.getEducation() ), event.getEducation() )
				);
			}
		});
		
		eventBus.addHandler(ProfileSavedEvent.TYPE,
				new ProfileSavedEventHandler() {
					public void saveProfile(ProfileSavedEvent event) {
						profile = event.getProfile();
						getDisplay().setProfile(event.getProfile()); // update
						// display
					}
				});

		display.getEditProfileImageMenuItem().setCommand(new Command() {
			public void execute() {
				display.showImageDialog();
			}
		});

		display.getEditBioMenuItem().setCommand(new Command() {
			public void execute() {
				display.editBio();
			}
		});

//		display.getClearImageHandler().addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//
//				dispatcher.execute(
//						new RemoveProfileImage(profile.getUsername()),
//						new DispatchCallback<VoidResult>() {
//							public void onSuccess(VoidResult result) {
//
//							};
//						});
//			}
//		});

		display.getSaveBioLink().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				display.commitBio();
				if (bio != null) {
					dispatcher.execute(new SaveBio(bio),
							new DispatchCallback<SaveBioResult>() {
								@Override
								public void onSuccess(SaveBioResult result) {

								}
							});
				}
			}
		});

	}
	
	protected AccomplishmentWidget createWidgetWithLinks(final AccomplishmentWidget widget, final Accomplishment a ){
		widget.getEditLink().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent clickEvent) {
				eventBus.fireEvent( new EditAccomplishmentEvent( a ) );
			}
		});
		widget.getDeleteLink().addClickHandler( new ClickHandler() {
			public void onClick(ClickEvent clickEvent) {
				eventBus.fireEvent( new DeleteAccomplishmentEvent( a ) );
				display.removeAccomplishment( widget );
			}
		});		
		
		return widget;
	}

	
	
	
	protected ClickHandler createEditExperienceHandler(final Accomplishment a) {
		return new ClickHandler() {
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new EditExperienceEvent((Experience) a));
			}
		};
	}

	
	
	protected Anchor createEditLink(final Accomplishment accomplishment) {
		Anchor anchor = new Anchor("Edit");

		anchor.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new EditExperienceEvent(
						(Experience) accomplishment));
			}
		});

		return anchor;
	}

	protected Anchor createDeleteLink(final AccomplishmentWidget item,
			final Accomplishment accomplishment) {

		Anchor anchor = new Anchor("Delete");

		anchor.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new DeleteAccomplishmentEvent(accomplishment));
				display.removeAccomplishment(item);
			}
		});

		return anchor;

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
