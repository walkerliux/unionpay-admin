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

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("TID =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("TID <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("TID >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("TID >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("TID <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("TID <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("TID in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("TID not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("TID between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
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

        public Criteria andRateIdEqualTo(Long value) {
            addCriterion("RATE_ID =", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdNotEqualTo(Long value) {
            addCriterion("RATE_ID <>", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdGreaterThan(Long value) {
            addCriterion("RATE_ID >", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("RATE_ID >=", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdLessThan(Long value) {
            addCriterion("RATE_ID <", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdLessThanOrEqualTo(Long value) {
            addCriterion("RATE_ID <=", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdIn(List<Long> values) {
            addCriterion("RATE_ID in", values, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdNotIn(List<Long> values) {
            addCriterion("RATE_ID not in", values, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdBetween(Long value1, Long value2) {
            addCriterion("RATE_ID between", value1, value2, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdNotBetween(Long value1, Long value2) {
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

        public Criteria andMinfeeEqualTo(Long value) {
            addCriterion("MINFEE =", value, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeNotEqualTo(Long value) {
            addCriterion("MINFEE <>", value, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeGreaterThan(Long value) {
            addCriterion("MINFEE >", value, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeGreaterThanOrEqualTo(Long value) {
            addCriterion("MINFEE >=", value, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeLessThan(Long value) {
            addCriterion("MINFEE <", value, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeLessThanOrEqualTo(Long value) {
            addCriterion("MINFEE <=", value, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeIn(List<Long> values) {
            addCriterion("MINFEE in", values, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeNotIn(List<Long> values) {
            addCriterion("MINFEE not in", values, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeBetween(Long value1, Long value2) {
            addCriterion("MINFEE between", value1, value2, "minfee");
            return (Criteria) this;
        }

        public Criteria andMinfeeNotBetween(Long value1, Long value2) {
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

        public Criteria andMaxfeeEqualTo(Long value) {
            addCriterion("MAXFEE =", value, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeNotEqualTo(Long value) {
            addCriterion("MAXFEE <>", value, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeGreaterThan(Long value) {
            addCriterion("MAXFEE >", value, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeGreaterThanOrEqualTo(Long value) {
            addCriterion("MAXFEE >=", value, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeLessThan(Long value) {
            addCriterion("MAXFEE <", value, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeLessThanOrEqualTo(Long value) {
            addCriterion("MAXFEE <=", value, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeIn(List<Long> values) {
            addCriterion("MAXFEE in", values, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeNotIn(List<Long> values) {
            addCriterion("MAXFEE not in", values, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeBetween(Long value1, Long value2) {
            addCriterion("MAXFEE between", value1, value2, "maxfee");
            return (Criteria) this;
        }

        public Criteria andMaxfeeNotBetween(Long value1, Long value2) {
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

        public Criteria andFixfeeEqualTo(Long value) {
            addCriterion("FIXFEE =", value, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeNotEqualTo(Long value) {
            addCriterion("FIXFEE <>", value, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeGreaterThan(Long value) {
            addCriterion("FIXFEE >", value, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeGreaterThanOrEqualTo(Long value) {
            addCriterion("FIXFEE >=", value, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeLessThan(Long value) {
            addCriterion("FIXFEE <", value, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeLessThanOrEqualTo(Long value) {
            addCriterion("FIXFEE <=", value, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeIn(List<Long> values) {
            addCriterion("FIXFEE in", values, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeNotIn(List<Long> values) {
            addCriterion("FIXFEE not in", values, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeBetween(Long value1, Long value2) {
            addCriterion("FIXFEE between", value1, value2, "fixfee");
            return (Criteria) this;
        }

        public Criteria andFixfeeNotBetween(Long value1, Long value2) {
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

        public Criteria andFeerateEqualTo(Long value) {
            addCriterion("FEERATE =", value, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateNotEqualTo(Long value) {
            addCriterion("FEERATE <>", value, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateGreaterThan(Long value) {
            addCriterion("FEERATE >", value, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateGreaterThanOrEqualTo(Long value) {
            addCriterion("FEERATE >=", value, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateLessThan(Long value) {
            addCriterion("FEERATE <", value, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateLessThanOrEqualTo(Long value) {
            addCriterion("FEERATE <=", value, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateIn(List<Long> values) {
            addCriterion("FEERATE in", values, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateNotIn(List<Long> values) {
            addCriterion("FEERATE not in", values, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateBetween(Long value1, Long value2) {
            addCriterion("FEERATE between", value1, value2, "feerate");
            return (Criteria) this;
        }

        public Criteria andFeerateNotBetween(Long value1, Long value2) {
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

        public Criteria andNotesIsNull() {
            addCriterion("notes is null");
            return (Criteria) this;
        }

        public Criteria andNotesIsNotNull() {
            addCriterion("notes is not null");
            return (Criteria) this;
        }

        public Criteria andNotesEqualTo(String value) {
            addCriterion("notes =", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotEqualTo(String value) {
            addCriterion("notes <>", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThan(String value) {
            addCriterion("notes >", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThanOrEqualTo(String value) {
            addCriterion("notes >=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThan(String value) {
            addCriterion("notes <", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThanOrEqualTo(String value) {
            addCriterion("notes <=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLike(String value) {
            addCriterion("notes like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotLike(String value) {
            addCriterion("notes not like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesIn(List<String> values) {
            addCriterion("notes in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotIn(List<String> values) {
            addCriterion("notes not in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesBetween(String value1, String value2) {
            addCriterion("notes between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotBetween(String value1, String value2) {
            addCriterion("notes not between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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