<%@ include file='menu.jsp'  %>
<html>
 <body>
 <form action='show-product'>
  <table class='tai' style='background-color:orange'>
   <tr>
    <td class='tdp'>Enter product id</td>
    <td class='tdp'><input type='text' value="${pid}" name='pid' class='tb' style="width:200px" required></td>
    <td><button class='bt'>Search Record</button></td>
   </tr>
  </table>
  <div class='dvv'>
   <h3 style='color:red'>${msg}</h3>
  </div>
  </form>
 </body>
</html>