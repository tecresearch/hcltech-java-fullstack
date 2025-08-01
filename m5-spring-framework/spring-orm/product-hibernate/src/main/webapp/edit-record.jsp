<%@ include file='menu.jsp'  %>
<html>
 <style>
  th{
   text-align: left;
  }
 </style>
 <body>
 <form action="update-product-record" method="post">
  <table border='1' class='talist' style='width:40%'>
    <tr style='background-color:magenta'>
     <th colspan="2" style="text-align: center;color:white">Product Details</th>
    </tr>
	<tr>
	 <th>Product id</th>
	 <td>${product.pid}<input type="hidden" value="${product.pid}" name="pid"></td>
	</tr>   
	<tr>
	 <th>Edit product name</th>
	 <td><input type="text" name="name" value="${product.name}" class="tb" style="width:100%"></td>
	</tr>
	<tr>
	 <th>Edit product brand</th>
	 <td><input type="text" name="brand" value="${product.brand}" class="tb" style="width:100%"></td>
	</tr>
	<tr>
	 <th>Edit product price</th>
	 <td><input type="text" name="price" value="${product.price}" class="tb" style="width:100%"></td>
	</tr>
	<tr>
	 <td colspan="2" align="right">
	 	<button class='bt'>Update Record</button>
	 	<input type="button" value='Cancel' class='bt' onclick="history.back()">
	 </td>
	</tr>
  </table>
  </form>
 </body>
</html>