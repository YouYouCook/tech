package cn.krt.zbcg.system.services;

import cn.krt.zbcg.commons.bo.system.MedicineCgBO;
import cn.krt.zbcg.system.dao.IMedicineCgDAO;
import java.util.List;
import java.util.Map;
import org.ssi.common.PageInfo;
import org.ssi.services.IService;

public abstract interface IMedicineCgServices extends IService
{
  public abstract IMedicineCgDAO getCineCgDAO();

  public abstract void setCineCgDAO(IMedicineCgDAO paramIMedicineCgDAO);

  public abstract void insert(MedicineCgBO paramMedicineCgBO);

  public abstract int update(MedicineCgBO paramMedicineCgBO);

  public abstract List findAll(PageInfo paramPageInfo);

  public abstract List findAll(PageInfo paramPageInfo, Map paramMap);

  public abstract List queryListByPage(Object paramObject);

  public abstract MedicineCgBO findById(Integer paramInteger);

  public abstract int delete(MedicineCgBO paramMedicineCgBO);

  public abstract int delete(String[] paramArrayOfString);

  public abstract void addCG(Map paramMap)
    throws Exception;

  public abstract void updateTops(String[] paramArrayOfString)
    throws Exception;

  public abstract List getTops(Map paramMap)
    throws Exception;

  public abstract void updateCgJB(Map paramMap);
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.IMedicineCgServices
 * JD-Core Version:    0.6.2
 */