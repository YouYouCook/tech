package cn.krt.zbcg.system.services;

import cn.krt.zbcg.commons.bo.system.VipzbBO;
import cn.krt.zbcg.system.dao.IVipzbDAO;
import java.util.List;
import java.util.Map;
import org.ssi.common.PageInfo;
import org.ssi.services.IService;

public abstract interface IVipzbServices extends IService
{
  public abstract IVipzbDAO getZbDAO();

  public abstract void setZbDAO(IVipzbDAO paramIVipzbDAO);

  public abstract void insert(VipzbBO paramVipzbBO);

  public abstract int update(VipzbBO paramVipzbBO);

  public abstract List findAll(PageInfo paramPageInfo);

  public abstract List findAll(PageInfo paramPageInfo, Map paramMap);

  public abstract List queryListByPage(Object paramObject);

  public abstract VipzbBO findById(Integer paramInteger);

  public abstract int delete(VipzbBO paramVipzbBO);

  public abstract int delete(String[] paramArrayOfString);

  public abstract List findZbCustomer(Map paramMap);

  public abstract VipzbBO findByMc(VipzbBO paramVipzbBO);

  public abstract int updateOne(VipzbBO paramVipzbBO);
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.IVipzbServices
 * JD-Core Version:    0.6.2
 */