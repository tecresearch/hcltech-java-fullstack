import React from 'react';
import App from './App';
import {render, cleanup, fireEvent} from '@testing-library/react';
import customers from "./List";
import '@testing-library/jest-dom/extend-expect';


const renderApp = () => render(<App/>);

afterEach(() => {
    cleanup()
});

const TEST_IDS = {
    searchInput: "search-input",
    searchedCustomers: "searched-customers",
    noResults: "no-results"
}

let getByTestId, queryByTestId, searchInput, searchedCustomers, noResults;

beforeEach(() => {
    const app = render(<App />);
    getByTestId = app.getByTestId;
    queryByTestId = app.queryByTestId;
    searchInput = getByTestId(TEST_IDS.searchInput);
    searchedCustomers = queryByTestId(TEST_IDS.searchedCustomers);
})

const displayData = data => {
    for(let i = 0; i < data.length; i++) {
        const name = searchedCustomers.children[i].children[0];
        const age = searchedCustomers.children[i].children[1];
        const location = searchedCustomers.children[i].children[2];
        const gender = searchedCustomers.children[i].children[3];
        const income = searchedCustomers.children[i].children[4];

        expect(name).toHaveTextContent(data[i].name);
        expect(age).toHaveTextContent(data[i].age);
        expect(location).toHaveTextContent(data[i].location);
        expect(gender).toHaveTextContent(data[i].gender);
        expect(income).toHaveTextContent(data[i].income);
    }
}

it('The type of input in the search box should be text', () => {
    expect(searchInput).toHaveAttribute("type", "text");
});

it("should initially have no input string in the search box", () => {
    expect(searchInput).toHaveValue("");
})

it("should initially display all the data", () => {
    displayData(customers);
})

it("should display a message when no results are found for a text", () => {
    fireEvent.change(searchInput, {target: {value: "Philo"}});
    expect(searchedCustomers).not.toBeInTheDocument();
    noResults = queryByTestId(TEST_IDS.noResults);
    expect(noResults).toHaveTextContent("No Results Found!");
})

it("searched string should only be in the start of the results found", () => {
    fireEvent.change(searchInput, {target: {value: "Phil"}});
    expect(queryByTestId(TEST_IDS.noResults)).not.toBeInTheDocument();
    displayData([{
        name: "Philip Anderson",
        age: 18,
        location: "New York City",
        gender: "Female",
        income: "$150,000"
    },
        {
            name: "John Smith",
            age: 25,
            location: "Philadephia",
            gender: "Male",
            income: "$200,000"
        }
    ])
});

it("should display all the data when the input is dollar", () => {
    fireEvent.change(searchInput, {target: {value: "$"}});
    displayData(customers);
})

it("the search should be case-sensitive", () => {
    fireEvent.change(searchInput, {target: {value: "phi"}});
    expect(searchedCustomers).not.toBeInTheDocument();
    noResults = queryByTestId(TEST_IDS.noResults);
    expect(noResults).toHaveTextContent("No Results Found!");
})

it("the results for the result should be in the same order as that of original data", () => {
    fireEvent.change(searchInput, {target: {value: "Phil"}});
    expect(queryByTestId(TEST_IDS.noResults)).not.toBeInTheDocument();
    displayData([{
        name: "Philip Anderson",
        age: 18,
        location: "New York City",
        gender: "Female",
        income: "$150,000"
    },
        {
            name: "John Smith",
            age: 25,
            location: "Philadephia",
            gender: "Male",
            income: "$200,000"
        }
    ])
})


