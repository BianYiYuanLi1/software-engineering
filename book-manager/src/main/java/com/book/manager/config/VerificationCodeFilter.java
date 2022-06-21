//package com.book.manager.config;
//
//import com.book.manager.exception.VerifyCodeExpection;
//import com.book.manager.util.R;
//import com.book.manager.util.http.CodeEnum;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * 拦截登录请求，验证输入的验证码是否正确
// */
//@Component
//public class VerificationCodeFilter extends GenericFilter {
//
//  @Autowired
//  WebSecurityConfig webSecurityConfig;
//
//  @Override
//  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//    HttpServletRequest request = (HttpServletRequest) servletRequest;
//    HttpServletResponse response = (HttpServletResponse) servletResponse;
//    //如果是登录请求则拦截
//    System.out.println("访问路径是："+request.getServletPath());
//    if ("POST".equals(request.getMethod())&&"/user/addReader".equals(request.getServletPath())){
//      //用户输入的验证码
//      String code=null;
//      BufferedReader reader = request.getReader();
//      String line = reader.readLine();
//      if(line!=null){
//        String[] split = line.split(",");
//        for(int i=0;i<split.length;i++){
//          System.out.println("split["+i+"]:"+split[i]);
//          String[] split1 = split[i].split(":");
//          for (int j = 0; j < split1.length; j++) {
//            System.out.println("    split1["+j+"]:"+split1[j]);
//            if (split1[j].equals("\"verfication\"")){
//              code=split1[j+1];
//            }
//          }
//          if(code!=null)break;
//        }
//        code=code.substring(1,code.length()-1);
//        System.out.println("用户输入的验证码是："+ code);
//        //session中保存的验证码
//        String verify_code = (String) request.getSession().getAttribute("vfcode");
//        System.out.println("保存的验证码是："+ verify_code);
//        response.setContentType("application/json;charset=utf-8");
//        //验证session中保存是否存在
//        //验证是否相同
//        if (code!=null && !code.equals(verify_code)){
//          throw new VerifyCodeExpection("验证码错误");
//        }else {
//          filterChain.doFilter(request,response);
//        }
//      }
//      else {
//        filterChain.doFilter(request,response);
//      }
//    }
//    else {
//      filterChain.doFilter(request,response);
//    }
//  }
//}
