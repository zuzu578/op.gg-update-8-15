<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> test Jsp </h1>


</body>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
$( document ).ready(function() {
    console.log( "ready!" );
    axios.get('http://localhost:8082/myopggapp/exController')
    .then((res)=>{
    			console.log(res.data);
    		
    			
    		})
	
});


</script>
</html>