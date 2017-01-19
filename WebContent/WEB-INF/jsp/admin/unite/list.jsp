<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../include/header.jsp"/>
<title>Ders Listesi</title>
</head>
<body class="skin-blue">
<jsp:include page="../include/head.jsp" />
    <div class="wrapper row-offcanvas row-offcanvas-left">
			<jsp:include page="../include/left.jsp"/>
 
 
 <aside class="right-side">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <h1>
      Ders Listesi

    </h1>

  </section>

  <!-- Main content -->
  <section class="content">

    <div class="box">

      <div class="box-body">
 
        
        <table class="table table-bordered">
          <tbody><tr>
            <th style="width: 10px">id</th>
            <th>Ders İsmi</th>
         
            <th style="width: 40px">Düzenle</th>
            <th style="width: 40px">Sil</th>
          </tr>
         <c:forEach items="${list}" var="row">
        <tr>
          <td><c:out value="${row.id}" /></td>
          <td><c:out value="${row.name}" /></td>
          <td><a href="${pageContext.request.contextPath}/admin/unite/edit/${row.id}">duzenle</a></td>
          <td><a href="${pageContext.request.contextPath}/admin/unite/${courseId}/delete/${row.id}">sil</a></td>
 
        </tr>
      </c:forEach>

          </tbody></table>
      </div><!-- /.box-body -->
      <div class="box-footer clearfix ">
        <div class="pagination-sm no-margin pull-right">

        </div>
      </div>
    </div>
  </section>
  <!-- /.content -->
</aside> 
 
    </div>

</body>
</html>