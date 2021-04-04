package com.example.demo.Web;

import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.Model.User;
import com.example.demo.Service.UserServiceImpl;
import com.example.demo.Utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import net.bytebuddy.utility.RandomString;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class ForgotPasswordController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/reset")
    public String processForgotPasswordForm(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String token = RandomString.make(45);

        System.out.println("Email: " + email);
        System.out.println("Token: " + token);

        try {
            userService.updateResetPasswordToken(token, email);
        } catch (UserNotFoundException uNF) {
            model.addAttribute("error", uNF.getMessage());
        }

        String resetPasswordLink = Utility.getSiteURL(request) + "/resetPassword?token=" + token;
        sendEmail(email, resetPasswordLink);
        model.addAttribute("message", "We have sent a link to your email. Follow this link to reset your password.");
        return "redirect:/";
    }

    private void sendEmail (String email, String resetPasswordLink){
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setFrom("Group6BookstoreCSCI4050@gmail.com", "Bookstore Support");
            helper.setTo(email);
            String subject = "Here is your reset password link!";
            String content = "<p>Hello,</p>"
                    + "<p>You have requested to reset your password.</p>"
                    + "<p>Click the link below to change your password:</p>"
                    + "<p><a href=\"" + resetPasswordLink + "\">Change my password</a></p>"
                    + "<p>Ignore this email if you do remember your password or you did not make the request.</p>";
            helper.setSubject(subject);
            helper.setText(content, true);
            System.out.println(resetPasswordLink);
            mailSender.send(message);
        } catch (UnsupportedEncodingException | MessagingException uCE) {
            uCE.printStackTrace();
        }
    }

    @GetMapping("/resetPassword")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
        User user = userService.getByToken(token);
        if(user == null) {
            model.addAttribute("message", "Invalid Token");
            return "message";
        }
        model.addAttribute("token", token);
        return "resetPassword";
    }

    @PostMapping("/resetPassword")
    public String processResetPassword(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        User user = userService.getByToken(token);

        if(user == null) {
            model.addAttribute("message", "Invalid Token");
            return "message";
        } else {
            userService.updatePassword(user, password);
        }
        return "redirect:/";
    }
}
