import React from 'react';
import { useNavigate } from 'react-router-dom';
/**
 * 
 * @returns Key Concepts Illustrated
Logging Clicked Element: The target property will log the text of the clicked element, 
which is the specific cell you clicked. If you have nested elements (like spans within the table cells), 
target will point to the innermost element clicked.
Logging Current Target: The currentTarget property will log the text of the element 
where the event handler was attached. This should be the table cell you intended to navigate from, 
regardless of whether you click inside that cell or on a nested element.
Navigate Based on ID: The function still decides the navigation based on the currentTarget.
id to determine which route to take.
 */
const QuickLinks = () => {
    const navigate = useNavigate();

    // Handle link click with only the event object 
    const handleLink = (e) => {
        e.preventDefault(); // Prevent default action if necessary

        // Get the clicked element's parent row to identify the link
        const targetRow = e.currentTarget.closest('tr');
        let pageName = targetRow.children[0].innerText; // Get the page name from the first cell

          // Get the target and currentTarget elements
        const target = e.target; // The actual clicked element
        const currentTarget = e.currentTarget; // The element where the event handler is attached

        console.log(`Clicked element: ${target.innerText}`); // Logs the text of the clicked cell
        console.log(`Current target element: ${currentTarget.innerText}`); // Logs the text of the cell that has the onClick handler
         
        // Determine new path based on clicked link
        pageName=currentTarget.id;
        switch (pageName) {
            case 'Home':
                navigate('/home');
                break;
            case 'About':
                navigate('/about');
                break;
            case 'Contact':
                navigate('/contact');
                break;
            default:
                navigate('/notfound'); // Fallback for undefined links
        }
    };

    return (
        <div  >
            <hr />
            <h5>QuickLinks</h5>
              <hr />
            <table>
                <thead>
                    <tr><th>Page Name</th><th>URL</th></tr></thead>
                <tbody style={{ cursor: 'pointer' }}>
                    <tr>
                        <td>Home</td>
                        <td id="Home" onClick={handleLink}>link</td>
                    </tr>
                    <tr>
                        <td>About</td>
                        <td id="About" onClick={handleLink}>link</td>
                    </tr>
                    <tr>
                        <td>Contact</td>
                        <td id="Contact" onClick={handleLink}>link</td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default QuickLinks;
