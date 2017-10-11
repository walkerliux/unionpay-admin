package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TChnlCpdkBatchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TChnlCpdkBatchExample() {
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

        public Criteria andFilenameIsNull() {
            addCriterion("fileName is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("fileName is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("fileName =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("fileName <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("fileName >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("fileName >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("fileName <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("fileName <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("fileName like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("fileName not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("fileName in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("fileName not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("fileName between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("fileName not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andHpfilenameIsNull() {
            addCriterion("hpFileName is null");
            return (Criteria) this;
        }

        public Criteria andHpfilenameIsNotNull() {
            addCriterion("hpFileName is not null");
            return (Criteria) this;
        }

        public Criteria andHpfilenameEqualTo(String value) {
            addCriterion("hpFileName =", value, "hpfilename");
            return (Criteria) this;
        }

        public Criteria andHpfilenameNotEqualTo(String value) {
            addCriterion("hpFileName <>", value, "hpfilename");
            return (Criteria) this;
        }

        public Criteria andHpfilenameGreaterThan(String value) {
            addCriterion("hpFileName >", value, "hpfilename");
            return (Criteria) this;
        }

        public Criteria andHpfilenameGreaterThanOrEqualTo(String value) {
            addCriterion("hpFileName >=", value, "hpfilename");
            return (Criteria) this;
        }

        public Criteria andHpfilenameLessThan(String value) {
            addCriterion("hpFileName <", value, "hpfilename");
            return (Criteria) this;
        }

        public Criteria andHpfilenameLessThanOrEqualTo(String value) {
            addCriterion("hpFileName <=", value, "hpfilename");
            return (Criteria) this;
        }

        public Criteria andHpfilenameLike(String value) {
            addCriterion("hpFileName like", value, "hpfilename");
            return (Criteria) this;
        }

        public Criteria andHpfilenameNotLike(String value) {
            addCriterion("hpFileName not like", value, "hpfilename");
            return (Criteria) this;
        }

        public Criteria andHpfilenameIn(List<String> values) {
            addCriterion("hpFileName in", values, "hpfilename");
            return (Criteria) this;
        }

        public Criteria andHpfilenameNotIn(List<String> values) {
            addCriterion("hpFileName not in", values, "hpfilename");
            return (Criteria) this;
        }

        public Criteria andHpfilenameBetween(String value1, String value2) {
            addCriterion("hpFileName between", value1, value2, "hpfilename");
            return (Criteria) this;
        }

        public Criteria andHpfilenameNotBetween(String value1, String value2) {
            addCriterion("hpFileName not between", value1, value2, "hpfilename");
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

        public Criteria andTotalnumIsNull() {
            addCriterion("totalNum is null");
            return (Criteria) this;
        }

        public Criteria andTotalnumIsNotNull() {
            addCriterion("totalNum is not null");
            return (Criteria) this;
        }

        public Criteria andTotalnumEqualTo(String value) {
            addCriterion("totalNum =", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumNotEqualTo(String value) {
            addCriterion("totalNum <>", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumGreaterThan(String value) {
            addCriterion("totalNum >", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumGreaterThanOrEqualTo(String value) {
            addCriterion("totalNum >=", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumLessThan(String value) {
            addCriterion("totalNum <", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumLessThanOrEqualTo(String value) {
            addCriterion("totalNum <=", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumLike(String value) {
            addCriterion("totalNum like", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumNotLike(String value) {
            addCriterion("totalNum not like", value, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumIn(List<String> values) {
            addCriterion("totalNum in", values, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumNotIn(List<String> values) {
            addCriterion("totalNum not in", values, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumBetween(String value1, String value2) {
            addCriterion("totalNum between", value1, value2, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalnumNotBetween(String value1, String value2) {
            addCriterion("totalNum not between", value1, value2, "totalnum");
            return (Criteria) this;
        }

        public Criteria andTotalamtIsNull() {
            addCriterion("totalAmt is null");
            return (Criteria) this;
        }

        public Criteria andTotalamtIsNotNull() {
            addCriterion("totalAmt is not null");
            return (Criteria) this;
        }

        public Criteria andTotalamtEqualTo(String value) {
            addCriterion("totalAmt =", value, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtNotEqualTo(String value) {
            addCriterion("totalAmt <>", value, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtGreaterThan(String value) {
            addCriterion("totalAmt >", value, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtGreaterThanOrEqualTo(String value) {
            addCriterion("totalAmt >=", value, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtLessThan(String value) {
            addCriterion("totalAmt <", value, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtLessThanOrEqualTo(String value) {
            addCriterion("totalAmt <=", value, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtLike(String value) {
            addCriterion("totalAmt like", value, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtNotLike(String value) {
            addCriterion("totalAmt not like", value, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtIn(List<String> values) {
            addCriterion("totalAmt in", values, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtNotIn(List<String> values) {
            addCriterion("totalAmt not in", values, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtBetween(String value1, String value2) {
            addCriterion("totalAmt between", value1, value2, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtNotBetween(String value1, String value2) {
            addCriterion("totalAmt not between", value1, value2, "totalamt");
            return (Criteria) this;
        }

        public Criteria andSuccnumIsNull() {
            addCriterion("succNum is null");
            return (Criteria) this;
        }

        public Criteria andSuccnumIsNotNull() {
            addCriterion("succNum is not null");
            return (Criteria) this;
        }

        public Criteria andSuccnumEqualTo(String value) {
            addCriterion("succNum =", value, "succnum");
            return (Criteria) this;
        }

        public Criteria andSuccnumNotEqualTo(String value) {
            addCriterion("succNum <>", value, "succnum");
            return (Criteria) this;
        }

        public Criteria andSuccnumGreaterThan(String value) {
            addCriterion("succNum >", value, "succnum");
            return (Criteria) this;
        }

        public Criteria andSuccnumGreaterThanOrEqualTo(String value) {
            addCriterion("succNum >=", value, "succnum");
            return (Criteria) this;
        }

        public Criteria andSuccnumLessThan(String value) {
            addCriterion("succNum <", value, "succnum");
            return (Criteria) this;
        }

        public Criteria andSuccnumLessThanOrEqualTo(String value) {
            addCriterion("succNum <=", value, "succnum");
            return (Criteria) this;
        }

        public Criteria andSuccnumLike(String value) {
            addCriterion("succNum like", value, "succnum");
            return (Criteria) this;
        }

        public Criteria andSuccnumNotLike(String value) {
            addCriterion("succNum not like", value, "succnum");
            return (Criteria) this;
        }

        public Criteria andSuccnumIn(List<String> values) {
            addCriterion("succNum in", values, "succnum");
            return (Criteria) this;
        }

        public Criteria andSuccnumNotIn(List<String> values) {
            addCriterion("succNum not in", values, "succnum");
            return (Criteria) this;
        }

        public Criteria andSuccnumBetween(String value1, String value2) {
            addCriterion("succNum between", value1, value2, "succnum");
            return (Criteria) this;
        }

        public Criteria andSuccnumNotBetween(String value1, String value2) {
            addCriterion("succNum not between", value1, value2, "succnum");
            return (Criteria) this;
        }

        public Criteria andFailnumIsNull() {
            addCriterion("failNum is null");
            return (Criteria) this;
        }

        public Criteria andFailnumIsNotNull() {
            addCriterion("failNum is not null");
            return (Criteria) this;
        }

        public Criteria andFailnumEqualTo(String value) {
            addCriterion("failNum =", value, "failnum");
            return (Criteria) this;
        }

        public Criteria andFailnumNotEqualTo(String value) {
            addCriterion("failNum <>", value, "failnum");
            return (Criteria) this;
        }

        public Criteria andFailnumGreaterThan(String value) {
            addCriterion("failNum >", value, "failnum");
            return (Criteria) this;
        }

        public Criteria andFailnumGreaterThanOrEqualTo(String value) {
            addCriterion("failNum >=", value, "failnum");
            return (Criteria) this;
        }

        public Criteria andFailnumLessThan(String value) {
            addCriterion("failNum <", value, "failnum");
            return (Criteria) this;
        }

        public Criteria andFailnumLessThanOrEqualTo(String value) {
            addCriterion("failNum <=", value, "failnum");
            return (Criteria) this;
        }

        public Criteria andFailnumLike(String value) {
            addCriterion("failNum like", value, "failnum");
            return (Criteria) this;
        }

        public Criteria andFailnumNotLike(String value) {
            addCriterion("failNum not like", value, "failnum");
            return (Criteria) this;
        }

        public Criteria andFailnumIn(List<String> values) {
            addCriterion("failNum in", values, "failnum");
            return (Criteria) this;
        }

        public Criteria andFailnumNotIn(List<String> values) {
            addCriterion("failNum not in", values, "failnum");
            return (Criteria) this;
        }

        public Criteria andFailnumBetween(String value1, String value2) {
            addCriterion("failNum between", value1, value2, "failnum");
            return (Criteria) this;
        }

        public Criteria andFailnumNotBetween(String value1, String value2) {
            addCriterion("failNum not between", value1, value2, "failnum");
            return (Criteria) this;
        }

        public Criteria andSuccamtIsNull() {
            addCriterion("succAmt is null");
            return (Criteria) this;
        }

        public Criteria andSuccamtIsNotNull() {
            addCriterion("succAmt is not null");
            return (Criteria) this;
        }

        public Criteria andSuccamtEqualTo(String value) {
            addCriterion("succAmt =", value, "succamt");
            return (Criteria) this;
        }

        public Criteria andSuccamtNotEqualTo(String value) {
            addCriterion("succAmt <>", value, "succamt");
            return (Criteria) this;
        }

        public Criteria andSuccamtGreaterThan(String value) {
            addCriterion("succAmt >", value, "succamt");
            return (Criteria) this;
        }

        public Criteria andSuccamtGreaterThanOrEqualTo(String value) {
            addCriterion("succAmt >=", value, "succamt");
            return (Criteria) this;
        }

        public Criteria andSuccamtLessThan(String value) {
            addCriterion("succAmt <", value, "succamt");
            return (Criteria) this;
        }

        public Criteria andSuccamtLessThanOrEqualTo(String value) {
            addCriterion("succAmt <=", value, "succamt");
            return (Criteria) this;
        }

        public Criteria andSuccamtLike(String value) {
            addCriterion("succAmt like", value, "succamt");
            return (Criteria) this;
        }

        public Criteria andSuccamtNotLike(String value) {
            addCriterion("succAmt not like", value, "succamt");
            return (Criteria) this;
        }

        public Criteria andSuccamtIn(List<String> values) {
            addCriterion("succAmt in", values, "succamt");
            return (Criteria) this;
        }

        public Criteria andSuccamtNotIn(List<String> values) {
            addCriterion("succAmt not in", values, "succamt");
            return (Criteria) this;
        }

        public Criteria andSuccamtBetween(String value1, String value2) {
            addCriterion("succAmt between", value1, value2, "succamt");
            return (Criteria) this;
        }

        public Criteria andSuccamtNotBetween(String value1, String value2) {
            addCriterion("succAmt not between", value1, value2, "succamt");
            return (Criteria) this;
        }

        public Criteria andFailamtIsNull() {
            addCriterion("failAmt is null");
            return (Criteria) this;
        }

        public Criteria andFailamtIsNotNull() {
            addCriterion("failAmt is not null");
            return (Criteria) this;
        }

        public Criteria andFailamtEqualTo(String value) {
            addCriterion("failAmt =", value, "failamt");
            return (Criteria) this;
        }

        public Criteria andFailamtNotEqualTo(String value) {
            addCriterion("failAmt <>", value, "failamt");
            return (Criteria) this;
        }

        public Criteria andFailamtGreaterThan(String value) {
            addCriterion("failAmt >", value, "failamt");
            return (Criteria) this;
        }

        public Criteria andFailamtGreaterThanOrEqualTo(String value) {
            addCriterion("failAmt >=", value, "failamt");
            return (Criteria) this;
        }

        public Criteria andFailamtLessThan(String value) {
            addCriterion("failAmt <", value, "failamt");
            return (Criteria) this;
        }

        public Criteria andFailamtLessThanOrEqualTo(String value) {
            addCriterion("failAmt <=", value, "failamt");
            return (Criteria) this;
        }

        public Criteria andFailamtLike(String value) {
            addCriterion("failAmt like", value, "failamt");
            return (Criteria) this;
        }

        public Criteria andFailamtNotLike(String value) {
            addCriterion("failAmt not like", value, "failamt");
            return (Criteria) this;
        }

        public Criteria andFailamtIn(List<String> values) {
            addCriterion("failAmt in", values, "failamt");
            return (Criteria) this;
        }

        public Criteria andFailamtNotIn(List<String> values) {
            addCriterion("failAmt not in", values, "failamt");
            return (Criteria) this;
        }

        public Criteria andFailamtBetween(String value1, String value2) {
            addCriterion("failAmt between", value1, value2, "failamt");
            return (Criteria) this;
        }

        public Criteria andFailamtNotBetween(String value1, String value2) {
            addCriterion("failAmt not between", value1, value2, "failamt");
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

        public Criteria andUploadresptimeIsNull() {
            addCriterion("uploadRespTime is null");
            return (Criteria) this;
        }

        public Criteria andUploadresptimeIsNotNull() {
            addCriterion("uploadRespTime is not null");
            return (Criteria) this;
        }

        public Criteria andUploadresptimeEqualTo(String value) {
            addCriterion("uploadRespTime =", value, "uploadresptime");
            return (Criteria) this;
        }

        public Criteria andUploadresptimeNotEqualTo(String value) {
            addCriterion("uploadRespTime <>", value, "uploadresptime");
            return (Criteria) this;
        }

        public Criteria andUploadresptimeGreaterThan(String value) {
            addCriterion("uploadRespTime >", value, "uploadresptime");
            return (Criteria) this;
        }

        public Criteria andUploadresptimeGreaterThanOrEqualTo(String value) {
            addCriterion("uploadRespTime >=", value, "uploadresptime");
            return (Criteria) this;
        }

        public Criteria andUploadresptimeLessThan(String value) {
            addCriterion("uploadRespTime <", value, "uploadresptime");
            return (Criteria) this;
        }

        public Criteria andUploadresptimeLessThanOrEqualTo(String value) {
            addCriterion("uploadRespTime <=", value, "uploadresptime");
            return (Criteria) this;
        }

        public Criteria andUploadresptimeLike(String value) {
            addCriterion("uploadRespTime like", value, "uploadresptime");
            return (Criteria) this;
        }

        public Criteria andUploadresptimeNotLike(String value) {
            addCriterion("uploadRespTime not like", value, "uploadresptime");
            return (Criteria) this;
        }

        public Criteria andUploadresptimeIn(List<String> values) {
            addCriterion("uploadRespTime in", values, "uploadresptime");
            return (Criteria) this;
        }

        public Criteria andUploadresptimeNotIn(List<String> values) {
            addCriterion("uploadRespTime not in", values, "uploadresptime");
            return (Criteria) this;
        }

        public Criteria andUploadresptimeBetween(String value1, String value2) {
            addCriterion("uploadRespTime between", value1, value2, "uploadresptime");
            return (Criteria) this;
        }

        public Criteria andUploadresptimeNotBetween(String value1, String value2) {
            addCriterion("uploadRespTime not between", value1, value2, "uploadresptime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeIsNull() {
            addCriterion("noticeTime is null");
            return (Criteria) this;
        }

        public Criteria andNoticetimeIsNotNull() {
            addCriterion("noticeTime is not null");
            return (Criteria) this;
        }

        public Criteria andNoticetimeEqualTo(String value) {
            addCriterion("noticeTime =", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeNotEqualTo(String value) {
            addCriterion("noticeTime <>", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeGreaterThan(String value) {
            addCriterion("noticeTime >", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeGreaterThanOrEqualTo(String value) {
            addCriterion("noticeTime >=", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeLessThan(String value) {
            addCriterion("noticeTime <", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeLessThanOrEqualTo(String value) {
            addCriterion("noticeTime <=", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeLike(String value) {
            addCriterion("noticeTime like", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeNotLike(String value) {
            addCriterion("noticeTime not like", value, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeIn(List<String> values) {
            addCriterion("noticeTime in", values, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeNotIn(List<String> values) {
            addCriterion("noticeTime not in", values, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeBetween(String value1, String value2) {
            addCriterion("noticeTime between", value1, value2, "noticetime");
            return (Criteria) this;
        }

        public Criteria andNoticetimeNotBetween(String value1, String value2) {
            addCriterion("noticeTime not between", value1, value2, "noticetime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIsNull() {
            addCriterion("finishTime is null");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIsNotNull() {
            addCriterion("finishTime is not null");
            return (Criteria) this;
        }

        public Criteria andFinishtimeEqualTo(String value) {
            addCriterion("finishTime =", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotEqualTo(String value) {
            addCriterion("finishTime <>", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeGreaterThan(String value) {
            addCriterion("finishTime >", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeGreaterThanOrEqualTo(String value) {
            addCriterion("finishTime >=", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeLessThan(String value) {
            addCriterion("finishTime <", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeLessThanOrEqualTo(String value) {
            addCriterion("finishTime <=", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeLike(String value) {
            addCriterion("finishTime like", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotLike(String value) {
            addCriterion("finishTime not like", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIn(List<String> values) {
            addCriterion("finishTime in", values, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotIn(List<String> values) {
            addCriterion("finishTime not in", values, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeBetween(String value1, String value2) {
            addCriterion("finishTime between", value1, value2, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotBetween(String value1, String value2) {
            addCriterion("finishTime not between", value1, value2, "finishtime");
            return (Criteria) this;
        }

        public Criteria andUploadrespcodeIsNull() {
            addCriterion("uploadRespCode is null");
            return (Criteria) this;
        }

        public Criteria andUploadrespcodeIsNotNull() {
            addCriterion("uploadRespCode is not null");
            return (Criteria) this;
        }

        public Criteria andUploadrespcodeEqualTo(String value) {
            addCriterion("uploadRespCode =", value, "uploadrespcode");
            return (Criteria) this;
        }

        public Criteria andUploadrespcodeNotEqualTo(String value) {
            addCriterion("uploadRespCode <>", value, "uploadrespcode");
            return (Criteria) this;
        }

        public Criteria andUploadrespcodeGreaterThan(String value) {
            addCriterion("uploadRespCode >", value, "uploadrespcode");
            return (Criteria) this;
        }

        public Criteria andUploadrespcodeGreaterThanOrEqualTo(String value) {
            addCriterion("uploadRespCode >=", value, "uploadrespcode");
            return (Criteria) this;
        }

        public Criteria andUploadrespcodeLessThan(String value) {
            addCriterion("uploadRespCode <", value, "uploadrespcode");
            return (Criteria) this;
        }

        public Criteria andUploadrespcodeLessThanOrEqualTo(String value) {
            addCriterion("uploadRespCode <=", value, "uploadrespcode");
            return (Criteria) this;
        }

        public Criteria andUploadrespcodeLike(String value) {
            addCriterion("uploadRespCode like", value, "uploadrespcode");
            return (Criteria) this;
        }

        public Criteria andUploadrespcodeNotLike(String value) {
            addCriterion("uploadRespCode not like", value, "uploadrespcode");
            return (Criteria) this;
        }

        public Criteria andUploadrespcodeIn(List<String> values) {
            addCriterion("uploadRespCode in", values, "uploadrespcode");
            return (Criteria) this;
        }

        public Criteria andUploadrespcodeNotIn(List<String> values) {
            addCriterion("uploadRespCode not in", values, "uploadrespcode");
            return (Criteria) this;
        }

        public Criteria andUploadrespcodeBetween(String value1, String value2) {
            addCriterion("uploadRespCode between", value1, value2, "uploadrespcode");
            return (Criteria) this;
        }

        public Criteria andUploadrespcodeNotBetween(String value1, String value2) {
            addCriterion("uploadRespCode not between", value1, value2, "uploadrespcode");
            return (Criteria) this;
        }

        public Criteria andUploadrespmessageIsNull() {
            addCriterion("uploadRespMessage is null");
            return (Criteria) this;
        }

        public Criteria andUploadrespmessageIsNotNull() {
            addCriterion("uploadRespMessage is not null");
            return (Criteria) this;
        }

        public Criteria andUploadrespmessageEqualTo(String value) {
            addCriterion("uploadRespMessage =", value, "uploadrespmessage");
            return (Criteria) this;
        }

        public Criteria andUploadrespmessageNotEqualTo(String value) {
            addCriterion("uploadRespMessage <>", value, "uploadrespmessage");
            return (Criteria) this;
        }

        public Criteria andUploadrespmessageGreaterThan(String value) {
            addCriterion("uploadRespMessage >", value, "uploadrespmessage");
            return (Criteria) this;
        }

        public Criteria andUploadrespmessageGreaterThanOrEqualTo(String value) {
            addCriterion("uploadRespMessage >=", value, "uploadrespmessage");
            return (Criteria) this;
        }

        public Criteria andUploadrespmessageLessThan(String value) {
            addCriterion("uploadRespMessage <", value, "uploadrespmessage");
            return (Criteria) this;
        }

        public Criteria andUploadrespmessageLessThanOrEqualTo(String value) {
            addCriterion("uploadRespMessage <=", value, "uploadrespmessage");
            return (Criteria) this;
        }

        public Criteria andUploadrespmessageLike(String value) {
            addCriterion("uploadRespMessage like", value, "uploadrespmessage");
            return (Criteria) this;
        }

        public Criteria andUploadrespmessageNotLike(String value) {
            addCriterion("uploadRespMessage not like", value, "uploadrespmessage");
            return (Criteria) this;
        }

        public Criteria andUploadrespmessageIn(List<String> values) {
            addCriterion("uploadRespMessage in", values, "uploadrespmessage");
            return (Criteria) this;
        }

        public Criteria andUploadrespmessageNotIn(List<String> values) {
            addCriterion("uploadRespMessage not in", values, "uploadrespmessage");
            return (Criteria) this;
        }

        public Criteria andUploadrespmessageBetween(String value1, String value2) {
            addCriterion("uploadRespMessage between", value1, value2, "uploadrespmessage");
            return (Criteria) this;
        }

        public Criteria andUploadrespmessageNotBetween(String value1, String value2) {
            addCriterion("uploadRespMessage not between", value1, value2, "uploadrespmessage");
            return (Criteria) this;
        }

        public Criteria andHprespcodeIsNull() {
            addCriterion("hpRespCode is null");
            return (Criteria) this;
        }

        public Criteria andHprespcodeIsNotNull() {
            addCriterion("hpRespCode is not null");
            return (Criteria) this;
        }

        public Criteria andHprespcodeEqualTo(String value) {
            addCriterion("hpRespCode =", value, "hprespcode");
            return (Criteria) this;
        }

        public Criteria andHprespcodeNotEqualTo(String value) {
            addCriterion("hpRespCode <>", value, "hprespcode");
            return (Criteria) this;
        }

        public Criteria andHprespcodeGreaterThan(String value) {
            addCriterion("hpRespCode >", value, "hprespcode");
            return (Criteria) this;
        }

        public Criteria andHprespcodeGreaterThanOrEqualTo(String value) {
            addCriterion("hpRespCode >=", value, "hprespcode");
            return (Criteria) this;
        }

        public Criteria andHprespcodeLessThan(String value) {
            addCriterion("hpRespCode <", value, "hprespcode");
            return (Criteria) this;
        }

        public Criteria andHprespcodeLessThanOrEqualTo(String value) {
            addCriterion("hpRespCode <=", value, "hprespcode");
            return (Criteria) this;
        }

        public Criteria andHprespcodeLike(String value) {
            addCriterion("hpRespCode like", value, "hprespcode");
            return (Criteria) this;
        }

        public Criteria andHprespcodeNotLike(String value) {
            addCriterion("hpRespCode not like", value, "hprespcode");
            return (Criteria) this;
        }

        public Criteria andHprespcodeIn(List<String> values) {
            addCriterion("hpRespCode in", values, "hprespcode");
            return (Criteria) this;
        }

        public Criteria andHprespcodeNotIn(List<String> values) {
            addCriterion("hpRespCode not in", values, "hprespcode");
            return (Criteria) this;
        }

        public Criteria andHprespcodeBetween(String value1, String value2) {
            addCriterion("hpRespCode between", value1, value2, "hprespcode");
            return (Criteria) this;
        }

        public Criteria andHprespcodeNotBetween(String value1, String value2) {
            addCriterion("hpRespCode not between", value1, value2, "hprespcode");
            return (Criteria) this;
        }

        public Criteria andHprespmessageIsNull() {
            addCriterion("hpRespMessage is null");
            return (Criteria) this;
        }

        public Criteria andHprespmessageIsNotNull() {
            addCriterion("hpRespMessage is not null");
            return (Criteria) this;
        }

        public Criteria andHprespmessageEqualTo(String value) {
            addCriterion("hpRespMessage =", value, "hprespmessage");
            return (Criteria) this;
        }

        public Criteria andHprespmessageNotEqualTo(String value) {
            addCriterion("hpRespMessage <>", value, "hprespmessage");
            return (Criteria) this;
        }

        public Criteria andHprespmessageGreaterThan(String value) {
            addCriterion("hpRespMessage >", value, "hprespmessage");
            return (Criteria) this;
        }

        public Criteria andHprespmessageGreaterThanOrEqualTo(String value) {
            addCriterion("hpRespMessage >=", value, "hprespmessage");
            return (Criteria) this;
        }

        public Criteria andHprespmessageLessThan(String value) {
            addCriterion("hpRespMessage <", value, "hprespmessage");
            return (Criteria) this;
        }

        public Criteria andHprespmessageLessThanOrEqualTo(String value) {
            addCriterion("hpRespMessage <=", value, "hprespmessage");
            return (Criteria) this;
        }

        public Criteria andHprespmessageLike(String value) {
            addCriterion("hpRespMessage like", value, "hprespmessage");
            return (Criteria) this;
        }

        public Criteria andHprespmessageNotLike(String value) {
            addCriterion("hpRespMessage not like", value, "hprespmessage");
            return (Criteria) this;
        }

        public Criteria andHprespmessageIn(List<String> values) {
            addCriterion("hpRespMessage in", values, "hprespmessage");
            return (Criteria) this;
        }

        public Criteria andHprespmessageNotIn(List<String> values) {
            addCriterion("hpRespMessage not in", values, "hprespmessage");
            return (Criteria) this;
        }

        public Criteria andHprespmessageBetween(String value1, String value2) {
            addCriterion("hpRespMessage between", value1, value2, "hprespmessage");
            return (Criteria) this;
        }

        public Criteria andHprespmessageNotBetween(String value1, String value2) {
            addCriterion("hpRespMessage not between", value1, value2, "hprespmessage");
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