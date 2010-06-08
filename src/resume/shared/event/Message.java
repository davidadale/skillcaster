package resume.shared.event;

import com.google.gwt.event.shared.GwtEvent;

public class Message extends GwtEvent<MessageHandler> {

	public enum Level{
		ERROR,
		INFO
	}
	
	public static Type<MessageHandler> TYPE = 
		new Type<MessageHandler>();	
	
	String message;
	
	Level level;
	
	public Message(String message){
		this.message = message;
		level = Level.INFO;
	}
	
	
	public Message(String msg, Level level){
		this.message = msg;
		this.level = level;
	}
	
	@Override
	protected void dispatch(MessageHandler handler) {
		handler.handle( this );
	}

	@Override
	public GwtEvent.Type<MessageHandler> getAssociatedType() {
		return TYPE;
	}


	public String getMessage() {
		return message;
	}


	public Level getLevel() {
		return level;
	}
	
	public static Message info(String msg){
		return new Message( msg, Level.INFO );
	}
	
	public static Message error(String msg){
		return new Message( msg, Level.ERROR );
	}
	
	

}
