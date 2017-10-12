package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TChnlCpdkLogExample {
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

    public TChnlCpdkLogExample() {
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

        public Criteria andOpenbankidIsNull() {
            addCriterion("openBankId is null");
            return (Criteria) this;
        }

        public Criteria andOpenbankidIsNotNull() {
            addCriterion("openBankId is not null");
            return (Criteria) this;
        }

        public Criteria andOpenbankidEqualTo(String value) {
            addCriterion("openBankId =", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidNotEqualTo(String value) {
            addCriterion("openBankId <>", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidGreaterThan(String value) {
            addCriterion("openBankId >", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidGreaterThanOrEqualTo(String value) {
            addCriterion("openBankId >=", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidLessThan(String value) {
            addCriterion("openBankId <", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidLessThanOrEqualTo(String value) {
            addCriterion("openBankId <=", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidLike(String value) {
            addCriterion("openBankId like", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidNotLike(String value) {
            addCriterion("openBankId not like", value, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidIn(List<String> values) {
            addCriterion("openBankId in", values, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidNotIn(List<String> values) {
            addCriterion("openBankId not in", values, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidBetween(String value1, String value2) {
            addCriterion("openBankId between", value1, value2, "openbankid");
            return (Criteria) this;
        }

        public Criteria andOpenbankidNotBetween(String value1, String value2) {
            addCriterion("openBankId not between", value1, value2, "openbankid");
            return (Criteria) this;
        }

        public Criteria andCardtypeIsNull() {
            addCriterion("cardType is null");
            return (Criteria) this;
        }

        public Criteria andCardtypeIsNotNull() {
            addCriterion("cardType is not null");
            return (Criteria) this;
        }

        public Criteria andCardtypeEqualTo(String value) {
            addCriterion("cardType =", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotEqualTo(String value) {
            addCriterion("cardType <>", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeGreaterThan(String value) {
            addCriterion("cardType >", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeGreaterThanOrEqualTo(String value) {
            addCriterion("cardType >=", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLessThan(String value) {
            addCriterion("cardType <", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLessThanOrEqualTo(String value) {
            addCriterion("cardType <=", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLike(String value) {
            addCriterion("cardType like", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotLike(String value) {
            addCriterion("cardType not like", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeIn(List<String> values) {
            addCriterion("cardType in", values, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotIn(List<String> values) {
            addCriterion("cardType not in", values, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeBetween(String value1, String value2) {
            addCriterion("cardType between", value1, value2, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotBetween(String value1, String value2) {
            addCriterion("cardType not between", value1, value2, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardnoIsNull() {
            addCriterion("cardNo is null");
            return (Criteria) this;
        }

        public Criteria andCardnoIsNotNull() {
            addCriterion("cardNo is not null");
            return (Criteria) this;
        }

        public Criteria andCardnoEqualTo(String value) {
            addCriterion("cardNo =", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotEqualTo(String value) {
            addCriterion("cardNo <>", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoGreaterThan(String value) {
            addCriterion("cardNo >", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoGreaterThanOrEqualTo(String value) {
            addCriterion("cardNo >=", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLessThan(String value) {
            addCriterion("cardNo <", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLessThanOrEqualTo(String value) {
            addCriterion("cardNo <=", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoLike(String value) {
            addCriterion("cardNo like", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotLike(String value) {
            addCriterion("cardNo not like", value, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoIn(List<String> values) {
            addCriterion("cardNo in", values, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotIn(List<String> values) {
            addCriterion("cardNo not in", values, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoBetween(String value1, String value2) {
            addCriterion("cardNo between", value1, value2, "cardno");
            return (Criteria) this;
        }

        public Criteria andCardnoNotBetween(String value1, String value2) {
            addCriterion("cardNo not between", value1, value2, "cardno");
            return (Criteria) this;
        }

        public Criteria andUsrnameIsNull() {
            addCriterion("usrName is null");
            return (Criteria) this;
        }

        public Criteria andUsrnameIsNotNull() {
            addCriterion("usrName is not null");
            return (Criteria) this;
        }

        public Criteria andUsrnameEqualTo(String value) {
            addCriterion("usrName =", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameNotEqualTo(String value) {
            addCriterion("usrName <>", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameGreaterThan(String value) {
            addCriterion("usrName >", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameGreaterThanOrEqualTo(String value) {
            addCriterion("usrName >=", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameLessThan(String value) {
            addCriterion("usrName <", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameLessThanOrEqualTo(String value) {
            addCriterion("usrName <=", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameLike(String value) {
            addCriterion("usrName like", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameNotLike(String value) {
            addCriterion("usrName not like", value, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameIn(List<String> values) {
            addCriterion("usrName in", values, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameNotIn(List<String> values) {
            addCriterion("usrName not in", values, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameBetween(String value1, String value2) {
            addCriterion("usrName between", value1, value2, "usrname");
            return (Criteria) this;
        }

        public Criteria andUsrnameNotBetween(String value1, String value2) {
            addCriterion("usrName not between", value1, value2, "usrname");
            return (Criteria) this;
        }

        public Criteria andCerttypeIsNull() {
            addCriterion("certType is null");
            return (Criteria) this;
        }

        public Criteria andCerttypeIsNotNull() {
            addCriterion("certType is not null");
            return (Criteria) this;
        }

        public Criteria andCerttypeEqualTo(String value) {
            addCriterion("certType =", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeNotEqualTo(String value) {
            addCriterion("certType <>", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeGreaterThan(String value) {
            addCriterion("certType >", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeGreaterThanOrEqualTo(String value) {
            addCriterion("certType >=", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeLessThan(String value) {
            addCriterion("certType <", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeLessThanOrEqualTo(String value) {
            addCriterion("certType <=", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeLike(String value) {
            addCriterion("certType like", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeNotLike(String value) {
            addCriterion("certType not like", value, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeIn(List<String> values) {
            addCriterion("certType in", values, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeNotIn(List<String> values) {
            addCriterion("certType not in", values, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeBetween(String value1, String value2) {
            addCriterion("certType between", value1, value2, "certtype");
            return (Criteria) this;
        }

        public Criteria andCerttypeNotBetween(String value1, String value2) {
            addCriterion("certType not between", value1, value2, "certtype");
            return (Criteria) this;
        }

        public Criteria andCertidIsNull() {
            addCriterion("certId is null");
            return (Criteria) this;
        }

        public Criteria andCertidIsNotNull() {
            addCriterion("certId is not null");
            return (Criteria) this;
        }

        public Criteria andCertidEqualTo(String value) {
            addCriterion("certId =", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotEqualTo(String value) {
            addCriterion("certId <>", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidGreaterThan(String value) {
            addCriterion("certId >", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidGreaterThanOrEqualTo(String value) {
            addCriterion("certId >=", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLessThan(String value) {
            addCriterion("certId <", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLessThanOrEqualTo(String value) {
            addCriterion("certId <=", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLike(String value) {
            addCriterion("certId like", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotLike(String value) {
            addCriterion("certId not like", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidIn(List<String> values) {
            addCriterion("certId in", values, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotIn(List<String> values) {
            addCriterion("certId not in", values, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidBetween(String value1, String value2) {
            addCriterion("certId between", value1, value2, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotBetween(String value1, String value2) {
            addCriterion("certId not between", value1, value2, "certid");
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

        public Criteria andPurposeIsNull() {
            addCriterion("purpose is null");
            return (Criteria) this;
        }

        public Criteria andPurposeIsNotNull() {
            addCriterion("purpose is not null");
            return (Criteria) this;
        }

        public Criteria andPurposeEqualTo(String value) {
            addCriterion("purpose =", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotEqualTo(String value) {
            addCriterion("purpose <>", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThan(String value) {
            addCriterion("purpose >", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("purpose >=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThan(String value) {
            addCriterion("purpose <", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThanOrEqualTo(String value) {
            addCriterion("purpose <=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLike(String value) {
            addCriterion("purpose like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotLike(String value) {
            addCriterion("purpose not like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeIn(List<String> values) {
            addCriterion("purpose in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotIn(List<String> values) {
            addCriterion("purpose not in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeBetween(String value1, String value2) {
            addCriterion("purpose between", value1, value2, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotBetween(String value1, String value2) {
            addCriterion("purpose not between", value1, value2, "purpose");
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

        public Criteria andGateidIsNull() {
            addCriterion("gateId is null");
            return (Criteria) this;
        }

        public Criteria andGateidIsNotNull() {
            addCriterion("gateId is not null");
            return (Criteria) this;
        }

        public Criteria andGateidEqualTo(String value) {
            addCriterion("gateId =", value, "gateid");
            return (Criteria) this;
        }

        public Criteria andGateidNotEqualTo(String value) {
            addCriterion("gateId <>", value, "gateid");
            return (Criteria) this;
        }

        public Criteria andGateidGreaterThan(String value) {
            addCriterion("gateId >", value, "gateid");
            return (Criteria) this;
        }

        public Criteria andGateidGreaterThanOrEqualTo(String value) {
            addCriterion("gateId >=", value, "gateid");
            return (Criteria) this;
        }

        public Criteria andGateidLessThan(String value) {
            addCriterion("gateId <", value, "gateid");
            return (Criteria) this;
        }

        public Criteria andGateidLessThanOrEqualTo(String value) {
            addCriterion("gateId <=", value, "gateid");
            return (Criteria) this;
        }

        public Criteria andGateidLike(String value) {
            addCriterion("gateId like", value, "gateid");
            return (Criteria) this;
        }

        public Criteria andGateidNotLike(String value) {
            addCriterion("gateId not like", value, "gateid");
            return (Criteria) this;
        }

        public Criteria andGateidIn(List<String> values) {
            addCriterion("gateId in", values, "gateid");
            return (Criteria) this;
        }

        public Criteria andGateidNotIn(List<String> values) {
            addCriterion("gateId not in", values, "gateid");
            return (Criteria) this;
        }

        public Criteria andGateidBetween(String value1, String value2) {
            addCriterion("gateId between", value1, value2, "gateid");
            return (Criteria) this;
        }

        public Criteria andGateidNotBetween(String value1, String value2) {
            addCriterion("gateId not between", value1, value2, "gateid");
            return (Criteria) this;
        }

        public Criteria andTermtypeIsNull() {
            addCriterion("termType is null");
            return (Criteria) this;
        }

        public Criteria andTermtypeIsNotNull() {
            addCriterion("termType is not null");
            return (Criteria) this;
        }

        public Criteria andTermtypeEqualTo(String value) {
            addCriterion("termType =", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeNotEqualTo(String value) {
            addCriterion("termType <>", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeGreaterThan(String value) {
            addCriterion("termType >", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeGreaterThanOrEqualTo(String value) {
            addCriterion("termType >=", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeLessThan(String value) {
            addCriterion("termType <", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeLessThanOrEqualTo(String value) {
            addCriterion("termType <=", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeLike(String value) {
            addCriterion("termType like", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeNotLike(String value) {
            addCriterion("termType not like", value, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeIn(List<String> values) {
            addCriterion("termType in", values, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeNotIn(List<String> values) {
            addCriterion("termType not in", values, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeBetween(String value1, String value2) {
            addCriterion("termType between", value1, value2, "termtype");
            return (Criteria) this;
        }

        public Criteria andTermtypeNotBetween(String value1, String value2) {
            addCriterion("termType not between", value1, value2, "termtype");
            return (Criteria) this;
        }

        public Criteria andPaymodeIsNull() {
            addCriterion("payMode is null");
            return (Criteria) this;
        }

        public Criteria andPaymodeIsNotNull() {
            addCriterion("payMode is not null");
            return (Criteria) this;
        }

        public Criteria andPaymodeEqualTo(String value) {
            addCriterion("payMode =", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeNotEqualTo(String value) {
            addCriterion("payMode <>", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeGreaterThan(String value) {
            addCriterion("payMode >", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeGreaterThanOrEqualTo(String value) {
            addCriterion("payMode >=", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeLessThan(String value) {
            addCriterion("payMode <", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeLessThanOrEqualTo(String value) {
            addCriterion("payMode <=", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeLike(String value) {
            addCriterion("payMode like", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeNotLike(String value) {
            addCriterion("payMode not like", value, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeIn(List<String> values) {
            addCriterion("payMode in", values, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeNotIn(List<String> values) {
            addCriterion("payMode not in", values, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeBetween(String value1, String value2) {
            addCriterion("payMode between", value1, value2, "paymode");
            return (Criteria) this;
        }

        public Criteria andPaymodeNotBetween(String value1, String value2) {
            addCriterion("payMode not between", value1, value2, "paymode");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUserregistertimeIsNull() {
            addCriterion("userRegisterTime is null");
            return (Criteria) this;
        }

        public Criteria andUserregistertimeIsNotNull() {
            addCriterion("userRegisterTime is not null");
            return (Criteria) this;
        }

        public Criteria andUserregistertimeEqualTo(String value) {
            addCriterion("userRegisterTime =", value, "userregistertime");
            return (Criteria) this;
        }

        public Criteria andUserregistertimeNotEqualTo(String value) {
            addCriterion("userRegisterTime <>", value, "userregistertime");
            return (Criteria) this;
        }

        public Criteria andUserregistertimeGreaterThan(String value) {
            addCriterion("userRegisterTime >", value, "userregistertime");
            return (Criteria) this;
        }

        public Criteria andUserregistertimeGreaterThanOrEqualTo(String value) {
            addCriterion("userRegisterTime >=", value, "userregistertime");
            return (Criteria) this;
        }

        public Criteria andUserregistertimeLessThan(String value) {
            addCriterion("userRegisterTime <", value, "userregistertime");
            return (Criteria) this;
        }

        public Criteria andUserregistertimeLessThanOrEqualTo(String value) {
            addCriterion("userRegisterTime <=", value, "userregistertime");
            return (Criteria) this;
        }

        public Criteria andUserregistertimeLike(String value) {
            addCriterion("userRegisterTime like", value, "userregistertime");
            return (Criteria) this;
        }

        public Criteria andUserregistertimeNotLike(String value) {
            addCriterion("userRegisterTime not like", value, "userregistertime");
            return (Criteria) this;
        }

        public Criteria andUserregistertimeIn(List<String> values) {
            addCriterion("userRegisterTime in", values, "userregistertime");
            return (Criteria) this;
        }

        public Criteria andUserregistertimeNotIn(List<String> values) {
            addCriterion("userRegisterTime not in", values, "userregistertime");
            return (Criteria) this;
        }

        public Criteria andUserregistertimeBetween(String value1, String value2) {
            addCriterion("userRegisterTime between", value1, value2, "userregistertime");
            return (Criteria) this;
        }

        public Criteria andUserregistertimeNotBetween(String value1, String value2) {
            addCriterion("userRegisterTime not between", value1, value2, "userregistertime");
            return (Criteria) this;
        }

        public Criteria andUsermailIsNull() {
            addCriterion("userMail is null");
            return (Criteria) this;
        }

        public Criteria andUsermailIsNotNull() {
            addCriterion("userMail is not null");
            return (Criteria) this;
        }

        public Criteria andUsermailEqualTo(String value) {
            addCriterion("userMail =", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailNotEqualTo(String value) {
            addCriterion("userMail <>", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailGreaterThan(String value) {
            addCriterion("userMail >", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailGreaterThanOrEqualTo(String value) {
            addCriterion("userMail >=", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailLessThan(String value) {
            addCriterion("userMail <", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailLessThanOrEqualTo(String value) {
            addCriterion("userMail <=", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailLike(String value) {
            addCriterion("userMail like", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailNotLike(String value) {
            addCriterion("userMail not like", value, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailIn(List<String> values) {
            addCriterion("userMail in", values, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailNotIn(List<String> values) {
            addCriterion("userMail not in", values, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailBetween(String value1, String value2) {
            addCriterion("userMail between", value1, value2, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermailNotBetween(String value1, String value2) {
            addCriterion("userMail not between", value1, value2, "usermail");
            return (Criteria) this;
        }

        public Criteria andUsermobileIsNull() {
            addCriterion("userMobile is null");
            return (Criteria) this;
        }

        public Criteria andUsermobileIsNotNull() {
            addCriterion("userMobile is not null");
            return (Criteria) this;
        }

        public Criteria andUsermobileEqualTo(String value) {
            addCriterion("userMobile =", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileNotEqualTo(String value) {
            addCriterion("userMobile <>", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileGreaterThan(String value) {
            addCriterion("userMobile >", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileGreaterThanOrEqualTo(String value) {
            addCriterion("userMobile >=", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileLessThan(String value) {
            addCriterion("userMobile <", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileLessThanOrEqualTo(String value) {
            addCriterion("userMobile <=", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileLike(String value) {
            addCriterion("userMobile like", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileNotLike(String value) {
            addCriterion("userMobile not like", value, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileIn(List<String> values) {
            addCriterion("userMobile in", values, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileNotIn(List<String> values) {
            addCriterion("userMobile not in", values, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileBetween(String value1, String value2) {
            addCriterion("userMobile between", value1, value2, "usermobile");
            return (Criteria) this;
        }

        public Criteria andUsermobileNotBetween(String value1, String value2) {
            addCriterion("userMobile not between", value1, value2, "usermobile");
            return (Criteria) this;
        }

        public Criteria andDisksnIsNull() {
            addCriterion("diskSn is null");
            return (Criteria) this;
        }

        public Criteria andDisksnIsNotNull() {
            addCriterion("diskSn is not null");
            return (Criteria) this;
        }

        public Criteria andDisksnEqualTo(String value) {
            addCriterion("diskSn =", value, "disksn");
            return (Criteria) this;
        }

        public Criteria andDisksnNotEqualTo(String value) {
            addCriterion("diskSn <>", value, "disksn");
            return (Criteria) this;
        }

        public Criteria andDisksnGreaterThan(String value) {
            addCriterion("diskSn >", value, "disksn");
            return (Criteria) this;
        }

        public Criteria andDisksnGreaterThanOrEqualTo(String value) {
            addCriterion("diskSn >=", value, "disksn");
            return (Criteria) this;
        }

        public Criteria andDisksnLessThan(String value) {
            addCriterion("diskSn <", value, "disksn");
            return (Criteria) this;
        }

        public Criteria andDisksnLessThanOrEqualTo(String value) {
            addCriterion("diskSn <=", value, "disksn");
            return (Criteria) this;
        }

        public Criteria andDisksnLike(String value) {
            addCriterion("diskSn like", value, "disksn");
            return (Criteria) this;
        }

        public Criteria andDisksnNotLike(String value) {
            addCriterion("diskSn not like", value, "disksn");
            return (Criteria) this;
        }

        public Criteria andDisksnIn(List<String> values) {
            addCriterion("diskSn in", values, "disksn");
            return (Criteria) this;
        }

        public Criteria andDisksnNotIn(List<String> values) {
            addCriterion("diskSn not in", values, "disksn");
            return (Criteria) this;
        }

        public Criteria andDisksnBetween(String value1, String value2) {
            addCriterion("diskSn between", value1, value2, "disksn");
            return (Criteria) this;
        }

        public Criteria andDisksnNotBetween(String value1, String value2) {
            addCriterion("diskSn not between", value1, value2, "disksn");
            return (Criteria) this;
        }

        public Criteria andMacIsNull() {
            addCriterion("mac is null");
            return (Criteria) this;
        }

        public Criteria andMacIsNotNull() {
            addCriterion("mac is not null");
            return (Criteria) this;
        }

        public Criteria andMacEqualTo(String value) {
            addCriterion("mac =", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotEqualTo(String value) {
            addCriterion("mac <>", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThan(String value) {
            addCriterion("mac >", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThanOrEqualTo(String value) {
            addCriterion("mac >=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThan(String value) {
            addCriterion("mac <", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThanOrEqualTo(String value) {
            addCriterion("mac <=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLike(String value) {
            addCriterion("mac like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotLike(String value) {
            addCriterion("mac not like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacIn(List<String> values) {
            addCriterion("mac in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotIn(List<String> values) {
            addCriterion("mac not in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacBetween(String value1, String value2) {
            addCriterion("mac between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotBetween(String value1, String value2) {
            addCriterion("mac not between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andImeiIsNull() {
            addCriterion("imei is null");
            return (Criteria) this;
        }

        public Criteria andImeiIsNotNull() {
            addCriterion("imei is not null");
            return (Criteria) this;
        }

        public Criteria andImeiEqualTo(String value) {
            addCriterion("imei =", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotEqualTo(String value) {
            addCriterion("imei <>", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiGreaterThan(String value) {
            addCriterion("imei >", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiGreaterThanOrEqualTo(String value) {
            addCriterion("imei >=", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLessThan(String value) {
            addCriterion("imei <", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLessThanOrEqualTo(String value) {
            addCriterion("imei <=", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLike(String value) {
            addCriterion("imei like", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotLike(String value) {
            addCriterion("imei not like", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiIn(List<String> values) {
            addCriterion("imei in", values, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotIn(List<String> values) {
            addCriterion("imei not in", values, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiBetween(String value1, String value2) {
            addCriterion("imei between", value1, value2, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotBetween(String value1, String value2) {
            addCriterion("imei not between", value1, value2, "imei");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andCoordinatesIsNull() {
            addCriterion("coordinates is null");
            return (Criteria) this;
        }

        public Criteria andCoordinatesIsNotNull() {
            addCriterion("coordinates is not null");
            return (Criteria) this;
        }

        public Criteria andCoordinatesEqualTo(String value) {
            addCriterion("coordinates =", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesNotEqualTo(String value) {
            addCriterion("coordinates <>", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesGreaterThan(String value) {
            addCriterion("coordinates >", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesGreaterThanOrEqualTo(String value) {
            addCriterion("coordinates >=", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesLessThan(String value) {
            addCriterion("coordinates <", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesLessThanOrEqualTo(String value) {
            addCriterion("coordinates <=", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesLike(String value) {
            addCriterion("coordinates like", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesNotLike(String value) {
            addCriterion("coordinates not like", value, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesIn(List<String> values) {
            addCriterion("coordinates in", values, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesNotIn(List<String> values) {
            addCriterion("coordinates not in", values, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesBetween(String value1, String value2) {
            addCriterion("coordinates between", value1, value2, "coordinates");
            return (Criteria) this;
        }

        public Criteria andCoordinatesNotBetween(String value1, String value2) {
            addCriterion("coordinates not between", value1, value2, "coordinates");
            return (Criteria) this;
        }

        public Criteria andBasestationsnIsNull() {
            addCriterion("baseStationSn is null");
            return (Criteria) this;
        }

        public Criteria andBasestationsnIsNotNull() {
            addCriterion("baseStationSn is not null");
            return (Criteria) this;
        }

        public Criteria andBasestationsnEqualTo(String value) {
            addCriterion("baseStationSn =", value, "basestationsn");
            return (Criteria) this;
        }

        public Criteria andBasestationsnNotEqualTo(String value) {
            addCriterion("baseStationSn <>", value, "basestationsn");
            return (Criteria) this;
        }

        public Criteria andBasestationsnGreaterThan(String value) {
            addCriterion("baseStationSn >", value, "basestationsn");
            return (Criteria) this;
        }

        public Criteria andBasestationsnGreaterThanOrEqualTo(String value) {
            addCriterion("baseStationSn >=", value, "basestationsn");
            return (Criteria) this;
        }

        public Criteria andBasestationsnLessThan(String value) {
            addCriterion("baseStationSn <", value, "basestationsn");
            return (Criteria) this;
        }

        public Criteria andBasestationsnLessThanOrEqualTo(String value) {
            addCriterion("baseStationSn <=", value, "basestationsn");
            return (Criteria) this;
        }

        public Criteria andBasestationsnLike(String value) {
            addCriterion("baseStationSn like", value, "basestationsn");
            return (Criteria) this;
        }

        public Criteria andBasestationsnNotLike(String value) {
            addCriterion("baseStationSn not like", value, "basestationsn");
            return (Criteria) this;
        }

        public Criteria andBasestationsnIn(List<String> values) {
            addCriterion("baseStationSn in", values, "basestationsn");
            return (Criteria) this;
        }

        public Criteria andBasestationsnNotIn(List<String> values) {
            addCriterion("baseStationSn not in", values, "basestationsn");
            return (Criteria) this;
        }

        public Criteria andBasestationsnBetween(String value1, String value2) {
            addCriterion("baseStationSn between", value1, value2, "basestationsn");
            return (Criteria) this;
        }

        public Criteria andBasestationsnNotBetween(String value1, String value2) {
            addCriterion("baseStationSn not between", value1, value2, "basestationsn");
            return (Criteria) this;
        }

        public Criteria andCodeinputtypeIsNull() {
            addCriterion("codeInputType is null");
            return (Criteria) this;
        }

        public Criteria andCodeinputtypeIsNotNull() {
            addCriterion("codeInputType is not null");
            return (Criteria) this;
        }

        public Criteria andCodeinputtypeEqualTo(String value) {
            addCriterion("codeInputType =", value, "codeinputtype");
            return (Criteria) this;
        }

        public Criteria andCodeinputtypeNotEqualTo(String value) {
            addCriterion("codeInputType <>", value, "codeinputtype");
            return (Criteria) this;
        }

        public Criteria andCodeinputtypeGreaterThan(String value) {
            addCriterion("codeInputType >", value, "codeinputtype");
            return (Criteria) this;
        }

        public Criteria andCodeinputtypeGreaterThanOrEqualTo(String value) {
            addCriterion("codeInputType >=", value, "codeinputtype");
            return (Criteria) this;
        }

        public Criteria andCodeinputtypeLessThan(String value) {
            addCriterion("codeInputType <", value, "codeinputtype");
            return (Criteria) this;
        }

        public Criteria andCodeinputtypeLessThanOrEqualTo(String value) {
            addCriterion("codeInputType <=", value, "codeinputtype");
            return (Criteria) this;
        }

        public Criteria andCodeinputtypeLike(String value) {
            addCriterion("codeInputType like", value, "codeinputtype");
            return (Criteria) this;
        }

        public Criteria andCodeinputtypeNotLike(String value) {
            addCriterion("codeInputType not like", value, "codeinputtype");
            return (Criteria) this;
        }

        public Criteria andCodeinputtypeIn(List<String> values) {
            addCriterion("codeInputType in", values, "codeinputtype");
            return (Criteria) this;
        }

        public Criteria andCodeinputtypeNotIn(List<String> values) {
            addCriterion("codeInputType not in", values, "codeinputtype");
            return (Criteria) this;
        }

        public Criteria andCodeinputtypeBetween(String value1, String value2) {
            addCriterion("codeInputType between", value1, value2, "codeinputtype");
            return (Criteria) this;
        }

        public Criteria andCodeinputtypeNotBetween(String value1, String value2) {
            addCriterion("codeInputType not between", value1, value2, "codeinputtype");
            return (Criteria) this;
        }

        public Criteria andMobileforbankIsNull() {
            addCriterion("mobileForBank is null");
            return (Criteria) this;
        }

        public Criteria andMobileforbankIsNotNull() {
            addCriterion("mobileForBank is not null");
            return (Criteria) this;
        }

        public Criteria andMobileforbankEqualTo(String value) {
            addCriterion("mobileForBank =", value, "mobileforbank");
            return (Criteria) this;
        }

        public Criteria andMobileforbankNotEqualTo(String value) {
            addCriterion("mobileForBank <>", value, "mobileforbank");
            return (Criteria) this;
        }

        public Criteria andMobileforbankGreaterThan(String value) {
            addCriterion("mobileForBank >", value, "mobileforbank");
            return (Criteria) this;
        }

        public Criteria andMobileforbankGreaterThanOrEqualTo(String value) {
            addCriterion("mobileForBank >=", value, "mobileforbank");
            return (Criteria) this;
        }

        public Criteria andMobileforbankLessThan(String value) {
            addCriterion("mobileForBank <", value, "mobileforbank");
            return (Criteria) this;
        }

        public Criteria andMobileforbankLessThanOrEqualTo(String value) {
            addCriterion("mobileForBank <=", value, "mobileforbank");
            return (Criteria) this;
        }

        public Criteria andMobileforbankLike(String value) {
            addCriterion("mobileForBank like", value, "mobileforbank");
            return (Criteria) this;
        }

        public Criteria andMobileforbankNotLike(String value) {
            addCriterion("mobileForBank not like", value, "mobileforbank");
            return (Criteria) this;
        }

        public Criteria andMobileforbankIn(List<String> values) {
            addCriterion("mobileForBank in", values, "mobileforbank");
            return (Criteria) this;
        }

        public Criteria andMobileforbankNotIn(List<String> values) {
            addCriterion("mobileForBank not in", values, "mobileforbank");
            return (Criteria) this;
        }

        public Criteria andMobileforbankBetween(String value1, String value2) {
            addCriterion("mobileForBank between", value1, value2, "mobileforbank");
            return (Criteria) this;
        }

        public Criteria andMobileforbankNotBetween(String value1, String value2) {
            addCriterion("mobileForBank not between", value1, value2, "mobileforbank");
            return (Criteria) this;
        }

        public Criteria andOrderdescIsNull() {
            addCriterion("orderdesc is null");
            return (Criteria) this;
        }

        public Criteria andOrderdescIsNotNull() {
            addCriterion("orderdesc is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdescEqualTo(String value) {
            addCriterion("orderdesc =", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescNotEqualTo(String value) {
            addCriterion("orderdesc <>", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescGreaterThan(String value) {
            addCriterion("orderdesc >", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescGreaterThanOrEqualTo(String value) {
            addCriterion("orderdesc >=", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescLessThan(String value) {
            addCriterion("orderdesc <", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescLessThanOrEqualTo(String value) {
            addCriterion("orderdesc <=", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescLike(String value) {
            addCriterion("orderdesc like", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescNotLike(String value) {
            addCriterion("orderdesc not like", value, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescIn(List<String> values) {
            addCriterion("orderdesc in", values, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescNotIn(List<String> values) {
            addCriterion("orderdesc not in", values, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescBetween(String value1, String value2) {
            addCriterion("orderdesc between", value1, value2, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andOrderdescNotBetween(String value1, String value2) {
            addCriterion("orderdesc not between", value1, value2, "orderdesc");
            return (Criteria) this;
        }

        public Criteria andChkvalueIsNull() {
            addCriterion("chkValue is null");
            return (Criteria) this;
        }

        public Criteria andChkvalueIsNotNull() {
            addCriterion("chkValue is not null");
            return (Criteria) this;
        }

        public Criteria andChkvalueEqualTo(String value) {
            addCriterion("chkValue =", value, "chkvalue");
            return (Criteria) this;
        }

        public Criteria andChkvalueNotEqualTo(String value) {
            addCriterion("chkValue <>", value, "chkvalue");
            return (Criteria) this;
        }

        public Criteria andChkvalueGreaterThan(String value) {
            addCriterion("chkValue >", value, "chkvalue");
            return (Criteria) this;
        }

        public Criteria andChkvalueGreaterThanOrEqualTo(String value) {
            addCriterion("chkValue >=", value, "chkvalue");
            return (Criteria) this;
        }

        public Criteria andChkvalueLessThan(String value) {
            addCriterion("chkValue <", value, "chkvalue");
            return (Criteria) this;
        }

        public Criteria andChkvalueLessThanOrEqualTo(String value) {
            addCriterion("chkValue <=", value, "chkvalue");
            return (Criteria) this;
        }

        public Criteria andChkvalueLike(String value) {
            addCriterion("chkValue like", value, "chkvalue");
            return (Criteria) this;
        }

        public Criteria andChkvalueNotLike(String value) {
            addCriterion("chkValue not like", value, "chkvalue");
            return (Criteria) this;
        }

        public Criteria andChkvalueIn(List<String> values) {
            addCriterion("chkValue in", values, "chkvalue");
            return (Criteria) this;
        }

        public Criteria andChkvalueNotIn(List<String> values) {
            addCriterion("chkValue not in", values, "chkvalue");
            return (Criteria) this;
        }

        public Criteria andChkvalueBetween(String value1, String value2) {
            addCriterion("chkValue between", value1, value2, "chkvalue");
            return (Criteria) this;
        }

        public Criteria andChkvalueNotBetween(String value1, String value2) {
            addCriterion("chkValue not between", value1, value2, "chkvalue");
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

        public Criteria andChnlfeeIsNull() {
            addCriterion("chnlFee is null");
            return (Criteria) this;
        }

        public Criteria andChnlfeeIsNotNull() {
            addCriterion("chnlFee is not null");
            return (Criteria) this;
        }

        public Criteria andChnlfeeEqualTo(String value) {
            addCriterion("chnlFee =", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeNotEqualTo(String value) {
            addCriterion("chnlFee <>", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeGreaterThan(String value) {
            addCriterion("chnlFee >", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeGreaterThanOrEqualTo(String value) {
            addCriterion("chnlFee >=", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeLessThan(String value) {
            addCriterion("chnlFee <", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeLessThanOrEqualTo(String value) {
            addCriterion("chnlFee <=", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeLike(String value) {
            addCriterion("chnlFee like", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeNotLike(String value) {
            addCriterion("chnlFee not like", value, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeIn(List<String> values) {
            addCriterion("chnlFee in", values, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeNotIn(List<String> values) {
            addCriterion("chnlFee not in", values, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeBetween(String value1, String value2) {
            addCriterion("chnlFee between", value1, value2, "chnlfee");
            return (Criteria) this;
        }

        public Criteria andChnlfeeNotBetween(String value1, String value2) {
            addCriterion("chnlFee not between", value1, value2, "chnlfee");
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