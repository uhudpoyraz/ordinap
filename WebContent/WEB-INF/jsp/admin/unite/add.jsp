<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../include/header.jsp"/>
<title>Ders Ekle</title>
</head>
<body class="skin-blue">
<jsp:include page="../include/head.jsp" />
    <div class="wrapper row-offcanvas row-offcanvas-left">
			<jsp:include page="../include/left.jsp"/>
     <aside class="right-side">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <h1>
      Unite Ekle

    </h1>

  </section>

  <!-- Main content -->
  <section class="content">
    <div class="box box" style="width: 50%;">
      <div class="box-body">
			
			<c:if test="${not empty message}">
			
			 <div class="box-body">
          <div class="alert alert-success alert-dismissable">
            <i class="fa fa-check"></i>
            <button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>
            <b>${message}</b>
          </div>
        </div>
			
			</c:if>

		<form:form modelAttribute="Unite" action="/Ordinap/admin/unite/save/" method="post">
		<input name="courseId" type="hidden" value="${courseId}"/>
		
		<div class="form-group">
          <label>Unite İsmi</label>
          <form:input type="text" path="name" id="name"  class="form-control"/>
        </div>
		
		   <div class="form-group">
          <form:button class="btn btn-primary btn-sm">Ekle</form:button>
        </div>
		</form:form>
        
 
      </div>
    </div>
  </section>
  <!-- /.content -->
</aside>
    </div>

</body>
</html>