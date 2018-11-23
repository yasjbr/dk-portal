/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps.edu.diyar.studentInfo.database;

import java.io.Serializable;

/**
 *
 * @author Yaseen Jaber
 */
public class CoursesListView implements Serializable {

    private CoursesListViewPk comp_id;
    private String msCrsType;
    private String msCrsTypeAName;
    private String crsNo;
    private String crsAName;
    private Integer crHrs;
    private Integer crsMark;
    private String crsStatus;
    private String statusAName;
    private String termNo;

    public CoursesListViewPk getComp_id() {
        return comp_id;
    }

    public void setComp_id(CoursesListViewPk comp_id) {
        this.comp_id = comp_id;
    }

 

    public String getMsCrsType() {
        return msCrsType;
    }

    public void setMsCrsType(String msCrsType) {
        this.msCrsType = msCrsType;
    }

    public String getMsCrsTypeAName() {
        return msCrsTypeAName;
    }

    public void setMsCrsTypeAName(String msCrsTypeAName) {
        this.msCrsTypeAName = msCrsTypeAName;
    }

    public String getCrsNo() {
        return crsNo;
    }

    public void setCrsNo(String crsNo) {
        this.crsNo = crsNo;
    }

    public String getCrsAName() {
        return crsAName;
    }

    public void setCrsAName(String crsAName) {
        this.crsAName = crsAName;
    }

    public Integer getCrHrs() {
        return crHrs;
    }

    public void setCrHrs(Integer crHrs) {
        this.crHrs = crHrs;
    }

    public Integer getCrsMark() {
        return crsMark;
    }

    public void setCrsMark(Integer crsMark) {
        this.crsMark = crsMark;
    }

    public String getCrsStatus() {
        return crsStatus;
    }

    public void setCrsStatus(String crsStatus) {
        this.crsStatus = crsStatus;
    }

    public String getStatusAName() {
        return statusAName;
    }

    public void setStatusAName(String statusAName) {
        this.statusAName = statusAName;
    }

    public String getTermNo() {
        return termNo;
    }

    public void setTermNo(String termNo) {
        this.termNo = termNo;
    }

    public CoursesListView(CoursesListViewPk comp_id, String msCrsType, String msCrsTypeAName, String crsNo, String crsAName, Integer crHrs, Integer crsMark, String crsStatus, String statusAName, String termNo) {
        this.comp_id = comp_id;
        this.msCrsType = msCrsType;
        this.msCrsTypeAName = msCrsTypeAName;
        this.crsNo = crsNo;
        this.crsAName = crsAName;
        this.crHrs = crHrs;
        this.crsMark = crsMark;
        this.crsStatus = crsStatus;
        this.statusAName = statusAName;
        this.termNo = termNo;
    }

    public CoursesListView() {
    }

}
