package ar.com.trimatec.copre.repositories.impl.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class HibernateBaseRepository extends HibernateDaoSupport {

	protected Object findById(Class<?> aClass, Object anOid) {
		return this.getSession().get(aClass, (Integer)anOid);
	}
	
	protected List loadAll(Class<?> aClass) {
		return getHibernateTemplate().loadAll(aClass);
	}
	
}
