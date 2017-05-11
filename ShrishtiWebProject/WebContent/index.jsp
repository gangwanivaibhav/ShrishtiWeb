<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Search page using jsp/jQuery</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function() {  
		
		$("#search").on("click", function(){
			var name = $("#serchName").val();
			
			$.ajax({
				url : 'search.php?name='+name,
				type: "GET",
				datatype: "json",
				
				contentType : "application/json",
				
				success : function(data) {
					$("#pCount").text("");
					var str =  data.name +" : "+data.count;
					$("#pCount").text(str);
					
					
				}
			});
		})   
	});
function nameSearch(name) {
	if(name.length == 0) {
		$('#suggestions').hide();
	} else {
		$.post("allnames.jsp", {queryString: ""+name+""}, function(data){
		if(data.length >0) {
			$('#suggestions').show();
			$('#autoSuggestionsList').html(data);
		}
		});
	}
}
function fill(thisValue) {
	$('#name').val(thisValue);
	setTimeout("$('#suggestions').hide();", 200);
}
</script>

</head>
<body>
    <div class="container-fluid">
        <div class="panel panel-default">
            <div class="panel-heading" align="center">
                <h4><b><font color="white" style="font-family: georgia;">Search</font> </b></h4>
            </div>
            <div class="panel-body"align="center">
				
				<!-- <form action="search.php" method="get">	
					<input id = "name" name="name" type="text" placeholder ="enter something">
					<input id="search" type="submit" value="Submit">
				</form> -->
				 
				<form method="get" id="serachForm">
					<div> 
						<input type="text" size="30" value="" id="serchName" name="name" 
						onkeyup="nameSearch(this.value);" onblur="fill();" placeholder ="Type keyword here"/>
						<input id="search" type="button" value="Submit">
					</div>
					<div id="suggestions" style="display: none;">
						<div id="autoSuggestionsList">
						</div>
					</div>
				</form>
				<br>
				<div id ="dispCount" class = "well">
					<p id="pCount"></p>
				</div>
            </div>
        </div>
    </div>


</body>
</html>
