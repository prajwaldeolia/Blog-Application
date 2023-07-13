<%@ include file="/WEB-INF/views/layout.jsp" %>

<c:set var="content" value="like" />

<h1>Likes</h1>

<p>Total Likes: ${totalLikes}</p>

<!-- Like button -->
<form action="/likes/like/${blogId}" method="post">
    <button type="submit">Like</button>
</form>

<!-- Unlike button -->
<form action="/likes/unlike/${blogId}" method="post">
    <button type="submit">Unlike</button>
</form>
