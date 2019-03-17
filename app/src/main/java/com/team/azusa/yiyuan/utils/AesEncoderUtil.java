package com.team.azusa.yiyuan.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AesEncoderUtil {
	public static final String CHAR_ENCODING = "UTF-8";
	public static final String AES_ALGORITHM = "AES";

	/**
	 * 加密
	 */
	public static String AESEncode(String key, String data) {
		if (key.length() < 16) {
			throw new RuntimeException("Invalid AES key length (must be 16 bytes)");
		} else if (key.length() > 16) {
			key = key.substring(0, 16);
		}
		try {
			Cipher cipher = Cipher.getInstance(AES_ALGORITHM);// 创建密码�?
			byte[] byteContent = data.getBytes(CHAR_ENCODING);
			cipher.init(Cipher.ENCRYPT_MODE, genKey(key));// 初始�?
			byte[] result = cipher.doFinal(byteContent);
			return parseByte2HexStr(result); // 加密
		} catch (Exception e) {
			e.getMessage();
		}
		return null;

	}

	/**
	 * 解密
	 * @return
	 */
	public static String AESDncode(String key, String data) {
		if (key.length() < 16) {
			throw new RuntimeException("Invalid AES key length (must be 16 bytes)");
		} else if (key.length() > 16) {
			key = key.substring(0, 16);
		}
		try {
			byte[] decryptFrom = parseHexStr2Byte(data);
			Cipher cipher = Cipher.getInstance(AES_ALGORITHM);// 创建密码�?
			cipher.init(Cipher.DECRYPT_MODE, genKey(key));// 初始�?
			byte[] result = cipher.doFinal(decryptFrom);
			return new String(result, "utf-8"); // 加密
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 创建加密解密密钥
	 * 
	 * @param key
	 *            加密解密密钥
	 * @return
	 */
	private static SecretKeySpec genKey(String key) {
		SecretKeySpec secretKey;
		try {
			secretKey = new SecretKeySpec(key.getBytes(CHAR_ENCODING), AES_ALGORITHM);
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec seckey = new SecretKeySpec(enCodeFormat, AES_ALGORITHM);
			return seckey;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("genKey fail!", e);
		}
	}

	/**
	 * 将二进制转换�?16进制
	 * 
	 * @param buf
	 * @return
	 */
	private static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * �?16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	private static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
	
	public static String getEncodeRule(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }

}
