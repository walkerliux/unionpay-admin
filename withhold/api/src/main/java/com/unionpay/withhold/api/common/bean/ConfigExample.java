package com.unionpay.withhold.api.common.bean;

import java.util.ArrayList;
import java.util.List;

public class ConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConfigExample() {
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

        public Criteria andDkKeyIsNull() {
            addCriterion("dk_key is null");
            return (Criteria) this;
        }

        public Criteria andDkKeyIsNotNull() {
            addCriterion("dk_key is not null");
            return (Criteria) this;
        }

        public Criteria andDkKeyEqualTo(String value) {
            addCriterion("dk_key =", value, "dkKey");
            return (Criteria) this;
        }

        public Criteria andDkKeyNotEqualTo(String value) {
            addCriterion("dk_key <>", value, "dkKey");
            return (Criteria) this;
        }

        public Criteria andDkKeyGreaterThan(String value) {
            addCriterion("dk_key >", value, "dkKey");
            return (Criteria) this;
        }

        public Criteria andDkKeyGreaterThanOrEqualTo(String value) {
            addCriterion("dk_key >=", value, "dkKey");
            return (Criteria) this;
        }

        public Criteria andDkKeyLessThan(String value) {
            addCriterion("dk_key <", value, "dkKey");
            return (Criteria) this;
        }

        public Criteria andDkKeyLessThanOrEqualTo(String value) {
            addCriterion("dk_key <=", value, "dkKey");
            return (Criteria) this;
        }

        public Criteria andDkKeyLike(String value) {
            addCriterion("dk_key like", value, "dkKey");
            return (Criteria) this;
        }

        public Criteria andDkKeyNotLike(String value) {
            addCriterion("dk_key not like", value, "dkKey");
            return (Criteria) this;
        }

        public Criteria andDkKeyIn(List<String> values) {
            addCriterion("dk_key in", values, "dkKey");
            return (Criteria) this;
        }

        public Criteria andDkKeyNotIn(List<String> values) {
            addCriterion("dk_key not in", values, "dkKey");
            return (Criteria) this;
        }

        public Criteria andDkKeyBetween(String value1, String value2) {
            addCriterion("dk_key between", value1, value2, "dkKey");
            return (Criteria) this;
        }

        public Criteria andDkKeyNotBetween(String value1, String value2) {
            addCriterion("dk_key not between", value1, value2, "dkKey");
            return (Criteria) this;
        }

        public Criteria andDkValueIsNull() {
            addCriterion("dk_value is null");
            return (Criteria) this;
        }

        public Criteria andDkValueIsNotNull() {
            addCriterion("dk_value is not null");
            return (Criteria) this;
        }

        public Criteria andDkValueEqualTo(String value) {
            addCriterion("dk_value =", value, "dkValue");
            return (Criteria) this;
        }

        public Criteria andDkValueNotEqualTo(String value) {
            addCriterion("dk_value <>", value, "dkValue");
            return (Criteria) this;
        }

        public Criteria andDkValueGreaterThan(String value) {
            addCriterion("dk_value >", value, "dkValue");
            return (Criteria) this;
        }

        public Criteria andDkValueGreaterThanOrEqualTo(String value) {
            addCriterion("dk_value >=", value, "dkValue");
            return (Criteria) this;
        }

        public Criteria andDkValueLessThan(String value) {
            addCriterion("dk_value <", value, "dkValue");
            return (Criteria) this;
        }

        public Criteria andDkValueLessThanOrEqualTo(String value) {
            addCriterion("dk_value <=", value, "dkValue");
            return (Criteria) this;
        }

        public Criteria andDkValueLike(String value) {
            addCriterion("dk_value like", value, "dkValue");
            return (Criteria) this;
        }

        public Criteria andDkValueNotLike(String value) {
            addCriterion("dk_value not like", value, "dkValue");
            return (Criteria) this;
        }

        public Criteria andDkValueIn(List<String> values) {
            addCriterion("dk_value in", values, "dkValue");
            return (Criteria) this;
        }

        public Criteria andDkValueNotIn(List<String> values) {
            addCriterion("dk_value not in", values, "dkValue");
            return (Criteria) this;
        }

        public Criteria andDkValueBetween(String value1, String value2) {
            addCriterion("dk_value between", value1, value2, "dkValue");
            return (Criteria) this;
        }

        public Criteria andDkValueNotBetween(String value1, String value2) {
            addCriterion("dk_value not between", value1, value2, "dkValue");
            return (Criteria) this;
        }

        public Criteria andDkNameIsNull() {
            addCriterion("dk_name is null");
            return (Criteria) this;
        }

        public Criteria andDkNameIsNotNull() {
            addCriterion("dk_name is not null");
            return (Criteria) this;
        }

        public Criteria andDkNameEqualTo(String value) {
            addCriterion("dk_name =", value, "dkName");
            return (Criteria) this;
        }

        public Criteria andDkNameNotEqualTo(String value) {
            addCriterion("dk_name <>", value, "dkName");
            return (Criteria) this;
        }

        public Criteria andDkNameGreaterThan(String value) {
            addCriterion("dk_name >", value, "dkName");
            return (Criteria) this;
        }

        public Criteria andDkNameGreaterThanOrEqualTo(String value) {
            addCriterion("dk_name >=", value, "dkName");
            return (Criteria) this;
        }

        public Criteria andDkNameLessThan(String value) {
            addCriterion("dk_name <", value, "dkName");
            return (Criteria) this;
        }

        public Criteria andDkNameLessThanOrEqualTo(String value) {
            addCriterion("dk_name <=", value, "dkName");
            return (Criteria) this;
        }

        public Criteria andDkNameLike(String value) {
            addCriterion("dk_name like", value, "dkName");
            return (Criteria) this;
        }

        public Criteria andDkNameNotLike(String value) {
            addCriterion("dk_name not like", value, "dkName");
            return (Criteria) this;
        }

        public Criteria andDkNameIn(List<String> values) {
            addCriterion("dk_name in", values, "dkName");
            return (Criteria) this;
        }

        public Criteria andDkNameNotIn(List<String> values) {
            addCriterion("dk_name not in", values, "dkName");
            return (Criteria) this;
        }

        public Criteria andDkNameBetween(String value1, String value2) {
            addCriterion("dk_name between", value1, value2, "dkName");
            return (Criteria) this;
        }

        public Criteria andDkNameNotBetween(String value1, String value2) {
            addCriterion("dk_name not between", value1, value2, "dkName");
            return (Criteria) this;
        }

        public Criteria andDkDescIsNull() {
            addCriterion("dk_desc is null");
            return (Criteria) this;
        }

        public Criteria andDkDescIsNotNull() {
            addCriterion("dk_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDkDescEqualTo(String value) {
            addCriterion("dk_desc =", value, "dkDesc");
            return (Criteria) this;
        }

        public Criteria andDkDescNotEqualTo(String value) {
            addCriterion("dk_desc <>", value, "dkDesc");
            return (Criteria) this;
        }

        public Criteria andDkDescGreaterThan(String value) {
            addCriterion("dk_desc >", value, "dkDesc");
            return (Criteria) this;
        }

        public Criteria andDkDescGreaterThanOrEqualTo(String value) {
            addCriterion("dk_desc >=", value, "dkDesc");
            return (Criteria) this;
        }

        public Criteria andDkDescLessThan(String value) {
            addCriterion("dk_desc <", value, "dkDesc");
            return (Criteria) this;
        }

        public Criteria andDkDescLessThanOrEqualTo(String value) {
            addCriterion("dk_desc <=", value, "dkDesc");
            return (Criteria) this;
        }

        public Criteria andDkDescLike(String value) {
            addCriterion("dk_desc like", value, "dkDesc");
            return (Criteria) this;
        }

        public Criteria andDkDescNotLike(String value) {
            addCriterion("dk_desc not like", value, "dkDesc");
            return (Criteria) this;
        }

        public Criteria andDkDescIn(List<String> values) {
            addCriterion("dk_desc in", values, "dkDesc");
            return (Criteria) this;
        }

        public Criteria andDkDescNotIn(List<String> values) {
            addCriterion("dk_desc not in", values, "dkDesc");
            return (Criteria) this;
        }

        public Criteria andDkDescBetween(String value1, String value2) {
            addCriterion("dk_desc between", value1, value2, "dkDesc");
            return (Criteria) this;
        }

        public Criteria andDkDescNotBetween(String value1, String value2) {
            addCriterion("dk_desc not between", value1, value2, "dkDesc");
            return (Criteria) this;
        }

        public Criteria andDkReadonlyIsNull() {
            addCriterion("dk_readonly is null");
            return (Criteria) this;
        }

        public Criteria andDkReadonlyIsNotNull() {
            addCriterion("dk_readonly is not null");
            return (Criteria) this;
        }

        public Criteria andDkReadonlyEqualTo(Boolean value) {
            addCriterion("dk_readonly =", value, "dkReadonly");
            return (Criteria) this;
        }

        public Criteria andDkReadonlyNotEqualTo(Boolean value) {
            addCriterion("dk_readonly <>", value, "dkReadonly");
            return (Criteria) this;
        }

        public Criteria andDkReadonlyGreaterThan(Boolean value) {
            addCriterion("dk_readonly >", value, "dkReadonly");
            return (Criteria) this;
        }

        public Criteria andDkReadonlyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("dk_readonly >=", value, "dkReadonly");
            return (Criteria) this;
        }

        public Criteria andDkReadonlyLessThan(Boolean value) {
            addCriterion("dk_readonly <", value, "dkReadonly");
            return (Criteria) this;
        }

        public Criteria andDkReadonlyLessThanOrEqualTo(Boolean value) {
            addCriterion("dk_readonly <=", value, "dkReadonly");
            return (Criteria) this;
        }

        public Criteria andDkReadonlyIn(List<Boolean> values) {
            addCriterion("dk_readonly in", values, "dkReadonly");
            return (Criteria) this;
        }

        public Criteria andDkReadonlyNotIn(List<Boolean> values) {
            addCriterion("dk_readonly not in", values, "dkReadonly");
            return (Criteria) this;
        }

        public Criteria andDkReadonlyBetween(Boolean value1, Boolean value2) {
            addCriterion("dk_readonly between", value1, value2, "dkReadonly");
            return (Criteria) this;
        }

        public Criteria andDkReadonlyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("dk_readonly not between", value1, value2, "dkReadonly");
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