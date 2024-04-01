import React, { useState } from "react";
import Modal from "../../components/products/SaveProductModal";

import "./css/product.css";

import CardList from "../../components/products/CardList";

function ProductsView() {
    const [isModalOpen, setIsModalOpen] = useState(false);

    const handleToggleModal = () => {
        setIsModalOpen(!isModalOpen);
    };

    return (
        <div className="product-view">
            <h1 className="product-view__header">Список продуктов</h1>
            <div className="product-view__create">
                <h3 className="create__header">Создать новую запись</h3>
                <button className="modal-button" onClick={handleToggleModal}>Создать</button>
            </div>
            <div className="product-view__content">
                <CardList />
            </div>
            <Modal isOpen={isModalOpen} onClose={handleToggleModal} />
        </div>
    );
}

export default ProductsView;