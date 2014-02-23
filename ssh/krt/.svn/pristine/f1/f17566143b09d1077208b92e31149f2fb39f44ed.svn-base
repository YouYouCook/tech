package cn.krt.zbcg.system.services;

import java.util.List;
import java.util.Map;

import org.ssi.common.PageInfo;
import org.ssi.services.IService;

import cn.krt.zbcg.commons.bo.system.ShqdheadBO;
import cn.krt.zbcg.system.dao.ShqdheadDAO;


public  abstract interface  IShqdHeadServices  extends IService  {
	public ShqdheadDAO getShqdheadDAO();

	public void setShqdheadDAO(ShqdheadDAO shqdheadDAO);

	public abstract List findAll(PageInfo paramPageInfo);

	public abstract List findAll(PageInfo paramPageInfo, Map paramMap);

	public abstract List queryListByPage(Object paramObject);

	public abstract void insert(ShqdheadBO ShqdBO);
	
	public abstract ShqdheadBO findById(Integer paramInteger);
	 	public int delete(String[] ids);
	public abstract int update(ShqdheadBO paramUserBO);
}
