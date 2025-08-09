// /*-------------------------------------Introduction to the DOM

// What is the DOM?: The DOM (Document Object Model) is a programming interface for HTML and XML documents. It represents the page so that programs can change the document structure, style, and content.
// DOM tree structure: The DOM represents the document as a tree of nodes, with each node corresponding to an element, attribute, or text.
// Nodes: Nodes are the fundamental units of the DOM, representing elements (tags), attributes (like class or id), and text within elements.


// ----------------------Selecting DOM Elements
// 
// // document.getElementById(): Selects a single element by its unique ID.

const root = document.getElementById('root');

console.log(root);


// document.getElementsByClassName(): Selects all elements with a given class name.


const myNavbar = document.getElementsByClassName('navbar');

console.log(myNavbar);

// document.getElementsByTagName(): Selects all elements with a specific tag name.

const myTag = document.getElementsByTagName('ul');

console.log(myTag);


// document.querySelector(): Selects the first element that matches a CSS selector.

const mySingleLi = document.querySelector('li');

console.log(mySingleLi);

// document.querySelectorAll(): Selects all elements that match a CSS selector.

const myList = document.querySelectorAll('li');

console.log(myList);


// ------------------------Manipulating Content


// innerHTML vs textContent: innerHTML sets or retrieves HTML content inside an element, while textContent sets or retrieves text content only.
mySingleLi.textContent = `<a href="#">LOGO</a>`;

// Adding/removing text content: Methods for dynamically changing the text inside an element.
mySingleLi.innerHTML = mySingleLi.innerHTML.replace('LOGO', '');//removing inner text
mySingleLi.innerHTML = `<a href="#">TCA</a>`;//adding inner content
mySingleLi.textContent = '';//removing inner text
mySingleLi.textContent += '[ TC';//adding inner content
mySingleLi.textContent += 'A ]';//adding inner content

// Working with innerHTML, outerHTML: innerHTML allows setting or getting the HTML inside an element, while outerHTML includes the element itself.
mySingleLi.innerHTML = `<a href="#">TCA</a>`;//adding inner content
mySingleLi.outerHTML = `
        <strong id="myNewLogo" >
          <a id="logo" href="#HOME" >TCA</a>
        </strong>`;//adding inner content


// -----------------------Manipulating Styles


// Inline styles: style property: Directly sets styles on an element using the style property.
mySingleLi.style.backgroundColor = "aliceblue";
mySingleLi.style.color = "red";
mySingleLi.style.fontSize = "28px";


// Adding/removing CSS classes: classList property (add(), remove(), toggle(), contains()): Methods for dynamically adding, removing, toggling, and checking for CSS classes on an element.


const bgChange = document.querySelector('span');
const modeIcons = document.querySelectorAll('.mode'); // Renamed for clarity
const myList1 = document.querySelector('.myList'); // Select the myList

bgChange.id = "bg-changer"; // Adding id to the span
bgChange.className = "bg-changer1"; // Adding class to span
bgChange.classList.add("light"); // Start with light class

// Function to toggle between dark and light classes
modeIcons.forEach(modeIcon => {
  modeIcon.onclick = function () {
    if (bgChange.classList.contains("light")) {
      bgChange.classList.remove("light");
      bgChange.classList.add("dark");
      document.body.style.backgroundColor = "black";
      modeIcon.style.fill = "white"; // Change SVG color to white
      myList1.style.backgroundColor = "gray"; // Change myList background color
      myList1.style.color = "white"; // Change myList text color
      myList1.querySelectorAll('a').forEach(link => link.style.color = "white"); // Change link color
    } else {
      bgChange.classList.remove("dark");
      bgChange.classList.add("light");
      document.body.style.backgroundColor = "white";
      modeIcon.style.fill = "black"; // Change SVG color to black
      myList1.style.backgroundColor = ""; // Reset myList background color
      myList1.style.color = "black"; // Change myList text color
      myList1.querySelectorAll('a').forEach(link => link.style.color = "black"); // Reset link color
    }
  };
});

//for hamburger
// ...TODO

const hamburgerIcon = document.getElementById('hmbgr');
console.log(hamburgerIcon);

hamburgerIcon.onclick = function () {
  console.log("hamburger clicked");
  const hamburger_menu = document.querySelector('.hamburger');

  if (hamburgerIcon.src.includes('hamburger-close.svg')) {
    hamburgerIcon.src = "hamburger-open.svg";
    hamburger_menu.style.display = "flex";
  } else {
    hamburgerIcon.src = "hamburger-close.svg";
    hamburger_menu.style.display = "none";
  }


}

//adding the new logo
const myNewLogo = document.querySelector('#myNewLogo');
myNewLogo.innerHTML = "<p>TCA</p>"

// Handling computed styles: getComputedStyle(): Retrieves the actual computed styles applied to an element, as determined by the browser.


function getComputedStyles() {
  const rootElement = document.getElementById('root');
  const myListElement = document.querySelector('.myList');
  const linkElement = document.querySelector('.myList a');

  const rootStyles = getComputedStyle(rootElement);
  const myListStyles = getComputedStyle(myListElement);
  const linkStyles = getComputedStyle(linkElement);

  console.log('Root Styles:', {
    display: rootStyles.display,
    justifyContent: rootStyles.justifyContent,
    alignItems: rootStyles.alignItems,
    flexWrap: rootStyles.flexWrap,
  });

  console.log('MyList Styles:', {
    display: myListStyles.display,
    gap: myListStyles.gap,
    padding: myListStyles.padding,
    borderRadius: myListStyles.borderRadius,
    backgroundColor: myListStyles.backgroundColor,
  });

  console.log('Link Styles:', {
    listStyle: linkStyles.listStyle,
    textDecoration: linkStyles.textDecoration,
    color: linkStyles.color,
  });
}
getComputedStyles();


// ---------------------- Manipulating DOM Elements


// Creating elements: document.createElement(): Creates a new element node.

const main = document.createElement('div');
main.id = "main";
console.log(main);

const footer = document.createElement('div');
footer.id = "footer";
console.log(footer);

let ncomment = document.createComment("This is navbar section");
console.log(ncomment);

let nccomment = document.createComment("This is navbar content");
console.log(nccomment);

let nhbcomment = document.createComment("This is hamburger content");
console.log(nhbcomment);

let hcomment = document.createComment("This is hero section");
console.log(hcomment);


let hleftcomment = document.createComment("This is hero left content");
console.log(hleftcomment);


let hrightcomment = document.createComment("This is hero right content");
console.log(hrightcomment);

let mcomment = document.createComment("This is main section comment");
console.log(mcomment);

let mnewText = document.createTextNode("This is main content ");
console.log(mnewText);

let fcomment = document.createComment("This is footer section comment");
console.log(fcomment);

let fnewText = document.createTextNode("This is footer content ");
console.log(fnewText);

// Appending elements: appendChild(), insertBefore(): Appends a new child node to a parent or inserts it before an existing child node.

// appendChild():
//appending the main to the root
main.appendChild(mcomment);
main.appendChild(mnewText);
root.appendChild(main);

// appending the footer to the root
footer.appendChild(fcomment);
footer.appendChild(fnewText);
root.appendChild(footer);


// insertBefore():

// --------------------------------------------------------------------------------------------------------------
// Insert the navbar comments before the navbar element and inside

const rt = document.getElementById('root');
console.log(rt.childNodes, { count: rt.childNodes.length });
root.insertBefore(ncomment, root.childNodes[0]); // Insert navbar comment

// Assuming the navigation bar has the class 'navbar'
const navigation = document.querySelector('.navbar');
console.log(navigation.childNodes, { count: navigation.childNodes.length });
navigation.insertBefore(nccomment, navigation.childNodes[0]); // Insert navbar content comment
navigation.insertBefore(nhbcomment, navigation.childNodes[3]); // Insert hamburger content comment

// -------------------------------------------------------------------------------------------------------------------

//Insert the hero comments before the hero element and inside

const heroSection = document.querySelector('.heroSection');
console.log(heroSection.childNodes, { count: heroSection.childNodes.length });
rt.insertBefore(document.createComment("This is hero section "), rt.childNodes[3]);

const heroC = document.querySelector('.container');
console.log(heroC.childNodes, { count: heroC.childNodes.length });
heroC.insertBefore(hleftcomment, heroC.childNodes[0]);
heroC.insertBefore(hrightcomment, heroC.childNodes[4]);
//---------------------------------------------------------------------------------------------------------------------
//insert the comment before main element and inside
const mainSection = document.querySelector('#main');
console.log(mainSection.childNodes, { count: mainSection.childNodes.length });
root.insertBefore(mcomment, root.childNodes[6]);

// --------------------------------------------------------------------------------------------------------------

//insert the comment before main element and inside
const footerSection = document.querySelector('#footer');
console.log(footerSection.childNodes, { count: footerSection.childNodes.length });
root.insertBefore(fcomment, root.childNodes[9]);

//--------------------------------------------------------------------------------------------------------------------
// Select the root element
const root1 = document.getElementById('root'); // Ensure there's a root element in your HTML

// Create a target element
const myElement = document.createElement('div');
myElement.id = 'temp_element';
root1.appendChild(myElement);

// Select the target element
const targetElement = document.getElementById('temp_element');

// Create new elements
const newElement1 = document.createElement('div');
newElement1.textContent = 'Before Begin';

const newElement2 = document.createElement('div');
newElement2.textContent = 'After Begin';

const newElement3 = document.createElement('div');
newElement3.textContent = 'Before End';

const newElement4 = document.createElement('div');
newElement4.textContent = 'After End';

// Insert the new elements using insertAdjacentElement : create if not then append
targetElement.insertAdjacentElement('beforebegin', newElement1); // Before target
targetElement.insertAdjacentElement('afterbegin', newElement2);  // Inside, before first child
targetElement.insertAdjacentElement('beforeend', newElement3);   // Inside, after last child
targetElement.insertAdjacentElement('afterend', newElement4);    // After target


//insertAdjecentHTML

root.insertAdjacentHTML("beforebegin", "<center><h3>Thank you for visite</h3></center>");
root.insertAdjacentHTML("afterbegin", "<center><h3>Thank you for visite</h3></center>");
root.insertAdjacentHTML("beforeend", "<center><h3>Thank you for visite</h3></center>");
root.insertAdjacentHTML("afterend", "<center><h3>Thank you for visite</h3></center>");


//insertAdjecentText

root.insertAdjacentText("beforebegin", "Thank you for visite");
root.insertAdjacentText("afterbegin", "Thank you for visite");
root.insertAdjacentText("beforeend", "Thank you for visite");
root.insertAdjacentText("afterend", "Thank you for visite");


// In the DOM (Document Object Model), every element, attribute, and piece of text is represented as a node. Nodes are categorized by node types, and each node type is represented by a unique number. Here’s an overview of common node types:

// Element nodes (e.g., <div>, <p>): nodeType === 1
// Attribute nodes (attributes on elements like id, class): nodeType === 2 (though attributes are rarely accessed this way in modern JavaScript)
// Text nodes (the actual text inside elements): nodeType === 3
// So, when you check node.nodeType === 3, you are determining if the current node is a text node.

// Removing elements: removeChild(): Removes a child node from its parent node.

//removing textNode

const root3 = document.getElementById('root');
const body3 = document.body;
console.log('root3', {
  nodeType: root3.nodeType,
  nodeName: root3.nodeName,
}, 'body3', {
  nodeType: body3.nodeType,
  nodeName: body3.nodeName,
});

// Looping through the child nodes of root3
root3.childNodes.forEach(node => {
  if (node.nodeType === 3) { // Check if it's a text node (nodeType 3)
    node.textContent = ''; // Remove the text content
  }
});

console.log("Text nodes removed from #root");

body3.childNodes.forEach(node => {
  if (node.nodeType === 3) {
    node.textContent = "";
  }
});
console.log("Text nodes removed from body");

//removing all the h3

const h3 = document.querySelectorAll('h3');
console.log(h3.length);
h3.forEach(element => {
  element.remove();

});
// Removing elements
// Assuming newElement1 is a child of targetElement

try {
  targetElement.removeChild(newElement1);
} catch (err) {
  console.log(err.message, {
    code: err.code,
    name: err.name,
    message: "not a child of targetElement"
  });
}

// This will throw an error since newElement2 is not a child of targetElement

// To remove newElement2 correctly:
newElement1.remove(); // Remove newElement2 from the DOM

// To remove newElement4 correctly, you can call remove directly on it
newElement4.remove(); // Remove newElement4 from the DOM

//removing newElement1

if (targetElement.contains(newElement2)) {
  targetElement.removeChild(newElement2); // This removes newElement2 from targetElement 
}
//--------------------------------------------------------------------------------------------------
// Replacing elements
const newElement5 = document.createElement('div');
newElement5.textContent = 'Replaced Element';

// Replace newElement3 with newElement5
targetElement.replaceChild(newElement5, newElement3); // Replaces newElement3 with newElement5

// Replacing the targetElement itself
const newTarget = document.createElement('div');
newTarget.textContent = 'I replaced myself!';
targetElement.replaceWith(newTarget); // Replace targetElement with newElement6

newTarget.remove();
main.replaceWith(footer);
footer.replaceWith(main);
//remove all temp elements
main.remove();
footer.remove();
mcomment.remove();
mnewText.remove();
fcomment.remove();
fnewText.remove();



// Creating main section for my website
const myMainS = document.createElement('div');
myMainS.id = "sectionMain";

// Creating a container for About and Features sections
const infoContainer = document.createElement('div');
infoContainer.className = "infoContainer";

// Creating About Section
const aboutDiv = document.createElement('div');
aboutDiv.className = "about";
aboutDiv.innerHTML = `
  <h2>About</h2>
  <p>Our mission is to innovate and empower through technology. We strive to create solutions that connect people and devices in meaningful ways, enhancing productivity and simplifying life.</p>
  <p>We believe in the power of collaboration and community, driving forward-thinking initiatives that leverage cutting-edge technologies to solve real-world problems.</p>
  <p>With a team of passionate experts, we are committed to delivering excellence and ensuring our clients achieve their goals through tailored solutions.</p>
`;

// Creating Features Section
const featuresDiv = document.createElement('div');
featuresDiv.className = "features";
featuresDiv.innerHTML = `
  <h2>Features</h2>
  <p>Our platform offers seamless integration, user-friendly interfaces, and robust support. Enjoy a top-notch experience with continuous updates, security features, and customer-focused enhancements.</p>
  <p>Key features include:</p>
  <ul>
    <li>Real-time data processing and analytics for informed decision-making.</li>
    <li>Customizable dashboards to suit your unique business needs.</li>
    <li>24/7 customer support to ensure uninterrupted service.</li>
    <li>Comprehensive API documentation for easy integration with existing systems.</li>
  </ul>
`;

// Adding content to the main section
const sectionsContent = [
  { title: "IoT Development", description: "Explore the world of IoT development, connecting devices and creating smart solutions.", image: "img/card/iot.png" },
  { title: "Mobile Applications", description: "Discover how to develop engaging mobile applications for iOS and Android platforms.", image: "img/card/app.jpg" },
  { title: "Web Development", description: "Learn the latest web technologies and frameworks to build responsive websites.", image: "img/card/wd.jpg" },
  { title: "Cloud Solutions", description: "Understand cloud computing and how to leverage it for scalable applications.", image: "img/card/cloud.jpg" }, 
  { title: "Machine Learning", description: "Dive into machine learning techniques to develop intelligent applications that learn from data.", image: "img/card/ml.jpg" },
  { title: "Blockchain Technology", description: "Explore blockchain solutions for enhanced security and transparency in transactions.", image: "img/card/bc.jpg" },
  { title: "Cybersecurity", description: "Implement robust cybersecurity measures to protect your data and applications.", image: "img/card/cs.jpg" },
  { title: "Data Analytics", description: "Utilize data analytics to gain insights and drive business strategies effectively.", image: "img/card/da.png" }
];

// Appending all sections to the main section
infoContainer.appendChild(aboutDiv);
infoContainer.appendChild(featuresDiv);
myMainS.appendChild(infoContainer);

const myDivMain = document.createElement('div');
myDivMain.className = "myDivMain";

sectionsContent.forEach(content => {
  const myDiv = document.createElement('div');
  myDiv.className = "MD";

  const image = document.createElement('img'); // Create image element
  image.src = content.image; // Set image source
  image.alt = content.title; // Set alt text
  image.style.width = "100%"; // Style image width
  image.style.borderRadius = "8px"; // Optional: Add rounded corners

  const title = document.createElement('h2');
  title.textContent = content.title;

  const description = document.createElement('p');
  description.textContent = content.description;

  myDiv.appendChild(image); // Add image to the MD div
  myDiv.appendChild(title);
  myDiv.appendChild(description);
  myDivMain.appendChild(myDiv);
});

myMainS.appendChild(myDivMain);

// Append the main section to the root
root.insertAdjacentElement('beforeend', myMainS);



// Creating footer section for my website
const myFooterS = document.createElement('div');
myFooterS.id = 'sectionFooter';
myFooterS.style.color = "white"; // Text color for better visibility
myFooterS.style.padding = "20px"; // Add padding for space
myFooterS.style.backgroundColor = "#41007e"; // Set a solid background color
myFooterS.style.display = "flex"; // Use flexbox for layout
myFooterS.style.flexDirection = "column"; // Stack children vertically
myFooterS.style.alignItems = "center"; // Center-align children

// Creating the first div to hold Sitemap, Quick Links, and Contact Form
const contentDiv = document.createElement('div');
contentDiv.className = 'contentDiv';


// Creating Sitemap Section
const sitemapDiv = document.createElement('div');
sitemapDiv.innerHTML = `
  <h3>Sitemap</h3>
  <ul style="list-style: none; padding: 0;">
    <li><a href="#about" style="color: white;">About Us</a></li>
    <li><a href="#services" style="color: white;">Services</a></li>
    <li><a href="#contact" style="color: white;">Contact</a></li>
    <li><a href="#features" style="color: white;">Features</a></li>
  </ul>
`;

// Creating Quick Links Section
const quickLinksDiv = document.createElement('div');
quickLinksDiv.innerHTML = `
  <h3>Quick Links</h3>
  <ul style="list-style: none; padding: 0;">
    <li><a href="#privacy" style="color: white;">Privacy Policy</a></li>
    <li><a href="#terms" style="color: white;">Terms of Service</a></li>
    <li><a href="#faq" style="color: white;">FAQ</a></li>
  </ul>
`;

// Creating Contact Form Section
const contactDiv = document.createElement('div');
contactDiv.innerHTML = `
  <h3>Contact Us</h3>
  <form id="contactForm">
    <input type="text" placeholder="Your Name" required style="margin: 5px; padding: 8px; width: 80%;"><br>
    <input type="email" placeholder="Your Email" required style="margin: 5px; padding: 8px; width: 80%;"><br>
    <textarea placeholder="Your Message" required style="margin: 5px; padding: 8px; width: 80%;"></textarea><br>
    <button type="submit" style="padding: 10px 20px; background-color: #f347bf; color: white; border: none; border-radius: 5px;">Send Message</button>
  </form>
`;

// Append all sections to the content div
contentDiv.appendChild(sitemapDiv);
contentDiv.appendChild(quickLinksDiv);
contentDiv.appendChild(contactDiv);

// Append the content div to the footer
myFooterS.appendChild(contentDiv);

// Creating and adding footer text div
const footerTextDiv = document.createElement('div');
footerTextDiv.style.marginTop = "20px"; // Space above the footer text
const footerText = document.createElement('p');
footerText.textContent = "© 2024 TCA. All rights reserved.";
footerTextDiv.appendChild(footerText);

// Append the footer text div to the footer
myFooterS.appendChild(footerTextDiv);

// Append the footer to the root
root.insertAdjacentElement('beforeend', myFooterS);


//--------------------------------------------------------------------------------------------------------------------

// ---------------------Manipulating Attributes

// Getting and setting attributes: getAttribute(), setAttribute(): Retrieves or sets the value of an attribute on an element.
// <!-- <link rel="stylesheet" href="animation/css/onload.css"> inject via js-->to the head
        const link = document.createElement('link');
        link.classList.add("aos-css");//to be remove
        console.log(link);
        const links=link.getAttribute('class');
        console.log(links);
        link.setAttribute('rel',"stylesheet");
        link.setAttribute('href',"https://unpkg.com/aos@2.3.1/dist/aos.css");
        link.setAttribute('type','text/css');
        console.log('getting all Attributes:',{
          rel: link.getAttribute('rel'),
          href:link.getAttribute('href'),
          type:link.getAttribute('type'),
        });

        // Getting and setting attributes: hasAttribute(): Checks if an element has a particular attribute.
        console.log(link.hasAttribute('rel'));
       
        // <!-- <script src="animation/css/onload.js"></script>inject via js -->
        const scriptAnimation = document.createElement('script');
        console.log(scriptAnimation);
        if(scriptAnimation.hasAttribute('src')){
          console.log('script has src attribute');
        }else{
          console.log('script does not have src attribute');
          scriptAnimation.setAttribute('src',"https://unpkg.com/aos@2.3.1/dist/aos.js");
          scriptAnimation.setAttribute('type',"text/javascript");
          console.log('now set : script has src attribute');
          scriptAnimation.setAttribute("class","animation-js");//to be remove
        }

        //appending link and script for animation to head
        document.head.insertAdjacentElement('beforeend',link);
        document.head.insertAdjacentElement('beforeend',scriptAnimation);
        


// also get all getAttributes using attribute prop
const linkAT=link.attributes;
const scriptAT=scriptAnimation.attributes;
const arr=[linkAT,scriptAT];
console.log('getting all Attributes:',arr[0].linkAT,arr[1].scriptAT);

arr.forEach(attributes=>{
  for(let i=0;i<attributes.length;i++){
    console.log(attributes[i].name,attributes[i].value);
    }
})

// Removing attributes: removeAttribute(): Removes an attribute from an element.

link.removeAttribute('class');
scriptAnimation.removeAttribute('class');



// Handling data attributes(dataset): Special attributes prefixed with data- used for embedding custom data within elements.

const dlinks=document.querySelectorAll('nav a');

  // Loop through each link and log data attributes
  dlinks.forEach(link => {
    const section = link.dataset.section; // Access data-section
    console.log(`Section: ${section}`);
    
    // Example of adding an event listener
    link.onclick=(event) => {
        event.preventDefault(); // Prevent default link behavior
        console.log(`You clicked on: ${section}`);
    };
});



    // Loop through each link and change data attributes using dataset
    dlinks.forEach(link => {
      const section = link.textContent.toLowerCase(); // Get the text content in lowercase

      // Set a new data attribute using dataset
      link.dataset[section] = section; // Creates data-home, data-services, etc.

      // Optionally, remove the old data-section attribute
      delete link.dataset.section; // Remove the old data-section attribute if needed

      console.log(`Set data-${section} for ${link.textContent}: ${link.dataset[section]}`);
  });


    // Array of new section values
    const data = ["homepage", "servicePage", "platformPage", "clientPage", "aboutPage", "contactPage"];

    // Modify data attributes values using the array
    dlinks.forEach((link, index) => {
        link.dataset.section = data[index]; // Set the data-section to the corresponding value in the array
        console.log(`Updated Section for ${link.textContent}: ${link.dataset.section}`);
    });
 
//adding aos data-aos attribute to the hero element for animation 
// welcomeNote
// heroHead
// heroContent
// welcomeBg

  // Selecting hero section elements
  const welcomeNote = document.querySelector('.welcomeNote');
  const heroHead = document.getElementById('heroHead');
  const heroContent = document.getElementById('heroContent');
  const welcomeBg = document.querySelector('.welcomeBg');

  // Log selected elements
  console.log('Welcome Note:', welcomeNote);
  console.log('Hero Head:', heroHead);
  console.log('Hero Content:', heroContent);
  console.log('Welcome Background:', welcomeBg);

  // Check for null and set data-aos if elements exist
  const heroArr = [welcomeNote, heroHead, heroContent, welcomeBg];
  heroArr.forEach((element) => {
      if (element) { // Check if the element is not null
          element.dataset.aos = ''; // Create the attribute without a value
          console.log(`Created data-aos for ${element.className || element.id}: ${element.dataset.aos}`);
      } else {
          console.log('Element not found');
      }
  });

  
  const aosValues = ['fade-right', 'fade-right','fade-up', 'fade-left']; // Example values
  
  heroArr.forEach((element, index) => {
      if (element) {
          element.dataset.aos = aosValues[index] || ''; // Set value based on index
          console.log(`Set data-aos for ${element.className || element.id}: ${element.dataset.aos}`);
      } else {
          console.log('Element not found');
      }
  });

//animation apply on 

//.about
//.features
//.MD

 // Apply data-aos attributes to .about, .features, and .MD
 const aboutSection = document.querySelector('.about');
 const featuresSection = document.querySelector('.features');
 const mdElements = document.querySelectorAll('.MD');

 // Setting data-aos for the about and features sections
 if (aboutSection) {
     aboutSection.dataset.aos = 'fade-right'; // Example value
     console.log(`Set data-aos for .about: ${aboutSection.dataset.aos}`);
 }

 if (featuresSection) {
     featuresSection.dataset.aos = 'fade-left'; // Example value
     console.log(`Set data-aos for .features: ${featuresSection.dataset.aos}`);
 }

 // Setting data-aos for each .MD element
 mdElements.forEach((element, index) => {
     element.dataset.aos = index % 2 === 0 ? 'zoom-in' : 'zoom-out'; // Alternate values
     console.log(`Set data-aos for .MD element ${index + 1}: ${element.dataset.aos}`);
 });







//dom imp concepts covered

// -------------------- DOM Traversal

// Question 1: Parent, Child, and Sibling Relationships
// Explanation:
// - Parent Node: Every node can have one parent node, except the root node.
// - Child Nodes: Nodes can have multiple child nodes, which are nested inside them.
// - Sibling Nodes: Nodes that share the same parent are considered siblings.

// Selecting the container div
const container = document.querySelector('.container');

// Parent Node

// --------------------

// Question 2: Properties - parentNode, childNodes, firstChild, lastChild
// Explanation:
// - `parentNode`: Accesses the parent node of a given node.
// - `childNodes`: Returns a NodeList of all child nodes (including text nodes).
// - `firstChild`: Accesses the first child node of a specified node.
// - `lastChild`: Accesses the last child node of a specified node.

// Child Nodes

// First Child

// Last Child

// --------------------

// Question 3: Previous Sibling and Next Sibling
// Explanation:
// - `previousSibling`: Accesses the previous sibling node (could be a text node).
// - `nextSibling`: Accesses the next sibling node (could be a text node).


// Previous Sibling
// const previousSibling = firstParagraph.previousSibling; // Could be a text node (whitespace)
// console.log('Previous Sibling (could be text node):', previousSibling);

// Next Sibling

// Additional Sibling Navigation
// Using Element Properties for Sibling Navigation

// Getting previous and next sibling elements
console.log(hamburgerIcon);