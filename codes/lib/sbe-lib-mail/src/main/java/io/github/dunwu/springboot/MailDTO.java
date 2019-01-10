package io.github.dunwu.springboot;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.Date;

/**
 * @author Zhang Peng
 * @date 2019-01-09
 */
@Data
public class MailDTO {
    private String from;
    private String replyTo;
    private String[] to;
    private String[] cc;
    private String[] bcc;
    private Date sentDate;
    private String subject;
    private String text;
    private String[] filenames;
}
