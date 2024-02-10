<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                                    <h4 class="mb-4 pb-3">User Profile</h4>
                                    <form method="POST" action="${pageContext.request.contextPath}/user-profile/${userId}.view" modelAttribute="user">
                                        <div class="form-group">
<%--                                            <input type="hidden" name="userId" class="form-style" id="userId"  value="${userId}"/>">--%>
                                            <label for="firstName">First Name</label>
                                            <input readonly type="text" name="userDetails.first_Name"
                                                   class="form-style" id="firstName"
                                                   value="<c:out value="${user.userDetails.firstName}"/>">
                                            <i class="input-icon uil uil-user"></i>
                                        </div>
                                        <div class="form-group mt-2">
                                            <label for="lastName">Last Name</label>
                                            <input readonly type="text" name="userDetails.last_Name"
                                                   class="form-style" id="lastName"
                                                   value="<c:out value="${user.userDetails.lastName}"/>">
                                            <i class="input-icon uil uil-user"></i>
                                        </div>
                                        <div class="form-group mt-3">
                                            <label for="phoneNumber">Phone number</label>
                                            <input readonly type="tel" name="userDetails.phone_Number"
                                                   class="form-style" id="phoneNumber"
                                                   value="<c:out value="${user.userDetails.phoneNumber}"/>">
                                            <i class="input-icon uil uil-phone"></i>
                                        </div>
                                        <div class="form-group mt-3">
                                            <label for="birthDate">Birth day</label>
                                            <input readonly type="date" name="userDetails.birth_Date"
                                                   class="form-style" id="birthDate"
                                                   value="<c:out value="${user.userDetails.birthDate}"/>">
                                            <i class="input-icon uil uil-user"></i>
                                        </div>
                                        <div class="form-group mt-3">
                                            <label for="email">Email</label>
                                            <input readonly type="email" name="email" class="form-style"
                                                   id="email" value="<c:out value="${user.email}"/>">
                                            <i class="input-icon uil uil-at"></i>
                                        </div>
                                        <div class="form-group mt-3">
                                            <label for="roleEnum">Role</label>
                                            <input readonly type="text" name="password" class="form-style"
                                                   id="roleEnum" value="<c:out value="${user.roleEnum}" />">
                                            <i class="input-icon uil uil-users-alt"></i>
                                        </div>
<%--                                            <a href="${pageContext.request.contextPath}/edit-userProfile/{userId}.view" class="btn mt-4-primary btn-lg" >Edit</a>--%>
                                            <p class="mb-0 mt-4 text-center"><a href="${pageContext.request.contextPath}/index.html"  class="link">Cancel</a></p>
                                    </form>
                                </div>

                                </div>
                            </div>
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