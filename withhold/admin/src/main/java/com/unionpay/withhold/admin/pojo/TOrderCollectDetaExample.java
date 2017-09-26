package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TOrderCollectDetaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrderCollectDetaExample() {
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

        public Criteria andBatchtidIsNull() {
            addCriterion("BATCHTID is null");
            return (Criteria) this;
        }

        public Criteria andBatchtidIsNotNull() {
            addCriterion("BATCHTID is not null");
            return (Criteria) this;
        }

        public Criteria andBatchtidEqualTo(Long value) {
            addCriterion("BATCHTID =", value, "batchtid");
            return (Criteria) this;
        }

        public Criteria andBatchtidNotEqualTo(Long value) {
            addCriterion("BATCHTID <>", value, "batchtid");
            return (Criteria) this;
        }

        public Criteria andBatchtidGreaterThan(Long value) {
            addCriterion("BATCHTID >", value, "batchtid");
            return (Criteria) this;
        }

        public Criteria andBatchtidGreaterThanOrEqualTo(Long value) {
            addCriterion("BATCHTID >=", value, "batchtid");
            return (Criteria) this;
        }

        public Criteria andBatchtidLessThan(Long value) {
            addCriterion("BATCHTID <", value, "batchtid");
            return (Criteria) this;
        }

        public Criteria andBatchtidLessThanOrEqualTo(Long value) {
            addCriterion("BATCHTID <=", value, "batchtid");
            return (Criteria) this;
        }

        public Criteria andBatchtidIn(List<Long> values) {
            addCriterion("BATCHTID in", values, "batchtid");
            return (Criteria) this;
        }

        public Criteria andBatchtidNotIn(List<Long> values) {
            addCriterion("BATCHTID not in", values, "batchtid");
            return (Criteria) this;
        }

        public Criteria andBatchtidBetween(Long value1, Long value2) {
            addCriterion("BATCHTID between", value1, value2, "batchtid");
            return (Criteria) this;
        }

        public Criteria andBatchtidNotBetween(Long value1, Long value2) {
            addCriterion("BATCHTID not between", value1, value2, "batchtid");
            return (Criteria) this;
        }

        public Criteria andBatchnoIsNull() {
            addCriterion("BATCHNO is null");
            return (Criteria) this;
        }

        public Criteria andBatchnoIsNotNull() {
            addCriterion("BATCHNO is not null");
            return (Criteria) this;
        }

        public Criteria andBatchnoEqualTo(String value) {
            addCriterion("BATCHNO =", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotEqualTo(String value) {
            addCriterion("BATCHNO <>", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoGreaterThan(String value) {
            addCriterion("BATCHNO >", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoGreaterThanOrEqualTo(String value) {
            addCriterion("BATCHNO >=", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoLessThan(String value) {
            addCriterion("BATCHNO <", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoLessThanOrEqualTo(String value) {
            addCriterion("BATCHNO <=", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoLike(String value) {
            addCriterion("BATCHNO like", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotLike(String value) {
            addCriterion("BATCHNO not like", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoIn(List<String> values) {
            addCriterion("BATCHNO in", values, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotIn(List<String> values) {
            addCriterion("BATCHNO not in", values, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoBetween(String value1, String value2) {
            addCriterion("BATCHNO between", value1, value2, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotBetween(String value1, String value2) {
            addCriterion("BATCHNO not between", value1, value2, "batchno");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNull() {
            addCriterion("ORDERID is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("ORDERID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("ORDERID =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("ORDERID <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("ORDERID >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("ORDERID >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("ORDERID <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("ORDERID <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("ORDERID like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("ORDERID not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("ORDERID in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("ORDERID not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("ORDERID between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("ORDERID not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andCurrencycodeIsNull() {
            addCriterion("CURRENCYCODE is null");
            return (Criteria) this;
        }

        public Criteria andCurrencycodeIsNotNull() {
            addCriterion("CURRENCYCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencycodeEqualTo(String value) {
            addCriterion("CURRENCYCODE =", value, "currencycode");
            return (Criteria) this;
        }

        public Criteria andCurrencycodeNotEqualTo(String value) {
            addCriterion("CURRENCYCODE <>", value, "currencycode");
            return (Criteria) this;
        }

        public Criteria andCurrencycodeGreaterThan(String value) {
            addCriterion("CURRENCYCODE >", value, "currencycode");
            return (Criteria) this;
        }

        public Criteria andCurrencycodeGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENCYCODE >=", value, "currencycode");
            return (Criteria) this;
        }

        public Criteria andCurrencycodeLessThan(String value) {
            addCriterion("CURRENCYCODE <", value, "currencycode");
            return (Criteria) this;
        }

        public Criteria andCurrencycodeLessThanOrEqualTo(String value) {
            addCriterion("CURRENCYCODE <=", value, "currencycode");
            return (Criteria) this;
        }

        public Criteria andCurrencycodeLike(String value) {
            addCriterion("CURRENCYCODE like", value, "currencycode");
            return (Criteria) this;
        }

        public Criteria andCurrencycodeNotLike(String value) {
            addCriterion("CURRENCYCODE not like", value, "currencycode");
            return (Criteria) this;
        }

        public Criteria andCurrencycodeIn(List<String> values) {
            addCriterion("CURRENCYCODE in", values, "currencycode");
            return (Criteria) this;
        }

        public Criteria andCurrencycodeNotIn(List<String> values) {
            addCriterion("CURRENCYCODE not in", values, "currencycode");
            return (Criteria) this;
        }

        public Criteria andCurrencycodeBetween(String value1, String value2) {
            addCriterion("CURRENCYCODE between", value1, value2, "currencycode");
            return (Criteria) this;
        }

        public Criteria andCurrencycodeNotBetween(String value1, String value2) {
            addCriterion("CURRENCYCODE not between", value1, value2, "currencycode");
            return (Criteria) this;
        }

        public Criteria andAmtIsNull() {
            addCriterion("AMT is null");
            return (Criteria) this;
        }

        public Criteria andAmtIsNotNull() {
            addCriterion("AMT is not null");
            return (Criteria) this;
        }

        public Criteria andAmtEqualTo(String value) {
            addCriterion("AMT =", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotEqualTo(String value) {
            addCriterion("AMT <>", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtGreaterThan(String value) {
            addCriterion("AMT >", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtGreaterThanOrEqualTo(String value) {
            addCriterion("AMT >=", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtLessThan(String value) {
            addCriterion("AMT <", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtLessThanOrEqualTo(String value) {
            addCriterion("AMT <=", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtLike(String value) {
            addCriterion("AMT like", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotLike(String value) {
            addCriterion("AMT not like", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtIn(List<String> values) {
            addCriterion("AMT in", values, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotIn(List<String> values) {
            addCriterion("AMT not in", values, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtBetween(String value1, String value2) {
            addCriterion("AMT between", value1, value2, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotBetween(String value1, String value2) {
            addCriterion("AMT not between", value1, value2, "amt");
            return (Criteria) this;
        }

        public Criteria andDebtorbankIsNull() {
            addCriterion("DEBTORBANK is null");
            return (Criteria) this;
        }

        public Criteria andDebtorbankIsNotNull() {
            addCriterion("DEBTORBANK is not null");
            return (Criteria) this;
        }

        public Criteria andDebtorbankEqualTo(String value) {
            addCriterion("DEBTORBANK =", value, "debtorbank");
            return (Criteria) this;
        }

        public Criteria andDebtorbankNotEqualTo(String value) {
            addCriterion("DEBTORBANK <>", value, "debtorbank");
            return (Criteria) this;
        }

        public Criteria andDebtorbankGreaterThan(String value) {
            addCriterion("DEBTORBANK >", value, "debtorbank");
            return (Criteria) this;
        }

        public Criteria andDebtorbankGreaterThanOrEqualTo(String value) {
            addCriterion("DEBTORBANK >=", value, "debtorbank");
            return (Criteria) this;
        }

        public Criteria andDebtorbankLessThan(String value) {
            addCriterion("DEBTORBANK <", value, "debtorbank");
            return (Criteria) this;
        }

        public Criteria andDebtorbankLessThanOrEqualTo(String value) {
            addCriterion("DEBTORBANK <=", value, "debtorbank");
            return (Criteria) this;
        }

        public Criteria andDebtorbankLike(String value) {
            addCriterion("DEBTORBANK like", value, "debtorbank");
            return (Criteria) this;
        }

        public Criteria andDebtorbankNotLike(String value) {
            addCriterion("DEBTORBANK not like", value, "debtorbank");
            return (Criteria) this;
        }

        public Criteria andDebtorbankIn(List<String> values) {
            addCriterion("DEBTORBANK in", values, "debtorbank");
            return (Criteria) this;
        }

        public Criteria andDebtorbankNotIn(List<String> values) {
            addCriterion("DEBTORBANK not in", values, "debtorbank");
            return (Criteria) this;
        }

        public Criteria andDebtorbankBetween(String value1, String value2) {
            addCriterion("DEBTORBANK between", value1, value2, "debtorbank");
            return (Criteria) this;
        }

        public Criteria andDebtorbankNotBetween(String value1, String value2) {
            addCriterion("DEBTORBANK not between", value1, value2, "debtorbank");
            return (Criteria) this;
        }

        public Criteria andDebtoraccountIsNull() {
            addCriterion("DEBTORACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andDebtoraccountIsNotNull() {
            addCriterion("DEBTORACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDebtoraccountEqualTo(String value) {
            addCriterion("DEBTORACCOUNT =", value, "debtoraccount");
            return (Criteria) this;
        }

        public Criteria andDebtoraccountNotEqualTo(String value) {
            addCriterion("DEBTORACCOUNT <>", value, "debtoraccount");
            return (Criteria) this;
        }

        public Criteria andDebtoraccountGreaterThan(String value) {
            addCriterion("DEBTORACCOUNT >", value, "debtoraccount");
            return (Criteria) this;
        }

        public Criteria andDebtoraccountGreaterThanOrEqualTo(String value) {
            addCriterion("DEBTORACCOUNT >=", value, "debtoraccount");
            return (Criteria) this;
        }

        public Criteria andDebtoraccountLessThan(String value) {
            addCriterion("DEBTORACCOUNT <", value, "debtoraccount");
            return (Criteria) this;
        }

        public Criteria andDebtoraccountLessThanOrEqualTo(String value) {
            addCriterion("DEBTORACCOUNT <=", value, "debtoraccount");
            return (Criteria) this;
        }

        public Criteria andDebtoraccountLike(String value) {
            addCriterion("DEBTORACCOUNT like", value, "debtoraccount");
            return (Criteria) this;
        }

        public Criteria andDebtoraccountNotLike(String value) {
            addCriterion("DEBTORACCOUNT not like", value, "debtoraccount");
            return (Criteria) this;
        }

        public Criteria andDebtoraccountIn(List<String> values) {
            addCriterion("DEBTORACCOUNT in", values, "debtoraccount");
            return (Criteria) this;
        }

        public Criteria andDebtoraccountNotIn(List<String> values) {
            addCriterion("DEBTORACCOUNT not in", values, "debtoraccount");
            return (Criteria) this;
        }

        public Criteria andDebtoraccountBetween(String value1, String value2) {
            addCriterion("DEBTORACCOUNT between", value1, value2, "debtoraccount");
            return (Criteria) this;
        }

        public Criteria andDebtoraccountNotBetween(String value1, String value2) {
            addCriterion("DEBTORACCOUNT not between", value1, value2, "debtoraccount");
            return (Criteria) this;
        }

        public Criteria andDebtornameIsNull() {
            addCriterion("DEBTORNAME is null");
            return (Criteria) this;
        }

        public Criteria andDebtornameIsNotNull() {
            addCriterion("DEBTORNAME is not null");
            return (Criteria) this;
        }

        public Criteria andDebtornameEqualTo(String value) {
            addCriterion("DEBTORNAME =", value, "debtorname");
            return (Criteria) this;
        }

        public Criteria andDebtornameNotEqualTo(String value) {
            addCriterion("DEBTORNAME <>", value, "debtorname");
            return (Criteria) this;
        }

        public Criteria andDebtornameGreaterThan(String value) {
            addCriterion("DEBTORNAME >", value, "debtorname");
            return (Criteria) this;
        }

        public Criteria andDebtornameGreaterThanOrEqualTo(String value) {
            addCriterion("DEBTORNAME >=", value, "debtorname");
            return (Criteria) this;
        }

        public Criteria andDebtornameLessThan(String value) {
            addCriterion("DEBTORNAME <", value, "debtorname");
            return (Criteria) this;
        }

        public Criteria andDebtornameLessThanOrEqualTo(String value) {
            addCriterion("DEBTORNAME <=", value, "debtorname");
            return (Criteria) this;
        }

        public Criteria andDebtornameLike(String value) {
            addCriterion("DEBTORNAME like", value, "debtorname");
            return (Criteria) this;
        }

        public Criteria andDebtornameNotLike(String value) {
            addCriterion("DEBTORNAME not like", value, "debtorname");
            return (Criteria) this;
        }

        public Criteria andDebtornameIn(List<String> values) {
            addCriterion("DEBTORNAME in", values, "debtorname");
            return (Criteria) this;
        }

        public Criteria andDebtornameNotIn(List<String> values) {
            addCriterion("DEBTORNAME not in", values, "debtorname");
            return (Criteria) this;
        }

        public Criteria andDebtornameBetween(String value1, String value2) {
            addCriterion("DEBTORNAME between", value1, value2, "debtorname");
            return (Criteria) this;
        }

        public Criteria andDebtornameNotBetween(String value1, String value2) {
            addCriterion("DEBTORNAME not between", value1, value2, "debtorname");
            return (Criteria) this;
        }

        public Criteria andDebtorconsignIsNull() {
            addCriterion("DEBTORCONSIGN is null");
            return (Criteria) this;
        }

        public Criteria andDebtorconsignIsNotNull() {
            addCriterion("DEBTORCONSIGN is not null");
            return (Criteria) this;
        }

        public Criteria andDebtorconsignEqualTo(String value) {
            addCriterion("DEBTORCONSIGN =", value, "debtorconsign");
            return (Criteria) this;
        }

        public Criteria andDebtorconsignNotEqualTo(String value) {
            addCriterion("DEBTORCONSIGN <>", value, "debtorconsign");
            return (Criteria) this;
        }

        public Criteria andDebtorconsignGreaterThan(String value) {
            addCriterion("DEBTORCONSIGN >", value, "debtorconsign");
            return (Criteria) this;
        }

        public Criteria andDebtorconsignGreaterThanOrEqualTo(String value) {
            addCriterion("DEBTORCONSIGN >=", value, "debtorconsign");
            return (Criteria) this;
        }

        public Criteria andDebtorconsignLessThan(String value) {
            addCriterion("DEBTORCONSIGN <", value, "debtorconsign");
            return (Criteria) this;
        }

        public Criteria andDebtorconsignLessThanOrEqualTo(String value) {
            addCriterion("DEBTORCONSIGN <=", value, "debtorconsign");
            return (Criteria) this;
        }

        public Criteria andDebtorconsignLike(String value) {
            addCriterion("DEBTORCONSIGN like", value, "debtorconsign");
            return (Criteria) this;
        }

        public Criteria andDebtorconsignNotLike(String value) {
            addCriterion("DEBTORCONSIGN not like", value, "debtorconsign");
            return (Criteria) this;
        }

        public Criteria andDebtorconsignIn(List<String> values) {
            addCriterion("DEBTORCONSIGN in", values, "debtorconsign");
            return (Criteria) this;
        }

        public Criteria andDebtorconsignNotIn(List<String> values) {
            addCriterion("DEBTORCONSIGN not in", values, "debtorconsign");
            return (Criteria) this;
        }

        public Criteria andDebtorconsignBetween(String value1, String value2) {
            addCriterion("DEBTORCONSIGN between", value1, value2, "debtorconsign");
            return (Criteria) this;
        }

        public Criteria andDebtorconsignNotBetween(String value1, String value2) {
            addCriterion("DEBTORCONSIGN not between", value1, value2, "debtorconsign");
            return (Criteria) this;
        }

        public Criteria andCreditorbankIsNull() {
            addCriterion("CREDITORBANK is null");
            return (Criteria) this;
        }

        public Criteria andCreditorbankIsNotNull() {
            addCriterion("CREDITORBANK is not null");
            return (Criteria) this;
        }

        public Criteria andCreditorbankEqualTo(String value) {
            addCriterion("CREDITORBANK =", value, "creditorbank");
            return (Criteria) this;
        }

        public Criteria andCreditorbankNotEqualTo(String value) {
            addCriterion("CREDITORBANK <>", value, "creditorbank");
            return (Criteria) this;
        }

        public Criteria andCreditorbankGreaterThan(String value) {
            addCriterion("CREDITORBANK >", value, "creditorbank");
            return (Criteria) this;
        }

        public Criteria andCreditorbankGreaterThanOrEqualTo(String value) {
            addCriterion("CREDITORBANK >=", value, "creditorbank");
            return (Criteria) this;
        }

        public Criteria andCreditorbankLessThan(String value) {
            addCriterion("CREDITORBANK <", value, "creditorbank");
            return (Criteria) this;
        }

        public Criteria andCreditorbankLessThanOrEqualTo(String value) {
            addCriterion("CREDITORBANK <=", value, "creditorbank");
            return (Criteria) this;
        }

        public Criteria andCreditorbankLike(String value) {
            addCriterion("CREDITORBANK like", value, "creditorbank");
            return (Criteria) this;
        }

        public Criteria andCreditorbankNotLike(String value) {
            addCriterion("CREDITORBANK not like", value, "creditorbank");
            return (Criteria) this;
        }

        public Criteria andCreditorbankIn(List<String> values) {
            addCriterion("CREDITORBANK in", values, "creditorbank");
            return (Criteria) this;
        }

        public Criteria andCreditorbankNotIn(List<String> values) {
            addCriterion("CREDITORBANK not in", values, "creditorbank");
            return (Criteria) this;
        }

        public Criteria andCreditorbankBetween(String value1, String value2) {
            addCriterion("CREDITORBANK between", value1, value2, "creditorbank");
            return (Criteria) this;
        }

        public Criteria andCreditorbankNotBetween(String value1, String value2) {
            addCriterion("CREDITORBANK not between", value1, value2, "creditorbank");
            return (Criteria) this;
        }

        public Criteria andCreditoraccountIsNull() {
            addCriterion("CREDITORACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andCreditoraccountIsNotNull() {
            addCriterion("CREDITORACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCreditoraccountEqualTo(String value) {
            addCriterion("CREDITORACCOUNT =", value, "creditoraccount");
            return (Criteria) this;
        }

        public Criteria andCreditoraccountNotEqualTo(String value) {
            addCriterion("CREDITORACCOUNT <>", value, "creditoraccount");
            return (Criteria) this;
        }

        public Criteria andCreditoraccountGreaterThan(String value) {
            addCriterion("CREDITORACCOUNT >", value, "creditoraccount");
            return (Criteria) this;
        }

        public Criteria andCreditoraccountGreaterThanOrEqualTo(String value) {
            addCriterion("CREDITORACCOUNT >=", value, "creditoraccount");
            return (Criteria) this;
        }

        public Criteria andCreditoraccountLessThan(String value) {
            addCriterion("CREDITORACCOUNT <", value, "creditoraccount");
            return (Criteria) this;
        }

        public Criteria andCreditoraccountLessThanOrEqualTo(String value) {
            addCriterion("CREDITORACCOUNT <=", value, "creditoraccount");
            return (Criteria) this;
        }

        public Criteria andCreditoraccountLike(String value) {
            addCriterion("CREDITORACCOUNT like", value, "creditoraccount");
            return (Criteria) this;
        }

        public Criteria andCreditoraccountNotLike(String value) {
            addCriterion("CREDITORACCOUNT not like", value, "creditoraccount");
            return (Criteria) this;
        }

        public Criteria andCreditoraccountIn(List<String> values) {
            addCriterion("CREDITORACCOUNT in", values, "creditoraccount");
            return (Criteria) this;
        }

        public Criteria andCreditoraccountNotIn(List<String> values) {
            addCriterion("CREDITORACCOUNT not in", values, "creditoraccount");
            return (Criteria) this;
        }

        public Criteria andCreditoraccountBetween(String value1, String value2) {
            addCriterion("CREDITORACCOUNT between", value1, value2, "creditoraccount");
            return (Criteria) this;
        }

        public Criteria andCreditoraccountNotBetween(String value1, String value2) {
            addCriterion("CREDITORACCOUNT not between", value1, value2, "creditoraccount");
            return (Criteria) this;
        }

        public Criteria andCreditornameIsNull() {
            addCriterion("CREDITORNAME is null");
            return (Criteria) this;
        }

        public Criteria andCreditornameIsNotNull() {
            addCriterion("CREDITORNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCreditornameEqualTo(String value) {
            addCriterion("CREDITORNAME =", value, "creditorname");
            return (Criteria) this;
        }

        public Criteria andCreditornameNotEqualTo(String value) {
            addCriterion("CREDITORNAME <>", value, "creditorname");
            return (Criteria) this;
        }

        public Criteria andCreditornameGreaterThan(String value) {
            addCriterion("CREDITORNAME >", value, "creditorname");
            return (Criteria) this;
        }

        public Criteria andCreditornameGreaterThanOrEqualTo(String value) {
            addCriterion("CREDITORNAME >=", value, "creditorname");
            return (Criteria) this;
        }

        public Criteria andCreditornameLessThan(String value) {
            addCriterion("CREDITORNAME <", value, "creditorname");
            return (Criteria) this;
        }

        public Criteria andCreditornameLessThanOrEqualTo(String value) {
            addCriterion("CREDITORNAME <=", value, "creditorname");
            return (Criteria) this;
        }

        public Criteria andCreditornameLike(String value) {
            addCriterion("CREDITORNAME like", value, "creditorname");
            return (Criteria) this;
        }

        public Criteria andCreditornameNotLike(String value) {
            addCriterion("CREDITORNAME not like", value, "creditorname");
            return (Criteria) this;
        }

        public Criteria andCreditornameIn(List<String> values) {
            addCriterion("CREDITORNAME in", values, "creditorname");
            return (Criteria) this;
        }

        public Criteria andCreditornameNotIn(List<String> values) {
            addCriterion("CREDITORNAME not in", values, "creditorname");
            return (Criteria) this;
        }

        public Criteria andCreditornameBetween(String value1, String value2) {
            addCriterion("CREDITORNAME between", value1, value2, "creditorname");
            return (Criteria) this;
        }

        public Criteria andCreditornameNotBetween(String value1, String value2) {
            addCriterion("CREDITORNAME not between", value1, value2, "creditorname");
            return (Criteria) this;
        }

        public Criteria andProprietaryIsNull() {
            addCriterion("PROPRIETARY is null");
            return (Criteria) this;
        }

        public Criteria andProprietaryIsNotNull() {
            addCriterion("PROPRIETARY is not null");
            return (Criteria) this;
        }

        public Criteria andProprietaryEqualTo(String value) {
            addCriterion("PROPRIETARY =", value, "proprietary");
            return (Criteria) this;
        }

        public Criteria andProprietaryNotEqualTo(String value) {
            addCriterion("PROPRIETARY <>", value, "proprietary");
            return (Criteria) this;
        }

        public Criteria andProprietaryGreaterThan(String value) {
            addCriterion("PROPRIETARY >", value, "proprietary");
            return (Criteria) this;
        }

        public Criteria andProprietaryGreaterThanOrEqualTo(String value) {
            addCriterion("PROPRIETARY >=", value, "proprietary");
            return (Criteria) this;
        }

        public Criteria andProprietaryLessThan(String value) {
            addCriterion("PROPRIETARY <", value, "proprietary");
            return (Criteria) this;
        }

        public Criteria andProprietaryLessThanOrEqualTo(String value) {
            addCriterion("PROPRIETARY <=", value, "proprietary");
            return (Criteria) this;
        }

        public Criteria andProprietaryLike(String value) {
            addCriterion("PROPRIETARY like", value, "proprietary");
            return (Criteria) this;
        }

        public Criteria andProprietaryNotLike(String value) {
            addCriterion("PROPRIETARY not like", value, "proprietary");
            return (Criteria) this;
        }

        public Criteria andProprietaryIn(List<String> values) {
            addCriterion("PROPRIETARY in", values, "proprietary");
            return (Criteria) this;
        }

        public Criteria andProprietaryNotIn(List<String> values) {
            addCriterion("PROPRIETARY not in", values, "proprietary");
            return (Criteria) this;
        }

        public Criteria andProprietaryBetween(String value1, String value2) {
            addCriterion("PROPRIETARY between", value1, value2, "proprietary");
            return (Criteria) this;
        }

        public Criteria andProprietaryNotBetween(String value1, String value2) {
            addCriterion("PROPRIETARY not between", value1, value2, "proprietary");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("SUMMARY is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("SUMMARY is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("SUMMARY =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("SUMMARY <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("SUMMARY >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("SUMMARY >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("SUMMARY <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("SUMMARY <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("SUMMARY like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("SUMMARY not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("SUMMARY in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("SUMMARY not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("SUMMARY between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("SUMMARY not between", value1, value2, "summary");
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

        public Criteria andRelatetradetxnIsNull() {
            addCriterion("RELATETRADETXN is null");
            return (Criteria) this;
        }

        public Criteria andRelatetradetxnIsNotNull() {
            addCriterion("RELATETRADETXN is not null");
            return (Criteria) this;
        }

        public Criteria andRelatetradetxnEqualTo(String value) {
            addCriterion("RELATETRADETXN =", value, "relatetradetxn");
            return (Criteria) this;
        }

        public Criteria andRelatetradetxnNotEqualTo(String value) {
            addCriterion("RELATETRADETXN <>", value, "relatetradetxn");
            return (Criteria) this;
        }

        public Criteria andRelatetradetxnGreaterThan(String value) {
            addCriterion("RELATETRADETXN >", value, "relatetradetxn");
            return (Criteria) this;
        }

        public Criteria andRelatetradetxnGreaterThanOrEqualTo(String value) {
            addCriterion("RELATETRADETXN >=", value, "relatetradetxn");
            return (Criteria) this;
        }

        public Criteria andRelatetradetxnLessThan(String value) {
            addCriterion("RELATETRADETXN <", value, "relatetradetxn");
            return (Criteria) this;
        }

        public Criteria andRelatetradetxnLessThanOrEqualTo(String value) {
            addCriterion("RELATETRADETXN <=", value, "relatetradetxn");
            return (Criteria) this;
        }

        public Criteria andRelatetradetxnLike(String value) {
            addCriterion("RELATETRADETXN like", value, "relatetradetxn");
            return (Criteria) this;
        }

        public Criteria andRelatetradetxnNotLike(String value) {
            addCriterion("RELATETRADETXN not like", value, "relatetradetxn");
            return (Criteria) this;
        }

        public Criteria andRelatetradetxnIn(List<String> values) {
            addCriterion("RELATETRADETXN in", values, "relatetradetxn");
            return (Criteria) this;
        }

        public Criteria andRelatetradetxnNotIn(List<String> values) {
            addCriterion("RELATETRADETXN not in", values, "relatetradetxn");
            return (Criteria) this;
        }

        public Criteria andRelatetradetxnBetween(String value1, String value2) {
            addCriterion("RELATETRADETXN between", value1, value2, "relatetradetxn");
            return (Criteria) this;
        }

        public Criteria andRelatetradetxnNotBetween(String value1, String value2) {
            addCriterion("RELATETRADETXN not between", value1, value2, "relatetradetxn");
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