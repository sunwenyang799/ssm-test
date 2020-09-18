package com.ssm.log;

import com.ssm.pojo.SysLog;
import com.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * @author swy
 * @description: 日志
 * @date 2020/9/18 16:17
 */
@Component
@Aspect
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    private Long visitTime;
    private Class clazz;
    private Method method;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    @Pointcut("execution(* com.ssm.controller.*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint jp) throws NoSuchMethodException {
        //获取访问时间
        visitTime = new Date().getTime();
        //获取访问类
//        clazz = jp.getSignature().getDeclaringType();
        clazz  = jp.getTarget().getClass();
        String className = clazz.getName();
        //获取访问方法名
        String methodName = jp.getSignature().getName();
        //获取参数
        Object[] args = jp.getArgs();
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);
        } else {
            Class[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classes);
        }
        logger.info("执行方法：" + className + methodName + "参数为：" + args.toString());
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        StringBuilder url = new StringBuilder();
        //获取方法调用时间
        Long executionTime = new Date().getTime() - visitTime;
        //获取请求url
        RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
        if (classAnnotation != null) {
            url.append(classAnnotation.value()[0]);
            RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
            if (methodAnnotation != null) {
                url.append(methodAnnotation.value()[0]);
            }
        }
        //获取调用者ip
        String ip = request.getRemoteAddr();
        //获取username
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();

        SysLog sysLog = new SysLog();
        sysLog.setId(UUID.randomUUID().toString().replace("-", ""));
        sysLog.setExecutionTime(executionTime);
        sysLog.setIp(ip);
        sysLog.setMethod("类：" + clazz.getName() + "方法：" + method.getName());
        sysLog.setUrl(url.toString());
        sysLog.setUsername(username);
        sysLog.setVisitTime(new Date(visitTime));
        sysLog.setVisitTimeStr(new Date(visitTime).toString());
        sysLogService.saveLog(sysLog);
    }
}
