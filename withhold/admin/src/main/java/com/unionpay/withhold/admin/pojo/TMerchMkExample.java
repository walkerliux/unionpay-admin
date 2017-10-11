package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TMerchMkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMerchMkExample() {
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

        public Criteria andSafeseqIsNull() {
            addCriterion("SAFESEQ is null");
            return (Criteria) this;
        }

        public Criteria andSafeseqIsNotNull() {
            addCriterion("SAFESEQ is not null");
            return (Criteria) this;
        }

        public Criteria andSafeseqEqualTo(Integer value) {
            addCriterion("SAFESEQ =", value, "safeseq");
            return (Criteria) this;
        }

        public Criteria andSafeseqNotEqualTo(Integer value) {
            addCriterion("SAFESEQ <>", value, "safeseq");
            return (Criteria) this;
        }

        public Criteria andSafeseqGreaterThan(Integer value) {
            addCriterion("SAFESEQ >", value, "safeseq");
            return (Criteria) this;
        }

        public Criteria andSafeseqGreaterThanOrEqualTo(Integer value) {
            addCriterion("SAFESEQ >=", value, "safeseq");
            return (Criteria) this;
        }

        public Criteria andSafeseqLessThan(Integer value) {
            addCriterion("SAFESEQ <", value, "safeseq");
            return (Criteria) this;
        }

        public Criteria andSafeseqLessThanOrEqualTo(Integer value) {
            addCriterion("SAFESEQ <=", value, "safeseq");
            return (Criteria) this;
        }

        public Criteria andSafeseqIn(List<Integer> values) {
            addCriterion("SAFESEQ in", values, "safeseq");
            return (Criteria) this;
        }

        public Criteria andSafeseqNotIn(List<Integer> values) {
            addCriterion("SAFESEQ not in", values, "safeseq");
            return (Criteria) this;
        }

        public Criteria andSafeseqBetween(Integer value1, Integer value2) {
            addCriterion("SAFESEQ between", value1, value2, "safeseq");
            return (Criteria) this;
        }

        public Criteria andSafeseqNotBetween(Integer value1, Integer value2) {
            addCriterion("SAFESEQ not between", value1, value2, "safeseq");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNull() {
            addCriterion("MEMBERID is null");
            return (Criteria) this;
        }

        public Criteria andMemberidIsNotNull() {
            addCriterion("MEMBERID is not null");
            return (Criteria) this;
        }

        public Criteria andMemberidEqualTo(String value) {
            addCriterion("MEMBERID =", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotEqualTo(String value) {
            addCriterion("MEMBERID <>", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThan(String value) {
            addCriterion("MEMBERID >", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBERID >=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThan(String value) {
            addCriterion("MEMBERID <", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLessThanOrEqualTo(String value) {
            addCriterion("MEMBERID <=", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidLike(String value) {
            addCriterion("MEMBERID like", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotLike(String value) {
            addCriterion("MEMBERID not like", value, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidIn(List<String> values) {
            addCriterion("MEMBERID in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotIn(List<String> values) {
            addCriterion("MEMBERID not in", values, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidBetween(String value1, String value2) {
            addCriterion("MEMBERID between", value1, value2, "memberid");
            return (Criteria) this;
        }

        public Criteria andMemberidNotBetween(String value1, String value2) {
            addCriterion("MEMBERID not between", value1, value2, "memberid");
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

        public Criteria andMemberpubkeyIsNull() {
            addCriterion("MEMBERPUBKEY is null");
            return (Criteria) this;
        }

        public Criteria andMemberpubkeyIsNotNull() {
            addCriterion("MEMBERPUBKEY is not null");
            return (Criteria) this;
        }

        public Criteria andMemberpubkeyEqualTo(String value) {
            addCriterion("MEMBERPUBKEY =", value, "memberpubkey");
            return (Criteria) this;
        }

        public Criteria andMemberpubkeyNotEqualTo(String value) {
            addCriterion("MEMBERPUBKEY <>", value, "memberpubkey");
            return (Criteria) this;
        }

        public Criteria andMemberpubkeyGreaterThan(String value) {
            addCriterion("MEMBERPUBKEY >", value, "memberpubkey");
            return (Criteria) this;
        }

        public Criteria andMemberpubkeyGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBERPUBKEY >=", value, "memberpubkey");
            return (Criteria) this;
        }

        public Criteria andMemberpubkeyLessThan(String value) {
            addCriterion("MEMBERPUBKEY <", value, "memberpubkey");
            return (Criteria) this;
        }

        public Criteria andMemberpubkeyLessThanOrEqualTo(String value) {
            addCriterion("MEMBERPUBKEY <=", value, "memberpubkey");
            return (Criteria) this;
        }

        public Criteria andMemberpubkeyLike(String value) {
            addCriterion("MEMBERPUBKEY like", value, "memberpubkey");
            return (Criteria) this;
        }

        public Criteria andMemberpubkeyNotLike(String value) {
            addCriterion("MEMBERPUBKEY not like", value, "memberpubkey");
            return (Criteria) this;
        }

        public Criteria andMemberpubkeyIn(List<String> values) {
            addCriterion("MEMBERPUBKEY in", values, "memberpubkey");
            return (Criteria) this;
        }

        public Criteria andMemberpubkeyNotIn(List<String> values) {
            addCriterion("MEMBERPUBKEY not in", values, "memberpubkey");
            return (Criteria) this;
        }

        public Criteria andMemberpubkeyBetween(String value1, String value2) {
            addCriterion("MEMBERPUBKEY between", value1, value2, "memberpubkey");
            return (Criteria) this;
        }

        public Criteria andMemberpubkeyNotBetween(String value1, String value2) {
            addCriterion("MEMBERPUBKEY not between", value1, value2, "memberpubkey");
            return (Criteria) this;
        }

        public Criteria andMemberprikeyIsNull() {
            addCriterion("MEMBERPRIKEY is null");
            return (Criteria) this;
        }

        public Criteria andMemberprikeyIsNotNull() {
            addCriterion("MEMBERPRIKEY is not null");
            return (Criteria) this;
        }

        public Criteria andMemberprikeyEqualTo(String value) {
            addCriterion("MEMBERPRIKEY =", value, "memberprikey");
            return (Criteria) this;
        }

        public Criteria andMemberprikeyNotEqualTo(String value) {
            addCriterion("MEMBERPRIKEY <>", value, "memberprikey");
            return (Criteria) this;
        }

        public Criteria andMemberprikeyGreaterThan(String value) {
            addCriterion("MEMBERPRIKEY >", value, "memberprikey");
            return (Criteria) this;
        }

        public Criteria andMemberprikeyGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBERPRIKEY >=", value, "memberprikey");
            return (Criteria) this;
        }

        public Criteria andMemberprikeyLessThan(String value) {
            addCriterion("MEMBERPRIKEY <", value, "memberprikey");
            return (Criteria) this;
        }

        public Criteria andMemberprikeyLessThanOrEqualTo(String value) {
            addCriterion("MEMBERPRIKEY <=", value, "memberprikey");
            return (Criteria) this;
        }

        public Criteria andMemberprikeyLike(String value) {
            addCriterion("MEMBERPRIKEY like", value, "memberprikey");
            return (Criteria) this;
        }

        public Criteria andMemberprikeyNotLike(String value) {
            addCriterion("MEMBERPRIKEY not like", value, "memberprikey");
            return (Criteria) this;
        }

        public Criteria andMemberprikeyIn(List<String> values) {
            addCriterion("MEMBERPRIKEY in", values, "memberprikey");
            return (Criteria) this;
        }

        public Criteria andMemberprikeyNotIn(List<String> values) {
            addCriterion("MEMBERPRIKEY not in", values, "memberprikey");
            return (Criteria) this;
        }

        public Criteria andMemberprikeyBetween(String value1, String value2) {
            addCriterion("MEMBERPRIKEY between", value1, value2, "memberprikey");
            return (Criteria) this;
        }

        public Criteria andMemberprikeyNotBetween(String value1, String value2) {
            addCriterion("MEMBERPRIKEY not between", value1, value2, "memberprikey");
            return (Criteria) this;
        }

        public Criteria andLocalpubkeyIsNull() {
            addCriterion("LOCALPUBKEY is null");
            return (Criteria) this;
        }

        public Criteria andLocalpubkeyIsNotNull() {
            addCriterion("LOCALPUBKEY is not null");
            return (Criteria) this;
        }

        public Criteria andLocalpubkeyEqualTo(String value) {
            addCriterion("LOCALPUBKEY =", value, "localpubkey");
            return (Criteria) this;
        }

        public Criteria andLocalpubkeyNotEqualTo(String value) {
            addCriterion("LOCALPUBKEY <>", value, "localpubkey");
            return (Criteria) this;
        }

        public Criteria andLocalpubkeyGreaterThan(String value) {
            addCriterion("LOCALPUBKEY >", value, "localpubkey");
            return (Criteria) this;
        }

        public Criteria andLocalpubkeyGreaterThanOrEqualTo(String value) {
            addCriterion("LOCALPUBKEY >=", value, "localpubkey");
            return (Criteria) this;
        }

        public Criteria andLocalpubkeyLessThan(String value) {
            addCriterion("LOCALPUBKEY <", value, "localpubkey");
            return (Criteria) this;
        }

        public Criteria andLocalpubkeyLessThanOrEqualTo(String value) {
            addCriterion("LOCALPUBKEY <=", value, "localpubkey");
            return (Criteria) this;
        }

        public Criteria andLocalpubkeyLike(String value) {
            addCriterion("LOCALPUBKEY like", value, "localpubkey");
            return (Criteria) this;
        }

        public Criteria andLocalpubkeyNotLike(String value) {
            addCriterion("LOCALPUBKEY not like", value, "localpubkey");
            return (Criteria) this;
        }

        public Criteria andLocalpubkeyIn(List<String> values) {
            addCriterion("LOCALPUBKEY in", values, "localpubkey");
            return (Criteria) this;
        }

        public Criteria andLocalpubkeyNotIn(List<String> values) {
            addCriterion("LOCALPUBKEY not in", values, "localpubkey");
            return (Criteria) this;
        }

        public Criteria andLocalpubkeyBetween(String value1, String value2) {
            addCriterion("LOCALPUBKEY between", value1, value2, "localpubkey");
            return (Criteria) this;
        }

        public Criteria andLocalpubkeyNotBetween(String value1, String value2) {
            addCriterion("LOCALPUBKEY not between", value1, value2, "localpubkey");
            return (Criteria) this;
        }

        public Criteria andLocalprikeyIsNull() {
            addCriterion("LOCALPRIKEY is null");
            return (Criteria) this;
        }

        public Criteria andLocalprikeyIsNotNull() {
            addCriterion("LOCALPRIKEY is not null");
            return (Criteria) this;
        }

        public Criteria andLocalprikeyEqualTo(String value) {
            addCriterion("LOCALPRIKEY =", value, "localprikey");
            return (Criteria) this;
        }

        public Criteria andLocalprikeyNotEqualTo(String value) {
            addCriterion("LOCALPRIKEY <>", value, "localprikey");
            return (Criteria) this;
        }

        public Criteria andLocalprikeyGreaterThan(String value) {
            addCriterion("LOCALPRIKEY >", value, "localprikey");
            return (Criteria) this;
        }

        public Criteria andLocalprikeyGreaterThanOrEqualTo(String value) {
            addCriterion("LOCALPRIKEY >=", value, "localprikey");
            return (Criteria) this;
        }

        public Criteria andLocalprikeyLessThan(String value) {
            addCriterion("LOCALPRIKEY <", value, "localprikey");
            return (Criteria) this;
        }

        public Criteria andLocalprikeyLessThanOrEqualTo(String value) {
            addCriterion("LOCALPRIKEY <=", value, "localprikey");
            return (Criteria) this;
        }

        public Criteria andLocalprikeyLike(String value) {
            addCriterion("LOCALPRIKEY like", value, "localprikey");
            return (Criteria) this;
        }

        public Criteria andLocalprikeyNotLike(String value) {
            addCriterion("LOCALPRIKEY not like", value, "localprikey");
            return (Criteria) this;
        }

        public Criteria andLocalprikeyIn(List<String> values) {
            addCriterion("LOCALPRIKEY in", values, "localprikey");
            return (Criteria) this;
        }

        public Criteria andLocalprikeyNotIn(List<String> values) {
            addCriterion("LOCALPRIKEY not in", values, "localprikey");
            return (Criteria) this;
        }

        public Criteria andLocalprikeyBetween(String value1, String value2) {
            addCriterion("LOCALPRIKEY between", value1, value2, "localprikey");
            return (Criteria) this;
        }

        public Criteria andLocalprikeyNotBetween(String value1, String value2) {
            addCriterion("LOCALPRIKEY not between", value1, value2, "localprikey");
            return (Criteria) this;
        }

        public Criteria andPlatformpfxpwdIsNull() {
            addCriterion("PLATFORMPFXPWD is null");
            return (Criteria) this;
        }

        public Criteria andPlatformpfxpwdIsNotNull() {
            addCriterion("PLATFORMPFXPWD is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformpfxpwdEqualTo(String value) {
            addCriterion("PLATFORMPFXPWD =", value, "platformpfxpwd");
            return (Criteria) this;
        }

        public Criteria andPlatformpfxpwdNotEqualTo(String value) {
            addCriterion("PLATFORMPFXPWD <>", value, "platformpfxpwd");
            return (Criteria) this;
        }

        public Criteria andPlatformpfxpwdGreaterThan(String value) {
            addCriterion("PLATFORMPFXPWD >", value, "platformpfxpwd");
            return (Criteria) this;
        }

        public Criteria andPlatformpfxpwdGreaterThanOrEqualTo(String value) {
            addCriterion("PLATFORMPFXPWD >=", value, "platformpfxpwd");
            return (Criteria) this;
        }

        public Criteria andPlatformpfxpwdLessThan(String value) {
            addCriterion("PLATFORMPFXPWD <", value, "platformpfxpwd");
            return (Criteria) this;
        }

        public Criteria andPlatformpfxpwdLessThanOrEqualTo(String value) {
            addCriterion("PLATFORMPFXPWD <=", value, "platformpfxpwd");
            return (Criteria) this;
        }

        public Criteria andPlatformpfxpwdLike(String value) {
            addCriterion("PLATFORMPFXPWD like", value, "platformpfxpwd");
            return (Criteria) this;
        }

        public Criteria andPlatformpfxpwdNotLike(String value) {
            addCriterion("PLATFORMPFXPWD not like", value, "platformpfxpwd");
            return (Criteria) this;
        }

        public Criteria andPlatformpfxpwdIn(List<String> values) {
            addCriterion("PLATFORMPFXPWD in", values, "platformpfxpwd");
            return (Criteria) this;
        }

        public Criteria andPlatformpfxpwdNotIn(List<String> values) {
            addCriterion("PLATFORMPFXPWD not in", values, "platformpfxpwd");
            return (Criteria) this;
        }

        public Criteria andPlatformpfxpwdBetween(String value1, String value2) {
            addCriterion("PLATFORMPFXPWD between", value1, value2, "platformpfxpwd");
            return (Criteria) this;
        }

        public Criteria andPlatformpfxpwdNotBetween(String value1, String value2) {
            addCriterion("PLATFORMPFXPWD not between", value1, value2, "platformpfxpwd");
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

        public Criteria andPinIsNull() {
            addCriterion("PIN is null");
            return (Criteria) this;
        }

        public Criteria andPinIsNotNull() {
            addCriterion("PIN is not null");
            return (Criteria) this;
        }

        public Criteria andPinEqualTo(String value) {
            addCriterion("PIN =", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotEqualTo(String value) {
            addCriterion("PIN <>", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinGreaterThan(String value) {
            addCriterion("PIN >", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinGreaterThanOrEqualTo(String value) {
            addCriterion("PIN >=", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLessThan(String value) {
            addCriterion("PIN <", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLessThanOrEqualTo(String value) {
            addCriterion("PIN <=", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLike(String value) {
            addCriterion("PIN like", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotLike(String value) {
            addCriterion("PIN not like", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinIn(List<String> values) {
            addCriterion("PIN in", values, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotIn(List<String> values) {
            addCriterion("PIN not in", values, "pin");
            return (Criteria) this;
        }

        public Criteria andPinBetween(String value1, String value2) {
            addCriterion("PIN between", value1, value2, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotBetween(String value1, String value2) {
            addCriterion("PIN not between", value1, value2, "pin");
            return (Criteria) this;
        }

        public Criteria andMacIsNull() {
            addCriterion("MAC is null");
            return (Criteria) this;
        }

        public Criteria andMacIsNotNull() {
            addCriterion("MAC is not null");
            return (Criteria) this;
        }

        public Criteria andMacEqualTo(String value) {
            addCriterion("MAC =", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotEqualTo(String value) {
            addCriterion("MAC <>", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThan(String value) {
            addCriterion("MAC >", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThanOrEqualTo(String value) {
            addCriterion("MAC >=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThan(String value) {
            addCriterion("MAC <", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThanOrEqualTo(String value) {
            addCriterion("MAC <=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLike(String value) {
            addCriterion("MAC like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotLike(String value) {
            addCriterion("MAC not like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacIn(List<String> values) {
            addCriterion("MAC in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotIn(List<String> values) {
            addCriterion("MAC not in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacBetween(String value1, String value2) {
            addCriterion("MAC between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotBetween(String value1, String value2) {
            addCriterion("MAC not between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andDataIsNull() {
            addCriterion("DATA is null");
            return (Criteria) this;
        }

        public Criteria andDataIsNotNull() {
            addCriterion("DATA is not null");
            return (Criteria) this;
        }

        public Criteria andDataEqualTo(String value) {
            addCriterion("DATA =", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotEqualTo(String value) {
            addCriterion("DATA <>", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThan(String value) {
            addCriterion("DATA >", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThanOrEqualTo(String value) {
            addCriterion("DATA >=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThan(String value) {
            addCriterion("DATA <", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThanOrEqualTo(String value) {
            addCriterion("DATA <=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLike(String value) {
            addCriterion("DATA like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotLike(String value) {
            addCriterion("DATA not like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataIn(List<String> values) {
            addCriterion("DATA in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotIn(List<String> values) {
            addCriterion("DATA not in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataBetween(String value1, String value2) {
            addCriterion("DATA between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotBetween(String value1, String value2) {
            addCriterion("DATA not between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andMd5IsNull() {
            addCriterion("MD5 is null");
            return (Criteria) this;
        }

        public Criteria andMd5IsNotNull() {
            addCriterion("MD5 is not null");
            return (Criteria) this;
        }

        public Criteria andMd5EqualTo(String value) {
            addCriterion("MD5 =", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotEqualTo(String value) {
            addCriterion("MD5 <>", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5GreaterThan(String value) {
            addCriterion("MD5 >", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5GreaterThanOrEqualTo(String value) {
            addCriterion("MD5 >=", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5LessThan(String value) {
            addCriterion("MD5 <", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5LessThanOrEqualTo(String value) {
            addCriterion("MD5 <=", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5Like(String value) {
            addCriterion("MD5 like", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotLike(String value) {
            addCriterion("MD5 not like", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5In(List<String> values) {
            addCriterion("MD5 in", values, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotIn(List<String> values) {
            addCriterion("MD5 not in", values, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5Between(String value1, String value2) {
            addCriterion("MD5 between", value1, value2, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotBetween(String value1, String value2) {
            addCriterion("MD5 not between", value1, value2, "md5");
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

        public Criteria andKeyflagIsNull() {
            addCriterion("KEYFLAG is null");
            return (Criteria) this;
        }

        public Criteria andKeyflagIsNotNull() {
            addCriterion("KEYFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andKeyflagEqualTo(String value) {
            addCriterion("KEYFLAG =", value, "keyflag");
            return (Criteria) this;
        }

        public Criteria andKeyflagNotEqualTo(String value) {
            addCriterion("KEYFLAG <>", value, "keyflag");
            return (Criteria) this;
        }

        public Criteria andKeyflagGreaterThan(String value) {
            addCriterion("KEYFLAG >", value, "keyflag");
            return (Criteria) this;
        }

        public Criteria andKeyflagGreaterThanOrEqualTo(String value) {
            addCriterion("KEYFLAG >=", value, "keyflag");
            return (Criteria) this;
        }

        public Criteria andKeyflagLessThan(String value) {
            addCriterion("KEYFLAG <", value, "keyflag");
            return (Criteria) this;
        }

        public Criteria andKeyflagLessThanOrEqualTo(String value) {
            addCriterion("KEYFLAG <=", value, "keyflag");
            return (Criteria) this;
        }

        public Criteria andKeyflagLike(String value) {
            addCriterion("KEYFLAG like", value, "keyflag");
            return (Criteria) this;
        }

        public Criteria andKeyflagNotLike(String value) {
            addCriterion("KEYFLAG not like", value, "keyflag");
            return (Criteria) this;
        }

        public Criteria andKeyflagIn(List<String> values) {
            addCriterion("KEYFLAG in", values, "keyflag");
            return (Criteria) this;
        }

        public Criteria andKeyflagNotIn(List<String> values) {
            addCriterion("KEYFLAG not in", values, "keyflag");
            return (Criteria) this;
        }

        public Criteria andKeyflagBetween(String value1, String value2) {
            addCriterion("KEYFLAG between", value1, value2, "keyflag");
            return (Criteria) this;
        }

        public Criteria andKeyflagNotBetween(String value1, String value2) {
            addCriterion("KEYFLAG not between", value1, value2, "keyflag");
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