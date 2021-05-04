package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.service;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {
    private ConsoleDao consoleDao;
    private GameDao gameDao;
    private TshirtDao tshirtDao;
    private InvoiceDao invoiceDao;
    private ProcessingFeeDao processingFeeDao;
    private TaxDao taxDao;

    @Autowired
    public ServiceLayer(ConsoleDao consoleDao, GameDao gameDao, TshirtDao tshirtDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao, TaxDao taxDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.tshirtDao = tshirtDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.taxDao = taxDao;
    }

    //The complicated stuff

}
