package com.zone.uitls;

import javax.mail.Session;
import java.util.Date;  
import java.util.Properties;  
  
import javax.mail.Authenticator;  
import javax.mail.Message;  
import javax.mail.MessagingException;  
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.AddressException;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
public class SendMailUtil {  
    
    public static final String HOST = "smtp.163.com";  
    public static final String PROTOCOL = "SMTP";  
    public static final int PORT = 25;  
    public static final String SENDER = "15180517632@163.com";//此处需要与host相同的网站  
    public static final String SENDERPWD = "s328196073";  
      
    /** 
     * 获取用于发送邮件的Session 
     * @return 
     */  
    public static Session getSession() {  
        Properties props = new Properties();  
        props.put("mail.smtp.host", HOST);//设置服务器地址  
        props.put("mail.store.protocol" , PROTOCOL);//设置协议  
        props.put("mail.smtp.port", PORT);//设置端口  
        props.put("mail.smtp.auth" , true);
        props.setProperty("mail.debug", "true");
          
        Authenticator authenticator = new Authenticator() {  
            @Override  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication(SENDER, SENDERPWD);  
            }  
        };  
        Session session = Session.getDefaultInstance(props,authenticator);  
        return session;  
    }  
      
    /** 
     * 发送邮件 
     * @param receiver 
     * @param content 
     */  
    public static void send(String receiver, String content) {  
        Session session = getSession();  
        try {  
            System.out.println("-------开始发送-------");  
            Message msg = new MimeMessage(session);  
            //设置message属性  
            msg.setFrom(new InternetAddress(SENDER));  
            InternetAddress[] addrs = {new InternetAddress(receiver)};  
            msg.setRecipients(Message.RecipientType.TO, addrs);  
            msg.setSubject("你需要注册网站会员的验证码请不要告诉别人！！！！");  
            msg.setSentDate(new Date());  
            msg.setContent(content,"text/html;charset=utf-8");  
            //开始发送  
            Transport.send(msg);  
                        System.out.println("-------发送完成-------");  
        } catch (AddressException e) {  
            e.printStackTrace();  
        } catch (MessagingException e) {  
            e.printStackTrace();  
        }  
    }
    
}    