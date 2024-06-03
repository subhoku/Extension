package com.ext.model;

public class RequestHeaderModel {
	// Private Variables
	private String version;
	private String ts;
	private String txn;
	private String keySign;
	private String keyIndex;
	private String sessionRefId;
	private String orgId;
	private String oprId;
	private String lang;
	private String os;
	private String osVersion;
	private String deviceType;
	private String deviceId;
	private String publicIp;
	private String browser;
	private String appVersion;
	private String macAddress;

	public RequestHeaderModel() {

	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getTxn() {
		return txn;
	}

	public void setTxn(String txn) {
		this.txn = txn;
	}

	public String getKeySign() {
		return keySign;
	}

	public void setKeySign(String keySign) {
		this.keySign = keySign;
	}

	public String getKeyIndex() {
		return keyIndex;
	}

	public void setKeyIndex(String keyIndex) {
		this.keyIndex = keyIndex;
	}

	public String getSessionRefId() {
		return sessionRefId;
	}

	public void setSessionRefId(String sessionRefId) {
		this.sessionRefId = sessionRefId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOprId() {
		return oprId;
	}

	public void setOprId(String oprId) {
		this.oprId = oprId;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getPublicIp() {
		return publicIp;
	}

	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	@Override
	public String toString() {
		return "RequestHeaderModel [version=" + version + ", ts=" + ts + ", txn=" + txn + ", keySign=" + keySign + ", keyIndex=" + keyIndex + ", sessionRefId=" + sessionRefId + ", orgId=" + orgId
		        + ", oprId=" + oprId + ", lang=" + lang + ", os=" + os + ", osVersion=" + osVersion + ", deviceType=" + deviceType + ", deviceId=" + deviceId + ", publicIp=" + publicIp + ", browser="
		        + browser + ", appVersion=" + appVersion + ", macAddress=" + macAddress + "]";
	}

	
	
}
