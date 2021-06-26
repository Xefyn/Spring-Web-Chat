<html>
  <head>
    <link href="${pageContext.request.contextPath}/resources/css/chat.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
  </head>
  <body>
    <div class="row" style="min-height: 90vh;">
      <div class="col-sm-8 offset-2">
        <h2>Welcome back ${activeUser.name} to chat messaging</h2>
        <div class="containerStyle" style="text-align: center;padding: 0;">
          <div class="rowStyle" style="height: 100%;">
            <div class="col sm-3 listTab" style="text-align: left;">
              <c:forEach items="${listUser}" var="user">
                <c:if test="${user != activeUser}">
                  <form action="selectFriend" method="post" style="margin-bottom: 0;">
                    <input type="hidden" id="id" name="id" value="${user.id}" />
                    <input type="hidden" id="name" name="name" value="${user.name}" />
                    <input type="hidden" id="activeId" name="activeId" value="${activeUser.id}" />
                    <input type="hidden" id="activeName" name="activeName" value="${activeUser.name}" />
                    <button class="listItem">
                      <c:out value="${user.name}"/>
                    </button>
                  </form>
                </c:if>
              </c:forEach>
            </div>
            <div class="col-sm-9" style="position: relative;">
              <div class="friendName">
                ${friend.name}
              </div>
              <div style="padding: 5px;">
                <c:forEach items="${listChat}" var="chat">
                  <c:if test="${activeUser.id == chat.userSenderId}">
                    <div style="width: 100%;display: flex;justify-content: flex-end;">
                      <div class="chatBubbleRight">
                        ${chat.message}
                      </div>
                    </div>
                  </c:if>
                  <c:if test="${activeUser.id != chat.userSenderId}">
                    <div style="width: 100%;display: flex;justify-content: flex-start;">
                      <div class="chatBubbleLeft">
                        ${chat.message}
                      </div>
                    </div>
                  </c:if>
                </c:forEach>
              </div>
              <div class="chatContainer">
                <form action="sendChat" method="post" style="margin-bottom: 0;">
                  <input type="hidden" id="id" name="id" value="${friend.id}" />
                  <input type="hidden" id="name" name="name" value="${friend.name}" />
                  <input type="hidden" id="activeId" name="activeId" value="${activeUser.id}" />
                  <input type="hidden" id="activeName" name="activeName" value="${activeUser.name}" />
                  <input
                    type="text"
                    id="message"
                    name="message"
                    style="border-radius: 25px;"
                    class="form-control"
                    placeholder="Enter a message"
                  />
                  <button class="btn buttonSearch">
                    <i class="fas fa-paper-plane fa-2x"></i>
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script>
      function setFriend(friend){
      }
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  </body>
</html>