package springboot_project.test.service;

import org.springframework.beans.factory.annotation.Value;

public class RestApi {
    @Value("${host}")
    private String host


    private HttpServletRequest processRequest(HttpServletRequest request) {


        return new HttpServletRequest();
    }
}
