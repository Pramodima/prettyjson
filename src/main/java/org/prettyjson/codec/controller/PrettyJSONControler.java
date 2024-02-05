package org.prettyjson.codec.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class PrettyJSONControler {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PrettyJSONControler.class);
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String getPrettyJson(/* String encodedString*/ HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return "beautifyjson";
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/getBeautifyJson")
    public String getMinifyJson( String minifyJson, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String indented="";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Object json = objectMapper.readValue(minifyJson, Object.class);
             indented = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        } catch (JsonProcessingException e) {
            indented=e.getMessage();
        }
        return indented;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/minify")
    public String encode( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return "minifyjson";
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/health")
    public String checkHealth( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return "OK";
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/getMinifyJson")
    public String getEncodedString( String beautifiedString, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String minifyStr="";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
          JsonNode  jsonNode = objectMapper.readValue(beautifiedString, JsonNode.class);
            minifyStr=jsonNode.toString();
        } catch (JsonProcessingException e) {
        minifyStr=e.getMessage();
        }

        return minifyStr;
    }
}
