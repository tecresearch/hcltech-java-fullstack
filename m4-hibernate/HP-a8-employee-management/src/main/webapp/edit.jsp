<%@ include file="navbar.jsp" %>
<html>
  <body onload="makeActive('edit')">
   <form action="show-record.jsp">
    <table class='ta' style='background-color:gray;color:white'>
     <tr>
      <td class='pad'><label>Enter employee id</label></td>
      <td class='pad'>
      	<input type="number" name="eid" required>
      </td>
      <td class='pad'>
       <button class='btn btn-primary'>Show Record</button>
      </td>
     </tr>
    </table>
   </form>
  </body>
</html>