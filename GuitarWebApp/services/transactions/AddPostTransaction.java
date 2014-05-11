package transactions;

import java.util.Map;

import javax.persistence.EntityManager;

import model.Post;
import model.User;
import persistence.DAO;
import factory.Factory;
import factory.PostFactory;
import factory.PostRep;

public class AddPostTransaction extends DAOTransaction{

	@Override
	protected Object process(EntityManager em, Map<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		String userID = (String) params.get("userID");
		PostRep postRep = (PostRep) params.get("postRep");
		
		DAO<User> udao = new DAO<User>(User.class, em);
		User u = udao.singleResultRead(userID, User.class);
		Factory f = new PostFactory();
		Post p = (Post) f.create(postRep);
		u.addPost(p);
		udao.update(u);
		return null;
	}

}
