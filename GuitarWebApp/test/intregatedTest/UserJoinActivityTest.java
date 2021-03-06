package intregatedTest;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Post;
import model.User;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.DAO;
import service.factory.PostFactory;
import utils.EntityManagerFactoryCreator;
import utils.ParamGenerator;
import utils.PostType;

public class UserJoinActivityTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private DAO<User> udao;
	private DAO<Post> pdao;
	
	@BeforeClass
	public static void classSetUp(){
		emf = EntityManagerFactoryCreator.getInstance().getEntityManagerFactory();
		em = emf.createEntityManager();
	}
	
	@Before
	public void setUp() throws Exception{
		udao = new DAO<User>(User.class, em);
		pdao = new DAO<Post>(Post.class, em);
		
		User u1 = new User("2011052407");
		User u2 = new User("2011052406");
		
		em.getTransaction().begin();
		udao.create(u1);
		udao.create(u2);
		em.getTransaction().commit();
		
		Post p1 = new PostFactory().create(ParamGenerator.generatePostParam(PostType.ACTIVITY));
		em.getTransaction().begin();
		u1 = udao.singleResultRead("2011052407", User.class);
		u1.addPost(p1);
		udao.update(u1);
		em.getTransaction().commit();
	}
	
	@Test
	public void testUserLikePost() throws Exception{
		User u2;	
		
		em.getTransaction().begin();
		u2 = udao.singleResultRead("2011052406", User.class);
		Post p = pdao.singleResultRead(new Long(1), Post.class);
		u2.joinActivity(p);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		p =pdao.singleResultRead(new Long(1), Post.class);
		Set<User> parts = p.getParticipants();
		em.getTransaction().commit();
		
		assertEquals(1, parts.size());
	}
}
