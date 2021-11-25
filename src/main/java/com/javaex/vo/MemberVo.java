package com.javaex.vo;
public class MemberVo {
    private int memNo;
    private String memName;
    private String memPhone;
    private String memAdd;
    private String memId;
    private String memPass;
    private String adminCk;
    
    
    
    
    
    public MemberVo(String memId, String memPass) {
        // TODO Auto-generated constructor stub
        this.memId = memId;
        this.memPass = memPass;
    }
    public MemberVo(String memname2, String memid2, String mempass2, String memphone2, String memadd2, String adminck2) {
        // TODO Auto-generated constructor stub
        this.memName = memname2;
        this.memId = memid2;
        this.memPass = mempass2;
        this.memPhone = memphone2;
        this.memAdd = memadd2;
        this.adminCk = adminck2;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    public int getMemNo() {
        return memNo;
    }
    public void setMemNo(int memNo) {
        this.memNo = memNo;
    }
    public String getMemName() {
        return memName;
    }
    public void setMemName(String memName) {
        this.memName = memName;
    }
    public String getMemPhone() {
        return memPhone;
    }
    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone;
    }
    public String getMemAdd() {
        return memAdd;
    }
    public void setMemAdd(String memAdd) {
        this.memAdd = memAdd;
    }
    public String getMemId() {
        return memId;
    }
    public void setMemId(String memId) {
        this.memId = memId;
    }
    public String getMemPass() {
        return memPass;
    }
    public void setMemPass(String memPass) {
        this.memPass = memPass;
    }
    
    public String getAdminCk() {
        return adminCk;
    }
    public void setAdminCk(String adminCk) {
        this.adminCk = adminCk;
    }
}
