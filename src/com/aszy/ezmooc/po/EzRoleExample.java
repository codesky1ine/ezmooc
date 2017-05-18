package com.aszy.ezmooc.po;

import java.util.ArrayList;
import java.util.List;

public class EzRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EzRoleExample() {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("ROLE_ID like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("ROLE_ID not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("ROLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("ROLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("ROLE_NAME =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("ROLE_NAME <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("ROLE_NAME >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_NAME >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("ROLE_NAME <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("ROLE_NAME <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("ROLE_NAME like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("ROLE_NAME not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("ROLE_NAME in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("ROLE_NAME not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("ROLE_NAME between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("ROLE_NAME not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andCourceAceessIsNull() {
            addCriterion("COURCE_ACEESS is null");
            return (Criteria) this;
        }

        public Criteria andCourceAceessIsNotNull() {
            addCriterion("COURCE_ACEESS is not null");
            return (Criteria) this;
        }

        public Criteria andCourceAceessEqualTo(String value) {
            addCriterion("COURCE_ACEESS =", value, "courceAceess");
            return (Criteria) this;
        }

        public Criteria andCourceAceessNotEqualTo(String value) {
            addCriterion("COURCE_ACEESS <>", value, "courceAceess");
            return (Criteria) this;
        }

        public Criteria andCourceAceessGreaterThan(String value) {
            addCriterion("COURCE_ACEESS >", value, "courceAceess");
            return (Criteria) this;
        }

        public Criteria andCourceAceessGreaterThanOrEqualTo(String value) {
            addCriterion("COURCE_ACEESS >=", value, "courceAceess");
            return (Criteria) this;
        }

        public Criteria andCourceAceessLessThan(String value) {
            addCriterion("COURCE_ACEESS <", value, "courceAceess");
            return (Criteria) this;
        }

        public Criteria andCourceAceessLessThanOrEqualTo(String value) {
            addCriterion("COURCE_ACEESS <=", value, "courceAceess");
            return (Criteria) this;
        }

        public Criteria andCourceAceessLike(String value) {
            addCriterion("COURCE_ACEESS like", value, "courceAceess");
            return (Criteria) this;
        }

        public Criteria andCourceAceessNotLike(String value) {
            addCriterion("COURCE_ACEESS not like", value, "courceAceess");
            return (Criteria) this;
        }

        public Criteria andCourceAceessIn(List<String> values) {
            addCriterion("COURCE_ACEESS in", values, "courceAceess");
            return (Criteria) this;
        }

        public Criteria andCourceAceessNotIn(List<String> values) {
            addCriterion("COURCE_ACEESS not in", values, "courceAceess");
            return (Criteria) this;
        }

        public Criteria andCourceAceessBetween(String value1, String value2) {
            addCriterion("COURCE_ACEESS between", value1, value2, "courceAceess");
            return (Criteria) this;
        }

        public Criteria andCourceAceessNotBetween(String value1, String value2) {
            addCriterion("COURCE_ACEESS not between", value1, value2, "courceAceess");
            return (Criteria) this;
        }

        public Criteria andCourceCatgAcessIsNull() {
            addCriterion("COURCE_CATG_ACESS is null");
            return (Criteria) this;
        }

        public Criteria andCourceCatgAcessIsNotNull() {
            addCriterion("COURCE_CATG_ACESS is not null");
            return (Criteria) this;
        }

        public Criteria andCourceCatgAcessEqualTo(String value) {
            addCriterion("COURCE_CATG_ACESS =", value, "courceCatgAcess");
            return (Criteria) this;
        }

        public Criteria andCourceCatgAcessNotEqualTo(String value) {
            addCriterion("COURCE_CATG_ACESS <>", value, "courceCatgAcess");
            return (Criteria) this;
        }

        public Criteria andCourceCatgAcessGreaterThan(String value) {
            addCriterion("COURCE_CATG_ACESS >", value, "courceCatgAcess");
            return (Criteria) this;
        }

        public Criteria andCourceCatgAcessGreaterThanOrEqualTo(String value) {
            addCriterion("COURCE_CATG_ACESS >=", value, "courceCatgAcess");
            return (Criteria) this;
        }

        public Criteria andCourceCatgAcessLessThan(String value) {
            addCriterion("COURCE_CATG_ACESS <", value, "courceCatgAcess");
            return (Criteria) this;
        }

        public Criteria andCourceCatgAcessLessThanOrEqualTo(String value) {
            addCriterion("COURCE_CATG_ACESS <=", value, "courceCatgAcess");
            return (Criteria) this;
        }

        public Criteria andCourceCatgAcessLike(String value) {
            addCriterion("COURCE_CATG_ACESS like", value, "courceCatgAcess");
            return (Criteria) this;
        }

        public Criteria andCourceCatgAcessNotLike(String value) {
            addCriterion("COURCE_CATG_ACESS not like", value, "courceCatgAcess");
            return (Criteria) this;
        }

        public Criteria andCourceCatgAcessIn(List<String> values) {
            addCriterion("COURCE_CATG_ACESS in", values, "courceCatgAcess");
            return (Criteria) this;
        }

        public Criteria andCourceCatgAcessNotIn(List<String> values) {
            addCriterion("COURCE_CATG_ACESS not in", values, "courceCatgAcess");
            return (Criteria) this;
        }

        public Criteria andCourceCatgAcessBetween(String value1, String value2) {
            addCriterion("COURCE_CATG_ACESS between", value1, value2, "courceCatgAcess");
            return (Criteria) this;
        }

        public Criteria andCourceCatgAcessNotBetween(String value1, String value2) {
            addCriterion("COURCE_CATG_ACESS not between", value1, value2, "courceCatgAcess");
            return (Criteria) this;
        }

        public Criteria andTeacherAcessIsNull() {
            addCriterion("TEACHER_ACESS is null");
            return (Criteria) this;
        }

        public Criteria andTeacherAcessIsNotNull() {
            addCriterion("TEACHER_ACESS is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherAcessEqualTo(String value) {
            addCriterion("TEACHER_ACESS =", value, "teacherAcess");
            return (Criteria) this;
        }

        public Criteria andTeacherAcessNotEqualTo(String value) {
            addCriterion("TEACHER_ACESS <>", value, "teacherAcess");
            return (Criteria) this;
        }

        public Criteria andTeacherAcessGreaterThan(String value) {
            addCriterion("TEACHER_ACESS >", value, "teacherAcess");
            return (Criteria) this;
        }

        public Criteria andTeacherAcessGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_ACESS >=", value, "teacherAcess");
            return (Criteria) this;
        }

        public Criteria andTeacherAcessLessThan(String value) {
            addCriterion("TEACHER_ACESS <", value, "teacherAcess");
            return (Criteria) this;
        }

        public Criteria andTeacherAcessLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_ACESS <=", value, "teacherAcess");
            return (Criteria) this;
        }

        public Criteria andTeacherAcessLike(String value) {
            addCriterion("TEACHER_ACESS like", value, "teacherAcess");
            return (Criteria) this;
        }

        public Criteria andTeacherAcessNotLike(String value) {
            addCriterion("TEACHER_ACESS not like", value, "teacherAcess");
            return (Criteria) this;
        }

        public Criteria andTeacherAcessIn(List<String> values) {
            addCriterion("TEACHER_ACESS in", values, "teacherAcess");
            return (Criteria) this;
        }

        public Criteria andTeacherAcessNotIn(List<String> values) {
            addCriterion("TEACHER_ACESS not in", values, "teacherAcess");
            return (Criteria) this;
        }

        public Criteria andTeacherAcessBetween(String value1, String value2) {
            addCriterion("TEACHER_ACESS between", value1, value2, "teacherAcess");
            return (Criteria) this;
        }

        public Criteria andTeacherAcessNotBetween(String value1, String value2) {
            addCriterion("TEACHER_ACESS not between", value1, value2, "teacherAcess");
            return (Criteria) this;
        }

        public Criteria andVideoAcessIsNull() {
            addCriterion("VIDEO_ACESS is null");
            return (Criteria) this;
        }

        public Criteria andVideoAcessIsNotNull() {
            addCriterion("VIDEO_ACESS is not null");
            return (Criteria) this;
        }

        public Criteria andVideoAcessEqualTo(String value) {
            addCriterion("VIDEO_ACESS =", value, "videoAcess");
            return (Criteria) this;
        }

        public Criteria andVideoAcessNotEqualTo(String value) {
            addCriterion("VIDEO_ACESS <>", value, "videoAcess");
            return (Criteria) this;
        }

        public Criteria andVideoAcessGreaterThan(String value) {
            addCriterion("VIDEO_ACESS >", value, "videoAcess");
            return (Criteria) this;
        }

        public Criteria andVideoAcessGreaterThanOrEqualTo(String value) {
            addCriterion("VIDEO_ACESS >=", value, "videoAcess");
            return (Criteria) this;
        }

        public Criteria andVideoAcessLessThan(String value) {
            addCriterion("VIDEO_ACESS <", value, "videoAcess");
            return (Criteria) this;
        }

        public Criteria andVideoAcessLessThanOrEqualTo(String value) {
            addCriterion("VIDEO_ACESS <=", value, "videoAcess");
            return (Criteria) this;
        }

        public Criteria andVideoAcessLike(String value) {
            addCriterion("VIDEO_ACESS like", value, "videoAcess");
            return (Criteria) this;
        }

        public Criteria andVideoAcessNotLike(String value) {
            addCriterion("VIDEO_ACESS not like", value, "videoAcess");
            return (Criteria) this;
        }

        public Criteria andVideoAcessIn(List<String> values) {
            addCriterion("VIDEO_ACESS in", values, "videoAcess");
            return (Criteria) this;
        }

        public Criteria andVideoAcessNotIn(List<String> values) {
            addCriterion("VIDEO_ACESS not in", values, "videoAcess");
            return (Criteria) this;
        }

        public Criteria andVideoAcessBetween(String value1, String value2) {
            addCriterion("VIDEO_ACESS between", value1, value2, "videoAcess");
            return (Criteria) this;
        }

        public Criteria andVideoAcessNotBetween(String value1, String value2) {
            addCriterion("VIDEO_ACESS not between", value1, value2, "videoAcess");
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