package com.test.service;

public interface NotificationProvider {

    boolean sendNotification(String receiver, String message);

    String resendNotifications();

    void cleanup();
}
