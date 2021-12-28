package com.spartan.spartanbrain.application.student.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/main")
public class StudentController {

    /**
     * Method that returns a comment based on Tenant Code and Header Summary ID
     *
     * @return Comments Found
     */
    @RequestMapping(method = RequestMethod.GET, value = "/helloworld")
    public String getSalute() {
        log.debug("Using /search/findByHeaderSummaryId URL, GET Request Method with parameters: "
                        + "Header Summary ID: {}, "
                        + "Comment Type: {}");
        return "Hello World";
    }

}
