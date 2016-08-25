package com.test.service;

import static org.mockito.Mockito.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class SimpleServiceImplTest {

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();


    @MockBean
    private NotificationProvider notificationProviderMock;

    @Autowired
    private SimpleService simpleService;

    @Test
    public void simpleServiceMethod() throws Exception {
        when(notificationProviderMock.sendNotification(anyString(), anyString())).thenReturn(false);
        doNothing().when(notificationProviderMock).cleanup();

        String result = simpleService.simpleServiceMethod(1);

        assertEquals("", "1", result);
        verify(notificationProviderMock, times(1)).sendNotification(anyString(), anyString());
    }

    @Test
    @Parameters(method = "simpleServiceMethodDataProvider")
    public void simpleServiceMethodDataDrivenTest(Integer testParam, String expectedResult) {
        when(notificationProviderMock.sendNotification(anyString(), anyString())).thenReturn(false);

        String result = simpleService.simpleServiceMethod(testParam);

        assertEquals("", expectedResult, result);
        verify(notificationProviderMock, times(1)).sendNotification(anyString(), anyString());

    }

    @Test
    public void simpleServiceRecovery() throws Exception {
        doReturn("").when(notificationProviderMock).resendNotifications();

        simpleService.simpleServiceRecovery();

        verify(notificationProviderMock, times(1)).resendNotifications();

    }

    @SuppressWarnings("unused")
    private Object[][] simpleServiceMethodDataProvider() {
        return new Object[][] { {1, "1"}, { 2, "2"}};
    }

}