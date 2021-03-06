package persistence;

import javax.persistence.EntityManager;

import model.Account;
import model.Comment;
import model.Community;
import model.Post;
import model.User;
import persistence.components.CollectionReadable;
import persistence.components.Creatable;
import persistence.components.Deletable;
import persistence.components.SingleResultReadable;

public abstract class DAOComponentFactory {
	public static <T> DAOComponentFactory createInstance(EntityManager em, Class<T> t) throws Exception{
		if(t.equals(Post.class)){
			return new PostDAOComponentFactory(em);
		} else if(t.equals(User.class)){
			return new UserDAOComponentFactory(em);
		} else if(t.equals(Comment.class)){
			return new CommentDAOComponentFactory(em);
		} else if(t.equals(Community.class)){
			return new CommunityDAOComponentFactory(em);
		} else if(t.equals(Account.class)){
			return new AccountDAOComponentFactory(em);
		}
		else{
			throw new ClassNotFoundException();
		}
		
	}
	
	public abstract Creatable createCreatable();
	
	public abstract SingleResultReadable createSingleResultReadable();
	
	public abstract CollectionReadable createCollectionReadable();
	
	public abstract Deletable createDeletable();
	
}
