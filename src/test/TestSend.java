package test;

import javax.mail.MessagingException;

public class TestSend {
    static SentNewEmail sentNewEmail=new SentNewEmail();
    public static  void main(String[] args) throws MessagingException {
        sentNewEmail.sent("2247839764@qq.com","aaa","1234445");
    }
}
