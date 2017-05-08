package yks.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yks.bi.utils.MD5Util;
import com.yks.bi.utils.ResponseData;
import com.yks.bi.utils.HttpRequestUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created by Administrator on 2017/5/7.
 */
public class HttpRequestUtilsTest {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @org.junit.Test
    public void sendHttpGet() throws Exception {
        String url = "http://sso.youkeshu.com/?c=of_base_sso_api&a=ticket&name=okr&callback=callback";
        ResponseData responseData = HttpRequestUtils.sendHttpGet(url);
        String responseText = responseData.getResponseText();
        System.out.println(responseText);
        String ticket = "";
        if(StringUtils.isNotEmpty(responseText)){
            String json = responseText.substring(responseText.indexOf("(") + 1 ,responseText.lastIndexOf(")"));
            JsonNode jsonNode = objectMapper.readTree(json);
            if(jsonNode.get("state").asInt() == 200){
                ticket = jsonNode.get("ticket").asText();
            }else{
                System.out.println("请求无法获取token！");
            }
        }
        StringBuffer sb = new StringBuffer("http://sso.youkeshu.com/?c=of_base_sso_api&a=check");
        sb.append("&space=default&name=okr&role=0");
        sb.append("&user=liuxing2");
        sb.append("&pwd=xing1234");
        sb.append("&ticket=" + ticket);
        String md5 = "of_base_sso_apicheckdefaultokr0liuxing2xing1234" + ticket + "123456";
        sb.append("&md5=" + MD5Util.encode(md5).toLowerCase());
        ResponseData responseData1 = HttpRequestUtils.sendHttpGet(sb.toString());
        System.out.println(responseData1.getStatusCode());
        System.out.println(responseData1.getResponseText());


    }

    @Test
    public void sendHttpPost() throws Exception {

    }

}