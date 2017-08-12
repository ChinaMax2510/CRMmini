package com.zy.crm.domain;

import java.io.Serializable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * usage 可以有以下几个取值：
CacheConcurrencyStrategy.NONE：不使用缓存，默认；
CacheConcurrencyStrategy.READ_ONLY：只读模式，若对缓存的数据进行修改操作会抛出异常；
CacheConcurrencyStrategy.NONSTRICT_READ_WRITE：不严格的读写模式，不会对缓存的数据加锁；
CacheConcurrencyStrategy.READ_WRITE：读写模式，在更新缓存的时候会把缓存里面的数据换成一个锁，其它事务如果去取相应的缓存数据，发现被锁了，直接就去数据库查询；
CacheConcurrencyStrategy.TRANSACTIONAL：事务模式，支持事务，当事务发生回滚时，缓存中的数据也回滚，只支持 JPA 。
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
//@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PopdeomPrivilege implements Serializable {
	
	/**
	 * 该类对应的表中有三个主键，
	 * 表中的一个或两个主键可重复。但是三个主键不能都重复
	 */
	
	
	private PopdeomPrivilegeID ids;

	public PopdeomPrivilegeID getIds() {
		return ids;
	}

	public void setIds(PopdeomPrivilegeID ids) {
		this.ids = ids;
	}

}
