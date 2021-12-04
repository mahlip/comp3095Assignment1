package ca.gbc.comp3095.assignment1.web;

import ca.gbc.comp3095.assignment1.model.AppUser;
import ca.gbc.comp3095.assignment1.service.AppUserNotFoundException;
import ca.gbc.comp3095.assignment1.service.AppUserServiceImpl;
import ca.gbc.comp3095.assignment1.service.Utility;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class PasswordResetController {

    @Autowired
    private AppUserServiceImpl appUserService;

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/forgot_password_form")
    public String showForgotPasswordForm(Model model){
        model.addAttribute("pageTitle", "Forgot Password");
        return "forgot_password_form";
    }

    @PostMapping("/forgot_password_form")
    public String processForgotPasswordForm(HttpServletRequest request, Model model){
        String email = request.getParameter("username");
        String token = RandomString.make(45);
        try {
            appUserService.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password_form?token=" + token;
            sendEmail(email, resetPasswordLink);

            model.addAttribute("message", "A password reset link has been sent to your email. Please check your email.");

        } catch (AppUserNotFoundException ex){
            model.addAttribute("error", ex.getMessage());
        } catch (UnsupportedEncodingException | MessagingException e) {
            model.addAttribute("error", "Error while sending email.");
        }
        model.addAttribute("pageTitle", "Forgot Password");

        return "forgot_password_form";
    }

    private void sendEmail(String email, String resetPasswordLink) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("contact@recipeapp.com", "Recipe App Support");
        helper.setTo(email);

        String subject = "Please click the link to reset your password.";

        String content = "<p>Hello,</p>" + "<p>You have made a request to reset your password.</p>"
                + "<p>Click the link below to change your password.</p>"
                + "<p><a href=\" " + resetPasswordLink + "\">Change password</a></p>"
                + "<p>If you did not make this request, or you no longer want to change your password " +
                "please ignore this email.</p>";
        helper.setSubject(subject);
        helper.setText(content, true);

        mailSender.send(message);
    }

    @GetMapping("/reset_password_form")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model){
        AppUser appUser = appUserService.getByResetPasswordToken(token);
        if(appUser == null){
            model.addAttribute("title", "Reset your password");
            model.addAttribute("message", "Invalid Token");

            return "message";
        }
        model.addAttribute("token", token);
        model.addAttribute("pageTitle", "Reset your Password");

        return "reset_password_form";
    }

    @PostMapping("/reset_password_form")
    public String processResetPassword(HttpServletRequest request, Model model){
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        AppUser appUser = appUserService.getByResetPasswordToken(token);

        if(appUser == null){
            model.addAttribute("title", "Reset your password");
            model.addAttribute("message", "Invalid Token");
            return "message";
        } else{
            appUserService.updatePassword(appUser, password);
            model.addAttribute("message", "You have successfully changed your password.");
        }
        return "message";
    }

}
