package cn.krt.zbcg.system.dao;

import cn.krt.zbcg.commons.bo.system.MedicineZbBO;

import java.util.List;
import java.util.Map;

import org.ssi.dao.IBaseDao;

public abstract interface IMedicineZbDAO extends IBaseDao
{
  public abstract void insert(MedicineZbBO paramMedicineZbBO)
    throws Exception;

  public abstract int update(MedicineZbBO paramMedicineZbBO)
    throws Exception;

  public abstract List selectAll(Object paramObject);

  public abstract Object selectAllOfCount(Object paramObject);

  public abstract Object queryData(Object paramObject);

  public abstract int delete(MedicineZbBO paramMedicineZbBO)
    throws Exception;

  public abstract void insertPrepare(Map paramMap)
    throws Exception;

  public abstract List checkZbMedicine(Map paramMap);

  public abstract List resultForCg(Map paramMap);

  public abstract List resultForSuppliers(Map paramMap);

  public abstract void updateZbState(MedicineZbBO paramMedicineZbBO);

  public abstract void updateZbStateFq(String paramString1, String paramString2);

  public abstract void updateZbAuthState(String paramString1, String paramString2);
  public Object selectCgCount(Object obj);
  public abstract List tqjb(Map paramMap);
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.IMedicineZbDAO
 * JD-Core Version:    0.6.2
 */