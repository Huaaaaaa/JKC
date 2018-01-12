package com.hyc.construct;

public class TestA {
	public String hn;
	public String ak;
	public String sk;
	
    public TestA(){
//    	this.hn = "HostName";
//    	this.ak = "AccessKey";
//    	this.sk = "SecretKey";
    }
    
    public void setValue(){
    	setHn("HostName");
    	setAk("AccessKey");
    	setSk("SecretKey");
    }

	public String getHn() {
		return hn;
	}

	public void setHn(String hn) {
		this.hn = hn;
	}

	public String getAk() {
		return ak;
	}

	public void setAk(String ak) {
		this.ak = ak;
	}

	public String getSk() {
		return sk;
	}

	public void setSk(String sk) {
		this.sk = sk;
	}
    
    
}
