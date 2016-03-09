package com.example.ddddd.utils;

public class Utils {
	
	public static final int VIP = 2;
	/**
	 * 总金额
	 */
	public static final int amount = 38;
	
	private final static String baseUrl = "http://api.76iw.com/";
	private final static String imgBaseUrl = "http://v.masmag.com.cn/dsfgfhsfsas/";
	public final static String URL_GET_ORDER = baseUrl + "order/createOrder/";
	
	private static String imgs[] = {
			"img/v004.jpg", "img/v005.jpg", "img/v006.jpg", 
			"img/v007.jpg", "img/v008.jpg", "img/v009.jpg", 
			"img/v010.jpg", "img/v011.jpg", "img/v012.jpg", 
			"img/v013.jpg", "img/v014.jpg", "img/v015.jpg", 
	};
	
	
	private static String videoTopUrl[] = {
		"mp4/f002.mp4", "mp4/f004.mp4", "mp4/f005.mp4", 
		"mp4/016.mp4", "mp4/017.mp4"
	};
	public static String getTopUrl(int position){
		return imgBaseUrl + videoTopUrl[position];
	}
	
	private static String videoMvUrl[] = {
		"mp4/001.mp4", "mp4/002.mp4", "mp4/003.mp4", 
		"mp4/004.mp4", "mp4/005.mp4", "mp4/006.mp4", 
		"mp4/007.mp4", "mp4/008.mp4", "mp4/009.mp4", 
		"mp4/010.mp4", "mp4/011.mp4", "mp4/012.mp4", 
		"mp4/013.mp4", "mp4/014.mp4", "mp4/015.mp4", 
	};
	public static String getMvUrl(int position){
		return imgBaseUrl + videoMvUrl[position];
	}
	
	public static final String tv_shibo1 = imgBaseUrl + "mp4/f001.mp4";
	public static final String tv_shibo2 = imgBaseUrl + "mp4/f003.mp4";
	
	/**
	 * 获取图片资源路径
	 * @param i
	 * @return
	 */
	public static String getImgPath(int i){
		return imgBaseUrl + imgs[i];
	}
}
