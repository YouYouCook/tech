package cn.krt.zbcg.system.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.ssi.common.PageInfo;
import org.ssi.services.impl.ServiceImpl;
import cn.krt.zbcg.commons.bo.system.FapiaoinfoBO;
import cn.krt.zbcg.system.dao.FapiaoinfoDAO;
import cn.krt.zbcg.system.services.IFaPiaoServices;
public class FaPiaoServicesImpl   extends ServiceImpl  implements IFaPiaoServices{
	 private FapiaoinfoDAO fapiaoDAO;


	
	
	public FapiaoinfoDAO getFapiaoDAO() {
		return fapiaoDAO;
	}

	public void setFapiaoDAO(FapiaoinfoDAO fapiaoDAO) {
		this.fapiaoDAO = fapiaoDAO;
	}

	public List findAll(PageInfo pageInfo)
	   {
	     this.pageInfo = pageInfo;
	     Map map = new HashMap();
	     List list = findAll(pageInfo, map);
	     return list;
	   }
	 
	   public List findAll(PageInfo pageInfo, Map map)
	   {
	     this.pageInfo = pageInfo;
	     List list = queryListByPage(map);
	     return list;
	   }
	   public List findAlls(PageInfo pageInfo, Map map) {
	     this.pageInfo = pageInfo;
	     List list = queryListByPages(map);
	     return list;
	   }
	 
	   public List queryListByPage(Object obj)
	   {
	     this.pageInfo = this.pageInfo;
	     Map map = new HashMap();
	 
	     List list = null;
	 
	     setPublicParams((Map)obj);
	     this.logger.debug("��ѯ��" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "ҳ���");
	 
	     list = this.fapiaoDAO.selectAll(obj);
	     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
	 
	     if ((list == null) || (list.size() == 0))
	     {
	       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
	       {
	         setPublicParams((Map)obj, true);
	         list = this.fapiaoDAO.selectAll(obj);
	         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
	       }
	     }
	 
	     List o = (List) this.fapiaoDAO.selectAllOfCount(obj);
	     if (o != null)
	     {
	       this.logger.debug("���=" + o.toString());
	       this.pageInfo.setTotalSize(o.size());
	     }
	     return list;
	   }
		
		
		   public List queryListByPages(Object obj) {
	     this.pageInfo = this.pageInfo;
	     Map map = new HashMap();
	 
	     List list = null;
	 
	     setPublicParams((Map)obj);
	     this.logger.debug("��ѯ��" + (this.pageInfo != null ? this.pageInfo.getPageNum() : 0) + "ҳ���");
	 
	     list = this.fapiaoDAO.selectAlls(obj);
	     this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
	 
	     if ((list == null) || (list.size() == 0))
	     {
	       if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0))
	       {
	         setPublicParams((Map)obj, true);
	         list = this.fapiaoDAO.selectAlls(obj);
	         this.logger.debug("list.size(befor reset)=" + (list != null ? Integer.valueOf(list.size()) : ""));
	       }
	     }
	 
	     Object o = this.fapiaoDAO.selectAllOfCounts(obj);
	     if (o != null)
	     {
	       this.logger.debug("���=" + o.toString());
	       this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
	     }
	     return list;
	   }


	@Override
	public void insert(FapiaoinfoBO shqbo) {
		try {
			this.fapiaoDAO.insert(shqbo);
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionUtils.getFullStackTrace(e);
			e.printStackTrace();
			e.printStackTrace();
		}

	}

	@Override
	public FapiaoinfoBO findById(Integer userId) {
		FapiaoinfoBO key = new FapiaoinfoBO();
		key.setId(userId);
		FapiaoinfoBO record = (FapiaoinfoBO) this.fapiaoDAO.queryData(key);
		return record;
	}

	public int update(FapiaoinfoBO record) {
		int rows = 0;
		try {
			rows = this.fapiaoDAO.update(record);
		} catch (Exception e) {
			ExceptionUtils.getFullStackTrace(e);
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public int delete(String[] ids) {
		this.fapiaoDAO.deleteByPrimaryKey(Integer.valueOf(ids[0]));
		return 0;
	}





}
