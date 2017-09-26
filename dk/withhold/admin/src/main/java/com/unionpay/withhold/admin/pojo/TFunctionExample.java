package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TFunctionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFunctionExample() {
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

        public Criteria andFunctIdIsNull() {
            addCriterion("FUNCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andFunctIdIsNotNull() {
            addCriterion("FUNCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFunctIdEqualTo(Long value) {
            addCriterion("FUNCT_ID =", value, "functId");
            return (Criteria) this;
        }

        public Criteria andFunctIdNotEqualTo(Long value) {
            addCriterion("FUNCT_ID <>", value, "functId");
            return (Criteria) this;
        }

        public Criteria andFunctIdGreaterThan(Long value) {
            addCriterion("FUNCT_ID >", value, "functId");
            return (Criteria) this;
        }

        public Criteria andFunctIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FUNCT_ID >=", value, "functId");
            return (Criteria) this;
        }

        public Criteria andFunctIdLessThan(Long value) {
            addCriterion("FUNCT_ID <", value, "functId");
            return (Criteria) this;
        }

        public Criteria andFunctIdLessThanOrEqualTo(Long value) {
            addCriterion("FUNCT_ID <=", value, "functId");
            return (Criteria) this;
        }

        public Criteria andFunctIdIn(List<Long> values) {
            addCriterion("FUNCT_ID in", values, "functId");
            return (Criteria) this;
        }

        public Criteria andFunctIdNotIn(List<Long> values) {
            addCriterion("FUNCT_ID not in", values, "functId");
            return (Criteria) this;
        }

        public Criteria andFunctIdBetween(Long value1, Long value2) {
            addCriterion("FUNCT_ID between", value1, value2, "functId");
            return (Criteria) this;
        }

        public Criteria andFunctIdNotBetween(Long value1, Long value2) {
            addCriterion("FUNCT_ID not between", value1, value2, "functId");
            return (Criteria) this;
        }

        public Criteria andFunctNameIsNull() {
            addCriterion("FUNCT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFunctNameIsNotNull() {
            addCriterion("FUNCT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFunctNameEqualTo(String value) {
            addCriterion("FUNCT_NAME =", value, "functName");
            return (Criteria) this;
        }

        public Criteria andFunctNameNotEqualTo(String value) {
            addCriterion("FUNCT_NAME <>", value, "functName");
            return (Criteria) this;
        }

        public Criteria andFunctNameGreaterThan(String value) {
            addCriterion("FUNCT_NAME >", value, "functName");
            return (Criteria) this;
        }

        public Criteria andFunctNameGreaterThanOrEqualTo(String value) {
            addCriterion("FUNCT_NAME >=", value, "functName");
            return (Criteria) this;
        }

        public Criteria andFunctNameLessThan(String value) {
            addCriterion("FUNCT_NAME <", value, "functName");
            return (Criteria) this;
        }

        public Criteria andFunctNameLessThanOrEqualTo(String value) {
            addCriterion("FUNCT_NAME <=", value, "functName");
            return (Criteria) this;
        }

        public Criteria andFunctNameLike(String value) {
            addCriterion("FUNCT_NAME like", value, "functName");
            return (Criteria) this;
        }

        public Criteria andFunctNameNotLike(String value) {
            addCriterion("FUNCT_NAME not like", value, "functName");
            return (Criteria) this;
        }

        public Criteria andFunctNameIn(List<String> values) {
            addCriterion("FUNCT_NAME in", values, "functName");
            return (Criteria) this;
        }

        public Criteria andFunctNameNotIn(List<String> values) {
            addCriterion("FUNCT_NAME not in", values, "functName");
            return (Criteria) this;
        }

        public Criteria andFunctNameBetween(String value1, String value2) {
            addCriterion("FUNCT_NAME between", value1, value2, "functName");
            return (Criteria) this;
        }

        public Criteria andFunctNameNotBetween(String value1, String value2) {
            addCriterion("FUNCT_NAME not between", value1, value2, "functName");
            return (Criteria) this;
        }

        public Criteria andFunctOrderIsNull() {
            addCriterion("FUNCT_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andFunctOrderIsNotNull() {
            addCriterion("FUNCT_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andFunctOrderEqualTo(Long value) {
            addCriterion("FUNCT_ORDER =", value, "functOrder");
            return (Criteria) this;
        }

        public Criteria andFunctOrderNotEqualTo(Long value) {
            addCriterion("FUNCT_ORDER <>", value, "functOrder");
            return (Criteria) this;
        }

        public Criteria andFunctOrderGreaterThan(Long value) {
            addCriterion("FUNCT_ORDER >", value, "functOrder");
            return (Criteria) this;
        }

        public Criteria andFunctOrderGreaterThanOrEqualTo(Long value) {
            addCriterion("FUNCT_ORDER >=", value, "functOrder");
            return (Criteria) this;
        }

        public Criteria andFunctOrderLessThan(Long value) {
            addCriterion("FUNCT_ORDER <", value, "functOrder");
            return (Criteria) this;
        }

        public Criteria andFunctOrderLessThanOrEqualTo(Long value) {
            addCriterion("FUNCT_ORDER <=", value, "functOrder");
            return (Criteria) this;
        }

        public Criteria andFunctOrderIn(List<Long> values) {
            addCriterion("FUNCT_ORDER in", values, "functOrder");
            return (Criteria) this;
        }

        public Criteria andFunctOrderNotIn(List<Long> values) {
            addCriterion("FUNCT_ORDER not in", values, "functOrder");
            return (Criteria) this;
        }

        public Criteria andFunctOrderBetween(Long value1, Long value2) {
            addCriterion("FUNCT_ORDER between", value1, value2, "functOrder");
            return (Criteria) this;
        }

        public Criteria andFunctOrderNotBetween(Long value1, Long value2) {
            addCriterion("FUNCT_ORDER not between", value1, value2, "functOrder");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("PARENT_ID =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("PARENT_ID <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("PARENT_ID >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ID >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("PARENT_ID <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ID <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("PARENT_ID like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("PARENT_ID not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("PARENT_ID in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("PARENT_ID not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("PARENT_ID between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_ID not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("ICON is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("ICON is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("ICON =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("ICON <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("ICON >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("ICON >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("ICON <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("ICON <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("ICON like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("ICON not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("ICON in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("ICON not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("ICON between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("ICON not between", value1, value2, "icon");
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

        public Criteria andLevelIdIsNull() {
            addCriterion("LEVEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andLevelIdIsNotNull() {
            addCriterion("LEVEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLevelIdEqualTo(Short value) {
            addCriterion("LEVEL_ID =", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotEqualTo(Short value) {
            addCriterion("LEVEL_ID <>", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdGreaterThan(Short value) {
            addCriterion("LEVEL_ID >", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdGreaterThanOrEqualTo(Short value) {
            addCriterion("LEVEL_ID >=", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdLessThan(Short value) {
            addCriterion("LEVEL_ID <", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdLessThanOrEqualTo(Short value) {
            addCriterion("LEVEL_ID <=", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdIn(List<Short> values) {
            addCriterion("LEVEL_ID in", values, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotIn(List<Short> values) {
            addCriterion("LEVEL_ID not in", values, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdBetween(Short value1, Short value2) {
            addCriterion("LEVEL_ID between", value1, value2, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotBetween(Short value1, Short value2) {
            addCriterion("LEVEL_ID not between", value1, value2, "levelId");
            return (Criteria) this;
        }

        public Criteria andLeafnodeIsNull() {
            addCriterion("LEAFNODE is null");
            return (Criteria) this;
        }

        public Criteria andLeafnodeIsNotNull() {
            addCriterion("LEAFNODE is not null");
            return (Criteria) this;
        }

        public Criteria andLeafnodeEqualTo(String value) {
            addCriterion("LEAFNODE =", value, "leafnode");
            return (Criteria) this;
        }

        public Criteria andLeafnodeNotEqualTo(String value) {
            addCriterion("LEAFNODE <>", value, "leafnode");
            return (Criteria) this;
        }

        public Criteria andLeafnodeGreaterThan(String value) {
            addCriterion("LEAFNODE >", value, "leafnode");
            return (Criteria) this;
        }

        public Criteria andLeafnodeGreaterThanOrEqualTo(String value) {
            addCriterion("LEAFNODE >=", value, "leafnode");
            return (Criteria) this;
        }

        public Criteria andLeafnodeLessThan(String value) {
            addCriterion("LEAFNODE <", value, "leafnode");
            return (Criteria) this;
        }

        public Criteria andLeafnodeLessThanOrEqualTo(String value) {
            addCriterion("LEAFNODE <=", value, "leafnode");
            return (Criteria) this;
        }

        public Criteria andLeafnodeLike(String value) {
            addCriterion("LEAFNODE like", value, "leafnode");
            return (Criteria) this;
        }

        public Criteria andLeafnodeNotLike(String value) {
            addCriterion("LEAFNODE not like", value, "leafnode");
            return (Criteria) this;
        }

        public Criteria andLeafnodeIn(List<String> values) {
            addCriterion("LEAFNODE in", values, "leafnode");
            return (Criteria) this;
        }

        public Criteria andLeafnodeNotIn(List<String> values) {
            addCriterion("LEAFNODE not in", values, "leafnode");
            return (Criteria) this;
        }

        public Criteria andLeafnodeBetween(String value1, String value2) {
            addCriterion("LEAFNODE between", value1, value2, "leafnode");
            return (Criteria) this;
        }

        public Criteria andLeafnodeNotBetween(String value1, String value2) {
            addCriterion("LEAFNODE not between", value1, value2, "leafnode");
            return (Criteria) this;
        }

        public Criteria andSysFlagIsNull() {
            addCriterion("SYS_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSysFlagIsNotNull() {
            addCriterion("SYS_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSysFlagEqualTo(String value) {
            addCriterion("SYS_FLAG =", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotEqualTo(String value) {
            addCriterion("SYS_FLAG <>", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagGreaterThan(String value) {
            addCriterion("SYS_FLAG >", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_FLAG >=", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagLessThan(String value) {
            addCriterion("SYS_FLAG <", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagLessThanOrEqualTo(String value) {
            addCriterion("SYS_FLAG <=", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagLike(String value) {
            addCriterion("SYS_FLAG like", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotLike(String value) {
            addCriterion("SYS_FLAG not like", value, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagIn(List<String> values) {
            addCriterion("SYS_FLAG in", values, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotIn(List<String> values) {
            addCriterion("SYS_FLAG not in", values, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagBetween(String value1, String value2) {
            addCriterion("SYS_FLAG between", value1, value2, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andSysFlagNotBetween(String value1, String value2) {
            addCriterion("SYS_FLAG not between", value1, value2, "sysFlag");
            return (Criteria) this;
        }

        public Criteria andFunctTypeIsNull() {
            addCriterion("FUNCT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFunctTypeIsNotNull() {
            addCriterion("FUNCT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFunctTypeEqualTo(Short value) {
            addCriterion("FUNCT_TYPE =", value, "functType");
            return (Criteria) this;
        }

        public Criteria andFunctTypeNotEqualTo(Short value) {
            addCriterion("FUNCT_TYPE <>", value, "functType");
            return (Criteria) this;
        }

        public Criteria andFunctTypeGreaterThan(Short value) {
            addCriterion("FUNCT_TYPE >", value, "functType");
            return (Criteria) this;
        }

        public Criteria andFunctTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("FUNCT_TYPE >=", value, "functType");
            return (Criteria) this;
        }

        public Criteria andFunctTypeLessThan(Short value) {
            addCriterion("FUNCT_TYPE <", value, "functType");
            return (Criteria) this;
        }

        public Criteria andFunctTypeLessThanOrEqualTo(Short value) {
            addCriterion("FUNCT_TYPE <=", value, "functType");
            return (Criteria) this;
        }

        public Criteria andFunctTypeIn(List<Short> values) {
            addCriterion("FUNCT_TYPE in", values, "functType");
            return (Criteria) this;
        }

        public Criteria andFunctTypeNotIn(List<Short> values) {
            addCriterion("FUNCT_TYPE not in", values, "functType");
            return (Criteria) this;
        }

        public Criteria andFunctTypeBetween(Short value1, Short value2) {
            addCriterion("FUNCT_TYPE between", value1, value2, "functType");
            return (Criteria) this;
        }

        public Criteria andFunctTypeNotBetween(Short value1, Short value2) {
            addCriterion("FUNCT_TYPE not between", value1, value2, "functType");
            return (Criteria) this;
        }

        public Criteria andIsadminIsNull() {
            addCriterion("ISADMIN is null");
            return (Criteria) this;
        }

        public Criteria andIsadminIsNotNull() {
            addCriterion("ISADMIN is not null");
            return (Criteria) this;
        }

        public Criteria andIsadminEqualTo(String value) {
            addCriterion("ISADMIN =", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminNotEqualTo(String value) {
            addCriterion("ISADMIN <>", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminGreaterThan(String value) {
            addCriterion("ISADMIN >", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminGreaterThanOrEqualTo(String value) {
            addCriterion("ISADMIN >=", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminLessThan(String value) {
            addCriterion("ISADMIN <", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminLessThanOrEqualTo(String value) {
            addCriterion("ISADMIN <=", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminLike(String value) {
            addCriterion("ISADMIN like", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminNotLike(String value) {
            addCriterion("ISADMIN not like", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminIn(List<String> values) {
            addCriterion("ISADMIN in", values, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminNotIn(List<String> values) {
            addCriterion("ISADMIN not in", values, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminBetween(String value1, String value2) {
            addCriterion("ISADMIN between", value1, value2, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminNotBetween(String value1, String value2) {
            addCriterion("ISADMIN not between", value1, value2, "isadmin");
            return (Criteria) this;
        }

        public Criteria andMoveSortIsNull() {
            addCriterion("MOVE_SORT is null");
            return (Criteria) this;
        }

        public Criteria andMoveSortIsNotNull() {
            addCriterion("MOVE_SORT is not null");
            return (Criteria) this;
        }

        public Criteria andMoveSortEqualTo(String value) {
            addCriterion("MOVE_SORT =", value, "moveSort");
            return (Criteria) this;
        }

        public Criteria andMoveSortNotEqualTo(String value) {
            addCriterion("MOVE_SORT <>", value, "moveSort");
            return (Criteria) this;
        }

        public Criteria andMoveSortGreaterThan(String value) {
            addCriterion("MOVE_SORT >", value, "moveSort");
            return (Criteria) this;
        }

        public Criteria andMoveSortGreaterThanOrEqualTo(String value) {
            addCriterion("MOVE_SORT >=", value, "moveSort");
            return (Criteria) this;
        }

        public Criteria andMoveSortLessThan(String value) {
            addCriterion("MOVE_SORT <", value, "moveSort");
            return (Criteria) this;
        }

        public Criteria andMoveSortLessThanOrEqualTo(String value) {
            addCriterion("MOVE_SORT <=", value, "moveSort");
            return (Criteria) this;
        }

        public Criteria andMoveSortLike(String value) {
            addCriterion("MOVE_SORT like", value, "moveSort");
            return (Criteria) this;
        }

        public Criteria andMoveSortNotLike(String value) {
            addCriterion("MOVE_SORT not like", value, "moveSort");
            return (Criteria) this;
        }

        public Criteria andMoveSortIn(List<String> values) {
            addCriterion("MOVE_SORT in", values, "moveSort");
            return (Criteria) this;
        }

        public Criteria andMoveSortNotIn(List<String> values) {
            addCriterion("MOVE_SORT not in", values, "moveSort");
            return (Criteria) this;
        }

        public Criteria andMoveSortBetween(String value1, String value2) {
            addCriterion("MOVE_SORT between", value1, value2, "moveSort");
            return (Criteria) this;
        }

        public Criteria andMoveSortNotBetween(String value1, String value2) {
            addCriterion("MOVE_SORT not between", value1, value2, "moveSort");
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