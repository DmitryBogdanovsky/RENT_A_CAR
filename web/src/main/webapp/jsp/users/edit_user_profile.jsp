<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../header.jsp" %>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://unicons.iconscout.com/release/v2.1.9/css/unicons.css'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_profile.css">
</head>
<div class="section">
    <div class="container">
        <div class="row full-height justify-content-center">
            <div class="col-12 text-center align-self-center py-5">
                <div class="section pb-5 pt-5 pt-sm-2 text-center">
                    <div class="card-3d-wrap mx-auto">
                        <div class="card-front">
                            <div class="center-wrap">
                                <div class="section text-center">
                                <h4 class="mb-4 pb-3">Edit User Profile</h4>
                                <form method="POST" action="${pageContext.request.contextPath}/edit-userProfile/${userId}.action" modelAttribute="user">
                                    <div class="form-group">
                                             <label for="firstName">First Name</label>
                                             <input type="text" name="userDetails.firstName" class="form-style" id="firstName" value="<c:out value="${user.userDetails.firstName}"/>">
                                            <i class="input-icon uil uil-user"></i>
                                    <div class="form-group mt-2">
                                        <label for="lastName">Last Name</label>
                                        <input type="text" name="userDetails.lastName" class="form-style" id="lastName" value="<c:out value="${user.userDetails.lastName}"/>">
                                        <i class="input-icon uil uil-user"></i>
                                    </div>
                                    <div class="form-group mt-3">
                                        <label for="phoneNumber">Phone number</label>
                                        <input type="tel" name="userDetails.phoneNumber" class="form-style" id="phoneNumber" value="<c:out value="${user.userDetails.phoneNumber}"/>">
                                        <i class="input-icon uil uil-phone"></i>
                                    </div>
                                    <div class="form-group mt-3">
                                        <label for="birthDate">Your Birth day</label>
                                        <input type="date" name="userDetails.birthDate" class="form-style" id="birthDate" value="<c:out value="${user.userDetails.birthDate}"/>">
                                        <i class="input-icon uil uil-user"></i>
                                    </div>
                                    <div class="form-group mt-3">
                                        <label for="email">Your Email</label>
                                        <input type="email" name="email" class="form-style" id="email" value="<c:out value="${user.email}"/>">
                                        <i class="input-icon uil uil-at"></i>
                                    </div>
<%--                                    <div class="form-group mt-3">--%>
<%--                                        <label for="password">Your Password</label>--%>
<%--                                        <input readonly name="password" class="form-style" id="password"  value="<c:out value="${user.password}"/>">--%>
<%--                                        <i class="input-icon uil uil-lock-alt"></i>--%>
<%--                                    </div>--%>
                                        <div>
                                        <input readonly type="text" name="role" class="form-style"
                                               id="roleEnum" value="<c:out value="${user.roleEnum}" />">
                                        <i class="input-icon uil uil-users-alt"></i>
                                        </div>
                                    <button class="btn mt-4-primary btn-lg" type="submit">Update</button>
                                     </div>
                                 </form>
                               </div>
                             </div>
                           </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<%@include file="../footer.jsp" %>
</html>

