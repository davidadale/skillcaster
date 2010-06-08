package resume.client.component;

import resume.shared.data.Skill;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.pietschy.gwt.pectin.client.binding.WidgetBinder;

public class SkillWidget extends Composite{

	private static SkillWidgetUiBinder uiBinder = GWT
			.create(SkillWidgetUiBinder.class);

	interface SkillWidgetUiBinder extends UiBinder<Widget, SkillWidget> {
	}

	SkillModel model = new SkillModel();
	WidgetBinder binder = new WidgetBinder();
	
	//@UiField(provided=true)
	//ComboBox<Skill.Category> category = new ComboBox<Skill.Category>( Skill.Category.values() );
	@UiField
	Label category;

	@UiField
	TextArea qualifications;
	
	Skill skill;
	
	public SkillWidget(){
		initWidget(uiBinder.createAndBindUi(this));
		qualifications.setWidth("100%");
		//binder.bind( model.category ).to(  category );
		binder.bind( model.qualifications ).to( qualifications );
	}
	
	public SkillWidget(Skill skill) {
		this.skill = skill;
		initWidget(uiBinder.createAndBindUi(this));
		qualifications.setWidth("100%");
		//binder.bind( model.category ).to( category );
		category.setText( skill.getCategory().toString() );
		binder.bind( model.qualifications ).to( qualifications );
		model.setSkill( skill );
	}
	
	public Skill getSkill(){
		return skill;
	}
	
	public void setSkill(Skill skill){
		category.setText( skill.getCategory().toString() );
		model.setSkill( skill );
	}
	
	public void commit(){
		model.commit();
	}

}
