package pl.skrzypekjan.aopsample.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pl.skrzypekjan.aopsample.service.MailService;

import javax.mail.MessagingException;


@Aspect
@Component
public class EmailAOP {

    private MailService mailService;

    public EmailAOP(MailService mailService) {
        this.mailService = mailService;
    }

    @After("@annotation(SendEmail)")
    private void sendEmail2() throws MessagingException {
        System.out.println("The new movie was added!");
        mailService.sendEmail("RECIPIENT'S EMAIL",
                "The new movie was added!",
                "Message from Api application, You added new movie!!!");
        System.out.println("Congratulations! Your mail has been send to the user.");
    }

    //    @Around("@annotation(SendEmail)")
//    private void sendEmail(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("working");
//        joinPoint.proceed();
//    }
}
