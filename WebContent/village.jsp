
 <jsp:include page="header.jsp"></jsp:include> 
	<h2>Formulaire d'enregistrement d'un village</h2>
	<form method = "post" action = "VillageServlet">
  	<div class="form-group">
   		 <label for="">Village</label>
    	 <input type="text" class="form-control" placeholder = "Nom du village..." name="nomVillage" >
  	</div>
  		<button type="submit" class="btn btn-primary">Enregistrer</button>
	</form>
<jsp:include page="footer.jsp"></jsp:include>