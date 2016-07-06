<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>poll</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<h1>Variants:</h1>
<form action="/poll" method="post">
<ul>
    <#list choicetexts as choice>
        <li><p><input type="radio" name="variant" id="inlineRadio1" value="${choice}"> ${choice}</p></li>
    </#list>
</ul>
    <button type="submit">Vote</button>
</form>
</body>
</html>