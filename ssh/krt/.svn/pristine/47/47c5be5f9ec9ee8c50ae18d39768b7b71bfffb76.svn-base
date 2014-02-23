package cn.krt.zbcg.system.dao;

import cn.krt.zbcg.commons.bo.system.UserBO;
import java.util.List;
import org.ssi.dao.IBaseDao;

public abstract interface IUserDAO extends IBaseDao
{
  public abstract void insert(UserBO paramUserBO)
    throws Exception;

  public abstract int update(UserBO paramUserBO)
    throws Exception;

  public abstract List selectAll(Object paramObject);

  public abstract Object selectAllOfCount(Object paramObject);

  public abstract Object queryData(Object paramObject);

  public abstract int delete(UserBO paramUserBO)
    throws Exception;

  public abstract UserBO getUserByName(UserBO paramUserBO);

  public abstract void updatePassword(UserBO paramUserBO);

  public abstract UserBO getUserByLoginName(UserBO paramUserBO);

  public abstract UserBO getPasswordByCheck(UserBO paramUserBO);

  public abstract void updateUserPassword(UserBO paramUserBO);
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.IUserDAO
 * JD-Core Version:    0.6.2
 */