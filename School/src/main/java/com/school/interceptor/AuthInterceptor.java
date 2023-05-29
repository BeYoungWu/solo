package com.school.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.school.dto.AccountDto;

public class AuthInterceptor implements HandlerInterceptor {

	// 컨트롤러를 호출하기 전에 호출되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
			throws Exception {
		
		String uri = req.getRequestURI(); // 현재 요청 경로 (웹경로 : http://.../.../*.action)

		HttpSession session = req.getSession();
		AccountDto account = (AccountDto)session.getAttribute("loginuser");
		
		if (account == null) {	// 로그인 하지 않은 사용자
			if (uri.contains("/board/write") 	||
				uri.contains("/board/list")     ||
				uri.contains("/admin")) { // 로그인한 사용자만 볼 수 있는 요청
			
				resp.sendRedirect("/account/login");
				return false; // 예정된 컨트롤러 호출을 취소				
			}
			
		}
		
		int accountType = account.getUserType();
		
		if (accountType == 0) { // 일반회원인 경우
			// 전부 불가
		}
		
		if (accountType == 1) { // 학생회원인 경우
			// 학생코너만 사용가능 나머지는 불가
		}
		
		if (accountType == 2) { // 학부모회원인 경우
			// 학부모코너만 사용가능 나머지는 불가
		}
		
		if (accountType == 3) { // 교사회원인 경우
			// 관리자페이지만 불가
		}
		
		if (accountType != 4) { // 관리자가 아닌  사용자
			if(uri.contains("/admin")) { // 관리자가 아니면 볼 수 없음
				
				String unauthorizedMessage = "회원유형이 해당되지 않습니다"; // 경고 메시지 설정

		        // 세션에 경고 메시지 저장
		        req.getSession().setAttribute("unauthorizedMessage", unauthorizedMessage);
		        
		        // 리다이렉트할 경로 설정
		        String redirectPath = "/home?error=unauthorized";
		        resp.sendRedirect(redirectPath);
		        return false;
			}
		}
		
		return true; // 예정대로 컨트롤러 호출을 수행
	}	
	
	// 컨트롤러 처리가 끝난 후에 호출되는 메서드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	
	// View 처리까지 끝난 후에 호출되는 메서드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
}
