package com.unionpay.withhold.trade.order.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderCollectSingleDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderCollectSingleDOExample() {
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

        public Criteria andAccesstypeIsNull() {
            addCriterion("ACCESSTYPE is null");
            return (Criteria) this;
        }

        public Criteria andAccesstypeIsNotNull() {
            addCriterion("ACCESSTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAccesstypeEqualTo(String value) {
            addCriterion("ACCESSTYPE =", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeNotEqualTo(String value) {
            addCriterion("ACCESSTYPE <>", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeGreaterThan(String value) {
            addCriterion("ACCESSTYPE >", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCESSTYPE >=", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeLessThan(String value) {
            addCriterion("ACCESSTYPE <", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeLessThanOrEqualTo(String value) {
            addCriterion("ACCESSTYPE <=", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeLike(String value) {
            addCriterion("ACCESSTYPE like", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeNotLike(String value) {
            addCriterion("ACCESSTYPE not like", value, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeIn(List<String> values) {
            addCriterion("ACCESSTYPE in", values, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeNotIn(List<String> values) {
            addCriterion("ACCESSTYPE not in", values, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeBetween(String value1, String value2) {
            addCriterion("ACCESSTYPE between", value1, value2, "accesstype");
            return (Criteria) this;
        }

        public Criteria andAccesstypeNotBetween(String value1, String value2) {
            addCriterion("ACCESSTYPE not between", value1, value2, "accesstype");
            return (Criteria) this;
        }

        public Criteria andCoopinstiidIsNull() {
            addCriterion("COOPINSTIID is null");
            return (Criteria) this;
        }

        public Criteria andCoopinstiidIsNotNull() {
            addCriterion("COOPINSTIID is not null");
            return (Criteria) this;
        }

        public Criteria andCoopinstiidEqualTo(String value) {
            addCriterion("COOPINSTIID =", value, "coopinstiid");
            return (Criteria) this;
        }

        public Criteria andCoopinstiidNotEqualTo(String value) {
            addCriterion("COOPINSTIID <>", value, "coopinstiid");
            return (Criteria) this;
        }

        public Criteria andCoopinstiidGreaterThan(String value) {
            addCriterion("COOPINSTIID >", value, "coopinstiid");
            return (Criteria) this;
        }

        public Criteria andCoopinstiidGreaterThanOrEqualTo(String value) {
            addCriterion("COOPINSTIID >=", value, "coopinstiid");
            return (Criteria) this;
        }

        public Criteria andCoopinstiidLessThan(String value) {
            addCriterion("COOPINSTIID <", value, "coopinstiid");
            return (Criteria) this;
        }

        public Criteria andCoopinstiidLessThanOrEqualTo(String value) {
            addCriterion("COOPINSTIID <=", value, "coopinstiid");
            return (Criteria) this;
        }

        public Criteria andCoopinstiidLike(String value) {
            addCriterion("COOPINSTIID like", value, "coopinstiid");
            return (Criteria) this;
        }

        public Criteria andCoopinstiidNotLike(String value) {
            addCriterion("COOPINSTIID not like", value, "coopinstiid");
            return (Criteria) this;
        }

        public Criteria andCoopinstiidIn(List<String> values) {
            addCriterion("COOPINSTIID in", values, "coopinstiid");
            return (Criteria) this;
        }

        public Criteria andCoopinstiidNotIn(List<String> values) {
            addCriterion("COOPINSTIID not in", values, "coopinstiid");
            return (Criteria) this;
        }

        public Criteria andCoopinstiidBetween(String value1, String value2) {
            addCriterion("COOPINSTIID between", value1, value2, "coopinstiid");
            return (Criteria) this;
        }

        public Criteria andCoopinstiidNotBetween(String value1, String value2) {
            addCriterion("COOPINSTIID not between", value1, value2, "coopinstiid");
            return (Criteria) this;
        }

        public Criteria andMeridIsNull() {
            addCriterion("MERID is null");
            return (Criteria) this;
        }

        public Criteria andMeridIsNotNull() {
            addCriterion("MERID is not null");
            return (Criteria) this;
        }

        public Criteria andMeridEqualTo(String value) {
            addCriterion("MERID =", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridNotEqualTo(String value) {
            addCriterion("MERID <>", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridGreaterThan(String value) {
            addCriterion("MERID >", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridGreaterThanOrEqualTo(String value) {
            addCriterion("MERID >=", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridLessThan(String value) {
            addCriterion("MERID <", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridLessThanOrEqualTo(String value) {
            addCriterion("MERID <=", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridLike(String value) {
            addCriterion("MERID like", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridNotLike(String value) {
            addCriterion("MERID not like", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridIn(List<String> values) {
            addCriterion("MERID in", values, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridNotIn(List<String> values) {
            addCriterion("MERID not in", values, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridBetween(String value1, String value2) {
            addCriterion("MERID between", value1, value2, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridNotBetween(String value1, String value2) {
            addCriterion("MERID not between", value1, value2, "merid");
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

        public Criteria andTxntypeIsNull() {
            addCriterion("TXNTYPE is null");
            return (Criteria) this;
        }

        public Criteria andTxntypeIsNotNull() {
            addCriterion("TXNTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTxntypeEqualTo(String value) {
            addCriterion("TXNTYPE =", value, "txntype");
            return (Criteria) this;
        }

        public Criteria andTxntypeNotEqualTo(String value) {
            addCriterion("TXNTYPE <>", value, "txntype");
            return (Criteria) this;
        }

        public Criteria andTxntypeGreaterThan(String value) {
            addCriterion("TXNTYPE >", value, "txntype");
            return (Criteria) this;
        }

        public Criteria andTxntypeGreaterThanOrEqualTo(String value) {
            addCriterion("TXNTYPE >=", value, "txntype");
            return (Criteria) this;
        }

        public Criteria andTxntypeLessThan(String value) {
            addCriterion("TXNTYPE <", value, "txntype");
            return (Criteria) this;
        }

        public Criteria andTxntypeLessThanOrEqualTo(String value) {
            addCriterion("TXNTYPE <=", value, "txntype");
            return (Criteria) this;
        }

        public Criteria andTxntypeLike(String value) {
            addCriterion("TXNTYPE like", value, "txntype");
            return (Criteria) this;
        }

        public Criteria andTxntypeNotLike(String value) {
            addCriterion("TXNTYPE not like", value, "txntype");
            return (Criteria) this;
        }

        public Criteria andTxntypeIn(List<String> values) {
            addCriterion("TXNTYPE in", values, "txntype");
            return (Criteria) this;
        }

        public Criteria andTxntypeNotIn(List<String> values) {
            addCriterion("TXNTYPE not in", values, "txntype");
            return (Criteria) this;
        }

        public Criteria andTxntypeBetween(String value1, String value2) {
            addCriterion("TXNTYPE between", value1, value2, "txntype");
            return (Criteria) this;
        }

        public Criteria andTxntypeNotBetween(String value1, String value2) {
            addCriterion("TXNTYPE not between", value1, value2, "txntype");
            return (Criteria) this;
        }

        public Criteria andTxnsubtypeIsNull() {
            addCriterion("TXNSUBTYPE is null");
            return (Criteria) this;
        }

        public Criteria andTxnsubtypeIsNotNull() {
            addCriterion("TXNSUBTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTxnsubtypeEqualTo(String value) {
            addCriterion("TXNSUBTYPE =", value, "txnsubtype");
            return (Criteria) this;
        }

        public Criteria andTxnsubtypeNotEqualTo(String value) {
            addCriterion("TXNSUBTYPE <>", value, "txnsubtype");
            return (Criteria) this;
        }

        public Criteria andTxnsubtypeGreaterThan(String value) {
            addCriterion("TXNSUBTYPE >", value, "txnsubtype");
            return (Criteria) this;
        }

        public Criteria andTxnsubtypeGreaterThanOrEqualTo(String value) {
            addCriterion("TXNSUBTYPE >=", value, "txnsubtype");
            return (Criteria) this;
        }

        public Criteria andTxnsubtypeLessThan(String value) {
            addCriterion("TXNSUBTYPE <", value, "txnsubtype");
            return (Criteria) this;
        }

        public Criteria andTxnsubtypeLessThanOrEqualTo(String value) {
            addCriterion("TXNSUBTYPE <=", value, "txnsubtype");
            return (Criteria) this;
        }

        public Criteria andTxnsubtypeLike(String value) {
            addCriterion("TXNSUBTYPE like", value, "txnsubtype");
            return (Criteria) this;
        }

        public Criteria andTxnsubtypeNotLike(String value) {
            addCriterion("TXNSUBTYPE not like", value, "txnsubtype");
            return (Criteria) this;
        }

        public Criteria andTxnsubtypeIn(List<String> values) {
            addCriterion("TXNSUBTYPE in", values, "txnsubtype");
            return (Criteria) this;
        }

        public Criteria andTxnsubtypeNotIn(List<String> values) {
            addCriterion("TXNSUBTYPE not in", values, "txnsubtype");
            return (Criteria) this;
        }

        public Criteria andTxnsubtypeBetween(String value1, String value2) {
            addCriterion("TXNSUBTYPE between", value1, value2, "txnsubtype");
            return (Criteria) this;
        }

        public Criteria andTxnsubtypeNotBetween(String value1, String value2) {
            addCriterion("TXNSUBTYPE not between", value1, value2, "txnsubtype");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNull() {
            addCriterion("BIZTYPE is null");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNotNull() {
            addCriterion("BIZTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBiztypeEqualTo(String value) {
            addCriterion("BIZTYPE =", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotEqualTo(String value) {
            addCriterion("BIZTYPE <>", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThan(String value) {
            addCriterion("BIZTYPE >", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThanOrEqualTo(String value) {
            addCriterion("BIZTYPE >=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThan(String value) {
            addCriterion("BIZTYPE <", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThanOrEqualTo(String value) {
            addCriterion("BIZTYPE <=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLike(String value) {
            addCriterion("BIZTYPE like", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotLike(String value) {
            addCriterion("BIZTYPE not like", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeIn(List<String> values) {
            addCriterion("BIZTYPE in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotIn(List<String> values) {
            addCriterion("BIZTYPE not in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeBetween(String value1, String value2) {
            addCriterion("BIZTYPE between", value1, value2, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotBetween(String value1, String value2) {
            addCriterion("BIZTYPE not between", value1, value2, "biztype");
            return (Criteria) this;
        }

        public Criteria andBackurlIsNull() {
            addCriterion("BACKURL is null");
            return (Criteria) this;
        }

        public Criteria andBackurlIsNotNull() {
            addCriterion("BACKURL is not null");
            return (Criteria) this;
        }

        public Criteria andBackurlEqualTo(String value) {
            addCriterion("BACKURL =", value, "backurl");
            return (Criteria) this;
        }

        public Criteria andBackurlNotEqualTo(String value) {
            addCriterion("BACKURL <>", value, "backurl");
            return (Criteria) this;
        }

        public Criteria andBackurlGreaterThan(String value) {
            addCriterion("BACKURL >", value, "backurl");
            return (Criteria) this;
        }

        public Criteria andBackurlGreaterThanOrEqualTo(String value) {
            addCriterion("BACKURL >=", value, "backurl");
            return (Criteria) this;
        }

        public Criteria andBackurlLessThan(String value) {
            addCriterion("BACKURL <", value, "backurl");
            return (Criteria) this;
        }

        public Criteria andBackurlLessThanOrEqualTo(String value) {
            addCriterion("BACKURL <=", value, "backurl");
            return (Criteria) this;
        }

        public Criteria andBackurlLike(String value) {
            addCriterion("BACKURL like", value, "backurl");
            return (Criteria) this;
        }

        public Criteria andBackurlNotLike(String value) {
            addCriterion("BACKURL not like", value, "backurl");
            return (Criteria) this;
        }

        public Criteria andBackurlIn(List<String> values) {
            addCriterion("BACKURL in", values, "backurl");
            return (Criteria) this;
        }

        public Criteria andBackurlNotIn(List<String> values) {
            addCriterion("BACKURL not in", values, "backurl");
            return (Criteria) this;
        }

        public Criteria andBackurlBetween(String value1, String value2) {
            addCriterion("BACKURL between", value1, value2, "backurl");
            return (Criteria) this;
        }

        public Criteria andBackurlNotBetween(String value1, String value2) {
            addCriterion("BACKURL not between", value1, value2, "backurl");
            return (Criteria) this;
        }

        public Criteria andMernameIsNull() {
            addCriterion("MERNAME is null");
            return (Criteria) this;
        }

        public Criteria andMernameIsNotNull() {
            addCriterion("MERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andMernameEqualTo(String value) {
            addCriterion("MERNAME =", value, "mername");
            return (Criteria) this;
        }

        public Criteria andMernameNotEqualTo(String value) {
            addCriterion("MERNAME <>", value, "mername");
            return (Criteria) this;
        }

        public Criteria andMernameGreaterThan(String value) {
            addCriterion("MERNAME >", value, "mername");
            return (Criteria) this;
        }

        public Criteria andMernameGreaterThanOrEqualTo(String value) {
            addCriterion("MERNAME >=", value, "mername");
            return (Criteria) this;
        }

        public Criteria andMernameLessThan(String value) {
            addCriterion("MERNAME <", value, "mername");
            return (Criteria) this;
        }

        public Criteria andMernameLessThanOrEqualTo(String value) {
            addCriterion("MERNAME <=", value, "mername");
            return (Criteria) this;
        }

        public Criteria andMernameLike(String value) {
            addCriterion("MERNAME like", value, "mername");
            return (Criteria) this;
        }

        public Criteria andMernameNotLike(String value) {
            addCriterion("MERNAME not like", value, "mername");
            return (Criteria) this;
        }

        public Criteria andMernameIn(List<String> values) {
            addCriterion("MERNAME in", values, "mername");
            return (Criteria) this;
        }

        public Criteria andMernameNotIn(List<String> values) {
            addCriterion("MERNAME not in", values, "mername");
            return (Criteria) this;
        }

        public Criteria andMernameBetween(String value1, String value2) {
            addCriterion("MERNAME between", value1, value2, "mername");
            return (Criteria) this;
        }

        public Criteria andMernameNotBetween(String value1, String value2) {
            addCriterion("MERNAME not between", value1, value2, "mername");
            return (Criteria) this;
        }

        public Criteria andMerabbrIsNull() {
            addCriterion("MERABBR is null");
            return (Criteria) this;
        }

        public Criteria andMerabbrIsNotNull() {
            addCriterion("MERABBR is not null");
            return (Criteria) this;
        }

        public Criteria andMerabbrEqualTo(String value) {
            addCriterion("MERABBR =", value, "merabbr");
            return (Criteria) this;
        }

        public Criteria andMerabbrNotEqualTo(String value) {
            addCriterion("MERABBR <>", value, "merabbr");
            return (Criteria) this;
        }

        public Criteria andMerabbrGreaterThan(String value) {
            addCriterion("MERABBR >", value, "merabbr");
            return (Criteria) this;
        }

        public Criteria andMerabbrGreaterThanOrEqualTo(String value) {
            addCriterion("MERABBR >=", value, "merabbr");
            return (Criteria) this;
        }

        public Criteria andMerabbrLessThan(String value) {
            addCriterion("MERABBR <", value, "merabbr");
            return (Criteria) this;
        }

        public Criteria andMerabbrLessThanOrEqualTo(String value) {
            addCriterion("MERABBR <=", value, "merabbr");
            return (Criteria) this;
        }

        public Criteria andMerabbrLike(String value) {
            addCriterion("MERABBR like", value, "merabbr");
            return (Criteria) this;
        }

        public Criteria andMerabbrNotLike(String value) {
            addCriterion("MERABBR not like", value, "merabbr");
            return (Criteria) this;
        }

        public Criteria andMerabbrIn(List<String> values) {
            addCriterion("MERABBR in", values, "merabbr");
            return (Criteria) this;
        }

        public Criteria andMerabbrNotIn(List<String> values) {
            addCriterion("MERABBR not in", values, "merabbr");
            return (Criteria) this;
        }

        public Criteria andMerabbrBetween(String value1, String value2) {
            addCriterion("MERABBR between", value1, value2, "merabbr");
            return (Criteria) this;
        }

        public Criteria andMerabbrNotBetween(String value1, String value2) {
            addCriterion("MERABBR not between", value1, value2, "merabbr");
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

        public Criteria andTxntimeIsNull() {
            addCriterion("TXNTIME is null");
            return (Criteria) this;
        }

        public Criteria andTxntimeIsNotNull() {
            addCriterion("TXNTIME is not null");
            return (Criteria) this;
        }

        public Criteria andTxntimeEqualTo(String value) {
            addCriterion("TXNTIME =", value, "txntime");
            return (Criteria) this;
        }

        public Criteria andTxntimeNotEqualTo(String value) {
            addCriterion("TXNTIME <>", value, "txntime");
            return (Criteria) this;
        }

        public Criteria andTxntimeGreaterThan(String value) {
            addCriterion("TXNTIME >", value, "txntime");
            return (Criteria) this;
        }

        public Criteria andTxntimeGreaterThanOrEqualTo(String value) {
            addCriterion("TXNTIME >=", value, "txntime");
            return (Criteria) this;
        }

        public Criteria andTxntimeLessThan(String value) {
            addCriterion("TXNTIME <", value, "txntime");
            return (Criteria) this;
        }

        public Criteria andTxntimeLessThanOrEqualTo(String value) {
            addCriterion("TXNTIME <=", value, "txntime");
            return (Criteria) this;
        }

        public Criteria andTxntimeLike(String value) {
            addCriterion("TXNTIME like", value, "txntime");
            return (Criteria) this;
        }

        public Criteria andTxntimeNotLike(String value) {
            addCriterion("TXNTIME not like", value, "txntime");
            return (Criteria) this;
        }

        public Criteria andTxntimeIn(List<String> values) {
            addCriterion("TXNTIME in", values, "txntime");
            return (Criteria) this;
        }

        public Criteria andTxntimeNotIn(List<String> values) {
            addCriterion("TXNTIME not in", values, "txntime");
            return (Criteria) this;
        }

        public Criteria andTxntimeBetween(String value1, String value2) {
            addCriterion("TXNTIME between", value1, value2, "txntime");
            return (Criteria) this;
        }

        public Criteria andTxntimeNotBetween(String value1, String value2) {
            addCriterion("TXNTIME not between", value1, value2, "txntime");
            return (Criteria) this;
        }

        public Criteria andPaytimeoutIsNull() {
            addCriterion("PAYTIMEOUT is null");
            return (Criteria) this;
        }

        public Criteria andPaytimeoutIsNotNull() {
            addCriterion("PAYTIMEOUT is not null");
            return (Criteria) this;
        }

        public Criteria andPaytimeoutEqualTo(String value) {
            addCriterion("PAYTIMEOUT =", value, "paytimeout");
            return (Criteria) this;
        }

        public Criteria andPaytimeoutNotEqualTo(String value) {
            addCriterion("PAYTIMEOUT <>", value, "paytimeout");
            return (Criteria) this;
        }

        public Criteria andPaytimeoutGreaterThan(String value) {
            addCriterion("PAYTIMEOUT >", value, "paytimeout");
            return (Criteria) this;
        }

        public Criteria andPaytimeoutGreaterThanOrEqualTo(String value) {
            addCriterion("PAYTIMEOUT >=", value, "paytimeout");
            return (Criteria) this;
        }

        public Criteria andPaytimeoutLessThan(String value) {
            addCriterion("PAYTIMEOUT <", value, "paytimeout");
            return (Criteria) this;
        }

        public Criteria andPaytimeoutLessThanOrEqualTo(String value) {
            addCriterion("PAYTIMEOUT <=", value, "paytimeout");
            return (Criteria) this;
        }

        public Criteria andPaytimeoutLike(String value) {
            addCriterion("PAYTIMEOUT like", value, "paytimeout");
            return (Criteria) this;
        }

        public Criteria andPaytimeoutNotLike(String value) {
            addCriterion("PAYTIMEOUT not like", value, "paytimeout");
            return (Criteria) this;
        }

        public Criteria andPaytimeoutIn(List<String> values) {
            addCriterion("PAYTIMEOUT in", values, "paytimeout");
            return (Criteria) this;
        }

        public Criteria andPaytimeoutNotIn(List<String> values) {
            addCriterion("PAYTIMEOUT not in", values, "paytimeout");
            return (Criteria) this;
        }

        public Criteria andPaytimeoutBetween(String value1, String value2) {
            addCriterion("PAYTIMEOUT between", value1, value2, "paytimeout");
            return (Criteria) this;
        }

        public Criteria andPaytimeoutNotBetween(String value1, String value2) {
            addCriterion("PAYTIMEOUT not between", value1, value2, "paytimeout");
            return (Criteria) this;
        }

        public Criteria andTxnamtIsNull() {
            addCriterion("TXNAMT is null");
            return (Criteria) this;
        }

        public Criteria andTxnamtIsNotNull() {
            addCriterion("TXNAMT is not null");
            return (Criteria) this;
        }

        public Criteria andTxnamtEqualTo(Long value) {
            addCriterion("TXNAMT =", value, "txnamt");
            return (Criteria) this;
        }

        public Criteria andTxnamtNotEqualTo(Long value) {
            addCriterion("TXNAMT <>", value, "txnamt");
            return (Criteria) this;
        }

        public Criteria andTxnamtGreaterThan(Long value) {
            addCriterion("TXNAMT >", value, "txnamt");
            return (Criteria) this;
        }

        public Criteria andTxnamtGreaterThanOrEqualTo(Long value) {
            addCriterion("TXNAMT >=", value, "txnamt");
            return (Criteria) this;
        }

        public Criteria andTxnamtLessThan(Long value) {
            addCriterion("TXNAMT <", value, "txnamt");
            return (Criteria) this;
        }

        public Criteria andTxnamtLessThanOrEqualTo(Long value) {
            addCriterion("TXNAMT <=", value, "txnamt");
            return (Criteria) this;
        }

        public Criteria andTxnamtIn(List<Long> values) {
            addCriterion("TXNAMT in", values, "txnamt");
            return (Criteria) this;
        }

        public Criteria andTxnamtNotIn(List<Long> values) {
            addCriterion("TXNAMT not in", values, "txnamt");
            return (Criteria) this;
        }

        public Criteria andTxnamtBetween(Long value1, Long value2) {
            addCriterion("TXNAMT between", value1, value2, "txnamt");
            return (Criteria) this;
        }

        public Criteria andTxnamtNotBetween(Long value1, Long value2) {
            addCriterion("TXNAMT not between", value1, value2, "txnamt");
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

        public Criteria andOrderdescIsNull() {
            addCriterion("ORDERDESC is null");
            return (Criteria) this;
        }

        public Criteria andOrderdescIsNotNull() {
            addCriterion("ORDERDESC is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdescEqualTo(String value) {
            addCriterion("ORDERDESC =", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescNotEqualTo(String value) {
            addCriterion("ORDERDESC <>", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescGreaterThan(String value) {
            addCriterion("ORDERDESC >", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescGreaterThanOrEqualTo(String value) {
            addCriterion("ORDERDESC >=", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescLessThan(String value) {
            addCriterion("ORDERDESC <", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescLessThanOrEqualTo(String value) {
            addCriterion("ORDERDESC <=", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescLike(String value) {
            addCriterion("ORDERDESC like", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescNotLike(String value) {
            addCriterion("ORDERDESC not like", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescIn(List<String> values) {
            addCriterion("ORDERDESC in", values, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescNotIn(List<String> values) {
            addCriterion("ORDERDESC not in", values, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescBetween(String value1, String value2) {
            addCriterion("ORDERDESC between", value1, value2, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescNotBetween(String value1, String value2) {
            addCriterion("ORDERDESC not between", value1, value2, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andReservedIsNull() {
            addCriterion("RESERVED is null");
            return (Criteria) this;
        }

        public Criteria andReservedIsNotNull() {
            addCriterion("RESERVED is not null");
            return (Criteria) this;
        }

        public Criteria andReservedEqualTo(String value) {
            addCriterion("RESERVED =", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotEqualTo(String value) {
            addCriterion("RESERVED <>", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedGreaterThan(String value) {
            addCriterion("RESERVED >", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedGreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED >=", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLessThan(String value) {
            addCriterion("RESERVED <", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLessThanOrEqualTo(String value) {
            addCriterion("RESERVED <=", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLike(String value) {
            addCriterion("RESERVED like", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotLike(String value) {
            addCriterion("RESERVED not like", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedIn(List<String> values) {
            addCriterion("RESERVED in", values, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotIn(List<String> values) {
            addCriterion("RESERVED not in", values, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedBetween(String value1, String value2) {
            addCriterion("RESERVED between", value1, value2, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotBetween(String value1, String value2) {
            addCriterion("RESERVED not between", value1, value2, "reserved");
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

        public Criteria andTnIsNull() {
            addCriterion("TN is null");
            return (Criteria) this;
        }

        public Criteria andTnIsNotNull() {
            addCriterion("TN is not null");
            return (Criteria) this;
        }

        public Criteria andTnEqualTo(String value) {
            addCriterion("TN =", value, "tn");
            return (Criteria) this;
        }

        public Criteria andTnNotEqualTo(String value) {
            addCriterion("TN <>", value, "tn");
            return (Criteria) this;
        }

        public Criteria andTnGreaterThan(String value) {
            addCriterion("TN >", value, "tn");
            return (Criteria) this;
        }

        public Criteria andTnGreaterThanOrEqualTo(String value) {
            addCriterion("TN >=", value, "tn");
            return (Criteria) this;
        }

        public Criteria andTnLessThan(String value) {
            addCriterion("TN <", value, "tn");
            return (Criteria) this;
        }

        public Criteria andTnLessThanOrEqualTo(String value) {
            addCriterion("TN <=", value, "tn");
            return (Criteria) this;
        }

        public Criteria andTnLike(String value) {
            addCriterion("TN like", value, "tn");
            return (Criteria) this;
        }

        public Criteria andTnNotLike(String value) {
            addCriterion("TN not like", value, "tn");
            return (Criteria) this;
        }

        public Criteria andTnIn(List<String> values) {
            addCriterion("TN in", values, "tn");
            return (Criteria) this;
        }

        public Criteria andTnNotIn(List<String> values) {
            addCriterion("TN not in", values, "tn");
            return (Criteria) this;
        }

        public Criteria andTnBetween(String value1, String value2) {
            addCriterion("TN between", value1, value2, "tn");
            return (Criteria) this;
        }

        public Criteria andTnNotBetween(String value1, String value2) {
            addCriterion("TN not between", value1, value2, "tn");
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

        public Criteria andOrdercommitimeIsNull() {
            addCriterion("ORDERCOMMITIME is null");
            return (Criteria) this;
        }

        public Criteria andOrdercommitimeIsNotNull() {
            addCriterion("ORDERCOMMITIME is not null");
            return (Criteria) this;
        }

        public Criteria andOrdercommitimeEqualTo(String value) {
            addCriterion("ORDERCOMMITIME =", value, "ordercommitime");
            return (Criteria) this;
        }

        public Criteria andOrdercommitimeNotEqualTo(String value) {
            addCriterion("ORDERCOMMITIME <>", value, "ordercommitime");
            return (Criteria) this;
        }

        public Criteria andOrdercommitimeGreaterThan(String value) {
            addCriterion("ORDERCOMMITIME >", value, "ordercommitime");
            return (Criteria) this;
        }

        public Criteria andOrdercommitimeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDERCOMMITIME >=", value, "ordercommitime");
            return (Criteria) this;
        }

        public Criteria andOrdercommitimeLessThan(String value) {
            addCriterion("ORDERCOMMITIME <", value, "ordercommitime");
            return (Criteria) this;
        }

        public Criteria andOrdercommitimeLessThanOrEqualTo(String value) {
            addCriterion("ORDERCOMMITIME <=", value, "ordercommitime");
            return (Criteria) this;
        }

        public Criteria andOrdercommitimeLike(String value) {
            addCriterion("ORDERCOMMITIME like", value, "ordercommitime");
            return (Criteria) this;
        }

        public Criteria andOrdercommitimeNotLike(String value) {
            addCriterion("ORDERCOMMITIME not like", value, "ordercommitime");
            return (Criteria) this;
        }

        public Criteria andOrdercommitimeIn(List<String> values) {
            addCriterion("ORDERCOMMITIME in", values, "ordercommitime");
            return (Criteria) this;
        }

        public Criteria andOrdercommitimeNotIn(List<String> values) {
            addCriterion("ORDERCOMMITIME not in", values, "ordercommitime");
            return (Criteria) this;
        }

        public Criteria andOrdercommitimeBetween(String value1, String value2) {
            addCriterion("ORDERCOMMITIME between", value1, value2, "ordercommitime");
            return (Criteria) this;
        }

        public Criteria andOrdercommitimeNotBetween(String value1, String value2) {
            addCriterion("ORDERCOMMITIME not between", value1, value2, "ordercommitime");
            return (Criteria) this;
        }

        public Criteria andSyncnotifyIsNull() {
            addCriterion("SYNCNOTIFY is null");
            return (Criteria) this;
        }

        public Criteria andSyncnotifyIsNotNull() {
            addCriterion("SYNCNOTIFY is not null");
            return (Criteria) this;
        }

        public Criteria andSyncnotifyEqualTo(String value) {
            addCriterion("SYNCNOTIFY =", value, "syncnotify");
            return (Criteria) this;
        }

        public Criteria andSyncnotifyNotEqualTo(String value) {
            addCriterion("SYNCNOTIFY <>", value, "syncnotify");
            return (Criteria) this;
        }

        public Criteria andSyncnotifyGreaterThan(String value) {
            addCriterion("SYNCNOTIFY >", value, "syncnotify");
            return (Criteria) this;
        }

        public Criteria andSyncnotifyGreaterThanOrEqualTo(String value) {
            addCriterion("SYNCNOTIFY >=", value, "syncnotify");
            return (Criteria) this;
        }

        public Criteria andSyncnotifyLessThan(String value) {
            addCriterion("SYNCNOTIFY <", value, "syncnotify");
            return (Criteria) this;
        }

        public Criteria andSyncnotifyLessThanOrEqualTo(String value) {
            addCriterion("SYNCNOTIFY <=", value, "syncnotify");
            return (Criteria) this;
        }

        public Criteria andSyncnotifyLike(String value) {
            addCriterion("SYNCNOTIFY like", value, "syncnotify");
            return (Criteria) this;
        }

        public Criteria andSyncnotifyNotLike(String value) {
            addCriterion("SYNCNOTIFY not like", value, "syncnotify");
            return (Criteria) this;
        }

        public Criteria andSyncnotifyIn(List<String> values) {
            addCriterion("SYNCNOTIFY in", values, "syncnotify");
            return (Criteria) this;
        }

        public Criteria andSyncnotifyNotIn(List<String> values) {
            addCriterion("SYNCNOTIFY not in", values, "syncnotify");
            return (Criteria) this;
        }

        public Criteria andSyncnotifyBetween(String value1, String value2) {
            addCriterion("SYNCNOTIFY between", value1, value2, "syncnotify");
            return (Criteria) this;
        }

        public Criteria andSyncnotifyNotBetween(String value1, String value2) {
            addCriterion("SYNCNOTIFY not between", value1, value2, "syncnotify");
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