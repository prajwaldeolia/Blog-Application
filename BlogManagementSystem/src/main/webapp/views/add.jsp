<%@ include file="/WEB-INF/views/layout.jsp" %>

<c:set var="content" value="add" />

<h1>Add Blog</h1>

<form action="/blogs/add" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required>

    <label for="content">Content:</label>
    <textarea id="content" name="content" required></textarea>

    <button type="submit">Add</button>
</form>
