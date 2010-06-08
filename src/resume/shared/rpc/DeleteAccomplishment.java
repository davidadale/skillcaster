package resume.shared.rpc;

import net.customware.gwt.dispatch.shared.Action;
import resume.shared.data.Accomplishment;

public class DeleteAccomplishment implements Action<VoidResult> {

	private static final long serialVersionUID = -8570995423382653822L;

	Accomplishment item;

	@SuppressWarnings("unused")
	private DeleteAccomplishment(){
		
	}
	
	public DeleteAccomplishment(Accomplishment item) {
		super();
		this.item = item;
	}

	public Accomplishment getItem() {
		return item;
	}

}
