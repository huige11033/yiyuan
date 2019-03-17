package com.team.azusa.yiyuan.utils;


import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class SignUtil {


	public static HashMap<String, String> doSign(String secretKey, Map<String, String> param) {
		// 请求的时间
		String timestamp = System.currentTimeMillis() + "";

		// 获取加密key�?,时间戳加
		String key = AesEncoderUtil.getEncodeRule(timestamp);

		// 对参数进行AES加密
		String content = AesEncoderUtil.AESEncode(key, JSON.toJSONString(param));// 对数据集合进行AES加密

		// 生成签名
		StringBuffer sb = new StringBuffer();
		sb.append(secretKey).append(content).append(timestamp);// 密钥+加密内容+时间�?
		String sign = MD5Security.generate(sb.toString());

		// 6、请求参数封
		HashMap<String, String> postParameters = new HashMap<String, String>();
		postParameters.put("content", content);
		postParameters.put("timestamp", timestamp);// 调用接口时生成时�?
		postParameters.put("sign", sign);// 签名
		return postParameters;
	}
}
