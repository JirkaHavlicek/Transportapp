package com.example.hr_module;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;

@SpringJUnitConfig
@SpringBootTest
@AutoConfigureTestDatabase
@TestPropertySource("/application.yaml")
class HrModuleApplicationTests {

    @MockBean
    private DataSource dataSourceMock;

    @Test
    void contextLoads() {
    }

}
