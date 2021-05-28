<#ftl encoding="UTF-8"/>
<#import "/spring.ftl" as spring/>
<#macro head>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>
        <link rel="stylesheet" type="text/css" href="<@spring.url'/static/styles/font-awesome.min.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url'/static/styles/bootstrap.min.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<@spring.url'/static/styles/main_page.css'/>"/>

        <script type="text/javascript" src="<@spring.url'/static/scripts/popper.min.js'/>"/></script>
        <script type="text/javascript" src="<@spring.url'/static/scripts/jquery-3.5.1.min.js'/>"></script>
        <script type="text/javascript" src="<@spring.url'/static/scripts/bootstrap.bundle.min.js'/>"></script>
        <script type="text/javascript" src="<@spring.url'/static/scripts/bootstrap.min.js'/>"></script>
        <script type="text/javascript" src="<@spring.url'/static/scripts/script.js'/>"></script>
    </head>
    <body>
</#macro>