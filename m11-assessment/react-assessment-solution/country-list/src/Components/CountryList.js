import React, { useEffect, useState } from 'react';
import { response } from '../response.js'
function CountryList({ input }) {

  const [filterdCountryList, setFilterdCountryList] = useState([]);

  useEffect(() => {
    const ans = response.filter((country) => {
      return country.toLowerCase().includes(input.toLowerCase().trim());
    });
    setFilterdCountryList(ans)

  }, [input]);


  return (
    <section>
      <ul className="card country-list" data-testid="countryList">
        {filterdCountryList?.map((country, index) => (<li key={index} className="pa-10 pl-20">{country}</li>))}
      </ul>
    </section>
  );
}

export default CountryList;
