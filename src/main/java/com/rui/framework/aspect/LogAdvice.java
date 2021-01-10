/*
package com.rui.framework.aspect;

import com.rui.sys.entity.Log;
import com.rui.sys.entity.User;
import com.rui.sys.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

*/
/**
 * aop切面类，实现日式功能
 *//*

public class LogAdvice {
    @Autowired
    private LogService logService;

    public void doBefore(JoinPoint joinPoint){
        Log log = new Log();
        log.setModel(joinPoint.getTarget().getClass().getSimpleName());//获取类名
        log.setOperation(joinPoint.getSignature().getName());//获取方法名
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];//获取参数列表
        HttpSession session = request.getSession();//将拿到的参数列表的第一个参数获取到sessiong
        Object o = session.getAttribute("USER");//从session中拿出用户session
        User user = (User) o;
        System.out.println();;
    }
    public void doAfter(){
        System.out.println("LogAdvice before advice ");
    }



    */
/*
     * 操作日志
     * *//*

    //后置增强，对controller下所有*.controller进行方法增强，
    public void operationLog(JoinPoint joinPoint){//需要通过joinpoint来获取
        Log log = new Log();
        log.setModel(joinPoint.getTarget().getClass().getSimpleName());//获取类名
        log.setOperation(joinPoint.getSignature().getName());//获取方法名
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];//获取参数列表
        HttpSession session = request.getSession();//将拿到的参数列表的第一个参数获取到sessiong
        Object o = session.getAttribute("USER");//从session中拿出用户session
        User user = (User) o;
        System.out.println();;
        */
/*Staff staff = (Staff)o;
        log.setOperator(staff.getAccount());//将session中的用户记录
        log.setResult("成功");//未发生异常set成功
        logService.addOperationLog(log);*//*


    }

    */
/*
     * 系统异常日志
     *//*

    public void systemLog(JoinPoint joinPoint,Throwable e){//需要通过joinpoint来获取
        Log log = new Log();
        log.setModel(joinPoint.getTarget().getClass().getSimpleName());//获取类名
        log.setOperation(joinPoint.getSignature().getName());//获取方法名
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];//获取参数列表
        HttpSession session = request.getSession();//将拿到的参数列表的第一个参数获取到sessiong
        Object o = session.getAttribute("USER");//从session中拿出用户session
        */
/*Staff staff = (Staff)o;
        log.setOperator(staff.getAccount());//将session中的用户记录
        log.setResult(e.getClass().getSimpleName());//获取发生异常的类
        logService.addSystemLog(log);*//*

    }

    */
/*
     * 登陆日志
     *//*

*/
/*    @After("execution(* com.mgy.controller.SelfController.login(..))")
    public void loginLog(JoinPoint joinPoint){//需要通过joinpoint来获取
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());//获取类名
        log.setOperation(joinPoint.getSignature().getName());//获取方法名
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];//获取参数列表
        HttpSession session = request.getSession();//将拿到的参数列表的第一个参数获取到sessiong
        Object o = session.getAttribute("USER");//从session中拿出用户session
        if (o==null){
            log.setOperation(request.getParameter("account"));//如果获取不到session证明未登陆成功，此时将用户输入的用户名记录
            log.setResult("失败");
        }else {
//            如果session中有值代表登陆成功
            Staff staff = (Staff)o;
            log.setOperator(staff.getAccount());//将session中的用户记录
            log.setResult("成功");
        }

        logService.addLoginLog(log);

    }*//*



    */
/*
     * 登出日志
     * *//*

    */
/*@Before("execution(* com.mgy.controller.SelfController.logout(..))")
    public void logoutLog(JoinPoint joinPoint){//需要通过joinpoint来获取
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());//获取类名
        log.setOperation(joinPoint.getSignature().getName());//获取方法名
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object o = session.getAttribute("USER");
        if (o==null){
            log.setOperation(request.getParameter("account"));
        }else {
            Staff staff = (Staff)o;
            log.setOperator(staff.getAccount());
            log.setResult("成功");
        }

        logService.addLoginLog(log);

    }*//*

}
*/
