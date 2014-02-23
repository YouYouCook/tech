package cn.krt.zbcg.system.services;

import cn.krt.zbcg.commons.bo.system.CustomerVipBO;
import cn.krt.zbcg.system.dao.ICustomerVipDAO;
import java.util.List;
import java.util.Map;
import org.ssi.common.PageInfo;
import org.ssi.services.IService;

public abstract interface ICustomerVipServices extends IService
{
  public abstract ICustomerVipDAO getCustomerVipDAO();

  public abstract void setCustomerVipDAO(ICustomerVipDAO paramICustomerVipDAO);

  public abstract void insert(CustomerVipBO paramCustomerVipBO);

  public abstract int update(CustomerVipBO paramCustomerVipBO);

  public abstract List findAll(PageInfo paramPageInfo);

  public abstract List findAll(PageInfo paramPageInfo, Map paramMap);

  public abstract List queryListByPage(Object paramObject);

  public abstract CustomerVipBO findById(Integer paramInteger);

  public abstract int delete(CustomerVipBO paramCustomerVipBO);

  public abstract int delete(String[] paramArrayOfString);

  public abstract List findVipCustomer(Map paramMap);

  public abstract CustomerVipBO checkResult(CustomerVipBO paramCustomerVipBO);

  public abstract List findVipCustomerOne(int paramInt1, int paramInt2);
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.ICustomerVipServices
 * JD-Core Version:    0.6.2
 */