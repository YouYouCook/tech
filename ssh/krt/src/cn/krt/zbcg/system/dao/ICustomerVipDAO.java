package cn.krt.zbcg.system.dao;

import cn.krt.zbcg.commons.bo.system.CustomerVipBO;
import java.util.List;
import java.util.Map;
import org.ssi.dao.IBaseDao;

public abstract interface ICustomerVipDAO extends IBaseDao
{
  public abstract void insert(CustomerVipBO paramCustomerVipBO)
    throws Exception;

  public abstract int update(CustomerVipBO paramCustomerVipBO)
    throws Exception;

  public abstract List selectAll(Object paramObject);

  public abstract Object selectAllOfCount(Object paramObject);

  public abstract Object queryData(Object paramObject);

  public abstract int delete(CustomerVipBO paramCustomerVipBO)
    throws Exception;

  public abstract List findVipCustomer(Map paramMap);

  public abstract CustomerVipBO checkResult(CustomerVipBO paramCustomerVipBO);

  public abstract List findVipCustomerOne(CustomerVipBO paramCustomerVipBO);
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.ICustomerVipDAO
 * JD-Core Version:    0.6.2
 */