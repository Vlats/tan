package com.itheima.utils;

public class PageInfo {
	
	private int current;
	private int total;
	private int start;
	private int end;
	private int page_num;
	private int record_num = 10; //每页默认显示10条记录
	
	
	public int getPage_num() {
		return page_num;
	}


	public void setPage_num(int page_num) {
		this.page_num = page_num;
	}


	public int getRecord_num() {
		return record_num;
	}


	public void setRecord_num(int record_num) {
		this.record_num = record_num;
	}


	public PageInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PageInfo(int current,int total) {
		this.total = total;
		this.current = current;
		page_num = total/record_num;
		if(total%record_num!=0) page_num++;
		if(page_num<=5) {
			start = 1;
			end = page_num;
		}
		else {
			if(current<=3) {
				start = 1;
				end = 5;
			}
			else {
				if(page_num-current>=2)
				{start =current -2;
				end = current +2;}
				else {
					end = page_num;
					start = end - 5;
				}
				
			}
			
		}
		
		
		
	}
	
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}
