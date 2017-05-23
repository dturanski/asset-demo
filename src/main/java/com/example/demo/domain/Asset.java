package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author David Turanski
 **/
@Entity
public class Asset {
	@Id
	@GeneratedValue
	long id;

	String macAddress;

	String ipAddress;

	public Asset(String ipAddress, String macAddress) {
		this.ipAddress = ipAddress;
		this.macAddress = macAddress;
	}

	public Asset() {

	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public long getId() {
		return id;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Asset asset = (Asset) o;

		return id == asset.id;
	}

	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}
}
