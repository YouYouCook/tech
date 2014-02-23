package cn.id5.idreal_hr.commons.log.services;

import cn.id5.idreal_hr.commons.bo.log.LogBO;
import cn.id5.idreal_hr.commons.log.dao.ILogDAO;
import java.util.List;
import org.ssi.common.PageInfo;
import org.ssi.services.IService;

public abstract interface ILogServices extends IService
{
  public abstract ILogDAO getLogDAO();

  public abstract void setLogDAO(ILogDAO paramILogDAO);

  public abstract void insert(LogBO paramLogBO);

  public abstract int update(LogBO paramLogBO);

  public abstract List findAll(PageInfo paramPageInfo);

  public abstract List queryListByPage(Object paramObject);

  public abstract LogBO findById(Long paramLong);

  public abstract int delete(LogBO paramLogBO);

  public abstract int delete(String[] paramArrayOfString);
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.id5.idreal_hr.commons.log.services.ILogServices
 * JD-Core Version:    0.6.2
 */