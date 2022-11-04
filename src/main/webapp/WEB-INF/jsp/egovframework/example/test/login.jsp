<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head></head>
<body>
   <h1>로그인</h1>
   <form name='f' action="login_check" method='POST'>
   <c:if test="${param.ng!=null}">
			<p> error : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/> </p>
		</c:if>
		
		<c:if test="${LoginFailMessage!=null}">
			<p> Error : <c:out value="${LoginFailMessage}"/> </p>
		</c:if>
      <table>
         <tr>
            <td>아이디 : </td>
            <td><input type='text' name='user_id' value=''></td>
         </tr>
         <tr>
            <td>비밀번호 : </td>
            <td><input type='password' name='user_pw' /></td>
         </tr>
         <tr>
         	<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></td>
         </tr> 
         <tr>
            <td><input name="submit" type="submit" value="Login" /></td>
         </tr>
      </table>
  </form>
</body>
</html>