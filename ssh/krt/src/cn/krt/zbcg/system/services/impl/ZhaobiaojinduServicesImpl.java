package cn.krt.zbcg.system.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.ssi.common.PageInfo;
import org.ssi.services.impl.ServiceImpl;
import cn.krt.zbcg.commons.bo.system.ZhaobiaojinduBO;
import cn.krt.zbcg.system.dao.ZhaobiaojinduDAO;
import cn.krt.zbcg.system.services.IZhaobiaojinduServices;

public class ZhaobiaojinduServicesImpl extends ServiceImpl implements
		IZhaobiaojinduServices {
	
	private ZhaobiaojinduDAO zhaobiaojinduDAO;

	

	public ZhaobiaojinduDAO getZhaobiaojinduDAO() {
		return zhaobiaojinduDAO;
	}

	public void setZhaobiaojinduDAO(ZhaobiaojinduDAO zhaobiaojinduDAO) {
		this.zhaobiaojinduDAO = zhaobiaojinduDAO;
	}
	
	

	public List findAll(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
		Map map = new HashMap();
		List list = findAll(pageInfo, map);
		return list;
	}

	public List findAll(PageInfo pageInfo, Map map) {
		this.pageInfo = pageInfo;
		List list = queryListByPage(map);
		return list;
	}

	public List findAlls(PageInfo pageInfo, Map map) {
		this.pageInfo = pageInfo;
		List list = queryListByPages(map);
		return list;
	}

	public List queryListByPage(Object obj) {
		this.pageInfo = this.pageInfo;
		Map map = new HashMap();

		List list = null;

		setPublicParams((Map) obj);
		this.logger.debug("��ѯ��"
				+ (this.pageInfo != null ? this.pageInfo.getPageNum() : 0)
				+ "ҳ���");

		list = this.zhaobiaojinduDAO.selectAll(obj);
		this.logger.debug("list.size(befor reset)="
				+ (list != null ? Integer.valueOf(list.size()) : ""));

		if ((list == null) || (list.size() == 0)) {
			if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0)) {
				setPublicParams((Map) obj, true);
				list = this.zhaobiaojinduDAO.selectAll(obj);
				this.logger.debug("list.size(befor reset)="
						+ (list != null ? Integer.valueOf(list.size()) : ""));
			}
		}

		List o = (List) this.zhaobiaojinduDAO.selectAllOfCount(obj);
		if (o != null) {
			this.logger.debug("���=" + o.toString());
			this.pageInfo.setTotalSize(o.size());
		}
		return list;
	}

	public List queryListByPages(Object obj) {
		this.pageInfo = this.pageInfo;
		Map map = new HashMap();

		List list = null;

		setPublicParams((Map) obj);
		this.logger.debug("��ѯ��"
				+ (this.pageInfo != null ? this.pageInfo.getPageNum() : 0)
				+ "ҳ���");

		list = this.zhaobiaojinduDAO.selectAlls(obj);
		this.logger.debug("list.size(befor reset)="
				+ (list != null ? Integer.valueOf(list.size()) : ""));

		if ((list == null) || (list.size() == 0)) {
			if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0)) {
				setPublicParams((Map) obj, true);
				list = this.zhaobiaojinduDAO.selectAlls(obj);
				this.logger.debug("list.size(befor reset)="
						+ (list != null ? Integer.valueOf(list.size()) : ""));
			}
		}

		Object o = this.zhaobiaojinduDAO.selectAllOfCounts(obj);
		if (o != null) {
			this.logger.debug("���=" + o.toString());
			this.pageInfo.setTotalSize(Integer.parseInt(o.toString()));
		}
		return list;
	}

	@Override
	public void insert(ZhaobiaojinduBO shqbo) {
		try {
			this.zhaobiaojinduDAO.insert(shqbo);
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionUtils.getFullStackTrace(e);
			e.printStackTrace();
			e.printStackTrace();
		}
	}

	@Override
	public ZhaobiaojinduBO findById(Integer userId) {
		ZhaobiaojinduBO key = new ZhaobiaojinduBO();
		key.setId(userId);
		ZhaobiaojinduBO record = (ZhaobiaojinduBO) this.zhaobiaojinduDAO.queryData(key);
		return record;
	}
	
	public ZhaobiaojinduBO findByPzsx(String pinzhongshuxing) {
		ZhaobiaojinduBO record = (ZhaobiaojinduBO) this.zhaobiaojinduDAO.selectByPinzhong(pinzhongshuxing);
		return record;
	}
	public List findNoFininshDD(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
		Map map = new HashMap();

		List list = null;

		setPublicParams(map);
		this.logger.debug("��ѯ��"
				+ (this.pageInfo != null ? this.pageInfo.getPageNum() : 0)
				+ "ҳ���");

		list = this.zhaobiaojinduDAO.selectByNoFinishDD(map);
		this.logger.debug("list.size(befor reset)="
				+ (list != null ? Integer.valueOf(list.size()) : ""));

		if ((list == null) || (list.size() == 0)) {
			if ((this.pageInfo != null) && (this.pageInfo.getPageNum() > 0)) {
				setPublicParams(map, true);
				list = this.zhaobiaojinduDAO.selectByNoFinishDD(map);
				this.logger.debug("list.size(befor reset)="
						+ (list != null ? Integer.valueOf(list.size()) : ""));
			}
		}

		List o = (List) this.zhaobiaojinduDAO.selectByNoFinishDD(map);
		if (o != null) {
			this.logger.debug("���=" + o.toString());
			this.pageInfo.setTotalSize(o.size());
		}
		return list;
	}

	
	
	@Override
	public int delete(String[] ids) {
		this.zhaobiaojinduDAO.deleteByPrimaryKey(Integer.valueOf(ids[0]));
		return 0;
	}

	@Override
	public int update(ZhaobiaojinduBO record) {
		int rows = 0;
		try {
			rows = this.zhaobiaojinduDAO.updateByPrimaryKey(record);
		} catch (Exception e) {
			ExceptionUtils.getFullStackTrace(e);
			e.printStackTrace();
		}
		return rows;
	}


	

}
