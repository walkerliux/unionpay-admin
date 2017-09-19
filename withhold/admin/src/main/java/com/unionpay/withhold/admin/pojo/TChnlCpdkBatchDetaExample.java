package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TChnlCpdkBatchDetaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TChnlCpdkBatchDetaExample() {
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

        public Criteria andBatchnoIsNull() {
            addCriterion("batchNo is null");
            return (Criteria) this;
        }

        public Criteria andBatchnoIsNotNull() {
            addCriterion("batchNo is not null");
            return (Criteria) this;
        }

        public Criteria andBatchnoEqualTo(String value) {
            addCriterion("batchNo =", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotEqualTo(String value) {
            addCriterion("batchNo <>", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoGreaterThan(String value) {
            addCriterion("batchNo >", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoGreaterThanOrEqualTo(String value) {
            addCriterion("batchNo >=", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoLessThan(String value) {
            addCriterion("batchNo <", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoLessThanOrEqualTo(String value) {
            addCriterion("batchNo <=", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoLike(String value) {
            addCriterion("batchNo like", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotLike(String value) {
            addCriterion("batchNo not like", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoIn(List<String> values) {
            addCriterion("batchNo in", values, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotIn(List<String> values) {
            addCriterion("batchNo not in", values, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoBetween(String value1, String value2) {
            addCriterion("batchNo between", value1, value2, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotBetween(String value1, String value2) {
            addCriterion("batchNo not between", value1, value2, "batchno");
            return (Criteria) this;
        }

        public Criteria andTransdateIsNull() {
            addCriterion("transDate is null");
            return (Criteria) this;
        }

        public Criteria andTransdateIsNotNull() {
            addCriterion("transDate is not null");
            return (Criteria) this;
        }

        public Criteria andTransdateEqualTo(String value) {
            addCriterion("transDate =", value, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateNotEqualTo(String value) {
            addCriterion("transDate <>", value, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateGreaterThan(String value) {
            addCriterion("transDate >", value, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateGreaterThanOrEqualTo(String value) {
            addCriterion("transDate >=", value, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateLessThan(String value) {
            addCriterion("transDate <", value, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateLessThanOrEqualTo(String value) {
            addCriterion("transDate <=", value, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateLike(String value) {
            addCriterion("transDate like", value, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateNotLike(String value) {
            addCriterion("transDate not like", value, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateIn(List<String> values) {
            addCriterion("transDate in", values, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateNotIn(List<String> values) {
            addCriterion("transDate not in", values, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateBetween(String value1, String value2) {
            addCriterion("transDate between", value1, value2, "transdate");
            return (Criteria) this;
        }

        public Criteria andTransdateNotBetween(String value1, String value2) {
            addCriterion("transDate not between", value1, value2, "transdate");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNull() {
            addCriterion("orderNo is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("orderNo is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(String value) {
            addCriterion("orderNo =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(String value) {
            addCriterion("orderNo <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(String value) {
            addCriterion("orderNo >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(String value) {
            addCriterion("orderNo >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(String value) {
            addCriterion("orderNo <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(String value) {
            addCriterion("orderNo <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLike(String value) {
            addCriterion("orderNo like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotLike(String value) {
            addCriterion("orderNo not like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<String> values) {
            addCriterion("orderNo in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<String> values) {
            addCriterion("orderNo not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(String value1, String value2) {
            addCriterion("orderNo between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(String value1, String value2) {
            addCriterion("orderNo not between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOpenbankidIsNull() {
            addCriterion("openBankId is null");
            return (Criteria) this;
        }

        public Criteria andOpenbankidIsNotNull() {
            addCriterion("openBankId is not null");
            return (Criteria) this;
        }

        public Criteria andOpenbankidEqualTo(String value) {
            addCriterion("openBankId =", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidNotEqualTo(String value) {
            addCriterion("openBankId <>", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidGreaterThan(String value) {
            addCriterion("openBankId >", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidGreaterThanOrEqualTo(String value) {
            addCriterion("openBankId >=", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidLessThan(String value) {
            addCriterion("openBankId <", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidLessThanOrEqualTo(String value) {
            addCriterion("openBankId <=", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidLike(String value) {
            addCriterion("openBankId like", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidNotLike(String value) {
            addCriterion("openBankId not like", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidIn(List<String> values) {
            addCriterion("openBankId in", values, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidNotIn(List<String> values) {
            addCriterion("openBankId not in", values, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidBetween(String value1, String value2) {
            addCriterion("openBankId between", value1, value2, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidNotBetween(String value1, String value2) {
            addCriterion("openBankId not between", value1, value2, "openbankid");
            return (Criteria) this;
        }

        public Criteria andCardtypeIsNull() {
            addCriterion("cardType is null");
            return (Criteria) this;
        }

        public Criteria andCardtypeIsNotNull() {
            addCriterion("cardType is not null");
            return (Criteria) this;
        }

        public Criteria andCardtypeEqualTo(String value) {
            addCriterion("cardType =", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotEqualTo(String value) {
            addCriterion("cardType <>", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeGreaterThan(String value) {
            addCriterion("cardType >", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeGreaterThanOrEqualTo(String value) {
            addCriterion("cardType >=", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLessThan(String value) {
            addCriterion("cardType <", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLessThanOrEqualTo(String value) {
            addCriterion("cardType <=", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLike(String value) {
            addCriterion("cardType like", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotLike(String value) {
            addCriterion("cardType not like", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeIn(List<String> values) {
            addCriterion("cardType in", values, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotIn(List<String> values) {
            addCriterion("cardType not in", values, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeBetween(String value1, String value2) {
            addCriterion("cardType between", value1, value2, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotBetween(String value1, String value2) {
            addCriterion("cardType not between", value1, value2, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardnoIsNull() {
            addCriterion("cardNo is null");
            return (Criteria) this;
        }

        public Criteria andCardnoIsNotNull() {
            addCriterion("cardNo is not null");
            return (Criteria) this;
        }

        public Criteria andCardnoEqualTo(String value) {
            addCriterion("cardNo =", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotEqualTo(String value) {
            addCriterion("cardNo <>", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoGreaterThan(String value) {
            addCriterion("cardNo >", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoGreaterThanOrEqualTo(String value) {
            addCriterion("cardNo >=", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLessThan(String value) {
            addCriterion("cardNo <", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLessThanOrEqualTo(String value) {
            addCriterion("cardNo <=", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLike(String value) {
            addCriterion("cardNo like", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotLike(String value) {
            addCriterion("cardNo not like", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoIn(List<String> values) {
            addCriterion("cardNo in", values, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotIn(List<String> values) {
            addCriterion("cardNo not in", values, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoBetween(String value1, String value2) {
            addCriterion("cardNo between", value1, value2, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotBetween(String value1, String value2) {
            addCriterion("cardNo not between", value1, value2, "cardno");
            return (Criteria) this;
        }

        public Criteria andUsrnameIsNull() {
            addCriterion("usrName is null");
            return (Criteria) this;
        }

        public Criteria andUsrnameIsNotNull() {
            addCriterion("usrName is not null");
            return (Criteria) this;
        }

        public Criteria andUsrnameEqualTo(String value) {
            addCriterion("usrName =", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameNotEqualTo(String value) {
            addCriterion("usrName <>", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameGreaterThan(String value) {
            addCriterion("usrName >", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameGreaterThanOrEqualTo(String value) {
            addCriterion("usrName >=", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameLessThan(String value) {
            addCriterion("usrName <", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameLessThanOrEqualTo(String value) {
            addCriterion("usrName <=", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameLike(String value) {
            addCriterion("usrName like", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameNotLike(String value) {
            addCriterion("usrName not like", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameIn(List<String> values) {
            addCriterion("usrName in", values, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameNotIn(List<String> values) {
            addCriterion("usrName not in", values, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameBetween(String value1, String value2) {
            addCriterion("usrName between", value1, value2, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameNotBetween(String value1, String value2) {
            addCriterion("usrName not between", value1, value2, "usrname");
            return (Criteria) this;
        }

        public Criteria andCerttypeIsNull() {
            addCriterion("certType is null");
            return (Criteria) this;
        }

        public Criteria andCerttypeIsNotNull() {
            addCriterion("certType is not null");
            return (Criteria) this;
        }

        public Criteria andCerttypeEqualTo(String value) {
            addCriterion("certType =", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeNotEqualTo(String value) {
            addCriterion("certType <>", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeGreaterThan(String value) {
            addCriterion("certType >", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeGreaterThanOrEqualTo(String value) {
            addCriterion("certType >=", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeLessThan(String value) {
            addCriterion("certType <", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeLessThanOrEqualTo(String value) {
            addCriterion("certType <=", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeLike(String value) {
            addCriterion("certType like", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeNotLike(String value) {
            addCriterion("certType not like", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeIn(List<String> values) {
            addCriterion("certType in", values, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeNotIn(List<String> values) {
            addCriterion("certType not in", values, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeBetween(String value1, String value2) {
            addCriterion("certType between", value1, value2, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeNotBetween(String value1, String value2) {
            addCriterion("certType not between", value1, value2, "certtype");
            return (Criteria) this;
        }

        public Criteria andCertidIsNull() {
            addCriterion("certId is null");
            return (Criteria) this;
        }

        public Criteria andCertidIsNotNull() {
            addCriterion("certId is not null");
            return (Criteria) this;
        }

        public Criteria andCertidEqualTo(String value) {
            addCriterion("certId =", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotEqualTo(String value) {
            addCriterion("certId <>", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidGreaterThan(String value) {
            addCriterion("certId >", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidGreaterThanOrEqualTo(String value) {
            addCriterion("certId >=", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLessThan(String value) {
            addCriterion("certId <", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLessThanOrEqualTo(String value) {
            addCriterion("certId <=", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLike(String value) {
            addCriterion("certId like", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotLike(String value) {
            addCriterion("certId not like", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidIn(List<String> values) {
            addCriterion("certId in", values, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotIn(List<String> values) {
            addCriterion("certId not in", values, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidBetween(String value1, String value2) {
            addCriterion("certId between", value1, value2, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotBetween(String value1, String value2) {
            addCriterion("certId not between", value1, value2, "certid");
            return (Criteria) this;
        }

        public Criteria andCuryidIsNull() {
            addCriterion("curyId is null");
            return (Criteria) this;
        }

        public Criteria andCuryidIsNotNull() {
            addCriterion("curyId is not null");
            return (Criteria) this;
        }

        public Criteria andCuryidEqualTo(String value) {
            addCriterion("curyId =", value, "curyid");
            return (Criteria) this;
        }

        public Criteria andCuryidNotEqualTo(String value) {
            addCriterion("curyId <>", value, "curyid");
            return (Criteria) this;
        }

        public Criteria andCuryidGreaterThan(String value) {
            addCriterion("curyId >", value, "curyid");
            return (Criteria) this;
        }

        public Criteria andCuryidGreaterThanOrEqualTo(String value) {
            addCriterion("curyId >=", value, "curyid");
            return (Criteria) this;
        }

        public Criteria andCuryidLessThan(String value) {
            addCriterion("curyId <", value, "curyid");
            return (Criteria) this;
        }

        public Criteria andCuryidLessThanOrEqualTo(String value) {
            addCriterion("curyId <=", value, "curyid");
            return (Criteria) this;
        }

        public Criteria andCuryidLike(String value) {
            addCriterion("curyId like", value, "curyid");
            return (Criteria) this;
        }

        public Criteria andCuryidNotLike(String value) {
            addCriterion("curyId not like", value, "curyid");
            return (Criteria) this;
        }

        public Criteria andCuryidIn(List<String> values) {
            addCriterion("curyId in", values, "curyid");
            return (Criteria) this;
        }

        public Criteria andCuryidNotIn(List<String> values) {
            addCriterion("curyId not in", values, "curyid");
            return (Criteria) this;
        }

        public Criteria andCuryidBetween(String value1, String value2) {
            addCriterion("curyId between", value1, value2, "curyid");
            return (Criteria) this;
        }

        public Criteria andCuryidNotBetween(String value1, String value2) {
            addCriterion("curyId not between", value1, value2, "curyid");
            return (Criteria) this;
        }

        public Criteria andTransamtIsNull() {
            addCriterion("transAmt is null");
            return (Criteria) this;
        }

        public Criteria andTransamtIsNotNull() {
            addCriterion("transAmt is not null");
            return (Criteria) this;
        }

        public Criteria andTransamtEqualTo(String value) {
            addCriterion("transAmt =", value, "transamt");
            return (Criteria) this;
        }

        public Criteria andTransamtNotEqualTo(String value) {
            addCriterion("transAmt <>", value, "transamt");
            return (Criteria) this;
        }

        public Criteria andTransamtGreaterThan(String value) {
            addCriterion("transAmt >", value, "transamt");
            return (Criteria) this;
        }

        public Criteria andTransamtGreaterThanOrEqualTo(String value) {
            addCriterion("transAmt >=", value, "transamt");
            return (Criteria) this;
        }

        public Criteria andTransamtLessThan(String value) {
            addCriterion("transAmt <", value, "transamt");
            return (Criteria) this;
        }

        public Criteria andTransamtLessThanOrEqualTo(String value) {
            addCriterion("transAmt <=", value, "transamt");
            return (Criteria) this;
        }

        public Criteria andTransamtLike(String value) {
            addCriterion("transAmt like", value, "transamt");
            return (Criteria) this;
        }

        public Criteria andTransamtNotLike(String value) {
            addCriterion("transAmt not like", value, "transamt");
            return (Criteria) this;
        }

        public Criteria andTransamtIn(List<String> values) {
            addCriterion("transAmt in", values, "transamt");
            return (Criteria) this;
        }

        public Criteria andTransamtNotIn(List<String> values) {
            addCriterion("transAmt not in", values, "transamt");
            return (Criteria) this;
        }

        public Criteria andTransamtBetween(String value1, String value2) {
            addCriterion("transAmt between", value1, value2, "transamt");
            return (Criteria) this;
        }

        public Criteria andTransamtNotBetween(String value1, String value2) {
            addCriterion("transAmt not between", value1, value2, "transamt");
            return (Criteria) this;
        }

        public Criteria andPurposeIsNull() {
            addCriterion("purpose is null");
            return (Criteria) this;
        }

        public Criteria andPurposeIsNotNull() {
            addCriterion("purpose is not null");
            return (Criteria) this;
        }

        public Criteria andPurposeEqualTo(String value) {
            addCriterion("purpose =", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotEqualTo(String value) {
            addCriterion("purpose <>", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThan(String value) {
            addCriterion("purpose >", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("purpose >=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThan(String value) {
            addCriterion("purpose <", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThanOrEqualTo(String value) {
            addCriterion("purpose <=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLike(String value) {
            addCriterion("purpose like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotLike(String value) {
            addCriterion("purpose not like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeIn(List<String> values) {
            addCriterion("purpose in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotIn(List<String> values) {
            addCriterion("purpose not in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeBetween(String value1, String value2) {
            addCriterion("purpose between", value1, value2, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotBetween(String value1, String value2) {
            addCriterion("purpose not between", value1, value2, "purpose");
            return (Criteria) this;
        }

        public Criteria andPriv1IsNull() {
            addCriterion("priv1 is null");
            return (Criteria) this;
        }

        public Criteria andPriv1IsNotNull() {
            addCriterion("priv1 is not null");
            return (Criteria) this;
        }

        public Criteria andPriv1EqualTo(String value) {
            addCriterion("priv1 =", value, "priv1");
            return (Criteria) this;
        }

        public Criteria andPriv1NotEqualTo(String value) {
            addCriterion("priv1 <>", value, "priv1");
            return (Criteria) this;
        }

        public Criteria andPriv1GreaterThan(String value) {
            addCriterion("priv1 >", value, "priv1");
            return (Criteria) this;
        }

        public Criteria andPriv1GreaterThanOrEqualTo(String value) {
            addCriterion("priv1 >=", value, "priv1");
            return (Criteria) this;
        }

        public Criteria andPriv1LessThan(String value) {
            addCriterion("priv1 <", value, "priv1");
            return (Criteria) this;
        }

        public Criteria andPriv1LessThanOrEqualTo(String value) {
            addCriterion("priv1 <=", value, "priv1");
            return (Criteria) this;
        }

        public Criteria andPriv1Like(String value) {
            addCriterion("priv1 like", value, "priv1");
            return (Criteria) this;
        }

        public Criteria andPriv1NotLike(String value) {
            addCriterion("priv1 not like", value, "priv1");
            return (Criteria) this;
        }

        public Criteria andPriv1In(List<String> values) {
            addCriterion("priv1 in", values, "priv1");
            return (Criteria) this;
        }

        public Criteria andPriv1NotIn(List<String> values) {
            addCriterion("priv1 not in", values, "priv1");
            return (Criteria) this;
        }

        public Criteria andPriv1Between(String value1, String value2) {
            addCriterion("priv1 between", value1, value2, "priv1");
            return (Criteria) this;
        }

        public Criteria andPriv1NotBetween(String value1, String value2) {
            addCriterion("priv1 not between", value1, value2, "priv1");
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

        public Criteria andUptimeIsNull() {
            addCriterion("upTime is null");
            return (Criteria) this;
        }

        public Criteria andUptimeIsNotNull() {
            addCriterion("upTime is not null");
            return (Criteria) this;
        }

        public Criteria andUptimeEqualTo(String value) {
            addCriterion("upTime =", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotEqualTo(String value) {
            addCriterion("upTime <>", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThan(String value) {
            addCriterion("upTime >", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThanOrEqualTo(String value) {
            addCriterion("upTime >=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThan(String value) {
            addCriterion("upTime <", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThanOrEqualTo(String value) {
            addCriterion("upTime <=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLike(String value) {
            addCriterion("upTime like", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotLike(String value) {
            addCriterion("upTime not like", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeIn(List<String> values) {
            addCriterion("upTime in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotIn(List<String> values) {
            addCriterion("upTime not in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeBetween(String value1, String value2) {
            addCriterion("upTime between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotBetween(String value1, String value2) {
            addCriterion("upTime not between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andExtfieldIsNull() {
            addCriterion("extField is null");
            return (Criteria) this;
        }

        public Criteria andExtfieldIsNotNull() {
            addCriterion("extField is not null");
            return (Criteria) this;
        }

        public Criteria andExtfieldEqualTo(String value) {
            addCriterion("extField =", value, "extfield");
            return (Criteria) this;
        }

        public Criteria andExtfieldNotEqualTo(String value) {
            addCriterion("extField <>", value, "extfield");
            return (Criteria) this;
        }

        public Criteria andExtfieldGreaterThan(String value) {
            addCriterion("extField >", value, "extfield");
            return (Criteria) this;
        }

        public Criteria andExtfieldGreaterThanOrEqualTo(String value) {
            addCriterion("extField >=", value, "extfield");
            return (Criteria) this;
        }

        public Criteria andExtfieldLessThan(String value) {
            addCriterion("extField <", value, "extfield");
            return (Criteria) this;
        }

        public Criteria andExtfieldLessThanOrEqualTo(String value) {
            addCriterion("extField <=", value, "extfield");
            return (Criteria) this;
        }

        public Criteria andExtfieldLike(String value) {
            addCriterion("extField like", value, "extfield");
            return (Criteria) this;
        }

        public Criteria andExtfieldNotLike(String value) {
            addCriterion("extField not like", value, "extfield");
            return (Criteria) this;
        }

        public Criteria andExtfieldIn(List<String> values) {
            addCriterion("extField in", values, "extfield");
            return (Criteria) this;
        }

        public Criteria andExtfieldNotIn(List<String> values) {
            addCriterion("extField not in", values, "extfield");
            return (Criteria) this;
        }

        public Criteria andExtfieldBetween(String value1, String value2) {
            addCriterion("extField between", value1, value2, "extfield");
            return (Criteria) this;
        }

        public Criteria andExtfieldNotBetween(String value1, String value2) {
            addCriterion("extField not between", value1, value2, "extfield");
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