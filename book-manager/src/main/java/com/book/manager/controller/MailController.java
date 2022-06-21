package com.book.manager.controller;

import com.book.manager.service.MailService;
import com.book.manager.util.R;
import com.book.manager.util.http.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 邮箱服务控制器
 */
@RestController
@RequestMapping("/mail")
public class MailController {

  @Autowired
  MailService mailService;


  @PostMapping("/verificationCode")
  public R sendVerificationCode(@RequestBody String address, HttpSession session){
    System.out.println("地址是："+address);
//    address=address.substring()
    //四位随机数：1000~9999
    int verificationCode = (int)(Math.random()*8999)+1000;
    session.setAttribute("vfcode",verificationCode+"");
    boolean b = mailService.sendVerificationCode(address, verificationCode);
    if(b){
      System.out.println("发送验证码成功："+verificationCode);
      return R.success(CodeEnum.SUCCESS);
    }
    else {
      System.out.println("发送验证码失败");
      return R.fail(CodeEnum.FAIL);
    }
  }

  @GetMapping("/verficate")
  public R verficate(@RequestParam("verficateCode")String verficateCode, HttpSession session){
    String verify_code = (String) session.getAttribute("vfcode");
    if (verficateCode!=null){
      boolean equals = verficateCode.equals(verify_code);
      if(equals){
        return R.success(CodeEnum.SUCCESS);
      }
      else {
        return R.fail(CodeEnum.VERIFICATE_FAIL);
      }
    }
    return R.fail(CodeEnum.FAIL);
  }
}
