package com.transaction.management.Service;

import com.transaction.management.exception.TransactionManagementException;
import org.springframework.stereotype.Service;

public interface TransactionManagementService {

    public String createInformation(String input) throws Exception;
}
