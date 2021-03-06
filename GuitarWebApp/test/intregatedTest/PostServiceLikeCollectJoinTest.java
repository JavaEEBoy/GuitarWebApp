package intregatedTest;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Post;
import model.User;
import model.representation.PostRepresentation;

import org.junit.Before;
import org.junit.Test;

import persistence.DAO;
import service.PostService;
import service.factory.PostFactory;
import utils.EntityManagerFactoryCreator;
import utils.ParamGenerator;
import utils.PostType;

public class PostServiceLikeCollectJoinTest {
	
	@Before
	public void setUp() throws Exception{
		EntityManagerFactory emf = EntityManagerFactoryCreator.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		DAO<User> udao = new DAO<User>(User.class, em);
		
		User u1 = new User("2011052407");
		User u2 = new User("2011052406");
		User u3 = new User("2011052405");
		
		em.getTransaction().begin();
		udao.create(u1);
		udao.create(u2);
		udao.create(u3);
		Post p = new PostFactory().create(ParamGenerator.generatePostParam(PostType.ACTIVITY));
		u1.addPost(p);
		udao.update(u1);
		em.getTransaction().commit();
	}
	
	@Test
	public void testLikeCollectJoin() throws Exception{
		PostService ps = new PostService();
		ps.likePost("2011052406", new Long(1));
		ps.likePost("2011052405", new Long(1));
		ps.collectPost("2011052406", new Long(1));
		ps.joinActivity("2011052406", new Long(1));
		
		PostRepresentation p = ps.getPostByID(new Long(1));
		assertEquals(2, p.getLikerRepresentations().size());
		assertEquals(1, p.getParticipantRepresentations().size());
		assertEquals("2011052406", p.getParticipantRepresentations().iterator().next().getID());
	}
}
