package com.comtroller.dao;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.comtroller.entity.Product;
import com.controller.CustEcxeptions.ProductNotfoundEcxeption;
import com.controller.hibernateconfig.HibernateConfi;

public class ProductDao {
	SessionFactory sessionfactory;
public ProductDao(){
	sessionfactory=HibernateConfi.congif();
}

public String saveProduct(Product product) {//....................................................
	Session session=sessionfactory.openSession();
	boolean added=false;
	try {
		
		Transaction transaction=session.beginTransaction();
		Product dbproduct=session.get(Product.class, product.getProductId());
		if(dbproduct==null) {
			session.save(product);
			transaction.commit();
			added=true;		
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}finally {
		if(session!=null) {
			session.close();
		}		
	}
	if(added) {
		return "Save!!...";
	}else {
		return "not Save or duplicate product id entered";
	}
}
public String deleteProduct(int id) {//...........................................................
	Session session=null;
	boolean deleted=false;
	try {
		session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Product product=session.get(Product.class,id);// get product whose id is present
		if(product!=null) {
		session.delete(product);// then delete it
		transaction.commit();
		deleted=true;
		}
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	if(deleted)	{
		return "delete!....";
	}else {
		return "not delete!....";
	}
	
}
public Product getproductByid(int id) {//.........................................................
	Session session=null;
	Product product=null;
	try {
		session=sessionfactory.openSession();
		product=session.get(Product.class, id);
		
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		if (session!=null) {
			session.close();
		}
	}
	return product;
	
}



public String updateProduct(Product product) {
	Session session=null;
	boolean updated=false;
	try {
		session=sessionfactory.openSession();
		
		Product dbproduct=session.get(Product.class, product.getProductId());
		Transaction transaction=session.beginTransaction();
		if(dbproduct!=null) {
			
			session.evict(dbproduct);
			session.update(product);
			transaction.commit();
			updated=true;
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		if (session!=null) {
			session.close();
		}
	}
	if(updated) {
		return "update succrsful....";
	}else {
		return "data is not present to update";
	}
}

@SuppressWarnings("unchecked")
public List<Product> getAllProduct() {
	Session session=null;
	List<Product> list=null;
	try {
		session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		list=criteria.list();
	//session.close();	
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	return list;
}

public List<Product> getLimitedProduct(int limit) {
	Session session=null;
	List<Product> list=null;
	try {
		session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		criteria.setFirstResult(5);
		criteria.setMaxResults(limit);
		list=criteria.list();
		
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	return list;
}

public List<Product> getproductByName(String fetchByName) {
	Session session=null;
	List<Product> list=null;
	try {
		session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		criteria.add(Restrictions.ilike("productName", fetchByName)); //output is pen 
//		criteria.add(Restrictions.eq("productName", fetchByName));      //output is pen 
		
		list=criteria.list();
		
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	return list;
	
	
}

public List<Product> orderList() {
	Session session=null;
	List<Product> list=null;
	try {
		session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
			criteria.addOrder(Order.asc("productPrice"));
		list=criteria.list();
		
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	return list;
}

public List<Product> greaterThan() {
	Session session=null;
	List<Product> list=null;
	try {
		session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		criteria.add(Restrictions.ge("productPrice", 500d));
		list=criteria.list();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	
	return list;
}

public List<Product> alleqmethod() {
	Session session=null;
	List<Product> list=null;
	try {
		Map<String, Object> map=new HashMap<>();
		map.put("productName", "watch");
		map.put("productPrice", 1000d);
		
		
		session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		criteria.add(Restrictions.allEq(map));//internally and is used in query
	
		list=criteria.list();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	

	return list;
}

public List<Product> andOr() {
	Session session=null;
	List<Product> list=null;
	try {
		
		
		
		session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		Criterion cr1= Restrictions.eq("productName", "pen");
		Criterion cr2= Restrictions.eq("productName", "pencil");

		criteria.add(Restrictions.or(cr1,cr2));//internally or is used in query
	
		list=criteria.list();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	return list;
}

public double sumPrice() {
	double sum=0d;
	Session session=null;
	try {
		session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		criteria.setProjection(Projections.sum("productPrice"));
		
		List list=criteria.list();
		sum= (double) list.get(0);
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	return sum;
}

public List<Product> maxProduct() {
	Session session=null;
	double maxprice=0d;
	List<Product> list=null;
	try {
		session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		criteria.setProjection(Projections.max("productPrice"));
		maxprice=(double) criteria.uniqueResult();//here we get max price
	 
		System.out.println(maxprice);
		Criteria criteria1=session.createCriteria(Product.class);
		criteria1.add(Restrictions.eq("productPrice",maxprice));
		list=criteria1.list();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	return list;
}

public long countProduct() {
	long count=0l;
	Session session=null;
	try {
		session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		criteria.setProjection(Projections.rowCount());
		
		count=(long) criteria.uniqueResult();
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(session!=null) {
			session.close();
		}
	}
	return count;
}

}
