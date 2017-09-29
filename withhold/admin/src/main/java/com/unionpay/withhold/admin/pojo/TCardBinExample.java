package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TCardBinExample {
	private String cardbin;
	public String getCardbin() {
		return cardbin;
	}
	public void setCardbin(String cardbin) {
		this.cardbin = cardbin;
	}
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

    public TCardBinExample() {
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

        public Criteria andCardbinIsNull() {
            addCriterion("CARDBIN is null");
            return (Criteria) this;
        }

        public Criteria andCardbinIsNotNull() {
            addCriterion("CARDBIN is not null");
            return (Criteria) this;
        }

        public Criteria andCardbinEqualTo(String value) {
            addCriterion("CARDBIN =", value, "cardbin");
            return (Criteria) this;
        }

        public Criteria andCardbinNotEqualTo(String value) {
            addCriterion("CARDBIN <>", value, "cardbin");
            return (Criteria) this;
        }

        public Criteria andCardbinGreaterThan(String value) {
            addCriterion("CARDBIN >", value, "cardbin");
            return (Criteria) this;
        }

        public Criteria andCardbinGreaterThanOrEqualTo(String value) {
            addCriterion("CARDBIN >=", value, "cardbin");
            return (Criteria) this;
        }

        public Criteria andCardbinLessThan(String value) {
            addCriterion("CARDBIN <", value, "cardbin");
            return (Criteria) this;
        }

        public Criteria andCardbinLessThanOrEqualTo(String value) {
            addCriterion("CARDBIN <=", value, "cardbin");
            return (Criteria) this;
        }

        public Criteria andCardbinLike(String value) {
            addCriterion("CARDBIN like", value, "cardbin");
            return (Criteria) this;
        }

        public Criteria andCardbinNotLike(String value) {
            addCriterion("CARDBIN not like", value, "cardbin");
            return (Criteria) this;
        }

        public Criteria andCardbinIn(List<String> values) {
            addCriterion("CARDBIN in", values, "cardbin");
            return (Criteria) this;
        }

        public Criteria andCardbinNotIn(List<String> values) {
            addCriterion("CARDBIN not in", values, "cardbin");
            return (Criteria) this;
        }

        public Criteria andCardbinBetween(String value1, String value2) {
            addCriterion("CARDBIN between", value1, value2, "cardbin");
            return (Criteria) this;
        }

        public Criteria andCardbinNotBetween(String value1, String value2) {
            addCriterion("CARDBIN not between", value1, value2, "cardbin");
            return (Criteria) this;
        }

        public Criteria andCardlenIsNull() {
            addCriterion("CARDLEN is null");
            return (Criteria) this;
        }

        public Criteria andCardlenIsNotNull() {
            addCriterion("CARDLEN is not null");
            return (Criteria) this;
        }

        public Criteria andCardlenEqualTo(Short value) {
            addCriterion("CARDLEN =", value, "cardlen");
            return (Criteria) this;
        }

        public Criteria andCardlenNotEqualTo(Short value) {
            addCriterion("CARDLEN <>", value, "cardlen");
            return (Criteria) this;
        }

        public Criteria andCardlenGreaterThan(Short value) {
            addCriterion("CARDLEN >", value, "cardlen");
            return (Criteria) this;
        }

        public Criteria andCardlenGreaterThanOrEqualTo(Short value) {
            addCriterion("CARDLEN >=", value, "cardlen");
            return (Criteria) this;
        }

        public Criteria andCardlenLessThan(Short value) {
            addCriterion("CARDLEN <", value, "cardlen");
            return (Criteria) this;
        }

        public Criteria andCardlenLessThanOrEqualTo(Short value) {
            addCriterion("CARDLEN <=", value, "cardlen");
            return (Criteria) this;
        }

        public Criteria andCardlenIn(List<Short> values) {
            addCriterion("CARDLEN in", values, "cardlen");
            return (Criteria) this;
        }

        public Criteria andCardlenNotIn(List<Short> values) {
            addCriterion("CARDLEN not in", values, "cardlen");
            return (Criteria) this;
        }

        public Criteria andCardlenBetween(Short value1, Short value2) {
            addCriterion("CARDLEN between", value1, value2, "cardlen");
            return (Criteria) this;
        }

        public Criteria andCardlenNotBetween(Short value1, Short value2) {
            addCriterion("CARDLEN not between", value1, value2, "cardlen");
            return (Criteria) this;
        }

        public Criteria andBinlenIsNull() {
            addCriterion("BINLEN is null");
            return (Criteria) this;
        }

        public Criteria andBinlenIsNotNull() {
            addCriterion("BINLEN is not null");
            return (Criteria) this;
        }

        public Criteria andBinlenEqualTo(Short value) {
            addCriterion("BINLEN =", value, "binlen");
            return (Criteria) this;
        }

        public Criteria andBinlenNotEqualTo(Short value) {
            addCriterion("BINLEN <>", value, "binlen");
            return (Criteria) this;
        }

        public Criteria andBinlenGreaterThan(Short value) {
            addCriterion("BINLEN >", value, "binlen");
            return (Criteria) this;
        }

        public Criteria andBinlenGreaterThanOrEqualTo(Short value) {
            addCriterion("BINLEN >=", value, "binlen");
            return (Criteria) this;
        }

        public Criteria andBinlenLessThan(Short value) {
            addCriterion("BINLEN <", value, "binlen");
            return (Criteria) this;
        }

        public Criteria andBinlenLessThanOrEqualTo(Short value) {
            addCriterion("BINLEN <=", value, "binlen");
            return (Criteria) this;
        }

        public Criteria andBinlenIn(List<Short> values) {
            addCriterion("BINLEN in", values, "binlen");
            return (Criteria) this;
        }

        public Criteria andBinlenNotIn(List<Short> values) {
            addCriterion("BINLEN not in", values, "binlen");
            return (Criteria) this;
        }

        public Criteria andBinlenBetween(Short value1, Short value2) {
            addCriterion("BINLEN between", value1, value2, "binlen");
            return (Criteria) this;
        }

        public Criteria andBinlenNotBetween(Short value1, Short value2) {
            addCriterion("BINLEN not between", value1, value2, "binlen");
            return (Criteria) this;
        }

        public Criteria andCardnameIsNull() {
            addCriterion("CARDNAME is null");
            return (Criteria) this;
        }

        public Criteria andCardnameIsNotNull() {
            addCriterion("CARDNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCardnameEqualTo(String value) {
            addCriterion("CARDNAME =", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameNotEqualTo(String value) {
            addCriterion("CARDNAME <>", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameGreaterThan(String value) {
            addCriterion("CARDNAME >", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameGreaterThanOrEqualTo(String value) {
            addCriterion("CARDNAME >=", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameLessThan(String value) {
            addCriterion("CARDNAME <", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameLessThanOrEqualTo(String value) {
            addCriterion("CARDNAME <=", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameLike(String value) {
            addCriterion("CARDNAME like", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameNotLike(String value) {
            addCriterion("CARDNAME not like", value, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameIn(List<String> values) {
            addCriterion("CARDNAME in", values, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameNotIn(List<String> values) {
            addCriterion("CARDNAME not in", values, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameBetween(String value1, String value2) {
            addCriterion("CARDNAME between", value1, value2, "cardname");
            return (Criteria) this;
        }

        public Criteria andCardnameNotBetween(String value1, String value2) {
            addCriterion("CARDNAME not between", value1, value2, "cardname");
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

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("TYPE not between", value1, value2, "type");
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