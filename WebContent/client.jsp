<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
<h1>Formulaire d'enregistrement d'un client</h1>
<form action="ClientServlet" method="post">
			<input class="form-control" type="text"  name ="nomFamille" placeholder="Nom de famille..."> <br>
			<input class="form-control" type="text"name="numeroTelephone" placeholder="Numero de telephone..."> <br>
		    <div class="form-row align-items-center">
			    <div class="col-auto my-1">
				      <label class="mr-sm-2" for="inlineFormCustomSelect">Village</label>
				      <select name="villageid" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
				        <option selected>Choisir ici...</option>
				        <c:forEach items="${villages }" var="village">
				        	<option value='<c:out value="${village.id }"/>'><c:out value="${village.nom }"/></option>
				        </c:forEach>
				      </select>
			    </div>
			    
			    <div class="col-auto my-1">
			     	 <button type="submit" class="btn btn-primary">Enregistrer</button>
			    </div>
		  </div>

	</form>
<jsp:include page="footer.jsp"></jsp:include>

