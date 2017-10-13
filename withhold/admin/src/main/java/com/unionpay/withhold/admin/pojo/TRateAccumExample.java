package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TRateAccumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRateAccumExample() {
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

        public Criteria andRateIdIsNull() {
            addCriterion("RATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRateIdIsNotNull() {
            addCriterion("RATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRateIdEqualTo(Integer value) {
            addCriterion("RATE_ID =", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdNotEqualTo(Integer value) {
            addCriterion("RATE_ID <>", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdGreaterThan(Integer value) {
            addCriterion("RATE_ID >", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RATE_ID >=", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdLessThan(Integer value) {
            addCriterion("RATE_ID <", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdLessThanOrEqualTo(Integer value) {
            addCriterion("RATE_ID <=", value, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdIn(List<Integer> values) {
            addCriterion("RATE_ID in", values, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdNotIn(List<Integer> values) {
            addCriterion("RATE_ID not in", values, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdBetween(Integer value1, Integer value2) {
            addCriterion("RATE_ID between", value1, value2, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RATE_ID not between", value1, value2, "rateId");
            return (Criteria) this;
        }

        public Criteria andRateDescIsNull() {
            addCriterion("RATE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andRateDescIsNotNull() {
            addCriterion("RATE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andRateDescEqualTo(String value) {
            addCriterion("RATE_DESC =", value, "rateDesc");
            return (Criteria) this;
        }

        public Criteria andRateDescNotEqualTo(String value) {
            addCriterion("RATE_DESC <>", value, "rateDesc");
            return (Criteria) this;
        }

        public Criteria andRateDescGreaterThan(String value) {
            addCriterion("RATE_DESC >", value, "rateDesc");
            return (Criteria) this;
        }

        public Criteria andRateDescGreaterThanOrEqualTo(String value) {
            addCriterion("RATE_DESC >=", value, "rateDesc");
            return (Criteria) this;
        }

        public Criteria andRateDescLessThan(String value) {
            addCriterion("RATE_DESC <", value, "rateDesc");
            return (Criteria) this;
        }

        public Criteria andRateDescLessThanOrEqualTo(String value) {
            addCriterion("RATE_DESC <=", value, "rateDesc");
            return (Criteria) this;
        }

        public Criteria andRateDescLike(String value) {
            addCriterion("RATE_DESC like", value, "rateDesc");
            return (Criteria) this;
        }

        public Criteria andRateDescNotLike(String value) {
            addCriterion("RATE_DESC not like", value, "rateDesc");
            return (Criteria) this;
        }

        public Criteria andRateDescIn(List<String> values) {
            addCriterion("RATE_DESC in", values, "rateDesc");
            return (Criteria) this;
        }

        public Criteria andRateDescNotIn(List<String> values) {
            addCriterion("RATE_DESC not in", values, "rateDesc");
            return (Criteria) this;
        }

        public Criteria andRateDescBetween(String value1, String value2) {
            addCriterion("RATE_DESC between", value1, value2, "rateDesc");
            return (Criteria) this;
        }

        public Criteria andRateDescNotBetween(String value1, String value2) {
            addCriterion("RATE_DESC not between", value1, value2, "rateDesc");
            return (Criteria) this;
        }

        public Criteria andRateMethodIsNull() {
            addCriterion("RATE_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andRateMethodIsNotNull() {
            addCriterion("RATE_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andRateMethodEqualTo(String value) {
            addCriterion("RATE_METHOD =", value, "rateMethod");
            return (Criteria) this;
        }

        public Criteria andRateMethodNotEqualTo(String value) {
            addCriterion("RATE_METHOD <>", value, "rateMethod");
            return (Criteria) this;
        }

        public Criteria andRateMethodGreaterThan(String value) {
            addCriterion("RATE_METHOD >", value, "rateMethod");
            return (Criteria) this;
        }

        public Criteria andRateMethodGreaterThanOrEqualTo(String value) {
            addCriterion("RATE_METHOD >=", value, "rateMethod");
            return (Criteria) this;
        }

        public Criteria andRateMethodLessThan(String value) {
            addCriterion("RATE_METHOD <", value, "rateMethod");
            return (Criteria) this;
        }

        public Criteria andRateMethodLessThanOrEqualTo(String value) {
            addCriterion("RATE_METHOD <=", value, "rateMethod");
            return (Criteria) this;
        }

        public Criteria andRateMethodLike(String value) {
            addCriterion("RATE_METHOD like", value, "rateMethod");
            return (Criteria) this;
        }

        public Criteria andRateMethodNotLike(String value) {
            addCriterion("RATE_METHOD not like", value, "rateMethod");
            return (Criteria) this;
        }

        public Criteria andRateMethodIn(List<String> values) {
            addCriterion("RATE_METHOD in", values, "rateMethod");
            return (Criteria) this;
        }

        public Criteria andRateMethodNotIn(List<String> values) {
            addCriterion("RATE_METHOD not in", values, "rateMethod");
            return (Criteria) this;
        }

        public Criteria andRateMethodBetween(String value1, String value2) {
            addCriterion("RATE_METHOD between", value1, value2, "rateMethod");
            return (Criteria) this;
        }

        public Criteria andRateMethodNotBetween(String value1, String value2) {
            addCriterion("RATE_METHOD not between", value1, value2, "rateMethod");
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