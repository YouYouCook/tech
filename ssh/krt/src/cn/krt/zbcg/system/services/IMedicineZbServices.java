package cn.krt.zbcg.system.services;

import cn.krt.zbcg.commons.bo.system.MedicineZbBO;
import cn.krt.zbcg.system.dao.IMedicineZbDAO;
import java.util.List;
import java.util.Map;
import org.ssi.common.PageInfo;
import org.ssi.services.IService;

public abstract interface IMedicineZbServices extends IService
{
  public abstract IMedicineZbDAO getCineZbDAO();

  public abstract void setCineZbDAO(IMedicineZbDAO paramIMedicineZbDAO);

  public abstract void insert(MedicineZbBO paramMedicineZbBO);

  public abstract int update(MedicineZbBO paramMedicineZbBO);

  public abstract List findAll(PageInfo paramPageInfo)
    throws Exception;

  public abstract List findAll(PageInfo paramPageInfo, Map paramMap)
    throws Exception;

  public abstract List queryListByPage(Object paramObject);

  public abstract MedicineZbBO findById(Integer paramInteger);

  public abstract int delete(MedicineZbBO paramMedicineZbBO);

  public abstract int delete(String[] paramArrayOfString);

  public abstract List checkZbMedicine(Map paramMap);

  public abstract List resultForCg(Map paramMap, PageInfo pageInfo);

  public abstract List resultForSuppliers(Map paramMap);

  public abstract void updateZbState(MedicineZbBO paramMedicineZbBO);

  public abstract void updateZbStateFq(String paramString1, String paramString2);

  public abstract void updateZbAuthState(String paramString1, String paramString2);

  public abstract List tqjb(Map paramMap);
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.IMedicineZbServices
 * JD-Core Version:    0.6.2
 */