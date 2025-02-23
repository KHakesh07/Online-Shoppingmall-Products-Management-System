import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { Link } from 'react-router-dom';

const ItemDetails = () => {
  const { id } = useParams();
  const [item, setItem] = useState(null);

  useEffect(() => {
    fetchItem();
  }, []);

  const fetchItem = async () => {
    const response = await axios.get(`http://localhost:8080/items/${id}`);
    setItem(response.data);
  };

  return (
    <div>
      {item ? (
        <div className='product-det'>
          <h1>Product Details</h1>
          <Link to="/" className='item-home'>Home</Link>
          <table className='view_table'>
            <tr>
              <td className='view_details'>Product Name</td>
              <td>{item.name}</td>
            </tr>
            <tr>
              <td className='view_details'>Manufacturing Date</td>
              <td>{item.manufacturing}</td>
            </tr>
            <tr>
              <td className='view_details'>Expire Date</td>
              <td>{item.expiry}</td>
            </tr><tr>
              <td className='view_details'>Category</td>
              <td>{item.category}</td>
            </tr><tr>
              <td className='view_details'>Product Price</td>
              <td>{item.price}</td>
            </tr>
          </table>
        </div>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
};

export default ItemDetails;
