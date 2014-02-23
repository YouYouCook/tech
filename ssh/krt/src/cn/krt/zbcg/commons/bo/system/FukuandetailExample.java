package cn.krt.zbcg.commons.bo.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FukuandetailExample {
    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table fukuandetail
     *
     * @abatorgenerated Wed Aug 14 22:01:38 CST 2013
     */
    protected String orderByClause;

    /**
     * This field was generated by Abator for iBATIS.
     * This field corresponds to the database table fukuandetail
     *
     * @abatorgenerated Wed Aug 14 22:01:38 CST 2013
     */
    protected List oredCriteria;

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fukuandetail
     *
     * @abatorgenerated Wed Aug 14 22:01:38 CST 2013
     */
    public FukuandetailExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fukuandetail
     *
     * @abatorgenerated Wed Aug 14 22:01:38 CST 2013
     */
    protected FukuandetailExample(FukuandetailExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fukuandetail
     *
     * @abatorgenerated Wed Aug 14 22:01:38 CST 2013
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fukuandetail
     *
     * @abatorgenerated Wed Aug 14 22:01:38 CST 2013
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fukuandetail
     *
     * @abatorgenerated Wed Aug 14 22:01:38 CST 2013
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fukuandetail
     *
     * @abatorgenerated Wed Aug 14 22:01:38 CST 2013
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fukuandetail
     *
     * @abatorgenerated Wed Aug 14 22:01:38 CST 2013
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fukuandetail
     *
     * @abatorgenerated Wed Aug 14 22:01:38 CST 2013
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table fukuandetail
     *
     * @abatorgenerated Wed Aug 14 22:01:38 CST 2013
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table fukuandetail
     *
     * @abatorgenerated Wed Aug 14 22:01:38 CST 2013
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List dateList = new ArrayList();
            Iterator iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(((Date)iter.next()).getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return this;
        }

        public Criteria andIdIn(List values) {
            addCriterion("id in", values, "id");
            return this;
        }

        public Criteria andIdNotIn(List values) {
            addCriterion("id not in", values, "id");
            return this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return this;
        }

        public Criteria andPinmingIsNull() {
            addCriterion("pinming is null");
            return this;
        }

        public Criteria andPinmingIsNotNull() {
            addCriterion("pinming is not null");
            return this;
        }

        public Criteria andPinmingEqualTo(String value) {
            addCriterion("pinming =", value, "pinming");
            return this;
        }

        public Criteria andPinmingNotEqualTo(String value) {
            addCriterion("pinming <>", value, "pinming");
            return this;
        }

        public Criteria andPinmingGreaterThan(String value) {
            addCriterion("pinming >", value, "pinming");
            return this;
        }

        public Criteria andPinmingGreaterThanOrEqualTo(String value) {
            addCriterion("pinming >=", value, "pinming");
            return this;
        }

        public Criteria andPinmingLessThan(String value) {
            addCriterion("pinming <", value, "pinming");
            return this;
        }

        public Criteria andPinmingLessThanOrEqualTo(String value) {
            addCriterion("pinming <=", value, "pinming");
            return this;
        }

        public Criteria andPinmingLike(String value) {
            addCriterion("pinming like", value, "pinming");
            return this;
        }

        public Criteria andPinmingNotLike(String value) {
            addCriterion("pinming not like", value, "pinming");
            return this;
        }

        public Criteria andPinmingIn(List values) {
            addCriterion("pinming in", values, "pinming");
            return this;
        }

        public Criteria andPinmingNotIn(List values) {
            addCriterion("pinming not in", values, "pinming");
            return this;
        }

        public Criteria andPinmingBetween(String value1, String value2) {
            addCriterion("pinming between", value1, value2, "pinming");
            return this;
        }

        public Criteria andPinmingNotBetween(String value1, String value2) {
            addCriterion("pinming not between", value1, value2, "pinming");
            return this;
        }

        public Criteria andYjzfsjIsNull() {
            addCriterion("yjzfsj is null");
            return this;
        }

        public Criteria andYjzfsjIsNotNull() {
            addCriterion("yjzfsj is not null");
            return this;
        }

        public Criteria andYjzfsjEqualTo(Date value) {
            addCriterionForJDBCDate("yjzfsj =", value, "yjzfsj");
            return this;
        }

        public Criteria andYjzfsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("yjzfsj <>", value, "yjzfsj");
            return this;
        }

        public Criteria andYjzfsjGreaterThan(Date value) {
            addCriterionForJDBCDate("yjzfsj >", value, "yjzfsj");
            return this;
        }

        public Criteria andYjzfsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("yjzfsj >=", value, "yjzfsj");
            return this;
        }

        public Criteria andYjzfsjLessThan(Date value) {
            addCriterionForJDBCDate("yjzfsj <", value, "yjzfsj");
            return this;
        }

        public Criteria andYjzfsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("yjzfsj <=", value, "yjzfsj");
            return this;
        }

        public Criteria andYjzfsjIn(List values) {
            addCriterionForJDBCDate("yjzfsj in", values, "yjzfsj");
            return this;
        }

        public Criteria andYjzfsjNotIn(List values) {
            addCriterionForJDBCDate("yjzfsj not in", values, "yjzfsj");
            return this;
        }

        public Criteria andYjzfsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("yjzfsj between", value1, value2, "yjzfsj");
            return this;
        }

        public Criteria andYjzfsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("yjzfsj not between", value1, value2, "yjzfsj");
            return this;
        }

        public Criteria andSjfksjIsNull() {
            addCriterion("sjfksj is null");
            return this;
        }

        public Criteria andSjfksjIsNotNull() {
            addCriterion("sjfksj is not null");
            return this;
        }

        public Criteria andSjfksjEqualTo(Date value) {
            addCriterionForJDBCDate("sjfksj =", value, "sjfksj");
            return this;
        }

        public Criteria andSjfksjNotEqualTo(Date value) {
            addCriterionForJDBCDate("sjfksj <>", value, "sjfksj");
            return this;
        }

        public Criteria andSjfksjGreaterThan(Date value) {
            addCriterionForJDBCDate("sjfksj >", value, "sjfksj");
            return this;
        }

        public Criteria andSjfksjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sjfksj >=", value, "sjfksj");
            return this;
        }

        public Criteria andSjfksjLessThan(Date value) {
            addCriterionForJDBCDate("sjfksj <", value, "sjfksj");
            return this;
        }

        public Criteria andSjfksjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sjfksj <=", value, "sjfksj");
            return this;
        }

        public Criteria andSjfksjIn(List values) {
            addCriterionForJDBCDate("sjfksj in", values, "sjfksj");
            return this;
        }

        public Criteria andSjfksjNotIn(List values) {
            addCriterionForJDBCDate("sjfksj not in", values, "sjfksj");
            return this;
        }

        public Criteria andSjfksjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sjfksj between", value1, value2, "sjfksj");
            return this;
        }

        public Criteria andSjfksjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sjfksj not between", value1, value2, "sjfksj");
            return this;
        }

        public Criteria andGongyingshangIsNull() {
            addCriterion("gongyingshang is null");
            return this;
        }

        public Criteria andGongyingshangIsNotNull() {
            addCriterion("gongyingshang is not null");
            return this;
        }

        public Criteria andGongyingshangEqualTo(String value) {
            addCriterion("gongyingshang =", value, "gongyingshang");
            return this;
        }

        public Criteria andGongyingshangNotEqualTo(String value) {
            addCriterion("gongyingshang <>", value, "gongyingshang");
            return this;
        }

        public Criteria andGongyingshangGreaterThan(String value) {
            addCriterion("gongyingshang >", value, "gongyingshang");
            return this;
        }

        public Criteria andGongyingshangGreaterThanOrEqualTo(String value) {
            addCriterion("gongyingshang >=", value, "gongyingshang");
            return this;
        }

        public Criteria andGongyingshangLessThan(String value) {
            addCriterion("gongyingshang <", value, "gongyingshang");
            return this;
        }

        public Criteria andGongyingshangLessThanOrEqualTo(String value) {
            addCriterion("gongyingshang <=", value, "gongyingshang");
            return this;
        }

        public Criteria andGongyingshangLike(String value) {
            addCriterion("gongyingshang like", value, "gongyingshang");
            return this;
        }

        public Criteria andGongyingshangNotLike(String value) {
            addCriterion("gongyingshang not like", value, "gongyingshang");
            return this;
        }

        public Criteria andGongyingshangIn(List values) {
            addCriterion("gongyingshang in", values, "gongyingshang");
            return this;
        }

        public Criteria andGongyingshangNotIn(List values) {
            addCriterion("gongyingshang not in", values, "gongyingshang");
            return this;
        }

        public Criteria andGongyingshangBetween(String value1, String value2) {
            addCriterion("gongyingshang between", value1, value2, "gongyingshang");
            return this;
        }

        public Criteria andGongyingshangNotBetween(String value1, String value2) {
            addCriterion("gongyingshang not between", value1, value2, "gongyingshang");
            return this;
        }

        public Criteria andKaipiaoriqiIsNull() {
            addCriterion("kaipiaoriqi is null");
            return this;
        }

        public Criteria andKaipiaoriqiIsNotNull() {
            addCriterion("kaipiaoriqi is not null");
            return this;
        }

        public Criteria andKaipiaoriqiEqualTo(Date value) {
            addCriterionForJDBCDate("kaipiaoriqi =", value, "kaipiaoriqi");
            return this;
        }

        public Criteria andKaipiaoriqiNotEqualTo(Date value) {
            addCriterionForJDBCDate("kaipiaoriqi <>", value, "kaipiaoriqi");
            return this;
        }

        public Criteria andKaipiaoriqiGreaterThan(Date value) {
            addCriterionForJDBCDate("kaipiaoriqi >", value, "kaipiaoriqi");
            return this;
        }

        public Criteria andKaipiaoriqiGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("kaipiaoriqi >=", value, "kaipiaoriqi");
            return this;
        }

        public Criteria andKaipiaoriqiLessThan(Date value) {
            addCriterionForJDBCDate("kaipiaoriqi <", value, "kaipiaoriqi");
            return this;
        }

        public Criteria andKaipiaoriqiLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("kaipiaoriqi <=", value, "kaipiaoriqi");
            return this;
        }

        public Criteria andKaipiaoriqiIn(List values) {
            addCriterionForJDBCDate("kaipiaoriqi in", values, "kaipiaoriqi");
            return this;
        }

        public Criteria andKaipiaoriqiNotIn(List values) {
            addCriterionForJDBCDate("kaipiaoriqi not in", values, "kaipiaoriqi");
            return this;
        }

        public Criteria andKaipiaoriqiBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("kaipiaoriqi between", value1, value2, "kaipiaoriqi");
            return this;
        }

        public Criteria andKaipiaoriqiNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("kaipiaoriqi not between", value1, value2, "kaipiaoriqi");
            return this;
        }

        public Criteria andGuazhangjieIsNull() {
            addCriterion("guazhangjie is null");
            return this;
        }

        public Criteria andGuazhangjieIsNotNull() {
            addCriterion("guazhangjie is not null");
            return this;
        }

        public Criteria andGuazhangjieEqualTo(Float value) {
            addCriterion("guazhangjie =", value, "guazhangjie");
            return this;
        }

        public Criteria andGuazhangjieNotEqualTo(Float value) {
            addCriterion("guazhangjie <>", value, "guazhangjie");
            return this;
        }

        public Criteria andGuazhangjieGreaterThan(Float value) {
            addCriterion("guazhangjie >", value, "guazhangjie");
            return this;
        }

        public Criteria andGuazhangjieGreaterThanOrEqualTo(Float value) {
            addCriterion("guazhangjie >=", value, "guazhangjie");
            return this;
        }

        public Criteria andGuazhangjieLessThan(Float value) {
            addCriterion("guazhangjie <", value, "guazhangjie");
            return this;
        }

        public Criteria andGuazhangjieLessThanOrEqualTo(Float value) {
            addCriterion("guazhangjie <=", value, "guazhangjie");
            return this;
        }

        public Criteria andGuazhangjieIn(List values) {
            addCriterion("guazhangjie in", values, "guazhangjie");
            return this;
        }

        public Criteria andGuazhangjieNotIn(List values) {
            addCriterion("guazhangjie not in", values, "guazhangjie");
            return this;
        }

        public Criteria andGuazhangjieBetween(Float value1, Float value2) {
            addCriterion("guazhangjie between", value1, value2, "guazhangjie");
            return this;
        }

        public Criteria andGuazhangjieNotBetween(Float value1, Float value2) {
            addCriterion("guazhangjie not between", value1, value2, "guazhangjie");
            return this;
        }

        public Criteria andGzsjIsNull() {
            addCriterion("gzsj is null");
            return this;
        }

        public Criteria andGzsjIsNotNull() {
            addCriterion("gzsj is not null");
            return this;
        }

        public Criteria andGzsjEqualTo(Date value) {
            addCriterionForJDBCDate("gzsj =", value, "gzsj");
            return this;
        }

        public Criteria andGzsjNotEqualTo(Date value) {
            addCriterionForJDBCDate("gzsj <>", value, "gzsj");
            return this;
        }

        public Criteria andGzsjGreaterThan(Date value) {
            addCriterionForJDBCDate("gzsj >", value, "gzsj");
            return this;
        }

        public Criteria andGzsjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("gzsj >=", value, "gzsj");
            return this;
        }

        public Criteria andGzsjLessThan(Date value) {
            addCriterionForJDBCDate("gzsj <", value, "gzsj");
            return this;
        }

        public Criteria andGzsjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("gzsj <=", value, "gzsj");
            return this;
        }

        public Criteria andGzsjIn(List values) {
            addCriterionForJDBCDate("gzsj in", values, "gzsj");
            return this;
        }

        public Criteria andGzsjNotIn(List values) {
            addCriterionForJDBCDate("gzsj not in", values, "gzsj");
            return this;
        }

        public Criteria andGzsjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("gzsj between", value1, value2, "gzsj");
            return this;
        }

        public Criteria andGzsjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("gzsj not between", value1, value2, "gzsj");
            return this;
        }

        public Criteria andZhangqiIsNull() {
            addCriterion("zhangqi is null");
            return this;
        }

        public Criteria andZhangqiIsNotNull() {
            addCriterion("zhangqi is not null");
            return this;
        }

        public Criteria andZhangqiEqualTo(String value) {
            addCriterion("zhangqi =", value, "zhangqi");
            return this;
        }

        public Criteria andZhangqiNotEqualTo(String value) {
            addCriterion("zhangqi <>", value, "zhangqi");
            return this;
        }

        public Criteria andZhangqiGreaterThan(String value) {
            addCriterion("zhangqi >", value, "zhangqi");
            return this;
        }

        public Criteria andZhangqiGreaterThanOrEqualTo(String value) {
            addCriterion("zhangqi >=", value, "zhangqi");
            return this;
        }

        public Criteria andZhangqiLessThan(String value) {
            addCriterion("zhangqi <", value, "zhangqi");
            return this;
        }

        public Criteria andZhangqiLessThanOrEqualTo(String value) {
            addCriterion("zhangqi <=", value, "zhangqi");
            return this;
        }

        public Criteria andZhangqiLike(String value) {
            addCriterion("zhangqi like", value, "zhangqi");
            return this;
        }

        public Criteria andZhangqiNotLike(String value) {
            addCriterion("zhangqi not like", value, "zhangqi");
            return this;
        }

        public Criteria andZhangqiIn(List values) {
            addCriterion("zhangqi in", values, "zhangqi");
            return this;
        }

        public Criteria andZhangqiNotIn(List values) {
            addCriterion("zhangqi not in", values, "zhangqi");
            return this;
        }

        public Criteria andZhangqiBetween(String value1, String value2) {
            addCriterion("zhangqi between", value1, value2, "zhangqi");
            return this;
        }

        public Criteria andZhangqiNotBetween(String value1, String value2) {
            addCriterion("zhangqi not between", value1, value2, "zhangqi");
            return this;
        }

        public Criteria andYjzfjeIsNull() {
            addCriterion("yjzfje is null");
            return this;
        }

        public Criteria andYjzfjeIsNotNull() {
            addCriterion("yjzfje is not null");
            return this;
        }

        public Criteria andYjzfjeEqualTo(Float value) {
            addCriterion("yjzfje =", value, "yjzfje");
            return this;
        }

        public Criteria andYjzfjeNotEqualTo(Float value) {
            addCriterion("yjzfje <>", value, "yjzfje");
            return this;
        }

        public Criteria andYjzfjeGreaterThan(Float value) {
            addCriterion("yjzfje >", value, "yjzfje");
            return this;
        }

        public Criteria andYjzfjeGreaterThanOrEqualTo(Float value) {
            addCriterion("yjzfje >=", value, "yjzfje");
            return this;
        }

        public Criteria andYjzfjeLessThan(Float value) {
            addCriterion("yjzfje <", value, "yjzfje");
            return this;
        }

        public Criteria andYjzfjeLessThanOrEqualTo(Float value) {
            addCriterion("yjzfje <=", value, "yjzfje");
            return this;
        }

        public Criteria andYjzfjeIn(List values) {
            addCriterion("yjzfje in", values, "yjzfje");
            return this;
        }

        public Criteria andYjzfjeNotIn(List values) {
            addCriterion("yjzfje not in", values, "yjzfje");
            return this;
        }

        public Criteria andYjzfjeBetween(Float value1, Float value2) {
            addCriterion("yjzfje between", value1, value2, "yjzfje");
            return this;
        }

        public Criteria andYjzfjeNotBetween(Float value1, Float value2) {
            addCriterion("yjzfje not between", value1, value2, "yjzfje");
            return this;
        }

        public Criteria andBeizhuIsNull() {
            addCriterion("beizhu is null");
            return this;
        }

        public Criteria andBeizhuIsNotNull() {
            addCriterion("beizhu is not null");
            return this;
        }

        public Criteria andBeizhuEqualTo(String value) {
            addCriterion("beizhu =", value, "beizhu");
            return this;
        }

        public Criteria andBeizhuNotEqualTo(String value) {
            addCriterion("beizhu <>", value, "beizhu");
            return this;
        }

        public Criteria andBeizhuGreaterThan(String value) {
            addCriterion("beizhu >", value, "beizhu");
            return this;
        }

        public Criteria andBeizhuGreaterThanOrEqualTo(String value) {
            addCriterion("beizhu >=", value, "beizhu");
            return this;
        }

        public Criteria andBeizhuLessThan(String value) {
            addCriterion("beizhu <", value, "beizhu");
            return this;
        }

        public Criteria andBeizhuLessThanOrEqualTo(String value) {
            addCriterion("beizhu <=", value, "beizhu");
            return this;
        }

        public Criteria andBeizhuLike(String value) {
            addCriterion("beizhu like", value, "beizhu");
            return this;
        }

        public Criteria andBeizhuNotLike(String value) {
            addCriterion("beizhu not like", value, "beizhu");
            return this;
        }

        public Criteria andBeizhuIn(List values) {
            addCriterion("beizhu in", values, "beizhu");
            return this;
        }

        public Criteria andBeizhuNotIn(List values) {
            addCriterion("beizhu not in", values, "beizhu");
            return this;
        }

        public Criteria andBeizhuBetween(String value1, String value2) {
            addCriterion("beizhu between", value1, value2, "beizhu");
            return this;
        }

        public Criteria andBeizhuNotBetween(String value1, String value2) {
            addCriterion("beizhu not between", value1, value2, "beizhu");
            return this;
        }

        public Criteria andShuliangIsNull() {
            addCriterion("shuliang is null");
            return this;
        }

        public Criteria andShuliangIsNotNull() {
            addCriterion("shuliang is not null");
            return this;
        }

        public Criteria andShuliangEqualTo(Integer value) {
            addCriterion("shuliang =", value, "shuliang");
            return this;
        }

        public Criteria andShuliangNotEqualTo(Integer value) {
            addCriterion("shuliang <>", value, "shuliang");
            return this;
        }

        public Criteria andShuliangGreaterThan(Integer value) {
            addCriterion("shuliang >", value, "shuliang");
            return this;
        }

        public Criteria andShuliangGreaterThanOrEqualTo(Integer value) {
            addCriterion("shuliang >=", value, "shuliang");
            return this;
        }

        public Criteria andShuliangLessThan(Integer value) {
            addCriterion("shuliang <", value, "shuliang");
            return this;
        }

        public Criteria andShuliangLessThanOrEqualTo(Integer value) {
            addCriterion("shuliang <=", value, "shuliang");
            return this;
        }

        public Criteria andShuliangIn(List values) {
            addCriterion("shuliang in", values, "shuliang");
            return this;
        }

        public Criteria andShuliangNotIn(List values) {
            addCriterion("shuliang not in", values, "shuliang");
            return this;
        }

        public Criteria andShuliangBetween(Integer value1, Integer value2) {
            addCriterion("shuliang between", value1, value2, "shuliang");
            return this;
        }

        public Criteria andShuliangNotBetween(Integer value1, Integer value2) {
            addCriterion("shuliang not between", value1, value2, "shuliang");
            return this;
        }

        public Criteria andFapiaohaomaIsNull() {
            addCriterion("fapiaohaoma is null");
            return this;
        }

        public Criteria andFapiaohaomaIsNotNull() {
            addCriterion("fapiaohaoma is not null");
            return this;
        }

        public Criteria andFapiaohaomaEqualTo(String value) {
            addCriterion("fapiaohaoma =", value, "fapiaohaoma");
            return this;
        }

        public Criteria andFapiaohaomaNotEqualTo(String value) {
            addCriterion("fapiaohaoma <>", value, "fapiaohaoma");
            return this;
        }

        public Criteria andFapiaohaomaGreaterThan(String value) {
            addCriterion("fapiaohaoma >", value, "fapiaohaoma");
            return this;
        }

        public Criteria andFapiaohaomaGreaterThanOrEqualTo(String value) {
            addCriterion("fapiaohaoma >=", value, "fapiaohaoma");
            return this;
        }

        public Criteria andFapiaohaomaLessThan(String value) {
            addCriterion("fapiaohaoma <", value, "fapiaohaoma");
            return this;
        }

        public Criteria andFapiaohaomaLessThanOrEqualTo(String value) {
            addCriterion("fapiaohaoma <=", value, "fapiaohaoma");
            return this;
        }

        public Criteria andFapiaohaomaLike(String value) {
            addCriterion("fapiaohaoma like", value, "fapiaohaoma");
            return this;
        }

        public Criteria andFapiaohaomaNotLike(String value) {
            addCriterion("fapiaohaoma not like", value, "fapiaohaoma");
            return this;
        }

        public Criteria andFapiaohaomaIn(List values) {
            addCriterion("fapiaohaoma in", values, "fapiaohaoma");
            return this;
        }

        public Criteria andFapiaohaomaNotIn(List values) {
            addCriterion("fapiaohaoma not in", values, "fapiaohaoma");
            return this;
        }

        public Criteria andFapiaohaomaBetween(String value1, String value2) {
            addCriterion("fapiaohaoma between", value1, value2, "fapiaohaoma");
            return this;
        }

        public Criteria andFapiaohaomaNotBetween(String value1, String value2) {
            addCriterion("fapiaohaoma not between", value1, value2, "fapiaohaoma");
            return this;
        }

        public Criteria andPihaoIsNull() {
            addCriterion("pihao is null");
            return this;
        }

        public Criteria andPihaoIsNotNull() {
            addCriterion("pihao is not null");
            return this;
        }

        public Criteria andPihaoEqualTo(String value) {
            addCriterion("pihao =", value, "pihao");
            return this;
        }

        public Criteria andPihaoNotEqualTo(String value) {
            addCriterion("pihao <>", value, "pihao");
            return this;
        }

        public Criteria andPihaoGreaterThan(String value) {
            addCriterion("pihao >", value, "pihao");
            return this;
        }

        public Criteria andPihaoGreaterThanOrEqualTo(String value) {
            addCriterion("pihao >=", value, "pihao");
            return this;
        }

        public Criteria andPihaoLessThan(String value) {
            addCriterion("pihao <", value, "pihao");
            return this;
        }

        public Criteria andPihaoLessThanOrEqualTo(String value) {
            addCriterion("pihao <=", value, "pihao");
            return this;
        }

        public Criteria andPihaoLike(String value) {
            addCriterion("pihao like", value, "pihao");
            return this;
        }

        public Criteria andPihaoNotLike(String value) {
            addCriterion("pihao not like", value, "pihao");
            return this;
        }

        public Criteria andPihaoIn(List values) {
            addCriterion("pihao in", values, "pihao");
            return this;
        }

        public Criteria andPihaoNotIn(List values) {
            addCriterion("pihao not in", values, "pihao");
            return this;
        }

        public Criteria andPihaoBetween(String value1, String value2) {
            addCriterion("pihao between", value1, value2, "pihao");
            return this;
        }

        public Criteria andPihaoNotBetween(String value1, String value2) {
            addCriterion("pihao not between", value1, value2, "pihao");
            return this;
        }
    }
}