package com.afei.config.aspect.clear;import com.afei.config.redis.RSToken;import com.afei.config.response.ResponseResult;import com.afei.config.response.ReturnCode;import com.afei.utils.RedisUtil;import org.aspectj.lang.ProceedingJoinPoint;import org.aspectj.lang.annotation.Around;import org.aspectj.lang.annotation.Aspect;import org.aspectj.lang.annotation.Pointcut;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.context.annotation.Configuration;import org.springframework.data.redis.core.RedisTemplate;import org.springframework.web.bind.annotation.ResponseBody;import org.springframework.web.context.request.RequestContextHolder;import org.springframework.web.context.request.ServletRequestAttributes;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import java.util.Objects;import java.util.UUID;import java.util.concurrent.TimeUnit;/** * @author gongxiangfei * @description:  防重复提交切面 * @Date 2019/7/2 6:27 PM */@Configuration@Aspectpublic class RSTokenAspect {    private final Logger logger = LoggerFactory.getLogger(this.getClass());    @Autowired    private RedisUtil redisUtil;    @Autowired    private RedisTemplate redisTemplate;    private String redisPrefix="BI-";    private String redisSubmitPrefix="BI_SUBMIT_";    private String lockResult="OK";    private String responseResult="success";    @Pointcut("execution(* com.afei.controller.*.*(..))&& @annotation(rsToken) ")    public void submit(RSToken rsToken){}    @ResponseBody    @Around("submit(rsToken)")    private Object managerRSToken(ProceedingJoinPoint process, RSToken  rsToken) throws Throwable {/*        if(Objects.isNull(rsToken)){            return process.proceed();        }        HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();        HttpServletResponse response=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();        String token = CookieUtil.getCookieValue(request, "saas_login_token");        String value = UUID.randomUUID().toString();        if(rsToken.add()){            redisTemplate.opsForValue().set(redisSubmitPrefix+token,value,rsToken.timeout(), TimeUnit.SECONDS);            response.addHeader("BI_SUBMIT_"+token,value);        }        if(rsToken.remove()){            if(StringUtils.isBlank(token)){                return ResponseResult.fail(ReturnCode.RETURN_CODE_301200010);            }            Object submitTokenValue = redisTemplate.opsForValue().get(redisSubmitPrefix + token);            if(Objects.isNull(submitTokenValue)){                return ResponseResult.fail(ReturnCode.RETURN_CODE_301200013);            }            String key = redisPrefix + token;            Object result = redisUtil.lock(key,  value, rsToken);            if(lockResult.equals(result)){                try{                    //继续操作                    ResponseResult rsResponse = (ResponseResult)process.proceed();                    if(rsResponse.getCode()==0&&responseResult.equals(rsResponse.getMessage())){                        deleteSubmitToken(redisSubmitPrefix+token);                    }                }catch(RuntimeException e){                    return ResponseResult.fail(ReturnCode.RETURN_CODE_301200011);                }finally {                    //如果执行失败的花。也要将                    deleteSubmitToken(redisSubmitPrefix+token);                    //解锁代码要放在finally代码快中执行                    redisUtil.deleteLock(key, value);                }            }else{                return ResponseResult.fail(ReturnCode.RETURN_CODE_301200011);            }        }*/        return process.proceed();    }    private void deleteSubmitToken(String s) {        redisTemplate.delete(s);    }}