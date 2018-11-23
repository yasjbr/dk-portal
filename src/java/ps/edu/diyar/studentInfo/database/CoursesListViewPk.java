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
public class CoursesListViewPk  implements Serializable{
  private String msNo;
    private String specNo;
    private String studId;

    public String getMsNo() {
        return msNo;
    }

    public void setMsNo(String msNo) {
        this.msNo = msNo;
    }

    public String getSpecNo() {
        return specNo;
    }

    public void setSpecNo(String specNo) {
        this.specNo = specNo;
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CoursesListViewPk other = (CoursesListViewPk) obj;
        if ((this.msNo == null) ? (other.msNo != null) : !this.msNo.equals(other.msNo)) {
            return false;
        }
        if ((this.specNo == null) ? (other.specNo != null) : !this.specNo.equals(other.specNo)) {
            return false;
        }
        if ((this.studId == null) ? (other.studId != null) : !this.studId.equals(other.studId)) {
            return false;
        }
        return true;
    }
    
    
    
}
