package resume.server.service;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

public class Repository<T> {
	
	Class<T> type;
	
	PersistenceManagerFactory pmFactory = null;
	
	public Repository(Class<T> type){
		this.type = type;
	}
	
	public void setPersistenceManagerFactory(PersistenceManagerFactory pmf){
		this.pmFactory = pmf;
	}
	
	public T loadByUsername(String username){
		
		T result = null;

		List<T> items = queryByUsername( username );
		
		if( items!=null && !items.isEmpty() ){
			result = items.get( 0 );
		}
		
		return result;
	}
	
	public List<T> findAllByUserName(String username){
		return queryByUsername( username );
	}
	
	public T save(T object){
		
		PersistenceManager pm = getPM();
		
		try{
			pm.makePersistent( object );
			//pm.detachCopy( object );
		}finally{
			pm.close();
		}
		
		return object;
	}
	
	public void delete(T object, Long id){
		
		PersistenceManager pm = getPM();
		
		try{
			pm.deletePersistent( 
					pm.getObjectById( object.getClass() , id ) );
			
		}finally{
			pm.close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> queryByUsername(String username){
		
		PersistenceManager pm = getPM();
		
		try{
			Query q = pm.newQuery( type );
			q.setFilter("username == usernameParam");
			q.declareParameters("String usernameParam");
			List<T> items = (List<T>) q.execute( username );
			if( items!=null && !items.isEmpty() ){
				return (List<T>) pm.detachCopyAll(items);	
			}
			
		}finally{
			pm.close();
		}	
		
		return null;
		
	}
	
	protected PersistenceManager getPM(){
		if( this.pmFactory == null ){
			this.pmFactory = PMF.get();
		}
		return this.pmFactory.getPersistenceManager();
	}

}
