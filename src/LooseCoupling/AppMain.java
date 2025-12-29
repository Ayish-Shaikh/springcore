package LooseCoupling;

public class AppMain {
    public static void main(String[] args) {

        NotificationService emailService = new EmailNotificationService();
        NotificationService smsService = new SMSNotificationService();
        UserService userService = new UserService(emailService);
        UserService userService1 = new UserService(smsService);
        userService.notifyUser("Order placed.");
        userService1.notifyUser("Order placed.");

        UserService userServiceSetter = new UserService();
        userServiceSetter.setNotificationService(emailService);
        userServiceSetter.notificationService = smsService;
    }
}
