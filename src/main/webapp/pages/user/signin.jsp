<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<!-- css, javascript -->
</head>

<body>
	<p>
		Enter information into the fields below. Your entries will be
		displayed when you Submit the form.<br /> This is just to demonstrate
		the Struts html tags. The information that you enter is discarded.
	</p>
	<p>* = required field</p>
	<hr noshade="noshade" />
	<html:errors />
	<html:form action="/SigninCheck" method="post">
		<p>
			<label for="username"><bean:message key="user.label.username" bundle="user" />
			</label>
			<html:text property="username" size="40" maxlength="100"></html:text>
		</p>
		<p>
			<label for="password"><bean:message key="user.label.password"  bundle="user"  /></label>
			<html:password property="password" size="40" maxlength="100"></html:password>
		</p>
		<p>
			<input type="checkbox" name="isRememberMe" value="true">Remember
			Me
		</p>
		<p>
			<html:submit>
				<bean:message key="user.label.button.Signin"  bundle="user" />
			</html:submit>
		</p>
	</html:form>
</body>
</html>