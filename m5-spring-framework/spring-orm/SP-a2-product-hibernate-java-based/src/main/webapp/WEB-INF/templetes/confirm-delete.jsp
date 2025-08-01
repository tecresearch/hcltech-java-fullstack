<%@ include file='menu.jsp'  %>
<html>
 <style>
  th{
   text-align: left;
  }
 </style>
 <body>
 <form action="delete">
  <table border='1' class='talist' style='width:40%'>
    <tr style='background-color:red'>
     <th colspan="2" style="text-align: center;color:white">Product Details</th>
    </tr>
	<tr>
	 <th>Product id</th>
	 <td>${product.pid}<input type="hidden" value="${product.pid}" name="pid"></td>
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
	<tr>
	 <td colspan="2" align="right">
	 	<button class='bt' style='color:white;background-color:red'>Are you sure to delete?</button>
	 	<input type="button" value='Cancel' class='bt' onclick="history.back()">
	 </td>
	</tr>
  </table>
  </form>
 </body>
</html>