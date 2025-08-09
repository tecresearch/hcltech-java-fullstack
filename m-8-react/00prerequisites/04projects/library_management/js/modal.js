// Modal element
const modal = document.getElementById('loginModal');

// Close button element
const closeButton = document.querySelector('.close-button');

// Show modal on page load
window.onload = function() {
    modal.style.display = 'block';
};

// Close the modal when the user clicks the close button
closeButton.onclick = function() {
    modal.style.display = 'none';
};

// Close the modal if the user clicks outside of the modal content
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = 'none';
    }
};
