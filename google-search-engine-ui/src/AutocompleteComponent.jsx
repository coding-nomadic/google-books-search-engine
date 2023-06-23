import React, { useState } from 'react';
import axios from 'axios';
import Autocomplete from 'react-autocomplete';
import './AutocompleteComponent.css'; // Import custom CSS for styling
import config from './config';

function AutocompleteComponent() {
  const [inputValue, setInputValue] = useState('');
  const [suggestions, setSuggestions] = useState([]);

  function handleInputChange(value) {
    setInputValue(value);
    const apiUrl = config.apiUrl;
    // Make an API call here to fetch suggestions based on the input value
    axios.get({apiUrl}`?search=${value}`)
      .then(response => {
        setSuggestions(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  }

  function handleSelectValue(value) {
    setInputValue(value);
    // Do something with the selected value (e.g., display details, make another API call)
  }

  return (
    <div style={{
      display: 'flex', flexDirection: 'column',
      alignItems: 'center'
    }}>
      <div>
          {/* Inline css*/}
          <h4 style={{
              padding: '15px',
              border: '13px solid #b4f0b4',
              color: 'rgb(11, 167, 11)',
              backgroundColor: '#282c34'
              
          }}>
              Google Books : Find
              Details About Your Favourite Book
          </h4>
      </div>
    <Autocomplete
      value={inputValue} 
      items={suggestions}
      getItemValue={item => item.title}
      onChange={e => handleInputChange(e.target.value)}
      onSelect={value => handleSelectValue(value)}
      renderItem={(item, isHighlighted) => (
        <div style={{ background: isHighlighted ?'green' : 'green'}}>
          <p>Book Name - {item.title}</p>
          <p>Author - {item.authors}</p>
          <p>Publisher - {item.publisher}</p>
          <p>Published Year - {item.publishedDate}</p>
          <p>Description - {item.description}</p>
          <hr />
        </div>
      )}
    />
     </div>
  );
}

export default AutocompleteComponent;
