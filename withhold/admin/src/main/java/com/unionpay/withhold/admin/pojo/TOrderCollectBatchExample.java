package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TOrderCollectBatchExample {
	private int pageNum;
	private int pageSize;
	private int beginRow;
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getBeginRow() {
		// 在mapper.xml使用begin属性时，对其进行计算
		return (pageNum - 1) * pageSize;
	}
	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrderCollectBatchExample() {
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

        public Criteria andCertidIsNull() {
            addCriterion("CERTID is null");
            return (Criteria) this;
        }

        public Criteria andCertidIsNotNull() {
            addCriterion("CERTID is not null");
            return (Criteria) this;
        }

        public Criteria andCertidEqualTo(String value) {
            addCriterion("CERTID =", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotEqualTo(String value) {
            addCriterion("CERTID <>", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidGreaterThan(String value) {
            addCriterion("CERTID >", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidGreaterThanOrEqualTo(String value) {
            addCriterion("CERTID >=", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLessThan(String value) {
            addCriterion("CERTID <", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLessThanOrEqualTo(String value) {
            addCriterion("CERTID <=", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLike(String value) {
            addCriterion("CERTID like", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotLike(String value) {
            addCriterion("CERTID not like", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidIn(List<String> values) {
            addCriterion("CERTID in", values, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotIn(List<String> values) {
            addCriterion("CERTID not in", values, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidBetween(String value1, String value2) {
            addCriterion("CERTID between", value1, value2, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotBetween(String value1, String value2) {
            addCriterion("CERTID not between", value1, value2, "certid");
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

        public Criteria andFactoridIsNull() {
            addCriterion("FACTORID is null");
            return (Criteria) this;
        }

        public Criteria andFactoridIsNotNull() {
            addCriterion("FACTORID is not null");
            return (Criteria) this;
        }

        public Criteria andFactoridEqualTo(String value) {
            addCriterion("FACTORID =", value, "factorid");
            return (Criteria) this;
        }

        public Criteria andFactoridNotEqualTo(String value) {
            addCriterion("FACTORID <>", value, "factorid");
            return (Criteria) this;
        }

        public Criteria andFactoridGreaterThan(String value) {
            addCriterion("FACTORID >", value, "factorid");
            return (Criteria) this;
        }

        public Criteria andFactoridGreaterThanOrEqualTo(String value) {
            addCriterion("FACTORID >=", value, "factorid");
            return (Criteria) this;
        }

        public Criteria andFactoridLessThan(String value) {
            addCriterion("FACTORID <", value, "factorid");
            return (Criteria) this;
        }

        public Criteria andFactoridLessThanOrEqualTo(String value) {
            addCriterion("FACTORID <=", value, "factorid");
            return (Criteria) this;
        }

        public Criteria andFactoridLike(String value) {
            addCriterion("FACTORID like", value, "factorid");
            return (Criteria) this;
        }

        public Criteria andFactoridNotLike(String value) {
            addCriterion("FACTORID not like", value, "factorid");
            return (Criteria) this;
        }

        public Criteria andFactoridIn(List<String> values) {
            addCriterion("FACTORID in", values, "factorid");
            return (Criteria) this;
        }

        public Criteria andFactoridNotIn(List<String> values) {
            addCriterion("FACTORID not in", values, "factorid");
            return (Criteria) this;
        }

        public Criteria andFactoridBetween(String value1, String value2) {
            addCriterion("FACTORID between", value1, value2, "factorid");
            return (Criteria) this;
        }

        public Criteria andFactoridNotBetween(String value1, String value2) {
            addCriterion("FACTORID not between", value1, value2, "factorid");
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

        public Criteria andTxndateIsNull() {
            addCriterion("TXNDATE is null");
            return (Criteria) this;
        }

        public Criteria andTxndateIsNotNull() {
            addCriterion("TXNDATE is not null");
            return (Criteria) this;
        }

        public Criteria andTxndateEqualTo(String value) {
            addCriterion("TXNDATE =", value, "txndate");
            return (Criteria) this;
        }

        public Criteria andTxndateNotEqualTo(String value) {
            addCriterion("TXNDATE <>", value, "txndate");
            return (Criteria) this;
        }

        public Criteria andTxndateGreaterThan(String value) {
            addCriterion("TXNDATE >", value, "txndate");
            return (Criteria) this;
        }

        public Criteria andTxndateGreaterThanOrEqualTo(String value) {
            addCriterion("TXNDATE >=", value, "txndate");
            return (Criteria) this;
        }

        public Criteria andTxndateLessThan(String value) {
            addCriterion("TXNDATE <", value, "txndate");
            return (Criteria) this;
        }

        public Criteria andTxndateLessThanOrEqualTo(String value) {
            addCriterion("TXNDATE <=", value, "txndate");
            return (Criteria) this;
        }

        public Criteria andTxndateLike(String value) {
            addCriterion("TXNDATE like", value, "txndate");
            return (Criteria) this;
        }

        public Criteria andTxndateNotLike(String value) {
            addCriterion("TXNDATE not like", value, "txndate");
            return (Criteria) this;
        }

        public Criteria andTxndateIn(List<String> values) {
            addCriterion("TXNDATE in", values, "txndate");
            return (Criteria) this;
        }

        public Criteria andTxndateNotIn(List<String> values) {
            addCriterion("TXNDATE not in", values, "txndate");
            return (Criteria) this;
        }

        public Criteria andTxndateBetween(String value1, String value2) {
            addCriterion("TXNDATE between", value1, value2, "txndate");
            return (Criteria) this;
        }

        public Criteria andTxndateNotBetween(String value1, String value2) {
            addCriterion("TXNDATE not between", value1, value2, "txndate");
            return (Criteria) this;
        }

        public Criteria andTotalqtyIsNull() {
            addCriterion("TOTALQTY is null");
            return (Criteria) this;
        }

        public Criteria andTotalqtyIsNotNull() {
            addCriterion("TOTALQTY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalqtyEqualTo(Long value) {
            addCriterion("TOTALQTY =", value, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyNotEqualTo(Long value) {
            addCriterion("TOTALQTY <>", value, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyGreaterThan(Long value) {
            addCriterion("TOTALQTY >", value, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTALQTY >=", value, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyLessThan(Long value) {
            addCriterion("TOTALQTY <", value, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyLessThanOrEqualTo(Long value) {
            addCriterion("TOTALQTY <=", value, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyIn(List<Long> values) {
            addCriterion("TOTALQTY in", values, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyNotIn(List<Long> values) {
            addCriterion("TOTALQTY not in", values, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyBetween(Long value1, Long value2) {
            addCriterion("TOTALQTY between", value1, value2, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalqtyNotBetween(Long value1, Long value2) {
            addCriterion("TOTALQTY not between", value1, value2, "totalqty");
            return (Criteria) this;
        }

        public Criteria andTotalamtIsNull() {
            addCriterion("TOTALAMT is null");
            return (Criteria) this;
        }

        public Criteria andTotalamtIsNotNull() {
            addCriterion("TOTALAMT is not null");
            return (Criteria) this;
        }

        public Criteria andTotalamtEqualTo(Long value) {
            addCriterion("TOTALAMT =", value, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtNotEqualTo(Long value) {
            addCriterion("TOTALAMT <>", value, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtGreaterThan(Long value) {
            addCriterion("TOTALAMT >", value, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTALAMT >=", value, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtLessThan(Long value) {
            addCriterion("TOTALAMT <", value, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtLessThanOrEqualTo(Long value) {
            addCriterion("TOTALAMT <=", value, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtIn(List<Long> values) {
            addCriterion("TOTALAMT in", values, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtNotIn(List<Long> values) {
            addCriterion("TOTALAMT not in", values, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtBetween(Long value1, Long value2) {
            addCriterion("TOTALAMT between", value1, value2, "totalamt");
            return (Criteria) this;
        }

        public Criteria andTotalamtNotBetween(Long value1, Long value2) {
            addCriterion("TOTALAMT not between", value1, value2, "totalamt");
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

        public Criteria andOrderfinshtimeIsNull() {
            addCriterion("ORDERFINSHTIME is null");
            return (Criteria) this;
        }

        public Criteria andOrderfinshtimeIsNotNull() {
            addCriterion("ORDERFINSHTIME is not null");
            return (Criteria) this;
        }

        public Criteria andOrderfinshtimeEqualTo(String value) {
            addCriterion("ORDERFINSHTIME =", value, "orderfinshtime");
            return (Criteria) this;
        }

        public Criteria andOrderfinshtimeNotEqualTo(String value) {
            addCriterion("ORDERFINSHTIME <>", value, "orderfinshtime");
            return (Criteria) this;
        }

        public Criteria andOrderfinshtimeGreaterThan(String value) {
            addCriterion("ORDERFINSHTIME >", value, "orderfinshtime");
            return (Criteria) this;
        }

        public Criteria andOrderfinshtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDERFINSHTIME >=", value, "orderfinshtime");
            return (Criteria) this;
        }

        public Criteria andOrderfinshtimeLessThan(String value) {
            addCriterion("ORDERFINSHTIME <", value, "orderfinshtime");
            return (Criteria) this;
        }

        public Criteria andOrderfinshtimeLessThanOrEqualTo(String value) {
            addCriterion("ORDERFINSHTIME <=", value, "orderfinshtime");
            return (Criteria) this;
        }

        public Criteria andOrderfinshtimeLike(String value) {
            addCriterion("ORDERFINSHTIME like", value, "orderfinshtime");
            return (Criteria) this;
        }

        public Criteria andOrderfinshtimeNotLike(String value) {
            addCriterion("ORDERFINSHTIME not like", value, "orderfinshtime");
            return (Criteria) this;
        }

        public Criteria andOrderfinshtimeIn(List<String> values) {
            addCriterion("ORDERFINSHTIME in", values, "orderfinshtime");
            return (Criteria) this;
        }

        public Criteria andOrderfinshtimeNotIn(List<String> values) {
            addCriterion("ORDERFINSHTIME not in", values, "orderfinshtime");
            return (Criteria) this;
        }

        public Criteria andOrderfinshtimeBetween(String value1, String value2) {
            addCriterion("ORDERFINSHTIME between", value1, value2, "orderfinshtime");
            return (Criteria) this;
        }

        public Criteria andOrderfinshtimeNotBetween(String value1, String value2) {
            addCriterion("ORDERFINSHTIME not between", value1, value2, "orderfinshtime");
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