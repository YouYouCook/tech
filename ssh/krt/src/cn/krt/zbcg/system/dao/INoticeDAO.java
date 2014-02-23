package cn.krt.zbcg.system.dao;

import cn.krt.zbcg.commons.bo.system.NoticeBO;
import java.util.List;
import org.ssi.dao.IBaseDao;

public abstract interface INoticeDAO extends IBaseDao
{
  public abstract void insert(NoticeBO paramNoticeBO)
    throws Exception;

  public abstract int update(NoticeBO paramNoticeBO)
    throws Exception;

  public abstract List selectAll(Object paramObject);

  public abstract Object selectAllOfCount(Object paramObject);

  public abstract Object queryData(Object paramObject);

  public abstract int delete(NoticeBO paramNoticeBO)
    throws Exception;

  public abstract NoticeBO findNotice();
}

/* Location:           D:\李慧医药项目\tcmages\krt\WEB-INF\classes\
 * Qualified Name:     cn.krt.zbcg.system.dao.INoticeDAO
 * JD-Core Version:    0.6.2
 */