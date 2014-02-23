package cn.krt.zbcg.system.dao;

import cn.krt.zbcg.commons.bo.system.CustomerBO;
import java.util.List;
import org.ssi.dao.IBaseDao;

public abstract interface ICustomerDAO extends IBaseDao
{
  public abstract void insert(CustomerBO paramCustomerBO)
    throws Exception;

  public abstract int update(CustomerBO paramCustomerBO)
    throws Exception;

  public abstract List selectAll(Object paramObject);

  public abstract Object selectAllOfCount(Object paramObject);

  public abstract Object queryData(Object paramObject);

  public abstract int delete(CustomerBO paramCustomerBO)
    throws Exception;

  public abstract CustomerBO checkCustomerId(CustomerBO paramCustomerBO);

  public abstract void updatePassword(CustomerBO paramCustomerBO);

  public abstract CustomerBO getPasswordByCheck(CustomerBO paramCustomerBO);
  public abstract List selectAllCustomer()
		    throws Exception;
  public abstract List selectOutofDate()
    throws Exception;
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.ICustomerDAO
 * JD-Core Version:    0.6.2
 */