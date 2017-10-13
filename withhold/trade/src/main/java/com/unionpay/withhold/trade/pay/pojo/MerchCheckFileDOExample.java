package com.unionpay.withhold.trade.pay.pojo;

import java.util.ArrayList;
import java.util.List;

public class MerchCheckFileDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchCheckFileDOExample() {
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

        public Criteria andMerchnoIsNull() {
            addCriterion("merchNo is null");
            return (Criteria) this;
        }

        public Criteria andMerchnoIsNotNull() {
            addCriterion("merchNo is not null");
            return (Criteria) this;
        }

        public Criteria andMerchnoEqualTo(String value) {
            addCriterion("merchNo =", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoNotEqualTo(String value) {
            addCriterion("merchNo <>", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoGreaterThan(String value) {
            addCriterion("merchNo >", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoGreaterThanOrEqualTo(String value) {
            addCriterion("merchNo >=", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoLessThan(String value) {
            addCriterion("merchNo <", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoLessThanOrEqualTo(String value) {
            addCriterion("merchNo <=", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoLike(String value) {
            addCriterion("merchNo like", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoNotLike(String value) {
            addCriterion("merchNo not like", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoIn(List<String> values) {
            addCriterion("merchNo in", values, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoNotIn(List<String> values) {
            addCriterion("merchNo not in", values, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoBetween(String value1, String value2) {
            addCriterion("merchNo between", value1, value2, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoNotBetween(String value1, String value2) {
            addCriterion("merchNo not between", value1, value2, "merchno");
            return (Criteria) this;
        }

        public Criteria andCheckdateIsNull() {
            addCriterion("checkDate is null");
            return (Criteria) this;
        }

        public Criteria andCheckdateIsNotNull() {
            addCriterion("checkDate is not null");
            return (Criteria) this;
        }

        public Criteria andCheckdateEqualTo(String value) {
            addCriterion("checkDate =", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateNotEqualTo(String value) {
            addCriterion("checkDate <>", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateGreaterThan(String value) {
            addCriterion("checkDate >", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateGreaterThanOrEqualTo(String value) {
            addCriterion("checkDate >=", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateLessThan(String value) {
            addCriterion("checkDate <", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateLessThanOrEqualTo(String value) {
            addCriterion("checkDate <=", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateLike(String value) {
            addCriterion("checkDate like", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateNotLike(String value) {
            addCriterion("checkDate not like", value, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateIn(List<String> values) {
            addCriterion("checkDate in", values, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateNotIn(List<String> values) {
            addCriterion("checkDate not in", values, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateBetween(String value1, String value2) {
            addCriterion("checkDate between", value1, value2, "checkdate");
            return (Criteria) this;
        }

        public Criteria andCheckdateNotBetween(String value1, String value2) {
            addCriterion("checkDate not between", value1, value2, "checkdate");
            return (Criteria) this;
        }

        public Criteria andIntimeIsNull() {
            addCriterion("intime is null");
            return (Criteria) this;
        }

        public Criteria andIntimeIsNotNull() {
            addCriterion("intime is not null");
            return (Criteria) this;
        }

        public Criteria andIntimeEqualTo(String value) {
            addCriterion("intime =", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotEqualTo(String value) {
            addCriterion("intime <>", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThan(String value) {
            addCriterion("intime >", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeGreaterThanOrEqualTo(String value) {
            addCriterion("intime >=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThan(String value) {
            addCriterion("intime <", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLessThanOrEqualTo(String value) {
            addCriterion("intime <=", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeLike(String value) {
            addCriterion("intime like", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotLike(String value) {
            addCriterion("intime not like", value, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeIn(List<String> values) {
            addCriterion("intime in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotIn(List<String> values) {
            addCriterion("intime not in", values, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeBetween(String value1, String value2) {
            addCriterion("intime between", value1, value2, "intime");
            return (Criteria) this;
        }

        public Criteria andIntimeNotBetween(String value1, String value2) {
            addCriterion("intime not between", value1, value2, "intime");
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

        public Criteria andUriIsNull() {
            addCriterion("uri is null");
            return (Criteria) this;
        }

        public Criteria andUriIsNotNull() {
            addCriterion("uri is not null");
            return (Criteria) this;
        }

        public Criteria andUriEqualTo(String value) {
            addCriterion("uri =", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotEqualTo(String value) {
            addCriterion("uri <>", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThan(String value) {
            addCriterion("uri >", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriGreaterThanOrEqualTo(String value) {
            addCriterion("uri >=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThan(String value) {
            addCriterion("uri <", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLessThanOrEqualTo(String value) {
            addCriterion("uri <=", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriLike(String value) {
            addCriterion("uri like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotLike(String value) {
            addCriterion("uri not like", value, "uri");
            return (Criteria) this;
        }

        public Criteria andUriIn(List<String> values) {
            addCriterion("uri in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotIn(List<String> values) {
            addCriterion("uri not in", values, "uri");
            return (Criteria) this;
        }

        public Criteria andUriBetween(String value1, String value2) {
            addCriterion("uri between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andUriNotBetween(String value1, String value2) {
            addCriterion("uri not between", value1, value2, "uri");
            return (Criteria) this;
        }

        public Criteria andRequesttimeIsNull() {
            addCriterion("requestTime is null");
            return (Criteria) this;
        }

        public Criteria andRequesttimeIsNotNull() {
            addCriterion("requestTime is not null");
            return (Criteria) this;
        }

        public Criteria andRequesttimeEqualTo(String value) {
            addCriterion("requestTime =", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeNotEqualTo(String value) {
            addCriterion("requestTime <>", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeGreaterThan(String value) {
            addCriterion("requestTime >", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeGreaterThanOrEqualTo(String value) {
            addCriterion("requestTime >=", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeLessThan(String value) {
            addCriterion("requestTime <", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeLessThanOrEqualTo(String value) {
            addCriterion("requestTime <=", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeLike(String value) {
            addCriterion("requestTime like", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeNotLike(String value) {
            addCriterion("requestTime not like", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeIn(List<String> values) {
            addCriterion("requestTime in", values, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeNotIn(List<String> values) {
            addCriterion("requestTime not in", values, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeBetween(String value1, String value2) {
            addCriterion("requestTime between", value1, value2, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeNotBetween(String value1, String value2) {
            addCriterion("requestTime not between", value1, value2, "requesttime");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
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