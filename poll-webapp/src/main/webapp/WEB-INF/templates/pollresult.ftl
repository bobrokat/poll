<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>pollresults</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<h1>Results:</h1>
<ul>
<#list pollChoices as choice>
    <li><b>${choice.getChoice_text()}</b> -  ${choice.getVotes()}</li>
</#list>
</ul>

<a href="/polls" >Back to polls</a>

</body>
</html>