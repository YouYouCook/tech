package cn.krt.zbcg.system.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.ssi.common.PageInfo;
import org.ssi.services.impl.ServiceImpl;

import cn.krt.zbcg.commons.bo.system.ShqdBO;
import cn.krt.zbcg.commons.bo.system.UserBO;
import cn.krt.zbcg.system.dao.ShqdDAO;
import cn.krt.zbcg.system.services.IShqdServices;


public class ShqdServiceImpl  extends ServiceImpl  implements IShqdServices{

	 private ShqdDAO shqdDAO;

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
		/* 122 */     list = this.shqdDAO.selectAll(obj);
		/* 123 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
		/*     */ 
		/* 125 */     if ((list == null) || (list.size() == 0))
		/*     */     {
		/* 127 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
		/*     */       {
		/* 129 */         setPublicParams((Map)obj, true);
		/* 130 */         list = this.shqdDAO.selectAll(obj);
		/* 131 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
		/*     */       }
		/*     */     }
		/*     */ 
		/* 135 */     Object o = this.shqdDAO.selectAllOfCount(obj);
		/* 136 */     if (o != null)
		/*     */     {
		/* 138 */       this.logger.debug("���=" + o.toString());
		/* 139 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
		/*     */     }
		/* 141 */     return list;
		/*     */   }
		
		
		/*     */   public List queryListByPages(Object obj) {
			/* 145 */     this.pageInfo = this.pageInfo;
			/* 146 */     Map map = new HashMap();
			/*     */ 
			/* 148 */     List list = null;
			/*     */ 
			/* 150 */     setPublicParams((Map)obj);
			/* 151 */     this.logger.debug("��ѯ��" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "ҳ���");
			/*     */ 
			/* 153 */     list = this.shqdDAO.selectAlls(obj);
			/* 154 */     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
			/*     */ 
			/* 156 */     if ((list == null) || (list.size() == 0))
			/*     */     {
			/* 158 */       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
			/*     */       {
			/* 160 */         setPublicParams((Map)obj, true);
			/* 161 */         list = this.shqdDAO.selectAlls(obj);
			/* 162 */         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
			/*     */       }
			/*     */     }
			/*     */ 
			/* 166 */     Object o = this.shqdDAO.selectAllOfCounts(obj);
			/* 167 */     if (o != null)
			/*     */     {
			/* 169 */       this.logger.debug("���=" + o.toString());
			/* 170 */       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
			/*     */     }
			/* 172 */     return list;
			/*     */   }

	@Override
	public ShqdDAO getShqdDAO() {
		return shqdDAO;
	}

	@Override
	public void setShqdDAO(ShqdDAO storageDAO) {
		this.shqdDAO = storageDAO;
		
	}
	@Override
	public void insert(ShqdBO ShqdBO) {
		/*     */     try
		/*     */     {
		/*  54 */       this.shqdDAO.insert(ShqdBO);
		/*     */     }
		/*     */     catch (Exception e) {
						e.printStackTrace();
		/*  57 */       ExceptionUtils.getFullStackTrace(e);	e.printStackTrace();	e.printStackTrace();
		/*     */     }
		
	}
	@Override
	public ShqdBO findById(Integer userId) {
			 ShqdBO key = new ShqdBO();
		     key.setId(userId);
		     ShqdBO record = (ShqdBO)this.shqdDAO.queryData(key);;
		     return record;
	}

	   public int update(ShqdBO record)
	   {
	     int rows = 0;
	     try {
	       rows = this.shqdDAO.updateByPrimaryKey(record);
	     }
	     catch (Exception e) {
	       ExceptionUtils.getFullStackTrace(e);	e.printStackTrace();
	     }
	     return rows;
	   }
	@Override
	public int delete(String[] ids) {
		
		this.shqdDAO.deleteByPrimaryKey(Integer.valueOf(ids[0]));
		return 0;
	}

}
