import React, { useState, useEffect } from 'react';

import categoryRequests from "../../requests/category/categoryRequests";

import styles from './css/drop-down.css';

const DropDown = ({ onSelect }) => {
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);
    const [selectedItem, setSelectedItem] = useState(null);

    useEffect(() => {
        async function fetchData() {
            const requestResult = await categoryRequests.getAllCategories();

            setData(requestResult);
            setLoading(false);
        }

        fetchData();
    }, []);

    const handleSelectChange = (event) => {
        const selectedId = parseInt(event.target.value, 10);
        const selectedItem = data.find(item => item.id === selectedId);
        setSelectedItem(selectedItem);
        onSelect(selectedId);
    };

    if (loading) {
        return <div className={styles.loading}>Loading...</div>;
    }

    return (
        <select className={styles.dropdown} onChange={handleSelectChange}>
            {data.map(item => (
                <option key={item.id} value={item.id}>
                    {item.name}
                </option>
            ))}
        </select>
    );
};


export default DropDown;