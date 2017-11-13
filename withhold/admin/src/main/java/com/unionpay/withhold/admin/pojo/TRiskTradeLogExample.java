package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TRiskTradeLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRiskTradeLogExample() {
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

        public Criteria andRiskTradeTypeIsNull() {
            addCriterion("RISK_TRADE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRiskTradeTypeIsNotNull() {
            addCriterion("RISK_TRADE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRiskTradeTypeEqualTo(Integer value) {
            addCriterion("RISK_TRADE_TYPE =", value, "riskTradeType");
            return (Criteria) this;
        }

        public Criteria andRiskTradeTypeNotEqualTo(Integer value) {
            addCriterion("RISK_TRADE_TYPE <>", value, "riskTradeType");
            return (Criteria) this;
        }

        public Criteria andRiskTradeTypeGreaterThan(Integer value) {
            addCriterion("RISK_TRADE_TYPE >", value, "riskTradeType");
            return (Criteria) this;
        }

        public Criteria andRiskTradeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("RISK_TRADE_TYPE >=", value, "riskTradeType");
            return (Criteria) this;
        }

        public Criteria andRiskTradeTypeLessThan(Integer value) {
            addCriterion("RISK_TRADE_TYPE <", value, "riskTradeType");
            return (Criteria) this;
        }

        public Criteria andRiskTradeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("RISK_TRADE_TYPE <=", value, "riskTradeType");
            return (Criteria) this;
        }

        public Criteria andRiskTradeTypeIn(List<Integer> values) {
            addCriterion("RISK_TRADE_TYPE in", values, "riskTradeType");
            return (Criteria) this;
        }

        public Criteria andRiskTradeTypeNotIn(List<Integer> values) {
            addCriterion("RISK_TRADE_TYPE not in", values, "riskTradeType");
            return (Criteria) this;
        }

        public Criteria andRiskTradeTypeBetween(Integer value1, Integer value2) {
            addCriterion("RISK_TRADE_TYPE between", value1, value2, "riskTradeType");
            return (Criteria) this;
        }

        public Criteria andRiskTradeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("RISK_TRADE_TYPE not between", value1, value2, "riskTradeType");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoIsNull() {
            addCriterion("TXNSEQNO is null");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoIsNotNull() {
            addCriterion("TXNSEQNO is not null");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoEqualTo(String value) {
            addCriterion("TXNSEQNO =", value, "txnseqno");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoNotEqualTo(String value) {
            addCriterion("TXNSEQNO <>", value, "txnseqno");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoGreaterThan(String value) {
            addCriterion("TXNSEQNO >", value, "txnseqno");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoGreaterThanOrEqualTo(String value) {
            addCriterion("TXNSEQNO >=", value, "txnseqno");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoLessThan(String value) {
            addCriterion("TXNSEQNO <", value, "txnseqno");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoLessThanOrEqualTo(String value) {
            addCriterion("TXNSEQNO <=", value, "txnseqno");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoLike(String value) {
            addCriterion("TXNSEQNO like", value, "txnseqno");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoNotLike(String value) {
            addCriterion("TXNSEQNO not like", value, "txnseqno");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoIn(List<String> values) {
            addCriterion("TXNSEQNO in", values, "txnseqno");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoNotIn(List<String> values) {
            addCriterion("TXNSEQNO not in", values, "txnseqno");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoBetween(String value1, String value2) {
            addCriterion("TXNSEQNO between", value1, value2, "txnseqno");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoNotBetween(String value1, String value2) {
            addCriterion("TXNSEQNO not between", value1, value2, "txnseqno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNull() {
            addCriterion("ORDERNO is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("ORDERNO is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(String value) {
            addCriterion("ORDERNO =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(String value) {
            addCriterion("ORDERNO <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(String value) {
            addCriterion("ORDERNO >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDERNO >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(String value) {
            addCriterion("ORDERNO <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(String value) {
            addCriterion("ORDERNO <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLike(String value) {
            addCriterion("ORDERNO like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotLike(String value) {
            addCriterion("ORDERNO not like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<String> values) {
            addCriterion("ORDERNO in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<String> values) {
            addCriterion("ORDERNO not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(String value1, String value2) {
            addCriterion("ORDERNO between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(String value1, String value2) {
            addCriterion("ORDERNO not between", value1, value2, "orderno");
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

        public Criteria andMerchnameIsNull() {
            addCriterion("MERCHNAME is null");
            return (Criteria) this;
        }

        public Criteria andMerchnameIsNotNull() {
            addCriterion("MERCHNAME is not null");
            return (Criteria) this;
        }

        public Criteria andMerchnameEqualTo(String value) {
            addCriterion("MERCHNAME =", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameNotEqualTo(String value) {
            addCriterion("MERCHNAME <>", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameGreaterThan(String value) {
            addCriterion("MERCHNAME >", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHNAME >=", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameLessThan(String value) {
            addCriterion("MERCHNAME <", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameLessThanOrEqualTo(String value) {
            addCriterion("MERCHNAME <=", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameLike(String value) {
            addCriterion("MERCHNAME like", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameNotLike(String value) {
            addCriterion("MERCHNAME not like", value, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameIn(List<String> values) {
            addCriterion("MERCHNAME in", values, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameNotIn(List<String> values) {
            addCriterion("MERCHNAME not in", values, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameBetween(String value1, String value2) {
            addCriterion("MERCHNAME between", value1, value2, "merchname");
            return (Criteria) this;
        }

        public Criteria andMerchnameNotBetween(String value1, String value2) {
            addCriterion("MERCHNAME not between", value1, value2, "merchname");
            return (Criteria) this;
        }

        public Criteria andCacodeIsNull() {
            addCriterion("CACODE is null");
            return (Criteria) this;
        }

        public Criteria andCacodeIsNotNull() {
            addCriterion("CACODE is not null");
            return (Criteria) this;
        }

        public Criteria andCacodeEqualTo(String value) {
            addCriterion("CACODE =", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeNotEqualTo(String value) {
            addCriterion("CACODE <>", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeGreaterThan(String value) {
            addCriterion("CACODE >", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeGreaterThanOrEqualTo(String value) {
            addCriterion("CACODE >=", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeLessThan(String value) {
            addCriterion("CACODE <", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeLessThanOrEqualTo(String value) {
            addCriterion("CACODE <=", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeLike(String value) {
            addCriterion("CACODE like", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeNotLike(String value) {
            addCriterion("CACODE not like", value, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeIn(List<String> values) {
            addCriterion("CACODE in", values, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeNotIn(List<String> values) {
            addCriterion("CACODE not in", values, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeBetween(String value1, String value2) {
            addCriterion("CACODE between", value1, value2, "cacode");
            return (Criteria) this;
        }

        public Criteria andCacodeNotBetween(String value1, String value2) {
            addCriterion("CACODE not between", value1, value2, "cacode");
            return (Criteria) this;
        }

        public Criteria andCanameIsNull() {
            addCriterion("CANAME is null");
            return (Criteria) this;
        }

        public Criteria andCanameIsNotNull() {
            addCriterion("CANAME is not null");
            return (Criteria) this;
        }

        public Criteria andCanameEqualTo(String value) {
            addCriterion("CANAME =", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotEqualTo(String value) {
            addCriterion("CANAME <>", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameGreaterThan(String value) {
            addCriterion("CANAME >", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameGreaterThanOrEqualTo(String value) {
            addCriterion("CANAME >=", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameLessThan(String value) {
            addCriterion("CANAME <", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameLessThanOrEqualTo(String value) {
            addCriterion("CANAME <=", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameLike(String value) {
            addCriterion("CANAME like", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotLike(String value) {
            addCriterion("CANAME not like", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameIn(List<String> values) {
            addCriterion("CANAME in", values, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotIn(List<String> values) {
            addCriterion("CANAME not in", values, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameBetween(String value1, String value2) {
            addCriterion("CANAME between", value1, value2, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotBetween(String value1, String value2) {
            addCriterion("CANAME not between", value1, value2, "caname");
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

        public Criteria andChnlnameIsNull() {
            addCriterion("CHNLNAME is null");
            return (Criteria) this;
        }

        public Criteria andChnlnameIsNotNull() {
            addCriterion("CHNLNAME is not null");
            return (Criteria) this;
        }

        public Criteria andChnlnameEqualTo(String value) {
            addCriterion("CHNLNAME =", value, "chnlname");
            return (Criteria) this;
        }

        public Criteria andChnlnameNotEqualTo(String value) {
            addCriterion("CHNLNAME <>", value, "chnlname");
            return (Criteria) this;
        }

        public Criteria andChnlnameGreaterThan(String value) {
            addCriterion("CHNLNAME >", value, "chnlname");
            return (Criteria) this;
        }

        public Criteria andChnlnameGreaterThanOrEqualTo(String value) {
            addCriterion("CHNLNAME >=", value, "chnlname");
            return (Criteria) this;
        }

        public Criteria andChnlnameLessThan(String value) {
            addCriterion("CHNLNAME <", value, "chnlname");
            return (Criteria) this;
        }

        public Criteria andChnlnameLessThanOrEqualTo(String value) {
            addCriterion("CHNLNAME <=", value, "chnlname");
            return (Criteria) this;
        }

        public Criteria andChnlnameLike(String value) {
            addCriterion("CHNLNAME like", value, "chnlname");
            return (Criteria) this;
        }

        public Criteria andChnlnameNotLike(String value) {
            addCriterion("CHNLNAME not like", value, "chnlname");
            return (Criteria) this;
        }

        public Criteria andChnlnameIn(List<String> values) {
            addCriterion("CHNLNAME in", values, "chnlname");
            return (Criteria) this;
        }

        public Criteria andChnlnameNotIn(List<String> values) {
            addCriterion("CHNLNAME not in", values, "chnlname");
            return (Criteria) this;
        }

        public Criteria andChnlnameBetween(String value1, String value2) {
            addCriterion("CHNLNAME between", value1, value2, "chnlname");
            return (Criteria) this;
        }

        public Criteria andChnlnameNotBetween(String value1, String value2) {
            addCriterion("CHNLNAME not between", value1, value2, "chnlname");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andPanIsNull() {
            addCriterion("PAN is null");
            return (Criteria) this;
        }

        public Criteria andPanIsNotNull() {
            addCriterion("PAN is not null");
            return (Criteria) this;
        }

        public Criteria andPanEqualTo(String value) {
            addCriterion("PAN =", value, "pan");
            return (Criteria) this;
        }

        public Criteria andPanNotEqualTo(String value) {
            addCriterion("PAN <>", value, "pan");
            return (Criteria) this;
        }

        public Criteria andPanGreaterThan(String value) {
            addCriterion("PAN >", value, "pan");
            return (Criteria) this;
        }

        public Criteria andPanGreaterThanOrEqualTo(String value) {
            addCriterion("PAN >=", value, "pan");
            return (Criteria) this;
        }

        public Criteria andPanLessThan(String value) {
            addCriterion("PAN <", value, "pan");
            return (Criteria) this;
        }

        public Criteria andPanLessThanOrEqualTo(String value) {
            addCriterion("PAN <=", value, "pan");
            return (Criteria) this;
        }

        public Criteria andPanLike(String value) {
            addCriterion("PAN like", value, "pan");
            return (Criteria) this;
        }

        public Criteria andPanNotLike(String value) {
            addCriterion("PAN not like", value, "pan");
            return (Criteria) this;
        }

        public Criteria andPanIn(List<String> values) {
            addCriterion("PAN in", values, "pan");
            return (Criteria) this;
        }

        public Criteria andPanNotIn(List<String> values) {
            addCriterion("PAN not in", values, "pan");
            return (Criteria) this;
        }

        public Criteria andPanBetween(String value1, String value2) {
            addCriterion("PAN between", value1, value2, "pan");
            return (Criteria) this;
        }

        public Criteria andPanNotBetween(String value1, String value2) {
            addCriterion("PAN not between", value1, value2, "pan");
            return (Criteria) this;
        }

        public Criteria andTradeRiskLevelIsNull() {
            addCriterion("TRADE_RISK_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andTradeRiskLevelIsNotNull() {
            addCriterion("TRADE_RISK_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andTradeRiskLevelEqualTo(Integer value) {
            addCriterion("TRADE_RISK_LEVEL =", value, "tradeRiskLevel");
            return (Criteria) this;
        }

        public Criteria andTradeRiskLevelNotEqualTo(Integer value) {
            addCriterion("TRADE_RISK_LEVEL <>", value, "tradeRiskLevel");
            return (Criteria) this;
        }

        public Criteria andTradeRiskLevelGreaterThan(Integer value) {
            addCriterion("TRADE_RISK_LEVEL >", value, "tradeRiskLevel");
            return (Criteria) this;
        }

        public Criteria andTradeRiskLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRADE_RISK_LEVEL >=", value, "tradeRiskLevel");
            return (Criteria) this;
        }

        public Criteria andTradeRiskLevelLessThan(Integer value) {
            addCriterion("TRADE_RISK_LEVEL <", value, "tradeRiskLevel");
            return (Criteria) this;
        }

        public Criteria andTradeRiskLevelLessThanOrEqualTo(Integer value) {
            addCriterion("TRADE_RISK_LEVEL <=", value, "tradeRiskLevel");
            return (Criteria) this;
        }

        public Criteria andTradeRiskLevelIn(List<Integer> values) {
            addCriterion("TRADE_RISK_LEVEL in", values, "tradeRiskLevel");
            return (Criteria) this;
        }

        public Criteria andTradeRiskLevelNotIn(List<Integer> values) {
            addCriterion("TRADE_RISK_LEVEL not in", values, "tradeRiskLevel");
            return (Criteria) this;
        }

        public Criteria andTradeRiskLevelBetween(Integer value1, Integer value2) {
            addCriterion("TRADE_RISK_LEVEL between", value1, value2, "tradeRiskLevel");
            return (Criteria) this;
        }

        public Criteria andTradeRiskLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("TRADE_RISK_LEVEL not between", value1, value2, "tradeRiskLevel");
            return (Criteria) this;
        }

        public Criteria andCardIssuerCodeIsNull() {
            addCriterion("CARD_ISSUER_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCardIssuerCodeIsNotNull() {
            addCriterion("CARD_ISSUER_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCardIssuerCodeEqualTo(String value) {
            addCriterion("CARD_ISSUER_CODE =", value, "cardIssuerCode");
            return (Criteria) this;
        }

        public Criteria andCardIssuerCodeNotEqualTo(String value) {
            addCriterion("CARD_ISSUER_CODE <>", value, "cardIssuerCode");
            return (Criteria) this;
        }

        public Criteria andCardIssuerCodeGreaterThan(String value) {
            addCriterion("CARD_ISSUER_CODE >", value, "cardIssuerCode");
            return (Criteria) this;
        }

        public Criteria andCardIssuerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_ISSUER_CODE >=", value, "cardIssuerCode");
            return (Criteria) this;
        }

        public Criteria andCardIssuerCodeLessThan(String value) {
            addCriterion("CARD_ISSUER_CODE <", value, "cardIssuerCode");
            return (Criteria) this;
        }

        public Criteria andCardIssuerCodeLessThanOrEqualTo(String value) {
            addCriterion("CARD_ISSUER_CODE <=", value, "cardIssuerCode");
            return (Criteria) this;
        }

        public Criteria andCardIssuerCodeLike(String value) {
            addCriterion("CARD_ISSUER_CODE like", value, "cardIssuerCode");
            return (Criteria) this;
        }

        public Criteria andCardIssuerCodeNotLike(String value) {
            addCriterion("CARD_ISSUER_CODE not like", value, "cardIssuerCode");
            return (Criteria) this;
        }

        public Criteria andCardIssuerCodeIn(List<String> values) {
            addCriterion("CARD_ISSUER_CODE in", values, "cardIssuerCode");
            return (Criteria) this;
        }

        public Criteria andCardIssuerCodeNotIn(List<String> values) {
            addCriterion("CARD_ISSUER_CODE not in", values, "cardIssuerCode");
            return (Criteria) this;
        }

        public Criteria andCardIssuerCodeBetween(String value1, String value2) {
            addCriterion("CARD_ISSUER_CODE between", value1, value2, "cardIssuerCode");
            return (Criteria) this;
        }

        public Criteria andCardIssuerCodeNotBetween(String value1, String value2) {
            addCriterion("CARD_ISSUER_CODE not between", value1, value2, "cardIssuerCode");
            return (Criteria) this;
        }

        public Criteria andCardIssuerNameIsNull() {
            addCriterion("CARD_ISSUER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCardIssuerNameIsNotNull() {
            addCriterion("CARD_ISSUER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCardIssuerNameEqualTo(String value) {
            addCriterion("CARD_ISSUER_NAME =", value, "cardIssuerName");
            return (Criteria) this;
        }

        public Criteria andCardIssuerNameNotEqualTo(String value) {
            addCriterion("CARD_ISSUER_NAME <>", value, "cardIssuerName");
            return (Criteria) this;
        }

        public Criteria andCardIssuerNameGreaterThan(String value) {
            addCriterion("CARD_ISSUER_NAME >", value, "cardIssuerName");
            return (Criteria) this;
        }

        public Criteria andCardIssuerNameGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_ISSUER_NAME >=", value, "cardIssuerName");
            return (Criteria) this;
        }

        public Criteria andCardIssuerNameLessThan(String value) {
            addCriterion("CARD_ISSUER_NAME <", value, "cardIssuerName");
            return (Criteria) this;
        }

        public Criteria andCardIssuerNameLessThanOrEqualTo(String value) {
            addCriterion("CARD_ISSUER_NAME <=", value, "cardIssuerName");
            return (Criteria) this;
        }

        public Criteria andCardIssuerNameLike(String value) {
            addCriterion("CARD_ISSUER_NAME like", value, "cardIssuerName");
            return (Criteria) this;
        }

        public Criteria andCardIssuerNameNotLike(String value) {
            addCriterion("CARD_ISSUER_NAME not like", value, "cardIssuerName");
            return (Criteria) this;
        }

        public Criteria andCardIssuerNameIn(List<String> values) {
            addCriterion("CARD_ISSUER_NAME in", values, "cardIssuerName");
            return (Criteria) this;
        }

        public Criteria andCardIssuerNameNotIn(List<String> values) {
            addCriterion("CARD_ISSUER_NAME not in", values, "cardIssuerName");
            return (Criteria) this;
        }

        public Criteria andCardIssuerNameBetween(String value1, String value2) {
            addCriterion("CARD_ISSUER_NAME between", value1, value2, "cardIssuerName");
            return (Criteria) this;
        }

        public Criteria andCardIssuerNameNotBetween(String value1, String value2) {
            addCriterion("CARD_ISSUER_NAME not between", value1, value2, "cardIssuerName");
            return (Criteria) this;
        }

        public Criteria andAcqdatetimeIsNull() {
            addCriterion("ACQDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andAcqdatetimeIsNotNull() {
            addCriterion("ACQDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andAcqdatetimeEqualTo(String value) {
            addCriterion("ACQDATETIME =", value, "acqdatetime");
            return (Criteria) this;
        }

        public Criteria andAcqdatetimeNotEqualTo(String value) {
            addCriterion("ACQDATETIME <>", value, "acqdatetime");
            return (Criteria) this;
        }

        public Criteria andAcqdatetimeGreaterThan(String value) {
            addCriterion("ACQDATETIME >", value, "acqdatetime");
            return (Criteria) this;
        }

        public Criteria andAcqdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("ACQDATETIME >=", value, "acqdatetime");
            return (Criteria) this;
        }

        public Criteria andAcqdatetimeLessThan(String value) {
            addCriterion("ACQDATETIME <", value, "acqdatetime");
            return (Criteria) this;
        }

        public Criteria andAcqdatetimeLessThanOrEqualTo(String value) {
            addCriterion("ACQDATETIME <=", value, "acqdatetime");
            return (Criteria) this;
        }

        public Criteria andAcqdatetimeLike(String value) {
            addCriterion("ACQDATETIME like", value, "acqdatetime");
            return (Criteria) this;
        }

        public Criteria andAcqdatetimeNotLike(String value) {
            addCriterion("ACQDATETIME not like", value, "acqdatetime");
            return (Criteria) this;
        }

        public Criteria andAcqdatetimeIn(List<String> values) {
            addCriterion("ACQDATETIME in", values, "acqdatetime");
            return (Criteria) this;
        }

        public Criteria andAcqdatetimeNotIn(List<String> values) {
            addCriterion("ACQDATETIME not in", values, "acqdatetime");
            return (Criteria) this;
        }

        public Criteria andAcqdatetimeBetween(String value1, String value2) {
            addCriterion("ACQDATETIME between", value1, value2, "acqdatetime");
            return (Criteria) this;
        }

        public Criteria andAcqdatetimeNotBetween(String value1, String value2) {
            addCriterion("ACQDATETIME not between", value1, value2, "acqdatetime");
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

        public Criteria andResinfoIsNull() {
            addCriterion("RESINFO is null");
            return (Criteria) this;
        }

        public Criteria andResinfoIsNotNull() {
            addCriterion("RESINFO is not null");
            return (Criteria) this;
        }

        public Criteria andResinfoEqualTo(String value) {
            addCriterion("RESINFO =", value, "resinfo");
            return (Criteria) this;
        }

        public Criteria andResinfoNotEqualTo(String value) {
            addCriterion("RESINFO <>", value, "resinfo");
            return (Criteria) this;
        }

        public Criteria andResinfoGreaterThan(String value) {
            addCriterion("RESINFO >", value, "resinfo");
            return (Criteria) this;
        }

        public Criteria andResinfoGreaterThanOrEqualTo(String value) {
            addCriterion("RESINFO >=", value, "resinfo");
            return (Criteria) this;
        }

        public Criteria andResinfoLessThan(String value) {
            addCriterion("RESINFO <", value, "resinfo");
            return (Criteria) this;
        }

        public Criteria andResinfoLessThanOrEqualTo(String value) {
            addCriterion("RESINFO <=", value, "resinfo");
            return (Criteria) this;
        }

        public Criteria andResinfoLike(String value) {
            addCriterion("RESINFO like", value, "resinfo");
            return (Criteria) this;
        }

        public Criteria andResinfoNotLike(String value) {
            addCriterion("RESINFO not like", value, "resinfo");
            return (Criteria) this;
        }

        public Criteria andResinfoIn(List<String> values) {
            addCriterion("RESINFO in", values, "resinfo");
            return (Criteria) this;
        }

        public Criteria andResinfoNotIn(List<String> values) {
            addCriterion("RESINFO not in", values, "resinfo");
            return (Criteria) this;
        }

        public Criteria andResinfoBetween(String value1, String value2) {
            addCriterion("RESINFO between", value1, value2, "resinfo");
            return (Criteria) this;
        }

        public Criteria andResinfoNotBetween(String value1, String value2) {
            addCriterion("RESINFO not between", value1, value2, "resinfo");
            return (Criteria) this;
        }

        public Criteria andRescodeIsNull() {
            addCriterion("RESCODE is null");
            return (Criteria) this;
        }

        public Criteria andRescodeIsNotNull() {
            addCriterion("RESCODE is not null");
            return (Criteria) this;
        }

        public Criteria andRescodeEqualTo(String value) {
            addCriterion("RESCODE =", value, "rescode");
            return (Criteria) this;
        }

        public Criteria andRescodeNotEqualTo(String value) {
            addCriterion("RESCODE <>", value, "rescode");
            return (Criteria) this;
        }

        public Criteria andRescodeGreaterThan(String value) {
            addCriterion("RESCODE >", value, "rescode");
            return (Criteria) this;
        }

        public Criteria andRescodeGreaterThanOrEqualTo(String value) {
            addCriterion("RESCODE >=", value, "rescode");
            return (Criteria) this;
        }

        public Criteria andRescodeLessThan(String value) {
            addCriterion("RESCODE <", value, "rescode");
            return (Criteria) this;
        }

        public Criteria andRescodeLessThanOrEqualTo(String value) {
            addCriterion("RESCODE <=", value, "rescode");
            return (Criteria) this;
        }

        public Criteria andRescodeLike(String value) {
            addCriterion("RESCODE like", value, "rescode");
            return (Criteria) this;
        }

        public Criteria andRescodeNotLike(String value) {
            addCriterion("RESCODE not like", value, "rescode");
            return (Criteria) this;
        }

        public Criteria andRescodeIn(List<String> values) {
            addCriterion("RESCODE in", values, "rescode");
            return (Criteria) this;
        }

        public Criteria andRescodeNotIn(List<String> values) {
            addCriterion("RESCODE not in", values, "rescode");
            return (Criteria) this;
        }

        public Criteria andRescodeBetween(String value1, String value2) {
            addCriterion("RESCODE between", value1, value2, "rescode");
            return (Criteria) this;
        }

        public Criteria andRescodeNotBetween(String value1, String value2) {
            addCriterion("RESCODE not between", value1, value2, "rescode");
            return (Criteria) this;
        }

        public Criteria andStrategyIsNull() {
            addCriterion("STRATEGY is null");
            return (Criteria) this;
        }

        public Criteria andStrategyIsNotNull() {
            addCriterion("STRATEGY is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyEqualTo(String value) {
            addCriterion("STRATEGY =", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotEqualTo(String value) {
            addCriterion("STRATEGY <>", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyGreaterThan(String value) {
            addCriterion("STRATEGY >", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyGreaterThanOrEqualTo(String value) {
            addCriterion("STRATEGY >=", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyLessThan(String value) {
            addCriterion("STRATEGY <", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyLessThanOrEqualTo(String value) {
            addCriterion("STRATEGY <=", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyLike(String value) {
            addCriterion("STRATEGY like", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotLike(String value) {
            addCriterion("STRATEGY not like", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyIn(List<String> values) {
            addCriterion("STRATEGY in", values, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotIn(List<String> values) {
            addCriterion("STRATEGY not in", values, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyBetween(String value1, String value2) {
            addCriterion("STRATEGY between", value1, value2, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotBetween(String value1, String value2) {
            addCriterion("STRATEGY not between", value1, value2, "strategy");
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
    /**添加分页查询**/
    private int pageNum;
	private int pageSize;
	private int beginRow;
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getBeginRow() {
		// 在mapper.xml使用begin属性时，对其进行计算
		return (pageNum - 1) * pageSize;
	}
	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
	/**添加条件查询**/
	
}