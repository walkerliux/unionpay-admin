package com.unionpay.withhold.trade.pay.pojo;

import java.util.ArrayList;
import java.util.List;

public class RspmsgPayDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RspmsgPayDOExample() {
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

        public Criteria andRspidIsNull() {
            addCriterion("RSPID is null");
            return (Criteria) this;
        }

        public Criteria andRspidIsNotNull() {
            addCriterion("RSPID is not null");
            return (Criteria) this;
        }

        public Criteria andRspidEqualTo(Integer value) {
            addCriterion("RSPID =", value, "rspid");
            return (Criteria) this;
        }

        public Criteria andRspidNotEqualTo(Integer value) {
            addCriterion("RSPID <>", value, "rspid");
            return (Criteria) this;
        }

        public Criteria andRspidGreaterThan(Integer value) {
            addCriterion("RSPID >", value, "rspid");
            return (Criteria) this;
        }

        public Criteria andRspidGreaterThanOrEqualTo(Integer value) {
            addCriterion("RSPID >=", value, "rspid");
            return (Criteria) this;
        }

        public Criteria andRspidLessThan(Integer value) {
            addCriterion("RSPID <", value, "rspid");
            return (Criteria) this;
        }

        public Criteria andRspidLessThanOrEqualTo(Integer value) {
            addCriterion("RSPID <=", value, "rspid");
            return (Criteria) this;
        }

        public Criteria andRspidIn(List<Integer> values) {
            addCriterion("RSPID in", values, "rspid");
            return (Criteria) this;
        }

        public Criteria andRspidNotIn(List<Integer> values) {
            addCriterion("RSPID not in", values, "rspid");
            return (Criteria) this;
        }

        public Criteria andRspidBetween(Integer value1, Integer value2) {
            addCriterion("RSPID between", value1, value2, "rspid");
            return (Criteria) this;
        }

        public Criteria andRspidNotBetween(Integer value1, Integer value2) {
            addCriterion("RSPID not between", value1, value2, "rspid");
            return (Criteria) this;
        }

        public Criteria andApicodeIsNull() {
            addCriterion("APICODE is null");
            return (Criteria) this;
        }

        public Criteria andApicodeIsNotNull() {
            addCriterion("APICODE is not null");
            return (Criteria) this;
        }

        public Criteria andApicodeEqualTo(String value) {
            addCriterion("APICODE =", value, "apicode");
            return (Criteria) this;
        }

        public Criteria andApicodeNotEqualTo(String value) {
            addCriterion("APICODE <>", value, "apicode");
            return (Criteria) this;
        }

        public Criteria andApicodeGreaterThan(String value) {
            addCriterion("APICODE >", value, "apicode");
            return (Criteria) this;
        }

        public Criteria andApicodeGreaterThanOrEqualTo(String value) {
            addCriterion("APICODE >=", value, "apicode");
            return (Criteria) this;
        }

        public Criteria andApicodeLessThan(String value) {
            addCriterion("APICODE <", value, "apicode");
            return (Criteria) this;
        }

        public Criteria andApicodeLessThanOrEqualTo(String value) {
            addCriterion("APICODE <=", value, "apicode");
            return (Criteria) this;
        }

        public Criteria andApicodeLike(String value) {
            addCriterion("APICODE like", value, "apicode");
            return (Criteria) this;
        }

        public Criteria andApicodeNotLike(String value) {
            addCriterion("APICODE not like", value, "apicode");
            return (Criteria) this;
        }

        public Criteria andApicodeIn(List<String> values) {
            addCriterion("APICODE in", values, "apicode");
            return (Criteria) this;
        }

        public Criteria andApicodeNotIn(List<String> values) {
            addCriterion("APICODE not in", values, "apicode");
            return (Criteria) this;
        }

        public Criteria andApicodeBetween(String value1, String value2) {
            addCriterion("APICODE between", value1, value2, "apicode");
            return (Criteria) this;
        }

        public Criteria andApicodeNotBetween(String value1, String value2) {
            addCriterion("APICODE not between", value1, value2, "apicode");
            return (Criteria) this;
        }

        public Criteria andApiinfoIsNull() {
            addCriterion("APIINFO is null");
            return (Criteria) this;
        }

        public Criteria andApiinfoIsNotNull() {
            addCriterion("APIINFO is not null");
            return (Criteria) this;
        }

        public Criteria andApiinfoEqualTo(String value) {
            addCriterion("APIINFO =", value, "apiinfo");
            return (Criteria) this;
        }

        public Criteria andApiinfoNotEqualTo(String value) {
            addCriterion("APIINFO <>", value, "apiinfo");
            return (Criteria) this;
        }

        public Criteria andApiinfoGreaterThan(String value) {
            addCriterion("APIINFO >", value, "apiinfo");
            return (Criteria) this;
        }

        public Criteria andApiinfoGreaterThanOrEqualTo(String value) {
            addCriterion("APIINFO >=", value, "apiinfo");
            return (Criteria) this;
        }

        public Criteria andApiinfoLessThan(String value) {
            addCriterion("APIINFO <", value, "apiinfo");
            return (Criteria) this;
        }

        public Criteria andApiinfoLessThanOrEqualTo(String value) {
            addCriterion("APIINFO <=", value, "apiinfo");
            return (Criteria) this;
        }

        public Criteria andApiinfoLike(String value) {
            addCriterion("APIINFO like", value, "apiinfo");
            return (Criteria) this;
        }

        public Criteria andApiinfoNotLike(String value) {
            addCriterion("APIINFO not like", value, "apiinfo");
            return (Criteria) this;
        }

        public Criteria andApiinfoIn(List<String> values) {
            addCriterion("APIINFO in", values, "apiinfo");
            return (Criteria) this;
        }

        public Criteria andApiinfoNotIn(List<String> values) {
            addCriterion("APIINFO not in", values, "apiinfo");
            return (Criteria) this;
        }

        public Criteria andApiinfoBetween(String value1, String value2) {
            addCriterion("APIINFO between", value1, value2, "apiinfo");
            return (Criteria) this;
        }

        public Criteria andApiinfoNotBetween(String value1, String value2) {
            addCriterion("APIINFO not between", value1, value2, "apiinfo");
            return (Criteria) this;
        }

        public Criteria andRetcodeIsNull() {
            addCriterion("RETCODE is null");
            return (Criteria) this;
        }

        public Criteria andRetcodeIsNotNull() {
            addCriterion("RETCODE is not null");
            return (Criteria) this;
        }

        public Criteria andRetcodeEqualTo(String value) {
            addCriterion("RETCODE =", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeNotEqualTo(String value) {
            addCriterion("RETCODE <>", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeGreaterThan(String value) {
            addCriterion("RETCODE >", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeGreaterThanOrEqualTo(String value) {
            addCriterion("RETCODE >=", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeLessThan(String value) {
            addCriterion("RETCODE <", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeLessThanOrEqualTo(String value) {
            addCriterion("RETCODE <=", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeLike(String value) {
            addCriterion("RETCODE like", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeNotLike(String value) {
            addCriterion("RETCODE not like", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeIn(List<String> values) {
            addCriterion("RETCODE in", values, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeNotIn(List<String> values) {
            addCriterion("RETCODE not in", values, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeBetween(String value1, String value2) {
            addCriterion("RETCODE between", value1, value2, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeNotBetween(String value1, String value2) {
            addCriterion("RETCODE not between", value1, value2, "retcode");
            return (Criteria) this;
        }

        public Criteria andRspinfoIsNull() {
            addCriterion("RSPINFO is null");
            return (Criteria) this;
        }

        public Criteria andRspinfoIsNotNull() {
            addCriterion("RSPINFO is not null");
            return (Criteria) this;
        }

        public Criteria andRspinfoEqualTo(String value) {
            addCriterion("RSPINFO =", value, "rspinfo");
            return (Criteria) this;
        }

        public Criteria andRspinfoNotEqualTo(String value) {
            addCriterion("RSPINFO <>", value, "rspinfo");
            return (Criteria) this;
        }

        public Criteria andRspinfoGreaterThan(String value) {
            addCriterion("RSPINFO >", value, "rspinfo");
            return (Criteria) this;
        }

        public Criteria andRspinfoGreaterThanOrEqualTo(String value) {
            addCriterion("RSPINFO >=", value, "rspinfo");
            return (Criteria) this;
        }

        public Criteria andRspinfoLessThan(String value) {
            addCriterion("RSPINFO <", value, "rspinfo");
            return (Criteria) this;
        }

        public Criteria andRspinfoLessThanOrEqualTo(String value) {
            addCriterion("RSPINFO <=", value, "rspinfo");
            return (Criteria) this;
        }

        public Criteria andRspinfoLike(String value) {
            addCriterion("RSPINFO like", value, "rspinfo");
            return (Criteria) this;
        }

        public Criteria andRspinfoNotLike(String value) {
            addCriterion("RSPINFO not like", value, "rspinfo");
            return (Criteria) this;
        }

        public Criteria andRspinfoIn(List<String> values) {
            addCriterion("RSPINFO in", values, "rspinfo");
            return (Criteria) this;
        }

        public Criteria andRspinfoNotIn(List<String> values) {
            addCriterion("RSPINFO not in", values, "rspinfo");
            return (Criteria) this;
        }

        public Criteria andRspinfoBetween(String value1, String value2) {
            addCriterion("RSPINFO between", value1, value2, "rspinfo");
            return (Criteria) this;
        }

        public Criteria andRspinfoNotBetween(String value1, String value2) {
            addCriterion("RSPINFO not between", value1, value2, "rspinfo");
            return (Criteria) this;
        }

        public Criteria andChnltypeIsNull() {
            addCriterion("CHNLTYPE is null");
            return (Criteria) this;
        }

        public Criteria andChnltypeIsNotNull() {
            addCriterion("CHNLTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andChnltypeEqualTo(String value) {
            addCriterion("CHNLTYPE =", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeNotEqualTo(String value) {
            addCriterion("CHNLTYPE <>", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeGreaterThan(String value) {
            addCriterion("CHNLTYPE >", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHNLTYPE >=", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeLessThan(String value) {
            addCriterion("CHNLTYPE <", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeLessThanOrEqualTo(String value) {
            addCriterion("CHNLTYPE <=", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeLike(String value) {
            addCriterion("CHNLTYPE like", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeNotLike(String value) {
            addCriterion("CHNLTYPE not like", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeIn(List<String> values) {
            addCriterion("CHNLTYPE in", values, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeNotIn(List<String> values) {
            addCriterion("CHNLTYPE not in", values, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeBetween(String value1, String value2) {
            addCriterion("CHNLTYPE between", value1, value2, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeNotBetween(String value1, String value2) {
            addCriterion("CHNLTYPE not between", value1, value2, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnlrspcodeIsNull() {
            addCriterion("CHNLRSPCODE is null");
            return (Criteria) this;
        }

        public Criteria andChnlrspcodeIsNotNull() {
            addCriterion("CHNLRSPCODE is not null");
            return (Criteria) this;
        }

        public Criteria andChnlrspcodeEqualTo(String value) {
            addCriterion("CHNLRSPCODE =", value, "chnlrspcode");
            return (Criteria) this;
        }

        public Criteria andChnlrspcodeNotEqualTo(String value) {
            addCriterion("CHNLRSPCODE <>", value, "chnlrspcode");
            return (Criteria) this;
        }

        public Criteria andChnlrspcodeGreaterThan(String value) {
            addCriterion("CHNLRSPCODE >", value, "chnlrspcode");
            return (Criteria) this;
        }

        public Criteria andChnlrspcodeGreaterThanOrEqualTo(String value) {
            addCriterion("CHNLRSPCODE >=", value, "chnlrspcode");
            return (Criteria) this;
        }

        public Criteria andChnlrspcodeLessThan(String value) {
            addCriterion("CHNLRSPCODE <", value, "chnlrspcode");
            return (Criteria) this;
        }

        public Criteria andChnlrspcodeLessThanOrEqualTo(String value) {
            addCriterion("CHNLRSPCODE <=", value, "chnlrspcode");
            return (Criteria) this;
        }

        public Criteria andChnlrspcodeLike(String value) {
            addCriterion("CHNLRSPCODE like", value, "chnlrspcode");
            return (Criteria) this;
        }

        public Criteria andChnlrspcodeNotLike(String value) {
            addCriterion("CHNLRSPCODE not like", value, "chnlrspcode");
            return (Criteria) this;
        }

        public Criteria andChnlrspcodeIn(List<String> values) {
            addCriterion("CHNLRSPCODE in", values, "chnlrspcode");
            return (Criteria) this;
        }

        public Criteria andChnlrspcodeNotIn(List<String> values) {
            addCriterion("CHNLRSPCODE not in", values, "chnlrspcode");
            return (Criteria) this;
        }

        public Criteria andChnlrspcodeBetween(String value1, String value2) {
            addCriterion("CHNLRSPCODE between", value1, value2, "chnlrspcode");
            return (Criteria) this;
        }

        public Criteria andChnlrspcodeNotBetween(String value1, String value2) {
            addCriterion("CHNLRSPCODE not between", value1, value2, "chnlrspcode");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("REASON is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("REASON is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("REASON =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("REASON <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("REASON >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("REASON >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("REASON <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("REASON <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("REASON like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("REASON not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("REASON in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("REASON not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("REASON between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("REASON not between", value1, value2, "reason");
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