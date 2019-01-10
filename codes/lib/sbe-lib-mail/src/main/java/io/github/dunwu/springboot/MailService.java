package io.github.dunwu.springboot;

import com.github.dozermapper.core.Mapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;

/**
 * @author Zhang Peng
 * @date 2019-01-09
 */
@Service
public class MailService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MailProperties mailProperties;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Mapper mapper;

    public void sendSimpleMailMessage(MailDTO mailDTO) {
        SimpleMailMessage simpleMailMessage = mapper.map(mailDTO, SimpleMailMessage.class);
        if (StringUtils.isEmpty(mailDTO.getFrom())) {
            mailDTO.setFrom(mailProperties.getFrom());
        }
        javaMailSender.send(simpleMailMessage);
    }

    public void sendMimeMessage(MailDTO mailDTO) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(mimeMessage, true);

            if (StringUtils.isEmpty(mailDTO.getFrom())) {
                messageHelper.setFrom(mailProperties.getFrom());
            }
            messageHelper.setTo(mailDTO.getTo());
            messageHelper.setSubject(mailDTO.getSubject());

            mimeMessage = messageHelper.getMimeMessage();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(mailDTO.getText(), "text/html;charset=UTF-8");

            // 描述数据关系
            MimeMultipart mm = new MimeMultipart();
            mm.setSubType("related");
            mm.addBodyPart(mimeBodyPart);

            // 添加邮件附件
            for (String filename : mailDTO.getFilenames()) {
                MimeBodyPart attachPart = new MimeBodyPart();
                try {
                    attachPart.attachFile(filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mm.addBodyPart(attachPart);
            }
            mimeMessage.setContent(mm);
            mimeMessage.saveChanges();

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);
    }
}
