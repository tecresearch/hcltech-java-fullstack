<%@ include file='menu.jsp'  %>
<html>
 <body>
 <form action='save-record' method="post">
  <table class='tai'>
   <tr>
    <td class='tdp'>Enter product id</td>
    <td class='tdp'><input type='text' name='pid' class='tb' required></td>
   </tr>
    <tr>
    <td class='tdp'>Enter product name</td>
    <td class='tdp'><input type='text' name='name' class='tb' required></td>
   </tr>
    <tr>
    <td class='tdp'>Enter product brand</td>
    <td class='tdp'><input type='text' name='brand' class='tb' required></td>
   </tr>
    <tr>
    <td class='tdp'>Enter product price</td>
    <td class='tdp'><input type='text' name='price' class='tb' required></td>
   </tr>
   <tr>
    <td class='tdp' colspan="2" align="right">
     <button class='bt'>Save Record</button>
    </td>
   </tr>
  </table>
  </form>
 </body>
</html>