package com.itheima.domain;

public class Department {
	private int did;			//����id
	private String dname;		//��������
	private String dup;			//�ϼ�����
	private int dgrade;			//�ȼ�
	private int sum;            //Ա������
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDup() {
		return dup;
	}
	public void setDup(String dup) {
		this.dup = dup;
	}
	public int getDgrade() {
		return dgrade;
	}
	public void setDgrade(int dgrade) {
		this.dgrade = dgrade;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
}
