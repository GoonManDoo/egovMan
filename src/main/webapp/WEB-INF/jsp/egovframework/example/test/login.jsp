<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head></head>
<body>
   <h1>로그인</h1>
   <form name='f' action="login" method='POST'>
      <table>
         <tr>
            <td>아이디 : </td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td>비밀번호 : </td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
         	<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></td>
         </tr> 
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form>
</body>
</html>