package cn.krt.zbcg.system.services;

import java.util.List;
import java.util.Map;

import org.ssi.common.PageInfo;
import org.ssi.services.IService;

import cn.krt.zbcg.commons.bo.system.ZhaobiaojinduBO;
import cn.krt.zbcg.system.dao.ZhaobiaojinduDAO;

public  abstract interface  IZhaobiaojinduServices  extends IService{

	public abstract List findAll(PageInfo paramPageInfo);

	public abstract List queryListByPage(Object paramObject);

	public abstract void insert(ZhaobiaojinduBO shqbo);

	public abstract ZhaobiaojinduBO findById(Integer paramInteger);

	public abstract int delete(String[] ids);

	public abstract int update(ZhaobiaojinduBO paramUserBO);

	public abstract List findAll(org.ssi.common.PageInfo pageInfo, Map map);
	
	public ZhaobiaojinduBO findByPzsx(String pinzhongshuxing);
	
	public List findNoFininshDD(PageInfo pageInfo);
}
