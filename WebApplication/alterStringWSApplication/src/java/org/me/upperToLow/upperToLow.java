/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package org.me.upperToLow;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author matheus.nazaro_unesp
 */
@WebService(serviceName = "upperToLow")
public class upperToLow {
    /**
     * Web service operation
     */
    @WebMethod(operationName = "upperToLow")
    public String upperToLow(@WebParam(name = "upperString") String upperString) {
        //TODO write your implementation code here:
        return upperString.toLowerCase();
    }
}
