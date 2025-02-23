import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import { Link } from 'react-router-dom';

const EditItem = () => {
  const { id } = useParams();
  const [item, setItem] = useState({
    name: '',
    manufacturing: '',
    expiry: '',
    category: '',
    price: ''
  });

  useEffect(() => {
    fetchItem();
  }, []);

  const fetchItem = async () => {
    const response = await axios.get(`http://localhost:8080/items/${id}`);
    setItem(response.data);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setItem({ ...item, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`http://localhost:8080/items/${id}`, item);
  };

  return (
    <div>
      <h1>Edit Item</h1>
      <Link to="/" className='item-home'>Home</Link>
      <form onSubmit={handleSubmit} className='add-item-form'>
        <input name="name" value={item.name} onChange={handleChange} />
        <input name="manufacturing" type="date" value={item.manufacturing} onChange={handleChange} />
        <input name="expiry" type="date" value={item.expiry} onChange={handleChange} />
        <input name="category" type='text' value={item.category} onChange={handleChange}/>
        <input name="price" type="float" value={item.price} onChange={handleChange} />
        <button type="submit">Update</button>
      </form>
    </div>
  );
};

export default EditItem;
