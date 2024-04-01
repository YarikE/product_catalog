import {useEffect, useState} from "react";

import categoryRequests from "../../requests/category/categoryRequests";

import CategoryCard from "./CategoryCard";

import "./css/category-list.css";

function CategoryList() {
    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const response = await categoryRequests.getAllCategories();
            setData(response);
        };

        fetchData();
    }, []);

    return (
        <ul>
            {data.map(item => (
                <li key={ item.id }>
                    <CategoryCard categoryName={ item.name } categoryDescription={ item.description } />
                </li>
            ))}
        </ul>
    );
}

export default CategoryList;
