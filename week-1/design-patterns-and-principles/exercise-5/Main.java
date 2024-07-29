public class Main {
    public static void main(String[] args) {
        Notifier email = new EmailNotifier();
        email.sendMessage("hello i am gaurav");

        Notifier sms = new SMSNotifierDecorator(email);
        sms.sendMessage("hello i am gaurav");

        Notifier slack = new SlacNotifierDecorator(sms);
        slack.sendMessage("hello i am gaurav");
    }
}

//  component
interface Notifier {
    void sendMessage(String message);
}

//  concreateCompnent
class EmailNotifier implements Notifier {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending the email notification: " + message);
    }
}

//  Decorator
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void sendMessage(String message) {
        notifier.sendMessage(message);
    }
}


//concrete decorator

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void sendMessage(String message) {
        super.sendMessage(message);
        System.out.println("Sending SMS Notification: " + message);
    }
}

class SlacNotifierDecorator extends NotifierDecorator {
    public SlacNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void sendMessage(String message) {
        super.sendMessage(message);
        System.out.println("Sending Slack Notification: " + message);
    }
}




