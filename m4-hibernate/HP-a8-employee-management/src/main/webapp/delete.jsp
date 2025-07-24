<%@ include file="navbar.jsp" %>
<html>
  <body onload="makeActive('delete')">
   <form action="confirm-delete.jsp">
    <table class='ta' style='background-color:red;color:white'>
     <tr>
      <td class='pad'><label>Enter employee id</label></td>
      <td class='pad'>
      	<input type="number" name="eid" required>
      </td>
      <td class='pad'>
       <button class='btn btn-primary'>Delete Record</button>
      </td>
     </tr>
    </table>
   </form>
  </body>
</html>