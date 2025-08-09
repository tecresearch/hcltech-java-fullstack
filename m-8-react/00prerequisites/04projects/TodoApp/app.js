const taskInput = document.getElementById("taskInput");
const addTaskBtn = document.getElementById("addTaskBtn");
const taskList = document.getElementById("taskList");

// Function to create a new list item with buttons
function createListItem(text) {
    const listItem = document.createElement("li"); // Create a new list item
    listItem.textContent = text; // Set the text content

    // Create 'View' button
    const viewBtn = document.createElement("button");
    viewBtn.textContent = "View";
    viewBtn.onclick = () => alert(`Viewing: ${text}`); // Add event listener for 'View' button

    // Create 'Delete' button
    const deleteBtn = document.createElement("button");
    deleteBtn.textContent = "Delete";
    deleteBtn.onclick = () => {
        taskList.removeChild(listItem); // Remove the list item on delete button click
    };

    // Append buttons to the list item
    listItem.appendChild(viewBtn);
    listItem.appendChild(deleteBtn);

    return listItem; // Return the created list item with buttons
}

// Function to add a new task
function addTask() {
    const taskText = taskInput.value.trim(); // Get the input value and remove whitespace
    if (taskText === "") {
        alert("Please enter a task.");
        return; // Exit if the input is empty
    }

    const newListItem = createListItem(taskText); // Create a new list item
    taskList.appendChild(newListItem); // Append the new list item to the task list
    taskInput.value = ""; // Clear the input field after adding the task
}

// Event listener for the 'Add Task' button
addTaskBtn.addEventListener("click", addTask);
