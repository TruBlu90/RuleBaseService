/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.rulebaseservice.service;

import dk.rulebaseservice.controller.Controller;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Jon
 */
@WebService(serviceName = "RuleBaseService")
public class RuleBaseService
{

    /**
     * Web service operation
     * @param creditScore
     * @return 
     */
    @WebMethod(operationName = "getAppropriateBanks")
    public List<String> getAppropriateBanks(@WebParam(name = "creditScore") int creditScore) 
    {
        Controller controller = new Controller(creditScore);
        return controller.selectSuitableBanks();
    }

}
