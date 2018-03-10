package com.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//import org.apache.commons.lang.time.DateFormatUtils;


public class ToolUtil {

	/*public static String getOrderNo(String buyType) {
		String dateFormat = DateFormatUtils.format(System.currentTimeMillis(), "yyMMddHHmmss");
		return buyType + dateFormat;
	}
	public static Integer[] parseIntArray(String[] array) {
		Integer[] intArray = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			if (!array[i].equals("")) {
				intArray[i] = Integer.parseInt(array[i]);
			}
		}
		return intArray;
	}*/

	public static boolean isEmpty(String str) {
		return str == null || "".equals(str.trim());
	}

	
	/**
	 * 利用盘口和比分计算是否赢盘，走盘,
	 * 
	 * @param hand
	 *            盘口
	 * @param hScore
	 *            主队进球
	 * @param aScore
	 *            客队进球
	 * @param id
	 *            1代表当前比赛主队是主队,2代表当前比赛主队是客队
	 * @return
	 */
	public static String calcHand(float hand, int hScore, int aScore, int id) {
		int result = -1;
		if (id == 1) {
			if (hand >= 0) {

				if (hScore + Math.abs(hand) > aScore)
					result = 1;
				else if (hScore + Math.abs(hand) == aScore)
					result = 0;
				else
					result = -1;
			} else {
				if (hScore - Math.abs(hand) > aScore)
					result = 1;
				else if (hScore - Math.abs(hand) == aScore)
					result = 0;
				else
					result = -1;
			}
		} else {
			if (hand >= 0) {
				if (aScore - Math.abs(hand) > hScore)
					result = 1;
				else if (aScore - Math.abs(hand) == hScore)
					result = 0;
				else
					result = -1;
			} else {

				if (aScore + Math.abs(hand) > hScore)
					result = 1;
				else if (aScore + Math.abs(hand) == hScore)
					result = 0;
				else
					result = -1;
			}
		}

		return result == 1 ? "赢" : result == 0 ? "走" : "输";
	}

	/**
	 * 计算当前比赛2队交战历史主队的胜平负
	 * 
	 * @param hScore
	 *            主队比分
	 * @param aScore
	 *            客队比分
	 * @param id
	 *            1代表当前比赛主队是主队,2代表当前比赛主队是客队
	 * @return
	 */
	public static String calcResult(int hScore, int aScore, int id) {
		int result = -1;
		if (id == 1) {
			if (hScore > aScore) {
				result = 1;
			} else if (hScore == aScore) {
				result = 0;
			} else {
				result = -1;
			}
		} else {

			if (hScore > aScore) {
				result = -1;
			} else if (hScore == aScore) {
				result = 0;
			} else {
				result = 1;
			}
		}
		return result == 1 ? "胜" : result == 0 ? "平" : "负";
	}

	public static String calcBsResult(String allScore, float bsHan) {
		int result = -1;
		int hScore = Integer.valueOf(allScore.split("\\:")[0]);
		int aScore = Integer.valueOf(allScore.split("\\:")[1]);
		int score = hScore + aScore;
		if (score > bsHan) {
			result = 1;
		} else if (score == bsHan) {
			result = 0;
		} else {
			result = -1;
		}
		return result == 1 ? "大" : result == 0 ? "走" : "小";
	}

	// 计算平均返还率
	// (主胜 * 平 * 客胜 ) / 主胜 * 平 + 主胜 * 客胜 + 平 * 客胜
	public static float calcRate(float win, float eq, float lose) {

		float result = (win * eq * lose) / (win * eq + win * lose + eq * lose);
		return result;
	}

	public static String percentPaser(Double result) {
		NumberFormat format = NumberFormat.getPercentInstance();// 获取格式化类实例
		format.setMinimumFractionDigits(2);// 设置小数位
		return format.format(result);
	}

	// 小数点保留两位方法
	public static double reservedDecimal(float result) {
		DecimalFormat df = new DecimalFormat("######0.00");
		return Double.valueOf(df.format(result));
	}

	public static void main(String[] args) {
		System.out.println(calcRate(2.58f, 3.2f, 2.4f));
	}

	/**
	 * 根据文件路径获取文件中的key，value值
	 * 
	 * @param filePath
	 * @return
	 */
	public static Map<String, Object> getProperties(String filePash) {
		Properties props = new Properties();
		Map<String, Object> propMap = new HashMap<String, Object>();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(filePash));
			props.load(in);
			Enumeration en = props.propertyNames();
			// 遍历文本内容
			while (en.hasMoreElements()) {
				String key = en.nextElement().toString();
				String value = new String(props.getProperty(key).getBytes("ISO-8859-1"), "UTF-8");
				propMap.put(key, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propMap;
	}

	/**
	 * 根据参数判断是否保留两位小数点 如果值大于100则不保留2位小数点，如果值小于100则需要保留两位小数点
	 * 
	 * @param value
	 * @return result;
	 * 
	 */
	public static String isReservedDecimal(float value) {
		String result = "0";
		if (value >= 100) {
			result = String.valueOf(new BigDecimal(value).setScale(0, BigDecimal.ROUND_HALF_UP));
		} else {
			result = String.valueOf(new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP));
		}
		return result;
	}
	/**
	 * 保留两位小数点
	 */
	public static Float reserved2Decimal(float value){
		float result = Float.valueOf(new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		return result;
	}
	/**
	 * 获取当前年份信息
	 */
	public static int getYearInfo() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	/**
	 * 截取年份和秒方法
	 */
	public static String subYearSecond(String date) {
		String value = "";
		String result = "";
		if (null != date && !"".equals(date)) {
			value = date.substring(5, date.length() - 1);
			result = value.substring(0, value.length() - 2);
		}
		return result;
	}
	/**
	 * 截取年份方法
	 */
	public static String subYear(String date) {
		String result = "";
		if (null != date && !"".equals(date)) {
			result = date.substring(5, date.length());
		}
		return result;
	}
	/**
	 * 字符串乱码转化
	 */
	public static String getDecodeStr(String param){
		String result = "";
		try{
			result = new String(param.getBytes("ISO-8859-1"), "UTF-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 时间戳转换为时间方法
	 */
	public static String getTimeByTimeStamp(String timeStamp){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = simpleDateFormat.format(new Date(Long.parseLong(timeStamp)));
		return time;
	}
	public static String getTimeByTimeStamp(String timeStamp, String dateFormat){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		String time = simpleDateFormat.format(new Date(Long.parseLong(timeStamp)));
		return time;
	}
	/**
	 * 获取当前日期的前几天日期
	 */
	public static String getBeforeDate(int dayNum){
		Calendar day = Calendar.getInstance();
		day.setTime(new Date());
		day.add(Calendar.DATE, -dayNum+1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(day.getTime());
		return date;
	}
	/**
	 * 获取当前日期的前几天日期
	 */
	public static String getAppointBeforeDate(String date, int dayNum)throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar day = Calendar.getInstance();
		day.setTime(sdf.parse(date));
		day.add(Calendar.DATE, dayNum);
		String value = sdf.format(day.getTime());
		return value;
	}
	/**
	 * 获取当前日期
	 */
	public static String getNowDate(String format){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String date = simpleDateFormat.format(calendar.getTime());
		return date;
	}
	/**
	 * 比较当前时间大小
	 * 
	 * @param date
	 * @return
	 */
	public static boolean comparNewDate(String date){
		boolean flag = false;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse(date);
			flag = d.before(new Date());
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 对象转化为Integer类型
	 * 
	 * @param object
	 * @return
	 */
	public static Integer objectToInteger(Object object){
    	if (null != object) {
    		return Integer.valueOf(object.toString());
    	} else {
    		return null;
    	}
    }
	/**
	 * 对象转化为Double类型
	 * 
	 * @param object
	 * @return
	 */
	public static double objectToDouble(Object object){
    	if (null != object) {
    		return Double.valueOf(object.toString());
    	} else {
    		return 0;
    	}
    }
	/**
	 * 对象转化为String类型
	 * 
	 * @param object
	 * @return
	 */
	public static String objectToString(Object object){
		if (null != object){
			return object.toString();
		}else{
			return null;
		}
	}
	
	/**
	 * 
	 */
	public static String stringToUTF8(String object) {
		try{
			if(null != object) {
				object = new String(object.getBytes("ISO-8859-1"),"UTF-8");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return object;
	}
}
