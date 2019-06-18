package com.afei.config.aspect;

import com.afei.config.redis.RSToken;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * Description
 * 基于切面防重复提交
 * @author thinkpad
 * @version 1.0
 * Date                 Author			Version     Description
 * ------------------------------------------------------------------
 * 2019-2-20--14:37     suyin             1.0      Version
 */
@Aspect
@Component
public class RsTokenAspect {

    /*@Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    private static final String RSTOKEN = "rstoken";

    private static final String TOKEN = "token";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JedisLockUtil jedisLockUtil;


    @Pointcut("@annotation(rsToken) && execution (* imall.controller..*.*(..))")
    public void rsTokenAspectPointcut(RSToken rsToken) {
    }


    @ResponseBody
    @Around(value = "rsTokenAspectPointcut(rsToken)")
    public Object rsTokenAspectAround(ProceedingJoinPoint invocation, RSToken rsToken) throws Throwable {
        if (rsToken == null) {
            return invocation.proceed();
        }
        String token = getRequestHeaderByName(TOKEN);
        if (rsToken.add()) {
            String value = String.valueOf(System.currentTimeMillis());
            redisTemplate.opsForValue().set(UserConstant.WX_MIMI_USER_SUBMIT_TOKEN + token, value, rsToken.timeout(), TimeUnit.SECONDS);
            response.addHeader(RSTOKEN, value);
            return invocation.proceed();
        }
        if (rsToken.remove()) {
            String value = getRequestHeaderByName(RSTOKEN);
            String v = (String) redisTemplate.opsForValue().get(UserConstant.WX_MIMI_USER_SUBMIT_TOKEN + token);
            if (null == v || StringUtils.isBlank(value)) {
                return AppMessage.error(50001);
            }
            String lockKey = UserConstant.WX_MIMI_USER_LOCK + token;
            boolean b = jedisLockUtil.tryLock(lockKey, 1, 20);
            if (b) {
                v = (String) redisTemplate.opsForValue().get(UserConstant.WX_MIMI_USER_SUBMIT_TOKEN + token);
                if (null == v) {
                    return AppMessage.error(50001);
                } else if (v.equals(value)) {
                    AppMessage appMessage = null;
                    try {
                        appMessage = (AppMessage) invocation.proceed();
                        if (appMessage != null && AppMessageCode.success.getCode() == appMessage.getCode().intValue()) {
                            clearRsToken(token);
                        }
                    } catch (RuntimeException e) {
                       // clearRsToken(token);
                        throw e;
                    } finally {
                        jedisLockUtil.deleteLock(lockKey);
                    }
                    return appMessage;
                } else {
                    return AppMessage.error(50004);
                }
            } else {
                return AppMessage.error(50002);
            }


        }
        return null;
    }


    private void clearRsToken(String token) {
        redisTemplate.delete(UserConstant.WX_MIMI_USER_SUBMIT_TOKEN + token);
    }


    private String getRequestHeaderByName(String name) {
        if (request == null) {
            return null;
        }
        return request.getHeader(name);
    }

*/
}
