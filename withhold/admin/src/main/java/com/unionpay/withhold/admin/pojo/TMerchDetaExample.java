package com.unionpay.withhold.admin.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMerchDetaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMerchDetaExample() {
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

        public Criteria andMerchIdIsNull() {
            addCriterion("MERCH_ID is null");
            return (Criteria) this;
        }

        public Criteria andMerchIdIsNotNull() {
            addCriterion("MERCH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMerchIdEqualTo(Long value) {
            addCriterion("MERCH_ID =", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotEqualTo(Long value) {
            addCriterion("MERCH_ID <>", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdGreaterThan(Long value) {
            addCriterion("MERCH_ID >", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MERCH_ID >=", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdLessThan(Long value) {
            addCriterion("MERCH_ID <", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdLessThanOrEqualTo(Long value) {
            addCriterion("MERCH_ID <=", value, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdIn(List<Long> values) {
            addCriterion("MERCH_ID in", values, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotIn(List<Long> values) {
            addCriterion("MERCH_ID not in", values, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdBetween(Long value1, Long value2) {
            addCriterion("MERCH_ID between", value1, value2, "merchId");
            return (Criteria) this;
        }

        public Criteria andMerchIdNotBetween(Long value1, Long value2) {
            addCriterion("MERCH_ID not between", value1, value2, "merchId");
            return (Criteria) this;
        }

        public Criteria andMemIdIsNull() {
            addCriterion("MEM_ID is null");
            return (Criteria) this;
        }

        public Criteria andMemIdIsNotNull() {
            addCriterion("MEM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMemIdEqualTo(Long value) {
            addCriterion("MEM_ID =", value, "memId");
            return (Criteria) this;
        }

        public Criteria andMemIdNotEqualTo(Long value) {
            addCriterion("MEM_ID <>", value, "memId");
            return (Criteria) this;
        }

        public Criteria andMemIdGreaterThan(Long value) {
            addCriterion("MEM_ID >", value, "memId");
            return (Criteria) this;
        }

        public Criteria andMemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MEM_ID >=", value, "memId");
            return (Criteria) this;
        }

        public Criteria andMemIdLessThan(Long value) {
            addCriterion("MEM_ID <", value, "memId");
            return (Criteria) this;
        }

        public Criteria andMemIdLessThanOrEqualTo(Long value) {
            addCriterion("MEM_ID <=", value, "memId");
            return (Criteria) this;
        }

        public Criteria andMemIdIn(List<Long> values) {
            addCriterion("MEM_ID in", values, "memId");
            return (Criteria) this;
        }

        public Criteria andMemIdNotIn(List<Long> values) {
            addCriterion("MEM_ID not in", values, "memId");
            return (Criteria) this;
        }

        public Criteria andMemIdBetween(Long value1, Long value2) {
            addCriterion("MEM_ID between", value1, value2, "memId");
            return (Criteria) this;
        }

        public Criteria andMemIdNotBetween(Long value1, Long value2) {
            addCriterion("MEM_ID not between", value1, value2, "memId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(String value) {
            addCriterion("MEMBER_ID =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(String value) {
            addCriterion("MEMBER_ID <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(String value) {
            addCriterion("MEMBER_ID >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBER_ID >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(String value) {
            addCriterion("MEMBER_ID <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(String value) {
            addCriterion("MEMBER_ID <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLike(String value) {
            addCriterion("MEMBER_ID like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotLike(String value) {
            addCriterion("MEMBER_ID not like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<String> values) {
            addCriterion("MEMBER_ID in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<String> values) {
            addCriterion("MEMBER_ID not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(String value1, String value2) {
            addCriterion("MEMBER_ID between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(String value1, String value2) {
            addCriterion("MEMBER_ID not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNull() {
            addCriterion("MEMBER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNotNull() {
            addCriterion("MEMBER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNameEqualTo(String value) {
            addCriterion("MEMBER_NAME =", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotEqualTo(String value) {
            addCriterion("MEMBER_NAME <>", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThan(String value) {
            addCriterion("MEMBER_NAME >", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBER_NAME >=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThan(String value) {
            addCriterion("MEMBER_NAME <", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanOrEqualTo(String value) {
            addCriterion("MEMBER_NAME <=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLike(String value) {
            addCriterion("MEMBER_NAME like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotLike(String value) {
            addCriterion("MEMBER_NAME not like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameIn(List<String> values) {
            addCriterion("MEMBER_NAME in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotIn(List<String> values) {
            addCriterion("MEMBER_NAME not in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameBetween(String value1, String value2) {
            addCriterion("MEMBER_NAME between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotBetween(String value1, String value2) {
            addCriterion("MEMBER_NAME not between", value1, value2, "memberName");
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

        public Criteria andPostCodeIsNull() {
            addCriterion("POST_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNotNull() {
            addCriterion("POST_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPostCodeEqualTo(String value) {
            addCriterion("POST_CODE =", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotEqualTo(String value) {
            addCriterion("POST_CODE <>", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThan(String value) {
            addCriterion("POST_CODE >", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThanOrEqualTo(String value) {
            addCriterion("POST_CODE >=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThan(String value) {
            addCriterion("POST_CODE <", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThanOrEqualTo(String value) {
            addCriterion("POST_CODE <=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLike(String value) {
            addCriterion("POST_CODE like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotLike(String value) {
            addCriterion("POST_CODE not like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeIn(List<String> values) {
            addCriterion("POST_CODE in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotIn(List<String> values) {
            addCriterion("POST_CODE not in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeBetween(String value1, String value2) {
            addCriterion("POST_CODE between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotBetween(String value1, String value2) {
            addCriterion("POST_CODE not between", value1, value2, "postCode");
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

        public Criteria andContAddressIsNull() {
            addCriterion("CONT_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andContAddressIsNotNull() {
            addCriterion("CONT_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andContAddressEqualTo(String value) {
            addCriterion("CONT_ADDRESS =", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressNotEqualTo(String value) {
            addCriterion("CONT_ADDRESS <>", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressGreaterThan(String value) {
            addCriterion("CONT_ADDRESS >", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_ADDRESS >=", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressLessThan(String value) {
            addCriterion("CONT_ADDRESS <", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressLessThanOrEqualTo(String value) {
            addCriterion("CONT_ADDRESS <=", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressLike(String value) {
            addCriterion("CONT_ADDRESS like", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressNotLike(String value) {
            addCriterion("CONT_ADDRESS not like", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressIn(List<String> values) {
            addCriterion("CONT_ADDRESS in", values, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressNotIn(List<String> values) {
            addCriterion("CONT_ADDRESS not in", values, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressBetween(String value1, String value2) {
            addCriterion("CONT_ADDRESS between", value1, value2, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressNotBetween(String value1, String value2) {
            addCriterion("CONT_ADDRESS not between", value1, value2, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContPostIsNull() {
            addCriterion("CONT_POST is null");
            return (Criteria) this;
        }

        public Criteria andContPostIsNotNull() {
            addCriterion("CONT_POST is not null");
            return (Criteria) this;
        }

        public Criteria andContPostEqualTo(String value) {
            addCriterion("CONT_POST =", value, "contPost");
            return (Criteria) this;
        }

        public Criteria andContPostNotEqualTo(String value) {
            addCriterion("CONT_POST <>", value, "contPost");
            return (Criteria) this;
        }

        public Criteria andContPostGreaterThan(String value) {
            addCriterion("CONT_POST >", value, "contPost");
            return (Criteria) this;
        }

        public Criteria andContPostGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_POST >=", value, "contPost");
            return (Criteria) this;
        }

        public Criteria andContPostLessThan(String value) {
            addCriterion("CONT_POST <", value, "contPost");
            return (Criteria) this;
        }

        public Criteria andContPostLessThanOrEqualTo(String value) {
            addCriterion("CONT_POST <=", value, "contPost");
            return (Criteria) this;
        }

        public Criteria andContPostLike(String value) {
            addCriterion("CONT_POST like", value, "contPost");
            return (Criteria) this;
        }

        public Criteria andContPostNotLike(String value) {
            addCriterion("CONT_POST not like", value, "contPost");
            return (Criteria) this;
        }

        public Criteria andContPostIn(List<String> values) {
            addCriterion("CONT_POST in", values, "contPost");
            return (Criteria) this;
        }

        public Criteria andContPostNotIn(List<String> values) {
            addCriterion("CONT_POST not in", values, "contPost");
            return (Criteria) this;
        }

        public Criteria andContPostBetween(String value1, String value2) {
            addCriterion("CONT_POST between", value1, value2, "contPost");
            return (Criteria) this;
        }

        public Criteria andContPostNotBetween(String value1, String value2) {
            addCriterion("CONT_POST not between", value1, value2, "contPost");
            return (Criteria) this;
        }

        public Criteria andContEmailIsNull() {
            addCriterion("CONT_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andContEmailIsNotNull() {
            addCriterion("CONT_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andContEmailEqualTo(String value) {
            addCriterion("CONT_EMAIL =", value, "contEmail");
            return (Criteria) this;
        }

        public Criteria andContEmailNotEqualTo(String value) {
            addCriterion("CONT_EMAIL <>", value, "contEmail");
            return (Criteria) this;
        }

        public Criteria andContEmailGreaterThan(String value) {
            addCriterion("CONT_EMAIL >", value, "contEmail");
            return (Criteria) this;
        }

        public Criteria andContEmailGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_EMAIL >=", value, "contEmail");
            return (Criteria) this;
        }

        public Criteria andContEmailLessThan(String value) {
            addCriterion("CONT_EMAIL <", value, "contEmail");
            return (Criteria) this;
        }

        public Criteria andContEmailLessThanOrEqualTo(String value) {
            addCriterion("CONT_EMAIL <=", value, "contEmail");
            return (Criteria) this;
        }

        public Criteria andContEmailLike(String value) {
            addCriterion("CONT_EMAIL like", value, "contEmail");
            return (Criteria) this;
        }

        public Criteria andContEmailNotLike(String value) {
            addCriterion("CONT_EMAIL not like", value, "contEmail");
            return (Criteria) this;
        }

        public Criteria andContEmailIn(List<String> values) {
            addCriterion("CONT_EMAIL in", values, "contEmail");
            return (Criteria) this;
        }

        public Criteria andContEmailNotIn(List<String> values) {
            addCriterion("CONT_EMAIL not in", values, "contEmail");
            return (Criteria) this;
        }

        public Criteria andContEmailBetween(String value1, String value2) {
            addCriterion("CONT_EMAIL between", value1, value2, "contEmail");
            return (Criteria) this;
        }

        public Criteria andContEmailNotBetween(String value1, String value2) {
            addCriterion("CONT_EMAIL not between", value1, value2, "contEmail");
            return (Criteria) this;
        }

        public Criteria andSetlCycleIsNull() {
            addCriterion("SETL_CYCLE is null");
            return (Criteria) this;
        }

        public Criteria andSetlCycleIsNotNull() {
            addCriterion("SETL_CYCLE is not null");
            return (Criteria) this;
        }

        public Criteria andSetlCycleEqualTo(String value) {
            addCriterion("SETL_CYCLE =", value, "setlCycle");
            return (Criteria) this;
        }

        public Criteria andSetlCycleNotEqualTo(String value) {
            addCriterion("SETL_CYCLE <>", value, "setlCycle");
            return (Criteria) this;
        }

        public Criteria andSetlCycleGreaterThan(String value) {
            addCriterion("SETL_CYCLE >", value, "setlCycle");
            return (Criteria) this;
        }

        public Criteria andSetlCycleGreaterThanOrEqualTo(String value) {
            addCriterion("SETL_CYCLE >=", value, "setlCycle");
            return (Criteria) this;
        }

        public Criteria andSetlCycleLessThan(String value) {
            addCriterion("SETL_CYCLE <", value, "setlCycle");
            return (Criteria) this;
        }

        public Criteria andSetlCycleLessThanOrEqualTo(String value) {
            addCriterion("SETL_CYCLE <=", value, "setlCycle");
            return (Criteria) this;
        }

        public Criteria andSetlCycleLike(String value) {
            addCriterion("SETL_CYCLE like", value, "setlCycle");
            return (Criteria) this;
        }

        public Criteria andSetlCycleNotLike(String value) {
            addCriterion("SETL_CYCLE not like", value, "setlCycle");
            return (Criteria) this;
        }

        public Criteria andSetlCycleIn(List<String> values) {
            addCriterion("SETL_CYCLE in", values, "setlCycle");
            return (Criteria) this;
        }

        public Criteria andSetlCycleNotIn(List<String> values) {
            addCriterion("SETL_CYCLE not in", values, "setlCycle");
            return (Criteria) this;
        }

        public Criteria andSetlCycleBetween(String value1, String value2) {
            addCriterion("SETL_CYCLE between", value1, value2, "setlCycle");
            return (Criteria) this;
        }

        public Criteria andSetlCycleNotBetween(String value1, String value2) {
            addCriterion("SETL_CYCLE not between", value1, value2, "setlCycle");
            return (Criteria) this;
        }

        public Criteria andChargeIsNull() {
            addCriterion("CHARGE is null");
            return (Criteria) this;
        }

        public Criteria andChargeIsNotNull() {
            addCriterion("CHARGE is not null");
            return (Criteria) this;
        }

        public Criteria andChargeEqualTo(BigDecimal value) {
            addCriterion("CHARGE =", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotEqualTo(BigDecimal value) {
            addCriterion("CHARGE <>", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeGreaterThan(BigDecimal value) {
            addCriterion("CHARGE >", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CHARGE >=", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLessThan(BigDecimal value) {
            addCriterion("CHARGE <", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CHARGE <=", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeIn(List<BigDecimal> values) {
            addCriterion("CHARGE in", values, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotIn(List<BigDecimal> values) {
            addCriterion("CHARGE not in", values, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHARGE between", value1, value2, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CHARGE not between", value1, value2, "charge");
            return (Criteria) this;
        }

        public Criteria andDepositIsNull() {
            addCriterion("DEPOSIT is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("DEPOSIT is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(BigDecimal value) {
            addCriterion("DEPOSIT >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(BigDecimal value) {
            addCriterion("DEPOSIT <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<BigDecimal> values) {
            addCriterion("DEPOSIT in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<BigDecimal> values) {
            addCriterion("DEPOSIT not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSIT between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSIT not between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andRiskVerIsNull() {
            addCriterion("RISK_VER is null");
            return (Criteria) this;
        }

        public Criteria andRiskVerIsNotNull() {
            addCriterion("RISK_VER is not null");
            return (Criteria) this;
        }

        public Criteria andRiskVerEqualTo(String value) {
            addCriterion("RISK_VER =", value, "riskVer");
            return (Criteria) this;
        }

        public Criteria andRiskVerNotEqualTo(String value) {
            addCriterion("RISK_VER <>", value, "riskVer");
            return (Criteria) this;
        }

        public Criteria andRiskVerGreaterThan(String value) {
            addCriterion("RISK_VER >", value, "riskVer");
            return (Criteria) this;
        }

        public Criteria andRiskVerGreaterThanOrEqualTo(String value) {
            addCriterion("RISK_VER >=", value, "riskVer");
            return (Criteria) this;
        }

        public Criteria andRiskVerLessThan(String value) {
            addCriterion("RISK_VER <", value, "riskVer");
            return (Criteria) this;
        }

        public Criteria andRiskVerLessThanOrEqualTo(String value) {
            addCriterion("RISK_VER <=", value, "riskVer");
            return (Criteria) this;
        }

        public Criteria andRiskVerLike(String value) {
            addCriterion("RISK_VER like", value, "riskVer");
            return (Criteria) this;
        }

        public Criteria andRiskVerNotLike(String value) {
            addCriterion("RISK_VER not like", value, "riskVer");
            return (Criteria) this;
        }

        public Criteria andRiskVerIn(List<String> values) {
            addCriterion("RISK_VER in", values, "riskVer");
            return (Criteria) this;
        }

        public Criteria andRiskVerNotIn(List<String> values) {
            addCriterion("RISK_VER not in", values, "riskVer");
            return (Criteria) this;
        }

        public Criteria andRiskVerBetween(String value1, String value2) {
            addCriterion("RISK_VER between", value1, value2, "riskVer");
            return (Criteria) this;
        }

        public Criteria andRiskVerNotBetween(String value1, String value2) {
            addCriterion("RISK_VER not between", value1, value2, "riskVer");
            return (Criteria) this;
        }

        public Criteria andRoutVerIsNull() {
            addCriterion("ROUT_VER is null");
            return (Criteria) this;
        }

        public Criteria andRoutVerIsNotNull() {
            addCriterion("ROUT_VER is not null");
            return (Criteria) this;
        }

        public Criteria andRoutVerEqualTo(String value) {
            addCriterion("ROUT_VER =", value, "routVer");
            return (Criteria) this;
        }

        public Criteria andRoutVerNotEqualTo(String value) {
            addCriterion("ROUT_VER <>", value, "routVer");
            return (Criteria) this;
        }

        public Criteria andRoutVerGreaterThan(String value) {
            addCriterion("ROUT_VER >", value, "routVer");
            return (Criteria) this;
        }

        public Criteria andRoutVerGreaterThanOrEqualTo(String value) {
            addCriterion("ROUT_VER >=", value, "routVer");
            return (Criteria) this;
        }

        public Criteria andRoutVerLessThan(String value) {
            addCriterion("ROUT_VER <", value, "routVer");
            return (Criteria) this;
        }

        public Criteria andRoutVerLessThanOrEqualTo(String value) {
            addCriterion("ROUT_VER <=", value, "routVer");
            return (Criteria) this;
        }

        public Criteria andRoutVerLike(String value) {
            addCriterion("ROUT_VER like", value, "routVer");
            return (Criteria) this;
        }

        public Criteria andRoutVerNotLike(String value) {
            addCriterion("ROUT_VER not like", value, "routVer");
            return (Criteria) this;
        }

        public Criteria andRoutVerIn(List<String> values) {
            addCriterion("ROUT_VER in", values, "routVer");
            return (Criteria) this;
        }

        public Criteria andRoutVerNotIn(List<String> values) {
            addCriterion("ROUT_VER not in", values, "routVer");
            return (Criteria) this;
        }

        public Criteria andRoutVerBetween(String value1, String value2) {
            addCriterion("ROUT_VER between", value1, value2, "routVer");
            return (Criteria) this;
        }

        public Criteria andRoutVerNotBetween(String value1, String value2) {
            addCriterion("ROUT_VER not between", value1, value2, "routVer");
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

        public Criteria andMccIsNull() {
            addCriterion("MCC is null");
            return (Criteria) this;
        }

        public Criteria andMccIsNotNull() {
            addCriterion("MCC is not null");
            return (Criteria) this;
        }

        public Criteria andMccEqualTo(String value) {
            addCriterion("MCC =", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotEqualTo(String value) {
            addCriterion("MCC <>", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccGreaterThan(String value) {
            addCriterion("MCC >", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccGreaterThanOrEqualTo(String value) {
            addCriterion("MCC >=", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccLessThan(String value) {
            addCriterion("MCC <", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccLessThanOrEqualTo(String value) {
            addCriterion("MCC <=", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccLike(String value) {
            addCriterion("MCC like", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotLike(String value) {
            addCriterion("MCC not like", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccIn(List<String> values) {
            addCriterion("MCC in", values, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotIn(List<String> values) {
            addCriterion("MCC not in", values, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccBetween(String value1, String value2) {
            addCriterion("MCC between", value1, value2, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotBetween(String value1, String value2) {
            addCriterion("MCC not between", value1, value2, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccListIsNull() {
            addCriterion("MCC_LIST is null");
            return (Criteria) this;
        }

        public Criteria andMccListIsNotNull() {
            addCriterion("MCC_LIST is not null");
            return (Criteria) this;
        }

        public Criteria andMccListEqualTo(String value) {
            addCriterion("MCC_LIST =", value, "mccList");
            return (Criteria) this;
        }

        public Criteria andMccListNotEqualTo(String value) {
            addCriterion("MCC_LIST <>", value, "mccList");
            return (Criteria) this;
        }

        public Criteria andMccListGreaterThan(String value) {
            addCriterion("MCC_LIST >", value, "mccList");
            return (Criteria) this;
        }

        public Criteria andMccListGreaterThanOrEqualTo(String value) {
            addCriterion("MCC_LIST >=", value, "mccList");
            return (Criteria) this;
        }

        public Criteria andMccListLessThan(String value) {
            addCriterion("MCC_LIST <", value, "mccList");
            return (Criteria) this;
        }

        public Criteria andMccListLessThanOrEqualTo(String value) {
            addCriterion("MCC_LIST <=", value, "mccList");
            return (Criteria) this;
        }

        public Criteria andMccListLike(String value) {
            addCriterion("MCC_LIST like", value, "mccList");
            return (Criteria) this;
        }

        public Criteria andMccListNotLike(String value) {
            addCriterion("MCC_LIST not like", value, "mccList");
            return (Criteria) this;
        }

        public Criteria andMccListIn(List<String> values) {
            addCriterion("MCC_LIST in", values, "mccList");
            return (Criteria) this;
        }

        public Criteria andMccListNotIn(List<String> values) {
            addCriterion("MCC_LIST not in", values, "mccList");
            return (Criteria) this;
        }

        public Criteria andMccListBetween(String value1, String value2) {
            addCriterion("MCC_LIST between", value1, value2, "mccList");
            return (Criteria) this;
        }

        public Criteria andMccListNotBetween(String value1, String value2) {
            addCriterion("MCC_LIST not between", value1, value2, "mccList");
            return (Criteria) this;
        }

        public Criteria andTransfactorsIsNull() {
            addCriterion("transfactors is null");
            return (Criteria) this;
        }

        public Criteria andTransfactorsIsNotNull() {
            addCriterion("transfactors is not null");
            return (Criteria) this;
        }

        public Criteria andTransfactorsEqualTo(String value) {
            addCriterion("transfactors =", value, "transfactors");
            return (Criteria) this;
        }

        public Criteria andTransfactorsNotEqualTo(String value) {
            addCriterion("transfactors <>", value, "transfactors");
            return (Criteria) this;
        }

        public Criteria andTransfactorsGreaterThan(String value) {
            addCriterion("transfactors >", value, "transfactors");
            return (Criteria) this;
        }

        public Criteria andTransfactorsGreaterThanOrEqualTo(String value) {
            addCriterion("transfactors >=", value, "transfactors");
            return (Criteria) this;
        }

        public Criteria andTransfactorsLessThan(String value) {
            addCriterion("transfactors <", value, "transfactors");
            return (Criteria) this;
        }

        public Criteria andTransfactorsLessThanOrEqualTo(String value) {
            addCriterion("transfactors <=", value, "transfactors");
            return (Criteria) this;
        }

        public Criteria andTransfactorsLike(String value) {
            addCriterion("transfactors like", value, "transfactors");
            return (Criteria) this;
        }

        public Criteria andTransfactorsNotLike(String value) {
            addCriterion("transfactors not like", value, "transfactors");
            return (Criteria) this;
        }

        public Criteria andTransfactorsIn(List<String> values) {
            addCriterion("transfactors in", values, "transfactors");
            return (Criteria) this;
        }

        public Criteria andTransfactorsNotIn(List<String> values) {
            addCriterion("transfactors not in", values, "transfactors");
            return (Criteria) this;
        }

        public Criteria andTransfactorsBetween(String value1, String value2) {
            addCriterion("transfactors between", value1, value2, "transfactors");
            return (Criteria) this;
        }

        public Criteria andTransfactorsNotBetween(String value1, String value2) {
            addCriterion("transfactors not between", value1, value2, "transfactors");
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

        public Criteria andInUserIsNull() {
            addCriterion("IN_USER is null");
            return (Criteria) this;
        }

        public Criteria andInUserIsNotNull() {
            addCriterion("IN_USER is not null");
            return (Criteria) this;
        }

        public Criteria andInUserEqualTo(Long value) {
            addCriterion("IN_USER =", value, "inUser");
            return (Criteria) this;
        }

        public Criteria andInUserNotEqualTo(Long value) {
            addCriterion("IN_USER <>", value, "inUser");
            return (Criteria) this;
        }

        public Criteria andInUserGreaterThan(Long value) {
            addCriterion("IN_USER >", value, "inUser");
            return (Criteria) this;
        }

        public Criteria andInUserGreaterThanOrEqualTo(Long value) {
            addCriterion("IN_USER >=", value, "inUser");
            return (Criteria) this;
        }

        public Criteria andInUserLessThan(Long value) {
            addCriterion("IN_USER <", value, "inUser");
            return (Criteria) this;
        }

        public Criteria andInUserLessThanOrEqualTo(Long value) {
            addCriterion("IN_USER <=", value, "inUser");
            return (Criteria) this;
        }

        public Criteria andInUserIn(List<Long> values) {
            addCriterion("IN_USER in", values, "inUser");
            return (Criteria) this;
        }

        public Criteria andInUserNotIn(List<Long> values) {
            addCriterion("IN_USER not in", values, "inUser");
            return (Criteria) this;
        }

        public Criteria andInUserBetween(Long value1, Long value2) {
            addCriterion("IN_USER between", value1, value2, "inUser");
            return (Criteria) this;
        }

        public Criteria andInUserNotBetween(Long value1, Long value2) {
            addCriterion("IN_USER not between", value1, value2, "inUser");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNull() {
            addCriterion("IN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNotNull() {
            addCriterion("IN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andInTimeEqualTo(Date value) {
            addCriterion("IN_TIME =", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotEqualTo(Date value) {
            addCriterion("IN_TIME <>", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThan(Date value) {
            addCriterion("IN_TIME >", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("IN_TIME >=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThan(Date value) {
            addCriterion("IN_TIME <", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThanOrEqualTo(Date value) {
            addCriterion("IN_TIME <=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeIn(List<Date> values) {
            addCriterion("IN_TIME in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotIn(List<Date> values) {
            addCriterion("IN_TIME not in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeBetween(Date value1, Date value2) {
            addCriterion("IN_TIME between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotBetween(Date value1, Date value2) {
            addCriterion("IN_TIME not between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andStexaUserIsNull() {
            addCriterion("STEXA_USER is null");
            return (Criteria) this;
        }

        public Criteria andStexaUserIsNotNull() {
            addCriterion("STEXA_USER is not null");
            return (Criteria) this;
        }

        public Criteria andStexaUserEqualTo(Long value) {
            addCriterion("STEXA_USER =", value, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserNotEqualTo(Long value) {
            addCriterion("STEXA_USER <>", value, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserGreaterThan(Long value) {
            addCriterion("STEXA_USER >", value, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserGreaterThanOrEqualTo(Long value) {
            addCriterion("STEXA_USER >=", value, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserLessThan(Long value) {
            addCriterion("STEXA_USER <", value, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserLessThanOrEqualTo(Long value) {
            addCriterion("STEXA_USER <=", value, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserIn(List<Long> values) {
            addCriterion("STEXA_USER in", values, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserNotIn(List<Long> values) {
            addCriterion("STEXA_USER not in", values, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserBetween(Long value1, Long value2) {
            addCriterion("STEXA_USER between", value1, value2, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaUserNotBetween(Long value1, Long value2) {
            addCriterion("STEXA_USER not between", value1, value2, "stexaUser");
            return (Criteria) this;
        }

        public Criteria andStexaTimeIsNull() {
            addCriterion("STEXA_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStexaTimeIsNotNull() {
            addCriterion("STEXA_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStexaTimeEqualTo(Date value) {
            addCriterion("STEXA_TIME =", value, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeNotEqualTo(Date value) {
            addCriterion("STEXA_TIME <>", value, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeGreaterThan(Date value) {
            addCriterion("STEXA_TIME >", value, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STEXA_TIME >=", value, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeLessThan(Date value) {
            addCriterion("STEXA_TIME <", value, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeLessThanOrEqualTo(Date value) {
            addCriterion("STEXA_TIME <=", value, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeIn(List<Date> values) {
            addCriterion("STEXA_TIME in", values, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeNotIn(List<Date> values) {
            addCriterion("STEXA_TIME not in", values, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeBetween(Date value1, Date value2) {
            addCriterion("STEXA_TIME between", value1, value2, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaTimeNotBetween(Date value1, Date value2) {
            addCriterion("STEXA_TIME not between", value1, value2, "stexaTime");
            return (Criteria) this;
        }

        public Criteria andStexaOptIsNull() {
            addCriterion("STEXA_OPT is null");
            return (Criteria) this;
        }

        public Criteria andStexaOptIsNotNull() {
            addCriterion("STEXA_OPT is not null");
            return (Criteria) this;
        }

        public Criteria andStexaOptEqualTo(String value) {
            addCriterion("STEXA_OPT =", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptNotEqualTo(String value) {
            addCriterion("STEXA_OPT <>", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptGreaterThan(String value) {
            addCriterion("STEXA_OPT >", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptGreaterThanOrEqualTo(String value) {
            addCriterion("STEXA_OPT >=", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptLessThan(String value) {
            addCriterion("STEXA_OPT <", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptLessThanOrEqualTo(String value) {
            addCriterion("STEXA_OPT <=", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptLike(String value) {
            addCriterion("STEXA_OPT like", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptNotLike(String value) {
            addCriterion("STEXA_OPT not like", value, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptIn(List<String> values) {
            addCriterion("STEXA_OPT in", values, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptNotIn(List<String> values) {
            addCriterion("STEXA_OPT not in", values, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptBetween(String value1, String value2) {
            addCriterion("STEXA_OPT between", value1, value2, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andStexaOptNotBetween(String value1, String value2) {
            addCriterion("STEXA_OPT not between", value1, value2, "stexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserIsNull() {
            addCriterion("CVLEXA_USER is null");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserIsNotNull() {
            addCriterion("CVLEXA_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserEqualTo(Long value) {
            addCriterion("CVLEXA_USER =", value, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserNotEqualTo(Long value) {
            addCriterion("CVLEXA_USER <>", value, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserGreaterThan(Long value) {
            addCriterion("CVLEXA_USER >", value, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserGreaterThanOrEqualTo(Long value) {
            addCriterion("CVLEXA_USER >=", value, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserLessThan(Long value) {
            addCriterion("CVLEXA_USER <", value, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserLessThanOrEqualTo(Long value) {
            addCriterion("CVLEXA_USER <=", value, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserIn(List<Long> values) {
            addCriterion("CVLEXA_USER in", values, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserNotIn(List<Long> values) {
            addCriterion("CVLEXA_USER not in", values, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserBetween(Long value1, Long value2) {
            addCriterion("CVLEXA_USER between", value1, value2, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaUserNotBetween(Long value1, Long value2) {
            addCriterion("CVLEXA_USER not between", value1, value2, "cvlexaUser");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeIsNull() {
            addCriterion("CVLEXA_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeIsNotNull() {
            addCriterion("CVLEXA_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeEqualTo(Date value) {
            addCriterion("CVLEXA_TIME =", value, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeNotEqualTo(Date value) {
            addCriterion("CVLEXA_TIME <>", value, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeGreaterThan(Date value) {
            addCriterion("CVLEXA_TIME >", value, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CVLEXA_TIME >=", value, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeLessThan(Date value) {
            addCriterion("CVLEXA_TIME <", value, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeLessThanOrEqualTo(Date value) {
            addCriterion("CVLEXA_TIME <=", value, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeIn(List<Date> values) {
            addCriterion("CVLEXA_TIME in", values, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeNotIn(List<Date> values) {
            addCriterion("CVLEXA_TIME not in", values, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeBetween(Date value1, Date value2) {
            addCriterion("CVLEXA_TIME between", value1, value2, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaTimeNotBetween(Date value1, Date value2) {
            addCriterion("CVLEXA_TIME not between", value1, value2, "cvlexaTime");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptIsNull() {
            addCriterion("CVLEXA_OPT is null");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptIsNotNull() {
            addCriterion("CVLEXA_OPT is not null");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptEqualTo(String value) {
            addCriterion("CVLEXA_OPT =", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptNotEqualTo(String value) {
            addCriterion("CVLEXA_OPT <>", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptGreaterThan(String value) {
            addCriterion("CVLEXA_OPT >", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptGreaterThanOrEqualTo(String value) {
            addCriterion("CVLEXA_OPT >=", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptLessThan(String value) {
            addCriterion("CVLEXA_OPT <", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptLessThanOrEqualTo(String value) {
            addCriterion("CVLEXA_OPT <=", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptLike(String value) {
            addCriterion("CVLEXA_OPT like", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptNotLike(String value) {
            addCriterion("CVLEXA_OPT not like", value, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptIn(List<String> values) {
            addCriterion("CVLEXA_OPT in", values, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptNotIn(List<String> values) {
            addCriterion("CVLEXA_OPT not in", values, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptBetween(String value1, String value2) {
            addCriterion("CVLEXA_OPT between", value1, value2, "cvlexaOpt");
            return (Criteria) this;
        }

        public Criteria andCvlexaOptNotBetween(String value1, String value2) {
            addCriterion("CVLEXA_OPT not between", value1, value2, "cvlexaOpt");
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