import React from 'react';
import logo from './logo.svg';
import './App.css';
import { useState } from 'react';


function App() {

  const [todos, setTodos] = useState([]);
  const [name, setName] = useState([]);

  function onChange(e) {
    setName(e.target.value)
  }
  function clickSubmit(e) {
    setTodos([...todos, name])
  }
  return (
    <div className="App">
      <p>Hello World</p>
      <input id="input" onChange={onChange}></input>
      <input type="submit" value="登録" onClick={clickSubmit}></input>
      { todos.map((value) => <li>{value}</li>) }
    </div>
  );
}

export default App;
