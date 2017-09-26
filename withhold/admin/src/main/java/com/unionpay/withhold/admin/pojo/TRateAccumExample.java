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

        public Criteria andTidIsNull() {
            addCriterion("TID is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("TID is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Long value) {
            addCriterion("TID =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Long value) {
            addCriterion("TID <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Long value) {
            addCriterion("TID >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Long value) {
            addCriterion("TID >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Long value) {
            addCriterion("TID <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Long value) {
            addCriterion("TID <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Long> values) {
            addCriterion("TID in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Long> values) {
            addCriterion("TID not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Long value1, Long value2) {
            addCriterion("TID between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Long value1, Long value2) {
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

        public Criteria andAccmodeIsNull() {
            addCriterion("ACCMODE is null");
            return (Criteria) this;
        }

        public Criteria andAccmodeIsNotNull() {
            addCriterion("ACCMODE is not null");
            return (Criteria) this;
        }

        public Criteria andAccmodeEqualTo(Short value) {
            addCriterion("ACCMODE =", value, "accmode");
            return (Criteria) this;
        }

        public Criteria andAccmodeNotEqualTo(Short value) {
            addCriterion("ACCMODE <>", value, "accmode");
            return (Criteria) this;
        }

        public Criteria andAccmodeGreaterThan(Short value) {
            addCriterion("ACCMODE >", value, "accmode");
            return (Criteria) this;
        }

        public Criteria andAccmodeGreaterThanOrEqualTo(Short value) {
            addCriterion("ACCMODE >=", value, "accmode");
            return (Criteria) this;
        }

        public Criteria andAccmodeLessThan(Short value) {
            addCriterion("ACCMODE <", value, "accmode");
            return (Criteria) this;
        }

        public Criteria andAccmodeLessThanOrEqualTo(Short value) {
            addCriterion("ACCMODE <=", value, "accmode");
            return (Criteria) this;
        }

        public Criteria andAccmodeIn(List<Short> values) {
            addCriterion("ACCMODE in", values, "accmode");
            return (Criteria) this;
        }

        public Criteria andAccmodeNotIn(List<Short> values) {
            addCriterion("ACCMODE not in", values, "accmode");
            return (Criteria) this;
        }

        public Criteria andAccmodeBetween(Short value1, Short value2) {
            addCriterion("ACCMODE between", value1, value2, "accmode");
            return (Criteria) this;
        }

        public Criteria andAccmodeNotBetween(Short value1, Short value2) {
            addCriterion("ACCMODE not between", value1, value2, "accmode");
            return (Criteria) this;
        }

        public Criteria andAccobjIsNull() {
            addCriterion("ACCOBJ is null");
            return (Criteria) this;
        }

        public Criteria andAccobjIsNotNull() {
            addCriterion("ACCOBJ is not null");
            return (Criteria) this;
        }

        public Criteria andAccobjEqualTo(String value) {
            addCriterion("ACCOBJ =", value, "accobj");
            return (Criteria) this;
        }

        public Criteria andAccobjNotEqualTo(String value) {
            addCriterion("ACCOBJ <>", value, "accobj");
            return (Criteria) this;
        }

        public Criteria andAccobjGreaterThan(String value) {
            addCriterion("ACCOBJ >", value, "accobj");
            return (Criteria) this;
        }

        public Criteria andAccobjGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOBJ >=", value, "accobj");
            return (Criteria) this;
        }

        public Criteria andAccobjLessThan(String value) {
            addCriterion("ACCOBJ <", value, "accobj");
            return (Criteria) this;
        }

        public Criteria andAccobjLessThanOrEqualTo(String value) {
            addCriterion("ACCOBJ <=", value, "accobj");
            return (Criteria) this;
        }

        public Criteria andAccobjLike(String value) {
            addCriterion("ACCOBJ like", value, "accobj");
            return (Criteria) this;
        }

        public Criteria andAccobjNotLike(String value) {
            addCriterion("ACCOBJ not like", value, "accobj");
            return (Criteria) this;
        }

        public Criteria andAccobjIn(List<String> values) {
            addCriterion("ACCOBJ in", values, "accobj");
            return (Criteria) this;
        }

        public Criteria andAccobjNotIn(List<String> values) {
            addCriterion("ACCOBJ not in", values, "accobj");
            return (Criteria) this;
        }

        public Criteria andAccobjBetween(String value1, String value2) {
            addCriterion("ACCOBJ between", value1, value2, "accobj");
            return (Criteria) this;
        }

        public Criteria andAccobjNotBetween(String value1, String value2) {
            addCriterion("ACCOBJ not between", value1, value2, "accobj");
            return (Criteria) this;
        }

        public Criteria andServicefeeIsNull() {
            addCriterion("SERVICEFEE is null");
            return (Criteria) this;
        }

        public Criteria andServicefeeIsNotNull() {
            addCriterion("SERVICEFEE is not null");
            return (Criteria) this;
        }

        public Criteria andServicefeeEqualTo(Long value) {
            addCriterion("SERVICEFEE =", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotEqualTo(Long value) {
            addCriterion("SERVICEFEE <>", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeGreaterThan(Long value) {
            addCriterion("SERVICEFEE >", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeGreaterThanOrEqualTo(Long value) {
            addCriterion("SERVICEFEE >=", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeLessThan(Long value) {
            addCriterion("SERVICEFEE <", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeLessThanOrEqualTo(Long value) {
            addCriterion("SERVICEFEE <=", value, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeIn(List<Long> values) {
            addCriterion("SERVICEFEE in", values, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotIn(List<Long> values) {
            addCriterion("SERVICEFEE not in", values, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeBetween(Long value1, Long value2) {
            addCriterion("SERVICEFEE between", value1, value2, "servicefee");
            return (Criteria) this;
        }

        public Criteria andServicefeeNotBetween(Long value1, Long value2) {
            addCriterion("SERVICEFEE not between", value1, value2, "servicefee");
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