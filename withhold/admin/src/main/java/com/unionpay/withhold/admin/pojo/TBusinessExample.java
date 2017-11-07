package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TBusinessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBusinessExample() {
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

        public Criteria andBusiidIsNull() {
            addCriterion("BUSIID is null");
            return (Criteria) this;
        }

        public Criteria andBusiidIsNotNull() {
            addCriterion("BUSIID is not null");
            return (Criteria) this;
        }

        public Criteria andBusiidEqualTo(Integer value) {
            addCriterion("BUSIID =", value, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidNotEqualTo(Integer value) {
            addCriterion("BUSIID <>", value, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidGreaterThan(Integer value) {
            addCriterion("BUSIID >", value, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUSIID >=", value, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidLessThan(Integer value) {
            addCriterion("BUSIID <", value, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidLessThanOrEqualTo(Integer value) {
            addCriterion("BUSIID <=", value, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidIn(List<Integer> values) {
            addCriterion("BUSIID in", values, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidNotIn(List<Integer> values) {
            addCriterion("BUSIID not in", values, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidBetween(Integer value1, Integer value2) {
            addCriterion("BUSIID between", value1, value2, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusiidNotBetween(Integer value1, Integer value2) {
            addCriterion("BUSIID not between", value1, value2, "busiid");
            return (Criteria) this;
        }

        public Criteria andBusicodeIsNull() {
            addCriterion("BUSICODE is null");
            return (Criteria) this;
        }

        public Criteria andBusicodeIsNotNull() {
            addCriterion("BUSICODE is not null");
            return (Criteria) this;
        }

        public Criteria andBusicodeEqualTo(String value) {
            addCriterion("BUSICODE =", value, "busicode");
            return (Criteria) this;
        }

        public Criteria andBusicodeNotEqualTo(String value) {
            addCriterion("BUSICODE <>", value, "busicode");
            return (Criteria) this;
        }

        public Criteria andBusicodeGreaterThan(String value) {
            addCriterion("BUSICODE >", value, "busicode");
            return (Criteria) this;
        }

        public Criteria andBusicodeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSICODE >=", value, "busicode");
            return (Criteria) this;
        }

        public Criteria andBusicodeLessThan(String value) {
            addCriterion("BUSICODE <", value, "busicode");
            return (Criteria) this;
        }

        public Criteria andBusicodeLessThanOrEqualTo(String value) {
            addCriterion("BUSICODE <=", value, "busicode");
            return (Criteria) this;
        }

        public Criteria andBusicodeLike(String value) {
            addCriterion("BUSICODE like", value, "busicode");
            return (Criteria) this;
        }

        public Criteria andBusicodeNotLike(String value) {
            addCriterion("BUSICODE not like", value, "busicode");
            return (Criteria) this;
        }

        public Criteria andBusicodeIn(List<String> values) {
            addCriterion("BUSICODE in", values, "busicode");
            return (Criteria) this;
        }

        public Criteria andBusicodeNotIn(List<String> values) {
            addCriterion("BUSICODE not in", values, "busicode");
            return (Criteria) this;
        }

        public Criteria andBusicodeBetween(String value1, String value2) {
            addCriterion("BUSICODE between", value1, value2, "busicode");
            return (Criteria) this;
        }

        public Criteria andBusicodeNotBetween(String value1, String value2) {
            addCriterion("BUSICODE not between", value1, value2, "busicode");
            return (Criteria) this;
        }

        public Criteria andBusinameIsNull() {
            addCriterion("BUSINAME is null");
            return (Criteria) this;
        }

        public Criteria andBusinameIsNotNull() {
            addCriterion("BUSINAME is not null");
            return (Criteria) this;
        }

        public Criteria andBusinameEqualTo(String value) {
            addCriterion("BUSINAME =", value, "businame");
            return (Criteria) this;
        }

        public Criteria andBusinameNotEqualTo(String value) {
            addCriterion("BUSINAME <>", value, "businame");
            return (Criteria) this;
        }

        public Criteria andBusinameGreaterThan(String value) {
            addCriterion("BUSINAME >", value, "businame");
            return (Criteria) this;
        }

        public Criteria andBusinameGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINAME >=", value, "businame");
            return (Criteria) this;
        }

        public Criteria andBusinameLessThan(String value) {
            addCriterion("BUSINAME <", value, "businame");
            return (Criteria) this;
        }

        public Criteria andBusinameLessThanOrEqualTo(String value) {
            addCriterion("BUSINAME <=", value, "businame");
            return (Criteria) this;
        }

        public Criteria andBusinameLike(String value) {
            addCriterion("BUSINAME like", value, "businame");
            return (Criteria) this;
        }

        public Criteria andBusinameNotLike(String value) {
            addCriterion("BUSINAME not like", value, "businame");
            return (Criteria) this;
        }

        public Criteria andBusinameIn(List<String> values) {
            addCriterion("BUSINAME in", values, "businame");
            return (Criteria) this;
        }

        public Criteria andBusinameNotIn(List<String> values) {
            addCriterion("BUSINAME not in", values, "businame");
            return (Criteria) this;
        }

        public Criteria andBusinameBetween(String value1, String value2) {
            addCriterion("BUSINAME between", value1, value2, "businame");
            return (Criteria) this;
        }

        public Criteria andBusinameNotBetween(String value1, String value2) {
            addCriterion("BUSINAME not between", value1, value2, "businame");
            return (Criteria) this;
        }

        public Criteria andBusitypeIsNull() {
            addCriterion("BUSITYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusitypeIsNotNull() {
            addCriterion("BUSITYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusitypeEqualTo(String value) {
            addCriterion("BUSITYPE =", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeNotEqualTo(String value) {
            addCriterion("BUSITYPE <>", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeGreaterThan(String value) {
            addCriterion("BUSITYPE >", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSITYPE >=", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeLessThan(String value) {
            addCriterion("BUSITYPE <", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeLessThanOrEqualTo(String value) {
            addCriterion("BUSITYPE <=", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeLike(String value) {
            addCriterion("BUSITYPE like", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeNotLike(String value) {
            addCriterion("BUSITYPE not like", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeIn(List<String> values) {
            addCriterion("BUSITYPE in", values, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeNotIn(List<String> values) {
            addCriterion("BUSITYPE not in", values, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeBetween(String value1, String value2) {
            addCriterion("BUSITYPE between", value1, value2, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeNotBetween(String value1, String value2) {
            addCriterion("BUSITYPE not between", value1, value2, "busitype");
            return (Criteria) this;
        }

        public Criteria andRiskflagIsNull() {
            addCriterion("RISKFLAG is null");
            return (Criteria) this;
        }

        public Criteria andRiskflagIsNotNull() {
            addCriterion("RISKFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andRiskflagEqualTo(String value) {
            addCriterion("RISKFLAG =", value, "riskflag");
            return (Criteria) this;
        }

        public Criteria andRiskflagNotEqualTo(String value) {
            addCriterion("RISKFLAG <>", value, "riskflag");
            return (Criteria) this;
        }

        public Criteria andRiskflagGreaterThan(String value) {
            addCriterion("RISKFLAG >", value, "riskflag");
            return (Criteria) this;
        }

        public Criteria andRiskflagGreaterThanOrEqualTo(String value) {
            addCriterion("RISKFLAG >=", value, "riskflag");
            return (Criteria) this;
        }

        public Criteria andRiskflagLessThan(String value) {
            addCriterion("RISKFLAG <", value, "riskflag");
            return (Criteria) this;
        }

        public Criteria andRiskflagLessThanOrEqualTo(String value) {
            addCriterion("RISKFLAG <=", value, "riskflag");
            return (Criteria) this;
        }

        public Criteria andRiskflagLike(String value) {
            addCriterion("RISKFLAG like", value, "riskflag");
            return (Criteria) this;
        }

        public Criteria andRiskflagNotLike(String value) {
            addCriterion("RISKFLAG not like", value, "riskflag");
            return (Criteria) this;
        }

        public Criteria andRiskflagIn(List<String> values) {
            addCriterion("RISKFLAG in", values, "riskflag");
            return (Criteria) this;
        }

        public Criteria andRiskflagNotIn(List<String> values) {
            addCriterion("RISKFLAG not in", values, "riskflag");
            return (Criteria) this;
        }

        public Criteria andRiskflagBetween(String value1, String value2) {
            addCriterion("RISKFLAG between", value1, value2, "riskflag");
            return (Criteria) this;
        }

        public Criteria andRiskflagNotBetween(String value1, String value2) {
            addCriterion("RISKFLAG not between", value1, value2, "riskflag");
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