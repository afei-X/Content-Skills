package com.afei.config.threadPool.threadpool2sendemail;


import com.sun.mail.util.MailSSLSocketFactory;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * @author gongxiangfei
 * @describe 发送邮件实体类
 * @dataTime 2019-05-28 11：41：00
 */
public class EmailRunnable implements Runnable{


    @Override
    public void run()  {


        try {

            Properties props = new Properties();

            // 开启debug调试
            //props.setProperty("mail.debug", "true");
            // 发送服务器需要身份验证
            props.setProperty("mail.smtp.auth", "true");
            // 设置邮件服务器主机名
            props.setProperty("mail.host", "smtp.qq.com");
            // 发送邮件协议名称
            props.setProperty("mail.transport.protocol", "smtp");

            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);

            Session session = Session.getInstance(props);
            System.out.println(session);
            Message msg = new MimeMessage(session);
            msg.setSubject("主题");
            StringBuilder builder = new StringBuilder();
            builder.append("博客:");
            builder.append("url = " + "http://www.cnblogs.com/hzxy-blog/");
            msg.setText(builder.toString());
            msg.setFrom(new InternetAddress("965305150@qq.com"));

            Transport transport = session.getTransport();
            transport.connect("smtp.qq.com",
                    "965305150@qq.com"
                    ,
                    "isbvfmnvyqsybaij"
            );

            transport.sendMessage(msg, new Address[] { new InternetAddress(
                    "965305150@qq.com"
            ) });
            transport.close();
        }catch (Exception e){

        }
    }
}
