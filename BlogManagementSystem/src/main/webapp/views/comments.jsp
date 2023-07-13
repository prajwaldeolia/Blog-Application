<%@ include file="/WEB-INF/views/layout.jsp" %>

<c:set var="content" value="comments" />

<h1>Comments</h1>

<!-- Display list of comments -->
<c:forEach var="comment" items="${comments}">
    <p>${comment.content}</p>
</c:forEach>

<!-- Add comment form -->
<form action="/comments/add" method="post">
    <input type="hidden" name="blogId" value="${blogId}">
    <textarea name="content" required></textarea>
    <button type="submit">Add Comment</button>
</form>
