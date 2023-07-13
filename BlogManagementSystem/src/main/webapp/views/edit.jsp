<%@ include file="/WEB-INF/views/layout.jsp" %>

<c:set var="content" value="edit" />

<h1>Edit Blog</h1>

<form action="/blogs/edit/${blogId}" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" value="${blog.title}" required>

    <label for="content">Content:</label>
    <textarea id="content" name="content" required>${blog.content}</textarea>

    <button type="submit">Save</button>
</form>
