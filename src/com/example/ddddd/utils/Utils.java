package com.example.ddddd.utils;

public class Utils {
	
	public static final int VIP = 2;
	/**
	 * 总金额
	 */
//	public static final int amount = 38;
	public static final int amount = 1;
	
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
		"http://150wz.com/vipvideo/xdy0007.mp4?key=a2f2fcec71f5f444331722c0bcac8835&time=570355e1", 
		"http://150wz.com/vipvideo/xdy0006.mp4?key=a73a4077f88457b84ca20bc89f70634e&time=570355d3", 
		"http://video.150wz.com:10086/pb/pb0010.MP4", 
		"http://150wz.com/vipvideo/xdy0008.mp4?key=d880fc94dc5f99f84b34fb8d171ea60b&time=570353fe", 
		"http://150wz.com/vipvideo/xdy0008.mp4?key=d880fc94dc5f99f84b34fb8d171ea60b&time=570353fe"
	};
	public static String getTopUrl(int position){
		return videoTopUrl[position];
	}
	
	private static String videoMvUrl[] = {
		"http://150wz.com/vipvideo/xdy0008.mp4?key=d880fc94dc5f99f84b34fb8d171ea60b&time=570353fe",
		"http://150wz.com/vipvideo/xdy0008.mp4?key=d880fc94dc5f99f84b34fb8d171ea60b&time=570353fe",
		"http://150wz.com/vipvideo/xdy0007.mp4?key=a2f2fcec71f5f444331722c0bcac8835&time=570355e1",
		"http://150wz.com/vipvideo/xdy0006.mp4?key=a73a4077f88457b84ca20bc89f70634e&time=570355d3",
		"http://video.150wz.com:10086/pb/pb0010.MP4",
		"http://video.150wz.com:10086/pb/pb0019.MP4",
		"http://150wz.com/uvideo/hg0015.MP4",
		"http://150wz.com/uvideo/hg0030.MP4",
		"http://appcdn.syingkj.com/video/mntk1/20140904mn10.mp4"
	};
	public static String getMvUrl(int position){
		return videoMvUrl[position % videoMvUrl.length];
	}
	
	public static final String tv_shibo1 = imgBaseUrl + "mp4/f001.mp4";
	public static final String tv_shibo2 = imgBaseUrl + "mp4/f003.mp4";
	
	/**
	 * 获取图片资源路径
	 * @param i
	 * @return
	 */
	public static String getImgPath(int i){
		return imgs[i];
	}
}
