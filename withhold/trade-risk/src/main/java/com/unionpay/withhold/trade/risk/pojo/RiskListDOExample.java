package com.unionpay.withhold.trade.risk.pojo;

import java.util.ArrayList;
import java.util.List;

public class RiskListDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiskListDOExample() {
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

        public Criteria andRidIsNull() {
            addCriterion("RID is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("RID is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("RID =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("RID <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("RID >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("RID >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("RID <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("RID <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("RID in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("RID not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("RID between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("RID not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andStrategyIsNull() {
            addCriterion("STRATEGY is null");
            return (Criteria) this;
        }

        public Criteria andStrategyIsNotNull() {
            addCriterion("STRATEGY is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyEqualTo(String value) {
            addCriterion("STRATEGY =", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotEqualTo(String value) {
            addCriterion("STRATEGY <>", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyGreaterThan(String value) {
            addCriterion("STRATEGY >", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyGreaterThanOrEqualTo(String value) {
            addCriterion("STRATEGY >=", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyLessThan(String value) {
            addCriterion("STRATEGY <", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyLessThanOrEqualTo(String value) {
            addCriterion("STRATEGY <=", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyLike(String value) {
            addCriterion("STRATEGY like", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotLike(String value) {
            addCriterion("STRATEGY not like", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyIn(List<String> values) {
            addCriterion("STRATEGY in", values, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotIn(List<String> values) {
            addCriterion("STRATEGY not in", values, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyBetween(String value1, String value2) {
            addCriterion("STRATEGY between", value1, value2, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotBetween(String value1, String value2) {
            addCriterion("STRATEGY not between", value1, value2, "strategy");
            return (Criteria) this;
        }

        public Criteria andOrdersIsNull() {
            addCriterion("ORDERS is null");
            return (Criteria) this;
        }

        public Criteria andOrdersIsNotNull() {
            addCriterion("ORDERS is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersEqualTo(Short value) {
            addCriterion("ORDERS =", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotEqualTo(Short value) {
            addCriterion("ORDERS <>", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersGreaterThan(Short value) {
            addCriterion("ORDERS >", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersGreaterThanOrEqualTo(Short value) {
            addCriterion("ORDERS >=", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersLessThan(Short value) {
            addCriterion("ORDERS <", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersLessThanOrEqualTo(Short value) {
            addCriterion("ORDERS <=", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersIn(List<Short> values) {
            addCriterion("ORDERS in", values, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotIn(List<Short> values) {
            addCriterion("ORDERS not in", values, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersBetween(Short value1, Short value2) {
            addCriterion("ORDERS between", value1, value2, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotBetween(Short value1, Short value2) {
            addCriterion("ORDERS not between", value1, value2, "orders");
            return (Criteria) this;
        }

        public Criteria andExcfncIsNull() {
            addCriterion("EXCFNC is null");
            return (Criteria) this;
        }

        public Criteria andExcfncIsNotNull() {
            addCriterion("EXCFNC is not null");
            return (Criteria) this;
        }

        public Criteria andExcfncEqualTo(String value) {
            addCriterion("EXCFNC =", value, "excfnc");
            return (Criteria) this;
        }

        public Criteria andExcfncNotEqualTo(String value) {
            addCriterion("EXCFNC <>", value, "excfnc");
            return (Criteria) this;
        }

        public Criteria andExcfncGreaterThan(String value) {
            addCriterion("EXCFNC >", value, "excfnc");
            return (Criteria) this;
        }

        public Criteria andExcfncGreaterThanOrEqualTo(String value) {
            addCriterion("EXCFNC >=", value, "excfnc");
            return (Criteria) this;
        }

        public Criteria andExcfncLessThan(String value) {
            addCriterion("EXCFNC <", value, "excfnc");
            return (Criteria) this;
        }

        public Criteria andExcfncLessThanOrEqualTo(String value) {
            addCriterion("EXCFNC <=", value, "excfnc");
            return (Criteria) this;
        }

        public Criteria andExcfncLike(String value) {
            addCriterion("EXCFNC like", value, "excfnc");
            return (Criteria) this;
        }

        public Criteria andExcfncNotLike(String value) {
            addCriterion("EXCFNC not like", value, "excfnc");
            return (Criteria) this;
        }

        public Criteria andExcfncIn(List<String> values) {
            addCriterion("EXCFNC in", values, "excfnc");
            return (Criteria) this;
        }

        public Criteria andExcfncNotIn(List<String> values) {
            addCriterion("EXCFNC not in", values, "excfnc");
            return (Criteria) this;
        }

        public Criteria andExcfncBetween(String value1, String value2) {
            addCriterion("EXCFNC between", value1, value2, "excfnc");
            return (Criteria) this;
        }

        public Criteria andExcfncNotBetween(String value1, String value2) {
            addCriterion("EXCFNC not between", value1, value2, "excfnc");
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

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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