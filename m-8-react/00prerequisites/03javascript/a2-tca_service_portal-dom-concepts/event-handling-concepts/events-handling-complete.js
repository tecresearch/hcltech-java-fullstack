// --------------------Event Handling in the DOM

//Events: events are the activities perform to the browser via client for example  Common events: click, focus, blur, change, submit, etc.: Examples of frequently used DOM events that can be handled with JavaScript.
// Events are actions or occurrences that happen in the browser, usually as a result of user interaction. They can be triggered by various activities, such as:

// User Actions: Clicks, key presses, mouse movements, form submissions, etc.
// Browser Actions: Page load, resize, focus/blur of elements, etc.
// Media Actions: Play, pause, volume change in audio or video elements.
// Common DOM Events:

// click: Triggered when an element is clicked.
// focus: Triggered when an element gains focus (e.g., an input field).
// blur: Triggered when an element loses focus.
// change: Triggered when the value of an input element changes.
// submit: Triggered when a form is submitted.
// keydown: Triggered when a key is pressed down.
// keyup: Triggered when a key is released.

//Event Handler : Event activities handled by the Event Handler means what we perform when the events are occured

// Function to handle button click event
function handleClick() {
    alert('Button clicked!');
    // window.location.href = 'newPage.html'; // Redirect after alert
}

// Function to handle focus event
function handleFocus() {
    document.write("focused");
    // window.location.href = 'newPage.html'; // Redirect after alert
}

// Function to handle blur event
function handleBlur() {
    alert('Input lost focus!');
    // window.location.href = 'newPage.html'; // Redirect after alert
}

// Function to handle change event
function handleChange() {
    alert('Input value changed!');
    // window.location.href = 'newPage.html'; // Redirect after alert
}

// Function to handle form submission
function handleSubmit(event) {
    event.preventDefault(); // Prevent form submission for demo
    alert('Form submitted!');
    // window.location.href = 'newPage.html'; // Redirect after alert
}

// Function to handle keydown event
function handleKeyDown() {
    alert('Key pressed down!');
    // window.location.href = 'newPage.html'; // Redirect after alert
}

// Function to handle keyup event
function handleKeyUp() {
    alert('Key released!');
    // window.location.href = 'newPage.html'; // Redirect after alert
}



// Setting event handlers directly when website will be loaded 
// document.addEventListener('DOMContentLoaded', () => {
//     document.querySelector('#clickButton').onclick = handleClick;
//     document.querySelector('#focusInput').onfocus = handleFocus;
//     document.querySelector('#focusInput').onblur = handleBlur;
//     document.querySelector('#changeInput').onchange = handleChange;
//     document.querySelector('#myForm').onsubmit = handleSubmit;
//     document.querySelector('#keyInput').onkeydown = handleKeyDown;
//     document.querySelector('#keyInput').onkeyup = handleKeyUp;
// });




// Adding event listeners: addEventListener(): Attaches an event handler function to an element for a specific event.

const eMyList=document.querySelector('.myList');

console.log(eMyList);


const performAction=(eventObject)=>{// Event object: The event object contains details about the event.
    console.log(
        'eventObject',{
            "Type":eventObject.type,
            "At Target":eventObject.AT_TARGET,
            "current Target":eventObject.currentTarget,
            "Timestamp":eventObject.timeStamp,
            "Target":eventObject.target,
            "NODENAME":eventObject.target.nodeName,
            "Target content":eventObject.target.textContent,
            "Prevent Default":eventObject.preventDefault,
            "Propogation":eventObject.stopPropagation,
            "PHASE_CAPTURING":eventObject.CAPTURING_PHASE,
            "PHASE_BUBLING":eventObject.BUBBLING_PHASE,
        }
    );
}

eMyList.addEventListener('click',performAction);

// Removing event listeners: removeEventListener(): Removes an event handler that was previously added with addEventListener.

eMyList.removeEventListener('click',performAction);

//Event propagation: Event propagation refers to the order in which events are handled (bubbling or capturing).
// 1.Event propagation (bubbling(false)->child to parent :find the root element from target(by default)
        
        const eNavbar=document.querySelector('.navbar');
        console.log(eNavbar);
        
        const myUL=document.querySelector('.myList');
        console.log(myUL);


        const lists=document.querySelectorAll('.myList li');
        console.log(lists);

        // eNavbar.addEventListener('click',()=>{
        //     console.log("2222-This is root element navbar");
        // },false)

        // myUL.addEventListener('click',()=>{
        //     console.log("1111-This is first child");
        // })

        // lists.forEach(lis => {
        //     lis.addEventListener('click',()=>{
        //         console.log("0000-childs of first child");
        //     })
        // });

// 2. Event propagation capturing(true)->parent to child :find the target element from root

        // eNavbar.addEventListener('click',()=>{
        //     console.log("2222-This is root element navbar");
        // },true);

        // myUL.addEventListener('click',()=>{
        //     console.log("1111-This is first child");
        // },true);

        // lists.forEach(lis => {
        //     lis.addEventListener('click',()=>{
        //         console.log("0000-childs of first child");
        //     })
        // });


// Event delegation: A technique to handle events efficiently by assigning a single event handler to a parent element instead of multiple handlers.

        const eRoot=document.querySelector('#root');
        console.log(eRoot);

        const myMessege=(eventDetails)=>{
            eventDetails.preventDefault()//remove the default behaviour of the click element
            eventDetails.stopPropagation()//boubling and capturing will stops means event action will stay at the target element
            console.log('eventDetails=>',{
                "type":eventDetails.type,
                "NodeName":eventDetails.target.nodeName,
                "Target Element":eventDetails.target,
                "Target content":eventDetails.target.textContent,
                "target value":eventDetails.target.value,
            })
        }

        //we applied the singl event handler to the root(parent)
        eRoot.addEventListener('click',myMessege);
        eRoot.removeEventListener('click',myMessege);





















