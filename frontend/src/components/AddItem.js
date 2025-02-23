import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const AddItem = () => {
  const [item, setItem] = useState({
    name: '',
    manufacturing: '',
    expiry: '',
    price: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setItem({ ...item, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await axios.post('http://localhost:8080/items/additem', item);

  };

  return (
    <div>
      <h1>Add Product</h1>
      <Link to="/" className='item-home'>Home</Link>
      <form onSubmit={handleSubmit} className='add-item-form'>
        <input name="name" placeholder="Name" onChange={handleChange} />
        <input name="manufacturing" type="date" placeholder='manufacture date' onChange={handleChange} />
        <input name="expiry" type="date" placeholder='Expiry date' onChange={handleChange} />
        <input name="category" type="text" placeholder='category' onChange={handleChange} />
        <input name="price" type="float" placeholder="Price "onChange={handleChange} />
        <button type="submit">Add</button>
      </form>
    </div>
  );
};

export default AddItem;
