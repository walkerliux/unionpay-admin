package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TChnlDetaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TChnlDetaExample() {
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

        public Criteria andChnlidIsNull() {
            addCriterion("CHNLID is null");
            return (Criteria) this;
        }

        public Criteria andChnlidIsNotNull() {
            addCriterion("CHNLID is not null");
            return (Criteria) this;
        }

        public Criteria andChnlidEqualTo(Integer value) {
            addCriterion("CHNLID =", value, "chnlid");
            return (Criteria) this;
        }

        public Criteria andChnlidNotEqualTo(Integer value) {
            addCriterion("CHNLID <>", value, "chnlid");
            return (Criteria) this;
        }

        public Criteria andChnlidGreaterThan(Integer value) {
            addCriterion("CHNLID >", value, "chnlid");
            return (Criteria) this;
        }

        public Criteria andChnlidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHNLID >=", value, "chnlid");
            return (Criteria) this;
        }

        public Criteria andChnlidLessThan(Integer value) {
            addCriterion("CHNLID <", value, "chnlid");
            return (Criteria) this;
        }

        public Criteria andChnlidLessThanOrEqualTo(Integer value) {
            addCriterion("CHNLID <=", value, "chnlid");
            return (Criteria) this;
        }

        public Criteria andChnlidIn(List<Integer> values) {
            addCriterion("CHNLID in", values, "chnlid");
            return (Criteria) this;
        }

        public Criteria andChnlidNotIn(List<Integer> values) {
            addCriterion("CHNLID not in", values, "chnlid");
            return (Criteria) this;
        }

        public Criteria andChnlidBetween(Integer value1, Integer value2) {
            addCriterion("CHNLID between", value1, value2, "chnlid");
            return (Criteria) this;
        }

        public Criteria andChnlidNotBetween(Integer value1, Integer value2) {
            addCriterion("CHNLID not between", value1, value2, "chnlid");
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

        public Criteria andInsticodeIsNull() {
            addCriterion("INSTICODE is null");
            return (Criteria) this;
        }

        public Criteria andInsticodeIsNotNull() {
            addCriterion("INSTICODE is not null");
            return (Criteria) this;
        }

        public Criteria andInsticodeEqualTo(String value) {
            addCriterion("INSTICODE =", value, "insticode");
            return (Criteria) this;
        }

        public Criteria andInsticodeNotEqualTo(String value) {
            addCriterion("INSTICODE <>", value, "insticode");
            return (Criteria) this;
        }

        public Criteria andInsticodeGreaterThan(String value) {
            addCriterion("INSTICODE >", value, "insticode");
            return (Criteria) this;
        }

        public Criteria andInsticodeGreaterThanOrEqualTo(String value) {
            addCriterion("INSTICODE >=", value, "insticode");
            return (Criteria) this;
        }

        public Criteria andInsticodeLessThan(String value) {
            addCriterion("INSTICODE <", value, "insticode");
            return (Criteria) this;
        }

        public Criteria andInsticodeLessThanOrEqualTo(String value) {
            addCriterion("INSTICODE <=", value, "insticode");
            return (Criteria) this;
        }

        public Criteria andInsticodeLike(String value) {
            addCriterion("INSTICODE like", value, "insticode");
            return (Criteria) this;
        }

        public Criteria andInsticodeNotLike(String value) {
            addCriterion("INSTICODE not like", value, "insticode");
            return (Criteria) this;
        }

        public Criteria andInsticodeIn(List<String> values) {
            addCriterion("INSTICODE in", values, "insticode");
            return (Criteria) this;
        }

        public Criteria andInsticodeNotIn(List<String> values) {
            addCriterion("INSTICODE not in", values, "insticode");
            return (Criteria) this;
        }

        public Criteria andInsticodeBetween(String value1, String value2) {
            addCriterion("INSTICODE between", value1, value2, "insticode");
            return (Criteria) this;
        }

        public Criteria andInsticodeNotBetween(String value1, String value2) {
            addCriterion("INSTICODE not between", value1, value2, "insticode");
            return (Criteria) this;
        }

        public Criteria andChnltypeIsNull() {
            addCriterion("CHNLTYPE is null");
            return (Criteria) this;
        }

        public Criteria andChnltypeIsNotNull() {
            addCriterion("CHNLTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andChnltypeEqualTo(String value) {
            addCriterion("CHNLTYPE =", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeNotEqualTo(String value) {
            addCriterion("CHNLTYPE <>", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeGreaterThan(String value) {
            addCriterion("CHNLTYPE >", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHNLTYPE >=", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeLessThan(String value) {
            addCriterion("CHNLTYPE <", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeLessThanOrEqualTo(String value) {
            addCriterion("CHNLTYPE <=", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeLike(String value) {
            addCriterion("CHNLTYPE like", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeNotLike(String value) {
            addCriterion("CHNLTYPE not like", value, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeIn(List<String> values) {
            addCriterion("CHNLTYPE in", values, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeNotIn(List<String> values) {
            addCriterion("CHNLTYPE not in", values, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeBetween(String value1, String value2) {
            addCriterion("CHNLTYPE between", value1, value2, "chnltype");
            return (Criteria) this;
        }

        public Criteria andChnltypeNotBetween(String value1, String value2) {
            addCriterion("CHNLTYPE not between", value1, value2, "chnltype");
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

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andBmkIsNull() {
            addCriterion("BMK is null");
            return (Criteria) this;
        }

        public Criteria andBmkIsNotNull() {
            addCriterion("BMK is not null");
            return (Criteria) this;
        }

        public Criteria andBmkEqualTo(String value) {
            addCriterion("BMK =", value, "bmk");
            return (Criteria) this;
        }

        public Criteria andBmkNotEqualTo(String value) {
            addCriterion("BMK <>", value, "bmk");
            return (Criteria) this;
        }

        public Criteria andBmkGreaterThan(String value) {
            addCriterion("BMK >", value, "bmk");
            return (Criteria) this;
        }

        public Criteria andBmkGreaterThanOrEqualTo(String value) {
            addCriterion("BMK >=", value, "bmk");
            return (Criteria) this;
        }

        public Criteria andBmkLessThan(String value) {
            addCriterion("BMK <", value, "bmk");
            return (Criteria) this;
        }

        public Criteria andBmkLessThanOrEqualTo(String value) {
            addCriterion("BMK <=", value, "bmk");
            return (Criteria) this;
        }

        public Criteria andBmkLike(String value) {
            addCriterion("BMK like", value, "bmk");
            return (Criteria) this;
        }

        public Criteria andBmkNotLike(String value) {
            addCriterion("BMK not like", value, "bmk");
            return (Criteria) this;
        }

        public Criteria andBmkIn(List<String> values) {
            addCriterion("BMK in", values, "bmk");
            return (Criteria) this;
        }

        public Criteria andBmkNotIn(List<String> values) {
            addCriterion("BMK not in", values, "bmk");
            return (Criteria) this;
        }

        public Criteria andBmkBetween(String value1, String value2) {
            addCriterion("BMK between", value1, value2, "bmk");
            return (Criteria) this;
        }

        public Criteria andBmkNotBetween(String value1, String value2) {
            addCriterion("BMK not between", value1, value2, "bmk");
            return (Criteria) this;
        }

        public Criteria andMackeyIsNull() {
            addCriterion("MACKEY is null");
            return (Criteria) this;
        }

        public Criteria andMackeyIsNotNull() {
            addCriterion("MACKEY is not null");
            return (Criteria) this;
        }

        public Criteria andMackeyEqualTo(String value) {
            addCriterion("MACKEY =", value, "mackey");
            return (Criteria) this;
        }

        public Criteria andMackeyNotEqualTo(String value) {
            addCriterion("MACKEY <>", value, "mackey");
            return (Criteria) this;
        }

        public Criteria andMackeyGreaterThan(String value) {
            addCriterion("MACKEY >", value, "mackey");
            return (Criteria) this;
        }

        public Criteria andMackeyGreaterThanOrEqualTo(String value) {
            addCriterion("MACKEY >=", value, "mackey");
            return (Criteria) this;
        }

        public Criteria andMackeyLessThan(String value) {
            addCriterion("MACKEY <", value, "mackey");
            return (Criteria) this;
        }

        public Criteria andMackeyLessThanOrEqualTo(String value) {
            addCriterion("MACKEY <=", value, "mackey");
            return (Criteria) this;
        }

        public Criteria andMackeyLike(String value) {
            addCriterion("MACKEY like", value, "mackey");
            return (Criteria) this;
        }

        public Criteria andMackeyNotLike(String value) {
            addCriterion("MACKEY not like", value, "mackey");
            return (Criteria) this;
        }

        public Criteria andMackeyIn(List<String> values) {
            addCriterion("MACKEY in", values, "mackey");
            return (Criteria) this;
        }

        public Criteria andMackeyNotIn(List<String> values) {
            addCriterion("MACKEY not in", values, "mackey");
            return (Criteria) this;
        }

        public Criteria andMackeyBetween(String value1, String value2) {
            addCriterion("MACKEY between", value1, value2, "mackey");
            return (Criteria) this;
        }

        public Criteria andMackeyNotBetween(String value1, String value2) {
            addCriterion("MACKEY not between", value1, value2, "mackey");
            return (Criteria) this;
        }

        public Criteria andPinkeyIsNull() {
            addCriterion("PINKEY is null");
            return (Criteria) this;
        }

        public Criteria andPinkeyIsNotNull() {
            addCriterion("PINKEY is not null");
            return (Criteria) this;
        }

        public Criteria andPinkeyEqualTo(String value) {
            addCriterion("PINKEY =", value, "pinkey");
            return (Criteria) this;
        }

        public Criteria andPinkeyNotEqualTo(String value) {
            addCriterion("PINKEY <>", value, "pinkey");
            return (Criteria) this;
        }

        public Criteria andPinkeyGreaterThan(String value) {
            addCriterion("PINKEY >", value, "pinkey");
            return (Criteria) this;
        }

        public Criteria andPinkeyGreaterThanOrEqualTo(String value) {
            addCriterion("PINKEY >=", value, "pinkey");
            return (Criteria) this;
        }

        public Criteria andPinkeyLessThan(String value) {
            addCriterion("PINKEY <", value, "pinkey");
            return (Criteria) this;
        }

        public Criteria andPinkeyLessThanOrEqualTo(String value) {
            addCriterion("PINKEY <=", value, "pinkey");
            return (Criteria) this;
        }

        public Criteria andPinkeyLike(String value) {
            addCriterion("PINKEY like", value, "pinkey");
            return (Criteria) this;
        }

        public Criteria andPinkeyNotLike(String value) {
            addCriterion("PINKEY not like", value, "pinkey");
            return (Criteria) this;
        }

        public Criteria andPinkeyIn(List<String> values) {
            addCriterion("PINKEY in", values, "pinkey");
            return (Criteria) this;
        }

        public Criteria andPinkeyNotIn(List<String> values) {
            addCriterion("PINKEY not in", values, "pinkey");
            return (Criteria) this;
        }

        public Criteria andPinkeyBetween(String value1, String value2) {
            addCriterion("PINKEY between", value1, value2, "pinkey");
            return (Criteria) this;
        }

        public Criteria andPinkeyNotBetween(String value1, String value2) {
            addCriterion("PINKEY not between", value1, value2, "pinkey");
            return (Criteria) this;
        }

        public Criteria andDatakeyIsNull() {
            addCriterion("DATAKEY is null");
            return (Criteria) this;
        }

        public Criteria andDatakeyIsNotNull() {
            addCriterion("DATAKEY is not null");
            return (Criteria) this;
        }

        public Criteria andDatakeyEqualTo(String value) {
            addCriterion("DATAKEY =", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyNotEqualTo(String value) {
            addCriterion("DATAKEY <>", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyGreaterThan(String value) {
            addCriterion("DATAKEY >", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyGreaterThanOrEqualTo(String value) {
            addCriterion("DATAKEY >=", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyLessThan(String value) {
            addCriterion("DATAKEY <", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyLessThanOrEqualTo(String value) {
            addCriterion("DATAKEY <=", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyLike(String value) {
            addCriterion("DATAKEY like", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyNotLike(String value) {
            addCriterion("DATAKEY not like", value, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyIn(List<String> values) {
            addCriterion("DATAKEY in", values, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyNotIn(List<String> values) {
            addCriterion("DATAKEY not in", values, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyBetween(String value1, String value2) {
            addCriterion("DATAKEY between", value1, value2, "datakey");
            return (Criteria) this;
        }

        public Criteria andDatakeyNotBetween(String value1, String value2) {
            addCriterion("DATAKEY not between", value1, value2, "datakey");
            return (Criteria) this;
        }

        public Criteria andEncodeIsNull() {
            addCriterion("ENCODE is null");
            return (Criteria) this;
        }

        public Criteria andEncodeIsNotNull() {
            addCriterion("ENCODE is not null");
            return (Criteria) this;
        }

        public Criteria andEncodeEqualTo(String value) {
            addCriterion("ENCODE =", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeNotEqualTo(String value) {
            addCriterion("ENCODE <>", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeGreaterThan(String value) {
            addCriterion("ENCODE >", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeGreaterThanOrEqualTo(String value) {
            addCriterion("ENCODE >=", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeLessThan(String value) {
            addCriterion("ENCODE <", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeLessThanOrEqualTo(String value) {
            addCriterion("ENCODE <=", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeLike(String value) {
            addCriterion("ENCODE like", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeNotLike(String value) {
            addCriterion("ENCODE not like", value, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeIn(List<String> values) {
            addCriterion("ENCODE in", values, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeNotIn(List<String> values) {
            addCriterion("ENCODE not in", values, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeBetween(String value1, String value2) {
            addCriterion("ENCODE between", value1, value2, "encode");
            return (Criteria) this;
        }

        public Criteria andEncodeNotBetween(String value1, String value2) {
            addCriterion("ENCODE not between", value1, value2, "encode");
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

        public Criteria andFronturlIsNull() {
            addCriterion("FRONTURL is null");
            return (Criteria) this;
        }

        public Criteria andFronturlIsNotNull() {
            addCriterion("FRONTURL is not null");
            return (Criteria) this;
        }

        public Criteria andFronturlEqualTo(String value) {
            addCriterion("FRONTURL =", value, "fronturl");
            return (Criteria) this;
        }

        public Criteria andFronturlNotEqualTo(String value) {
            addCriterion("FRONTURL <>", value, "fronturl");
            return (Criteria) this;
        }

        public Criteria andFronturlGreaterThan(String value) {
            addCriterion("FRONTURL >", value, "fronturl");
            return (Criteria) this;
        }

        public Criteria andFronturlGreaterThanOrEqualTo(String value) {
            addCriterion("FRONTURL >=", value, "fronturl");
            return (Criteria) this;
        }

        public Criteria andFronturlLessThan(String value) {
            addCriterion("FRONTURL <", value, "fronturl");
            return (Criteria) this;
        }

        public Criteria andFronturlLessThanOrEqualTo(String value) {
            addCriterion("FRONTURL <=", value, "fronturl");
            return (Criteria) this;
        }

        public Criteria andFronturlLike(String value) {
            addCriterion("FRONTURL like", value, "fronturl");
            return (Criteria) this;
        }

        public Criteria andFronturlNotLike(String value) {
            addCriterion("FRONTURL not like", value, "fronturl");
            return (Criteria) this;
        }

        public Criteria andFronturlIn(List<String> values) {
            addCriterion("FRONTURL in", values, "fronturl");
            return (Criteria) this;
        }

        public Criteria andFronturlNotIn(List<String> values) {
            addCriterion("FRONTURL not in", values, "fronturl");
            return (Criteria) this;
        }

        public Criteria andFronturlBetween(String value1, String value2) {
            addCriterion("FRONTURL between", value1, value2, "fronturl");
            return (Criteria) this;
        }

        public Criteria andFronturlNotBetween(String value1, String value2) {
            addCriterion("FRONTURL not between", value1, value2, "fronturl");
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

        public Criteria andSafeurlIsNull() {
            addCriterion("SAFEURL is null");
            return (Criteria) this;
        }

        public Criteria andSafeurlIsNotNull() {
            addCriterion("SAFEURL is not null");
            return (Criteria) this;
        }

        public Criteria andSafeurlEqualTo(String value) {
            addCriterion("SAFEURL =", value, "safeurl");
            return (Criteria) this;
        }

        public Criteria andSafeurlNotEqualTo(String value) {
            addCriterion("SAFEURL <>", value, "safeurl");
            return (Criteria) this;
        }

        public Criteria andSafeurlGreaterThan(String value) {
            addCriterion("SAFEURL >", value, "safeurl");
            return (Criteria) this;
        }

        public Criteria andSafeurlGreaterThanOrEqualTo(String value) {
            addCriterion("SAFEURL >=", value, "safeurl");
            return (Criteria) this;
        }

        public Criteria andSafeurlLessThan(String value) {
            addCriterion("SAFEURL <", value, "safeurl");
            return (Criteria) this;
        }

        public Criteria andSafeurlLessThanOrEqualTo(String value) {
            addCriterion("SAFEURL <=", value, "safeurl");
            return (Criteria) this;
        }

        public Criteria andSafeurlLike(String value) {
            addCriterion("SAFEURL like", value, "safeurl");
            return (Criteria) this;
        }

        public Criteria andSafeurlNotLike(String value) {
            addCriterion("SAFEURL not like", value, "safeurl");
            return (Criteria) this;
        }

        public Criteria andSafeurlIn(List<String> values) {
            addCriterion("SAFEURL in", values, "safeurl");
            return (Criteria) this;
        }

        public Criteria andSafeurlNotIn(List<String> values) {
            addCriterion("SAFEURL not in", values, "safeurl");
            return (Criteria) this;
        }

        public Criteria andSafeurlBetween(String value1, String value2) {
            addCriterion("SAFEURL between", value1, value2, "safeurl");
            return (Criteria) this;
        }

        public Criteria andSafeurlNotBetween(String value1, String value2) {
            addCriterion("SAFEURL not between", value1, value2, "safeurl");
            return (Criteria) this;
        }

        public Criteria andChnlmerchnoIsNull() {
            addCriterion("CHNLMERCHNO is null");
            return (Criteria) this;
        }

        public Criteria andChnlmerchnoIsNotNull() {
            addCriterion("CHNLMERCHNO is not null");
            return (Criteria) this;
        }

        public Criteria andChnlmerchnoEqualTo(String value) {
            addCriterion("CHNLMERCHNO =", value, "chnlmerchno");
            return (Criteria) this;
        }

        public Criteria andChnlmerchnoNotEqualTo(String value) {
            addCriterion("CHNLMERCHNO <>", value, "chnlmerchno");
            return (Criteria) this;
        }

        public Criteria andChnlmerchnoGreaterThan(String value) {
            addCriterion("CHNLMERCHNO >", value, "chnlmerchno");
            return (Criteria) this;
        }

        public Criteria andChnlmerchnoGreaterThanOrEqualTo(String value) {
            addCriterion("CHNLMERCHNO >=", value, "chnlmerchno");
            return (Criteria) this;
        }

        public Criteria andChnlmerchnoLessThan(String value) {
            addCriterion("CHNLMERCHNO <", value, "chnlmerchno");
            return (Criteria) this;
        }

        public Criteria andChnlmerchnoLessThanOrEqualTo(String value) {
            addCriterion("CHNLMERCHNO <=", value, "chnlmerchno");
            return (Criteria) this;
        }

        public Criteria andChnlmerchnoLike(String value) {
            addCriterion("CHNLMERCHNO like", value, "chnlmerchno");
            return (Criteria) this;
        }

        public Criteria andChnlmerchnoNotLike(String value) {
            addCriterion("CHNLMERCHNO not like", value, "chnlmerchno");
            return (Criteria) this;
        }

        public Criteria andChnlmerchnoIn(List<String> values) {
            addCriterion("CHNLMERCHNO in", values, "chnlmerchno");
            return (Criteria) this;
        }

        public Criteria andChnlmerchnoNotIn(List<String> values) {
            addCriterion("CHNLMERCHNO not in", values, "chnlmerchno");
            return (Criteria) this;
        }

        public Criteria andChnlmerchnoBetween(String value1, String value2) {
            addCriterion("CHNLMERCHNO between", value1, value2, "chnlmerchno");
            return (Criteria) this;
        }

        public Criteria andChnlmerchnoNotBetween(String value1, String value2) {
            addCriterion("CHNLMERCHNO not between", value1, value2, "chnlmerchno");
            return (Criteria) this;
        }

        public Criteria andImplIsNull() {
            addCriterion("IMPL is null");
            return (Criteria) this;
        }

        public Criteria andImplIsNotNull() {
            addCriterion("IMPL is not null");
            return (Criteria) this;
        }

        public Criteria andImplEqualTo(String value) {
            addCriterion("IMPL =", value, "impl");
            return (Criteria) this;
        }

        public Criteria andImplNotEqualTo(String value) {
            addCriterion("IMPL <>", value, "impl");
            return (Criteria) this;
        }

        public Criteria andImplGreaterThan(String value) {
            addCriterion("IMPL >", value, "impl");
            return (Criteria) this;
        }

        public Criteria andImplGreaterThanOrEqualTo(String value) {
            addCriterion("IMPL >=", value, "impl");
            return (Criteria) this;
        }

        public Criteria andImplLessThan(String value) {
            addCriterion("IMPL <", value, "impl");
            return (Criteria) this;
        }

        public Criteria andImplLessThanOrEqualTo(String value) {
            addCriterion("IMPL <=", value, "impl");
            return (Criteria) this;
        }

        public Criteria andImplLike(String value) {
            addCriterion("IMPL like", value, "impl");
            return (Criteria) this;
        }

        public Criteria andImplNotLike(String value) {
            addCriterion("IMPL not like", value, "impl");
            return (Criteria) this;
        }

        public Criteria andImplIn(List<String> values) {
            addCriterion("IMPL in", values, "impl");
            return (Criteria) this;
        }

        public Criteria andImplNotIn(List<String> values) {
            addCriterion("IMPL not in", values, "impl");
            return (Criteria) this;
        }

        public Criteria andImplBetween(String value1, String value2) {
            addCriterion("IMPL between", value1, value2, "impl");
            return (Criteria) this;
        }

        public Criteria andImplNotBetween(String value1, String value2) {
            addCriterion("IMPL not between", value1, value2, "impl");
            return (Criteria) this;
        }

        public Criteria andRefundImplIsNull() {
            addCriterion("REFUND_IMPL is null");
            return (Criteria) this;
        }

        public Criteria andRefundImplIsNotNull() {
            addCriterion("REFUND_IMPL is not null");
            return (Criteria) this;
        }

        public Criteria andRefundImplEqualTo(String value) {
            addCriterion("REFUND_IMPL =", value, "refundImpl");
            return (Criteria) this;
        }

        public Criteria andRefundImplNotEqualTo(String value) {
            addCriterion("REFUND_IMPL <>", value, "refundImpl");
            return (Criteria) this;
        }

        public Criteria andRefundImplGreaterThan(String value) {
            addCriterion("REFUND_IMPL >", value, "refundImpl");
            return (Criteria) this;
        }

        public Criteria andRefundImplGreaterThanOrEqualTo(String value) {
            addCriterion("REFUND_IMPL >=", value, "refundImpl");
            return (Criteria) this;
        }

        public Criteria andRefundImplLessThan(String value) {
            addCriterion("REFUND_IMPL <", value, "refundImpl");
            return (Criteria) this;
        }

        public Criteria andRefundImplLessThanOrEqualTo(String value) {
            addCriterion("REFUND_IMPL <=", value, "refundImpl");
            return (Criteria) this;
        }

        public Criteria andRefundImplLike(String value) {
            addCriterion("REFUND_IMPL like", value, "refundImpl");
            return (Criteria) this;
        }

        public Criteria andRefundImplNotLike(String value) {
            addCriterion("REFUND_IMPL not like", value, "refundImpl");
            return (Criteria) this;
        }

        public Criteria andRefundImplIn(List<String> values) {
            addCriterion("REFUND_IMPL in", values, "refundImpl");
            return (Criteria) this;
        }

        public Criteria andRefundImplNotIn(List<String> values) {
            addCriterion("REFUND_IMPL not in", values, "refundImpl");
            return (Criteria) this;
        }

        public Criteria andRefundImplBetween(String value1, String value2) {
            addCriterion("REFUND_IMPL between", value1, value2, "refundImpl");
            return (Criteria) this;
        }

        public Criteria andRefundImplNotBetween(String value1, String value2) {
            addCriterion("REFUND_IMPL not between", value1, value2, "refundImpl");
            return (Criteria) this;
        }

        public Criteria andLimitnumIsNull() {
            addCriterion("limitnum is null");
            return (Criteria) this;
        }

        public Criteria andLimitnumIsNotNull() {
            addCriterion("limitnum is not null");
            return (Criteria) this;
        }

        public Criteria andLimitnumEqualTo(Long value) {
            addCriterion("limitnum =", value, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumNotEqualTo(Long value) {
            addCriterion("limitnum <>", value, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumGreaterThan(Long value) {
            addCriterion("limitnum >", value, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumGreaterThanOrEqualTo(Long value) {
            addCriterion("limitnum >=", value, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumLessThan(Long value) {
            addCriterion("limitnum <", value, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumLessThanOrEqualTo(Long value) {
            addCriterion("limitnum <=", value, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumIn(List<Long> values) {
            addCriterion("limitnum in", values, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumNotIn(List<Long> values) {
            addCriterion("limitnum not in", values, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumBetween(Long value1, Long value2) {
            addCriterion("limitnum between", value1, value2, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitnumNotBetween(Long value1, Long value2) {
            addCriterion("limitnum not between", value1, value2, "limitnum");
            return (Criteria) this;
        }

        public Criteria andLimitamtIsNull() {
            addCriterion("limitamt is null");
            return (Criteria) this;
        }

        public Criteria andLimitamtIsNotNull() {
            addCriterion("limitamt is not null");
            return (Criteria) this;
        }

        public Criteria andLimitamtEqualTo(Long value) {
            addCriterion("limitamt =", value, "limitamt");
            return (Criteria) this;
        }

        public Criteria andLimitamtNotEqualTo(Long value) {
            addCriterion("limitamt <>", value, "limitamt");
            return (Criteria) this;
        }

        public Criteria andLimitamtGreaterThan(Long value) {
            addCriterion("limitamt >", value, "limitamt");
            return (Criteria) this;
        }

        public Criteria andLimitamtGreaterThanOrEqualTo(Long value) {
            addCriterion("limitamt >=", value, "limitamt");
            return (Criteria) this;
        }

        public Criteria andLimitamtLessThan(Long value) {
            addCriterion("limitamt <", value, "limitamt");
            return (Criteria) this;
        }

        public Criteria andLimitamtLessThanOrEqualTo(Long value) {
            addCriterion("limitamt <=", value, "limitamt");
            return (Criteria) this;
        }

        public Criteria andLimitamtIn(List<Long> values) {
            addCriterion("limitamt in", values, "limitamt");
            return (Criteria) this;
        }

        public Criteria andLimitamtNotIn(List<Long> values) {
            addCriterion("limitamt not in", values, "limitamt");
            return (Criteria) this;
        }

        public Criteria andLimitamtBetween(Long value1, Long value2) {
            addCriterion("limitamt between", value1, value2, "limitamt");
            return (Criteria) this;
        }

        public Criteria andLimitamtNotBetween(Long value1, Long value2) {
            addCriterion("limitamt not between", value1, value2, "limitamt");
            return (Criteria) this;
        }

        public Criteria andTradeelementIsNull() {
            addCriterion("TRADEELEMENT is null");
            return (Criteria) this;
        }

        public Criteria andTradeelementIsNotNull() {
            addCriterion("TRADEELEMENT is not null");
            return (Criteria) this;
        }

        public Criteria andTradeelementEqualTo(String value) {
            addCriterion("TRADEELEMENT =", value, "tradeelement");
            return (Criteria) this;
        }

        public Criteria andTradeelementNotEqualTo(String value) {
            addCriterion("TRADEELEMENT <>", value, "tradeelement");
            return (Criteria) this;
        }

        public Criteria andTradeelementGreaterThan(String value) {
            addCriterion("TRADEELEMENT >", value, "tradeelement");
            return (Criteria) this;
        }

        public Criteria andTradeelementGreaterThanOrEqualTo(String value) {
            addCriterion("TRADEELEMENT >=", value, "tradeelement");
            return (Criteria) this;
        }

        public Criteria andTradeelementLessThan(String value) {
            addCriterion("TRADEELEMENT <", value, "tradeelement");
            return (Criteria) this;
        }

        public Criteria andTradeelementLessThanOrEqualTo(String value) {
            addCriterion("TRADEELEMENT <=", value, "tradeelement");
            return (Criteria) this;
        }

        public Criteria andTradeelementLike(String value) {
            addCriterion("TRADEELEMENT like", value, "tradeelement");
            return (Criteria) this;
        }

        public Criteria andTradeelementNotLike(String value) {
            addCriterion("TRADEELEMENT not like", value, "tradeelement");
            return (Criteria) this;
        }

        public Criteria andTradeelementIn(List<String> values) {
            addCriterion("TRADEELEMENT in", values, "tradeelement");
            return (Criteria) this;
        }

        public Criteria andTradeelementNotIn(List<String> values) {
            addCriterion("TRADEELEMENT not in", values, "tradeelement");
            return (Criteria) this;
        }

        public Criteria andTradeelementBetween(String value1, String value2) {
            addCriterion("TRADEELEMENT between", value1, value2, "tradeelement");
            return (Criteria) this;
        }

        public Criteria andTradeelementNotBetween(String value1, String value2) {
            addCriterion("TRADEELEMENT not between", value1, value2, "tradeelement");
            return (Criteria) this;
        }

        public Criteria andChkfileurlIsNull() {
            addCriterion("CHKFILEURL is null");
            return (Criteria) this;
        }

        public Criteria andChkfileurlIsNotNull() {
            addCriterion("CHKFILEURL is not null");
            return (Criteria) this;
        }

        public Criteria andChkfileurlEqualTo(String value) {
            addCriterion("CHKFILEURL =", value, "chkfileurl");
            return (Criteria) this;
        }

        public Criteria andChkfileurlNotEqualTo(String value) {
            addCriterion("CHKFILEURL <>", value, "chkfileurl");
            return (Criteria) this;
        }

        public Criteria andChkfileurlGreaterThan(String value) {
            addCriterion("CHKFILEURL >", value, "chkfileurl");
            return (Criteria) this;
        }

        public Criteria andChkfileurlGreaterThanOrEqualTo(String value) {
            addCriterion("CHKFILEURL >=", value, "chkfileurl");
            return (Criteria) this;
        }

        public Criteria andChkfileurlLessThan(String value) {
            addCriterion("CHKFILEURL <", value, "chkfileurl");
            return (Criteria) this;
        }

        public Criteria andChkfileurlLessThanOrEqualTo(String value) {
            addCriterion("CHKFILEURL <=", value, "chkfileurl");
            return (Criteria) this;
        }

        public Criteria andChkfileurlLike(String value) {
            addCriterion("CHKFILEURL like", value, "chkfileurl");
            return (Criteria) this;
        }

        public Criteria andChkfileurlNotLike(String value) {
            addCriterion("CHKFILEURL not like", value, "chkfileurl");
            return (Criteria) this;
        }

        public Criteria andChkfileurlIn(List<String> values) {
            addCriterion("CHKFILEURL in", values, "chkfileurl");
            return (Criteria) this;
        }

        public Criteria andChkfileurlNotIn(List<String> values) {
            addCriterion("CHKFILEURL not in", values, "chkfileurl");
            return (Criteria) this;
        }

        public Criteria andChkfileurlBetween(String value1, String value2) {
            addCriterion("CHKFILEURL between", value1, value2, "chkfileurl");
            return (Criteria) this;
        }

        public Criteria andChkfileurlNotBetween(String value1, String value2) {
            addCriterion("CHKFILEURL not between", value1, value2, "chkfileurl");
            return (Criteria) this;
        }

        public Criteria andChkfilgettypeIsNull() {
            addCriterion("CHKFILGETTYPE is null");
            return (Criteria) this;
        }

        public Criteria andChkfilgettypeIsNotNull() {
            addCriterion("CHKFILGETTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andChkfilgettypeEqualTo(String value) {
            addCriterion("CHKFILGETTYPE =", value, "chkfilgettype");
            return (Criteria) this;
        }

        public Criteria andChkfilgettypeNotEqualTo(String value) {
            addCriterion("CHKFILGETTYPE <>", value, "chkfilgettype");
            return (Criteria) this;
        }

        public Criteria andChkfilgettypeGreaterThan(String value) {
            addCriterion("CHKFILGETTYPE >", value, "chkfilgettype");
            return (Criteria) this;
        }

        public Criteria andChkfilgettypeGreaterThanOrEqualTo(String value) {
            addCriterion("CHKFILGETTYPE >=", value, "chkfilgettype");
            return (Criteria) this;
        }

        public Criteria andChkfilgettypeLessThan(String value) {
            addCriterion("CHKFILGETTYPE <", value, "chkfilgettype");
            return (Criteria) this;
        }

        public Criteria andChkfilgettypeLessThanOrEqualTo(String value) {
            addCriterion("CHKFILGETTYPE <=", value, "chkfilgettype");
            return (Criteria) this;
        }

        public Criteria andChkfilgettypeLike(String value) {
            addCriterion("CHKFILGETTYPE like", value, "chkfilgettype");
            return (Criteria) this;
        }

        public Criteria andChkfilgettypeNotLike(String value) {
            addCriterion("CHKFILGETTYPE not like", value, "chkfilgettype");
            return (Criteria) this;
        }

        public Criteria andChkfilgettypeIn(List<String> values) {
            addCriterion("CHKFILGETTYPE in", values, "chkfilgettype");
            return (Criteria) this;
        }

        public Criteria andChkfilgettypeNotIn(List<String> values) {
            addCriterion("CHKFILGETTYPE not in", values, "chkfilgettype");
            return (Criteria) this;
        }

        public Criteria andChkfilgettypeBetween(String value1, String value2) {
            addCriterion("CHKFILGETTYPE between", value1, value2, "chkfilgettype");
            return (Criteria) this;
        }

        public Criteria andChkfilgettypeNotBetween(String value1, String value2) {
            addCriterion("CHKFILGETTYPE not between", value1, value2, "chkfilgettype");
            return (Criteria) this;
        }

        public Criteria andCfftpuserIsNull() {
            addCriterion("CFFTPUSER is null");
            return (Criteria) this;
        }

        public Criteria andCfftpuserIsNotNull() {
            addCriterion("CFFTPUSER is not null");
            return (Criteria) this;
        }

        public Criteria andCfftpuserEqualTo(String value) {
            addCriterion("CFFTPUSER =", value, "cfftpuser");
            return (Criteria) this;
        }

        public Criteria andCfftpuserNotEqualTo(String value) {
            addCriterion("CFFTPUSER <>", value, "cfftpuser");
            return (Criteria) this;
        }

        public Criteria andCfftpuserGreaterThan(String value) {
            addCriterion("CFFTPUSER >", value, "cfftpuser");
            return (Criteria) this;
        }

        public Criteria andCfftpuserGreaterThanOrEqualTo(String value) {
            addCriterion("CFFTPUSER >=", value, "cfftpuser");
            return (Criteria) this;
        }

        public Criteria andCfftpuserLessThan(String value) {
            addCriterion("CFFTPUSER <", value, "cfftpuser");
            return (Criteria) this;
        }

        public Criteria andCfftpuserLessThanOrEqualTo(String value) {
            addCriterion("CFFTPUSER <=", value, "cfftpuser");
            return (Criteria) this;
        }

        public Criteria andCfftpuserLike(String value) {
            addCriterion("CFFTPUSER like", value, "cfftpuser");
            return (Criteria) this;
        }

        public Criteria andCfftpuserNotLike(String value) {
            addCriterion("CFFTPUSER not like", value, "cfftpuser");
            return (Criteria) this;
        }

        public Criteria andCfftpuserIn(List<String> values) {
            addCriterion("CFFTPUSER in", values, "cfftpuser");
            return (Criteria) this;
        }

        public Criteria andCfftpuserNotIn(List<String> values) {
            addCriterion("CFFTPUSER not in", values, "cfftpuser");
            return (Criteria) this;
        }

        public Criteria andCfftpuserBetween(String value1, String value2) {
            addCriterion("CFFTPUSER between", value1, value2, "cfftpuser");
            return (Criteria) this;
        }

        public Criteria andCfftpuserNotBetween(String value1, String value2) {
            addCriterion("CFFTPUSER not between", value1, value2, "cfftpuser");
            return (Criteria) this;
        }

        public Criteria andCfftppwdIsNull() {
            addCriterion("CFFTPPWD is null");
            return (Criteria) this;
        }

        public Criteria andCfftppwdIsNotNull() {
            addCriterion("CFFTPPWD is not null");
            return (Criteria) this;
        }

        public Criteria andCfftppwdEqualTo(String value) {
            addCriterion("CFFTPPWD =", value, "cfftppwd");
            return (Criteria) this;
        }

        public Criteria andCfftppwdNotEqualTo(String value) {
            addCriterion("CFFTPPWD <>", value, "cfftppwd");
            return (Criteria) this;
        }

        public Criteria andCfftppwdGreaterThan(String value) {
            addCriterion("CFFTPPWD >", value, "cfftppwd");
            return (Criteria) this;
        }

        public Criteria andCfftppwdGreaterThanOrEqualTo(String value) {
            addCriterion("CFFTPPWD >=", value, "cfftppwd");
            return (Criteria) this;
        }

        public Criteria andCfftppwdLessThan(String value) {
            addCriterion("CFFTPPWD <", value, "cfftppwd");
            return (Criteria) this;
        }

        public Criteria andCfftppwdLessThanOrEqualTo(String value) {
            addCriterion("CFFTPPWD <=", value, "cfftppwd");
            return (Criteria) this;
        }

        public Criteria andCfftppwdLike(String value) {
            addCriterion("CFFTPPWD like", value, "cfftppwd");
            return (Criteria) this;
        }

        public Criteria andCfftppwdNotLike(String value) {
            addCriterion("CFFTPPWD not like", value, "cfftppwd");
            return (Criteria) this;
        }

        public Criteria andCfftppwdIn(List<String> values) {
            addCriterion("CFFTPPWD in", values, "cfftppwd");
            return (Criteria) this;
        }

        public Criteria andCfftppwdNotIn(List<String> values) {
            addCriterion("CFFTPPWD not in", values, "cfftppwd");
            return (Criteria) this;
        }

        public Criteria andCfftppwdBetween(String value1, String value2) {
            addCriterion("CFFTPPWD between", value1, value2, "cfftppwd");
            return (Criteria) this;
        }

        public Criteria andCfftppwdNotBetween(String value1, String value2) {
            addCriterion("CFFTPPWD not between", value1, value2, "cfftppwd");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("CONTACT is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("CONTACT is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("CONTACT =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("CONTACT <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("CONTACT >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("CONTACT <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("CONTACT <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("CONTACT like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("CONTACT not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("CONTACT in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("CONTACT not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("CONTACT between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("CONTACT not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContPhoneIsNull() {
            addCriterion("CONT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andContPhoneIsNotNull() {
            addCriterion("CONT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andContPhoneEqualTo(String value) {
            addCriterion("CONT_PHONE =", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneNotEqualTo(String value) {
            addCriterion("CONT_PHONE <>", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneGreaterThan(String value) {
            addCriterion("CONT_PHONE >", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_PHONE >=", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneLessThan(String value) {
            addCriterion("CONT_PHONE <", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneLessThanOrEqualTo(String value) {
            addCriterion("CONT_PHONE <=", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneLike(String value) {
            addCriterion("CONT_PHONE like", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneNotLike(String value) {
            addCriterion("CONT_PHONE not like", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneIn(List<String> values) {
            addCriterion("CONT_PHONE in", values, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneNotIn(List<String> values) {
            addCriterion("CONT_PHONE not in", values, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneBetween(String value1, String value2) {
            addCriterion("CONT_PHONE between", value1, value2, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneNotBetween(String value1, String value2) {
            addCriterion("CONT_PHONE not between", value1, value2, "contPhone");
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