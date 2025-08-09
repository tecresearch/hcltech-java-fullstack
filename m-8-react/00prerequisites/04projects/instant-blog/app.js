
// ✅ Full working CRUD app with UI updates and localStorage including PATCH
const apiUrl = "https://jsonplaceholder.typicode.com/posts";
let localPosts = []; // Store posts in local memory to simulate real DB

// On DOM load
document.addEventListener("DOMContentLoaded", () => {
  const saved = localStorage.getItem("posts");
  localPosts = saved ? JSON.parse(saved) : [];
  if (localPosts.length === 0) {
    // First load from API if local is empty
    fetch(apiUrl)
      .then(res => res.json())
      .then(data => {
        localPosts = data.slice(0, 10); // Load first 10
        localStorage.setItem("posts", JSON.stringify(localPosts));
        renderPosts();
      });
  } else {
    renderPosts();
  }
});

function renderPosts() {
  const postList = document.getElementById("post-list");
  
  if (localPosts.length === 0) {
    postList.innerHTML = `
      <div class="empty-state">
        <i class="fas fa-comment-slash"></i>
        <p>No posts yet. Be the first to share your thoughts!</p>
        <button onclick="document.getElementById('create').scrollIntoView({behavior: 'smooth'})">
          <i class="fas fa-pen"></i> Create Post
        </button>
      </div>
    `;
    return;
  }
  
  postList.innerHTML = localPosts.map(post => `
    <li class="post-card" id="post-${post.id}">
      <h3 class="post-title">${post.title}</h3>
      <p class="post-body">${post.body}</p>
      <div class="post-meta">
        <div class="post-user">
          <span class="user-avatar">${post.userId}</span>
          <span>Anonymous</span>
        </div>
        <div class="post-actions">
          <button class="btn-secondary" onclick="editPost(${post.id})">
            <i class="fas fa-edit"></i> Edit
          </button>
          <button class="btn-warning" onclick="patchPost(${post.id})">
            <i class="fas fa-pen-square"></i> Patch
          </button>
          <button class="btn-danger" onclick="deletePost(${post.id})">
            <i class="fas fa-trash"></i> Delete
          </button>
        </div>
      </div>
    </li>
  `).join('');
}

function createPost() {
  const title = document.getElementById("title").value;
  const body = document.getElementById("body").value;
  if (!title || !body) return alert("Please provide title and body");

  const newPost = {
    title,
    body,
    userId: Math.floor(Math.random() * 10) + 1, // Random user
    id: Date.now(), // Simulate unique ID
  };

  // Save to local and UI
  localPosts.unshift(newPost);
  localStorage.setItem("posts", JSON.stringify(localPosts));
  renderPosts();

  // Optional real API call (demo only)
  fetch(apiUrl, {
    method: "POST",
    headers: { "Content-type": "application/json" },
    body: JSON.stringify(newPost),
  })
    .then(res => res.json())
    .then(data => console.log("POST response:", data))
    .catch(err => console.error("POST error:", err));

  // Clear form
  document.getElementById("title").value = "";
  document.getElementById("body").value = "";
  
  // Scroll to new post
  setTimeout(() => {
    document.getElementById(`post-${newPost.id}`).scrollIntoView({ 
      behavior: 'smooth',
      block: 'start'
    });
  }, 100);
}

function editPost(id) {
  const post = localPosts.find(p => p.id === id);
  if (!post) return;

  const newTitle = prompt("Edit title:", post.title);
  const newBody = prompt("Edit body:", post.body);

  if (newTitle && newBody) {
    post.title = newTitle;
    post.body = newBody;
    localStorage.setItem("posts", JSON.stringify(localPosts));
    renderPosts();

    fetch(`${apiUrl}/${id}`, {
      method: "PUT",
      headers: { "Content-type": "application/json" },
      body: JSON.stringify(post),
    })
      .then(res => res.json())
      .then(data => console.log("PUT response:", data))
      .catch(err => console.error("PUT error:", err));
  }
}

function patchPost(id) {
  const post = localPosts.find(p => p.id === id);
  if (!post) return;

  const newTitle = prompt("Patch title only:", post.title);
  if (newTitle) {
    post.title = newTitle;
    localStorage.setItem("posts", JSON.stringify(localPosts));
    renderPosts();

    fetch(`${apiUrl}/${id}`, {
      method: "PATCH",
      headers: { "Content-type": "application/json" },
      body: JSON.stringify({ title: newTitle }),
    })
      .then(res => res.json())
      .then(data => console.log("PATCH response:", data))
      .catch(err => console.error("PATCH error:", err));
  }
}

function deletePost(id) {
  if (!confirm("Are you sure you want to delete this post?")) return;
  
  localPosts = localPosts.filter(post => post.id !== id);
  localStorage.setItem("posts", JSON.stringify(localPosts));
  renderPosts();

  fetch(`${apiUrl}/${id}`, { method: "DELETE" })
    .then(res => {
      if (res.ok) {
        console.log("Post deleted successfully");
      } else {
        console.warn("DELETE response failed:", res.status);
      }
    })
    .catch(err => console.error("DELETE error:", err));
}
