package com.aszy.ezmooc.po;

import java.util.ArrayList;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer startIndex;

    protected Integer pageSize;
    
    public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
    
    public CourseExample() {
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

        public Criteria andCourseIdIsNull() {
            addCriterion("COURSE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("COURSE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(String value) {
            addCriterion("c.COURSE_ID =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(String value) {
            addCriterion("COURSE_ID <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(String value) {
            addCriterion("COURSE_ID >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE_ID >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(String value) {
            addCriterion("COURSE_ID <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(String value) {
            addCriterion("COURSE_ID <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLike(String value) {
            addCriterion("COURSE_ID like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotLike(String value) {
            addCriterion("COURSE_ID not like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<String> values) {
            addCriterion("COURSE_ID in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<String> values) {
            addCriterion("COURSE_ID not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(String value1, String value2) {
            addCriterion("COURSE_ID between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(String value1, String value2) {
            addCriterion("COURSE_ID not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("COURSE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("COURSE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("COURSE_NAME =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("COURSE_NAME <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("COURSE_NAME >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE_NAME >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("COURSE_NAME <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("COURSE_NAME <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("COURSE_NAME like", "%"+value+"%", "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("COURSE_NAME not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("COURSE_NAME in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("COURSE_NAME not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("COURSE_NAME between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("COURSE_NAME not between", value1, value2, "courseName");
            return (Criteria) this;
        }
        
        public Criteria andCourseNameOrInfoLike(String courseName, String courseInfo) {
            addCriterion("(COURSE_NAME like '%"+courseName+"%' or COURSE_INFO like '%"+courseInfo+"%')");
            return (Criteria) this;
        }

        public Criteria andCourseCatgIdIsNull() {
            addCriterion("COURSE_CATG_ID is null");
            return (Criteria) this;
        }

        public Criteria andCourseCatgIdIsNotNull() {
            addCriterion("COURSE_CATG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCatgIdEqualTo(String value) {
            addCriterion("c.COURSE_CATG_ID =", value, "courseCatgId");
            return (Criteria) this;
        }

        public Criteria andCourseCatgIdNotEqualTo(String value) {
            addCriterion("COURSE_CATG_ID <>", value, "courseCatgId");
            return (Criteria) this;
        }

        public Criteria andCourseCatgIdGreaterThan(String value) {
            addCriterion("COURSE_CATG_ID >", value, "courseCatgId");
            return (Criteria) this;
        }

        public Criteria andCourseCatgIdGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE_CATG_ID >=", value, "courseCatgId");
            return (Criteria) this;
        }

        public Criteria andCourseCatgIdLessThan(String value) {
            addCriterion("COURSE_CATG_ID <", value, "courseCatgId");
            return (Criteria) this;
        }

        public Criteria andCourseCatgIdLessThanOrEqualTo(String value) {
            addCriterion("COURSE_CATG_ID <=", value, "courseCatgId");
            return (Criteria) this;
        }

        public Criteria andCourseCatgIdLike(String value) {
            addCriterion("COURSE_CATG_ID like", value, "courseCatgId");
            return (Criteria) this;
        }

        public Criteria andCourseCatgIdNotLike(String value) {
            addCriterion("COURSE_CATG_ID not like", value, "courseCatgId");
            return (Criteria) this;
        }

        public Criteria andCourseCatgIdIn(List<String> values) {
            addCriterion("COURSE_CATG_ID in", values, "courseCatgId");
            return (Criteria) this;
        }

        public Criteria andCourseCatgIdNotIn(List<String> values) {
            addCriterion("COURSE_CATG_ID not in", values, "courseCatgId");
            return (Criteria) this;
        }

        public Criteria andCourseCatgIdBetween(String value1, String value2) {
            addCriterion("COURSE_CATG_ID between", value1, value2, "courseCatgId");
            return (Criteria) this;
        }

        public Criteria andCourseCatgIdNotBetween(String value1, String value2) {
            addCriterion("COURSE_CATG_ID not between", value1, value2, "courseCatgId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("TEACHER_ID is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("TEACHER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(String value) {
            addCriterion("TEACHER_ID =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(String value) {
            addCriterion("TEACHER_ID <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(String value) {
            addCriterion("TEACHER_ID >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_ID >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(String value) {
            addCriterion("TEACHER_ID <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_ID <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLike(String value) {
            addCriterion("TEACHER_ID like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotLike(String value) {
            addCriterion("TEACHER_ID not like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<String> values) {
            addCriterion("TEACHER_ID in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<String> values) {
            addCriterion("TEACHER_ID not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(String value1, String value2) {
            addCriterion("TEACHER_ID between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(String value1, String value2) {
            addCriterion("TEACHER_ID not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andCourseImageIsNull() {
            addCriterion("COURSE_IMAGE is null");
            return (Criteria) this;
        }

        public Criteria andCourseImageIsNotNull() {
            addCriterion("COURSE_IMAGE is not null");
            return (Criteria) this;
        }

        public Criteria andCourseImageEqualTo(String value) {
            addCriterion("COURSE_IMAGE =", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageNotEqualTo(String value) {
            addCriterion("COURSE_IMAGE <>", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageGreaterThan(String value) {
            addCriterion("COURSE_IMAGE >", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE_IMAGE >=", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageLessThan(String value) {
            addCriterion("COURSE_IMAGE <", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageLessThanOrEqualTo(String value) {
            addCriterion("COURSE_IMAGE <=", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageLike(String value) {
            addCriterion("COURSE_IMAGE like", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageNotLike(String value) {
            addCriterion("COURSE_IMAGE not like", value, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageIn(List<String> values) {
            addCriterion("COURSE_IMAGE in", values, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageNotIn(List<String> values) {
            addCriterion("COURSE_IMAGE not in", values, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageBetween(String value1, String value2) {
            addCriterion("COURSE_IMAGE between", value1, value2, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseImageNotBetween(String value1, String value2) {
            addCriterion("COURSE_IMAGE not between", value1, value2, "courseImage");
            return (Criteria) this;
        }

        public Criteria andCourseInfoIsNull() {
            addCriterion("COURSE_INFO is null");
            return (Criteria) this;
        }

        public Criteria andCourseInfoIsNotNull() {
            addCriterion("COURSE_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andCourseInfoEqualTo(String value) {
            addCriterion("COURSE_INFO =", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoNotEqualTo(String value) {
            addCriterion("COURSE_INFO <>", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoGreaterThan(String value) {
            addCriterion("COURSE_INFO >", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE_INFO >=", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoLessThan(String value) {
            addCriterion("COURSE_INFO <", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoLessThanOrEqualTo(String value) {
            addCriterion("COURSE_INFO <=", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoLike(String value) {
            addCriterion("COURSE_INFO like", "%"+value+"%", "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoNotLike(String value) {
            addCriterion("COURSE_INFO not like", value, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoIn(List<String> values) {
            addCriterion("COURSE_INFO in", values, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoNotIn(List<String> values) {
            addCriterion("COURSE_INFO not in", values, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoBetween(String value1, String value2) {
            addCriterion("COURSE_INFO between", value1, value2, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseInfoNotBetween(String value1, String value2) {
            addCriterion("COURSE_INFO not between", value1, value2, "courseInfo");
            return (Criteria) this;
        }

        public Criteria andCourseViewsIsNull() {
            addCriterion("COURSE_VIEWS is null");
            return (Criteria) this;
        }

        public Criteria andCourseViewsIsNotNull() {
            addCriterion("COURSE_VIEWS is not null");
            return (Criteria) this;
        }

        public Criteria andCourseViewsEqualTo(Integer value) {
            addCriterion("COURSE_VIEWS =", value, "courseViews");
            return (Criteria) this;
        }

        public Criteria andCourseViewsNotEqualTo(Integer value) {
            addCriterion("COURSE_VIEWS <>", value, "courseViews");
            return (Criteria) this;
        }

        public Criteria andCourseViewsGreaterThan(Integer value) {
            addCriterion("COURSE_VIEWS >", value, "courseViews");
            return (Criteria) this;
        }

        public Criteria andCourseViewsGreaterThanOrEqualTo(Integer value) {
            addCriterion("COURSE_VIEWS >=", value, "courseViews");
            return (Criteria) this;
        }

        public Criteria andCourseViewsLessThan(Integer value) {
            addCriterion("COURSE_VIEWS <", value, "courseViews");
            return (Criteria) this;
        }

        public Criteria andCourseViewsLessThanOrEqualTo(Integer value) {
            addCriterion("COURSE_VIEWS <=", value, "courseViews");
            return (Criteria) this;
        }

        public Criteria andCourseViewsIn(List<Integer> values) {
            addCriterion("COURSE_VIEWS in", values, "courseViews");
            return (Criteria) this;
        }

        public Criteria andCourseViewsNotIn(List<Integer> values) {
            addCriterion("COURSE_VIEWS not in", values, "courseViews");
            return (Criteria) this;
        }

        public Criteria andCourseViewsBetween(Integer value1, Integer value2) {
            addCriterion("COURSE_VIEWS between", value1, value2, "courseViews");
            return (Criteria) this;
        }

        public Criteria andCourseViewsNotBetween(Integer value1, Integer value2) {
            addCriterion("COURSE_VIEWS not between", value1, value2, "courseViews");
            return (Criteria) this;
        }

        public Criteria andAppendTimeIsNull() {
            addCriterion("APPEND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAppendTimeIsNotNull() {
            addCriterion("APPEND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAppendTimeEqualTo(String value) {
            addCriterion("APPEND_TIME =", value, "appendTime");
            return (Criteria) this;
        }

        public Criteria andAppendTimeNotEqualTo(String value) {
            addCriterion("APPEND_TIME <>", value, "appendTime");
            return (Criteria) this;
        }

        public Criteria andAppendTimeGreaterThan(String value) {
            addCriterion("APPEND_TIME >", value, "appendTime");
            return (Criteria) this;
        }

        public Criteria andAppendTimeGreaterThanOrEqualTo(String value) {
            addCriterion("APPEND_TIME >=", value, "appendTime");
            return (Criteria) this;
        }

        public Criteria andAppendTimeLessThan(String value) {
            addCriterion("APPEND_TIME <", value, "appendTime");
            return (Criteria) this;
        }

        public Criteria andAppendTimeLessThanOrEqualTo(String value) {
            addCriterion("APPEND_TIME <=", value, "appendTime");
            return (Criteria) this;
        }

        public Criteria andAppendTimeLike(String value) {
            addCriterion("APPEND_TIME like", value, "appendTime");
            return (Criteria) this;
        }

        public Criteria andAppendTimeNotLike(String value) {
            addCriterion("APPEND_TIME not like", value, "appendTime");
            return (Criteria) this;
        }

        public Criteria andAppendTimeIn(List<String> values) {
            addCriterion("APPEND_TIME in", values, "appendTime");
            return (Criteria) this;
        }

        public Criteria andAppendTimeNotIn(List<String> values) {
            addCriterion("APPEND_TIME not in", values, "appendTime");
            return (Criteria) this;
        }

        public Criteria andAppendTimeBetween(String value1, String value2) {
            addCriterion("APPEND_TIME between", value1, value2, "appendTime");
            return (Criteria) this;
        }

        public Criteria andAppendTimeNotBetween(String value1, String value2) {
            addCriterion("APPEND_TIME not between", value1, value2, "appendTime");
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