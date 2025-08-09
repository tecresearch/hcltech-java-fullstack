(async function () {
    try {
        // Fetch the JSON data from the file
        const response = await fetch('data.json');

        // Check if the response is ok (status is 200-299)
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        // Parse the JSON data
        const data = await response.json();

        // Get the elements by their IDs or class names
        const navId = document.getElementById('navBarId');
        const sideBarId = document.getElementById('sideBarId');
        const headingClass = document.getElementsByClassName('headingClass');
        const paragraphClass = document.getElementsByClassName('paragraphClass');
        const footerId = document.getElementById('footerId');
        const navLeft = document.getElementsByClassName('navLeftClass');
        const navRight = document.getElementsByClassName('navRightClass');

        // Create navbar content dynamically
        
        const navbarContent = data.navbar.map(item => `<a href="${item.link}">${item.name}</a>`).join(' ');
        
        // Set content for navLeft elements
        if (navLeft.length > 0) {
            for (let i = 0; i < navLeft.length; i++) {
                navLeft[i].innerHTML = navbarContent; // Set HTML content for navLeft elements
            }
        } else {
            console.error("Elements with class 'navLeftClass' not found.");
        }

        // Set content for navRight elements (search box)
        if (navRight.length > 0) {
            for (let i = 0; i < navRight.length; i++) {
                navRight[i].innerHTML = data.searchBox; // Set HTML content for navRight elements
            }
        } else {
            console.error("Elements with class 'navRightClass' not found.");
        }

        // Create sidebar content dynamically
        const sidebarContent = data.sidebar.map(item => `<li>${item}</li>`).join('');

        // Set content for sidebar element
        if (sideBarId) {
            sideBarId.innerHTML = `<ul>${sidebarContent}</ul>`;
        } else {
            console.error("Element with ID 'sideBarId' not found.");
        }

        // Set content for heading elements
        if (headingClass.length > 0) {
            for (let i = 0; i < headingClass.length; i++) {
                headingClass[i].textContent = data.main;
            }
        } else {
            console.error("Elements with class 'headingClass' not found.");
        }

        // Set content for paragraph elements
        if (paragraphClass.length > 0) {
            for (let i = 0; i < paragraphClass.length; i++) {
                paragraphClass[i].textContent = data.text;
            }
        } else {
            console.error("Elements with class 'paragraphClass' not found.");
        }

        // Set content for footer element
        if (footerId) {
            footerId.textContent = data.footer;
        } else {
            console.error("Element with ID 'footerId' not found.");
        }

        // Log the data for debugging
        console.log(data);

    } catch (error) {
        // Handle any errors that occur during fetch
        console.error("Error fetching or processing data:", error);
    }
})();
