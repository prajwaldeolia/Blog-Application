<%@ include file="/WEB-INF/views/layout.jsp" %>

<c:set var="content" value="blogs" />

<h1>Blogs</h1>

<!-- Display list of blogs -->
<c:forEach var="blog" items="${blogs}">
    <h2>${blog.title}</h2>
    <p>${blog.content}</p>
    
    <!-- Display comments -->
    <h3>Comments:</h3>
    <ul>
        <c:forEach var="comment" items="${blog.comments}">
            <li>${comment.content}</li>
        </c:forEach>
    </ul>
    
    <!-- Display likes -->
    <p>Likes: ${blog.likes.size()}</p>
    
    <!-- Comment form -->
    <form action="/comments/add" method="post">
        <input type="hidden" name="blogId" value="${blog.id}">
        <input type="text" name="content" placeholder="Add a comment" required>
        <button type="submit">Add Comment</button>
    </form>
    
    <!-- Like button -->
    <form action="/likes/like/${blog.id}" method="post">
        <button type="submit">Like</button>
    </form>
    
    <!-- Unlike button -->
    <form action="/likes/unlike/${blog.id}" method="post">
        <button type="submit">Unlike</button>
    </form>
</c:forEach>
