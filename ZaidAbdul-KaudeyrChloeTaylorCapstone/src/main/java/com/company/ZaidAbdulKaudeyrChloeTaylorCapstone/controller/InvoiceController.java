package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.controller;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.Invoice;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.service.ServiceLayer;
import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    @Autowired
    ServiceLayer service;

    @PostMapping(value = "/invoice")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        return service.addInvoice(invoice);
    }
}
