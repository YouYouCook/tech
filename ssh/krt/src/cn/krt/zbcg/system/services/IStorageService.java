package cn.krt.zbcg.system.services;

import java.util.List;
import java.util.Map;

import org.ssi.common.PageInfo;
import org.ssi.services.IService;

import cn.krt.zbcg.commons.bo.system.StorageBO;
import cn.krt.zbcg.commons.bo.system.UserBO;
import cn.krt.zbcg.system.dao.StorageDAO;


public  abstract interface IStorageService   extends IService{
	
		public  abstract StorageDAO getStorageDAO(); 

		public abstract void setStorageDAO(StorageDAO storageDAO); 
		  public abstract List findAll(PageInfo paramPageInfo);

		  public abstract List findAll(PageInfo paramPageInfo, Map paramMap);

		  public abstract List queryListByPage(Object paramObject);
		  
		 public abstract List findDaiyanPhao(PageInfo pageInfo);
			
		public abstract String findDaiyansunshuliang();
		
			   public int update(StorageBO record);

		public abstract StorageBO findById(Integer valueOf);

		public abstract void delete(String[] ids);

		public  abstract List findBuhegePumber(PageInfo pageInfo);
		public abstract  String findBuhegeShuliang();

		public abstract void insert(StorageBO storageBo);
}
