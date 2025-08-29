import React from 'react';
import {render, fireEvent, cleanup, within} from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import App from './App';
import {response} from './response';

const TEST_IDS = {
  FILTER_FIELD: 'filterInput',
  COUNTRY_LIST: 'countryList'
};

describe('CountryFilter App', () => {

  let app;
  let container;
  let getByTestId;

  beforeEach(() => {
    app = render(<App />);
    container = app.container;
    getByTestId = app.getByTestId;
  });

  afterEach(() => {
    cleanup();
  });

  it('should render the Initial state without crash', () => {
    const allInput = getByTestId(TEST_IDS.FILTER_FIELD);
    const ul = getByTestId(TEST_IDS.COUNTRY_LIST);
    const all_li = ul.children;
    expect(allInput).toBeInstanceOf(HTMLElement);
    expect(allInput.value).toEqual('');
    for (let i = 0; i < all_li.length; i++) {
      expect(all_li[i].textContent.trim()).toEqual(response[i]);
    }
  });

  it('should have right countries in the rendered HTML after filtering', () => {
    ["British Virgin Islands", "India"].forEach((country) => {
      const input = getByTestId(TEST_IDS.FILTER_FIELD);
      fireEvent.keyUp(input, { target: { value: country } });
      fireEvent.change(input, { target: { value: country } });
      const ul = getByTestId(TEST_IDS.COUNTRY_LIST);
      const all_li = ul.children;
      expect(all_li.length).toEqual(1);
      expect(all_li[0].textContent.trim()).toEqual(country);
    });
  });

  it('should filter countries without case sensitivity', () => {
    const results = ["British Virgin Islands", "India"];
    const input = getByTestId(TEST_IDS.FILTER_FIELD);
    ["BrItiSH ViRgIn IsLaNdS", "iNdIa"].forEach((country, i) => {
      fireEvent.keyUp(input, { target: { value: country } });
      fireEvent.change(input, { target: { value: country } });
      const ul = getByTestId(TEST_IDS.COUNTRY_LIST);
      const all_li = ul.children;
      expect(all_li.length).toEqual(1);
      expect(all_li[0].textContent.trim()).toEqual(results[i]);
    });
  });

  it('should support fuzzy search', () => {
    ["LES", "les"].forEach((val) => {
      const input = getByTestId(TEST_IDS.FILTER_FIELD);
      fireEvent.keyUp(input, { target: { value: val } });
      fireEvent.change(input, { target: { value: val } });
      const ul = getByTestId(TEST_IDS.COUNTRY_LIST);
      const all_li = ul.children;
      expect(all_li.length).toEqual(4);
      expect(all_li[0].textContent.trim()).toEqual('Lesotho');
      expect(all_li[1].textContent.trim()).toEqual('Netherlands Antilles');
      expect(all_li[2].textContent.trim()).toEqual('Palestine');
      expect(all_li[3].textContent.trim()).toEqual('Seychelles');
    });
  });

  it('should show all contents on resetting the typed fields', () => {
    const input = getByTestId(TEST_IDS.FILTER_FIELD);
    fireEvent.keyUp(input, { target: { value: 'les' } });
    fireEvent.change(input, { target: { value: 'les' } });
    fireEvent.keyUp(input, { target: { value: 'man' } });
    fireEvent.change(input, { target: { value: 'man' } });
    fireEvent.keyUp(input, { target: { value: '' } });
    fireEvent.change(input, { target: { value: '' } });
    const ul = getByTestId(TEST_IDS.COUNTRY_LIST);
    const all_li = ul.children;
    expect(all_li.length).toEqual(205);
    for (let  i = 0; i < all_li.length; i++) {
      expect(all_li[i].textContent.trim()).toEqual(response[i]);
    }
  });

  it('should should show correct content after a series of searches', () => {
    const input = getByTestId(TEST_IDS.FILTER_FIELD);
    fireEvent.keyUp(input, { target: { value: 'les' } });
    fireEvent.change(input, { target: { value: 'les' } });
    fireEvent.keyUp(input, { target: { value: 'man' } });
    fireEvent.change(input, { target: { value: 'man' } });
    fireEvent.keyUp(input, { target: { value: '' } });
    fireEvent.change(input, { target: { value: '' } });
    fireEvent.keyUp(input, { target: { value: 'afg' } });
    fireEvent.change(input, { target: { value: 'afg' } });
    fireEvent.keyUp(input, { target: { value: 'ind' } });
    fireEvent.change(input, { target: { value: 'ind' } });
    fireEvent.keyUp(input, { target: { value: 'win' } });
    fireEvent.change(input, { target: { value: 'win' } });
    fireEvent.keyUp(input, { target: { value: 'ind' } });
    fireEvent.change(input, { target: { value: 'ind' } });
    const ul = getByTestId(TEST_IDS.COUNTRY_LIST);
    const all_li = ul.children;
    expect(all_li.length).toEqual(3);
    expect(all_li[0].textContent.trim()).toEqual('French West Indies');
    expect(all_li[1].textContent.trim()).toEqual('India');
    expect(all_li[2].textContent.trim()).toEqual('Indonesia');
  });

});
