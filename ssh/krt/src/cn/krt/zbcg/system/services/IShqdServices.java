package cn.krt.zbcg.system.services;

import org.ssi.services.IService;

import java.util.List;
import java.util.Map;
import org.ssi.common.PageInfo;
import cn.krt.zbcg.commons.bo.system.ShqdBO;
import cn.krt.zbcg.system.dao.ShqdDAO;

public abstract interface IShqdServices extends IService {

	public abstract ShqdDAO getShqdDAO();

	public abstract void setShqdDAO(ShqdDAO storageDAO);

	public abstract List findAll(PageInfo paramPageInfo);

	public abstract List findAll(PageInfo paramPageInfo, Map paramMap);

	public abstract List queryListByPage(Object paramObject);

	public abstract void insert(ShqdBO ShqdBO);
	
	public abstract ShqdBO findById(Integer paramInteger);
	 	public int delete(String[] ids);
	public abstract int update(ShqdBO paramUserBO);
}


