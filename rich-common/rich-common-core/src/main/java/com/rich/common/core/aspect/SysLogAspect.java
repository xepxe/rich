package com.rich.common.core.aspect;

import com.rich.common.core.annotation.SysLog;
import com.rich.common.core.model.SysLogDTO;
import com.rich.common.core.util.IpUtil;
import com.rich.common.core.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xepxe
 * @date 2022/9/1 10:48
 */
@Slf4j
@Aspect
@Component
public class SysLogAspect {

    @Pointcut(value = "@annotation(sysLog)")
    public void pointcut(SysLog sysLog) {
    }

    @Around(value = "pointcut(sysLog)", argNames = "joinPoint,sysLog")
    public Object around(ProceedingJoinPoint joinPoint, SysLog sysLog) throws Throwable {
        SysLogDTO sysLogDTO = handleLog(joinPoint);
        if (sysLog != null) {
            sysLogDTO.setName(sysLog.value());
            sysLogDTO.setOperation(sysLog.operation());
        }
        StopWatch stopWatch = StopWatch.createStarted();
        Object o = null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable e) {
            sysLogDTO.setException(e.getMessage());
            throw e;
        } finally {
            stopWatch.stop();
            sysLogDTO.setResult(JsonUtil.to(o));
            sysLogDTO.setCost(stopWatch.getTime());
        }

        return o;
    }

    private SysLogDTO handleLog(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = methodSignature.getName();
        Object reqParams = getParameter(methodSignature.getMethod(), joinPoint.getArgs());
        log.info("{}.{}() params:{}", className, methodName, JsonUtil.to(reqParams));
        SysLogDTO sysLogDTO = new SysLogDTO();
        sysLogDTO.setUsername(request.getRemoteUser());
        sysLogDTO.setIp(IpUtil.getIpAddr(request));
        sysLogDTO.setMethod(request.getMethod());
        sysLogDTO.setParams(reqParams);
        sysLogDTO.setCreateTime(new Date());
        log.info("request:{}", JsonUtil.to(sysLogDTO));
        return sysLogDTO;
    }

    /**
     * 根据方法和传入的参数获取请求参数
     */
    private Object getParameter(Method method, Object[] args) {
        Map<String, Object> argMap = new HashMap<>(16);
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            for (int i = 0; i < args.length; i++) {
                //请求参数servlet json序列化报错
                if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile || args[i] instanceof MultipartFile[]) {
                    continue;
                }
                argMap.put(paramNames[i], args[i]);
            }
        }
        return argMap;
    }

}
