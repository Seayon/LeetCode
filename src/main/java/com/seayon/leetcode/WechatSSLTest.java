package com.seayon.leetcode;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

/**
 * @Version 1.0
 * @author: 赵旭阳
 * @Date: 2018/7/27 9:28
 * @Description
 */
public class WechatSSLTest {
	public static void main(String[] args){
		OkHttpClient okHttpClient = new OkHttpClient();

		Request request = new Request.Builder().url("https://api.weixin.qq.com/cgi-bin/token").build();
		try {
			System.out.println(okHttpClient.newCall(request).execute().body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
