package cn.krt.zbcg.system.dao;

import cn.krt.zbcg.commons.bo.system.MedicineBO;
import java.util.List;
import org.ssi.dao.IBaseDao;

public abstract interface IMedicineDAO extends IBaseDao
{
  public abstract void insert(MedicineBO paramMedicineBO)
    throws Exception;

  public abstract int update(MedicineBO paramMedicineBO)
    throws Exception;

  public abstract List selectAll(Object paramObject);

  public abstract List selectAlls(Object paramObject);

  public abstract Object selectAllOfCount(Object paramObject);

  public abstract Object selectAllOfCounts(Object paramObject);

  public abstract Object queryData(Object paramObject);

  public abstract int delete(MedicineBO paramMedicineBO)
    throws Exception;

  public abstract List all();
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.IMedicineDAO
 * JD-Core Version:    0.6.2
 */