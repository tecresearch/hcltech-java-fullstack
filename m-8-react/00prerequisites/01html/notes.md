```
#Learn HTML

1. Document Structure Tags (5)
<html>, <head>, <title>, <body>, <base>
=====================================================

1. Document Structure Tags in HTML
These tags are essential for defining the structure of an 
HTML document. 
1. <html> (Root Element)
The <html> tag is the root of an HTML document. 
It contains all the other elements inside it.

<!DOCTYPE html>
<html>
<head>
    <title>My First HTML Page</title>
</head>
<body>
    <h1>Welcome to My Website</h1>
    <p>This is a simple HTML document.</p>
</body>
</html>


2. <head> (Metadata Section)
The <head> tag contains metadata (information about the document) like:

Title of the webpage
Links to CSS, JavaScript, and fonts
SEO meta tags

<head>
    <title>About Us</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="This is an About Us page.">
    <link rel="stylesheet" href="styles.css">
</head>

✅ Explanation:

<title> sets the tab title of the webpage.
<meta charset="UTF-8"> ensures correct text encoding.
<meta name="viewport" content="width=device-width, initial-scale=1.0"> makes the page responsive.
<link rel="stylesheet" href="styles.css"> links to an external CSS file.

3. <title> (Page Title)
The <title> tag defines the title that appears in the browser tab.

<title>My Portfolio</title>


4. <body> (Visible Content)
The <body> tag contains everything that is visible to users,
such as:

Headings, paragraphs
Images, links, buttons
Forms, tables, etc.

<body>
    <h1>Welcome to My Blog</h1>
    <p>This is a blog about technology and programming.</p>
    <img src="blog-image.jpg" alt="Blog Image">
</body>
✅ Explanation:

The <body> contains visible elements.
The <h1> and <p> are text elements.
The <img> tag displays an image.

5. <base> (Base URL for Links)
The <base> tag sets the base URL for all relative links in the document.

<head>
<baes href="https://www.example.com/">
</head>
<body>
    <a href="contact.html">Contact Us</a>
</body>

✅ Explanation:

Without <base>, href="contact.html" means the file is in the same folder.
With <base>, the link becomes https://www.example.com/contact.html.

==============================================================================

2. Metadata Tags (7)
<meta>, <link>, <style>, <script>, <noscript>, <template>, <slot>
==============================================================================

2. Metadata Tags in HTML
Metadata tags provide information about a web page but are 
not displayed directly
to users. These tags help with SEO, 
styling, scripting, and accessibility.


1. <meta> (Metadata Information)
The <meta> tag provides metadata about the document,
such as character set, 
viewport settings, description, and keywords.

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="A blog about web development and programming.">
    <meta name="keywords" content="HTML, CSS, JavaScript, Web Development">
    <meta name="author" content="John Doe">
</head>

✅ Explanation:

<meta charset="UTF-8"> → Ensures the correct text encoding.
<meta name="viewport"> → Makes the page responsive on mobile.
<meta name="description"> → Helps search engines understand the page.
<meta name="keywords"> → (Outdated but still used in some cases for SEO).
<meta name="author"> → Specifies the webpage’s author.

2. <link> (Link External Resources)
The <link> tag is used to connect external resources,
 such as CSS files, fonts, and icons.

<head>
    <link rel="stylesheet" href="styles.css">  <!-- Link to external CSS -->
    <link rel="icon" type="image/png" href="favicon.png">  <!-- Website favicon -->
</head>

 Explanation:

<link rel="stylesheet" href="styles.css"> → Links an external CSS file.
<link rel="icon" href="favicon.png"> → Adds a favicon (small icon in the browser tab).


3. <style> (Internal CSS Styling)
The <style> tag allows adding CSS styles inside an HTML document.

<head>
    <style>
        body {
            background-color: lightblue;
            font-family: Arial, sans-serif;
        }
        h1 {
            color: navy;
        }
    </style>
</head>

✅ Explanation:

The <style> tag is placed inside <head>.
It defines styles for the webpage (background, text color, font, etc.).

4. <script> (JavaScript Execution)
The <script> tag is used to add JavaScript to an HTML page.
<head>
    <script src="script.js"></script>  <!-- External JS file -->
</head>

script.js
<head>
    <script>
        function showAlert() {
            alert("Hello, Welcome to my website!");
        }
    </script>
</head>
<body>
    <button onclick="showAlert()">Click Me</button>
</body>


✅ Explanation:

The <script> tag allows adding JavaScript.
JavaScript can be written inside <script> or linked externally.

5. <noscript> (Fallback for No JavaScript)
The <noscript> tag provides alternative content for users whose browsers 
do not support JavaScript.

6. <template> (Reusable HTML Content)
The <template> tag is used to define reusable HTML code that is
 not displayed until activated with JavaScript.

<template id="cardTemplate">
    <div class="card">
        <h2>Title</h2>
        <p>Description here...</p>
    </div>
</template>

<script>
    let template = document.getElementById("cardTemplate");
    let clone = template.content.cloneNode(true);
    document.body.appendChild(clone);
</script>


✅ Explanation:

The <template> tag contains HTML that is not rendered immediately.
JavaScript is used to insert its content dynamically.


7. <slot> (For Web Components)
The <slot> tag is used inside custom web components
to define placeholders for content.

<custom-card>
    <h2 slot="title">My Card Title</h2>
    <p slot="description">This is a custom card.</p>
</custom-card>

<template id="cardTemplate">
    <div class="card">
        <slot name="title"></slot>
        <slot name="description"></slot>
    </div>
</template>

<script>
    class CustomCard extends HTMLElement {
        constructor() {
            super();
            let template = document.getElementById("cardTemplate").content;
            this.attachShadow({ mode: "open" }).appendChild(template.cloneNode(true));
        }
    }
    customElements.define("custom-card", CustomCard);
</script>


✅ Explanation:

<slot> acts as a placeholder inside a custom component.
Developers can pass content into it.
=================================================================






ALL THE NECCESSARY BODY TAGS

3. Sectioning Tags (9)
Symentic tags: <header>, <nav>, <section>, <article>, <aside>, <footer>, <main>, <address>, <hgroup>
-----------------------------------------------------------------------------------------------------------


✅ Complete Code with Definitions
html
Copy code
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Example of Sectioning Tags in HTML">
    <meta name="keywords" content="HTML, Sectioning Tags, Semantic Elements">
    <meta name="author" content="John Doe">
    <title>Sectioning Tags Example</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header, nav, section, article, aside, footer {
            margin: 20px;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
        }
        nav ul {
            list-style-type: none;
            padding: 0;
        }
        nav ul li {
            display: inline;
            margin-right: 10px;
        }
        address {
            font-style: italic;
        }
    </style>
</head>
<body>

    <!-- <header>: Represents the introductory section of a webpage or a section -->
    <header>
        <h1>Welcome to My Website</h1>
        <p>Your go-to source for web development tutorials.</p>
    </header>

    <!-- <nav>: Defines a navigation menu containing links -->
    <nav>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Services</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
    </nav>

    <!-- <main>: The main content of the document, unique per page -->
    <main>
        <!-- <section>: Represents a thematic grouping of content -->
        <section>
            <h2>Latest Articles</h2>
            <p>Find the most recent updates on web technologies.</p>
        </section>

        <!-- <article>: Represents an independent piece of content -->
        <article>
            <h2>Understanding Semantic HTML</h2>
            <p>Semantic HTML improves accessibility and SEO.</p>
        </article>
    </main>

    <!-- <aside>: Represents additional content related to the main content -->
    <aside>
        <h3>Related Topics</h3>
        <ul>
            <li>CSS Grid Layout</li>
            <li>JavaScript ES6 Features</li>
            <li>Building Responsive Websites</li>
        </ul>
    </aside>

    <!-- <footer>: Represents the footer of a document or section -->
    <footer>
        <p>&copy; 2025 My Website. All Rights Reserved.</p>
    </footer>

    <!-- <address>: Provides contact details -->
    <address>
        Contact us at: <a href="mailto:support@mywebsite.com">support@mywebsite.com</a>
    </address>

    <!-- <hgroup>: Groups related headings -->
    <hgroup>
        <h1>Web Development Tutorials</h1>
        <h2>Learn, Code, and Build</h2>
    </hgroup>

</body>
</html>
✅ Explanation of Each Sectioning Tag
Tag	Definition
<header>	Represents introductory content, such as a website banner or page title.
<nav>	Defines a navigation menu with links to different sections of the site.
<section>	Groups related content together, such as articles on the same topic.
<article>	Represents a self-contained piece of content, such as a blog post or news article.
<aside>	Contains secondary or supplementary content, like sidebars or ads.
<footer>	Defines the footer of a document, usually containing copyright info or links.
<main>	Represents the primary content of the document (should be unique per page).
<address>	Provides contact details, typically for the author or organization.
<hgroup>	Groups multiple related headings (<h1> - <h6>) together for better structure.



4. Heading Tags (6)
<h1>, <h2>, <h3>, <h4>, <h5>, <h6>
=========================================================================
Here are some interview questions related to HTML Heading Tags 
(<h1> to <h6>) along with their answers:

✅ Basic Questions
1️⃣ What are HTML heading tags?

HTML provides six heading tags (<h1> to <h6>), where <h1> is the largest and most important, while <h6> is the smallest and least important.
2️⃣ What is the purpose of using heading tags in HTML?

They define the structure of the content, improve readability, and enhance SEO by helping search engines understand the page hierarchy.
3️⃣ What is the difference between <h1> and <h6>?

<h1> is the most important and largest heading, whereas <h6> is the least important and smallest heading.
✅ Intermediate Questions
4️⃣ How do heading tags affect SEO (Search Engine Optimization)?

Search engines prioritize <h1> for understanding page content. Proper use of headings improves page ranking.
5️⃣ Can we use multiple <h1> tags on a webpage?

Yes, but it's recommended to have only one <h1> per page for SEO best practices, as it represents the main heading of the page.
6️⃣ What happens if you don’t use heading tags properly?

It can make the content harder to read and negatively impact SEO, making it difficult for search engines to index the page properly.
7️⃣ Is there any default styling applied to heading tags?

Yes, browsers apply bold text and different font sizes to heading tags by default.
8️⃣ Can heading tags be customized with CSS?

Yes, using properties like font-size, color, and margin, we can customize their appearance.
✅ Advanced Questions
9️⃣ How does <h1> impact accessibility for screen readers?

Screen readers rely on <h1> for navigation. Proper heading structure improves accessibility for visually impaired users.
🔟 What is the correct way to structure headings in HTML?

Always follow a hierarchical order: <h1> → <h2> → <h3> and so on, without skipping levels unnecessarily.
1️⃣1️⃣ Can you use headings inside <article> or <section> tags?

Yes, headings can be used inside these tags to define sub-sections clearly.
1️⃣2️⃣ What happens if you use <h1> multiple times on a page?

It can confuse search engines about the primary topic of the page, potentially harming SEO.
1️⃣3️⃣ How do headings contribute to web accessibility?

They help users with screen readers navigate content efficiently.
✅ Practical Question
📌 Write an HTML example using all six heading tags.

html
Copy code
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Heading Tags Example</title>
</head>
<body>

    <h1>Main Title of the Page</h1>
    <h2>Section Title</h2>
    <h3>Subsection Title</h3>
    <h4>Detailed Explanation</h4>
    <h5>Additional Information</h5>
    <h6>Footnotes or Small Notes</h6>

</body>
</html>
These questions cover basic, intermediate, and advanced levels to help you prepare for interviews on HTML heading tags. Let me know if you need more! 😊

The default font-size (in pixels) for each HTML heading tag varies across browsers, but the standard sizes (in most browsers like Chrome, Firefox, and Edge) are:

Heading Tag	Default Font Size (px)	Default Font Weight
<h1>	32px	Bold
<h2>	24px	Bold
<h3>	18.72px	Bold
<h4>	16px	Bold
<h5>	13.28px	Bold
<h6>	10.72px	Bold
🔹 Browsers apply bold styling to all heading tags by default.
🔹 These sizes can be overridden using CSS.

✅ Example: Customizing Heading Sizes with CSS
html
Copy code
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Heading Sizes</title>
    <style>
        h1 { font-size: 40px; color: blue; }
        h2 { font-size: 30px; color: green; }
        h3 { font-size: 25px; color: orange; }
        h4 { font-size: 20px; color: red; }
        h5 { font-size: 16px; color: purple; }
        h6 { font-size: 12px; color: gray; }
    </style>
</head>
<body>
    <p>headings font-size can be change via css</p>
    <h1>Heading 1 -original-font-size(32) after change=> 40px </h1>
    <h2>Heading 2 -original-font-size(24) after change=> 30px</h2>
    <h3>Heading 3 -original-font-size(18.72) after change=> 25px</h3>
    <h4>Heading 4 -original-font-size(16) after change=> 20px</h4>
    <h5>Heading 5 -original-font-size(13.28) after change=> 16px</h5>
    <h6>Heading 6 -original-font-size(10.72) after change=> 12px</h6>

</body>
</html>
📝 Can We Change These Sizes?
Yes! Using CSS (font-size), you can modify the heading sizes as per your design requirements.

================================================================================================================================================


5. Text Content Tags (14)
<p>, <hr>, <pre>, <blockquote>, <ol>, <ul>, <li>, <dl>, <dt>, <dd>,
 <figure>, <figcaption>, <div>, <span>
---------------------------------------------------------------------------------------------------------------
Explanation of Each Tag:
<p> (Paragraph): Defines a block of text.
<hr> (Horizontal Rule): Creates a horizontal line for separating content.
<pre> (Preformatted Text): Preserves spaces and line breaks.
<blockquote> (Blockquote): Displays a section of quoted text.
<ol> (Ordered List): Creates a numbered list.
<ul> (Unordered List): Creates a bulleted list.
<li> (List Item): Defines individual items inside <ol> or <ul>.
<dl> (Definition List): Contains terms and their definitions.
<dt> (Definition Term): Defines the term in a <dl>.
<dd> (Definition Description): Provides the meaning of <dt>.
<figure> (Figure Container): Groups images, illustrations, etc.
<figcaption> (Figure Caption): Provides a caption for the <figure>.
<div> (Division Block): A block-level container for grouping elements.
<span> (Inline Span): An inline container used for styling text.

============================================================================================================

6. Inline Text Formatting Tags (14)
<a>, <b>, <i>, <u>, <strong>, <em>, <small>, <mark>, <del>, <ins>, <sub>, <sup>, <code>, <cite>
---------------------------------------------------------------------------------------------------------

Explanation of Each Tag:
<a> (Anchor): Creates a hyperlink.
<b> (Bold): Makes text bold without semantic meaning.
<i> (Italic): Makes text italic for styling purposes.
<u> (Underline): Underlines text.
<strong> (Strong Importance): Makes text bold and important.
<em> (Emphasis): Italicizes text and gives it semantic emphasis.
<small> (Small Text): Displays text in a smaller font.
<mark> (Highlighted Text): Highlights text with a background color.
<del> (Deleted Text): Represents deleted text with a strikethrough.
<ins> (Inserted Text): Represents newly inserted text with an underline.
<sub> (Subscript): Displays text below the baseline.
<sup> (Superscript): Displays text above the baseline.
<code> (Code Formatting): Displays programming code in a monospace font.
<cite> (Citation): Used to reference works like books, movies, or research papers.
==============================================================================================================

7. Forms and Input Tags (17)
<form>, <input>, <label>, <button>, <select>, <option>, <optgroup>,
 <textarea>, <fieldset>, <legend>, <output>, <datalist>, <progress>,
  <meter>, <keygen> (obsolete), <menu>, <menuitem> (obsolete)
----------------------------------------------------------------------------------------------

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forms and Input Tags</title>
</head>
<body>

    <h2>Forms and Input Tags with Definitions</h2>

    <!-- Form Tag -->
    <p>
        <strong>&lt;form&gt; (Form Tag):</strong> The <code>&lt;form&gt;</code> tag is used to create an HTML form 
        for user input. It can contain various input fields, buttons, and controls.
    </p>
    <form action="#" method="post">
        <label for="name">Enter Name:</label>
        <input type="text" id="name" name="name">
        <button type="submit">Submit</button>
    </form>
    <hr>

    <!-- Input Tag -->
    <p>
        <strong>&lt;input&gt; (Input Tag):</strong> The <code>&lt;input&gt;</code> tag allows users to enter 
        data into a form. It supports various types like text, password, checkbox, radio, etc.
    </p>
    <form>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email">
    </form>
    <hr>

    <!-- Label Tag -->
    <p>
        <strong>&lt;label&gt; (Label Tag):</strong> The <code>&lt;label&gt;</code> tag provides a label 
        for form elements, making them more accessible.
    </p>
    <form>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
    </form>
    <hr>

    <!-- Button Tag -->
    <p>
        <strong>&lt;button&gt; (Button Tag):</strong> The <code>&lt;button&gt;</code> tag creates a clickable button.
    </p>
    <form>
        <button type="submit">Click Me</button>
    </form>
    <hr>

    <!-- Select, Option, and Optgroup -->
    <p>
        <strong>&lt;select&gt;, &lt;option&gt;, &lt;optgroup&gt; (Dropdown List):</strong> 
        The <code>&lt;select&gt;</code> tag creates a dropdown menu. The <code>&lt;option&gt;</code> tag 
        defines individual options, while <code>&lt;optgroup&gt;</code> groups related options.
    </p>
    <form>
        <label for="country">Choose a country:</label>
        <select id="country" name="country">
            <optgroup label="Europe">
                <option value="france">France</option>
                <option value="germany">Germany</option>
            </optgroup>
            <optgroup label="Asia">
                <option value="india">India</option>
                <option value="japan">Japan</option>
            </optgroup>
        </select>
    </form>
    <hr>

    <!-- Textarea -->
    <p>
        <strong>&lt;textarea&gt; (Multiline Input):</strong> The <code>&lt;textarea&gt;</code> tag allows users 
        to enter multiple lines of text.
    </p>
    <form>
        <label for="message">Your Message:</label>
        <textarea id="message" name="message" rows="4" cols="30"></textarea>
    </form>
    <hr>

    <!-- Fieldset and Legend -->
    <p>
        <strong>&lt;fieldset&gt; and &lt;legend&gt; (Grouping Form Elements):</strong> 
        The <code>&lt;fieldset&gt;</code> tag groups related form elements, and <code>&lt;legend&gt;</code> 
        provides a caption for the fieldset.
    </p>
    <form>
        <fieldset>
            <legend>Personal Information</legend>
            <label for="fname">First Name:</label>
            <input type="text" id="fname" name="fname">
        </fieldset>
    </form>
    <hr>

    <!-- Output -->
    <p>
        <strong>&lt;output&gt; (Displaying Calculation Results):</strong> 
        The <code>&lt;output&gt;</code> tag is used to display the result of a calculation.
    </p>
    <form oninput="result.value=parseInt(num1.value)+parseInt(num2.value)">
        <input type="number" id="num1" name="num1" value="0"> +
        <input type="number" id="num2" name="num2" value="0"> =
        <output name="result">0</output>
    </form>
    <hr>

    <!-- Datalist -->
    <p>
        <strong>&lt;datalist&gt; (Predefined Input Suggestions):</strong> 
        The <code>&lt;datalist&gt;</code> tag provides a list of predefined options for an input field.
    </p>
    <form>
        <label for="browser">Choose a browser:</label>
        <input list="browsers" id="browser" name="browser">
        <datalist id="browsers">
            <option value="Chrome">
            <option value="Firefox">
            <option value="Edge">
            <option value="Safari">
        </datalist>
    </form>
    <hr>

    <!-- Progress Bar -->
    <p>
        <strong>&lt;progress&gt; (Progress Bar):</strong> 
        The <code>&lt;progress&gt;</code> tag represents the progress of a task.
    </p>
    <progress value="70" max="100"></progress>
    <hr>

    <!-- Meter -->
    <p>
        <strong>&lt;meter&gt; (Measurement Indicator):</strong> 
        The <code>&lt;meter&gt;</code> tag represents a measurement within a known range.
    </p>
    <meter value="2" min="0" max="5"></meter>
    <hr>

    <!-- Keygen (Obsolete) -->
    <p>
        <strong>&lt;keygen&gt; (Obsolete Key Pair Generator):</strong> 
        The <code>&lt;keygen&gt;</code> tag was used for generating key pairs but is now deprecated.
    </p>
    <p>Note: This tag is no longer supported in modern browsers.</p>
    <hr>

    <!-- Menu and Menuitem (Obsolete) -->
    <p>
        <strong>&lt;menu&gt; and &lt;menuitem&gt; (Obsolete Menu Elements):</strong> 
        These tags were used for context menus but are now deprecated.
    </p>
    <p>Note: These tags are no longer supported in modern browsers.</p>

</body>
</html>
----------------------------------------------------------------
Explanation of Each Tag:
<form> → Creates an HTML form.
<input> → Accepts user input (text, number, email, etc.).
<label> → Provides a label for form inputs.
<button> → Creates a clickable button.
<select> → Creates a dropdown menu.
<option> → Defines an option inside <select>.
<optgroup> → Groups related <option> elements.
<textarea> → Allows multiple lines of input.
<fieldset> → Groups related form elements.
<legend> → Provides a title for <fieldset>.
<output> → Displays calculated results.
<datalist> → Provides predefined input suggestions.
<progress> → Displays task progress.
<meter> → Displays a measurement within a range.
<keygen> (obsolete) → Used to generate key pairs (deprecated).
<menu> (obsolete) → Used for context menus (deprecated).
<menuitem> (obsolete) → Defined menu items (deprecated).

==================================================================================================


8. Interactive Elements (5)
<details>, <summary>, <dialog>, <marquee> (deprecated), <bdi>
----------------------------------------------------------------------------------------


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Interactive Elements</title>
</head>
<body>

    <h2>Interactive Elements with Definitions</h2>

    <!-- Details and Summary -->
    <p>
        <strong>&lt;details&gt; and &lt;summary&gt; (Expandable Content):</strong> 
        The <code>&lt;details&gt;</code> tag creates a collapsible section, and <code>&lt;summary&gt;</code> 
        defines the visible heading for the content.
    </p>
    <details>
        <summary>Click to reveal more information</summary>
        <p>This is additional content that can be toggled.</p>
    </details>
    <hr>

    <!-- Dialog -->
    <p>
        <strong>&lt;dialog&gt; (Modal Dialog Box):</strong> 
        The <code>&lt;dialog&gt;</code> tag represents a pop-up dialog box.
    </p>
    <dialog id="myDialog">
        <p>This is a dialog box!</p>
        <button onclick="document.getElementById('myDialog').close()">Close</button>
    </dialog>
    <button onclick="document.getElementById('myDialog').showModal()">Open Dialog</button>
    <hr>

    <!-- Marquee (Deprecated) -->
    <p>
        <strong>&lt;marquee&gt; (Scrolling Text - Deprecated):</strong> 
        The <code>&lt;marquee&gt;</code> tag was used for scrolling text but is now deprecated.
    </p>
    <marquee behavior="scroll" direction="left">This text scrolls from right to left.</marquee>
    <p>Note: The <code>&lt;marquee&gt;</code> tag is obsolete and should be avoided in modern web development.</p>
    <hr>

    <!-- BDI -->
    <p>
        <strong>&lt;bdi&gt; (Bi-Directional Isolation):</strong> 
        The <code>&lt;bdi&gt;</code> tag isolates text that might have different text directionality.
    </p>
    <p>Username: <bdi>مرحبا</bdi> (This Arabic text remains unaffected by surrounding content direction.)</p>

</body>
</html>


--------------------

Explanation of Each Tag:
<details> → Creates a collapsible section.
<summary> → Defines the heading inside <details>.
<dialog> → Represents a pop-up dialog box.
<marquee> (deprecated) → Used to create scrolling text (no longer recommended).
<bdi> → Isolates text with different text directionality (useful for multilingual content).
----------------------------------------------------------------------------------------------------------------


9. Table Tags (12)
<table>, <caption>, <thead>, <tbody>, <tfoot>, <tr>, <th>, <td>, <col>, <colgroup>, <fieldset>, <legend>
===========================================================================================================
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Table Tags in HTML</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: lightgray;
        }
    </style>
</head>
<body>

    <h2>Table Tags with Definitions and Examples</h2>

    <!-- Table -->
    <p>
        <strong>&lt;table&gt; (Table Structure):</strong> 
        The <code>&lt;table&gt;</code> tag is used to define a table.
    </p>
    <table>
        <caption><strong>Student Marks Table</strong></caption>
        <thead>
            <tr>
                <th>Name</th>
                <th>Math</th>
                <th>Science</th>
                <th>English</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Alice</td>
                <td>85</td>
                <td>90</td>
                <td>88</td>
            </tr>
            <tr>
                <td>Bob</td>
                <td>78</td>
                <td>76</td>
                <td>80</td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="3">Total Students</td>
                <td>2</td>
            </tr>
        </tfoot>
    </table>

    <!-- Table Explanation -->
    <h3>Table Tags and Definitions</h3>

    <ul>
        <li><strong>&lt;table&gt;:</strong> Defines a table.</li>
        <li><strong>&lt;caption&gt;:</strong> Specifies a title for the table.</li>
        <li><strong>&lt;thead&gt;:</strong> Groups header content inside a table.</li>
        <li><strong>&lt;tbody&gt;:</strong> Groups the main body content of a table.</li>
        <li><strong>&lt;tfoot&gt;:</strong> Defines the footer content of a table.</li>
        <li><strong>&lt;tr&gt; (Table Row):</strong> Represents a row inside a table.</li>
        <li><strong>&lt;th&gt; (Table Header):</strong> Defines a header cell.</li>
        <li><strong>&lt;td&gt; (Table Data):</strong> Defines a data cell.</li>
    </ul>

    <h3>Column Management in Tables</h3>

    <p><strong>&lt;col&gt; and &lt;colgroup&gt; (Column Formatting):</strong></p>
    <table>
        <colgroup>
            <col style="background-color: lightblue;">
            <col style="background-color: lightyellow;">
            <col style="background-color: lightgreen;">
        </colgroup>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Stock</th>
        </tr>
        <tr>
            <td>Phone</td>
            <td>$500</td>
            <td>Available</td>
        </tr>
        <tr>
            <td>Laptop</td>
            <td>$1200</td>
            <td>Out of Stock</td>
        </tr>
    </table>

    <h3>Grouping Form Elements</h3>

    <p><strong>&lt;fieldset&gt; and &lt;legend&gt; (Grouping Form Elements):</strong></p>
    <form>
        <fieldset>
            <legend>Personal Information</legend>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name"><br><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email"><br><br>
            <button type="submit">Submit</button>
        </fieldset>
    </form>

</body>
</html>
----------------------------------------------------
Explanation of Each Table Tag:
<table> → Creates a table.
<caption> → Provides a title for the table.
<thead> → Groups the header row of the table.
<tbody> → Groups the main content of the table.
<tfoot> → Defines the footer section of the table.
<tr> → Defines a row in the table.
<th> → Represents a table header cell.
<td> → Represents a table data cell.
<col> → Defines styling for individual columns.
<colgroup> → Groups multiple <col> elements for styling.
<fieldset> → Groups form elements together.
<legend> → Provides a caption for a <fieldset>.

--------------------------------------------------------------------------



10. Embedded Content Tags (9)
<img>, <audio>, <video>, <source>, <track>, <iframe>, <embed>, <object>, <param>
=====================================================================================
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Embedded Content Tags in HTML</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        img, audio, video, iframe, embed, object {
            margin-bottom: 20px;
            display: block;
        }
    </style>
</head>
<body>

    <h2>Embedded Content Tags with Definitions and Examples</h2>

    <!-- 1. <img> Tag -->
    <h3>1. &lt;img&gt; - Display an Image</h3>
    <p>
        The <code>&lt;img&gt;</code> tag is used to embed images in an HTML page.
        It requires the <code>src</code> attribute to specify the image path and the <code>alt</code> attribute for alternative text.
    </p>
    <img src="https://via.placeholder.com/300" alt="Sample Image" width="300">

    <!-- 2. <audio> Tag -->
    <h3>2. &lt;audio&gt; - Embed Audio Files</h3>
    <p>
        The <code>&lt;audio&gt;</code> tag is used to embed audio files in a webpage. The <code>controls</code> attribute adds play, pause, and volume options.
    </p>
    <audio controls>
        <source src="sample-audio.mp3" type="audio/mp3">
        Your browser does not support the audio element.
    </audio>

    <!-- 3. <video> Tag -->
    <h3>3. &lt;video&gt; - Embed Video Files</h3>
    <p>
        The <code>&lt;video&gt;</code> tag is used to embed video content in a webpage.
        The <code>controls</code> attribute provides play, pause, and volume controls.
    </p>
    <video width="320" height="240" controls>
        <source src="sample-video.mp4" type="video/mp4">
        Your browser does not support the video tag.
    </video>

    <!-- 4. <source> Tag -->
    <h3>4. &lt;source&gt; - Specify Media Source</h3>
    <p>
        The <code>&lt;source&gt;</code> tag allows multiple media formats to be specified inside <code>&lt;audio&gt;</code> and <code>&lt;video&gt;</code> elements.
    </p>
    <video width="320" height="240" controls>
        <source src="sample-video.mp4" type="video/mp4">
        <source src="sample-video.ogg" type="video/ogg">
        Your browser does not support the video tag.
    </video>

    <!-- 5. <track> Tag -->
    <h3>5. &lt;track&gt; - Add Subtitles to Video</h3>
    <p>
        The <code>&lt;track&gt;</code> tag is used to add subtitles or captions to videos.
    </p>
    <video width="320" height="240" controls>
        <source src="sample-video.mp4" type="video/mp4">
        <track src="subtitles.vtt" kind="subtitles" srclang="en" label="English">
        Your browser does not support the video tag.
    </video>

    <!-- 6. <iframe> Tag -->
    <h3>6. &lt;iframe&gt; - Embed an External Webpage</h3>
    <p>
        The <code>&lt;iframe&gt;</code> tag is used to embed another webpage inside the current page.
    </p>
    <iframe src="https://www.example.com" width="600" height="300"></iframe>

    <!-- 7. <embed> Tag -->
    <h3>7. &lt;embed&gt; - Embed External Content</h3>
    <p>
        The <code>&lt;embed&gt;</code> tag is used to embed external content like PDF, Flash, or music players.
    </p>
    <embed src="sample.pdf" width="500" height="400" type="application/pdf">

    <!-- 8. <object> Tag -->
    <h3>8. &lt;object&gt; - Embed External Resources</h3>
    <p>
        The <code>&lt;object&gt;</code> tag is used to embed objects like PDF, Flash files, and Java applets.
    </p>
    <object data="sample.pdf" type="application/pdf" width="500" height="400">
        <p>PDF cannot be displayed.</p>
    </object>

    <!-- 9. <param> Tag -->
    <h3>9. &lt;param&gt; - Define Parameters for Objects</h3>
    <p>
        The <code>&lt;param&gt;</code> tag is used to define parameters for embedded objects.
    </p>
    <object data="sample.swf" type="application/x-shockwave-flash" width="400" height="300">
        <param name="autoplay" value="true">
        <param name="loop" value="false">
    </object>

</body>
</html>
-----------------------------------------
Explanation of Embedded Content Tags:
<img> → Displays an image.
<audio> → Embeds an audio file with play controls.
<video> → Embeds a video file with controls.
<source> → Specifies multiple media sources for <audio> and <video>.
<track> → Adds subtitles to a video.
<iframe> → Embeds another webpage inside the current page.
<embed> → Embeds external content like PDFs or Flash.
<object> → Embeds external resources like PDFs or Flash files.
<param> → Defines parameters for <object> elements.

-----------------------------------------------------------------------


11. Scripting Tags (4)
<script>, <noscript>, <canvas>, <template>
====================================================
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Scripting Tags in HTML</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        canvas {
            border: 1px solid black;
        }
    </style>
</head>
<body>

    <h2>Scripting Tags with Definitions and Examples</h2>

    <!-- 1. <script> Tag -->
    <h3>1. &lt;script&gt; - Embed JavaScript Code</h3>
    <p>
        The <code>&lt;script&gt;</code> tag is used to include JavaScript code within an HTML document. 
        It can be placed inside the `<head>` or `<body>` section.
    </p>
    <button onclick="showAlert()">Click Me</button>
    <script>
        function showAlert() {
            alert("Hello! This is a JavaScript alert.");
        }
    </script>

    <!-- 2. <noscript> Tag -->
    <h3>2. &lt;noscript&gt; - Fallback for Disabled JavaScript</h3>
    <p>
        The <code>&lt;noscript&gt;</code> tag provides alternative content when JavaScript is disabled in the browser.
    </p>
    <noscript>
        <p>Your browser does not support JavaScript or it is disabled.</p>
    </noscript>

    <!-- 3. <canvas> Tag -->
    <h3>3. &lt;canvas&gt; - Draw Graphics with JavaScript</h3>
    <p>
        The <code>&lt;canvas&gt;</code> tag is used to draw graphics on a webpage using JavaScript.
    </p>
    <canvas id="myCanvas" width="200" height="100"></canvas>
    <script>
        let canvas = document.getElementById("myCanvas");
        let ctx = canvas.getContext("2d");
        ctx.fillStyle = "blue";
        ctx.fillRect(10, 10, 150, 80);
    </script>

    <!-- 4. <template> Tag -->
    <h3>4. &lt;template&gt; - Define Reusable HTML Content</h3>
    <p>
        The <code>&lt;template&gt;</code> tag is used to store HTML code that can be cloned using JavaScript.
    </p>
    <template id="greetingTemplate">
        <p>Hello, this is a dynamic message!</p>
    </template>
    <button onclick="showTemplate()">Show Template Content</button>
    <div id="templateContainer"></div>
    <script>
        function showTemplate() {
            let template = document.getElementById("greetingTemplate");
            let clone = template.content.cloneNode(true);
            document.getElementById("templateContainer").appendChild(clone);
        }
    </script>

</body>
</html>
------------------------------------------
Explanation of Scripting Tags:
<script> → Used to include JavaScript code in an HTML document.
<noscript> → Provides an alternative message if JavaScript is disabled.
<canvas> → Creates a drawing area for graphics using JavaScript.
<template> → Stores reusable HTML code that can be cloned dynamically.

-----------------------------------------------------------------------------





12. Obsolete/Deprecated Tags (9)
<applet>, <acronym>, <bgsound>, <dir>, <frame>, <frameset>, <noframes>, <big>, <tt>
================================================================================================
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Obsolete/Deprecated Tags in HTML</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .deprecated {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <h2>Obsolete/Deprecated HTML Tags with Definitions and Examples</h2>
    <p class="deprecated">⚠️ These tags are no longer supported in HTML5 and should not be used.</p>

    <!-- 1. <applet> Tag -->
    <h3>1. &lt;applet&gt; - Embed Java Applets</h3>
    <p>
        The <code>&lt;applet&gt;</code> tag was used to embed Java applets, but it is now deprecated due to security concerns. 
        Use the `<object>` or `<embed>` tag instead.
    </p>
    <p class="deprecated">❌ This tag is no longer supported in modern browsers.</p>

    <!-- 2. <acronym> Tag -->
    <h3>2. &lt;acronym&gt; - Define Acronyms</h3>
    <p>
        The <code>&lt;acronym&gt;</code> tag was used to define acronyms, but it is now replaced by `<abbr>`.
    </p>
    <p><acronym title="Hypertext Markup Language">HTML</acronym> (Deprecated)</p>
    <p>✅ Use: <abbr title="Hypertext Markup Language">HTML</abbr></p>

    <!-- 3. <bgsound> Tag -->
    <h3>3. &lt;bgsound&gt; - Background Sound</h3>
    <p>
        The <code>&lt;bgsound&gt;</code> tag was used to play background music in webpages. 
        It is now replaced by `<audio>`.
    </p>
    <p class="deprecated">❌ This tag is no longer supported.</p>
    <p>✅ Use: <code>&lt;audio&gt;</code> instead.</p>

    <!-- 4. <dir> Tag -->
    <h3>4. &lt;dir&gt; - Directory List</h3>
    <p>
        The <code>&lt;dir&gt;</code> tag was used to create directory lists, but it is replaced by `<ul>`.
    </p>
    <p class="deprecated">❌ This tag is no longer supported.</p>
    <p>✅ Use:</p>
    <ul>
        <li>Item 1</li>
        <li>Item 2</li>
    </ul>

    <!-- 5. <frame> and <frameset> Tags -->
    <h3>5. &lt;frame&gt; &amp; &lt;frameset&gt; - Frames in Webpages</h3>
    <p>
        The <code>&lt;frame&gt;</code> and <code>&lt;frameset&gt;</code> tags were used to divide a webpage into multiple sections.
        They have been replaced by modern layouts using `<div>` and CSS Flexbox/Grid.
    </p>
    <p class="deprecated">❌ These tags are no longer supported.</p>

    <!-- 6. <noframes> Tag -->
    <h3>6. &lt;noframes&gt; - Alternative Content for Frames</h3>
    <p>
        The <code>&lt;noframes&gt;</code> tag was used to provide alternative content for browsers that do not support frames.
    </p>
    <p class="deprecated">❌ This tag is obsolete.</p>

    <!-- 7. <big> Tag -->
    <h3>7. &lt;big&gt; - Bigger Text</h3>
    <p>
        The <code>&lt;big&gt;</code> tag was used to increase font size, but it is now replaced by CSS.
    </p>
    <p><big>This text is big (Deprecated)</big></p>
    <p>✅ Use: <span style="font-size: 1.2em;">This is big text using CSS</span></p>

    <!-- 8. <tt> Tag -->
    <h3>8. &lt;tt&gt; - Teletype Text</h3>
    <p>
        The <code>&lt;tt&gt;</code> tag was used to display text in teletype (monospace), but it is replaced by `<code>` or `<pre>`.
    </p>
    <p><tt>This is teletype text (Deprecated)</tt></p>
    <p>✅ Use: <code>This is code text</code></p>

</body>
</html>
------------------------------------------------------------------------
Explanation of Deprecated Tags:
<applet> → Used for embedding Java applets (replaced by <object>).
<acronym> → Used for acronyms (replaced by <abbr>).
<bgsound> → Used for background music (replaced by <audio>).
<dir> → Used for directory lists (replaced by <ul>).
<frame> & <frameset> → Used to create frame-based layouts (replaced by CSS Flexbox/Grid).
<noframes> → Provided content for non-frame browsers (obsolete).
<big> → Used to increase text size (replaced by CSS font-size).
<tt> → Used for teletype text (replaced by <code> or <pre>).
























```