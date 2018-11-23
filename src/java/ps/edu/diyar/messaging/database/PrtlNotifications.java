/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps.edu.diyar.messaging.database;

/**
 *
 * @author Yaseen Jaber
 */
public class PrtlNotifications {
    private long notId;
    private String notMsg;

    public long getNotId() {
        return notId;
    }

    public void setNotId(long notId) {
        this.notId = notId;
    }

    public String getNotMsg() {
        return notMsg;
    }

    public void setNotMsg(String notMsg) {
        this.notMsg = notMsg;
    }

    public PrtlNotifications() {
    }

    
    
    
    
    
    
    public PrtlNotifications(long notId, String notMsg) {
        this.notId = notId;
        this.notMsg = notMsg;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (this.notId ^ (this.notId >>> 32));
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
        final PrtlNotifications other = (PrtlNotifications) obj;
        if (this.notId != other.notId) {
            return false;
        }
        return true;
    }
    
    
    
}
