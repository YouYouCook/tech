package cn.krt.zbcg.system.dao;

import cn.krt.zbcg.commons.bo.system.MedicineJbBO;
import java.util.List;
import java.util.Map;
import org.ssi.dao.IBaseDao;

public abstract interface IMedicineJbDAO extends IBaseDao
{
  public abstract void insert(MedicineJbBO paramMedicineJbBO)
    throws Exception;

  public abstract int update(MedicineJbBO paramMedicineJbBO)
    throws Exception;

  public abstract List selectAll(Object paramObject);

  public abstract Object selectAllOfCount(Object paramObject);

  public abstract Object queryData(Object paramObject);

  public abstract int delete(MedicineJbBO paramMedicineJbBO)
    throws Exception;

  public abstract void insertPrepare(String paramString)
    throws Exception;

  public abstract void updateJb(Map paramMap)
    throws Exception;

  public abstract void updateTopsDown(Map paramMap)
    throws Exception;

  public abstract void updateTopsUp(Map paramMap)
    throws Exception;

  public abstract void updateMedicineCode(Map paramMap)
    throws Exception;

  public abstract List isTops(Map paramMap);

  public abstract List getTops(Map paramMap);

  public abstract List tqjb(Map paramMap);

  public abstract void updateJbJB(Map paramMap)
    throws Exception;

  public abstract MedicineJbBO judeJB(MedicineJbBO paramMedicineJbBO);

  public abstract List resetGetTops(Map paramMap)
    throws Exception;

  public abstract List startTender()
    throws Exception;

  public abstract List endTender()
    throws Exception;
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.IMedicineJbDAO
 * JD-Core Version:    0.6.2
 */