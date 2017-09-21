package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TCoopAgencyApplyExample {
	private int pageNum;
	private int pageSize;
	private int beginRow;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBeginRow() {
		// 在mapper.xml使用begin属性时，对其进行计算
		return (pageNum - 1) * pageSize;
	}

	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
	
	
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCoopAgencyApplyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSelfIdIsNull() {
            addCriterion("SELF_ID is null");
            return (Criteria) this;
        }

        public Criteria andSelfIdIsNotNull() {
            addCriterion("SELF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSelfIdEqualTo(Long value) {
            addCriterion("SELF_ID =", value, "selfId");
            return (Criteria) this;
        }

        public Criteria andSelfIdNotEqualTo(Long value) {
            addCriterion("SELF_ID <>", value, "selfId");
            return (Criteria) this;
        }

        public Criteria andSelfIdGreaterThan(Long value) {
            addCriterion("SELF_ID >", value, "selfId");
            return (Criteria) this;
        }

        public Criteria andSelfIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SELF_ID >=", value, "selfId");
            return (Criteria) this;
        }

        public Criteria andSelfIdLessThan(Long value) {
            addCriterion("SELF_ID <", value, "selfId");
            return (Criteria) this;
        }

        public Criteria andSelfIdLessThanOrEqualTo(Long value) {
            addCriterion("SELF_ID <=", value, "selfId");
            return (Criteria) this;
        }

        public Criteria andSelfIdIn(List<Long> values) {
            addCriterion("SELF_ID in", values, "selfId");
            return (Criteria) this;
        }

        public Criteria andSelfIdNotIn(List<Long> values) {
            addCriterion("SELF_ID not in", values, "selfId");
            return (Criteria) this;
        }

        public Criteria andSelfIdBetween(Long value1, Long value2) {
            addCriterion("SELF_ID between", value1, value2, "selfId");
            return (Criteria) this;
        }

        public Criteria andSelfIdNotBetween(Long value1, Long value2) {
            addCriterion("SELF_ID not between", value1, value2, "selfId");
            return (Criteria) this;
        }

        public Criteria andCaidIsNull() {
            addCriterion("CAID is null");
            return (Criteria) this;
        }

        public Criteria andCaidIsNotNull() {
            addCriterion("CAID is not null");
            return (Criteria) this;
        }

        public Criteria andCaidEqualTo(Long value) {
            addCriterion("CAID =", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidNotEqualTo(Long value) {
            addCriterion("CAID <>", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidGreaterThan(Long value) {
            addCriterion("CAID >", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidGreaterThanOrEqualTo(Long value) {
            addCriterion("CAID >=", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidLessThan(Long value) {
            addCriterion("CAID <", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidLessThanOrEqualTo(Long value) {
            addCriterion("CAID <=", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidIn(List<Long> values) {
            addCriterion("CAID in", values, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidNotIn(List<Long> values) {
            addCriterion("CAID not in", values, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidBetween(Long value1, Long value2) {
            addCriterion("CAID between", value1, value2, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidNotBetween(Long value1, Long value2) {
            addCriterion("CAID not between", value1, value2, "caid");
            return (Criteria) this;
        }

        public Criteria andCacodeIsNull() {
            addCriterion("CACODE is null");
            return (Criteria) this;
        }

        public Criteria andCacodeIsNotNull() {
            addCriterion("CACODE is not null");
            return (Criteria) this;
        }

        public Criteria andCacodeEqualTo(String value) {
            addCriterion("CACODE =", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeNotEqualTo(String value) {
            addCriterion("CACODE <>", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeGreaterThan(String value) {
            addCriterion("CACODE >", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeGreaterThanOrEqualTo(String value) {
            addCriterion("CACODE >=", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeLessThan(String value) {
            addCriterion("CACODE <", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeLessThanOrEqualTo(String value) {
            addCriterion("CACODE <=", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeLike(String value) {
            addCriterion("CACODE like", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeNotLike(String value) {
            addCriterion("CACODE not like", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeIn(List<String> values) {
            addCriterion("CACODE in", values, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeNotIn(List<String> values) {
            addCriterion("CACODE not in", values, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeBetween(String value1, String value2) {
            addCriterion("CACODE between", value1, value2, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeNotBetween(String value1, String value2) {
            addCriterion("CACODE not between", value1, value2, "cacode");
            return (Criteria) this;
        }

        public Criteria andCanameIsNull() {
            addCriterion("CANAME is null");
            return (Criteria) this;
        }

        public Criteria andCanameIsNotNull() {
            addCriterion("CANAME is not null");
            return (Criteria) this;
        }

        public Criteria andCanameEqualTo(String value) {
            addCriterion("CANAME =", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotEqualTo(String value) {
            addCriterion("CANAME <>", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameGreaterThan(String value) {
            addCriterion("CANAME >", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameGreaterThanOrEqualTo(String value) {
            addCriterion("CANAME >=", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameLessThan(String value) {
            addCriterion("CANAME <", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameLessThanOrEqualTo(String value) {
            addCriterion("CANAME <=", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameLike(String value) {
            addCriterion("CANAME like", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotLike(String value) {
            addCriterion("CANAME not like", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameIn(List<String> values) {
            addCriterion("CANAME in", values, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotIn(List<String> values) {
            addCriterion("CANAME not in", values, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameBetween(String value1, String value2) {
            addCriterion("CANAME between", value1, value2, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotBetween(String value1, String value2) {
            addCriterion("CANAME not between", value1, value2, "caname");
            return (Criteria) this;
        }

        public Criteria andCaprovinceIsNull() {
            addCriterion("CAPROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andCaprovinceIsNotNull() {
            addCriterion("CAPROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andCaprovinceEqualTo(Long value) {
            addCriterion("CAPROVINCE =", value, "caprovince");
            return (Criteria) this;
        }

        public Criteria andCaprovinceNotEqualTo(Long value) {
            addCriterion("CAPROVINCE <>", value, "caprovince");
            return (Criteria) this;
        }

        public Criteria andCaprovinceGreaterThan(Long value) {
            addCriterion("CAPROVINCE >", value, "caprovince");
            return (Criteria) this;
        }

        public Criteria andCaprovinceGreaterThanOrEqualTo(Long value) {
            addCriterion("CAPROVINCE >=", value, "caprovince");
            return (Criteria) this;
        }

        public Criteria andCaprovinceLessThan(Long value) {
            addCriterion("CAPROVINCE <", value, "caprovince");
            return (Criteria) this;
        }

        public Criteria andCaprovinceLessThanOrEqualTo(Long value) {
            addCriterion("CAPROVINCE <=", value, "caprovince");
            return (Criteria) this;
        }

        public Criteria andCaprovinceIn(List<Long> values) {
            addCriterion("CAPROVINCE in", values, "caprovince");
            return (Criteria) this;
        }

        public Criteria andCaprovinceNotIn(List<Long> values) {
            addCriterion("CAPROVINCE not in", values, "caprovince");
            return (Criteria) this;
        }

        public Criteria andCaprovinceBetween(Long value1, Long value2) {
            addCriterion("CAPROVINCE between", value1, value2, "caprovince");
            return (Criteria) this;
        }

        public Criteria andCaprovinceNotBetween(Long value1, Long value2) {
            addCriterion("CAPROVINCE not between", value1, value2, "caprovince");
            return (Criteria) this;
        }

        public Criteria andCacityIsNull() {
            addCriterion("CACITY is null");
            return (Criteria) this;
        }

        public Criteria andCacityIsNotNull() {
            addCriterion("CACITY is not null");
            return (Criteria) this;
        }

        public Criteria andCacityEqualTo(Long value) {
            addCriterion("CACITY =", value, "cacity");
            return (Criteria) this;
        }

        public Criteria andCacityNotEqualTo(Long value) {
            addCriterion("CACITY <>", value, "cacity");
            return (Criteria) this;
        }

        public Criteria andCacityGreaterThan(Long value) {
            addCriterion("CACITY >", value, "cacity");
            return (Criteria) this;
        }

        public Criteria andCacityGreaterThanOrEqualTo(Long value) {
            addCriterion("CACITY >=", value, "cacity");
            return (Criteria) this;
        }

        public Criteria andCacityLessThan(Long value) {
            addCriterion("CACITY <", value, "cacity");
            return (Criteria) this;
        }

        public Criteria andCacityLessThanOrEqualTo(Long value) {
            addCriterion("CACITY <=", value, "cacity");
            return (Criteria) this;
        }

        public Criteria andCacityIn(List<Long> values) {
            addCriterion("CACITY in", values, "cacity");
            return (Criteria) this;
        }

        public Criteria andCacityNotIn(List<Long> values) {
            addCriterion("CACITY not in", values, "cacity");
            return (Criteria) this;
        }

        public Criteria andCacityBetween(Long value1, Long value2) {
            addCriterion("CACITY between", value1, value2, "cacity");
            return (Criteria) this;
        }

        public Criteria andCacityNotBetween(Long value1, Long value2) {
            addCriterion("CACITY not between", value1, value2, "cacity");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("CONTACT is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("CONTACT is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("CONTACT =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("CONTACT <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("CONTACT >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("CONTACT <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("CONTACT <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("CONTACT like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("CONTACT not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("CONTACT in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("CONTACT not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("CONTACT between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("CONTACT not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContPhoneIsNull() {
            addCriterion("CONT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andContPhoneIsNotNull() {
            addCriterion("CONT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andContPhoneEqualTo(String value) {
            addCriterion("CONT_PHONE =", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneNotEqualTo(String value) {
            addCriterion("CONT_PHONE <>", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneGreaterThan(String value) {
            addCriterion("CONT_PHONE >", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_PHONE >=", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneLessThan(String value) {
            addCriterion("CONT_PHONE <", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneLessThanOrEqualTo(String value) {
            addCriterion("CONT_PHONE <=", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneLike(String value) {
            addCriterion("CONT_PHONE like", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneNotLike(String value) {
            addCriterion("CONT_PHONE not like", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneIn(List<String> values) {
            addCriterion("CONT_PHONE in", values, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneNotIn(List<String> values) {
            addCriterion("CONT_PHONE not in", values, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneBetween(String value1, String value2) {
            addCriterion("CONT_PHONE between", value1, value2, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneNotBetween(String value1, String value2) {
            addCriterion("CONT_PHONE not between", value1, value2, "contPhone");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCalevelIsNull() {
            addCriterion("CALEVEL is null");
            return (Criteria) this;
        }

        public Criteria andCalevelIsNotNull() {
            addCriterion("CALEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andCalevelEqualTo(Short value) {
            addCriterion("CALEVEL =", value, "calevel");
            return (Criteria) this;
        }

        public Criteria andCalevelNotEqualTo(Short value) {
            addCriterion("CALEVEL <>", value, "calevel");
            return (Criteria) this;
        }

        public Criteria andCalevelGreaterThan(Short value) {
            addCriterion("CALEVEL >", value, "calevel");
            return (Criteria) this;
        }

        public Criteria andCalevelGreaterThanOrEqualTo(Short value) {
            addCriterion("CALEVEL >=", value, "calevel");
            return (Criteria) this;
        }

        public Criteria andCalevelLessThan(Short value) {
            addCriterion("CALEVEL <", value, "calevel");
            return (Criteria) this;
        }

        public Criteria andCalevelLessThanOrEqualTo(Short value) {
            addCriterion("CALEVEL <=", value, "calevel");
            return (Criteria) this;
        }

        public Criteria andCalevelIn(List<Short> values) {
            addCriterion("CALEVEL in", values, "calevel");
            return (Criteria) this;
        }

        public Criteria andCalevelNotIn(List<Short> values) {
            addCriterion("CALEVEL not in", values, "calevel");
            return (Criteria) this;
        }

        public Criteria andCalevelBetween(Short value1, Short value2) {
            addCriterion("CALEVEL between", value1, value2, "calevel");
            return (Criteria) this;
        }

        public Criteria andCalevelNotBetween(Short value1, Short value2) {
            addCriterion("CALEVEL not between", value1, value2, "calevel");
            return (Criteria) this;
        }

        public Criteria andSupercodeIsNull() {
            addCriterion("SUPERCODE is null");
            return (Criteria) this;
        }

        public Criteria andSupercodeIsNotNull() {
            addCriterion("SUPERCODE is not null");
            return (Criteria) this;
        }

        public Criteria andSupercodeEqualTo(String value) {
            addCriterion("SUPERCODE =", value, "supercode");
            return (Criteria) this;
        }

        public Criteria andSupercodeNotEqualTo(String value) {
            addCriterion("SUPERCODE <>", value, "supercode");
            return (Criteria) this;
        }

        public Criteria andSupercodeGreaterThan(String value) {
            addCriterion("SUPERCODE >", value, "supercode");
            return (Criteria) this;
        }

        public Criteria andSupercodeGreaterThanOrEqualTo(String value) {
            addCriterion("SUPERCODE >=", value, "supercode");
            return (Criteria) this;
        }

        public Criteria andSupercodeLessThan(String value) {
            addCriterion("SUPERCODE <", value, "supercode");
            return (Criteria) this;
        }

        public Criteria andSupercodeLessThanOrEqualTo(String value) {
            addCriterion("SUPERCODE <=", value, "supercode");
            return (Criteria) this;
        }

        public Criteria andSupercodeLike(String value) {
            addCriterion("SUPERCODE like", value, "supercode");
            return (Criteria) this;
        }

        public Criteria andSupercodeNotLike(String value) {
            addCriterion("SUPERCODE not like", value, "supercode");
            return (Criteria) this;
        }

        public Criteria andSupercodeIn(List<String> values) {
            addCriterion("SUPERCODE in", values, "supercode");
            return (Criteria) this;
        }

        public Criteria andSupercodeNotIn(List<String> values) {
            addCriterion("SUPERCODE not in", values, "supercode");
            return (Criteria) this;
        }

        public Criteria andSupercodeBetween(String value1, String value2) {
            addCriterion("SUPERCODE between", value1, value2, "supercode");
            return (Criteria) this;
        }

        public Criteria andSupercodeNotBetween(String value1, String value2) {
            addCriterion("SUPERCODE not between", value1, value2, "supercode");
            return (Criteria) this;
        }

        public Criteria andInuserIsNull() {
            addCriterion("INUSER is null");
            return (Criteria) this;
        }

        public Criteria andInuserIsNotNull() {
            addCriterion("INUSER is not null");
            return (Criteria) this;
        }

        public Criteria andInuserEqualTo(Long value) {
            addCriterion("INUSER =", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserNotEqualTo(Long value) {
            addCriterion("INUSER <>", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserGreaterThan(Long value) {
            addCriterion("INUSER >", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserGreaterThanOrEqualTo(Long value) {
            addCriterion("INUSER >=", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserLessThan(Long value) {
            addCriterion("INUSER <", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserLessThanOrEqualTo(Long value) {
            addCriterion("INUSER <=", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserIn(List<Long> values) {
            addCriterion("INUSER in", values, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserNotIn(List<Long> values) {
            addCriterion("INUSER not in", values, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserBetween(Long value1, Long value2) {
            addCriterion("INUSER between", value1, value2, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserNotBetween(Long value1, Long value2) {
            addCriterion("INUSER not between", value1, value2, "inuser");
            return (Criteria) this;
        }

        public Criteria andIntimeIsNull() {
            addCriterion("INTIME is null");
            return (Criteria) this;
        }

        public Criteria andIntimeIsNotNull() {
            addCriterion("INTIME is not null");
            return (Criteria) this;
        }

        public Criteria andIntimeEqualTo(Date value) {
            addCriterion("INTIME =", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotEqualTo(Date value) {
            addCriterion("INTIME <>", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThan(Date value) {
            addCriterion("INTIME >", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("INTIME >=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThan(Date value) {
            addCriterion("INTIME <", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThanOrEqualTo(Date value) {
            addCriterion("INTIME <=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeIn(List<Date> values) {
            addCriterion("INTIME in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotIn(List<Date> values) {
            addCriterion("INTIME not in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeBetween(Date value1, Date value2) {
            addCriterion("INTIME between", value1, value2, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotBetween(Date value1, Date value2) {
            addCriterion("INTIME not between", value1, value2, "intime");
            return (Criteria) this;
        }

        public Criteria andNotesIsNull() {
            addCriterion("NOTES is null");
            return (Criteria) this;
        }

        public Criteria andNotesIsNotNull() {
            addCriterion("NOTES is not null");
            return (Criteria) this;
        }

        public Criteria andNotesEqualTo(String value) {
            addCriterion("NOTES =", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotEqualTo(String value) {
            addCriterion("NOTES <>", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThan(String value) {
            addCriterion("NOTES >", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThanOrEqualTo(String value) {
            addCriterion("NOTES >=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThan(String value) {
            addCriterion("NOTES <", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThanOrEqualTo(String value) {
            addCriterion("NOTES <=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLike(String value) {
            addCriterion("NOTES like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotLike(String value) {
            addCriterion("NOTES not like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesIn(List<String> values) {
            addCriterion("NOTES in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotIn(List<String> values) {
            addCriterion("NOTES not in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesBetween(String value1, String value2) {
            addCriterion("NOTES between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotBetween(String value1, String value2) {
            addCriterion("NOTES not between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("REMARKS =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("REMARKS >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("REMARKS <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("REMARKS like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("REMARKS not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("REMARKS in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRiskverIsNull() {
            addCriterion("RISKVER is null");
            return (Criteria) this;
        }

        public Criteria andRiskverIsNotNull() {
            addCriterion("RISKVER is not null");
            return (Criteria) this;
        }

        public Criteria andRiskverEqualTo(String value) {
            addCriterion("RISKVER =", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverNotEqualTo(String value) {
            addCriterion("RISKVER <>", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverGreaterThan(String value) {
            addCriterion("RISKVER >", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverGreaterThanOrEqualTo(String value) {
            addCriterion("RISKVER >=", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverLessThan(String value) {
            addCriterion("RISKVER <", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverLessThanOrEqualTo(String value) {
            addCriterion("RISKVER <=", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverLike(String value) {
            addCriterion("RISKVER like", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverNotLike(String value) {
            addCriterion("RISKVER not like", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverIn(List<String> values) {
            addCriterion("RISKVER in", values, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverNotIn(List<String> values) {
            addCriterion("RISKVER not in", values, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverBetween(String value1, String value2) {
            addCriterion("RISKVER between", value1, value2, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverNotBetween(String value1, String value2) {
            addCriterion("RISKVER not between", value1, value2, "riskver");
            return (Criteria) this;
        }

        public Criteria andStexaUserIsNull() {
            addCriterion("STEXA_USER is null");
            return (Criteria) this;
        }

        public Criteria andStexaUserIsNotNull() {
            addCriterion("STEXA_USER is not null");
            return (Criteria) this;
        }

        public Criteria andStexaUserEqualTo(Long value) {
            addCriterion("STEXA_USER =", value, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserNotEqualTo(Long value) {
            addCriterion("STEXA_USER <>", value, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserGreaterThan(Long value) {
            addCriterion("STEXA_USER >", value, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserGreaterThanOrEqualTo(Long value) {
            addCriterion("STEXA_USER >=", value, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserLessThan(Long value) {
            addCriterion("STEXA_USER <", value, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserLessThanOrEqualTo(Long value) {
            addCriterion("STEXA_USER <=", value, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserIn(List<Long> values) {
            addCriterion("STEXA_USER in", values, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserNotIn(List<Long> values) {
            addCriterion("STEXA_USER not in", values, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserBetween(Long value1, Long value2) {
            addCriterion("STEXA_USER between", value1, value2, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserNotBetween(Long value1, Long value2) {
            addCriterion("STEXA_USER not between", value1, value2, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaTimeIsNull() {
            addCriterion("STEXA_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStexaTimeIsNotNull() {
            addCriterion("STEXA_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStexaTimeEqualTo(Date value) {
            addCriterion("STEXA_TIME =", value, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeNotEqualTo(Date value) {
            addCriterion("STEXA_TIME <>", value, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeGreaterThan(Date value) {
            addCriterion("STEXA_TIME >", value, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STEXA_TIME >=", value, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeLessThan(Date value) {
            addCriterion("STEXA_TIME <", value, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeLessThanOrEqualTo(Date value) {
            addCriterion("STEXA_TIME <=", value, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeIn(List<Date> values) {
            addCriterion("STEXA_TIME in", values, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeNotIn(List<Date> values) {
            addCriterion("STEXA_TIME not in", values, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeBetween(Date value1, Date value2) {
            addCriterion("STEXA_TIME between", value1, value2, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeNotBetween(Date value1, Date value2) {
            addCriterion("STEXA_TIME not between", value1, value2, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaOptIsNull() {
            addCriterion("STEXA_OPT is null");
            return (Criteria) this;
        }

        public Criteria andStexaOptIsNotNull() {
            addCriterion("STEXA_OPT is not null");
            return (Criteria) this;
        }

        public Criteria andStexaOptEqualTo(String value) {
            addCriterion("STEXA_OPT =", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptNotEqualTo(String value) {
            addCriterion("STEXA_OPT <>", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptGreaterThan(String value) {
            addCriterion("STEXA_OPT >", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptGreaterThanOrEqualTo(String value) {
            addCriterion("STEXA_OPT >=", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptLessThan(String value) {
            addCriterion("STEXA_OPT <", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptLessThanOrEqualTo(String value) {
            addCriterion("STEXA_OPT <=", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptLike(String value) {
            addCriterion("STEXA_OPT like", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptNotLike(String value) {
            addCriterion("STEXA_OPT not like", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptIn(List<String> values) {
            addCriterion("STEXA_OPT in", values, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptNotIn(List<String> values) {
            addCriterion("STEXA_OPT not in", values, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptBetween(String value1, String value2) {
            addCriterion("STEXA_OPT between", value1, value2, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptNotBetween(String value1, String value2) {
            addCriterion("STEXA_OPT not between", value1, value2, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserIsNull() {
            addCriterion("CVLEXA_USER is null");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserIsNotNull() {
            addCriterion("CVLEXA_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserEqualTo(Long value) {
            addCriterion("CVLEXA_USER =", value, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserNotEqualTo(Long value) {
            addCriterion("CVLEXA_USER <>", value, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserGreaterThan(Long value) {
            addCriterion("CVLEXA_USER >", value, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserGreaterThanOrEqualTo(Long value) {
            addCriterion("CVLEXA_USER >=", value, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserLessThan(Long value) {
            addCriterion("CVLEXA_USER <", value, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserLessThanOrEqualTo(Long value) {
            addCriterion("CVLEXA_USER <=", value, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserIn(List<Long> values) {
            addCriterion("CVLEXA_USER in", values, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserNotIn(List<Long> values) {
            addCriterion("CVLEXA_USER not in", values, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserBetween(Long value1, Long value2) {
            addCriterion("CVLEXA_USER between", value1, value2, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserNotBetween(Long value1, Long value2) {
            addCriterion("CVLEXA_USER not between", value1, value2, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeIsNull() {
            addCriterion("CVLEXA_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeIsNotNull() {
            addCriterion("CVLEXA_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeEqualTo(Date value) {
            addCriterion("CVLEXA_TIME =", value, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeNotEqualTo(Date value) {
            addCriterion("CVLEXA_TIME <>", value, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeGreaterThan(Date value) {
            addCriterion("CVLEXA_TIME >", value, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CVLEXA_TIME >=", value, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeLessThan(Date value) {
            addCriterion("CVLEXA_TIME <", value, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeLessThanOrEqualTo(Date value) {
            addCriterion("CVLEXA_TIME <=", value, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeIn(List<Date> values) {
            addCriterion("CVLEXA_TIME in", values, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeNotIn(List<Date> values) {
            addCriterion("CVLEXA_TIME not in", values, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeBetween(Date value1, Date value2) {
            addCriterion("CVLEXA_TIME between", value1, value2, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeNotBetween(Date value1, Date value2) {
            addCriterion("CVLEXA_TIME not between", value1, value2, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptIsNull() {
            addCriterion("CVLEXA_OPT is null");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptIsNotNull() {
            addCriterion("CVLEXA_OPT is not null");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptEqualTo(String value) {
            addCriterion("CVLEXA_OPT =", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptNotEqualTo(String value) {
            addCriterion("CVLEXA_OPT <>", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptGreaterThan(String value) {
            addCriterion("CVLEXA_OPT >", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptGreaterThanOrEqualTo(String value) {
            addCriterion("CVLEXA_OPT >=", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptLessThan(String value) {
            addCriterion("CVLEXA_OPT <", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptLessThanOrEqualTo(String value) {
            addCriterion("CVLEXA_OPT <=", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptLike(String value) {
            addCriterion("CVLEXA_OPT like", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptNotLike(String value) {
            addCriterion("CVLEXA_OPT not like", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptIn(List<String> values) {
            addCriterion("CVLEXA_OPT in", values, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptNotIn(List<String> values) {
            addCriterion("CVLEXA_OPT not in", values, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptBetween(String value1, String value2) {
            addCriterion("CVLEXA_OPT between", value1, value2, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptNotBetween(String value1, String value2) {
            addCriterion("CVLEXA_OPT not between", value1, value2, "cvlexaOpt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}