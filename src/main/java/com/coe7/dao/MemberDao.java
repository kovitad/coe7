package com.coe7.dao;


import javax.persistence.Query;

import org.springframework.stereotype.Repository;




import com.coe7.domain.Member;

@Repository
public class MemberDao extends AbstractDAO<Member> {
	
	@Override
	public Member save(Member object) {
		Member result = this.getEM().merge(object);
		//this.getEM().flush();
		return result;
	}
	
	public Member find(final String userName) {
		Query query = getEM().createQuery("from com.coe7.domain.Member m where m.username = :member");
		query.setParameter("member", userName);
		return (Member)query.getSingleResult();
	}

}
