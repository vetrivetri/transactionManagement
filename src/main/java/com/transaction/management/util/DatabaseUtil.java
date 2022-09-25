package com.transaction.management.util;

import com.transaction.management.Repository.LogRepository;
import com.transaction.management.entity.LogEntity;
import com.transaction.management.exception.TransactionManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class DatabaseUtil {
    @Autowired
    LogRepository logRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog(Exception ex){
        LogEntity entity = new LogEntity();
        entity.setErrorMessage(ex.getStackTrace().toString());
        entity.setCreatedDate(new Date());
        logRepository.save(entity);
    }
}
