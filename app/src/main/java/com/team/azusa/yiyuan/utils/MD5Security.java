package com.team.azusa.yiyuan.utils;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Security {

	public static final String HEXSTRING = "0123456789abcdef";

	/**
	 * MD5加密函数
	 * 
	 * @param originalText
	 *            �?加密的数�?
	 * @return
	 */
	public static String md5(String originalText) {
		String result = "";
		String digit = "";
		try {
			byte buf[] = originalText.getBytes("ISO-8859-1");
			StringBuffer hexString = new StringBuffer();
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(buf);
			byte[] digest = algorithm.digest();
			for (int i = 0; i < digest.length; i++) {
				digit = Integer.toHexString(0xFF & digest[i]);
				if (digit.length() == 1) {
					digit = "0" + digit;
				}
				hexString.append(digit);
			}
			result = hexString.toString();
		} catch (Exception ex) {
			result = "";
		}
		return result.toUpperCase();
	}

	public static String hexchar2bin(String md5str) throws UnsupportedEncodingException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(md5str.length() / 2);
		for (int i = 0; i < md5str.length(); i = i + 2) {
			baos.write((HEXSTRING.indexOf(md5str.charAt(i)) << 4 | HEXSTRING.indexOf(md5str.charAt(i + 1))));
		}
		return new String(baos.toByteArray(), "ISO-8859-1");
	}

	/**
	 * 计算md5摘要
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String md5Digest(String data, String channelNo, String timestamp, String key) throws NoSuchAlgorithmException {
		MessageDigest md5Digest = MessageDigest.getInstance("MD5");
		StringBuilder sb = new StringBuilder();
		sb.append(channelNo);
		sb.append(timestamp);
		sb.append(data);
		sb.append(key);
		md5Digest.update(sb.toString().getBytes());
		// 完成哈希计算，得到摘�?
		byte[] md5Encoded = md5Digest.digest();
		// 采用base64编码
		return Base64.encodeBase64URLSafeString(md5Encoded);
	}

	/**
	 * 计算hash摘要
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String shaDigest(String data) throws NoSuchAlgorithmException {
		MessageDigest shaDigest = MessageDigest.getInstance("SHA");
		// 更新要计算的内容
		shaDigest.update(data.getBytes());
		// 完成哈希计算，得到摘�?
		byte[] shaEncoded = shaDigest.digest();
		// 采用base64进行编码
		return Base64.encodeBase64URLSafeString(shaEncoded);
	}

	/**
	/**
	 * 普�?�MD5
	 */
	public static String md5Encoder(String content) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.getStackTrace();
		}
		char[] charArray = content.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}

		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	/**
	 * 加盐MD5
	 * 
	 * @param content 加密内容
	 * @return
	 */
	public static String generate(String content) {
		StringBuilder sb = new StringBuilder(16);
		// 制�?�盐�?
		sb.append(md5Encoder(md5Encoder(content)));
		String salt = sb.toString();
		content = md5Hex(content + salt);
		char[] cs = new char[48];
		for (int i = 0; i < 48; i += 3) {
			cs[i] = content.charAt(i / 3 * 2);
			char c = salt.charAt(i / 3);
			cs[i + 1] = c;
			cs[i + 2] = content.charAt(i / 3 * 2 + 1);
		}
		return new String(cs);
	}

	/**
	 * 获取十六进制字符串形式的MD5摘要
	 */
	private static String md5Hex(String sc) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bs = md5.digest(sc.getBytes());
			return new String(new Hex().encode(bs));
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(generate("abc"));
	}
	
	
	

}
