package com.donggua.webpackage;


import com.donggua.webpackage.countrydao.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.*;

/**
 * Created by HP on 2017/7/6.
 */

@Controller
public class HelloWorld {
//
//    @ResponseBody
//    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
//    public String hello(){
//        System.out.println("hello world12");
//        return "success";
//    }

    @Autowired
    CountryDao countryDao;

//    RememberMeAuthenticationFilter
//SessionManagementFilter
//    UsernamePasswordAuthenticationFilter

//    FilterSecurityInterceptor

//    HttpSession
//ThreadLocal
//DispatcherServlet
//    RequestMappingHandlerMapping
//BeanNameUrlHandlerMapping
    @ResponseBody
    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET)
    public Country getCountryByID(@PathVariable("id") int id){
        System.out.println(id);
        Country country = countryDao.selectCountryByID(id);
        Controller2.testAround();
        System.out.println(country.getCountry_id());
        System.out.println(country.getCountry());
        return country;
    }

//    @ResponseBody
//    @RequestMapping(value = "/country/{countryName}", method = RequestMethod.GET)
//    public String getCountryByCountryName(@PathVariable("countryName") String countryName){
//        return countryName;
//    }


    public boolean find132pattern(int[] nums){
        boolean result = false;
        int max = Integer.MIN_VALUE;
        int indexOfMax = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num > max){
                max = num;
                indexOfMax = i;
            }
        }
        int leftMin = Integer.MAX_VALUE;
        for(int i = 0; i < indexOfMax; i++){
            if(nums[i] < leftMin){
                leftMin = nums[i];
            }
        }

        int rightMax = Integer.MIN_VALUE;
        for(int i = indexOfMax + 1; i < nums.length; i++){
            if(nums[i] > rightMax){
                rightMax = nums[i];
            }
        }


        return leftMin < max && max > rightMax && leftMin < rightMax;
    }

    @ResponseBody
    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public Person hello(){
        System.out.println("hello world12");
        return new Person(623, "WDY", true);
    }

//    @ResponseBody
//    @RequestMapping(value = "/add/country/{countryName}",method = RequestMethod.GET)
//    public TempClass addCountry(@PathVariable("countryName") final String countryName){
//        Country country = new Country();
//        country.setCountry(countryName);
//        countryDao.insertCountry(country);
//        System.out.println("insert successfully");
//
//        TempClass obj = new TempClass();
//        obj.setResult("insert country:" + countryName + " successfully!");
//        return obj;
//    }


    @RequestMapping("/")
    public String getHomePage(ModelMap model){
        System.out.println("visit home");
        model.addAttribute("message", "千里之堤毁于蚁穴");
        return "home";
    }

    @ResponseBody
    @RequestMapping(value = {"/body/{x}", "/WDY/{x}"}, method = RequestMethod.GET)
    public List<Country> getBody(@PathVariable("x") String x) {
        System.out.println("URI Part 1 : " + x);
        BodyTest bt = new BodyTest(x, "1234");
        //bt.a = x;
        //bt.b = "123";
        List<Country> list = countryDao.selectAllCountriesAndReturnHashMap();
        return list;//序列化方式：fast json? google proto buffer? thrift?
    }


    @RequestMapping(value = "/person/profile/{id}/{name}/{status}", method = RequestMethod.GET)
    @ResponseBody
    public Person porfile(@PathVariable int id, @PathVariable String name, @PathVariable boolean status) {
        return new Person(id, name, status);
    }


    public class TempClass{
        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
//RequestMappingInfo
        private String result;
    }


    public class Person implements Serializable {

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        private boolean status;

        public Person() {
            // do nothing
        }

        public Person(int id, String name, boolean status){
            this.id = id;
            this.name = name;
            this.status = status;
        }
    }


    //这应该是个JavaBean
    public class  BodyTest implements Serializable {
        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        private String a;

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        private String b;
        public BodyTest(){

        }
        public BodyTest(String a,String b){
            this.a = a;
            this.b = b;
        }
    }

    /*
    *
    @RequestMapping(value = "/user/{userId}/roles/{roleId}", method = RequestMethod.GET)
    public String getLogin(@PathVariable("userId") String userId,
                           @PathVariable("roleId") String roleId) {

        System.out.println("User Id : " + userId);
        System.out.println("Role Id : " + roleId);
        return "success";
    }
    @RequestMapping(value="/product/{productId}",method = RequestMethod.GET)
    public String getProduct(@PathVariable("productId") String productId){
        System.out.println("Product Id : " + productId);
        return "success";
    }
}
    * */
}
