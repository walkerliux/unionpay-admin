package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TTxnsLogExample {
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

    public TTxnsLogExample() {
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

        public Criteria andApptypeIsNull() {
            addCriterion("APPTYPE is null");
            return (Criteria) this;
        }

        public Criteria andApptypeIsNotNull() {
            addCriterion("APPTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andApptypeEqualTo(String value) {
            addCriterion("APPTYPE =", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotEqualTo(String value) {
            addCriterion("APPTYPE <>", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeGreaterThan(String value) {
            addCriterion("APPTYPE >", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeGreaterThanOrEqualTo(String value) {
            addCriterion("APPTYPE >=", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLessThan(String value) {
            addCriterion("APPTYPE <", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLessThanOrEqualTo(String value) {
            addCriterion("APPTYPE <=", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLike(String value) {
            addCriterion("APPTYPE like", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotLike(String value) {
            addCriterion("APPTYPE not like", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeIn(List<String> values) {
            addCriterion("APPTYPE in", values, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotIn(List<String> values) {
            addCriterion("APPTYPE not in", values, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeBetween(String value1, String value2) {
            addCriterion("APPTYPE between", value1, value2, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotBetween(String value1, String value2) {
            addCriterion("APPTYPE not between", value1, value2, "apptype");
            return (Criteria) this;
        }

        public Criteria andBusitypeIsNull() {
            addCriterion("BUSITYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusitypeIsNotNull() {
            addCriterion("BUSITYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusitypeEqualTo(String value) {
            addCriterion("BUSITYPE =", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeNotEqualTo(String value) {
            addCriterion("BUSITYPE <>", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeGreaterThan(String value) {
            addCriterion("BUSITYPE >", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSITYPE >=", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeLessThan(String value) {
            addCriterion("BUSITYPE <", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeLessThanOrEqualTo(String value) {
            addCriterion("BUSITYPE <=", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeLike(String value) {
            addCriterion("BUSITYPE like", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeNotLike(String value) {
            addCriterion("BUSITYPE not like", value, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeIn(List<String> values) {
            addCriterion("BUSITYPE in", values, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeNotIn(List<String> values) {
            addCriterion("BUSITYPE not in", values, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeBetween(String value1, String value2) {
            addCriterion("BUSITYPE between", value1, value2, "busitype");
            return (Criteria) this;
        }

        public Criteria andBusitypeNotBetween(String value1, String value2) {
            addCriterion("BUSITYPE not between", value1, value2, "busitype");
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

        public Criteria andTradcommIsNull() {
            addCriterion("TRADCOMM is null");
            return (Criteria) this;
        }

        public Criteria andTradcommIsNotNull() {
            addCriterion("TRADCOMM is not null");
            return (Criteria) this;
        }

        public Criteria andTradcommEqualTo(Long value) {
            addCriterion("TRADCOMM =", value, "tradcomm");
            return (Criteria) this;
        }

        public Criteria andTradcommNotEqualTo(Long value) {
            addCriterion("TRADCOMM <>", value, "tradcomm");
            return (Criteria) this;
        }

        public Criteria andTradcommGreaterThan(Long value) {
            addCriterion("TRADCOMM >", value, "tradcomm");
            return (Criteria) this;
        }

        public Criteria andTradcommGreaterThanOrEqualTo(Long value) {
            addCriterion("TRADCOMM >=", value, "tradcomm");
            return (Criteria) this;
        }

        public Criteria andTradcommLessThan(Long value) {
            addCriterion("TRADCOMM <", value, "tradcomm");
            return (Criteria) this;
        }

        public Criteria andTradcommLessThanOrEqualTo(Long value) {
            addCriterion("TRADCOMM <=", value, "tradcomm");
            return (Criteria) this;
        }

        public Criteria andTradcommIn(List<Long> values) {
            addCriterion("TRADCOMM in", values, "tradcomm");
            return (Criteria) this;
        }

        public Criteria andTradcommNotIn(List<Long> values) {
            addCriterion("TRADCOMM not in", values, "tradcomm");
            return (Criteria) this;
        }

        public Criteria andTradcommBetween(Long value1, Long value2) {
            addCriterion("TRADCOMM between", value1, value2, "tradcomm");
            return (Criteria) this;
        }

        public Criteria andTradcommNotBetween(Long value1, Long value2) {
            addCriterion("TRADCOMM not between", value1, value2, "tradcomm");
            return (Criteria) this;
        }

        public Criteria andChnlfeeIsNull() {
            addCriterion("CHNLFEE is null");
            return (Criteria) this;
        }

        public Criteria andChnlfeeIsNotNull() {
            addCriterion("CHNLFEE is not null");
            return (Criteria) this;
        }

        public Criteria andChnlfeeEqualTo(String value) {
            addCriterion("CHNLFEE =", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeNotEqualTo(String value) {
            addCriterion("CHNLFEE <>", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeGreaterThan(String value) {
            addCriterion("CHNLFEE >", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeGreaterThanOrEqualTo(String value) {
            addCriterion("CHNLFEE >=", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeLessThan(String value) {
            addCriterion("CHNLFEE <", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeLessThanOrEqualTo(String value) {
            addCriterion("CHNLFEE <=", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeLike(String value) {
            addCriterion("CHNLFEE like", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeNotLike(String value) {
            addCriterion("CHNLFEE not like", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeIn(List<String> values) {
            addCriterion("CHNLFEE in", values, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeNotIn(List<String> values) {
            addCriterion("CHNLFEE not in", values, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeBetween(String value1, String value2) {
            addCriterion("CHNLFEE between", value1, value2, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeNotBetween(String value1, String value2) {
            addCriterion("CHNLFEE not between", value1, value2, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andCoopfeeIsNull() {
            addCriterion("COOPFEE is null");
            return (Criteria) this;
        }

        public Criteria andCoopfeeIsNotNull() {
            addCriterion("COOPFEE is not null");
            return (Criteria) this;
        }

        public Criteria andCoopfeeEqualTo(String value) {
            addCriterion("COOPFEE =", value, "coopfee");
            return (Criteria) this;
        }

        public Criteria andCoopfeeNotEqualTo(String value) {
            addCriterion("COOPFEE <>", value, "coopfee");
            return (Criteria) this;
        }

        public Criteria andCoopfeeGreaterThan(String value) {
            addCriterion("COOPFEE >", value, "coopfee");
            return (Criteria) this;
        }

        public Criteria andCoopfeeGreaterThanOrEqualTo(String value) {
            addCriterion("COOPFEE >=", value, "coopfee");
            return (Criteria) this;
        }

        public Criteria andCoopfeeLessThan(String value) {
            addCriterion("COOPFEE <", value, "coopfee");
            return (Criteria) this;
        }

        public Criteria andCoopfeeLessThanOrEqualTo(String value) {
            addCriterion("COOPFEE <=", value, "coopfee");
            return (Criteria) this;
        }

        public Criteria andCoopfeeLike(String value) {
            addCriterion("COOPFEE like", value, "coopfee");
            return (Criteria) this;
        }

        public Criteria andCoopfeeNotLike(String value) {
            addCriterion("COOPFEE not like", value, "coopfee");
            return (Criteria) this;
        }

        public Criteria andCoopfeeIn(List<String> values) {
            addCriterion("COOPFEE in", values, "coopfee");
            return (Criteria) this;
        }

        public Criteria andCoopfeeNotIn(List<String> values) {
            addCriterion("COOPFEE not in", values, "coopfee");
            return (Criteria) this;
        }

        public Criteria andCoopfeeBetween(String value1, String value2) {
            addCriterion("COOPFEE between", value1, value2, "coopfee");
            return (Criteria) this;
        }

        public Criteria andCoopfeeNotBetween(String value1, String value2) {
            addCriterion("COOPFEE not between", value1, value2, "coopfee");
            return (Criteria) this;
        }

        public Criteria andTxnfeeIsNull() {
            addCriterion("TXNFEE is null");
            return (Criteria) this;
        }

        public Criteria andTxnfeeIsNotNull() {
            addCriterion("TXNFEE is not null");
            return (Criteria) this;
        }

        public Criteria andTxnfeeEqualTo(Long value) {
            addCriterion("TXNFEE =", value, "txnfee");
            return (Criteria) this;
        }

        public Criteria andTxnfeeNotEqualTo(Long value) {
            addCriterion("TXNFEE <>", value, "txnfee");
            return (Criteria) this;
        }

        public Criteria andTxnfeeGreaterThan(Long value) {
            addCriterion("TXNFEE >", value, "txnfee");
            return (Criteria) this;
        }

        public Criteria andTxnfeeGreaterThanOrEqualTo(Long value) {
            addCriterion("TXNFEE >=", value, "txnfee");
            return (Criteria) this;
        }

        public Criteria andTxnfeeLessThan(Long value) {
            addCriterion("TXNFEE <", value, "txnfee");
            return (Criteria) this;
        }

        public Criteria andTxnfeeLessThanOrEqualTo(Long value) {
            addCriterion("TXNFEE <=", value, "txnfee");
            return (Criteria) this;
        }

        public Criteria andTxnfeeIn(List<Long> values) {
            addCriterion("TXNFEE in", values, "txnfee");
            return (Criteria) this;
        }

        public Criteria andTxnfeeNotIn(List<Long> values) {
            addCriterion("TXNFEE not in", values, "txnfee");
            return (Criteria) this;
        }

        public Criteria andTxnfeeBetween(Long value1, Long value2) {
            addCriterion("TXNFEE between", value1, value2, "txnfee");
            return (Criteria) this;
        }

        public Criteria andTxnfeeNotBetween(Long value1, Long value2) {
            addCriterion("TXNFEE not between", value1, value2, "txnfee");
            return (Criteria) this;
        }

        public Criteria andRiskverIsNull() {
            addCriterion("RISKVER is null");
            return (Criteria) this;
        }

        public Criteria andRiskverIsNotNull() {
            addCriterion("RISKVER is not null");
            return (Criteria) this;
        }

        public Criteria andRiskverEqualTo(String value) {
            addCriterion("RISKVER =", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverNotEqualTo(String value) {
            addCriterion("RISKVER <>", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverGreaterThan(String value) {
            addCriterion("RISKVER >", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverGreaterThanOrEqualTo(String value) {
            addCriterion("RISKVER >=", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverLessThan(String value) {
            addCriterion("RISKVER <", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverLessThanOrEqualTo(String value) {
            addCriterion("RISKVER <=", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverLike(String value) {
            addCriterion("RISKVER like", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverNotLike(String value) {
            addCriterion("RISKVER not like", value, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverIn(List<String> values) {
            addCriterion("RISKVER in", values, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverNotIn(List<String> values) {
            addCriterion("RISKVER not in", values, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverBetween(String value1, String value2) {
            addCriterion("RISKVER between", value1, value2, "riskver");
            return (Criteria) this;
        }

        public Criteria andRiskverNotBetween(String value1, String value2) {
            addCriterion("RISKVER not between", value1, value2, "riskver");
            return (Criteria) this;
        }

        public Criteria andSplitverIsNull() {
            addCriterion("SPLITVER is null");
            return (Criteria) this;
        }

        public Criteria andSplitverIsNotNull() {
            addCriterion("SPLITVER is not null");
            return (Criteria) this;
        }

        public Criteria andSplitverEqualTo(String value) {
            addCriterion("SPLITVER =", value, "splitver");
            return (Criteria) this;
        }

        public Criteria andSplitverNotEqualTo(String value) {
            addCriterion("SPLITVER <>", value, "splitver");
            return (Criteria) this;
        }

        public Criteria andSplitverGreaterThan(String value) {
            addCriterion("SPLITVER >", value, "splitver");
            return (Criteria) this;
        }

        public Criteria andSplitverGreaterThanOrEqualTo(String value) {
            addCriterion("SPLITVER >=", value, "splitver");
            return (Criteria) this;
        }

        public Criteria andSplitverLessThan(String value) {
            addCriterion("SPLITVER <", value, "splitver");
            return (Criteria) this;
        }

        public Criteria andSplitverLessThanOrEqualTo(String value) {
            addCriterion("SPLITVER <=", value, "splitver");
            return (Criteria) this;
        }

        public Criteria andSplitverLike(String value) {
            addCriterion("SPLITVER like", value, "splitver");
            return (Criteria) this;
        }

        public Criteria andSplitverNotLike(String value) {
            addCriterion("SPLITVER not like", value, "splitver");
            return (Criteria) this;
        }

        public Criteria andSplitverIn(List<String> values) {
            addCriterion("SPLITVER in", values, "splitver");
            return (Criteria) this;
        }

        public Criteria andSplitverNotIn(List<String> values) {
            addCriterion("SPLITVER not in", values, "splitver");
            return (Criteria) this;
        }

        public Criteria andSplitverBetween(String value1, String value2) {
            addCriterion("SPLITVER between", value1, value2, "splitver");
            return (Criteria) this;
        }

        public Criteria andSplitverNotBetween(String value1, String value2) {
            addCriterion("SPLITVER not between", value1, value2, "splitver");
            return (Criteria) this;
        }

        public Criteria andFeeverIsNull() {
            addCriterion("FEEVER is null");
            return (Criteria) this;
        }

        public Criteria andFeeverIsNotNull() {
            addCriterion("FEEVER is not null");
            return (Criteria) this;
        }

        public Criteria andFeeverEqualTo(String value) {
            addCriterion("FEEVER =", value, "feever");
            return (Criteria) this;
        }

        public Criteria andFeeverNotEqualTo(String value) {
            addCriterion("FEEVER <>", value, "feever");
            return (Criteria) this;
        }

        public Criteria andFeeverGreaterThan(String value) {
            addCriterion("FEEVER >", value, "feever");
            return (Criteria) this;
        }

        public Criteria andFeeverGreaterThanOrEqualTo(String value) {
            addCriterion("FEEVER >=", value, "feever");
            return (Criteria) this;
        }

        public Criteria andFeeverLessThan(String value) {
            addCriterion("FEEVER <", value, "feever");
            return (Criteria) this;
        }

        public Criteria andFeeverLessThanOrEqualTo(String value) {
            addCriterion("FEEVER <=", value, "feever");
            return (Criteria) this;
        }

        public Criteria andFeeverLike(String value) {
            addCriterion("FEEVER like", value, "feever");
            return (Criteria) this;
        }

        public Criteria andFeeverNotLike(String value) {
            addCriterion("FEEVER not like", value, "feever");
            return (Criteria) this;
        }

        public Criteria andFeeverIn(List<String> values) {
            addCriterion("FEEVER in", values, "feever");
            return (Criteria) this;
        }

        public Criteria andFeeverNotIn(List<String> values) {
            addCriterion("FEEVER not in", values, "feever");
            return (Criteria) this;
        }

        public Criteria andFeeverBetween(String value1, String value2) {
            addCriterion("FEEVER between", value1, value2, "feever");
            return (Criteria) this;
        }

        public Criteria andFeeverNotBetween(String value1, String value2) {
            addCriterion("FEEVER not between", value1, value2, "feever");
            return (Criteria) this;
        }

        public Criteria andPrdtverIsNull() {
            addCriterion("PRDTVER is null");
            return (Criteria) this;
        }

        public Criteria andPrdtverIsNotNull() {
            addCriterion("PRDTVER is not null");
            return (Criteria) this;
        }

        public Criteria andPrdtverEqualTo(String value) {
            addCriterion("PRDTVER =", value, "prdtver");
            return (Criteria) this;
        }

        public Criteria andPrdtverNotEqualTo(String value) {
            addCriterion("PRDTVER <>", value, "prdtver");
            return (Criteria) this;
        }

        public Criteria andPrdtverGreaterThan(String value) {
            addCriterion("PRDTVER >", value, "prdtver");
            return (Criteria) this;
        }

        public Criteria andPrdtverGreaterThanOrEqualTo(String value) {
            addCriterion("PRDTVER >=", value, "prdtver");
            return (Criteria) this;
        }

        public Criteria andPrdtverLessThan(String value) {
            addCriterion("PRDTVER <", value, "prdtver");
            return (Criteria) this;
        }

        public Criteria andPrdtverLessThanOrEqualTo(String value) {
            addCriterion("PRDTVER <=", value, "prdtver");
            return (Criteria) this;
        }

        public Criteria andPrdtverLike(String value) {
            addCriterion("PRDTVER like", value, "prdtver");
            return (Criteria) this;
        }

        public Criteria andPrdtverNotLike(String value) {
            addCriterion("PRDTVER not like", value, "prdtver");
            return (Criteria) this;
        }

        public Criteria andPrdtverIn(List<String> values) {
            addCriterion("PRDTVER in", values, "prdtver");
            return (Criteria) this;
        }

        public Criteria andPrdtverNotIn(List<String> values) {
            addCriterion("PRDTVER not in", values, "prdtver");
            return (Criteria) this;
        }

        public Criteria andPrdtverBetween(String value1, String value2) {
            addCriterion("PRDTVER between", value1, value2, "prdtver");
            return (Criteria) this;
        }

        public Criteria andPrdtverNotBetween(String value1, String value2) {
            addCriterion("PRDTVER not between", value1, value2, "prdtver");
            return (Criteria) this;
        }

        public Criteria andCheckstandverIsNull() {
            addCriterion("CHECKSTANDVER is null");
            return (Criteria) this;
        }

        public Criteria andCheckstandverIsNotNull() {
            addCriterion("CHECKSTANDVER is not null");
            return (Criteria) this;
        }

        public Criteria andCheckstandverEqualTo(String value) {
            addCriterion("CHECKSTANDVER =", value, "checkstandver");
            return (Criteria) this;
        }

        public Criteria andCheckstandverNotEqualTo(String value) {
            addCriterion("CHECKSTANDVER <>", value, "checkstandver");
            return (Criteria) this;
        }

        public Criteria andCheckstandverGreaterThan(String value) {
            addCriterion("CHECKSTANDVER >", value, "checkstandver");
            return (Criteria) this;
        }

        public Criteria andCheckstandverGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKSTANDVER >=", value, "checkstandver");
            return (Criteria) this;
        }

        public Criteria andCheckstandverLessThan(String value) {
            addCriterion("CHECKSTANDVER <", value, "checkstandver");
            return (Criteria) this;
        }

        public Criteria andCheckstandverLessThanOrEqualTo(String value) {
            addCriterion("CHECKSTANDVER <=", value, "checkstandver");
            return (Criteria) this;
        }

        public Criteria andCheckstandverLike(String value) {
            addCriterion("CHECKSTANDVER like", value, "checkstandver");
            return (Criteria) this;
        }

        public Criteria andCheckstandverNotLike(String value) {
            addCriterion("CHECKSTANDVER not like", value, "checkstandver");
            return (Criteria) this;
        }

        public Criteria andCheckstandverIn(List<String> values) {
            addCriterion("CHECKSTANDVER in", values, "checkstandver");
            return (Criteria) this;
        }

        public Criteria andCheckstandverNotIn(List<String> values) {
            addCriterion("CHECKSTANDVER not in", values, "checkstandver");
            return (Criteria) this;
        }

        public Criteria andCheckstandverBetween(String value1, String value2) {
            addCriterion("CHECKSTANDVER between", value1, value2, "checkstandver");
            return (Criteria) this;
        }

        public Criteria andCheckstandverNotBetween(String value1, String value2) {
            addCriterion("CHECKSTANDVER not between", value1, value2, "checkstandver");
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

        public Criteria andCardinstinoIsNull() {
            addCriterion("CARDINSTINO is null");
            return (Criteria) this;
        }

        public Criteria andCardinstinoIsNotNull() {
            addCriterion("CARDINSTINO is not null");
            return (Criteria) this;
        }

        public Criteria andCardinstinoEqualTo(String value) {
            addCriterion("CARDINSTINO =", value, "cardinstino");
            return (Criteria) this;
        }

        public Criteria andCardinstinoNotEqualTo(String value) {
            addCriterion("CARDINSTINO <>", value, "cardinstino");
            return (Criteria) this;
        }

        public Criteria andCardinstinoGreaterThan(String value) {
            addCriterion("CARDINSTINO >", value, "cardinstino");
            return (Criteria) this;
        }

        public Criteria andCardinstinoGreaterThanOrEqualTo(String value) {
            addCriterion("CARDINSTINO >=", value, "cardinstino");
            return (Criteria) this;
        }

        public Criteria andCardinstinoLessThan(String value) {
            addCriterion("CARDINSTINO <", value, "cardinstino");
            return (Criteria) this;
        }

        public Criteria andCardinstinoLessThanOrEqualTo(String value) {
            addCriterion("CARDINSTINO <=", value, "cardinstino");
            return (Criteria) this;
        }

        public Criteria andCardinstinoLike(String value) {
            addCriterion("CARDINSTINO like", value, "cardinstino");
            return (Criteria) this;
        }

        public Criteria andCardinstinoNotLike(String value) {
            addCriterion("CARDINSTINO not like", value, "cardinstino");
            return (Criteria) this;
        }

        public Criteria andCardinstinoIn(List<String> values) {
            addCriterion("CARDINSTINO in", values, "cardinstino");
            return (Criteria) this;
        }

        public Criteria andCardinstinoNotIn(List<String> values) {
            addCriterion("CARDINSTINO not in", values, "cardinstino");
            return (Criteria) this;
        }

        public Criteria andCardinstinoBetween(String value1, String value2) {
            addCriterion("CARDINSTINO between", value1, value2, "cardinstino");
            return (Criteria) this;
        }

        public Criteria andCardinstinoNotBetween(String value1, String value2) {
            addCriterion("CARDINSTINO not between", value1, value2, "cardinstino");
            return (Criteria) this;
        }

        public Criteria andInpanIsNull() {
            addCriterion("INPAN is null");
            return (Criteria) this;
        }

        public Criteria andInpanIsNotNull() {
            addCriterion("INPAN is not null");
            return (Criteria) this;
        }

        public Criteria andInpanEqualTo(String value) {
            addCriterion("INPAN =", value, "inpan");
            return (Criteria) this;
        }

        public Criteria andInpanNotEqualTo(String value) {
            addCriterion("INPAN <>", value, "inpan");
            return (Criteria) this;
        }

        public Criteria andInpanGreaterThan(String value) {
            addCriterion("INPAN >", value, "inpan");
            return (Criteria) this;
        }

        public Criteria andInpanGreaterThanOrEqualTo(String value) {
            addCriterion("INPAN >=", value, "inpan");
            return (Criteria) this;
        }

        public Criteria andInpanLessThan(String value) {
            addCriterion("INPAN <", value, "inpan");
            return (Criteria) this;
        }

        public Criteria andInpanLessThanOrEqualTo(String value) {
            addCriterion("INPAN <=", value, "inpan");
            return (Criteria) this;
        }

        public Criteria andInpanLike(String value) {
            addCriterion("INPAN like", value, "inpan");
            return (Criteria) this;
        }

        public Criteria andInpanNotLike(String value) {
            addCriterion("INPAN not like", value, "inpan");
            return (Criteria) this;
        }

        public Criteria andInpanIn(List<String> values) {
            addCriterion("INPAN in", values, "inpan");
            return (Criteria) this;
        }

        public Criteria andInpanNotIn(List<String> values) {
            addCriterion("INPAN not in", values, "inpan");
            return (Criteria) this;
        }

        public Criteria andInpanBetween(String value1, String value2) {
            addCriterion("INPAN between", value1, value2, "inpan");
            return (Criteria) this;
        }

        public Criteria andInpanNotBetween(String value1, String value2) {
            addCriterion("INPAN not between", value1, value2, "inpan");
            return (Criteria) this;
        }

        public Criteria andIncardtypeIsNull() {
            addCriterion("INCARDTYPE is null");
            return (Criteria) this;
        }

        public Criteria andIncardtypeIsNotNull() {
            addCriterion("INCARDTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIncardtypeEqualTo(String value) {
            addCriterion("INCARDTYPE =", value, "incardtype");
            return (Criteria) this;
        }

        public Criteria andIncardtypeNotEqualTo(String value) {
            addCriterion("INCARDTYPE <>", value, "incardtype");
            return (Criteria) this;
        }

        public Criteria andIncardtypeGreaterThan(String value) {
            addCriterion("INCARDTYPE >", value, "incardtype");
            return (Criteria) this;
        }

        public Criteria andIncardtypeGreaterThanOrEqualTo(String value) {
            addCriterion("INCARDTYPE >=", value, "incardtype");
            return (Criteria) this;
        }

        public Criteria andIncardtypeLessThan(String value) {
            addCriterion("INCARDTYPE <", value, "incardtype");
            return (Criteria) this;
        }

        public Criteria andIncardtypeLessThanOrEqualTo(String value) {
            addCriterion("INCARDTYPE <=", value, "incardtype");
            return (Criteria) this;
        }

        public Criteria andIncardtypeLike(String value) {
            addCriterion("INCARDTYPE like", value, "incardtype");
            return (Criteria) this;
        }

        public Criteria andIncardtypeNotLike(String value) {
            addCriterion("INCARDTYPE not like", value, "incardtype");
            return (Criteria) this;
        }

        public Criteria andIncardtypeIn(List<String> values) {
            addCriterion("INCARDTYPE in", values, "incardtype");
            return (Criteria) this;
        }

        public Criteria andIncardtypeNotIn(List<String> values) {
            addCriterion("INCARDTYPE not in", values, "incardtype");
            return (Criteria) this;
        }

        public Criteria andIncardtypeBetween(String value1, String value2) {
            addCriterion("INCARDTYPE between", value1, value2, "incardtype");
            return (Criteria) this;
        }

        public Criteria andIncardtypeNotBetween(String value1, String value2) {
            addCriterion("INCARDTYPE not between", value1, value2, "incardtype");
            return (Criteria) this;
        }

        public Criteria andIncardinstinoIsNull() {
            addCriterion("INCARDINSTINO is null");
            return (Criteria) this;
        }

        public Criteria andIncardinstinoIsNotNull() {
            addCriterion("INCARDINSTINO is not null");
            return (Criteria) this;
        }

        public Criteria andIncardinstinoEqualTo(String value) {
            addCriterion("INCARDINSTINO =", value, "incardinstino");
            return (Criteria) this;
        }

        public Criteria andIncardinstinoNotEqualTo(String value) {
            addCriterion("INCARDINSTINO <>", value, "incardinstino");
            return (Criteria) this;
        }

        public Criteria andIncardinstinoGreaterThan(String value) {
            addCriterion("INCARDINSTINO >", value, "incardinstino");
            return (Criteria) this;
        }

        public Criteria andIncardinstinoGreaterThanOrEqualTo(String value) {
            addCriterion("INCARDINSTINO >=", value, "incardinstino");
            return (Criteria) this;
        }

        public Criteria andIncardinstinoLessThan(String value) {
            addCriterion("INCARDINSTINO <", value, "incardinstino");
            return (Criteria) this;
        }

        public Criteria andIncardinstinoLessThanOrEqualTo(String value) {
            addCriterion("INCARDINSTINO <=", value, "incardinstino");
            return (Criteria) this;
        }

        public Criteria andIncardinstinoLike(String value) {
            addCriterion("INCARDINSTINO like", value, "incardinstino");
            return (Criteria) this;
        }

        public Criteria andIncardinstinoNotLike(String value) {
            addCriterion("INCARDINSTINO not like", value, "incardinstino");
            return (Criteria) this;
        }

        public Criteria andIncardinstinoIn(List<String> values) {
            addCriterion("INCARDINSTINO in", values, "incardinstino");
            return (Criteria) this;
        }

        public Criteria andIncardinstinoNotIn(List<String> values) {
            addCriterion("INCARDINSTINO not in", values, "incardinstino");
            return (Criteria) this;
        }

        public Criteria andIncardinstinoBetween(String value1, String value2) {
            addCriterion("INCARDINSTINO between", value1, value2, "incardinstino");
            return (Criteria) this;
        }

        public Criteria andIncardinstinoNotBetween(String value1, String value2) {
            addCriterion("INCARDINSTINO not between", value1, value2, "incardinstino");
            return (Criteria) this;
        }

        public Criteria andAccordnoIsNull() {
            addCriterion("ACCORDNO is null");
            return (Criteria) this;
        }

        public Criteria andAccordnoIsNotNull() {
            addCriterion("ACCORDNO is not null");
            return (Criteria) this;
        }

        public Criteria andAccordnoEqualTo(String value) {
            addCriterion("ACCORDNO =", value, "accordno");
            return (Criteria) this;
        }

        public Criteria andAccordnoNotEqualTo(String value) {
            addCriterion("ACCORDNO <>", value, "accordno");
            return (Criteria) this;
        }

        public Criteria andAccordnoGreaterThan(String value) {
            addCriterion("ACCORDNO >", value, "accordno");
            return (Criteria) this;
        }

        public Criteria andAccordnoGreaterThanOrEqualTo(String value) {
            addCriterion("ACCORDNO >=", value, "accordno");
            return (Criteria) this;
        }

        public Criteria andAccordnoLessThan(String value) {
            addCriterion("ACCORDNO <", value, "accordno");
            return (Criteria) this;
        }

        public Criteria andAccordnoLessThanOrEqualTo(String value) {
            addCriterion("ACCORDNO <=", value, "accordno");
            return (Criteria) this;
        }

        public Criteria andAccordnoLike(String value) {
            addCriterion("ACCORDNO like", value, "accordno");
            return (Criteria) this;
        }

        public Criteria andAccordnoNotLike(String value) {
            addCriterion("ACCORDNO not like", value, "accordno");
            return (Criteria) this;
        }

        public Criteria andAccordnoIn(List<String> values) {
            addCriterion("ACCORDNO in", values, "accordno");
            return (Criteria) this;
        }

        public Criteria andAccordnoNotIn(List<String> values) {
            addCriterion("ACCORDNO not in", values, "accordno");
            return (Criteria) this;
        }

        public Criteria andAccordnoBetween(String value1, String value2) {
            addCriterion("ACCORDNO between", value1, value2, "accordno");
            return (Criteria) this;
        }

        public Criteria andAccordnoNotBetween(String value1, String value2) {
            addCriterion("ACCORDNO not between", value1, value2, "accordno");
            return (Criteria) this;
        }

        public Criteria andAccordinstIsNull() {
            addCriterion("ACCORDINST is null");
            return (Criteria) this;
        }

        public Criteria andAccordinstIsNotNull() {
            addCriterion("ACCORDINST is not null");
            return (Criteria) this;
        }

        public Criteria andAccordinstEqualTo(String value) {
            addCriterion("ACCORDINST =", value, "accordinst");
            return (Criteria) this;
        }

        public Criteria andAccordinstNotEqualTo(String value) {
            addCriterion("ACCORDINST <>", value, "accordinst");
            return (Criteria) this;
        }

        public Criteria andAccordinstGreaterThan(String value) {
            addCriterion("ACCORDINST >", value, "accordinst");
            return (Criteria) this;
        }

        public Criteria andAccordinstGreaterThanOrEqualTo(String value) {
            addCriterion("ACCORDINST >=", value, "accordinst");
            return (Criteria) this;
        }

        public Criteria andAccordinstLessThan(String value) {
            addCriterion("ACCORDINST <", value, "accordinst");
            return (Criteria) this;
        }

        public Criteria andAccordinstLessThanOrEqualTo(String value) {
            addCriterion("ACCORDINST <=", value, "accordinst");
            return (Criteria) this;
        }

        public Criteria andAccordinstLike(String value) {
            addCriterion("ACCORDINST like", value, "accordinst");
            return (Criteria) this;
        }

        public Criteria andAccordinstNotLike(String value) {
            addCriterion("ACCORDINST not like", value, "accordinst");
            return (Criteria) this;
        }

        public Criteria andAccordinstIn(List<String> values) {
            addCriterion("ACCORDINST in", values, "accordinst");
            return (Criteria) this;
        }

        public Criteria andAccordinstNotIn(List<String> values) {
            addCriterion("ACCORDINST not in", values, "accordinst");
            return (Criteria) this;
        }

        public Criteria andAccordinstBetween(String value1, String value2) {
            addCriterion("ACCORDINST between", value1, value2, "accordinst");
            return (Criteria) this;
        }

        public Criteria andAccordinstNotBetween(String value1, String value2) {
            addCriterion("ACCORDINST not between", value1, value2, "accordinst");
            return (Criteria) this;
        }

        public Criteria andAccsecmernoIsNull() {
            addCriterion("ACCSECMERNO is null");
            return (Criteria) this;
        }

        public Criteria andAccsecmernoIsNotNull() {
            addCriterion("ACCSECMERNO is not null");
            return (Criteria) this;
        }

        public Criteria andAccsecmernoEqualTo(String value) {
            addCriterion("ACCSECMERNO =", value, "accsecmerno");
            return (Criteria) this;
        }

        public Criteria andAccsecmernoNotEqualTo(String value) {
            addCriterion("ACCSECMERNO <>", value, "accsecmerno");
            return (Criteria) this;
        }

        public Criteria andAccsecmernoGreaterThan(String value) {
            addCriterion("ACCSECMERNO >", value, "accsecmerno");
            return (Criteria) this;
        }

        public Criteria andAccsecmernoGreaterThanOrEqualTo(String value) {
            addCriterion("ACCSECMERNO >=", value, "accsecmerno");
            return (Criteria) this;
        }

        public Criteria andAccsecmernoLessThan(String value) {
            addCriterion("ACCSECMERNO <", value, "accsecmerno");
            return (Criteria) this;
        }

        public Criteria andAccsecmernoLessThanOrEqualTo(String value) {
            addCriterion("ACCSECMERNO <=", value, "accsecmerno");
            return (Criteria) this;
        }

        public Criteria andAccsecmernoLike(String value) {
            addCriterion("ACCSECMERNO like", value, "accsecmerno");
            return (Criteria) this;
        }

        public Criteria andAccsecmernoNotLike(String value) {
            addCriterion("ACCSECMERNO not like", value, "accsecmerno");
            return (Criteria) this;
        }

        public Criteria andAccsecmernoIn(List<String> values) {
            addCriterion("ACCSECMERNO in", values, "accsecmerno");
            return (Criteria) this;
        }

        public Criteria andAccsecmernoNotIn(List<String> values) {
            addCriterion("ACCSECMERNO not in", values, "accsecmerno");
            return (Criteria) this;
        }

        public Criteria andAccsecmernoBetween(String value1, String value2) {
            addCriterion("ACCSECMERNO between", value1, value2, "accsecmerno");
            return (Criteria) this;
        }

        public Criteria andAccsecmernoNotBetween(String value1, String value2) {
            addCriterion("ACCSECMERNO not between", value1, value2, "accsecmerno");
            return (Criteria) this;
        }

        public Criteria andAccfirmernoIsNull() {
            addCriterion("ACCFIRMERNO is null");
            return (Criteria) this;
        }

        public Criteria andAccfirmernoIsNotNull() {
            addCriterion("ACCFIRMERNO is not null");
            return (Criteria) this;
        }

        public Criteria andAccfirmernoEqualTo(String value) {
            addCriterion("ACCFIRMERNO =", value, "accfirmerno");
            return (Criteria) this;
        }

        public Criteria andAccfirmernoNotEqualTo(String value) {
            addCriterion("ACCFIRMERNO <>", value, "accfirmerno");
            return (Criteria) this;
        }

        public Criteria andAccfirmernoGreaterThan(String value) {
            addCriterion("ACCFIRMERNO >", value, "accfirmerno");
            return (Criteria) this;
        }

        public Criteria andAccfirmernoGreaterThanOrEqualTo(String value) {
            addCriterion("ACCFIRMERNO >=", value, "accfirmerno");
            return (Criteria) this;
        }

        public Criteria andAccfirmernoLessThan(String value) {
            addCriterion("ACCFIRMERNO <", value, "accfirmerno");
            return (Criteria) this;
        }

        public Criteria andAccfirmernoLessThanOrEqualTo(String value) {
            addCriterion("ACCFIRMERNO <=", value, "accfirmerno");
            return (Criteria) this;
        }

        public Criteria andAccfirmernoLike(String value) {
            addCriterion("ACCFIRMERNO like", value, "accfirmerno");
            return (Criteria) this;
        }

        public Criteria andAccfirmernoNotLike(String value) {
            addCriterion("ACCFIRMERNO not like", value, "accfirmerno");
            return (Criteria) this;
        }

        public Criteria andAccfirmernoIn(List<String> values) {
            addCriterion("ACCFIRMERNO in", values, "accfirmerno");
            return (Criteria) this;
        }

        public Criteria andAccfirmernoNotIn(List<String> values) {
            addCriterion("ACCFIRMERNO not in", values, "accfirmerno");
            return (Criteria) this;
        }

        public Criteria andAccfirmernoBetween(String value1, String value2) {
            addCriterion("ACCFIRMERNO between", value1, value2, "accfirmerno");
            return (Criteria) this;
        }

        public Criteria andAccfirmernoNotBetween(String value1, String value2) {
            addCriterion("ACCFIRMERNO not between", value1, value2, "accfirmerno");
            return (Criteria) this;
        }

        public Criteria andAccsettledateIsNull() {
            addCriterion("ACCSETTLEDATE is null");
            return (Criteria) this;
        }

        public Criteria andAccsettledateIsNotNull() {
            addCriterion("ACCSETTLEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andAccsettledateEqualTo(String value) {
            addCriterion("ACCSETTLEDATE =", value, "accsettledate");
            return (Criteria) this;
        }

        public Criteria andAccsettledateNotEqualTo(String value) {
            addCriterion("ACCSETTLEDATE <>", value, "accsettledate");
            return (Criteria) this;
        }

        public Criteria andAccsettledateGreaterThan(String value) {
            addCriterion("ACCSETTLEDATE >", value, "accsettledate");
            return (Criteria) this;
        }

        public Criteria andAccsettledateGreaterThanOrEqualTo(String value) {
            addCriterion("ACCSETTLEDATE >=", value, "accsettledate");
            return (Criteria) this;
        }

        public Criteria andAccsettledateLessThan(String value) {
            addCriterion("ACCSETTLEDATE <", value, "accsettledate");
            return (Criteria) this;
        }

        public Criteria andAccsettledateLessThanOrEqualTo(String value) {
            addCriterion("ACCSETTLEDATE <=", value, "accsettledate");
            return (Criteria) this;
        }

        public Criteria andAccsettledateLike(String value) {
            addCriterion("ACCSETTLEDATE like", value, "accsettledate");
            return (Criteria) this;
        }

        public Criteria andAccsettledateNotLike(String value) {
            addCriterion("ACCSETTLEDATE not like", value, "accsettledate");
            return (Criteria) this;
        }

        public Criteria andAccsettledateIn(List<String> values) {
            addCriterion("ACCSETTLEDATE in", values, "accsettledate");
            return (Criteria) this;
        }

        public Criteria andAccsettledateNotIn(List<String> values) {
            addCriterion("ACCSETTLEDATE not in", values, "accsettledate");
            return (Criteria) this;
        }

        public Criteria andAccsettledateBetween(String value1, String value2) {
            addCriterion("ACCSETTLEDATE between", value1, value2, "accsettledate");
            return (Criteria) this;
        }

        public Criteria andAccsettledateNotBetween(String value1, String value2) {
            addCriterion("ACCSETTLEDATE not between", value1, value2, "accsettledate");
            return (Criteria) this;
        }

        public Criteria andAccordcommitimeIsNull() {
            addCriterion("ACCORDCOMMITIME is null");
            return (Criteria) this;
        }

        public Criteria andAccordcommitimeIsNotNull() {
            addCriterion("ACCORDCOMMITIME is not null");
            return (Criteria) this;
        }

        public Criteria andAccordcommitimeEqualTo(String value) {
            addCriterion("ACCORDCOMMITIME =", value, "accordcommitime");
            return (Criteria) this;
        }

        public Criteria andAccordcommitimeNotEqualTo(String value) {
            addCriterion("ACCORDCOMMITIME <>", value, "accordcommitime");
            return (Criteria) this;
        }

        public Criteria andAccordcommitimeGreaterThan(String value) {
            addCriterion("ACCORDCOMMITIME >", value, "accordcommitime");
            return (Criteria) this;
        }

        public Criteria andAccordcommitimeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCORDCOMMITIME >=", value, "accordcommitime");
            return (Criteria) this;
        }

        public Criteria andAccordcommitimeLessThan(String value) {
            addCriterion("ACCORDCOMMITIME <", value, "accordcommitime");
            return (Criteria) this;
        }

        public Criteria andAccordcommitimeLessThanOrEqualTo(String value) {
            addCriterion("ACCORDCOMMITIME <=", value, "accordcommitime");
            return (Criteria) this;
        }

        public Criteria andAccordcommitimeLike(String value) {
            addCriterion("ACCORDCOMMITIME like", value, "accordcommitime");
            return (Criteria) this;
        }

        public Criteria andAccordcommitimeNotLike(String value) {
            addCriterion("ACCORDCOMMITIME not like", value, "accordcommitime");
            return (Criteria) this;
        }

        public Criteria andAccordcommitimeIn(List<String> values) {
            addCriterion("ACCORDCOMMITIME in", values, "accordcommitime");
            return (Criteria) this;
        }

        public Criteria andAccordcommitimeNotIn(List<String> values) {
            addCriterion("ACCORDCOMMITIME not in", values, "accordcommitime");
            return (Criteria) this;
        }

        public Criteria andAccordcommitimeBetween(String value1, String value2) {
            addCriterion("ACCORDCOMMITIME between", value1, value2, "accordcommitime");
            return (Criteria) this;
        }

        public Criteria andAccordcommitimeNotBetween(String value1, String value2) {
            addCriterion("ACCORDCOMMITIME not between", value1, value2, "accordcommitime");
            return (Criteria) this;
        }

        public Criteria andAccordfintimeIsNull() {
            addCriterion("ACCORDFINTIME is null");
            return (Criteria) this;
        }

        public Criteria andAccordfintimeIsNotNull() {
            addCriterion("ACCORDFINTIME is not null");
            return (Criteria) this;
        }

        public Criteria andAccordfintimeEqualTo(String value) {
            addCriterion("ACCORDFINTIME =", value, "accordfintime");
            return (Criteria) this;
        }

        public Criteria andAccordfintimeNotEqualTo(String value) {
            addCriterion("ACCORDFINTIME <>", value, "accordfintime");
            return (Criteria) this;
        }

        public Criteria andAccordfintimeGreaterThan(String value) {
            addCriterion("ACCORDFINTIME >", value, "accordfintime");
            return (Criteria) this;
        }

        public Criteria andAccordfintimeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCORDFINTIME >=", value, "accordfintime");
            return (Criteria) this;
        }

        public Criteria andAccordfintimeLessThan(String value) {
            addCriterion("ACCORDFINTIME <", value, "accordfintime");
            return (Criteria) this;
        }

        public Criteria andAccordfintimeLessThanOrEqualTo(String value) {
            addCriterion("ACCORDFINTIME <=", value, "accordfintime");
            return (Criteria) this;
        }

        public Criteria andAccordfintimeLike(String value) {
            addCriterion("ACCORDFINTIME like", value, "accordfintime");
            return (Criteria) this;
        }

        public Criteria andAccordfintimeNotLike(String value) {
            addCriterion("ACCORDFINTIME not like", value, "accordfintime");
            return (Criteria) this;
        }

        public Criteria andAccordfintimeIn(List<String> values) {
            addCriterion("ACCORDFINTIME in", values, "accordfintime");
            return (Criteria) this;
        }

        public Criteria andAccordfintimeNotIn(List<String> values) {
            addCriterion("ACCORDFINTIME not in", values, "accordfintime");
            return (Criteria) this;
        }

        public Criteria andAccordfintimeBetween(String value1, String value2) {
            addCriterion("ACCORDFINTIME between", value1, value2, "accordfintime");
            return (Criteria) this;
        }

        public Criteria andAccordfintimeNotBetween(String value1, String value2) {
            addCriterion("ACCORDFINTIME not between", value1, value2, "accordfintime");
            return (Criteria) this;
        }

        public Criteria andAccretcodeIsNull() {
            addCriterion("ACCRETCODE is null");
            return (Criteria) this;
        }

        public Criteria andAccretcodeIsNotNull() {
            addCriterion("ACCRETCODE is not null");
            return (Criteria) this;
        }

        public Criteria andAccretcodeEqualTo(String value) {
            addCriterion("ACCRETCODE =", value, "accretcode");
            return (Criteria) this;
        }

        public Criteria andAccretcodeNotEqualTo(String value) {
            addCriterion("ACCRETCODE <>", value, "accretcode");
            return (Criteria) this;
        }

        public Criteria andAccretcodeGreaterThan(String value) {
            addCriterion("ACCRETCODE >", value, "accretcode");
            return (Criteria) this;
        }

        public Criteria andAccretcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCRETCODE >=", value, "accretcode");
            return (Criteria) this;
        }

        public Criteria andAccretcodeLessThan(String value) {
            addCriterion("ACCRETCODE <", value, "accretcode");
            return (Criteria) this;
        }

        public Criteria andAccretcodeLessThanOrEqualTo(String value) {
            addCriterion("ACCRETCODE <=", value, "accretcode");
            return (Criteria) this;
        }

        public Criteria andAccretcodeLike(String value) {
            addCriterion("ACCRETCODE like", value, "accretcode");
            return (Criteria) this;
        }

        public Criteria andAccretcodeNotLike(String value) {
            addCriterion("ACCRETCODE not like", value, "accretcode");
            return (Criteria) this;
        }

        public Criteria andAccretcodeIn(List<String> values) {
            addCriterion("ACCRETCODE in", values, "accretcode");
            return (Criteria) this;
        }

        public Criteria andAccretcodeNotIn(List<String> values) {
            addCriterion("ACCRETCODE not in", values, "accretcode");
            return (Criteria) this;
        }

        public Criteria andAccretcodeBetween(String value1, String value2) {
            addCriterion("ACCRETCODE between", value1, value2, "accretcode");
            return (Criteria) this;
        }

        public Criteria andAccretcodeNotBetween(String value1, String value2) {
            addCriterion("ACCRETCODE not between", value1, value2, "accretcode");
            return (Criteria) this;
        }

        public Criteria andAccretinfoIsNull() {
            addCriterion("ACCRETINFO is null");
            return (Criteria) this;
        }

        public Criteria andAccretinfoIsNotNull() {
            addCriterion("ACCRETINFO is not null");
            return (Criteria) this;
        }

        public Criteria andAccretinfoEqualTo(String value) {
            addCriterion("ACCRETINFO =", value, "accretinfo");
            return (Criteria) this;
        }

        public Criteria andAccretinfoNotEqualTo(String value) {
            addCriterion("ACCRETINFO <>", value, "accretinfo");
            return (Criteria) this;
        }

        public Criteria andAccretinfoGreaterThan(String value) {
            addCriterion("ACCRETINFO >", value, "accretinfo");
            return (Criteria) this;
        }

        public Criteria andAccretinfoGreaterThanOrEqualTo(String value) {
            addCriterion("ACCRETINFO >=", value, "accretinfo");
            return (Criteria) this;
        }

        public Criteria andAccretinfoLessThan(String value) {
            addCriterion("ACCRETINFO <", value, "accretinfo");
            return (Criteria) this;
        }

        public Criteria andAccretinfoLessThanOrEqualTo(String value) {
            addCriterion("ACCRETINFO <=", value, "accretinfo");
            return (Criteria) this;
        }

        public Criteria andAccretinfoLike(String value) {
            addCriterion("ACCRETINFO like", value, "accretinfo");
            return (Criteria) this;
        }

        public Criteria andAccretinfoNotLike(String value) {
            addCriterion("ACCRETINFO not like", value, "accretinfo");
            return (Criteria) this;
        }

        public Criteria andAccretinfoIn(List<String> values) {
            addCriterion("ACCRETINFO in", values, "accretinfo");
            return (Criteria) this;
        }

        public Criteria andAccretinfoNotIn(List<String> values) {
            addCriterion("ACCRETINFO not in", values, "accretinfo");
            return (Criteria) this;
        }

        public Criteria andAccretinfoBetween(String value1, String value2) {
            addCriterion("ACCRETINFO between", value1, value2, "accretinfo");
            return (Criteria) this;
        }

        public Criteria andAccretinfoNotBetween(String value1, String value2) {
            addCriterion("ACCRETINFO not between", value1, value2, "accretinfo");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNull() {
            addCriterion("PAYTYPE is null");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNotNull() {
            addCriterion("PAYTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPaytypeEqualTo(String value) {
            addCriterion("PAYTYPE =", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotEqualTo(String value) {
            addCriterion("PAYTYPE <>", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThan(String value) {
            addCriterion("PAYTYPE >", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYTYPE >=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThan(String value) {
            addCriterion("PAYTYPE <", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThanOrEqualTo(String value) {
            addCriterion("PAYTYPE <=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLike(String value) {
            addCriterion("PAYTYPE like", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotLike(String value) {
            addCriterion("PAYTYPE not like", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeIn(List<String> values) {
            addCriterion("PAYTYPE in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotIn(List<String> values) {
            addCriterion("PAYTYPE not in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeBetween(String value1, String value2) {
            addCriterion("PAYTYPE between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotBetween(String value1, String value2) {
            addCriterion("PAYTYPE not between", value1, value2, "paytype");
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

        public Criteria andPayinstIsNull() {
            addCriterion("PAYINST is null");
            return (Criteria) this;
        }

        public Criteria andPayinstIsNotNull() {
            addCriterion("PAYINST is not null");
            return (Criteria) this;
        }

        public Criteria andPayinstEqualTo(String value) {
            addCriterion("PAYINST =", value, "payinst");
            return (Criteria) this;
        }

        public Criteria andPayinstNotEqualTo(String value) {
            addCriterion("PAYINST <>", value, "payinst");
            return (Criteria) this;
        }

        public Criteria andPayinstGreaterThan(String value) {
            addCriterion("PAYINST >", value, "payinst");
            return (Criteria) this;
        }

        public Criteria andPayinstGreaterThanOrEqualTo(String value) {
            addCriterion("PAYINST >=", value, "payinst");
            return (Criteria) this;
        }

        public Criteria andPayinstLessThan(String value) {
            addCriterion("PAYINST <", value, "payinst");
            return (Criteria) this;
        }

        public Criteria andPayinstLessThanOrEqualTo(String value) {
            addCriterion("PAYINST <=", value, "payinst");
            return (Criteria) this;
        }

        public Criteria andPayinstLike(String value) {
            addCriterion("PAYINST like", value, "payinst");
            return (Criteria) this;
        }

        public Criteria andPayinstNotLike(String value) {
            addCriterion("PAYINST not like", value, "payinst");
            return (Criteria) this;
        }

        public Criteria andPayinstIn(List<String> values) {
            addCriterion("PAYINST in", values, "payinst");
            return (Criteria) this;
        }

        public Criteria andPayinstNotIn(List<String> values) {
            addCriterion("PAYINST not in", values, "payinst");
            return (Criteria) this;
        }

        public Criteria andPayinstBetween(String value1, String value2) {
            addCriterion("PAYINST between", value1, value2, "payinst");
            return (Criteria) this;
        }

        public Criteria andPayinstNotBetween(String value1, String value2) {
            addCriterion("PAYINST not between", value1, value2, "payinst");
            return (Criteria) this;
        }

        public Criteria andPayfirmernoIsNull() {
            addCriterion("PAYFIRMERNO is null");
            return (Criteria) this;
        }

        public Criteria andPayfirmernoIsNotNull() {
            addCriterion("PAYFIRMERNO is not null");
            return (Criteria) this;
        }

        public Criteria andPayfirmernoEqualTo(String value) {
            addCriterion("PAYFIRMERNO =", value, "payfirmerno");
            return (Criteria) this;
        }

        public Criteria andPayfirmernoNotEqualTo(String value) {
            addCriterion("PAYFIRMERNO <>", value, "payfirmerno");
            return (Criteria) this;
        }

        public Criteria andPayfirmernoGreaterThan(String value) {
            addCriterion("PAYFIRMERNO >", value, "payfirmerno");
            return (Criteria) this;
        }

        public Criteria andPayfirmernoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYFIRMERNO >=", value, "payfirmerno");
            return (Criteria) this;
        }

        public Criteria andPayfirmernoLessThan(String value) {
            addCriterion("PAYFIRMERNO <", value, "payfirmerno");
            return (Criteria) this;
        }

        public Criteria andPayfirmernoLessThanOrEqualTo(String value) {
            addCriterion("PAYFIRMERNO <=", value, "payfirmerno");
            return (Criteria) this;
        }

        public Criteria andPayfirmernoLike(String value) {
            addCriterion("PAYFIRMERNO like", value, "payfirmerno");
            return (Criteria) this;
        }

        public Criteria andPayfirmernoNotLike(String value) {
            addCriterion("PAYFIRMERNO not like", value, "payfirmerno");
            return (Criteria) this;
        }

        public Criteria andPayfirmernoIn(List<String> values) {
            addCriterion("PAYFIRMERNO in", values, "payfirmerno");
            return (Criteria) this;
        }

        public Criteria andPayfirmernoNotIn(List<String> values) {
            addCriterion("PAYFIRMERNO not in", values, "payfirmerno");
            return (Criteria) this;
        }

        public Criteria andPayfirmernoBetween(String value1, String value2) {
            addCriterion("PAYFIRMERNO between", value1, value2, "payfirmerno");
            return (Criteria) this;
        }

        public Criteria andPayfirmernoNotBetween(String value1, String value2) {
            addCriterion("PAYFIRMERNO not between", value1, value2, "payfirmerno");
            return (Criteria) this;
        }

        public Criteria andPaysecmernoIsNull() {
            addCriterion("PAYSECMERNO is null");
            return (Criteria) this;
        }

        public Criteria andPaysecmernoIsNotNull() {
            addCriterion("PAYSECMERNO is not null");
            return (Criteria) this;
        }

        public Criteria andPaysecmernoEqualTo(String value) {
            addCriterion("PAYSECMERNO =", value, "paysecmerno");
            return (Criteria) this;
        }

        public Criteria andPaysecmernoNotEqualTo(String value) {
            addCriterion("PAYSECMERNO <>", value, "paysecmerno");
            return (Criteria) this;
        }

        public Criteria andPaysecmernoGreaterThan(String value) {
            addCriterion("PAYSECMERNO >", value, "paysecmerno");
            return (Criteria) this;
        }

        public Criteria andPaysecmernoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYSECMERNO >=", value, "paysecmerno");
            return (Criteria) this;
        }

        public Criteria andPaysecmernoLessThan(String value) {
            addCriterion("PAYSECMERNO <", value, "paysecmerno");
            return (Criteria) this;
        }

        public Criteria andPaysecmernoLessThanOrEqualTo(String value) {
            addCriterion("PAYSECMERNO <=", value, "paysecmerno");
            return (Criteria) this;
        }

        public Criteria andPaysecmernoLike(String value) {
            addCriterion("PAYSECMERNO like", value, "paysecmerno");
            return (Criteria) this;
        }

        public Criteria andPaysecmernoNotLike(String value) {
            addCriterion("PAYSECMERNO not like", value, "paysecmerno");
            return (Criteria) this;
        }

        public Criteria andPaysecmernoIn(List<String> values) {
            addCriterion("PAYSECMERNO in", values, "paysecmerno");
            return (Criteria) this;
        }

        public Criteria andPaysecmernoNotIn(List<String> values) {
            addCriterion("PAYSECMERNO not in", values, "paysecmerno");
            return (Criteria) this;
        }

        public Criteria andPaysecmernoBetween(String value1, String value2) {
            addCriterion("PAYSECMERNO between", value1, value2, "paysecmerno");
            return (Criteria) this;
        }

        public Criteria andPaysecmernoNotBetween(String value1, String value2) {
            addCriterion("PAYSECMERNO not between", value1, value2, "paysecmerno");
            return (Criteria) this;
        }

        public Criteria andPayordcomtimeIsNull() {
            addCriterion("PAYORDCOMTIME is null");
            return (Criteria) this;
        }

        public Criteria andPayordcomtimeIsNotNull() {
            addCriterion("PAYORDCOMTIME is not null");
            return (Criteria) this;
        }

        public Criteria andPayordcomtimeEqualTo(String value) {
            addCriterion("PAYORDCOMTIME =", value, "payordcomtime");
            return (Criteria) this;
        }

        public Criteria andPayordcomtimeNotEqualTo(String value) {
            addCriterion("PAYORDCOMTIME <>", value, "payordcomtime");
            return (Criteria) this;
        }

        public Criteria andPayordcomtimeGreaterThan(String value) {
            addCriterion("PAYORDCOMTIME >", value, "payordcomtime");
            return (Criteria) this;
        }

        public Criteria andPayordcomtimeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYORDCOMTIME >=", value, "payordcomtime");
            return (Criteria) this;
        }

        public Criteria andPayordcomtimeLessThan(String value) {
            addCriterion("PAYORDCOMTIME <", value, "payordcomtime");
            return (Criteria) this;
        }

        public Criteria andPayordcomtimeLessThanOrEqualTo(String value) {
            addCriterion("PAYORDCOMTIME <=", value, "payordcomtime");
            return (Criteria) this;
        }

        public Criteria andPayordcomtimeLike(String value) {
            addCriterion("PAYORDCOMTIME like", value, "payordcomtime");
            return (Criteria) this;
        }

        public Criteria andPayordcomtimeNotLike(String value) {
            addCriterion("PAYORDCOMTIME not like", value, "payordcomtime");
            return (Criteria) this;
        }

        public Criteria andPayordcomtimeIn(List<String> values) {
            addCriterion("PAYORDCOMTIME in", values, "payordcomtime");
            return (Criteria) this;
        }

        public Criteria andPayordcomtimeNotIn(List<String> values) {
            addCriterion("PAYORDCOMTIME not in", values, "payordcomtime");
            return (Criteria) this;
        }

        public Criteria andPayordcomtimeBetween(String value1, String value2) {
            addCriterion("PAYORDCOMTIME between", value1, value2, "payordcomtime");
            return (Criteria) this;
        }

        public Criteria andPayordcomtimeNotBetween(String value1, String value2) {
            addCriterion("PAYORDCOMTIME not between", value1, value2, "payordcomtime");
            return (Criteria) this;
        }

        public Criteria andPayordfintimeIsNull() {
            addCriterion("PAYORDFINTIME is null");
            return (Criteria) this;
        }

        public Criteria andPayordfintimeIsNotNull() {
            addCriterion("PAYORDFINTIME is not null");
            return (Criteria) this;
        }

        public Criteria andPayordfintimeEqualTo(String value) {
            addCriterion("PAYORDFINTIME =", value, "payordfintime");
            return (Criteria) this;
        }

        public Criteria andPayordfintimeNotEqualTo(String value) {
            addCriterion("PAYORDFINTIME <>", value, "payordfintime");
            return (Criteria) this;
        }

        public Criteria andPayordfintimeGreaterThan(String value) {
            addCriterion("PAYORDFINTIME >", value, "payordfintime");
            return (Criteria) this;
        }

        public Criteria andPayordfintimeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYORDFINTIME >=", value, "payordfintime");
            return (Criteria) this;
        }

        public Criteria andPayordfintimeLessThan(String value) {
            addCriterion("PAYORDFINTIME <", value, "payordfintime");
            return (Criteria) this;
        }

        public Criteria andPayordfintimeLessThanOrEqualTo(String value) {
            addCriterion("PAYORDFINTIME <=", value, "payordfintime");
            return (Criteria) this;
        }

        public Criteria andPayordfintimeLike(String value) {
            addCriterion("PAYORDFINTIME like", value, "payordfintime");
            return (Criteria) this;
        }

        public Criteria andPayordfintimeNotLike(String value) {
            addCriterion("PAYORDFINTIME not like", value, "payordfintime");
            return (Criteria) this;
        }

        public Criteria andPayordfintimeIn(List<String> values) {
            addCriterion("PAYORDFINTIME in", values, "payordfintime");
            return (Criteria) this;
        }

        public Criteria andPayordfintimeNotIn(List<String> values) {
            addCriterion("PAYORDFINTIME not in", values, "payordfintime");
            return (Criteria) this;
        }

        public Criteria andPayordfintimeBetween(String value1, String value2) {
            addCriterion("PAYORDFINTIME between", value1, value2, "payordfintime");
            return (Criteria) this;
        }

        public Criteria andPayordfintimeNotBetween(String value1, String value2) {
            addCriterion("PAYORDFINTIME not between", value1, value2, "payordfintime");
            return (Criteria) this;
        }

        public Criteria andPayrettsnseqnoIsNull() {
            addCriterion("PAYRETTSNSEQNO is null");
            return (Criteria) this;
        }

        public Criteria andPayrettsnseqnoIsNotNull() {
            addCriterion("PAYRETTSNSEQNO is not null");
            return (Criteria) this;
        }

        public Criteria andPayrettsnseqnoEqualTo(String value) {
            addCriterion("PAYRETTSNSEQNO =", value, "payrettsnseqno");
            return (Criteria) this;
        }

        public Criteria andPayrettsnseqnoNotEqualTo(String value) {
            addCriterion("PAYRETTSNSEQNO <>", value, "payrettsnseqno");
            return (Criteria) this;
        }

        public Criteria andPayrettsnseqnoGreaterThan(String value) {
            addCriterion("PAYRETTSNSEQNO >", value, "payrettsnseqno");
            return (Criteria) this;
        }

        public Criteria andPayrettsnseqnoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYRETTSNSEQNO >=", value, "payrettsnseqno");
            return (Criteria) this;
        }

        public Criteria andPayrettsnseqnoLessThan(String value) {
            addCriterion("PAYRETTSNSEQNO <", value, "payrettsnseqno");
            return (Criteria) this;
        }

        public Criteria andPayrettsnseqnoLessThanOrEqualTo(String value) {
            addCriterion("PAYRETTSNSEQNO <=", value, "payrettsnseqno");
            return (Criteria) this;
        }

        public Criteria andPayrettsnseqnoLike(String value) {
            addCriterion("PAYRETTSNSEQNO like", value, "payrettsnseqno");
            return (Criteria) this;
        }

        public Criteria andPayrettsnseqnoNotLike(String value) {
            addCriterion("PAYRETTSNSEQNO not like", value, "payrettsnseqno");
            return (Criteria) this;
        }

        public Criteria andPayrettsnseqnoIn(List<String> values) {
            addCriterion("PAYRETTSNSEQNO in", values, "payrettsnseqno");
            return (Criteria) this;
        }

        public Criteria andPayrettsnseqnoNotIn(List<String> values) {
            addCriterion("PAYRETTSNSEQNO not in", values, "payrettsnseqno");
            return (Criteria) this;
        }

        public Criteria andPayrettsnseqnoBetween(String value1, String value2) {
            addCriterion("PAYRETTSNSEQNO between", value1, value2, "payrettsnseqno");
            return (Criteria) this;
        }

        public Criteria andPayrettsnseqnoNotBetween(String value1, String value2) {
            addCriterion("PAYRETTSNSEQNO not between", value1, value2, "payrettsnseqno");
            return (Criteria) this;
        }

        public Criteria andPayretcodeIsNull() {
            addCriterion("PAYRETCODE is null");
            return (Criteria) this;
        }

        public Criteria andPayretcodeIsNotNull() {
            addCriterion("PAYRETCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPayretcodeEqualTo(String value) {
            addCriterion("PAYRETCODE =", value, "payretcode");
            return (Criteria) this;
        }

        public Criteria andPayretcodeNotEqualTo(String value) {
            addCriterion("PAYRETCODE <>", value, "payretcode");
            return (Criteria) this;
        }

        public Criteria andPayretcodeGreaterThan(String value) {
            addCriterion("PAYRETCODE >", value, "payretcode");
            return (Criteria) this;
        }

        public Criteria andPayretcodeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYRETCODE >=", value, "payretcode");
            return (Criteria) this;
        }

        public Criteria andPayretcodeLessThan(String value) {
            addCriterion("PAYRETCODE <", value, "payretcode");
            return (Criteria) this;
        }

        public Criteria andPayretcodeLessThanOrEqualTo(String value) {
            addCriterion("PAYRETCODE <=", value, "payretcode");
            return (Criteria) this;
        }

        public Criteria andPayretcodeLike(String value) {
            addCriterion("PAYRETCODE like", value, "payretcode");
            return (Criteria) this;
        }

        public Criteria andPayretcodeNotLike(String value) {
            addCriterion("PAYRETCODE not like", value, "payretcode");
            return (Criteria) this;
        }

        public Criteria andPayretcodeIn(List<String> values) {
            addCriterion("PAYRETCODE in", values, "payretcode");
            return (Criteria) this;
        }

        public Criteria andPayretcodeNotIn(List<String> values) {
            addCriterion("PAYRETCODE not in", values, "payretcode");
            return (Criteria) this;
        }

        public Criteria andPayretcodeBetween(String value1, String value2) {
            addCriterion("PAYRETCODE between", value1, value2, "payretcode");
            return (Criteria) this;
        }

        public Criteria andPayretcodeNotBetween(String value1, String value2) {
            addCriterion("PAYRETCODE not between", value1, value2, "payretcode");
            return (Criteria) this;
        }

        public Criteria andPayretinfoIsNull() {
            addCriterion("PAYRETINFO is null");
            return (Criteria) this;
        }

        public Criteria andPayretinfoIsNotNull() {
            addCriterion("PAYRETINFO is not null");
            return (Criteria) this;
        }

        public Criteria andPayretinfoEqualTo(String value) {
            addCriterion("PAYRETINFO =", value, "payretinfo");
            return (Criteria) this;
        }

        public Criteria andPayretinfoNotEqualTo(String value) {
            addCriterion("PAYRETINFO <>", value, "payretinfo");
            return (Criteria) this;
        }

        public Criteria andPayretinfoGreaterThan(String value) {
            addCriterion("PAYRETINFO >", value, "payretinfo");
            return (Criteria) this;
        }

        public Criteria andPayretinfoGreaterThanOrEqualTo(String value) {
            addCriterion("PAYRETINFO >=", value, "payretinfo");
            return (Criteria) this;
        }

        public Criteria andPayretinfoLessThan(String value) {
            addCriterion("PAYRETINFO <", value, "payretinfo");
            return (Criteria) this;
        }

        public Criteria andPayretinfoLessThanOrEqualTo(String value) {
            addCriterion("PAYRETINFO <=", value, "payretinfo");
            return (Criteria) this;
        }

        public Criteria andPayretinfoLike(String value) {
            addCriterion("PAYRETINFO like", value, "payretinfo");
            return (Criteria) this;
        }

        public Criteria andPayretinfoNotLike(String value) {
            addCriterion("PAYRETINFO not like", value, "payretinfo");
            return (Criteria) this;
        }

        public Criteria andPayretinfoIn(List<String> values) {
            addCriterion("PAYRETINFO in", values, "payretinfo");
            return (Criteria) this;
        }

        public Criteria andPayretinfoNotIn(List<String> values) {
            addCriterion("PAYRETINFO not in", values, "payretinfo");
            return (Criteria) this;
        }

        public Criteria andPayretinfoBetween(String value1, String value2) {
            addCriterion("PAYRETINFO between", value1, value2, "payretinfo");
            return (Criteria) this;
        }

        public Criteria andPayretinfoNotBetween(String value1, String value2) {
            addCriterion("PAYRETINFO not between", value1, value2, "payretinfo");
            return (Criteria) this;
        }

        public Criteria andAppordnoIsNull() {
            addCriterion("APPORDNO is null");
            return (Criteria) this;
        }

        public Criteria andAppordnoIsNotNull() {
            addCriterion("APPORDNO is not null");
            return (Criteria) this;
        }

        public Criteria andAppordnoEqualTo(String value) {
            addCriterion("APPORDNO =", value, "appordno");
            return (Criteria) this;
        }

        public Criteria andAppordnoNotEqualTo(String value) {
            addCriterion("APPORDNO <>", value, "appordno");
            return (Criteria) this;
        }

        public Criteria andAppordnoGreaterThan(String value) {
            addCriterion("APPORDNO >", value, "appordno");
            return (Criteria) this;
        }

        public Criteria andAppordnoGreaterThanOrEqualTo(String value) {
            addCriterion("APPORDNO >=", value, "appordno");
            return (Criteria) this;
        }

        public Criteria andAppordnoLessThan(String value) {
            addCriterion("APPORDNO <", value, "appordno");
            return (Criteria) this;
        }

        public Criteria andAppordnoLessThanOrEqualTo(String value) {
            addCriterion("APPORDNO <=", value, "appordno");
            return (Criteria) this;
        }

        public Criteria andAppordnoLike(String value) {
            addCriterion("APPORDNO like", value, "appordno");
            return (Criteria) this;
        }

        public Criteria andAppordnoNotLike(String value) {
            addCriterion("APPORDNO not like", value, "appordno");
            return (Criteria) this;
        }

        public Criteria andAppordnoIn(List<String> values) {
            addCriterion("APPORDNO in", values, "appordno");
            return (Criteria) this;
        }

        public Criteria andAppordnoNotIn(List<String> values) {
            addCriterion("APPORDNO not in", values, "appordno");
            return (Criteria) this;
        }

        public Criteria andAppordnoBetween(String value1, String value2) {
            addCriterion("APPORDNO between", value1, value2, "appordno");
            return (Criteria) this;
        }

        public Criteria andAppordnoNotBetween(String value1, String value2) {
            addCriterion("APPORDNO not between", value1, value2, "appordno");
            return (Criteria) this;
        }

        public Criteria andAppinstIsNull() {
            addCriterion("APPINST is null");
            return (Criteria) this;
        }

        public Criteria andAppinstIsNotNull() {
            addCriterion("APPINST is not null");
            return (Criteria) this;
        }

        public Criteria andAppinstEqualTo(String value) {
            addCriterion("APPINST =", value, "appinst");
            return (Criteria) this;
        }

        public Criteria andAppinstNotEqualTo(String value) {
            addCriterion("APPINST <>", value, "appinst");
            return (Criteria) this;
        }

        public Criteria andAppinstGreaterThan(String value) {
            addCriterion("APPINST >", value, "appinst");
            return (Criteria) this;
        }

        public Criteria andAppinstGreaterThanOrEqualTo(String value) {
            addCriterion("APPINST >=", value, "appinst");
            return (Criteria) this;
        }

        public Criteria andAppinstLessThan(String value) {
            addCriterion("APPINST <", value, "appinst");
            return (Criteria) this;
        }

        public Criteria andAppinstLessThanOrEqualTo(String value) {
            addCriterion("APPINST <=", value, "appinst");
            return (Criteria) this;
        }

        public Criteria andAppinstLike(String value) {
            addCriterion("APPINST like", value, "appinst");
            return (Criteria) this;
        }

        public Criteria andAppinstNotLike(String value) {
            addCriterion("APPINST not like", value, "appinst");
            return (Criteria) this;
        }

        public Criteria andAppinstIn(List<String> values) {
            addCriterion("APPINST in", values, "appinst");
            return (Criteria) this;
        }

        public Criteria andAppinstNotIn(List<String> values) {
            addCriterion("APPINST not in", values, "appinst");
            return (Criteria) this;
        }

        public Criteria andAppinstBetween(String value1, String value2) {
            addCriterion("APPINST between", value1, value2, "appinst");
            return (Criteria) this;
        }

        public Criteria andAppinstNotBetween(String value1, String value2) {
            addCriterion("APPINST not between", value1, value2, "appinst");
            return (Criteria) this;
        }

        public Criteria andAppordcommitimeIsNull() {
            addCriterion("APPORDCOMMITIME is null");
            return (Criteria) this;
        }

        public Criteria andAppordcommitimeIsNotNull() {
            addCriterion("APPORDCOMMITIME is not null");
            return (Criteria) this;
        }

        public Criteria andAppordcommitimeEqualTo(String value) {
            addCriterion("APPORDCOMMITIME =", value, "appordcommitime");
            return (Criteria) this;
        }

        public Criteria andAppordcommitimeNotEqualTo(String value) {
            addCriterion("APPORDCOMMITIME <>", value, "appordcommitime");
            return (Criteria) this;
        }

        public Criteria andAppordcommitimeGreaterThan(String value) {
            addCriterion("APPORDCOMMITIME >", value, "appordcommitime");
            return (Criteria) this;
        }

        public Criteria andAppordcommitimeGreaterThanOrEqualTo(String value) {
            addCriterion("APPORDCOMMITIME >=", value, "appordcommitime");
            return (Criteria) this;
        }

        public Criteria andAppordcommitimeLessThan(String value) {
            addCriterion("APPORDCOMMITIME <", value, "appordcommitime");
            return (Criteria) this;
        }

        public Criteria andAppordcommitimeLessThanOrEqualTo(String value) {
            addCriterion("APPORDCOMMITIME <=", value, "appordcommitime");
            return (Criteria) this;
        }

        public Criteria andAppordcommitimeLike(String value) {
            addCriterion("APPORDCOMMITIME like", value, "appordcommitime");
            return (Criteria) this;
        }

        public Criteria andAppordcommitimeNotLike(String value) {
            addCriterion("APPORDCOMMITIME not like", value, "appordcommitime");
            return (Criteria) this;
        }

        public Criteria andAppordcommitimeIn(List<String> values) {
            addCriterion("APPORDCOMMITIME in", values, "appordcommitime");
            return (Criteria) this;
        }

        public Criteria andAppordcommitimeNotIn(List<String> values) {
            addCriterion("APPORDCOMMITIME not in", values, "appordcommitime");
            return (Criteria) this;
        }

        public Criteria andAppordcommitimeBetween(String value1, String value2) {
            addCriterion("APPORDCOMMITIME between", value1, value2, "appordcommitime");
            return (Criteria) this;
        }

        public Criteria andAppordcommitimeNotBetween(String value1, String value2) {
            addCriterion("APPORDCOMMITIME not between", value1, value2, "appordcommitime");
            return (Criteria) this;
        }

        public Criteria andAppordfintimeIsNull() {
            addCriterion("APPORDFINTIME is null");
            return (Criteria) this;
        }

        public Criteria andAppordfintimeIsNotNull() {
            addCriterion("APPORDFINTIME is not null");
            return (Criteria) this;
        }

        public Criteria andAppordfintimeEqualTo(String value) {
            addCriterion("APPORDFINTIME =", value, "appordfintime");
            return (Criteria) this;
        }

        public Criteria andAppordfintimeNotEqualTo(String value) {
            addCriterion("APPORDFINTIME <>", value, "appordfintime");
            return (Criteria) this;
        }

        public Criteria andAppordfintimeGreaterThan(String value) {
            addCriterion("APPORDFINTIME >", value, "appordfintime");
            return (Criteria) this;
        }

        public Criteria andAppordfintimeGreaterThanOrEqualTo(String value) {
            addCriterion("APPORDFINTIME >=", value, "appordfintime");
            return (Criteria) this;
        }

        public Criteria andAppordfintimeLessThan(String value) {
            addCriterion("APPORDFINTIME <", value, "appordfintime");
            return (Criteria) this;
        }

        public Criteria andAppordfintimeLessThanOrEqualTo(String value) {
            addCriterion("APPORDFINTIME <=", value, "appordfintime");
            return (Criteria) this;
        }

        public Criteria andAppordfintimeLike(String value) {
            addCriterion("APPORDFINTIME like", value, "appordfintime");
            return (Criteria) this;
        }

        public Criteria andAppordfintimeNotLike(String value) {
            addCriterion("APPORDFINTIME not like", value, "appordfintime");
            return (Criteria) this;
        }

        public Criteria andAppordfintimeIn(List<String> values) {
            addCriterion("APPORDFINTIME in", values, "appordfintime");
            return (Criteria) this;
        }

        public Criteria andAppordfintimeNotIn(List<String> values) {
            addCriterion("APPORDFINTIME not in", values, "appordfintime");
            return (Criteria) this;
        }

        public Criteria andAppordfintimeBetween(String value1, String value2) {
            addCriterion("APPORDFINTIME between", value1, value2, "appordfintime");
            return (Criteria) this;
        }

        public Criteria andAppordfintimeNotBetween(String value1, String value2) {
            addCriterion("APPORDFINTIME not between", value1, value2, "appordfintime");
            return (Criteria) this;
        }

        public Criteria andTradeseltxnIsNull() {
            addCriterion("TRADESELTXN is null");
            return (Criteria) this;
        }

        public Criteria andTradeseltxnIsNotNull() {
            addCriterion("TRADESELTXN is not null");
            return (Criteria) this;
        }

        public Criteria andTradeseltxnEqualTo(String value) {
            addCriterion("TRADESELTXN =", value, "tradeseltxn");
            return (Criteria) this;
        }

        public Criteria andTradeseltxnNotEqualTo(String value) {
            addCriterion("TRADESELTXN <>", value, "tradeseltxn");
            return (Criteria) this;
        }

        public Criteria andTradeseltxnGreaterThan(String value) {
            addCriterion("TRADESELTXN >", value, "tradeseltxn");
            return (Criteria) this;
        }

        public Criteria andTradeseltxnGreaterThanOrEqualTo(String value) {
            addCriterion("TRADESELTXN >=", value, "tradeseltxn");
            return (Criteria) this;
        }

        public Criteria andTradeseltxnLessThan(String value) {
            addCriterion("TRADESELTXN <", value, "tradeseltxn");
            return (Criteria) this;
        }

        public Criteria andTradeseltxnLessThanOrEqualTo(String value) {
            addCriterion("TRADESELTXN <=", value, "tradeseltxn");
            return (Criteria) this;
        }

        public Criteria andTradeseltxnLike(String value) {
            addCriterion("TRADESELTXN like", value, "tradeseltxn");
            return (Criteria) this;
        }

        public Criteria andTradeseltxnNotLike(String value) {
            addCriterion("TRADESELTXN not like", value, "tradeseltxn");
            return (Criteria) this;
        }

        public Criteria andTradeseltxnIn(List<String> values) {
            addCriterion("TRADESELTXN in", values, "tradeseltxn");
            return (Criteria) this;
        }

        public Criteria andTradeseltxnNotIn(List<String> values) {
            addCriterion("TRADESELTXN not in", values, "tradeseltxn");
            return (Criteria) this;
        }

        public Criteria andTradeseltxnBetween(String value1, String value2) {
            addCriterion("TRADESELTXN between", value1, value2, "tradeseltxn");
            return (Criteria) this;
        }

        public Criteria andTradeseltxnNotBetween(String value1, String value2) {
            addCriterion("TRADESELTXN not between", value1, value2, "tradeseltxn");
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

        public Criteria andRetinfoIsNull() {
            addCriterion("RETINFO is null");
            return (Criteria) this;
        }

        public Criteria andRetinfoIsNotNull() {
            addCriterion("RETINFO is not null");
            return (Criteria) this;
        }

        public Criteria andRetinfoEqualTo(String value) {
            addCriterion("RETINFO =", value, "retinfo");
            return (Criteria) this;
        }

        public Criteria andRetinfoNotEqualTo(String value) {
            addCriterion("RETINFO <>", value, "retinfo");
            return (Criteria) this;
        }

        public Criteria andRetinfoGreaterThan(String value) {
            addCriterion("RETINFO >", value, "retinfo");
            return (Criteria) this;
        }

        public Criteria andRetinfoGreaterThanOrEqualTo(String value) {
            addCriterion("RETINFO >=", value, "retinfo");
            return (Criteria) this;
        }

        public Criteria andRetinfoLessThan(String value) {
            addCriterion("RETINFO <", value, "retinfo");
            return (Criteria) this;
        }

        public Criteria andRetinfoLessThanOrEqualTo(String value) {
            addCriterion("RETINFO <=", value, "retinfo");
            return (Criteria) this;
        }

        public Criteria andRetinfoLike(String value) {
            addCriterion("RETINFO like", value, "retinfo");
            return (Criteria) this;
        }

        public Criteria andRetinfoNotLike(String value) {
            addCriterion("RETINFO not like", value, "retinfo");
            return (Criteria) this;
        }

        public Criteria andRetinfoIn(List<String> values) {
            addCriterion("RETINFO in", values, "retinfo");
            return (Criteria) this;
        }

        public Criteria andRetinfoNotIn(List<String> values) {
            addCriterion("RETINFO not in", values, "retinfo");
            return (Criteria) this;
        }

        public Criteria andRetinfoBetween(String value1, String value2) {
            addCriterion("RETINFO between", value1, value2, "retinfo");
            return (Criteria) this;
        }

        public Criteria andRetinfoNotBetween(String value1, String value2) {
            addCriterion("RETINFO not between", value1, value2, "retinfo");
            return (Criteria) this;
        }

        public Criteria andTradestatflagIsNull() {
            addCriterion("TRADESTATFLAG is null");
            return (Criteria) this;
        }

        public Criteria andTradestatflagIsNotNull() {
            addCriterion("TRADESTATFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andTradestatflagEqualTo(String value) {
            addCriterion("TRADESTATFLAG =", value, "tradestatflag");
            return (Criteria) this;
        }

        public Criteria andTradestatflagNotEqualTo(String value) {
            addCriterion("TRADESTATFLAG <>", value, "tradestatflag");
            return (Criteria) this;
        }

        public Criteria andTradestatflagGreaterThan(String value) {
            addCriterion("TRADESTATFLAG >", value, "tradestatflag");
            return (Criteria) this;
        }

        public Criteria andTradestatflagGreaterThanOrEqualTo(String value) {
            addCriterion("TRADESTATFLAG >=", value, "tradestatflag");
            return (Criteria) this;
        }

        public Criteria andTradestatflagLessThan(String value) {
            addCriterion("TRADESTATFLAG <", value, "tradestatflag");
            return (Criteria) this;
        }

        public Criteria andTradestatflagLessThanOrEqualTo(String value) {
            addCriterion("TRADESTATFLAG <=", value, "tradestatflag");
            return (Criteria) this;
        }

        public Criteria andTradestatflagLike(String value) {
            addCriterion("TRADESTATFLAG like", value, "tradestatflag");
            return (Criteria) this;
        }

        public Criteria andTradestatflagNotLike(String value) {
            addCriterion("TRADESTATFLAG not like", value, "tradestatflag");
            return (Criteria) this;
        }

        public Criteria andTradestatflagIn(List<String> values) {
            addCriterion("TRADESTATFLAG in", values, "tradestatflag");
            return (Criteria) this;
        }

        public Criteria andTradestatflagNotIn(List<String> values) {
            addCriterion("TRADESTATFLAG not in", values, "tradestatflag");
            return (Criteria) this;
        }

        public Criteria andTradestatflagBetween(String value1, String value2) {
            addCriterion("TRADESTATFLAG between", value1, value2, "tradestatflag");
            return (Criteria) this;
        }

        public Criteria andTradestatflagNotBetween(String value1, String value2) {
            addCriterion("TRADESTATFLAG not between", value1, value2, "tradestatflag");
            return (Criteria) this;
        }

        public Criteria andTradetxnflagIsNull() {
            addCriterion("TRADETXNFLAG is null");
            return (Criteria) this;
        }

        public Criteria andTradetxnflagIsNotNull() {
            addCriterion("TRADETXNFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andTradetxnflagEqualTo(String value) {
            addCriterion("TRADETXNFLAG =", value, "tradetxnflag");
            return (Criteria) this;
        }

        public Criteria andTradetxnflagNotEqualTo(String value) {
            addCriterion("TRADETXNFLAG <>", value, "tradetxnflag");
            return (Criteria) this;
        }

        public Criteria andTradetxnflagGreaterThan(String value) {
            addCriterion("TRADETXNFLAG >", value, "tradetxnflag");
            return (Criteria) this;
        }

        public Criteria andTradetxnflagGreaterThanOrEqualTo(String value) {
            addCriterion("TRADETXNFLAG >=", value, "tradetxnflag");
            return (Criteria) this;
        }

        public Criteria andTradetxnflagLessThan(String value) {
            addCriterion("TRADETXNFLAG <", value, "tradetxnflag");
            return (Criteria) this;
        }

        public Criteria andTradetxnflagLessThanOrEqualTo(String value) {
            addCriterion("TRADETXNFLAG <=", value, "tradetxnflag");
            return (Criteria) this;
        }

        public Criteria andTradetxnflagLike(String value) {
            addCriterion("TRADETXNFLAG like", value, "tradetxnflag");
            return (Criteria) this;
        }

        public Criteria andTradetxnflagNotLike(String value) {
            addCriterion("TRADETXNFLAG not like", value, "tradetxnflag");
            return (Criteria) this;
        }

        public Criteria andTradetxnflagIn(List<String> values) {
            addCriterion("TRADETXNFLAG in", values, "tradetxnflag");
            return (Criteria) this;
        }

        public Criteria andTradetxnflagNotIn(List<String> values) {
            addCriterion("TRADETXNFLAG not in", values, "tradetxnflag");
            return (Criteria) this;
        }

        public Criteria andTradetxnflagBetween(String value1, String value2) {
            addCriterion("TRADETXNFLAG between", value1, value2, "tradetxnflag");
            return (Criteria) this;
        }

        public Criteria andTradetxnflagNotBetween(String value1, String value2) {
            addCriterion("TRADETXNFLAG not between", value1, value2, "tradetxnflag");
            return (Criteria) this;
        }

        public Criteria andTxncodeIsNull() {
            addCriterion("TXNCODE is null");
            return (Criteria) this;
        }

        public Criteria andTxncodeIsNotNull() {
            addCriterion("TXNCODE is not null");
            return (Criteria) this;
        }

        public Criteria andTxncodeEqualTo(String value) {
            addCriterion("TXNCODE =", value, "txncode");
            return (Criteria) this;
        }

        public Criteria andTxncodeNotEqualTo(String value) {
            addCriterion("TXNCODE <>", value, "txncode");
            return (Criteria) this;
        }

        public Criteria andTxncodeGreaterThan(String value) {
            addCriterion("TXNCODE >", value, "txncode");
            return (Criteria) this;
        }

        public Criteria andTxncodeGreaterThanOrEqualTo(String value) {
            addCriterion("TXNCODE >=", value, "txncode");
            return (Criteria) this;
        }

        public Criteria andTxncodeLessThan(String value) {
            addCriterion("TXNCODE <", value, "txncode");
            return (Criteria) this;
        }

        public Criteria andTxncodeLessThanOrEqualTo(String value) {
            addCriterion("TXNCODE <=", value, "txncode");
            return (Criteria) this;
        }

        public Criteria andTxncodeLike(String value) {
            addCriterion("TXNCODE like", value, "txncode");
            return (Criteria) this;
        }

        public Criteria andTxncodeNotLike(String value) {
            addCriterion("TXNCODE not like", value, "txncode");
            return (Criteria) this;
        }

        public Criteria andTxncodeIn(List<String> values) {
            addCriterion("TXNCODE in", values, "txncode");
            return (Criteria) this;
        }

        public Criteria andTxncodeNotIn(List<String> values) {
            addCriterion("TXNCODE not in", values, "txncode");
            return (Criteria) this;
        }

        public Criteria andTxncodeBetween(String value1, String value2) {
            addCriterion("TXNCODE between", value1, value2, "txncode");
            return (Criteria) this;
        }

        public Criteria andTxncodeNotBetween(String value1, String value2) {
            addCriterion("TXNCODE not between", value1, value2, "txncode");
            return (Criteria) this;
        }

        public Criteria andCashcodeIsNull() {
            addCriterion("CASHCODE is null");
            return (Criteria) this;
        }

        public Criteria andCashcodeIsNotNull() {
            addCriterion("CASHCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCashcodeEqualTo(String value) {
            addCriterion("CASHCODE =", value, "cashcode");
            return (Criteria) this;
        }

        public Criteria andCashcodeNotEqualTo(String value) {
            addCriterion("CASHCODE <>", value, "cashcode");
            return (Criteria) this;
        }

        public Criteria andCashcodeGreaterThan(String value) {
            addCriterion("CASHCODE >", value, "cashcode");
            return (Criteria) this;
        }

        public Criteria andCashcodeGreaterThanOrEqualTo(String value) {
            addCriterion("CASHCODE >=", value, "cashcode");
            return (Criteria) this;
        }

        public Criteria andCashcodeLessThan(String value) {
            addCriterion("CASHCODE <", value, "cashcode");
            return (Criteria) this;
        }

        public Criteria andCashcodeLessThanOrEqualTo(String value) {
            addCriterion("CASHCODE <=", value, "cashcode");
            return (Criteria) this;
        }

        public Criteria andCashcodeLike(String value) {
            addCriterion("CASHCODE like", value, "cashcode");
            return (Criteria) this;
        }

        public Criteria andCashcodeNotLike(String value) {
            addCriterion("CASHCODE not like", value, "cashcode");
            return (Criteria) this;
        }

        public Criteria andCashcodeIn(List<String> values) {
            addCriterion("CASHCODE in", values, "cashcode");
            return (Criteria) this;
        }

        public Criteria andCashcodeNotIn(List<String> values) {
            addCriterion("CASHCODE not in", values, "cashcode");
            return (Criteria) this;
        }

        public Criteria andCashcodeBetween(String value1, String value2) {
            addCriterion("CASHCODE between", value1, value2, "cashcode");
            return (Criteria) this;
        }

        public Criteria andCashcodeNotBetween(String value1, String value2) {
            addCriterion("CASHCODE not between", value1, value2, "cashcode");
            return (Criteria) this;
        }

        public Criteria andRelateIsNull() {
            addCriterion("RELATE is null");
            return (Criteria) this;
        }

        public Criteria andRelateIsNotNull() {
            addCriterion("RELATE is not null");
            return (Criteria) this;
        }

        public Criteria andRelateEqualTo(String value) {
            addCriterion("RELATE =", value, "relate");
            return (Criteria) this;
        }

        public Criteria andRelateNotEqualTo(String value) {
            addCriterion("RELATE <>", value, "relate");
            return (Criteria) this;
        }

        public Criteria andRelateGreaterThan(String value) {
            addCriterion("RELATE >", value, "relate");
            return (Criteria) this;
        }

        public Criteria andRelateGreaterThanOrEqualTo(String value) {
            addCriterion("RELATE >=", value, "relate");
            return (Criteria) this;
        }

        public Criteria andRelateLessThan(String value) {
            addCriterion("RELATE <", value, "relate");
            return (Criteria) this;
        }

        public Criteria andRelateLessThanOrEqualTo(String value) {
            addCriterion("RELATE <=", value, "relate");
            return (Criteria) this;
        }

        public Criteria andRelateLike(String value) {
            addCriterion("RELATE like", value, "relate");
            return (Criteria) this;
        }

        public Criteria andRelateNotLike(String value) {
            addCriterion("RELATE not like", value, "relate");
            return (Criteria) this;
        }

        public Criteria andRelateIn(List<String> values) {
            addCriterion("RELATE in", values, "relate");
            return (Criteria) this;
        }

        public Criteria andRelateNotIn(List<String> values) {
            addCriterion("RELATE not in", values, "relate");
            return (Criteria) this;
        }

        public Criteria andRelateBetween(String value1, String value2) {
            addCriterion("RELATE between", value1, value2, "relate");
            return (Criteria) this;
        }

        public Criteria andRelateNotBetween(String value1, String value2) {
            addCriterion("RELATE not between", value1, value2, "relate");
            return (Criteria) this;
        }

        public Criteria andRetdatetimeIsNull() {
            addCriterion("RETDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andRetdatetimeIsNotNull() {
            addCriterion("RETDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andRetdatetimeEqualTo(String value) {
            addCriterion("RETDATETIME =", value, "retdatetime");
            return (Criteria) this;
        }

        public Criteria andRetdatetimeNotEqualTo(String value) {
            addCriterion("RETDATETIME <>", value, "retdatetime");
            return (Criteria) this;
        }

        public Criteria andRetdatetimeGreaterThan(String value) {
            addCriterion("RETDATETIME >", value, "retdatetime");
            return (Criteria) this;
        }

        public Criteria andRetdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("RETDATETIME >=", value, "retdatetime");
            return (Criteria) this;
        }

        public Criteria andRetdatetimeLessThan(String value) {
            addCriterion("RETDATETIME <", value, "retdatetime");
            return (Criteria) this;
        }

        public Criteria andRetdatetimeLessThanOrEqualTo(String value) {
            addCriterion("RETDATETIME <=", value, "retdatetime");
            return (Criteria) this;
        }

        public Criteria andRetdatetimeLike(String value) {
            addCriterion("RETDATETIME like", value, "retdatetime");
            return (Criteria) this;
        }

        public Criteria andRetdatetimeNotLike(String value) {
            addCriterion("RETDATETIME not like", value, "retdatetime");
            return (Criteria) this;
        }

        public Criteria andRetdatetimeIn(List<String> values) {
            addCriterion("RETDATETIME in", values, "retdatetime");
            return (Criteria) this;
        }

        public Criteria andRetdatetimeNotIn(List<String> values) {
            addCriterion("RETDATETIME not in", values, "retdatetime");
            return (Criteria) this;
        }

        public Criteria andRetdatetimeBetween(String value1, String value2) {
            addCriterion("RETDATETIME between", value1, value2, "retdatetime");
            return (Criteria) this;
        }

        public Criteria andRetdatetimeNotBetween(String value1, String value2) {
            addCriterion("RETDATETIME not between", value1, value2, "retdatetime");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoOgIsNull() {
            addCriterion("TXNSEQNO_OG is null");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoOgIsNotNull() {
            addCriterion("TXNSEQNO_OG is not null");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoOgEqualTo(String value) {
            addCriterion("TXNSEQNO_OG =", value, "txnseqnoOg");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoOgNotEqualTo(String value) {
            addCriterion("TXNSEQNO_OG <>", value, "txnseqnoOg");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoOgGreaterThan(String value) {
            addCriterion("TXNSEQNO_OG >", value, "txnseqnoOg");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoOgGreaterThanOrEqualTo(String value) {
            addCriterion("TXNSEQNO_OG >=", value, "txnseqnoOg");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoOgLessThan(String value) {
            addCriterion("TXNSEQNO_OG <", value, "txnseqnoOg");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoOgLessThanOrEqualTo(String value) {
            addCriterion("TXNSEQNO_OG <=", value, "txnseqnoOg");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoOgLike(String value) {
            addCriterion("TXNSEQNO_OG like", value, "txnseqnoOg");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoOgNotLike(String value) {
            addCriterion("TXNSEQNO_OG not like", value, "txnseqnoOg");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoOgIn(List<String> values) {
            addCriterion("TXNSEQNO_OG in", values, "txnseqnoOg");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoOgNotIn(List<String> values) {
            addCriterion("TXNSEQNO_OG not in", values, "txnseqnoOg");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoOgBetween(String value1, String value2) {
            addCriterion("TXNSEQNO_OG between", value1, value2, "txnseqnoOg");
            return (Criteria) this;
        }

        public Criteria andTxnseqnoOgNotBetween(String value1, String value2) {
            addCriterion("TXNSEQNO_OG not between", value1, value2, "txnseqnoOg");
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

        public Criteria andAccmemberidIsNull() {
            addCriterion("ACCMEMBERID is null");
            return (Criteria) this;
        }

        public Criteria andAccmemberidIsNotNull() {
            addCriterion("ACCMEMBERID is not null");
            return (Criteria) this;
        }

        public Criteria andAccmemberidEqualTo(String value) {
            addCriterion("ACCMEMBERID =", value, "accmemberid");
            return (Criteria) this;
        }

        public Criteria andAccmemberidNotEqualTo(String value) {
            addCriterion("ACCMEMBERID <>", value, "accmemberid");
            return (Criteria) this;
        }

        public Criteria andAccmemberidGreaterThan(String value) {
            addCriterion("ACCMEMBERID >", value, "accmemberid");
            return (Criteria) this;
        }

        public Criteria andAccmemberidGreaterThanOrEqualTo(String value) {
            addCriterion("ACCMEMBERID >=", value, "accmemberid");
            return (Criteria) this;
        }

        public Criteria andAccmemberidLessThan(String value) {
            addCriterion("ACCMEMBERID <", value, "accmemberid");
            return (Criteria) this;
        }

        public Criteria andAccmemberidLessThanOrEqualTo(String value) {
            addCriterion("ACCMEMBERID <=", value, "accmemberid");
            return (Criteria) this;
        }

        public Criteria andAccmemberidLike(String value) {
            addCriterion("ACCMEMBERID like", value, "accmemberid");
            return (Criteria) this;
        }

        public Criteria andAccmemberidNotLike(String value) {
            addCriterion("ACCMEMBERID not like", value, "accmemberid");
            return (Criteria) this;
        }

        public Criteria andAccmemberidIn(List<String> values) {
            addCriterion("ACCMEMBERID in", values, "accmemberid");
            return (Criteria) this;
        }

        public Criteria andAccmemberidNotIn(List<String> values) {
            addCriterion("ACCMEMBERID not in", values, "accmemberid");
            return (Criteria) this;
        }

        public Criteria andAccmemberidBetween(String value1, String value2) {
            addCriterion("ACCMEMBERID between", value1, value2, "accmemberid");
            return (Criteria) this;
        }

        public Criteria andAccmemberidNotBetween(String value1, String value2) {
            addCriterion("ACCMEMBERID not between", value1, value2, "accmemberid");
            return (Criteria) this;
        }

        public Criteria andApporderstatusIsNull() {
            addCriterion("APPORDERSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andApporderstatusIsNotNull() {
            addCriterion("APPORDERSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andApporderstatusEqualTo(String value) {
            addCriterion("APPORDERSTATUS =", value, "apporderstatus");
            return (Criteria) this;
        }

        public Criteria andApporderstatusNotEqualTo(String value) {
            addCriterion("APPORDERSTATUS <>", value, "apporderstatus");
            return (Criteria) this;
        }

        public Criteria andApporderstatusGreaterThan(String value) {
            addCriterion("APPORDERSTATUS >", value, "apporderstatus");
            return (Criteria) this;
        }

        public Criteria andApporderstatusGreaterThanOrEqualTo(String value) {
            addCriterion("APPORDERSTATUS >=", value, "apporderstatus");
            return (Criteria) this;
        }

        public Criteria andApporderstatusLessThan(String value) {
            addCriterion("APPORDERSTATUS <", value, "apporderstatus");
            return (Criteria) this;
        }

        public Criteria andApporderstatusLessThanOrEqualTo(String value) {
            addCriterion("APPORDERSTATUS <=", value, "apporderstatus");
            return (Criteria) this;
        }

        public Criteria andApporderstatusLike(String value) {
            addCriterion("APPORDERSTATUS like", value, "apporderstatus");
            return (Criteria) this;
        }

        public Criteria andApporderstatusNotLike(String value) {
            addCriterion("APPORDERSTATUS not like", value, "apporderstatus");
            return (Criteria) this;
        }

        public Criteria andApporderstatusIn(List<String> values) {
            addCriterion("APPORDERSTATUS in", values, "apporderstatus");
            return (Criteria) this;
        }

        public Criteria andApporderstatusNotIn(List<String> values) {
            addCriterion("APPORDERSTATUS not in", values, "apporderstatus");
            return (Criteria) this;
        }

        public Criteria andApporderstatusBetween(String value1, String value2) {
            addCriterion("APPORDERSTATUS between", value1, value2, "apporderstatus");
            return (Criteria) this;
        }

        public Criteria andApporderstatusNotBetween(String value1, String value2) {
            addCriterion("APPORDERSTATUS not between", value1, value2, "apporderstatus");
            return (Criteria) this;
        }

        public Criteria andApporderinfoIsNull() {
            addCriterion("APPORDERINFO is null");
            return (Criteria) this;
        }

        public Criteria andApporderinfoIsNotNull() {
            addCriterion("APPORDERINFO is not null");
            return (Criteria) this;
        }

        public Criteria andApporderinfoEqualTo(String value) {
            addCriterion("APPORDERINFO =", value, "apporderinfo");
            return (Criteria) this;
        }

        public Criteria andApporderinfoNotEqualTo(String value) {
            addCriterion("APPORDERINFO <>", value, "apporderinfo");
            return (Criteria) this;
        }

        public Criteria andApporderinfoGreaterThan(String value) {
            addCriterion("APPORDERINFO >", value, "apporderinfo");
            return (Criteria) this;
        }

        public Criteria andApporderinfoGreaterThanOrEqualTo(String value) {
            addCriterion("APPORDERINFO >=", value, "apporderinfo");
            return (Criteria) this;
        }

        public Criteria andApporderinfoLessThan(String value) {
            addCriterion("APPORDERINFO <", value, "apporderinfo");
            return (Criteria) this;
        }

        public Criteria andApporderinfoLessThanOrEqualTo(String value) {
            addCriterion("APPORDERINFO <=", value, "apporderinfo");
            return (Criteria) this;
        }

        public Criteria andApporderinfoLike(String value) {
            addCriterion("APPORDERINFO like", value, "apporderinfo");
            return (Criteria) this;
        }

        public Criteria andApporderinfoNotLike(String value) {
            addCriterion("APPORDERINFO not like", value, "apporderinfo");
            return (Criteria) this;
        }

        public Criteria andApporderinfoIn(List<String> values) {
            addCriterion("APPORDERINFO in", values, "apporderinfo");
            return (Criteria) this;
        }

        public Criteria andApporderinfoNotIn(List<String> values) {
            addCriterion("APPORDERINFO not in", values, "apporderinfo");
            return (Criteria) this;
        }

        public Criteria andApporderinfoBetween(String value1, String value2) {
            addCriterion("APPORDERINFO between", value1, value2, "apporderinfo");
            return (Criteria) this;
        }

        public Criteria andApporderinfoNotBetween(String value1, String value2) {
            addCriterion("APPORDERINFO not between", value1, value2, "apporderinfo");
            return (Criteria) this;
        }

        public Criteria andAccbusicodeIsNull() {
            addCriterion("ACCBUSICODE is null");
            return (Criteria) this;
        }

        public Criteria andAccbusicodeIsNotNull() {
            addCriterion("ACCBUSICODE is not null");
            return (Criteria) this;
        }

        public Criteria andAccbusicodeEqualTo(String value) {
            addCriterion("ACCBUSICODE =", value, "accbusicode");
            return (Criteria) this;
        }

        public Criteria andAccbusicodeNotEqualTo(String value) {
            addCriterion("ACCBUSICODE <>", value, "accbusicode");
            return (Criteria) this;
        }

        public Criteria andAccbusicodeGreaterThan(String value) {
            addCriterion("ACCBUSICODE >", value, "accbusicode");
            return (Criteria) this;
        }

        public Criteria andAccbusicodeGreaterThanOrEqualTo(String value) {
            addCriterion("ACCBUSICODE >=", value, "accbusicode");
            return (Criteria) this;
        }

        public Criteria andAccbusicodeLessThan(String value) {
            addCriterion("ACCBUSICODE <", value, "accbusicode");
            return (Criteria) this;
        }

        public Criteria andAccbusicodeLessThanOrEqualTo(String value) {
            addCriterion("ACCBUSICODE <=", value, "accbusicode");
            return (Criteria) this;
        }

        public Criteria andAccbusicodeLike(String value) {
            addCriterion("ACCBUSICODE like", value, "accbusicode");
            return (Criteria) this;
        }

        public Criteria andAccbusicodeNotLike(String value) {
            addCriterion("ACCBUSICODE not like", value, "accbusicode");
            return (Criteria) this;
        }

        public Criteria andAccbusicodeIn(List<String> values) {
            addCriterion("ACCBUSICODE in", values, "accbusicode");
            return (Criteria) this;
        }

        public Criteria andAccbusicodeNotIn(List<String> values) {
            addCriterion("ACCBUSICODE not in", values, "accbusicode");
            return (Criteria) this;
        }

        public Criteria andAccbusicodeBetween(String value1, String value2) {
            addCriterion("ACCBUSICODE between", value1, value2, "accbusicode");
            return (Criteria) this;
        }

        public Criteria andAccbusicodeNotBetween(String value1, String value2) {
            addCriterion("ACCBUSICODE not between", value1, value2, "accbusicode");
            return (Criteria) this;
        }

        public Criteria andAcccoopinstinoIsNull() {
            addCriterion("ACCCOOPINSTINO is null");
            return (Criteria) this;
        }

        public Criteria andAcccoopinstinoIsNotNull() {
            addCriterion("ACCCOOPINSTINO is not null");
            return (Criteria) this;
        }

        public Criteria andAcccoopinstinoEqualTo(String value) {
            addCriterion("ACCCOOPINSTINO =", value, "acccoopinstino");
            return (Criteria) this;
        }

        public Criteria andAcccoopinstinoNotEqualTo(String value) {
            addCriterion("ACCCOOPINSTINO <>", value, "acccoopinstino");
            return (Criteria) this;
        }

        public Criteria andAcccoopinstinoGreaterThan(String value) {
            addCriterion("ACCCOOPINSTINO >", value, "acccoopinstino");
            return (Criteria) this;
        }

        public Criteria andAcccoopinstinoGreaterThanOrEqualTo(String value) {
            addCriterion("ACCCOOPINSTINO >=", value, "acccoopinstino");
            return (Criteria) this;
        }

        public Criteria andAcccoopinstinoLessThan(String value) {
            addCriterion("ACCCOOPINSTINO <", value, "acccoopinstino");
            return (Criteria) this;
        }

        public Criteria andAcccoopinstinoLessThanOrEqualTo(String value) {
            addCriterion("ACCCOOPINSTINO <=", value, "acccoopinstino");
            return (Criteria) this;
        }

        public Criteria andAcccoopinstinoLike(String value) {
            addCriterion("ACCCOOPINSTINO like", value, "acccoopinstino");
            return (Criteria) this;
        }

        public Criteria andAcccoopinstinoNotLike(String value) {
            addCriterion("ACCCOOPINSTINO not like", value, "acccoopinstino");
            return (Criteria) this;
        }

        public Criteria andAcccoopinstinoIn(List<String> values) {
            addCriterion("ACCCOOPINSTINO in", values, "acccoopinstino");
            return (Criteria) this;
        }

        public Criteria andAcccoopinstinoNotIn(List<String> values) {
            addCriterion("ACCCOOPINSTINO not in", values, "acccoopinstino");
            return (Criteria) this;
        }

        public Criteria andAcccoopinstinoBetween(String value1, String value2) {
            addCriterion("ACCCOOPINSTINO between", value1, value2, "acccoopinstino");
            return (Criteria) this;
        }

        public Criteria andAcccoopinstinoNotBetween(String value1, String value2) {
            addCriterion("ACCCOOPINSTINO not between", value1, value2, "acccoopinstino");
            return (Criteria) this;
        }

        public Criteria andPanNameIsNull() {
            addCriterion("PAN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPanNameIsNotNull() {
            addCriterion("PAN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPanNameEqualTo(String value) {
            addCriterion("PAN_NAME =", value, "panName");
            return (Criteria) this;
        }

        public Criteria andPanNameNotEqualTo(String value) {
            addCriterion("PAN_NAME <>", value, "panName");
            return (Criteria) this;
        }

        public Criteria andPanNameGreaterThan(String value) {
            addCriterion("PAN_NAME >", value, "panName");
            return (Criteria) this;
        }

        public Criteria andPanNameGreaterThanOrEqualTo(String value) {
            addCriterion("PAN_NAME >=", value, "panName");
            return (Criteria) this;
        }

        public Criteria andPanNameLessThan(String value) {
            addCriterion("PAN_NAME <", value, "panName");
            return (Criteria) this;
        }

        public Criteria andPanNameLessThanOrEqualTo(String value) {
            addCriterion("PAN_NAME <=", value, "panName");
            return (Criteria) this;
        }

        public Criteria andPanNameLike(String value) {
            addCriterion("PAN_NAME like", value, "panName");
            return (Criteria) this;
        }

        public Criteria andPanNameNotLike(String value) {
            addCriterion("PAN_NAME not like", value, "panName");
            return (Criteria) this;
        }

        public Criteria andPanNameIn(List<String> values) {
            addCriterion("PAN_NAME in", values, "panName");
            return (Criteria) this;
        }

        public Criteria andPanNameNotIn(List<String> values) {
            addCriterion("PAN_NAME not in", values, "panName");
            return (Criteria) this;
        }

        public Criteria andPanNameBetween(String value1, String value2) {
            addCriterion("PAN_NAME between", value1, value2, "panName");
            return (Criteria) this;
        }

        public Criteria andPanNameNotBetween(String value1, String value2) {
            addCriterion("PAN_NAME not between", value1, value2, "panName");
            return (Criteria) this;
        }

        public Criteria andProductcodeIsNull() {
            addCriterion("PRODUCTCODE is null");
            return (Criteria) this;
        }

        public Criteria andProductcodeIsNotNull() {
            addCriterion("PRODUCTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andProductcodeEqualTo(String value) {
            addCriterion("PRODUCTCODE =", value, "productcode");
            return (Criteria) this;
        }

        public Criteria andProductcodeNotEqualTo(String value) {
            addCriterion("PRODUCTCODE <>", value, "productcode");
            return (Criteria) this;
        }

        public Criteria andProductcodeGreaterThan(String value) {
            addCriterion("PRODUCTCODE >", value, "productcode");
            return (Criteria) this;
        }

        public Criteria andProductcodeGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCTCODE >=", value, "productcode");
            return (Criteria) this;
        }

        public Criteria andProductcodeLessThan(String value) {
            addCriterion("PRODUCTCODE <", value, "productcode");
            return (Criteria) this;
        }

        public Criteria andProductcodeLessThanOrEqualTo(String value) {
            addCriterion("PRODUCTCODE <=", value, "productcode");
            return (Criteria) this;
        }

        public Criteria andProductcodeLike(String value) {
            addCriterion("PRODUCTCODE like", value, "productcode");
            return (Criteria) this;
        }

        public Criteria andProductcodeNotLike(String value) {
            addCriterion("PRODUCTCODE not like", value, "productcode");
            return (Criteria) this;
        }

        public Criteria andProductcodeIn(List<String> values) {
            addCriterion("PRODUCTCODE in", values, "productcode");
            return (Criteria) this;
        }

        public Criteria andProductcodeNotIn(List<String> values) {
            addCriterion("PRODUCTCODE not in", values, "productcode");
            return (Criteria) this;
        }

        public Criteria andProductcodeBetween(String value1, String value2) {
            addCriterion("PRODUCTCODE between", value1, value2, "productcode");
            return (Criteria) this;
        }

        public Criteria andProductcodeNotBetween(String value1, String value2) {
            addCriterion("PRODUCTCODE not between", value1, value2, "productcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeIsNull() {
            addCriterion("GROUPCODE is null");
            return (Criteria) this;
        }

        public Criteria andGroupcodeIsNotNull() {
            addCriterion("GROUPCODE is not null");
            return (Criteria) this;
        }

        public Criteria andGroupcodeEqualTo(String value) {
            addCriterion("GROUPCODE =", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeNotEqualTo(String value) {
            addCriterion("GROUPCODE <>", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeGreaterThan(String value) {
            addCriterion("GROUPCODE >", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeGreaterThanOrEqualTo(String value) {
            addCriterion("GROUPCODE >=", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeLessThan(String value) {
            addCriterion("GROUPCODE <", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeLessThanOrEqualTo(String value) {
            addCriterion("GROUPCODE <=", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeLike(String value) {
            addCriterion("GROUPCODE like", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeNotLike(String value) {
            addCriterion("GROUPCODE not like", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeIn(List<String> values) {
            addCriterion("GROUPCODE in", values, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeNotIn(List<String> values) {
            addCriterion("GROUPCODE not in", values, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeBetween(String value1, String value2) {
            addCriterion("GROUPCODE between", value1, value2, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeNotBetween(String value1, String value2) {
            addCriterion("GROUPCODE not between", value1, value2, "groupcode");
            return (Criteria) this;
        }

        public Criteria andInpanNameIsNull() {
            addCriterion("INPAN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andInpanNameIsNotNull() {
            addCriterion("INPAN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andInpanNameEqualTo(String value) {
            addCriterion("INPAN_NAME =", value, "inpanName");
            return (Criteria) this;
        }

        public Criteria andInpanNameNotEqualTo(String value) {
            addCriterion("INPAN_NAME <>", value, "inpanName");
            return (Criteria) this;
        }

        public Criteria andInpanNameGreaterThan(String value) {
            addCriterion("INPAN_NAME >", value, "inpanName");
            return (Criteria) this;
        }

        public Criteria andInpanNameGreaterThanOrEqualTo(String value) {
            addCriterion("INPAN_NAME >=", value, "inpanName");
            return (Criteria) this;
        }

        public Criteria andInpanNameLessThan(String value) {
            addCriterion("INPAN_NAME <", value, "inpanName");
            return (Criteria) this;
        }

        public Criteria andInpanNameLessThanOrEqualTo(String value) {
            addCriterion("INPAN_NAME <=", value, "inpanName");
            return (Criteria) this;
        }

        public Criteria andInpanNameLike(String value) {
            addCriterion("INPAN_NAME like", value, "inpanName");
            return (Criteria) this;
        }

        public Criteria andInpanNameNotLike(String value) {
            addCriterion("INPAN_NAME not like", value, "inpanName");
            return (Criteria) this;
        }

        public Criteria andInpanNameIn(List<String> values) {
            addCriterion("INPAN_NAME in", values, "inpanName");
            return (Criteria) this;
        }

        public Criteria andInpanNameNotIn(List<String> values) {
            addCriterion("INPAN_NAME not in", values, "inpanName");
            return (Criteria) this;
        }

        public Criteria andInpanNameBetween(String value1, String value2) {
            addCriterion("INPAN_NAME between", value1, value2, "inpanName");
            return (Criteria) this;
        }

        public Criteria andInpanNameNotBetween(String value1, String value2) {
            addCriterion("INPAN_NAME not between", value1, value2, "inpanName");
            return (Criteria) this;
        }

        public Criteria andFeepaymodelIsNull() {
            addCriterion("FEEPAYMODEL is null");
            return (Criteria) this;
        }

        public Criteria andFeepaymodelIsNotNull() {
            addCriterion("FEEPAYMODEL is not null");
            return (Criteria) this;
        }

        public Criteria andFeepaymodelEqualTo(String value) {
            addCriterion("FEEPAYMODEL =", value, "feepaymodel");
            return (Criteria) this;
        }

        public Criteria andFeepaymodelNotEqualTo(String value) {
            addCriterion("FEEPAYMODEL <>", value, "feepaymodel");
            return (Criteria) this;
        }

        public Criteria andFeepaymodelGreaterThan(String value) {
            addCriterion("FEEPAYMODEL >", value, "feepaymodel");
            return (Criteria) this;
        }

        public Criteria andFeepaymodelGreaterThanOrEqualTo(String value) {
            addCriterion("FEEPAYMODEL >=", value, "feepaymodel");
            return (Criteria) this;
        }

        public Criteria andFeepaymodelLessThan(String value) {
            addCriterion("FEEPAYMODEL <", value, "feepaymodel");
            return (Criteria) this;
        }

        public Criteria andFeepaymodelLessThanOrEqualTo(String value) {
            addCriterion("FEEPAYMODEL <=", value, "feepaymodel");
            return (Criteria) this;
        }

        public Criteria andFeepaymodelLike(String value) {
            addCriterion("FEEPAYMODEL like", value, "feepaymodel");
            return (Criteria) this;
        }

        public Criteria andFeepaymodelNotLike(String value) {
            addCriterion("FEEPAYMODEL not like", value, "feepaymodel");
            return (Criteria) this;
        }

        public Criteria andFeepaymodelIn(List<String> values) {
            addCriterion("FEEPAYMODEL in", values, "feepaymodel");
            return (Criteria) this;
        }

        public Criteria andFeepaymodelNotIn(List<String> values) {
            addCriterion("FEEPAYMODEL not in", values, "feepaymodel");
            return (Criteria) this;
        }

        public Criteria andFeepaymodelBetween(String value1, String value2) {
            addCriterion("FEEPAYMODEL between", value1, value2, "feepaymodel");
            return (Criteria) this;
        }

        public Criteria andFeepaymodelNotBetween(String value1, String value2) {
            addCriterion("FEEPAYMODEL not between", value1, value2, "feepaymodel");
            return (Criteria) this;
        }

        public Criteria andPathcodeIsNull() {
            addCriterion("PATHCODE is null");
            return (Criteria) this;
        }

        public Criteria andPathcodeIsNotNull() {
            addCriterion("PATHCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPathcodeEqualTo(String value) {
            addCriterion("PATHCODE =", value, "pathcode");
            return (Criteria) this;
        }

        public Criteria andPathcodeNotEqualTo(String value) {
            addCriterion("PATHCODE <>", value, "pathcode");
            return (Criteria) this;
        }

        public Criteria andPathcodeGreaterThan(String value) {
            addCriterion("PATHCODE >", value, "pathcode");
            return (Criteria) this;
        }

        public Criteria andPathcodeGreaterThanOrEqualTo(String value) {
            addCriterion("PATHCODE >=", value, "pathcode");
            return (Criteria) this;
        }

        public Criteria andPathcodeLessThan(String value) {
            addCriterion("PATHCODE <", value, "pathcode");
            return (Criteria) this;
        }

        public Criteria andPathcodeLessThanOrEqualTo(String value) {
            addCriterion("PATHCODE <=", value, "pathcode");
            return (Criteria) this;
        }

        public Criteria andPathcodeLike(String value) {
            addCriterion("PATHCODE like", value, "pathcode");
            return (Criteria) this;
        }

        public Criteria andPathcodeNotLike(String value) {
            addCriterion("PATHCODE not like", value, "pathcode");
            return (Criteria) this;
        }

        public Criteria andPathcodeIn(List<String> values) {
            addCriterion("PATHCODE in", values, "pathcode");
            return (Criteria) this;
        }

        public Criteria andPathcodeNotIn(List<String> values) {
            addCriterion("PATHCODE not in", values, "pathcode");
            return (Criteria) this;
        }

        public Criteria andPathcodeBetween(String value1, String value2) {
            addCriterion("PATHCODE between", value1, value2, "pathcode");
            return (Criteria) this;
        }

        public Criteria andPathcodeNotBetween(String value1, String value2) {
            addCriterion("PATHCODE not between", value1, value2, "pathcode");
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
    /*条件添加*/
    private String accsecmerno;
    private String apporderstatus;
    private String pan;
    private String pathcode;
    private String startdate;
    private String enddate;
    private String starttime;
    private String endtime;

	public String getAccsecmerno() {
		return accsecmerno;
	}

	public void setAccsecmerno(String accsecmerno) {
		this.accsecmerno = accsecmerno;
	}

	public String getApporderstatus() {
		return apporderstatus;
	}

	public void setApporderstatus(String apporderstatus) {
		this.apporderstatus = apporderstatus;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPathcode() {
		return pathcode;
	}

	public void setPathcode(String pathcode) {
		this.pathcode = pathcode;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	
    
}