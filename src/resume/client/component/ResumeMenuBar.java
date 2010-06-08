package resume.client.component;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import com.rippleware.gwt.client.ui.MenuItem;


public class ResumeMenuBar extends Composite {

	MenuItem addWorkExperienceMnu = new MenuItem("Work Experience");	
	MenuItem addEducationMnu = new MenuItem("Education");
	MenuItem editProfileImageMnu = new MenuItem("Profile Image");
	MenuItem editProfileMnu = new MenuItem("Profile");
	MenuItem editBioMnu = new MenuItem("Bio");
	MenuItem editSkillsMnu = new MenuItem("Skills");
	MenuBar menuBar;
	
	public ResumeMenuBar() {
		
		menuBar = new MenuBar();
		
		MenuBar addMenu = new MenuBar(true);
		addMenu.addItem( addWorkExperienceMnu );
		addMenu.addItem( addEducationMnu );
		
		MenuBar editMenu = new MenuBar(true);
		editMenu.addItem( editProfileMnu  );
		editMenu.addItem( editBioMnu );
		editMenu.addItem( editSkillsMnu );
		editMenu.addItem( editProfileImageMnu );
		MenuItem addMenuItem = new MenuItem("Add Stuff", addMenu);
		MenuItem editMenuItem = new MenuItem("Edit Stuff", editMenu );
		
		menuBar.addItem( addMenuItem );
		menuBar.addItem( editMenuItem );
		
		initWidget(menuBar);
	}

	public MenuItem getAddWorkExperienceMnu() {
		return addWorkExperienceMnu;
	}

	public MenuItem getAddEducationMnu() {
		return addEducationMnu;
	}

	public MenuItem getEditProfileImageMnu() {
		return editProfileImageMnu;
	}

	public MenuItem getEditProfileMnu() {
		return editProfileMnu;
	}

	public MenuItem getEditBioMnu() {
		return editBioMnu;
	}

	public MenuItem getEditSkillsMnu() {
		return editSkillsMnu;
	}

}
