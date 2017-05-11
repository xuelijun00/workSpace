package com.yks.bi.service.system;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yks.bi.common.HttpRequestUtils;
import com.yks.bi.common.MD5Util;
import com.yks.bi.common.ResponseData;
import com.yks.bi.dto.system.SystemUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by liuxing on 2017/5/5.
 */
@Service("systemUserService")
public class SystemUserService {

    private static Logger log = Logger.getLogger(SystemUserService.class);
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 用户登入
     *
     * @param username
     * @param password
     * @return
     * @throws IOException
     */
    public SystemUser login(String username, String password) throws IOException {
        SystemUser user = null;
        String url = "http://sso.youkeshu.com/?c=of_base_sso_api&a=ticket&name=okr&callback=callback";
        ResponseData responseData = HttpRequestUtils.sendHttpGet(url);
        String responseText = responseData.getResponseText();
        String ticket = "";
        if (StringUtils.isNotEmpty(responseText)) {
            String json = responseText.substring(responseText.indexOf("(") + 1, responseText.lastIndexOf(")"));
            JsonNode jsonNode = objectMapper.readTree(json);
            if (jsonNode.get("state").asInt() == 200) {
                ticket = jsonNode.get("ticket").asText();
            } else {
                log.info("请求无法获取token！");
                return user;
            }
        }
        StringBuffer sb = new StringBuffer("http://sso.youkeshu.com/?c=of_base_sso_api&a=check");
        sb.append("&space=default&name=okr&role=0");
        sb.append("&user=" + username);
        sb.append("&pwd=" + password);
        sb.append("&ticket=" + ticket);
        String md5 = "of_base_sso_apicheckdefaultokr0" + username + password + ticket + "123456";
        sb.append("&md5=" + MD5Util.encode(md5).toLowerCase());
        ResponseData responseData1 = HttpRequestUtils.sendHttpGet(sb.toString());
        JsonNode jsonNode = objectMapper.readTree(responseData1.getResponseText());
        if (jsonNode.get("state").asInt() == 200) {
            user = new SystemUser();
            user.setId(jsonNode.get("user").asInt());
            user.setUsername(jsonNode.get("nike").asText());
            log.info("登入成功：" + jsonNode.get("nike").asText());
        }else{
            log.info("登入失败：" + jsonNode.get("msg").asText());
        }
        return user;
    }

}
