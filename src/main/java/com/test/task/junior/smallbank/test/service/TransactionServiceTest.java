package com.test.task.junior.smallbank.test.service;

import com.test.task.junior.smallbank.services.TransactionService;
import com.test.task.junior.smallbank.test.config.TestDataBaseConfig;
import com.test.task.junior.smallbank.test.util.TransactionUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration

public class TransactionServiceTest {
    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private TransactionService transactionService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testSaveTransaction() throws Exception {
       transactionService.addTransaction(TransactionUtil.createTransaction());
    }
}
