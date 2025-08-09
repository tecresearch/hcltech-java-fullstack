// Create and add initial style sheet
const initialStyles = `
* {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}
body {
    font-family: Arial, sans-serif;
    margin: 0;
    display: flex;
    flex-direction: column;
    min-height: 100vh;
    background-color: #f5f5f5;
}
header, footer {
    background-color: #007bff;
    color: #fff;
    text-align: center;
    padding: 1rem;
}
header {
    position: fixed;
    width: 100%;
    top: 0;
    left: 0;
    z-index: 1000;
}
footer {
    position: fixed;
    width: 100%;
    bottom: 0;
    left: 0;
}
nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
}
#hamburger {
    display: none;
}
#sidebar {
    position: fixed;
    top: 0;
    left: -250px;
    width: 250px;
    height: 100%;
    background-color: #333;
    color: #fff;
    transition: left 0.3s ease;
    padding: 1rem;
    box-shadow: 2px 0 5px rgba(0, 0, 0, 0.2);
}
#sidebar a {
    color: #fff;
    text-decoration: none;
    display: block;
    padding: 0.5rem 0;
}
#sidebar a:hover {
    background-color: #575757;
}
#main {
    flex: 1;
    display: flex;
    flex-direction: column;
    margin-left: 0;
    transition: margin-left 0.3s ease;
    padding: 1rem;
}
#sidebar.active {
    left: 0;
}
#main.active {
    margin-left: 250px;
}
#content {
    padding: 1rem;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
button {
    background-color: #007bff;
    border: none;
    border-radius: 4px;
    color: #fff;
    cursor: pointer;
    padding: 0.5rem 1rem;
    font-size: 1rem;
    margin: 0.5rem;
    transition: background-color 0.3s ease;
}
button:hover {
    background-color: #0056b3;
}
.new-div {
    background-color: #e2e2e2;
    border: 1px solid #ccc;
    border-radius: 4px;
    padding: 1rem;
    margin-top: 1rem;
    transition: background-color 0.3s ease, transform 0.3s ease;
}
.new-div:hover {
    background-color: #d0d0d0;
    transform: scale(1.05);
}
#hamburger {
    display: block;
    cursor: pointer;
    font-size: 1.5rem;
    padding: 0.5rem;
}
img {
    max-width: 100%;
    height: auto;
}
@media (max-width: 768px) {
    #sidebar {
        width: 200px;
    }
    #hamburger {
        display: block;
    }
    #main.active {
        margin-left: 200px;
    }
}
`;

// Create and append the style element
const styleSheet = document.createElement('style');
styleSheet.type = 'text/css';
styleSheet.innerText = initialStyles;
document.head.appendChild(styleSheet);

// Create HTML elements
const header = document.createElement('header');
const nav = document.createElement('nav');
const logo = document.createElement('div');
logo.textContent = 'Logo';
logo.style.fontSize = '1.5rem';

const hamburger = document.createElement('div');
hamburger.id = 'hamburger';
hamburger.textContent = '☰';

const mainNav = document.createElement('div');
mainNav.innerHTML = `
    <a href="#">Home</a>
    <a href="#">About</a>
    <a href="#">Services</a>
    <a href="#">Contact</a>
`;

nav.appendChild(logo);
nav.appendChild(mainNav);
nav.appendChild(hamburger);
header.appendChild(nav);

const sidebar = document.createElement('aside');
sidebar.id = 'sidebar';
sidebar.innerHTML = `
    <a href="#">Home</a>
    <a href="#">About</a>
    <a href="#">Services</a>
    <a href="#">Contact</a>
`;

const main = document.createElement('div');
main.id = 'main';

const content = document.createElement('div');
content.id = 'content';

const footer = document.createElement('footer');
footer.textContent = 'Footer Content';

// Append elements to the DOM
document.body.appendChild(header);
document.body.appendChild(sidebar);
document.body.appendChild(main);
main.appendChild(content);
document.body.appendChild(footer);

// Event Listener for hamburger menu
hamburger.addEventListener('click', () => {
    sidebar.classList.toggle('active');
    main.classList.toggle('active');
});

// Event Listener for changing style
const changeStyleBtn = document.createElement('button');
changeStyleBtn.id = 'changeStyleBtn';
changeStyleBtn.textContent = 'Change Style';
content.appendChild(changeStyleBtn);

changeStyleBtn.addEventListener('click', () => {
    // Remove old style
    const oldStyle = document.querySelector('style');
    if (oldStyle) {
        document.head.removeChild(oldStyle);
    }
    
    // Add new style
    const newStyles = `
    body {
        background-color: #fafafa;
    }
    #container {
        background-color: #f0f0f0;
        border: 2px solid #007bff;
        transition: background-color 0.5s ease, border-color 0.5s ease;
    }
    .new-div {
        border: 1px solid #333;
        background-color: #d9d9d9;
        font-style: italic;
    }
    .new-div:hover {
        background-color: #c0c0c0;
        transform: scale(1.05);
    }
    `;
    
    const newStyleSheet = document.createElement('style');
    newStyleSheet.type = 'text/css';
    newStyleSheet.innerText = newStyles;
    document.head.appendChild(newStyleSheet);
});

// Event Listener for adding new div
const addDivBtn = document.createElement('button');
addDivBtn.id = 'addDivBtn';
addDivBtn.textContent = 'Add New Div';
content.appendChild(addDivBtn);

addDivBtn.addEventListener('click', () => {
    // Create new div
    const newDiv = document.createElement('div');
    newDiv.className = 'new-div';
    newDiv.textContent = 'I am a new div!';
    
    // Append new div to content
    content.appendChild(newDiv);
    
    // Log DOM elements and methods
    console.log('DOM Manipulation:');
    console.log(`Parent Node: ${content.parentNode}`);
    console.log(`Child Nodes: ${content.childNodes.length}`);
    console.log(`First Child: ${content.firstChild}`);
    console.log(`Last Child: ${content.lastChild}`);
});

// Event Listener for removing last div
const removeDivBtn = document.createElement('button');
removeDivBtn.id = 'removeDivBtn';
removeDivBtn.textContent = 'Remove Last Div';
content.appendChild(removeDivBtn);

removeDivBtn.addEventListener('click', () => {
    if (confirm('Are you sure you want to remove the last div?')) {
        const divs = content.getElementsByClassName('new-div');
        if (divs.length > 0) {
            const lastDiv = divs[divs.length - 1];
            content.removeChild(lastDiv);
        }
    }
});

// Feature 1: Add an animation to the new divs
const keyframes = `
@keyframes bounce {
    0%, 20%, 50%, 80%, 100% {
        transform: translateY(0);
    }
    40% {
        transform: translateY(-30px);
    }
    60% {
        transform: translateY(-15px);
    }
}
.new-div {
    animation: bounce 2s infinite;
}
`;

const animationStyleSheet = document.createElement('style');
animationStyleSheet.type = 'text/css';
animationStyleSheet.innerText = keyframes;
document.head.appendChild(animationStyleSheet);

// Feature 2: Add a border to the container on mouse hover
main.addEventListener('mouseover', () => {
    main.style.border = '3px solid #ff6347'; // Tomato color
});
main.addEventListener('mouseout', () => {
    main.style.border = 'none'; // Remove border
});

// Feature 3: Toggle visibility of the sidebar
const toggleSidebarBtn = document.createElement('button');
toggleSidebarBtn.id = 'toggleSidebarBtn';
toggleSidebarBtn.textContent = 'Toggle Sidebar';
main.appendChild(toggleSidebarBtn);

toggleSidebarBtn.addEventListener('click', () => {
    sidebar.classList.toggle('active');
    main.classList.toggle('active');
});

// Feature 4: Add a tooltip to the button
const addTooltip = (element, message) => {
    element.setAttribute('title', message);
};
addTooltip(changeStyleBtn, 'Click to change the style');
addTooltip(addDivBtn, 'Click to add a new div');
addTooltip(removeDivBtn, 'Click to remove the last div');

// Feature 5: Highlight header on click
header.addEventListener('click', () => {
    header.style.backgroundColor = '#f0e68c'; // Khaki color
    setTimeout(() => {
        header.style.backgroundColor = '';
    }, 1000);
});


// Feature 7: Add an input field with a button to change header text
const inputField = document.createElement('input');
inputField.type = 'text';
inputField.placeholder = 'Enter new header text';
const updateHeaderBtn = document.createElement('button');
updateHeaderBtn.textContent = 'Update Header';
content.appendChild(inputField);
content.appendChild(updateHeaderBtn);

updateHeaderBtn.addEventListener('click', () => {
    const newText = inputField.value;
    if (newText.trim()) {
        logo.textContent = newText;
    }
});

// Feature 8: Store added divs in an array and log them
const addedDivs = [];
addDivBtn.addEventListener('click', () => {
    const newDiv = document.createElement('div');
    newDiv.className = 'new-div';
    newDiv.textContent = 'I am a new div!';
    
    content.appendChild(newDiv);
    addedDivs.push(newDiv);
    console.log('Added Divs:', addedDivs);
});

// Feature 9: Change button text color on hover
const buttons = document.querySelectorAll('button');
buttons.forEach(button => {
    button.addEventListener('mouseover', () => {
        button.style.color = '#000';
    });
    button.addEventListener('mouseout', () => {
        button.style.color = '#fff';
    });
});

// Feature 10: Add a confirmation dialog before removing a div
removeDivBtn.addEventListener('click', () => {
    if (confirm('Are you sure you want to remove the last div?')) {
        const divs = content.getElementsByClassName('new-div');
        if (divs.length > 0) {
            const lastDiv = divs[divs.length - 1];
            content.removeChild(lastDiv);
        }
    }
});

// Feature 11: Change background image on button click
const changeBgImageBtn = document.createElement('button');
changeBgImageBtn.id = 'changeBgImageBtn';
changeBgImageBtn.textContent = 'Change Background Image';
content.appendChild(changeBgImageBtn);

changeBgImageBtn.addEventListener('click', () => {
    document.body.style.backgroundImage = 'url(https://via.placeholder.com/1920x1080)';
    document.body.style.backgroundSize = 'cover';
    document.body.style.backgroundPosition = 'center';
});

// Feature 12: Add a modal popup with a close button
const modal = document.createElement('div');
modal.id = 'modal';
modal.style.position = 'fixed';
modal.style.top = '50%';
modal.style.left = '50%';
modal.style.transform = 'translate(-50%, -50%)';
modal.style.backgroundColor = '#fff';
modal.style.padding = '1rem';
modal.style.boxShadow = '0 0 10px rgba(0, 0, 0, 0.3)';
modal.style.display = 'none';
modal.innerHTML = `
    <p>This is a modal popup.</p>
    <button id="closeModalBtn">Close</button>
`;
document.body.appendChild(modal);

const showModalBtn = document.createElement('button');
showModalBtn.textContent = 'Show Modal';
content.appendChild(showModalBtn);

showModalBtn.addEventListener('click', () => {
    modal.style.display = 'block';
});

document.getElementById('closeModalBtn').addEventListener('click', () => {
    modal.style.display = 'none';
});

// Feature 13: Add a progress bar
const progressBarContainer = document.createElement('div');
progressBarContainer.style.width = '100%';
progressBarContainer.style.backgroundColor = '#e0e0e0';
progressBarContainer.style.borderRadius = '4px';
progressBarContainer.style.overflow = 'hidden';
const progressBar = document.createElement('div');
progressBar.style.height = '20px';
progressBar.style.backgroundColor = '#007bff';
progressBar.style.width = '0%';
progressBarContainer.appendChild(progressBar);
content.appendChild(progressBarContainer);

const startProgressBtn = document.createElement('button');
startProgressBtn.textContent = 'Start Progress';
content.appendChild(startProgressBtn);

startProgressBtn.addEventListener('click', () => {
    let width = 0;
    const interval = setInterval(() => {
        if (width >= 100) {
            clearInterval(interval);
        } else {
            width += 1;
            progressBar.style.width = width + '%';
        }
    }, 50);
});

// Feature 14: Add a random quote generator
// Assuming 'content' is already defined and is a reference to your container element
const quoteBtn = document.createElement('button');
quoteBtn.textContent = 'Generate Random Quote';
content.appendChild(quoteBtn);

const quoteDisplay = document.createElement('div');
quoteDisplay.id = 'quoteDisplay';
content.appendChild(quoteDisplay);

// Function to fetch and display a random quote
function fetchQuotes() {
    fetch('https://dummyjson.com/quotes')
        .then(response => response.json())
        .then(data => {
            const quotes = data.quotes; // Access the array of quotes from the API response
            const randomIndex = Math.floor(Math.random() * quotes.length); // Get a random index
            const quote = quotes[randomIndex]; // Get the quote at the random index
            quoteDisplay.textContent = `"${quote.quote}" — ${quote.author}`; // Display the quote
        })
        .catch(error => console.error('Error fetching quotes:', error)); // Handle any errors
}

// Add event listener to the button to fetch and display a random quote
quoteBtn.addEventListener('click', fetchQuotes);

// Optionally, you can fetch a quote when the page loads
window.onload = fetchQuotes;


// Feature 15: Add a clock displaying the current time
const clock = document.createElement('div');
clock.id = 'clock';
clock.style.fontSize = '2rem';
clock.style.marginTop = '1rem';
content.appendChild(clock);

const updateClock = () => {
    const now = new Date();
    clock.textContent = now.toLocaleTimeString();
};
setInterval(updateClock, 1000);
updateClock();

// Feature 16: Change header logo on button click
const changeLogoBtn = document.createElement('button');
changeLogoBtn.textContent = 'Change Logo';
content.appendChild(changeLogoBtn);

changeLogoBtn.addEventListener('click', () => {
    logo.textContent = 'New Logo';
    logo.style.color = '#ff6347'; // Tomato color
});

// Feature 17: Add a color picker to change the background color of new divs
const colorPicker = document.createElement('input');
colorPicker.type = 'color';
content.appendChild(colorPicker);

colorPicker.addEventListener('input', (event) => {
    const color = event.target.value;
    document.querySelectorAll('.new-div').forEach(div => {
        div.style.backgroundColor = color;
    });
});

// Feature 18: Add a character counter for input field
const charCounter = document.createElement('div');
charCounter.id = 'charCounter';
charCounter.style.marginTop = '1rem';
content.appendChild(charCounter);

inputField.addEventListener('input', () => {
    charCounter.textContent = `Character count: ${inputField.value.length}`;
});

// Feature 19: Add a dropdown menu
const dropdown = document.createElement('select');
dropdown.innerHTML = `
    <option value="">Select an option</option>
    <option value="1">Option 1</option>
    <option value="2">Option 2</option>
    <option value="3">Option 3</option>
`;
content.appendChild(dropdown);

// Feature 20: Add a text area with a word counter
const textArea = document.createElement('textarea');
textArea.rows = 4;
textArea.cols = 50;
content.appendChild(textArea);

const wordCounter = document.createElement('div');
wordCounter.id = 'wordCounter';
wordCounter.style.marginTop = '1rem';
content.appendChild(wordCounter);

textArea.addEventListener('input', () => {
    const wordCount = textArea.value.split(/\s+/).filter(Boolean).length;
    wordCounter.textContent = `Word count: ${wordCount}`;
});

// Feature 21: Add a "Scroll to Top" button
const scrollToTopBtn = document.createElement('button');
scrollToTopBtn.textContent = 'Scroll to Top';
scrollToTopBtn.style.position = 'fixed';
scrollToTopBtn.style.bottom = '1rem';
scrollToTopBtn.style.right = '1rem';
scrollToTopBtn.style.display = 'none';
document.body.appendChild(scrollToTopBtn);

scrollToTopBtn.addEventListener('click', () => {
    window.scrollTo({ top: 0, behavior: 'smooth' });
});

window.addEventListener('scroll', () => {
    if (window.scrollY > 200) {
        scrollToTopBtn.style.display = 'block';
    } else {
        scrollToTopBtn.style.display = 'none';
    }
});

// Feature 22: Add a date picker
const datePicker = document.createElement('input');
datePicker.type = 'date';
content.appendChild(datePicker);

// Feature 23: Add a file upload input
const fileInput = document.createElement('input');
fileInput.type = 'file';
content.appendChild(fileInput);

// Feature 24: Add a responsive grid layout
const gridContainer = document.createElement('div');
gridContainer.style.display = 'grid';
gridContainer.style.gridTemplateColumns = 'repeat(auto-fill, minmax(150px, 1fr))';
gridContainer.style.gap = '1rem';
gridContainer.style.marginTop = '1rem';
content.appendChild(gridContainer);

const addGridItemBtn = document.createElement('button');
addGridItemBtn.textContent = 'Add Grid Item';
content.appendChild(addGridItemBtn);

addGridItemBtn.addEventListener('click', () => {
    const gridItem = document.createElement('div');
    gridItem.style.backgroundColor = '#007bff';
    gridItem.style.color = '#fff';
    gridItem.style.padding = '1rem';
    gridItem.textContent = 'Grid Item';
    gridItem.style.borderRadius = '4px';
    gridContainer.appendChild(gridItem);
});

// Feature 25: Add a search bar
const searchBar = document.createElement('input');
searchBar.type = 'text';
searchBar.placeholder = 'Search...';
content.appendChild(searchBar);

// Feature 26: Add a sidebar menu with icons
const sidebarMenu = document.createElement('div');
sidebarMenu.id = 'sidebarMenu';
sidebarMenu.innerHTML = `
    <a href="#" class="menu-item">🏠 Home</a>
    <a href="#" class="menu-item">📄 About</a>
    <a href="#" class="menu-item">🛠️ Services</a>
    <a href="#" class="menu-item">📞 Contact</a>
`;
sidebar.appendChild(sidebarMenu);

// Feature 27: Add a responsive image gallery
const galleryContainer = document.createElement('div');
galleryContainer.style.display = 'grid';
galleryContainer.style.gridTemplateColumns = 'repeat(auto-fill, minmax(150px, 1fr))';
galleryContainer.style.gap = '1rem';
galleryContainer.style.marginTop = '1rem';
content.appendChild(galleryContainer);

const addImageBtn = document.createElement('button');
addImageBtn.textContent = 'Add Image';
content.appendChild(addImageBtn);

addImageBtn.addEventListener('click', () => {
    const img = document.createElement('img');
    img.src = 'https://via.placeholder.com/150';
    img.alt = 'Gallery Image';
    img.style.width = '100%';
    img.style.borderRadius = '4px';
    galleryContainer.appendChild(img);
});

// Feature 28: Add a tooltip to the sidebar menu items
const menuItems = document.querySelectorAll('#sidebarMenu .menu-item');
menuItems.forEach(item => {
    addTooltip(item, `This is the ${item.textContent.trim()} section`);
});

// Feature 29: Add a "Toggle Dark Mode" button
const darkModeBtn = document.createElement('button');
darkModeBtn.textContent = 'Toggle Dark Mode';
content.appendChild(darkModeBtn);

darkModeBtn.addEventListener('click', () => {
    document.body.classList.toggle('dark-mode');
});

// Add Dark Mode Styles
const darkModeStyles = `
.dark-mode {
    background-color: #121212;
    color: #e0e0e0;
}
.dark-mode header, .dark-mode footer {
    background-color: #1f1f1f;
}
.dark-mode #sidebar {
    background-color: #2c2c2c;
}
.dark-mode .new-div {
    background-color: #333;
    border: 1px solid #666;
}
`;
const darkModeStyleSheet = document.createElement('style');
darkModeStyleSheet.type = 'text/css';
darkModeStyleSheet.innerText = darkModeStyles;
document.head.appendChild(darkModeStyleSheet);

// Feature 30: Add a "Show/Hide Sidebar" toggle button
const showHideSidebarBtn = document.createElement('button');
showHideSidebarBtn.textContent = 'Show/Hide Sidebar';
content.appendChild(showHideSidebarBtn);

showHideSidebarBtn.addEventListener('click', () => {
    sidebar.classList.toggle('active');
});
