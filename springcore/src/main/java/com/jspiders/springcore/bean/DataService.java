package com.jspiders.springcore.bean;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DataService {

	// Field injection
	@Value("This object provides data service")
	private String serviceInfo;
	@Autowired
	private ArrayList<Object> arrayList;

	// Constructor injection
	public DataService(@Value("This object provides data service") String serviceInfo,
			@Autowired ArrayList<Object> arrayList) {
		super();
		this.serviceInfo = serviceInfo;
		this.arrayList = arrayList;
	}

	public String getServiceInfo() {
		return serviceInfo;
	}

	// Setter injection
	@Value("This object provides data service")
	public void setServiceInfo(String serviceInfo) {
		this.serviceInfo = serviceInfo;
	}

	public ArrayList<Object> getArrayList() {
		return arrayList;
	}

	// Setter injection
	@Autowired
	public void setArrayList(ArrayList<Object> arrayList) {
		this.arrayList = arrayList;
	}

	@Override
	public String toString() {
		return "DataService [serviceInfo=" + serviceInfo + ", arrayList=" + arrayList + "]";
	}

}
