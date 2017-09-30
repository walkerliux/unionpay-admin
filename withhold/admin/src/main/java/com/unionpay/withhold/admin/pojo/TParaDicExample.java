package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TParaDicExample {
	private int pageNum;
	private int pageSize;
	private int beginRow;
	private String parentId;
	private String paraCode;
	private String paraName;
	
    public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParaCode() {
		return paraCode;
	}

	public void setParaCode(String paraCode) {
		this.paraCode = paraCode;
	}

	public String getParaName() {
		return paraName;
	}

	public void setParaName(String paraName) {
		this.paraName = paraName;
	}

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

    public TParaDicExample() {
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

        public Criteria andParaCodeIsNull() {
            addCriterion("PARA_CODE is null");
            return (Criteria) this;
        }

        public Criteria andParaCodeIsNotNull() {
            addCriterion("PARA_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andParaCodeEqualTo(String value) {
            addCriterion("PARA_CODE =", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeNotEqualTo(String value) {
            addCriterion("PARA_CODE <>", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeGreaterThan(String value) {
            addCriterion("PARA_CODE >", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PARA_CODE >=", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeLessThan(String value) {
            addCriterion("PARA_CODE <", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeLessThanOrEqualTo(String value) {
            addCriterion("PARA_CODE <=", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeLike(String value) {
            addCriterion("PARA_CODE like", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeNotLike(String value) {
            addCriterion("PARA_CODE not like", value, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeIn(List<String> values) {
            addCriterion("PARA_CODE in", values, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeNotIn(List<String> values) {
            addCriterion("PARA_CODE not in", values, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeBetween(String value1, String value2) {
            addCriterion("PARA_CODE between", value1, value2, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParaCodeNotBetween(String value1, String value2) {
            addCriterion("PARA_CODE not between", value1, value2, "paraCode");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("PARENT_ID =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("PARENT_ID <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("PARENT_ID >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PARENT_ID >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("PARENT_ID <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("PARENT_ID <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("PARENT_ID in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("PARENT_ID not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("PARENT_ID between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("PARENT_ID not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParaNameIsNull() {
            addCriterion("PARA_NAME is null");
            return (Criteria) this;
        }

        public Criteria andParaNameIsNotNull() {
            addCriterion("PARA_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andParaNameEqualTo(String value) {
            addCriterion("PARA_NAME =", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameNotEqualTo(String value) {
            addCriterion("PARA_NAME <>", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameGreaterThan(String value) {
            addCriterion("PARA_NAME >", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameGreaterThanOrEqualTo(String value) {
            addCriterion("PARA_NAME >=", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameLessThan(String value) {
            addCriterion("PARA_NAME <", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameLessThanOrEqualTo(String value) {
            addCriterion("PARA_NAME <=", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameLike(String value) {
            addCriterion("PARA_NAME like", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameNotLike(String value) {
            addCriterion("PARA_NAME not like", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameIn(List<String> values) {
            addCriterion("PARA_NAME in", values, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameNotIn(List<String> values) {
            addCriterion("PARA_NAME not in", values, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameBetween(String value1, String value2) {
            addCriterion("PARA_NAME between", value1, value2, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameNotBetween(String value1, String value2) {
            addCriterion("PARA_NAME not between", value1, value2, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaTypeIsNull() {
            addCriterion("PARA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andParaTypeIsNotNull() {
            addCriterion("PARA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andParaTypeEqualTo(String value) {
            addCriterion("PARA_TYPE =", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeNotEqualTo(String value) {
            addCriterion("PARA_TYPE <>", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeGreaterThan(String value) {
            addCriterion("PARA_TYPE >", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PARA_TYPE >=", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeLessThan(String value) {
            addCriterion("PARA_TYPE <", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeLessThanOrEqualTo(String value) {
            addCriterion("PARA_TYPE <=", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeLike(String value) {
            addCriterion("PARA_TYPE like", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeNotLike(String value) {
            addCriterion("PARA_TYPE not like", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeIn(List<String> values) {
            addCriterion("PARA_TYPE in", values, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeNotIn(List<String> values) {
            addCriterion("PARA_TYPE not in", values, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeBetween(String value1, String value2) {
            addCriterion("PARA_TYPE between", value1, value2, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeNotBetween(String value1, String value2) {
            addCriterion("PARA_TYPE not between", value1, value2, "paraType");
            return (Criteria) this;
        }

        public Criteria andHasSubIsNull() {
            addCriterion("HAS_SUB is null");
            return (Criteria) this;
        }

        public Criteria andHasSubIsNotNull() {
            addCriterion("HAS_SUB is not null");
            return (Criteria) this;
        }

        public Criteria andHasSubEqualTo(Short value) {
            addCriterion("HAS_SUB =", value, "hasSub");
            return (Criteria) this;
        }

        public Criteria andHasSubNotEqualTo(Short value) {
            addCriterion("HAS_SUB <>", value, "hasSub");
            return (Criteria) this;
        }

        public Criteria andHasSubGreaterThan(Short value) {
            addCriterion("HAS_SUB >", value, "hasSub");
            return (Criteria) this;
        }

        public Criteria andHasSubGreaterThanOrEqualTo(Short value) {
            addCriterion("HAS_SUB >=", value, "hasSub");
            return (Criteria) this;
        }

        public Criteria andHasSubLessThan(Short value) {
            addCriterion("HAS_SUB <", value, "hasSub");
            return (Criteria) this;
        }

        public Criteria andHasSubLessThanOrEqualTo(Short value) {
            addCriterion("HAS_SUB <=", value, "hasSub");
            return (Criteria) this;
        }

        public Criteria andHasSubIn(List<Short> values) {
            addCriterion("HAS_SUB in", values, "hasSub");
            return (Criteria) this;
        }

        public Criteria andHasSubNotIn(List<Short> values) {
            addCriterion("HAS_SUB not in", values, "hasSub");
            return (Criteria) this;
        }

        public Criteria andHasSubBetween(Short value1, Short value2) {
            addCriterion("HAS_SUB between", value1, value2, "hasSub");
            return (Criteria) this;
        }

        public Criteria andHasSubNotBetween(Short value1, Short value2) {
            addCriterion("HAS_SUB not between", value1, value2, "hasSub");
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

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAddedIsNull() {
            addCriterion("ADDED is null");
            return (Criteria) this;
        }

        public Criteria andAddedIsNotNull() {
            addCriterion("ADDED is not null");
            return (Criteria) this;
        }

        public Criteria andAddedEqualTo(Long value) {
            addCriterion("ADDED =", value, "added");
            return (Criteria) this;
        }

        public Criteria andAddedNotEqualTo(Long value) {
            addCriterion("ADDED <>", value, "added");
            return (Criteria) this;
        }

        public Criteria andAddedGreaterThan(Long value) {
            addCriterion("ADDED >", value, "added");
            return (Criteria) this;
        }

        public Criteria andAddedGreaterThanOrEqualTo(Long value) {
            addCriterion("ADDED >=", value, "added");
            return (Criteria) this;
        }

        public Criteria andAddedLessThan(Long value) {
            addCriterion("ADDED <", value, "added");
            return (Criteria) this;
        }

        public Criteria andAddedLessThanOrEqualTo(Long value) {
            addCriterion("ADDED <=", value, "added");
            return (Criteria) this;
        }

        public Criteria andAddedIn(List<Long> values) {
            addCriterion("ADDED in", values, "added");
            return (Criteria) this;
        }

        public Criteria andAddedNotIn(List<Long> values) {
            addCriterion("ADDED not in", values, "added");
            return (Criteria) this;
        }

        public Criteria andAddedBetween(Long value1, Long value2) {
            addCriterion("ADDED between", value1, value2, "added");
            return (Criteria) this;
        }

        public Criteria andAddedNotBetween(Long value1, Long value2) {
            addCriterion("ADDED not between", value1, value2, "added");
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