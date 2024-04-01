import React, {useEffect, useState} from "react";
import productRequests from "../../requests/product/productRequests";
import ProductCard from "./ProductCard";

import "./css/card-list.css";

function CardList() {
    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const response = await productRequests.getAllProducts();
            setData(response);
        };

        fetchData();
    }, []);

    return (
        <ul className="card-list">
            {data.map(item => (
                <li key={ item.id } className="card-list__item">
                    <ProductCard
                        id={ item.id }
                        name={ item.name }
                        description={ item.description }
                        price={ item.price }
                        imageId={ item.image_id }
                        status={ item.status }
                        categoryName={ item.category ? item.category.name : "Нет категории" }
                    />
                </li>
            ))}
        </ul>
    );
}

export default CardList;
