package com.unionpay.withhold.admin.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TLimitMemDayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TLimitMemDayExample() {
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

        public Criteria andTIdIsNull() {
            addCriterion("T_ID is null");
            return (Criteria) this;
        }

        public Criteria andTIdIsNotNull() {
            addCriterion("T_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTIdEqualTo(Long value) {
            addCriterion("T_ID =", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotEqualTo(Long value) {
            addCriterion("T_ID <>", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThan(Long value) {
            addCriterion("T_ID >", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThanOrEqualTo(Long value) {
            addCriterion("T_ID >=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThan(Long value) {
            addCriterion("T_ID <", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThanOrEqualTo(Long value) {
            addCriterion("T_ID <=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdIn(List<Long> values) {
            addCriterion("T_ID in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotIn(List<Long> values) {
            addCriterion("T_ID not in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdBetween(Long value1, Long value2) {
            addCriterion("T_ID between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotBetween(Long value1, Long value2) {
            addCriterion("T_ID not between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andCaseidIsNull() {
            addCriterion("CASEID is null");
            return (Criteria) this;
        }

        public Criteria andCaseidIsNotNull() {
            addCriterion("CASEID is not null");
            return (Criteria) this;
        }

        public Criteria andCaseidEqualTo(Long value) {
            addCriterion("CASEID =", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotEqualTo(Long value) {
            addCriterion("CASEID <>", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidGreaterThan(Long value) {
            addCriterion("CASEID >", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidGreaterThanOrEqualTo(Long value) {
            addCriterion("CASEID >=", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidLessThan(Long value) {
            addCriterion("CASEID <", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidLessThanOrEqualTo(Long value) {
            addCriterion("CASEID <=", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidIn(List<Long> values) {
            addCriterion("CASEID in", values, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotIn(List<Long> values) {
            addCriterion("CASEID not in", values, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidBetween(Long value1, Long value2) {
            addCriterion("CASEID between", value1, value2, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotBetween(Long value1, Long value2) {
            addCriterion("CASEID not between", value1, value2, "caseid");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNull() {
            addCriterion("MEMBERID is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("MEMBERID is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(String value) {
            addCriterion("MEMBERID =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(String value) {
            addCriterion("MEMBERID <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(String value) {
            addCriterion("MEMBERID >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBERID >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(String value) {
            addCriterion("MEMBERID <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(String value) {
            addCriterion("MEMBERID <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLike(String value) {
            addCriterion("MEMBERID like", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotLike(String value) {
            addCriterion("MEMBERID not like", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<String> values) {
            addCriterion("MEMBERID in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<String> values) {
            addCriterion("MEMBERID not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(String value1, String value2) {
            addCriterion("MEMBERID between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(String value1, String value2) {
            addCriterion("MEMBERID not between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andLimitAmountIsNull() {
            addCriterion("LIMIT_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andLimitAmountIsNotNull() {
            addCriterion("LIMIT_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLimitAmountEqualTo(BigDecimal value) {
            addCriterion("LIMIT_AMOUNT =", value, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountNotEqualTo(BigDecimal value) {
            addCriterion("LIMIT_AMOUNT <>", value, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountGreaterThan(BigDecimal value) {
            addCriterion("LIMIT_AMOUNT >", value, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LIMIT_AMOUNT >=", value, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountLessThan(BigDecimal value) {
            addCriterion("LIMIT_AMOUNT <", value, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LIMIT_AMOUNT <=", value, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountIn(List<BigDecimal> values) {
            addCriterion("LIMIT_AMOUNT in", values, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountNotIn(List<BigDecimal> values) {
            addCriterion("LIMIT_AMOUNT not in", values, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIMIT_AMOUNT between", value1, value2, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIMIT_AMOUNT not between", value1, value2, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitCountIsNull() {
            addCriterion("LIMIT_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andLimitCountIsNotNull() {
            addCriterion("LIMIT_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLimitCountEqualTo(Long value) {
            addCriterion("LIMIT_COUNT =", value, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountNotEqualTo(Long value) {
            addCriterion("LIMIT_COUNT <>", value, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountGreaterThan(Long value) {
            addCriterion("LIMIT_COUNT >", value, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountGreaterThanOrEqualTo(Long value) {
            addCriterion("LIMIT_COUNT >=", value, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountLessThan(Long value) {
            addCriterion("LIMIT_COUNT <", value, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountLessThanOrEqualTo(Long value) {
            addCriterion("LIMIT_COUNT <=", value, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountIn(List<Long> values) {
            addCriterion("LIMIT_COUNT in", values, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountNotIn(List<Long> values) {
            addCriterion("LIMIT_COUNT not in", values, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountBetween(Long value1, Long value2) {
            addCriterion("LIMIT_COUNT between", value1, value2, "limitCount");
            return (Criteria) this;
        }

        public Criteria andLimitCountNotBetween(Long value1, Long value2) {
            addCriterion("LIMIT_COUNT not between", value1, value2, "limitCount");
            return (Criteria) this;
        }

        public Criteria andRisklevelIsNull() {
            addCriterion("RISKLEVEL is null");
            return (Criteria) this;
        }

        public Criteria andRisklevelIsNotNull() {
            addCriterion("RISKLEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andRisklevelEqualTo(Short value) {
            addCriterion("RISKLEVEL =", value, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelNotEqualTo(Short value) {
            addCriterion("RISKLEVEL <>", value, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelGreaterThan(Short value) {
            addCriterion("RISKLEVEL >", value, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelGreaterThanOrEqualTo(Short value) {
            addCriterion("RISKLEVEL >=", value, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelLessThan(Short value) {
            addCriterion("RISKLEVEL <", value, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelLessThanOrEqualTo(Short value) {
            addCriterion("RISKLEVEL <=", value, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelIn(List<Short> values) {
            addCriterion("RISKLEVEL in", values, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelNotIn(List<Short> values) {
            addCriterion("RISKLEVEL not in", values, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelBetween(Short value1, Short value2) {
            addCriterion("RISKLEVEL between", value1, value2, "risklevel");
            return (Criteria) this;
        }

        public Criteria andRisklevelNotBetween(Short value1, Short value2) {
            addCriterion("RISKLEVEL not between", value1, value2, "risklevel");
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