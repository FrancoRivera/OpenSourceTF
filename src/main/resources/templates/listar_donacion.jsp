
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header_slim.jsp" /> 

<div class="margin_30"></div>
<div class="margin_30"></div>
<div class="container">

<!-- START OF TEMPLATE -->

<h1 class="text-center">Tu lista de Donaciones</h1>


<c:choose>
 <c:when test="${not empty lista}">
<table class="table">
<thead>
<tr>
<th> ID </th> <th> Nombre CA </th> <th> Nombre Usuario </th> <th> Tipo Donación </th> <th> Descripcion </th> <th> Cantidad </th><th>Creación</th>
</tr>

				 
				    <c:forEach var="p" items="${lista}">
							<tr>
							<td> ${p.id_donation}</td>
							<td> ${p.nombregc}</td>
							<td> ${p.nombreuser}</td>
							<td> ${p.type}</td>
							<td> ${p.description}</td>
							<td> ${p.quantity}</td>
							<td> ${p.dcreation}</td>
							<td> <form action="donation" method="post"><input type="hidden" name="action" value="delete"><input type="hidden" name="donation_id" value="${p.id_donation}"><input type="hidden" name="gc_id" value="${p.id_gatheringc}"><button class="btn btn-danger">Borrar</button></form></td>
							</tr>
					</c:forEach>	

</thead>
</table>
				  </c:when>
				  <c:otherwise>
				    <p>No hay donaciones</p>
				  </c:otherwise>
				</c:choose>
				
				<a href="registro"><button type="button" class="btn btn-primary"> Agregar nueva donacion </button></a>

  <!-- END OF TEMPLATE -->
  
  
   </div>
  
<jsp:include page="footer.jsp" /> 
 <script   src="https://code.jquery.com/jquery-3.2.1.min.js"   integrity="sha256-k2WSCIexGzOj3Euiig+TlR8gA0EmPjuc79OEeY5L45g="   crossorigin="anonymous"></script>
<script   src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"   integrity="sha256-eGE6blurk5sHj+rmkfsGYeKyZx3M4bG+ZlFyA7Kns7E="   crossorigin="anonymous"></script>
<script src="js/holder.min.js"></script>
<script src="js/bootstrap-datepicker.min.js"></script>
      
<script>
$('.input-daterange input').each(function() {
    $(this).datepicker({
    format:"yyyy-mm-dd"
    })
});

$("#select_tipo").on("change", function(){
	if ($(this).val()=="Dinero"){
		$("#input_qty").slideDown();
	}
	else{
		$("#input_qty").slideUp();
	}
});

</script>

</body>
</html>
