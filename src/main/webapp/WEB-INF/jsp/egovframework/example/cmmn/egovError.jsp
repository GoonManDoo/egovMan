 <%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>error</title></head><body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="100%" height="100%" align="center" valign="middle" style="padding-top: 150px;">
			code : ${requestScope['javax.servlet.error.status_code']}<br/>
			exception type : ${requestScope['javax.servlet.error.exception_type']}<br/>
			message : ${requestScope['javax.servlet.error.message']}<br/>
			exception : ${requestScope['javax.servlet.error.exception']}<br/>
			request uri : ${requestScope['javax.servlet.error.request_uri']}<br/>
			servlet name : ${requestScope['javax.servlet.error.servlet_name']}<br/>
		</td>
	</tr>
</table>
</body>
</html>
