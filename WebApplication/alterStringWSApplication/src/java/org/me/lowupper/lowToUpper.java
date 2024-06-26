/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/EjbWebService.java to edit this template
 */
package org.me.lowupper;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author matheus.nazaro_unesp
 */
@WebService(serviceName = "lowToUpper")
@Stateless()
public class lowToUpper {
    /**
     * Web service operation
     */
    @WebMethod(operationName = "lowToUpper")
    public String lowToUpper(@WebParam(name = "lowString") String lowString) {
        //TODO write your implementation code here:
        return lowString.toUpperCase();
    }
}
