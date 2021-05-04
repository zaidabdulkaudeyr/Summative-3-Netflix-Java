package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.dao;

import com.company.ZaidAbdulKaudeyrChloeTaylorCapstone.model.ProcessingFee;

public interface ProcessingFeeDao
{
    ProcessingFee getProcessingFeeByType(String type);
}
