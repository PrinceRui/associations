
package com.rui.framework.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    public static final int READ_TIMEOUT = 3 * 1000;// milliseconds

    public static JSONObject sendGet(String url, Map<String, String> param) {
        return sendGet(url, param, -1);
    }

    public static JSONObject sendPost(String url, Map<String, String> param) {
        return sendPost(url, param, -1);
    }


    public static JSONObject sendGet(String url, Map<String, String> param, int timeoutSeconds) {
        String queryStr = queryStr(url, param);
        int timeout = timeoutSeconds <= 0 ? READ_TIMEOUT : timeoutSeconds * 1000;
        try {
            Connection
                    .Response response = Jsoup.connect(queryStr)
                    .timeout(timeout)
                    .ignoreContentType(true)
                    .method(Connection.Method.GET)
                    .execute();
            logger.info("sendQuery url={}", queryStr);
            String responseStr = new String(response.bodyAsBytes());
            logger.info("sendQuery response: status={}", response.statusCode());
            logger.info("sendQuery response: body={}", responseStr);
            return JSON.parseObject(responseStr);
        } catch (IOException e) {
            logger.error("sendQuery error. url={}", queryStr, e);
        }
        return null;
    }

    public static JSONObject sendPost(String url, Map<String, String> param, int timeoutSeconds) {
        String queryStr = url;
        int timeout = timeoutSeconds <= 0 ? READ_TIMEOUT : timeoutSeconds * 1000;
        try {
            Connection.Response response = Jsoup.connect(url)
                    .timeout(timeout)
                    .ignoreContentType(true)
                    .method(Connection.Method.POST)
                    .data(param)
                    .execute();
            logger.info("sendQueryPost url={}", queryStr);
            String responseStr = new String(response.bodyAsBytes());
            logger.info("sendQuery response: status={}", response.statusCode());
            logger.info("sendQuery response: body={}", responseStr);
            return JSON.parseObject(responseStr);
        } catch (IOException e) {
            logger.error("sendQueryPost error. url={}", queryStr, e);
        }
        return null;
    }

    public static String queryStr(String url, Map<String, String> param) {
        return (param != null && param.size() > 0) ? (url + "?" + paramStr(param)) : url;
    }

    public static String paramStr(Map<String, String> param) {
        StringBuffer paramStrSb = new StringBuffer();
        if (param != null && param.size() > 0) {
            // 处理请求参数,对参数按照 key1=value1&key2=value2 的格式，并按照参数名ASCII字典序排序
            SortedMap<String, String> paramsSortedMap = new TreeMap<>(param);
            paramsSortedMap.forEach((k, v) -> {
                if (paramStrSb.length() == 0) {
                    paramStrSb.append(k + "=" + v);
                } else {
                    paramStrSb.append("&" + k + "=" + v);
                }
            });
        }
        return paramStrSb.toString();
    }

}