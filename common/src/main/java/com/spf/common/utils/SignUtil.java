package com.spf.common.utils;

import cn.hutool.crypto.digest.DigestUtil;
import com.spf.common.exception.TimeStampException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;
import java.util.*;

/**
 * <p>Description: 接口签名工具类 提供生成签名、验证签名功能
 * <p>User: mtwu
 * <p>Date: 2017-5-10
 * <p>Version: 1.0
 */
@Service
public class SignUtil {

  // 字符编码格式 目前支持 gbk 或 utf-8
  public static String              input_charset = "utf-8";
  // 签名方式 不需修改
  public static String              sign_type     = "MD5";
  public static long                timeout       = 60000;
  public static final String secret = "go2CN|20170605wearethebest";

  /**
   * 签名字符串
   * @param sArray 需要签名的参数
   * @param input_charset 编码格式
   * @return 签名结果
   */
  public String sign(Map<String, Object> sArray,String input_charset) throws Exception {
    sArray = paraFilter(sArray);
    String text = createLinkString(sArray);
    text = text + secret;
    return DigestUtil.md5Hex(getContentBytes(text, input_charset));
  }



  /**
   * 签名字符串
   * @param sArray 需要签名的参数
   * @param sign 签名结果
   * @param input_charset 编码格式
   * @return 签名结果
   */
  public static boolean verify(Map<String, Object> sArray, String sign,String input_charset) throws Exception {
    sArray = paraFilter(sArray);
    String t = sArray.get("timestamp").toString();
    verifyTimeStamp(t);
    String text = createLinkString(sArray);
    text = text + secret;
    String mysign = DigestUtil.md5Hex(getContentBytes(text, input_charset));
    if (mysign.equals(sign)) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean verifyTimeStamp(String timeStamp) throws Exception {

    if (timeStamp == null) {
      throw new TimeStampException("timestamp参数不能为空");
    } else {
      long t = Long.parseLong(timeStamp);
      long c = System.currentTimeMillis();
      long diff = c - t;
      if (diff > timeout) {
        throw new TimeStampException("请求时间超时");
      }
    }
    return true;
  }

  /**
   * @param content
   * @param charset
   * @return
   * @throws SignatureException
   * @throws UnsupportedEncodingException
   */
  private static byte[] getContentBytes(String content, String charset) throws Exception {
    if (charset == null || "".equals(charset)) {
      return content.getBytes();
    }
    try {
      return content.getBytes(charset);
    } catch (UnsupportedEncodingException e) {
      throw new UnsupportedEncodingException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
    }
  }

  /**
   * 除去数组中的空值和签名参数
   * @param sArray 签名参数组
   * @return 去掉空值与签名参数后的新签名参数组
   */
  public static Map<String, Object> paraFilter(Map<String, Object> sArray) {

    Map<String, Object> result = new HashMap<String, Object>();

    if (sArray == null || sArray.size() <= 0) {
      return result;
    }

    for (String key : sArray.keySet()) {
      String value = sArray.get(key).toString();
      if (value == null || value.equals("") || key.equalsIgnoreCase("sign") || key.equalsIgnoreCase("sign_type") || key.equalsIgnoreCase("key")) {
        continue;
      }
      result.put(key, value);
    }

    return result;
  }

  /**
   * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
   * @param params 需要排序并参与字符拼接的参数组
   * @return 拼接后字符串
   */
  public static String createLinkString(Map<String, Object> params) {

    List<String> keys = new ArrayList<String>(params.keySet());
    Collections.sort(keys);

    String prestr = "";

    for (int i = 0; i < keys.size(); i++) {
      String key = keys.get(i);
      String value = params.get(key).toString();

      if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
        prestr = prestr + key + "=" + value;
      } else {
        prestr = prestr + key + "=" + value + "&";
      }
    }

    return prestr;
  }

}
