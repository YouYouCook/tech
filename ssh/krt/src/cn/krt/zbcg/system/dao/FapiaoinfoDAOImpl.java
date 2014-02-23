package cn.krt.zbcg.system.dao;


import cn.krt.zbcg.commons.bo.system.FapiaoinfoBO;
import cn.krt.zbcg.commons.bo.system.FapiaoinfoExample;
import cn.krt.zbcg.commons.bo.system.ShqdExample;
import cn.krt.zbcg.system.dao.FapiaoinfoDAO;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.ssi.dao.impl.BaseDaoImpl;

public class FapiaoinfoDAOImpl extends BaseDaoImpl implements  FapiaoinfoDAO {

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fapiaoinfo
     *
     * @abatorgenerated Wed Aug 14 00:34:02 CST 2013
     */
    public FapiaoinfoDAOImpl() {
        super();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fapiaoinfo
     *
     * @abatorgenerated Wed Aug 14 00:34:02 CST 2013
     */
    public void insert(FapiaoinfoBO record) {
        getSqlMapClientTemplate().insert("fapiaoinfo.abatorgenerated_insert", record);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fapiaoinfo
     *
     * @abatorgenerated Wed Aug 14 00:34:02 CST 2013
     */
    public int updateByPrimaryKey(FapiaoinfoBO record) {
        int rows = getSqlMapClientTemplate().update("fapiaoinfo.abatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fapiaoinfo
     *
     * @abatorgenerated Wed Aug 14 00:34:02 CST 2013
     */
    public int updateByPrimaryKeySelective(FapiaoinfoBO record) {
        int rows = getSqlMapClientTemplate().update("fapiaoinfo.abatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fapiaoinfo
     *
     * @abatorgenerated Wed Aug 14 00:34:02 CST 2013
     */
    public List selectByExample(FapiaoinfoExample example) {
        List list = getSqlMapClientTemplate().queryForList("fapiaoinfo.abatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fapiaoinfo
     *
     * @abatorgenerated Wed Aug 14 00:34:02 CST 2013
     */
    public FapiaoinfoBO selectByPrimaryKey(Integer id) {
        FapiaoinfoBO key = new FapiaoinfoBO();
        key.setId(id);
        FapiaoinfoBO record = (FapiaoinfoBO) getSqlMapClientTemplate().queryForObject("fapiaoinfo.abatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fapiaoinfo
     *
     * @abatorgenerated Wed Aug 14 00:34:02 CST 2013
     */
    public int deleteByExample(FapiaoinfoExample example) {
        int rows = getSqlMapClientTemplate().delete("fapiaoinfo.abatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fapiaoinfo
     *
     * @abatorgenerated Wed Aug 14 00:34:02 CST 2013
     */
    public int deleteByPrimaryKey(Integer id) {
        FapiaoinfoBO key = new FapiaoinfoBO();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("fapiaoinfo.abatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fapiaoinfo
     *
     * @abatorgenerated Wed Aug 14 00:34:02 CST 2013
     */
    public int countByExample(FapiaoinfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("fapiaoinfo.abatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fapiaoinfo
     *
     * @abatorgenerated Wed Aug 14 00:34:02 CST 2013
     */
    public int updateByExampleSelective(FapiaoinfoBO record, FapiaoinfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("fapiaoinfo.abatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fapiaoinfo
     *
     * @abatorgenerated Wed Aug 14 00:34:02 CST 2013
     */
    public int updateByExample(FapiaoinfoBO record, FapiaoinfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("fapiaoinfo.abatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table fapiaoinfo
     *
     * @abatorgenerated Wed Aug 14 00:34:02 CST 2013
     */
    private static class UpdateByExampleParms extends FapiaoinfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, FapiaoinfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	@Override
	public int countByExample(ShqdExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List selectAll(Object paramObject) {
		List list = queryList("fapiaoinfo.selectAll", paramObject);
		return list;
	}

	@Override
	public Object selectAllOfCount(Object obj) {
		List list = queryList("fapiaoinfo.selectAll", obj);
		return list;
	}

	@Override
	public List selectAlls(Object paramObject) {
		List list = queryList("fapiaoinfo.selectAll", paramObject);
		return list;
	}

	@Override
	public Object selectAllOfCounts(Object paramObject) {
		List list = queryList("fapiaoinfo.selectAll", paramObject);
		return list;
	}
	
	  public Object queryData(Object obj)
      {
       Object record = queryData("fapiaoinfo.selectByPrimaryKey", obj);
        return record;
     }

	@Override
	public FapiaoinfoBO queryData(FapiaoinfoBO key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(FapiaoinfoBO record) throws Exception {
		  int rows = update("fapiaoinfo.updateByPrimaryKey", record);
		    return rows;
	}
}