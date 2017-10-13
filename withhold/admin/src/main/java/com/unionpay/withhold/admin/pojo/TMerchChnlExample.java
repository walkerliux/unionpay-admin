package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMerchChnlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMerchChnlExample() {
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
            addCriterion("MERCHNO is null");
            return (Criteria) this;
        }

        public Criteria andMerchnoIsNotNull() {
            addCriterion("MERCHNO is not null");
            return (Criteria) this;
        }

        public Criteria andMerchnoEqualTo(String value) {
            addCriterion("MERCHNO =", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoNotEqualTo(String value) {
            addCriterion("MERCHNO <>", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoGreaterThan(String value) {
            addCriterion("MERCHNO >", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHNO >=", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoLessThan(String value) {
            addCriterion("MERCHNO <", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoLessThanOrEqualTo(String value) {
            addCriterion("MERCHNO <=", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoLike(String value) {
            addCriterion("MERCHNO like", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoNotLike(String value) {
            addCriterion("MERCHNO not like", value, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoIn(List<String> values) {
            addCriterion("MERCHNO in", values, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoNotIn(List<String> values) {
            addCriterion("MERCHNO not in", values, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoBetween(String value1, String value2) {
            addCriterion("MERCHNO between", value1, value2, "merchno");
            return (Criteria) this;
        }

        public Criteria andMerchnoNotBetween(String value1, String value2) {
            addCriterion("MERCHNO not between", value1, value2, "merchno");
            return (Criteria) this;
        }

        public Criteria andChnlcodeIsNull() {
            addCriterion("CHNLCODE is null");
            return (Criteria) this;
        }

        public Criteria andChnlcodeIsNotNull() {
            addCriterion("CHNLCODE is not null");
            return (Criteria) this;
        }

        public Criteria andChnlcodeEqualTo(String value) {
            addCriterion("CHNLCODE =", value, "chnlcode");
            return (Criteria) this;
        }

        public Criteria andChnlcodeNotEqualTo(String value) {
            addCriterion("CHNLCODE <>", value, "chnlcode");
            return (Criteria) this;
        }

        public Criteria andChnlcodeGreaterThan(String value) {
            addCriterion("CHNLCODE >", value, "chnlcode");
            return (Criteria) this;
        }

        public Criteria andChnlcodeGreaterThanOrEqualTo(String value) {
            addCriterion("CHNLCODE >=", value, "chnlcode");
            return (Criteria) this;
        }

        public Criteria andChnlcodeLessThan(String value) {
            addCriterion("CHNLCODE <", value, "chnlcode");
            return (Criteria) this;
        }

        public Criteria andChnlcodeLessThanOrEqualTo(String value) {
            addCriterion("CHNLCODE <=", value, "chnlcode");
            return (Criteria) this;
        }

        public Criteria andChnlcodeLike(String value) {
            addCriterion("CHNLCODE like", value, "chnlcode");
            return (Criteria) this;
        }

        public Criteria andChnlcodeNotLike(String value) {
            addCriterion("CHNLCODE not like", value, "chnlcode");
            return (Criteria) this;
        }

        public Criteria andChnlcodeIn(List<String> values) {
            addCriterion("CHNLCODE in", values, "chnlcode");
            return (Criteria) this;
        }

        public Criteria andChnlcodeNotIn(List<String> values) {
            addCriterion("CHNLCODE not in", values, "chnlcode");
            return (Criteria) this;
        }

        public Criteria andChnlcodeBetween(String value1, String value2) {
            addCriterion("CHNLCODE between", value1, value2, "chnlcode");
            return (Criteria) this;
        }

        public Criteria andChnlcodeNotBetween(String value1, String value2) {
            addCriterion("CHNLCODE not between", value1, value2, "chnlcode");
            return (Criteria) this;
        }

        public Criteria andChnlmercnoIsNull() {
            addCriterion("CHNLMERCNO is null");
            return (Criteria) this;
        }

        public Criteria andChnlmercnoIsNotNull() {
            addCriterion("CHNLMERCNO is not null");
            return (Criteria) this;
        }

        public Criteria andChnlmercnoEqualTo(String value) {
            addCriterion("CHNLMERCNO =", value, "chnlmercno");
            return (Criteria) this;
        }

        public Criteria andChnlmercnoNotEqualTo(String value) {
            addCriterion("CHNLMERCNO <>", value, "chnlmercno");
            return (Criteria) this;
        }

        public Criteria andChnlmercnoGreaterThan(String value) {
            addCriterion("CHNLMERCNO >", value, "chnlmercno");
            return (Criteria) this;
        }

        public Criteria andChnlmercnoGreaterThanOrEqualTo(String value) {
            addCriterion("CHNLMERCNO >=", value, "chnlmercno");
            return (Criteria) this;
        }

        public Criteria andChnlmercnoLessThan(String value) {
            addCriterion("CHNLMERCNO <", value, "chnlmercno");
            return (Criteria) this;
        }

        public Criteria andChnlmercnoLessThanOrEqualTo(String value) {
            addCriterion("CHNLMERCNO <=", value, "chnlmercno");
            return (Criteria) this;
        }

        public Criteria andChnlmercnoLike(String value) {
            addCriterion("CHNLMERCNO like", value, "chnlmercno");
            return (Criteria) this;
        }

        public Criteria andChnlmercnoNotLike(String value) {
            addCriterion("CHNLMERCNO not like", value, "chnlmercno");
            return (Criteria) this;
        }

        public Criteria andChnlmercnoIn(List<String> values) {
            addCriterion("CHNLMERCNO in", values, "chnlmercno");
            return (Criteria) this;
        }

        public Criteria andChnlmercnoNotIn(List<String> values) {
            addCriterion("CHNLMERCNO not in", values, "chnlmercno");
            return (Criteria) this;
        }

        public Criteria andChnlmercnoBetween(String value1, String value2) {
            addCriterion("CHNLMERCNO between", value1, value2, "chnlmercno");
            return (Criteria) this;
        }

        public Criteria andChnlmercnoNotBetween(String value1, String value2) {
            addCriterion("CHNLMERCNO not between", value1, value2, "chnlmercno");
            return (Criteria) this;
        }

        public Criteria andSafetypeIsNull() {
            addCriterion("SAFETYPE is null");
            return (Criteria) this;
        }

        public Criteria andSafetypeIsNotNull() {
            addCriterion("SAFETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSafetypeEqualTo(String value) {
            addCriterion("SAFETYPE =", value, "safetype");
            return (Criteria) this;
        }

        public Criteria andSafetypeNotEqualTo(String value) {
            addCriterion("SAFETYPE <>", value, "safetype");
            return (Criteria) this;
        }

        public Criteria andSafetypeGreaterThan(String value) {
            addCriterion("SAFETYPE >", value, "safetype");
            return (Criteria) this;
        }

        public Criteria andSafetypeGreaterThanOrEqualTo(String value) {
            addCriterion("SAFETYPE >=", value, "safetype");
            return (Criteria) this;
        }

        public Criteria andSafetypeLessThan(String value) {
            addCriterion("SAFETYPE <", value, "safetype");
            return (Criteria) this;
        }

        public Criteria andSafetypeLessThanOrEqualTo(String value) {
            addCriterion("SAFETYPE <=", value, "safetype");
            return (Criteria) this;
        }

        public Criteria andSafetypeLike(String value) {
            addCriterion("SAFETYPE like", value, "safetype");
            return (Criteria) this;
        }

        public Criteria andSafetypeNotLike(String value) {
            addCriterion("SAFETYPE not like", value, "safetype");
            return (Criteria) this;
        }

        public Criteria andSafetypeIn(List<String> values) {
            addCriterion("SAFETYPE in", values, "safetype");
            return (Criteria) this;
        }

        public Criteria andSafetypeNotIn(List<String> values) {
            addCriterion("SAFETYPE not in", values, "safetype");
            return (Criteria) this;
        }

        public Criteria andSafetypeBetween(String value1, String value2) {
            addCriterion("SAFETYPE between", value1, value2, "safetype");
            return (Criteria) this;
        }

        public Criteria andSafetypeNotBetween(String value1, String value2) {
            addCriterion("SAFETYPE not between", value1, value2, "safetype");
            return (Criteria) this;
        }

        public Criteria andStorgetypeIsNull() {
            addCriterion("STORGETYPE is null");
            return (Criteria) this;
        }

        public Criteria andStorgetypeIsNotNull() {
            addCriterion("STORGETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andStorgetypeEqualTo(String value) {
            addCriterion("STORGETYPE =", value, "storgetype");
            return (Criteria) this;
        }

        public Criteria andStorgetypeNotEqualTo(String value) {
            addCriterion("STORGETYPE <>", value, "storgetype");
            return (Criteria) this;
        }

        public Criteria andStorgetypeGreaterThan(String value) {
            addCriterion("STORGETYPE >", value, "storgetype");
            return (Criteria) this;
        }

        public Criteria andStorgetypeGreaterThanOrEqualTo(String value) {
            addCriterion("STORGETYPE >=", value, "storgetype");
            return (Criteria) this;
        }

        public Criteria andStorgetypeLessThan(String value) {
            addCriterion("STORGETYPE <", value, "storgetype");
            return (Criteria) this;
        }

        public Criteria andStorgetypeLessThanOrEqualTo(String value) {
            addCriterion("STORGETYPE <=", value, "storgetype");
            return (Criteria) this;
        }

        public Criteria andStorgetypeLike(String value) {
            addCriterion("STORGETYPE like", value, "storgetype");
            return (Criteria) this;
        }

        public Criteria andStorgetypeNotLike(String value) {
            addCriterion("STORGETYPE not like", value, "storgetype");
            return (Criteria) this;
        }

        public Criteria andStorgetypeIn(List<String> values) {
            addCriterion("STORGETYPE in", values, "storgetype");
            return (Criteria) this;
        }

        public Criteria andStorgetypeNotIn(List<String> values) {
            addCriterion("STORGETYPE not in", values, "storgetype");
            return (Criteria) this;
        }

        public Criteria andStorgetypeBetween(String value1, String value2) {
            addCriterion("STORGETYPE between", value1, value2, "storgetype");
            return (Criteria) this;
        }

        public Criteria andStorgetypeNotBetween(String value1, String value2) {
            addCriterion("STORGETYPE not between", value1, value2, "storgetype");
            return (Criteria) this;
        }

        public Criteria andPrikeypwdIsNull() {
            addCriterion("PRIKEYPWD is null");
            return (Criteria) this;
        }

        public Criteria andPrikeypwdIsNotNull() {
            addCriterion("PRIKEYPWD is not null");
            return (Criteria) this;
        }

        public Criteria andPrikeypwdEqualTo(String value) {
            addCriterion("PRIKEYPWD =", value, "prikeypwd");
            return (Criteria) this;
        }

        public Criteria andPrikeypwdNotEqualTo(String value) {
            addCriterion("PRIKEYPWD <>", value, "prikeypwd");
            return (Criteria) this;
        }

        public Criteria andPrikeypwdGreaterThan(String value) {
            addCriterion("PRIKEYPWD >", value, "prikeypwd");
            return (Criteria) this;
        }

        public Criteria andPrikeypwdGreaterThanOrEqualTo(String value) {
            addCriterion("PRIKEYPWD >=", value, "prikeypwd");
            return (Criteria) this;
        }

        public Criteria andPrikeypwdLessThan(String value) {
            addCriterion("PRIKEYPWD <", value, "prikeypwd");
            return (Criteria) this;
        }

        public Criteria andPrikeypwdLessThanOrEqualTo(String value) {
            addCriterion("PRIKEYPWD <=", value, "prikeypwd");
            return (Criteria) this;
        }

        public Criteria andPrikeypwdLike(String value) {
            addCriterion("PRIKEYPWD like", value, "prikeypwd");
            return (Criteria) this;
        }

        public Criteria andPrikeypwdNotLike(String value) {
            addCriterion("PRIKEYPWD not like", value, "prikeypwd");
            return (Criteria) this;
        }

        public Criteria andPrikeypwdIn(List<String> values) {
            addCriterion("PRIKEYPWD in", values, "prikeypwd");
            return (Criteria) this;
        }

        public Criteria andPrikeypwdNotIn(List<String> values) {
            addCriterion("PRIKEYPWD not in", values, "prikeypwd");
            return (Criteria) this;
        }

        public Criteria andPrikeypwdBetween(String value1, String value2) {
            addCriterion("PRIKEYPWD between", value1, value2, "prikeypwd");
            return (Criteria) this;
        }

        public Criteria andPrikeypwdNotBetween(String value1, String value2) {
            addCriterion("PRIKEYPWD not between", value1, value2, "prikeypwd");
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

        public Criteria andInuserEqualTo(Integer value) {
            addCriterion("INUSER =", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserNotEqualTo(Integer value) {
            addCriterion("INUSER <>", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserGreaterThan(Integer value) {
            addCriterion("INUSER >", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserGreaterThanOrEqualTo(Integer value) {
            addCriterion("INUSER >=", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserLessThan(Integer value) {
            addCriterion("INUSER <", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserLessThanOrEqualTo(Integer value) {
            addCriterion("INUSER <=", value, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserIn(List<Integer> values) {
            addCriterion("INUSER in", values, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserNotIn(List<Integer> values) {
            addCriterion("INUSER not in", values, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserBetween(Integer value1, Integer value2) {
            addCriterion("INUSER between", value1, value2, "inuser");
            return (Criteria) this;
        }

        public Criteria andInuserNotBetween(Integer value1, Integer value2) {
            addCriterion("INUSER not between", value1, value2, "inuser");
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