$(function() {
    handleChangeGenre();
    const genreLinks = $('*[data-link="genre"]');
    genreLinks.click(handleChangeGenre);

    const gamesContainer = $('#gamesContainer');

    function handleChangeGenre(e) {
        if (e) {
            e.preventDefault();
        }
        const link = e ? `/games/${$(this).attr('href').split('/')[2]}` : '/games';

        $.ajax({
            type: "GET",
            url: link,
            success: function (games) {
                gamesContainer.empty();
                games.forEach(function(game) {
                    const template = generateGameHtml(game);
                    gamesContainer.append(template);
                });
            },
            error: function (err) {
                console.log(err)
            }
        });
    }

    function generateGameHtml(game) {
        return `<div class="card m-1 game-card" style="width: 18rem;">
                    <img src="${game.logo.source}" class="card-img-top" alt="logo">
                    <div class="card-body">
                        <h5 class="card-title">${game.title}</h5>
                        <p class="card-text">${game.summary}</p>
                        <a href="/game/${game.title}" class="btn btn-primary">More...</a>
                    </div>
                </div>`
    }
})