import CategoryList from "../../components/category/CategoryList";

import "./css/category.css";
import React from "react";

function CategoryView() {
    return (
        <div className="category-view">
            <h1 className="category-view__header">Список категорий</h1>
            <div className="category-view__create">
                <h3 className="create__header">Создать новую запись</h3>
                <button className="modal-button" >Создать</button>
            </div>
            <div className="category-view__content">
                <CategoryList/>
            </div>
        </div>
    );
}

export default CategoryView;