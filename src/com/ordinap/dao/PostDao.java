package com.ordinap.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ordinap.entity.Post;
import com.ordinap.entity.Unite;
import com.ordinap.entity.User;

 
public interface PostDao {
	
	public void setSessionFactory(SessionFactory sessionFactory);
	public Session getCurrentSession();
	public void add(User user,Unite unite,Post post);
	public Post get(Integer postId);
	public List<Post> getAll();
	public List<Post> getFindByExamTypeId(Integer examTypeId,Integer start,Integer rowCount);
	public List<Post> getFindByUntieId(Integer uniteId,Integer start,Integer rowCount);
	public void delete(Post post);
	public Long count();
	public Long getCountByUser(Long userId);

}
