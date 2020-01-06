<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>login</title>
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"> -->
	
<style type="text/css">
		@import url(http://fonts.googleapis.com/css?family=Roboto:400);
body {
  background-color:#fff;
  -webkit-font-smoothing: antialiased;
  font: normal 14px Roboto,arial,sans-serif;
}

.container {
    padding: 25px;
    position: fixed;
}

.form-login {
    background-color: #EDEDED;
    padding-top: 10px;
    padding-bottom: 20px;
    padding-left: 20px;
    padding-right: 20px;
    border-radius: 15px;
    border-color:#d2d2d2;
    border-width: 5px;
    box-shadow:0 1px 0 #cfcfcf;
}

h4 { 
 border:0 solid #fff; 
 border-bottom-width:1px;
 padding-bottom:10px;
 text-align: center;
}

.form-control {
    border-radius: 10px;
}

.wrapper {
    text-align: center;
}

	</style>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet">
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>


	 <script type="text/javascript">
	function displaytable() {
		
		    $('#example').DataTable( {
		        "processing": true,
		       
		        "ajax": {
		            "url": "MongoDataCurrent",
		            "type": "GET"
		        },
		        "columns": [
		            { "data": "MessageID" },
		            { "data": "Request" },
		            { "data": "Source" },
		            { "data": "Request_Time" },
		            { "data": "Destination" },
		            { "data": "Response" },
		            { "data": "Response_Time" },
		            { "data": "Status" }
		        ],
		    } );
		    
		} ;
		
		
		function LoginFun(){
			var userid = document.getElementById("userid").value;
			var password=document.getElementById("password").value;
			var err;
			
			if(userid==""&&password==""){
				err="please enter Userid and Password"
					  document.getElementById("errormessage").innerHTML=err;
			}else if(userid==""){
				err="please enter Userid"
 					  document.getElementById("errormessage").innerHTML=err;
			}else if(password==""){
				err="please enter Password"
 					  document.getElementById("errormessage").innerHTML=err;
			}else{
				
			$.ajax({
				  type: 'POST',
                url: 'MongoData',
                async:false,
                data: {
                        username: userid, pass: password
                    }, 
                success: function(data){
                	
                	if(data=="success"){
                	var vdiv="<table id= 'example' class= 'display' cellspacing= '0' ><thead><tr><th style='width:10%'>MessageID</th><th style='width:10%'>Request</th><th style='width:10%'>Source</th><th style='width:10%'>Request_Time</th><th style='width:10%'>Destination</th><th style='width:10%'>Response</th><th style='width:10%'>Response_Time</th><th style='width:10%'>Status</th></tr></thead><tfoot><tr><th style='width:10%'>MessageID</th><th style='width:10%'>Request</th><th style='width:10%'>Source</th><th style='width:10%'>Request_Time</th><th style='width:10%'>Destination</th><th style='width:10%'>Response</th><th style='width:10%'>Response_Time</th><th style='width:10%'>Status</th></tr></tfoot></table>";;
                	document.getElementById("displaytable").innerHTML=vdiv;
                	displaytable();
                	
                	}else{
                		  err="userid or password is  incorrect";
   					  document.getElementById("errormessage").innerHTML=err;
   	                	
                	}
				  },
				  error: function(data){
					  alert("err data1 ::"+data);
					 
					  }
	        });
			}
		}

</script>

	
</head>
<body id="displaytable">

<%
//out.print("outside if userid ::"+session.getAttribute("userid"));
if (session.getAttribute("userid") == null){ 

	//out.print("inside if userid ::"+session.getAttribute("userid"));

%>
<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
        	
	            <div class="form-login">
	            <h4 id="errormessage" style="color:red"></h4>
	            <input type="text" id="userid" class="form-control input-sm chat-input" placeholder="Userid" />
	            </br>
	            <input type="Password" id="password" class="form-control input-sm chat-input" placeholder="Password" />
	            </br>
	            <div class="wrapper">
	            <span class="group-btn">     
	            <button  class="btn btn-primary btn-md" onclick="LoginFun()">Submit</button>
	            </span>
	            </div>
	            </div>
        
        </div>
    </div>
</div>

<%}else { %>
<table id="example" class="display" cellspacing="0" >
        <thead>
            <tr>
                <th style="width:10%">MessageID</th>
                <th style="width:10%">Request</th>
                <th style="width:10%">Source</th>
                <th style="width:10%">Request_Time</th>
                <th style="width:10%">Destination</th>
                <th style="width:10%">Response</th>
                <th style="width:10%">Response_Time</th>
                <th style="width:10%">Status</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th style="width:10%">MessageID</th>
                <th style="width:10%">Request</th>
                <th style="width:10%">Source</th>
                <th style="width:10%">Request_Time</th>
                <th style="width:10%">Destination</th>
                <th style="width:10%">Response</th>
                <th style="width:10%">Response_Time</th>
                <th style="width:10%">Status</th>
            </tr>
        </tfoot>
    </table>
    <script>
    $('#example').DataTable( {
        "processing": true,
       
        "ajax": {
            "url": "MongoData",
            "type": "GET"
        },
        "columns": [
            { "data": "MessageID" },
            { "data": "Request" },
            { "data": "Source" },
            { "data": "Request_Time" },
            { "data": "Destination" },
            { "data": "Response" },
            { "data": "Response_Time" },
            { "data": "Status" }
        ],
    } );

    </script>
<%}%>

	









</body>
</html>