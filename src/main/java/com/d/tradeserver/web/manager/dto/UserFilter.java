package com.d.tradeserver.web.manager.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserFilter {

    private String nickName;
    private String gender;
    private Integer minScore;
    private Integer maxScore;
    private String schoolCardIdLike;
    private String schoolName;
    private List<Integer> schoolIdList;
    private String realNameLike;
    private Integer status;
    private String emailLike;
    private Integer grade;
    private String majorName;
    private List<Integer> majorIdList;
    private String classNum;
    private String minCreateDateTime;
    private String maxCreateDateTime;
    private String minUpdateDateTime;
    private String maxUpdateDateTime;


    public Map<String, Object> getUserMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("nickName", nickName);
        map.put("gender", gender);
        map.put("minScore", minScore);
        map.put("maxScore", maxScore);
        return map;
    }

    public Map<String, Object> getUserDetailMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("schoolIdList", schoolIdList);
        map.put("majorIdList", majorIdList);
        map.put("schoolCardIdLike", schoolCardIdLike);
        map.put("realNameLike", realNameLike);
        map.put("status", status);
        map.put("emailLike", emailLike);
        map.put("grade", gender);
        map.put("classNum", classNum);
        return map;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public String getSchoolCardIdLike() {
        return schoolCardIdLike;
    }

    public void setSchoolCardIdLike(String schoolCardIdLike) {
        this.schoolCardIdLike = schoolCardIdLike;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Integer> getSchoolIdList() {
        return schoolIdList;
    }

    public void setSchoolIdList(List<Integer> schoolIdList) {
        this.schoolIdList = schoolIdList;
    }

    public String getRealNameLike() {
        return realNameLike;
    }

    public void setRealNameLike(String realNameLike) {
        this.realNameLike = realNameLike;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmailLike() {
        return emailLike;
    }

    public void setEmailLike(String emailLike) {
        this.emailLike = emailLike;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public List<Integer> getMajorIdList() {
        return majorIdList;
    }

    public void setMajorIdList(List<Integer> majorIdList) {
        this.majorIdList = majorIdList;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getMinCreateDateTime() {
        return minCreateDateTime;
    }

    public void setMinCreateDateTime(String minCreateDateTime) {
        this.minCreateDateTime = minCreateDateTime;
    }

    public String getMaxCreateDateTime() {
        return maxCreateDateTime;
    }

    public void setMaxCreateDateTime(String maxCreateDateTime) {
        this.maxCreateDateTime = maxCreateDateTime;
    }

    public String getMinUpdateDateTime() {
        return minUpdateDateTime;
    }

    public void setMinUpdateDateTime(String minUpdateDateTime) {
        this.minUpdateDateTime = minUpdateDateTime;
    }

    public String getMaxUpdateDateTime() {
        return maxUpdateDateTime;
    }

    public void setMaxUpdateDateTime(String maxUpdateDateTime) {
        this.maxUpdateDateTime = maxUpdateDateTime;
    }
}
