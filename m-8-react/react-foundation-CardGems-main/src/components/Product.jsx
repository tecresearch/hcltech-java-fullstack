import React from 'react';
import { useParams } from 'react-router-dom';
import { cardData } from '../data/data';
import { Card } from './Card';

function Product() {
  const { productId } = useParams();
  const product = cardData.find((item) => item.id === parseInt(productId));

  return (
    <div className="container mx-auto p-4">
      
      {product ? (
        // If the product is found, render the specific product's card
        <div className="flex justify-center">
          <Card
            key={product.id}
            title={product.title}
            description={product.description}
            imageUrl={product.imageUrl}
            like={product.like} // Ensure that the 'like' property is included in cardData
          />
        </div>
      ) : (
        // If the product is not found, render all cards
        <div>
          <h1 className="text-center text-2xl font-bold mb-4">Showing All Products:</h1>
          <div className="flex flex-wrap justify-center gap-4">
            {cardData.map(card => (
              <Card
                key={card.id}
                title={card.title}
                description={card.description}
                imageUrl={card.imageUrl}
                like={card.like} // Ensure that the 'like' property is included in cardData
              />
            ))}
          </div>
        </div>
      )}
    </div>
  );
}

export default Product;
