package com.mole123ader.erzhan20156.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;

import android.os.Handler;
import android.os.Message;

public class NetUtils {

	public interface OnNetWorkCallback{
		public void onNetWorkCallback(String result);
	}
	
	public static void getPost(final String url, final Map<String, String> params, final Handler handler){
		new Thread(){
			public void run() {
				Message msg = handler.obtainMessage();
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost request = new HttpPost(url);
				String ret = null;
				try{
					request.addHeader("Accept-Encoding", "default");
					
					Iterator<String> it = params.keySet().iterator();
					if(params != null && params.size() > 0){
						List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
						while(it.hasNext()){
							String key = it.next();
							String value = params.get(key);
							list.add(new BasicNameValuePair(key, value));
							System.err.println(key + ":" + value);
						}
						((HttpPost) request).setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
					}
					
					httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
		            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);
		            HttpResponse response = httpClient.execute(request);
                    int statusCode = response.getStatusLine().getStatusCode();
                    if (statusCode == HttpStatus.SC_OK) {
                    	InputStream is = response.getEntity().getContent();
                    	InputStreamReader reader = new InputStreamReader(is, "utf-8");
                        char[] data = new char[100];
                        int readSize;
                        StringBuffer sb = new StringBuffer();
                        while ((readSize = reader.read(data)) > 0) {
                            sb.append(data, 0, readSize);
                        }
                        ret = sb.toString();
                        reader.close();
                    }
                    msg.what = 1;
					msg.obj = ret;
				}catch(Exception e){
					e.printStackTrace();
					ret = "请求失败";
					msg.what = 0;
					msg.obj = ret;
				}finally{
					System.err.println("ret=" + ret);
					handler.sendMessage(msg);
				}
			};
		}.start();
	}
}
