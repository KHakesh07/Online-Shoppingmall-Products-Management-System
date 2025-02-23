import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ItemList from './components/ItemList';
import AddItem from './components/AddItem';
import EditItem from './components/EditItem';
import ItemDetails from './components/ItemDetails';
import './App.css';
import './addItem.css';
import './viewdetail.css';

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/" element={<ItemList />} />
          <Route path="/add" element={<AddItem />} />
          <Route path="/edit/:id" element={<EditItem />} />
          <Route path="/details/:id" element={<ItemDetails />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
