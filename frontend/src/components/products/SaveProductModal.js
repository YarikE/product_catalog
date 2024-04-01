import React from "react";

import "./css/save-product-modal.css";

const SaveProductModal = ({ isOpen, onClose, onSubmit }) => {
    if (!isOpen) {
        return null;
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        // Дополнительная логика передачи данных из модального окна на страницу
        const formData = new FormData(e.target);
        onSubmit(formData);
        onClose();
    };

    return (
        <div className="modal">
            <div className="modal-content">
                <span className="close" onClick={onClose}>&times;</span>
                <h2>Модальное окно для создания новой записи</h2>
                <form onSubmit={handleSubmit}>
                    <label>Название:</label>
                    <input type="text" name="title"/>

                    <label>Описание:</label>
                    <input type="text" name="description"/>

                    <label>Загрузить файл:</label>
                    <input type="file" name="file"/>

                    <button className="modal-button" type="submit">Отправить</button>
                </form>
            </div>
        </div>
    );
};

export default SaveProductModal;