package org.prettyjson.codec.controller;

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
        return "prettyjson";
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/minifyJson")
    public String getMinifyJson( String encodedString, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String decodedValue ="";
        try {
            decodedValue = new String(Base64.decodeBase64(encodedString));

        }
        catch(Exception e){
        LOGGER.error("error "+e.getMessage());
            decodedValue="invalid input";
        }
        return decodedValue;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/minify")
    public String encode( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return "encode";
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/health")
    public String checkHealth( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return "OK";
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/getMinifyJson")
    public String getEncodedString( String decodedString, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String encodedValue ="";
        try {
            encodedValue = new String(Base64.encodeBase64(decodedString.getBytes()));

        }
        catch(Exception e){
            LOGGER.error("error "+e.getMessage());
            encodedValue="invalid input";
        }
        return encodedValue;
    }
}
