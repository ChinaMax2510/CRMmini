package com.zy.crm.domain;

import java.io.Serializable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * usage ���������¼���ȡֵ��
CacheConcurrencyStrategy.NONE����ʹ�û��棬Ĭ�ϣ�
CacheConcurrencyStrategy.READ_ONLY��ֻ��ģʽ�����Ի�������ݽ����޸Ĳ������׳��쳣��
CacheConcurrencyStrategy.NONSTRICT_READ_WRITE�����ϸ�Ķ�дģʽ������Ի�������ݼ�����
CacheConcurrencyStrategy.READ_WRITE����дģʽ���ڸ��»����ʱ���ѻ�����������ݻ���һ�����������������ȥȡ��Ӧ�Ļ������ݣ����ֱ����ˣ�ֱ�Ӿ�ȥ���ݿ��ѯ��
CacheConcurrencyStrategy.TRANSACTIONAL������ģʽ��֧�����񣬵��������ع�ʱ�������е�����Ҳ�ع���ֻ֧�� JPA ��
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
//@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PopdeomPrivilege implements Serializable {
	
	/**
	 * �����Ӧ�ı���������������
	 * ���е�һ���������������ظ������������������ܶ��ظ�
	 */
	
	
	private PopdeomPrivilegeID ids;

	public PopdeomPrivilegeID getIds() {
		return ids;
	}

	public void setIds(PopdeomPrivilegeID ids) {
		this.ids = ids;
	}

}
