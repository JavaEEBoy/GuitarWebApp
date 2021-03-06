package intregatedTest;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Post;
import model.User;

import org.junit.Before;
import org.junit.Test;

import persistence.DAO;
import service.factory.Factory;
import service.factory.PostFactory;
import service.transactions.SSETransactions.AddPostSSETransaction;
import utils.EntityManagerFactoryCreator;
import utils.ParamGenerator;
import utils.PostType;

public class AddPostSSETransactionTest {
	@Before
	public void setUp() throws Exception{
User user = new User("2011052407");
		
		EntityManagerFactory emf = EntityManagerFactoryCreator.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		DAO<User> udao = new DAO<User>(User.class, em);
		Factory f = new PostFactory();
		
		em.getTransaction().begin();
		udao.create(user);
		Post p1 = (Post) f.create(ParamGenerator.generatePostParam(PostType.DISCUSSION));
		Post p2 = (Post) f.create(ParamGenerator.generatePostParam(PostType.DISCUSSION));
		Post p3 = (Post) f.create(ParamGenerator.generatePostParam(PostType.DISCUSSION));
		Thread.sleep(1000);
		Post p4 = (Post) f.create(ParamGenerator.generatePostParam(PostType.DISCUSSION));
		user.addPost(p1);
		user.addPost(p2);
		user.addPost(p3);
		user.addPost(p4);
		udao.update(user);
		em.getTransaction().commit();
	}
	
	@Test
	public void testAddPostSSE() throws Exception{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userID", "2011052407");
		AddPostSSETransaction transaction = new AddPostSSETransaction();
		transaction.initEvent(params);
	}
}
