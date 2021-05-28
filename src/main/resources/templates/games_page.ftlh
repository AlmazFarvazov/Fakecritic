<#ftl encoding="UTF-8"/>
<#import "/spring.ftl" as spring/>

<#import "macroses/_head.ftlh" as head>
<#import "macroses/_header.ftlh" as header>
<#import "macroses/_footer.ftlh" as footer>

<@head.head/>
<@header.header/>

    <div class="container">
        <div class="row row-cols-4 align-items-start" id="gamesContainer">
<#--            <#list games as game>-->
<#--                <div class="card m-1 game-card" style="width: 18rem;">-->
<#--                    <img src="<@spring.url'${game.logo.source}'/>" class="card-img-top" alt="logo">-->
<#--                    <div class="card-body">-->
<#--                        <h5 class="card-title">${game.title}</h5>-->
<#--                        <p class="card-text">${game.summary}</p>-->
<#--                        <a href="<@spring.url'/game/${game.title}'/>" class="btn btn-primary">More...</a>-->
<#--                    </div>-->
<#--                </div>-->
<#--            </#list>-->
        </div>
    </div>

<@footer.footer/>