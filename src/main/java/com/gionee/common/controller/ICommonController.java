package com.gionee.common.controller;


public interface ICommonController<T,R>{
	
	public void doService(T request,R resp) ;
}
