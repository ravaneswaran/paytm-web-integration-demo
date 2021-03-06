<%@page import="rc.demo.app.properties.ApplicationProperties"%>
<%@page import="rc.demo.app.models.User"%>
<%@page import="rc.demo.app.SessionAttributes"%>
<%
	User sessionUser = (User)request.getSession().getAttribute(SessionAttributes.SESSION_USER);
%>

<div class="caption">
	<%= ApplicationProperties.getValue("app.title") %> : HTTP Status 404
</div>
<div class="user-strip">
	<%
		if(null == sessionUser){
	%>
			<div class="non-user-block">
				<div class="non-user-block-one" onclick="showOrHideUserMenu('#user-dropdown')">		
					<div class="non-user-block-one-item"></div>
					<div class="non-user-block-one-item"></div>
					<div class="non-user-block-one-item"></div>
					<div class="non-user-block-one-item"></div>
					<div class="non-user-block-one-item"></div>
					<div class="non-user-block-one-item"></div>
					<div class="non-user-block-one-item"></div>
					<div class="non-user-block-one-item"></div>
					<div class="non-user-block-one-item"></div>
				</div>
				<div id="user-dropdown" class="user-dropdown">
					<a href="../pages/login.jsp">Login</a>
					<!-- <div class="separator"></div>
					<a href="../user/logout">Logout</a> -->
				</div>
			</div>
	<%
		} else {
	%>
			<div class="user-block" onclick="showOrHideUserMenu('#user-dropdown')"><%= sessionUser.getFirstName() + " " + sessionUser.getLastName() %>
				<div id="user-dropdown" class="user-dropdown">
					<a href="../pages/product-listing.jsp">Product Listing</a>
					<a href="#">Order Listing</a>
					<div class="separator"></div>
					<a href="../pages/change-password.jsp">Change Password</a>
					<div class="separator"></div>
					<a href="../user/logout">Logout</a>
				</div>
			</div>
			<div class="user-welcome">Welcome</div>
	<%
		}
	%>
</div>
<div class="background-image"></div>            
<div id="cssmenu">
	<jsp:include page="../../pages/menu-bar/menu-bar.jsp"/>
</div>

<script>
	function showOrHideUserMenu(id){
		var display = $(id).css("display");
		if(display == "block"){
			$(id).css("display", "none");
		} else {
			$(id).css("display", "block");
		}
	}
</script>