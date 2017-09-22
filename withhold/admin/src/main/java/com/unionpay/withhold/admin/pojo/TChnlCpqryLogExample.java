package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TChnlCpqryLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TChnlCpqryLogExample() {
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

        public Criteria andMeridIsNull() {
            addCriterion("merId is null");
            return (Criteria) this;
        }

        public Criteria andMeridIsNotNull() {
            addCriterion("merId is not null");
            return (Criteria) this;
        }

        public Criteria andMeridEqualTo(String value) {
            addCriterion("merId =", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridNotEqualTo(String value) {
            addCriterion("merId <>", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridGreaterThan(String value) {
            addCriterion("merId >", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridGreaterThanOrEqualTo(String value) {
            addCriterion("merId >=", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridLessThan(String value) {
            addCriterion("merId <", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridLessThanOrEqualTo(String value) {
            addCriterion("merId <=", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridLike(String value) {
            addCriterion("merId like", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridNotLike(String value) {
            addCriterion("merId not like", value, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridIn(List<String> values) {
            addCriterion("merId in", values, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridNotIn(List<String> values) {
            addCriterion("merId not in", values, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridBetween(String value1, String value2) {
            addCriterion("merId between", value1, value2, "merid");
            return (Criteria) this;
        }

        public Criteria andMeridNotBetween(String value1, String value2) {
            addCriterion("merId not between", value1, value2, "merid");
            return (Criteria) this;
        }

        public Criteria andTranstypeIsNull() {
            addCriterion("transType is null");
            return (Criteria) this;
        }

        public Criteria andTranstypeIsNotNull() {
            addCriterion("transType is not null");
            return (Criteria) this;
        }

        public Criteria andTranstypeEqualTo(String value) {
            addCriterion("transType =", value, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeNotEqualTo(String value) {
            addCriterion("transType <>", value, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeGreaterThan(String value) {
            addCriterion("transType >", value, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeGreaterThanOrEqualTo(String value) {
            addCriterion("transType >=", value, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeLessThan(String value) {
            addCriterion("transType <", value, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeLessThanOrEqualTo(String value) {
            addCriterion("transType <=", value, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeLike(String value) {
            addCriterion("transType like", value, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeNotLike(String value) {
            addCriterion("transType not like", value, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeIn(List<String> values) {
            addCriterion("transType in", values, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeNotIn(List<String> values) {
            addCriterion("transType not in", values, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeBetween(String value1, String value2) {
            addCriterion("transType between", value1, value2, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeNotBetween(String value1, String value2) {
            addCriterion("transType not between", value1, value2, "transtype");
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

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
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

        public Criteria andTransstatIsNull() {
            addCriterion("transStat is null");
            return (Criteria) this;
        }

        public Criteria andTransstatIsNotNull() {
            addCriterion("transStat is not null");
            return (Criteria) this;
        }

        public Criteria andTransstatEqualTo(String value) {
            addCriterion("transStat =", value, "transstat");
            return (Criteria) this;
        }

        public Criteria andTransstatNotEqualTo(String value) {
            addCriterion("transStat <>", value, "transstat");
            return (Criteria) this;
        }

        public Criteria andTransstatGreaterThan(String value) {
            addCriterion("transStat >", value, "transstat");
            return (Criteria) this;
        }

        public Criteria andTransstatGreaterThanOrEqualTo(String value) {
            addCriterion("transStat >=", value, "transstat");
            return (Criteria) this;
        }

        public Criteria andTransstatLessThan(String value) {
            addCriterion("transStat <", value, "transstat");
            return (Criteria) this;
        }

        public Criteria andTransstatLessThanOrEqualTo(String value) {
            addCriterion("transStat <=", value, "transstat");
            return (Criteria) this;
        }

        public Criteria andTransstatLike(String value) {
            addCriterion("transStat like", value, "transstat");
            return (Criteria) this;
        }

        public Criteria andTransstatNotLike(String value) {
            addCriterion("transStat not like", value, "transstat");
            return (Criteria) this;
        }

        public Criteria andTransstatIn(List<String> values) {
            addCriterion("transStat in", values, "transstat");
            return (Criteria) this;
        }

        public Criteria andTransstatNotIn(List<String> values) {
            addCriterion("transStat not in", values, "transstat");
            return (Criteria) this;
        }

        public Criteria andTransstatBetween(String value1, String value2) {
            addCriterion("transStat between", value1, value2, "transstat");
            return (Criteria) this;
        }

        public Criteria andTransstatNotBetween(String value1, String value2) {
            addCriterion("transStat not between", value1, value2, "transstat");
            return (Criteria) this;
        }

        public Criteria andChnlretdateIsNull() {
            addCriterion("chnlRetDate is null");
            return (Criteria) this;
        }

        public Criteria andChnlretdateIsNotNull() {
            addCriterion("chnlRetDate is not null");
            return (Criteria) this;
        }

        public Criteria andChnlretdateEqualTo(String value) {
            addCriterion("chnlRetDate =", value, "chnlretdate");
            return (Criteria) this;
        }

        public Criteria andChnlretdateNotEqualTo(String value) {
            addCriterion("chnlRetDate <>", value, "chnlretdate");
            return (Criteria) this;
        }

        public Criteria andChnlretdateGreaterThan(String value) {
            addCriterion("chnlRetDate >", value, "chnlretdate");
            return (Criteria) this;
        }

        public Criteria andChnlretdateGreaterThanOrEqualTo(String value) {
            addCriterion("chnlRetDate >=", value, "chnlretdate");
            return (Criteria) this;
        }

        public Criteria andChnlretdateLessThan(String value) {
            addCriterion("chnlRetDate <", value, "chnlretdate");
            return (Criteria) this;
        }

        public Criteria andChnlretdateLessThanOrEqualTo(String value) {
            addCriterion("chnlRetDate <=", value, "chnlretdate");
            return (Criteria) this;
        }

        public Criteria andChnlretdateLike(String value) {
            addCriterion("chnlRetDate like", value, "chnlretdate");
            return (Criteria) this;
        }

        public Criteria andChnlretdateNotLike(String value) {
            addCriterion("chnlRetDate not like", value, "chnlretdate");
            return (Criteria) this;
        }

        public Criteria andChnlretdateIn(List<String> values) {
            addCriterion("chnlRetDate in", values, "chnlretdate");
            return (Criteria) this;
        }

        public Criteria andChnlretdateNotIn(List<String> values) {
            addCriterion("chnlRetDate not in", values, "chnlretdate");
            return (Criteria) this;
        }

        public Criteria andChnlretdateBetween(String value1, String value2) {
            addCriterion("chnlRetDate between", value1, value2, "chnlretdate");
            return (Criteria) this;
        }

        public Criteria andChnlretdateNotBetween(String value1, String value2) {
            addCriterion("chnlRetDate not between", value1, value2, "chnlretdate");
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