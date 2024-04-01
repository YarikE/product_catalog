import React, { useState } from "react";
import Modal from "../../components/products/SaveProductModal";

import "./css/product.css";

import CardList from "../../components/products/CardList";

function ProductsView() {
    const [isModalOpen, setIsModalOpen] = useState(false);

    const handleToggleModal = () => {
        setIsModalOpen(!isModalOpen);
    };

    const handleNewRecordSubmit = (formData) => {
        // Логика для отправки файла на сервер
        console.log("Отправка файла на сервер:", formData.get("file"));
        // Дополнительная логика для обработки файла и отправки на сервер
    };

    return (
        <div className="product-view">
            <h1 className="product-view__header">Список продуктов</h1>
            <div className="product-view__create">
                <h3 className="create__header">Создать новую запись</h3>
                <button className="modal-button" onClick={handleToggleModal}>Открыть модальное окно</button>
            </div>
            <div className="product-view__content">
                <CardList />
            </div>
            <Modal isOpen={isModalOpen} onClose={handleToggleModal} onSubmit={handleNewRecordSubmit} />
        </div>
    );
}

export default ProductsView;