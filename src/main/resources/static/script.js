// Function to fetch developers and players data from the server and populate dropdowns
function fetchDataAndPopulateDropdowns() {
    // Fetch developers
    fetch('/devs')
        .then(response => response.json())
        .then(data => {
            const developerDropdown = document.getElementById('developer');
            developerDropdown.innerHTML = '';
            data.forEach(developer => {
                const option = document.createElement('option');
                option.value = developer.id;
                option.textContent = developer.devName;
                developerDropdown.appendChild(option);
            });
        })
        .catch(error => console.error('Error fetching developers:', error));

    // Fetch players
    fetch('/players')
        .then(response => response.json())
        .then(data => {
            const playersDropdown = document.getElementById('players');
            playersDropdown.innerHTML = '';
            data.forEach(player => {
                const option = document.createElement('option');
                option.value = player.id;
                option.textContent = player.playerName;
                playersDropdown.appendChild(option);
            });
        })
        .catch(error => console.error('Error fetching players:', error));
}

// Handle form submission for adding a new developer
document.getElementById('add-developer-form').addEventListener('submit', event => {
    event.preventDefault();

    const formData = new FormData(event.target);
    const developerName = formData.get('new-developer-name');

    // Send the data to the server
    fetch('/devs', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ devName: developerName })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to add developer');
            }
            return response.json();
        })
        .then(data => {
            // Handle success
            console.log('Developer added successfully:', data);
            // Refresh developers dropdown
            fetchDataAndPopulateDropdowns();
            // Reset form
            event.target.reset();
        })
        .catch(error => {
            // Handle error
            console.error('Failed to add developer:', error);
        });
});

// Handle form submission for adding a new player
document.getElementById('add-player-form').addEventListener('submit', event => {
    event.preventDefault();

    const formData = new FormData(event.target);
    const playerName = formData.get('new-player-name');

    // Send the data to the server
    fetch('/players', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ playerName: playerName })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to add player');
            }
            return response.json();
        })
        .then(data => {
            // Handle success
            console.log('Player added successfully:', data);
            // Refresh players dropdown
            fetchDataAndPopulateDropdowns();
            // Reset form
            event.target.reset();
        })
        .catch(error => {
            // Handle error
            console.error('Failed to add player:', error);
        });
});

// Handle form submission for adding a new game
document.getElementById('add-game-form').addEventListener('submit', event => {
    event.preventDefault();

    const formData = new FormData(event.target);
    const gameTitle = formData.get('game-title');
    const developerId = formData.get('developer');
    const playerIds = formData.getAll('players');

    const requestBody = {
        gameTitle: gameTitle,
        developerId: developerId,
        playerIds: playerIds
    };

    // Send the data to the server
    fetch('/games', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestBody)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to add game');
            }
            return response.json();
        })
        .then(data => {
            // Handle success
            console.log('Game added successfully:', data);
        })
        .catch(error => {
            // Handle error
            console.error('Failed to add game:', error);
        });
});

// Fetch data and populate dropdowns on page load
window.addEventListener('load', () => {
    fetchDataAndPopulateDropdowns();
});
