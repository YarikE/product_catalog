import React, {useRef, useState} from "react";

import imageRequests from "../../requests/image/imageRequests";

import DropDown from "./DropDown";
import ToggleButton from "../global/buttons/ToggleButton";

import "./css/save-product-modal.css";

const SaveProductModal = ({ isOpen, onClose }) => {
    if (!isOpen) {
        return null;
    }

    const [selectedItemId, setSelectedItemId] = useState(null);
    const [status, setStatus] = useState(false);
    const formRef = useRef(null);

    /**
     * Получить Id сохраненного изображения
     *
     * @param file Изображение
     *
     * @return String
     */
    async function getSavedFileId(file) {
        return await imageRequests.saveImage(file);
    }

    /**
     * Получить сегодняшнюю дату
     * @return {string}
     */
    function getNowDate() {
        const today = new Date();
        const year = today.getFullYear();
        let month = today.getMonth() + 1;
        let day = today.getDate();

        if (month < 10) {
            month = '0' + month;
        }

        if (day < 10) {
            day = '0' + day;
        }

        return `${year}-${month}-${day}`;
    }

    /**
     * Сохранить данные из модального окна
     */
    const save = async () => {
        const formData = new FormData(formRef.current);
        const file = formData.get("file")
        let fileId;

        if (file && validateFile(file)) {
            fileId = await getSavedFileId(file);
        } else {
            fileId = null;
        }

        console.log({
            name: formData.get("name"),
            description: formData.get("description"),
            price: formData.get("price"),
            image_id: fileId,
            category_id: selectedItemId,
            status: status,
            add_date: getNowDate(),
        });

        onClose();
    };

    /**
     * Валидация файла
     *
     * @param file
     * @return {boolean}
     */
    const validateFile = (file) => {
        if (file.size > 15 * 1024 * 1024) {
            alert("Файл должен быть не более 15 МБ");
            return false;
        }

        if (!file.type.startsWith("image/")) {
            alert("Файл должен быть изображением");
            return false;
        }

        return true;
    };

    const handleSelect = (selectedId) => {
        setSelectedItemId(selectedId);
    };

    const switchStatus = () => {
        setStatus((prevState) => !prevState);
    };

    return (
        <div className="modal">
            <div className="modal-content">
        <span className="close" onClick={onClose}>
          &times;
        </span>
                <h2>Создание новой записи</h2>

                <form ref={formRef}>
                    <label>Название:</label>
                    <input className="modal-input" type="text" name="name" />

                    <label>Описание:</label>
                    <input className="modal-input" type="text" name="description" />

                    <label>Цена:</label>
                    <input className="modal-input" type="number" name="price" min="1" step="0.1" />

                    <label>Статус:</label>
                    <ToggleButton isOn={status} toggle={switchStatus} />

                    <label>Выберите категорию:</label>
                    <div className="modal-input">
                        <DropDown onSelect={handleSelect} />
                    </div>

                    <label>Загрузить файл:</label>
                    <input className="modal-input" type="file" name="file" />

                    <button
                        className="modal-button"
                        type="button"
                        onClick={save}
                    >
                        Отправить
                    </button>
                </form>
            </div>
        </div>
    );
};

export default SaveProductModal;