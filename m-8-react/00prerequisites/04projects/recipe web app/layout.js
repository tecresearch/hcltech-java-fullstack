// const body=document.body;
// const body=document.getElementsByTagName('body')[0];
const body=document.querySelector('body');
const mainDiv=document.createElement('div');
mainDiv.id='root';
body.appendChild(mainDiv);

//Creating elements
const navBar=document.createElement('nav');
navBar.id='navBarId';



const sideBar=document.createElement('aside');
sideBar.id='sideBarId';


const main=document.createElement('main');
main.id='mainId';

const heading=document.createElement('h1');
heading.classList.add('headingClass');

// Create a new <p> element
const paragraph = document.createElement('p');
paragraph.classList.add('paragraphClass');


const footer=document.createElement('footer');
footer.id='footerId';

const navLeft=document.createElement('div');
navLeft.classList.add('navLeftClass');

const navRight=document.createElement('div');
navRight.classList.add('navRightClass');



mainDiv.appendChild(navBar);
mainDiv.appendChild(sideBar);
mainDiv.appendChild(main);
mainDiv.appendChild(footer);
main.appendChild(heading);
main.appendChild(paragraph);
navBar.appendChild(navLeft);
navBar.appendChild(navRight);

