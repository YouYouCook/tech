package cn.krt.zbcg.system.services;

import java.util.List;
import java.util.Map;

import org.ssi.common.PageInfo;
import org.ssi.services.IService;

import cn.krt.zbcg.commons.bo.system.FapiaoinfoBO;
import cn.krt.zbcg.commons.bo.system.FukuandetailBO;


public abstract interface IFukuanDetailServices  extends IService{

	int delete(String[] ids);

	FukuandetailBO findById(Integer userId);

	void insert(FukuandetailBO shqbo);

	List findAll(PageInfo pageInfo, Map map);

	int update(FukuandetailBO fukuanbo);

}
