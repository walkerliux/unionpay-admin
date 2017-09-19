package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TRiskCaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRiskCaseExample() {
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

        public Criteria andRiskidIsNull() {
            addCriterion("RISKID is null");
            return (Criteria) this;
        }

        public Criteria andRiskidIsNotNull() {
            addCriterion("RISKID is not null");
            return (Criteria) this;
        }

        public Criteria andRiskidEqualTo(Long value) {
            addCriterion("RISKID =", value, "riskid");
            return (Criteria) this;
        }

        public Criteria andRiskidNotEqualTo(Long value) {
            addCriterion("RISKID <>", value, "riskid");
            return (Criteria) this;
        }

        public Criteria andRiskidGreaterThan(Long value) {
            addCriterion("RISKID >", value, "riskid");
            return (Criteria) this;
        }

        public Criteria andRiskidGreaterThanOrEqualTo(Long value) {
            addCriterion("RISKID >=", value, "riskid");
            return (Criteria) this;
        }

        public Criteria andRiskidLessThan(Long value) {
            addCriterion("RISKID <", value, "riskid");
            return (Criteria) this;
        }

        public Criteria andRiskidLessThanOrEqualTo(Long value) {
            addCriterion("RISKID <=", value, "riskid");
            return (Criteria) this;
        }

        public Criteria andRiskidIn(List<Long> values) {
            addCriterion("RISKID in", values, "riskid");
            return (Criteria) this;
        }

        public Criteria andRiskidNotIn(List<Long> values) {
            addCriterion("RISKID not in", values, "riskid");
            return (Criteria) this;
        }

        public Criteria andRiskidBetween(Long value1, Long value2) {
            addCriterion("RISKID between", value1, value2, "riskid");
            return (Criteria) this;
        }

        public Criteria andRiskidNotBetween(Long value1, Long value2) {
            addCriterion("RISKID not between", value1, value2, "riskid");
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

        public Criteria andRiskverIsNull() {
            addCriterion("RISKVER is null");
            return (Criteria) this;
        }

        public Criteria andRiskverIsNotNull() {
            addCriterion("RISKVER is not null");
            return (Criteria) this;
        }

        public Criteria andRiskverEqualTo(String value) {
            addCriterion("RISKVER =", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverNotEqualTo(String value) {
            addCriterion("RISKVER <>", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverGreaterThan(String value) {
            addCriterion("RISKVER >", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverGreaterThanOrEqualTo(String value) {
            addCriterion("RISKVER >=", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverLessThan(String value) {
            addCriterion("RISKVER <", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverLessThanOrEqualTo(String value) {
            addCriterion("RISKVER <=", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverLike(String value) {
            addCriterion("RISKVER like", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverNotLike(String value) {
            addCriterion("RISKVER not like", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverIn(List<String> values) {
            addCriterion("RISKVER in", values, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverNotIn(List<String> values) {
            addCriterion("RISKVER not in", values, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverBetween(String value1, String value2) {
            addCriterion("RISKVER between", value1, value2, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverNotBetween(String value1, String value2) {
            addCriterion("RISKVER not between", value1, value2, "riskver");
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

        public Criteria andActiveflagIsNull() {
            addCriterion("ACTIVEFLAG is null");
            return (Criteria) this;
        }

        public Criteria andActiveflagIsNotNull() {
            addCriterion("ACTIVEFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andActiveflagEqualTo(String value) {
            addCriterion("ACTIVEFLAG =", value, "activeflag");
            return (Criteria) this;
        }

        public Criteria andActiveflagNotEqualTo(String value) {
            addCriterion("ACTIVEFLAG <>", value, "activeflag");
            return (Criteria) this;
        }

        public Criteria andActiveflagGreaterThan(String value) {
            addCriterion("ACTIVEFLAG >", value, "activeflag");
            return (Criteria) this;
        }

        public Criteria andActiveflagGreaterThanOrEqualTo(String value) {
            addCriterion("ACTIVEFLAG >=", value, "activeflag");
            return (Criteria) this;
        }

        public Criteria andActiveflagLessThan(String value) {
            addCriterion("ACTIVEFLAG <", value, "activeflag");
            return (Criteria) this;
        }

        public Criteria andActiveflagLessThanOrEqualTo(String value) {
            addCriterion("ACTIVEFLAG <=", value, "activeflag");
            return (Criteria) this;
        }

        public Criteria andActiveflagLike(String value) {
            addCriterion("ACTIVEFLAG like", value, "activeflag");
            return (Criteria) this;
        }

        public Criteria andActiveflagNotLike(String value) {
            addCriterion("ACTIVEFLAG not like", value, "activeflag");
            return (Criteria) this;
        }

        public Criteria andActiveflagIn(List<String> values) {
            addCriterion("ACTIVEFLAG in", values, "activeflag");
            return (Criteria) this;
        }

        public Criteria andActiveflagNotIn(List<String> values) {
            addCriterion("ACTIVEFLAG not in", values, "activeflag");
            return (Criteria) this;
        }

        public Criteria andActiveflagBetween(String value1, String value2) {
            addCriterion("ACTIVEFLAG between", value1, value2, "activeflag");
            return (Criteria) this;
        }

        public Criteria andActiveflagNotBetween(String value1, String value2) {
            addCriterion("ACTIVEFLAG not between", value1, value2, "activeflag");
            return (Criteria) this;
        }

        public Criteria andInitflagIsNull() {
            addCriterion("INITFLAG is null");
            return (Criteria) this;
        }

        public Criteria andInitflagIsNotNull() {
            addCriterion("INITFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andInitflagEqualTo(String value) {
            addCriterion("INITFLAG =", value, "initflag");
            return (Criteria) this;
        }

        public Criteria andInitflagNotEqualTo(String value) {
            addCriterion("INITFLAG <>", value, "initflag");
            return (Criteria) this;
        }

        public Criteria andInitflagGreaterThan(String value) {
            addCriterion("INITFLAG >", value, "initflag");
            return (Criteria) this;
        }

        public Criteria andInitflagGreaterThanOrEqualTo(String value) {
            addCriterion("INITFLAG >=", value, "initflag");
            return (Criteria) this;
        }

        public Criteria andInitflagLessThan(String value) {
            addCriterion("INITFLAG <", value, "initflag");
            return (Criteria) this;
        }

        public Criteria andInitflagLessThanOrEqualTo(String value) {
            addCriterion("INITFLAG <=", value, "initflag");
            return (Criteria) this;
        }

        public Criteria andInitflagLike(String value) {
            addCriterion("INITFLAG like", value, "initflag");
            return (Criteria) this;
        }

        public Criteria andInitflagNotLike(String value) {
            addCriterion("INITFLAG not like", value, "initflag");
            return (Criteria) this;
        }

        public Criteria andInitflagIn(List<String> values) {
            addCriterion("INITFLAG in", values, "initflag");
            return (Criteria) this;
        }

        public Criteria andInitflagNotIn(List<String> values) {
            addCriterion("INITFLAG not in", values, "initflag");
            return (Criteria) this;
        }

        public Criteria andInitflagBetween(String value1, String value2) {
            addCriterion("INITFLAG between", value1, value2, "initflag");
            return (Criteria) this;
        }

        public Criteria andInitflagNotBetween(String value1, String value2) {
            addCriterion("INITFLAG not between", value1, value2, "initflag");
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