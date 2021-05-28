<#ftl encoding="UTF-8"/>
<#import "/spring.ftl" as spring/>
<#macro header>
<header>
    <nav class="navbar navbar-expand-xl navbar-dark bg-dark">
        <div class="container">
        <a class="navbar-brand" href="<@spring.url"/news"/>">FAKECRITIC</a>
            <div class="container justify-content-center">
                <form class="d-flex">
                    <input class="form-control mr-2" id="search-input" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-warning" type="submit">Search</button>
                </form>
            </div>
        <div class="navbar align-items-end" id="navbarScroll">
            <ul class="navbar-nav mr-auto my-2 navbar-nav-scroll" style="max-height: 100px;">
                <li class="nav-item">
                    <a class="nav-link" href="<@spring.url'/profile'/>">Profile</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
                        Games
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                        <#list genres as genre>
                            <li><a class="dropdown-item" href="<@spring.url'/games/${genre.name}'/>" data-link="genre">${genre.name}</a></li>
                        </#list>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="<@spring.url'/genre'/>">All</a>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="btn btn-outline-secondary" href="<@spring.url'/logout'/>">EXIT</a>
                </li>
            </ul>
        </div>
        </div>
    </nav>
</header>
</#macro>