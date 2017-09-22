package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TRouteConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRouteConfigExample() {
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

        public Criteria andRidIsNull() {
            addCriterion("RID is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("RID is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Long value) {
            addCriterion("RID =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Long value) {
            addCriterion("RID <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Long value) {
            addCriterion("RID >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Long value) {
            addCriterion("RID >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Long value) {
            addCriterion("RID <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Long value) {
            addCriterion("RID <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Long> values) {
            addCriterion("RID in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Long> values) {
            addCriterion("RID not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Long value1, Long value2) {
            addCriterion("RID between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Long value1, Long value2) {
            addCriterion("RID not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRoutidIsNull() {
            addCriterion("ROUTID is null");
            return (Criteria) this;
        }

        public Criteria andRoutidIsNotNull() {
            addCriterion("ROUTID is not null");
            return (Criteria) this;
        }

        public Criteria andRoutidEqualTo(Long value) {
            addCriterion("ROUTID =", value, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidNotEqualTo(Long value) {
            addCriterion("ROUTID <>", value, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidGreaterThan(Long value) {
            addCriterion("ROUTID >", value, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidGreaterThanOrEqualTo(Long value) {
            addCriterion("ROUTID >=", value, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidLessThan(Long value) {
            addCriterion("ROUTID <", value, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidLessThanOrEqualTo(Long value) {
            addCriterion("ROUTID <=", value, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidIn(List<Long> values) {
            addCriterion("ROUTID in", values, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidNotIn(List<Long> values) {
            addCriterion("ROUTID not in", values, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidBetween(Long value1, Long value2) {
            addCriterion("ROUTID between", value1, value2, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutidNotBetween(Long value1, Long value2) {
            addCriterion("ROUTID not between", value1, value2, "routid");
            return (Criteria) this;
        }

        public Criteria andRoutverIsNull() {
            addCriterion("ROUTVER is null");
            return (Criteria) this;
        }

        public Criteria andRoutverIsNotNull() {
            addCriterion("ROUTVER is not null");
            return (Criteria) this;
        }

        public Criteria andRoutverEqualTo(String value) {
            addCriterion("ROUTVER =", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverNotEqualTo(String value) {
            addCriterion("ROUTVER <>", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverGreaterThan(String value) {
            addCriterion("ROUTVER >", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTVER >=", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverLessThan(String value) {
            addCriterion("ROUTVER <", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverLessThanOrEqualTo(String value) {
            addCriterion("ROUTVER <=", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverLike(String value) {
            addCriterion("ROUTVER like", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverNotLike(String value) {
            addCriterion("ROUTVER not like", value, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverIn(List<String> values) {
            addCriterion("ROUTVER in", values, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverNotIn(List<String> values) {
            addCriterion("ROUTVER not in", values, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverBetween(String value1, String value2) {
            addCriterion("ROUTVER between", value1, value2, "routver");
            return (Criteria) this;
        }

        public Criteria andRoutverNotBetween(String value1, String value2) {
            addCriterion("ROUTVER not between", value1, value2, "routver");
            return (Criteria) this;
        }

        public Criteria andStimeIsNull() {
            addCriterion("STIME is null");
            return (Criteria) this;
        }

        public Criteria andStimeIsNotNull() {
            addCriterion("STIME is not null");
            return (Criteria) this;
        }

        public Criteria andStimeEqualTo(String value) {
            addCriterion("STIME =", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotEqualTo(String value) {
            addCriterion("STIME <>", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeGreaterThan(String value) {
            addCriterion("STIME >", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeGreaterThanOrEqualTo(String value) {
            addCriterion("STIME >=", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLessThan(String value) {
            addCriterion("STIME <", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLessThanOrEqualTo(String value) {
            addCriterion("STIME <=", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLike(String value) {
            addCriterion("STIME like", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotLike(String value) {
            addCriterion("STIME not like", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeIn(List<String> values) {
            addCriterion("STIME in", values, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotIn(List<String> values) {
            addCriterion("STIME not in", values, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeBetween(String value1, String value2) {
            addCriterion("STIME between", value1, value2, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotBetween(String value1, String value2) {
            addCriterion("STIME not between", value1, value2, "stime");
            return (Criteria) this;
        }

        public Criteria andEtimeIsNull() {
            addCriterion("ETIME is null");
            return (Criteria) this;
        }

        public Criteria andEtimeIsNotNull() {
            addCriterion("ETIME is not null");
            return (Criteria) this;
        }

        public Criteria andEtimeEqualTo(String value) {
            addCriterion("ETIME =", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotEqualTo(String value) {
            addCriterion("ETIME <>", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeGreaterThan(String value) {
            addCriterion("ETIME >", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ETIME >=", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeLessThan(String value) {
            addCriterion("ETIME <", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeLessThanOrEqualTo(String value) {
            addCriterion("ETIME <=", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeLike(String value) {
            addCriterion("ETIME like", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotLike(String value) {
            addCriterion("ETIME not like", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeIn(List<String> values) {
            addCriterion("ETIME in", values, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotIn(List<String> values) {
            addCriterion("ETIME not in", values, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeBetween(String value1, String value2) {
            addCriterion("ETIME between", value1, value2, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotBetween(String value1, String value2) {
            addCriterion("ETIME not between", value1, value2, "etime");
            return (Criteria) this;
        }

        public Criteria andMinamtIsNull() {
            addCriterion("MINAMT is null");
            return (Criteria) this;
        }

        public Criteria andMinamtIsNotNull() {
            addCriterion("MINAMT is not null");
            return (Criteria) this;
        }

        public Criteria andMinamtEqualTo(Long value) {
            addCriterion("MINAMT =", value, "minamt");
            return (Criteria) this;
        }

        public Criteria andMinamtNotEqualTo(Long value) {
            addCriterion("MINAMT <>", value, "minamt");
            return (Criteria) this;
        }

        public Criteria andMinamtGreaterThan(Long value) {
            addCriterion("MINAMT >", value, "minamt");
            return (Criteria) this;
        }

        public Criteria andMinamtGreaterThanOrEqualTo(Long value) {
            addCriterion("MINAMT >=", value, "minamt");
            return (Criteria) this;
        }

        public Criteria andMinamtLessThan(Long value) {
            addCriterion("MINAMT <", value, "minamt");
            return (Criteria) this;
        }

        public Criteria andMinamtLessThanOrEqualTo(Long value) {
            addCriterion("MINAMT <=", value, "minamt");
            return (Criteria) this;
        }

        public Criteria andMinamtIn(List<Long> values) {
            addCriterion("MINAMT in", values, "minamt");
            return (Criteria) this;
        }

        public Criteria andMinamtNotIn(List<Long> values) {
            addCriterion("MINAMT not in", values, "minamt");
            return (Criteria) this;
        }

        public Criteria andMinamtBetween(Long value1, Long value2) {
            addCriterion("MINAMT between", value1, value2, "minamt");
            return (Criteria) this;
        }

        public Criteria andMinamtNotBetween(Long value1, Long value2) {
            addCriterion("MINAMT not between", value1, value2, "minamt");
            return (Criteria) this;
        }

        public Criteria andMaxamtIsNull() {
            addCriterion("MAXAMT is null");
            return (Criteria) this;
        }

        public Criteria andMaxamtIsNotNull() {
            addCriterion("MAXAMT is not null");
            return (Criteria) this;
        }

        public Criteria andMaxamtEqualTo(Long value) {
            addCriterion("MAXAMT =", value, "maxamt");
            return (Criteria) this;
        }

        public Criteria andMaxamtNotEqualTo(Long value) {
            addCriterion("MAXAMT <>", value, "maxamt");
            return (Criteria) this;
        }

        public Criteria andMaxamtGreaterThan(Long value) {
            addCriterion("MAXAMT >", value, "maxamt");
            return (Criteria) this;
        }

        public Criteria andMaxamtGreaterThanOrEqualTo(Long value) {
            addCriterion("MAXAMT >=", value, "maxamt");
            return (Criteria) this;
        }

        public Criteria andMaxamtLessThan(Long value) {
            addCriterion("MAXAMT <", value, "maxamt");
            return (Criteria) this;
        }

        public Criteria andMaxamtLessThanOrEqualTo(Long value) {
            addCriterion("MAXAMT <=", value, "maxamt");
            return (Criteria) this;
        }

        public Criteria andMaxamtIn(List<Long> values) {
            addCriterion("MAXAMT in", values, "maxamt");
            return (Criteria) this;
        }

        public Criteria andMaxamtNotIn(List<Long> values) {
            addCriterion("MAXAMT not in", values, "maxamt");
            return (Criteria) this;
        }

        public Criteria andMaxamtBetween(Long value1, Long value2) {
            addCriterion("MAXAMT between", value1, value2, "maxamt");
            return (Criteria) this;
        }

        public Criteria andMaxamtNotBetween(Long value1, Long value2) {
            addCriterion("MAXAMT not between", value1, value2, "maxamt");
            return (Criteria) this;
        }

        public Criteria andBankcodeIsNull() {
            addCriterion("BANKCODE is null");
            return (Criteria) this;
        }

        public Criteria andBankcodeIsNotNull() {
            addCriterion("BANKCODE is not null");
            return (Criteria) this;
        }

        public Criteria andBankcodeEqualTo(String value) {
            addCriterion("BANKCODE =", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeNotEqualTo(String value) {
            addCriterion("BANKCODE <>", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeGreaterThan(String value) {
            addCriterion("BANKCODE >", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeGreaterThanOrEqualTo(String value) {
            addCriterion("BANKCODE >=", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeLessThan(String value) {
            addCriterion("BANKCODE <", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeLessThanOrEqualTo(String value) {
            addCriterion("BANKCODE <=", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeLike(String value) {
            addCriterion("BANKCODE like", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeNotLike(String value) {
            addCriterion("BANKCODE not like", value, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeIn(List<String> values) {
            addCriterion("BANKCODE in", values, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeNotIn(List<String> values) {
            addCriterion("BANKCODE not in", values, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeBetween(String value1, String value2) {
            addCriterion("BANKCODE between", value1, value2, "bankcode");
            return (Criteria) this;
        }

        public Criteria andBankcodeNotBetween(String value1, String value2) {
            addCriterion("BANKCODE not between", value1, value2, "bankcode");
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

        public Criteria andCardtypeIsNull() {
            addCriterion("CARDTYPE is null");
            return (Criteria) this;
        }

        public Criteria andCardtypeIsNotNull() {
            addCriterion("CARDTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCardtypeEqualTo(String value) {
            addCriterion("CARDTYPE =", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotEqualTo(String value) {
            addCriterion("CARDTYPE <>", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeGreaterThan(String value) {
            addCriterion("CARDTYPE >", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeGreaterThanOrEqualTo(String value) {
            addCriterion("CARDTYPE >=", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLessThan(String value) {
            addCriterion("CARDTYPE <", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLessThanOrEqualTo(String value) {
            addCriterion("CARDTYPE <=", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLike(String value) {
            addCriterion("CARDTYPE like", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotLike(String value) {
            addCriterion("CARDTYPE not like", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeIn(List<String> values) {
            addCriterion("CARDTYPE in", values, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotIn(List<String> values) {
            addCriterion("CARDTYPE not in", values, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeBetween(String value1, String value2) {
            addCriterion("CARDTYPE between", value1, value2, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotBetween(String value1, String value2) {
            addCriterion("CARDTYPE not between", value1, value2, "cardtype");
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

        public Criteria andOrdertypeIsNull() {
            addCriterion("ORDERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andOrdertypeIsNotNull() {
            addCriterion("ORDERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOrdertypeEqualTo(Long value) {
            addCriterion("ORDERTYPE =", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeNotEqualTo(Long value) {
            addCriterion("ORDERTYPE <>", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeGreaterThan(Long value) {
            addCriterion("ORDERTYPE >", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDERTYPE >=", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeLessThan(Long value) {
            addCriterion("ORDERTYPE <", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeLessThanOrEqualTo(Long value) {
            addCriterion("ORDERTYPE <=", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeIn(List<Long> values) {
            addCriterion("ORDERTYPE in", values, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeNotIn(List<Long> values) {
            addCriterion("ORDERTYPE not in", values, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeBetween(Long value1, Long value2) {
            addCriterion("ORDERTYPE between", value1, value2, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeNotBetween(Long value1, Long value2) {
            addCriterion("ORDERTYPE not between", value1, value2, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdersIsNull() {
            addCriterion("ORDERS is null");
            return (Criteria) this;
        }

        public Criteria andOrdersIsNotNull() {
            addCriterion("ORDERS is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersEqualTo(Long value) {
            addCriterion("ORDERS =", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotEqualTo(Long value) {
            addCriterion("ORDERS <>", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersGreaterThan(Long value) {
            addCriterion("ORDERS >", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDERS >=", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersLessThan(Long value) {
            addCriterion("ORDERS <", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersLessThanOrEqualTo(Long value) {
            addCriterion("ORDERS <=", value, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersIn(List<Long> values) {
            addCriterion("ORDERS in", values, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotIn(List<Long> values) {
            addCriterion("ORDERS not in", values, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersBetween(Long value1, Long value2) {
            addCriterion("ORDERS between", value1, value2, "orders");
            return (Criteria) this;
        }

        public Criteria andOrdersNotBetween(Long value1, Long value2) {
            addCriterion("ORDERS not between", value1, value2, "orders");
            return (Criteria) this;
        }

        public Criteria andIsdefIsNull() {
            addCriterion("ISDEF is null");
            return (Criteria) this;
        }

        public Criteria andIsdefIsNotNull() {
            addCriterion("ISDEF is not null");
            return (Criteria) this;
        }

        public Criteria andIsdefEqualTo(String value) {
            addCriterion("ISDEF =", value, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefNotEqualTo(String value) {
            addCriterion("ISDEF <>", value, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefGreaterThan(String value) {
            addCriterion("ISDEF >", value, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefGreaterThanOrEqualTo(String value) {
            addCriterion("ISDEF >=", value, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefLessThan(String value) {
            addCriterion("ISDEF <", value, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefLessThanOrEqualTo(String value) {
            addCriterion("ISDEF <=", value, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefLike(String value) {
            addCriterion("ISDEF like", value, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefNotLike(String value) {
            addCriterion("ISDEF not like", value, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefIn(List<String> values) {
            addCriterion("ISDEF in", values, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefNotIn(List<String> values) {
            addCriterion("ISDEF not in", values, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefBetween(String value1, String value2) {
            addCriterion("ISDEF between", value1, value2, "isdef");
            return (Criteria) this;
        }

        public Criteria andIsdefNotBetween(String value1, String value2) {
            addCriterion("ISDEF not between", value1, value2, "isdef");
            return (Criteria) this;
        }

        public Criteria andTradeeleIsNull() {
            addCriterion("TRADEELE is null");
            return (Criteria) this;
        }

        public Criteria andTradeeleIsNotNull() {
            addCriterion("TRADEELE is not null");
            return (Criteria) this;
        }

        public Criteria andTradeeleEqualTo(String value) {
            addCriterion("TRADEELE =", value, "tradeele");
            return (Criteria) this;
        }

        public Criteria andTradeeleNotEqualTo(String value) {
            addCriterion("TRADEELE <>", value, "tradeele");
            return (Criteria) this;
        }

        public Criteria andTradeeleGreaterThan(String value) {
            addCriterion("TRADEELE >", value, "tradeele");
            return (Criteria) this;
        }

        public Criteria andTradeeleGreaterThanOrEqualTo(String value) {
            addCriterion("TRADEELE >=", value, "tradeele");
            return (Criteria) this;
        }

        public Criteria andTradeeleLessThan(String value) {
            addCriterion("TRADEELE <", value, "tradeele");
            return (Criteria) this;
        }

        public Criteria andTradeeleLessThanOrEqualTo(String value) {
            addCriterion("TRADEELE <=", value, "tradeele");
            return (Criteria) this;
        }

        public Criteria andTradeeleLike(String value) {
            addCriterion("TRADEELE like", value, "tradeele");
            return (Criteria) this;
        }

        public Criteria andTradeeleNotLike(String value) {
            addCriterion("TRADEELE not like", value, "tradeele");
            return (Criteria) this;
        }

        public Criteria andTradeeleIn(List<String> values) {
            addCriterion("TRADEELE in", values, "tradeele");
            return (Criteria) this;
        }

        public Criteria andTradeeleNotIn(List<String> values) {
            addCriterion("TRADEELE not in", values, "tradeele");
            return (Criteria) this;
        }

        public Criteria andTradeeleBetween(String value1, String value2) {
            addCriterion("TRADEELE between", value1, value2, "tradeele");
            return (Criteria) this;
        }

        public Criteria andTradeeleNotBetween(String value1, String value2) {
            addCriterion("TRADEELE not between", value1, value2, "tradeele");
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