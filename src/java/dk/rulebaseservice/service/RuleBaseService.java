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
     */
    @WebMethod(operationName = "chooseAppropriateBanks")
    public List<String> chooseAppropriateBanks(@WebParam(name = "ssn") String ssn, @WebParam(name = "loanAmount") double loanAmount, @WebParam(name = "loanDuration") int loanDuration, @WebParam(name = "creditScore") int creditScore)
    {
        Controller controller = new Controller(ssn, loanAmount, loanDuration, creditScore);
        return controller.selectSuitableBanks();
    }
}
