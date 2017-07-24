package com.donggua.webpackage;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by HP on 2017/7/19.
 */

@Controller
@RequestMapping(value = "/FootballStars")
public class FootballStarControler {
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getFootballStarsByName(@PathVariable("name") String name){
        System.out.println(name + " is coming!");
        return "messi";
    }
}
