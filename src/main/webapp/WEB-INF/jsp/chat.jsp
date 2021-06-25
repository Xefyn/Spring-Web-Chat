<html>
  <head>
    <link href="${pageContext.request.contextPath}/resources/css/chat.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  </head>
  <body>
    <div class="row">
      <div class="col-sm-8 offset-2">
        <div class="container" style="text-align: center;">
          <div class="row">
              <h2>Welcome back to chat messaging</h2>
          </div>
          <div class="row">
            <div class="col sm-4" style="text-align: left;">
              <c:forEach items="${listUser}" var="user">
                <c:out value="${user.name}"/>
              </c:forEach>
            </div>
            <div class="col-sm-8">8</div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>