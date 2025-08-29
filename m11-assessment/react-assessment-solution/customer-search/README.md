# React: 19

## Environment 

- React Version: 19
- Node Version: 22(LTS)
- Default Port: 8000

## Application Demo:

![](https://hrcdn.net/s3_pub/istreet-assets/APWexJLC9i9cRlAMHWroOg/Screen-Recording-2022-10-21-at-3.gif)

The list of available customers and their details is imported as List in the SearchCustomer component. Use the list to render them as shown.

## Functionality Requirements

The component must have the following functionalities:

- Initially, the input field must be empty. Whenever the input is empty, all the customers passed in the input to the component must be rendered in the       list.
- The type of input in the input box should be text.
- As soon as the search term is typed in the input, search customer records that starts with the search term present in any customer field. For example, if   the search term is "Phil", then records with the name "Philip Anderson" and the location "Philadelphia" should be displayed in the results.
- The searched list should preserve the order customers are given in the input to the component.
- If the search term has no searched customers, then do not render the table but instead display a message "No Results Found!".
- The search results should be case-sensitive.

## Project Specifications

**Read Only Files**

    - src/App.test.js
    - src/App.js
    - src/App.css
    - src/index.css
    - src/index.js
    - src/List.js
    - src/registerServiceWorker.js


**Commands**
- run: 
```bash
npm start
```
- install: 
```bash
npm install
```
- test: 
```bash
npm test
```
