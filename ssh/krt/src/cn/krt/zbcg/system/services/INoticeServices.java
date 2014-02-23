package cn.krt.zbcg.system.services;

import cn.krt.zbcg.commons.bo.system.NoticeBO;
import cn.krt.zbcg.system.dao.INoticeDAO;
import java.util.List;
import java.util.Map;
import org.ssi.common.PageInfo;
import org.ssi.services.IService;

public abstract interface INoticeServices extends IService
{
  public abstract INoticeDAO getCeDAO();

  public abstract void setCeDAO(INoticeDAO paramINoticeDAO);

  public abstract void insert(NoticeBO paramNoticeBO);

  public abstract int update(NoticeBO paramNoticeBO);

  public abstract List findAll(PageInfo paramPageInfo);

  public abstract List findAll(PageInfo paramPageInfo, Map paramMap);

  public abstract List queryListByPage(Object paramObject);

  public abstract NoticeBO findById(Integer paramInteger);

  public abstract int delete(NoticeBO paramNoticeBO);

  public abstract int delete(String[] paramArrayOfString);

  public abstract NoticeBO findNotice();
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.services.INoticeServices
 * JD-Core Version:    0.6.2
 */