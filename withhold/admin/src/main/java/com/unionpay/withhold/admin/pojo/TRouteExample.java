package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TRouteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRouteExample() {
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

        public Criteria andRoutidIsNull() {
            addCriterion("ROUTID is null");
            return (Criteria) this;
        }

        public Criteria andRoutidIsNotNull() {
            addCriterion("ROUTID is not null");
            return (Criteria) this;
        }

        public Criteria andRoutidEqualTo(Integer value) {
            addCriterion("ROUTID =", value, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidNotEqualTo(Integer value) {
            addCriterion("ROUTID <>", value, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidGreaterThan(Integer value) {
            addCriterion("ROUTID >", value, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROUTID >=", value, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidLessThan(Integer value) {
            addCriterion("ROUTID <", value, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidLessThanOrEqualTo(Integer value) {
            addCriterion("ROUTID <=", value, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidIn(List<Integer> values) {
            addCriterion("ROUTID in", values, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidNotIn(List<Integer> values) {
            addCriterion("ROUTID not in", values, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidBetween(Integer value1, Integer value2) {
            addCriterion("ROUTID between", value1, value2, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidNotBetween(Integer value1, Integer value2) {
            addCriterion("ROUTID not between", value1, value2, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutverIsNull() {
            addCriterion("ROUTVER is null");
            return (Criteria) this;
        }

        public Criteria andRoutverIsNotNull() {
            addCriterion("ROUTVER is not null");
            return (Criteria) this;
        }

        public Criteria andRoutverEqualTo(String value) {
            addCriterion("ROUTVER =", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverNotEqualTo(String value) {
            addCriterion("ROUTVER <>", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverGreaterThan(String value) {
            addCriterion("ROUTVER >", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTVER >=", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverLessThan(String value) {
            addCriterion("ROUTVER <", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverLessThanOrEqualTo(String value) {
            addCriterion("ROUTVER <=", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverLike(String value) {
            addCriterion("ROUTVER like", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverNotLike(String value) {
            addCriterion("ROUTVER not like", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverIn(List<String> values) {
            addCriterion("ROUTVER in", values, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverNotIn(List<String> values) {
            addCriterion("ROUTVER not in", values, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverBetween(String value1, String value2) {
            addCriterion("ROUTVER between", value1, value2, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverNotBetween(String value1, String value2) {
            addCriterion("ROUTVER not between", value1, value2, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutnameIsNull() {
            addCriterion("ROUTNAME is null");
            return (Criteria) this;
        }

        public Criteria andRoutnameIsNotNull() {
            addCriterion("ROUTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andRoutnameEqualTo(String value) {
            addCriterion("ROUTNAME =", value, "routname");
            return (Criteria) this;
        }

        public Criteria andRoutnameNotEqualTo(String value) {
            addCriterion("ROUTNAME <>", value, "routname");
            return (Criteria) this;
        }

        public Criteria andRoutnameGreaterThan(String value) {
            addCriterion("ROUTNAME >", value, "routname");
            return (Criteria) this;
        }

        public Criteria andRoutnameGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTNAME >=", value, "routname");
            return (Criteria) this;
        }

        public Criteria andRoutnameLessThan(String value) {
            addCriterion("ROUTNAME <", value, "routname");
            return (Criteria) this;
        }

        public Criteria andRoutnameLessThanOrEqualTo(String value) {
            addCriterion("ROUTNAME <=", value, "routname");
            return (Criteria) this;
        }

        public Criteria andRoutnameLike(String value) {
            addCriterion("ROUTNAME like", value, "routname");
            return (Criteria) this;
        }

        public Criteria andRoutnameNotLike(String value) {
            addCriterion("ROUTNAME not like", value, "routname");
            return (Criteria) this;
        }

        public Criteria andRoutnameIn(List<String> values) {
            addCriterion("ROUTNAME in", values, "routname");
            return (Criteria) this;
        }

        public Criteria andRoutnameNotIn(List<String> values) {
            addCriterion("ROUTNAME not in", values, "routname");
            return (Criteria) this;
        }

        public Criteria andRoutnameBetween(String value1, String value2) {
            addCriterion("ROUTNAME between", value1, value2, "routname");
            return (Criteria) this;
        }

        public Criteria andRoutnameNotBetween(String value1, String value2) {
            addCriterion("ROUTNAME not between", value1, value2, "routname");
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

        public Criteria andIntimeIsNull() {
            addCriterion("INTIME is null");
            return (Criteria) this;
        }

        public Criteria andIntimeIsNotNull() {
            addCriterion("INTIME is not null");
            return (Criteria) this;
        }

        public Criteria andIntimeEqualTo(Date value) {
            addCriterion("INTIME =", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotEqualTo(Date value) {
            addCriterion("INTIME <>", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThan(Date value) {
            addCriterion("INTIME >", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("INTIME >=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThan(Date value) {
            addCriterion("INTIME <", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThanOrEqualTo(Date value) {
            addCriterion("INTIME <=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeIn(List<Date> values) {
            addCriterion("INTIME in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotIn(List<Date> values) {
            addCriterion("INTIME not in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeBetween(Date value1, Date value2) {
            addCriterion("INTIME between", value1, value2, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotBetween(Date value1, Date value2) {
            addCriterion("INTIME not between", value1, value2, "intime");
            return (Criteria) this;
        }

        public Criteria andInuserIsNull() {
            addCriterion("INUSER is null");
            return (Criteria) this;
        }

        public Criteria andInuserIsNotNull() {
            addCriterion("INUSER is not null");
            return (Criteria) this;
        }

        public Criteria andInuserEqualTo(Long value) {
            addCriterion("INUSER =", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserNotEqualTo(Long value) {
            addCriterion("INUSER <>", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserGreaterThan(Long value) {
            addCriterion("INUSER >", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserGreaterThanOrEqualTo(Long value) {
            addCriterion("INUSER >=", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserLessThan(Long value) {
            addCriterion("INUSER <", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserLessThanOrEqualTo(Long value) {
            addCriterion("INUSER <=", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserIn(List<Long> values) {
            addCriterion("INUSER in", values, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserNotIn(List<Long> values) {
            addCriterion("INUSER not in", values, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserBetween(Long value1, Long value2) {
            addCriterion("INUSER between", value1, value2, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserNotBetween(Long value1, Long value2) {
            addCriterion("INUSER not between", value1, value2, "inuser");
            return (Criteria) this;
        }

        public Criteria andUptimeIsNull() {
            addCriterion("UPTIME is null");
            return (Criteria) this;
        }

        public Criteria andUptimeIsNotNull() {
            addCriterion("UPTIME is not null");
            return (Criteria) this;
        }

        public Criteria andUptimeEqualTo(Date value) {
            addCriterion("UPTIME =", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotEqualTo(Date value) {
            addCriterion("UPTIME <>", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThan(Date value) {
            addCriterion("UPTIME >", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPTIME >=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThan(Date value) {
            addCriterion("UPTIME <", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThanOrEqualTo(Date value) {
            addCriterion("UPTIME <=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeIn(List<Date> values) {
            addCriterion("UPTIME in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotIn(List<Date> values) {
            addCriterion("UPTIME not in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeBetween(Date value1, Date value2) {
            addCriterion("UPTIME between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotBetween(Date value1, Date value2) {
            addCriterion("UPTIME not between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andUpuserIsNull() {
            addCriterion("UPUSER is null");
            return (Criteria) this;
        }

        public Criteria andUpuserIsNotNull() {
            addCriterion("UPUSER is not null");
            return (Criteria) this;
        }

        public Criteria andUpuserEqualTo(Long value) {
            addCriterion("UPUSER =", value, "upuser");
            return (Criteria) this;
        }

        public Criteria andUpuserNotEqualTo(Long value) {
            addCriterion("UPUSER <>", value, "upuser");
            return (Criteria) this;
        }

        public Criteria andUpuserGreaterThan(Long value) {
            addCriterion("UPUSER >", value, "upuser");
            return (Criteria) this;
        }

        public Criteria andUpuserGreaterThanOrEqualTo(Long value) {
            addCriterion("UPUSER >=", value, "upuser");
            return (Criteria) this;
        }

        public Criteria andUpuserLessThan(Long value) {
            addCriterion("UPUSER <", value, "upuser");
            return (Criteria) this;
        }

        public Criteria andUpuserLessThanOrEqualTo(Long value) {
            addCriterion("UPUSER <=", value, "upuser");
            return (Criteria) this;
        }

        public Criteria andUpuserIn(List<Long> values) {
            addCriterion("UPUSER in", values, "upuser");
            return (Criteria) this;
        }

        public Criteria andUpuserNotIn(List<Long> values) {
            addCriterion("UPUSER not in", values, "upuser");
            return (Criteria) this;
        }

        public Criteria andUpuserBetween(Long value1, Long value2) {
            addCriterion("UPUSER between", value1, value2, "upuser");
            return (Criteria) this;
        }

        public Criteria andUpuserNotBetween(Long value1, Long value2) {
            addCriterion("UPUSER not between", value1, value2, "upuser");
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