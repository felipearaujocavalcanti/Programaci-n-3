<%@include file="plantilla/header.jsp" %>
<%@include file="plantilla/menu.jsp" %>


    <c:set var="usuarios" scope="page" value="<%= servicio.getUsuarios() %>"/>
    <c:set var="Perfiles" scope="page" value="<%= servicio.getPerfiles() %>"/>
    
    
    
     <div class="row">
     <div class="col s10 offset-s1 ">
         <div class="card-panel">
      <div class="row">
           <h3><center>Usuarios</center></h3>
        <div class="col s12">
           
            <form action="controcatl.do" method="POST">
                <div class="input-field">
                    <input id="rutUser" type="text" name="rutUser" placeholder="11.111.111-1">
                    <label for="rutUser"></label>
                </div>
                
                <div class="input-field">
                    <input id="nombreUser" type="text" name="nombreUser" placeholder="Ingrese su Nombre">
                    <label for="nombreUser"></label>
                </div>
                
                <div class="input-field">
                    <input id="apellidoUser" type="text" name="apellidoUser" placeholder="Ingrese su Apellido">
                    <label for="apellidoUser"></label>
                </div>
                
                <div class="input-field">
                        <input id="emailUser" type="email" name="emailUser" placeholder="Ingrese su correo">
                    <label for="emailUser"></label>
                </div>
                
                <div class="input-field">
                        <input id="clave" type="password" name="clave" placeholder="Ingrese su contrase�a">
                    <label for="clave"></label>
                </div>
                
              <select name="perfil" placeholder="Perfil usuario">
                     <c:forEach items="${pageScope.Perfiles}" var="u">
                          <option value="${u.idPerfil}" var="u">${u.nombrePerfil}</option>
                     </c:forEach>
                    
                     
                 </select>
                
                
               
                <button class="btn right" name="bt" value="adduser" type="submit">Guardar</button>
                <button class="btn align-center" name="bt" value="" type="submit">Borrar</button>
                <a class="btn-floating btn-large cyan pulse"><i class="material-icons">edit</i></a>
            </form>
           ${requestScope.msg}
            <br><br>
            <table class="bordered">
                <tr>
                    <td>Rut</td>
                    <td>Nombre</td>
                    <td>Apellido</td>
                    <td>Email</td>
                    <td>Clave</td>
                    <td>Perfil</td>
                </tr>
               <c:forEach items="${pageScope.usuarios}" var="u">
                <tr>
                    
                    <td>${u.rutUser}</td>
                    <td>${u.nombreUser}</td>
                    <td>${u.apellidoUser}</td>
                    <td>${u.emailUser}</td>
                    <td>${u.clave}</td>
                    <td>${u.perfil.nombrePerfil}</td>
                    
                </tr>
                </c:forEach>
                
            </table>
           
        </div>
    </div>
        </div>
        </div>
        </div>
            
            <%@include file="plantilla/footer.jsp" %>
            
  