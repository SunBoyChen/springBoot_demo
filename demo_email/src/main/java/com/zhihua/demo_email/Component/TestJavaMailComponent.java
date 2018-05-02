package com.zhihua.demo_email.Component;


import com.zhihua.demo_email.conf.TestJavaMailSenderImpl;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.ParseException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Component
public class TestJavaMailComponent {
    private static final String template = "mail/roncoo.ftl";

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Autowired
    private TestJavaMailSenderImpl javaMailSender;

    public void sendMail(String email) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("email", email);
        try {
            //获取邮箱内容
            String text = getTextByTemplate(template, map);
            //System.out.println(text);
            send(email, text);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String getTextByTemplate(String template, Map<String, Object> model) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
        return FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurer.getConfiguration().getTemplate(template), model);
    }

    private String send(String email, String text) throws MessagingException, UnsupportedEncodingException {
        // 创建邮件消息
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        InternetAddress from = new InternetAddress();
        //设置发送人
        from.setAddress(javaMailSender.getUsername());
        //邮件内容标题
        from.setPersonal("cc学院", "UTF-8");
        helper.setFrom(from);
        //设置被发送人邮箱
        helper.setTo(email);
        //标题
        helper.setSubject("测试邮件");
        //设置内容， 设置类型，文本还是html
        helper.setText(text, true);
        javaMailSender.send(message);
        return text;
    }

}