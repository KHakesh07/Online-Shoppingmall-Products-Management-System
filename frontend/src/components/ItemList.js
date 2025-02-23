import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const ItemList = () => {
  const [items, setItems] = useState([]);

  useEffect(() => {
    fetchItems();
  }, []);

  const fetchItems = async () => {
    const response = await axios.get('http://localhost:8080/items/all');
    setItems(response.data);
  };

  const deleteItem = async (id) => {
    await axios.delete(`http://localhost:8080/items/${id}`);
    fetchItems();
  };

  return (
    <div>
      <h1>Item List</h1>
      <Link to="/add">Add Item</Link>
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Manufacturing Date</th>
            <th>Expiry Date</th>
            <th>Category</th>
            <th>Price</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {items.map(item => (
            <tr key={item.id}>
              <td>{item.name}</td>
              <td>{item.manufacturing}</td>
              <td>{item.expiry}</td>
              <td>{item.category}</td>
              <td>{item.price}</td>
              <td>
                <Link to={`/details/${item.id}`}>View</Link>
                <Link to={`/edit/${item.id}`}>Edit</Link>
                <button onClick={() => deleteItem(item.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ItemList;
