<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>polls</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<h1>Polls</h1>
<ul>
    <#list polls as poll>
        <li>
            <form action="/poll" method="get">
                <button type="submit" class="link-button" value="${poll.getId()}" name="pollid">${poll.getTitle()}
                </button>
                <style>
                    .link-button{
                        border: none;
                        background: none;
                    }
                </style>
            </form>
        </li>
    </#list>
</ul>
</body>
</html>