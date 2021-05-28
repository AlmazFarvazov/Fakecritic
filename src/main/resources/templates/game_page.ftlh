<#ftl encoding="UTF-8"/>
<#import "/spring.ftl" as spring/>

<#import "macroses/_head.ftlh" as head>
<#import "macroses/_header.ftlh" as header>
<#import "macroses/_footer.ftlh" as footer>

<@head.head/>
<@header.header/>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card">

                <div class="card-body">
                    <div class="card-title mb-4">
                        <div class="d-flex justify-content-start">
                            <div class="image-container">
                                <img src="'<@spring.url'${game.logo.source}'/>'" id="imgProfile" style="width: 150px; height: 150px" class="img-thumbnail"  alt="logo"/>
                            </div>
                            <div class="gameData ml-3">
                                <h2 class="d-block" style="font-size: 1.5rem; font-weight: bold">${game.title}</h2>
                                <h6 class="d-block"><label style="font-weight:bold;">Developer: </label> ${game.developer.name}</h6>
                                <h6 class="d-block"><label style="font-weight:bold;">Score: </label> ${game.score}</h6>
                                <h6 class="d-block"><label style="font-weight:bold;">Genres: </label>
                                    <#list gameGenres as genre>
                                        <a href="<@spring.url'/games/${genre.name}'/>">${genre.name} </a>
                                    </#list>
                                </h6>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <div class="row">
                                <div class="col-sm-3 col-md-2 col-5">
                                    <label style="font-weight:bold;">Summary</label>
                                </div>
                                <div class="col-md-8 col-6">
                                    ${game.summary}
                                </div>
                            </div>
                            <hr />

                            <div class="row">
                                <div class="col-sm-3 col-md-2 col-5">
                                    <label style="font-weight:bold;">Released</label>
                                </div>
                                <div class="col-md-8 col-6">
                                    ${game.releaseDate}
                                </div>
                            </div>
                            <hr />

                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>
<@footer.footer/>