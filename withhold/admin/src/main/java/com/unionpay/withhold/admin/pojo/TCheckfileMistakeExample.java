package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TCheckfileMistakeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCheckfileMistakeExample() {
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

        public Criteria andIidIsNull() {
            addCriterion("IID is null");
            return (Criteria) this;
        }

        public Criteria andIidIsNotNull() {
            addCriterion("IID is not null");
            return (Criteria) this;
        }

        public Criteria andIidEqualTo(Long value) {
            addCriterion("IID =", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidNotEqualTo(Long value) {
            addCriterion("IID <>", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidGreaterThan(Long value) {
            addCriterion("IID >", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidGreaterThanOrEqualTo(Long value) {
            addCriterion("IID >=", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidLessThan(Long value) {
            addCriterion("IID <", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidLessThanOrEqualTo(Long value) {
            addCriterion("IID <=", value, "iid");
            return (Criteria) this;
        }

        public Criteria andIidIn(List<Long> values) {
            addCriterion("IID in", values, "iid");
            return (Criteria) this;
        }

        public Criteria andIidNotIn(List<Long> values) {
            addCriterion("IID not in", values, "iid");
            return (Criteria) this;
        }

        public Criteria andIidBetween(Long value1, Long value2) {
            addCriterion("IID between", value1, value2, "iid");
            return (Criteria) this;
        }

        public Criteria andIidNotBetween(Long value1, Long value2) {
            addCriterion("IID not between", value1, value2, "iid");
            return (Criteria) this;
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

        public Criteria andInstiidIsNull() {
            addCriterion("INSTIID is null");
            return (Criteria) this;
        }

        public Criteria andInstiidIsNotNull() {
            addCriterion("INSTIID is not null");
            return (Criteria) this;
        }

        public Criteria andInstiidEqualTo(String value) {
            addCriterion("INSTIID =", value, "instiid");
            return (Criteria) this;
        }

        public Criteria andInstiidNotEqualTo(String value) {
            addCriterion("INSTIID <>", value, "instiid");
            return (Criteria) this;
        }

        public Criteria andInstiidGreaterThan(String value) {
            addCriterion("INSTIID >", value, "instiid");
            return (Criteria) this;
        }

        public Criteria andInstiidGreaterThanOrEqualTo(String value) {
            addCriterion("INSTIID >=", value, "instiid");
            return (Criteria) this;
        }

        public Criteria andInstiidLessThan(String value) {
            addCriterion("INSTIID <", value, "instiid");
            return (Criteria) this;
        }

        public Criteria andInstiidLessThanOrEqualTo(String value) {
            addCriterion("INSTIID <=", value, "instiid");
            return (Criteria) this;
        }

        public Criteria andInstiidLike(String value) {
            addCriterion("INSTIID like", value, "instiid");
            return (Criteria) this;
        }

        public Criteria andInstiidNotLike(String value) {
            addCriterion("INSTIID not like", value, "instiid");
            return (Criteria) this;
        }

        public Criteria andInstiidIn(List<String> values) {
            addCriterion("INSTIID in", values, "instiid");
            return (Criteria) this;
        }

        public Criteria andInstiidNotIn(List<String> values) {
            addCriterion("INSTIID not in", values, "instiid");
            return (Criteria) this;
        }

        public Criteria andInstiidBetween(String value1, String value2) {
            addCriterion("INSTIID between", value1, value2, "instiid");
            return (Criteria) this;
        }

        public Criteria andInstiidNotBetween(String value1, String value2) {
            addCriterion("INSTIID not between", value1, value2, "instiid");
            return (Criteria) this;
        }

        public Criteria andPayordnoIsNull() {
            addCriterion("PAYORDNO is null");
            return (Criteria) this;
        }

        public Criteria andPayordnoIsNotNull() {
            addCriterion("PAYORDNO is not null");
            return (Criteria) this;
        }

        public Criteria andPayordnoEqualTo(String value) {
            addCriterion("PAYORDNO =", value, "payordno");
            return (Criteria) this;
        }

        public Criteria andPayordnoNotEqualTo(String value) {
            addCriterion("PAYORDNO <>", value, "payordno");
            return (Criteria) this;
        }

        public Criteria andPayordnoGreaterThan(String value) {
            addCriterion("PAYORDNO >", value, "payordno");
            return (Criteria) this;
        }

        public Criteria andPayordnoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYORDNO >=", value, "payordno");
            return (Criteria) this;
        }

        public Criteria andPayordnoLessThan(String value) {
            addCriterion("PAYORDNO <", value, "payordno");
            return (Criteria) this;
        }

        public Criteria andPayordnoLessThanOrEqualTo(String value) {
            addCriterion("PAYORDNO <=", value, "payordno");
            return (Criteria) this;
        }

        public Criteria andPayordnoLike(String value) {
            addCriterion("PAYORDNO like", value, "payordno");
            return (Criteria) this;
        }

        public Criteria andPayordnoNotLike(String value) {
            addCriterion("PAYORDNO not like", value, "payordno");
            return (Criteria) this;
        }

        public Criteria andPayordnoIn(List<String> values) {
            addCriterion("PAYORDNO in", values, "payordno");
            return (Criteria) this;
        }

        public Criteria andPayordnoNotIn(List<String> values) {
            addCriterion("PAYORDNO not in", values, "payordno");
            return (Criteria) this;
        }

        public Criteria andPayordnoBetween(String value1, String value2) {
            addCriterion("PAYORDNO between", value1, value2, "payordno");
            return (Criteria) this;
        }

        public Criteria andPayordnoNotBetween(String value1, String value2) {
            addCriterion("PAYORDNO not between", value1, value2, "payordno");
            return (Criteria) this;
        }

        public Criteria andTxndatetimeIsNull() {
            addCriterion("TXNDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andTxndatetimeIsNotNull() {
            addCriterion("TXNDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andTxndatetimeEqualTo(String value) {
            addCriterion("TXNDATETIME =", value, "txndatetime");
            return (Criteria) this;
        }

        public Criteria andTxndatetimeNotEqualTo(String value) {
            addCriterion("TXNDATETIME <>", value, "txndatetime");
            return (Criteria) this;
        }

        public Criteria andTxndatetimeGreaterThan(String value) {
            addCriterion("TXNDATETIME >", value, "txndatetime");
            return (Criteria) this;
        }

        public Criteria andTxndatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("TXNDATETIME >=", value, "txndatetime");
            return (Criteria) this;
        }

        public Criteria andTxndatetimeLessThan(String value) {
            addCriterion("TXNDATETIME <", value, "txndatetime");
            return (Criteria) this;
        }

        public Criteria andTxndatetimeLessThanOrEqualTo(String value) {
            addCriterion("TXNDATETIME <=", value, "txndatetime");
            return (Criteria) this;
        }

        public Criteria andTxndatetimeLike(String value) {
            addCriterion("TXNDATETIME like", value, "txndatetime");
            return (Criteria) this;
        }

        public Criteria andTxndatetimeNotLike(String value) {
            addCriterion("TXNDATETIME not like", value, "txndatetime");
            return (Criteria) this;
        }

        public Criteria andTxndatetimeIn(List<String> values) {
            addCriterion("TXNDATETIME in", values, "txndatetime");
            return (Criteria) this;
        }

        public Criteria andTxndatetimeNotIn(List<String> values) {
            addCriterion("TXNDATETIME not in", values, "txndatetime");
            return (Criteria) this;
        }

        public Criteria andTxndatetimeBetween(String value1, String value2) {
            addCriterion("TXNDATETIME between", value1, value2, "txndatetime");
            return (Criteria) this;
        }

        public Criteria andTxndatetimeNotBetween(String value1, String value2) {
            addCriterion("TXNDATETIME not between", value1, value2, "txndatetime");
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

        public Criteria andSystrcnoIsNull() {
            addCriterion("SYSTRCNO is null");
            return (Criteria) this;
        }

        public Criteria andSystrcnoIsNotNull() {
            addCriterion("SYSTRCNO is not null");
            return (Criteria) this;
        }

        public Criteria andSystrcnoEqualTo(String value) {
            addCriterion("SYSTRCNO =", value, "systrcno");
            return (Criteria) this;
        }

        public Criteria andSystrcnoNotEqualTo(String value) {
            addCriterion("SYSTRCNO <>", value, "systrcno");
            return (Criteria) this;
        }

        public Criteria andSystrcnoGreaterThan(String value) {
            addCriterion("SYSTRCNO >", value, "systrcno");
            return (Criteria) this;
        }

        public Criteria andSystrcnoGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTRCNO >=", value, "systrcno");
            return (Criteria) this;
        }

        public Criteria andSystrcnoLessThan(String value) {
            addCriterion("SYSTRCNO <", value, "systrcno");
            return (Criteria) this;
        }

        public Criteria andSystrcnoLessThanOrEqualTo(String value) {
            addCriterion("SYSTRCNO <=", value, "systrcno");
            return (Criteria) this;
        }

        public Criteria andSystrcnoLike(String value) {
            addCriterion("SYSTRCNO like", value, "systrcno");
            return (Criteria) this;
        }

        public Criteria andSystrcnoNotLike(String value) {
            addCriterion("SYSTRCNO not like", value, "systrcno");
            return (Criteria) this;
        }

        public Criteria andSystrcnoIn(List<String> values) {
            addCriterion("SYSTRCNO in", values, "systrcno");
            return (Criteria) this;
        }

        public Criteria andSystrcnoNotIn(List<String> values) {
            addCriterion("SYSTRCNO not in", values, "systrcno");
            return (Criteria) this;
        }

        public Criteria andSystrcnoBetween(String value1, String value2) {
            addCriterion("SYSTRCNO between", value1, value2, "systrcno");
            return (Criteria) this;
        }

        public Criteria andSystrcnoNotBetween(String value1, String value2) {
            addCriterion("SYSTRCNO not between", value1, value2, "systrcno");
            return (Criteria) this;
        }

        public Criteria andPaytrcnoIsNull() {
            addCriterion("PAYTRCNO is null");
            return (Criteria) this;
        }

        public Criteria andPaytrcnoIsNotNull() {
            addCriterion("PAYTRCNO is not null");
            return (Criteria) this;
        }

        public Criteria andPaytrcnoEqualTo(String value) {
            addCriterion("PAYTRCNO =", value, "paytrcno");
            return (Criteria) this;
        }

        public Criteria andPaytrcnoNotEqualTo(String value) {
            addCriterion("PAYTRCNO <>", value, "paytrcno");
            return (Criteria) this;
        }

        public Criteria andPaytrcnoGreaterThan(String value) {
            addCriterion("PAYTRCNO >", value, "paytrcno");
            return (Criteria) this;
        }

        public Criteria andPaytrcnoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYTRCNO >=", value, "paytrcno");
            return (Criteria) this;
        }

        public Criteria andPaytrcnoLessThan(String value) {
            addCriterion("PAYTRCNO <", value, "paytrcno");
            return (Criteria) this;
        }

        public Criteria andPaytrcnoLessThanOrEqualTo(String value) {
            addCriterion("PAYTRCNO <=", value, "paytrcno");
            return (Criteria) this;
        }

        public Criteria andPaytrcnoLike(String value) {
            addCriterion("PAYTRCNO like", value, "paytrcno");
            return (Criteria) this;
        }

        public Criteria andPaytrcnoNotLike(String value) {
            addCriterion("PAYTRCNO not like", value, "paytrcno");
            return (Criteria) this;
        }

        public Criteria andPaytrcnoIn(List<String> values) {
            addCriterion("PAYTRCNO in", values, "paytrcno");
            return (Criteria) this;
        }

        public Criteria andPaytrcnoNotIn(List<String> values) {
            addCriterion("PAYTRCNO not in", values, "paytrcno");
            return (Criteria) this;
        }

        public Criteria andPaytrcnoBetween(String value1, String value2) {
            addCriterion("PAYTRCNO between", value1, value2, "paytrcno");
            return (Criteria) this;
        }

        public Criteria andPaytrcnoNotBetween(String value1, String value2) {
            addCriterion("PAYTRCNO not between", value1, value2, "paytrcno");
            return (Criteria) this;
        }

        public Criteria andCfeeIsNull() {
            addCriterion("CFEE is null");
            return (Criteria) this;
        }

        public Criteria andCfeeIsNotNull() {
            addCriterion("CFEE is not null");
            return (Criteria) this;
        }

        public Criteria andCfeeEqualTo(Long value) {
            addCriterion("CFEE =", value, "cfee");
            return (Criteria) this;
        }

        public Criteria andCfeeNotEqualTo(Long value) {
            addCriterion("CFEE <>", value, "cfee");
            return (Criteria) this;
        }

        public Criteria andCfeeGreaterThan(Long value) {
            addCriterion("CFEE >", value, "cfee");
            return (Criteria) this;
        }

        public Criteria andCfeeGreaterThanOrEqualTo(Long value) {
            addCriterion("CFEE >=", value, "cfee");
            return (Criteria) this;
        }

        public Criteria andCfeeLessThan(Long value) {
            addCriterion("CFEE <", value, "cfee");
            return (Criteria) this;
        }

        public Criteria andCfeeLessThanOrEqualTo(Long value) {
            addCriterion("CFEE <=", value, "cfee");
            return (Criteria) this;
        }

        public Criteria andCfeeIn(List<Long> values) {
            addCriterion("CFEE in", values, "cfee");
            return (Criteria) this;
        }

        public Criteria andCfeeNotIn(List<Long> values) {
            addCriterion("CFEE not in", values, "cfee");
            return (Criteria) this;
        }

        public Criteria andCfeeBetween(Long value1, Long value2) {
            addCriterion("CFEE between", value1, value2, "cfee");
            return (Criteria) this;
        }

        public Criteria andCfeeNotBetween(Long value1, Long value2) {
            addCriterion("CFEE not between", value1, value2, "cfee");
            return (Criteria) this;
        }

        public Criteria andDfeeIsNull() {
            addCriterion("DFEE is null");
            return (Criteria) this;
        }

        public Criteria andDfeeIsNotNull() {
            addCriterion("DFEE is not null");
            return (Criteria) this;
        }

        public Criteria andDfeeEqualTo(Long value) {
            addCriterion("DFEE =", value, "dfee");
            return (Criteria) this;
        }

        public Criteria andDfeeNotEqualTo(Long value) {
            addCriterion("DFEE <>", value, "dfee");
            return (Criteria) this;
        }

        public Criteria andDfeeGreaterThan(Long value) {
            addCriterion("DFEE >", value, "dfee");
            return (Criteria) this;
        }

        public Criteria andDfeeGreaterThanOrEqualTo(Long value) {
            addCriterion("DFEE >=", value, "dfee");
            return (Criteria) this;
        }

        public Criteria andDfeeLessThan(Long value) {
            addCriterion("DFEE <", value, "dfee");
            return (Criteria) this;
        }

        public Criteria andDfeeLessThanOrEqualTo(Long value) {
            addCriterion("DFEE <=", value, "dfee");
            return (Criteria) this;
        }

        public Criteria andDfeeIn(List<Long> values) {
            addCriterion("DFEE in", values, "dfee");
            return (Criteria) this;
        }

        public Criteria andDfeeNotIn(List<Long> values) {
            addCriterion("DFEE not in", values, "dfee");
            return (Criteria) this;
        }

        public Criteria andDfeeBetween(Long value1, Long value2) {
            addCriterion("DFEE between", value1, value2, "dfee");
            return (Criteria) this;
        }

        public Criteria andDfeeNotBetween(Long value1, Long value2) {
            addCriterion("DFEE not between", value1, value2, "dfee");
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

        public Criteria andAcqsettledateIsNull() {
            addCriterion("ACQSETTLEDATE is null");
            return (Criteria) this;
        }

        public Criteria andAcqsettledateIsNotNull() {
            addCriterion("ACQSETTLEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andAcqsettledateEqualTo(String value) {
            addCriterion("ACQSETTLEDATE =", value, "acqsettledate");
            return (Criteria) this;
        }

        public Criteria andAcqsettledateNotEqualTo(String value) {
            addCriterion("ACQSETTLEDATE <>", value, "acqsettledate");
            return (Criteria) this;
        }

        public Criteria andAcqsettledateGreaterThan(String value) {
            addCriterion("ACQSETTLEDATE >", value, "acqsettledate");
            return (Criteria) this;
        }

        public Criteria andAcqsettledateGreaterThanOrEqualTo(String value) {
            addCriterion("ACQSETTLEDATE >=", value, "acqsettledate");
            return (Criteria) this;
        }

        public Criteria andAcqsettledateLessThan(String value) {
            addCriterion("ACQSETTLEDATE <", value, "acqsettledate");
            return (Criteria) this;
        }

        public Criteria andAcqsettledateLessThanOrEqualTo(String value) {
            addCriterion("ACQSETTLEDATE <=", value, "acqsettledate");
            return (Criteria) this;
        }

        public Criteria andAcqsettledateLike(String value) {
            addCriterion("ACQSETTLEDATE like", value, "acqsettledate");
            return (Criteria) this;
        }

        public Criteria andAcqsettledateNotLike(String value) {
            addCriterion("ACQSETTLEDATE not like", value, "acqsettledate");
            return (Criteria) this;
        }

        public Criteria andAcqsettledateIn(List<String> values) {
            addCriterion("ACQSETTLEDATE in", values, "acqsettledate");
            return (Criteria) this;
        }

        public Criteria andAcqsettledateNotIn(List<String> values) {
            addCriterion("ACQSETTLEDATE not in", values, "acqsettledate");
            return (Criteria) this;
        }

        public Criteria andAcqsettledateBetween(String value1, String value2) {
            addCriterion("ACQSETTLEDATE between", value1, value2, "acqsettledate");
            return (Criteria) this;
        }

        public Criteria andAcqsettledateNotBetween(String value1, String value2) {
            addCriterion("ACQSETTLEDATE not between", value1, value2, "acqsettledate");
            return (Criteria) this;
        }

        public Criteria andProidIsNull() {
            addCriterion("PROID is null");
            return (Criteria) this;
        }

        public Criteria andProidIsNotNull() {
            addCriterion("PROID is not null");
            return (Criteria) this;
        }

        public Criteria andProidEqualTo(Long value) {
            addCriterion("PROID =", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotEqualTo(Long value) {
            addCriterion("PROID <>", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThan(Long value) {
            addCriterion("PROID >", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThanOrEqualTo(Long value) {
            addCriterion("PROID >=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThan(Long value) {
            addCriterion("PROID <", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThanOrEqualTo(Long value) {
            addCriterion("PROID <=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidIn(List<Long> values) {
            addCriterion("PROID in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotIn(List<Long> values) {
            addCriterion("PROID not in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidBetween(Long value1, Long value2) {
            addCriterion("PROID between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotBetween(Long value1, Long value2) {
            addCriterion("PROID not between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("RESULT is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("RESULT =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("RESULT <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("RESULT >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("RESULT <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("RESULT <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("RESULT like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("RESULT not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("RESULT in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("RESULT not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("RESULT between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("RESULT not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andMistatusIsNull() {
            addCriterion("MISTATUS is null");
            return (Criteria) this;
        }

        public Criteria andMistatusIsNotNull() {
            addCriterion("MISTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andMistatusEqualTo(String value) {
            addCriterion("MISTATUS =", value, "mistatus");
            return (Criteria) this;
        }

        public Criteria andMistatusNotEqualTo(String value) {
            addCriterion("MISTATUS <>", value, "mistatus");
            return (Criteria) this;
        }

        public Criteria andMistatusGreaterThan(String value) {
            addCriterion("MISTATUS >", value, "mistatus");
            return (Criteria) this;
        }

        public Criteria andMistatusGreaterThanOrEqualTo(String value) {
            addCriterion("MISTATUS >=", value, "mistatus");
            return (Criteria) this;
        }

        public Criteria andMistatusLessThan(String value) {
            addCriterion("MISTATUS <", value, "mistatus");
            return (Criteria) this;
        }

        public Criteria andMistatusLessThanOrEqualTo(String value) {
            addCriterion("MISTATUS <=", value, "mistatus");
            return (Criteria) this;
        }

        public Criteria andMistatusLike(String value) {
            addCriterion("MISTATUS like", value, "mistatus");
            return (Criteria) this;
        }

        public Criteria andMistatusNotLike(String value) {
            addCriterion("MISTATUS not like", value, "mistatus");
            return (Criteria) this;
        }

        public Criteria andMistatusIn(List<String> values) {
            addCriterion("MISTATUS in", values, "mistatus");
            return (Criteria) this;
        }

        public Criteria andMistatusNotIn(List<String> values) {
            addCriterion("MISTATUS not in", values, "mistatus");
            return (Criteria) this;
        }

        public Criteria andMistatusBetween(String value1, String value2) {
            addCriterion("MISTATUS between", value1, value2, "mistatus");
            return (Criteria) this;
        }

        public Criteria andMistatusNotBetween(String value1, String value2) {
            addCriterion("MISTATUS not between", value1, value2, "mistatus");
            return (Criteria) this;
        }

        public Criteria andMistakeTradeSourceIsNull() {
            addCriterion("MISTAKE_TRADE_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andMistakeTradeSourceIsNotNull() {
            addCriterion("MISTAKE_TRADE_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andMistakeTradeSourceEqualTo(Short value) {
            addCriterion("MISTAKE_TRADE_SOURCE =", value, "mistakeTradeSource");
            return (Criteria) this;
        }

        public Criteria andMistakeTradeSourceNotEqualTo(Short value) {
            addCriterion("MISTAKE_TRADE_SOURCE <>", value, "mistakeTradeSource");
            return (Criteria) this;
        }

        public Criteria andMistakeTradeSourceGreaterThan(Short value) {
            addCriterion("MISTAKE_TRADE_SOURCE >", value, "mistakeTradeSource");
            return (Criteria) this;
        }

        public Criteria andMistakeTradeSourceGreaterThanOrEqualTo(Short value) {
            addCriterion("MISTAKE_TRADE_SOURCE >=", value, "mistakeTradeSource");
            return (Criteria) this;
        }

        public Criteria andMistakeTradeSourceLessThan(Short value) {
            addCriterion("MISTAKE_TRADE_SOURCE <", value, "mistakeTradeSource");
            return (Criteria) this;
        }

        public Criteria andMistakeTradeSourceLessThanOrEqualTo(Short value) {
            addCriterion("MISTAKE_TRADE_SOURCE <=", value, "mistakeTradeSource");
            return (Criteria) this;
        }

        public Criteria andMistakeTradeSourceIn(List<Short> values) {
            addCriterion("MISTAKE_TRADE_SOURCE in", values, "mistakeTradeSource");
            return (Criteria) this;
        }

        public Criteria andMistakeTradeSourceNotIn(List<Short> values) {
            addCriterion("MISTAKE_TRADE_SOURCE not in", values, "mistakeTradeSource");
            return (Criteria) this;
        }

        public Criteria andMistakeTradeSourceBetween(Short value1, Short value2) {
            addCriterion("MISTAKE_TRADE_SOURCE between", value1, value2, "mistakeTradeSource");
            return (Criteria) this;
        }

        public Criteria andMistakeTradeSourceNotBetween(Short value1, Short value2) {
            addCriterion("MISTAKE_TRADE_SOURCE not between", value1, value2, "mistakeTradeSource");
            return (Criteria) this;
        }

        public Criteria andDatasourceIsNull() {
            addCriterion("DATASOURCE is null");
            return (Criteria) this;
        }

        public Criteria andDatasourceIsNotNull() {
            addCriterion("DATASOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andDatasourceEqualTo(String value) {
            addCriterion("DATASOURCE =", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceNotEqualTo(String value) {
            addCriterion("DATASOURCE <>", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceGreaterThan(String value) {
            addCriterion("DATASOURCE >", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceGreaterThanOrEqualTo(String value) {
            addCriterion("DATASOURCE >=", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceLessThan(String value) {
            addCriterion("DATASOURCE <", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceLessThanOrEqualTo(String value) {
            addCriterion("DATASOURCE <=", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceLike(String value) {
            addCriterion("DATASOURCE like", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceNotLike(String value) {
            addCriterion("DATASOURCE not like", value, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceIn(List<String> values) {
            addCriterion("DATASOURCE in", values, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceNotIn(List<String> values) {
            addCriterion("DATASOURCE not in", values, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceBetween(String value1, String value2) {
            addCriterion("DATASOURCE between", value1, value2, "datasource");
            return (Criteria) this;
        }

        public Criteria andDatasourceNotBetween(String value1, String value2) {
            addCriterion("DATASOURCE not between", value1, value2, "datasource");
            return (Criteria) this;
        }

        public Criteria andMistakedescIsNull() {
            addCriterion("MISTAKEDESC is null");
            return (Criteria) this;
        }

        public Criteria andMistakedescIsNotNull() {
            addCriterion("MISTAKEDESC is not null");
            return (Criteria) this;
        }

        public Criteria andMistakedescEqualTo(String value) {
            addCriterion("MISTAKEDESC =", value, "mistakedesc");
            return (Criteria) this;
        }

        public Criteria andMistakedescNotEqualTo(String value) {
            addCriterion("MISTAKEDESC <>", value, "mistakedesc");
            return (Criteria) this;
        }

        public Criteria andMistakedescGreaterThan(String value) {
            addCriterion("MISTAKEDESC >", value, "mistakedesc");
            return (Criteria) this;
        }

        public Criteria andMistakedescGreaterThanOrEqualTo(String value) {
            addCriterion("MISTAKEDESC >=", value, "mistakedesc");
            return (Criteria) this;
        }

        public Criteria andMistakedescLessThan(String value) {
            addCriterion("MISTAKEDESC <", value, "mistakedesc");
            return (Criteria) this;
        }

        public Criteria andMistakedescLessThanOrEqualTo(String value) {
            addCriterion("MISTAKEDESC <=", value, "mistakedesc");
            return (Criteria) this;
        }

        public Criteria andMistakedescLike(String value) {
            addCriterion("MISTAKEDESC like", value, "mistakedesc");
            return (Criteria) this;
        }

        public Criteria andMistakedescNotLike(String value) {
            addCriterion("MISTAKEDESC not like", value, "mistakedesc");
            return (Criteria) this;
        }

        public Criteria andMistakedescIn(List<String> values) {
            addCriterion("MISTAKEDESC in", values, "mistakedesc");
            return (Criteria) this;
        }

        public Criteria andMistakedescNotIn(List<String> values) {
            addCriterion("MISTAKEDESC not in", values, "mistakedesc");
            return (Criteria) this;
        }

        public Criteria andMistakedescBetween(String value1, String value2) {
            addCriterion("MISTAKEDESC between", value1, value2, "mistakedesc");
            return (Criteria) this;
        }

        public Criteria andMistakedescNotBetween(String value1, String value2) {
            addCriterion("MISTAKEDESC not between", value1, value2, "mistakedesc");
            return (Criteria) this;
        }

        public Criteria andAccepterIdIsNull() {
            addCriterion("ACCEPTER_ID is null");
            return (Criteria) this;
        }

        public Criteria andAccepterIdIsNotNull() {
            addCriterion("ACCEPTER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAccepterIdEqualTo(Long value) {
            addCriterion("ACCEPTER_ID =", value, "accepterId");
            return (Criteria) this;
        }

        public Criteria andAccepterIdNotEqualTo(Long value) {
            addCriterion("ACCEPTER_ID <>", value, "accepterId");
            return (Criteria) this;
        }

        public Criteria andAccepterIdGreaterThan(Long value) {
            addCriterion("ACCEPTER_ID >", value, "accepterId");
            return (Criteria) this;
        }

        public Criteria andAccepterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ACCEPTER_ID >=", value, "accepterId");
            return (Criteria) this;
        }

        public Criteria andAccepterIdLessThan(Long value) {
            addCriterion("ACCEPTER_ID <", value, "accepterId");
            return (Criteria) this;
        }

        public Criteria andAccepterIdLessThanOrEqualTo(Long value) {
            addCriterion("ACCEPTER_ID <=", value, "accepterId");
            return (Criteria) this;
        }

        public Criteria andAccepterIdIn(List<Long> values) {
            addCriterion("ACCEPTER_ID in", values, "accepterId");
            return (Criteria) this;
        }

        public Criteria andAccepterIdNotIn(List<Long> values) {
            addCriterion("ACCEPTER_ID not in", values, "accepterId");
            return (Criteria) this;
        }

        public Criteria andAccepterIdBetween(Long value1, Long value2) {
            addCriterion("ACCEPTER_ID between", value1, value2, "accepterId");
            return (Criteria) this;
        }

        public Criteria andAccepterIdNotBetween(Long value1, Long value2) {
            addCriterion("ACCEPTER_ID not between", value1, value2, "accepterId");
            return (Criteria) this;
        }

        public Criteria andAcceptDateIsNull() {
            addCriterion("ACCEPT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAcceptDateIsNotNull() {
            addCriterion("ACCEPT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptDateEqualTo(Date value) {
            addCriterion("ACCEPT_DATE =", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateNotEqualTo(Date value) {
            addCriterion("ACCEPT_DATE <>", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateGreaterThan(Date value) {
            addCriterion("ACCEPT_DATE >", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ACCEPT_DATE >=", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateLessThan(Date value) {
            addCriterion("ACCEPT_DATE <", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateLessThanOrEqualTo(Date value) {
            addCriterion("ACCEPT_DATE <=", value, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateIn(List<Date> values) {
            addCriterion("ACCEPT_DATE in", values, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateNotIn(List<Date> values) {
            addCriterion("ACCEPT_DATE not in", values, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateBetween(Date value1, Date value2) {
            addCriterion("ACCEPT_DATE between", value1, value2, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptDateNotBetween(Date value1, Date value2) {
            addCriterion("ACCEPT_DATE not between", value1, value2, "acceptDate");
            return (Criteria) this;
        }

        public Criteria andAcceptResultIsNull() {
            addCriterion("ACCEPT_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andAcceptResultIsNotNull() {
            addCriterion("ACCEPT_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptResultEqualTo(Short value) {
            addCriterion("ACCEPT_RESULT =", value, "acceptResult");
            return (Criteria) this;
        }

        public Criteria andAcceptResultNotEqualTo(Short value) {
            addCriterion("ACCEPT_RESULT <>", value, "acceptResult");
            return (Criteria) this;
        }

        public Criteria andAcceptResultGreaterThan(Short value) {
            addCriterion("ACCEPT_RESULT >", value, "acceptResult");
            return (Criteria) this;
        }

        public Criteria andAcceptResultGreaterThanOrEqualTo(Short value) {
            addCriterion("ACCEPT_RESULT >=", value, "acceptResult");
            return (Criteria) this;
        }

        public Criteria andAcceptResultLessThan(Short value) {
            addCriterion("ACCEPT_RESULT <", value, "acceptResult");
            return (Criteria) this;
        }

        public Criteria andAcceptResultLessThanOrEqualTo(Short value) {
            addCriterion("ACCEPT_RESULT <=", value, "acceptResult");
            return (Criteria) this;
        }

        public Criteria andAcceptResultIn(List<Short> values) {
            addCriterion("ACCEPT_RESULT in", values, "acceptResult");
            return (Criteria) this;
        }

        public Criteria andAcceptResultNotIn(List<Short> values) {
            addCriterion("ACCEPT_RESULT not in", values, "acceptResult");
            return (Criteria) this;
        }

        public Criteria andAcceptResultBetween(Short value1, Short value2) {
            addCriterion("ACCEPT_RESULT between", value1, value2, "acceptResult");
            return (Criteria) this;
        }

        public Criteria andAcceptResultNotBetween(Short value1, Short value2) {
            addCriterion("ACCEPT_RESULT not between", value1, value2, "acceptResult");
            return (Criteria) this;
        }

        public Criteria andAcceptOpinionIsNull() {
            addCriterion("ACCEPT_OPINION is null");
            return (Criteria) this;
        }

        public Criteria andAcceptOpinionIsNotNull() {
            addCriterion("ACCEPT_OPINION is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptOpinionEqualTo(String value) {
            addCriterion("ACCEPT_OPINION =", value, "acceptOpinion");
            return (Criteria) this;
        }

        public Criteria andAcceptOpinionNotEqualTo(String value) {
            addCriterion("ACCEPT_OPINION <>", value, "acceptOpinion");
            return (Criteria) this;
        }

        public Criteria andAcceptOpinionGreaterThan(String value) {
            addCriterion("ACCEPT_OPINION >", value, "acceptOpinion");
            return (Criteria) this;
        }

        public Criteria andAcceptOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPT_OPINION >=", value, "acceptOpinion");
            return (Criteria) this;
        }

        public Criteria andAcceptOpinionLessThan(String value) {
            addCriterion("ACCEPT_OPINION <", value, "acceptOpinion");
            return (Criteria) this;
        }

        public Criteria andAcceptOpinionLessThanOrEqualTo(String value) {
            addCriterion("ACCEPT_OPINION <=", value, "acceptOpinion");
            return (Criteria) this;
        }

        public Criteria andAcceptOpinionLike(String value) {
            addCriterion("ACCEPT_OPINION like", value, "acceptOpinion");
            return (Criteria) this;
        }

        public Criteria andAcceptOpinionNotLike(String value) {
            addCriterion("ACCEPT_OPINION not like", value, "acceptOpinion");
            return (Criteria) this;
        }

        public Criteria andAcceptOpinionIn(List<String> values) {
            addCriterion("ACCEPT_OPINION in", values, "acceptOpinion");
            return (Criteria) this;
        }

        public Criteria andAcceptOpinionNotIn(List<String> values) {
            addCriterion("ACCEPT_OPINION not in", values, "acceptOpinion");
            return (Criteria) this;
        }

        public Criteria andAcceptOpinionBetween(String value1, String value2) {
            addCriterion("ACCEPT_OPINION between", value1, value2, "acceptOpinion");
            return (Criteria) this;
        }

        public Criteria andAcceptOpinionNotBetween(String value1, String value2) {
            addCriterion("ACCEPT_OPINION not between", value1, value2, "acceptOpinion");
            return (Criteria) this;
        }

        public Criteria andDealEndDateIsNull() {
            addCriterion("DEAL_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDealEndDateIsNotNull() {
            addCriterion("DEAL_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDealEndDateEqualTo(Date value) {
            addCriterion("DEAL_END_DATE =", value, "dealEndDate");
            return (Criteria) this;
        }

        public Criteria andDealEndDateNotEqualTo(Date value) {
            addCriterion("DEAL_END_DATE <>", value, "dealEndDate");
            return (Criteria) this;
        }

        public Criteria andDealEndDateGreaterThan(Date value) {
            addCriterion("DEAL_END_DATE >", value, "dealEndDate");
            return (Criteria) this;
        }

        public Criteria andDealEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("DEAL_END_DATE >=", value, "dealEndDate");
            return (Criteria) this;
        }

        public Criteria andDealEndDateLessThan(Date value) {
            addCriterion("DEAL_END_DATE <", value, "dealEndDate");
            return (Criteria) this;
        }

        public Criteria andDealEndDateLessThanOrEqualTo(Date value) {
            addCriterion("DEAL_END_DATE <=", value, "dealEndDate");
            return (Criteria) this;
        }

        public Criteria andDealEndDateIn(List<Date> values) {
            addCriterion("DEAL_END_DATE in", values, "dealEndDate");
            return (Criteria) this;
        }

        public Criteria andDealEndDateNotIn(List<Date> values) {
            addCriterion("DEAL_END_DATE not in", values, "dealEndDate");
            return (Criteria) this;
        }

        public Criteria andDealEndDateBetween(Date value1, Date value2) {
            addCriterion("DEAL_END_DATE between", value1, value2, "dealEndDate");
            return (Criteria) this;
        }

        public Criteria andDealEndDateNotBetween(Date value1, Date value2) {
            addCriterion("DEAL_END_DATE not between", value1, value2, "dealEndDate");
            return (Criteria) this;
        }

        public Criteria andDealOperatorIdIsNull() {
            addCriterion("DEAL_OPERATOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andDealOperatorIdIsNotNull() {
            addCriterion("DEAL_OPERATOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDealOperatorIdEqualTo(Long value) {
            addCriterion("DEAL_OPERATOR_ID =", value, "dealOperatorId");
            return (Criteria) this;
        }

        public Criteria andDealOperatorIdNotEqualTo(Long value) {
            addCriterion("DEAL_OPERATOR_ID <>", value, "dealOperatorId");
            return (Criteria) this;
        }

        public Criteria andDealOperatorIdGreaterThan(Long value) {
            addCriterion("DEAL_OPERATOR_ID >", value, "dealOperatorId");
            return (Criteria) this;
        }

        public Criteria andDealOperatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("DEAL_OPERATOR_ID >=", value, "dealOperatorId");
            return (Criteria) this;
        }

        public Criteria andDealOperatorIdLessThan(Long value) {
            addCriterion("DEAL_OPERATOR_ID <", value, "dealOperatorId");
            return (Criteria) this;
        }

        public Criteria andDealOperatorIdLessThanOrEqualTo(Long value) {
            addCriterion("DEAL_OPERATOR_ID <=", value, "dealOperatorId");
            return (Criteria) this;
        }

        public Criteria andDealOperatorIdIn(List<Long> values) {
            addCriterion("DEAL_OPERATOR_ID in", values, "dealOperatorId");
            return (Criteria) this;
        }

        public Criteria andDealOperatorIdNotIn(List<Long> values) {
            addCriterion("DEAL_OPERATOR_ID not in", values, "dealOperatorId");
            return (Criteria) this;
        }

        public Criteria andDealOperatorIdBetween(Long value1, Long value2) {
            addCriterion("DEAL_OPERATOR_ID between", value1, value2, "dealOperatorId");
            return (Criteria) this;
        }

        public Criteria andDealOperatorIdNotBetween(Long value1, Long value2) {
            addCriterion("DEAL_OPERATOR_ID not between", value1, value2, "dealOperatorId");
            return (Criteria) this;
        }

        public Criteria andDealDateIsNull() {
            addCriterion("DEAL_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDealDateIsNotNull() {
            addCriterion("DEAL_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDealDateEqualTo(Date value) {
            addCriterion("DEAL_DATE =", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotEqualTo(Date value) {
            addCriterion("DEAL_DATE <>", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateGreaterThan(Date value) {
            addCriterion("DEAL_DATE >", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateGreaterThanOrEqualTo(Date value) {
            addCriterion("DEAL_DATE >=", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateLessThan(Date value) {
            addCriterion("DEAL_DATE <", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateLessThanOrEqualTo(Date value) {
            addCriterion("DEAL_DATE <=", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateIn(List<Date> values) {
            addCriterion("DEAL_DATE in", values, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotIn(List<Date> values) {
            addCriterion("DEAL_DATE not in", values, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateBetween(Date value1, Date value2) {
            addCriterion("DEAL_DATE between", value1, value2, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotBetween(Date value1, Date value2) {
            addCriterion("DEAL_DATE not between", value1, value2, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNull() {
            addCriterion("DEAL_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNotNull() {
            addCriterion("DEAL_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andDealResultEqualTo(Short value) {
            addCriterion("DEAL_RESULT =", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotEqualTo(Short value) {
            addCriterion("DEAL_RESULT <>", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThan(Short value) {
            addCriterion("DEAL_RESULT >", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThanOrEqualTo(Short value) {
            addCriterion("DEAL_RESULT >=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThan(Short value) {
            addCriterion("DEAL_RESULT <", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThanOrEqualTo(Short value) {
            addCriterion("DEAL_RESULT <=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultIn(List<Short> values) {
            addCriterion("DEAL_RESULT in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotIn(List<Short> values) {
            addCriterion("DEAL_RESULT not in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultBetween(Short value1, Short value2) {
            addCriterion("DEAL_RESULT between", value1, value2, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotBetween(Short value1, Short value2) {
            addCriterion("DEAL_RESULT not between", value1, value2, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealOpinionIsNull() {
            addCriterion("DEAL_OPINION is null");
            return (Criteria) this;
        }

        public Criteria andDealOpinionIsNotNull() {
            addCriterion("DEAL_OPINION is not null");
            return (Criteria) this;
        }

        public Criteria andDealOpinionEqualTo(String value) {
            addCriterion("DEAL_OPINION =", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotEqualTo(String value) {
            addCriterion("DEAL_OPINION <>", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionGreaterThan(String value) {
            addCriterion("DEAL_OPINION >", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("DEAL_OPINION >=", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionLessThan(String value) {
            addCriterion("DEAL_OPINION <", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionLessThanOrEqualTo(String value) {
            addCriterion("DEAL_OPINION <=", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionLike(String value) {
            addCriterion("DEAL_OPINION like", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotLike(String value) {
            addCriterion("DEAL_OPINION not like", value, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionIn(List<String> values) {
            addCriterion("DEAL_OPINION in", values, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotIn(List<String> values) {
            addCriterion("DEAL_OPINION not in", values, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionBetween(String value1, String value2) {
            addCriterion("DEAL_OPINION between", value1, value2, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andDealOpinionNotBetween(String value1, String value2) {
            addCriterion("DEAL_OPINION not between", value1, value2, "dealOpinion");
            return (Criteria) this;
        }

        public Criteria andVisitOperatorIdIsNull() {
            addCriterion("VISIT_OPERATOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andVisitOperatorIdIsNotNull() {
            addCriterion("VISIT_OPERATOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andVisitOperatorIdEqualTo(Long value) {
            addCriterion("VISIT_OPERATOR_ID =", value, "visitOperatorId");
            return (Criteria) this;
        }

        public Criteria andVisitOperatorIdNotEqualTo(Long value) {
            addCriterion("VISIT_OPERATOR_ID <>", value, "visitOperatorId");
            return (Criteria) this;
        }

        public Criteria andVisitOperatorIdGreaterThan(Long value) {
            addCriterion("VISIT_OPERATOR_ID >", value, "visitOperatorId");
            return (Criteria) this;
        }

        public Criteria andVisitOperatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("VISIT_OPERATOR_ID >=", value, "visitOperatorId");
            return (Criteria) this;
        }

        public Criteria andVisitOperatorIdLessThan(Long value) {
            addCriterion("VISIT_OPERATOR_ID <", value, "visitOperatorId");
            return (Criteria) this;
        }

        public Criteria andVisitOperatorIdLessThanOrEqualTo(Long value) {
            addCriterion("VISIT_OPERATOR_ID <=", value, "visitOperatorId");
            return (Criteria) this;
        }

        public Criteria andVisitOperatorIdIn(List<Long> values) {
            addCriterion("VISIT_OPERATOR_ID in", values, "visitOperatorId");
            return (Criteria) this;
        }

        public Criteria andVisitOperatorIdNotIn(List<Long> values) {
            addCriterion("VISIT_OPERATOR_ID not in", values, "visitOperatorId");
            return (Criteria) this;
        }

        public Criteria andVisitOperatorIdBetween(Long value1, Long value2) {
            addCriterion("VISIT_OPERATOR_ID between", value1, value2, "visitOperatorId");
            return (Criteria) this;
        }

        public Criteria andVisitOperatorIdNotBetween(Long value1, Long value2) {
            addCriterion("VISIT_OPERATOR_ID not between", value1, value2, "visitOperatorId");
            return (Criteria) this;
        }

        public Criteria andVisitDateIsNull() {
            addCriterion("VISIT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andVisitDateIsNotNull() {
            addCriterion("VISIT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andVisitDateEqualTo(Date value) {
            addCriterion("VISIT_DATE =", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateNotEqualTo(Date value) {
            addCriterion("VISIT_DATE <>", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateGreaterThan(Date value) {
            addCriterion("VISIT_DATE >", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateGreaterThanOrEqualTo(Date value) {
            addCriterion("VISIT_DATE >=", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateLessThan(Date value) {
            addCriterion("VISIT_DATE <", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateLessThanOrEqualTo(Date value) {
            addCriterion("VISIT_DATE <=", value, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateIn(List<Date> values) {
            addCriterion("VISIT_DATE in", values, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateNotIn(List<Date> values) {
            addCriterion("VISIT_DATE not in", values, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateBetween(Date value1, Date value2) {
            addCriterion("VISIT_DATE between", value1, value2, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitDateNotBetween(Date value1, Date value2) {
            addCriterion("VISIT_DATE not between", value1, value2, "visitDate");
            return (Criteria) this;
        }

        public Criteria andVisitResultIsNull() {
            addCriterion("VISIT_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andVisitResultIsNotNull() {
            addCriterion("VISIT_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andVisitResultEqualTo(Short value) {
            addCriterion("VISIT_RESULT =", value, "visitResult");
            return (Criteria) this;
        }

        public Criteria andVisitResultNotEqualTo(Short value) {
            addCriterion("VISIT_RESULT <>", value, "visitResult");
            return (Criteria) this;
        }

        public Criteria andVisitResultGreaterThan(Short value) {
            addCriterion("VISIT_RESULT >", value, "visitResult");
            return (Criteria) this;
        }

        public Criteria andVisitResultGreaterThanOrEqualTo(Short value) {
            addCriterion("VISIT_RESULT >=", value, "visitResult");
            return (Criteria) this;
        }

        public Criteria andVisitResultLessThan(Short value) {
            addCriterion("VISIT_RESULT <", value, "visitResult");
            return (Criteria) this;
        }

        public Criteria andVisitResultLessThanOrEqualTo(Short value) {
            addCriterion("VISIT_RESULT <=", value, "visitResult");
            return (Criteria) this;
        }

        public Criteria andVisitResultIn(List<Short> values) {
            addCriterion("VISIT_RESULT in", values, "visitResult");
            return (Criteria) this;
        }

        public Criteria andVisitResultNotIn(List<Short> values) {
            addCriterion("VISIT_RESULT not in", values, "visitResult");
            return (Criteria) this;
        }

        public Criteria andVisitResultBetween(Short value1, Short value2) {
            addCriterion("VISIT_RESULT between", value1, value2, "visitResult");
            return (Criteria) this;
        }

        public Criteria andVisitResultNotBetween(Short value1, Short value2) {
            addCriterion("VISIT_RESULT not between", value1, value2, "visitResult");
            return (Criteria) this;
        }

        public Criteria andVisitOpinionIsNull() {
            addCriterion("VISIT_OPINION is null");
            return (Criteria) this;
        }

        public Criteria andVisitOpinionIsNotNull() {
            addCriterion("VISIT_OPINION is not null");
            return (Criteria) this;
        }

        public Criteria andVisitOpinionEqualTo(String value) {
            addCriterion("VISIT_OPINION =", value, "visitOpinion");
            return (Criteria) this;
        }

        public Criteria andVisitOpinionNotEqualTo(String value) {
            addCriterion("VISIT_OPINION <>", value, "visitOpinion");
            return (Criteria) this;
        }

        public Criteria andVisitOpinionGreaterThan(String value) {
            addCriterion("VISIT_OPINION >", value, "visitOpinion");
            return (Criteria) this;
        }

        public Criteria andVisitOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("VISIT_OPINION >=", value, "visitOpinion");
            return (Criteria) this;
        }

        public Criteria andVisitOpinionLessThan(String value) {
            addCriterion("VISIT_OPINION <", value, "visitOpinion");
            return (Criteria) this;
        }

        public Criteria andVisitOpinionLessThanOrEqualTo(String value) {
            addCriterion("VISIT_OPINION <=", value, "visitOpinion");
            return (Criteria) this;
        }

        public Criteria andVisitOpinionLike(String value) {
            addCriterion("VISIT_OPINION like", value, "visitOpinion");
            return (Criteria) this;
        }

        public Criteria andVisitOpinionNotLike(String value) {
            addCriterion("VISIT_OPINION not like", value, "visitOpinion");
            return (Criteria) this;
        }

        public Criteria andVisitOpinionIn(List<String> values) {
            addCriterion("VISIT_OPINION in", values, "visitOpinion");
            return (Criteria) this;
        }

        public Criteria andVisitOpinionNotIn(List<String> values) {
            addCriterion("VISIT_OPINION not in", values, "visitOpinion");
            return (Criteria) this;
        }

        public Criteria andVisitOpinionBetween(String value1, String value2) {
            addCriterion("VISIT_OPINION between", value1, value2, "visitOpinion");
            return (Criteria) this;
        }

        public Criteria andVisitOpinionNotBetween(String value1, String value2) {
            addCriterion("VISIT_OPINION not between", value1, value2, "visitOpinion");
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