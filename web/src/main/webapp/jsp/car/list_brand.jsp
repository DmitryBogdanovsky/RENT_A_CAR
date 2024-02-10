<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="../header.jsp" %>

<table style="width:100%" class="table">
  <tr>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
      <th style="width: 40px;"></th>
    </sec:authorize>
    <th>"brand_name"</th>
  </tr>
  <tbody>
    <c:forEach items="${brands}" var="brandCar">
      <tr class='table-row' data-href='${brandCar.id}'>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
          <td><a style="text-decoration: none" href="${pageContext.request.contextPath}/brand-edit/${brandCar.id}.view">Edit</a></td>
        </sec:authorize>
        <td><c:out value="${brandCar.brandName}"/></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">

    <%-- Disable Previous on the first page --%>
    <c:choose>
      <c:when test="${page == 1}">
        <li class="page-item disabled">
          <a class="page-link" href="#" tabindex="-1">prev</a>
        </li>
      </c:when>
      <c:otherwise>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/brand-list.view?page=${page - 1}">prev</a></li>
      </c:otherwise>
    </c:choose>


    <li class="page-item"><a class="page-link" href=""><c:out value="${page}"/></a></li>

    <c:choose>
      <c:when test="${page == pages}">
        <li class="page-item disabled">
          <a class="page-link" href="${pageContext.request.contextPath}/brand-list.view?page=${page}" tabindex="-1">next</a>
        </li>
      </c:when>
      <c:otherwise>
        <li class="page-item">
          <a class="page-link" href="${pageContext.request.contextPath}/brand-list.view?page=${page + 1}">next</a>
        </li>
      </c:otherwise>
    </c:choose>

  </ul>
</nav>

<%@ include file="../footer.jsp" %>