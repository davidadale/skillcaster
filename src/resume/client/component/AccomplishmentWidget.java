package resume.client.component;

import resume.shared.data.Accomplishment;
import resume.shared.data.Education;
import resume.shared.data.Experience;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Anchor;
import com.rippleware.gwt.client.ui.ListItem;

public class AccomplishmentWidget extends ListItem  {

	Accomplishment item;
	
	DateTimeFormat format = DateTimeFormat.getFormat("MMM yyyy");
	
	Anchor edit = new Anchor("Edit");
	Anchor delete = new Anchor("Delete");
	
	public AccomplishmentWidget(Accomplishment item) {
		super();
		this.item = item;
		if( item instanceof Experience ){
			buildListItem(getExperienceHtml(  ((Experience)item) )  );
		}else if( item instanceof Education){
			buildListItem(getEducationHtml(  ((Education)item) )  );
		}
	}	
	
	public AccomplishmentWidget(Experience item) {
		super();
		this.item = item;
		buildListItem(getExperienceHtml(item));
	}
	
	public AccomplishmentWidget(Education item) {
		super();
		this.item = item;
		buildListItem(getEducationHtml(item ));
	}
	
	protected void buildListItem(String html){
		setHtml( html );
		addLinks();
	}
	
	protected String getExperienceHtml(Experience experience){
		
		StringBuffer html = new StringBuffer();
		html.append( format.format(experience.getCompletionDate()) + " - <strong>" + experience.getCategory() + "</strong>");
		html.append( "<div>" + experience.getShortDescription() + "</div>" );
		return html.toString();
		
	}
	
	protected String getEducationHtml(Education education){
		
		StringBuffer html = new StringBuffer();
		html.append( format.format(education.getCompletionDate()) + " - <strong>" + education.getCategory() + "</strong>" );
		html.append( "<div>" + education.getDegree() + " - " + education.getSchool() + "</div>" );
		return html.toString();
	}
	
	protected void addLinks(){
		addActionLink( edit );
		addActionLink( delete );		
	}
	
	public Long getId(){
		return item.getId();
	}
	
	public HasClickHandlers getEditLink(){
		return edit;
	}
	
	public HasClickHandlers getDeleteLink(){
		return delete;
	}

	public Accomplishment getAccomplishment() {
		return item;
	}

	public int compareTo(ListItem o) {
		return getAccomplishment().getCompletionDate().compareTo( 
				((AccomplishmentWidget)o).getAccomplishment().getCompletionDate()
		) * -1;
	}
	
}
