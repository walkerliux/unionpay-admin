package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TSpeFeeDetaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSpeFeeDetaExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("TID is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("TID is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(String value) {
            addCriterion("TID =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(String value) {
            addCriterion("TID <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(String value) {
            addCriterion("TID >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(String value) {
            addCriterion("TID >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(String value) {
            addCriterion("TID <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(String value) {
            addCriterion("TID <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLike(String value) {
            addCriterion("TID like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotLike(String value) {
            addCriterion("TID not like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<String> values) {
            addCriterion("TID in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<String> values) {
            addCriterion("TID not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(String value1, String value2) {
            addCriterion("TID between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(String value1, String value2) {
            addCriterion("TID not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andRateIdIsNull() {
            addCriterion("RATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRateIdIsNotNull() {
            addCriterion("RATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRateIdEqualTo(String value) {
            addCriterion("RATE_ID =", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdNotEqualTo(String value) {
            addCriterion("RATE_ID <>", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdGreaterThan(String value) {
            addCriterion("RATE_ID >", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdGreaterThanOrEqualTo(String value) {
            addCriterion("RATE_ID >=", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdLessThan(String value) {
            addCriterion("RATE_ID <", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdLessThanOrEqualTo(String value) {
            addCriterion("RATE_ID <=", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdLike(String value) {
            addCriterion("RATE_ID like", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdNotLike(String value) {
            addCriterion("RATE_ID not like", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdIn(List<String> values) {
            addCriterion("RATE_ID in", values, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdNotIn(List<String> values) {
            addCriterion("RATE_ID not in", values, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdBetween(String value1, String value2) {
            addCriterion("RATE_ID between", value1, value2, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdNotBetween(String value1, String value2) {
            addCriterion("RATE_ID not between", value1, value2, "rateId");
            return (Criteria) this;
        }

        public Criteria andMinfeeIsNull() {
            addCriterion("MINFEE is null");
            return (Criteria) this;
        }

        public Criteria andMinfeeIsNotNull() {
            addCriterion("MINFEE is not null");
            return (Criteria) this;
        }

        public Criteria andMinfeeEqualTo(String value) {
            addCriterion("MINFEE =", value, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeNotEqualTo(String value) {
            addCriterion("MINFEE <>", value, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeGreaterThan(String value) {
            addCriterion("MINFEE >", value, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeGreaterThanOrEqualTo(String value) {
            addCriterion("MINFEE >=", value, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeLessThan(String value) {
            addCriterion("MINFEE <", value, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeLessThanOrEqualTo(String value) {
            addCriterion("MINFEE <=", value, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeLike(String value) {
            addCriterion("MINFEE like", value, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeNotLike(String value) {
            addCriterion("MINFEE not like", value, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeIn(List<String> values) {
            addCriterion("MINFEE in", values, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeNotIn(List<String> values) {
            addCriterion("MINFEE not in", values, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeBetween(String value1, String value2) {
            addCriterion("MINFEE between", value1, value2, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeNotBetween(String value1, String value2) {
            addCriterion("MINFEE not between", value1, value2, "minfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeIsNull() {
            addCriterion("MAXFEE is null");
            return (Criteria) this;
        }

        public Criteria andMaxfeeIsNotNull() {
            addCriterion("MAXFEE is not null");
            return (Criteria) this;
        }

        public Criteria andMaxfeeEqualTo(String value) {
            addCriterion("MAXFEE =", value, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeNotEqualTo(String value) {
            addCriterion("MAXFEE <>", value, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeGreaterThan(String value) {
            addCriterion("MAXFEE >", value, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeGreaterThanOrEqualTo(String value) {
            addCriterion("MAXFEE >=", value, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeLessThan(String value) {
            addCriterion("MAXFEE <", value, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeLessThanOrEqualTo(String value) {
            addCriterion("MAXFEE <=", value, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeLike(String value) {
            addCriterion("MAXFEE like", value, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeNotLike(String value) {
            addCriterion("MAXFEE not like", value, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeIn(List<String> values) {
            addCriterion("MAXFEE in", values, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeNotIn(List<String> values) {
            addCriterion("MAXFEE not in", values, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeBetween(String value1, String value2) {
            addCriterion("MAXFEE between", value1, value2, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeNotBetween(String value1, String value2) {
            addCriterion("MAXFEE not between", value1, value2, "maxfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeIsNull() {
            addCriterion("FIXFEE is null");
            return (Criteria) this;
        }

        public Criteria andFixfeeIsNotNull() {
            addCriterion("FIXFEE is not null");
            return (Criteria) this;
        }

        public Criteria andFixfeeEqualTo(String value) {
            addCriterion("FIXFEE =", value, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeNotEqualTo(String value) {
            addCriterion("FIXFEE <>", value, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeGreaterThan(String value) {
            addCriterion("FIXFEE >", value, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeGreaterThanOrEqualTo(String value) {
            addCriterion("FIXFEE >=", value, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeLessThan(String value) {
            addCriterion("FIXFEE <", value, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeLessThanOrEqualTo(String value) {
            addCriterion("FIXFEE <=", value, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeLike(String value) {
            addCriterion("FIXFEE like", value, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeNotLike(String value) {
            addCriterion("FIXFEE not like", value, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeIn(List<String> values) {
            addCriterion("FIXFEE in", values, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeNotIn(List<String> values) {
            addCriterion("FIXFEE not in", values, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeBetween(String value1, String value2) {
            addCriterion("FIXFEE between", value1, value2, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeNotBetween(String value1, String value2) {
            addCriterion("FIXFEE not between", value1, value2, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFeerateIsNull() {
            addCriterion("FEERATE is null");
            return (Criteria) this;
        }

        public Criteria andFeerateIsNotNull() {
            addCriterion("FEERATE is not null");
            return (Criteria) this;
        }

        public Criteria andFeerateEqualTo(String value) {
            addCriterion("FEERATE =", value, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateNotEqualTo(String value) {
            addCriterion("FEERATE <>", value, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateGreaterThan(String value) {
            addCriterion("FEERATE >", value, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateGreaterThanOrEqualTo(String value) {
            addCriterion("FEERATE >=", value, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateLessThan(String value) {
            addCriterion("FEERATE <", value, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateLessThanOrEqualTo(String value) {
            addCriterion("FEERATE <=", value, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateLike(String value) {
            addCriterion("FEERATE like", value, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateNotLike(String value) {
            addCriterion("FEERATE not like", value, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateIn(List<String> values) {
            addCriterion("FEERATE in", values, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateNotIn(List<String> values) {
            addCriterion("FEERATE not in", values, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateBetween(String value1, String value2) {
            addCriterion("FEERATE between", value1, value2, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateNotBetween(String value1, String value2) {
            addCriterion("FEERATE not between", value1, value2, "feerate");
            return (Criteria) this;
        }

        public Criteria andFunctionIsNull() {
            addCriterion("FUNCTION is null");
            return (Criteria) this;
        }

        public Criteria andFunctionIsNotNull() {
            addCriterion("FUNCTION is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionEqualTo(String value) {
            addCriterion("FUNCTION =", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotEqualTo(String value) {
            addCriterion("FUNCTION <>", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionGreaterThan(String value) {
            addCriterion("FUNCTION >", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("FUNCTION >=", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLessThan(String value) {
            addCriterion("FUNCTION <", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLessThanOrEqualTo(String value) {
            addCriterion("FUNCTION <=", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionLike(String value) {
            addCriterion("FUNCTION like", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotLike(String value) {
            addCriterion("FUNCTION not like", value, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionIn(List<String> values) {
            addCriterion("FUNCTION in", values, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotIn(List<String> values) {
            addCriterion("FUNCTION not in", values, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionBetween(String value1, String value2) {
            addCriterion("FUNCTION between", value1, value2, "function");
            return (Criteria) this;
        }

        public Criteria andFunctionNotBetween(String value1, String value2) {
            addCriterion("FUNCTION not between", value1, value2, "function");
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