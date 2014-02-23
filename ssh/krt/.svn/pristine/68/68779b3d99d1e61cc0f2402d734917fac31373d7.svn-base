package cn.krt.zbcg.system.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.ssi.common.PageInfo;
import org.ssi.services.impl.ServiceImpl;

import cn.krt.zbcg.commons.bo.system.StorageBO;
import cn.krt.zbcg.commons.bo.system.UserBO;
import cn.krt.zbcg.system.dao.IUserDAO;
import cn.krt.zbcg.system.dao.StorageDAO;
import cn.krt.zbcg.system.services.IStorageService;

public class StorageServiceImpl  extends ServiceImpl  implements IStorageService{
	 private StorageDAO storageDAO;

	public StorageDAO getStorageDAO() {
		return storageDAO;
	}

	public void setStorageDAO(StorageDAO storageDAO) {
		this.storageDAO = storageDAO;
	}
	
	public List findBuhegePumber(PageInfo pageInfo){
		this.pageInfo = pageInfo;
		List list = this.storageDAO.selectBuhege();
		 this.pageInfo.setTotalSize(list.size());
		 return list;
	}
	public String findBuhegeShuliang(){
		String result =  (String) this.storageDAO.selectBuhegeshuliang();
		return result;
	}
	
	
			public List findDaiyanPhao(PageInfo pageInfo){
				this.pageInfo = pageInfo;
				List list = this.storageDAO.selectDaiyanPhao();
				 this.pageInfo.setTotalSize(list.size());
				 return list;
			}
			public String findDaiyansunshuliang(){
				String result =  (String) this.storageDAO.selectDaiyanshuliang();
				return result;
			}
			
	/*     */   public List findAll(PageInfo pageInfo)
	/*     */   {
	/*  85 */     this.pageInfo = pageInfo;
	/*  86 */     Map map = new HashMap();
	/*  87 */     List list = findAll(pageInfo, map);
	/*  88 */     return list;
	/*     */   }
	/*     */ 
	/*     */   public List findAll(PageInfo pageInfo, Map map)
	/*     */   {
	/*  98 */     this.pageInfo = pageInfo;
	/*  99 */     List list = queryListByPage(map);
	/* 100 */     return list;
	/*     */   }
	/*     */   public List findAlls(PageInfo pageInfo, Map map) {
	/* 103 */     this.pageInfo = pageInfo;
	/* 104 */     List list = queryListByPages(map);
	/* 105 */     return list;
	/*     */   }
	/*     */ 
	/*     */   public List queryListByPage(Object obj)
	/*     */   {
	/* 114 */     this.pageInfo = this.pageInfo;
	/* 115 */     Map map = new HashMap();
	/*     */ 
	/* 117 */     List list = null;
	/*     */ 
	/* 119 */     setPublicParams((Map)obj);
	/* 120 */     this.logger.debug("��ѯ��" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "ҳ���");
	/*     */ 
	/* 122 */     list = this.storageDAO.selectAll(obj);
	/* 123 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
	/*     */ 
	/* 125 */     if ((list == null) || (list.size() == 0))
	/*     */     {
	/* 127 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
	/*     */       {
	/* 129 */         setPublicParams((Map)obj, true);
	/* 130 */         list = this.storageDAO.selectAll(obj);
	/* 131 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
	/*     */       }
	/*     */     }
	/*     */ 
	/* 135 */     Object o = this.storageDAO.selectAllOfCount(obj);
	/* 136 */     if (o != null)
	/*     */     {
	/* 138 */       this.logger.debug("���=" + o.toString());
	/* 139 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
	/*     */     }
	/* 141 */     return list;
	/*     */   }
	
				   public int update(StorageBO record)
				   {
				     int rows = 0;
				     try {
				       rows = this.storageDAO.updateByPrimaryKey(record);
				     }
				     catch (Exception e) {
				    	 e.printStackTrace();
				       ExceptionUtils.getFullStackTrace(e);
				     }
				     return rows;
				   }
	/*     */   public List queryListByPages(Object obj) {
		/* 145 */     this.pageInfo = this.pageInfo;
		/* 146 */     Map map = new HashMap();
		/*     */ 
		/* 148 */     List list = null;
		/*     */ 
		/* 150 */     setPublicParams((Map)obj);
		/* 151 */     this.logger.debug("��ѯ��" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "ҳ���");
		/*     */ 
		/* 153 */     list = this.storageDAO.selectAlls(obj);
		/* 154 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
		/*     */ 
		/* 156 */     if ((list == null) || (list.size() == 0))
		/*     */     {
		/* 158 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
		/*     */       {
		/* 160 */         setPublicParams((Map)obj, true);
		/* 161 */         list = this.storageDAO.selectAlls(obj);
		/* 162 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
		/*     */       }
		/*     */     }
		/*     */ 
		/* 166 */     Object o = this.storageDAO.selectAllOfCounts(obj);
		/* 167 */     if (o != null)
		/*     */     {
		/* 169 */       this.logger.debug("���=" + o.toString());
		/* 170 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
		/*     */     }
		/* 172 */     return list;
		/*     */   }

	@Override
	public StorageBO findById(Integer id) {
		StorageBO key = new StorageBO();
	    key.setId(id);;
	    StorageBO record = (StorageBO)this.storageDAO.queryData(key);
	    return record;
	}

	@Override
	public void delete(String[] ids) {
		 int rows = 0;
		 StorageBO key = new StorageBO();
	     try {
	    	 this.storageDAO.deleteByPrimaryKey(Integer.valueOf(ids[0]));
	     }
	     catch (Exception e){
	    	  e.printStackTrace();
	       ExceptionUtils.getFullStackTrace(e);
	     }
	}

	@Override
	public void insert(StorageBO storageBo) {
		/*     */     try
		/*     */     {
		/*  54 */       this.storageDAO.insert(storageBo);
		/*     */     }
		/*     */     catch (Exception e) {
						  e.printStackTrace();
		/*  57 */       ExceptionUtils.getFullStackTrace(e);
		/*     */     }
		
	}
}
