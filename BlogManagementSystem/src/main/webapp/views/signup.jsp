<%@ include file="/WEB-INF/views/layout.jsp" %>

<c:set var="content" value="signup" />

<h1>Signup</h1>

<form action="/users/signup" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <button type="submit">Signup</button>
</form>
