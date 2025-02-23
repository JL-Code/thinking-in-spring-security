package com.jiangy.thinkinginspringsecurity.security.ott;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.ott.OneTimeToken;
import org.springframework.security.web.authentication.ott.OneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.authentication.ott.RedirectOneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

/**
 * 生成魔法链接并通过短信或邮件的方式发送给用户
 * <p>创建时间: 2025/2/23 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">蒋勇</a>
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MagicLinkOneTimeTokenGenerationSuccessHandler implements OneTimeTokenGenerationSuccessHandler {

    private final MailSender mailSender;
    private final OneTimeTokenGenerationSuccessHandler redirectHandler = new RedirectOneTimeTokenGenerationSuccessHandler("/ott/sent");

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, OneTimeToken oneTimeToken) throws IOException, ServletException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(UrlUtils.buildFullRequestUrl(request))
                .replacePath(request.getContextPath())
                .replaceQuery(null)
                .fragment(null)
                .path("/login/ott")
                .queryParam("token", oneTimeToken.getTokenValue());
        String magicLink = builder.toUriString();
        String email = getUserEmail(oneTimeToken.getUsername());
        var message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your Spring Security One Time Token");
        message.setText("Use the following link to sign in into the application: " + magicLink);
        this.mailSender.send(message);
        this.redirectHandler.handle(request, response, oneTimeToken);
    }

    private String getUserEmail(String username) {
        // ...
        return "jiangliu0316@outlook.com";
    }


}
