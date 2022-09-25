package com.transaction.management.Service.impl;

import com.transaction.management.Repository.InformationRepository;
import com.transaction.management.Repository.LogRepository;
import com.transaction.management.Service.TransactionManagementService;
import com.transaction.management.entity.InformationEntity;
import com.transaction.management.entity.LogEntity;
import com.transaction.management.exception.TransactionManagementException;
import com.transaction.management.util.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TransactionManagementServiceImpl implements TransactionManagementService {
    @Autowired
    InformationRepository informationRepository;

    @Autowired
    LogRepository logRepository;

    @Autowired
    DatabaseUtil databaseUtil;
   /* @Override
    public String createInformation(String input){
        try{
            createInformationTemp(input);
        }catch(Exception ex){
            Logging(ex);
        }
        return "success";
    }*/

    /**
     *
     * @param input
     * @return
     * @throws TransactionManagementException
     * This method is for transaction session management , creating new session and adding
     * into db even when a exception happens.
     */
    @Transactional(rollbackFor = TransactionManagementException.class)
    public String createInformation(String input) throws TransactionManagementException {
        try{
            if(input.equalsIgnoreCase("1")) {
                InformationEntity informationEntity = new InformationEntity();
                informationEntity.setInformation("GOOD");
                informationEntity.setName("PERSON1");
                informationRepository.save(informationEntity);
            }else{
                InformationEntity informationEntity = new InformationEntity();
                informationEntity.setInformation("GOOD");
                informationEntity.setName("PERSON1");
                informationRepository.save(informationEntity);
                throw new TransactionManagementException();
            }
        }catch(Exception ex){
           databaseUtil.saveLog(ex);
            throw new TransactionManagementException();
        }
        finally {

        }

        return "success";
    }


    private void Logging(Exception ex){
        {
            LogEntity entity = new LogEntity();
            entity.setErrorMessage(ex.getStackTrace().toString());
            entity.setCreatedDate(new Date());
            logRepository.save(entity);
        }
    }
}
