package cn.krt.zbcg.system.dao;

import cn.krt.zbcg.commons.bo.system.MedicineCgBO;
import java.util.List;
import java.util.Map;
import org.ssi.dao.IBaseDao;

public abstract interface IMedicineCgDAO extends IBaseDao
{
  public abstract void insert(MedicineCgBO paramMedicineCgBO)
    throws Exception;

  public abstract int update(MedicineCgBO paramMedicineCgBO)
    throws Exception;

  public abstract List selectAll(Object paramObject);

  public abstract Object selectAllOfCount(Object paramObject);

  public abstract Object queryData(Object paramObject);

  public abstract int delete(MedicineCgBO paramMedicineCgBO)
    throws Exception;

  public abstract void addCG(Map paramMap)
    throws Exception;

  public abstract List selectByCgDate(String paramString);

  public abstract void updateCgJB(Map paramMap);

  public abstract List selectAllList();
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.IMedicineCgDAO
 * JD-Core Version:    0.6.2
 */