<%@page import="rc.demo.razorpay.SessionAttributes"%>
<%@page import="rc.demo.razorpay.models.User"%>

<%
	User sessionUser = (User)request.getSession().getAttribute(SessionAttributes.SESSION_USER);
	
	if(null != sessionUser){
		response.sendRedirect("../pages/product-listing.jsp");
	}
%>