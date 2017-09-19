package com.unionpay.withhold.admin.pojo;

public class TFunction {
    private Long functId;

    private String functName;

    private Long functOrder;

    private String parentId;

    private String url;

    private String icon;

    private String status;

    private Short levelId;

    private String leafnode;

    private String sysFlag;

    private Short functType;

    private String isadmin;

    private String moveSort;

    private String notes;

    private String remarks;

    public Long getFunctId() {
        return functId;
    }

    public void setFunctId(Long functId) {
        this.functId = functId;
    }

    public String getFunctName() {
        return functName;
    }

    public void setFunctName(String functName) {
        this.functName = functName == null ? null : functName.trim();
    }

    public Long getFunctOrder() {
        return functOrder;
    }

    public void setFunctOrder(Long functOrder) {
        this.functOrder = functOrder;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Short getLevelId() {
        return levelId;
    }

    public void setLevelId(Short levelId) {
        this.levelId = levelId;
    }

    public String getLeafnode() {
        return leafnode;
    }

    public void setLeafnode(String leafnode) {
        this.leafnode = leafnode == null ? null : leafnode.trim();
    }

    public String getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(String sysFlag) {
        this.sysFlag = sysFlag == null ? null : sysFlag.trim();
    }

    public Short getFunctType() {
        return functType;
    }

    public void setFunctType(Short functType) {
        this.functType = functType;
    }

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin == null ? null : isadmin.trim();
    }

    public String getMoveSort() {
        return moveSort;
    }

    public void setMoveSort(String moveSort) {
        this.moveSort = moveSort == null ? null : moveSort.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}