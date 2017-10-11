package com.unionpay.withhold.trade.pay.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderDownloadCheckFileDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderDownloadCheckFileDOExample() {
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

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("VERSION like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("VERSION not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andEncodingIsNull() {
            addCriterion("ENCODING is null");
            return (Criteria) this;
        }

        public Criteria andEncodingIsNotNull() {
            addCriterion("ENCODING is not null");
            return (Criteria) this;
        }

        public Criteria andEncodingEqualTo(String value) {
            addCriterion("ENCODING =", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingNotEqualTo(String value) {
            addCriterion("ENCODING <>", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingGreaterThan(String value) {
            addCriterion("ENCODING >", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingGreaterThanOrEqualTo(String value) {
            addCriterion("ENCODING >=", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingLessThan(String value) {
            addCriterion("ENCODING <", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingLessThanOrEqualTo(String value) {
            addCriterion("ENCODING <=", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingLike(String value) {
            addCriterion("ENCODING like", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingNotLike(String value) {
            addCriterion("ENCODING not like", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingIn(List<String> values) {
            addCriterion("ENCODING in", values, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingNotIn(List<String> values) {
            addCriterion("ENCODING not in", values, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingBetween(String value1, String value2) {
            addCriterion("ENCODING between", value1, value2, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingNotBetween(String value1, String value2) {
            addCriterion("ENCODING not between", value1, value2, "encoding");
            return (Criteria) this;
        }

        public Criteria andCertIdIsNull() {
            addCriterion("CERT_ID is null");
            return (Criteria) this;
        }

        public Criteria andCertIdIsNotNull() {
            addCriterion("CERT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCertIdEqualTo(String value) {
            addCriterion("CERT_ID =", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdNotEqualTo(String value) {
            addCriterion("CERT_ID <>", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdGreaterThan(String value) {
            addCriterion("CERT_ID >", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_ID >=", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdLessThan(String value) {
            addCriterion("CERT_ID <", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdLessThanOrEqualTo(String value) {
            addCriterion("CERT_ID <=", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdLike(String value) {
            addCriterion("CERT_ID like", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdNotLike(String value) {
            addCriterion("CERT_ID not like", value, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdIn(List<String> values) {
            addCriterion("CERT_ID in", values, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdNotIn(List<String> values) {
            addCriterion("CERT_ID not in", values, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdBetween(String value1, String value2) {
            addCriterion("CERT_ID between", value1, value2, "certId");
            return (Criteria) this;
        }

        public Criteria andCertIdNotBetween(String value1, String value2) {
            addCriterion("CERT_ID not between", value1, value2, "certId");
            return (Criteria) this;
        }

        public Criteria andSignMethodIsNull() {
            addCriterion("SIGN_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andSignMethodIsNotNull() {
            addCriterion("SIGN_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andSignMethodEqualTo(String value) {
            addCriterion("SIGN_METHOD =", value, "signMethod");
            return (Criteria) this;
        }

        public Criteria andSignMethodNotEqualTo(String value) {
            addCriterion("SIGN_METHOD <>", value, "signMethod");
            return (Criteria) this;
        }

        public Criteria andSignMethodGreaterThan(String value) {
            addCriterion("SIGN_METHOD >", value, "signMethod");
            return (Criteria) this;
        }

        public Criteria andSignMethodGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_METHOD >=", value, "signMethod");
            return (Criteria) this;
        }

        public Criteria andSignMethodLessThan(String value) {
            addCriterion("SIGN_METHOD <", value, "signMethod");
            return (Criteria) this;
        }

        public Criteria andSignMethodLessThanOrEqualTo(String value) {
            addCriterion("SIGN_METHOD <=", value, "signMethod");
            return (Criteria) this;
        }

        public Criteria andSignMethodLike(String value) {
            addCriterion("SIGN_METHOD like", value, "signMethod");
            return (Criteria) this;
        }

        public Criteria andSignMethodNotLike(String value) {
            addCriterion("SIGN_METHOD not like", value, "signMethod");
            return (Criteria) this;
        }

        public Criteria andSignMethodIn(List<String> values) {
            addCriterion("SIGN_METHOD in", values, "signMethod");
            return (Criteria) this;
        }

        public Criteria andSignMethodNotIn(List<String> values) {
            addCriterion("SIGN_METHOD not in", values, "signMethod");
            return (Criteria) this;
        }

        public Criteria andSignMethodBetween(String value1, String value2) {
            addCriterion("SIGN_METHOD between", value1, value2, "signMethod");
            return (Criteria) this;
        }

        public Criteria andSignMethodNotBetween(String value1, String value2) {
            addCriterion("SIGN_METHOD not between", value1, value2, "signMethod");
            return (Criteria) this;
        }

        public Criteria andTransTypeIsNull() {
            addCriterion("TRANS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTransTypeIsNotNull() {
            addCriterion("TRANS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTransTypeEqualTo(String value) {
            addCriterion("TRANS_TYPE =", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotEqualTo(String value) {
            addCriterion("TRANS_TYPE <>", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThan(String value) {
            addCriterion("TRANS_TYPE >", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TRANS_TYPE >=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThan(String value) {
            addCriterion("TRANS_TYPE <", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThanOrEqualTo(String value) {
            addCriterion("TRANS_TYPE <=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLike(String value) {
            addCriterion("TRANS_TYPE like", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotLike(String value) {
            addCriterion("TRANS_TYPE not like", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeIn(List<String> values) {
            addCriterion("TRANS_TYPE in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotIn(List<String> values) {
            addCriterion("TRANS_TYPE not in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeBetween(String value1, String value2) {
            addCriterion("TRANS_TYPE between", value1, value2, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotBetween(String value1, String value2) {
            addCriterion("TRANS_TYPE not between", value1, value2, "transType");
            return (Criteria) this;
        }

        public Criteria andMchntCdIsNull() {
            addCriterion("MCHNT_CD is null");
            return (Criteria) this;
        }

        public Criteria andMchntCdIsNotNull() {
            addCriterion("MCHNT_CD is not null");
            return (Criteria) this;
        }

        public Criteria andMchntCdEqualTo(String value) {
            addCriterion("MCHNT_CD =", value, "mchntCd");
            return (Criteria) this;
        }

        public Criteria andMchntCdNotEqualTo(String value) {
            addCriterion("MCHNT_CD <>", value, "mchntCd");
            return (Criteria) this;
        }

        public Criteria andMchntCdGreaterThan(String value) {
            addCriterion("MCHNT_CD >", value, "mchntCd");
            return (Criteria) this;
        }

        public Criteria andMchntCdGreaterThanOrEqualTo(String value) {
            addCriterion("MCHNT_CD >=", value, "mchntCd");
            return (Criteria) this;
        }

        public Criteria andMchntCdLessThan(String value) {
            addCriterion("MCHNT_CD <", value, "mchntCd");
            return (Criteria) this;
        }

        public Criteria andMchntCdLessThanOrEqualTo(String value) {
            addCriterion("MCHNT_CD <=", value, "mchntCd");
            return (Criteria) this;
        }

        public Criteria andMchntCdLike(String value) {
            addCriterion("MCHNT_CD like", value, "mchntCd");
            return (Criteria) this;
        }

        public Criteria andMchntCdNotLike(String value) {
            addCriterion("MCHNT_CD not like", value, "mchntCd");
            return (Criteria) this;
        }

        public Criteria andMchntCdIn(List<String> values) {
            addCriterion("MCHNT_CD in", values, "mchntCd");
            return (Criteria) this;
        }

        public Criteria andMchntCdNotIn(List<String> values) {
            addCriterion("MCHNT_CD not in", values, "mchntCd");
            return (Criteria) this;
        }

        public Criteria andMchntCdBetween(String value1, String value2) {
            addCriterion("MCHNT_CD between", value1, value2, "mchntCd");
            return (Criteria) this;
        }

        public Criteria andMchntCdNotBetween(String value1, String value2) {
            addCriterion("MCHNT_CD not between", value1, value2, "mchntCd");
            return (Criteria) this;
        }

        public Criteria andQueryIdIsNull() {
            addCriterion("QUERY_ID is null");
            return (Criteria) this;
        }

        public Criteria andQueryIdIsNotNull() {
            addCriterion("QUERY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andQueryIdEqualTo(String value) {
            addCriterion("QUERY_ID =", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdNotEqualTo(String value) {
            addCriterion("QUERY_ID <>", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdGreaterThan(String value) {
            addCriterion("QUERY_ID >", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdGreaterThanOrEqualTo(String value) {
            addCriterion("QUERY_ID >=", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdLessThan(String value) {
            addCriterion("QUERY_ID <", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdLessThanOrEqualTo(String value) {
            addCriterion("QUERY_ID <=", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdLike(String value) {
            addCriterion("QUERY_ID like", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdNotLike(String value) {
            addCriterion("QUERY_ID not like", value, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdIn(List<String> values) {
            addCriterion("QUERY_ID in", values, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdNotIn(List<String> values) {
            addCriterion("QUERY_ID not in", values, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdBetween(String value1, String value2) {
            addCriterion("QUERY_ID between", value1, value2, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryIdNotBetween(String value1, String value2) {
            addCriterion("QUERY_ID not between", value1, value2, "queryId");
            return (Criteria) this;
        }

        public Criteria andQueryDtIsNull() {
            addCriterion("QUERY_DT is null");
            return (Criteria) this;
        }

        public Criteria andQueryDtIsNotNull() {
            addCriterion("QUERY_DT is not null");
            return (Criteria) this;
        }

        public Criteria andQueryDtEqualTo(String value) {
            addCriterion("QUERY_DT =", value, "queryDt");
            return (Criteria) this;
        }

        public Criteria andQueryDtNotEqualTo(String value) {
            addCriterion("QUERY_DT <>", value, "queryDt");
            return (Criteria) this;
        }

        public Criteria andQueryDtGreaterThan(String value) {
            addCriterion("QUERY_DT >", value, "queryDt");
            return (Criteria) this;
        }

        public Criteria andQueryDtGreaterThanOrEqualTo(String value) {
            addCriterion("QUERY_DT >=", value, "queryDt");
            return (Criteria) this;
        }

        public Criteria andQueryDtLessThan(String value) {
            addCriterion("QUERY_DT <", value, "queryDt");
            return (Criteria) this;
        }

        public Criteria andQueryDtLessThanOrEqualTo(String value) {
            addCriterion("QUERY_DT <=", value, "queryDt");
            return (Criteria) this;
        }

        public Criteria andQueryDtLike(String value) {
            addCriterion("QUERY_DT like", value, "queryDt");
            return (Criteria) this;
        }

        public Criteria andQueryDtNotLike(String value) {
            addCriterion("QUERY_DT not like", value, "queryDt");
            return (Criteria) this;
        }

        public Criteria andQueryDtIn(List<String> values) {
            addCriterion("QUERY_DT in", values, "queryDt");
            return (Criteria) this;
        }

        public Criteria andQueryDtNotIn(List<String> values) {
            addCriterion("QUERY_DT not in", values, "queryDt");
            return (Criteria) this;
        }

        public Criteria andQueryDtBetween(String value1, String value2) {
            addCriterion("QUERY_DT between", value1, value2, "queryDt");
            return (Criteria) this;
        }

        public Criteria andQueryDtNotBetween(String value1, String value2) {
            addCriterion("QUERY_DT not between", value1, value2, "queryDt");
            return (Criteria) this;
        }

        public Criteria andTransDtIsNull() {
            addCriterion("TRANS_DT is null");
            return (Criteria) this;
        }

        public Criteria andTransDtIsNotNull() {
            addCriterion("TRANS_DT is not null");
            return (Criteria) this;
        }

        public Criteria andTransDtEqualTo(String value) {
            addCriterion("TRANS_DT =", value, "transDt");
            return (Criteria) this;
        }

        public Criteria andTransDtNotEqualTo(String value) {
            addCriterion("TRANS_DT <>", value, "transDt");
            return (Criteria) this;
        }

        public Criteria andTransDtGreaterThan(String value) {
            addCriterion("TRANS_DT >", value, "transDt");
            return (Criteria) this;
        }

        public Criteria andTransDtGreaterThanOrEqualTo(String value) {
            addCriterion("TRANS_DT >=", value, "transDt");
            return (Criteria) this;
        }

        public Criteria andTransDtLessThan(String value) {
            addCriterion("TRANS_DT <", value, "transDt");
            return (Criteria) this;
        }

        public Criteria andTransDtLessThanOrEqualTo(String value) {
            addCriterion("TRANS_DT <=", value, "transDt");
            return (Criteria) this;
        }

        public Criteria andTransDtLike(String value) {
            addCriterion("TRANS_DT like", value, "transDt");
            return (Criteria) this;
        }

        public Criteria andTransDtNotLike(String value) {
            addCriterion("TRANS_DT not like", value, "transDt");
            return (Criteria) this;
        }

        public Criteria andTransDtIn(List<String> values) {
            addCriterion("TRANS_DT in", values, "transDt");
            return (Criteria) this;
        }

        public Criteria andTransDtNotIn(List<String> values) {
            addCriterion("TRANS_DT not in", values, "transDt");
            return (Criteria) this;
        }

        public Criteria andTransDtBetween(String value1, String value2) {
            addCriterion("TRANS_DT between", value1, value2, "transDt");
            return (Criteria) this;
        }

        public Criteria andTransDtNotBetween(String value1, String value2) {
            addCriterion("TRANS_DT not between", value1, value2, "transDt");
            return (Criteria) this;
        }

        public Criteria andDlUrlIsNull() {
            addCriterion("DL_URL is null");
            return (Criteria) this;
        }

        public Criteria andDlUrlIsNotNull() {
            addCriterion("DL_URL is not null");
            return (Criteria) this;
        }

        public Criteria andDlUrlEqualTo(String value) {
            addCriterion("DL_URL =", value, "dlUrl");
            return (Criteria) this;
        }

        public Criteria andDlUrlNotEqualTo(String value) {
            addCriterion("DL_URL <>", value, "dlUrl");
            return (Criteria) this;
        }

        public Criteria andDlUrlGreaterThan(String value) {
            addCriterion("DL_URL >", value, "dlUrl");
            return (Criteria) this;
        }

        public Criteria andDlUrlGreaterThanOrEqualTo(String value) {
            addCriterion("DL_URL >=", value, "dlUrl");
            return (Criteria) this;
        }

        public Criteria andDlUrlLessThan(String value) {
            addCriterion("DL_URL <", value, "dlUrl");
            return (Criteria) this;
        }

        public Criteria andDlUrlLessThanOrEqualTo(String value) {
            addCriterion("DL_URL <=", value, "dlUrl");
            return (Criteria) this;
        }

        public Criteria andDlUrlLike(String value) {
            addCriterion("DL_URL like", value, "dlUrl");
            return (Criteria) this;
        }

        public Criteria andDlUrlNotLike(String value) {
            addCriterion("DL_URL not like", value, "dlUrl");
            return (Criteria) this;
        }

        public Criteria andDlUrlIn(List<String> values) {
            addCriterion("DL_URL in", values, "dlUrl");
            return (Criteria) this;
        }

        public Criteria andDlUrlNotIn(List<String> values) {
            addCriterion("DL_URL not in", values, "dlUrl");
            return (Criteria) this;
        }

        public Criteria andDlUrlBetween(String value1, String value2) {
            addCriterion("DL_URL between", value1, value2, "dlUrl");
            return (Criteria) this;
        }

        public Criteria andDlUrlNotBetween(String value1, String value2) {
            addCriterion("DL_URL not between", value1, value2, "dlUrl");
            return (Criteria) this;
        }

        public Criteria andRespcodeIsNull() {
            addCriterion("RESPCODE is null");
            return (Criteria) this;
        }

        public Criteria andRespcodeIsNotNull() {
            addCriterion("RESPCODE is not null");
            return (Criteria) this;
        }

        public Criteria andRespcodeEqualTo(String value) {
            addCriterion("RESPCODE =", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeNotEqualTo(String value) {
            addCriterion("RESPCODE <>", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeGreaterThan(String value) {
            addCriterion("RESPCODE >", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeGreaterThanOrEqualTo(String value) {
            addCriterion("RESPCODE >=", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeLessThan(String value) {
            addCriterion("RESPCODE <", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeLessThanOrEqualTo(String value) {
            addCriterion("RESPCODE <=", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeLike(String value) {
            addCriterion("RESPCODE like", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeNotLike(String value) {
            addCriterion("RESPCODE not like", value, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeIn(List<String> values) {
            addCriterion("RESPCODE in", values, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeNotIn(List<String> values) {
            addCriterion("RESPCODE not in", values, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeBetween(String value1, String value2) {
            addCriterion("RESPCODE between", value1, value2, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespcodeNotBetween(String value1, String value2) {
            addCriterion("RESPCODE not between", value1, value2, "respcode");
            return (Criteria) this;
        }

        public Criteria andRespmsgIsNull() {
            addCriterion("RESPMSG is null");
            return (Criteria) this;
        }

        public Criteria andRespmsgIsNotNull() {
            addCriterion("RESPMSG is not null");
            return (Criteria) this;
        }

        public Criteria andRespmsgEqualTo(String value) {
            addCriterion("RESPMSG =", value, "respmsg");
            return (Criteria) this;
        }

        public Criteria andRespmsgNotEqualTo(String value) {
            addCriterion("RESPMSG <>", value, "respmsg");
            return (Criteria) this;
        }

        public Criteria andRespmsgGreaterThan(String value) {
            addCriterion("RESPMSG >", value, "respmsg");
            return (Criteria) this;
        }

        public Criteria andRespmsgGreaterThanOrEqualTo(String value) {
            addCriterion("RESPMSG >=", value, "respmsg");
            return (Criteria) this;
        }

        public Criteria andRespmsgLessThan(String value) {
            addCriterion("RESPMSG <", value, "respmsg");
            return (Criteria) this;
        }

        public Criteria andRespmsgLessThanOrEqualTo(String value) {
            addCriterion("RESPMSG <=", value, "respmsg");
            return (Criteria) this;
        }

        public Criteria andRespmsgLike(String value) {
            addCriterion("RESPMSG like", value, "respmsg");
            return (Criteria) this;
        }

        public Criteria andRespmsgNotLike(String value) {
            addCriterion("RESPMSG not like", value, "respmsg");
            return (Criteria) this;
        }

        public Criteria andRespmsgIn(List<String> values) {
            addCriterion("RESPMSG in", values, "respmsg");
            return (Criteria) this;
        }

        public Criteria andRespmsgNotIn(List<String> values) {
            addCriterion("RESPMSG not in", values, "respmsg");
            return (Criteria) this;
        }

        public Criteria andRespmsgBetween(String value1, String value2) {
            addCriterion("RESPMSG between", value1, value2, "respmsg");
            return (Criteria) this;
        }

        public Criteria andRespmsgNotBetween(String value1, String value2) {
            addCriterion("RESPMSG not between", value1, value2, "respmsg");
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