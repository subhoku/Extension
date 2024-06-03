package com.ext.util;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

import com.ext.model.ResponseHeaderModel;




public class CommonUtils {
	private static final SecureRandom random = new SecureRandom();
	private static final java.util.Base64.Encoder encoder = java.util.Base64.getUrlEncoder().withoutPadding();
	public static SimpleDateFormat sdfDdMmYyyy = new SimpleDateFormat("dd/MM/yyyy");
	public static SimpleDateFormat sdfMmDdYyyy = new SimpleDateFormat("MM/dd/yyyy");
	public static SimpleDateFormat sdfYyyyMmDd = new SimpleDateFormat("yyyy/MM/dd");
	public static SimpleDateFormat sdfYyyyMmDdHhMmSS = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	public static SimpleDateFormat sdfForNewDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
	public static SimpleDateFormat sdfYyyyMmDdByHyphen = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sdfddMmYyyyHhMmSS = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static SimpleDateFormat sdfDdMmYyyyByHyphen = new SimpleDateFormat("dd-MM-yyyy");

	public static boolean checkNameString(String str, String length) {
		boolean flag = false;
		try {
			/*
			 * if (isNull(str)) { flag = false; }
			 */
			if (Pattern.compile("[A-Za-z\\s\\.]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	public static Date getDateFromStr(String originalDate, String fromFormat, String toFormat) {
		SimpleDateFormat srcFrm = new SimpleDateFormat(fromFormat);
		SimpleDateFormat trgtFrm = new SimpleDateFormat(toFormat);
		Date convertedDate = null;
		try {
			Date orgDate = srcFrm.parse(originalDate);
			String convertedDateStr = trgtFrm.format(orgDate);
			convertedDate = srcFrm.parse(convertedDateStr);
		} catch (Exception e) {
		}
		return convertedDate;
	}

	public static String getDateAsStrDMY(Date dateVal) {
		String dateStr;
		try {
			dateStr = sdfDdMmYyyy.format(dateVal);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return dateStr;
	}

	public static String getDateAsStrDMY(Object dateVal) {
		String dateStr;
		try {
			dateStr = sdfDdMmYyyy.format(dateVal);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return dateStr;
	}

	public static Date getDateInDMY(String originalDate) {
		Date convertedDate = null;
		try {
			convertedDate = sdfDdMmYyyy.parse(originalDate);
		} catch (Exception e) {
		}
		return convertedDate;
	}
	
	public static Date getDateInDDMMYYYY(String originalDate) {
		Date convertedDate = null;
		try {
			convertedDate = sdfYyyyMmDdByHyphen.parse(originalDate);
		} catch (Exception e) {
		}
		return convertedDate;
	}

	public static Date getDateInMDY(String originalDate) {
		Date convertedDate = null;
		try {
			convertedDate = sdfMmDdYyyy.parse(originalDate);
		} catch (Exception e) {
		}
		return convertedDate;
	}

	public static Date getDateInYMD(String originalDate) {
		Date convertedDate = null;
		try {
			convertedDate = sdfYyyyMmDd.parse(originalDate);
		} catch (Exception e) {
		}
		return convertedDate;
	}

	public static boolean isNull(Object str) {
		if (str == (null) || str.toString().equals("") || str.toString().equals(" ")
				|| str.toString().trim().length() == 0 || str.toString().trim().equals("null")
				|| str.toString().trim().equalsIgnoreCase("undefined")) {
			return true;
		}
		return false;
	}

	public static boolean isValidDate(String inDate, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
		try {
			sdf.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	public static int dateDiff(Date fromDate, Date toDate) {
		long diff;
		int diffDays = 0;
		try {
			diff = toDate.getTime() - fromDate.getTime();
			diffDays = (int) (diff / (24 * 60 * 60 * 1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diffDays;
	}

	public static long dateDiffInDays(String startDate, String endDate) {
		long diffDays = 0L;
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			Date d1 = format.parse(startDate);
			Date d2 = format.parse(endDate);

			// in milliseconds
			long diffInMs = d2.getTime() - d1.getTime();

			// long diffSeconds = diffInMs / 1000 % 60;
			// long diffMinutes = diffInMs / (60 * 1000) % 60;
			// long diffHours = diffInMs / (60 * 60 * 1000) % 24;
			diffDays = diffInMs / (24 * 60 * 60 * 1000);

			// System.out.print(diffHours + " hours, ");
			// System.out.print(diffMinutes + " minutes, ");
			// System.out.print(diffSeconds + " seconds.");S
		} catch (Exception e) {
			e.printStackTrace();
		}
		return diffDays;
	}
	// public static String getExpiryTime(String timestamp) {
	// String expiryTime = null;
	// SimpleDateFormat formatter = new
	// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
	//
	// try {
	// Calendar cal = Calendar.getInstance();
	// cal.setTime(formatter.parse(timestamp));
	// cal.add(Calendar.MINUTE, EXPIRY_TIME + GRACE_TIME);
	// expiryTime = formatter.format(cal.getTime());
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// return expiryTime;
	// }

	// ################################################################################################################
	// Request Validation
	// ################################################################################################################

	// public static boolean validateRequest(JSONObject jsonReqHeader, boolean
	// isLogin) {
	// boolean isValid = false;
	// try {
	// JSONObject jsonDeviceInfo = jsonReqHeader.getJSONObject("deviceInfo");
	//
	// if (isLogin) {
	// if (!isNull(jsonReqHeader.optString("version")) &&
	// !isNull(jsonReqHeader.optString("ts"))
	// && !isNull(jsonReqHeader.optString("txn")) &&
	// isNull(jsonReqHeader.optString("keySign"))
	// && isNull(jsonReqHeader.optString("sessionRefId")) &&
	// !isNull(jsonReqHeader.optString("lang"))
	// && !isNull(jsonDeviceInfo.optString("os")) &&
	// !isNull(jsonDeviceInfo.optString("osVersion"))
	// && !isNull(jsonDeviceInfo.optString("deviceType"))) {
	//
	// isValid = true;
	//
	// } else {
	// isValid = false;
	// }
	// } else {
	// if (!isNull(jsonReqHeader.optString("version")) &&
	// !isNull(jsonReqHeader.optString("ts"))
	// && !isNull(jsonReqHeader.optString("txn")) &&
	// !isNull(jsonReqHeader.optString("keySign"))
	// && !isNull(jsonReqHeader.optString("sessionRefId")) &&
	// !isNull(jsonReqHeader.optString("lang"))
	// && !isNull(jsonDeviceInfo.optString("os")) &&
	// !isNull(jsonDeviceInfo.optString("osVersion"))
	// && !isNull(jsonDeviceInfo.optString("deviceType"))) {
	//
	// isValid = true;
	//
	// } else {
	// isValid = false;
	// }
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return isValid;
	// }

	// public static int validateSession(String sessionRefId, String timeStamp)
	// {
	// int valid = 1;
	// try {
	// SimpleDateFormat formatter = new
	// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
	// StoreClient<GenericRecord, GenericRecord> client =
	// CacheUtils.getVoldermortConnection();
	// GenericRecord key = CacheUtils.getKeySchema();
	// key.put("sessionRefId", sessionRefId);
	// Versioned<GenericRecord> versioned = CacheUtils.get(client, key);
	//
	// if (!CommonUtils.isNull(String.valueOf(versioned))) {
	// GenericRecord userDetails = versioned.getValue();
	// String expiryTime = String.valueOf(userDetails.get("expiryTime"));
	//
	// if (validTimeRequest(expiryTime, timeStamp)) {
	// userDetails.put("lastTimestamp", formatter.format(new Date()));
	// userDetails.put("expiryTime", getExpiryTime(formatter.format(new
	// Date())));
	// versioned.setObject(userDetails);
	// CacheUtils.update(client, key, versioned);
	// valid = VALID_REQUEST;
	//
	// } else {
	// valid = INVALID_TIMESTAMP;
	// }
	// } else {
	// valid = INVALID_SESSION;
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return valid;
	// }

	// public static int validateSession(String sessionRefId, String timeStamp,
	// String keySign) {
	// int valid = 1;
	// Connection conn = null;
	// VoldermortModel voldermort = new VoldermortModel();
	// Statement stmt = null;
	// try {
	// conn = CacheUtils.getConnection();
	// String decryptedKeySign = null;
	//
	// if
	// (!CommonUtils.isNull(String.valueOf(CacheUtils.getUserDetails(sessionRefId))))
	// {
	// voldermort = CacheUtils.getUserDetails(sessionRefId);
	// String expiryTime = String.valueOf(voldermort.getExpiryTime());
	//
	// if (validTimeRequest(expiryTime, timeStamp)) {
	// decryptedKeySign = CryptoUtils.decryptKeySign(keySign,
	// String.valueOf(voldermort.getSecureToken()));
	// if (validTimeRequest(expiryTime, decryptedKeySign.substring(22,
	// decryptedKeySign.length()))) {
	// String sqlStr = "update nam_cache_store t set t.lastTimestamp = '" +
	// timeStamp
	// + "' , t.expiryTime = '" + getExpiryTime(timeStamp) + "' where
	// t.sessionRefId = '"
	// + sessionRefId + "'";
	// stmt = conn.createStatement();
	// stmt.executeUpdate(sqlStr);
	//
	// if
	// (org.apache.commons.lang.StringUtils.leftPad(String.valueOf(voldermort.getUserId()),
	// 20, "0")
	// .equals(decryptedKeySign.substring(0, 20))) {
	//
	// String deviceType = decryptedKeySign.substring(20, 22);
	//
	// if (deviceType.equals("01")) {
	// deviceType = "M";
	// } else if (deviceType.equals("02")) {
	// deviceType = "B";
	// } else if (deviceType.equals("03")) {
	// deviceType = "P";
	// } else {
	// deviceType = "O";
	// }
	// if (deviceType.equals(String.valueOf(voldermort.getDeviceType()))) {
	// valid = VALID_REQUEST;
	// } else {
	// valid = INVALID_DEVICETYPE;
	// }
	// } else {
	// valid = INVALID_USER;
	// }
	//
	// } else {
	// valid = INVALID_KS_TIMESTAMP;
	// }
	//
	// } else {
	// valid = INVALID_TIMESTAMP;
	// }
	//
	// } else {
	// valid = INVALID_SESSION;
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return 0;
	// }

//	public static RequestHeaderModel setRequestModel(JSONObject jsonReqHeader) {
//		RequestHeaderModel requestHeader = new RequestHeaderModel();
//		try {
//			requestHeader.setVersion(jsonReqHeader.optString("version"));
//			requestHeader.setTs(jsonReqHeader.optString("ts"));
//			requestHeader.setTxn(jsonReqHeader.optString("txn"));
//			requestHeader.setKeySign(jsonReqHeader.optString("keySign"));
//			requestHeader.setKeyIndex(jsonReqHeader.optString("keyIndex"));
//			requestHeader.setSessionRefId(jsonReqHeader.optString("sessionRefId"));
//			requestHeader.setLang(jsonReqHeader.optString("lang"));
//			requestHeader.setSessionRefId(jsonReqHeader.optString("sessionRefId"));
//			requestHeader.setLang(jsonReqHeader.optString("lang"));
//			requestHeader.setOrgId(jsonReqHeader.optString("orgId"));
//			requestHeader.setOprId(jsonReqHeader.optString("oprId"));
//			//JSONObject jsonDeviceInfo = jsonReqHeader.getJSONObject("deviceInfo");
//			// Set Device Info
//			requestHeader.setOs(jsonDeviceInfo.optString("os"));
//			requestHeader.setOsVersion(jsonDeviceInfo.optString("osVersion"));
//			requestHeader.setDeviceType(jsonDeviceInfo.optString("deviceType"));
//			requestHeader.setDeviceId(jsonDeviceInfo.optString("deviceId"));
//			requestHeader.setPublicIp(jsonDeviceInfo.optString("publicIp"));
//			requestHeader.setBrowser(jsonDeviceInfo.optString("browser"));
//			requestHeader.setAppVersion(jsonDeviceInfo.optString("appVersion"));
//			requestHeader.setMacAddress(jsonDeviceInfo.optString("macAddress"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return requestHeader;
//	}

	public static ResponseHeaderModel setResponseModel(String txn, String errCode, String errMsg) {
		ResponseHeaderModel responseHeader = new ResponseHeaderModel();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'XXX");
		try {
			responseHeader.setTs(formatter.format(new Date()));
			responseHeader.setTxn(txn);
			responseHeader.setStatusMsg("F");
			responseHeader.setErr(errCode);
			responseHeader.setErrMsg(errMsg);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseHeader;
	}

	/* Common validation methods for project */
	public static boolean isInteger(String str) {
		if (str == null || str == "" || str == " " || str == "0") {
			return false;
		}

		int length = str.length();
		if (length == 0) {
			return false;
		}
		if (length > 20) {
			return false;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
			if (str.contains("-")) {
				return false;
			}

		}
		return true;
	}

	//////////////////////
	public static boolean checkNumber(String str, String length) {
		boolean flag = false;
		try {

			/*
			 * if (isNull(str)) { flag=false; }
			 */

			if (Pattern.compile("(^0 | ^\\-)?[0-9]{1," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}

	}

	public static boolean checkDecimalNumber(String str) {
		boolean flag = false;
		try {

			// if
			// (Pattern.compile("[0-9]+(\\.[0-9][0-9][0-9][0-9]?)?").matcher(str).matches())
			// {
			if (Pattern.compile("^\\d+(?:\\.\\d{1,4})?$").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}

	}

	public static boolean checkAlpha(String str, String length) {
		boolean flag = false;
		try {
			/*
			 * if (isNull(str)) { flag = false; }
			 */
			if (Pattern.compile("[A-Za-z]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	public static boolean checkAlphaMandatory(String str, String length) {
		boolean flag = false;
		try {
			if (isNull(str)) {
				flag = false;
			}
			if (Pattern.compile("[A-Za-z\\s]{3," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			// System.out.println(flag);
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	public static boolean checkAlphaSpace(String str, String length) {
		boolean flag = false;
		try {
			/*
			 * if (isNull(str)) { flag = false; }
			 */
			if (Pattern.compile("[A-Za-z\\s]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	public static boolean checkAlphaSpaceHyphen(String str, String length) {
		boolean flag = false;
		try {
			/*
			 * if (isNull(str)) { flag = false; }
			 */
			if (Pattern.compile("[A-Za-z\\-\\s]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	// A- Z, 0-9 [] () &@#$%*
	public static boolean checkAlphaSpaceSpe(String str, String length) {
		boolean flag = false;
		try {

			if (Pattern
					.compile("[A-Za-z0-9\\-\\s\\[\\]\\(\\)\\,\\_\\!\\^\\&\\@\\#\\$\\%\\*\\./]{0," + length.trim() + "}")
					.matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	public static boolean checkAlphaSpaceSpeace(String str, String length) {
		boolean flag = false;
		try {

			if (Pattern.compile("[A-Za-z0-9\\-\\s\\[\\]\\(\\)\\&\\@\\#\\$\\%\\*\\?\\./\\+\\:\\,]{0," + length.trim() + "}")
					.matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	// a-z, A- Z, 0-9 [] ()&
	public static boolean checkAlphaSpe(String str, String length) {
		boolean flag = false;
		try {

			if (Pattern.compile("[a-zA-Z0-9\\ \\[\\]\\(\\)\\&]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	public static boolean checkAlphaSpaceDot(String str, String length) {
		boolean flag = false;
		try {
			/*
			 * if (isNull(str)) { flag = false; }
			 */
			if (Pattern.compile("[A-Za-z\\s\\.]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	public static boolean checkAlphaNumeric(String str, String length) {
		boolean flag = false;
		try {
			/*
			 * if (isNull(str)) { flag = false; }
			 */
			if (Pattern.compile("[A-Za-z0-9]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	public static boolean checkAlphaOrNumeric(String str, String length) {
		boolean flag = false;
		try {
			if (Pattern.compile("^(?=.*[A-Za-z]*)(?=.*[0-9]*)[A-Za-z0-9]{0," + length.trim() + "}$").matcher(str)
					.matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	public static boolean checkAlphaNumHyphenUndrScoreSlash(String str, String length) {
		boolean flag = false;
		try {

			if (Pattern.compile("[A-Za-z0-9\\_\\.\\-\\/]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	public static boolean checkAlphaNumSpacHyphenUndrScoreSlash(String str, String length) {
		boolean flag = false;
		try {

			if (Pattern.compile("[A-Za-z0-9\\_\\-\\s\\.]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	public static boolean checkAlphaLinkPath(String str, String length) {
		boolean flag = false;
		try {
			/*
			 * if (isNull(str)) { flag = false; }
			 */
			if (Pattern.compile("[A-Za-z0-9\\_\\#]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	public static boolean isAlphaNumSpecialCharMatches(String str) {
		try {
			Pattern alphaNumericRegex = Pattern
					.compile("[\\p{Alnum} \\_\\.\\&\\=\\?\\;\\!\\@\\#\\$\\%\\^\\&\\*\\-\\(\\)\\[\\]\\+]*");
			return alphaNumericRegex.matcher(str).matches();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean checkAlphaNumSpaceHyphen(String str, String length) {
		boolean flag = false;
		try {
			/*
			 * if (isNull(str)) { flag = false; }
			 */
			if (Pattern.compile("[A-Za-z0-9\\-\\s]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	public static boolean checkPin(String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("^[1-9][0-9]{5}$").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkEmail(String str, String length) {
		boolean flag = false;
		try {
			//String pattern = "[_a-z0-9-]\\+\\(\\.\\[\\_a-z0-9-]\\+\\)\\*\\@\\[a-z0-9-]\\+\\(\\.\\[a-z0-9-]+\\)\\*\\(\\.\\[a-z]{2,4}\\)";
			
			String pattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
			
			if (Pattern.compile(pattern).matcher(str.toLowerCase()).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkPhoneNo(String str, String length) {
		boolean flag = false;
		try {

			String pattern = "(91|0)?[7-9]?[0-9]{10,13}$";
			if (Pattern.compile(pattern).matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkSpecialCharAddress(String str, String length) {
		boolean flag = false;
		try {
			String pattern = "[a-zA-Z0-9 \\&\\@\\.\\+\\?\\*\\!\\/\\-\\,\\(\\)\\:\\`\\_\\s]+{0," + length.trim() + "}";
			if (Pattern.compile(pattern).matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean allowAllSpecialCharector(String str, String length) {
		boolean flag = false;
		try {
			String pattern = "[a-zA-Z0-9 \\&\\@\\.\\+\\?\\*\\!\\/\\-\\,\\(\\)\\:\\`\\_\\s\\']+{0," + length.trim() + "}";
			if (Pattern.compile(pattern).matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkPanNo(String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}$").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkTanNo(String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("[A-Z]{4}[0-9]{5}[A-Z]{1}$").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkCodeNo(String str, String length) {
		boolean flag = false;
		try {
			if (Pattern.compile("[A-Za-z0-9\\-\\/]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkDecimal(String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("[0-9]{0,9}[\\.][0-9]{0,4}$").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkTimeZone(String str, String length) {
		boolean flag = false;
		try {
			if (Pattern.compile("[A-Za-z0-9\\-\\+\\:]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkOperationMode(String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("[I|U|D|M]{1}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkYMDFlag(String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("[Y|M|D]{1}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkPkgType(String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("[P|T]{1}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkInclusiveExclusive(String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("[I|E]{1}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkUserOuType(String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("[F|U]{1}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkUserSlab(String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("[S|U]{1}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkOuSlab(String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("[S|O]{1}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkYesNo(String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("[Y|N]{1}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkExtendedSupport(String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("[A|C]{1}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkPassword(String str) {
		boolean flag = false;
		try {
			String pattern = "^(?=.*[0-9])(?=.*[_@#$%&*])[a-zA-Z0-9_@#$%&*]{8,15}$";
			if (Pattern.compile(pattern).matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkAlphaUnderscore(String str, String length) {
		boolean flag = false;
		try {
			/*
			 * if (isNull(str)) { flag = false; }
			 */
			if (Pattern.compile("[A-Za-z0-9\\_]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	public static boolean checkAlphaUnderscores(String str, String length) {
		boolean flag = false;
		try {
			/*
			 * if (isNull(str)) { flag = false; }
			 */
			if (Pattern.compile("[A-Za-z\\_]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	//////////////////
	public static boolean checkNumber(String value) {
		boolean flag = false;
		try {
			String pattern = "\\d+$";
			if (Pattern.compile(pattern).matcher(value).find()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;

		} catch (Exception e) {
			// TODO: Add catch code
			e.printStackTrace();
			return flag;
		}
	}

	public static boolean checkAlpha(String value) {
		try {
			return Pattern.compile("[A-Za-z]*").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			e.printStackTrace();
			return false;
		}
	}

	public static boolean checkAlphaSimulation(String value) {
		try {
			return Pattern.compile("[A-Za-z]{1}$").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			e.printStackTrace();
			return false;
		}
	}

	public static boolean checkAlphaCaps(String value) {
		try {
			return Pattern.compile("[A-Z]*").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean checkAlphaCapsLength(String value) {
		try {
			return Pattern.compile("[A-Z]").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean checkAlphaCapsForGeneralMaster(String value) {
		try {

			return Pattern.compile("[A-Z]").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean checkAlphaSpace(String value) {
		try {
			return Pattern.compile("^[A-Za-z\\s]+$").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			e.printStackTrace();
			return false;
		}
	}

	public static boolean checkAlphaSpaceLength(String value) {
		try {
			return Pattern.compile("^[A-Za-z\\s]{3,20}$").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			e.printStackTrace();
			return false;
		}
	}

	public static boolean checkAlphaSpaceDot(String value) {
		try {
			return Pattern.compile("^[A-Za-z\\s\\.]+$").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			e.printStackTrace();
			return false;
		}
	}

	public static boolean checkAlphaSpaceDotLength(String value) {
		try {
			return Pattern.compile("^[A-Za-z\\s\\.]{3,20}$").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			e.printStackTrace();
			return false;
		}
	}

	public static boolean checkAlphaNum(String value) {
		try {
			return Pattern.compile("^[A-Za-z0-9]+$").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean checkAlphaNumLength(String value) {
		try {
			return Pattern.compile("^[A-Za-z0-9]{3,18}$").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean checkAlphaNumForCode(String value) {
		try {
			return Pattern.compile("^[A-Za-z0-9]{1,3}$").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean checkAlphaNumSpace(String value) {
		try {
			return Pattern.compile("^[A-Za-z0-9\\s]+$").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean checkAlphaNumSpaceLength(String value) {
		try {
			return Pattern.compile("^[A-Za-z0-9\\s]{3,18}$").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			// e.printStackTrace();
			return false;
		}
	}

	/*
	 * public static boolean checkAlphaNumSpaceHyphen(String value) { try {
	 * return Pattern.compile("^[A-Za-z0-9\\-\\s]+$").matcher(value).find(); }
	 * catch (Exception e) { // TODO: Add catch code // e.printStackTrace();
	 * return false; } }
	 */
	public static boolean checkAlphaNumSpaceHyphenLength(String value) {
		try {
			return Pattern.compile("^[A-Za-z0-9\\-\\s]{3,18}$").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean checkSpecialChar(String value) {
		try {
			return Pattern.compile("[A-Za-z0-9\\-\\s]*").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean checkCodeNoLength(String value) {
		try {
			return Pattern.compile("^[A-Za-z0-9\\-\\/]+$").matcher(value).find();

		} catch (Exception e) {
			// TODO: Add catch code ^[(\\+91|0)?\\d{13}]$
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean checkDate(String value) {
		try {
			return Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[//](0[1-9]|1[012])[/](19|20)\\d\\d+$").matcher(value)
					.find();
		} catch (Exception e) {
			// TODO: Add catch code
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean checkDateBetween(String frmDate, String toDate, String dateToBeCheck) {
		boolean Status = false;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			LocalDate localFromDate = LocalDate.parse(frmDate, formatter);
			LocalDate localToDate = LocalDate.parse(toDate, formatter);
			LocalDate localDateToBeCheck = LocalDate.parse(dateToBeCheck, formatter);
			if (localDateToBeCheck.isAfter(localFromDate) && localDateToBeCheck.isBefore(localToDate)
					|| localDateToBeCheck.compareTo(localFromDate) == 0
					|| localDateToBeCheck.compareTo(localToDate) == 0) {
				Status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			Status = false;
		}
		return Status;
	}

	public static boolean checkDecimalVal(String value) {
		try {
			return Pattern.compile("^\\d[0-9]{0,11}(\\.\\d{0,4})?$").matcher(value).find();// ^\\d{1,12}(\\.\\d{1,4})?$
		} catch (Exception e) {
			// TODO: Add catch code
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean checkThreeDecimalVal(String value) {
		try {
			return Pattern.compile("^\\d[0-9]{0,11}(\\.\\d{0,3})?$").matcher(value).find();// ^\\d{1,12}(\\.\\d{1,4})?$
		} catch (Exception e) {
			// TODO: Add catch code
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean checkTimeZone(String value) {
		try {
			return Pattern.compile("^[A-Za-z0-9\\+\\(\\)\\:\\-\\.\\s]{5,18}$").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean checkStatus(String value) {
		try {
			return Pattern.compile("[AI]$").matcher(value).find();
		} catch (Exception e) {
			// TODO: Add catch code
			e.printStackTrace();
			return false;
		}
	}

	public static boolean checkPassword(String password, String minlen, String maxlen) {
		boolean flag = false;
		try {
			if (Pattern.compile(
					"^(?=^[a-zA-Z_.&=?;!@#$%^&*-])(?=.*[a-zA-Z])(?=.*\\d)(?=.*[_.&=?;!@#$%^&*-])[a-zA-Z\\d_.&=?;!@#$%^&*-]{"
							+ minlen.trim() + "," + maxlen.trim() + "}$")
					.matcher(password).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	public static boolean checkLangFlag(String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("[E|M]{1}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

//	public static String getKeyDigestString(String message, String key) throws NoSuchProviderException {
//		try {
//			String pwCompareStr = "";
//			byte[] messageByte = message.getBytes();
//			// if no key is provided, the message string gets encrypted with
//			// itself
//			// byte[] keyByte = (key != null && key.length() > 0) ?
//			// key.getBytes() : message.getBytes();
//
//			// get SHA1 instance
//			MessageDigest sha1 = MessageDigest.getInstance("SHA-1", "SUN");
//			sha1.update(messageByte);
//
//			// byte[] digestByte = sha1.digest(keyByte);
//			byte[] digestByte = sha1.digest();
//
//			// base 64 encoding
//			Base64 base64 = new Base64();
//			pwCompareStr = (base64.encodeToString(digestByte));
//			pwCompareStr = new StringBuilder("{SHA-1}").append(pwCompareStr).toString();
//			return pwCompareStr;
//		} catch (NoSuchAlgorithmException e) {
//		}
//		return null;
//	}

	public static boolean isNumLenthValidate(String str, int strLen) {
		if (str == null || str == "" || str == " " || str == "0") {
			return true;
		}

		int length = str.length();
		if (length == 0) {
			return true;
		}
		if (length > strLen) {
			return true;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return true;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return true;
			}
			if (str.contains("-")) {
				return true;
			}

		}
		return false;
	}

	public static final Date getDateFormatOneDateMinus(Date date) {

		LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		// minus one
		localDateTime = localDateTime.minusDays(1);
		// convert LocalDateTime to date
		Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		return currentDatePlusOneDay;
	}

	public static boolean stringLenthValidate(String str, int strLen) {
		if (str == null || str == "" || str == " " || str == "0") {
			return true;
		}
		int actualStrlength = str.length();
		if (actualStrlength > strLen) {
			return true;
		}
		return false;
	}

	public static String getDDMMYYYY(String yyyymmdd) {
		if (yyyymmdd == null || yyyymmdd.trim().length() != 10 || yyyymmdd.equals("00000000")) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		builder.append(yyyymmdd.trim()
				.substring(8)); /* * DD part is being extracted. */
		builder.append("/");
		builder.append(yyyymmdd.trim().substring(5,
				7));/* * MM part is being extracted */
		builder.append("/");
		builder.append(yyyymmdd.trim().substring(0, 4));
		return builder.toString();
	}

	/**
	 * This method will check allowed character true or false.
	 * 
	 * @param allowed
	 * @param str
	 * @return boolean
	 */
	public static boolean checkCharacter(String allowed, String str) {
		boolean flag = false;
		try {
			if (Pattern.compile("[" + allowed + "]{1}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	/**
	 * Get the minutes difference
	 */
	public static int minutesDiff(Date exprire, Date curdate) {
		if (exprire == null || curdate == null)
			return 0;
		return (int) ((curdate.getTime() / 60000) - (exprire.getTime() / 60000));
	}

	/**
	 * This method will check number 3 digit and decimal 4 place
	 */
	public static boolean checkDecimalNumbers(String str) {
		return Pattern.compile("^[0-9]{0,3}|[0-9]{0,9}[\\.][0-9]{0,4}$").matcher(str).matches();
	}

	/**
	 * This method will return time
	 * 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static String getTime(Object object) throws Exception {
		String time = null;
		Timestamp timestamp = (Timestamp) object;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
		String aa = String.valueOf(timestamp);
		time = dateFormat1.format(dateFormat.parse(aa));
		return time;
	}

	/**
	 * @author mtembhare
	 * @param file
	 * @param orgId
	 * @param oprId
	 * @param fileName
	 * @return To upload any data this method will be used
	 */
//	public static String uploadData(String file, String orgId, String oprId, String fileName) {
//		String filePath = null;
//		try {
//			Calendar cal = Calendar.getInstance();
//			int month = cal.get(Calendar.MONTH) + 1;
//			int year = cal.get(Calendar.YEAR);
//			int week = cal.get(Calendar.WEEK_OF_MONTH);
//
//			String strDirectoy = "file" + orgId + oprId + year + month + week;
//
//			File directory = new File(strDirectoy);
//			boolean success = directory.exists() ? true : directory.mkdir();
//			if (success) {
//				String image = file.split(",")[1];
//				byte[] fileBytes;
//				Base64 decoder = new Base64();
//				fileBytes = decoder.decode(image);
//				filePath = strDirectoy + "\\" + fileName;
//				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
//				stream.write(fileBytes);
//				stream.close();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return filePath;
//
//	}

	/**
	 * Check value is null if null then return 0 else allocated value will
	 * return
	 * 
	 * @param ptoutBalamt
	 * @return value
	 */
	public static int isPositive(String ptoutBalamt) {
		int value = 0;
		if (ptoutBalamt == (null) || ptoutBalamt.toString().equals("") || ptoutBalamt.toString().equals(" ")
				|| ptoutBalamt.toString().trim().equals("null")
				|| ptoutBalamt.toString().trim().equalsIgnoreCase("undefined")) {
			return value;
		} else {
			return value = Integer.parseInt(ptoutBalamt);
		}

	}

	// A- Z, 0-9 @#$&*
	public static boolean checkAlphaSpeNO(String str, String length) {
		return Pattern.compile("[A-Za-z0-9\\&\\@\\#\\$\\*]{0," + length.trim() + "}").matcher(str).matches();
	}

	/**
	 * This method will check value if null or 0 then return bigdecimal value 0
	 * else convert value in bigdecimal
	 * 
	 * @param amt
	 * @return
	 */
	public static BigDecimal getDecimalValue(String amt) {
		BigDecimal value = BigDecimal.ZERO;
		if (!CommonUtils.isNull(amt)) {
			value = new BigDecimal(amt);
		}
		return value;
	}

	/**
	 * Get date if null then return null date else convert date
	 * 
	 * @param getDate
	 * @return
	 * @throws Exception
	 */
	public static Date isDateNull(String getDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		if (!CommonUtils.isNull(getDate)) {
			date = sdf.parse(getDate);
		}
		return date;
	}

	/**
	 * Check Date Format. If valid format then return true else false
	 * 
	 * @param String
	 *            date, String dateFormat
	 * @return
	 * @throws Exception
	 */
	public static boolean checkDateFormat(String date, String dateFormat) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		boolean valid = false;
		try {
			sdf.setLenient(false);
			sdf.parse(date);
			valid = true;
		} catch (Exception e) {
			valid = false;
		}
		return valid;
	}

	public static boolean checkNumAlpha(String str, String length) {
		boolean flag = false;
		try {
			/*
			 * if (isNull(str)) { flag = false; }
			 */
			if (Pattern.compile("[0-9A-Za-z]{0," + length.trim() + "}").matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

	/**
	 * @purpose to validate given date is greater than current date
	 * @param String
	 * @return boolean
	 */
	public static boolean validatePostDatedChequeDdPo(String ddMMyyyy) {
		boolean flag = false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (!isNull(ddMMyyyy)) {
			LocalDate now = LocalDate.now();
			LocalDate localToDate = LocalDate.parse(ddMMyyyy, formatter);
			flag = localToDate.isAfter(now);
		} else {
			return flag;
		}
		return flag;
	}

	/**
	 * @purpose to validate given date is greater than date after added days
	 * @param String
	 * @return boolean
	 */
	public static boolean validatePostDatedChequeDdPoDays(String ddMMyyyy, int days) {
		boolean flag = false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (!isNull(ddMMyyyy) && isInteger(String.valueOf(days))) {
			LocalDate localStartDate = LocalDate.parse(ddMMyyyy, formatter);
			LocalDate now = LocalDate.now();
			LocalDate localEndDate = now.plusDays(days);
			flag = localStartDate.isAfter(localEndDate);
		} else {
			return flag;
		}
		return flag;
	}

	/**
	 * @purpose to validate given date is less than current date
	 * @param String
	 * @return boolean
	 */
	public static boolean validateBackDatedChequeDdPo(String ddMMyyyy) {
		boolean flag = false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (!isNull(ddMMyyyy)) {
			LocalDate now = LocalDate.now();
			LocalDate localToDate = LocalDate.parse(ddMMyyyy, formatter);
			flag = localToDate.isBefore(now);
		} else {
			return flag;
		}
		return flag;
	}

	/**
	 * @purpose to validate given date is less than date after added days
	 * @param String
	 * @return boolean
	 */
	public static boolean validateBackDatedChequeDdPoDays(String ddMMyyyy, int days) {
		boolean flag = false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (!isNull(ddMMyyyy) && isInteger(String.valueOf(days))) {
			LocalDate localStartDate = LocalDate.parse(ddMMyyyy, formatter);
			LocalDate now = LocalDate.now();
			LocalDate localEndDate = now.minusDays(days);
			flag = localStartDate.isBefore(localEndDate);
		} else {
			return flag;
		}
		return flag;
	}

	/**
	 * @purpose use this when you want date format either yyyyMMdd or ddMMyyyy
	 * @param String
	 * @return string
	 */
	public static String modifiedChequeDt(String givenDate) {
		String modifiedDt = "";
		if (!isNull(givenDate)) {
			if (givenDate.substring(0, 4).equals("/") || givenDate.substring(0, 4).equals("-")) {
				modifiedDt = getDDMMYYYY(givenDate);
			} else {
				modifiedDt = givenDate;
			}

		}
		return modifiedDt;
	}

	/* Convert Date format yyyy-MM-dd to dd/MM/yyyy */
	@SuppressWarnings("deprecation")
	public static String formatDateDDMMYYYY(String date) {
		String dateStr;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			String[] dateArr = date.split("-");

			Date dt = new Date(Integer.parseInt(dateArr[0]) - 1900, Integer.parseInt(dateArr[1]) - 1,
					Integer.parseInt(dateArr[2]));
			dateStr = sdf.format(dt);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return dateStr;
	}

	/**
	 * @author Sohan Ingle
	 * @param file
	 * @param orgId
	 * @param oprId
	 * @param fileName
	 * @param linkId
	 */

//	public static void commonUploadData(String file, String fileName, String parentFilepath) {
//		String filePath = null;
//		try {
//
//			Path path1 = Paths.get(parentFilepath);
//
//			if (!Files.exists(path1)) {
//				Files.createDirectories(path1);
//			}
//
//			if (Files.exists(path1)) {
//				byte[] fileBytes = null;
//				if (file.indexOf(",") != -1)
//					fileBytes = Base64.decodeBase64(file.split(",")[1].getBytes());
//				else
//					fileBytes = Base64.decodeBase64(file.getBytes());
//
//				filePath = path1 + File.separator + fileName;
//				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
//				stream.write(fileBytes);
//				stream.close();
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	/**
	 * @author K Deshmukh
	 * @param String
	 *            filePath
	 * @return String form of Base64 encoded document.
	 */
//	public static String commonDownloadData(String filePath) {
//		String fileContent = null;
//		try {
//			File requestedFile = new File(filePath);
//			if (requestedFile.exists()) {
//				byte[] fileBytes = new byte[(int) requestedFile.length()];
//				BufferedInputStream stream = new BufferedInputStream(new FileInputStream(requestedFile));
//				stream.read(fileBytes);
//				stream.close();
//				fileContent = Base64.encodeBase64String(fileBytes);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return fileContent;
//	}

	/**
	 * @author K Deshmukh
	 * @param String
	 *            filePath
	 * @param String
	 *            extSepChar
	 * @return String fileExtension.
	 */
	public static String getFileExtension(String fullPath, String extSepChar) {
		String fileExt = null;
		try {
			int sepIndx = fullPath.lastIndexOf(extSepChar);
			if (sepIndx != -1 && sepIndx != (fullPath.length() - 1))
				fileExt = fullPath.substring(sepIndx + 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileExt;
	}

	public static boolean isFutureDate(String getDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date currDate = new Date();
			Date newDate = sdf.parse(getDate);
			if (newDate.after(currDate)) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException pe) {
			return false;
		}
	}

	public static boolean isDate1AfterDate2(String date1, String date2) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {

			if (sdf.parse(date1).after(sdf.parse(date2))) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException pe) {
			return false;
		}

	}

	public static String changeDateFormat(String originalDate, String fromFormat, String toFormat) {
		SimpleDateFormat srcFrm = new SimpleDateFormat(fromFormat);
		SimpleDateFormat trgtFrm = new SimpleDateFormat(toFormat);
		String convertedDate = null;
		try {
			Date orgDate = srcFrm.parse(originalDate);
			convertedDate = trgtFrm.format(orgDate);
		} catch (Exception e) {
		}
		return convertedDate;
	}

	/**
	 * @author Sohan Ingle
	 * 
	 *         Check date Format
	 * 
	 * @param dateString
	 *            , dateFormat
	 * @return *
	 */
	public static boolean CheckDateFormat(String getDate, String dateFormate) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
		boolean isValidFormat = false;

		if (!CommonUtils.isNull(getDate)) {
			try {
				sdf.parse(getDate);
				isValidFormat = true;
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		return isValidFormat;
	}

	public static boolean isCurrentsDate(String getDate) throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			LocalDate currDate = LocalDate.now();
			LocalDate newDate = LocalDate.parse(getDate, formatter);
			if (currDate.equals(newDate)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception pe) {
			pe.printStackTrace();
			return false;
		}
	}

	

	public static boolean checkAlphaSpaceSpclChar(String str, String length) {
		boolean flag = false;
		try {

			if (Pattern.compile("[A-Za-z\\-\\s\\[\\]\\(\\)\\,\\_\\!\\^\\&\\@\\#\\$\\%\\*\\./]{0," + length.trim() + "}")
					.matcher(str).matches()) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

//   public static Bucket getBucket4j(int noOfHitsAllow,int noOfMin){
//    	Bandwidth limit = Bandwidth.classic(10, Refill.greedy(noOfHitsAllow, Duration.ofMinutes(noOfMin)));
//    	return Bucket4j.builder().addLimit(limit).build();
//    } 
   
//   public static boolean isEncoded(String inputStr) {
//       try {
//           new String(com.lowagie.text.pdf.codec.Base64.decode(inputStr), StandardCharsets.UTF_8);
//           return true;
//       } catch (Exception e) {
//           return false;
//       }
//   }
   public static String generate() {
 		byte[] buffer = new byte[20];
 		random.nextBytes(buffer);
 		return encoder.encodeToString(buffer);
 	}
   
//	public static org.json.JSONObject getRequestHeader(org.json.JSONObject jsonObj) {
//		JSONObject jsonReqHeader = null;
//
//		try {
//			if (String.valueOf(jsonObj).contains("requestHeader")) {
//				jsonReqHeader = jsonObj.getJSONObject("requestHeader");
//				return jsonReqHeader;
//			} else {
//				return jsonReqHeader;
//			}
//		} catch (Exception e) {
//			return jsonReqHeader;
//		}
//
//	}
	
//	public static ResponseEntity<CommonModel> bindError(CommonModel commonModel) {
//	      commonModel.setResponseHeader(CommonUtils.setResponseModel("", "5001", "Invalid Request"));
//	      return new ResponseEntity<CommonModel>(commonModel, HttpStatus.OK);
//	}
		 
   
   public static boolean validateJavaDate(String strDate)
   {
	/* Check if date is 'null' */
	if (strDate.trim().equals(""))
	{
	    return true;
	}
	/* Date is not 'null' */
	else
	{
	    /*
	     * Set preferred date format,
	     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
	    SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
	    sdfrmt.setLenient(false);
	    /* Create Date object
	     * parse the string into date 
             */
	    try
	    {
	        Date javaDate = sdfrmt.parse(strDate); 
	        System.out.println(strDate+" is valid date format");
	    }
	    /* Date format is invalid */
	    catch (ParseException e)
	    {
	        System.out.println(strDate+" is Invalid Date format");
	        return false;
	    }
	    /* Return true if date format is valid */
	    return true;
	}
   }
   
}
