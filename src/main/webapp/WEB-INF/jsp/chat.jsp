<html>
  <head>
    <link href="${pageContext.request.contextPath}/resources/css/chat.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  </head>
  <body>
    <div class="row" style="min-height: 90vh;">
      <div class="col-sm-8 offset-2">
        <h2>Welcome back to chat messaging</h2>
        <div class="containerStyle" style="text-align: center;padding: 0;">
          <div class="rowStyle" style="height: 100%;">
            <div class="col sm-3 listTab" style="text-align: left;">
              <c:forEach items="${listUser}" var="user">
                <div class="listItem">
                  <c:out value="${user.name}"/>
                </div>
              </c:forEach>
            </div>
            <div class="col-sm-9" style="position: relative;">

              <div class="searchContainer">
                <input
                  style="border-radius: 25px;"
                  class="form-control"
                  placeholder="Enter a message"
                />
                <button class="btn buttonSearch">
                  <i class="fas fa-paper-plane fa-2x"></i>
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>