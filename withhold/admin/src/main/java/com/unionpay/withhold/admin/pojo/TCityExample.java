package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TCityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCityExample() {
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

        public Criteria andCIdIsNull() {
            addCriterion("C_ID is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("C_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Long value) {
            addCriterion("C_ID =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Long value) {
            addCriterion("C_ID <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Long value) {
            addCriterion("C_ID >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Long value) {
            addCriterion("C_ID >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Long value) {
            addCriterion("C_ID <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Long value) {
            addCriterion("C_ID <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Long> values) {
            addCriterion("C_ID in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Long> values) {
            addCriterion("C_ID not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Long value1, Long value2) {
            addCriterion("C_ID between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Long value1, Long value2) {
            addCriterion("C_ID not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCNameIsNull() {
            addCriterion("C_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCNameIsNotNull() {
            addCriterion("C_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCNameEqualTo(String value) {
            addCriterion("C_NAME =", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotEqualTo(String value) {
            addCriterion("C_NAME <>", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThan(String value) {
            addCriterion("C_NAME >", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThanOrEqualTo(String value) {
            addCriterion("C_NAME >=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThan(String value) {
            addCriterion("C_NAME <", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThanOrEqualTo(String value) {
            addCriterion("C_NAME <=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLike(String value) {
            addCriterion("C_NAME like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotLike(String value) {
            addCriterion("C_NAME not like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameIn(List<String> values) {
            addCriterion("C_NAME in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotIn(List<String> values) {
            addCriterion("C_NAME not in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameBetween(String value1, String value2) {
            addCriterion("C_NAME between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotBetween(String value1, String value2) {
            addCriterion("C_NAME not between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCZcodeIsNull() {
            addCriterion("C_ZCODE is null");
            return (Criteria) this;
        }

        public Criteria andCZcodeIsNotNull() {
            addCriterion("C_ZCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCZcodeEqualTo(String value) {
            addCriterion("C_ZCODE =", value, "cZcode");
            return (Criteria) this;
        }

        public Criteria andCZcodeNotEqualTo(String value) {
            addCriterion("C_ZCODE <>", value, "cZcode");
            return (Criteria) this;
        }

        public Criteria andCZcodeGreaterThan(String value) {
            addCriterion("C_ZCODE >", value, "cZcode");
            return (Criteria) this;
        }

        public Criteria andCZcodeGreaterThanOrEqualTo(String value) {
            addCriterion("C_ZCODE >=", value, "cZcode");
            return (Criteria) this;
        }

        public Criteria andCZcodeLessThan(String value) {
            addCriterion("C_ZCODE <", value, "cZcode");
            return (Criteria) this;
        }

        public Criteria andCZcodeLessThanOrEqualTo(String value) {
            addCriterion("C_ZCODE <=", value, "cZcode");
            return (Criteria) this;
        }

        public Criteria andCZcodeLike(String value) {
            addCriterion("C_ZCODE like", value, "cZcode");
            return (Criteria) this;
        }

        public Criteria andCZcodeNotLike(String value) {
            addCriterion("C_ZCODE not like", value, "cZcode");
            return (Criteria) this;
        }

        public Criteria andCZcodeIn(List<String> values) {
            addCriterion("C_ZCODE in", values, "cZcode");
            return (Criteria) this;
        }

        public Criteria andCZcodeNotIn(List<String> values) {
            addCriterion("C_ZCODE not in", values, "cZcode");
            return (Criteria) this;
        }

        public Criteria andCZcodeBetween(String value1, String value2) {
            addCriterion("C_ZCODE between", value1, value2, "cZcode");
            return (Criteria) this;
        }

        public Criteria andCZcodeNotBetween(String value1, String value2) {
            addCriterion("C_ZCODE not between", value1, value2, "cZcode");
            return (Criteria) this;
        }

        public Criteria andCPcodeIsNull() {
            addCriterion("C_PCODE is null");
            return (Criteria) this;
        }

        public Criteria andCPcodeIsNotNull() {
            addCriterion("C_PCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCPcodeEqualTo(String value) {
            addCriterion("C_PCODE =", value, "cPcode");
            return (Criteria) this;
        }

        public Criteria andCPcodeNotEqualTo(String value) {
            addCriterion("C_PCODE <>", value, "cPcode");
            return (Criteria) this;
        }

        public Criteria andCPcodeGreaterThan(String value) {
            addCriterion("C_PCODE >", value, "cPcode");
            return (Criteria) this;
        }

        public Criteria andCPcodeGreaterThanOrEqualTo(String value) {
            addCriterion("C_PCODE >=", value, "cPcode");
            return (Criteria) this;
        }

        public Criteria andCPcodeLessThan(String value) {
            addCriterion("C_PCODE <", value, "cPcode");
            return (Criteria) this;
        }

        public Criteria andCPcodeLessThanOrEqualTo(String value) {
            addCriterion("C_PCODE <=", value, "cPcode");
            return (Criteria) this;
        }

        public Criteria andCPcodeLike(String value) {
            addCriterion("C_PCODE like", value, "cPcode");
            return (Criteria) this;
        }

        public Criteria andCPcodeNotLike(String value) {
            addCriterion("C_PCODE not like", value, "cPcode");
            return (Criteria) this;
        }

        public Criteria andCPcodeIn(List<String> values) {
            addCriterion("C_PCODE in", values, "cPcode");
            return (Criteria) this;
        }

        public Criteria andCPcodeNotIn(List<String> values) {
            addCriterion("C_PCODE not in", values, "cPcode");
            return (Criteria) this;
        }

        public Criteria andCPcodeBetween(String value1, String value2) {
            addCriterion("C_PCODE between", value1, value2, "cPcode");
            return (Criteria) this;
        }

        public Criteria andCPcodeNotBetween(String value1, String value2) {
            addCriterion("C_PCODE not between", value1, value2, "cPcode");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("P_ID is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("P_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Long value) {
            addCriterion("P_ID =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Long value) {
            addCriterion("P_ID <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Long value) {
            addCriterion("P_ID >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Long value) {
            addCriterion("P_ID >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Long value) {
            addCriterion("P_ID <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Long value) {
            addCriterion("P_ID <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Long> values) {
            addCriterion("P_ID in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Long> values) {
            addCriterion("P_ID not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Long value1, Long value2) {
            addCriterion("P_ID between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Long value1, Long value2) {
            addCriterion("P_ID not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andCCodeIsNull() {
            addCriterion("C_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCCodeIsNotNull() {
            addCriterion("C_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCCodeEqualTo(String value) {
            addCriterion("C_CODE =", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeNotEqualTo(String value) {
            addCriterion("C_CODE <>", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeGreaterThan(String value) {
            addCriterion("C_CODE >", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeGreaterThanOrEqualTo(String value) {
            addCriterion("C_CODE >=", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeLessThan(String value) {
            addCriterion("C_CODE <", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeLessThanOrEqualTo(String value) {
            addCriterion("C_CODE <=", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeLike(String value) {
            addCriterion("C_CODE like", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeNotLike(String value) {
            addCriterion("C_CODE not like", value, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeIn(List<String> values) {
            addCriterion("C_CODE in", values, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeNotIn(List<String> values) {
            addCriterion("C_CODE not in", values, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeBetween(String value1, String value2) {
            addCriterion("C_CODE between", value1, value2, "cCode");
            return (Criteria) this;
        }

        public Criteria andCCodeNotBetween(String value1, String value2) {
            addCriterion("C_CODE not between", value1, value2, "cCode");
            return (Criteria) this;
        }

        public Criteria andXzCodeIsNull() {
            addCriterion("XZ_CODE is null");
            return (Criteria) this;
        }

        public Criteria andXzCodeIsNotNull() {
            addCriterion("XZ_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andXzCodeEqualTo(String value) {
            addCriterion("XZ_CODE =", value, "xzCode");
            return (Criteria) this;
        }

        public Criteria andXzCodeNotEqualTo(String value) {
            addCriterion("XZ_CODE <>", value, "xzCode");
            return (Criteria) this;
        }

        public Criteria andXzCodeGreaterThan(String value) {
            addCriterion("XZ_CODE >", value, "xzCode");
            return (Criteria) this;
        }

        public Criteria andXzCodeGreaterThanOrEqualTo(String value) {
            addCriterion("XZ_CODE >=", value, "xzCode");
            return (Criteria) this;
        }

        public Criteria andXzCodeLessThan(String value) {
            addCriterion("XZ_CODE <", value, "xzCode");
            return (Criteria) this;
        }

        public Criteria andXzCodeLessThanOrEqualTo(String value) {
            addCriterion("XZ_CODE <=", value, "xzCode");
            return (Criteria) this;
        }

        public Criteria andXzCodeLike(String value) {
            addCriterion("XZ_CODE like", value, "xzCode");
            return (Criteria) this;
        }

        public Criteria andXzCodeNotLike(String value) {
            addCriterion("XZ_CODE not like", value, "xzCode");
            return (Criteria) this;
        }

        public Criteria andXzCodeIn(List<String> values) {
            addCriterion("XZ_CODE in", values, "xzCode");
            return (Criteria) this;
        }

        public Criteria andXzCodeNotIn(List<String> values) {
            addCriterion("XZ_CODE not in", values, "xzCode");
            return (Criteria) this;
        }

        public Criteria andXzCodeBetween(String value1, String value2) {
            addCriterion("XZ_CODE between", value1, value2, "xzCode");
            return (Criteria) this;
        }

        public Criteria andXzCodeNotBetween(String value1, String value2) {
            addCriterion("XZ_CODE not between", value1, value2, "xzCode");
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