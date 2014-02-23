package cn.krt.zbcg.system.services;

import cn.krt.zbcg.commons.bo.system.UserBO;
import cn.krt.zbcg.system.dao.IUserDAO;
import java.util.List;
import java.util.Map;
import org.ssi.common.PageInfo;
import org.ssi.services.IService;

public abstract interface IUserServices extends IService
{
  public abstract IUserDAO getUserDAO();

  public abstract void setUserDAO(IUserDAO paramIUserDAO);

  public abstract void insert(UserBO paramUserBO);

  public abstract int update(UserBO paramUserBO);

  public abstract List findAll(PageInfo paramPageInfo);

  public abstract List findAll(PageInfo paramPageInfo, Map paramMap);

  public abstract List queryListByPage(Object paramObject);

  public abstract UserBO findById(Integer paramInteger);

  public abstract int delete(UserBO paramUserBO);

  public abstract int delete(String[] paramArrayOfString);

  public abstract UserBO getUserByName(String paramString);

  public abstract void updatePassword(UserBO paramUserBO);

  public abstract UserBO getUserByLoginName(String paramString);

  public abstract UserBO getPasswordByCheck(UserBO paramUserBO);

  public abstract void updateUserPassword(UserBO paramUserBO);
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.IUserServices
 * JD-Core Version:    0.6.2
 */