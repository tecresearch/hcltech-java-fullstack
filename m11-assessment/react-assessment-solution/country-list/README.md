# React: 19

Given a partially completed React application with the HTML template built and ready, your task is to implement a filter that searches and displays matching countries in a list.


Certain core React functionalities have already been implemented. Complete the React application in order to pass all the unit tests.

**Application Demo:**  
![](https://hrcdn.net/s3_pub/istreet-assets/qilbsKltcR6vtc-6zMHAXw/f.gif)

The application has 2 components:

1. The Search view, which has the input box where the user can type to filter countries.

2. The CountryList view, which renders the list of countries that are filtered.


The entire list of countries to be displayed is stored in a variable named response inside the file `src/response.js`.


The app should implement the following functionalities:

- The initial view should render an empty input box with all countries appearing in the same order as in the `response` variable.

- On typing a character, each country containing the set of typed characters should be filtered and displayed.

- The filtering done over the country list should be case insensitive.

- When there is no character typed in the search box, it should show all countries.


Note:

- Get the list of countries to be displayed from the `response.js` file.

- The order in which each country appears should follow the same order in the `response.js` file, even after filtering.



The following data-testid attributes are required in the component for the tests to pass:

- The countries filter field `<input>` tag should have the data-testid attribute `filterInput`.

- The countries wrapper `<ul>` tag should have the data-testid attribute `countryList`.


Please note that the component has the above data-testid attributes for test cases. It is advised not to change them.


## Environment 

- React Version: 19
- Default Port: 8000


**Read Only Files**
- `src/App.test.js`


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

