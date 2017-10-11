package com.unionpay.withhold.admin.pojo;

import java.util.ArrayList;
import java.util.List;

public class TMccListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMccListExample() {
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

        public Criteria andMcclistIsNull() {
            addCriterion("MCCLIST is null");
            return (Criteria) this;
        }

        public Criteria andMcclistIsNotNull() {
            addCriterion("MCCLIST is not null");
            return (Criteria) this;
        }

        public Criteria andMcclistEqualTo(String value) {
            addCriterion("MCCLIST =", value, "mcclist");
            return (Criteria) this;
        }

        public Criteria andMcclistNotEqualTo(String value) {
            addCriterion("MCCLIST <>", value, "mcclist");
            return (Criteria) this;
        }

        public Criteria andMcclistGreaterThan(String value) {
            addCriterion("MCCLIST >", value, "mcclist");
            return (Criteria) this;
        }

        public Criteria andMcclistGreaterThanOrEqualTo(String value) {
            addCriterion("MCCLIST >=", value, "mcclist");
            return (Criteria) this;
        }

        public Criteria andMcclistLessThan(String value) {
            addCriterion("MCCLIST <", value, "mcclist");
            return (Criteria) this;
        }

        public Criteria andMcclistLessThanOrEqualTo(String value) {
            addCriterion("MCCLIST <=", value, "mcclist");
            return (Criteria) this;
        }

        public Criteria andMcclistLike(String value) {
            addCriterion("MCCLIST like", value, "mcclist");
            return (Criteria) this;
        }

        public Criteria andMcclistNotLike(String value) {
            addCriterion("MCCLIST not like", value, "mcclist");
            return (Criteria) this;
        }

        public Criteria andMcclistIn(List<String> values) {
            addCriterion("MCCLIST in", values, "mcclist");
            return (Criteria) this;
        }

        public Criteria andMcclistNotIn(List<String> values) {
            addCriterion("MCCLIST not in", values, "mcclist");
            return (Criteria) this;
        }

        public Criteria andMcclistBetween(String value1, String value2) {
            addCriterion("MCCLIST between", value1, value2, "mcclist");
            return (Criteria) this;
        }

        public Criteria andMcclistNotBetween(String value1, String value2) {
            addCriterion("MCCLIST not between", value1, value2, "mcclist");
            return (Criteria) this;
        }

        public Criteria andMcccontIsNull() {
            addCriterion("MCCCONT is null");
            return (Criteria) this;
        }

        public Criteria andMcccontIsNotNull() {
            addCriterion("MCCCONT is not null");
            return (Criteria) this;
        }

        public Criteria andMcccontEqualTo(String value) {
            addCriterion("MCCCONT =", value, "mcccont");
            return (Criteria) this;
        }

        public Criteria andMcccontNotEqualTo(String value) {
            addCriterion("MCCCONT <>", value, "mcccont");
            return (Criteria) this;
        }

        public Criteria andMcccontGreaterThan(String value) {
            addCriterion("MCCCONT >", value, "mcccont");
            return (Criteria) this;
        }

        public Criteria andMcccontGreaterThanOrEqualTo(String value) {
            addCriterion("MCCCONT >=", value, "mcccont");
            return (Criteria) this;
        }

        public Criteria andMcccontLessThan(String value) {
            addCriterion("MCCCONT <", value, "mcccont");
            return (Criteria) this;
        }

        public Criteria andMcccontLessThanOrEqualTo(String value) {
            addCriterion("MCCCONT <=", value, "mcccont");
            return (Criteria) this;
        }

        public Criteria andMcccontLike(String value) {
            addCriterion("MCCCONT like", value, "mcccont");
            return (Criteria) this;
        }

        public Criteria andMcccontNotLike(String value) {
            addCriterion("MCCCONT not like", value, "mcccont");
            return (Criteria) this;
        }

        public Criteria andMcccontIn(List<String> values) {
            addCriterion("MCCCONT in", values, "mcccont");
            return (Criteria) this;
        }

        public Criteria andMcccontNotIn(List<String> values) {
            addCriterion("MCCCONT not in", values, "mcccont");
            return (Criteria) this;
        }

        public Criteria andMcccontBetween(String value1, String value2) {
            addCriterion("MCCCONT between", value1, value2, "mcccont");
            return (Criteria) this;
        }

        public Criteria andMcccontNotBetween(String value1, String value2) {
            addCriterion("MCCCONT not between", value1, value2, "mcccont");
            return (Criteria) this;
        }

        public Criteria andMcctypeIsNull() {
            addCriterion("MCCTYPE is null");
            return (Criteria) this;
        }

        public Criteria andMcctypeIsNotNull() {
            addCriterion("MCCTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMcctypeEqualTo(String value) {
            addCriterion("MCCTYPE =", value, "mcctype");
            return (Criteria) this;
        }

        public Criteria andMcctypeNotEqualTo(String value) {
            addCriterion("MCCTYPE <>", value, "mcctype");
            return (Criteria) this;
        }

        public Criteria andMcctypeGreaterThan(String value) {
            addCriterion("MCCTYPE >", value, "mcctype");
            return (Criteria) this;
        }

        public Criteria andMcctypeGreaterThanOrEqualTo(String value) {
            addCriterion("MCCTYPE >=", value, "mcctype");
            return (Criteria) this;
        }

        public Criteria andMcctypeLessThan(String value) {
            addCriterion("MCCTYPE <", value, "mcctype");
            return (Criteria) this;
        }

        public Criteria andMcctypeLessThanOrEqualTo(String value) {
            addCriterion("MCCTYPE <=", value, "mcctype");
            return (Criteria) this;
        }

        public Criteria andMcctypeLike(String value) {
            addCriterion("MCCTYPE like", value, "mcctype");
            return (Criteria) this;
        }

        public Criteria andMcctypeNotLike(String value) {
            addCriterion("MCCTYPE not like", value, "mcctype");
            return (Criteria) this;
        }

        public Criteria andMcctypeIn(List<String> values) {
            addCriterion("MCCTYPE in", values, "mcctype");
            return (Criteria) this;
        }

        public Criteria andMcctypeNotIn(List<String> values) {
            addCriterion("MCCTYPE not in", values, "mcctype");
            return (Criteria) this;
        }

        public Criteria andMcctypeBetween(String value1, String value2) {
            addCriterion("MCCTYPE between", value1, value2, "mcctype");
            return (Criteria) this;
        }

        public Criteria andMcctypeNotBetween(String value1, String value2) {
            addCriterion("MCCTYPE not between", value1, value2, "mcctype");
            return (Criteria) this;
        }

        public Criteria andMcctradeIsNull() {
            addCriterion("MCCTRADE is null");
            return (Criteria) this;
        }

        public Criteria andMcctradeIsNotNull() {
            addCriterion("MCCTRADE is not null");
            return (Criteria) this;
        }

        public Criteria andMcctradeEqualTo(String value) {
            addCriterion("MCCTRADE =", value, "mcctrade");
            return (Criteria) this;
        }

        public Criteria andMcctradeNotEqualTo(String value) {
            addCriterion("MCCTRADE <>", value, "mcctrade");
            return (Criteria) this;
        }

        public Criteria andMcctradeGreaterThan(String value) {
            addCriterion("MCCTRADE >", value, "mcctrade");
            return (Criteria) this;
        }

        public Criteria andMcctradeGreaterThanOrEqualTo(String value) {
            addCriterion("MCCTRADE >=", value, "mcctrade");
            return (Criteria) this;
        }

        public Criteria andMcctradeLessThan(String value) {
            addCriterion("MCCTRADE <", value, "mcctrade");
            return (Criteria) this;
        }

        public Criteria andMcctradeLessThanOrEqualTo(String value) {
            addCriterion("MCCTRADE <=", value, "mcctrade");
            return (Criteria) this;
        }

        public Criteria andMcctradeLike(String value) {
            addCriterion("MCCTRADE like", value, "mcctrade");
            return (Criteria) this;
        }

        public Criteria andMcctradeNotLike(String value) {
            addCriterion("MCCTRADE not like", value, "mcctrade");
            return (Criteria) this;
        }

        public Criteria andMcctradeIn(List<String> values) {
            addCriterion("MCCTRADE in", values, "mcctrade");
            return (Criteria) this;
        }

        public Criteria andMcctradeNotIn(List<String> values) {
            addCriterion("MCCTRADE not in", values, "mcctrade");
            return (Criteria) this;
        }

        public Criteria andMcctradeBetween(String value1, String value2) {
            addCriterion("MCCTRADE between", value1, value2, "mcctrade");
            return (Criteria) this;
        }

        public Criteria andMcctradeNotBetween(String value1, String value2) {
            addCriterion("MCCTRADE not between", value1, value2, "mcctrade");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("INDUSTRY is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("INDUSTRY is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("INDUSTRY =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("INDUSTRY <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("INDUSTRY >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("INDUSTRY <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("INDUSTRY like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("INDUSTRY not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("INDUSTRY in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("INDUSTRY not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("INDUSTRY between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andMccclassIsNull() {
            addCriterion("MCCCLASS is null");
            return (Criteria) this;
        }

        public Criteria andMccclassIsNotNull() {
            addCriterion("MCCCLASS is not null");
            return (Criteria) this;
        }

        public Criteria andMccclassEqualTo(String value) {
            addCriterion("MCCCLASS =", value, "mccclass");
            return (Criteria) this;
        }

        public Criteria andMccclassNotEqualTo(String value) {
            addCriterion("MCCCLASS <>", value, "mccclass");
            return (Criteria) this;
        }

        public Criteria andMccclassGreaterThan(String value) {
            addCriterion("MCCCLASS >", value, "mccclass");
            return (Criteria) this;
        }

        public Criteria andMccclassGreaterThanOrEqualTo(String value) {
            addCriterion("MCCCLASS >=", value, "mccclass");
            return (Criteria) this;
        }

        public Criteria andMccclassLessThan(String value) {
            addCriterion("MCCCLASS <", value, "mccclass");
            return (Criteria) this;
        }

        public Criteria andMccclassLessThanOrEqualTo(String value) {
            addCriterion("MCCCLASS <=", value, "mccclass");
            return (Criteria) this;
        }

        public Criteria andMccclassLike(String value) {
            addCriterion("MCCCLASS like", value, "mccclass");
            return (Criteria) this;
        }

        public Criteria andMccclassNotLike(String value) {
            addCriterion("MCCCLASS not like", value, "mccclass");
            return (Criteria) this;
        }

        public Criteria andMccclassIn(List<String> values) {
            addCriterion("MCCCLASS in", values, "mccclass");
            return (Criteria) this;
        }

        public Criteria andMccclassNotIn(List<String> values) {
            addCriterion("MCCCLASS not in", values, "mccclass");
            return (Criteria) this;
        }

        public Criteria andMccclassBetween(String value1, String value2) {
            addCriterion("MCCCLASS between", value1, value2, "mccclass");
            return (Criteria) this;
        }

        public Criteria andMccclassNotBetween(String value1, String value2) {
            addCriterion("MCCCLASS not between", value1, value2, "mccclass");
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