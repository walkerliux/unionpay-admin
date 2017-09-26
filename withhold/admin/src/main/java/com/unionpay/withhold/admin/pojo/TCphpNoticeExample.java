package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TCphpNoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCphpNoticeExample() {
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

        public Criteria andResponsecodeIsNull() {
            addCriterion("responseCode is null");
            return (Criteria) this;
        }

        public Criteria andResponsecodeIsNotNull() {
            addCriterion("responseCode is not null");
            return (Criteria) this;
        }

        public Criteria andResponsecodeEqualTo(String value) {
            addCriterion("responseCode =", value, "responsecode");
            return (Criteria) this;
        }

        public Criteria andResponsecodeNotEqualTo(String value) {
            addCriterion("responseCode <>", value, "responsecode");
            return (Criteria) this;
        }

        public Criteria andResponsecodeGreaterThan(String value) {
            addCriterion("responseCode >", value, "responsecode");
            return (Criteria) this;
        }

        public Criteria andResponsecodeGreaterThanOrEqualTo(String value) {
            addCriterion("responseCode >=", value, "responsecode");
            return (Criteria) this;
        }

        public Criteria andResponsecodeLessThan(String value) {
            addCriterion("responseCode <", value, "responsecode");
            return (Criteria) this;
        }

        public Criteria andResponsecodeLessThanOrEqualTo(String value) {
            addCriterion("responseCode <=", value, "responsecode");
            return (Criteria) this;
        }

        public Criteria andResponsecodeLike(String value) {
            addCriterion("responseCode like", value, "responsecode");
            return (Criteria) this;
        }

        public Criteria andResponsecodeNotLike(String value) {
            addCriterion("responseCode not like", value, "responsecode");
            return (Criteria) this;
        }

        public Criteria andResponsecodeIn(List<String> values) {
            addCriterion("responseCode in", values, "responsecode");
            return (Criteria) this;
        }

        public Criteria andResponsecodeNotIn(List<String> values) {
            addCriterion("responseCode not in", values, "responsecode");
            return (Criteria) this;
        }

        public Criteria andResponsecodeBetween(String value1, String value2) {
            addCriterion("responseCode between", value1, value2, "responsecode");
            return (Criteria) this;
        }

        public Criteria andResponsecodeNotBetween(String value1, String value2) {
            addCriterion("responseCode not between", value1, value2, "responsecode");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMeridIsNull() {
            addCriterion("merId is null");
            return (Criteria) this;
        }

        public Criteria andMeridIsNotNull() {
            addCriterion("merId is not null");
            return (Criteria) this;
        }

        public Criteria andMeridEqualTo(String value) {
            addCriterion("merId =", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridNotEqualTo(String value) {
            addCriterion("merId <>", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridGreaterThan(String value) {
            addCriterion("merId >", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridGreaterThanOrEqualTo(String value) {
            addCriterion("merId >=", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridLessThan(String value) {
            addCriterion("merId <", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridLessThanOrEqualTo(String value) {
            addCriterion("merId <=", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridLike(String value) {
            addCriterion("merId like", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridNotLike(String value) {
            addCriterion("merId not like", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridIn(List<String> values) {
            addCriterion("merId in", values, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridNotIn(List<String> values) {
            addCriterion("merId not in", values, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridBetween(String value1, String value2) {
            addCriterion("merId between", value1, value2, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridNotBetween(String value1, String value2) {
            addCriterion("merId not between", value1, value2, "merid");
            return (Criteria) this;
        }

        public Criteria andOrfilenameIsNull() {
            addCriterion("orFileName is null");
            return (Criteria) this;
        }

        public Criteria andOrfilenameIsNotNull() {
            addCriterion("orFileName is not null");
            return (Criteria) this;
        }

        public Criteria andOrfilenameEqualTo(String value) {
            addCriterion("orFileName =", value, "orfilename");
            return (Criteria) this;
        }

        public Criteria andOrfilenameNotEqualTo(String value) {
            addCriterion("orFileName <>", value, "orfilename");
            return (Criteria) this;
        }

        public Criteria andOrfilenameGreaterThan(String value) {
            addCriterion("orFileName >", value, "orfilename");
            return (Criteria) this;
        }

        public Criteria andOrfilenameGreaterThanOrEqualTo(String value) {
            addCriterion("orFileName >=", value, "orfilename");
            return (Criteria) this;
        }

        public Criteria andOrfilenameLessThan(String value) {
            addCriterion("orFileName <", value, "orfilename");
            return (Criteria) this;
        }

        public Criteria andOrfilenameLessThanOrEqualTo(String value) {
            addCriterion("orFileName <=", value, "orfilename");
            return (Criteria) this;
        }

        public Criteria andOrfilenameLike(String value) {
            addCriterion("orFileName like", value, "orfilename");
            return (Criteria) this;
        }

        public Criteria andOrfilenameNotLike(String value) {
            addCriterion("orFileName not like", value, "orfilename");
            return (Criteria) this;
        }

        public Criteria andOrfilenameIn(List<String> values) {
            addCriterion("orFileName in", values, "orfilename");
            return (Criteria) this;
        }

        public Criteria andOrfilenameNotIn(List<String> values) {
            addCriterion("orFileName not in", values, "orfilename");
            return (Criteria) this;
        }

        public Criteria andOrfilenameBetween(String value1, String value2) {
            addCriterion("orFileName between", value1, value2, "orfilename");
            return (Criteria) this;
        }

        public Criteria andOrfilenameNotBetween(String value1, String value2) {
            addCriterion("orFileName not between", value1, value2, "orfilename");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("fileName is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("fileName is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("fileName =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("fileName <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("fileName >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("fileName >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("fileName <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("fileName <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("fileName like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("fileName not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("fileName in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("fileName not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("fileName between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("fileName not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andIntimeIsNull() {
            addCriterion("inTime is null");
            return (Criteria) this;
        }

        public Criteria andIntimeIsNotNull() {
            addCriterion("inTime is not null");
            return (Criteria) this;
        }

        public Criteria andIntimeEqualTo(String value) {
            addCriterion("inTime =", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotEqualTo(String value) {
            addCriterion("inTime <>", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThan(String value) {
            addCriterion("inTime >", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThanOrEqualTo(String value) {
            addCriterion("inTime >=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThan(String value) {
            addCriterion("inTime <", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThanOrEqualTo(String value) {
            addCriterion("inTime <=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLike(String value) {
            addCriterion("inTime like", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotLike(String value) {
            addCriterion("inTime not like", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeIn(List<String> values) {
            addCriterion("inTime in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotIn(List<String> values) {
            addCriterion("inTime not in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeBetween(String value1, String value2) {
            addCriterion("inTime between", value1, value2, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotBetween(String value1, String value2) {
            addCriterion("inTime not between", value1, value2, "intime");
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