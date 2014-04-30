package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CollectionReadableImp implements CollectionReadable{
	private EntityManager em;
	
	public CollectionReadableImp(EntityManager em){
		this.em = em;
	}
	
	@Override
	public <T> List<T> read(String criteria, int startIndex, int pageSize, Class<T> type) {
		// TODO Auto-generated method stub
		TypedQuery<T> query = em.createNamedQuery("",  type);
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

}
