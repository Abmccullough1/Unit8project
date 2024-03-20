// Function to fetch and populate developers list
function fetchAndPopulateDevelopersList() {
    fetch('http://localhost:8080/devs')
        .then(response => response.json())
        .then(data => {
            const developersList = document.getElementById('developers-list');
            developersList.innerHTML = ''; // Clear previous content
            data.forEach(developer => {
                const listItem = document.createElement('li');
                listItem.textContent = developer.devName;
                developersList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error fetching developers data:', error));
}

// Function to fetch and populate games list
function fetchAndPopulateGamesList() {
    fetch('http://localhost:8080/games')
        .then(response => response.json())
        .then(data => {
            const gamesList = document.getElementById('games-list');
            gamesList.innerHTML = ''; // Clear previous content
            data.forEach(game => {
                const listItem = document.createElement('li');
                listItem.textContent = game.gameTitle;
                gamesList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error fetching games data:', error));
}

// Function to fetch and populate players list
function fetchAndPopulatePlayersList() {
    fetch('http://localhost:8080/players')
        .then(response => response.json())
        .then(data => {
            const playersList = document.getElementById('players-list');
            playersList.innerHTML = ''; // Clear previous content
            data.forEach(player => {
                const listItem = document.createElement('li');
                listItem.textContent = player.playerName;
                playersList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error fetching players data:', error));
}

// Event listener for adding a developer
document.getElementById('add-developer-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const developerName = document.getElementById('developer-name').value;
    fetch('http://localhost:8080/devs', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ devName: developerName })
    })
        .then(response => {
            if (response.ok) {
                fetchAndPopulateDevelopersList(); // Refresh developers list
            } else {
                console.error('Failed to add developer');
            }
        })
        .catch(error => console.error('Error adding developer:', error));
});

// Event listener for adding a game
document.getElementById('add-game-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const gameTitle = document.getElementById('game-title').value;
    fetch('http://localhost:8080/games', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ gameTitle: gameTitle })
    })
        .then(response => {
            if (response.ok) {
                fetchAndPopulateGamesList(); // Refresh games list
            } else {
                console.error('Failed to add game');
            }
        })
        .catch(error => console.error('Error adding game:', error));
});

// Event listener for adding a player
document.getElementById('add-player-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const playerName = document.getElementById('player-name').value;
    fetch('http://localhost:8080/players', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ playerName: playerName })
    })
        .then(response => {
            if (response.ok) {
                fetchAndPopulatePlayersList();
            } else {
                console.error('Failed to add player');
            }
        })
        .catch(error => console.error('Error adding player:', error));
});

window.addEventListener('load', function() {
    fetchAndPopulateDevelopersList();
    fetchAndPopulateGamesList();
    fetchAndPopulatePlayersList();
});
