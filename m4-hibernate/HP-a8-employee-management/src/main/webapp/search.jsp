<%@ include file="navbar.jsp" %>
<html>
  <body onload="makeActive('search')">
   <form action="search-record.jsp">
    <table class='ta'>
     <tr>
      <td class='pad'><label>Enter employee id</label></td>
      <td class='pad'>
      	<input type="number" name="eid" required>
      </td>
      <td class='pad'>
       <button class='btn btn-primary'>Search Record</button>
      </td>
     </tr>
    </table>
   </form>
  </body>
</html>