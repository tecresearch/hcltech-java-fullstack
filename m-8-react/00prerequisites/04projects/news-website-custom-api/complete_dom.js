
function insertCssFileUsingJs(){
  // // Defining CSS as a string
const My_CSS = `
    * {
        padding: 0;
        margin: 0;
        box-sizing: border-box; /* Ensures consistent sizing across elements */
    }

    body {
        background-color: black; /* Sets background color to black */
        font-family: Arial, sans-serif; /* Sets default font family */
    }

    #root {
        width: 100vw; /* Full width of the viewport */
        display: flex; /* Use flexbox for layout */
        flex-direction: column; /* Arrange child elements vertically */
        justify-content: center; /* Center elements vertically */
        align-items: center; /* Center elements horizontally */
    }

    nav ul {
        display: flex; /* Flex layout for the navigation links */
        justify-content: start; /* Align links to the start (left) */
        align-items: center; /* Vertically center links */
        gap: 1rem; /* Space between each link */
    }

    a {
        color: white; /* Sets link color to white */
        text-decoration: none; /* Removes the underline from links */
    }

    a:hover {
        color: yellow; /* Changes link color to yellow on hover */
        text-decoration: underline; /* Underlines the link on hover */
        transition: 0.4s ease-in-out; /* Smooth transition for hover effect */
    }

    header {
        width: 100vw; /* Header width slightly less than full viewport */
        height: 60px; /* Fixed height for the header */
        display: flex; /* Flexbox layout */
        justify-content: space-between; /* Space between logo and navbar */
        align-items: center; /* Vertically center content */
        background-color: lightblue; /* Header background color */
        padding: 10px 20px; /* Padding inside header */
    }

    .MyLogo {
        color: white; /* Logo text color */
        font-size: 24px; /* Font size for the logo */
        font-weight: bold; /* Makes the logo text bold */
    }

    .hero {
        width: 100vw; /* Full width of viewport for hero section */
        height: 140px; /* Height of hero section */
        background-color: black; /* Background color for hero */
        opacity: 0.5; /* Semi-transparent effect */
        border: 1px solid white; /* White border around hero */
    }

    #mainContent {
        display: flex; /* Flex layout for the main content */
        width: 100vw; /* Full width of viewport */
        background-color: white; /* White background for main content */
        padding: 20px; /* Padding inside main content */
        gap: 20px; /* Space between sidebar and main section */
    }

    .sidebar {
        width: 20%; /* Sidebar takes 20% of the width */
        display: flex; /* Flex layout */
        flex-direction: column; /* Stack elements vertically */
        gap: 10px; /* Space between notice and news sections */
    }

    .notice, .news {
        background-color: #f1f1f1; /* Light background color */
        padding: 20px; /* Padding inside notice and news */
        border-left: 2px solid gray; /* Gray border on the left */
        border-radius: 20px 0 0 0; /* Rounded top-left corner */
    }

    .mainSection {
        width: 75%; /* Main section takes 75% of the width */
        background-color: #f9f9f9; /* Light background for the main section */
        padding: 20px; /* Padding inside the main section */
        border-left: 2px solid gray; /* Left border for visual separation */
        border-radius: 20px 0 0 0; /* Rounded top-left corner */
    }

    #footerContent {
        width: 100vw; /* Full width footer */
        height: 50px; /* Fixed height for the footer */
        background-color: black; /* Footer background color */
        opacity: 0.7; /* Semi-transparent footer */
        color: white; /* White text color */
        display: flex; /* Flex layout */
        justify-content: center; /* Center content horizontally */
        align-items: center; /* Center content vertically */
    }
`;

// Injecting CSS into the DOM
const styleSheet = document.createElement('style'); // Create a <style> tag
styleSheet.type = 'text/css'; // Set the type to CSS
styleSheet.innerText = My_CSS; // Add CSS string as the content
document.head.appendChild(styleSheet); // Append <style> tag to the <head>

}

// Creating the logo section
const logo = document.createElement('h1'); // Create an h1 element for the logo
logo.className = "MyLogo"; // Set class for styling
logo.textContent = "TCA News"; // Set logo text

// Creating the navbar
const navLinks = ` 
    <a href="#">Home</a>
    <a href="#">About</a>
    <a href="#">Services</a>
    <a href="#">Contact</a>
    <a href="#">Register</a>
    <a href="#">Login</a>`; // Define the navbar links as HTML string
const navbar = document.createElement('nav'); // Create a <nav> element
const navList = document.createElement('ul'); // Create an unordered list <ul>
navList.innerHTML = navLinks; // Insert the links into the <ul>
navbar.appendChild(navList); // Append the list to the navbar

// Creating the root div
const rootDiv = document.createElement('div'); // Create a div for the root container
rootDiv.id = "root"; // Assign ID to the root for styling

// Creating the hero section
const heroSection = document.createElement('div'); // Create a div for the hero section
heroSection.className = "hero"; // Set class for styling

// Creating the main content
const main = document.createElement('div'); // Create a div for the main content
main.id = "mainContent"; // Assign ID for styling

// Creating sidebar (left)
const sidebar = document.createElement('div'); // Create a div for the sidebar
sidebar.className = "sidebar"; // Set class for styling

// Creating notice section for the sidebar
const notice = document.createElement('div'); // Create a div for the notice section
notice.className = "notice"; // Set class for styling
notice.innerHTML = `
    <h3>Notice</h3>
    <ul>
        <li>Exam Schedule Released</li>
        <li>Holiday on 15th Sep</li>
        <li>New Courses Available</li>
        <li>Library Updated</li>
    </ul>`; // Set the content for the notice section

// Creating news section for the sidebar
const news = document.createElement('div'); // Create a div for the news section
news.className = "news"; // Set class for styling
news.innerHTML = `
    <h3>Latest News</h3>
    <ul>
        <li>Tech Conference 2024</li>
        <li>AI Seminar Coming Soon</li>
        <li>New Campus Facilities</li>
        <li>Startup Incubation</li>
    </ul>`; // Set the content for the news section

// Appending notice and news to sidebar
sidebar.appendChild(notice); // Add notice section to the sidebar
sidebar.appendChild(news); // Add news section to the sidebar




// Creating main section
const mainSection = document.createElement('div'); // Create a div for the main section
mainSection.className = "mainSection"; // Set class for styling

// Function to fetch news
const fetchNews = async () => {
  try {
    const response = await fetch('customApi/todayNews.json');
    if (response.ok) {
      return await response.json();
    } else {
      console.log("Error fetching news");
    }
  } catch {
    console.log("Something went wrong...");
  }
};


// Function to display articles based on category
const displayNewsByCategory = async (category) => {
  const data = await fetchNews();

  // Find the news category
  const categoryData = data.news.find(newsCategory => newsCategory.category === category);

  if (categoryData) {
    // Map through the articles and return HTML for each article
    const articlesHTML = categoryData.articles.map((article) => {
      return `
        <div class="card">
        
          <img src="${article.imageUrl ? article.imageUrl : 'customApi/img/default.jfif'}" alt="${article.title}" style="width:100%; height:auto;">
                    
          <h3 style="color:blue">${article.title}</h3>
          <h5 style="color:gray"><strong>Description:</strong> ${article.description}</h5>
          <p>${article.content}</p>
          <h6 style="color:blue"><strong>Published on:</strong> ${article.publishedAt}</h6>
        </div>
      `;
    }).join('');

    // Set the inner HTML of the main section
    mainSection.innerHTML = articlesHTML;
  } else {
    mainSection.innerHTML = `<p>No news articles available for ${category}</p>`;
  }
};

// Adding Sub menu 
const subLinks = `
 <a href="#" onclick="displayLastestNews()">Latest News</a>
  <a href="#" onclick="displayNewsByCategory('City News')">City News</a>
  <a href="#" onclick="displayNewsByCategory('Cricket News')">Cricket News</a>
  <a href="#" onclick="displayNewsByCategory('Entertainment News')">Entertainment News</a>
  <a href="#" onclick="displayNewsByCategory('Education')">Education</a>

`; // Define the navbar links as HTML string

// Create a sub bar
const sub = document.createElement('nav');
const subList = document.createElement('ul');
subList.innerHTML = subLinks;
sub.appendChild(subList);

// Append the nav and the main section to the body
document.body.appendChild(sub);
document.body.appendChild(mainSection);


// Automatically display "LATEST News" when the page loads
const fetchlatestNews= async()=>{
  try {
   const response= await fetch('customApi/latestnews.json');
   if(response.ok){
     return await response.json();
   }
   else{
     console.log("Error fetching News");
   }
  }catch{
   console.log("Something Went Worng...");
  }
 };

 const displayLastestNews=async ()=>{

  const dataL= await fetchlatestNews();

  //rendring the latest news
  console.log(dataL);

  const myLatestNewsHTML=dataL.news.map((myNews)=>{
    if (myNews) {
    return` 
 <div class="card">

   <img src="${myNews.imageUrl ? myNews.imageUrl : 'customApi/img/default.jfif' }" alt="${myNews.title}" style="width:100%; height:auto;">
   <h3 style="color:blue">${myNews.title}:<h3 style="color:blue">${myNews.category}</h3></h3>
   <h5 style="color:gray"><strong>Description:</strong> ${myNews.description}</h5>
   <p>${myNews.content}</p>
   <h6 style="color:blue"><strong>Published on:</strong> ${myNews.publishedAt}</h6>

 </div>`;
 
}
  }).join('');

 // Set the inner HTML of the main section
 mainSection.innerHTML = myLatestNewsHTML;


 };
 window.onload = () => {
  displayLastestNews();
 };
 
// Styling for cards and sections (optional)
const style = document.createElement('style');
style.innerHTML = `
  .mainSection {
    padding: 20px;
    background-color: #f9f9f9;
  }
  .card {
    background-color: white;
    border: 1px solid #ddd;
    border-radius: 5px;
    padding: 20px;
    margin-bottom: 20px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }
  nav ul {
    list-style-type: none;
    padding: 0;
    margin-bottom: 20px;
    // background-color: #333;
    overflow: hidden;
  }
  nav ul a {
    float: left;
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
  }
  nav ul a:hover {
    background-color: #111;
  }
`;
document.head.appendChild(style);



// Creating footer
const footerlinks = `
    <a href="#">Facebook</a>
    <a href="#">Instagram</a>
    <a href="#">Twitter</a>
    <a href="#">Github</a>
    <p>© 2024 TCA all Reserverd</p>`; 
const footer = document.createElement('div'); // Create a div for the footer
footer.id = "footerContent"; // Assign ID for styling
footer.innerHTML = footerlinks; // Set the text content for the footer



// Creating the header

const header = document.createElement('header'); // Create a header element
header.appendChild(logo); // Add logo to the header
header.appendChild(navbar); // Add navbar to the header

// Appending all elements to the DOM
document.body.appendChild(rootDiv); // Append the root container to the body
rootDiv.appendChild(header); // Add header to the root container
rootDiv.appendChild(heroSection); // Add hero section to the root container
rootDiv.appendChild(sub);// Add sublist container to the root
rootDiv.appendChild(main); // Add main content container to the root
main.appendChild(sidebar); // Add sidebar to the main content
main.appendChild(mainSection); // Add main section to the main content
rootDiv.appendChild(footer); // Add footer to the root container

const getDomContent=async ()=>{
    const response=await fetch('dom-content-api.json');
    const data=await response.json();
    console.log(data);

}
getDomContent();
