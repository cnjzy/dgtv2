package com.example.ddddd.utils;

public class Utils {
	
	public static final int VIP = 2;
	/**
	 * 总金额
	 */
	public static final int amount = 38;
//	public static final int amount = 1;
	
	private final static String baseUrl = "http://api.76iw.com/";
	private final static String imgBaseUrl = "http://v.masmag.com.cn/dsfgfhsfsas/";
	public final static String URL_GET_ORDER = baseUrl + "order/createOrder/";
	
	private static String imgs[] = {
		imgBaseUrl + "img/v004.jpg", imgBaseUrl + "img/v005.jpg", imgBaseUrl + "img/v006.jpg", 
		imgBaseUrl + "img/v007.jpg", imgBaseUrl + "img/v008.jpg", imgBaseUrl + "img/v009.jpg", 
		imgBaseUrl + "img/v010.jpg", imgBaseUrl + "img/v011.jpg", imgBaseUrl + "img/v012.jpg", 
		imgBaseUrl + "img/v013.jpg", imgBaseUrl + "img/v014.jpg", imgBaseUrl + "img/v015.jpg", 
	};
	
	
	private static String videoTopUrl[] = {
		"http://file.oneweone.cn/xdy0009.mp4", 
		"http://file.oneweone.cn/xdy0010.mp4", 
		"http://file.oneweone.cn/xdy0006.mp4", 
		"http://file.oneweone.cn/xdy0007.mp4"
	};
	public static String getTopUrl(int position){
		return videoTopUrl[position % videoTopUrl.length];
	}
	
	private static String videoMvUrl[] = {
		"http://file.oneweone.cn/xdy0009.mp4", 
		"http://file.oneweone.cn/xdy0010.mp4", 
		"http://file.oneweone.cn/xdy0006.mp4", 
		"http://file.oneweone.cn/xdy0007.mp4",
	};
	public static String getMvUrl(int position){
		return videoMvUrl[position % videoMvUrl.length];
	}
	
	public static final String tv_shibo1 = "http://imgtu.chnhtp.com:8081/SB/1.mp4";
	public static final String tv_shibo2 = "http://imgtu.chnhtp.com:8081/SB/2.mp4";
	
	/**
	 * 获取图片资源路径
	 * @param i
	 * @return
	 */
	public static String getImgPath(int i){
		return imgs[i];
	}
}
