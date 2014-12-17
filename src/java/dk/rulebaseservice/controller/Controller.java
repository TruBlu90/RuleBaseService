/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.rulebaseservice.controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marekrigan
 */
public class Controller 
{
    private List<String> bankList;
    private int creditScore;
    
    public Controller()
    {
        bankList = generateBankList();
    }
        
    public Controller(int creditScore)
    {
        this.creditScore = creditScore;
        bankList = generateBankList();
    }
    
    private List<String> generateBankList()
    {
        List<String> generatingBankList = new ArrayList<>();
        
        generatingBankList.add("cphbusiness.bankJSON");
        generatingBankList.add("cphbusiness.bankXML");
        generatingBankList.add("cphbusiness.wsBank");
        generatingBankList.add("cphbusiness.rabbitBank");
        
        return generatingBankList;
    }
    
    public List<String> selectSuitableBanks()
    {
        List<String> selectedBanks = new ArrayList<>();
        
        if (creditScore < 580)
        {
            return null;
        }
        
        if (creditScore >= 720)
        {
            selectedBanks.add(bankList.get(3));
            selectedBanks.add(bankList.get(2));
            selectedBanks.add(bankList.get(1));
            selectedBanks.add(bankList.get(0));
        }
        if (creditScore >= 680 && creditScore <= 719)
        {
            selectedBanks.add(bankList.get(2));
            selectedBanks.add(bankList.get(1));
            selectedBanks.add(bankList.get(0));
        }
        if (creditScore >= 620 && creditScore <= 679)
        {
            selectedBanks.add(bankList.get(1));
            selectedBanks.add(bankList.get(0));
        }
        if (creditScore >= 580 && creditScore <= 619)
        {
            selectedBanks.add(bankList.get(0));
        }
        
        return selectedBanks;
    }
    
}
