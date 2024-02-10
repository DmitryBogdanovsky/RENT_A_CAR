<%@ include file="../header.jsp" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%--@elvariable id="brand" type="antlr"--%>
<form:form method="POST" action="${pageContext.request.contextPath}/brand-add.action" modelAttribute="brand">
    <div class="mb-3">
        <form:label path="brandName" class="form-label">brand_name</form:label>
        <form:input path="brandName" class="form-control"/>
        <form:errors path="brandName" cssClass="text-danger"/>
    </div>

    <button type="submit" class="btn btn-primary">Update</button>
</form:form>

<%@ include file="../footer.jsp" %>
