package resume.client;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import resume.server.service.Repository;
import resume.shared.data.Experience;
import resume.shared.data.Profile;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class PersistenceTests {

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig());

	private PersistenceManagerFactory pmf;

	public PersistenceManagerFactory getPersistenceManagerFactory() {
		if (pmf == null) {
			Properties newProperties = new Properties();
			newProperties
					.put("javax.jdo.PersistenceManagerFactoryClass",
							"org.datanucleus.store.appengine.jdo.DatastoreJDOPersistenceManagerFactory");
			newProperties.put("javax.jdo.option.ConnectionURL", "appengine");
			newProperties.put("javax.jdo.option.NontransactionalRead", "true");
			newProperties.put("javax.jdo.option.NontransactionalWrite", "true");
			newProperties.put("javax.jdo.option.RetainValues", "true");
			newProperties.put("datanucleus.appengine.autoCreateDatastoreTxns",
					"true");
			newProperties.put("datanucleus.appengine.autoCreateDatastoreTxns",
					"true");
			pmf = JDOHelper.getPersistenceManagerFactory(newProperties);
		}
		return pmf;
	}

	@Before
	public void setUp() {
		helper.setUp();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSaveProfile() {
		
		pmf = getPersistenceManagerFactory();
		
		Profile profile = new Profile("davidadale@gmail.com","David Dale","Developer","Centric");
		getPersistenceManagerFactory().getPersistenceManager().makePersistent( profile );
		
		Query query = pmf.getPersistenceManager().newQuery(Profile.class);
		query.setFilter("username == 'davidadale@gmail.com'" );
		
		List<Profile> profiles = (List<Profile>) query.execute();
		
		assertEquals( 1, profiles.size() );
		
	}

	@Test
	public void testSaveExperience(){
		Experience x = new Experience("davidadale@gmail.com");
		
		Repository<Experience> repo = new Repository<Experience>(Experience.class);
		repo.setPersistenceManagerFactory( getPersistenceManagerFactory() );
		repo.save( x );
		
		assertNotNull( repo.loadByUsername("davidadale@gmail.com") );
		
	}
	
	@Test
	public void testListExperience(){
		
		Experience x1 = new Experience("davidadale@gmail.com");
		Experience x2 = new Experience("davidadale@gmail.com");
		Experience x3 = new Experience("davidadale@gmail.com");
		Experience x4 = new Experience("davidadale@gmail.com");
		Experience x5 = new Experience("davidadale@gmail.com");
		
		Repository<Experience> repo = new Repository<Experience>(Experience.class);
		
		repo.setPersistenceManagerFactory( getPersistenceManagerFactory() );
		
		repo.save( x1 );
		repo.save( x2 );
		repo.save( x3 );
		repo.save( x4 );
		repo.save( x5 );

		List<Experience> xs = repo.findAllByUserName("davidadale@gmail.com");
		
		assertNotNull( xs );
		
		assertTrue(xs.size()==5);
	}

}
