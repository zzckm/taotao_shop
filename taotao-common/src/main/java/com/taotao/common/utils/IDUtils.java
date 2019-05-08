package com.taotao.common.utils;

import java.util.Random;

public class IDUtils {
	public static String genImageName() {
       //取当前时间的长整型包含秒
       long millis = System.currentTimeMillis();
       //取三位随机数
       Random random = new Random();
       int end3 = random.nextInt(999);
       //如果不足三位前面补0
       String str=millis+String.format("%03d", end3);
       return str;
	}
	public static  Long getItemId() {
		long millis = System.currentTimeMillis();
		Random random = new Random();
	       int end3 = random.nextInt(99);
	       String str=millis+String.format("%02d", end3);
	       Long id=new Long(str);
	       return id;
	}
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(getItemId());
		}
	}
}
