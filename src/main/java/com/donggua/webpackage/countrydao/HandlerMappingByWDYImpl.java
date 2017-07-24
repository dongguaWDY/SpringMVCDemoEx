package com.donggua.webpackage.countrydao;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HP on 2017/7/20.
 */
@Component
public class HandlerMappingByWDYImpl implements HandlerMapping{
    //        Return a handler and any interceptors for this request. The choice may be made
//        on request URL, session state, or any factor the implementing class chooses.
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {


        return null;
    }
}
