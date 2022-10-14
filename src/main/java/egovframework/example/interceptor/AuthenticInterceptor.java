package egovframework.example.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * @author lso
 * @version 1.0.0
 * @since 2020-01-22 오전 10:59
 * @param
 * @return
 * <pre>
 * Comments : 권한 인터셉터
 * <pre>
 */
public class AuthenticInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle >>>  Controller 실행 전 실행");
        return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modeAndView) throws Exception {
        System.out.println("postHandle >>>  Controller 실행 후 실행");
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
        System.out.println("afterCompletion >>>  preHandle 메소드 return값이 true일 때 실행");
    }
 
}
