package cn.krt.zbcg.system.services;

import java.util.List;
import java.util.Map;

import org.ssi.common.PageInfo;
import org.ssi.services.IService;

import cn.krt.zbcg.commons.bo.system.FapiaoinfoBO;
import cn.krt.zbcg.system.dao.FapiaoinfoDAO;

public  abstract interface IFaPiaoServices extends IService{
	
	public abstract FapiaoinfoDAO getFapiaoDAO();

	public abstract void setFapiaoDAO(FapiaoinfoDAO fapiaoDao);
	
	public abstract List findAll(PageInfo paramPageInfo);

	public abstract List queryListByPage(Object paramObject);

	public abstract void insert(FapiaoinfoBO shqbo);

	public abstract FapiaoinfoBO findById(Integer paramInteger);

	public abstract int delete(String[] ids);

	public abstract int update(FapiaoinfoBO paramUserBO);

	public abstract List findAll(org.ssi.common.PageInfo pageInfo, Map map);


}
