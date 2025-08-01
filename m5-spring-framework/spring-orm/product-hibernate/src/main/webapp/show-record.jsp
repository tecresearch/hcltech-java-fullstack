<%@ include file='menu.jsp'  %>
<html>
 <style>
  th{
   text-align: left;
  }
 </style>
 <body>
  <table border='1' class='talist' style='width:40%'>
    <tr style='background-color:orange'>
     <th colspan="2" style="text-align: center;color:white">Product Details</th>
    </tr>
	<tr>
	 <th>Product id</th>
	 <td>${product.pid}</td>
	</tr>   
	<tr>
	 <th>Product name</th>
	 <td>${product.name}</td>
	</tr>
	<tr>
	 <th>Product brand</th>
	 <td>${product.brand}</td>
	</tr>
	<tr>
	 <th>Product price</th>
	 <td>${product.price}</td>
	</tr>
  </table>
 </body>
</html>