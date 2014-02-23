package org.ssi.dao;

import java.util.List;

public abstract interface IBaseDao
{
  public abstract void insert(String paramString, Object paramObject)
    throws Exception;

  public abstract int update(String paramString, Object paramObject)
    throws Exception;

  public abstract int delete(String paramString, Object paramObject)
    throws Exception;

  public abstract Integer getSequence(String paramString);

  public abstract Object queryData(String paramString, Object paramObject);

  public abstract List queryList(String paramString, Object paramObject);

  public abstract List queryList(String paramString);
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     org.ssi.dao.IBaseDao
 * JD-Core Version:    0.6.2
 */