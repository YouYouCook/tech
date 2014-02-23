package cn.krt.zbcg.system.services;

import cn.krt.zbcg.commons.bo.system.CustomerBO;
import cn.krt.zbcg.system.dao.ICustomerDAO;

import java.util.List;
import java.util.Map;

import org.ssi.common.PageInfo;
import org.ssi.services.IService;

public abstract interface ICustomerServices extends IService
{
  public abstract ICustomerDAO getCustomerDAO();

  public abstract void setCustomerDAO(ICustomerDAO paramICustomerDAO);

  public abstract void insert(CustomerBO paramCustomerBO);

  public abstract int update(CustomerBO paramCustomerBO);

  public abstract List findAll(PageInfo paramPageInfo);

  public abstract List findAll(PageInfo paramPageInfo, Map paramMap);

  public abstract List queryListByPage(Object paramObject);

  public abstract CustomerBO findById(Integer paramInteger);

  public abstract int delete(CustomerBO paramCustomerBO);

  public abstract int delete(String[] paramArrayOfString);

  public abstract CustomerBO checkCustomerId(String paramString);

  public abstract void updatePassword(CustomerBO paramCustomerBO);

  public abstract CustomerBO getPasswordByCheck(CustomerBO paramCustomerBO);
  public List getOutofDate(PageInfo paramPageInfo)   throws Exception;
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.ICustomerServices
 * JD-Core Version:    0.6.2
 */