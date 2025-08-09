document.addEventListener('DOMContentLoaded', async () => {
    const loadData = async () => {
        const response = await fetch('data.json');
        return await response.json();
    };

    const data = await loadData();

    // Common functions for setting content
    const setContent = (selector, content) => {
        const element = document.querySelector(selector);
        if (element) {
            element.innerHTML = content;
        }
    };

    // Handle modals
    const showModal = (modalId) => {
        document.getElementById(modalId).style.display = 'block';
    };

    const hideModal = (modalId) => {
        document.getElementById(modalId).style.display = 'none';
    };

    // Landing Page
    if (window.location.pathname.endsWith('index.html')) {
        setContent('#app-name', data.appName);
        setContent('#page-title', `${data.appName} - Landing Page`);
        setContent('#home-link', data.navbar.home);
        setContent('#login-btn', data.navbar.login);
        setContent('#signup-btn', data.navbar.signup);
        setContent('#landing-title', data.landing.title);
        setContent('#landing-description', data.landing.description);
        setContent('#login-title', data.login.title);
        setContent('#login-username-label', data.login.usernameLabel);
        setContent('#login-password-label', data.login.passwordLabel);
        setContent('#login-submit', data.login.submitButton);
        setContent('#signup-title', data.signup.title);
        setContent('#signup-username-label', data.signup.usernameLabel);
        setContent('#signup-email-label', data.signup.emailLabel);
        setContent('#signup-password-label', data.signup.passwordLabel);
        setContent('#signup-submit', data.signup.submitButton);

        // Show modals
        document.getElementById('login-btn').addEventListener('click', () => {
            showModal('login-modal');
        });
        document.getElementById('signup-btn').addEventListener('click', () => {
            showModal('signup-modal');
        });
        document.getElementById('login-close').addEventListener('click', () => {
            hideModal('login-modal');
        });
        document.getElementById('signup-close').addEventListener('click', () => {
            hideModal('signup-modal');
        });

        // Handle form submissions
        document.getElementById('login-form').addEventListener('submit', async (e) => {
            e.preventDefault();
            const username = document.getElementById('login-username').value;
            const password = document.getElementById('login-password').value;

            // Simulate a login (in real use case, replace with server request)
            // if (username === 'user' && password === 'password') {
                sessionStorage.setItem('loggedIn', 'true');
                window.location.href = 'dashboard.html';
            // } else {
                // alert('Invalid credentials');
            // }
        });

        document.getElementById('signup-form').addEventListener('submit', async (e) => {
            e.preventDefault();
            const username = document.getElementById('signup-username').value;
            const email = document.getElementById('signup-email').value;
            const password = document.getElementById('signup-password').value;

            // Simulate a signup (in real use case, replace with server request)
            console.log(`Signed up with Username: ${username}, Email: ${email}`);
            alert('Sign up successful');
            hideModal('signup-modal');
        });
    }

    // Dashboard Page
    if (window.location.pathname.endsWith('dashboard.html')) {
        if (!sessionStorage.getItem('loggedIn')) {
            window.location.href = 'index.html';
            return;
        }

        setContent('#app-name', data.appName);
        setContent('#page-title', `${data.appName} - Dashboard`);
        setContent('#dashboard-link', data.navbar.dashboard);
        setContent('#logout-btn', data.navbar.logout);

        // Load Sidebar
        const sidebar = document.getElementById('sidebar');
        if (sidebar) {
            const sidebarContent = `
                <h2>${data.sidebar.title}</h2>
                <ul>
                    ${data.sidebar.links.map(link => `<li><a href="${link.url}">${link.name}</a></li>`).join('')}
                </ul>
            `;
            sidebar.innerHTML = sidebarContent;
        }

        // Dashboard Content
        const dashboardContent = `
            <h2>${data.dashboard.title}</h2>
            <p>${data.dashboard.welcomeMessage}</p>
            <section>
                <h3>${data.dashboard.userStats.title}</h3>
                <ul>
                    <li>${data.dashboard.userStats.totalProjects}: 5</li>
                    <li>${data.dashboard.userStats.completedTasks}: 10</li>
                    <li>${data.dashboard.userStats.pendingTasks}: 2</li>
                    <li>${data.dashboard.userStats.totalUsers}: 100</li>
                </ul>
            </section>
            <section>
                <h3>${data.dashboard.recentActivities.title}</h3>
                <ul>
                    ${data.dashboard.recentActivities.activityList.map(activity => `<li>${activity}</li>`).join('')}
                </ul>
            </section>
            <section>
                <h3>${data.dashboard.quickActions.title}</h3>
                <ul>
                    ${data.dashboard.quickActions.actions.map(action => `<li>${action}</li>`).join('')}
                </ul>
            </section>
            <section>
                <h3>${data.dashboard.recentProjects.title}</h3>
                <ul>
                    ${data.dashboard.recentProjects.projects.map(project => `<li>${project}</li>`).join('')}
                </ul>
            </section>
            <section>
                <h3>${data.dashboard.notifications.title}</h3>
                <ul>
                    ${data.dashboard.notifications.notificationsList.map(notification => `<li>${notification}</li>`).join('')}
                </ul>
            </section>
            <section>
                <h3>${data.dashboard.settings.title}</h3>
                <ul>
                    ${data.dashboard.settings.options.map(option => `<li>${option}</li>`).join('')}
                </ul>
            </section>
        `;
        setContent('#dashboard-content', dashboardContent);

        // Handle logout
        document.getElementById('logout-btn').addEventListener('click', () => {
            sessionStorage.removeItem('loggedIn');
            window.location.href = 'index.html';
        });
    }
});
