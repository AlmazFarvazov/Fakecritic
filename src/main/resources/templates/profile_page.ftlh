<#ftl encoding="UTF-8"/>
<#import "spring.ftl" as spring/>

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
                                <img src="<@spring.url'${account.photo.source}'/>" id="imgProfile" style="width: 150px; height: 150px" class="img-thumbnail"  alt="photo"/>
                            </div>
                            <div class="gameData ml-3">
                                <h2 class="d-block" style="font-size: 1.5rem; font-weight: bold">${account.nickname}</h2>
                                <h6 class="d-block"><label style="font-weight:bold;">Email: </label> ${account.email}</h6>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>
<@footer.footer/>