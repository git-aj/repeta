package com.test.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationProviderImpl implements NotificationProvider {

    public boolean sendNotification(String receiver, String message) {
        if("dummy".equals(receiver)) {
            return true;
        }
        return false;
    }

    public String resendNotifications() {
        return null;
    }

    public void cleanup() {

    }
}
