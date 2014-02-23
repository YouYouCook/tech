package org.ssi.services;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.ssi.common.PageInfo;
import org.ssi.dao.IBaseDao;

public abstract interface IService
{
  public abstract PageInfo getPageInfo();

  public abstract IBaseDao getBaseDao();

  public abstract void setRequest(HttpServletRequest paramHttpServletRequest);

  public abstract void a_insert(String paramString, Object paramObject)
    throws Exception;

  public abstract int a_update(String paramString, Object paramObject)
    throws Exception;

  public abstract int a_delete(String paramString, Object paramObject)
    throws Exception;

  public abstract Object queryData(String paramString, Object paramObject);

  public abstract List queryListByPage(String paramString, Object paramObject);

  public abstract List queryList(String paramString, Object paramObject);
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.services.IService
 * JD-Core Version:    0.6.2
 */