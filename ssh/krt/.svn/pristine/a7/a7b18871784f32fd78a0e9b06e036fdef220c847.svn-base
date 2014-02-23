package cn.krt.zbcg.system.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.ssi.common.PageInfo;
import org.ssi.services.impl.ServiceImpl;

import cn.krt.zbcg.commons.bo.system.ShqdheadBO;
import cn.krt.zbcg.system.dao.ShqdheadDAO;
import cn.krt.zbcg.system.services.IShqdHeadServices;
import cn.krt.zbcg.system.services.IShqdServices;

public class ShqdHeadServiceImpl  extends ServiceImpl  implements IShqdHeadServices{
	
	 private ShqdheadDAO shqdheadDAO;

	public ShqdheadDAO getShqdheadDAO() {
		return shqdheadDAO;
	}

	public void setShqdheadDAO(ShqdheadDAO shqdheadDAO) {
		this.shqdheadDAO = shqdheadDAO;
	}

	@Override
	public List findAll(PageInfo paramPageInfo) {
	    this.pageInfo = paramPageInfo;
	    Map map = new HashMap();
	    List list = findAll(pageInfo, map);
	    return list;
	}

	@Override
	public List findAll(PageInfo paramPageInfo, Map paramMap) {
		   this.pageInfo = paramPageInfo;
		    List list = queryListByPage(paramMap);
		    return list;
	}
	 public List findAlls(PageInfo pageInfo, Map map) {
		    this.pageInfo = pageInfo;
		    List list = queryListByPages(map);
		    return list;
		  }
		
		  public List queryListByPage(Object obj)
		  {
		    Map map = new HashMap();
		
		    List list = null;
		
		    setPublicParams((Map)obj);
		    this.logger.debug("��ѯ��" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "ҳ���");
		
		    list = this.shqdheadDAO.selectAll(obj);
		    this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
		
		    if ((list == null) || (list.size() == 0))
		    {
		      if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
		      {
		        setPublicParams((Map)obj, true);
		        list = this.shqdheadDAO.selectAll(obj);
		        this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
		      }
		    }
		
		    Object o = this.shqdheadDAO.selectAllOfCount(obj);
		    if (o != null)
		    {
		      this.logger.debug("���=" + o.toString());
		      this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
		    }
		    return list;
		  }
		
		
		   public List queryListByPages(Object obj) {
			     Map map = new HashMap();
			 
			     List list = null;
			 
			     setPublicParams((Map)obj);
			     this.logger.debug("��ѯ��" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "ҳ���");
			 
			     list = this.shqdheadDAO.selectAlls(obj);
			     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
			 
			     if ((list == null) || (list.size() == 0))
			     {
			       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
			       {
			         setPublicParams((Map)obj, true);
			         list = this.shqdheadDAO.selectAlls(obj);
			         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
			       }
			     }
			 
			     Object o = this.shqdheadDAO.selectAllOfCounts(obj);
			     if (o != null)
			     {
			       this.logger.debug("���=" + o.toString());
			       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
			     }
			     return list;
			   }

	
	@Override
	public void insert(ShqdheadBO ShqdBO) {
		/*     */     try
		/*     */     {
		/*  54 */       this.shqdheadDAO.insert(ShqdBO);
		/*     */     }
		/*     */     catch (Exception e) {
						e.printStackTrace();
		/*  57 */       ExceptionUtils.getFullStackTrace(e);	e.printStackTrace();	e.printStackTrace();
		/*     */     }
		
	}

	@Override
	public ShqdheadBO findById(Integer paramInteger) {
		return this.shqdheadDAO.selectByPrimaryKey(paramInteger);
	}

	@Override
	public int delete(String[] ids) {
		this.shqdheadDAO.deleteByPrimaryKey(Integer.valueOf(ids[0]));
		return 0;
	}

	@Override
	public int update(ShqdheadBO paramUserBO) {
		  int rows = 0;
		     try {
		       rows = this.shqdheadDAO.updateByPrimaryKey(paramUserBO);
		     }
		     catch (Exception e) {
		       ExceptionUtils.getFullStackTrace(e);	e.printStackTrace();
		     }
		     return rows;
	}
}
