package intregatedTest;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.User;
import model.representation.PostRepresentation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import persistence.DAO;
import service.PostService;
import utils.EntityManagerFactoryCreator;
import utils.ParamGenerator;
import utils.PostType;

public class PostServiceAddPostTest {
	@Before
	public void setUp() throws Exception{
		User u = new User("2011052407");
		EntityManagerFactory emf = EntityManagerFactoryCreator.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		DAO<User> udao = new DAO<User>(User.class, em);
		
		em.getTransaction().begin();
		udao.create(u);
		em.getTransaction().commit();
	}
	
	@Test
	public void testPostServiceAddPost() throws Exception{
		PostService ps = new PostService();
		ps.addPost("2011052407", ParamGenerator.generatePostParam(PostType.ACTIVITY));
		
		PostRepresentation p = ps.getPostByID(new Long(1));
		
		Assert.assertNotNull(p);
		assertEquals(true, p.isActive());
	}
}
